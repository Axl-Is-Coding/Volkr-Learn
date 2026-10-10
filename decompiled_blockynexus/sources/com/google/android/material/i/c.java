package com.google.android.material.i;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import androidx.appcompat.widget.ia;

/* JADX INFO: compiled from: MaterialResources.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static ColorStateList a(Context context, TypedArray typedArray, int i) {
        int color;
        int resourceId;
        ColorStateList colorStateListA;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateListA = androidx.appcompat.a.a.a.a(context, resourceId)) == null) ? (Build.VERSION.SDK_INT > 15 || (color = typedArray.getColor(i, -1)) == -1) ? typedArray.getColorStateList(i) : ColorStateList.valueOf(color) : colorStateListA;
    }

    public static Drawable b(Context context, TypedArray typedArray, int i) {
        int resourceId;
        Drawable drawableB;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (drawableB = androidx.appcompat.a.a.a.b(context, resourceId)) == null) ? typedArray.getDrawable(i) : drawableB;
    }

    public static f c(Context context, TypedArray typedArray, int i) {
        int resourceId;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return null;
        }
        return new f(context, resourceId);
    }

    public static ColorStateList a(Context context, ia iaVar, int i) {
        int iA;
        int iG;
        ColorStateList colorStateListA;
        if (iaVar.g(i) && (iG = iaVar.g(i, 0)) != 0 && (colorStateListA = androidx.appcompat.a.a.a.a(context, iG)) != null) {
            return colorStateListA;
        }
        if (Build.VERSION.SDK_INT <= 15 && (iA = iaVar.a(i, -1)) != -1) {
            return ColorStateList.valueOf(iA);
        }
        return iaVar.a(i);
    }

    public static int a(Context context, TypedArray typedArray, int i, int i2) {
        TypedValue typedValue = new TypedValue();
        if (typedArray.getValue(i, typedValue) && typedValue.type == 2) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, i2);
            typedArrayObtainStyledAttributes.recycle();
            return dimensionPixelSize;
        }
        return typedArray.getDimensionPixelSize(i, i2);
    }

    static int a(TypedArray typedArray, int i, int i2) {
        return typedArray.hasValue(i) ? i : i2;
    }
}
