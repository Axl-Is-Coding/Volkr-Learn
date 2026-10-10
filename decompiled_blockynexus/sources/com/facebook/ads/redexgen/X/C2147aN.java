package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aN, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2147aN implements HC {
    public static byte[] A06;
    public static String[] A07;
    public long A00;
    public Uri A01;
    public InputStream A02;
    public boolean A03;
    public final AssetManager A04;
    public final HX<? super C2147aN> A05;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 54);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{107, 98, 44, 35, 41, Utf8.REPLACEMENT_BYTE, 34, 36, 41, 18, 44, 62, 62, 40, 57, 98};
    }

    public static void A02() {
        A07 = new String[]{"pM08nT1ncmNJ", "g85", "nscQf0o4Li7UcF904CUq0pnhLdimh0nx", "F8VXv1qVoFp68OVo6WPqVPomjNx", "ZQ8cSAnJS", "Qhc2B", "YeRFTalD9", "SLGuxMrf5R7JWBKvcRLC7wUDDVq2YQ4u"};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.HX != com.facebook.ads.internal.exoplayer2.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.upstream.AssetDataSource> */
    public C2147aN(Context context, HX<? super C2147aN> hx) {
        this.A04 = context.getAssets();
        this.A05 = hx;
    }

    @Override // com.facebook.ads.redexgen.X.HC
    public final Uri A7J() {
        return this.A01;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0098 A[Catch: IOException -> 0x00c3, TRY_ENTER, TryCatch #0 {IOException -> 0x00c3, blocks: (B:2:0x0000, B:4:0x001a, B:5:0x0020, B:15:0x0069, B:24:0x009d, B:26:0x00af, B:23:0x0098, B:32:0x00bd, B:33:0x00c2, B:6:0x0033, B:8:0x0041), top: B:37:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009d A[Catch: IOException -> 0x00c3, TryCatch #0 {IOException -> 0x00c3, blocks: (B:2:0x0000, B:4:0x001a, B:5:0x0020, B:15:0x0069, B:24:0x009d, B:26:0x00af, B:23:0x0098, B:32:0x00bd, B:33:0x00c2, B:6:0x0033, B:8:0x0041), top: B:37:0x0000 }] */
    @Override // com.facebook.ads.redexgen.X.HC
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long ABi(com.facebook.ads.redexgen.X.HG r9) throws com.facebook.ads.redexgen.X.H5 {
        /*
            Method dump skipped, instruction units count: 202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2147aN.ABi(com.facebook.ads.redexgen.X.HG):long");
    }

    @Override // com.facebook.ads.redexgen.X.HC
    public final void close() throws H5 {
        this.A01 = null;
        try {
            try {
                if (this.A02 != null) {
                    this.A02.close();
                }
            } catch (IOException e2) {
                throw new H5(e2);
            }
        } finally {
            this.A02 = null;
            if (this.A03) {
                this.A03 = false;
                HX<? super C2147aN> hx = this.A05;
                if (hx != null) {
                    hx.ABS(this);
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.HC
    public final int read(byte[] bArr, int i, int i2) throws H5 {
        if (i2 == 0) {
            return 0;
        }
        long j = this.A00;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e2) {
                throw new H5(e2);
            }
        }
        int i3 = this.A02.read(bArr, i, i2);
        if (i3 == -1) {
            if (this.A00 == -1) {
                return -1;
            }
            throw new H5(new EOFException());
        }
        long j2 = this.A00;
        if (j2 != -1) {
            this.A00 = j2 - ((long) i3);
        }
        HX<? super C2147aN> hx = this.A05;
        if (hx != null) {
            hx.A9N(this, i3);
        }
        return i3;
    }
}
