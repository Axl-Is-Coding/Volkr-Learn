package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ZE implements InterfaceC1563Dq {
    public static byte[] A00;
    public static String[] A01;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 83);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{109, 88, 88, 73, 65, 92, 88, 73, 72, 12, 88, 67, 12, 79, 94, 73, 77, 88, 73, 12, 72, 73, 79, 67, 72, 73, 94, 12, 74, 67, 94, 12, 89, 66, 95, 89, 92, 92, 67, 94, 88, 73, 72, 12, 74, 67, 94, 65, 77, 88, 88, 73, 73, 85, 80, 90, 88, 77, 80, 86, 87, 22, 80, 93, 10, ci.l, 31, 31, 3, 6, 12, ci.l, 27, 6, 0, 1, 64, 23, 66, 10, 2, 28, 8, 50, 35, 35, Utf8.REPLACEMENT_BYTE, 58, 48, 50, 39, 58, 60, 61, 124, 43, 126, 32, 48, 39, 54, 96, 102};
    }

    public static void A02() {
        A01 = new String[]{"aIgF7yW6te9d0giIJjPlgLYuMarqNmaI", "5uowvZFp", "cObh83RuJ2BcUv3u494pfG0SonjgkZ34", "vjRgY08J1B3TNMsxRteKWvE9VDogNaKh", "qNUTjYBqOOgeDCHuUlR3yEqIWp1K4VGN", "N6vmBeMb9YQ5y6AoxxD7YUaD7FUFK", "OjnTWYSeBoS9dL1Ai6OGe6VjE6jgVlWS", "CC64HnyKjXihB9EkxjxtlcenpS0"};
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0035  */
    @Override // com.facebook.ads.redexgen.X.InterfaceC1563Dq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.InterfaceC1561Do A4E(com.facebook.ads.internal.exoplayer2.Format r9) {
        /*
            r8 = this;
            java.lang.String r5 = r9.A0O
            int r7 = r5.hashCode()
            r0 = -1248341703(0xffffffffb597d139, float:-1.1311269E-6)
            r4 = 2
            r3 = 1
            if (r7 == r0) goto L65
            r0 = 1154383568(0x44ce7ed0, float:1651.9629)
            if (r7 == r0) goto L53
            r6 = 1652648887(0x62816bb7, float:1.1936958E21)
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.ZE.A01
            r0 = 7
            r1 = r2[r0]
            r0 = 1
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L92
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.ZE.A01
            java.lang.String r1 = "bTmSe2zy8D5qz7yeGIeNoRuS8tTOpcQK"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "fPfUohV67zMJVCtM8CPLt22RAENT6cGu"
            r0 = 6
            r2[r0] = r1
            if (r7 == r6) goto L42
        L35:
            r0 = -1
        L36:
            if (r0 == 0) goto L8c
            if (r0 == r3) goto L86
            if (r0 != r4) goto L77
            com.facebook.ads.redexgen.X.ZM r0 = new com.facebook.ads.redexgen.X.ZM
            r0.<init>()
            return r0
        L42:
            r2 = 83
            r1 = 20
            r0 = 0
            java.lang.String r0 = A00(r2, r1, r0)
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L35
            r0 = 2
            goto L36
        L53:
            r2 = 65
            r1 = 18
            r0 = 60
            java.lang.String r0 = A00(r2, r1, r0)
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L35
            r0 = 1
            goto L36
        L65:
            r2 = 50
            r1 = 15
            r0 = 106(0x6a, float:1.49E-43)
            java.lang.String r0 = A00(r2, r1, r0)
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L35
            r0 = 0
            goto L36
        L77:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            r2 = 0
            r1 = 50
            r0 = 127(0x7f, float:1.78E-43)
            java.lang.String r0 = A00(r2, r1, r0)
            r3.<init>(r0)
            throw r3
        L86:
            com.facebook.ads.redexgen.X.ZH r0 = new com.facebook.ads.redexgen.X.ZH
            r0.<init>()
            return r0
        L8c:
            com.facebook.ads.redexgen.X.ZJ r0 = new com.facebook.ads.redexgen.X.ZJ
            r0.<init>()
            return r0
        L92:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.ZE.A4E(com.facebook.ads.internal.exoplayer2.Format):com.facebook.ads.redexgen.X.Do");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1563Dq
    public final boolean ADm(Format format) {
        String str = format.A0O;
        return A00(50, 15, 106).equals(str) || A00(65, 18, 60).equals(str) || A00(83, 20, 0).equals(str);
    }
}
