package com.facebook.ads.redexgen.X;

import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'A05' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1S, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1S {
    public static byte[] A01;
    public static final /* synthetic */ C1S[] A02;
    public static final C1S A03;
    public static final C1S A04;
    public static final C1S A05;
    public final String A00;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 32);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{24, 23, 18, 27, 1, ci.l, 12, 27, 29, 31, 29, 22, 27, 3, 1, 28, 11, 10, 12, 3, 1, 22, ci.n, 18, ci.n, 27, 22, 119, 101, 98, 118, 105, 101, 119, 127, 112, 114, 101, 99, 97, 99, 104, 101};
    }

    static {
        A02();
        String strA01 = A01(27, 16, 0);
        A05 = new C1S(strA01, 0, strA01);
        String strA012 = A01(13, 14, 115);
        A04 = new C1S(strA012, 1, strA012);
        String strA013 = A01(0, 13, 126);
        A03 = new C1S(strA013, 2, strA013);
        A02 = new C1S[]{A05, A04, A03};
    }

    public C1S(String str, int i, String str2) {
        this.A00 = str2;
    }

    public static C1S A00(String str) {
        for (C1S c1s : values()) {
            if (c1s.A00.equalsIgnoreCase(str)) {
                return c1s;
            }
        }
        return A03;
    }

    public static C1S valueOf(String str) {
        return (C1S) Enum.valueOf(C1S.class, str);
    }

    public static C1S[] values() {
        return (C1S[]) A02.clone();
    }
}
