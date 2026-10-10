package com.google.android.material.d;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import com.google.android.material.i.b;

/* JADX INFO: compiled from: MaterialColors.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static int a(View view, int i) {
        return b.a(view, i);
    }

    public static int a(Context context, int i, String str) {
        return b.a(context, i, str);
    }

    public static int a(View view, int i, int i2) {
        return a(view.getContext(), i, i2);
    }

    public static int a(Context context, int i, int i2) {
        TypedValue typedValueA = b.a(context, i);
        return typedValueA != null ? typedValueA.data : i2;
    }

    public static int a(View view, int i, int i2, float f2) {
        return a(a(view, i), a(view, i2), f2);
    }

    public static int a(int i, int i2, float f2) {
        return a(i, androidx.core.a.a.b(i2, Math.round(Color.alpha(i2) * f2)));
    }

    public static int a(int i, int i2) {
        return androidx.core.a.a.a(i2, i);
    }
}
