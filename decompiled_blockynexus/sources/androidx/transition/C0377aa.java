package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: renamed from: androidx.transition.aa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: Transition.java */
/* JADX INFO: loaded from: classes.dex */
class C0377aa extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Transition f2221a;

    C0377aa(Transition transition) {
        this.f2221a = transition;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f2221a.b();
        animator.removeListener(this);
    }
}
