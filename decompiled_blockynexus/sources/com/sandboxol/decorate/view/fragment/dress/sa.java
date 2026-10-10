package com.sandboxol.decorate.view.fragment.dress;

import android.animation.Animator;
import com.sandboxol.decorate.R;

/* JADX INFO: compiled from: DressViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
class sa implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ va f17458a;

    sa(va vaVar) {
        this.f17458a = vaVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f17458a.f17465b.f17128e.setBackgroundResource(R.mipmap.ic_dress_dress_enter);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}
