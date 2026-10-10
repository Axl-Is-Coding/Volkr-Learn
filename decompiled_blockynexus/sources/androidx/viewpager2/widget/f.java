package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2;

/* JADX INFO: compiled from: ViewPager2.java */
/* JADX INFO: loaded from: classes.dex */
class f extends ViewPager2.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewPager2 f2445a;

    f(ViewPager2 viewPager2) {
        this.f2445a = viewPager2;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public void a(int i) {
        if (i == 0) {
            this.f2445a.updateCurrentItem();
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public void b(int i) {
        ViewPager2 viewPager2 = this.f2445a;
        if (viewPager2.mCurrentItem != i) {
            viewPager2.mCurrentItem = i;
            viewPager2.mAccessibilityProvider.g();
        }
    }
}
