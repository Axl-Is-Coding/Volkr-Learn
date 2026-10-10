package com.google.android.ads.mediationtestsuite.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.Toolbar;

/* JADX INFO: compiled from: AdUnitDetailActivity.java */
/* JADX INFO: loaded from: classes.dex */
class f extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Toolbar f12643a;

    f(Toolbar toolbar) {
        this.f12643a = toolbar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f12643a.setVisibility(8);
    }
}
