package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.util.Log;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1630Gj {
    public static byte[] A01;
    public static String[] A02;
    public static final Pattern A03;
    public static final Pattern A04;
    public final StringBuilder A00 = new StringBuilder();

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 88);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A01 = new byte[]{116, 22, 48, 76, 56, 55, 79, 91, 77, 94, 76, 56, 55, 79, 77, 66, 54, 42, 35, 4, 28, 11, 6, 3, ci.l, 74, 11, 6, 3, ci.k, 4, 7, ci.m, 4, 30, 74, 28, 11, 6, 31, ci.m, 80, 74, 106, 77, 85, 66, 79, 74, 71, 3, 66, 77, 64, 75, 76, 81, 3, 85, 66, 79, 86, 70, 25, 3, 42, 18, ci.n, 9, 9, ci.n, 23, 30, 89, 27, 24, 29, 89, 26, 12, 28, 89, 10, 28, ci.k, ci.k, ci.n, 23, 30, 67, 89, 118, 78, 76, 85, 85, 76, 75, 66, 5, 70, 80, 64, 5, 82, 76, 81, 77, 5, 71, 68, 65, 5, 77, 64, 68, 65, 64, 87, 31, 5, 22, 45, 40, 45, 44, 52, 45, 99, 32, 54, 38, 99, 48, 38, 55, 55, 42, 45, 36, 99, 51, 1, 6, 18, ci.n, ci.n, 39, 17, 1, 52, 5, 22, 23, 1, 22, 36, 95, 35, 81, 34, 59, 77, 57, 54, 78, 76, 57, 22, 78, 72, 72, 91, 57, 22, 78, 77, 57, 54, 78, 76, 77, 75, 79, 76, 90, 65, 41, 36, 33, 47, 38, 120, 116, 105, 82, 18, 19, 21, 30, 4, 21, 2, 91, 80, 90, 103, 116, 99, 56, 54, Utf8.REPLACEMENT_BYTE, 62, 35, 56, Utf8.REPLACEMENT_BYTE, 54, 113, 36, Utf8.REPLACEMENT_BYTE, 34, 36, 33, 33, 62, 35, 37, 52, 53, 113, 52, Utf8.REPLACEMENT_BYTE, 37, 56, 37, 40, 107, 113, 118, 119, 33, 44, 35, 42, 44, 37, 38, 52, 23, 18, 21, 30, 49, 41, 74, 78, 67, 67, 75, 66, 7, 11, 26, 25, 11, 20, 8, 18, ci.m, 18, 20, 21, 67, 88, 86, 89, 69, 109, 119, 100, 123, 121, 126, 107, 120, 126, 99, 52};
    }

    public static void A06() {
        A02 = new String[]{"BH2zNHpX", "Dnuq9wFIL2", "vBkvmD9EAd5t9FTNthVuCuoibAfWrGUa", "Nhu3hv03L3KjBzyMucsPwsjdroL1", "9TVwE8RhMB8DaYr8DWqJ6OPYy1", "9JupfOkL4WUcaojH", "ecCz7RACP0dYyLgy5uflHn", "VPA8JBGLf77hbCQNqSGQ8FIxNIe4WZlE"};
    }

    static {
        A06();
        A05();
        A03 = Pattern.compile(A03(161, 26, 61));
        A04 = Pattern.compile(A03(3, 12, 60));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000b  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A00(java.lang.String r8) {
        /*
            int r0 = r8.hashCode()
            r7 = 0
            r5 = 3
            r4 = 2
            r3 = 1
            switch(r0) {
                case -1364013995: goto L3d;
                case -1074341483: goto L4e;
                case 100571: goto L5f;
                case 109757538: goto L89;
                default: goto Lb;
            }
        Lb:
            r0 = -1
        Lc:
            if (r0 == 0) goto L9d
            if (r0 == r3) goto L9c
            if (r0 == r4) goto L9c
            if (r0 == r5) goto L9b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r2 = 43
            r1 = 22
            r0 = 123(0x7b, float:1.72E-43)
            java.lang.String r0 = A03(r2, r1, r0)
            r3.append(r0)
            r3.append(r8)
            java.lang.String r3 = r3.toString()
            r2 = 141(0x8d, float:1.98E-43)
            r1 = 15
            r0 = 60
            java.lang.String r0 = A03(r2, r1, r0)
            android.util.Log.w(r0, r3)
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            return r0
        L3d:
            r2 = 197(0xc5, float:2.76E-43)
            r1 = 6
            r0 = 40
            java.lang.String r0 = A03(r2, r1, r0)
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto Lb
            r0 = 1
            goto Lc
        L4e:
            r2 = 254(0xfe, float:3.56E-43)
            r1 = 6
            r0 = 127(0x7f, float:1.78E-43)
            java.lang.String r0 = A03(r2, r1, r0)
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto Lb
            r0 = 2
            goto Lc
        L5f:
            r2 = 203(0xcb, float:2.84E-43)
            r1 = 3
            r0 = 102(0x66, float:1.43E-43)
            java.lang.String r0 = A03(r2, r1, r0)
            boolean r6 = r8.equals(r0)
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C1630Gj.A02
            r0 = 3
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 10
            if (r1 == r0) goto L9e
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1630Gj.A02
            java.lang.String r1 = "MJ40TcK0DidUTvS4"
            r0 = 5
            r2[r0] = r1
            java.lang.String r1 = "MJ40TcK0DidUTvS4"
            r0 = 5
            r2[r0] = r1
            if (r6 == 0) goto Lb
            r0 = 3
            goto Lc
        L89:
            r2 = 281(0x119, float:3.94E-43)
            r1 = 5
            r0 = 82
            java.lang.String r0 = A03(r2, r1, r0)
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto Lb
            r0 = 0
            goto Lc
        L9b:
            return r4
        L9c:
            return r3
        L9d:
            return r7
        L9e:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1630Gj.A00(java.lang.String):int");
    }

    public static int A01(String str, int i) {
        int iIndexOf = str.indexOf(62, i);
        return iIndexOf == -1 ? str.length() : iIndexOf + 1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.text.Layout.Alignment A02(java.lang.String r8) {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1630Gj.A02(java.lang.String):android.text.Layout$Alignment");
    }

    public static String A04(String str) {
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return null;
        }
        return IW.A0n(strTrim, A03(156, 5, 39))[0];
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A07(android.text.SpannableStringBuilder r5, com.facebook.ads.redexgen.X.C1625Ge r6, int r7, int r8) {
        /*
            Method dump skipped, instruction units count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1630Gj.A07(android.text.SpannableStringBuilder, com.facebook.ads.redexgen.X.Ge, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A08(java.lang.String r6, android.text.SpannableStringBuilder r7) {
        /*
            int r1 = r6.hashCode()
            r0 = 3309(0xced, float:4.637E-42)
            r5 = 3
            r4 = 2
            r3 = 1
            if (r1 == r0) goto La0
            r0 = 3464(0xd88, float:4.854E-42)
            if (r1 == r0) goto L8f
            r0 = 96708(0x179c4, float:1.35517E-40)
            if (r1 == r0) goto L7e
            r0 = 3374865(0x337f11, float:4.729193E-39)
            if (r1 == r0) goto L6d
        L19:
            r0 = -1
        L1a:
            if (r0 == 0) goto L67
            if (r0 == r3) goto L61
            if (r0 == r4) goto L5b
            if (r0 == r5) goto L55
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r2 = 209(0xd1, float:2.93E-43)
            r1 = 31
            r0 = 9
            java.lang.String r0 = A03(r2, r1, r0)
            r3.append(r0)
            r3.append(r6)
            r2 = 16
            r1 = 2
            r0 = 85
            java.lang.String r0 = A03(r2, r1, r0)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            r2 = 141(0x8d, float:1.98E-43)
            r1 = 15
            r0 = 60
            java.lang.String r0 = A03(r2, r1, r0)
            android.util.Log.w(r0, r3)
        L54:
            return
        L55:
            r0 = 38
            r7.append(r0)
            goto L54
        L5b:
            r0 = 32
            r7.append(r0)
            goto L54
        L61:
            r0 = 62
            r7.append(r0)
            goto L54
        L67:
            r0 = 60
            r7.append(r0)
            goto L54
        L6d:
            r2 = 260(0x104, float:3.64E-43)
            r1 = 4
            r0 = 49
            java.lang.String r0 = A03(r2, r1, r0)
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L19
            r0 = 2
            goto L1a
        L7e:
            r2 = 192(0xc0, float:2.69E-43)
            r1 = 3
            r0 = 65
            java.lang.String r0 = A03(r2, r1, r0)
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L19
            r0 = 3
            goto L1a
        L8f:
            r2 = 252(0xfc, float:3.53E-43)
            r1 = 2
            r0 = 5
            java.lang.String r0 = A03(r2, r1, r0)
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L19
            r0 = 0
            goto L1a
        La0:
            r2 = 206(0xce, float:2.89E-43)
            r1 = 2
            r0 = 88
            java.lang.String r0 = A03(r2, r1, r0)
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L19
            r0 = 1
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1630Gj.A08(java.lang.String, android.text.SpannableStringBuilder):void");
    }

    public static void A09(String str, C1627Gg c1627Gg) {
        String strA03 = A03(141, 15, 60);
        Matcher matcher = A04.matcher(str);
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            String strGroup2 = matcher.group(2);
            try {
                if (A03(248, 4, 35).equals(strGroup)) {
                    A0A(strGroup2, c1627Gg);
                } else if (A03(187, 5, 16).equals(strGroup)) {
                    c1627Gg.A0C(A02(strGroup2));
                } else if (A03(264, 8, 35).equals(strGroup)) {
                    A0B(strGroup2, c1627Gg);
                } else if (A03(277, 4, 70).equals(strGroup)) {
                    c1627Gg.A06(C1631Gk.A00(strGroup2));
                } else {
                    Log.w(strA03, A03(121, 20, 27) + strGroup + A03(15, 1, 32) + strGroup2);
                }
            } catch (NumberFormatException unused) {
                Log.w(strA03, A03(65, 26, 33) + matcher.group());
            }
        }
    }

    public static void A0A(String str, C1627Gg c1627Gg) throws NumberFormatException {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            c1627Gg.A07(A00(str.substring(iIndexOf + 1)));
            str = str.substring(0, iIndexOf);
        } else {
            c1627Gg.A07(Integer.MIN_VALUE);
        }
        if (str.endsWith(A03(2, 1, 77))) {
            c1627Gg.A04(C1631Gk.A00(str)).A08(0);
            return;
        }
        int i = Integer.parseInt(str);
        if (i < 0) {
            i--;
        }
        C1627Gg c1627GgA04 = c1627Gg.A04(i);
        String[] strArr = A02;
        if (strArr[0].length() == strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[0] = "nfwpqDM6";
        strArr2[6] = "ldPC0GHiWge259aJMdVkFd";
        c1627GgA04.A08(1);
    }

    public static void A0B(String str, C1627Gg c1627Gg) throws NumberFormatException {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf != -1) {
            c1627Gg.A09(A00(str.substring(iIndexOf + 1)));
            str = str.substring(0, iIndexOf);
        } else {
            c1627Gg.A09(Integer.MIN_VALUE);
        }
        c1627Gg.A05(C1631Gk.A00(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0C(java.lang.String r11, com.facebook.ads.redexgen.X.C1628Gh r12, android.text.SpannableStringBuilder r13, java.util.List<com.facebook.ads.redexgen.X.C1625Ge> r14, java.util.List<com.facebook.ads.redexgen.X.C1629Gi> r15) {
        /*
            Method dump skipped, instruction units count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1630Gj.A0C(java.lang.String, com.facebook.ads.redexgen.X.Gh, android.text.SpannableStringBuilder, java.util.List, java.util.List):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A0D(java.lang.String r10, java.lang.String r11, com.facebook.ads.redexgen.X.C1627Gg r12, java.util.List<com.facebook.ads.redexgen.X.C1625Ge> r13) {
        /*
            Method dump skipped, instruction units count: 316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1630Gj.A0D(java.lang.String, java.lang.String, com.facebook.ads.redexgen.X.Gg, java.util.List):void");
    }

    public static void A0E(List<C1625Ge> list, String str, C1628Gh c1628Gh, List<C1629Gi> list2) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            C1625Ge c1625Ge = list.get(i);
            int iA0A = c1625Ge.A0A(str, c1628Gh.A01, c1628Gh.A03, c1628Gh.A02);
            if (iA0A > 0) {
                list2.add(new C1629Gi(iA0A, c1625Ge));
            }
        }
        Collections.sort(list2);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0F(java.lang.String r10) {
        /*
            int r1 = r10.hashCode()
            r0 = 98
            r9 = 0
            r7 = 5
            r6 = 4
            r5 = 3
            r4 = 2
            r3 = 1
            if (r1 == r0) goto L9f
            r0 = 99
            if (r1 == r0) goto L8e
            r0 = 105(0x69, float:1.47E-43)
            if (r1 == r0) goto L64
            r0 = 3314158(0x3291ee, float:4.644125E-39)
            if (r1 == r0) goto L53
            r0 = 117(0x75, float:1.64E-43)
            if (r1 == r0) goto L42
            r0 = 118(0x76, float:1.65E-43)
            if (r1 == r0) goto L31
        L23:
            r0 = -1
        L24:
            if (r0 == 0) goto Lb1
            if (r0 == r3) goto Lb1
            if (r0 == r4) goto Lb1
            if (r0 == r5) goto Lb1
            if (r0 == r6) goto Lb1
            if (r0 == r7) goto Lb1
            return r9
        L31:
            r2 = 287(0x11f, float:4.02E-43)
            r1 = 1
            r0 = 26
            java.lang.String r0 = A03(r2, r1, r0)
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L23
            r0 = 5
            goto L24
        L42:
            r2 = 286(0x11e, float:4.01E-43)
            r1 = 1
            r0 = 78
            java.lang.String r0 = A03(r2, r1, r0)
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L23
            r0 = 4
            goto L24
        L53:
            r2 = 240(0xf0, float:3.36E-43)
            r1 = 4
            r0 = 21
            java.lang.String r0 = A03(r2, r1, r0)
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L23
            r0 = 3
            goto L24
        L64:
            r2 = 208(0xd0, float:2.91E-43)
            r1 = 1
            r0 = 82
            java.lang.String r0 = A03(r2, r1, r0)
            boolean r8 = r10.equals(r0)
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C1630Gj.A02
            r0 = 3
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 10
            if (r1 == r0) goto Lb2
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1630Gj.A02
            java.lang.String r1 = "tlO5iwEB"
            r0 = 0
            r2[r0] = r1
            java.lang.String r1 = "pEnQwZlkHTTTq7cfdXWDKW"
            r0 = 6
            r2[r0] = r1
            if (r8 == 0) goto L23
            r0 = 2
            goto L24
        L8e:
            r2 = 196(0xc4, float:2.75E-43)
            r1 = 1
            r0 = 41
            java.lang.String r0 = A03(r2, r1, r0)
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L23
            r0 = 1
            goto L24
        L9f:
            r2 = 195(0xc3, float:2.73E-43)
            r1 = 1
            r0 = 104(0x68, float:1.46E-43)
            java.lang.String r0 = A03(r2, r1, r0)
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L23
            r0 = 0
            goto L24
        Lb1:
            return r3
        Lb2:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1630Gj.A0F(java.lang.String):boolean");
    }

    public static boolean A0G(String str, Matcher matcher, IG ig, C1627Gg c1627Gg, StringBuilder sb, List<C1625Ge> list) {
        try {
            c1627Gg.A0B(C1631Gk.A01(matcher.group(1))).A0A(C1631Gk.A01(matcher.group(2)));
            A09(matcher.group(3), c1627Gg);
            sb.setLength(0);
            while (true) {
                String strA0Q = ig.A0Q();
                if (!TextUtils.isEmpty(strA0Q)) {
                    if (sb.length() > 0) {
                        sb.append(A03(0, 1, 38));
                    }
                    sb.append(strA0Q.trim());
                } else {
                    A0D(str, sb.toString(), c1627Gg, list);
                    return true;
                }
            }
        } catch (NumberFormatException unused) {
            Log.w(A03(141, 15, 60), A03(91, 30, 125) + matcher.group());
            return false;
        }
    }

    public final boolean A0H(IG ig, C1627Gg c1627Gg, List<C1625Ge> list) {
        String strA0Q = ig.A0Q();
        if (strA0Q == null) {
            return false;
        }
        Matcher matcher = A03.matcher(strA0Q);
        if (matcher.matches()) {
            return A0G(null, matcher, ig, c1627Gg, this.A00, list);
        }
        String strA0Q2 = ig.A0Q();
        if (strA0Q2 == null) {
            return false;
        }
        Matcher matcher2 = A03.matcher(strA0Q2);
        if (matcher2.matches()) {
            return A0G(strA0Q.trim(), matcher2, ig, c1627Gg, this.A00, list);
        }
        return false;
    }
}
