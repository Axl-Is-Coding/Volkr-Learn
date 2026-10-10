package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.C0316d;
import androidx.core.view.J;
import androidx.core.view.ViewCompat;
import io.rong.imkit.utils.FileTypeUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Rect f13118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Rect f13119e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f13120f;
    private int g;

    public HeaderScrollingViewBehavior() {
        this.f13118d = new Rect();
        this.f13119e = new Rect();
        this.f13120f = 0;
    }

    private static int c(int i) {
        if (i == 0) {
            return 8388659;
        }
        return i;
    }

    abstract View a(List<View> list);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        View viewA;
        J lastWindowInsets;
        int i5 = view.getLayoutParams().height;
        if ((i5 != -1 && i5 != -2) || (viewA = a(coordinatorLayout.getDependencies(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i3);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (ViewCompat.j(viewA) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.e() + lastWindowInsets.b();
        }
        int iC = size + c(viewA);
        int measuredHeight = viewA.getMeasuredHeight();
        if (e()) {
            view.setTranslationY(-measuredHeight);
        } else {
            iC -= measuredHeight;
        }
        coordinatorLayout.onMeasureChild(view, i, i2, View.MeasureSpec.makeMeasureSpec(iC, i5 == -1 ? FileTypeUtils.GIGABYTE : Integer.MIN_VALUE), i4);
        return true;
    }

    float b(View view) {
        return 1.0f;
    }

    @Override // com.google.android.material.appbar.ViewOffsetBehavior
    protected void b(CoordinatorLayout coordinatorLayout, View view, int i) {
        View viewA = a(coordinatorLayout.getDependencies(view));
        if (viewA == null) {
            super.b(coordinatorLayout, view, i);
            this.f13120f = 0;
            return;
        }
        CoordinatorLayout.d dVar = (CoordinatorLayout.d) view.getLayoutParams();
        Rect rect = this.f13118d;
        rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar).leftMargin, viewA.getBottom() + ((ViewGroup.MarginLayoutParams) dVar).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) dVar).rightMargin, ((coordinatorLayout.getHeight() + viewA.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) dVar).bottomMargin);
        J lastWindowInsets = coordinatorLayout.getLastWindowInsets();
        if (lastWindowInsets != null && ViewCompat.j(coordinatorLayout) && !ViewCompat.j(view)) {
            rect.left += lastWindowInsets.c();
            rect.right -= lastWindowInsets.d();
        }
        Rect rect2 = this.f13119e;
        C0316d.a(c(dVar.f900c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
        int iA = a(viewA);
        view.layout(rect2.left, rect2.top - iA, rect2.right, rect2.bottom - iA);
        this.f13120f = rect2.top - viewA.getBottom();
    }

    int c(View view) {
        return view.getMeasuredHeight();
    }

    final int d() {
        return this.f13120f;
    }

    protected boolean e() {
        return false;
    }

    public final int c() {
        return this.g;
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13118d = new Rect();
        this.f13119e = new Rect();
        this.f13120f = 0;
    }

    final int a(View view) {
        if (this.g == 0) {
            return 0;
        }
        float fB = b(view);
        int i = this.g;
        return androidx.core.c.a.a((int) (fB * i), 0, i);
    }

    public final void b(int i) {
        this.g = i;
    }
}
