package com.facebook.ads.redexgen.X;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.widget.Button;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class P9 extends Button {
    public static byte[] A07;
    public String A00;
    public String A01;
    public boolean A02;
    public final Paint A03;
    public final Path A04;
    public final Path A05;
    public final Path A06;

    static {
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 4);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A07 = new byte[]{89, 104, 124, 122, 108, 118, 74, 71, 95};
    }

    public P9(C2026Wb c2026Wb) {
        this(c2026Wb, false);
    }

    public P9(C2026Wb c2026Wb, boolean z) {
        super(c2026Wb);
        this.A02 = false;
        this.A01 = A00(5, 4, 34);
        this.A00 = A00(0, 5, 13);
        this.A04 = new Path();
        this.A05 = new Path();
        this.A06 = new Path();
        this.A03 = new P8(this, z);
        A01();
        setClickable(true);
        LX.A0P(this, 0);
    }

    private void A01() {
        setContentDescription(this.A02 ? this.A01 : this.A00);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (canvas.isHardwareAccelerated() && Build.VERSION.SDK_INT < 17) {
            setLayerType(1, null);
        }
        float fMax = Math.max(canvas.getWidth(), canvas.getHeight()) / 100.0f;
        if (this.A02) {
            this.A06.rewind();
            this.A06.moveTo(fMax * 26.5f, fMax * 15.5f);
            this.A06.lineTo(fMax * 26.5f, 84.5f * fMax);
            this.A06.lineTo(90.0f * fMax, 50.0f * fMax);
            this.A06.lineTo(26.5f * fMax, 15.5f * fMax);
            this.A06.close();
            canvas.drawPath(this.A06, this.A03);
        } else {
            this.A04.rewind();
            this.A04.moveTo(fMax * 29.0f, fMax * 21.0f);
            this.A04.lineTo(fMax * 29.0f, fMax * 79.0f);
            this.A04.lineTo(fMax * 45.0f, fMax * 79.0f);
            this.A04.lineTo(45.0f * fMax, fMax * 21.0f);
            this.A04.lineTo(29.0f * fMax, fMax * 21.0f);
            this.A04.close();
            this.A05.rewind();
            this.A05.moveTo(fMax * 55.0f, fMax * 21.0f);
            this.A05.lineTo(fMax * 55.0f, fMax * 79.0f);
            this.A05.lineTo(fMax * 71.0f, 79.0f * fMax);
            this.A05.lineTo(71.0f * fMax, fMax * 21.0f);
            this.A05.lineTo(55.0f * fMax, 21.0f * fMax);
            this.A05.close();
            canvas.drawPath(this.A04, this.A03);
            canvas.drawPath(this.A05, this.A03);
        }
        super.onDraw(canvas);
    }

    public void setChecked(boolean z) {
        this.A02 = z;
        A01();
        refreshDrawableState();
        invalidate();
    }

    public void setPauseAccessibilityLabel(@Nullable String str) {
        if (str != null) {
            this.A00 = str;
            A01();
        }
    }

    public void setPlayAccessibilityLabel(@Nullable String str) {
        if (str != null) {
            this.A01 = str;
            A01();
        }
    }
}
