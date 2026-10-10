package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2111Zj implements HP {
    public static String[] A0C;
    public long A00;
    public long A02;
    public HG A03;
    public final Uri A05;
    public final F2 A07;
    public final HC A08;
    public final C1668Hx A09;
    public volatile boolean A0A;
    public final /* synthetic */ C1499Ap A0B;
    public final CH A06 = new CH();
    public boolean A04 = true;
    public long A01 = -1;

    static {
        A04();
    }

    public static void A04() {
        A0C = new String[]{"nBGgOhUJr5w54zk2FcSY", "YYZuUd", "gwBohD1o6c6DfEcFdJm47xfjaEoVukk3", "3TNnSL", "hJWvKqQqk09hkKqv49F3L8Ilz7Jhye22", "G8FOHrMAxxSNQBngbaVWxtAhYQnldn5N", "v6FRbmkBAKb4FwdIpHjrHHJWg4k1tULi", "7hirQzfzNIRD79h7knAyc8"};
    }

    public C2111Zj(C1499Ap c1499Ap, Uri uri, HC hc, F2 f2, C1668Hx c1668Hx) {
        this.A0B = c1499Ap;
        this.A05 = (Uri) C1662Hr.A01(uri);
        this.A08 = (HC) C1662Hr.A01(hc);
        this.A07 = (F2) C1662Hr.A01(f2);
        this.A09 = c1668Hx;
    }

    public final void A05(long j, long j2) {
        this.A06.A00 = j;
        this.A02 = j2;
        this.A04 = true;
    }

    @Override // com.facebook.ads.redexgen.X.HP
    public final void A3y() {
        this.A0A = true;
    }

    @Override // com.facebook.ads.redexgen.X.HP
    public final void A84() throws InterruptedException, IOException {
        int iACG = 0;
        while (iACG == 0) {
            boolean z = this.A0A;
            if (A0C[0].length() == 9) {
                throw new RuntimeException();
            }
            String[] strArr = A0C;
            strArr[3] = "6lKOSY";
            strArr[1] = "aO7eUD";
            if (!z) {
                CB cb = null;
                try {
                    long jA6t = this.A06.A00;
                    this.A03 = new HG(this.A05, jA6t, -1L, this.A0B.A0b);
                    this.A01 = this.A08.ABi(this.A03);
                    if (this.A01 != -1) {
                        this.A01 += jA6t;
                    }
                    Y7 y7 = new Y7(this.A08, jA6t, this.A01);
                    CA caA03 = this.A07.A03(y7, this.A08.A7J());
                    if (this.A04) {
                        caA03.AD2(jA6t, this.A02);
                        this.A04 = false;
                    }
                    while (iACG == 0 && !this.A0A) {
                        this.A09.A01();
                        iACG = caA03.ACG(y7, this.A06);
                        if (y7.A6t() > this.A0B.A0P + jA6t) {
                            jA6t = y7.A6t();
                            this.A09.A02();
                            this.A0B.A0R.post(this.A0B.A0a);
                        }
                    }
                    if (iACG == 1) {
                        iACG = 0;
                    } else {
                        this.A06.A00 = y7.A6t();
                        this.A00 = this.A06.A00 - this.A03.A01;
                    }
                    IW.A0X(this.A08);
                } catch (Throwable th) {
                    if (iACG != 1 && 0 != 0) {
                        this.A06.A00 = cb.A6t();
                        this.A00 = this.A06.A00 - this.A03.A01;
                    }
                    IW.A0X(this.A08);
                    throw th;
                }
            } else {
                return;
            }
        }
    }
}
