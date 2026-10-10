package com.disabngo.blockynexus.view.activity.main;

import android.animation.Animator;
import android.widget.ImageView;

/* JADX INFO: compiled from: MainModel.java */
/* JADX INFO: loaded from: classes2.dex */
class Rb implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ImageView f10828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Sb f10829b;

    Rb(Sb sb, ImageView imageView) {
        this.f10829b = sb;
        this.f10828a = imageView;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (!this.f10829b.f10836e.isRunning()) {
            Sb sb = this.f10829b;
            sb.f10835d.removeView(sb.f10837f);
            this.f10829b.f10835d.removeView(this.f10828a);
        }
        try {
            if (this.f10829b.g != null) {
                this.f10829b.g.run();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}
