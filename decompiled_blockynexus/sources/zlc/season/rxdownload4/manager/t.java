package zlc.season.rxdownload4.manager;

/* JADX INFO: compiled from: TaskManager.kt */
/* JADX INFO: loaded from: classes5.dex */
final class t<T> implements io.reactivex.b.g<zlc.season.rxdownload4.a.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ H f23974a;

    t(H h) {
        this.f23974a = h;
    }

    @Override // io.reactivex.b.g
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void accept(zlc.season.rxdownload4.a.a aVar) {
        StatusHandler statusHandlerF = this.f23974a.f();
        kotlin.jvm.internal.i.a((Object) aVar, "it");
        statusHandlerF.a(aVar);
    }
}
