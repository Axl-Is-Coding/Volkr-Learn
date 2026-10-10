package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: renamed from: androidx.recyclerview.widget.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DefaultItemAnimator.java */
/* JADX INFO: loaded from: classes.dex */
class C0356f extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ RecyclerView.w f1961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ViewPropertyAnimator f1962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ View f1963c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ C0361k f1964d;

    C0356f(C0361k c0361k, RecyclerView.w wVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f1964d = c0361k;
        this.f1961a = wVar;
        this.f1962b = viewPropertyAnimator;
        this.f1963c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f1962b.setListener(null);
        this.f1963c.setAlpha(1.0f);
        this.f1964d.l(this.f1961a);
        this.f1964d.r.remove(this.f1961a);
        this.f1964d.j();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f1964d.m(this.f1961a);
    }
}
