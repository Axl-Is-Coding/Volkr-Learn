package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2;

/* JADX INFO: compiled from: ViewPager2.java */
/* JADX INFO: loaded from: classes.dex */
class e extends ViewPager2.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewPager2 f2444a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    e(ViewPager2 viewPager2) {
        super(null);
        this.f2444a = viewPager2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.c
    public void a() {
        ViewPager2 viewPager2 = this.f2444a;
        viewPager2.mCurrentItemDirty = true;
        viewPager2.mScrollEventAdapter.g();
    }
}
