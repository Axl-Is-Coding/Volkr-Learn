package com.google.android.material.floatingactionbutton;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: BorderDrawable.java */
/* JADX INFO: loaded from: classes2.dex */
class d extends Drawable {
    float h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private com.google.android.material.l.n o;
    private ColorStateList p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.material.l.o f13393a = new com.google.android.material.l.o();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Path f13395c = new Path();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f13396d = new Rect();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RectF f13397e = new RectF();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RectF f13398f = new RectF();
    private final a g = new a();
    private boolean n = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f13394b = new Paint(1);

    /* JADX INFO: compiled from: BorderDrawable.java */
    private class a extends Drawable.ConstantState {
        private a() {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return d.this;
        }
    }

    d(com.google.android.material.l.n nVar) {
        this.o = nVar;
        this.f13394b.setStyle(Paint.Style.STROKE);
    }

    private Shader b() {
        copyBounds(this.f13396d);
        float fHeight = this.h / r0.height();
        return new LinearGradient(WheelView.DividerConfig.FILL, r0.top, WheelView.DividerConfig.FILL, r0.bottom, new int[]{androidx.core.a.a.a(this.i, this.m), androidx.core.a.a.a(this.j, this.m), androidx.core.a.a.a(androidx.core.a.a.b(this.j, 0), this.m), androidx.core.a.a.a(androidx.core.a.a.b(this.l, 0), this.m), androidx.core.a.a.a(this.l, this.m), androidx.core.a.a.a(this.k, this.m)}, new float[]{WheelView.DividerConfig.FILL, fHeight, 0.5f, 0.5f, 1.0f - fHeight, 1.0f}, Shader.TileMode.CLAMP);
    }

    public void a(float f2) {
        if (this.h != f2) {
            this.h = f2;
            this.f13394b.setStrokeWidth(f2 * 1.3333f);
            this.n = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.n) {
            this.f13394b.setShader(b());
            this.n = false;
        }
        float strokeWidth = this.f13394b.getStrokeWidth() / 2.0f;
        copyBounds(this.f13396d);
        this.f13397e.set(this.f13396d);
        float fMin = Math.min(this.o.k().a(a()), this.f13397e.width() / 2.0f);
        if (this.o.a(a())) {
            this.f13397e.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.f13397e, fMin, fMin, this.f13394b);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.h > WheelView.DividerConfig.FILL ? -3 : -2;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        if (this.o.a(a())) {
            outline.setRoundRect(getBounds(), this.o.k().a(a()));
            return;
        }
        copyBounds(this.f13396d);
        this.f13397e.set(this.f13396d);
        this.f13393a.a(this.o, 1.0f, this.f13397e, this.f13395c);
        if (this.f13395c.isConvex()) {
            outline.setConvexPath(this.f13395c);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        if (!this.o.a(a())) {
            return true;
        }
        int iRound = Math.round(this.h);
        rect.set(iRound, iRound, iRound, iRound);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.p;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.n = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.p;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.m)) != this.m) {
            this.n = true;
            this.m = colorForState;
        }
        if (this.n) {
            invalidateSelf();
        }
        return this.n;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f13394b.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f13394b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    void a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.m = colorStateList.getColorForState(getState(), this.m);
        }
        this.p = colorStateList;
        this.n = true;
        invalidateSelf();
    }

    void a(int i, int i2, int i3, int i4) {
        this.i = i;
        this.j = i2;
        this.k = i3;
        this.l = i4;
    }

    protected RectF a() {
        this.f13398f.set(getBounds());
        return this.f13398f;
    }

    public void a(com.google.android.material.l.n nVar) {
        this.o = nVar;
        invalidateSelf();
    }
}
