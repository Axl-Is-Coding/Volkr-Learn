package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: androidx.fragment.app.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentManagerImpl.java */
/* JADX INFO: loaded from: classes.dex */
class C0341t extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewGroup f1526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ View f1527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Fragment f1528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ LayoutInflaterFactory2C0343v f1529d;

    C0341t(LayoutInflaterFactory2C0343v layoutInflaterFactory2C0343v, ViewGroup viewGroup, View view, Fragment fragment) {
        this.f1529d = layoutInflaterFactory2C0343v;
        this.f1526a = viewGroup;
        this.f1527b = view;
        this.f1528c = fragment;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f1526a.endViewTransition(this.f1527b);
        animator.removeListener(this);
        Fragment fragment = this.f1528c;
        View view = fragment.mView;
        if (view == null || !fragment.mHidden) {
            return;
        }
        view.setVisibility(8);
    }
}
