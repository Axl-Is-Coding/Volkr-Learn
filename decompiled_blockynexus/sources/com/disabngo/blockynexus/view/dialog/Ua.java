package com.disabngo.blockynexus.view.dialog;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: compiled from: UnbindingPhoneDialog.java */
/* JADX INFO: loaded from: classes2.dex */
class Ua implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Va f11398a;

    Ua(Va va) {
        this.f11398a = va;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f11398a.f11436d != null) {
            this.f11398a.f11436d.a(charSequence.toString());
        }
    }
}
