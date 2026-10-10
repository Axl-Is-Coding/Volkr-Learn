package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: renamed from: androidx.appcompat.widget.w, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AppCompatSeekBarHelper.java */
/* JADX INFO: loaded from: classes.dex */
class C0309w extends C0308v {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SeekBar f718d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Drawable f719e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ColorStateList f720f;
    private PorterDuff.Mode g;
    private boolean h;
    private boolean i;

    C0309w(SeekBar seekBar) {
        super(seekBar);
        this.f720f = null;
        this.g = null;
        this.h = false;
        this.i = false;
        this.f718d = seekBar;
    }

    private void d() {
        if (this.f719e != null) {
            if (this.h || this.i) {
                this.f719e = androidx.core.graphics.drawable.a.i(this.f719e.mutate());
                if (this.h) {
                    androidx.core.graphics.drawable.a.a(this.f719e, this.f720f);
                }
                if (this.i) {
                    androidx.core.graphics.drawable.a.a(this.f719e, this.g);
                }
                if (this.f719e.isStateful()) {
                    this.f719e.setState(this.f718d.getDrawableState());
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.C0308v
    void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        ia iaVarA = ia.a(this.f718d.getContext(), attributeSet, R.styleable.AppCompatSeekBar, i, 0);
        Drawable drawableC = iaVarA.c(R.styleable.AppCompatSeekBar_android_thumb);
        if (drawableC != null) {
            this.f718d.setThumb(drawableC);
        }
        a(iaVarA.b(R.styleable.AppCompatSeekBar_tickMark));
        if (iaVarA.g(R.styleable.AppCompatSeekBar_tickMarkTintMode)) {
            this.g = F.a(iaVarA.d(R.styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.g);
            this.i = true;
        }
        if (iaVarA.g(R.styleable.AppCompatSeekBar_tickMarkTint)) {
            this.f720f = iaVarA.a(R.styleable.AppCompatSeekBar_tickMarkTint);
            this.h = true;
        }
        iaVarA.a();
        d();
    }

    void b() {
        Drawable drawable = this.f719e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f718d.getDrawableState())) {
            this.f718d.invalidateDrawable(drawable);
        }
    }

    void c() {
        Drawable drawable = this.f719e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    void a(Drawable drawable) {
        Drawable drawable2 = this.f719e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f719e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f718d);
            androidx.core.graphics.drawable.a.a(drawable, ViewCompat.m(this.f718d));
            if (drawable.isStateful()) {
                drawable.setState(this.f718d.getDrawableState());
            }
            d();
        }
        this.f718d.invalidate();
    }

    void a(Canvas canvas) {
        if (this.f719e != null) {
            int max = this.f718d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f719e.getIntrinsicWidth();
                int intrinsicHeight = this.f719e.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f719e.setBounds(-i, -i2, i, i2);
                float width = ((this.f718d.getWidth() - this.f718d.getPaddingLeft()) - this.f718d.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(this.f718d.getPaddingLeft(), this.f718d.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.f719e.draw(canvas);
                    canvas.translate(width, WheelView.DividerConfig.FILL);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }
}
