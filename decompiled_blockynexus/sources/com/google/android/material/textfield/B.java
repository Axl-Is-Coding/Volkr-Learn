package com.google.android.material.textfield;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: compiled from: TextInputLayout.java */
/* JADX INFO: loaded from: classes2.dex */
class B implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ TextInputLayout f13650a;

    B(TextInputLayout textInputLayout) {
        this.f13650a = textInputLayout;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.f13650a.updateLabelState(!r0.restoringSavedState);
        TextInputLayout textInputLayout = this.f13650a;
        if (textInputLayout.counterEnabled) {
            textInputLayout.updateCounter(editable.length());
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
