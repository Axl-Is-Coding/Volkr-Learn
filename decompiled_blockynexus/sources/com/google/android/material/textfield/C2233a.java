package com.google.android.material.textfield;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: renamed from: com.google.android.material.textfield.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
class C2233a implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f13660a;

    C2233a(g gVar) {
        this.f13660a = gVar;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (!g.b(editable)) {
            this.f13660a.f13668f.cancel();
            this.f13660a.g.start();
        } else {
            if (this.f13660a.f13683a.isEndIconVisible()) {
                return;
            }
            this.f13660a.g.cancel();
            this.f13660a.f13668f.start();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
