package retrofit2.adapter.rxjava2;

import io.reactivex.disposables.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import io.reactivex.p;
import io.reactivex.w;
import retrofit2.Call;
import retrofit2.Response;

/* JADX INFO: loaded from: classes5.dex */
final class CallExecuteObservable<T> extends p<Response<T>> {
    private final Call<T> originalCall;

    private static final class CallDisposable implements b {
        private final Call<?> call;
        private volatile boolean disposed;

        CallDisposable(Call<?> call) {
            this.call = call;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.disposed = true;
            this.call.cancel();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }
    }

    CallExecuteObservable(Call<T> call) {
        this.originalCall = call;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(w<? super Response<T>> wVar) {
        boolean z;
        Call<T> callClone = this.originalCall.clone();
        CallDisposable callDisposable = new CallDisposable(callClone);
        wVar.onSubscribe(callDisposable);
        if (callDisposable.isDisposed()) {
            return;
        }
        try {
            Response<T> responseExecute = callClone.execute();
            if (!callDisposable.isDisposed()) {
                wVar.onNext(responseExecute);
            }
            if (callDisposable.isDisposed()) {
                return;
            }
            try {
                wVar.onComplete();
            } catch (Throwable th) {
                th = th;
                z = true;
                a.b(th);
                if (z) {
                    io.reactivex.e.a.b(th);
                    return;
                }
                if (callDisposable.isDisposed()) {
                    return;
                }
                try {
                    wVar.onError(th);
                } catch (Throwable th2) {
                    a.b(th2);
                    io.reactivex.e.a.b(new CompositeException(th, th2));
                }
            }
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
    }
}
