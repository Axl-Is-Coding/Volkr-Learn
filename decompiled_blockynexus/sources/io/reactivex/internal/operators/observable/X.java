package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: ObservableLift.java */
/* JADX INFO: loaded from: classes5.dex */
public final class X<R, T> extends AbstractC2904a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.t<? extends R, ? super T> f22347b;

    public X(io.reactivex.u<T> uVar, io.reactivex.t<? extends R, ? super T> tVar) {
        super(uVar);
        this.f22347b = tVar;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super R> wVar) {
        try {
            io.reactivex.w<? super Object> wVarA = this.f22347b.a(wVar);
            io.reactivex.internal.functions.a.a(wVarA, "Operator " + this.f22347b + " returned a null Observer");
            this.f22358a.subscribe(wVarA);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            io.reactivex.e.a.b(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
