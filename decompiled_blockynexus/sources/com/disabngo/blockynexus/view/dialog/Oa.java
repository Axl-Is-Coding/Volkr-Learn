package com.disabngo.blockynexus.view.dialog;

import android.animation.Animator;
import com.sandboxol.center.entity.ScrapRewardComposeInfo;

/* JADX INFO: compiled from: ScrapRewardDetailsDialog.java */
/* JADX INFO: loaded from: classes2.dex */
class Oa implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ScrapRewardComposeInfo f11330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f11331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Pa f11332c;

    Oa(Pa pa, ScrapRewardComposeInfo scrapRewardComposeInfo, boolean z) {
        this.f11332c = pa;
        this.f11330a = scrapRewardComposeInfo;
        this.f11331b = z;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f11332c.f11339a.y.setVisibility(0);
        this.f11332c.f11339a.y.animate().scaleY(1.0f).setDuration(500L).setListener(new Na(this)).start();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f11332c.f11339a.y.setVisibility(4);
    }
}
