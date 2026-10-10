package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: renamed from: androidx.transition.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ChangeClipBounds.java */
/* JADX INFO: loaded from: classes.dex */
class C0395m extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f2271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ChangeClipBounds f2272b;

    C0395m(ChangeClipBounds changeClipBounds, View view) {
        this.f2272b = changeClipBounds;
        this.f2271a = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        ViewCompat.a(this.f2271a, (Rect) null);
    }
}
