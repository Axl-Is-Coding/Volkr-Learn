package androidx.appcompat.app;

/* JADX INFO: compiled from: ToolbarActionBar.java */
/* JADX INFO: loaded from: classes.dex */
class A implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ToolbarActionBar f195a;

    A(ToolbarActionBar toolbarActionBar) {
        this.f195a = toolbarActionBar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f195a.m();
    }
}
