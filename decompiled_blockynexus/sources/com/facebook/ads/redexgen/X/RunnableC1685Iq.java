package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Iq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1685Iq implements Runnable {
    public static String[] A05;
    public final /* synthetic */ float A00;
    public final /* synthetic */ int A01;
    public final /* synthetic */ int A02;
    public final /* synthetic */ int A03;
    public final /* synthetic */ C1688It A04;

    static {
        A00();
    }

    public static void A00() {
        A05 = new String[]{"DJpTE", "hjmigejYKbOgwmfvV1nc5iE8IDOYmXil", "2YKNaj9Qlm", "qxfanbBXI2ZjoCTgG7w8KuDdJjLlXH62", "XtZaZ3wYkBKmpvCnemS2yQk1T2uyfDPG", "Gw99gcoZxN", "lvDFpJS29mpdODJdSJz5AdBwktpN", "hlGH8f80A3YyARPnHLcSnfRHIOI89tOr"};
    }

    public RunnableC1685Iq(C1688It c1688It, int i, int i2, int i3, float f2) {
        this.A04 = c1688It;
        this.A03 = i;
        this.A01 = i2;
        this.A02 = i3;
        this.A00 = f2;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A04.A01.ABf(this.A03, this.A01, this.A02, this.A00);
        } catch (Throwable th) {
            if (A05[0].length() != 5) {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[3] = "OXxSdVemaS9DNqMoLNSyLFOeF9oFC1IL";
            strArr[3] = "OXxSdVemaS9DNqMoLNSyLFOeF9oFC1IL";
            KL.A00(th, this);
        }
    }
}
