package com.facebook.internal;

import com.facebook.FacebookSdk;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class WorkQueue {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int DEFAULT_MAX_CONCURRENT = 8;
    private final Executor executor;
    private final int maxConcurrent;
    private WorkNode pendingJobs;
    private int runningCount;
    private WorkNode runningJobs;
    private final Object workLock;

    public interface WorkItem {
        boolean cancel();

        boolean isRunning();

        void moveToFront();
    }

    private class WorkNode implements WorkItem {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Runnable callback;
        private boolean isRunning;
        private WorkNode next;
        private WorkNode prev;

        WorkNode(Runnable runnable) {
            this.callback = runnable;
        }

        WorkNode addToList(WorkNode workNode, boolean z) {
            if (workNode == null) {
                this.prev = this;
                this.next = this;
                workNode = this;
            } else {
                this.next = workNode;
                this.prev = workNode.prev;
                WorkNode workNode2 = this.next;
                this.prev.next = this;
                workNode2.prev = this;
            }
            return z ? this : workNode;
        }

        @Override // com.facebook.internal.WorkQueue.WorkItem
        public boolean cancel() {
            synchronized (WorkQueue.this.workLock) {
                if (isRunning()) {
                    return false;
                }
                WorkQueue.this.pendingJobs = removeFromList(WorkQueue.this.pendingJobs);
                return true;
            }
        }

        Runnable getCallback() {
            return this.callback;
        }

        WorkNode getNext() {
            return this.next;
        }

        @Override // com.facebook.internal.WorkQueue.WorkItem
        public boolean isRunning() {
            return this.isRunning;
        }

        @Override // com.facebook.internal.WorkQueue.WorkItem
        public void moveToFront() {
            synchronized (WorkQueue.this.workLock) {
                if (!isRunning()) {
                    WorkQueue.this.pendingJobs = removeFromList(WorkQueue.this.pendingJobs);
                    WorkQueue.this.pendingJobs = addToList(WorkQueue.this.pendingJobs, true);
                }
            }
        }

        WorkNode removeFromList(WorkNode workNode) {
            if (workNode == this && (workNode = this.next) == this) {
                workNode = null;
            }
            WorkNode workNode2 = this.next;
            workNode2.prev = this.prev;
            this.prev.next = workNode2;
            this.prev = null;
            this.next = null;
            return workNode;
        }

        void setIsRunning(boolean z) {
            this.isRunning = z;
        }

        void verify(boolean z) {
        }
    }

    public WorkQueue() {
        this(8);
    }

    private void execute(final WorkNode workNode) {
        this.executor.execute(new Runnable() { // from class: com.facebook.internal.WorkQueue.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    workNode.getCallback().run();
                } finally {
                    WorkQueue.this.finishItemAndStartNew(workNode);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019 A[Catch: all -> 0x003f, TryCatch #0 {, blocks: (B:6:0x0006, B:7:0x0013, B:9:0x0019, B:11:0x001d, B:13:0x0038), top: B:20:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void finishItemAndStartNew(com.facebook.internal.WorkQueue.WorkNode r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.workLock
            monitor-enter(r0)
            r1 = 1
            if (r5 == 0) goto L13
            com.facebook.internal.WorkQueue$WorkNode r2 = r4.runningJobs     // Catch: java.lang.Throwable -> L3f
            com.facebook.internal.WorkQueue$WorkNode r5 = r5.removeFromList(r2)     // Catch: java.lang.Throwable -> L3f
            r4.runningJobs = r5     // Catch: java.lang.Throwable -> L3f
            int r5 = r4.runningCount     // Catch: java.lang.Throwable -> L3f
            int r5 = r5 - r1
            r4.runningCount = r5     // Catch: java.lang.Throwable -> L3f
        L13:
            int r5 = r4.runningCount     // Catch: java.lang.Throwable -> L3f
            int r2 = r4.maxConcurrent     // Catch: java.lang.Throwable -> L3f
            if (r5 >= r2) goto L37
            com.facebook.internal.WorkQueue$WorkNode r5 = r4.pendingJobs     // Catch: java.lang.Throwable -> L3f
            if (r5 == 0) goto L38
            com.facebook.internal.WorkQueue$WorkNode r2 = r4.pendingJobs     // Catch: java.lang.Throwable -> L3f
            com.facebook.internal.WorkQueue$WorkNode r2 = r5.removeFromList(r2)     // Catch: java.lang.Throwable -> L3f
            r4.pendingJobs = r2     // Catch: java.lang.Throwable -> L3f
            com.facebook.internal.WorkQueue$WorkNode r2 = r4.runningJobs     // Catch: java.lang.Throwable -> L3f
            r3 = 0
            com.facebook.internal.WorkQueue$WorkNode r2 = r5.addToList(r2, r3)     // Catch: java.lang.Throwable -> L3f
            r4.runningJobs = r2     // Catch: java.lang.Throwable -> L3f
            int r2 = r4.runningCount     // Catch: java.lang.Throwable -> L3f
            int r2 = r2 + r1
            r4.runningCount = r2     // Catch: java.lang.Throwable -> L3f
            r5.setIsRunning(r1)     // Catch: java.lang.Throwable -> L3f
            goto L38
        L37:
            r5 = 0
        L38:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3f
            if (r5 == 0) goto L3e
            r4.execute(r5)
        L3e:
            return
        L3f:
            r5 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3f
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.WorkQueue.finishItemAndStartNew(com.facebook.internal.WorkQueue$WorkNode):void");
    }

    private void startItem() {
        finishItemAndStartNew(null);
    }

    public WorkItem addActiveWorkItem(Runnable runnable) {
        return addActiveWorkItem(runnable, true);
    }

    public void validate() {
        synchronized (this.workLock) {
            if (this.runningJobs != null) {
                WorkNode next = this.runningJobs;
                do {
                    next.verify(true);
                    next = next.getNext();
                } while (next != this.runningJobs);
            }
        }
    }

    public WorkQueue(int i) {
        this(i, FacebookSdk.getExecutor());
    }

    public WorkItem addActiveWorkItem(Runnable runnable, boolean z) {
        WorkNode workNode = new WorkNode(runnable);
        synchronized (this.workLock) {
            this.pendingJobs = workNode.addToList(this.pendingJobs, z);
        }
        startItem();
        return workNode;
    }

    public WorkQueue(int i, Executor executor) {
        this.workLock = new Object();
        this.runningJobs = null;
        this.runningCount = 0;
        this.maxConcurrent = i;
        this.executor = executor;
    }
}
