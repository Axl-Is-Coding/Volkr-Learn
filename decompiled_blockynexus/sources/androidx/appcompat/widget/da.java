package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;

/* JADX INFO: compiled from: ThemeUtils.java */
/* JADX INFO: loaded from: classes.dex */
class da {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f635a = new ThreadLocal<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int[] f636b = {-16842910};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int[] f637c = {R.attr.state_focused};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int[] f638d = {R.attr.state_activated};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int[] f639e = {R.attr.state_pressed};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int[] f640f = {R.attr.state_checked};
    static final int[] g = {R.attr.state_selected};
    static final int[] h = {-16842919, -16842908};
    static final int[] i = new int[0];
    private static final int[] j = new int[1];

    public static int a(Context context, int i2) {
        ColorStateList colorStateListC = c(context, i2);
        if (colorStateListC != null && colorStateListC.isStateful()) {
            return colorStateListC.getColorForState(f636b, colorStateListC.getDefaultColor());
        }
        TypedValue typedValueA = a();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValueA, true);
        return a(context, i2, typedValueA.getFloat());
    }

    public static int b(Context context, int i2) {
        int[] iArr = j;
        iArr[0] = i2;
        ia iaVarA = ia.a(context, (AttributeSet) null, iArr);
        try {
            return iaVarA.a(0, 0);
        } finally {
            iaVarA.a();
        }
    }

    public static ColorStateList c(Context context, int i2) {
        int[] iArr = j;
        iArr[0] = i2;
        ia iaVarA = ia.a(context, (AttributeSet) null, iArr);
        try {
            return iaVarA.a(0);
        } finally {
            iaVarA.a();
        }
    }

    private static TypedValue a() {
        TypedValue typedValue = f635a.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        f635a.set(typedValue2);
        return typedValue2;
    }

    static int a(Context context, int i2, float f2) {
        return androidx.core.a.a.b(b(context, i2), Math.round(Color.alpha(r0) * f2));
    }
}
