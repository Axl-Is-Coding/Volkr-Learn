package com.facebook.ads.redexgen.X;

import java.io.IOException;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2091Yo implements CA {
    public static byte[] A04;
    public static String[] A05;
    public static final CD A06;
    public static final int A07;
    public boolean A00;
    public final long A01;
    public final C2092Yp A02;
    public final IG A03;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 120);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{27, 22, 97};
    }

    public static void A02() {
        A05 = new String[]{"6Yd3MlxO6zs0On0JMF5Pwnois3aNTjpE", "MmQBoaYzrmdPmtEAYQ3R1Y6Mcsh6By7B", "7RUBoC8KCwVWfiCX9SWb", "GS41ND25W7ytYawGpGonJQP9IOOENLXr", "lL4oomLzy5vPLaNFQ0K", "J26", "emQAR3GMgLzBn72fJq6a", "GcSIxJRAUXsHB0u2DOmppTTbOqtsj228"};
    }

    static {
        A02();
        A01();
        A06 = new C2090Yn();
        A07 = IW.A08(A00(0, 3, 42));
    }

    public C2091Yo() {
        this(0L);
    }

    public C2091Yo(long j) {
        this.A01 = j;
        this.A02 = new C2092Yp(true);
        this.A03 = new IG(200);
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final void A7e(CC cc) {
        this.A02.A4U(cc, new DU(0, 1));
        cc.A54();
        cc.AD3(new YB(-9223372036854775807L));
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final int ACG(CB cb, CH ch) throws InterruptedException, IOException {
        int i = cb.read(this.A03.A00, 0, 200);
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
        IF r4 = new IF(ig.A00);
        int validFramesCount = 0;
        while (true) {
            cb.ABs(ig.A00, 0, 10);
            ig.A0Z(0);
            if (ig.A0H() != A07) {
                break;
            }
            ig.A0a(3);
            int iA0E = ig.A0E();
            int syncBytes = iA0E + 10;
            validFramesCount += syncBytes;
            cb.A3M(iA0E);
        }
        cb.ACt();
        cb.A3M(validFramesCount);
        int i = validFramesCount;
        int i2 = 0;
        if (A05[4].length() == 20) {
            throw new RuntimeException();
        }
        String[] strArr = A05;
        strArr[1] = "mY90xJHLqPMDpFXgmiZe2UkYD68ZyI7P";
        strArr[1] = "mY90xJHLqPMDpFXgmiZe2UkYD68ZyI7P";
        int startPosition = 0;
        while (true) {
            cb.ABs(ig.A00, 0, 2);
            ig.A0Z(0);
            int syncBytes2 = ig.A0J();
            if ((65526 & syncBytes2) != 65520) {
                startPosition = 0;
                i2 = 0;
                cb.ACt();
                i++;
                if (i - validFramesCount >= 8192) {
                    return false;
                }
                cb.A3M(i);
            } else {
                startPosition++;
                if (startPosition >= 4 && i2 > 188) {
                    return true;
                }
                cb.ABs(ig.A00, 0, 4);
                r4.A08(14);
                int iA05 = r4.A05(13);
                if (iA05 <= 6) {
                    return false;
                }
                int syncBytes3 = iA05 - 6;
                cb.A3M(syncBytes3);
                i2 += iA05;
            }
        }
    }
}
