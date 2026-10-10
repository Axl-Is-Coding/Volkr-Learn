package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import com.umeng.analytics.pro.ci;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
@TargetApi(16)
public final class C8 implements XX, AM, AK {
    public static byte[] A0O;
    public static String[] A0P;
    public float A00;
    public int A01;
    public int A02;
    public Surface A03;
    public SurfaceHolder A04;
    public TextureView A05;
    public Format A06;
    public Format A07;
    public C1495Al A08;
    public BU A09;
    public BU A0A;
    public F8 A0B;
    public List<G5> A0C;
    public boolean A0D;
    public final Handler A0E;
    public final XX A0F;
    public final SurfaceHolderCallbackC2051Xa A0G;
    public final C2054Xd A0H;
    public final CopyOnWriteArraySet<B1> A0I;
    public final CopyOnWriteArraySet<InterfaceC1564Dr> A0J;
    public final CopyOnWriteArraySet<G9> A0K;
    public final CopyOnWriteArraySet<InterfaceC1689Iu> A0L;
    public final CopyOnWriteArraySet<InterfaceC1680Il> A0M;
    public final XZ[] A0N;

    static {
        A0G();
        A0F();
    }

    public static String A07(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0O, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 58);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0F() {
        A0O = new byte[]{45, 23, 19, ci.l, 18, 27, 59, 6, 17, 46, 18, 31, 7, 27, 12, 9, 47, 40, 60, 59, 57, Utf8.REPLACEMENT_BYTE, ci.l, Utf8.REPLACEMENT_BYTE, 34, 46, 47, 40, Utf8.REPLACEMENT_BYTE, 22, 51, 41, 46, Utf8.REPLACEMENT_BYTE, 52, Utf8.REPLACEMENT_BYTE, 40, 122, 59, 54, 40, Utf8.REPLACEMENT_BYTE, 59, 62, 35, 122, 47, 52, 41, Utf8.REPLACEMENT_BYTE, 46, 122, 53, 40, 122, 40, Utf8.REPLACEMENT_BYTE, 42, 54, 59, 57, Utf8.REPLACEMENT_BYTE, 62, 116};
    }

