package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: IndicatorViewController.java */
/* JADX INFO: loaded from: classes2.dex */
class u extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f13686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TextView f13687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f13688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ TextView f13689d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ v f13690e;

    u(v vVar, int i, TextView textView, int i2, TextView textView2) {
        this.f13690e = vVar;
        this.f13686a = i;
        this.f13687b = textView;
        this.f13688c = i2;
        this.f13689d = textView2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f13690e.i = this.f13686a;
        this.f13690e.g = null;
        TextView textView = this.f13687b;
        if (textView != null) {
            textView.setVisibility(4);
            if (this.f13688c == 1 && this.f13690e.m != null) {
                this.f13690e.m.setText((CharSequence) null);
            }
            TextView textView2 = this.f13689d;
            if (textView2 != null) {
                textView2.setTranslationY(WheelView.DividerConfig.FILL);
                this.f13689d.setAlpha(1.0f);
            }
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        TextView textView = this.f13689d;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }
}
