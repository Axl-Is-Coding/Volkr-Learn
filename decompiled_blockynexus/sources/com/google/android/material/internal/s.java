package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.ia;
import com.google.android.material.R;

/* JADX INFO: compiled from: ThemeEnforcement.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f13483a = {R.attr.colorPrimary};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f13484b = {R.attr.colorPrimaryVariant};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f13485c = {android.R.attr.theme, R.attr.theme};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f13486d = {R.attr.materialThemeOverlay};

    public static TypedArray a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        b(context, attributeSet, i, i2);
        c(context, attributeSet, iArr, i, i2, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i, i2);
    }

    public static ia b(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        b(context, attributeSet, i, i2);
        c(context, attributeSet, iArr, i, i2, iArr2);
        return ia.a(context, attributeSet, iArr, i, i2);
    }

    private static void c(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ThemeEnforcement, i, i2);
        if (!typedArrayObtainStyledAttributes.getBoolean(R.styleable.ThemeEnforcement_enforceTextAppearance, false)) {
            typedArrayObtainStyledAttributes.recycle();
            return;
        }
        boolean zD = (iArr2 == null || iArr2.length == 0) ? typedArrayObtainStyledAttributes.getResourceId(R.styleable.ThemeEnforcement_android_textAppearance, -1) != -1 : d(context, attributeSet, iArr, i, i2, iArr2);
        typedArrayObtainStyledAttributes.recycle();
        if (!zD) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    private static boolean d(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, i2);
        for (int i3 : iArr2) {
            if (typedArrayObtainStyledAttributes.getResourceId(i3, -1) == -1) {
                typedArrayObtainStyledAttributes.recycle();
                return false;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return true;
    }

    public static void a(Context context) {
        a(context, f13483a, "Theme.AppCompat");
    }

    private static void b(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ThemeEnforcement, i, i2);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ThemeEnforcement_enforceMaterialTheme, false);
        typedArrayObtainStyledAttributes.recycle();
        if (z) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R.attr.isMaterialTheme, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                b(context);
            }
        }
        a(context);
    }

    private static boolean a(Context context, int[] iArr) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i = 0; i < iArr.length; i++) {
            if (!typedArrayObtainStyledAttributes.hasValue(i)) {
                typedArrayObtainStyledAttributes.recycle();
                return false;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return true;
    }

    private static void a(Context context, int[] iArr, String str) {
        if (a(context, iArr)) {
            return;
        }
        throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
    }

    public static Context a(Context context, AttributeSet attributeSet, int i, int i2) {
        int iC = c(context, attributeSet, i, i2);
        if (iC == 0) {
            return context;
        }
        if ((context instanceof androidx.appcompat.d.d) && ((androidx.appcompat.d.d) context).a() == iC) {
            return context;
        }
        androidx.appcompat.d.d dVar = new androidx.appcompat.d.d(context, iC);
        int iA = a(dVar, attributeSet);
        return iA != 0 ? new androidx.appcompat.d.d(dVar, iA) : dVar;
    }

    private static int c(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f13486d, i, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public static void b(Context context) {
        a(context, f13484b, "Theme.MaterialComponents");
    }

    private static int a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f13485c);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != 0 ? resourceId : resourceId2;
    }
}
