package com.google.android.material.tabs;

import android.animation.ValueAnimator;

/* JADX INFO: compiled from: TabLayout.java */
/* JADX INFO: loaded from: classes2.dex */
class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ TabLayout f13637a;

    a(TabLayout tabLayout) {
        this.f13637a = tabLayout;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f13637a.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
    }
}
