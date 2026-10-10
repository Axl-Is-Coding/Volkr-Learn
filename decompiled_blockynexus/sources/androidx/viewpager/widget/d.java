package androidx.viewpager.widget;

/* JADX INFO: compiled from: ViewPager.java */
/* JADX INFO: loaded from: classes.dex */
class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewPager f2401a;

    d(ViewPager viewPager) {
        this.f2401a = viewPager;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2401a.setScrollState(0);
        this.f2401a.populate();
    }
}
