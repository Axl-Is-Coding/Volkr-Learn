package com.facebook.ads.redexgen.X;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ao, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2174ao implements HA {
    public static String[] A0B;
    public long A00;
    public long A01;
    public HG A02;
    public IN A03;
    public File A04;
    public FileOutputStream A05;
    public OutputStream A06;
    public final int A07;
    public final long A08;
    public final InterfaceC1646Hb A09;
    public final boolean A0A;

    static {
        A02();
    }

    public static void A02() {
        A0B = new String[]{"w20bAWjYMNQBWlbon1lxwLvvC2Wc6aDw", "lwUY3oAzCyDGvzazHVXOHQ3zY7kbNweW", "UaweMkDBVxVyODuJAIk0oAizBiXulMgw", "HCwWhWYnSwS9lU8hovQ66gM", "BSrpyguVpFJpaQafc1NdT7mO3uIgLmFW", "PMiNqiQ4kgs0VWuHsJy6tm47yNuoSJAG", "LFxM2Smyc2PeWHZihlec1nFmzNKIeMAJ", "CwFpegEhQfdxfTMnj3Ot7m2"};
    }

    public C2174ao(InterfaceC1646Hb interfaceC1646Hb, long j) {
        this(interfaceC1646Hb, j, 20480, true);
    }

    public C2174ao(InterfaceC1646Hb interfaceC1646Hb, long j, int i, boolean z) {
        this.A09 = (InterfaceC1646Hb) C1662Hr.A01(interfaceC1646Hb);
        this.A08 = j;
        this.A07 = i;
        this.A0A = z;
    }

    private void A00() throws IOException {
        OutputStream outputStream = this.A06;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            boolean success = this.A0A;
            if (success) {
                this.A05.getFD().sync();
            }
            IW.A0Y(this.A06);
            this.A06 = null;
            File file = this.A04;
            this.A04 = null;
            if (1 != 0) {
                this.A09.A44(file);
            } else {
                file.delete();
            }
        } catch (Throwable th) {
            IW.A0Y(this.A06);
            this.A06 = null;
            File file2 = this.A04;
            this.A04 = null;
            if (0 != 0) {
                this.A09.A44(file2);
            } else {
                file2.delete();
            }
            throw th;
        }
    }

    private void A01() throws IOException {
        long jMin;
        if (this.A02.A02 == -1) {
            jMin = this.A08;
        } else {
            long j = this.A02.A02;
            long maxLength = this.A00;
            long j2 = j - maxLength;
            long maxLength2 = this.A08;
            jMin = Math.min(j2, maxLength2);
        }
        InterfaceC1646Hb interfaceC1646Hb = this.A09;
        String str = this.A02.A05;
        long maxLength3 = this.A02.A01;
        this.A04 = interfaceC1646Hb.ADc(str, this.A00 + maxLength3, jMin);
        this.A05 = new FileOutputStream(this.A04);
        int i = this.A07;
        if (i > 0) {
            IN in = this.A03;
            if (in == null) {
                this.A03 = new IN(this.A05, i);
            } else {
                in.A00(this.A05);
            }
            this.A06 = this.A03;
        } else {
            this.A06 = this.A05;
        }
        this.A01 = 0L;
    }

    @Override // com.facebook.ads.redexgen.X.HA
    public final void ABk(HG hg) throws C2173an {
        if (hg.A02 == -1 && !hg.A02(2)) {
            this.A02 = null;
            return;
        }
        this.A02 = hg;
        this.A00 = 0L;
        try {
            A01();
        } catch (IOException e2) {
            throw new C2173an(e2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.HA
    public final void close() throws C2173an {
        if (this.A02 == null) {
            return;
        }
        try {
            A00();
        } catch (IOException e2) {
            throw new C2173an(e2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.HA
    public final void write(byte[] bArr, int bytesToWrite, int i) throws C2173an {
        if (this.A02 == null) {
            return;
        }
        int i2 = 0;
        while (i2 < i) {
            try {
                long j = this.A01;
                long j2 = this.A08;
                if (A0B[0].charAt(30) != 'D') {
                    throw new RuntimeException();
                }
                String[] strArr = A0B;
                strArr[6] = "jgYsfafqQwydOQ8BdugE0IR3OVOgVMqo";
                strArr[6] = "jgYsfafqQwydOQ8BdugE0IR3OVOgVMqo";
                if (j == j2) {
                    A00();
                    A01();
                }
                int iMin = (int) Math.min(i - i2, this.A08 - this.A01);
                this.A06.write(bArr, bytesToWrite + i2, iMin);
                i2 += iMin;
                this.A01 += (long) iMin;
                this.A00 += (long) iMin;
            } catch (IOException e2) {
                throw new C2173an(e2);
            }
        }
    }
}
