package androidx.loader.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.f.i;
import androidx.core.os.OperationCanceledException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: AsyncTaskLoader.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<D> extends c<D> {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncTaskLoader";
    volatile a<D>.RunnableC0025a mCancellingTask;
    private final Executor mExecutor;
    Handler mHandler;
    long mLastLoadCompleteTime;
    volatile a<D>.RunnableC0025a mTask;
    long mUpdateThrottle;

    /* JADX INFO: renamed from: androidx.loader.content.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AsyncTaskLoader.java */
    final class RunnableC0025a extends ModernAsyncTask<Void, Void, D> implements Runnable {
        private final CountDownLatch k = new CountDownLatch(1);
        boolean l;

        RunnableC0025a() {
        }

        @Override // androidx.loader.content.ModernAsyncTask
        protected void b(D d2) {
            try {
                a.this.dispatchOnCancelled(this, d2);
            } finally {
                this.k.countDown();
            }
        }

        @Override // androidx.loader.content.ModernAsyncTask
        protected void c(D d2) {
            try {
                a.this.dispatchOnLoadComplete(this, d2);
            } finally {
                this.k.countDown();
            }
        }

        public void d() {
            try {
                this.k.await();
            } catch (InterruptedException unused) {
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.l = false;
            a.this.executePendingTask();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.loader.content.ModernAsyncTask
        public D a(Void... voidArr) {
            try {
                return (D) a.this.onLoadInBackground();
            } catch (OperationCanceledException e2) {
                if (a()) {
                    return null;
                }
                throw e2;
            }
        }
    }

    public a(Context context) {
        this(context, ModernAsyncTask.f1624c);
    }

    public void cancelLoadInBackground() {
    }

    void dispatchOnCancelled(a<D>.RunnableC0025a runnableC0025a, D d2) {
        onCanceled(d2);
        if (this.mCancellingTask == runnableC0025a) {
            rollbackContentChanged();
            this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
            this.mCancellingTask = null;
            deliverCancellation();
            executePendingTask();
        }
    }

    void dispatchOnLoadComplete(a<D>.RunnableC0025a runnableC0025a, D d2) {
        if (this.mTask != runnableC0025a) {
            dispatchOnCancelled(runnableC0025a, d2);
            return;
        }
        if (isAbandoned()) {
            onCanceled(d2);
            return;
        }
        commitContentChanged();
        this.mLastLoadCompleteTime = SystemClock.uptimeMillis();
        this.mTask = null;
        deliverResult(d2);
    }

    @Override // androidx.loader.content.c
    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (this.mTask != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.mTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mTask.l);
        }
        if (this.mCancellingTask != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.mCancellingTask);
            printWriter.print(" waiting=");
            printWriter.println(this.mCancellingTask.l);
        }
        if (this.mUpdateThrottle != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            i.a(this.mUpdateThrottle, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            i.a(this.mLastLoadCompleteTime, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    void executePendingTask() {
        if (this.mCancellingTask != null || this.mTask == null) {
            return;
        }
        if (this.mTask.l) {
            this.mTask.l = false;
            this.mHandler.removeCallbacks(this.mTask);
        }
        if (this.mUpdateThrottle <= 0 || SystemClock.uptimeMillis() >= this.mLastLoadCompleteTime + this.mUpdateThrottle) {
            this.mTask.a(this.mExecutor, null);
        } else {
            this.mTask.l = true;
            this.mHandler.postAtTime(this.mTask, this.mLastLoadCompleteTime + this.mUpdateThrottle);
        }
    }

    public boolean isLoadInBackgroundCanceled() {
        return this.mCancellingTask != null;
    }

    public abstract D loadInBackground();

    @Override // androidx.loader.content.c
    protected boolean onCancelLoad() {
        if (this.mTask == null) {
            return false;
        }
        if (!this.mStarted) {
            this.mContentChanged = true;
        }
        if (this.mCancellingTask != null) {
            if (this.mTask.l) {
                this.mTask.l = false;
                this.mHandler.removeCallbacks(this.mTask);
            }
            this.mTask = null;
            return false;
        }
        if (this.mTask.l) {
            this.mTask.l = false;
            this.mHandler.removeCallbacks(this.mTask);
            this.mTask = null;
            return false;
        }
        boolean zA = this.mTask.a(false);
        if (zA) {
            this.mCancellingTask = this.mTask;
            cancelLoadInBackground();
        }
        this.mTask = null;
        return zA;
    }

    public void onCanceled(D d2) {
    }

    @Override // androidx.loader.content.c
    protected void onForceLoad() {
        super.onForceLoad();
        cancelLoad();
        this.mTask = new RunnableC0025a();
        executePendingTask();
    }

    protected D onLoadInBackground() {
        return loadInBackground();
    }

    public void setUpdateThrottle(long j) {
        this.mUpdateThrottle = j;
        if (j != 0) {
            this.mHandler = new Handler();
        }
    }

    public void waitForLoader() {
        a<D>.RunnableC0025a runnableC0025a = this.mTask;
        if (runnableC0025a != null) {
            runnableC0025a.d();
        }
    }

    private a(Context context, Executor executor) {
        super(context);
        this.mLastLoadCompleteTime = -10000L;
        this.mExecutor = executor;
    }
}
