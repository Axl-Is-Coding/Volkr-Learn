package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: androidx.transition.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ChangeBounds.java */
/* JADX INFO: loaded from: classes.dex */
class C0380c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ViewGroup f2225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BitmapDrawable f2226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ View f2227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ float f2228d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ ChangeBounds f2229e;

    C0380c(ChangeBounds changeBounds, ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f2) {
        this.f2229e = changeBounds;
        this.f2225a = viewGroup;
        this.f2226b = bitmapDrawable;
        this.f2227c = view;
        this.f2228d = f2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        va.b(this.f2225a).b(this.f2226b);
        va.a(this.f2227c, this.f2228d);
    }
}
