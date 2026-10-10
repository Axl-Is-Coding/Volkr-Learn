package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.a2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2127a2 implements LE {
    public static byte[] A03;
    public static String[] A04;
    public int A00;

    @Nullable
    public String A01;
    public final LE A02;

    static {
        A03();
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            byte b2 = bArrCopyOfRange[i4];
            String[] strArr = A04;
            if (strArr[5].charAt(25) == strArr[3].charAt(25)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[5] = "Ai5XpAh7M4hRkPfPQf54GYnUnAkHicBv";
            strArr2[3] = "aIcIWiLMc3Hy2WApHOm5eO35KvTaoUWD";
            bArrCopyOfRange[i4] = (byte) ((b2 - i3) - 83);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{-117, -117, 125, -128};
    }

    public static void A03() {
        A04 = new String[]{"3JpGgMVfhEKs4h1tr8RMzDA7DOHokops", "dXqQ9QAcXKU8whF3kmnzOWjNbVMrrIOv", "otwaAvusvekoag06qMT5pISHPHVrRcMV", "WpvUEDFnYdSXMC7RGaJnlQQN5lPpeUoV", "uIVwlH6eBNHvEYk4kE6nlnhEt8muXj04", "pYVE6LchgLxW1usH7NIdAbU6pOe1Iyyx", "cgHZB3wyyqxQlT2ShG9pTXiCyg", "w9qB75SnMFWvoXL9CpdnGLUKrWLPOybN"};
    }

    public C2127a2(LE le) {
        this.A02 = le;
    }

    private void A01() {
        if (this.A01 != null) {
            this.A02.AC5(this.A01 + A00(0, 4, 10) + this.A00);
            this.A01 = null;
            this.A00 = 0;
        }
    }

    @Override // com.facebook.ads.redexgen.X.LE
    public final void AC5(String str) {
        if (!LG.A0A(str)) {
            String strA04 = LG.A04(str);
            if (strA04.equals(this.A01)) {
                this.A00++;
                return;
            }
            A01();
            this.A01 = strA04;
            this.A00 = 1;
            return;
        }
        A01();
        this.A02.AC5(str);
    }

    @Override // com.facebook.ads.redexgen.X.LE
    public final void flush() {
        A01();
        this.A02.flush();
    }
}
