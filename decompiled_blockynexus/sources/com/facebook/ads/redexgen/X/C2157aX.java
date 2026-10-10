package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.io.IOException;
import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aX, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2157aX implements HC {
    public static byte[] A00;
    public static final HB A01;
    public static final C2157aX A02;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 72);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{10, 59, 51, 51, Utf8.REPLACEMENT_BYTE, -26, 57, 53, 59, 56, 41, 43};
    }

    static {
        A01();
        A02 = new C2157aX();
        A01 = new C2156aW();
    }

    public C2157aX() {
    }

    public /* synthetic */ C2157aX(C2156aW c2156aW) {
        this();
    }

    @Override // com.facebook.ads.redexgen.X.HC
    public final Uri A7J() {
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.HC
    public final long ABi(HG hg) throws IOException {
        throw new IOException(A00(0, 12, 126));
    }

    @Override // com.facebook.ads.redexgen.X.HC
    public final void close() throws IOException {
    }

    @Override // com.facebook.ads.redexgen.X.HC
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        throw new UnsupportedOperationException();
    }
}
