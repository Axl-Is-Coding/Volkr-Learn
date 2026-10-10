package androidx.viewpager2.widget;

import android.view.View;
import androidx.core.view.accessibility.e;
import androidx.viewpager2.widget.ViewPager2;

/* JADX INFO: compiled from: ViewPager2.java */
/* JADX INFO: loaded from: classes.dex */
class i implements androidx.core.view.accessibility.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewPager2.f f2448a;

    i(ViewPager2.f fVar) {
        this.f2448a = fVar;
    }

    @Override // androidx.core.view.accessibility.e
    public boolean a(View view, e.a aVar) {
        this.f2448a.c(((ViewPager2) view).getCurrentItem() + 1);
        return true;
    }
}
