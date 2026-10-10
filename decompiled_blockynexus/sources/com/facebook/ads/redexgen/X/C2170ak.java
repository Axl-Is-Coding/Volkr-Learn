package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
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
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ak, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2170ak implements HC {
    public static byte[] A07;
    public static String[] A08;
    public long A00;
    public AssetFileDescriptor A01;
    public Uri A02;
    public InputStream A03;
    public boolean A04;
    public final Resources A05;
    public final HX<? super C2170ak> A06;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 108);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A07 = new byte[]{70, 113, 103, 123, 97, 102, 119, 113, 52, 125, 112, 113, 122, 96, 125, 114, 125, 113, 102, 52, 121, 97, 103, 96, 52, 118, 113, 52, 117, 122, 52, 125, 122, 96, 113, 115, 113, 102, 58, 7, 0, 27, 114, Utf8.REPLACEMENT_BYTE, 39, 33, 38, 114, 39, 33, 55, 114, 33, 49, 58, 55, Utf8.REPLACEMENT_BYTE, 55, 114, 32, 51, 37, 32, 55, 33, 61, 39, 32, 49, 55, 117, 102, 112, 117, 98, 116, 104, 114, 117, 100, 98};
    }

    public static void A02() {
        A08 = new String[]{"bSKnstrcEyUtH2EUzSuh7p", "TJp7broMG9ALkddxCeG8bg", "OUGN6fd13DTUK57USEtQiA6N8BMR4vG7", "MPCQ8AeafYWdEx3u0S1dfC5VpPwXU5er", "I2tJ7ud2NszgocKkHkmClXbQ6vlHE0Sp", "WRhnMtRu3VoUyGpCORxDhLZcb6GbN7Pt", "ionJv1BxfCrQS8AxzLJ8Tcnsr6gm7Nx1", "YblFDiTYESfr8ZIRtB8BAyjauKLHc0qm"};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.HX != com.facebook.ads.internal.exoplayer2.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.upstream.RawResourceDataSource> */
    public C2170ak(Context context, HX<? super C2170ak> hx) {
        this.A05 = context.getResources();
        this.A06 = hx;
    }

    @Override // com.facebook.ads.redexgen.X.HC
    public final Uri A7J() {
        return this.A02;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a3 A[Catch: IOException -> 0x0114, TRY_ENTER, TryCatch #1 {IOException -> 0x0114, blocks: (B:2:0x0000, B:4:0x001a, B:5:0x0024, B:12:0x0076, B:21:0x00a8, B:23:0x00b2, B:24:0x00b5, B:20:0x00a3, B:34:0x00ef, B:35:0x00f4, B:38:0x0104, B:39:0x0113, B:36:0x00f5, B:37:0x0103), top: B:45:0x0000, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a8 A[Catch: IOException -> 0x0114, TryCatch #1 {IOException -> 0x0114, blocks: (B:2:0x0000, B:4:0x001a, B:5:0x0024, B:12:0x0076, B:21:0x00a8, B:23:0x00b2, B:24:0x00b5, B:20:0x00a3, B:34:0x00ef, B:35:0x00f4, B:38:0x0104, B:39:0x0113, B:36:0x00f5, B:37:0x0103), top: B:45:0x0000, inners: #0 }] */
    @Override // com.facebook.ads.redexgen.X.HC
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long ABi(com.facebook.ads.redexgen.X.HG r8) throws com.facebook.ads.redexgen.X.HW {
        /*
            Method dump skipped, instruction units count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2170ak.ABi(com.facebook.ads.redexgen.X.HG):long");
    }

    @Override // com.facebook.ads.redexgen.X.HC
    public final void close() throws HW {
        this.A02 = null;
        try {
            try {
                if (this.A03 != null) {
                    this.A03.close();
                }
                this.A03 = null;
            } catch (Throwable th) {
                this.A03 = null;
                try {
                    try {
                        if (this.A01 != null) {
                            this.A01.close();
                        }
                        this.A01 = null;
                        if (this.A04) {
                            this.A04 = false;
                            HX<? super C2170ak> hx = this.A06;
                            if (hx != null) {
                                hx.ABS(this);
                            }
                        }
                        throw th;
                    } catch (IOException e2) {
                        throw new HW(e2);
                    }
                } finally {
                    this.A01 = null;
                    if (this.A04) {
                        this.A04 = false;
                        HX<? super C2170ak> hx2 = this.A06;
                        if (hx2 != null) {
                            hx2.ABS(this);
                        }
                    }
                }
            }
            try {
                try {
                    if (this.A01 != null) {
                        this.A01.close();
                    }
                } catch (IOException e3) {
                    throw new HW(e3);
                }
            } finally {
                this.A01 = null;
                if (this.A04) {
                    this.A04 = false;
                    HX<? super C2170ak> hx3 = this.A06;
                    if (hx3 != null) {
                        hx3.ABS(this);
                    }
                }
            }
        } catch (IOException e4) {
            throw new HW(e4);
        }
    }

    @Override // com.facebook.ads.redexgen.X.HC
    public final int read(byte[] bArr, int i, int i2) throws HW {
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
                throw new HW(e2);
            }
        }
        int i3 = this.A03.read(bArr, i, i2);
        if (i3 == -1) {
            if (this.A00 == -1) {
                return -1;
            }
            throw new HW(new EOFException());
        }
        long j2 = this.A00;
        if (j2 != -1) {
            this.A00 = j2 - ((long) i3);
        }
        HX<? super C2170ak> hx = this.A06;
        if (hx != null) {
            hx.A9N(this, i3);
        }
        return i3;
    }
}
