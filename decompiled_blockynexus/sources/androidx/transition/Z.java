package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: compiled from: Transition.java */
/* JADX INFO: loaded from: classes.dex */
class Z extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ a.a.b f2219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Transition f2220b;

    Z(Transition transition, a.a.b bVar) {
        this.f2220b = transition;
        this.f2219a = bVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f2219a.remove(animator);
        this.f2220b.A.remove(animator);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f2220b.A.add(animator);
    }
}
