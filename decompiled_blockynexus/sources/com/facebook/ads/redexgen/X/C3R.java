package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.drm.DrmInitData;
import com.umeng.analytics.pro.ci;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3R, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
@TargetApi(16)
public abstract class C3R extends CT {
    public static byte[] A0d;
    public static String[] A0e;
    public static final byte[] A0f;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public long A05;
    public MediaCodec A06;
    public Format A07;
    public InterfaceC1520Bt<Y1> A08;
    public InterfaceC1520Bt<Y1> A09;
    public DY A0A;
    public ByteBuffer A0B;
    public boolean A0C;
    public boolean A0D;
    public boolean A0E;
    public boolean A0F;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public boolean A0K;
    public boolean A0L;
    public boolean A0M;
    public boolean A0N;
    public boolean A0O;
    public boolean A0P;
    public boolean A0Q;
    public boolean A0R;
    public ByteBuffer[] A0S;
    public ByteBuffer[] A0T;
    public BU A0U;
    public final MediaCodec.BufferInfo A0V;
    public final A7 A0W;
    public final C2067Xq A0X;
    public final C2067Xq A0Y;

    @Nullable
    public final InterfaceC1521Bu<Y1> A0Z;
    public final InterfaceC1553De A0a;
    public final List<Long> A0b;
    public final boolean A0c;

    public static String A0a(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0d, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 20);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0k() {
        A0d = new byte[]{76, 64, 2, 21, 20, 64, ci.l, ci.m, 64, 19, 5, 3, 21, 18, 5, 64, 4, 5, 3, ci.m, 4, 5, 18, 64, 1, 22, 1, 9, 12, 1, 2, 12, 5, 78, 64, 52, 18, 25, 9, ci.l, 7, 64, 20, ci.m, 64, ci.n, 18, ci.m, 3, 5, 5, 4, 64, 23, 9, 20, 8, 64, 118, 116, 116, 116, 116, 116, 117, 114, 115, 112, 118, 7, 116, 116, 6, 0, 5, 118, 113, 125, 116, 116, 116, 116, 116, 116, 117, 114, 124, 7, 1, 116, 2, 117, 119, 118, 116, 116, 116, 116, 116, 116, 117, 114, 113, 124, 124, 124, 112, 116, 0, 7, 1, 115, 117, 117, 124, 5, 116, 116, 116, 118, 2, 6, 2, 117, 7, 119, 117, 7, 119, 118, 115, 113, 0, 115, 124, 7, 0, 18, 4, ci.m, 8, 26, 3, 29, 26, 8, ci.m, 117, 89, 85, 78, 91, 90, 34, 20, 11, 70, 21, 3, 21, 21, ci.m, 9, 8, 70, 20, 3, 23, 19, ci.m, 20, 3, 21, 70, 21, 3, 5, 19, 20, 3, 70, 2, 3, 5, 9, 2, 3, 20, 70, 0, 9, 20, 70, 62, 22, 23, 26, 18, 83, 1, 22, 2, 6, 26, 1, 22, 0, 83, 18, 83, 55, 1, 30, 32, 22, 0, 0, 26, 28, 29, 62, 18, 29, 18, 20, 22, 1, 125, 85, 84, 89, 81, 115, 95, 84, 85, 83, 98, 85, 94, 84, 85, 66, 85, 66, 125, 127, 106, 28, 119, 74, 75, 92, 93, 65, 28, 83, 68, 81, 28, 86, 87, 81, 27, 25, 12, 122, 17, 44, 45, 58, 59, 39, 122, 53, 34, 55, 122, 48, 49, 55, 122, 39, 49, 55, 33, 38, 49, 74, 72, 93, 43, 72, 81, 78, 43, 68, 80, 65, 76, 74, 43, 65, 64, 70, 74, 65, 64, 87, 43, 72, 85, 54, 127, 125, 104, 30, 125, 100, 123, 30, 102, 121, 116, 117, 127, 30, 116, 117, 115, 127, 116, 117, 98, 30, 113, 102, 115, 3, 1, 20, 98, 2, 58, 37, 40, 37, 45, 98, 36, 126, 122, 120, 98, 40, 41, 47, 35, 40, 41, 47, 45, 56, 78, 46, 22, 9, 4, 9, 1, 78, 8, 82, 86, 84, 78, 4, 5, 3, ci.m, 4, 5, 78, 19, 5, 3, 21, 18, 5, 121, 123, 110, 24, 101, 115, 117, 24, 87, 64, 85, 24, 82, 83, 85, 72, 74, 95, 41, 84, 66, 68, 41, 102, 113, 100, 41, 99, 98, 100, 41, 116, 98, 100, 114, 117, 98, 45, 47, 58, 76, 3, ci.l, ci.l, 21, 11, 12, 12, 7, ci.n, 76, 20, 11, 6, 7, ci.k, 76, 6, 7, 1, ci.k, 6, 7, ci.n, 76, 3, 20, 1, 1, 3, 22, 96, 47, 35, 34, 33, 41, 39, 45, 96, 47, 56, 45, 96, 42, 43, 45, 33, 42, 43, 60, 96, 47, 57, 43, 61, 33, 35, 43, Utf8.REPLACEMENT_BYTE, 61, 40, 94, 17, 29, 28, 31, 23, 25, 19, 94, 17, 6, 19, 94, 20, 21, 19, 31, 20, 21, 2, 94, 17, 7, 21, 3, 31, 29, 21, 94, 3, 21, 19, 5, 2, 21, 121, 123, 110, 24, 81, 89, 89, 81, 90, 83, 24, 87, 87, 85, 24, 82, 83, 85, 89, 82, 83, 68, 30, 28, 9, 127, 54, 62, 62, 54, 61, 52, 127, 39, 62, 35, 51, 56, 34, 127, 53, 52, 50, 62, 53, 52, 35, 2, 0, 21, 99, Utf8.REPLACEMENT_BYTE, 38, 99, 59, 36, 41, 40, 34, 18, 41, 40, 46, 34, 41, 40, Utf8.REPLACEMENT_BYTE, 99, 44, 59, 46, 112, 110, ci.l, 98, 22, 18, 19, 41, 55, 87, 59, 79, 72, 74, 106, 116, 20, 126, 1, 9, 9, 116, 106, 10, 109, ci.n, 23, 23, 79, 81, 49, 72, 41, 36, 41, 106, 97, 104, 103, 103, 108, 101, 36, 106, 102, 124, 103, 125, Utf8.REPLACEMENT_BYTE, 51, 50, 58, 53, 59, 41, 46, 57, 31, 51, 56, 57, Utf8.REPLACEMENT_BYTE, ci.m, 30, 9, ci.k, 24, 9, 47, 3, 8, 9, ci.m, 86, 96, 118, 101, 109, 106, 69, 106, 96, 66, 97, 97, 96, 83, 89, 90, 64, 91, 81, 80, 71, 24, 18, 17, 11, ci.n, 26, 27, 12, 33, 18, 10, 27, 5, ci.n, ci.k, 23, 18, 7, ci.n, 43, 33, 113, 115, 115, 115, 45, 32, 44, 34, 45, 49, 3, 4, 17, 2, 4, 51, 31, 20, 21, 19, 113, 108, 105, 100, 117, 108, 100, 101, 123, 118, 102, 122};
    }

