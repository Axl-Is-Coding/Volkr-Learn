package com.google.android.material.j;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.google.android.material.l.i;
import com.google.android.material.l.n;
import com.google.android.material.l.r;

/* JADX INFO: compiled from: RippleDrawableCompat.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends Drawable implements androidx.core.graphics.drawable.b, r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f13493a;

    /* JADX INFO: compiled from: RippleDrawableCompat.java */
    static final class a extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        i f13494a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f13495b;

        public a(i iVar) {
            this.f13494a = iVar;
            this.f13495b = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public b newDrawable() {
            return new b(new a(this));
        }

        public a(a aVar) {
            this.f13494a = (i) aVar.f13494a.getConstantState().newDrawable();
            this.f13495b = aVar.f13495b;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        a aVar = this.f13493a;
        if (aVar.f13495b) {
            aVar.f13494a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f13493a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f13493a.f13494a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable mutate() {
        mutate();
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f13493a.f13494a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        if (this.f13493a.f13494a.setState(iArr)) {
            zOnStateChange = true;
        }
        boolean zA = c.a(iArr);
        a aVar = this.f13493a;
        if (aVar.f13495b == zA) {
            return zOnStateChange;
        }
        aVar.f13495b = zA;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f13493a.f13494a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f13493a.f13494a.setColorFilter(colorFilter);
    }

    @Override // com.google.android.material.l.r
    public void setShapeAppearanceModel(n nVar) {
        this.f13493a.f13494a.setShapeAppearanceModel(nVar);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTint(int i) {
        this.f13493a.f13494a.setTint(i);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintList(ColorStateList colorStateList) {
        this.f13493a.f13494a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.b
    public void setTintMode(PorterDuff.Mode mode) {
        this.f13493a.f13494a.setTintMode(mode);
    }

    public b(n nVar) {
        this(new a(new i(nVar)));
    }

    @Override // android.graphics.drawable.Drawable
    public b mutate() {
        this.f13493a = new a(this.f13493a);
        return this;
    }

    private b(a aVar) {
        this.f13493a = aVar;
    }
}
