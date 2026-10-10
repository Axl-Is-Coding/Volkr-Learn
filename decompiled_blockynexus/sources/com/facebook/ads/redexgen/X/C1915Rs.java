package com.facebook.ads.redexgen.X;

import android.util.Log;
import androidx.annotation.Nullable;
import com.facebook.ads.AdError;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.EnumSet;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Rs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1915Rs implements InterfaceC12811q {
    public static byte[] A07;
    public static final String A08;
    public long A00 = -1;
    public C1580Ej A01;
    public boolean A02;
    public boolean A03;
    public final C2026Wb A04;
    public final InterstitialAdExtendedListener A05;
    public final C12821r A06;

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 110);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A07 = new byte[]{-59, -14, -92, -27, -24, -92, -16, -13, -27, -24, -92, -19, -9, -92, -27, -16, -10, -23, -27, -24, -3, -92, -19, -14, -92, -12, -10, -13, -21, -10, -23, -9, -9, -78, -92, -35, -13, -7, -92, -9, -20, -13, -7, -16, -24, -92, -5, -27, -19, -8, -92, -22, -13, -10, -92, -27, -24, -48, -13, -27, -24, -23, -24, -84, -83, -92, -8, -13, -92, -26, -23, -92, -25, -27, -16, -16, -23, -24, -4, 33, 39, 24, 37, 38, 39, 28, 39, 28, 20, 31, -45, 31, 34, 20, 23, -45, 22, 20, 31, 31, 24, 23, -45, 42, 27, 28, 31, 24, -45, 38, 27, 34, 42, 28, 33, 26, -45, 28, 33, 39, 24, 37, 38, 39, 28, 39, 28, 20, 31, -31, ci.k, 28, 21};
    }

    static {
        A06();
        A08 = C1915Rs.class.getSimpleName();
    }

    public C1915Rs(C12821r c12821r, InterfaceC12891y interfaceC12891y, String str) {
        this.A06 = c12821r;
        this.A04 = c12821r.A05();
        this.A05 = new S1(str, interfaceC12891y, this);
    }

    public final long A09() {
        C1580Ej c1580Ej = this.A01;
        if (c1580Ej != null) {
            return c1580Ej.A0F();
        }
        return -1L;
    }

    public final void A0A() {
        C1580Ej c1580Ej = this.A01;
        if (c1580Ej != null) {
            c1580Ej.A0R(new C1914Rr(this));
            this.A01.A0W(true);
            this.A01 = null;
            this.A03 = false;
            this.A02 = false;
        }
    }

    public final void A0B(@Nullable EnumSet<CacheFlag> enumSet, @Nullable String str) {
        this.A00 = System.currentTimeMillis();
        if (!this.A03 && this.A01 != null) {
            Log.w(A08, A05(0, 78, 22));
        }
        this.A03 = false;
        if (this.A02 && !C1693Iy.A0d(this.A04)) {
            this.A04.A04().A8H(A05(130, 3, 62), C8Y.A0B, new C8Z(A05(78, 52, 69)));
            AdErrorType adErrorType = AdErrorType.LOAD_CALLED_WHILE_SHOWING_AD;
            this.A04.A0A().A2d(LP.A01(this.A00), adErrorType.getErrorCode(), adErrorType.getDefaultErrorMessage());
            this.A05.onError(this.A06.A01(), new AdError(adErrorType.getErrorCode(), adErrorType.getDefaultErrorMessage()));
            return;
        }
        C1580Ej c1580Ej = this.A01;
        if (c1580Ej != null) {
            c1580Ej.A0R(new C1911Ro(this));
            this.A01.A0L();
            this.A01 = null;
        }
        C12741j c12741j = new C12741j(this.A06.A09(), C1704Jl.A01(this.A04.getResources().getDisplayMetrics()), AdPlacementType.INTERSTITIAL, EnumC1701Ji.A08, 1, enumSet);
        c12741j.A05(this.A06.A07());
        c12741j.A06(this.A06.A08());
        c12741j.A03(this.A06.A03());
        this.A01 = new C1580Ej(this.A04, c12741j);
        this.A01.A0R(new C1913Rq(this));
        this.A01.A0T(str);
    }

    public final boolean A0C() {
        C1580Ej c1580Ej = this.A01;
        return c1580Ej == null || c1580Ej.A0X();
    }

    public final boolean A0D() {
        return this.A03;
    }

    public final boolean A0E() {
        AdError adError = AdError.SHOW_CALLED_BEFORE_LOAD_ERROR;
        if (!this.A03) {
            this.A04.A0A().A2d(LP.A01(this.A00), adError.getErrorCode(), adError.getErrorMessage());
            this.A05.onError(this.A06.A01(), adError);
            return false;
        }
        C1580Ej c1580Ej = this.A01;
        if (c1580Ej == null) {
            this.A04.A04().A8H(A05(130, 3, 62), C8Y.A0H, new C8Z(AdErrorType.INTERSTITIAL_CONTROLLER_IS_NULL.getDefaultErrorMessage()));
            this.A04.A0A().A2d(LP.A01(this.A00), adError.getErrorCode(), adError.getErrorMessage());
            this.A05.onError(this.A06.A01(), adError);
            return false;
        }
        c1580Ej.A0K();
        this.A02 = true;
        this.A03 = false;
        return true;
    }
}
