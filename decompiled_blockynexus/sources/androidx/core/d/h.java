package androidx.core.d;

/* JADX INFO: compiled from: SelfDestructiveThread.java */
/* JADX INFO: loaded from: classes.dex */
class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Object f1089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ i f1090b;

    h(i iVar, Object obj) {
        this.f1090b = iVar;
        this.f1089a = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1090b.f1093c.a(this.f1089a);
    }
}