    public static void A0l() {
        A0e = new String[]{"9OVkIR1fNYEoLuJhr4v44UGIqobat2iA", "rvjyAE4a8qg3Symxb7ylQnmZk1yEw18g", "yq3KpxRuPN0WZ8jbU7FQkuT3q90s4j9W", "QhWwoh5s4IWFZsopFlKjqr3qYdcDlMjY", "GXhQrMO3EYw7GpvgdmF2LLQyblaoRrya", "HarHLo3NfHHJ1sn22D42qgtNJjG4ySv5", "mWzZtnKFhVqOEEmQC7RHyJpmfpW8oE62", "x54zHbOQHTTVCgIECmCrfbqAOALLU5ir"};
    }

    public abstract int A1D(InterfaceC1553De interfaceC1553De, InterfaceC1521Bu<Y1> interfaceC1521Bu, Format format) throws C1556Dh;

    public abstract void A1P(DY dy, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) throws C1556Dh;

    public abstract boolean A1R(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) throws C14789u;

    static {
        A0l();
        A0k();
        A0f = IW.A0i(A0a(59, 76, 80));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bu != com.facebook.ads.internal.exoplayer2.drm.DrmSessionManager<com.facebook.ads.internal.exoplayer2.drm.FrameworkMediaCrypto> */
    public C3R(int i, InterfaceC1553De interfaceC1553De, @Nullable InterfaceC1521Bu<Y1> interfaceC1521Bu, boolean z) {
        super(i);
        C1662Hr.A04(IW.A02 >= 16);
        this.A0a = (InterfaceC1553De) C1662Hr.A01(interfaceC1553De);
        this.A0Z = interfaceC1521Bu;
        this.A0c = z;
        this.A0X = new C2067Xq(0);
        this.A0Y = C2067Xq.A02();
        this.A0W = new A7();
        this.A0b = new ArrayList();
        this.A0V = new MediaCodec.BufferInfo();
        this.A01 = 0;
        this.A02 = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x010b A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int A0X(java.lang.String r6) {
        /*
            Method dump skipped, instruction units count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3R.A0X(java.lang.String):int");
    }

    private final long A0Y() {
        return 0L;
    }

    public static MediaCodec.CryptoInfo A0Z(C2067Xq c2067Xq, int i) {
        MediaCodec.CryptoInfo cryptoInfoA02 = c2067Xq.A02.A02();
        if (i == 0) {
            return cryptoInfoA02;
        }
        if (cryptoInfoA02.numBytesOfClearData == null) {
            String[] strArr = A0e;
            if (strArr[1].charAt(9) == strArr[6].charAt(9)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0e;
            strArr2[5] = "UbtyB27B24Biu3n6sBWjRVSN4hFFB4s1";
            strArr2[5] = "UbtyB27B24Biu3n6sBWjRVSN4hFFB4s1";
            cryptoInfoA02.numBytesOfClearData = new int[1];
        }
        int[] iArr = cryptoInfoA02.numBytesOfClearData;
        iArr[0] = iArr[0] + i;
        return cryptoInfoA02;
    }

    private ByteBuffer A0b(int i) {
        if (IW.A02 >= 21) {
            return this.A06.getInputBuffer(i);
        }
        return this.A0S[i];
    }

    private ByteBuffer A0c(int i) {
        if (IW.A02 >= 21) {
            return this.A06.getOutputBuffer(i);
        }
        return this.A0T[i];
    }

    private void A0d() {
        if (IW.A02 < 21) {
            this.A0S = this.A06.getInputBuffers();
            this.A0T = this.A06.getOutputBuffers();
        }
    }

    private void A0e() throws C14789u {
        if (this.A02 == 2) {
            A1I();
            A1K();
        } else {
            this.A0N = true;
            A1J();
        }
    }

    private void A0f() {
        if (IW.A02 < 21) {
            this.A0T = this.A06.getOutputBuffers();
        }
    }

    private void A0g() throws C14789u {
        MediaFormat outputFormat = this.A06.getOutputFormat();
        if (this.A00 != 0 && outputFormat.getInteger(A0a(739, 5, 6)) == 32 && outputFormat.getInteger(A0a(716, 6, 81)) == 32) {
            this.A0O = true;
            return;
        }
        if (this.A0I) {
            outputFormat.setInteger(A0a(632, 13, 29), 1);
        }
        A1M(this.A06, outputFormat);
    }

    private void A0h() {
        if (IW.A02 < 21) {
            this.A0S = null;
            this.A0T = null;
        }
    }

    private void A0i() {
        this.A03 = -1;
        this.A0X.A01 = null;
    }

    private void A0j() {
        this.A04 = -1;
        this.A0B = null;
    }

    private void A0m(C1549Da c1549Da) throws C14789u {
        throw C14789u.A01(c1549Da, A10());
    }

    private boolean A0n() {
        if (A0a(147, 6, 32).equals(IW.A05)) {
            if (!A0a(139, 4, 90).equals(IW.A06)) {
                if (A0a(135, 4, 82).equals(IW.A06)) {
                }
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0206, code lost:
    
        if (r16.A0X.A03() == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0208, code lost:
    
        r16.A0b.add(java.lang.Long.valueOf(r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0211, code lost:
    
        r16.A0X.A08();
        A1O(r16.A0X);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x021b, code lost:
    
        if (r6 == false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x021e, code lost:
    
        r16.A06.queueInputBuffer(r16.A03, 0, r16.A0X.A01.limit(), r7, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0231, code lost:
    
        r6 = A0Z(r16.A0X, r5);
        r16.A06.queueSecureInputBuffer(r16.A03, 0, r6, r7, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0240, code lost:
    
        A0i();
        r16.A0J = true;
        r16.A01 = 0;
        r16.A0U.A04++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x024e, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x024f, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0258, code lost:
    
        throw com.facebook.ads.redexgen.X.C14789u.A01(r1, A10());
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0095, code lost:
    
        if (r7 != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0097, code lost:
    
        r16.A0C = false;
        r16.A0X.A01.put(com.facebook.ads.redexgen.X.C3R.A0f);
        r16.A06.queueInputBuffer(r16.A03, 0, com.facebook.ads.redexgen.X.C3R.A0f.length, 0, 0);
        A0i();
        r16.A0J = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b5, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c2, code lost:
    
        if (r7 != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c5, code lost:
    
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c8, code lost:
    
        if (r16.A0R == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ca, code lost:
    
        r6 = -4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00cc, code lost:
    
        if (r6 != (-3)) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ce, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d1, code lost:
    
        if (r16.A01 != 1) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d3, code lost:
    
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d4, code lost:
    
        r8 = r16.A07.A0P.size();
        r6 = com.facebook.ads.redexgen.X.C3R.A0e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ee, code lost:
    
        if (r6[1].charAt(9) == r6[6].charAt(9)) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f0, code lost:
    
        r6 = com.facebook.ads.redexgen.X.C3R.A0e;
        r6[7] = "0VatHXJ47YZXuQNTjh1Q4vWnAJchohqJ";
        r6[7] = "0VatHXJ47YZXuQNTjh1Q4vWnAJchohqJ";
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00fc, code lost:
    
        if (r7 >= r8) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00fe, code lost:
    
        r16.A0X.A01.put(r16.A07.A0P.get(r7));
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0112, code lost:
    
        r6 = com.facebook.ads.redexgen.X.C3R.A0e;
        r6[3] = "zOhD8BhFeW0zpu1geu8qUgn88iwXK5ep";
        r6[0] = "60rX9qlLFkokv4JD1C8g9QKhync8N1Cu";
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x011e, code lost:
    
        if (r7 >= r8) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0121, code lost:
    
        r16.A01 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0123, code lost:
    
        r7 = r16.A0X.A01;
        r6 = com.facebook.ads.redexgen.X.C3R.A0e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0139, code lost:
    
        if (r6[1].charAt(9) == r6[6].charAt(9)) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x013b, code lost:
    
        r6 = com.facebook.ads.redexgen.X.C3R.A0e;
        r6[1] = "39aArsNj3IDVPnG6lUIYrUviornu3auc";
        r6[6] = "ZVN5NvQX1lR02F2nkBpRehMiTRLfpSWC";
        r5 = r7.position();
        r6 = A12(r16.A0W, r16.A0X, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0155, code lost:
    
        r5 = r7.position();
        r6 = A12(r16.A0W, r16.A0X, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0164, code lost:
    
        if (r6 != (-5)) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0168, code lost:
    
        if (r16.A01 != 2) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x016a, code lost:
    
        r16.A0X.A07();
        r16.A01 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0171, code lost:
    
        A1N(r16.A0W.A00);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0178, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x017f, code lost:
    
        if (r16.A0X.A04() == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0183, code lost:
    
        if (r16.A01 != 2) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0185, code lost:
    
        r16.A0X.A07();
        r16.A01 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x018c, code lost:
    
        r16.A0M = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0190, code lost:
    
        if (r16.A0J != false) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0192, code lost:
    
        A0e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0195, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0198, code lost:
    
        if (r16.A0G == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x019b, code lost:
    
        r16.A0K = true;
        r16.A06.queueInputBuffer(r16.A03, 0, 0, 0, 4);
        A0i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01ac, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01ad, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01b6, code lost:
    
        throw com.facebook.ads.redexgen.X.C14789u.A01(r1, A10());
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01b9, code lost:
    
        if (r16.A0Q == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01c1, code lost:
    
        if (r16.A0X.A05() != false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01c3, code lost:
    
        r16.A0X.A07();
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01ca, code lost:
    
        if (r16.A01 != 2) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01cc, code lost:
    
        r16.A01 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01ce, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01cf, code lost:
    
        r16.A0Q = false;
        r6 = r16.A0X.A0A();
        r16.A0R = A0y(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01df, code lost:
    
        if (r16.A0R == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01e1, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01e4, code lost:
    
        if (r16.A0D == false) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01e6, code lost:
    
        if (r6 != false) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01e8, code lost:
    
        com.facebook.ads.redexgen.X.IC.A0B(r16.A0X.A01);
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01f7, code lost:
    
        if (r16.A0X.A01.position() != 0) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01f9, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01fa, code lost:
    
        r16.A0D = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01fc, code lost:
    
        r7 = r16.A0X.A00;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0o() throws com.facebook.ads.redexgen.X.C14789u {
        /*
            Method dump skipped, instruction units count: 601
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3R.A0o():boolean");
    }

    private boolean A0p() {
        return this.A04 >= 0;
    }

    private boolean A0q(long j) {
        int size = this.A0b.size();
        for (int i = 0; i < size; i++) {
            long jLongValue = this.A0b.get(i).longValue();
            String[] strArr = A0e;
            if (strArr[1].charAt(9) == strArr[6].charAt(9)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0e;
            strArr2[4] = "ML5bMotUrNJfefR5zyFOe6FKAXdvvO6A";
            strArr2[2] = "SdeYytwJjEjJxI17XZFSuNmI9VlWoLpo";
            if (jLongValue == j) {
                this.A0b.remove(i);
                if (A0e[5].charAt(22) != 'm') {
                    String[] strArr3 = A0e;
                    strArr3[4] = "PN0xo47Kt8nFjD42DkF1Rwv3kccfY0ZU";
                    strArr3[2] = "8XhLexKKIuuBUtz2cCFHUx77okN3o4VX";
                    return true;
                }
                String[] strArr4 = A0e;
                strArr4[1] = "MaO0vnTK96XnVNRleRSpONjFXCjP5Eov";
                strArr4[6] = "hUdEzwsPaliJglUJ7NraoDZ4Fn5DncmA";
                return false;
            }
        }
        return false;
    }

    private boolean A0r(long j, long j2) throws C14789u {
        boolean zA1R;
        int iDequeueOutputBuffer;
        if (!A0p()) {
            if (this.A0F && this.A0K) {
                try {
                    iDequeueOutputBuffer = this.A06.dequeueOutputBuffer(this.A0V, A0Y());
                } catch (IllegalStateException unused) {
                    A0e();
                    if (this.A0N) {
                        A1I();
                    }
                    return false;
                }
            } else {
                iDequeueOutputBuffer = this.A06.dequeueOutputBuffer(this.A0V, A0Y());
            }
            if (iDequeueOutputBuffer >= 0) {
                if (this.A0O) {
                    this.A0O = false;
                    this.A06.releaseOutputBuffer(iDequeueOutputBuffer, false);
                    return true;
                }
                if (this.A0V.size == 0 && (this.A0V.flags & 4) != 0) {
                    A0e();
                    return false;
                }
                this.A04 = iDequeueOutputBuffer;
                this.A0B = A0c(iDequeueOutputBuffer);
                ByteBuffer byteBuffer = this.A0B;
                if (byteBuffer != null) {
                    byteBuffer.position(this.A0V.offset);
                    this.A0B.limit(this.A0V.offset + this.A0V.size);
                }
                this.A0P = A0q(this.A0V.presentationTimeUs);
            } else {
                if (iDequeueOutputBuffer == -2) {
                    A0g();
                    return true;
                }
                if (iDequeueOutputBuffer == -3) {
                    A0f();
                    return true;
                }
                if (this.A0G && (this.A0M || this.A02 == 2)) {
                    A0e();
                }
                return false;
            }
        }
        boolean z = this.A0F;
        String[] strArr = A0e;
        if (strArr[3].charAt(8) != strArr[0].charAt(8)) {
            String[] strArr2 = A0e;
            strArr2[3] = "H6QEdKrNS5VKUI2eiDzJYDiDaOSTSHZm";
            strArr2[0] = "qtM0JqIstAlLtY5WeeeWIRjDSmIhrDzd";
            if (z && this.A0K) {
                try {
                    zA1R = A1R(j, j2, this.A06, this.A0B, this.A04, this.A0V.flags, this.A0V.presentationTimeUs, this.A0P);
                } catch (IllegalStateException unused2) {
                    A0e();
                    boolean z2 = this.A0N;
                    String[] strArr3 = A0e;
                    if (strArr3[4].charAt(18) == strArr3[2].charAt(18)) {
                        String[] strArr4 = A0e;
                        strArr4[3] = "kLeAoHdKyNjlIY3W2lnlzypZ7jBCZpds";
                        strArr4[0] = "12vglqLCD0wnh38LM4o4LF1q7CPuStNa";
                        if (z2) {
                            A1I();
                        }
                        return false;
                    }
                }
            } else {
                zA1R = A1R(j, j2, this.A06, this.A0B, this.A04, this.A0V.flags, this.A0V.presentationTimeUs, this.A0P);
            }
            if (zA1R) {
                A1L(this.A0V.presentationTimeUs);
                boolean z3 = (this.A0V.flags & 4) != 0;
                A0j();
                if (!z3) {
                    return true;
                }
                A0e();
            }
            return false;
        }
        throw new RuntimeException();
    }

    public static boolean A0s(DY dy) {
        String str = dy.A02;
        if (IW.A02 > 17 || (!A0a(573, 24, 89).equals(str) && !A0a(426, 31, 118).equals(str))) {
            if (A0a(147, 6, 32).equals(IW.A05)) {
                if (!A0a(143, 4, 72).equals(IW.A06) || !dy.A05) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean A0t(String str) {
        if (IW.A02 > 23 || !A0a(548, 25, 69).equals(str)) {
            if (IW.A02 <= 19) {
                if (A0a(710, 6, 87).equals(IW.A03)) {
                    String[] strArr = A0e;
                    if (strArr[3].charAt(8) == strArr[0].charAt(8)) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A0e;
                    strArr2[1] = "95wFKgRrMS7zF0LnDUBUyEKLdOv2pw0Q";
                    strArr2[6] = "8UM2DR4qd3kvfN0lEIyvKJByOBGtF0J9";
                    if (A0a(457, 31, 90).equals(str) || A0a(488, 38, 100).equals(str)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public static boolean A0u(String str) {
        return IW.A02 == 21 && A0a(526, 22, 34).equals(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0v(java.lang.String r4) {
        /*
            int r0 = com.facebook.ads.redexgen.X.IW.A02
            r1 = 18
            if (r0 < r1) goto L81
            int r0 = com.facebook.ads.redexgen.X.IW.A02
            if (r0 != r1) goto L4a
            r2 = 389(0x185, float:5.45E-43)
            r1 = 15
            r0 = 34
            java.lang.String r0 = A0a(r2, r1, r0)
            boolean r3 = r0.equals(r4)
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C3R.A0e
            r0 = 3
            r1 = r2[r0]
            r0 = 0
            r2 = r2[r0]
            r0 = 8
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L85
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C3R.A0e
            java.lang.String r1 = "meV5e9Kkfi1Cw7qLNaZXa1JKO1Lv4Z7w"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "iFBSwhWIKfzcqDOwhwOBewnG37AI8L0V"
            r0 = 6
            r2[r0] = r1
            if (r3 != 0) goto L81
            r2 = 404(0x194, float:5.66E-43)
            r1 = 22
            r0 = 19
            java.lang.String r0 = A0a(r2, r1, r0)
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L81
        L4a:
            int r1 = com.facebook.ads.redexgen.X.IW.A02
            r0 = 19
            if (r1 != r0) goto L83
            java.lang.String r3 = com.facebook.ads.redexgen.X.IW.A06
            r2 = 611(0x263, float:8.56E-43)
            r1 = 7
            r0 = 45
            java.lang.String r0 = A0a(r2, r1, r0)
            boolean r0 = r3.startsWith(r0)
            if (r0 == 0) goto L83
            r2 = 245(0xf5, float:3.43E-43)
            r1 = 18
            r0 = 38
            java.lang.String r0 = A0a(r2, r1, r0)
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L81
            r2 = 263(0x107, float:3.69E-43)
            r1 = 25
            r0 = 64
            java.lang.String r0 = A0a(r2, r1, r0)
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L83
        L81:
            r0 = 1
        L82:
            return r0
        L83:
            r0 = 0
            goto L82
        L85:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3R.A0v(java.lang.String):boolean");
    }

    public static boolean A0w(String str, Format format) {
        return IW.A02 < 21 && format.A0P.isEmpty() && A0a(313, 25, 36).equals(str);
    }

    public static boolean A0x(String str, Format format) {
        return IW.A02 <= 18 && format.A05 == 1 && A0a(288, 25, 17).equals(str);
    }

    private boolean A0y(boolean z) throws C14789u {
        if (this.A08 == null || (!z && this.A0c)) {
            return false;
        }
        int iA77 = this.A08.A77();
        if (iA77 != 1) {
            return iA77 != 4;
        }
        throw C14789u.A01(this.A08.A6I(), A10());
    }

    @Override // com.facebook.ads.redexgen.X.CT
    public void A14() {
        this.A07 = null;
        try {
            A1I();
            try {
                if (this.A08 != null) {
                    this.A0Z.ACc(this.A08);
                }
                try {
                    if (this.A09 != null && this.A09 != this.A08) {
                        this.A0Z.ACc(this.A09);
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    if (this.A09 != null && this.A09 != this.A08) {
                        this.A0Z.ACc(this.A09);
                    }
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.A08 != null) {
                    this.A0Z.ACc(this.A08);
                }
                try {
                    if (this.A09 != null && this.A09 != this.A08) {
                        this.A0Z.ACc(this.A09);
                    }
                    throw th2;
                } finally {
                }
            } catch (Throwable th3) {
                try {
                    if (this.A09 != null && this.A09 != this.A08) {
                        this.A0Z.ACc(this.A09);
                    }
                    throw th3;
                } finally {
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.CT
    public void A15() {
    }

    @Override // com.facebook.ads.redexgen.X.CT
    public void A16() {
    }

    @Override // com.facebook.ads.redexgen.X.CT
    public void A17(long j, boolean z) throws C14789u {
        this.A0M = false;
        this.A0N = false;
        if (this.A06 != null) {
            A1H();
        }
    }

    @Override // com.facebook.ads.redexgen.X.CT
    public void A18(boolean z) throws C14789u {
        this.A0U = new BU();
    }

    public int A1C(MediaCodec mediaCodec, DY dy, Format format, Format format2) {
        return 0;
    }

    public final MediaCodec A1E() {
        return this.A06;
    }

    public final DY A1F() {
        return this.A0A;
    }

    public DY A1G(InterfaceC1553De interfaceC1553De, Format format, boolean z) throws C1556Dh {
        return interfaceC1553De.A67(format.A0O, z);
    }

    public void A1H() throws C14789u {
        this.A05 = -9223372036854775807L;
        A0i();
        A0j();
        this.A0Q = true;
        this.A0R = false;
        this.A0P = false;
        this.A0b.clear();
        this.A0C = false;
        this.A0O = false;
        if (this.A0H || (this.A0E && this.A0K)) {
            A1I();
            A1K();
        } else {
            int i = this.A02;
            if (A0e[7].charAt(4) != 'H') {
                throw new RuntimeException();
            }
            String[] strArr = A0e;
            strArr[1] = "wbouPn2Ftm3cpLG8fvuyld6AKnPflzbx";
            strArr[6] = "bzy96m6ZRNxMDmYLQEfFnOCqhh49XGXp";
            if (i != 0) {
                A1I();
                A1K();
            } else {
                this.A06.flush();
                this.A0J = false;
            }
        }
        if (this.A0L && this.A07 != null) {
            this.A01 = 1;
        }
    }

    public void A1I() {
        this.A05 = -9223372036854775807L;
        A0i();
        A0j();
        this.A0R = false;
        this.A0P = false;
        this.A0b.clear();
        A0h();
        this.A0A = null;
        this.A0L = false;
        this.A0J = false;
        this.A0D = false;
        this.A0H = false;
        this.A00 = 0;
        this.A0G = false;
        this.A0E = false;
        this.A0I = false;
        this.A0C = false;
        this.A0O = false;
        this.A0K = false;
        this.A01 = 0;
        this.A02 = 0;
        if (this.A06 != null) {
            this.A0U.A01++;
            try {
                this.A06.stop();
                try {
                    this.A06.release();
                    this.A06 = null;
                    InterfaceC1520Bt<Y1> interfaceC1520Bt = this.A08;
                    if (interfaceC1520Bt != null && this.A09 != interfaceC1520Bt) {
                        try {
                            this.A0Z.ACc(interfaceC1520Bt);
                        } finally {
                        }
                    }
                } catch (Throwable th) {
                    this.A06 = null;
                    InterfaceC1520Bt<Y1> interfaceC1520Bt2 = this.A08;
                    if (interfaceC1520Bt2 != null && this.A09 != interfaceC1520Bt2) {
                        try {
                            this.A0Z.ACc(interfaceC1520Bt2);
                        } finally {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    this.A06.release();
                    this.A06 = null;
                    InterfaceC1520Bt<Y1> interfaceC1520Bt3 = this.A08;
                    if (interfaceC1520Bt3 != null && this.A09 != interfaceC1520Bt3) {
                        try {
                            this.A0Z.ACc(interfaceC1520Bt3);
                        } finally {
                        }
                    }
                    throw th2;
                } catch (Throwable th3) {
                    this.A06 = null;
                    InterfaceC1520Bt<Y1> interfaceC1520Bt4 = this.A08;
                    if (interfaceC1520Bt4 != null && this.A09 != interfaceC1520Bt4) {
                        try {
                            this.A0Z.ACc(interfaceC1520Bt4);
                        } finally {
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    public void A1J() throws C14789u {
    }

    public final void A1K() throws C14789u {
        Format format;
        long jElapsedRealtime;
        if (this.A06 != null || (format = this.A07) == null) {
            return;
        }
        this.A08 = this.A09;
        String str = format.A0O;
        MediaCrypto mediaCryptoA00 = null;
        boolean zA01 = false;
        InterfaceC1520Bt<Y1> interfaceC1520Bt = this.A08;
        if (interfaceC1520Bt != null) {
            Y1 y1 = (Y1) interfaceC1520Bt.A6d();
            if (A0e[5].charAt(22) == 'm') {
                throw new RuntimeException();
            }
            String[] strArr = A0e;
            strArr[1] = "HTFGGBgFgI6ylI68q0FeBZ95y7T9Xgss";
            strArr[6] = "P6HI8GYxdJJ1MGo6JXYXPe6FB7j5p6fI";
            if (y1 == null) {
                if (this.A08.A6I() == null) {
                    return;
                }
            } else {
                mediaCryptoA00 = y1.A00();
                zA01 = y1.A01(str);
            }
            if (A0n()) {
                int iA77 = this.A08.A77();
                if (iA77 == 1) {
                    throw C14789u.A01(this.A08.A6I(), A10());
                }
                if (A0e[7].charAt(4) != 'H') {
                    if (iA77 != 4) {
                        return;
                    }
                } else {
                    String[] strArr2 = A0e;
                    strArr2[7] = "zdcyHT7sTCB3al7NiJFn52Vz5qRveBVU";
                    strArr2[7] = "zdcyHT7sTCB3al7NiJFn52Vz5qRveBVU";
                    if (iA77 != 4) {
                        return;
                    }
                }
            }
        }
        if (this.A0A == null) {
            try {
                this.A0A = A1G(this.A0a, this.A07, zA01);
                if (this.A0A == null && zA01) {
                    this.A0A = A1G(this.A0a, this.A07, false);
                    if (this.A0A != null) {
                        Log.w(A0a(227, 18, 36), A0a(153, 40, 114) + str + A0a(0, 58, 116) + this.A0A.A02 + A0a(58, 1, 76));
                    }
                }
            } catch (C1556Dh e2) {
                A0m(new C1549Da(this.A07, e2, zA01, -49998));
            }
            if (this.A0A == null) {
                A0m(new C1549Da(this.A07, (Throwable) null, zA01, -49999));
            }
        }
        if (!A1S(this.A0A)) {
            return;
        }
        String str2 = this.A0A.A02;
        this.A00 = A0X(str2);
        this.A0D = A0w(str2, this.A07);
        this.A0H = A0v(str2);
        this.A0G = A0s(this.A0A);
        this.A0E = A0t(str2);
        this.A0F = A0u(str2);
        this.A0I = A0x(str2, this.A07);
        try {
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            StringBuilder sb = new StringBuilder();
            String codecName = A0a(659, 12, 120);
            sb.append(codecName);
            sb.append(str2);
            String codecName2 = sb.toString();
            IT.A02(codecName2);
            this.A06 = MediaCodec.createByCodecName(str2);
            IT.A00();
            String codecName3 = A0a(645, 14, 72);
            IT.A02(codecName3);
            A1P(this.A0A, this.A06, this.A07, mediaCryptoA00);
            IT.A00();
            String codecName4 = A0a(722, 10, 100);
            IT.A02(codecName4);
            this.A06.start();
            IT.A00();
            long jElapsedRealtime3 = SystemClock.elapsedRealtime();
            A1Q(str2, jElapsedRealtime3, jElapsedRealtime3 - jElapsedRealtime2);
            A0d();
        } catch (Exception e3) {
            A0m(new C1549Da(this.A07, e3, zA01, str2));
        }
        if (A77() == 2) {
            jElapsedRealtime = SystemClock.elapsedRealtime() + 1000;
        } else {
            jElapsedRealtime = -9223372036854775807L;
        }
        this.A05 = jElapsedRealtime;
        A0i();
        A0j();
        this.A0Q = true;
        this.A0U.A00++;
    }

    public void A1L(long j) {
    }

    public void A1M(MediaCodec mediaCodec, MediaFormat mediaFormat) throws C14789u {
    }

    public void A1N(Format format) throws C14789u {
        DrmInitData drmInitData;
        MediaCodec mediaCodec;
        int iA1C;
        Format format2 = this.A07;
        this.A07 = format;
        DrmInitData drmInitData2 = this.A07.A0H;
        if (format2 == null) {
            drmInitData = null;
        } else {
            drmInitData = format2.A0H;
        }
        if (!IW.A0h(drmInitData2, drmInitData)) {
            if (this.A07.A0H != null) {
                InterfaceC1521Bu<Y1> interfaceC1521Bu = this.A0Z;
                if (A0e[5].charAt(22) != 'm') {
                    String[] strArr = A0e;
                    strArr[4] = "js0xY6djzstMh1ZGSSFwxrm9J2KEODfF";
                    strArr[2] = "gNDkR57A7pqknHdJ9eFPG5bc7UDUELIy";
                    if (interfaceC1521Bu != null) {
                        Looper looperMyLooper = Looper.myLooper();
                        DrmInitData drmInitData3 = this.A07.A0H;
                        if (A0e[5].charAt(22) != 'm') {
                            String[] strArr2 = A0e;
                            strArr2[7] = "L1yeHoCGmaJe3p3nUxagVjwy9TYWwSRI";
                            strArr2[7] = "L1yeHoCGmaJe3p3nUxagVjwy9TYWwSRI";
                            this.A09 = interfaceC1521Bu.A2Q(looperMyLooper, drmInitData3);
                            InterfaceC1520Bt<Y1> interfaceC1520Bt = this.A09;
                            if (interfaceC1520Bt == this.A08) {
                                InterfaceC1521Bu<Y1> interfaceC1521Bu2 = this.A0Z;
                                String[] strArr3 = A0e;
                                if (strArr3[1].charAt(9) == strArr3[6].charAt(9)) {
                                    throw new RuntimeException();
                                }
                                String[] strArr4 = A0e;
                                strArr4[1] = "PNJFXv8k8SK4Yjj8VNQjLQpnTp0fAy1J";
                                strArr4[6] = "VCM67JEqNnPycf67Mw9BgN4gUhlxC0Ru";
                                interfaceC1521Bu2.ACc(interfaceC1520Bt);
                            }
                        }
                    } else {
                        throw C14789u.A01(new IllegalStateException(A0a(193, 34, 103)), A10());
                    }
                }
                throw new RuntimeException();
            }
            this.A09 = null;
        }
        boolean z = false;
        if (this.A09 == this.A08 && (mediaCodec = this.A06) != null && (iA1C = A1C(mediaCodec, this.A0A, format2, this.A07)) != 0) {
            if (iA1C == 1) {
                z = true;
            } else if (iA1C == 3) {
                z = true;
                this.A0L = true;
                this.A01 = 1;
                int i = this.A00;
                this.A0C = i == 2 || (i == 1 && this.A07.A0F == format2.A0F && this.A07.A08 == format2.A08);
            } else {
                throw new IllegalStateException();
            }
        }
        if (!z) {
            if (this.A0J) {
                this.A02 = 1;
            } else {
                A1I();
                A1K();
            }
        }
    }

    public void A1O(C2067Xq c2067Xq) {
    }

    public void A1Q(String str, long j, long j2) {
    }

    public boolean A1S(DY dy) {
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.XZ
    public boolean A7n() {
        return this.A0N;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0074  */
    @Override // com.facebook.ads.redexgen.X.XZ
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean A7w() {
        /*
            r6 = this;
            com.facebook.ads.internal.exoplayer2.Format r0 = r6.A07
            if (r0 == 0) goto L92
            boolean r3 = r6.A0R
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C3R.A0e
            r0 = 5
            r1 = r1[r0]
            r0 = 22
            char r1 = r1.charAt(r0)
            r0 = 109(0x6d, float:1.53E-43)
            if (r1 == r0) goto L94
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C3R.A0e
            java.lang.String r1 = "4HO9JQHKOwc6R3VWcS8R4aXAnHys3aci"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "eJ1ha0lSNb53SSfCNHliM2QVteujQRGV"
            r0 = 6
            r2[r0] = r1
            if (r3 != 0) goto L92
            boolean r0 = r6.A1A()
            if (r0 != 0) goto L7e
            boolean r3 = r6.A0p()
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C3R.A0e
            r0 = 3
            r1 = r2[r0]
            r0 = 0
            r2 = r2[r0]
            r0 = 8
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L8f
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C3R.A0e
            java.lang.String r1 = "OQSQFxnlZZo22DxvkKeXHq8FF7pzfl1u"
            r0 = 5
            r2[r0] = r1
            java.lang.String r1 = "OQSQFxnlZZo22DxvkKeXHq8FF7pzfl1u"
            r0 = 5
            r2[r0] = r1
            if (r3 != 0) goto L7e
        L4f:
            long r4 = r6.A05
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r3 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C3R.A0e
            r0 = 7
            r1 = r1[r0]
            r0 = 4
            char r1 = r1.charAt(r0)
            r0 = 72
            if (r1 == r0) goto L80
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C3R.A0e
            java.lang.String r1 = "x7dDRka8TdETs6VLaaF6zooftcMnhKq2"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "EId5jOcDiZLe1q4ZwHFfLyVQFAikb5sI"
            r0 = 2
            r2[r0] = r1
            if (r3 == 0) goto L92
        L74:
            long r3 = android.os.SystemClock.elapsedRealtime()
            long r1 = r6.A05
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 >= 0) goto L92
        L7e:
            r0 = 1
        L7f:
            return r0
        L80:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C3R.A0e
            java.lang.String r1 = "3vglA6G8yuA12iVw0aFHPuEKtU4GGV7V"
            r0 = 3
            r2[r0] = r1
            java.lang.String r1 = "dEcUfU5Lns9loW0elZLaj7FKzckicWHS"
            r0 = 0
            r2[r0] = r1
            if (r3 == 0) goto L92
            goto L74
        L8f:
            if (r3 != 0) goto L7e
            goto L4f
        L92:
            r0 = 0
            goto L7f
        L94:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C3R.A7w():boolean");
    }

    @Override // com.facebook.ads.redexgen.X.XZ
    public final void ACj(long j, long j2) throws C14789u {
        if (this.A0N) {
            A1J();
            return;
        }
        if (this.A07 == null) {
            this.A0Y.A07();
            int iA12 = A12(this.A0W, this.A0Y, true);
            if (iA12 == -5) {
                A1N(this.A0W.A00);
            } else {
                if (iA12 == -4) {
                    C1662Hr.A04(this.A0Y.A04());
                    this.A0M = true;
                    A0e();
                    String[] strArr = A0e;
                    if (strArr[3].charAt(8) == strArr[0].charAt(8)) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A0e;
                    strArr2[7] = "aKhyH6I995l1LklLucgRLjJ4pFFWcDrl";
                    strArr2[7] = "aKhyH6I995l1LklLucgRLjJ4pFFWcDrl";
                    return;
                }
                return;
            }
        }
        A1K();
        if (this.A06 != null) {
            IT.A02(A0a(671, 12, 16));
            while (A0r(j, j2)) {
            }
            while (A0o()) {
            }
            IT.A00();
        } else {
            this.A0U.A07 += A11(j);
            this.A0Y.A07();
            int iA122 = A12(this.A0W, this.A0Y, false);
            if (iA122 == -5) {
                A7 a7 = this.A0W;
                if (A0e[7].charAt(4) != 'H') {
                    throw new RuntimeException();
                }
                String[] strArr3 = A0e;
                strArr3[7] = "H5HsHl4f2eN3vdaE4L0NqH64hfjdivD8";
                strArr3[7] = "H5HsHl4f2eN3vdaE4L0NqH64hfjdivD8";
                A1N(a7.A00);
            } else if (iA122 == -4) {
                C1662Hr.A04(this.A0Y.A04());
                this.A0M = true;
                A0e();
            }
        }
        this.A0U.A00();
    }

    @Override // com.facebook.ads.redexgen.X.AS
    public final int ADl(Format format) throws C14789u {
        try {
            return A1D(this.A0a, this.A0Z, format);
        } catch (C1556Dh e2) {
            throw C14789u.A01(e2, A10());
        }
    }

    @Override // com.facebook.ads.redexgen.X.CT, com.facebook.ads.redexgen.X.AS
    public final int ADn() {
        return 8;
    }
}
