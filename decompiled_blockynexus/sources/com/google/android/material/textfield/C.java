package com.google.android.material.textfield;

/* JADX INFO: compiled from: TextInputLayout.java */
/* JADX INFO: loaded from: classes2.dex */
class C implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ TextInputLayout f13651a;

    C(TextInputLayout textInputLayout) {
        this.f13651a = textInputLayout;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f13651a.endIconView.performClick();
        this.f13651a.endIconView.jumpDrawablesToCurrentState();
    }
}
