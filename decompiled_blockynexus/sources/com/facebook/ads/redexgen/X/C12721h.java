package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1h, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C12721h {
    public static byte[] A00;
    public static String[] A01;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A01;
            if (strArr[6].charAt(12) != strArr[5].charAt(12)) {
                break;
            }
            String[] strArr2 = A01;
            strArr2[2] = "wyIfRhN1EoOdsBbK5VRzuRP5Lc7uqmgb";
            strArr2[2] = "wyIfRhN1EoOdsBbK5VRzuRP5Lc7uqmgb";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            byte b2 = (byte) ((bArrCopyOfRange[i4] - i3) - 100);
            if (A01[0].length() == 15) {
                break;
            }
            String[] strArr3 = A01;
            strArr3[3] = "fUzr4JaNgjTtoWHz8k6HkVts9HpSP1Qi";
            strArr3[1] = "zuQx1GaumRIGoFj6MrcQJkCLkICnzrhi";
            bArrCopyOfRange[i4] = b2;
            i4++;
        }
        throw new RuntimeException();
    }

    public static void A01() {
        A00 = new byte[]{-88, -30, -18, -25, -26};
    }

    public static void A02() {
        A01 = new String[]{"kdNZsDbIr2FjUgQ6", "G4tbE8YXKkBHtbRzjHgF1iVs8BhQX3ki", "rgsd1nh14jUfY0oEDkCzVbJlkUwrdBXO", "6d8i19T6TQ9xRiUYh6SOmARBfT83lkdi", "2FsjHYpAfMpiihTdUse", "xtyrzkpFCSmXtl0pVvZtRxgukiiALNOU", "PnjWz3Ubzat8tEiN6RTB47L4MZQANY1H", "IONaBzwOxfylvpW8Ch"};
    }

    public static void A03(C2026Wb c2026Wb, AnonymousClass15 anonymousClass15, boolean z, InterfaceC12701f interfaceC12701f) {
        if (!C1693Iy.A1C(c2026Wb)) {
            AnonymousClass77 anonymousClass77 = new AnonymousClass77(c2026Wb);
            C1R playableAdData = anonymousClass15.A0M().A0E().A06();
            JC funnelLoggingHandler = new JC(anonymousClass15.A0Q(), c2026Wb.A06());
            anonymousClass77.A0X(funnelLoggingHandler);
            if (playableAdData == null) {
                interfaceC12701f.AAk(AdError.CACHE_ERROR);
                return;
            }
            AnonymousClass76 anonymousClass76 = new AnonymousClass76(playableAdData.A0F(), anonymousClass15.A0U(), anonymousClass15.A0T());
            anonymousClass76.A04 = true;
            if (C1693Iy.A19(c2026Wb)) {
                if (A01[2].charAt(7) != '1') {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[0] = "84TqyqDRqUmJCVM8";
                strArr[0] = "84TqyqDRqUmJCVM8";
                anonymousClass76.A03 = A00(0, 5, 22);
            }
            int i = C12691e.A00[playableAdData.A0A().ordinal()];
            if (i == 1 || i == 2) {
                anonymousClass77.A0T(anonymousClass76);
            }
            anonymousClass77.A0R(new AnonymousClass74(anonymousClass15.A0O().A01(), -1, -1, anonymousClass15.A0U(), anonymousClass15.A0T()));
            anonymousClass77.A0R(new AnonymousClass74(playableAdData.A0E(), -1, -1, anonymousClass15.A0U(), anonymousClass15.A0T()));
            anonymousClass77.A0Q(new RT(c2026Wb, interfaceC12701f, anonymousClass77, playableAdData, z, null), new AnonymousClass70(anonymousClass15.A0U(), anonymousClass15.A0T()));
            return;
        }
        interfaceC12701f.AAl();
    }
}
