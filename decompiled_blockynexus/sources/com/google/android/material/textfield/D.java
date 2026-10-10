package com.google.android.material.textfield;

/* JADX INFO: compiled from: TextInputLayout.java */
/* JADX INFO: loaded from: classes2.dex */
class D implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ TextInputLayout f13653a;

    D(TextInputLayout textInputLayout) {
        this.f13653a = textInputLayout;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f13653a.editText.requestLayout();
    }
}
