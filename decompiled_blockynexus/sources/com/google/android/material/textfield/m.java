package com.google.android.material.textfield;

import android.graphics.drawable.Drawable;
import android.widget.AutoCompleteTextView;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
class m implements TextInputLayout.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ s f13673a;

    m(s sVar) {
        this.f13673a = sVar;
    }

    @Override // com.google.android.material.textfield.TextInputLayout.b
    public void a(TextInputLayout textInputLayout) {
        AutoCompleteTextView autoCompleteTextViewA = this.f13673a.a(textInputLayout.getEditText());
        this.f13673a.b(autoCompleteTextViewA);
        this.f13673a.a(autoCompleteTextViewA);
        this.f13673a.c(autoCompleteTextViewA);
        autoCompleteTextViewA.setThreshold(0);
        autoCompleteTextViewA.removeTextChangedListener(this.f13673a.f13681e);
        autoCompleteTextViewA.addTextChangedListener(this.f13673a.f13681e);
        textInputLayout.setErrorIconDrawable((Drawable) null);
        textInputLayout.setTextInputAccessibilityDelegate(this.f13673a.f13682f);
        textInputLayout.setEndIconVisible(true);
    }
}
