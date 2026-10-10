package zlc.season.rxdownload4.manager;

/* JADX INFO: compiled from: Status.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private zlc.season.rxdownload4.a.a f23972a;

    private p() {
        this.f23972a = new zlc.season.rxdownload4.a.a(0L, 0L, false, null, 15, null);
    }

    public final zlc.season.rxdownload4.a.a a() {
        return this.f23972a;
    }

    public final void a(zlc.season.rxdownload4.a.a aVar) {
        kotlin.jvm.internal.i.b(aVar, "<set-?>");
        this.f23972a = aVar;
    }

    public /* synthetic */ p(kotlin.jvm.internal.f fVar) {
        this();
    }
}
