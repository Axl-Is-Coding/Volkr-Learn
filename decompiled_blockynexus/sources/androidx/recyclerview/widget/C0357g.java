package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: renamed from: androidx.recyclerview.widget.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DefaultItemAnimator.java */
/* JADX INFO: loaded from: classes.dex */
class C0357g extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ RecyclerView.w f1972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ View f1973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ViewPropertyAnimator f1974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ C0361k f1975d;

    C0357g(C0361k c0361k, RecyclerView.w wVar, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.f1975d = c0361k;
        this.f1972a = wVar;
        this.f1973b = view;
        this.f1974c = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f1973b.setAlpha(1.0f);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f1974c.setListener(null);
        this.f1975d.h(this.f1972a);
        this.f1975d.p.remove(this.f1972a);
        this.f1975d.j();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f1975d.i(this.f1972a);
    }
}
