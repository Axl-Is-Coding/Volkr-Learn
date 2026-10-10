package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import com.google.android.material.l.i;

/* JADX INFO: compiled from: AppBarLayout.java */
/* JADX INFO: loaded from: classes2.dex */
class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f13125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AppBarLayout f13126b;

    b(AppBarLayout appBarLayout, i iVar) {
        this.f13126b = appBarLayout;
        this.f13125a = iVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f13125a.b(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
