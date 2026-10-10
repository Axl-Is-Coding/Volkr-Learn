package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl;

/* JADX INFO: compiled from: FloatingActionButtonImpl.java */
/* JADX INFO: loaded from: classes2.dex */
class k extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f13408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f13409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ FloatingActionButtonImpl.e f13410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ FloatingActionButtonImpl f13411d;

    k(FloatingActionButtonImpl floatingActionButtonImpl, boolean z, FloatingActionButtonImpl.e eVar) {
        this.f13411d = floatingActionButtonImpl;
        this.f13409b = z;
        this.f13410c = eVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f13408a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f13411d.B = 0;
        this.f13411d.v = null;
        if (this.f13408a) {
            return;
        }
        this.f13411d.F.internalSetVisibility(this.f13409b ? 8 : 4, this.f13409b);
        FloatingActionButtonImpl.e eVar = this.f13410c;
        if (eVar != null) {
            eVar.b();
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f13411d.F.internalSetVisibility(0, this.f13409b);
        this.f13411d.B = 1;
        this.f13411d.v = animator;
        this.f13408a = false;
    }
}
