package androidx.fragment.app;

/* JADX INFO: renamed from: androidx.fragment.app.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentManagerImpl.java */
/* JADX INFO: loaded from: classes.dex */
class RunnableC0338p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ LayoutInflaterFactory2C0343v f1517a;

    RunnableC0338p(LayoutInflaterFactory2C0343v layoutInflaterFactory2C0343v) {
        this.f1517a = layoutInflaterFactory2C0343v;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1517a.t();
    }
}
