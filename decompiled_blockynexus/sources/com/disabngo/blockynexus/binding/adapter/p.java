package com.disabngo.blockynexus.binding.adapter;

import android.text.InputFilter;
import android.widget.EditText;

/* JADX INFO: compiled from: SecretQuestionEditTextBindAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class p {
    public static void a(EditText editText, boolean z) {
        if (z) {
            editText.setFilters(new InputFilter[]{new o()});
        }
    }
}
