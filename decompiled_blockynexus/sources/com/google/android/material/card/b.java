package com.google.android.material.card;

import android.R;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.view.ViewCompat;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.material.j.c;
import com.google.android.material.l.d;
import com.google.android.material.l.e;
import com.google.android.material.l.i;
import com.google.android.material.l.l;
import com.google.android.material.l.n;

/* JADX INFO: compiled from: MaterialCardViewHelper.java */
/* JADX INFO: loaded from: classes2.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f13248a = {R.attr.state_checked};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final double f13249b = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MaterialCardView f13250c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final i f13252e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final i f13253f;
    private final int g;
    private final int h;
    private int i;
    private Drawable j;
    private Drawable k;
    private ColorStateList l;
    private ColorStateList m;
    private n n;
    private ColorStateList o;
    private Drawable p;
    private LayerDrawable q;
    private i r;
    private i s;
    private boolean u;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f13251d = new Rect();
    private boolean t = false;

    public b(MaterialCardView materialCardView, AttributeSet attributeSet, int i, int i2) {
        this.f13250c = materialCardView;
        this.f13252e = new i(materialCardView.getContext(), attributeSet, i, i2);
        this.f13252e.a(materialCardView.getContext());
        this.f13252e.a(-12303292);
        n.a aVarN = this.f13252e.l().n();
        TypedArray typedArrayObtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.CardView, i, com.google.android.material.R.style.CardView);
        if (typedArrayObtainStyledAttributes.hasValue(com.google.android.material.R.styleable.CardView_cardCornerRadius)) {
            aVarN.a(typedArrayObtainStyledAttributes.getDimension(com.google.android.material.R.styleable.CardView_cardCornerRadius, WheelView.DividerConfig.FILL));
        }
        this.f13253f = new i();
        a(aVarN.a());
        Resources resources = materialCardView.getResources();
        this.g = resources.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_card_checked_icon_margin);
        this.h = resources.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_card_checked_icon_size);
        typedArrayObtainStyledAttributes.recycle();
    }

    private Drawable A() {
        if (!c.f13496a) {
            return z();
        }
        this.s = B();
        return new RippleDrawable(this.l, null, this.s);
    }

    private i B() {
        return new i(this.n);
    }

    private Drawable C() {
        if (this.p == null) {
            this.p = A();
        }
        if (this.q == null) {
            this.q = new LayerDrawable(new Drawable[]{this.p, this.f13253f, y()});
            this.q.setId(2, com.google.android.material.R.id.mtrl_card_checked_layer_id);
        }
        return this.q;
    }

    private float D() {
        if (!this.f13250c.getPreventCornerOverlap()) {
            return WheelView.DividerConfig.FILL;
        }
        if (Build.VERSION.SDK_INT >= 21 && !this.f13250c.getUseCompatPadding()) {
            return WheelView.DividerConfig.FILL;
        }
        double d2 = 1.0d - f13249b;
        double cardViewRadius = this.f13250c.getCardViewRadius();
        Double.isNaN(cardViewRadius);
        return (float) (d2 * cardViewRadius);
    }

    private boolean E() {
        return this.f13250c.getPreventCornerOverlap() && !x();
    }

    private boolean F() {
        return this.f13250c.getPreventCornerOverlap() && x() && this.f13250c.getUseCompatPadding();
    }

    private void G() {
        Drawable drawable;
        if (c.f13496a && (drawable = this.p) != null) {
            ((RippleDrawable) drawable).setColor(this.l);
            return;
        }
        i iVar = this.r;
        if (iVar != null) {
            iVar.a(this.l);
        }
    }

    private float u() {
        return Math.max(Math.max(a(this.n.j(), this.f13252e.n()), a(this.n.l(), this.f13252e.o())), Math.max(a(this.n.e(), this.f13252e.c()), a(this.n.c(), this.f13252e.b())));
    }

    private float v() {
        return this.f13250c.getMaxCardElevation() + (F() ? u() : WheelView.DividerConfig.FILL);
    }

    private float w() {
        return (this.f13250c.getMaxCardElevation() * 1.5f) + (F() ? u() : WheelView.DividerConfig.FILL);
    }

    private boolean x() {
        return Build.VERSION.SDK_INT >= 21 && this.f13252e.s();
    }

    private Drawable y() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = this.k;
        if (drawable != null) {
            stateListDrawable.addState(f13248a, drawable);
        }
        return stateListDrawable;
    }

    private Drawable z() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.r = B();
        this.r.a(this.l);
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, this.r);
        return stateListDrawable;
    }

    void a(TypedArray typedArray) {
        this.o = com.google.android.material.i.c.a(this.f13250c.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_strokeColor);
        if (this.o == null) {
            this.o = ColorStateList.valueOf(-1);
        }
        this.i = typedArray.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialCardView_strokeWidth, 0);
        this.u = typedArray.getBoolean(com.google.android.material.R.styleable.MaterialCardView_android_checkable, false);
        this.f13250c.setLongClickable(this.u);
        this.m = com.google.android.material.i.c.a(this.f13250c.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_checkedIconTint);
        a(com.google.android.material.i.c.b(this.f13250c.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_checkedIcon));
        this.l = com.google.android.material.i.c.a(this.f13250c.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_rippleColor);
        if (this.l == null) {
            this.l = ColorStateList.valueOf(com.google.android.material.d.a.a(this.f13250c, com.google.android.material.R.attr.colorControlHighlight));
        }
        ColorStateList colorStateListA = com.google.android.material.i.c.a(this.f13250c.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_cardForegroundColor);
        i iVar = this.f13253f;
        if (colorStateListA == null) {
            colorStateListA = ColorStateList.valueOf(0);
        }
        iVar.a(colorStateListA);
        G();
        r();
        t();
        this.f13250c.setBackgroundInternal(b(this.f13252e));
        this.j = this.f13250c.isClickable() ? C() : this.f13253f;
        this.f13250c.setForeground(b(this.j));
    }

    i b() {
        return this.f13252e;
    }

    ColorStateList c() {
        return this.f13252e.f();
    }

    void d(ColorStateList colorStateList) {
        if (this.o == colorStateList) {
            return;
        }
        this.o = colorStateList;
        t();
    }

    ColorStateList e() {
        return this.m;
    }

    float f() {
        return this.f13252e.n();
    }

    float g() {
        return this.f13252e.g();
    }

    ColorStateList h() {
        return this.l;
    }

    n i() {
        return this.n;
    }

    int j() {
        ColorStateList colorStateList = this.o;
        if (colorStateList == null) {
            return -1;
        }
        return colorStateList.getDefaultColor();
    }

    ColorStateList k() {
        return this.o;
    }

    int l() {
        return this.i;
    }

    Rect m() {
        return this.f13251d;
    }

    boolean n() {
        return this.t;
    }

    boolean o() {
        return this.u;
    }

    void p() {
        Drawable drawable = this.j;
        this.j = this.f13250c.isClickable() ? C() : this.f13253f;
        Drawable drawable2 = this.j;
        if (drawable != drawable2) {
            c(drawable2);
        }
    }

    void q() {
        int iU = (int) ((E() || F() ? u() : WheelView.DividerConfig.FILL) - D());
        MaterialCardView materialCardView = this.f13250c;
        Rect rect = this.f13251d;
        materialCardView.setAncestorContentPadding(rect.left + iU, rect.top + iU, rect.right + iU, rect.bottom + iU);
    }

    void r() {
        this.f13252e.b(this.f13250c.getCardElevation());
    }

    void s() {
        if (!n()) {
            this.f13250c.setBackgroundInternal(b(this.f13252e));
        }
        this.f13250c.setForeground(b(this.j));
    }

    void t() {
        this.f13253f.a(this.i, this.o);
    }

    void b(float f2) {
        this.f13252e.c(f2);
        i iVar = this.f13253f;
        if (iVar != null) {
            iVar.c(f2);
        }
        i iVar2 = this.s;
        if (iVar2 != null) {
            iVar2.c(f2);
        }
    }

    void c(ColorStateList colorStateList) {
        this.l = colorStateList;
        G();
    }

    private void c(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23 && (this.f13250c.getForeground() instanceof InsetDrawable)) {
            ((InsetDrawable) this.f13250c.getForeground()).setDrawable(drawable);
        } else {
            this.f13250c.setForeground(b(drawable));
        }
    }

    Drawable d() {
        return this.k;
    }

    void b(boolean z) {
        this.u = z;
    }

    void b(ColorStateList colorStateList) {
        this.m = colorStateList;
        Drawable drawable = this.k;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, colorStateList);
        }
    }

    private Drawable b(Drawable drawable) {
        int iCeil;
        int i;
        if ((Build.VERSION.SDK_INT < 21) || this.f13250c.getUseCompatPadding()) {
            int iCeil2 = (int) Math.ceil(w());
            iCeil = (int) Math.ceil(v());
            i = iCeil2;
        } else {
            iCeil = 0;
            i = 0;
        }
        return new a(this, drawable, iCeil, i, iCeil, i);
    }

    void a(boolean z) {
        this.t = z;
    }

    void a(int i) {
        if (i == this.i) {
            return;
        }
        this.i = i;
        t();
    }

    void a(ColorStateList colorStateList) {
        this.f13252e.a(colorStateList);
    }

    void a(int i, int i2, int i3, int i4) {
        this.f13251d.set(i, i2, i3, i4);
        q();
    }

    void a(float f2) {
        a(this.n.a(f2));
        this.j.invalidateSelf();
        if (F() || E()) {
            q();
        }
        if (F()) {
            s();
        }
    }

    void a(Drawable drawable) {
        this.k = drawable;
        if (drawable != null) {
            this.k = androidx.core.graphics.drawable.a.i(drawable.mutate());
            androidx.core.graphics.drawable.a.a(this.k, this.m);
        }
        if (this.q != null) {
            this.q.setDrawableByLayerId(com.google.android.material.R.id.mtrl_card_checked_layer_id, y());
        }
    }

    void a(int i, int i2) {
        int i3;
        int i4;
        if (this.q != null) {
            int i5 = this.g;
            int i6 = this.h;
            int i7 = (i - i5) - i6;
            int i8 = (i2 - i5) - i6;
            if (ViewCompat.m(this.f13250c) == 1) {
                i4 = i7;
                i3 = i5;
            } else {
                i3 = i7;
                i4 = i5;
            }
            this.q.setLayerInset(2, i3, this.g, i4, i8);
        }
    }

    void a() {
        Drawable drawable = this.p;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i = bounds.bottom;
            this.p.setBounds(bounds.left, bounds.top, bounds.right, i - 1);
            this.p.setBounds(bounds.left, bounds.top, bounds.right, i);
        }
    }

    void a(n nVar) {
        this.n = nVar;
        this.f13252e.setShapeAppearanceModel(nVar);
        i iVar = this.f13253f;
        if (iVar != null) {
            iVar.setShapeAppearanceModel(nVar);
        }
        i iVar2 = this.s;
        if (iVar2 != null) {
            iVar2.setShapeAppearanceModel(nVar);
        }
        i iVar3 = this.r;
        if (iVar3 != null) {
            iVar3.setShapeAppearanceModel(nVar);
        }
    }

    private float a(d dVar, float f2) {
        if (!(dVar instanceof l)) {
            return dVar instanceof e ? f2 / 2.0f : WheelView.DividerConfig.FILL;
        }
        double d2 = 1.0d - f13249b;
        double d3 = f2;
        Double.isNaN(d3);
        return (float) (d2 * d3);
    }
}
