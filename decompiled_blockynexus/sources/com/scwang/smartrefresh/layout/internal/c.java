package com.scwang.smartrefresh.layout.internal;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;

/* JADX INFO: compiled from: ProgressDrawable.java */
/* JADX INFO: loaded from: classes4.dex */
public class c extends b implements ValueAnimator.AnimatorUpdateListener, Animatable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f19185b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f19186c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected int f19187d = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected Path f19189f = new Path();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected ValueAnimator f19188e = ValueAnimator.ofInt(30, 3600);

    public c() {
        this.f19188e.setDuration(10000L);
        this.f19188e.setInterpolator(null);
        this.f19188e.setRepeatCount(-1);
        this.f19188e.setRepeatMode(1);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        float f2 = iWidth;
        float fMax = Math.max(1.0f, f2 / 22.0f);
        if (this.f19185b != iWidth || this.f19186c != iHeight) {
            this.f19189f.reset();
            float f3 = f2 - fMax;
            float f4 = iHeight / 2.0f;
            this.f19189f.addCircle(f3, f4, fMax, Path.Direction.CW);
            float f5 = f2 - (5.0f * fMax);
            this.f19189f.addRect(f5, f4 - fMax, f3, f4 + fMax, Path.Direction.CW);
            this.f19189f.addCircle(f5, f4, fMax, Path.Direction.CW);
            this.f19185b = iWidth;
            this.f19186c = iHeight;
        }
        canvas.save();
        float f6 = f2 / 2.0f;
        float f7 = iHeight / 2.0f;
        canvas.rotate(this.f19187d, f6, f7);
        for (int i = 0; i < 12; i++) {
            this.f19184a.setAlpha((i + 5) * 17);
            canvas.rotate(30.0f, f6, f7);
            canvas.drawPath(this.f19189f, this.f19184a);
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f19188e.isRunning();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f19187d = (((Integer) valueAnimator.getAnimatedValue()).intValue() / 30) * 30;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.f19188e.isRunning()) {
            return;
        }
        this.f19188e.addUpdateListener(this);
        this.f19188e.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.f19188e.isRunning()) {
            this.f19188e.removeAllListeners();
            this.f19188e.removeAllUpdateListeners();
            this.f19188e.cancel();
        }
    }
}
