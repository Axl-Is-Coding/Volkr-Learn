package com.google.android.material.textfield;

import android.widget.AutoCompleteTextView;

/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AutoCompleteTextView f13669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ k f13670b;

    j(k kVar, AutoCompleteTextView autoCompleteTextView) {
        this.f13670b = kVar;
        this.f13669a = autoCompleteTextView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zIsPopupShowing = this.f13669a.isPopupShowing();
        this.f13670b.f13671a.a(zIsPopupShowing);
        this.f13670b.f13671a.h = zIsPopupShowing;
    }
}
