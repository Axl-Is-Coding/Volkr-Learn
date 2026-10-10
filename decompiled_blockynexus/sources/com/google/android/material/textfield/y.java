package com.google.android.material.textfield;

import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
class y implements TextInputLayout.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ A f13698a;

    y(A a2) {
        this.f13698a = a2;
    }

    @Override // com.google.android.material.textfield.TextInputLayout.b
    public void a(TextInputLayout textInputLayout) {
        EditText editText = textInputLayout.getEditText();
        textInputLayout.setEndIconVisible(true);
        this.f13698a.f13685c.setChecked(!r4.c());
        editText.removeTextChangedListener(this.f13698a.f13647d);
        editText.addTextChangedListener(this.f13698a.f13647d);
    }
}
