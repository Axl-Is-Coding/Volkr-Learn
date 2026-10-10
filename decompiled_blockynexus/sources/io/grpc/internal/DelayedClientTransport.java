package io.grpc.internal;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.Suppliers;
import com.google.common.base.m;
import com.google.common.base.u;
import io.grpc.CallOptions;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.ClientTransport;
import io.grpc.internal.ManagedClientTransport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes5.dex */
class DelayedClientTransport implements ManagedClientTransport {
    private Status backoffStatus;
    private ManagedClientTransport.Listener listener;
    private boolean shutdown;
    private final Executor streamCreationExecutor;
    private volatile u<ClientTransport> transportSupplier;
    private final Object lock = new Object();
    private Collection<PendingStream> pendingStreams = new LinkedHashSet();
    private Collection<PendingPing> pendingPings = new ArrayList();

    private static class PendingPing {
        private final ClientTransport.PingCallback callback;
        private final Executor executor;

        public PendingPing(ClientTransport.PingCallback pingCallback, Executor executor) {
            this.callback = pingCallback;
            this.executor = executor;
        }

        public void createRealPing(ClientTransport clientTransport) {
            try {
                clientTransport.ping(this.callback, this.executor);
            } catch (UnsupportedOperationException e2) {
                this.executor.execute(new Runnable() { // from class: io.grpc.internal.DelayedClientTransport.PendingPing.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PendingPing.this.callback.onFailure(e2);
                    }
                });
            }
        }
    }

    private class PendingStream extends DelayedStream {
        private final CallOptions callOptions;
        private final Metadata headers;
        private final MethodDescriptor<?, ?> method;

        /* JADX INFO: Access modifiers changed from: private */
        public void createRealStream(ClientTransport clientTransport) {
            setStream(clientTransport.newStream(this.method, this.headers, this.callOptions));
        }

        @Override // io.grpc.internal.DelayedStream, io.grpc.internal.ClientStream
        public void cancel(Status status) {
            super.cancel(status);
            synchronized (DelayedClientTransport.this.lock) {
                if (DelayedClientTransport.this.pendingStreams != null) {
                    boolean zRemove = DelayedClientTransport.this.pendingStreams.remove(this);
                    if (DelayedClientTransport.this.pendingStreams.isEmpty() && zRemove) {
                        DelayedClientTransport.this.listener.transportInUse(false);
                        if (DelayedClientTransport.this.shutdown) {
                            DelayedClientTransport.this.pendingStreams = null;
                            DelayedClientTransport.this.listener.transportTerminated();
                        }
                    }
                }
            }
        }

        private PendingStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions) {
            this.method = methodDescriptor;
            this.headers = metadata;
            this.callOptions = callOptions;
        }
    }

    DelayedClientTransport(Executor executor) {
        this.streamCreationExecutor = executor;
    }

    void endBackoff() {
        synchronized (this.lock) {
            this.backoffStatus = null;
        }
    }

    @Override // io.grpc.internal.WithLogId
    public String getLogId() {
        return GrpcUtil.getLogId(this);
    }

    int getPendingStreamsCount() {
        int size;
        synchronized (this.lock) {
            size = this.pendingStreams == null ? 0 : this.pendingStreams.size();
        }
        return size;
    }

    u<ClientTransport> getTransportSupplier() {
        return this.transportSupplier;
    }

    public boolean hasPendingStreams() {
        boolean z;
        synchronized (this.lock) {
            z = (this.pendingStreams == null || this.pendingStreams.isEmpty()) ? false : true;
        }
        return z;
    }

    boolean isInBackoffPeriod() {
        boolean z;
        synchronized (this.lock) {
            z = this.backoffStatus != null;
        }
        return z;
    }

    @Override // io.grpc.internal.ClientTransport
    public ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions) {
        u<ClientTransport> uVar = this.transportSupplier;
        if (uVar == null) {
            synchronized (this.lock) {
                uVar = this.transportSupplier;
                if (uVar == null && !this.shutdown) {
                    if (this.backoffStatus != null && !callOptions.isWaitForReady()) {
                        return new FailingClientStream(this.backoffStatus);
                    }
                    PendingStream pendingStream = new PendingStream(methodDescriptor, metadata, callOptions);
                    this.pendingStreams.add(pendingStream);
                    if (this.pendingStreams.size() == 1) {
                        this.listener.transportInUse(true);
                    }
                    return pendingStream;
                }
            }
        }
        return uVar != null ? uVar.get().newStream(methodDescriptor, metadata, callOptions) : new FailingClientStream(Status.UNAVAILABLE.withDescription("transport shutdown"));
    }

    @Override // io.grpc.internal.ClientTransport
    public void ping(final ClientTransport.PingCallback pingCallback, Executor executor) {
        u<ClientTransport> uVar = this.transportSupplier;
        if (uVar == null) {
            synchronized (this.lock) {
                uVar = this.transportSupplier;
                if (uVar == null && !this.shutdown) {
                    this.pendingPings.add(new PendingPing(pingCallback, executor));
                    return;
                }
            }
        }
        if (uVar != null) {
            uVar.get().ping(pingCallback, executor);
        } else {
            executor.execute(new Runnable() { // from class: io.grpc.internal.DelayedClientTransport.1
                @Override // java.lang.Runnable
                public void run() {
                    pingCallback.onFailure(Status.UNAVAILABLE.withDescription("transport shutdown").asException());
                }
            });
        }
    }

    public void setTransport(ClientTransport clientTransport) {
        m.a(this != clientTransport, "delayed transport calling setTransport on itself");
        setTransportSupplier(Suppliers.a(clientTransport));
    }

    public void setTransportSupplier(final u<ClientTransport> uVar) {
        synchronized (this.lock) {
            if (this.transportSupplier != null) {
                return;
            }
            m.b(this.listener != null, "start() not called");
            m.a(uVar, "supplier");
            this.transportSupplier = uVar;
            Iterator<PendingPing> it = this.pendingPings.iterator();
            while (it.hasNext()) {
                it.next().createRealPing(uVar.get());
            }
            this.pendingPings = null;
            if (this.shutdown && this.pendingStreams != null) {
                this.listener.transportTerminated();
            }
            if (this.pendingStreams != null && !this.pendingStreams.isEmpty()) {
                final Collection<PendingStream> collection = this.pendingStreams;
                this.streamCreationExecutor.execute(new Runnable() { // from class: io.grpc.internal.DelayedClientTransport.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = collection.iterator();
                        while (it2.hasNext()) {
                            ((PendingStream) it2.next()).createRealStream((ClientTransport) uVar.get());
                        }
                        synchronized (DelayedClientTransport.this.lock) {
                            DelayedClientTransport.this.listener.transportInUse(false);
                        }
                    }
                });
            }
            this.pendingStreams = null;
            if (!this.shutdown) {
                this.listener.transportReady();
            }
        }
    }

    @Override // io.grpc.internal.ManagedClientTransport, io.grpc.internal.ServerTransport
    public void shutdown() {
        synchronized (this.lock) {
            if (this.shutdown) {
                return;
            }
            this.shutdown = true;
            this.listener.transportShutdown(Status.UNAVAILABLE.withDescription("Channel requested transport to shut down"));
            if (this.pendingStreams == null || this.pendingStreams.isEmpty()) {
                this.pendingStreams = null;
                this.listener.transportTerminated();
            }
        }
    }

    @Override // io.grpc.internal.ManagedClientTransport, io.grpc.internal.ServerTransport
    public void shutdownNow(Status status) {
        Collection<PendingStream> collection;
        shutdown();
        synchronized (this.lock) {
            if (this.pendingStreams != null) {
                collection = this.pendingStreams;
                this.pendingStreams = null;
            } else {
                collection = null;
            }
        }
        if (collection != null) {
            Iterator<PendingStream> it = collection.iterator();
            while (it.hasNext()) {
                it.next().cancel(status);
            }
            this.listener.transportTerminated();
        }
    }

    @Override // io.grpc.internal.ManagedClientTransport
    public void start(ManagedClientTransport.Listener listener) {
        m.a(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listener = listener;
    }

    void startBackoff(final Status status) {
        synchronized (this.lock) {
            m.b(this.backoffStatus == null);
            this.backoffStatus = Status.UNAVAILABLE.withDescription("Channel in TRANSIENT_FAILURE state").withCause(status.asRuntimeException());
            final ArrayList arrayList = new ArrayList();
            if (this.pendingStreams != null && !this.pendingStreams.isEmpty()) {
                Iterator<PendingStream> it = this.pendingStreams.iterator();
                while (it.hasNext()) {
                    PendingStream next = it.next();
                    if (!next.callOptions.isWaitForReady()) {
                        arrayList.add(next);
                        it.remove();
                    }
                }
                this.streamCreationExecutor.execute(new Runnable() { // from class: io.grpc.internal.DelayedClientTransport.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            ((PendingStream) it2.next()).setStream(new FailingClientStream(status));
                        }
                    }
                });
            }
        }
    }

    @Override // io.grpc.internal.ClientTransport
    public ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata) {
        return newStream(methodDescriptor, metadata, CallOptions.DEFAULT);
    }
}
