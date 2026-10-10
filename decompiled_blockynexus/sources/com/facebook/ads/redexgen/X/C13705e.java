package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5e, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C13705e {

    @Nullable
    public static InterfaceC13715f A00;
    public static boolean A01;
    public static byte[] A02;
    public static String[] A03;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 25);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-24, -21, -12, -23, -18, -13, -25, -8, -15};
    }

    public static void A03() {
        A03 = new String[]{"dhICO", "mxKq80OLCiD", "i2W9TrIDW1srZxkJxV7foM0MgZvVXbWR", "HI2hESQONWq4EaTE0poPF0OJaSIxJaLc", "DAl184VBvvXhRHJ82dj3bqQv5TXH8TG3", "HKaWDYwPLWKyKiUqhpuc4RGInXEUU", "cSOfcLeIkAX6sPpwLxmVuA24IrFfyR3p", "KnRyMDjzSPNAoacBq98iQYDM8U9nlYJB"};
    }

    static {
        A03();
        A02();
        A01 = false;
        A00 = null;
    }

    public static void A01() {
        synchronized (C13705e.class) {
            if (A00 == null) {
                return;
            }
            C8Z c8z = new C8Z(A00.ACm());
            c8z.A03(1);
            C2027Wc sdkContext = AnonymousClass86.A00();
            if (sdkContext != null) {
                sdkContext.A04().A8H(A00(0, 9, 109), 3401, c8z);
            }
            InterfaceC13715f interfaceC13715f = A00;
            if (A03[1].length() != 11) {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[3] = "kDYng9EYBsgXNgOEIL1h1gMPzmVJxAMa";
            strArr[6] = "TYxT1mxIdvKOfg1hbfM6O4XMHE5Nitia";
            interfaceC13715f.reset();
        }
    }

    public static void A04(final long j) {
        if (j > 0) {
            A00 = new TH();
            new Thread(j) { // from class: com.facebook.ads.redexgen.X.5g
                public final long A00;

                {
                    this.A00 = j;
                    start();
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() throws Throwable {
                    if (KL.A02(this)) {
                        return;
                    }
                    while (true) {
                        try {
                            try {
                                Thread.sleep(this.A00);
                            } catch (Throwable th) {
                                KL.A00(th, this);
                                return;
                            }
                        } catch (InterruptedException unused) {
                        }
                        C13705e.A01();
                    }
                }
            };
        }
    }
}
