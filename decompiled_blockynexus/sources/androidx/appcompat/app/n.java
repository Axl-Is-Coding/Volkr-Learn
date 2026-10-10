package androidx.appcompat.app;

/* JADX INFO: compiled from: AppCompatDelegateImpl.java */
/* JADX INFO: loaded from: classes.dex */
class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppCompatDelegateImpl f315a;

    n(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f315a = appCompatDelegateImpl;
    }

    @Override // java.lang.Runnable
    public void run() {
        AppCompatDelegateImpl appCompatDelegateImpl = this.f315a;
        if ((appCompatDelegateImpl.Z & 1) != 0) {
            appCompatDelegateImpl.f(0);
        }
        AppCompatDelegateImpl appCompatDelegateImpl2 = this.f315a;
        if ((appCompatDelegateImpl2.Z & 4096) != 0) {
            appCompatDelegateImpl2.f(108);
        }
        AppCompatDelegateImpl appCompatDelegateImpl3 = this.f315a;
        appCompatDelegateImpl3.Y = false;
        appCompatDelegateImpl3.Z = 0;
    }
}
