package zlc.season.rxdownload4.manager;

/* JADX INFO: compiled from: TaskManager.kt */
/* JADX INFO: loaded from: classes5.dex */
final class A<T> implements io.reactivex.b.g<Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ H f23931a;

    A(H h) {
        this.f23931a = h;
    }

    @Override // io.reactivex.b.g
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void accept(Throwable th) {
        StatusHandler statusHandlerG = this.f23931a.g();
        kotlin.jvm.internal.i.a((Object) th, "it");
        statusHandlerG.a(th);
    }
}
