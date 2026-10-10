package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.63, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public enum AnonymousClass63 {
    A03;

    public static byte[] A00;
    public static String[] A01;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            int i5 = (bArrCopyOfRange[i4] ^ i3) ^ 112;
            String[] strArr = A01;
            if (strArr[5].charAt(23) != strArr[7].charAt(23)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[2] = "TmWatSzP310RJQCSGktkHwyFxI";
            strArr2[4] = "1Mq3TnxtQ";
            bArrCopyOfRange[i4] = (byte) i5;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        byte[] bArr = {122, 97, 123, 109, 102, 113, 107, 120, 107, 96, 122};
        String[] strArr = A01;
        if (strArr[1].charAt(11) == strArr[3].charAt(11)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[0] = "8W4A78DjBH0uG37RO8SO06IKWezFcTvo";
        strArr2[0] = "8W4A78DjBH0uG37RO8SO06IKWezFcTvo";
        A00 = bArr;
    }

    public static void A02() {
        A01 = new String[]{"dHmVS3H0BU3wKh61b1vafqfwBkkFzpTO", "wWoQGnRDm0PwXBgVQ4qITNDkBZzwoYVj", "2GfgdM1mYWTRpqof1U8ngJSUNb", "cI7FK6eaPGszRzvhlWq5SquyH1qR7BiB", "9EGarfWen", "DeDz6M2EkKturwySGch2142fcPf5gCwe", "8zTDz8DDtndYFcWIeFeWxJwrqgWlV5a6", "wowMLPXoqmqv7BaAvDUMKLpfZAdLjyqX"};
    }

    static {
        A02();
        A01();
    }
}
