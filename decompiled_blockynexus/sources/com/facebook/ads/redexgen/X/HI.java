package com.facebook.ads.redexgen.X;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import cn.qqtheme.framework.widget.WheelView;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class HI extends ImageView implements InterfaceC1835Oq {
    public static byte[] A05;
    public static String[] A06;
    public static final int A07;

    @Nullable
    public LU A00;
    public final Paint A01;
    public final C2026Wb A02;
    public final JC A03;
    public final AbstractC1661Hq A04;

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 19);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A05 = new byte[]{101, 93, 92, 77, 8, 105, 76};
    }

    public static void A07() {
        A06 = new String[]{"CZ6R6baQKTb1E5sAmpDqVkfMXF7zVnG4", "nQZGX73N3q5NRRZlZyP90gUTrDeeLYBu", "LfCM6PYFJNbwOvLH4thVDQon3h1Zk2zk", "bpUakkTElIOqaP65ISNG9oh", "gJtMODfbj2e7z8MJG7ZRKfD", "8rYwk9o7IGDDsMQbyUTj4ra1LUt9E6qX", "3WiLQHXTUUJ8WctEatoRQ", "Xo7nIXQ5hsw2R0tzDjIU8fyfjH4jtFIR"};
    }

    static {
        A07();
        A06();
        A07 = (int) (LX.A01 * 4.0f);
    }

    public HI(C2026Wb c2026Wb, JC jc) {
        super(c2026Wb);
        this.A04 = new AbstractC1661Hq() { // from class: com.facebook.ads.redexgen.X.7R
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(I0 i0) {
                this.A00.A0A();
            }
        };
        this.A03 = jc;
        this.A02 = c2026Wb;
        this.A01 = new Paint();
        this.A01.setColor(-1728053248);
        setColorFilter(-1);
        int i = A07;
        setPadding(i, i, i, i);
        setContentDescription(A03(0, 7, 59));
        A05();
        setOnClickListener(new P3(this));
    }

    private void A04() {
        setImageBitmap(C1748Lg.A01(EnumC1747Lf.SOUND_OFF));
    }

    private void A05() {
        setImageBitmap(C1748Lg.A01(EnumC1747Lf.SOUND_ON));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A08() {
        LU lu = this.A00;
        if (lu != null) {
            float volume = lu.getVolume();
            String[] strArr = A06;
            if (strArr[5].charAt(12) == strArr[1].charAt(12)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[3] = "7LwdJMyLjSlNEKSwxkcw7Q3";
            strArr2[6] = "d5nTRpYYugpReKnwSxkEX";
            if (volume == WheelView.DividerConfig.FILL) {
                return true;
            }
        }
        return false;
    }

    public final void A0A() {
        if (this.A00 == null) {
            return;
        }
        if (A08()) {
            A04();
        } else {
            A05();
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1835Oq
    public final void A86(LU lu) {
        this.A00 = lu;
        LU lu2 = this.A00;
        if (lu2 != null) {
            lu2.getEventBus().A06(this.A04);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1835Oq
    public final void ADt(LU lu) {
        LU lu2 = this.A00;
        if (lu2 != null) {
            lu2.getEventBus().A07(this.A04);
        }
        this.A00 = null;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, Math.min(r1, r0), this.A01);
        super.onDraw(canvas);
    }
}
