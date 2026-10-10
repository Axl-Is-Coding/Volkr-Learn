package io.grpc.internal;

import com.google.common.base.m;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes5.dex */
public final class SerializingExecutor implements Executor {
    private static final Logger log = Logger.getLogger(SerializingExecutor.class.getName());
    private final Executor executor;
    private final Queue<Runnable> waitQueue = new ArrayDeque(4);
    private boolean isThreadScheduled = false;
    private final TaskRunner taskRunner = new TaskRunner();
    private final Object internalLock = new Object() { // from class: io.grpc.internal.SerializingExecutor.1
        public String toString() {
            return "SerializingExecutor lock: " + super.toString();
        }
    };

    private class TaskRunner implements Runnable {
        private TaskRunner() {
        }

        /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:18:0x004c
            	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
            	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
            */
        @Override // java.lang.Runnable
        public void run() {
            /*
                r8 = this;
            L0:
                r0 = 0
                r1 = 1
                io.grpc.internal.SerializingExecutor r2 = io.grpc.internal.SerializingExecutor.this     // Catch: java.lang.Throwable -> L4f
                java.lang.Object r2 = io.grpc.internal.SerializingExecutor.access$100(r2)     // Catch: java.lang.Throwable -> L4f
                monitor-enter(r2)     // Catch: java.lang.Throwable -> L4f
                io.grpc.internal.SerializingExecutor r3 = io.grpc.internal.SerializingExecutor.this     // Catch: java.lang.Throwable -> L4c
                boolean r3 = io.grpc.internal.SerializingExecutor.access$200(r3)     // Catch: java.lang.Throwable -> L4c
                com.google.common.base.m.b(r3)     // Catch: java.lang.Throwable -> L4c
                io.grpc.internal.SerializingExecutor r3 = io.grpc.internal.SerializingExecutor.this     // Catch: java.lang.Throwable -> L4c
                java.util.Queue r3 = io.grpc.internal.SerializingExecutor.access$300(r3)     // Catch: java.lang.Throwable -> L4c
                java.lang.Object r3 = r3.poll()     // Catch: java.lang.Throwable -> L4c
                java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch: java.lang.Throwable -> L4c
                if (r3 != 0) goto L2b
                io.grpc.internal.SerializingExecutor r3 = io.grpc.internal.SerializingExecutor.this     // Catch: java.lang.Throwable -> L4c
                io.grpc.internal.SerializingExecutor.access$202(r3, r0)     // Catch: java.lang.Throwable -> L4c
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L27
                return
            L27:
                r1 = move-exception
                r3 = r1
                r1 = 0
                goto L4d
            L2b:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L4c
                r3.run()     // Catch: java.lang.RuntimeException -> L30 java.lang.Throwable -> L4f
                goto L0
            L30:
                r2 = move-exception
                java.util.logging.Logger r4 = io.grpc.internal.SerializingExecutor.access$400()     // Catch: java.lang.Throwable -> L4f
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L4f
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4f
                r6.<init>()     // Catch: java.lang.Throwable -> L4f
                java.lang.String r7 = "Exception while executing runnable "
                r6.append(r7)     // Catch: java.lang.Throwable -> L4f
                r6.append(r3)     // Catch: java.lang.Throwable -> L4f
                java.lang.String r3 = r6.toString()     // Catch: java.lang.Throwable -> L4f
                r4.log(r5, r3, r2)     // Catch: java.lang.Throwable -> L4f
                goto L0
            L4c:
                r3 = move-exception
            L4d:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L4c
                throw r3     // Catch: java.lang.Throwable -> L4f
            L4f:
                r2 = move-exception
                if (r1 == 0) goto L63
                io.grpc.internal.SerializingExecutor r1 = io.grpc.internal.SerializingExecutor.this
                java.lang.Object r1 = io.grpc.internal.SerializingExecutor.access$100(r1)
                monitor-enter(r1)
                io.grpc.internal.SerializingExecutor r3 = io.grpc.internal.SerializingExecutor.this     // Catch: java.lang.Throwable -> L60
                io.grpc.internal.SerializingExecutor.access$202(r3, r0)     // Catch: java.lang.Throwable -> L60
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L60
                goto L63
            L60:
                r0 = move-exception
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L60
                throw r0
            L63:
                goto L65
            L64:
                throw r2
            L65:
                goto L64
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.SerializingExecutor.TaskRunner.run():void");
        }
    }

    public SerializingExecutor(Executor executor) {
        m.a(executor, "'executor' must not be null.");
        this.executor = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        boolean z;
        m.a(runnable, "'r' must not be null.");
        synchronized (this.internalLock) {
            this.waitQueue.add(runnable);
            z = true;
            if (this.isThreadScheduled) {
                z = false;
            } else {
                this.isThreadScheduled = true;
            }
        }
        if (z) {
            try {
                this.executor.execute(this.taskRunner);
            } catch (Throwable th) {
                synchronized (this.internalLock) {
                    this.isThreadScheduled = false;
                    throw th;
                }
            }
        }
    }
}