    public static void A0G() {
        A0P = new String[]{"p1p2g9mbI7jG28uS1AIjZaN2DuNLisT4", "5M6TC2sONh3rGys5YKd78dMRKX2wOUqH", "h92WNkWPJTM", "jYXxaa6xf7axcTjhEWPmUH7zZsfwsjgI", "vYDSW5DyAu5jQwnIRgw24Ezub5gSEfu7", "VyMVayVAQGyPc0QthTR0tkMwCD52dsyF", "LU4FXKZXpKPxotYf", "puFnwNxTYtdaaLd9gUGAlTVzIEShK4ZY"};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bu != com.facebook.ads.internal.exoplayer2.drm.DrmSessionManager<com.facebook.ads.internal.exoplayer2.drm.FrameworkMediaCrypto> */
    public C8(AU au, H1 h1, A9 a9, @Nullable InterfaceC1521Bu<Y1> interfaceC1521Bu) {
        this(au, h1, a9, interfaceC1521Bu, new C1484Aa());
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bu != com.facebook.ads.internal.exoplayer2.drm.DrmSessionManager<com.facebook.ads.internal.exoplayer2.drm.FrameworkMediaCrypto> */
    public C8(AU au, H1 h1, A9 a9, @Nullable InterfaceC1521Bu<Y1> interfaceC1521Bu, C1484Aa c1484Aa) {
        this(au, h1, a9, interfaceC1521Bu, c1484Aa, InterfaceC1665Hu.A00);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bu != com.facebook.ads.internal.exoplayer2.drm.DrmSessionManager<com.facebook.ads.internal.exoplayer2.drm.FrameworkMediaCrypto> */
    public C8(AU au, H1 h1, A9 a9, @Nullable InterfaceC1521Bu<Y1> interfaceC1521Bu, C1484Aa c1484Aa, InterfaceC1665Hu interfaceC1665Hu) {
        this.A0G = new SurfaceHolderCallbackC2051Xa(this);
        this.A0M = new CopyOnWriteArraySet<>();
        this.A0K = new CopyOnWriteArraySet<>();
        this.A0J = new CopyOnWriteArraySet<>();
        this.A0L = new CopyOnWriteArraySet<>();
        this.A0I = new CopyOnWriteArraySet<>();
        this.A0E = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        Handler handler = this.A0E;
        SurfaceHolderCallbackC2051Xa surfaceHolderCallbackC2051Xa = this.A0G;
        this.A0N = au.A4Q(handler, surfaceHolderCallbackC2051Xa, surfaceHolderCallbackC2051Xa, surfaceHolderCallbackC2051Xa, surfaceHolderCallbackC2051Xa, interfaceC1521Bu);
        this.A00 = 1.0f;
        this.A01 = 0;
        this.A08 = C1495Al.A04;
        this.A02 = 1;
        this.A0C = Collections.emptyList();
        this.A0F = A02(this.A0N, h1, a9, interfaceC1665Hu);
        this.A0H = c1484Aa.A00(this.A0F, interfaceC1665Hu);
        A3H(this.A0H);
        this.A0L.add(this.A0H);
        this.A0I.add(this.A0H);
        A0J(this.A0H);
        if (interfaceC1521Bu instanceof C2073Xw) {
            ((C2073Xw) interfaceC1521Bu).A05(this.A0E, this.A0H);
        }
    }

    private final XX A02(XZ[] xzArr, H1 h1, A9 a9, InterfaceC1665Hu interfaceC1665Hu) {
        return new CQ(xzArr, h1, a9, interfaceC1665Hu);
    }

    private void A0E() {
        TextureView textureView = this.A05;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.A0G) {
                Log.w(A07(0, 15, 68), A07(15, 49, 96));
            } else {
                this.A05.setSurfaceTextureListener(null);
            }
            this.A05 = null;
        }
        SurfaceHolder surfaceHolder = this.A04;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.A0G);
            this.A04 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0H(Surface surface, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (XZ xz : this.A0N) {
            int iA7H = xz.A7H();
            String[] strArr = A0P;
            if (strArr[5].charAt(24) == strArr[4].charAt(24)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0P;
            strArr2[6] = "VrJ3McZcw7cn2zeT";
            strArr2[0] = "MNepmlV8OvsHi61EfIBswCx5NcPOIPrl";
            if (iA7H == 2) {
                arrayList.add(this.A0F.A4K(xz).A06(1).A07(surface).A05());
            }
        }
        Surface surface2 = this.A03;
        if (surface2 != null && surface2 != surface) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((AQ) it.next()).A0C();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            if (this.A0D) {
                this.A03.release();
            }
        }
        this.A03 = surface;
        if (A0P[7].charAt(22) != 'V') {
            throw new RuntimeException();
        }
        String[] strArr3 = A0P;
        strArr3[5] = "BcNzrhvciYYCifYD3J0kGNpt4Q56t2ws";
        strArr3[4] = "LBzJc3KMaCoazXjGhEegCXyOf3paMmXp";
        this.A0D = z;
    }

    private final void A0J(InterfaceC1564Dr interfaceC1564Dr) {
        this.A0J.add(interfaceC1564Dr);
    }

    public final int A0K() {
        return this.A01;
    }

    public final Format A0L() {
        return this.A06;
    }

    @Nullable
    public final Format A0M() {
        return this.A07;
    }

    public final void A0N() {
        ADi(false);
    }

    public final void A0O(float f2) {
        this.A00 = f2;
        for (XZ xz : this.A0N) {
            String[] strArr = A0P;
            if (strArr[5].charAt(24) == strArr[4].charAt(24)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0P;
            strArr2[6] = "TZ1OBcEbhXggSiRE";
            strArr2[0] = "o47SCfAcsD46THYYRPii4HELThPbmwG8";
            if (xz.A7H() == 1) {
                this.A0F.A4K(xz).A06(2).A07(Float.valueOf(f2)).A05();
            }
        }
    }

    public final void A0P(Surface surface) {
        A0E();
        A0H(surface, false);
    }

    public final void A0Q(F8 f8) {
        AC2(f8, true, true);
    }

    public final void A0R(InterfaceC1680Il interfaceC1680Il) {
        this.A0M.add(interfaceC1680Il);
    }

    @Override // com.facebook.ads.redexgen.X.AN
    public final void A3H(AI ai) {
        this.A0F.A3H(ai);
    }

    @Override // com.facebook.ads.redexgen.X.XX
    public final AQ A4K(AP ap) {
        return this.A0F.A4K(ap);
    }

    @Override // com.facebook.ads.redexgen.X.AN
    public final int A5d() {
        return this.A0F.A5d();
    }

    @Override // com.facebook.ads.redexgen.X.AN
    public final long A5e() {
        return this.A0F.A5e();
    }

    @Override // com.facebook.ads.redexgen.X.AN
    public final long A5v() {
        return this.A0F.A5v();
    }

    @Override // com.facebook.ads.redexgen.X.AN
    public final int A5x() {
        return this.A0F.A5x();
    }

    @Override // com.facebook.ads.redexgen.X.AN
    public final int A5y() {
        return this.A0F.A5y();
    }

    @Override // com.facebook.ads.redexgen.X.AN
    public final long A60() {
        return this.A0F.A60();
    }

    @Override // com.facebook.ads.redexgen.X.AN
    public final AZ A62() {
        return this.A0F.A62();
    }

    @Override // com.facebook.ads.redexgen.X.AN
    public final int A63() {
        return this.A0F.A63();
    }

    @Override // com.facebook.ads.redexgen.X.AN
    public final long A6B() {
        return this.A0F.A6B();
    }

    @Override // com.facebook.ads.redexgen.X.AN
    public final boolean A6r() {
        return this.A0F.A6r();
    }

    @Override // com.facebook.ads.redexgen.X.XX
    public final void AC2(F8 f8, boolean z, boolean z2) {
        F8 f82 = this.A0B;
        if (f82 != f8) {
            if (f82 != null) {
                f82.ACf(this.A0H);
                this.A0H.A08();
            }
            f8.A3F(this.A0E, this.A0H);
            this.A0B = f8;
        }
        this.A0F.AC2(f8, z, z2);
    }

    @Override // com.facebook.ads.redexgen.X.AN
    public final void ACW() {
        this.A0F.ACW();
        A0E();
        Surface surface = this.A03;
        if (surface != null) {
            if (this.A0D) {
                surface.release();
            }
            this.A03 = null;
        }
        F8 f8 = this.A0B;
        if (f8 != null) {
            f8.ACf(this.A0H);
        }
        this.A0C = Collections.emptyList();
    }

    @Override // com.facebook.ads.redexgen.X.AN
    public final void AD4(long j) {
        this.A0H.A07();
        this.A0F.AD4(j);
    }

    @Override // com.facebook.ads.redexgen.X.AN
    public final void AD5() {
        this.A0H.A07();
        this.A0F.AD5();
    }

    @Override // com.facebook.ads.redexgen.X.AN
    public final void ADL(boolean z) {
        this.A0F.ADL(z);
    }

    @Override // com.facebook.ads.redexgen.X.AN
    public final void ADi(boolean z) {
        this.A0F.ADi(z);
        F8 f8 = this.A0B;
        if (f8 != null) {
            f8.ACf(this.A0H);
            this.A0B = null;
            this.A0H.A08();
        }
        this.A0C = Collections.emptyList();
        String[] strArr = A0P;
        if (strArr[6].length() == strArr[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0P;
        strArr2[5] = "8NqoZsSfBCZ1v43okD4Pix8d8oY1Moxp";
        strArr2[4] = "VfYOa1CKuZhM9jsFhHY6jw4UB0OoLmrV";
    }
}
