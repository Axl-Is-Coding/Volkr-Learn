package com.google.android.material.snackbar;

import android.animation.ValueAnimator;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: BaseTransientBottomBar.java */
/* JADX INFO: loaded from: classes2.dex */
class h implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13598a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BaseTransientBottomBar f13599b;

    h(BaseTransientBottomBar baseTransientBottomBar) {
        this.f13599b = baseTransientBottomBar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (BaseTransientBottomBar.f13579b) {
            ViewCompat.c(this.f13599b.g, iIntValue - this.f13598a);
        } else {
            this.f13599b.g.setTranslationY(iIntValue);
        }
        this.f13598a = iIntValue;
    }
}
