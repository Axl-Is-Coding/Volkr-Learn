package androidx.appcompat.widget;

/* JADX INFO: compiled from: Toolbar.java */
/* JADX INFO: loaded from: classes.dex */
class ka implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Toolbar f666a;

    ka(Toolbar toolbar) {
        this.f666a = toolbar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f666a.showOverflowMenu();
    }
}
