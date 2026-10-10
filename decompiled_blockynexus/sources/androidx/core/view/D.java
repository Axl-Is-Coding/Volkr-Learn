package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: compiled from: ViewPropertyAnimatorCompat.java */
/* JADX INFO: loaded from: classes.dex */
class D extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ G f1195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ View f1196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ F f1197c;

    D(F f2, G g, View view) {
        this.f1197c = f2;
        this.f1195a = g;
        this.f1196b = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f1195a.a(this.f1196b);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f1195a.b(this.f1196b);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f1195a.c(this.f1196b);
    }
}
