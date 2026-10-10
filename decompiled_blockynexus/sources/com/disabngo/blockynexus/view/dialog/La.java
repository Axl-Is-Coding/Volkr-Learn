package com.disabngo.blockynexus.view.dialog;

import android.animation.Animator;
import android.content.Context;
import com.sandboxol.common.dialog.FullScreenDialog;

/* JADX INFO: compiled from: ScrapRewardDetailsDialog.java */
/* JADX INFO: loaded from: classes2.dex */
class La implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ma f11318a;

    La(Ma ma) {
        this.f11318a = ma;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f11318a.f11320a.f11322a.f11332c.f11343e = false;
        Context context = ((FullScreenDialog) this.f11318a.f11320a.f11322a.f11332c).context;
        Oa oa = this.f11318a.f11320a.f11322a;
        Pa pa = oa.f11332c;
        new Qa(context, pa.f11340b, oa.f11330a, oa.f11331b ? 1 : pa.k.get().intValue(), this.f11318a.f11320a.f11322a.f11332c.j.get().intValue(), new Ka(this)).show();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}
