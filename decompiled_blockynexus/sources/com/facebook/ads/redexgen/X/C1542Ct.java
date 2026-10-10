package com.facebook.ads.redexgen.X;

import android.util.Log;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.UUID;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ct, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1542Ct {
    public static byte[] A00;
    public static String[] A01;

    static {
        A05();
        A04();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 3);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{76, 111, 111, 116, 93, 104, 115, 113, 73, 104, 117, 112, 109, 86, 75, 77, 72, 72, 87, 74, 76, 93, 92, 24, 72, 75, 75, 80, 24, 78, 93, 74, 75, 81, 87, 86, 2, 24};
    }

    public static void A05() {
        A01 = new String[]{"kk3S4O13iVXJvtm5AjTeD8rK", "Zu4hi0TCs3bKXIhBk2aWCiDe3xK", "JowY5N4XtyrwAA9epoNCHGChZ5QJHmq", "OOxBqRpXIUSrAU80JlBeMYgVyXHV", "tCZgrksHUVK4eCN8oQ7yIu", "GrKlMP1w4PgYrm5YCKNZqmcWRop33Hln", "0sCqI3ucQZfe3Uil9qNltLDWT8T5PAU", "ug"};
    }

    public static int A00(byte[] bArr) {
        C1541Cs parsedAtom = A01(bArr);
        if (parsedAtom != null) {
            return parsedAtom.A00;
        }
        return -1;
    }

    @Nullable
    public static C1541Cs A01(byte[] bArr) {
        IG ig = new IG(bArr);
        if (ig.A08() < 32) {
            return null;
        }
        ig.A0Z(0);
        if (ig.A09() != ig.A05() + 4) {
            return null;
        }
        int iA09 = ig.A09();
        int i = AbstractC1524Cb.A0r;
        String[] strArr = A01;
        String str = strArr[0];
        String str2 = strArr[7];
        int length = str.length();
        int atomType = str2.length();
        if (length == atomType) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[6] = "KiHnRKSUZsnBoZKY996tMhDtZ8Gdi7J";
        strArr2[6] = "KiHnRKSUZsnBoZKY996tMhDtZ8Gdi7J";
        if (iA09 != i) {
            return null;
        }
        int atomType2 = ig.A09();
        int iA01 = AbstractC1524Cb.A01(atomType2);
        if (iA01 > 1) {
            Log.w(A02(0, 12, 31), A02(12, 26, 59) + iA01);
            return null;
        }
        UUID uuid = new UUID(ig.A0M(), ig.A0M());
        if (iA01 == 1) {
            ig.A0a(ig.A0I() * 16);
        }
        int iA0I = ig.A0I();
        if (iA0I != ig.A05()) {
            return null;
        }
        byte[] data = new byte[iA0I];
        ig.A0d(data, 0, iA0I);
        return new C1541Cs(uuid, iA01, data);
    }

    @Nullable
    public static UUID A03(byte[] bArr) {
        C1541Cs c1541CsA01 = A01(bArr);
        if (c1541CsA01 != null) {
            return c1541CsA01.A01;
        }
        if (A01[6].length() != 31) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[2] = "A19aWphbBlm9ojDJQ1W47aeMdyevB22";
        strArr[1] = "rfVibYQBAeR1UXfUamieG6t7la8";
        return null;
    }
}
