package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;

/* JADX INFO: renamed from: com.google.android.material.datepicker.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CalendarItemStyle.java */
/* JADX INFO: loaded from: classes2.dex */
final class C2231c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rect f13298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ColorStateList f13299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ColorStateList f13300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ColorStateList f13301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f13302e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.google.android.material.l.n f13303f;

    private C2231c(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i, com.google.android.material.l.n nVar, Rect rect) {
        androidx.core.f.h.a(rect.left);
        androidx.core.f.h.a(rect.top);
        androidx.core.f.h.a(rect.right);
        androidx.core.f.h.a(rect.bottom);
        this.f13298a = rect;
        this.f13299b = colorStateList2;
        this.f13300c = colorStateList;
        this.f13301d = colorStateList3;
        this.f13302e = i;
        this.f13303f = nVar;
    }

    static C2231c a(Context context, int i) {
        androidx.core.f.h.a(i != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.MaterialCalendarItem);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetLeft, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetTop, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetRight, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList colorStateListA = com.google.android.material.i.c.a(context, typedArrayObtainStyledAttributes, R.styleable.MaterialCalendarItem_itemFillColor);
        ColorStateList colorStateListA2 = com.google.android.material.i.c.a(context, typedArrayObtainStyledAttributes, R.styleable.MaterialCalendarItem_itemTextColor);
        ColorStateList colorStateListA3 = com.google.android.material.i.c.a(context, typedArrayObtainStyledAttributes, R.styleable.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialCalendarItem_itemStrokeWidth, 0);
        com.google.android.material.l.n nVarA = com.google.android.material.l.n.a(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearance, 0), typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).a();
        typedArrayObtainStyledAttributes.recycle();
        return new C2231c(colorStateListA, colorStateListA2, colorStateListA3, dimensionPixelSize, nVarA, rect);
    }

    int b() {
        return this.f13298a.top;
    }

    void a(TextView textView) {
        com.google.android.material.l.i iVar = new com.google.android.material.l.i();
        com.google.android.material.l.i iVar2 = new com.google.android.material.l.i();
        iVar.setShapeAppearanceModel(this.f13303f);
        iVar2.setShapeAppearanceModel(this.f13303f);
        iVar.a(this.f13300c);
        iVar.a(this.f13302e, this.f13301d);
        textView.setTextColor(this.f13299b);
        Drawable rippleDrawable = Build.VERSION.SDK_INT >= 21 ? new RippleDrawable(this.f13299b.withAlpha(30), iVar, iVar2) : iVar;
        Rect rect = this.f13298a;
        ViewCompat.a(textView, new InsetDrawable(rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }

    int a() {
        return this.f13298a.bottom;
    }
}
