package com.facebook.ads.redexgen.X;

import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.Nullable;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.Map;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class NX {
    public static byte[] A09;

    @Nullable
    public NW A00;
    public boolean A01 = true;
    public boolean A02;
    public final C2026Wb A03;
    public final J5 A04;
    public final LQ A05;
    public final InterfaceC1767Lz A06;
    public final C1849Pe A07;
    public final String A08;

    static {
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 104);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A09 = new byte[]{31, 8, 29, 30, 41, 40, 40, 51, 50, 31, 48, 53, Utf8.REPLACEMENT_BYTE, 55, ci.n, 53, 47, 40, 57, 50, 57, 46, 114, 69, 69, 88, 69, 23, 82, 79, 82, 84, 66, 67, 94, 89, 80, 23, 86, 84, 67, 94, 88, 89, 73, 126, 126, 99, 126, 44, 123, 100, 101, 96, 105, 44, 99, 124, 105, 98, 101, 98, 107, 44};
    }

    public NX(C2026Wb c2026Wb, String str, C1849Pe c1849Pe, LQ lq, J5 j5, InterfaceC1767Lz interfaceC1767Lz) {
        this.A03 = c2026Wb;
        this.A08 = str;
        this.A07 = c1849Pe;
        this.A05 = lq;
        this.A04 = j5;
        this.A06 = interfaceC1767Lz;
    }

    public static void A03(C2026Wb c2026Wb, @Nullable C1849Pe c1849Pe, LQ lq, J5 j5, C1H c1h, String str) {
        AbstractC12430e abstractC12430eA01 = C12440f.A01(c2026Wb, j5, str, Uri.parse(c1h.A04()), new NQ().A04(c1849Pe).A03(lq).A06(), false, false);
        if (abstractC12430eA01 != null) {
            abstractC12430eA01.A0A();
        }
    }

    private void A05(String str, String str2, Map<String, String> map) {
        this.A04.A8d(str, map);
        L1.A00(new NU(this, map, str, str2), new NV(this, str, map), C1728Kk.A00());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A06(String str, String str2, Map<String, String> map) {
        String strA01 = A01(0, 22, 52);
        try {
            AbstractC12430e abstractC12430eA01 = C12440f.A01(this.A03, this.A04, str, Uri.parse(str2), new NQ(map).A04(this.A07).A03(this.A05).A06(), this.A01, this.A02);
            if (abstractC12430eA01 != null) {
                abstractC12430eA01.A0D();
            }
            if (this.A00 != null) {
                this.A00.A9Z();
            }
            this.A06.A3s(this.A08);
        } catch (ActivityNotFoundException e2) {
            Log.e(strA01, A01(44, 20, 100) + str2, e2);
        } catch (Exception e3) {
            Log.e(strA01, A01(22, 22, 95), e3);
        }
    }

    public final void A07(NW nw) {
        this.A00 = nw;
    }

    public final void A08(String str, String str2, Map<String, String> map) {
        new JC(str, this.A04).A03(JB.A0J, null);
        if (this.A05.A0A(this.A03)) {
            this.A04.A8D(str, map);
        } else if (C1693Iy.A0z(this.A03)) {
            A05(str, str2, map);
        } else {
            A06(str, str2, map);
        }
    }

    public final void A09(boolean z) {
        this.A02 = z;
    }

    public final void A0A(boolean z) {
        this.A01 = z;
    }
}
