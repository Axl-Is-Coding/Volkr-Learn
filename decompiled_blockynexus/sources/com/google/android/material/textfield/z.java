package com.google.android.material.textfield;

import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
class z implements TextInputLayout.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ A f13699a;

    z(A a2) {
        this.f13699a = a2;
    }

    @Override // com.google.android.material.textfield.TextInputLayout.c
    public void a(TextInputLayout textInputLayout, int i) {
        EditText editText = textInputLayout.getEditText();
        if (editText == null || i != 1) {
            return;
        }
        editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }
}
