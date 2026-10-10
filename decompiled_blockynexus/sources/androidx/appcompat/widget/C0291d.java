package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: renamed from: androidx.appcompat.widget.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActionBarOverlayLayout.java */
/* JADX INFO: loaded from: classes.dex */
class C0291d extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ActionBarOverlayLayout f634a;

    C0291d(ActionBarOverlayLayout actionBarOverlayLayout) {
        this.f634a = actionBarOverlayLayout;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        ActionBarOverlayLayout actionBarOverlayLayout = this.f634a;
        actionBarOverlayLayout.mCurrentActionBarTopAnimator = null;
        actionBarOverlayLayout.mAnimatingForFling = false;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        ActionBarOverlayLayout actionBarOverlayLayout = this.f634a;
        actionBarOverlayLayout.mCurrentActionBarTopAnimator = null;
        actionBarOverlayLayout.mAnimatingForFling = false;
    }
}
