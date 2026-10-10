package com.disabngo.blockynexus.view.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: compiled from: ScrapReceivedAnimDialog.java */
/* JADX INFO: loaded from: classes2.dex */
class Ia extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ScrapReceivedAnimDialog f11311a;

    Ia(ScrapReceivedAnimDialog scrapReceivedAnimDialog) {
        this.f11311a = scrapReceivedAnimDialog;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.f11311a.finish();
    }
}
