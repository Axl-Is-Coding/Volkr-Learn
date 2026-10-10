package retrofit2.adapter.rxjava2;

import io.reactivex.disposables.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import io.reactivex.p;
import io.reactivex.w;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes5.dex */
final class CallEnqueueObservable<T> extends p<Response<T>> {
    private final Call<T> originalCall;

    private static final class CallCallback<T> implements b, Callback<T> {
        private final Call<?> call;
        private volatile boolean disposed;
        private final w<? super Response<T>> observer;
        boolean terminated = false;

        CallCallback(Call<?> call, w<? super Response<T>> wVar) {
            this.call = call;
            this.observer = wVar;
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

        @Override // retrofit2.Callback
        public void onFailure(Call<T> call, Throwable th) {
            if (call.isCanceled()) {
                return;
            }
            try {
                this.observer.onError(th);
            } catch (Throwable th2) {
                a.b(th2);
                io.reactivex.e.a.b(new CompositeException(th, th2));
            }
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<T> call, Response<T> response) {
            if (this.disposed) {
                return;
            }
            try {
                this.observer.onNext(response);
                if (this.disposed) {
                    return;
                }
                this.terminated = true;
                this.observer.onComplete();
            } catch (Throwable th) {
                a.b(th);
                if (this.terminated) {
                    io.reactivex.e.a.b(th);
                    return;
                }
                if (this.disposed) {
                    return;
                }
                try {
                    this.observer.onError(th);
                } catch (Throwable th2) {
                    a.b(th2);
                    io.reactivex.e.a.b(new CompositeException(th, th2));
                }
            }
        }
    }

    CallEnqueueObservable(Call<T> call) {
        this.originalCall = call;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(w<? super Response<T>> wVar) {
        Call<T> callClone = this.originalCall.clone();
        CallCallback callCallback = new CallCallback(callClone, wVar);
        wVar.onSubscribe(callCallback);
        if (callCallback.isDisposed()) {
            return;
        }
        callClone.enqueue(callCallback);
    }
}
