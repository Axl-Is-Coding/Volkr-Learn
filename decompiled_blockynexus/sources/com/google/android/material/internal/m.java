package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: compiled from: StateListAnimator.java */
/* JADX INFO: loaded from: classes2.dex */
class m extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ n f13467a;

    m(n nVar) {
        this.f13467a = nVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        n nVar = this.f13467a;
        if (nVar.f13470c == animator) {
            nVar.f13470c = null;
        }
    }
}
