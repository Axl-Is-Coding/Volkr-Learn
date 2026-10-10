package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ez, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1596Ez extends R0<EnumC12410c> {
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
            if (strArr[1].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[5] = "VLAsB6FpgF6HHUeMgZV0uCFNDiYuOANh";
            strArr2[5] = "VLAsB6FpgF6HHUeMgZV0uCFNDiYuOANh";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 46);
            i4++;
        }
    }

    public static void A01() {
        A00 = new byte[]{19, 26, 17, 17};
    }

    public static void A02() {
        A01 = new String[]{"nfOmdPRKy6dJXhDeozy3bec4eprLIoSQ", "SpNSu", "KnwtHm0RppTzgOMyhwsp1PpmZykcOlps", "rm2Q4", "VxhbZsLUCIIY3eK9iwu", "VDpaDUxovSHskE3K7Rzj9CiAPD6OjiUH", "VHZOT7bXdVoDaPP", "SrW2lLCi4fFkH4TY8LZz6iOiSZQwKo1F"};
    }

    public C1596Ez(String str) {
        super(str);
    }

    @Override // com.facebook.ads.redexgen.X.R0
    /* JADX INFO: renamed from: A07, reason: merged with bridge method [inline-methods] */
    public final C0W A06(@Nullable EnumC12410c enumC12410c) {
        String strA02;
        if (enumC12410c != null) {
            strA02 = enumC12410c.A02();
        } else {
            if (A01[0].charAt(24) == 'c') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[2] = "FtIMifYPiEAUkOQozBm9Vw11LGuuRK56";
            strArr[2] = "FtIMifYPiEAUkOQozBm9Vw11LGuuRK56";
            strA02 = A00(0, 4, 119);
        }
        return new C0W(this, strA02);
    }
}
