package androidx.loader.content;

import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: Add missing generic type declarations: [Result] */
/* JADX INFO: compiled from: ModernAsyncTask.java */
/* JADX INFO: loaded from: classes.dex */
class f<Result> extends FutureTask<Result> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ModernAsyncTask f1640a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    f(ModernAsyncTask modernAsyncTask, Callable callable) {
        super(callable);
        this.f1640a = modernAsyncTask;
    }

    @Override // java.util.concurrent.FutureTask
    protected void done() {
        try {
            this.f1640a.e(get());
        } catch (InterruptedException e2) {
            Log.w("AsyncTask", e2);
        } catch (CancellationException unused) {
            this.f1640a.e(null);
        } catch (ExecutionException e3) {
            throw new RuntimeException("An error occurred while executing doInBackground()", e3.getCause());
        } catch (Throwable th) {
            throw new RuntimeException("An error occurred while executing doInBackground()", th);
        }
    }
}
