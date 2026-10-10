package com.google.android.material.textfield;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AutoCompleteTextView;

/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
class k implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ s f13671a;

    k(s sVar) {
        this.f13671a = sVar;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        s sVar = this.f13671a;
        AutoCompleteTextView autoCompleteTextViewA = sVar.a(sVar.f13683a.getEditText());
        autoCompleteTextViewA.post(new j(this, autoCompleteTextViewA));
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
