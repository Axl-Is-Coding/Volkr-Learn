package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import org.json.JSONException;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class R8 extends KT {
    public static byte[] A01;
    public static String[] A02;
    public final /* synthetic */ String A00;

    static {
        A03();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 67);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        byte[] bArr = {29, 41, 28, 40, 44, 28, 37, 26, 48, 22, 26, 24, 39, 39, 32, 37, 30};
        String[] strArr = A02;
        if (strArr[2].charAt(10) != strArr[7].charAt(10)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[5] = "QkfkB";
        strArr2[5] = "QkfkB";
        A01 = bArr;
    }

    public static void A03() {
        A02 = new String[]{"oskFp91e5pmXbfqncEKHUOJlooKh56jY", "lReJ4EGI0ZfzcS4beAfFSCPJefxJWm51", "X9zy5AMUM8AKtatrcfePQZWL0uWUICrn", "wxwSRA3odXIdIsY7f5yZfv3v7", "O6Pxh8VVn00f1EJnP312TgPdEktEk3X8", "2QJh3yF6", "0YwPA87fpumxZ406JTpoKHsZ368w", "aJIZZEX98MAeULDgBorQq277OQTM9IaN"};
    }

    public R8(String str) {
        this.A00 = str;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A07() {
        String strA00 = A00(0, 17, 116);
        try {
            C12580t.A04.await();
            if (C12580t.A0J(this.A00)) {
                ((C1J) C12580t.A00.A04().get(this.A00)).A05((int) (System.currentTimeMillis() / 1000));
                C12580t.A00.A07(this.A00);
                C12580t.A00.A05();
                C12580t.A0A();
            }
        } catch (InterruptedException e2) {
            C12580t.A01.A04().A8H(strA00, C8Y.A0w, new C8Z(e2));
        } catch (JSONException e3) {
            C12580t.A08();
            C12580t.A01.A04().A8H(strA00, C8Y.A0v, new C8Z(e3));
        }
    }
}
