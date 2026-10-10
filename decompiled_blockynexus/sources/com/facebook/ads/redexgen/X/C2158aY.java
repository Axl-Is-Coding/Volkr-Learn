package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aY, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2158aY implements HC {
    public static byte[] A05;
    public static String[] A06;
    public long A00;
    public Uri A01;
    public RandomAccessFile A02;
    public boolean A03;
    public final HX<? super C2158aY> A04;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 31);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{37};
    }

    public static void A02() {
        A06 = new String[]{"l2rBvT9KAEY6yl2SIp", "0cRN39km0cT", "q9WvQr", "pX7zul93kCJ6F7tIXqRnEpKrjeNmhaPh", "ddKujtHDPllkfb3cyYepVcXFvJyDikdo", "gNoa3Z", "AdKzyhJyCrP", "aoyUT4m5l2MLf3LhSWprSpj54sdxW1uC"};
    }

    public C2158aY() {
        this(null);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.HX != com.facebook.ads.internal.exoplayer2.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.upstream.FileDataSource> */
    public C2158aY(HX<? super C2158aY> hx) {
        this.A04 = hx;
    }

    @Override // com.facebook.ads.redexgen.X.HC
    public final Uri A7J() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.HC
    public final long ABi(HG hg) throws HJ {
        try {
            this.A01 = hg.A04;
            this.A02 = new RandomAccessFile(hg.A04.getPath(), A00(0, 1, 72));
            this.A02.seek(hg.A03);
            this.A00 = hg.A02 == -1 ? this.A02.length() - hg.A03 : hg.A02;
            if (this.A00 >= 0) {
                this.A03 = true;
                HX<? super C2158aY> hx = this.A04;
                if (hx != null) {
                    hx.ABT(this, hg);
                }
                long j = this.A00;
                if (A06[0].length() != 18) {
                    throw new RuntimeException();
                }
                String[] strArr = A06;
                strArr[7] = "qz0up6ppIELboyns2CZBgMvSr8RDOOhA";
                strArr[3] = "iQKzkqELqDYakLKWZdfSUnFo9DHl6nVv";
                return j;
            }
            throw new EOFException();
        } catch (IOException e2) {
            throw new HJ(e2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.HC
    public final void close() throws HJ {
        this.A01 = null;
        try {
            try {
                if (this.A02 != null) {
                    this.A02.close();
                }
            } catch (IOException e2) {
                throw new HJ(e2);
            }
        } finally {
            this.A02 = null;
            if (this.A03) {
                this.A03 = false;
                HX<? super C2158aY> hx = this.A04;
                if (hx != null) {
                    hx.ABS(this);
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.HC
    public final int read(byte[] bArr, int i, int i2) throws HJ {
        if (i2 == 0) {
            return 0;
        }
        long j = this.A00;
        if (j == 0) {
            return -1;
        }
        try {
            int i3 = this.A02.read(bArr, i, (int) Math.min(j, i2));
            if (i3 > 0) {
                this.A00 -= (long) i3;
                HX<? super C2158aY> hx = this.A04;
                if (hx != null) {
                    hx.A9N(this, i3);
                }
            }
            return i3;
        } catch (IOException e2) {
            throw new HJ(e2);
        }
    }
}
