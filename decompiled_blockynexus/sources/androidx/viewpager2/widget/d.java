package androidx.viewpager2.widget;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* JADX INFO: compiled from: PageTransformerAdapter.java */
/* JADX INFO: loaded from: classes.dex */
final class d extends ViewPager2.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinearLayoutManager f2442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ViewPager2.g f2443b;

    d(LinearLayoutManager linearLayoutManager) {
        this.f2442a = linearLayoutManager;
    }

    ViewPager2.g a() {
        return this.f2443b;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public void a(int i) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public void b(int i) {
    }

    void a(ViewPager2.g gVar) {
        this.f2443b = gVar;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public void a(int i, float f2, int i2) {
        if (this.f2443b == null) {
            return;
        }
        float f3 = -f2;
        for (int i3 = 0; i3 < this.f2442a.getChildCount(); i3++) {
            View childAt = this.f2442a.getChildAt(i3);
            if (childAt != null) {
                this.f2443b.a(childAt, (this.f2442a.getPosition(childAt) - i) + f3);
            } else {
                throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i3), Integer.valueOf(this.f2442a.getChildCount())));
            }
        }
    }
}
