package com.disabngo.blockynexus.view.dialog;

import android.animation.Animator;

/* JADX INFO: compiled from: ScrapRewardDetailsDialog.java */
/* JADX INFO: loaded from: classes2.dex */
class Na implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Oa f11322a;

    Na(Oa oa) {
        this.f11322a = oa;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f11322a.f11332c.f11339a.f8900e.setVisibility(8);
        this.f11322a.f11332c.f11339a.j.animate().scaleX(1.3f).scaleY(1.3f).setDuration(250L).setListener(new Ma(this)).start();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}
