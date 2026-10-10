package androidx.fragment.app;

/* JADX INFO: renamed from: androidx.fragment.app.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: Fragment.java */
/* JADX INFO: loaded from: classes.dex */
class RunnableC0329g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Fragment f1505a;

    RunnableC0329g(Fragment fragment) {
        this.f1505a = fragment;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1505a.callStartTransitionListener();
    }
}
