package com.sandbox.login.f.a.c;

import android.content.Context;
import androidx.databinding.ObservableField;

/* JADX INFO: compiled from: ConfirmPasswordModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {
    public void a(Context context, String str, ObservableField<Boolean> observableField, String str2) {
        observableField.set(true);
        com.sandbox.login.web.b.c(context, str, new d(this, observableField, str2, context, str));
    }
}
