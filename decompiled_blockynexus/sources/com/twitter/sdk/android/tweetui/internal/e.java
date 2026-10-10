package com.twitter.sdk.android.tweetui.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: compiled from: AnimationUtils.java */
/* JADX INFO: loaded from: classes5.dex */
class e extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f20410a;

    e(View view) {
        this.f20410a = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f20410a.setVisibility(4);
        this.f20410a.setAlpha(1.0f);
    }
}
