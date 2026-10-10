package com.google.android.material.textfield;

import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: renamed from: com.google.android.material.textfield.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
class C2234b implements TextInputLayout.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f13661a;

    C2234b(g gVar) {
        this.f13661a = gVar;
    }

    @Override // com.google.android.material.textfield.TextInputLayout.b
    public void a(TextInputLayout textInputLayout) {
        EditText editText = textInputLayout.getEditText();
        textInputLayout.setEndIconVisible(g.b(editText.getText()));
        textInputLayout.setEndIconCheckable(false);
        editText.removeTextChangedListener(this.f13661a.f13666d);
        editText.addTextChangedListener(this.f13661a.f13666d);
    }
}
