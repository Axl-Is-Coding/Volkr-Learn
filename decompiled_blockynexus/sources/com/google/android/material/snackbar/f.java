package com.google.android.material.snackbar;

import android.animation.ValueAnimator;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: BaseTransientBottomBar.java */
/* JADX INFO: loaded from: classes2.dex */
class f implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f13594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BaseTransientBottomBar f13595c;

    f(BaseTransientBottomBar baseTransientBottomBar, int i) {
        this.f13595c = baseTransientBottomBar;
        this.f13594b = i;
        this.f13593a = this.f13594b;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (BaseTransientBottomBar.f13579b) {
            ViewCompat.c(this.f13595c.g, iIntValue - this.f13593a);
        } else {
            this.f13595c.g.setTranslationY(iIntValue);
        }
        this.f13593a = iIntValue;
    }
}
