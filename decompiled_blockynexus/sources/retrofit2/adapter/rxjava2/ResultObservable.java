package retrofit2.adapter.rxjava2;

import io.reactivex.disposables.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import io.reactivex.p;
import io.reactivex.w;
import retrofit2.Response;

/* JADX INFO: loaded from: classes5.dex */
final class ResultObservable<T> extends p<Result<T>> {
    private final p<Response<T>> upstream;

    private static class ResultObserver<R> implements w<Response<R>> {
        private final w<? super Result<R>> observer;

        ResultObserver(w<? super Result<R>> wVar) {
            this.observer = wVar;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.observer.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            try {
                this.observer.onNext(Result.error(th));
                this.observer.onComplete();
            } catch (Throwable th2) {
                try {
                    this.observer.onError(th2);
                } catch (Throwable th3) {
                    a.b(th3);
                    io.reactivex.e.a.b(new CompositeException(th2, th3));
                }
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(b bVar) {
            this.observer.onSubscribe(bVar);
        }

        @Override // io.reactivex.w
        public void onNext(Response<R> response) {
            this.observer.onNext(Result.response(response));
        }
    }

    ResultObservable(p<Response<T>> pVar) {
        this.upstream = pVar;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(w<? super Result<T>> wVar) {
        this.upstream.subscribe(new ResultObserver(wVar));
    }
}
