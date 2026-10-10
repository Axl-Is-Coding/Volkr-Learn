package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: ViewPager2.java */
/* JADX INFO: loaded from: classes.dex */
class h implements RecyclerView.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewPager2 f2447a;

    h(ViewPager2 viewPager2) {
        this.f2447a = viewPager2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public void a(View view) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.j
    public void b(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (((ViewGroup.MarginLayoutParams) layoutParams).width != -1 || ((ViewGroup.MarginLayoutParams) layoutParams).height != -1) {
            throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
        }
    }
}
