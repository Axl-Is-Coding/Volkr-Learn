package com.facebook.ads.redexgen.X;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.view.View;
import android.widget.RelativeLayout;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class M2 extends View {
    public int A00;
    public Paint A01;
    public Paint A02;
    public Paint A03;
    public boolean A04;

    public M2(C2026Wb c2026Wb) {
        this(c2026Wb, 60, true);
    }

    public M2(C2026Wb c2026Wb, int i, boolean z) {
        super(c2026Wb);
        this.A00 = i;
        this.A04 = z;
        if (z) {
            this.A02 = new Paint();
            this.A02.setColor(-3355444);
            this.A02.setStyle(Paint.Style.STROKE);
            this.A02.setStrokeWidth(3.0f);
            this.A02.setAntiAlias(true);
            this.A01 = new Paint();
            this.A01.setColor(-1287371708);
            this.A01.setStyle(Paint.Style.FILL);
            this.A01.setAntiAlias(true);
            this.A03 = new Paint();
            this.A03.setColor(-1);
            this.A03.setStyle(Paint.Style.STROKE);
            this.A03.setStrokeWidth(6.0f);
            this.A03.setAntiAlias(true);
        }
    }

    public RelativeLayout.LayoutParams getDefaultLayoutParams() {
        float f2 = LX.A01;
        int i = this.A00;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (i * f2), (int) (i * f2));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        return layoutParams;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.A04) {
            if (canvas.isHardwareAccelerated() && Build.VERSION.SDK_INT < 17) {
                setLayerType(1, null);
            }
            int iMin = Math.min(canvas.getWidth(), canvas.getHeight());
            int i = iMin / 2;
            int i2 = iMin / 2;
            int centerY = i * 2;
            int i3 = centerY / 3;
            canvas.drawCircle(i, i2, i3, this.A02);
            int outerRadius = i3 - 2;
            canvas.drawCircle(i, i2, outerRadius, this.A01);
            int i4 = iMin / 3;
            int innerRadius = iMin / 3;
            int startX = i4 * 2;
            float f2 = startX;
            int startX2 = innerRadius * 2;
            canvas.drawLine(i4, innerRadius, f2, startX2, this.A03);
            int startX3 = i4 * 2;
            int startX4 = innerRadius * 2;
            canvas.drawLine(startX3, innerRadius, i4, startX4, this.A03);
        }
        super.onDraw(canvas);
    }
}
