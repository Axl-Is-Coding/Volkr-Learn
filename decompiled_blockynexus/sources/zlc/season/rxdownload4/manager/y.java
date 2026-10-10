package zlc.season.rxdownload4.manager;

/* JADX INFO: compiled from: TaskManager.kt */
/* JADX INFO: loaded from: classes5.dex */
final class y<T> implements io.reactivex.b.g<zlc.season.rxdownload4.a.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ H f23979a;

    y(H h) {
        this.f23979a = h;
    }

    @Override // io.reactivex.b.g
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void accept(zlc.season.rxdownload4.a.a aVar) {
        StatusHandler statusHandlerG = this.f23979a.g();
        kotlin.jvm.internal.i.a((Object) aVar, "it");
        statusHandlerG.a(aVar);
    }
}
