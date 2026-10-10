package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: androidx.fragment.app.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentManagerImpl.java */
/* JADX INFO: loaded from: classes.dex */
class C0340s extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewGroup f1522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ View f1523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Fragment f1524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ LayoutInflaterFactory2C0343v f1525d;

    C0340s(LayoutInflaterFactory2C0343v layoutInflaterFactory2C0343v, ViewGroup viewGroup, View view, Fragment fragment) {
        this.f1525d = layoutInflaterFactory2C0343v;
        this.f1522a = viewGroup;
        this.f1523b = view;
        this.f1524c = fragment;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f1522a.endViewTransition(this.f1523b);
        Animator animator2 = this.f1524c.getAnimator();
        this.f1524c.setAnimator(null);
        if (animator2 == null || this.f1522a.indexOfChild(this.f1523b) >= 0) {
            return;
        }
        LayoutInflaterFactory2C0343v layoutInflaterFactory2C0343v = this.f1525d;
        Fragment fragment = this.f1524c;
        layoutInflaterFactory2C0343v.a(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
    }
}
