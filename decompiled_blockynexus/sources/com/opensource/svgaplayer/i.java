package com.opensource.svgaplayer;

import android.animation.Animator;
import com.opensource.svgaplayer.SVGAImageView;

/* JADX INFO: compiled from: SVGAImageView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f15542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f15543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SVGAImageView f15544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ com.opensource.svgaplayer.b.b f15545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ c f15546e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ boolean f15547f;

    i(int i, int i2, SVGAImageView sVGAImageView, com.opensource.svgaplayer.b.b bVar, c cVar, boolean z) {
        this.f15542a = i;
        this.f15543b = i2;
        this.f15544c = sVGAImageView;
        this.f15545d = bVar;
        this.f15546e = cVar;
        this.f15547f = z;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f15544c.isAnimating = false;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f15544c.isAnimating = false;
        this.f15544c.stopAnimation();
        if (!this.f15544c.getClearsAfterStop()) {
            if (this.f15544c.getFillMode() == SVGAImageView.FillMode.Backward) {
                this.f15546e.a(this.f15542a);
            } else if (this.f15544c.getFillMode() == SVGAImageView.FillMode.Forward) {
                this.f15546e.a(this.f15543b);
            }
        }
        b callback = this.f15544c.getCallback();
        if (callback != null) {
            callback.a();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        b callback = this.f15544c.getCallback();
        if (callback != null) {
            callback.b();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f15544c.isAnimating = true;
    }
}
