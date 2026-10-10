package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl;

/* JADX INFO: compiled from: FloatingActionButtonImpl.java */
/* JADX INFO: loaded from: classes2.dex */
class l extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f13412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ FloatingActionButtonImpl.e f13413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ FloatingActionButtonImpl f13414c;

    l(FloatingActionButtonImpl floatingActionButtonImpl, boolean z, FloatingActionButtonImpl.e eVar) {
        this.f13414c = floatingActionButtonImpl;
        this.f13412a = z;
        this.f13413b = eVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f13414c.B = 0;
        this.f13414c.v = null;
        FloatingActionButtonImpl.e eVar = this.f13413b;
        if (eVar != null) {
            eVar.a();
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f13414c.F.internalSetVisibility(0, this.f13412a);
        this.f13414c.B = 2;
        this.f13414c.v = animator;
    }
}
