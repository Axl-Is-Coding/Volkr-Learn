package androidx.recyclerview.widget;

/* JADX INFO: compiled from: StaggeredGridLayoutManager.java */
/* JADX INFO: loaded from: classes.dex */
class ca implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ StaggeredGridLayoutManager f1956a;

    ca(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.f1956a = staggeredGridLayoutManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1956a.c();
    }
}
