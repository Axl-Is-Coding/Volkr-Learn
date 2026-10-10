package io.grpc.internal;

import com.google.common.base.m;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.CompressorRegistry;
import io.grpc.Context;
import io.grpc.Contexts;
import io.grpc.DecompressorRegistry;
import io.grpc.HandlerRegistry;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerMethodDefinition;
import io.grpc.Status;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public final class ServerImpl extends Server {
    private static final ServerStreamListener NOOP_LISTENER = new NoopListener();
    private final CompressorRegistry compressorRegistry;
    private final DecompressorRegistry decompressorRegistry;
    private Executor executor;
    private final HandlerRegistry fallbackRegistry;
    private final InternalHandlerRegistry registry;
    private final Context rootContext;
    private boolean serverShutdownCallbackInvoked;
    private boolean shutdown;
    private Status shutdownNowStatus;
    private boolean started;
    private boolean terminated;
    private final InternalServer transportServer;
    private boolean transportServerTerminated;
    private boolean usingSharedExecutor;
    private final Object lock = new Object();
    private final Collection<ServerTransport> transports = new HashSet();
    private final ScheduledExecutorService timeoutService = (ScheduledExecutorService) SharedResourceHolder.get(GrpcUtil.TIMER_SERVICE);

    private static class JumpToApplicationThreadServerStreamListener implements ServerStreamListener {
        private final Executor callExecutor;
        private final Context.CancellableContext context;
        private ServerStreamListener listener;
        private final ServerStream stream;

        public JumpToApplicationThreadServerStreamListener(Executor executor, ServerStream serverStream, Context.CancellableContext cancellableContext) {
            this.callExecutor = executor;
            this.stream = serverStream;
            this.context = cancellableContext;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ServerStreamListener getListener() {
            ServerStreamListener serverStreamListener = this.listener;
            if (serverStreamListener != null) {
                return serverStreamListener;
            }
            throw new IllegalStateException("listener unset");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void internalClose(Status status, Metadata metadata) {
            this.stream.close(status, metadata);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setListener(ServerStreamListener serverStreamListener) {
            m.a(serverStreamListener, "listener must not be null");
            m.b(this.listener == null, "Listener already set");
            this.listener = serverStreamListener;
        }

        @Override // io.grpc.internal.ServerStreamListener
        public void closed(final Status status) {
            this.callExecutor.execute(new ContextRunnable(this.context) { // from class: io.grpc.internal.ServerImpl.JumpToApplicationThreadServerStreamListener.3
                @Override // io.grpc.internal.ContextRunnable
                public void runInContext() {
                    try {
                        JumpToApplicationThreadServerStreamListener.this.getListener().closed(status);
                    } finally {
                        JumpToApplicationThreadServerStreamListener.this.context.cancel(status.getCause());
                    }
                }
            });
        }

        @Override // io.grpc.internal.ServerStreamListener
        public void halfClosed() {
            this.callExecutor.execute(new ContextRunnable(this.context) { // from class: io.grpc.internal.ServerImpl.JumpToApplicationThreadServerStreamListener.2
                @Override // io.grpc.internal.ContextRunnable
                public void runInContext() {
                    try {
                        JumpToApplicationThreadServerStreamListener.this.getListener().halfClosed();
                    } catch (RuntimeException e2) {
                        JumpToApplicationThreadServerStreamListener.this.internalClose(Status.fromThrowable(e2), new Metadata());
                        throw e2;
                    } catch (Throwable th) {
                        JumpToApplicationThreadServerStreamListener.this.internalClose(Status.fromThrowable(th), new Metadata());
                        throw new RuntimeException(th);
                    }
                }
            });
        }

        @Override // io.grpc.internal.StreamListener
        public void messageRead(final InputStream inputStream) {
            this.callExecutor.execute(new ContextRunnable(this.context) { // from class: io.grpc.internal.ServerImpl.JumpToApplicationThreadServerStreamListener.1
                @Override // io.grpc.internal.ContextRunnable
                public void runInContext() {
                    try {
                        JumpToApplicationThreadServerStreamListener.this.getListener().messageRead(inputStream);
                    } catch (RuntimeException e2) {
                        JumpToApplicationThreadServerStreamListener.this.internalClose(Status.fromThrowable(e2), new Metadata());
                        throw e2;
                    } catch (Throwable th) {
                        JumpToApplicationThreadServerStreamListener.this.internalClose(Status.fromThrowable(th), new Metadata());
                        throw new RuntimeException(th);
                    }
                }
            });
        }

        @Override // io.grpc.internal.StreamListener
        public void onReady() {
            this.callExecutor.execute(new ContextRunnable(this.context) { // from class: io.grpc.internal.ServerImpl.JumpToApplicationThreadServerStreamListener.4
                @Override // io.grpc.internal.ContextRunnable
                public void runInContext() {
                    JumpToApplicationThreadServerStreamListener.this.getListener().onReady();
                }
            });
        }
    }

    private static class NoopListener implements ServerStreamListener {
        private NoopListener() {
        }

        @Override // io.grpc.internal.ServerStreamListener
        public void closed(Status status) {
        }

        @Override // io.grpc.internal.ServerStreamListener
        public void halfClosed() {
        }

        @Override // io.grpc.internal.StreamListener
        public void messageRead(InputStream inputStream) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }

        @Override // io.grpc.internal.StreamListener
        public void onReady() {
        }
    }

    private class ServerListenerImpl implements ServerListener {
        private ServerListenerImpl() {
        }

        @Override // io.grpc.internal.ServerListener
        public void serverShutdown() {
            ArrayList<ServerTransport> arrayList;
            Status status;
            synchronized (ServerImpl.this.lock) {
                arrayList = new ArrayList(ServerImpl.this.transports);
                status = ServerImpl.this.shutdownNowStatus;
                ServerImpl.this.serverShutdownCallbackInvoked = true;
            }
            for (ServerTransport serverTransport : arrayList) {
                if (status == null) {
                    serverTransport.shutdown();
                } else {
                    serverTransport.shutdownNow(status);
                }
            }
            synchronized (ServerImpl.this.lock) {
                ServerImpl.this.transportServerTerminated = true;
                ServerImpl.this.checkForTermination();
            }
        }

        @Override // io.grpc.internal.ServerListener
        public ServerTransportListener transportCreated(ServerTransport serverTransport) {
            synchronized (ServerImpl.this.lock) {
                ServerImpl.this.transports.add(serverTransport);
            }
            return ServerImpl.this.new ServerTransportListenerImpl(serverTransport);
        }
    }

    private class ServerTransportListenerImpl implements ServerTransportListener {
        private final ServerTransport transport;

        public ServerTransportListenerImpl(ServerTransport serverTransport) {
            this.transport = serverTransport;
        }

        private Context.CancellableContext createContext(final ServerStream serverStream, Metadata metadata) {
            Long l = (Long) metadata.get(GrpcUtil.TIMEOUT_KEY);
            if (l == null) {
                return ServerImpl.this.rootContext.withCancellation();
            }
            Context.CancellableContext cancellableContextWithDeadlineAfter = ServerImpl.this.rootContext.withDeadlineAfter(l.longValue(), TimeUnit.NANOSECONDS, ServerImpl.this.timeoutService);
            cancellableContextWithDeadlineAfter.addListener(new Context.CancellationListener() { // from class: io.grpc.internal.ServerImpl.ServerTransportListenerImpl.2
                @Override // io.grpc.Context.CancellationListener
                public void cancelled(Context context) {
                    Status statusStatusFromCancelled = Contexts.statusFromCancelled(context);
                    if (Status.DEADLINE_EXCEEDED.getCode().equals(statusStatusFromCancelled.getCode())) {
                        serverStream.cancel(statusStatusFromCancelled);
                    }
                }
            }, MoreExecutors.a());
            return cancellableContextWithDeadlineAfter;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public <ReqT, RespT> ServerStreamListener startCall(ServerStream serverStream, String str, ServerMethodDefinition<ReqT, RespT> serverMethodDefinition, Metadata metadata, Context.CancellableContext cancellableContext) {
            ServerCallImpl serverCallImpl = new ServerCallImpl(serverStream, serverMethodDefinition.getMethodDescriptor(), metadata, cancellableContext, ServerImpl.this.decompressorRegistry, ServerImpl.this.compressorRegistry);
            ServerCall.Listener<ReqT> listenerStartCall = serverMethodDefinition.getServerCallHandler().startCall(serverCallImpl, metadata);
            if (listenerStartCall != null) {
                return serverCallImpl.newServerStreamListener(listenerStartCall);
            }
            throw new NullPointerException("startCall() returned a null listener for method " + str);
        }

        @Override // io.grpc.internal.ServerTransportListener
        public ServerStreamListener streamCreated(final ServerStream serverStream, final String str, final Metadata metadata) {
            final Context.CancellableContext cancellableContextCreateContext = createContext(serverStream, metadata);
            Executor serializeReentrantCallsDirectExecutor = ServerImpl.this.executor == MoreExecutors.a() ? new SerializeReentrantCallsDirectExecutor() : new SerializingExecutor(ServerImpl.this.executor);
            final JumpToApplicationThreadServerStreamListener jumpToApplicationThreadServerStreamListener = new JumpToApplicationThreadServerStreamListener(serializeReentrantCallsDirectExecutor, serverStream, cancellableContextCreateContext);
            serializeReentrantCallsDirectExecutor.execute(new ContextRunnable(cancellableContextCreateContext) { // from class: io.grpc.internal.ServerImpl.ServerTransportListenerImpl.1
                @Override // io.grpc.internal.ContextRunnable
                public void runInContext() {
                    ServerStreamListener serverStreamListener = ServerImpl.NOOP_LISTENER;
                    try {
                        try {
                            ServerMethodDefinition<?, ?> serverMethodDefinitionLookupMethod = ServerImpl.this.registry.lookupMethod(str);
                            if (serverMethodDefinitionLookupMethod == null) {
                                serverMethodDefinitionLookupMethod = ServerImpl.this.fallbackRegistry.lookupMethod(str);
                            }
                            ServerMethodDefinition<?, ?> serverMethodDefinition = serverMethodDefinitionLookupMethod;
                            if (serverMethodDefinition != null) {
                                jumpToApplicationThreadServerStreamListener.setListener(ServerTransportListenerImpl.this.startCall(serverStream, str, serverMethodDefinition, metadata, cancellableContextCreateContext));
                                return;
                            }
                            serverStream.close(Status.UNIMPLEMENTED.withDescription("Method not found: " + str), new Metadata());
                            cancellableContextCreateContext.cancel(null);
                        } catch (RuntimeException e2) {
                            serverStream.close(Status.fromThrowable(e2), new Metadata());
                            cancellableContextCreateContext.cancel(null);
                            throw e2;
                        } catch (Throwable th) {
                            serverStream.close(Status.fromThrowable(th), new Metadata());
                            cancellableContextCreateContext.cancel(null);
                            throw new RuntimeException(th);
                        }
                    } finally {
                        jumpToApplicationThreadServerStreamListener.setListener(serverStreamListener);
                    }
                }
            });
            return jumpToApplicationThreadServerStreamListener;
        }

        @Override // io.grpc.internal.ServerTransportListener
        public void transportTerminated() {
            ServerImpl.this.transportClosed(this.transport);
        }
    }

    ServerImpl(Executor executor, InternalHandlerRegistry internalHandlerRegistry, HandlerRegistry handlerRegistry, InternalServer internalServer, Context context, DecompressorRegistry decompressorRegistry, CompressorRegistry compressorRegistry) {
        this.executor = executor;
        m.a(internalHandlerRegistry, "registry");
        this.registry = internalHandlerRegistry;
        m.a(handlerRegistry, "fallbackRegistry");
        this.fallbackRegistry = handlerRegistry;
        m.a(internalServer, "transportServer");
        this.transportServer = internalServer;
        m.a(context);
        this.rootContext = context.fork();
        this.decompressorRegistry = decompressorRegistry;
        this.compressorRegistry = compressorRegistry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkForTermination() {
        synchronized (this.lock) {
            if (this.shutdown && this.transports.isEmpty() && this.transportServerTerminated) {
                if (this.terminated) {
                    throw new AssertionError("Server already terminated");
                }
                this.terminated = true;
                this.lock.notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void transportClosed(ServerTransport serverTransport) {
        synchronized (this.lock) {
            if (!this.transports.remove(serverTransport)) {
                throw new AssertionError("Transport already removed");
            }
            checkForTermination();
        }
    }

    @Override // io.grpc.Server
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        boolean z;
        synchronized (this.lock) {
            long jNanoTime = System.nanoTime() + timeUnit.toNanos(j);
            while (!this.terminated) {
                long jNanoTime2 = jNanoTime - System.nanoTime();
                if (jNanoTime2 <= 0) {
                    break;
                }
                TimeUnit.NANOSECONDS.timedWait(this.lock, jNanoTime2);
            }
            z = this.terminated;
        }
        return z;
    }

    @Override // io.grpc.Server
    public int getPort() {
        int port;
        synchronized (this.lock) {
            m.b(this.started, "Not started");
            m.b(!this.terminated, "Already terminated");
            port = this.transportServer.getPort();
        }
        return port;
    }

    @Override // io.grpc.Server
    public boolean isShutdown() {
        boolean z;
        synchronized (this.lock) {
            z = this.shutdown;
        }
        return z;
    }

    @Override // io.grpc.Server
    public boolean isTerminated() {
        boolean z;
        synchronized (this.lock) {
            z = this.terminated;
        }
        return z;
    }

    @Override // io.grpc.Server
    public ServerImpl shutdown() {
        synchronized (this.lock) {
            if (this.shutdown) {
                return this;
            }
            this.shutdown = true;
            boolean z = this.started;
            if (!z) {
                this.transportServerTerminated = true;
                checkForTermination();
            }
            if (z) {
                this.transportServer.shutdown();
            }
            SharedResourceHolder.release(GrpcUtil.TIMER_SERVICE, this.timeoutService);
            if (this.usingSharedExecutor) {
                SharedResourceHolder.release(GrpcUtil.SHARED_CHANNEL_EXECUTOR, (ExecutorService) this.executor);
            }
            return this;
        }
    }

    @Override // io.grpc.Server
    public ServerImpl shutdownNow() {
        shutdown();
        Status statusWithDescription = Status.UNAVAILABLE.withDescription("Server shutdownNow invoked");
        synchronized (this.lock) {
            if (this.shutdownNowStatus != null) {
                return this;
            }
            this.shutdownNowStatus = statusWithDescription;
            ArrayList arrayList = new ArrayList(this.transports);
            boolean z = this.serverShutdownCallbackInvoked;
            if (z) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((ServerTransport) it.next()).shutdownNow(statusWithDescription);
                }
            }
            return this;
        }
    }

    @Override // io.grpc.Server
    public ServerImpl start() throws IOException {
        synchronized (this.lock) {
            m.b(!this.started, "Already started");
            m.b(!this.shutdown, "Shutting down");
            this.usingSharedExecutor = this.executor == null;
            if (this.usingSharedExecutor) {
                this.executor = (Executor) SharedResourceHolder.get(GrpcUtil.SHARED_CHANNEL_EXECUTOR);
            }
            this.transportServer.start(new ServerListenerImpl());
            this.started = true;
        }
        return this;
    }

    @Override // io.grpc.Server
    public void awaitTermination() throws InterruptedException {
        synchronized (this.lock) {
            while (!this.terminated) {
                this.lock.wait();
            }
        }
    }
}
