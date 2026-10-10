package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class NQ {
    public static byte[] A01;
    public static String[] A02;
    public final Map<String, String> A00;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 113);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        byte[] bArr = {71, 90, 86, 80, 67, 125, 74, 75, 76, 86, 81, 5, 30, 4, 18, 25};
        String[] strArr = A02;
        if (strArr[6].charAt(15) == strArr[1].charAt(15)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[3] = "rnLFNN7HWa";
        strArr2[3] = "rnLFNN7HWa";
        A01 = bArr;
    }

    public static void A02() {
        A02 = new String[]{"CvydOG1rdpeZVjh1I2HxFGGpkCBtP1uR", "LPAb8wO4e9Bm4297vBHQiNlf50jewka4", "p6i6iSivtdsam", "kr1L5mV", "OjxdnAkOIagRjcigNYlctVvlDEXS237l", "CTcf", "XEPmNqkHOtxVdZCukAC2cQoZWEBCmlPv", "qw43eBE0dfm3vpW8jqKcT1ME9HQ7Rm2E"};
    }

    public NQ() {
        this.A00 = new HashMap();
    }

    public NQ(Map<String, String> extraData) {
        this.A00 = extraData;
    }

    public final NQ A03(@Nullable LQ lq) {
        if (lq != null) {
            this.A00.put(A00(11, 5, 0), L6.A01(lq.A05()));
        }
        return this;
    }

    public final NQ A04(@Nullable C1849Pe c1849Pe) {
        if (c1849Pe != null) {
            this.A00.putAll(c1849Pe.A0U());
        }
        return this;
    }

    public final NQ A05(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            this.A00.put(A00(0, 11, 83), str);
        }
        return this;
    }

    public final Map<String, String> A06() {
        return this.A00;
    }
}
