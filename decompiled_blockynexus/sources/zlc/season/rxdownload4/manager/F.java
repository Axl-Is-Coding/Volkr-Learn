package zlc.season.rxdownload4.manager;

/* JADX INFO: compiled from: TaskManager.kt */
/* JADX INFO: loaded from: classes5.dex */
final class F<T> implements io.reactivex.b.g<Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ H f23936a;

    F(H h) {
        this.f23936a = h;
    }

    @Override // io.reactivex.b.g
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void accept(Throwable th) {
        StatusHandler statusHandlerH = this.f23936a.h();
        kotlin.jvm.internal.i.a((Object) th, "it");
        statusHandlerH.a(th);
    }
}
