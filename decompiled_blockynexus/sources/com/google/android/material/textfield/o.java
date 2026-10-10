package com.google.android.material.textfield;

import android.view.View;

/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
class o implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ s f13676a;

    o(s sVar) {
        this.f13676a = sVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        this.f13676a.f13683a.setEndIconActivated(z);
        if (z) {
            return;
        }
        this.f13676a.a(false);
        this.f13676a.h = false;
    }
}
