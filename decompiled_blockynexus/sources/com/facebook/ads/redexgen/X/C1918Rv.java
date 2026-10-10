package com.facebook.ads.redexgen.X;

import android.util.Log;
import androidx.annotation.Nullable;
import com.facebook.ads.AdError;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.RewardData;
import com.facebook.ads.S2SRewardedVideoAdExtendedListener;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Rv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1918Rv implements InterfaceC12811q {
    public static byte[] A07;
    public static String[] A08;
    public static final String A09;
    public Eg A02;

    @Nullable
    public String A03;
    public final S2SRewardedVideoAdExtendedListener A05;
    public final C12861v A06;
    public int A00 = 0;
    public boolean A04 = false;
    public long A01 = -1;

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 93);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A07 = new byte[]{120, 87, 25, 88, 93, 25, 85, 86, 88, 93, 25, 80, 74, 25, 88, 85, 75, 92, 88, 93, 64, 25, 80, 87, 25, 73, 75, 86, 94, 75, 92, 74, 74, 23, 25, 96, 86, 76, 25, 74, 81, 86, 76, 85, 93, 25, 78, 88, 80, 77, 25, 95, 86, 75, 25, 88, 93, 117, 86, 88, 93, 92, 93, 17, ci.n, 25, 77, 86, 25, 91, 92, 25, 90, 88, 85, 85, 92, 93, 47, 24, 24, 5, 24, 74, 6, 5, 11, ci.l, 3, 4, ci.k, 74, 24, ci.m, 29, 11, 24, ci.l, ci.m, ci.l, 74, 28, 3, ci.l, ci.m, 5, 74, 11, ci.l, 92, 77, 84};
        if (A08[6].length() != 24) {
            throw new RuntimeException();
        }
        String[] strArr = A08;
        strArr[4] = "OGOVhUIoezz1oHK";
        strArr[0] = "xl2MkcRK0CWEWUY";
    }

    public static void A07() {
        A08 = new String[]{"gd6Snq8TqC5qGLc", "5Vo8FrFWo5Fl4YG5W1yHT6ZfMsOXSACT", "HYpFHiAeuVvng5d4eXQK0awgijL0SEef", "zgL9OdntC9Jt", "c4pha1QVXZPHNWU", "oPtBq8V8zceab2K03f0YSkruz1vfGvQp", "tGZii7gSURWSZ1CI0FSKqsks", "YmWpveYB3lCv"};
    }

    static {
        A07();
        A06();
        A09 = C1918Rv.class.getSimpleName();
    }

    public C1918Rv(C12861v c12861v, InterfaceC12891y interfaceC12891y, String str) {
        this.A06 = c12861v;
        this.A05 = new S2(str, interfaceC12891y, this, c12861v);
    }

    private void A09(@Nullable String str, @Nullable AdExperienceType adExperienceType, boolean z) {
        if (!this.A04 && this.A02 != null) {
            Log.w(A09, A04(0, 78, 100));
        }
        A0A(false);
        this.A04 = false;
        C12741j c12741j = new C12741j(this.A06.A0C, EnumC1702Jj.A06, AdPlacementType.REWARDED_VIDEO, EnumC1701Ji.A08, 1);
        c12741j.A07(z);
        c12741j.A05(this.A06.A06);
        c12741j.A06(this.A06.A07);
        this.A02 = new Eg(this.A06.A0B, c12741j);
        this.A02.A0R(new C1916Rt(this));
        this.A02.A0U(str, adExperienceType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0A(boolean z) {
        Eg eg = this.A02;
        if (eg != null) {
            eg.A0R(new C1917Ru(this));
            this.A02.A0W(z);
            this.A02 = null;
        }
    }

    public final long A0C() {
        Eg eg = this.A02;
        if (eg != null) {
            return eg.A0F();
        }
        return -1L;
    }

    public final void A0D() {
        A0A(true);
    }

    public final void A0E(RewardData rewardData) {
        this.A06.A03 = rewardData;
        if (this.A04) {
            this.A02.A0Y(rewardData);
        }
    }

    public final void A0F(@Nullable String str, @Nullable AdExperienceType adExperienceType, boolean z) {
        this.A01 = System.currentTimeMillis();
        try {
            A09(str, adExperienceType, z);
        } catch (Exception e2) {
            Log.e(A09, A04(78, 31, 55), e2);
            this.A06.A0B.A04().A8H(A04(109, 3, 96), C8Y.A0Q, new C8Z(e2));
            AdError adErrorInternalError = AdError.internalError(AdError.INTERNAL_ERROR_2004);
            this.A06.A0B.A0A().A2d(LP.A01(this.A01), adErrorInternalError.getErrorCode(), adErrorInternalError.getErrorMessage());
            this.A05.onError(this.A06.A01(), adErrorInternalError);
        }
    }

    public final boolean A0G() {
        Eg eg = this.A02;
        return eg == null || eg.A0X();
    }

    public final boolean A0H() {
        return this.A04;
    }

    public final boolean A0I(int i) {
        if (!this.A04) {
            this.A05.onError(this.A06.A01(), AdError.SHOW_CALLED_BEFORE_LOAD_ERROR);
            String[] strArr = A08;
            if (strArr[4].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[2] = "i4TgsteijYTgF3ZXWgh52CAoLdUIST6S";
            strArr2[1] = "KfQZimx5EO3wO5BoFkpX8kIEmrokSzla";
            return false;
        }
        Eg eg = this.A02;
        if (eg != null) {
            eg.A08.A02(i);
            this.A02.A0K();
            this.A04 = false;
            return true;
        }
        this.A04 = false;
        return false;
    }
}
