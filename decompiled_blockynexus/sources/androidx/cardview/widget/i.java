package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: RoundRectDrawable.java */
/* JADX INFO: loaded from: classes.dex */
class i extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f789a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RectF f791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f792d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f793e;
    private ColorStateList h;
    private PorterDuffColorFilter i;
    private ColorStateList j;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f794f = false;
    private boolean g = true;
    private PorterDuff.Mode k = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f790b = new Paint(5);

    i(ColorStateList colorStateList, float f2) {
        this.f789a = f2;
        b(colorStateList);
        this.f791c = new RectF();
        this.f792d = new Rect();
    }

    private void b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.h = colorStateList;
        this.f790b.setColor(this.h.getColorForState(getState(), this.h.getDefaultColor()));
    }

    void a(float f2, boolean z, boolean z2) {
        if (f2 == this.f793e && this.f794f == z && this.g == z2) {
            return;
        }
        this.f793e = f2;
        this.f794f = z;
        this.g = z2;
        a((Rect) null);
        invalidateSelf();
    }

    public float c() {
        return this.f789a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.f790b;
        if (this.i == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.i);
            z = true;
        }
        RectF rectF = this.f791c;
        float f2 = this.f789a;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        if (z) {
            paint.setColorFilter(null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f792d, this.f789a);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        a(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z = colorForState != this.f790b.getColor();
        if (z) {
            this.f790b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.j;
        if (colorStateList2 == null || (mode = this.k) == null) {
            return z;
        }
        this.i = a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f790b.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f790b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.j = colorStateList;
        this.i = a(this.j, this.k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.k = mode;
        this.i = a(this.j, this.k);
        invalidateSelf();
    }

    float b() {
        return this.f793e;
    }

    private void a(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f791c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f792d.set(rect);
        if (this.f794f) {
            this.f792d.inset((int) Math.ceil(j.a(this.f793e, this.f789a, this.g)), (int) Math.ceil(j.b(this.f793e, this.f789a, this.g)));
            this.f791c.set(this.f792d);
        }
    }

    void a(float f2) {
        if (f2 == this.f789a) {
            return;
        }
        this.f789a = f2;
        a((Rect) null);
        invalidateSelf();
    }

    public void a(ColorStateList colorStateList) {
        b(colorStateList);
        invalidateSelf();
    }

    public ColorStateList a() {
        return this.h;
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }
}
