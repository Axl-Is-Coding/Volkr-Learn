package com.bumptech.glide.request.target;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import cn.qqtheme.framework.widget.WheelView;
import com.bumptech.glide.e.l;

/* JADX INFO: loaded from: classes.dex */
public class FixedSizeDrawable extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Matrix f4816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RectF f4817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RectF f4818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Drawable f4819d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f4820e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f4821f;

    static final class a extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Drawable.ConstantState f4822a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f4823b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f4824c;

        a(a aVar) {
            this(aVar.f4822a, aVar.f4823b, aVar.f4824c);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new FixedSizeDrawable(this, this.f4822a.newDrawable());
        }

        a(Drawable.ConstantState constantState, int i, int i2) {
            this.f4822a = constantState;
            this.f4823b = i;
            this.f4824c = i2;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new FixedSizeDrawable(this, this.f4822a.newDrawable(resources));
        }
    }

    FixedSizeDrawable(a aVar, Drawable drawable) {
        l.a(aVar);
        this.f4820e = aVar;
        l.a(drawable);
        this.f4819d = drawable;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.f4816a = new Matrix();
        this.f4817b = new RectF(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.f4818c = new RectF();
    }

    private void a() {
        this.f4816a.setRectToRect(this.f4817b, this.f4818c, Matrix.ScaleToFit.CENTER);
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        this.f4819d.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.save();
        canvas.concat(this.f4816a);
        this.f4819d.draw(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f4819d.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.Callback getCallback() {
        return this.f4819d.getCallback();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.f4819d.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f4820e;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f4819d.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f4820e.f4824c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f4820e.f4823b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f4819d.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f4819d.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f4819d.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f4819d.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        this.f4819d.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f4821f && super.mutate() == this) {
            this.f4819d = this.f4819d.mutate();
            this.f4820e = new a(this.f4820e);
            this.f4821f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        super.scheduleSelf(runnable, j);
        this.f4819d.scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f4819d.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.f4818c.set(i, i2, i3, i4);
        a();
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.f4819d.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, PorterDuff.Mode mode) {
        this.f4819d.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated
    public void setDither(boolean z) {
        this.f4819d.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f4819d.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return this.f4819d.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.f4819d.unscheduleSelf(runnable);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f4819d.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        super.setBounds(rect);
        this.f4818c.set(rect);
        a();
    }
}
