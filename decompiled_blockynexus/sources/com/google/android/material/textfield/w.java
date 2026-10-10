package com.google.android.material.textfield;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: NoEndIconDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
class w extends t {
    w(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    @Override // com.google.android.material.textfield.t
    void a() {
        this.f13683a.setEndIconOnClickListener(null);
        this.f13683a.setEndIconDrawable((Drawable) null);
        this.f13683a.setEndIconContentDescription((CharSequence) null);
    }
}
