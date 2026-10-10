package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.umeng.analytics.pro.ci;
import java.io.File;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2182aw extends C1650Hf {
    public static byte[] A00;
    public static final Pattern A01;
    public static final Pattern A02;
    public static final Pattern A03;

    public static String A06(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 18);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A00 = new byte[]{120, 86, ci.l, 75, 86, 29, 0, 23, 39, 81, 87, 82, 80, 37, 87, 81, 37, 29, 82, 80, 37, 87, 81, 37, 29, 82, 80, 37, 87, ci.m, 72, 37, 87, 28, 1, 22, 93, 107, 29, 27, 30, 28, 105, 27, 29, 105, 81, 30, 28, 105, 27, 29, 105, 81, 30, 28, 105, 27, 67, 7, 105, 27, 80, 77, 90, 17, 85, 35, 87, 111, 32, 34, 87, 37, 35, 87, 111, 32, 34, 87, 37, 35, 87, 111, 32, 34, 87, 37, 125, 56, 87, 37, 110, 115, 100, 47};
    }

    static {
        A07();
        A01 = Pattern.compile(A06(8, 29, 107), 32);
        A02 = Pattern.compile(A06(37, 29, 39), 32);
        A03 = Pattern.compile(A06(66, 30, 25), 32);
    }

    public C2182aw(String str, long j, long j2, long j3, @Nullable File file) {
        super(str, j, j2, j3, file);
    }

    @Nullable
    public static C2182aw A00(File file, C1654Hj c1654Hj) {
        String name = file.getName();
        if (!name.endsWith(A06(1, 7, 106))) {
            file = A05(file, c1654Hj);
            if (file == null) {
                return null;
            }
            name = file.getName();
        }
        Matcher matcher = A03.matcher(name);
        if (!matcher.matches()) {
            return null;
        }
        long length = file.length();
        int id = Integer.parseInt(matcher.group(1));
        String strA0D = c1654Hj.A0D(id);
        if (strA0D == null) {
            return null;
        }
        String key = matcher.group(2);
        long j = Long.parseLong(key);
        String key2 = matcher.group(3);
        return new C2182aw(strA0D, j, length, Long.parseLong(key2), file);
    }

    public static C2182aw A01(String str, long j) {
        return new C2182aw(str, j, -1L, -9223372036854775807L, null);
    }

    public static C2182aw A02(String str, long j) {
        return new C2182aw(str, j, -1L, -9223372036854775807L, null);
    }

    public static C2182aw A03(String str, long j, long j2) {
        return new C2182aw(str, j, j2, -9223372036854775807L, null);
    }

    public static File A04(File file, int i, long j, long j2) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        String strA06 = A06(0, 1, 68);
        sb.append(strA06);
        sb.append(j);
        sb.append(strA06);
        sb.append(j2);
        sb.append(A06(1, 7, 106));
        return new File(file, sb.toString());
    }

    @Nullable
    public static File A05(File file, C1654Hj c1654Hj) {
        String strGroup;
        String name = file.getName();
        Matcher matcher = A02.matcher(name);
        if (matcher.matches()) {
            strGroup = IW.A0O(matcher.group(1));
            if (strGroup == null) {
                return null;
            }
        } else {
            matcher = A01.matcher(name);
            if (!matcher.matches()) {
                return null;
            }
            strGroup = matcher.group(1);
        }
        File fileA04 = A04(file.getParentFile(), c1654Hj.A09(strGroup), Long.parseLong(matcher.group(2)), Long.parseLong(matcher.group(3)));
        if (file.renameTo(fileA04)) {
            return fileA04;
        }
        return null;
    }

    public final C2182aw A08(int i) {
        C1662Hr.A04(this.A05);
        long now = System.currentTimeMillis();
        return new C2182aw(this.A04, this.A02, this.A01, now, A04(this.A03.getParentFile(), i, this.A02, now));
    }
}
