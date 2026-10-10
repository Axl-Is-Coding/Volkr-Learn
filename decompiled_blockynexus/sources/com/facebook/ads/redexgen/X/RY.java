package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RY extends KT {
    public static byte[] A02;
    public static String[] A03;
    public final /* synthetic */ AbstractC1898Rb A00;
    public final /* synthetic */ C2166ag A01;

    static {
        A03();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A03;
            if (strArr[4].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[0] = "oScLyKWb3fn2oYJPJdX8D34ZjyUzRvxz";
            strArr2[3] = "G9gk2wDsh72JfZvDy2Lys6UEtMP3Y1SB";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 84);
            i4++;
        }
    }

    public static void A01() {
        A02 = new byte[]{51, 52, 44, 59, 54, 51, 62, 122, 42, 54, 59, 57, Utf8.REPLACEMENT_BYTE, 55, Utf8.REPLACEMENT_BYTE, 52, 46, 122, 51, 52, 122, 40, Utf8.REPLACEMENT_BYTE, 41, 42, 53, 52, 41, Utf8.REPLACEMENT_BYTE};
    }

    public static void A03() {
        A03 = new String[]{"rcAoHT8yzEEoCxFmEfFHXcUl0vjpGdgY", "LSTuq6Bu4IKsOuvOF", "N9ND8qL7XSSd32I", "yk3W1HvskfBH2x0X91qy9qW3VKhe7rxg", "6nHANpKnXNhaq6nYT", "xMxpxuwRsi8wtxmAob8T1Ch5JVdvxyTv", "", "PgJ"};
    }

    public RY(AbstractC1898Rb abstractC1898Rb, C2166ag c2166ag) {
        this.A00 = abstractC1898Rb;
        this.A01 = c2166ag;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A07() {
        C14498q c14498qA00 = this.A01.A00();
        if (c14498qA00 == null || c14498qA00.A05() == null) {
            String strA00 = A00(0, 29, 14);
            C1697Jd c1697Jd = new C1697Jd(AdErrorType.NO_AD_PLACEMENT, strA00);
            this.A00.A0C.A0A().A4Y(c1697Jd.A04().getErrorCode(), strA00);
            this.A00.A07.A0F(c1697Jd);
            return;
        }
        this.A00.A05 = c14498qA00;
        this.A00.A0O();
    }
}
