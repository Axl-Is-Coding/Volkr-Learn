package com.facebook.ads.redexgen.X;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aQ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2150aQ implements HC {
    public static byte[] A07;
    public static String[] A08;
    public long A00;
    public AssetFileDescriptor A01;
    public Uri A02;
    public FileInputStream A03;
    public boolean A04;
    public final ContentResolver A05;
    public final HX<? super C2150aQ> A06;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 116);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A07 = new byte[]{-38, 6, 12, 3, -5, -73, 5, 6, 11, -73, 6, 7, -4, 5, -73, -3, 0, 3, -4, -73, -5, -4, 10, -6, 9, 0, 7, 11, 6, 9, -73, -3, 6, 9, -47, -73, -14};
    }

    public static void A02() {
        A08 = new String[]{"XY5JZk6rXZ0NPH7SICFbrzLAUaQN4bdH", "HnCNMjQ424yFS", "kyBc0", "GnRsDPDWJf0qkzwG5UAakx0LVXBsKD8t", "8DLCIs9NQKYqN", "T4UYq1MMo7qynT2Sse3Gz88uK5Ayy8ub", "yyLccmqAJUyLoqB1F9xK1icYlgZtX35P", "UgvPXgEXHuOjKzkqR3R9kUCYtrFgRRdg"};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.HX != com.facebook.ads.internal.exoplayer2.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.upstream.ContentDataSource> */
    public C2150aQ(Context context, HX<? super C2150aQ> hx) {
        this.A05 = context.getContentResolver();
        this.A06 = hx;
    }

    @Override // com.facebook.ads.redexgen.X.HC
    public final Uri A7J() {
        return this.A02;
    }

    @Override // com.facebook.ads.redexgen.X.HC
    public final long ABi(HG hg) throws H8 {
        try {
            this.A02 = hg.A04;
            this.A01 = this.A05.openAssetFileDescriptor(this.A02, A00(36, 1, 12));
            if (this.A01 != null) {
                this.A03 = new FileInputStream(this.A01.getFileDescriptor());
                long startOffset = this.A01.getStartOffset();
                long jSkip = this.A03.skip(hg.A03 + startOffset) - startOffset;
                long skipped = hg.A03;
                String[] strArr = A08;
                if (strArr[1].length() != strArr[4].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A08;
                strArr2[2] = "hKUpJ";
                strArr2[2] = "hKUpJ";
                if (jSkip == skipped) {
                    long assetFileDescriptorLength = -1;
                    if (hg.A02 != -1) {
                        long skipped2 = hg.A02;
                        this.A00 = skipped2;
                    } else {
                        long length = this.A01.getLength();
                        if (length == -1) {
                            FileChannel channel = this.A03.getChannel();
                            long size = channel.size();
                            if (size != 0) {
                                long channelSize = channel.position();
                                assetFileDescriptorLength = size - channelSize;
                            }
                            this.A00 = assetFileDescriptorLength;
                        } else {
                            this.A00 = length - jSkip;
                        }
                    }
                    this.A04 = true;
                    HX<? super C2150aQ> hx = this.A06;
                    if (hx != null) {
                        hx.ABT(this, hg);
                    }
                    return this.A00;
                }
                throw new EOFException();
            }
            throw new FileNotFoundException(A00(0, 36, 35) + this.A02);
        } catch (IOException e2) {
            throw new H8(e2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.HC
    public final void close() throws H8 {
        int length;
        int i;
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
                    } catch (IOException e2) {
                        throw new H8(e2);
                    }
                } finally {
                    if (length == i) {
                    }
                    throw new RuntimeException();
                }
                if (this.A04) {
                    this.A04 = false;
                    String[] strArr = A08;
                    if (strArr[6].charAt(21) != strArr[3].charAt(21)) {
                        String[] strArr2 = A08;
                        strArr2[5] = "49IvJFCSRSvhrewf7IAXf1OPFzRU50IL";
                        strArr2[0] = "4e2AtDz0XDbCK0xcLVm9895RacU2kPwa";
                        HX<? super C2150aQ> hx = this.A06;
                        if (hx != null) {
                            hx.ABS(this);
                        }
                    }
                    throw new RuntimeException();
                }
                throw th;
            }
            try {
                try {
                    if (this.A01 != null) {
                        this.A01.close();
                    }
                } catch (IOException e3) {
                    throw new H8(e3);
                }
            } finally {
                this.A01 = null;
                if (this.A04) {
                    this.A04 = false;
                    HX<? super C2150aQ> hx2 = this.A06;
                    if (hx2 != null) {
                        hx2.ABS(this);
                    }
                }
            }
        } catch (IOException e4) {
            throw new H8(e4);
        }
    }

    @Override // com.facebook.ads.redexgen.X.HC
    public final int read(byte[] bArr, int i, int i2) throws H8 {
        if (i2 == 0) {
            return 0;
        }
        long j = this.A00;
        if (A08[7].charAt(11) != 'j') {
            throw new RuntimeException();
        }
        String[] strArr = A08;
        strArr[1] = "ibErvL6ImcJTe";
        strArr[4] = "i4reTFCBluewh";
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e2) {
                throw new H8(e2);
            }
        }
        int i3 = this.A03.read(bArr, i, i2);
        if (i3 == -1) {
            if (this.A00 == -1) {
                return -1;
            }
            throw new H8(new EOFException());
        }
        long j2 = this.A00;
        if (j2 != -1) {
            this.A00 = j2 - ((long) i3);
        }
        HX<? super C2150aQ> hx = this.A06;
        if (hx != null) {
            hx.A9N(this, i3);
        }
        return i3;
    }
}
