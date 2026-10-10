package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.cardview.R;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: RoundRectDrawableWithShadow.java */
/* JADX INFO: loaded from: classes.dex */
class j extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final double f795a = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static a f796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f797c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Paint f799e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Paint f800f;
    private final RectF g;
    private float h;
    private Path i;
    private float j;
    private float k;
    private float l;
    private ColorStateList m;
    private final int o;
    private final int p;
    private boolean n = true;
    private boolean q = true;
    private boolean r = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Paint f798d = new Paint(5);

    /* JADX INFO: compiled from: RoundRectDrawableWithShadow.java */
    interface a {
        void a(Canvas canvas, RectF rectF, float f2, Paint paint);
    }

    j(Resources resources, ColorStateList colorStateList, float f2, float f3, float f4) {
        this.o = resources.getColor(R.color.cardview_shadow_start_color);
        this.p = resources.getColor(R.color.cardview_shadow_end_color);
        this.f797c = resources.getDimensionPixelSize(R.dimen.cardview_compat_inset_shadow);
        b(colorStateList);
        this.f799e = new Paint(5);
        this.f799e.setStyle(Paint.Style.FILL);
        this.h = (int) (f2 + 0.5f);
        this.g = new RectF();
        this.f800f = new Paint(this.f799e);
        this.f800f.setAntiAlias(false);
        a(f3, f4);
    }

    private void b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.m = colorStateList;
        this.f798d.setColor(this.m.getColorForState(getState(), this.m.getDefaultColor()));
    }

    private int d(float f2) {
        int i = (int) (f2 + 0.5f);
        return i % 2 == 1 ? i - 1 : i;
    }

    private void g() {
        float f2 = this.h;
        RectF rectF = new RectF(-f2, -f2, f2, f2);
        RectF rectF2 = new RectF(rectF);
        float f3 = this.k;
        rectF2.inset(-f3, -f3);
        Path path = this.i;
        if (path == null) {
            this.i = new Path();
        } else {
            path.reset();
        }
        this.i.setFillType(Path.FillType.EVEN_ODD);
        this.i.moveTo(-this.h, WheelView.DividerConfig.FILL);
        this.i.rLineTo(-this.k, WheelView.DividerConfig.FILL);
        this.i.arcTo(rectF2, 180.0f, 90.0f, false);
        this.i.arcTo(rectF, 270.0f, -90.0f, false);
        this.i.close();
        float f4 = this.h;
        float f5 = this.k;
        float f6 = f4 / (f4 + f5);
        Paint paint = this.f799e;
        float f7 = f4 + f5;
        int i = this.o;
        paint.setShader(new RadialGradient(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, f7, new int[]{i, i, this.p}, new float[]{WheelView.DividerConfig.FILL, f6, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.f800f;
        float f8 = this.h;
        float f9 = this.k;
        int i2 = this.o;
        paint2.setShader(new LinearGradient(WheelView.DividerConfig.FILL, (-f8) + f9, WheelView.DividerConfig.FILL, (-f8) - f9, new int[]{i2, i2, this.p}, new float[]{WheelView.DividerConfig.FILL, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f800f.setAntiAlias(false);
    }

    void a(boolean z) {
        this.q = z;
        invalidateSelf();
    }

    void c(float f2) {
        a(f2, this.j);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.n) {
            b(getBounds());
            this.n = false;
        }
        canvas.translate(WheelView.DividerConfig.FILL, this.l / 2.0f);
        a(canvas);
        canvas.translate(WheelView.DividerConfig.FILL, (-this.l) / 2.0f);
        f796b.a(canvas, this.g, this.h, this.f798d);
    }

    float e() {
        float f2 = this.j;
        return (Math.max(f2, this.h + this.f797c + (f2 / 2.0f)) * 2.0f) + ((this.j + this.f797c) * 2.0f);
    }

    float f() {
        return this.l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int iCeil = (int) Math.ceil(b(this.j, this.h, this.q));
        int iCeil2 = (int) Math.ceil(a(this.j, this.h, this.q));
        rect.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.m;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.n = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.m;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f798d.getColor() == colorForState) {
            return false;
        }
        this.f798d.setColor(colorForState);
        this.n = true;
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f798d.setAlpha(i);
        this.f799e.setAlpha(i);
        this.f800f.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f798d.setColorFilter(colorFilter);
    }

    float c() {
        return this.j;
    }

    float d() {
        float f2 = this.j;
        return (Math.max(f2, this.h + this.f797c + ((f2 * 1.5f) / 2.0f)) * 2.0f) + (((this.j * 1.5f) + this.f797c) * 2.0f);
    }

    private void a(float f2, float f3) {
        if (f2 < WheelView.DividerConfig.FILL) {
            throw new IllegalArgumentException("Invalid shadow size " + f2 + ". Must be >= 0");
        }
        if (f3 >= WheelView.DividerConfig.FILL) {
            float fD = d(f2);
            float fD2 = d(f3);
            if (fD > fD2) {
                if (!this.r) {
                    this.r = true;
                }
                fD = fD2;
            }
            if (this.l == fD && this.j == fD2) {
                return;
            }
            this.l = fD;
            this.j = fD2;
            this.k = (int) ((fD * 1.5f) + this.f797c + 0.5f);
            this.n = true;
            invalidateSelf();
            return;
        }
        throw new IllegalArgumentException("Invalid max shadow size " + f3 + ". Must be >= 0");
    }

    static float b(float f2, float f3, boolean z) {
        if (!z) {
            return f2 * 1.5f;
        }
        double d2 = f2 * 1.5f;
        double d3 = 1.0d - f795a;
        double d4 = f3;
        Double.isNaN(d4);
        Double.isNaN(d2);
        return (float) (d2 + (d3 * d4));
    }

    private void b(Rect rect) {
        float f2 = this.j;
        float f3 = 1.5f * f2;
        this.g.set(rect.left + f2, rect.top + f3, rect.right - f2, rect.bottom - f3);
        g();
    }

    float b() {
        return this.h;
    }

    void b(float f2) {
        a(this.l, f2);
    }

    static float a(float f2, float f3, boolean z) {
        if (!z) {
            return f2;
        }
        double d2 = f2;
        double d3 = 1.0d - f795a;
        double d4 = f3;
        Double.isNaN(d4);
        Double.isNaN(d2);
        return (float) (d2 + (d3 * d4));
    }

    void a(float f2) {
        if (f2 < WheelView.DividerConfig.FILL) {
            throw new IllegalArgumentException("Invalid radius " + f2 + ". Must be >= 0");
        }
        float f3 = (int) (f2 + 0.5f);
        if (this.h == f3) {
            return;
        }
        this.h = f3;
        this.n = true;
        invalidateSelf();
    }

    private void a(Canvas canvas) {
        float f2 = this.h;
        float f3 = (-f2) - this.k;
        float f4 = f2 + this.f797c + (this.l / 2.0f);
        float f5 = f4 * 2.0f;
        boolean z = this.g.width() - f5 > WheelView.DividerConfig.FILL;
        boolean z2 = this.g.height() - f5 > WheelView.DividerConfig.FILL;
        int iSave = canvas.save();
        RectF rectF = this.g;
        canvas.translate(rectF.left + f4, rectF.top + f4);
        canvas.drawPath(this.i, this.f799e);
        if (z) {
            canvas.drawRect(WheelView.DividerConfig.FILL, f3, this.g.width() - f5, -this.h, this.f800f);
        }
        canvas.restoreToCount(iSave);
        int iSave2 = canvas.save();
        RectF rectF2 = this.g;
        canvas.translate(rectF2.right - f4, rectF2.bottom - f4);
        canvas.rotate(180.0f);
        canvas.drawPath(this.i, this.f799e);
        if (z) {
            canvas.drawRect(WheelView.DividerConfig.FILL, f3, this.g.width() - f5, (-this.h) + this.k, this.f800f);
        }
        canvas.restoreToCount(iSave2);
        int iSave3 = canvas.save();
        RectF rectF3 = this.g;
        canvas.translate(rectF3.left + f4, rectF3.bottom - f4);
        canvas.rotate(270.0f);
        canvas.drawPath(this.i, this.f799e);
        if (z2) {
            canvas.drawRect(WheelView.DividerConfig.FILL, f3, this.g.height() - f5, -this.h, this.f800f);
        }
        canvas.restoreToCount(iSave3);
        int iSave4 = canvas.save();
        RectF rectF4 = this.g;
        canvas.translate(rectF4.right - f4, rectF4.top + f4);
        canvas.rotate(90.0f);
        canvas.drawPath(this.i, this.f799e);
        if (z2) {
            canvas.drawRect(WheelView.DividerConfig.FILL, f3, this.g.height() - f5, -this.h, this.f800f);
        }
        canvas.restoreToCount(iSave4);
    }

    void a(Rect rect) {
        getPadding(rect);
    }

    void a(ColorStateList colorStateList) {
        b(colorStateList);
        invalidateSelf();
    }

    ColorStateList a() {
        return this.m;
    }
}
