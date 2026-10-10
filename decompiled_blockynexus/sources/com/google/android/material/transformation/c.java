package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: FabTransformationBehavior.java */
/* JADX INFO: loaded from: classes2.dex */
class c extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f13715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ View f13716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ View f13717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ FabTransformationBehavior f13718d;

    c(FabTransformationBehavior fabTransformationBehavior, boolean z, View view, View view2) {
        this.f13718d = fabTransformationBehavior;
        this.f13715a = z;
        this.f13716b = view;
        this.f13717c = view2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.f13715a) {
            return;
        }
        this.f13716b.setVisibility(4);
        this.f13717c.setAlpha(1.0f);
        this.f13717c.setVisibility(0);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        if (this.f13715a) {
            this.f13716b.setVisibility(0);
            this.f13717c.setAlpha(WheelView.DividerConfig.FILL);
            this.f13717c.setVisibility(4);
        }
    }
}
