package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import com.umeng.analytics.pro.ci;
import java.nio.ByteBuffer;
import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.26, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
@TargetApi(16)
public final class AnonymousClass26 extends C3R implements I7 {
    public static byte[] A0E;
    public static String[] A0F;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public long A05;
    public MediaFormat A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public final Context A0B;
    public final B0 A0C;
    public final B6 A0D;

    static {
        A07();
        A06();
    }

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0E, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 16);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A0E = new byte[]{7, 5, ci.n, 102, 27, ci.k, 11, 102, 41, 41, 43, 102, 44, 45, 43, 65, 67, 86, 32, 105, 97, 97, 105, 98, 107, 32, 124, 111, 121, 32, 106, 107, 109, 97, 106, 107, 124, 54, 57, 51, 37, 56, 62, 51, 121, 36, 56, 49, 35, 32, 54, 37, 50, 121, 59, 50, 54, 57, 53, 54, 52, 60, 64, 84, 69, 72, 78, ci.l, 83, 64, 86, 24, 19, 26, 21, 21, 30, 23, 86, 24, 20, ci.l, 21, ci.m, Utf8.REPLACEMENT_BYTE, 50, 37, 56, 59, 35, 50, 76, 65, 86, 75, 85, 72, 80, 65, 95, 83, 74, 31, 91, 92, 66, 71, 70, 31, 65, 91, 72, 87, 70, 66, 70, 78, 48, 50, 41, 47, 50, 41, 52, 57, 121, 107, 103, 122, 102, 111, 39, 120, 107, 126, 111, 70, 84, 88, 70, 64, 91, 82, 5, 26, ci.k, ci.n, 25, 19, 11, 26};
    }

    public static void A07() {
        A0F = new String[]{"aLXIjAOeq43kD47uUx47KIQfBztZ5JR6", "bYDvuG1CO7Q3NDumZhhBhB8jHe", "lzauC9VKCpzgBdv7KHug0xPju0EyyDRc", "zBmjWuq", "FwqFg", "FmVSMSIXQUSd0OcxsELVimAN3SmZwHxI", "I9K2sHUvqtNZm1Rj9xJMtQcmEPzsJytW", "SRtBuggTCbvw2MXSYfok3SEL95E53gc0"};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bu != com.facebook.ads.internal.exoplayer2.drm.DrmSessionManager<com.facebook.ads.internal.exoplayer2.drm.FrameworkMediaCrypto> */
    public AnonymousClass26(Context context, InterfaceC1553De interfaceC1553De, @Nullable InterfaceC1521Bu<Y1> interfaceC1521Bu, boolean z, @Nullable Handler handler, @Nullable B1 b1, @Nullable C1496Am c1496Am, InterfaceC1502At... interfaceC1502AtArr) {
        this(context, interfaceC1553De, interfaceC1521Bu, z, handler, b1, new C2059Xi(c1496Am, interfaceC1502AtArr));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bu != com.facebook.ads.internal.exoplayer2.drm.DrmSessionManager<com.facebook.ads.internal.exoplayer2.drm.FrameworkMediaCrypto> */
    public AnonymousClass26(Context context, InterfaceC1553De interfaceC1553De, @Nullable InterfaceC1521Bu<Y1> interfaceC1521Bu, boolean z, @Nullable Handler handler, @Nullable B1 b1, B6 b6) {
        super(1, interfaceC1553De, interfaceC1521Bu, z);
        this.A0B = context.getApplicationContext();
        this.A0D = b6;
        this.A0C = new B0(handler, b1);
        b6.ADI(new C2061Xk(this));
    }

    private int A00(DY dy, Format format) {
        PackageManager packageManager;
        if (IW.A02 < 24) {
            if (A04(15, 22, 30).equals(dy.A02)) {
                boolean z = true;
                if (IW.A02 == 23 && (packageManager = this.A0B.getPackageManager()) != null && packageManager.hasSystemFeature(A04(37, 25, 71))) {
                    z = false;
                }
                if (z) {
                    return -1;
                }
            }
        }
        return format.A09;
    }

    private final int A01(DY dy, Format format, Format[] formatArr) {
        return A00(dy, format);
    }

    @SuppressLint({"InlinedApi"})
    private final MediaFormat A02(Format format, String str, int i) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(A04(113, 4, 59), str);
        mediaFormat.setInteger(A04(71, 13, 107), format.A05);
        mediaFormat.setInteger(A04(125, 11, 26), format.A0C);
        C1559Dk.A07(mediaFormat, format.A0P);
        C1559Dk.A05(mediaFormat, A04(99, 14, 34), i);
        if (IW.A02 >= 23) {
            mediaFormat.setInteger(A04(117, 8, 80), 0);
        }
        return mediaFormat;
    }

    private void A05() {
        long jA61 = this.A0D.A61(A7n());
        if (jA61 != Long.MIN_VALUE) {
            if (!this.A08) {
                jA61 = Math.max(this.A05, jA61);
            }
            this.A05 = jA61;
            this.A08 = false;
        }
    }

    public static boolean A09(String str) {
        if (IW.A02 < 24 && A04(0, 15, 88).equals(str)) {
            if (A04(136, 7, 37).equals(IW.A05) && (IW.A03.startsWith(A04(143, 8, 111)) || IW.A03.startsWith(A04(84, 7, 71)) || IW.A03.startsWith(A04(91, 8, 52)))) {
                return true;
            }
        }
        return false;
    }

    private final boolean A0A(String str) {
        int iA00 = I9.A00(str);
        if (iA00 != 0) {
            boolean zA7m = this.A0D.A7m(iA00);
            if (A0F[5].charAt(2) != 'V') {
                throw new RuntimeException();
            }
            String[] strArr = A0F;
            strArr[1] = "OP";
            strArr[1] = "OP";
            if (zA7m) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.C3R, com.facebook.ads.redexgen.X.CT
    public final void A14() {
        try {
            this.A0D.ACW();
            try {
                super.A14();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.A14();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.C3R, com.facebook.ads.redexgen.X.CT
    public final void A15() {
        super.A15();
        this.A0D.ABz();
    }

    @Override // com.facebook.ads.redexgen.X.C3R, com.facebook.ads.redexgen.X.CT
    public final void A16() {
        A05();
        this.A0D.pause();
        super.A16();
    }

    @Override // com.facebook.ads.redexgen.X.C3R, com.facebook.ads.redexgen.X.CT
    public final void A17(long j, boolean z) throws C14789u {
        super.A17(j, z);
        this.A0D.reset();
        this.A05 = j;
        this.A07 = true;
        this.A08 = true;
    }

    @Override // com.facebook.ads.redexgen.X.C3R, com.facebook.ads.redexgen.X.CT
    public final void A18(boolean z) throws C14789u {
        super.A18(z);
        this.A0C.A05(this.A0U);
        int i = A13().A00;
        if (i != 0) {
            this.A0D.A52(i);
        } else {
            this.A0D.A4l();
        }
    }

    @Override // com.facebook.ads.redexgen.X.C3R
    public final int A1C(MediaCodec mediaCodec, DY dy, Format format, Format format2) {
        return 0;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bu != com.facebook.ads.internal.exoplayer2.drm.DrmSessionManager<com.facebook.ads.internal.exoplayer2.drm.FrameworkMediaCrypto> */
    /* JADX WARN: Incorrect condition in loop: B:30:0x0079 */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ef  */
    @Override // com.facebook.ads.redexgen.X.C3R
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A1D(com.facebook.ads.redexgen.X.InterfaceC1553De r15, com.facebook.ads.redexgen.X.InterfaceC1521Bu<com.facebook.ads.redexgen.X.Y1> r16, com.facebook.ads.internal.exoplayer2.Format r17) throws com.facebook.ads.redexgen.X.C1556Dh {
        /*
            Method dump skipped, instruction units count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.AnonymousClass26.A1D(com.facebook.ads.redexgen.X.De, com.facebook.ads.redexgen.X.Bu, com.facebook.ads.internal.exoplayer2.Format):int");
    }

    @Override // com.facebook.ads.redexgen.X.C3R
    public final DY A1G(InterfaceC1553De interfaceC1553De, Format format, boolean z) throws C1556Dh {
        DY dyA6n;
        if (A0A(format.A0O) && (dyA6n = interfaceC1553De.A6n()) != null) {
            return dyA6n;
        }
        return super.A1G(interfaceC1553De, format, z);
    }

    @Override // com.facebook.ads.redexgen.X.C3R
    public final void A1J() throws C14789u {
        try {
            this.A0D.AC0();
        } catch (B5 e2) {
            throw C14789u.A01(e2, A10());
        }
    }

    @Override // com.facebook.ads.redexgen.X.C3R
    public final void A1M(MediaCodec mediaCodec, MediaFormat mediaFormat) throws C14789u {
        int i;
        int[] iArr;
        int i2;
        MediaFormat mediaFormat2 = this.A06;
        if (mediaFormat2 != null) {
            i = I9.A00(mediaFormat2.getString(A04(113, 4, 59)));
            mediaFormat = this.A06;
        } else {
            i = this.A04;
        }
        int integer = mediaFormat.getInteger(A04(71, 13, 107));
        int integer2 = mediaFormat.getInteger(A04(125, 11, 26));
        if (this.A09 && integer == 6 && (i2 = this.A00) < 6) {
            iArr = new int[i2];
            for (int i3 = 0; i3 < this.A00; i3++) {
                iArr[i3] = i3;
            }
        } else {
            iArr = null;
        }
        try {
            this.A0D.A46(i, integer, integer2, 0, iArr, this.A02, this.A03);
        } catch (B2 e2) {
            throw C14789u.A01(e2, A10());
        }
    }

    @Override // com.facebook.ads.redexgen.X.C3R
    public final void A1N(Format format) throws C14789u {
        int i;
        super.A1N(format);
        this.A0C.A03(format);
        if (A04(62, 9, 49).equals(format.A0O)) {
            i = format.A0A;
        } else {
            i = 2;
        }
        this.A04 = i;
        this.A00 = format.A05;
        this.A02 = format.A06;
        this.A03 = format.A07;
    }

    @Override // com.facebook.ads.redexgen.X.C3R
    public final void A1O(C2067Xq c2067Xq) {
        if (this.A07 && !c2067Xq.A03()) {
            if (Math.abs(c2067Xq.A00 - this.A05) > 500000) {
                this.A05 = c2067Xq.A00;
            }
            this.A07 = false;
        }
    }

    @Override // com.facebook.ads.redexgen.X.C3R
    public final void A1P(DY dy, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        this.A01 = A01(dy, format, A1B());
        this.A09 = A09(dy.A02);
        this.A0A = dy.A04;
        MediaFormat mediaFormatA02 = A02(format, dy.A01 == null ? A04(62, 9, 49) : dy.A01, this.A01);
        mediaCodec.configure(mediaFormatA02, (Surface) null, mediaCrypto, 0);
        if (this.A0A) {
            this.A06 = mediaFormatA02;
            this.A06.setString(A04(113, 4, 59), format.A0O);
        } else {
            this.A06 = null;
        }
    }

    @Override // com.facebook.ads.redexgen.X.C3R
    public final void A1Q(String str, long j, long j2) {
        this.A0C.A06(str, j, j2);
    }

    @Override // com.facebook.ads.redexgen.X.C3R
    public final boolean A1R(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws C14789u {
        if (this.A0A && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        }
        if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.A0U.A08++;
            this.A0D.A7N();
            return true;
        }
        try {
            if (!this.A0D.A7M(byteBuffer, j3)) {
                return false;
            }
            mediaCodec.releaseOutputBuffer(i, false);
            this.A0U.A06++;
            return true;
        } catch (B3 | B5 e2) {
            throw C14789u.A01(e2, A10());
        }
    }

    @Override // com.facebook.ads.redexgen.X.CT, com.facebook.ads.redexgen.X.XZ
    public final I7 A6c() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.X.I7
    public final AF A6s() {
        return this.A0D.A6s();
    }

    @Override // com.facebook.ads.redexgen.X.I7
    public final long A6v() {
        if (A77() == 2) {
            A05();
        }
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.X.CT, com.facebook.ads.redexgen.X.AP
    public final void A7O(int i, Object obj) throws C14789u {
        if (i != 2) {
            if (i != 3) {
                super.A7O(i, obj);
                return;
            } else {
                this.A0D.ADB((C1495Al) obj);
                return;
            }
        }
        B6 b6 = this.A0D;
        if (A0F[7].charAt(17) == 'P') {
            throw new RuntimeException();
        }
        String[] strArr = A0F;
        strArr[4] = "awvXiH99cLu1HaadjiPENScqQYAeI";
        strArr[4] = "awvXiH99cLu1HaadjiPENScqQYAeI";
        b6.setVolume(((Float) obj).floatValue());
    }

    @Override // com.facebook.ads.redexgen.X.C3R, com.facebook.ads.redexgen.X.XZ
    public final boolean A7n() {
        return super.A7n() && this.A0D.A7n();
    }

    @Override // com.facebook.ads.redexgen.X.C3R, com.facebook.ads.redexgen.X.XZ
    public final boolean A7w() {
        return this.A0D.A7Q() || super.A7w();
    }

    @Override // com.facebook.ads.redexgen.X.I7
    public final AF ADM(AF af) {
        return this.A0D.ADM(af);
    }
}
