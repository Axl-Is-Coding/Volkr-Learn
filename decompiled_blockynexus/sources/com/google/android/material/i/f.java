package com.google.android.material.i;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.material.R;

/* JADX INFO: compiled from: TextAppearance.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f13430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ColorStateList f13431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ColorStateList f13432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ColorStateList f13433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f13434e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f13435f;
    public final String g;
    public final boolean h;
    public final ColorStateList i;
    public final float j;
    public final float k;
    public final float l;
    private final int m;
    private boolean n = false;
    private Typeface o;

    public f(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.TextAppearance);
        this.f13430a = typedArrayObtainStyledAttributes.getDimension(R.styleable.TextAppearance_android_textSize, WheelView.DividerConfig.FILL);
        this.f13431b = c.a(context, typedArrayObtainStyledAttributes, R.styleable.TextAppearance_android_textColor);
        this.f13432c = c.a(context, typedArrayObtainStyledAttributes, R.styleable.TextAppearance_android_textColorHint);
        this.f13433d = c.a(context, typedArrayObtainStyledAttributes, R.styleable.TextAppearance_android_textColorLink);
        this.f13434e = typedArrayObtainStyledAttributes.getInt(R.styleable.TextAppearance_android_textStyle, 0);
        this.f13435f = typedArrayObtainStyledAttributes.getInt(R.styleable.TextAppearance_android_typeface, 1);
        int iA = c.a(typedArrayObtainStyledAttributes, R.styleable.TextAppearance_fontFamily, R.styleable.TextAppearance_android_fontFamily);
        this.m = typedArrayObtainStyledAttributes.getResourceId(iA, 0);
        this.g = typedArrayObtainStyledAttributes.getString(iA);
        this.h = typedArrayObtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        this.i = c.a(context, typedArrayObtainStyledAttributes, R.styleable.TextAppearance_android_shadowColor);
        this.j = typedArrayObtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, WheelView.DividerConfig.FILL);
        this.k = typedArrayObtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, WheelView.DividerConfig.FILL);
        this.l = typedArrayObtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, WheelView.DividerConfig.FILL);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void b() {
        String str;
        if (this.o == null && (str = this.g) != null) {
            this.o = Typeface.create(str, this.f13434e);
        }
        if (this.o == null) {
            int i = this.f13435f;
            if (i == 1) {
                this.o = Typeface.SANS_SERIF;
            } else if (i == 2) {
                this.o = Typeface.SERIF;
            } else if (i != 3) {
                this.o = Typeface.DEFAULT;
            } else {
                this.o = Typeface.MONOSPACE;
            }
            this.o = Typeface.create(this.o, this.f13434e);
        }
    }

    public void c(Context context, TextPaint textPaint, h hVar) {
        if (g.a()) {
            a(textPaint, a(context));
        } else {
            a(context, textPaint, hVar);
        }
    }

    public Typeface a(Context context) {
        if (this.n) {
            return this.o;
        }
        if (!context.isRestricted()) {
            try {
                this.o = androidx.core.content.a.h.a(context, this.m);
                if (this.o != null) {
                    this.o = Typeface.create(this.o, this.f13434e);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e2) {
                Log.d("TextAppearance", "Error loading font " + this.g, e2);
            }
        }
        b();
        this.n = true;
        return this.o;
    }

    public void b(Context context, TextPaint textPaint, h hVar) {
        c(context, textPaint, hVar);
        ColorStateList colorStateList = this.f13431b;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f2 = this.l;
        float f3 = this.j;
        float f4 = this.k;
        ColorStateList colorStateList2 = this.i;
        textPaint.setShadowLayer(f2, f3, f4, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void a(Context context, h hVar) {
        if (g.a()) {
            a(context);
        } else {
            b();
        }
        if (this.m == 0) {
            this.n = true;
        }
        if (this.n) {
            hVar.a(this.o, true);
            return;
        }
        try {
            androidx.core.content.a.h.a(context, this.m, new d(this, hVar), null);
        } catch (Resources.NotFoundException unused) {
            this.n = true;
            hVar.a(1);
        } catch (Exception e2) {
            Log.d("TextAppearance", "Error loading font " + this.g, e2);
            this.n = true;
            hVar.a(-3);
        }
    }

    public void a(Context context, TextPaint textPaint, h hVar) {
        a(textPaint, a());
        a(context, new e(this, textPaint, hVar));
    }

    public Typeface a() {
        b();
        return this.o;
    }

    public void a(TextPaint textPaint, Typeface typeface) {
        textPaint.setTypeface(typeface);
        int style = (typeface.getStyle() ^ (-1)) & this.f13434e;
        textPaint.setFakeBoldText((style & 1) != 0);
        textPaint.setTextSkewX((style & 2) != 0 ? -0.25f : WheelView.DividerConfig.FILL);
        textPaint.setTextSize(this.f13430a);
    }
}
