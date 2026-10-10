package com.disabngo.blockynexus.binding.adapter;

import android.text.InputFilter;
import android.text.Spanned;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SecretQuestionEditTextBindAdapter.java */
/* JADX INFO: loaded from: classes.dex */
class o implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Pattern f7178a = Pattern.compile("[🀀-🏿]|[🐀-\u1f7ff]|[☀-⟿]", 66);

    o() {
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (this.f7178a.matcher(charSequence).find()) {
            return "";
        }
        return null;
    }
}
