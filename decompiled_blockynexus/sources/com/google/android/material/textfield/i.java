package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: CutoutDrawable.java */
/* JADX INFO: loaded from: classes2.dex */
class i extends com.google.android.material.l.i {
    private final Paint w;
    private final RectF x;
    private int y;

    i() {
        this(null);
    }

    private void D() {
        this.w.setStyle(Paint.Style.FILL_AND_STROKE);
        this.w.setColor(-1);
        this.w.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    private void e(Canvas canvas) {
        if (a(getCallback())) {
            return;
        }
        canvas.restoreToCount(this.y);
    }

    private void f(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (!a(callback)) {
            g(canvas);
            return;
        }
        View view = (View) callback;
        if (view.getLayerType() != 2) {
            view.setLayerType(2, null);
        }
    }

    private void g(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.y = canvas.saveLayer(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, canvas.getWidth(), canvas.getHeight(), null);
        } else {
            this.y = canvas.saveLayer(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, canvas.getWidth(), canvas.getHeight(), null, 31);
        }
    }

    void a(float f2, float f3, float f4, float f5) {
        RectF rectF = this.x;
        if (f2 == rectF.left && f3 == rectF.top && f4 == rectF.right && f5 == rectF.bottom) {
            return;
        }
        this.x.set(f2, f3, f4, f5);
        invalidateSelf();
    }

    @Override // com.google.android.material.l.i, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        f(canvas);
        super.draw(canvas);
        canvas.drawRect(this.x, this.w);
        e(canvas);
    }

    boolean t() {
        return !this.x.isEmpty();
    }

    void u() {
        a(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL);
    }

    i(com.google.android.material.l.n nVar) {
        super(nVar == null ? new com.google.android.material.l.n() : nVar);
        this.w = new Paint(1);
        D();
        this.x = new RectF();
    }

    void a(RectF rectF) {
        a(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    private boolean a(Drawable.Callback callback) {
        return callback instanceof View;
    }
}
