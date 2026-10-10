package com.google.android.material.textfield;

import android.widget.AutoCompleteTextView;

/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
class p implements AutoCompleteTextView.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ s f13677a;

    p(s sVar) {
        this.f13677a = sVar;
    }

    @Override // android.widget.AutoCompleteTextView.OnDismissListener
    public void onDismiss() {
        this.f13677a.h = true;
        this.f13677a.j = System.currentTimeMillis();
        this.f13677a.a(false);
    }
}
