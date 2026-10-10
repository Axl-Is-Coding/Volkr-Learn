package io.grpc.inprocess;

import com.google.common.base.m;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.Compressor;
import io.grpc.Decompressor;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.ServerCall;
import io.grpc.Status;
import io.grpc.internal.ClientStream;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.ClientTransport;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.ManagedClientTransport;
import io.grpc.internal.NoopClientStream;
import io.grpc.internal.ServerStream;
import io.grpc.internal.ServerStreamListener;
import io.grpc.internal.ServerTransport;
import io.grpc.internal.ServerTransportListener;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes5.dex */
class InProcessTransport implements ConnectionClientTransport, ServerTransport {
    private static final Logger log = Logger.getLogger(InProcessTransport.class.getName());
    private ManagedClientTransport.Listener clientTransportListener;
    private final String name;
    private final Attributes serverStreamAttributes;
    private ServerTransportListener serverTransportListener;
    private boolean shutdown;
    private Status shutdownStatus;
    private Set<InProcessStream> streams = new HashSet();
    private boolean terminated;

    private class InProcessStream {
        private final InProcessClientStream clientStream;
        private final Metadata headers;
        private MethodDescriptor<?, ?> method;
        private final InProcessServerStream serverStream;

        private class InProcessClientStream implements ClientStream {
            private boolean closed;
            private boolean serverNotifyHalfClose;
            private ArrayDeque<InputStream> serverReceiveQueue;
            private int serverRequested;
            private ServerStreamListener serverStreamListener;

            private InProcessClientStream() {
                this.serverReceiveQueue = new ArrayDeque<>();
            }

