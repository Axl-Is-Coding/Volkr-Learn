package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.76, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class AnonymousClass76 {
    public static byte[] A09;
    public long A00;

    @Nullable
    public Integer A01;
    public String A02;
    public String A03;
    public boolean A04;
    public boolean A05;
    public final String A06;
    public final String A07;
    public final String A08;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 79);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A09 = new byte[]{88, 91, 85, 80};
    }

    public AnonymousClass76(String str, String str2, String str3) {
        this.A03 = A00(0, 0, 9);
        this.A02 = A00(0, 4, 123);
        this.A00 = -1L;
        this.A08 = str;
        this.A07 = str2;
        this.A06 = str3;
        this.A01 = null;
    }

    public AnonymousClass76(String str, String str2, String str3, long j) {
        this.A03 = A00(0, 0, 9);
        this.A02 = A00(0, 4, 123);
        this.A00 = -1L;
        this.A08 = str;
        this.A07 = str2;
        this.A06 = str3;
        this.A01 = null;
        this.A00 = j;
    }
}
