package io.grpc.internal;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.m;
import io.grpc.Compressor;
import io.grpc.Decompressor;
import io.grpc.Metadata;
import io.grpc.Status;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
class DelayedStream implements ClientStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private DelayedStreamListener delayedListener;
    private Status error;
    private ClientStreamListener listener;
    private volatile boolean passThrough;
    private List<Runnable> pendingCalls = new ArrayList();
    private ClientStream realStream;

    private static class DelayedStreamListener implements ClientStreamListener {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private volatile boolean passThrough;
        private List<Runnable> pendingCallbacks = new ArrayList();
        private final ClientStreamListener realListener;

        public DelayedStreamListener(ClientStreamListener clientStreamListener) {
            this.realListener = clientStreamListener;
        }

        private void delayOrExecute(Runnable runnable) {
            synchronized (this) {
                if (this.passThrough) {
                    runnable.run();
                } else {
                    this.pendingCallbacks.add(runnable);
                }
            }
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void closed(final Status status, final Metadata metadata) {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.DelayedStreamListener.4
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStreamListener.this.realListener.closed(status, metadata);
                }
            });
        }

        public void drainPendingCallbacks() {
            List<Runnable> list;
            List<Runnable> arrayList = new ArrayList<>();
            while (true) {
                synchronized (this) {
                    if (this.pendingCallbacks.isEmpty()) {
                        this.pendingCallbacks = null;
                        this.passThrough = true;
                        return;
                    } else {
                        list = this.pendingCallbacks;
                        this.pendingCallbacks = arrayList;
                    }
                }
                Iterator<Runnable> it = list.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
                list.clear();
                arrayList = list;
            }
        }

        @Override // io.grpc.internal.ClientStreamListener
        public void headersRead(final Metadata metadata) {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.DelayedStreamListener.3
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStreamListener.this.realListener.headersRead(metadata);
                }
            });
        }

        @Override // io.grpc.internal.StreamListener
        public void messageRead(final InputStream inputStream) {
            if (this.passThrough) {
                this.realListener.messageRead(inputStream);
            } else {
                delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.DelayedStreamListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DelayedStreamListener.this.realListener.messageRead(inputStream);
                    }
                });
            }
        }

        @Override // io.grpc.internal.StreamListener
        public void onReady() {
            if (this.passThrough) {
                this.realListener.onReady();
            } else {
                delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.DelayedStreamListener.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DelayedStreamListener.this.realListener.onReady();
                    }
                });
            }
        }
    }

    DelayedStream() {
    }

    private void delayOrExecute(Runnable runnable) {
        synchronized (this) {
            if (this.passThrough) {
                runnable.run();
            } else {
                this.pendingCalls.add(runnable);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
    
        r0 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002a, code lost:
    
        if (r0.hasNext() == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
    
        r0.next().run();
     */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void drainPendingCalls() {
        /*
            r3 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L5:
            monitor-enter(r3)
            java.util.List<java.lang.Runnable> r1 = r3.pendingCalls     // Catch: java.lang.Throwable -> L3b
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L3b
            if (r1 == 0) goto L1d
            r0 = 0
            r3.pendingCalls = r0     // Catch: java.lang.Throwable -> L3b
            r0 = 1
            r3.passThrough = r0     // Catch: java.lang.Throwable -> L3b
            io.grpc.internal.DelayedStream$DelayedStreamListener r0 = r3.delayedListener     // Catch: java.lang.Throwable -> L3b
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L3b
            if (r0 == 0) goto L1c
            r0.drainPendingCallbacks()
        L1c:
            return
        L1d:
            java.util.List<java.lang.Runnable> r1 = r3.pendingCalls     // Catch: java.lang.Throwable -> L3b
            r3.pendingCalls = r0     // Catch: java.lang.Throwable -> L3b
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L3b
            java.util.Iterator r0 = r1.iterator()
        L26:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L36
            java.lang.Object r2 = r0.next()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r2.run()
            goto L26
        L36:
            r1.clear()
            r0 = r1
            goto L5
        L3b:
            r0 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L3b
            goto L3f
        L3e:
            throw r0
        L3f:
            goto L3e
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.DelayedStream.drainPendingCalls():void");
    }

    @Override // io.grpc.internal.ClientStream
    public void cancel(final Status status) {
        boolean z;
        ClientStreamListener clientStreamListener;
        m.a(status, "reason");
        synchronized (this) {
            if (this.realStream == null) {
                this.realStream = NoopClientStream.INSTANCE;
                z = false;
                clientStreamListener = this.listener;
                this.error = status;
            } else {
                z = true;
                clientStreamListener = null;
            }
        }
        if (z) {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.5
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStream.this.realStream.cancel(status);
                }
            });
            return;
        }
        if (clientStreamListener != null) {
            clientStreamListener.closed(status, new Metadata());
        }
        drainPendingCalls();
    }

    @Override // io.grpc.internal.Stream
    public void flush() {
        if (this.passThrough) {
            this.realStream.flush();
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.4
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStream.this.realStream.flush();
                }
            });
        }
    }

    ClientStream getRealStream() {
        return this.realStream;
    }

    @Override // io.grpc.internal.ClientStream
    public void halfClose() {
        delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.6
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.halfClose();
            }
        });
    }

    @Override // io.grpc.internal.Stream
    public boolean isReady() {
        if (this.passThrough) {
            return this.realStream.isReady();
        }
        return false;
    }

    @Override // io.grpc.internal.Stream
    public void request(final int i) {
        if (this.passThrough) {
            this.realStream.request(i);
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.7
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStream.this.realStream.request(i);
                }
            });
        }
    }

    @Override // io.grpc.internal.ClientStream
    public void setAuthority(final String str) {
        m.b(this.listener == null, "May only be called before start");
        m.a(str, "authority");
        delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.1
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.setAuthority(str);
            }
        });
    }

    @Override // io.grpc.internal.Stream
    public void setCompressor(final Compressor compressor) {
        m.a(compressor, "compressor");
        delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.8
            @Override // java.lang.Runnable
            public void run() {
                DelayedStream.this.realStream.setCompressor(compressor);
            }
        });
    }

    @Override // io.grpc.internal.Stream
    public void setDecompressor(Decompressor decompressor) {
        m.a(decompressor, "decompressor");
        synchronized (this) {
        }
        m.b(this.realStream != null, "How did we receive a reply before the request is sent?");
        this.realStream.setDecompressor(decompressor);
    }

    @Override // io.grpc.internal.Stream
    public void setMessageCompression(final boolean z) {
        if (this.passThrough) {
            this.realStream.setMessageCompression(z);
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.9
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStream.this.realStream.setMessageCompression(z);
                }
            });
        }
    }

    final void setStream(ClientStream clientStream) {
        synchronized (this) {
            if (this.realStream != null) {
                return;
            }
            m.a(clientStream, "stream");
            this.realStream = clientStream;
            drainPendingCalls();
        }
    }

    @Override // io.grpc.internal.ClientStream
    public void start(final ClientStreamListener clientStreamListener) {
        Status status;
        boolean z;
        m.b(this.listener == null, "already started");
        synchronized (this) {
            m.a(clientStreamListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.listener = clientStreamListener;
            status = this.error;
            z = this.passThrough;
            if (!z) {
                DelayedStreamListener delayedStreamListener = new DelayedStreamListener(clientStreamListener);
                this.delayedListener = delayedStreamListener;
                clientStreamListener = delayedStreamListener;
            }
        }
        if (status != null) {
            clientStreamListener.closed(status, new Metadata());
        } else if (z) {
            this.realStream.start(clientStreamListener);
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.2
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStream.this.realStream.start(clientStreamListener);
                }
            });
        }
    }

    @Override // io.grpc.internal.Stream
    public void writeMessage(final InputStream inputStream) {
        m.a(inputStream, "message");
        if (this.passThrough) {
            this.realStream.writeMessage(inputStream);
        } else {
            delayOrExecute(new Runnable() { // from class: io.grpc.internal.DelayedStream.3
                @Override // java.lang.Runnable
                public void run() {
                    DelayedStream.this.realStream.writeMessage(inputStream);
                }
            });
        }
    }
}
