package retrofit2.adapter.rxjava2;

import io.reactivex.disposables.b;
import io.reactivex.e.a;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.p;
import io.reactivex.w;
import retrofit2.Response;

/* JADX INFO: loaded from: classes5.dex */
final class BodyObservable<T> extends p<T> {
    private final p<Response<T>> upstream;

    private static class BodyObserver<R> implements w<Response<R>> {
        private final w<? super R> observer;
        private boolean terminated;

        BodyObserver(w<? super R> wVar) {
            this.observer = wVar;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.terminated) {
                return;
            }
            this.observer.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (!this.terminated) {
                this.observer.onError(th);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th);
            a.b(assertionError);
        }

        @Override // io.reactivex.w
        public void onSubscribe(b bVar) {
            this.observer.onSubscribe(bVar);
        }

        @Override // io.reactivex.w
        public void onNext(Response<R> response) {
            if (response.isSuccessful()) {
                this.observer.onNext(response.body());
                return;
            }
            this.terminated = true;
            HttpException httpException = new HttpException(response);
            try {
                this.observer.onError(httpException);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                a.b(new CompositeException(httpException, th));
            }
        }
    }

    BodyObservable(p<Response<T>> pVar) {
        this.upstream = pVar;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(w<? super T> wVar) {
        this.upstream.subscribe(new BodyObserver(wVar));
    }
}
