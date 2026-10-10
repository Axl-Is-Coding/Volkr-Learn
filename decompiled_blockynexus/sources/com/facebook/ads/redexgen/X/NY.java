package com.facebook.ads.redexgen.X;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.annotation.Keep;
import cn.qqtheme.framework.widget.WheelView;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class NY extends View {
    public static byte[] A05;
    public float A00;
    public final float A01;
    public final Paint A02;
    public final Paint A03;
    public final RectF A04;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 80);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{0, 2, 31, 23, 2, 21, 3, 3};
    }

    public NY(C2026Wb c2026Wb) {
        super(c2026Wb);
        this.A01 = Resources.getSystem().getDisplayMetrics().density * 3.0f;
        this.A00 = WheelView.DividerConfig.FILL;
        this.A04 = new RectF();
        this.A02 = new Paint(1);
        this.A02.setStyle(Paint.Style.STROKE);
        this.A02.setStrokeWidth(this.A01);
        this.A03 = new Paint(1);
        this.A03.setStyle(Paint.Style.STROKE);
        this.A03.setStrokeWidth(this.A01);
    }

    public final void A02(int i, int i2) {
        this.A02.setColor(i);
        this.A03.setColor(i2);
    }

    @Keep
    public float getProgress() {
        return this.A00;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.A04, WheelView.DividerConfig.FILL, 360.0f, false, this.A02);
        canvas.drawArc(this.A04, -90.0f, ((100.0f - this.A00) * 360.0f) / 100.0f, false, this.A03);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int iMin = Math.min(getDefaultSize(getSuggestedMinimumHeight(), i2), getDefaultSize(getSuggestedMinimumWidth(), i));
        setMeasuredDimension(iMin, iMin);
        this.A04.set((this.A01 / 2.0f) + WheelView.DividerConfig.FILL + getPaddingLeft(), (this.A01 / 2.0f) + WheelView.DividerConfig.FILL + getPaddingTop(), (iMin - (this.A01 / 2.0f)) - getPaddingRight(), (iMin - (this.A01 / 2.0f)) - getPaddingBottom());
    }

    @Keep
    public void setProgress(float f2) {
        this.A00 = Math.min(f2, 100.0f);
        postInvalidate();
    }

    public void setProgressWithAnimation(float f2) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, A00(0, 8, 32), f2);
        objectAnimatorOfFloat.setDuration(400L);
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        objectAnimatorOfFloat.start();
    }
}
