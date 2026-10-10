package zlc.season.rxdownload4.manager;

/* JADX INFO: compiled from: TaskManager.kt */
/* JADX INFO: loaded from: classes5.dex */
final class v<T> implements io.reactivex.b.g<Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ H f23976a;

    v(H h) {
        this.f23976a = h;
    }

    @Override // io.reactivex.b.g
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void accept(Throwable th) {
        StatusHandler statusHandlerF = this.f23976a.f();
        kotlin.jvm.internal.i.a((Object) th, "it");
        statusHandlerF.a(th);
    }
}
