package androidx.fragment.app;

/* JADX INFO: renamed from: androidx.fragment.app.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: Fragment.java */
/* JADX INFO: loaded from: classes.dex */
class RunnableC0328f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Fragment f1504a;

    RunnableC0328f(Fragment fragment) {
        this.f1504a = fragment;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1504a.startPostponedEnterTransition();
    }
}
