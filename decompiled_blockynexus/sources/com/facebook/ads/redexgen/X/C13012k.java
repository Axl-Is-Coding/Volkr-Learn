package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.umeng.analytics.pro.ci;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2k, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C13012k extends AbstractC1497An {
    public static byte[] A05;
    public static String[] A06;
    public static final Pattern A07;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public final boolean A04;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 114);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A05 = new byte[]{-98, -20, 3, -2, -20, 32, 40, -17, -19, -2, -19, 3, -20, 32, 40, -17, -19, -2, -20, 32, 40, -17, -19, -20, 3, -2, -2, 64, 32, -14, -19, -20, 32, 40, -17, -19, -82, 44, 81, 73, 84, 87, 79, 93, 77, 34, 8, -2, 39, 42, 37, 25, 44, -14, -40, -5, 19, 17, 24, 24, 17, 22, ci.m, -56, 12, 17, 9, 20, 23, ci.m, 29, ci.k, -56, 20, 17, 22, ci.k, -56, 10, ci.k, ci.l, 23, 26, ci.k, -56, 11, 23, 21, 24, 20, ci.k, 28, ci.k, -56, ci.l, 23, 26, 21, 9, 28, -30, -56, 17, 41, 39, 46, 46, 39, 44, 37, -34, 34, 39, 31, 42, 45, 37, 51, 35, -34, 42, 39, 44, 35, -34, 53, 39, 50, 38, -34, 36, 35, 53, 35, 48, -34, 33, 45, 42, 51, 43, 44, 49, -34, 50, 38, 31, 44, -34, 36, 45, 48, 43, 31, 50, -8, -34, -35, -11, -13, -6, -6, -13, -8, -15, -86, -13, -8, 0, -21, -10, -13, -18, -86, -2, -13, -9, -13, -8, -15, -60, -86, 68, 100, 82, 53, 86, 84, 96, 85, 86, 99, -11, -33, ci.n, -1, 8, ci.l, ci.k, -9, 42, 42, 28, 73, 73, 91, 21, 52, -25, -29, -8, 21, 54, -24, -15, -25, 53, 54, 35, 52, 54, 85, 70, 89, 85};
    }

    public static void A04() {
        A06 = new String[]{"nLO9L7XoEpR8vgnDFT", "WlEQ0W9HytVOtlcgcYyzDlj1QkZOFGjO", "ODtnbW3mHTyNn479FkodGv794qS9hsWl", "APk9cVzJYKr2vBqvSJCf7k3ktACu2ubu", "Tq9sEDvjDozJ9rvk5K396aURjyjwu7hY", "bGv", "ZQgwsO83xrUrRKbDM61rEvH7uEXNNVYo", "gyYiWp0aVpa2EpLIT9J28do7UtlziSMd"};
    }

    static {
        A04();
        A03();
        A07 = Pattern.compile(A02(1, 35, 82));
    }

    public C13012k() {
        this(null);
    }

    public C13012k(List<byte[]> list) {
        super(A02(182, 10, 127));
        if (list != null && !list.isEmpty()) {
            this.A04 = true;
            String strA0Q = IW.A0Q(list.get(0));
            C1662Hr.A03(strA0Q.startsWith(A02(47, 8, 70)));
            A07(strA0Q);
            A05(new IG(list.get(1)));
            return;
        }
        this.A04 = false;
    }

    public static long A00(String str) {
        Matcher matcher = A07.matcher(str);
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        long j = Long.parseLong(matcher.group(1)) * 60 * 60 * 1000000;
        long timestampUs = Long.parseLong(matcher.group(2));
        long j2 = j + (timestampUs * 60 * 1000000);
        long timestampUs2 = Long.parseLong(matcher.group(3));
        return j2 + (timestampUs2 * 1000000) + (Long.parseLong(matcher.group(4)) * 10000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AbstractC1497An
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final C2135aB A0d(byte[] bArr, int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        I6 i6 = new I6();
        IG ig = new IG(bArr, i);
        if (!this.A04) {
            A05(ig);
        }
        A06(ig, arrayList, i6);
        G5[] g5Arr = new G5[arrayList.size()];
        arrayList.toArray(g5Arr);
        return new C2135aB(g5Arr, i6.A05());
    }

    private void A05(IG ig) {
        String strA0Q;
        do {
            strA0Q = ig.A0Q();
            if (strA0Q == null) {
                return;
            }
            if (A06[6].charAt(30) != 'Y') {
                throw new RuntimeException();
            }
            String[] strArr = A06;
            strArr[0] = "7FHmrvaj0sy2XXhHTc";
            strArr[5] = "VJa";
        } while (!strA0Q.startsWith(A02(192, 8, 40)));
    }

    private void A06(IG ig, List<G5> list, I6 i6) {
        while (true) {
            String strA0Q = ig.A0Q();
            if (strA0Q != null) {
                if (!this.A04 && strA0Q.startsWith(A02(47, 8, 70))) {
                    A07(strA0Q);
                } else if (strA0Q.startsWith(A02(37, 10, 118))) {
                    A08(strA0Q, list, i6);
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A07(java.lang.String r11) {
        /*
            Method dump skipped, instruction units count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C13012k.A07(java.lang.String):void");
    }

    private void A08(String str, List<G5> list, I6 i6) {
        int i = this.A01;
        String strA02 = A02(182, 10, 127);
        if (i == 0) {
            Log.w(strA02, A02(55, 47, 54) + str);
            return;
        }
        String[] strArrSplit = str.substring(A02(37, 10, 118).length()).split(A02(36, 1, 16), this.A01);
        if (strArrSplit.length != this.A01) {
            Log.w(strA02, A02(102, 55, 76) + str);
            return;
        }
        long jA00 = A00(strArrSplit[this.A02]);
        String strA022 = A02(157, 25, 24);
        if (jA00 == -9223372036854775807L) {
            Log.w(strA02, strA022 + str);
            return;
        }
        long endTimeUs = -9223372036854775807L;
        String str2 = strArrSplit[this.A00];
        if (!str2.trim().isEmpty()) {
            endTimeUs = A00(str2);
            if (endTimeUs == -9223372036854775807L) {
                Log.w(strA02, strA022 + str);
                return;
            }
        }
        String strReplaceAll = strArrSplit[this.A03].replaceAll(A02(206, 7, 71), A02(0, 0, 15));
        String strA023 = A02(0, 1, 34);
        list.add(new G5(strReplaceAll.replaceAll(A02(200, 3, 92), strA023).replaceAll(A02(203, 3, 123), strA023)));
        i6.A04(jA00);
        if (endTimeUs != -9223372036854775807L) {
            list.add(null);
            i6.A04(endTimeUs);
        }
    }
}
