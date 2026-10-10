package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionMenuView;

/* JADX INFO: compiled from: BottomAppBar.java */
/* JADX INFO: loaded from: classes2.dex */
class h extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f13181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ActionMenuView f13182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f13183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f13184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ BottomAppBar f13185e;

    h(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i, boolean z) {
        this.f13185e = bottomAppBar;
        this.f13182b = actionMenuView;
        this.f13183c = i;
        this.f13184d = z;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f13181a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.f13181a) {
            return;
        }
        this.f13185e.translateActionMenuView(this.f13182b, this.f13183c, this.f13184d);
    }
}
