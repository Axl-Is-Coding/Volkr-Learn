package io.reactivex;

/* JADX INFO: renamed from: io.reactivex.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: Completable.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractC2894a implements c {
    private static NullPointerException a(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    protected abstract void b(b bVar);

    @Override // io.reactivex.c
    public final void a(b bVar) {
        io.reactivex.internal.functions.a.a(bVar, "observer is null");
        try {
            b bVarA = io.reactivex.e.a.a(this, bVar);
            io.reactivex.internal.functions.a.a(bVarA, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            b(bVarA);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            io.reactivex.e.a.b(th);
            throw a(th);
        }
    }
}
