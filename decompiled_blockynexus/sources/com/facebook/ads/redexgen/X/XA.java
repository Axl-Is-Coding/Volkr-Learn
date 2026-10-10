package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.AdSettings;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderImpl;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XA implements AnonymousClass89 {
    public static XA A05;
    public static byte[] A06;
    public static String[] A07;
    public static final C0T[] A08;
    public C0U A00;
    public AnonymousClass88 A01;

    @Nullable
    public C8K A02;
    public C14558x A03;

    @Nullable
    public QK A04;

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A07;
            if (strArr[6].length() != strArr[7].length()) {
                break;
            }
            String[] strArr2 = A07;
            strArr2[6] = "Hv2WK1fJh7GnXaP";
            strArr2[7] = "jwUFRNkRPBL5IaL";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            int i5 = bArrCopyOfRange[i4] - i3;
            String[] strArr3 = A07;
            if (strArr3[4].charAt(26) != strArr3[0].charAt(26)) {
                break;
            }
            String[] strArr4 = A07;
            strArr4[2] = "3jbuj6iR6sIerVLqEJ9xAsC0KuP7QrbG";
            strArr4[3] = "qsuffxm3RCjhy50iWQEl04Txy4tWGAPw";
            bArrCopyOfRange[i4] = (byte) (i5 - 98);
            i4++;
        }
        throw new RuntimeException();
    }

    public static void A06() {
        A06 = new byte[]{-59, -55, -59, -62, -57, -13, -61, -64, -16, 2, ci.n, ci.n, 6, 12, 11, -67, 1, -2, 17, -2, -67, 6, 11, 6, 17, 6, -2, 9, 6, 23, 2, 1, 33, 20, 31, 30, 33, 35, 2, 20, 34, 34, 24, 30, 29, -13, ci.n, 35, ci.n, -8, 29, 24, 35, 24, ci.n, 27, 24, 41, 20, 19};
        if (A07[1].length() == 32) {
            throw new RuntimeException();
        }
        String[] strArr = A07;
        strArr[2] = "XQj6tBQR93KUWcmqG7acynHpkyXbPHo4";
        strArr[3] = "0fPU7ngiro1m2vFzwgFa3cBnolZ3o5pA";
    }

    public static void A07() {
        A07 = new String[]{"kZNWMB05A80rolZkZr5gINRkemJedumA", "PGnlsDLswmZGHAGkHnqyou4j", "CQczeQcoxNMNqPeDO5UPH4delPie3CF6", "Ozs7AQnIuhnl4TF488yhCLnc3lqg3Tqv", "QUMQF15y8F49TOv2Mbtf3pi6YRJU7tsl", "iRM3Hx3PCEqf", "8yEJzjy1AvS4vnL", "zEXAgd0MZ6iopjt"};
    }

    static {
        A07();
        A06();
        A08 = new C0T[]{C0T.A10, C0T.A0e, C0T.A11, C0T.A19, C0T.A0v, C0T.A0x};
    }

    @Nullable
    public static C5N A00(C2027Wc c2027Wc, @Nullable QK qk) {
        if (!C1693Iy.A14(c2027Wc) || qk == null) {
            return null;
        }
        return C5O.A00().A01(qk);
    }

    public static C8K A01(C2027Wc c2027Wc) {
        return C8L.A00().A01(c2027Wc);
    }

    public static synchronized XA A02() {
        XA xa;
        String[] strArr = A07;
        if (strArr[6].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A07;
        strArr2[2] = "yNOYv8BJbeG1jc93xecDuC4SV0M6ZsAO";
        strArr2[3] = "rgM7W1LhEjhuRpvAxAxTebmxK2ArHzjw";
        synchronized (XA.class) {
            if (A05 == null) {
                A05 = new XA();
            }
            xa = A05;
        }
        return xa;
    }

    @Nullable
    public static InterfaceC1854Pj A03(C2027Wc c2027Wc) {
        if (!C1693Iy.A10(c2027Wc)) {
            return null;
        }
        return Q1.A01(c2027Wc);
    }

    @Nullable
    public static QK A04(C2027Wc c2027Wc, C8K c8k, @Nullable InterfaceC1854Pj interfaceC1854Pj) {
        if (!C1693Iy.A1Z(c2027Wc) || interfaceC1854Pj == null) {
            return null;
        }
        return QL.A00().A01(c8k, interfaceC1854Pj, KA.A05(c2027Wc), new X9(new K3(c2027Wc, A05(0, 0, 122), null, EnumC1702Jj.A07, AdSettings.getTestAdType() != AdSettings.TestAdType.DEFAULT ? AdSettings.getTestAdType().getAdTypeString() : null, 0, AdSettings.isTestMode(c2027Wc), AdSettings.isMixedAudience(), new C1707Jo(), LG.A01(C1693Iy.A0H(c2027Wc)), null, null), c2027Wc), QI.A00().A00());
    }

    public static void A08() {
        String strA05 = A05(32, 28, 77);
        if (A07[5].length() == 20) {
            throw new RuntimeException();
        }
        String[] strArr = A07;
        strArr[5] = "4ii3kc4oT9MJsiDOLfNQb5ib2";
        strArr[5] = "4ii3kc4oT9MJsiDOLfNQb5ib2";
        C1710Jr.A05(strA05, A05(8, 24, 59), A05(0, 8, 46));
    }

    public static void A09(C2027Wc c2027Wc, @Nullable C5N c5n) {
        if (!C1693Iy.A14(c2027Wc) || c5n == null) {
            return;
        }
        C5L.A00().A01(c5n, c2027Wc);
    }

    public static void A0A(C2027Wc c2027Wc, @Nullable QK qk) {
        if (!C1693Iy.A0f(c2027Wc) || qk == null) {
            return;
        }
        new C13745i(c2027Wc, qk, new C13755j(), DynamicLoaderImpl.getBidderTokenProviderApi());
    }

    public final synchronized C8K A0B(AnonymousClass87 anonymousClass87) {
        if (this.A02 == null) {
            this.A02 = A01(anonymousClass87.A00());
        }
        return this.A02;
    }

    @Nullable
    public final synchronized QK A0C() {
        return this.A04;
    }

    public final synchronized void A0D(C2027Wc c2027Wc) {
        if (this.A04 != null) {
            return;
        }
        this.A02 = A01(c2027Wc);
        this.A04 = A04(c2027Wc, this.A02, A03(c2027Wc));
        A09(c2027Wc, A00(c2027Wc, this.A04));
        A0A(c2027Wc, this.A04);
        if (this.A04 != null) {
            this.A04.A5H();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass89
    public final J5 A5O(C2027Wc c2027Wc) {
        return b8.A01(c2027Wc);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass89
    public final synchronized AnonymousClass88 A5c(AnonymousClass87 anonymousClass87) {
        if (this.A01 == null) {
            this.A01 = new X7(this);
        }
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass89
    public final synchronized C8X A66(AnonymousClass87 anonymousClass87) {
        return new C2043Ws(anonymousClass87);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass89
    public final synchronized C8A A6F(AnonymousClass87 anonymousClass87) {
        X5 x5;
        x5 = new X5(this, anonymousClass87);
        String[] strArr = A07;
        if (strArr[4].charAt(26) != strArr[0].charAt(26)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A07;
        strArr2[1] = "2Vt1OUprKjNjnyD3";
        strArr2[1] = "2Vt1OUprKjNjnyD3";
        return x5;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass89
    @Nullable
    public final synchronized C0U A6R(AnonymousClass87 anonymousClass87) {
        if (!C1693Iy.A0o(anonymousClass87)) {
            return null;
        }
        if (this.A00 == null) {
            this.A00 = C0V.A00().A01(new X8(this, anonymousClass87));
        }
        C0U c0u = this.A00;
        if (A07[5].length() == 20) {
            throw new RuntimeException();
        }
        String[] strArr = A07;
        strArr[4] = "VIV2EvMRfEPiWlvmDKty9fFKFHJul9Yn";
        strArr[0] = "0wfCQdIt8NwFYvPKQ0QtM4LE4vJ9WdpV";
        return c0u;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass89
    public final synchronized C8B A6y(AnonymousClass87 anonymousClass87) {
        return new X6(this, anonymousClass87);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass89
    public final synchronized C14558x A74() {
        if (this.A03 == null) {
            this.A03 = new C14558x();
            A08();
        }
        return this.A03;
    }
}
