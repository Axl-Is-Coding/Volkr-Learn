package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: classes2.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ViewPropertyAnimator f13155d;

    public HideBottomViewOnScrollBehavior() {
        this.f13152a = 0;
        this.f13153b = 2;
        this.f13154c = 0;
    }

    public void b(V v) {
        if (this.f13153b == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f13155d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.f13153b = 2;
        a(v, 0, 225L, com.google.android.material.a.a.f13084d);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        return i == 2;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        this.f13152a = v.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v.getLayoutParams()).bottomMargin;
        return super.a(coordinatorLayout, v, i);
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13152a = 0;
        this.f13153b = 2;
        this.f13154c = 0;
    }

    public void a(V v, int i) {
        this.f13154c = i;
        if (this.f13153b == 1) {
            v.setTranslationY(this.f13152a + this.f13154c);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        if (i2 > 0) {
            a(v);
        } else if (i2 < 0) {
            b(v);
        }
    }

    public void a(V v) {
        if (this.f13153b == 1) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f13155d;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.f13153b = 1;
        a(v, this.f13152a + this.f13154c, 175L, com.google.android.material.a.a.f13083c);
    }

    private void a(V v, int i, long j, TimeInterpolator timeInterpolator) {
        this.f13155d = v.animate().translationY(i).setInterpolator(timeInterpolator).setDuration(j).setListener(new a(this));
    }
}
