package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.umeng.analytics.pro.ci;
import java.io.IOException;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aU, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2154aU implements HC {
    public static byte[] A0A;
    public static String[] A0B;
    public HC A00;
    public HC A01;
    public HC A02;
    public HC A03;
    public HC A04;
    public HC A05;
    public HC A06;
    public final Context A07;
    public final HC A08;
    public final HX<? super HC> A09;

    static {
        A08();
        A07();
    }

    public static String A06(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 49);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        byte[] bArr = {119, -87, -74, -84, -70, -73, -79, -84, -89, -87, -69, -69, -83, -68, 119, -40, 11, 11, -4, 4, 7, 11, 0, 5, -2, -73, 11, 6, -73, 7, 3, -8, ci.n, -73, -23, -21, -28, -25, -73, 10, 11, 9, -4, -8, 4, -73, ci.l, 0, 11, -1, 6, 12, 11, -73, -5, -4, 7, -4, 5, -5, 0, 5, -2, -73, 6, 5, -73, 11, -1, -4, -73, -23, -21, -28, -25, -73, -4, ci.m, 11, -4, 5, 10, 0, 6, 5, -13, 20, 21, ci.n, 36, 27, 35, -13, ci.n, 35, ci.n, 2, 30, 36, 33, 18, 20, -90, -45, -45, -48, -45, -127, -54, -49, -44, -43, -62, -49, -43, -54, -62, -43, -54, -49, -56, -127, -77, -75, -82, -79, -127, -58, -39, -43, -58, -49, -44, -54, -48, -49, -82, -64, -64, -78, -63, -33, -21, -23, -86, -30, -35, -33, -31, -34, -21, -21, -25, -86, -35, -32, -17, -86, -27, -22, -16, -31, -18, -22, -35, -24, -86, -31, -12, -21, -20, -24, -35, -11, -31, -18, -82, -86, -31, -12, -16, -86, -18, -16, -23, -20, -86, -50, -16, -23, -20, -64, -35, -16, -35, -49, -21, -15, -18, -33, -31, 17, 29, 28, 34, 19, 28, 34, -13, -16, 3, -16, -30, -47, -25, -30, -43, -29, -33, -27, -30, -45, -43, -27, -25, -32, -29};
        if (A0B[7].length() != 19) {
            throw new RuntimeException();
        }
        String[] strArr = A0B;
        strArr[1] = "aTM6G8lKpIJ6RP017QMILejHyUH2B7dh";
        strArr[3] = "ERhfqbVtKjwR0y0XTQNxaBJXl7PFqJQV";
        A0A = bArr;
    }

    public static void A08() {
        A0B = new String[]{"FbuaOXxD8R3r2Sez", "nl2ebpznfahqYQ0iJMeMraM5u9ytbnkM", "LukWv8Q1lv25Jz9VZoWHVgr80BMsfj7N", "UITThFDmXIK6qk0JXllT0SDhOskljLuD", "WWGwJIDbyg2bl1Mdb", "YrbKAvAwCNNri3u3ecPrw9BDMC3UJFWv", "h8pfgUZlB4VhxmKVTbPlaDG6t2cnqOd2", "IQvStArhblJullrSqn3"};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.HX != com.facebook.ads.internal.exoplayer2.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.upstream.DataSource> */
    public C2154aU(Context context, HX<? super HC> hx, HC hc) {
        this.A07 = context.getApplicationContext();
        this.A09 = hx;
        this.A08 = (HC) C1662Hr.A01(hc);
    }

    private HC A00() {
        if (this.A00 == null) {
            this.A00 = new C2147aN(this.A07, this.A09);
        }
        return this.A00;
    }

    private HC A01() {
        if (this.A01 == null) {
            this.A01 = new C2150aQ(this.A07, this.A09);
        }
        HC hc = this.A01;
        if (A0B[4].length() != 17) {
            throw new RuntimeException();
        }
        String[] strArr = A0B;
        strArr[7] = "5KWAQaHsfffdQGrIbOe";
        strArr[7] = "5KWAQaHsfffdQGrIbOe";
        return hc;
    }

    private HC A02() {
        if (this.A02 == null) {
            this.A02 = new C2151aR();
        }
        return this.A02;
    }

    private HC A03() {
        if (this.A04 == null) {
            this.A04 = new C2158aY(this.A09);
        }
        return this.A04;
    }

    private HC A04() {
        if (this.A05 == null) {
            this.A05 = new C2170ak(this.A07, this.A09);
        }
        return this.A05;
    }

    private HC A05() {
        if (this.A06 == null) {
            try {
                this.A06 = (HC) Class.forName(A06(141, 60, 75)).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException unused) {
                Log.w(A06(85, 17, 126), A06(15, 70, 102));
            } catch (Exception e2) {
                throw new RuntimeException(A06(102, 34, 48), e2);
            }
            if (this.A06 == null) {
                this.A06 = this.A08;
            }
        }
        return this.A06;
    }

    @Override // com.facebook.ads.redexgen.X.HC
    public final Uri A7J() {
        HC hc = this.A03;
        if (hc == null) {
            return null;
        }
        return hc.A7J();
    }

    @Override // com.facebook.ads.redexgen.X.HC
    public final long ABi(HG hg) throws IOException {
        C1662Hr.A04(this.A03 == null);
        String scheme = hg.A04.getScheme();
        if (IW.A0f(hg.A04)) {
            if (hg.A04.getPath().startsWith(A06(0, 15, 23))) {
                this.A03 = A00();
            } else {
                this.A03 = A03();
            }
        } else if (A06(136, 5, 28).equals(scheme)) {
            this.A03 = A00();
        } else if (A06(201, 7, 125).equals(scheme)) {
            this.A03 = A01();
        } else if (A06(223, 4, 66).equals(scheme)) {
            this.A03 = A05();
        } else if (A06(208, 4, 94).equals(scheme)) {
            this.A03 = A02();
        } else {
            if (A0B[7].length() != 19) {
                throw new RuntimeException();
            }
            String[] strArr = A0B;
            strArr[6] = "D4NYqGk09rVUGFQV4qQWMtXs9QaZTkcz";
            strArr[2] = "qnlKhzyemJcEWBYVQAP4EuZEjLdcMELi";
            if (A06(212, 11, 63).equals(scheme)) {
                this.A03 = A04();
            } else {
                this.A03 = this.A08;
            }
        }
        return this.A03.ABi(hg);
    }

    @Override // com.facebook.ads.redexgen.X.HC
    public final void close() throws IOException {
        HC hc = this.A03;
        if (hc != null) {
            try {
                hc.close();
            } finally {
                this.A03 = null;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.HC
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        return this.A03.read(bArr, i, i2);
    }
}
