package zlc.season.rxdownload4.manager;

/* JADX INFO: renamed from: zlc.season.rxdownload4.manager.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: Status.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class C2958g extends p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Throwable f23959b;

    public C2958g() {
        super(null);
        this.f23959b = new RuntimeException("UNKNOWN ERROR");
    }

    public final void a(Throwable th) {
        kotlin.jvm.internal.i.b(th, "<set-?>");
        this.f23959b = th;
    }
}