            private synchronized boolean internalCancel(Status status) {
                if (this.closed) {
                    return false;
                }
                this.closed = true;
                while (true) {
                    InputStream inputStreamPoll = this.serverReceiveQueue.poll();
                    if (inputStreamPoll == null) {
                        this.serverStreamListener.closed(status);
                        return true;
                    }
                    try {
                        inputStreamPoll.close();
                    } catch (Throwable th) {
                        InProcessTransport.log.log(Level.WARNING, "Exception closing stream", th);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void serverClosed(Status status) {
                internalCancel(status);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public synchronized boolean serverRequested(int i) {
                boolean z = false;
                if (this.closed) {
                    return false;
                }
                boolean z2 = this.serverRequested > 0;
                this.serverRequested += i;
                while (this.serverRequested > 0 && !this.serverReceiveQueue.isEmpty()) {
                    this.serverRequested--;
                    this.serverStreamListener.messageRead(this.serverReceiveQueue.poll());
                }
                if (this.serverReceiveQueue.isEmpty() && this.serverNotifyHalfClose) {
                    this.serverNotifyHalfClose = false;
                    this.serverStreamListener.halfClosed();
                }
                boolean z3 = this.serverRequested > 0;
                if (!z2 && z3) {
                    z = true;
                }
                return z;
            }

            private synchronized void setListener(ServerStreamListener serverStreamListener) {
                this.serverStreamListener = serverStreamListener;
            }

            @Override // io.grpc.internal.ClientStream
            public void cancel(Status status) {
                if (internalCancel(InProcessTransport.stripCause(status))) {
                    InProcessStream.this.serverStream.clientCancelled(status);
                    InProcessStream.this.streamClosed();
                }
            }

            @Override // io.grpc.internal.Stream
            public void flush() {
            }

            @Override // io.grpc.internal.ClientStream
            public synchronized void halfClose() {
                if (this.closed) {
                    return;
                }
                if (this.serverReceiveQueue.isEmpty()) {
                    this.serverStreamListener.halfClosed();
                } else {
                    this.serverNotifyHalfClose = true;
                }
            }

            @Override // io.grpc.internal.Stream
            public synchronized boolean isReady() {
                if (this.closed) {
                    return false;
                }
                return this.serverRequested > 0;
            }

            @Override // io.grpc.internal.Stream
            public void request(int i) {
                if (InProcessStream.this.serverStream.clientRequested(i)) {
                    synchronized (this) {
                        if (!this.closed) {
                            this.serverStreamListener.onReady();
                        }
                    }
                }
            }

            @Override // io.grpc.internal.ClientStream
            public void setAuthority(String str) {
            }

            @Override // io.grpc.internal.Stream
            public void setCompressor(Compressor compressor) {
            }

            @Override // io.grpc.internal.Stream
            public void setDecompressor(Decompressor decompressor) {
            }

            @Override // io.grpc.internal.Stream
            public void setMessageCompression(boolean z) {
            }

            @Override // io.grpc.internal.ClientStream
            public void start(ClientStreamListener clientStreamListener) {
                InProcessStream.this.serverStream.setListener(clientStreamListener);
                synchronized (InProcessTransport.this) {
                    InProcessStream.this.clientStream.setListener(InProcessTransport.this.serverTransportListener.streamCreated(InProcessStream.this.serverStream, InProcessStream.this.method.getFullMethodName(), InProcessStream.this.headers));
                    InProcessTransport.this.streams.add(InProcessStream.this);
                    if (InProcessTransport.this.streams.size() == 1) {
                        InProcessTransport.this.clientTransportListener.transportInUse(true);
                    }
                }
            }

            @Override // io.grpc.internal.Stream
            public synchronized void writeMessage(InputStream inputStream) {
                if (this.closed) {
                    return;
                }
                if (this.serverRequested > 0) {
                    this.serverRequested--;
                    this.serverStreamListener.messageRead(inputStream);
                } else {
                    this.serverReceiveQueue.add(inputStream);
                }
            }
        }

        private class InProcessServerStream implements ServerStream {
            private Status clientNotifyStatus;
            private Metadata clientNotifyTrailers;
            private ArrayDeque<InputStream> clientReceiveQueue;
            private int clientRequested;
            private ClientStreamListener clientStreamListener;
            private boolean closed;

            private InProcessServerStream() {
                this.clientReceiveQueue = new ArrayDeque<>();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clientCancelled(Status status) {
                internalCancel(status);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public synchronized boolean clientRequested(int i) {
                boolean z = false;
                if (this.closed) {
                    return false;
                }
                boolean z2 = this.clientRequested > 0;
                this.clientRequested += i;
                while (this.clientRequested > 0 && !this.clientReceiveQueue.isEmpty()) {
                    this.clientRequested--;
                    this.clientStreamListener.messageRead(this.clientReceiveQueue.poll());
                }
                if (this.closed) {
                    return false;
                }
                if (this.clientReceiveQueue.isEmpty() && this.clientNotifyStatus != null) {
                    this.closed = true;
                    this.clientStreamListener.closed(this.clientNotifyStatus, this.clientNotifyTrailers);
                }
                boolean z3 = this.clientRequested > 0;
                if (!z2 && z3) {
                    z = true;
                }
                return z;
            }

            private synchronized boolean internalCancel(Status status) {
                if (this.closed) {
                    return false;
                }
                this.closed = true;
                while (true) {
                    InputStream inputStreamPoll = this.clientReceiveQueue.poll();
                    if (inputStreamPoll == null) {
                        this.clientStreamListener.closed(status, new Metadata());
                        return true;
                    }
                    try {
                        inputStreamPoll.close();
                    } catch (Throwable th) {
                        InProcessTransport.log.log(Level.WARNING, "Exception closing stream", th);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public synchronized void setListener(ClientStreamListener clientStreamListener) {
                this.clientStreamListener = clientStreamListener;
            }

            @Override // io.grpc.internal.ServerStream
            public Attributes attributes() {
                return InProcessTransport.this.serverStreamAttributes;
            }

            @Override // io.grpc.internal.ServerStream
            public void cancel(Status status) {
                if (internalCancel(Status.CANCELLED.withDescription("server cancelled stream"))) {
                    InProcessStream.this.clientStream.serverClosed(status);
                    InProcessStream.this.streamClosed();
                }
            }

            @Override // io.grpc.internal.ServerStream
            public void close(Status status, Metadata metadata) {
                Status statusStripCause = InProcessTransport.stripCause(status);
                synchronized (this) {
                    if (this.closed) {
                        return;
                    }
                    if (this.clientReceiveQueue.isEmpty()) {
                        this.closed = true;
                        this.clientStreamListener.closed(statusStripCause, metadata);
                    } else {
                        this.clientNotifyStatus = statusStripCause;
                        this.clientNotifyTrailers = metadata;
                    }
                    InProcessStream.this.clientStream.serverClosed(Status.OK);
                    InProcessStream.this.streamClosed();
                }
            }

            @Override // io.grpc.internal.Stream
            public void flush() {
            }

            @Override // io.grpc.internal.Stream
            public synchronized boolean isReady() {
                if (this.closed) {
                    return false;
                }
                return this.clientRequested > 0;
            }

            @Override // io.grpc.internal.Stream
            public void request(int i) {
                if (InProcessStream.this.clientStream.serverRequested(i)) {
                    synchronized (this) {
                        if (!this.closed) {
                            this.clientStreamListener.onReady();
                        }
                    }
                }
            }

            @Override // io.grpc.internal.Stream
            public void setCompressor(Compressor compressor) {
            }

            @Override // io.grpc.internal.Stream
            public void setDecompressor(Decompressor decompressor) {
            }

            @Override // io.grpc.internal.Stream
            public void setMessageCompression(boolean z) {
            }

            @Override // io.grpc.internal.ServerStream
            public synchronized void writeHeaders(Metadata metadata) {
                if (this.closed) {
                    return;
                }
                this.clientStreamListener.headersRead(metadata);
            }

            @Override // io.grpc.internal.Stream
            public synchronized void writeMessage(InputStream inputStream) {
                if (this.closed) {
                    return;
                }
                if (this.clientRequested > 0) {
                    this.clientRequested--;
                    this.clientStreamListener.messageRead(inputStream);
                } else {
                    this.clientReceiveQueue.add(inputStream);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void streamClosed() {
            synchronized (InProcessTransport.this) {
                boolean zRemove = InProcessTransport.this.streams.remove(this);
                if (InProcessTransport.this.streams.isEmpty() && zRemove) {
                    InProcessTransport.this.clientTransportListener.transportInUse(false);
                    if (InProcessTransport.this.shutdown) {
                        InProcessTransport.this.notifyTerminated();
                    }
                }
            }
        }

        private InProcessStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata) {
            this.serverStream = new InProcessServerStream();
            this.clientStream = new InProcessClientStream();
            m.a(methodDescriptor);
            this.method = methodDescriptor;
            m.a(metadata);
            this.headers = metadata;
        }
    }

    public InProcessTransport(String str) {
        this.name = str;
        this.serverStreamAttributes = Attributes.newBuilder().set(ServerCall.REMOTE_ADDR_KEY, new InProcessSocketAddress(str)).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyShutdown(Status status) {
        if (this.shutdown) {
            return;
        }
        this.shutdown = true;
        this.clientTransportListener.transportShutdown(status);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void notifyTerminated() {
        if (this.terminated) {
            return;
        }
        this.terminated = true;
        this.clientTransportListener.transportTerminated();
        if (this.serverTransportListener != null) {
            this.serverTransportListener.transportTerminated();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status stripCause(Status status) {
        if (status == null) {
            return null;
        }
        return Status.fromCodeValue(status.getCode().value()).withDescription(status.getDescription());
    }

    @Override // io.grpc.internal.ConnectionClientTransport
    public Attributes getAttrs() {
        return Attributes.EMPTY;
    }

    @Override // io.grpc.internal.WithLogId
    public String getLogId() {
        return GrpcUtil.getLogId(this);
    }

    @Override // io.grpc.internal.ClientTransport
    public synchronized ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions) {
        if (this.shutdownStatus == null) {
            return new InProcessStream(methodDescriptor, metadata).clientStream;
        }
        final Status status = this.shutdownStatus;
        return new NoopClientStream() { // from class: io.grpc.inprocess.InProcessTransport.3
            @Override // io.grpc.internal.NoopClientStream, io.grpc.internal.ClientStream
            public void start(ClientStreamListener clientStreamListener) {
                clientStreamListener.closed(status, new Metadata());
            }
        };
    }

    @Override // io.grpc.internal.ClientTransport
    public synchronized void ping(final ClientTransport.PingCallback pingCallback, Executor executor) {
        if (this.terminated) {
            final Status status = this.shutdownStatus;
            executor.execute(new Runnable() { // from class: io.grpc.inprocess.InProcessTransport.4
                @Override // java.lang.Runnable
                public void run() {
                    pingCallback.onFailure(status.asRuntimeException());
                }
            });
        } else {
            executor.execute(new Runnable() { // from class: io.grpc.inprocess.InProcessTransport.5
                @Override // java.lang.Runnable
                public void run() {
                    pingCallback.onSuccess(0L);
                }
            });
        }
    }

    @Override // io.grpc.internal.ManagedClientTransport, io.grpc.internal.ServerTransport
    public synchronized void shutdown() {
        if (this.shutdown) {
            return;
        }
        this.shutdownStatus = Status.UNAVAILABLE.withDescription("transport was requested to shut down");
        notifyShutdown(this.shutdownStatus);
        if (this.streams.isEmpty()) {
            notifyTerminated();
        }
    }

    @Override // io.grpc.internal.ManagedClientTransport, io.grpc.internal.ServerTransport
    public void shutdownNow(Status status) {
        m.a(status, "reason");
        synchronized (this) {
            shutdown();
            if (this.terminated) {
                return;
            }
            Iterator it = new ArrayList(this.streams).iterator();
            while (it.hasNext()) {
                ((InProcessStream) it.next()).clientStream.cancel(status);
            }
        }
    }

    @Override // io.grpc.internal.ManagedClientTransport
    public synchronized void start(ManagedClientTransport.Listener listener) {
        this.clientTransportListener = listener;
        InProcessServer inProcessServerFindServer = InProcessServer.findServer(this.name);
        if (inProcessServerFindServer != null) {
            this.serverTransportListener = inProcessServerFindServer.register(this);
        }
        if (this.serverTransportListener != null) {
            Thread thread = new Thread(new Runnable() { // from class: io.grpc.inprocess.InProcessTransport.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (InProcessTransport.this) {
                        InProcessTransport.this.clientTransportListener.transportReady();
                    }
                }
            });
            thread.setDaemon(true);
            thread.setName("grpc-inprocess-ready");
            thread.start();
            return;
        }
        this.shutdownStatus = Status.UNAVAILABLE.withDescription("Could not find server: " + this.name);
        final Status status = this.shutdownStatus;
        Thread thread2 = new Thread(new Runnable() { // from class: io.grpc.inprocess.InProcessTransport.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (InProcessTransport.this) {
                    InProcessTransport.this.notifyShutdown(status);
                    InProcessTransport.this.notifyTerminated();
                }
            }
        });
        thread2.setDaemon(true);
        thread2.setName("grpc-inprocess-shutdown");
        thread2.start();
    }

    public String toString() {
        return getLogId() + "(" + this.name + ")";
    }

    @Override // io.grpc.internal.ClientTransport
    public synchronized ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata) {
        return newStream(methodDescriptor, metadata, CallOptions.DEFAULT);
    }
}
