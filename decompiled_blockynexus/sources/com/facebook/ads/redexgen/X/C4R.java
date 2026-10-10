package com.facebook.ads.redexgen.X;

import android.graphics.PointF;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import com.sandboxol.center.config.VipSubscribeStatus;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4R, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C4R {
    public static byte[] A07;
    public static String[] A08;
    public View A01;
    public C4E A02;
    public EI A03;
    public boolean A04;
    public boolean A05;
    public int A00 = -1;
    public final C4P A06 = new C4P(0, 0);

    static {
        A04();
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 28);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        byte[] bArr = {78, 105, 113, 102, 107, 110, 99, 39, 115, 102, 117, 96, 98, 115, 39, 119, 104, 116, 110, 115, 110, 104, 105, 22, 39, 53, 53, 35, 34, 102, 41, 48, 35, 52, 102, 50, 39, 52, 33, 35, 50, 102, 54, 41, 53, 47, 50, 47, 41, 40, 102, 49, 46, 47, 42, 35, 102, 53, 43, 41, 41, 50, 46, 102, 53, 37, 52, 41, 42, 42, 47, 40, 33, 104, 78, 121, 127, 101, 127, 112, 121, 110, 74, 117, 121, 107};
        String[] strArr = A08;
        if (strArr[4].length() != strArr[1].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A08;
        strArr2[7] = "8BqCBekg5p6xdwXQXpIxknueaPhzjw";
        strArr2[7] = "8BqCBekg5p6xdwXQXpIxknueaPhzjw";
        A07 = bArr;
    }

    public static void A04() {
        A08 = new String[]{"ffTcX10Z9", "veDPHJ", "R", "iWatF5LLo", "0slLts", "p92m", VipSubscribeStatus.SUBSCRIPTION_DEFERRED, "eFvKPH9TFpfstHyCObyNN72zUjBGeH"};
    }

    public abstract void A0H();

    public abstract void A0I(int i, int i2, C4T c4t, C4P c4p);

    public abstract void A0J(View view, C4T c4t, C4P c4p);

    private final int A00(View view) {
        return this.A03.A1D(view);
    }

    private final View A01(int i) {
        return this.A03.A06.A1r(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05(int i, int i2) {
        EI ei = this.A03;
        if (!this.A05 || this.A00 == -1 || ei == null) {
            A0A();
        }
        this.A04 = false;
        View view = this.A01;
        if (view != null) {
            int iA00 = A00(view);
            int i3 = this.A00;
            String[] strArr = A08;
            if (strArr[4].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[3] = "1zDtC4ICw";
            strArr2[0] = "WYaFIbeKL";
            if (iA00 == i3) {
                A0J(this.A01, ei.A0s, this.A06);
                C4P c4p = this.A06;
                if (A08[5].length() != 9) {
                    String[] strArr3 = A08;
                    strArr3[6] = "M";
                    strArr3[2] = "Q";
                    c4p.A06(ei);
                    A0A();
                } else {
                    String[] strArr4 = A08;
                    strArr4[5] = "sldJFA0K947j";
                    strArr4[5] = "sldJFA0K947j";
                    c4p.A06(ei);
                    A0A();
                }
            } else {
                Log.e(A02(74, 12, 0), A02(23, 51, 90));
                this.A01 = null;
            }
        }
        if (this.A05) {
            A0I(i, i2, ei.A0s, this.A06);
            boolean zA07 = this.A06.A07();
            this.A06.A06(ei);
            if (zA07) {
                if (this.A05) {
                    this.A04 = true;
                    ei.A08.A08();
                } else {
                    A0A();
                }
            }
        }
    }

    public final int A07() {
        return this.A03.A06.A0X();
    }

    public final int A08() {
        return this.A00;
    }

    @Nullable
    public final C4E A09() {
        return this.A02;
    }

    public final void A0A() {
        if (!this.A05) {
            return;
        }
        A0H();
        this.A03.A0s.A0F = -1;
        this.A01 = null;
        this.A00 = -1;
        this.A04 = false;
        this.A05 = false;
        this.A02.A0N(this);
        this.A02 = null;
        this.A03 = null;
    }

    public final void A0B(int i) {
        this.A00 = i;
    }

    public final void A0C(PointF pointF) {
        float fSqrt = (float) Math.sqrt((pointF.x * pointF.x) + (pointF.y * pointF.y));
        pointF.x /= fSqrt;
        pointF.y /= fSqrt;
    }

    public final void A0D(View view) {
        if (A00(view) == A08()) {
            this.A01 = view;
        }
    }

    public final void A0E(EI ei, C4E c4e) {
        this.A03 = ei;
        this.A02 = c4e;
        if (this.A00 != -1) {
            this.A03.A0s.A0F = this.A00;
            this.A05 = true;
            this.A04 = true;
            this.A01 = A01(A08());
            this.A03.A08.A08();
            return;
        }
        throw new IllegalArgumentException(A02(0, 23, 27));
    }

    public final boolean A0F() {
        return this.A04;
    }

    public final boolean A0G() {
        return this.A05;
    }
}
