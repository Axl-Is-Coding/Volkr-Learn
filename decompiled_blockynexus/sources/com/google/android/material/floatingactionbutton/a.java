package com.google.android.material.floatingactionbutton;

import android.animation.Animator;

/* JADX INFO: compiled from: AnimatorTracker.java */
/* JADX INFO: loaded from: classes2.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Animator f13386a;

    a() {
    }

    public void a(Animator animator) {
        a();
        this.f13386a = animator;
    }

    public void b() {
        this.f13386a = null;
    }

    public void a() {
        Animator animator = this.f13386a;
        if (animator != null) {
            animator.cancel();
        }
    }
}
