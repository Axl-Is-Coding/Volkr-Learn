package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1c, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C12671c {
    public static byte[] A0C;
    public static String[] A0D;
    public InterfaceC12600v A00;
    public AnonymousClass15 A01;
    public AnonymousClass77 A02;
    public String A03;
    public String A04;
    public List<C1Y> A05;
    public List<C1Z> A06;
    public List<C12651a> A07;
    public List<C1Y> A08;
    public List<C1Z> A09;
    public List<C12651a> A0A;
    public boolean A0B;

    static {
        A06();
        A05();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 61);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A0C = new byte[]{70, 97, 121, 110, 99, 102, 107, 47, 76, 110, 108, 103, 106, 71, 106, 99, 127, 106, 125, 47, 102, 124, 47, 123, 125, 118, 102, 97, 104, 47, 123, 96, 47, 108, 110, 108, 103, 106, 47, 110, 124, 124, 106, 123, 124, 98, 96, 98, 105, 100, 94, 108, 96, 111, 101, 96, 117, 110, 115, 120, 94, 103, 104, 109, 100, 114, 71, 69, 71, 76, 65, 123, 73, 69, 74, 64, 69, 80, 75, 86, 93, 123, 77, 73, 69, 67, 65, 87, 81, 83, 81, 90, 87, 109, 95, 83, 92, 86, 83, 70, 93, 64, 75, 109, 68, 91, 86, 87, 93, 65};
    }

    public static void A06() {
        A0D = new String[]{"sSa", "mi5m9ruhoFx", "", "s1wudweLxGs6i20t889bnIZHd8X0m2eo", "Fcx9vpMoDT8ZievIpIvDEirtE1Us4xir", "sWXb4LdtlKvePJz7J6b2Ft", "9VqadD5Zvd9D5BEd6Wk7rSckzIYQNWUp", "eNXwk482U"};
    }

    public C12671c(InterfaceC12600v interfaceC12600v, AnonymousClass15 anonymousClass15, String str, AnonymousClass77 anonymousClass77) {
        this.A01 = anonymousClass15;
        if (!A09()) {
            this.A0B = false;
            return;
        }
        this.A0B = true;
        JSONObject jSONObjectA0X = this.A01.A0X();
        this.A00 = interfaceC12600v;
        try {
            this.A06 = C12661b.A05(jSONObjectA0X);
            this.A07 = C12661b.A06(jSONObjectA0X);
            this.A05 = C12661b.A04(jSONObjectA0X);
            this.A09 = C12661b.A08(jSONObjectA0X);
            this.A0A = C12661b.A09(jSONObjectA0X);
            this.A08 = C12661b.A07(jSONObjectA0X);
        } catch (IllegalStateException unused) {
            this.A00.A9P();
        }
        this.A04 = anonymousClass15.A0U();
        this.A03 = str;
        this.A02 = anonymousClass77;
    }

    private void A02() {
        Iterator<C1Y> it;
        Iterator<C1Z> it2 = this.A06.iterator();
        while (true) {
            boolean zHasNext = it2.hasNext();
            if (A0D[7].length() != 9) {
                throw new RuntimeException();
            }
            String[] strArr = A0D;
            strArr[2] = "s43HwKDQ";
            strArr[2] = "s43HwKDQ";
            if (zHasNext) {
                C1Z next = it2.next();
                this.A02.A0R(new AnonymousClass74(next.A02(), next.A00(), next.A01(), this.A04, this.A03));
            } else {
                for (C12651a c12651a : this.A07) {
                    this.A02.A0W(new AnonymousClass76(c12651a.A01(), this.A04, this.A03, c12651a.A00()));
                }
                List<C1Y> list = this.A05;
                if (A0D[2].length() != 15) {
                    String[] strArr2 = A0D;
                    strArr2[5] = "Ng223TSybiacEU1WWPLk2q";
                    strArr2[5] = "Ng223TSybiacEU1WWPLk2q";
                    it = list.iterator();
                } else {
                    String[] strArr3 = A0D;
                    strArr3[7] = "18SymYfpU";
                    strArr3[7] = "18SymYfpU";
                    it = list.iterator();
                }
                while (true) {
                    boolean zHasNext2 = it.hasNext();
                    if (A0D[7].length() != 9) {
                        throw new RuntimeException();
                    }
                    String[] strArr4 = A0D;
                    strArr4[4] = "gi3GLNiIWCAwlyNF5UJWvDNlEZ56BupW";
                    strArr4[4] = "gi3GLNiIWCAwlyNF5UJWvDNlEZ56BupW";
                    if (zHasNext2) {
                        C1Y next2 = it.next();
                        AnonymousClass76 cacheFileData = new AnonymousClass76(next2.A01(), this.A04, this.A03);
                        cacheFileData.A04 = !next2.A00().equals(A01(0, 0, 60));
                        cacheFileData.A03 = next2.A00();
                        this.A02.A0T(cacheFileData);
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private void A03() {
        for (C1Z c1z : this.A09) {
            this.A02.A0S(new AnonymousClass74(c1z.A02(), c1z.A00(), c1z.A01(), this.A04, this.A03));
        }
        List<C12651a> list = this.A0A;
        if (A0D[7].length() != 9) {
            throw new RuntimeException();
        }
        String[] strArr = A0D;
        strArr[2] = "XaDaKpjcAfkqTK4VX";
        strArr[2] = "XaDaKpjcAfkqTK4VX";
        for (C12651a videoCacheData : list) {
            this.A02.A0V(new AnonymousClass76(videoCacheData.A01(), this.A04, this.A03));
        }
        for (C1Y c1y : this.A08) {
            AnonymousClass76 anonymousClass76 = new AnonymousClass76(c1y.A01(), this.A04, this.A03);
            anonymousClass76.A04 = !c1y.A00().equals(A01(0, 0, 60));
            anonymousClass76.A03 = c1y.A00();
            this.A02.A0U(anonymousClass76);
        }
    }

    private void A04() {
        this.A02.A0Q(new RS(this), new AnonymousClass70(this.A04, this.A03));
    }

    private boolean A07(String str) {
        AnonymousClass15 anonymousClass15 = this.A01;
        if (anonymousClass15 != null) {
            return anonymousClass15.A0X().has(str);
        }
        return false;
    }

    public final void A08() {
        if (A09()) {
            A02();
            A03();
            A04();
            return;
        }
        throw new IllegalStateException(A01(0, 45, 50));
    }

    public final boolean A09() {
        AnonymousClass15 anonymousClass15 = this.A01;
        if (anonymousClass15 != null) {
            JSONObject jSONObjectA0X = anonymousClass15.A0X();
            if (A0D[5].length() != 22) {
                throw new RuntimeException();
            }
            String[] strArr = A0D;
            strArr[5] = "0MUxNIoi6mFZgBaSZOUpUP";
            strArr[5] = "0MUxNIoi6mFZgBaSZOUpUP";
            return this.A0B || (jSONObjectA0X != null && A07(A01(66, 22, 25)) && A07(A01(88, 22, 15)) && A07(A01(45, 21, 60)));
        }
        return this.A0B;
    }
}
