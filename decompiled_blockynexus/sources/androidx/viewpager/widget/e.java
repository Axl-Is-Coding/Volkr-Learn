package androidx.viewpager.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.core.view.J;
import androidx.core.view.ViewCompat;
import androidx.core.view.r;

/* JADX INFO: compiled from: ViewPager.java */
/* JADX INFO: loaded from: classes.dex */
class e implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rect f2402a = new Rect();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ViewPager f2403b;

    e(ViewPager viewPager) {
        this.f2403b = viewPager;
    }

    @Override // androidx.core.view.r
    public J a(View view, J j) {
        J jB = ViewCompat.b(view, j);
        if (jB.g()) {
            return jB;
        }
        Rect rect = this.f2402a;
        rect.left = jB.c();
        rect.top = jB.e();
        rect.right = jB.d();
        rect.bottom = jB.b();
        int childCount = this.f2403b.getChildCount();
        for (int i = 0; i < childCount; i++) {
            J jA = ViewCompat.a(this.f2403b.getChildAt(i), jB);
            rect.left = Math.min(jA.c(), rect.left);
            rect.top = Math.min(jA.e(), rect.top);
            rect.right = Math.min(jA.d(), rect.right);
            rect.bottom = Math.min(jA.b(), rect.bottom);
        }
        return jB.a(rect.left, rect.top, rect.right, rect.bottom);
    }
}
