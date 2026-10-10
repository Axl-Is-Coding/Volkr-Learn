package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5i, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C13745i {
    public static boolean A04;
    public static byte[] A05;
    public static final String A06;
    public final C13755j A00;
    public final C13765k A01;
    public final C2027Wc A02;
    public final Q8 A03;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 114);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{46, 56, 19, 41, 52, 56, 62, 45, Utf8.REPLACEMENT_BYTE};
    }

    static {
        A01();
        A06 = C13745i.class.getSimpleName();
    }

    public C13745i(C2027Wc c2027Wc, QK qk, C13755j c13755j, C13765k c13765k) {
        this.A02 = c2027Wc;
        this.A03 = qk.A4N(Q9.A06);
        this.A00 = c13755j;
        this.A01 = c13765k;
        this.A03.A3I(new TI(this));
        A02();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void A02() {
        if (KL.A02(this)) {
            return;
        }
        try {
            if (!this.A03.A7w()) {
                BuildConfigApi.isDebug();
                return;
            }
            String strOptString = this.A03.A64().optString(A00(0, 9, 62));
            if (!TextUtils.isEmpty(strOptString)) {
                this.A00.A04(this.A02, strOptString);
                if (!A04 || C1693Iy.A0e(this.A02)) {
                    A04 = true;
                    this.A01.A06();
                }
            }
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
