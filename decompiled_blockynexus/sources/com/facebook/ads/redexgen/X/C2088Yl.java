package com.facebook.ads.redexgen.X;

import com.umeng.analytics.pro.ci;
import java.io.IOException;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2088Yl implements CA {
    public static byte[] A04;
    public static String[] A05;
    public static final CD A06;
    public static final int A07;
    public boolean A00;
    public final long A01;
    public final C2089Ym A02;
    public final IG A03;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 57);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{ci.m, 2, 117};
    }

    public static void A02() {
        A05 = new String[]{"P5w0t5YmbfCx1ojda5KKDsEMO6jqUmnr", "UdOatSKcJailVD", "", "xAiF", "epl8GGi5jyNsT2QZHjLNLopZqyhNzplR", "TY8pRi4pa4JcG30Kuv61m", "fOMFGQDuqjq2usuY2YJ2oGF", "ObZwfJQfEiVxl"};
    }

    static {
        A02();
        A01();
        A06 = new C2087Yk();
        A07 = IW.A08(A00(0, 3, 127));
    }

    public C2088Yl() {
        this(0L);
    }

    public C2088Yl(long j) {
        this.A01 = j;
        this.A02 = new C2089Ym();
        this.A03 = new IG(2786);
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final void A7e(CC cc) {
        this.A02.A4U(cc, new DU(0, 1));
        cc.A54();
        cc.AD3(new YB(-9223372036854775807L));
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final int ACG(CB cb, CH ch) throws InterruptedException, IOException {
        int i = cb.read(this.A03.A00, 0, 2786);
        if (i == -1) {
            return -1;
        }
        this.A03.A0Z(0);
        this.A03.A0Y(i);
        if (!this.A00) {
            this.A02.ABp(this.A01, true);
            this.A00 = true;
        }
        this.A02.A48(this.A03);
        return 0;
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final void AD2(long j, long j2) {
        this.A00 = false;
        this.A02.AD1();
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final boolean ADa(CB cb) throws InterruptedException, IOException {
        IG ig = new IG(10);
        int i = 0;
        while (true) {
            cb.ABs(ig.A00, 0, 10);
            if (A05[7].length() != 13) {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[5] = "IuOldmz1qGC5b";
            strArr[5] = "IuOldmz1qGC5b";
            ig.A0Z(0);
            if (ig.A0H() != A07) {
                cb.ACt();
                cb.A3M(i);
                int validFramesCount = i;
                int i2 = 0;
                while (true) {
                    cb.ABs(ig.A00, 0, 5);
                    ig.A0Z(0);
                    if (ig.A0J() != 2935) {
                        i2 = 0;
                        cb.ACt();
                        validFramesCount++;
                        if (validFramesCount - i >= 8192) {
                            return false;
                        }
                        cb.A3M(validFramesCount);
                    } else {
                        i2++;
                        if (A05[5].length() != 29) {
                            String[] strArr2 = A05;
                            strArr2[3] = "a4rI";
                            strArr2[6] = "EnE3h5gngskpWhoTVRGnZEO";
                            if (i2 >= 4) {
                                return true;
                            }
                        } else if (i2 >= 4) {
                            return true;
                        }
                        int iA05 = C1492Ai.A05(ig.A00);
                        if (iA05 == -1) {
                            return false;
                        }
                        int syncBytes = iA05 - 5;
                        cb.A3M(syncBytes);
                    }
                }
            } else {
                ig.A0a(3);
                int iA0E = ig.A0E();
                int syncBytes2 = iA0E + 10;
                i += syncBytes2;
                cb.A3M(iA0E);
            }
        }
    }
}
