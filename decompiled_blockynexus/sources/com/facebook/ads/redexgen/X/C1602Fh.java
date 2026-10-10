package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1602Fh {
    public static String[] A05;
    public static final C1602Fh A06;
    public final int A00;
    public final long A01;
    public final long A02;
    public final long[] A03;
    public final C1600Ff[] A04;

    public static void A00() {
        A05 = new String[]{"mUl0ad45", "wOnHxFom99khzfrw556TP2S7iTnXdaDI", "F2b18zOkBdzPS6Rw7y0xeVy", "72pK6LdfIPudsj2MuQDeavvJ5e506zcn", "15GKEV160LP26gLZR3RCLRKabW82Co", "R2OsGPNc82TrpFQIYzL", "mRreVGJS4QtDd4oKVCrkQCvx0ML", "uB3KfkVK117X08r1dhVcVjbfa1nPKP9i"};
    }

    static {
        A00();
        A06 = new C1602Fh(new long[0]);
    }

    public C1602Fh(long... jArr) {
        int length = jArr.length;
        this.A00 = length;
        this.A03 = Arrays.copyOf(jArr, length);
        this.A04 = new C1600Ff[length];
        for (int i = 0; i < length; i++) {
            this.A04[i] = new C1600Ff();
        }
        this.A01 = 0L;
        this.A02 = -9223372036854775807L;
    }

    public final int A01(long j) {
        int i = 0;
        while (true) {
            long[] jArr = this.A03;
            if (i >= jArr.length) {
                break;
            }
            long j2 = jArr[i];
            String[] strArr = A05;
            if (strArr[7].charAt(26) != strArr[1].charAt(26)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[4] = "npAqm7bEBhy427JdaT1Ni0I7koiD7S";
            strArr2[6] = "tFKaeO8lP01t1nMB1y4UInduFYw";
            if (j2 == Long.MIN_VALUE) {
                break;
            }
            if (j < jArr[i]) {
                C1600Ff[] c1600FfArr = this.A04;
                String[] strArr3 = A05;
                if (strArr3[2].length() != strArr3[5].length()) {
                    String[] strArr4 = A05;
                    strArr4[7] = "Q7qi9RXitykg8APizUDlkxccyVnHWt3u";
                    strArr4[1] = "mzuq9lDyRMMzUIbIxWm25ivrGAnK4SRi";
                    if (c1600FfArr[i].A02()) {
                        break;
                    }
                } else {
                    String[] strArr5 = A05;
                    strArr5[3] = "GUT9witaJOdRyBBc2tjzvJfymhz5uMqF";
                    strArr5[3] = "GUT9witaJOdRyBBc2tjzvJfymhz5uMqF";
                    if (c1600FfArr[i].A02()) {
                        break;
                    }
                }
            }
            i++;
        }
        if (i < this.A03.length) {
            return i;
        }
        return -1;
    }

    public final int A02(long j) {
        int length = this.A03.length - 1;
        while (length >= 0) {
            long[] jArr = this.A03;
            if (jArr[length] != Long.MIN_VALUE && jArr[length] <= j) {
                break;
            }
            length--;
        }
        if (length < 0 || !this.A04[length].A02()) {
            return -1;
        }
        return length;
    }
}
