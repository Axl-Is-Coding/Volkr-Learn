package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.internal.v;
import com.google.android.material.j.c;
import com.google.android.material.l.i;
import com.google.android.material.l.n;
import com.google.android.material.l.r;

/* JADX INFO: compiled from: MaterialButtonHelper.java */
/* JADX INFO: loaded from: classes2.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f13240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MaterialButton f13241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private n f13242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f13243d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f13244e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f13245f;
    private int g;
    private int h;
    private int i;
    private PorterDuff.Mode j;
    private ColorStateList k;
    private ColorStateList l;
    private ColorStateList m;
    private Drawable n;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private boolean r;
    private LayerDrawable s;

    static {
        f13240a = Build.VERSION.SDK_INT >= 21;
    }

    a(MaterialButton materialButton, n nVar) {
        this.f13241b = materialButton;
        this.f13242c = nVar;
    }

    private Drawable m() {
        i iVar = new i(this.f13242c);
        iVar.a(this.f13241b.getContext());
        androidx.core.graphics.drawable.a.a(iVar, this.k);
        PorterDuff.Mode mode = this.j;
        if (mode != null) {
            androidx.core.graphics.drawable.a.a(iVar, mode);
        }
        iVar.a(this.i, this.l);
        i iVar2 = new i(this.f13242c);
        iVar2.setTint(0);
        iVar2.a(this.i, this.o ? com.google.android.material.d.a.a(this.f13241b, R.attr.colorSurface) : 0);
        if (f13240a) {
            this.n = new i(this.f13242c);
            androidx.core.graphics.drawable.a.b(this.n, -1);
            this.s = new RippleDrawable(c.b(this.m), a(new LayerDrawable(new Drawable[]{iVar2, iVar})), this.n);
            return this.s;
        }
        this.n = new com.google.android.material.j.b(this.f13242c);
        androidx.core.graphics.drawable.a.a(this.n, c.b(this.m));
        this.s = new LayerDrawable(new Drawable[]{iVar2, iVar, this.n});
        return a(this.s);
    }

    private i n() {
        return c(true);
    }

    private void o() {
        i iVarC = c();
        i iVarN = n();
        if (iVarC != null) {
            iVarC.a(this.i, this.l);
            if (iVarN != null) {
                iVarN.a(this.i, this.o ? com.google.android.material.d.a.a(this.f13241b, R.attr.colorSurface) : 0);
            }
        }
    }

    void a(TypedArray typedArray) {
        this.f13243d = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetLeft, 0);
        this.f13244e = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetRight, 0);
        this.f13245f = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetTop, 0);
        this.g = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetBottom, 0);
        if (typedArray.hasValue(R.styleable.MaterialButton_cornerRadius)) {
            this.h = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_cornerRadius, -1);
            a(this.f13242c.a(this.h));
            this.q = true;
        }
        this.i = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_strokeWidth, 0);
        this.j = v.a(typedArray.getInt(R.styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.k = com.google.android.material.i.c.a(this.f13241b.getContext(), typedArray, R.styleable.MaterialButton_backgroundTint);
        this.l = com.google.android.material.i.c.a(this.f13241b.getContext(), typedArray, R.styleable.MaterialButton_strokeColor);
        this.m = com.google.android.material.i.c.a(this.f13241b.getContext(), typedArray, R.styleable.MaterialButton_rippleColor);
        this.r = typedArray.getBoolean(R.styleable.MaterialButton_android_checkable, false);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_elevation, 0);
        int iR = ViewCompat.r(this.f13241b);
        int paddingTop = this.f13241b.getPaddingTop();
        int iQ = ViewCompat.q(this.f13241b);
        int paddingBottom = this.f13241b.getPaddingBottom();
        this.f13241b.setInternalBackground(m());
        i iVarC = c();
        if (iVarC != null) {
            iVarC.b(dimensionPixelSize);
        }
        ViewCompat.b(this.f13241b, iR + this.f13243d, paddingTop + this.f13245f, iQ + this.f13244e, paddingBottom + this.g);
    }

    void b(boolean z) {
        this.o = z;
        o();
    }

    void c(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            if (c() != null) {
                androidx.core.graphics.drawable.a.a(c(), this.k);
            }
        }
    }

    ColorStateList d() {
        return this.m;
    }

    n e() {
        return this.f13242c;
    }

    ColorStateList f() {
        return this.l;
    }

    int g() {
        return this.i;
    }

    ColorStateList h() {
        return this.k;
    }

    PorterDuff.Mode i() {
        return this.j;
    }

    boolean j() {
        return this.p;
    }

    boolean k() {
        return this.r;
    }

    void l() {
        this.p = true;
        this.f13241b.setSupportBackgroundTintList(this.k);
        this.f13241b.setSupportBackgroundTintMode(this.j);
    }

    void b(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            o();
        }
    }

    void c(int i) {
        if (this.i != i) {
            this.i = i;
            o();
        }
    }

    void b(int i) {
        if (this.q && this.h == i) {
            return;
        }
        this.h = i;
        this.q = true;
        a(this.f13242c.a(i));
    }

    private i c(boolean z) {
        LayerDrawable layerDrawable = this.s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        if (f13240a) {
            return (i) ((LayerDrawable) ((InsetDrawable) this.s.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0);
        }
        return (i) this.s.getDrawable(!z ? 1 : 0);
    }

    private void b(n nVar) {
        if (c() != null) {
            c().setShapeAppearanceModel(nVar);
        }
        if (n() != null) {
            n().setShapeAppearanceModel(nVar);
        }
        if (b() != null) {
            b().setShapeAppearanceModel(nVar);
        }
    }

    i c() {
        return c(false);
    }

    public r b() {
        LayerDrawable layerDrawable = this.s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        if (this.s.getNumberOfLayers() > 2) {
            return (r) this.s.getDrawable(2);
        }
        return (r) this.s.getDrawable(1);
    }

    private InsetDrawable a(Drawable drawable) {
        return new InsetDrawable(drawable, this.f13243d, this.f13245f, this.f13244e, this.g);
    }

    void a(PorterDuff.Mode mode) {
        if (this.j != mode) {
            this.j = mode;
            if (c() == null || this.j == null) {
                return;
            }
            androidx.core.graphics.drawable.a.a(c(), this.j);
        }
    }

    void a(int i, int i2) {
        Drawable drawable = this.n;
        if (drawable != null) {
            drawable.setBounds(this.f13243d, this.f13245f, i2 - this.f13244e, i - this.g);
        }
    }

    void a(int i) {
        if (c() != null) {
            c().setTint(i);
        }
    }

    void a(ColorStateList colorStateList) {
        if (this.m != colorStateList) {
            this.m = colorStateList;
            if (f13240a && (this.f13241b.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f13241b.getBackground()).setColor(c.b(colorStateList));
            } else {
                if (f13240a || !(this.f13241b.getBackground() instanceof com.google.android.material.j.b)) {
                    return;
                }
                ((com.google.android.material.j.b) this.f13241b.getBackground()).setTintList(c.b(colorStateList));
            }
        }
    }

    int a() {
        return this.h;
    }

    void a(boolean z) {
        this.r = z;
    }

    void a(n nVar) {
        this.f13242c = nVar;
        b(nVar);
    }
}
