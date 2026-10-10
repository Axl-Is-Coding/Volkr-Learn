package com.google.android.material.datepicker;

import android.os.Build;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: DateStrings.java */
/* JADX INFO: loaded from: classes2.dex */
class f {
    static String a(long j) {
        return a(j, Locale.getDefault());
    }

    static String b(long j) {
        return b(j, Locale.getDefault());
    }

    static String a(long j, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? C.a(locale).format(new Date(j)) : C.b(locale).format(new Date(j));
    }

    static String b(long j, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? C.c(locale).format(new Date(j)) : C.b(locale).format(new Date(j));
    }
}
