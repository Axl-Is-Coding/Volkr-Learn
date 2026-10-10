package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2;

/* JADX INFO: compiled from: ViewPager2.java */
/* JADX INFO: loaded from: classes.dex */
class g extends ViewPager2.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewPager2 f2446a;

    g(ViewPager2 viewPager2) {
        this.f2446a = viewPager2;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public void b(int i) {
        this.f2446a.clearFocus();
        if (this.f2446a.hasFocus()) {
            this.f2446a.mRecyclerView.requestFocus(2);
        }
    }
}
