package com.facebook.ads.redexgen.X;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.umeng.analytics.pro.ci;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Rh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1904Rh implements K5 {
    public static byte[] A0E;
    public static String[] A0F;
    public InterfaceC12761l A00;
    public C14498q A01;
    public String A02;
    public boolean A03;
    public final int A04;
    public final Handler A05;

    @Nullable
    public final AdSize A06;
    public final C12560r A07;
    public final C2026Wb A08;
    public final J5 A09;
    public final EnumC1702Jj A0A;
    public final K6 A0B;
    public final Runnable A0C;
    public final String A0D;

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0E, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A0F[2].length() != 10) {
                throw new RuntimeException();
            }
            String[] strArr = A0F;
            strArr[1] = "uoxYJqIRleds8fPMMv";
            strArr[1] = "uoxYJqIRleds8fPMMv";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 87);
            i4++;
        }
    }

    public static void A05() {
        byte[] bArr = {54, 51, 70, 51, -20, -19, -18, -15, -10, -15, -4, -15, -9, -10, 8, 9, -70, 10, 6, -5, -3, -1, 7, -1, 8, ci.l, -70, 3, 8, -70, 12, -1, ci.k, 10, 9, 8, ci.k, -1};
        if (A0F[0].length() != 2) {
            throw new RuntimeException();
        }
        String[] strArr = A0F;
        strArr[1] = "dKV76OJFyRmVPWeRzZ";
        strArr[1] = "dKV76OJFyRmVPWeRzZ";
        A0E = bArr;
    }

    public static void A06() {
        A0F = new String[]{"Um", "5O6Pi5UhekEiJBNtL2", "ByBiFstlzS", "VNZICTTmM6bBZ", "I3ykA2cHAONkN", "xnUs6VMzToWHuFoC", "Qkjm3fg24P6DD7pmZ7L4neN1zLjqdukp", "LFB8Dcv49A6aPeUL"};
    }

    static {
        A06();
        A05();
        LZ.A02();
    }

    public C1904Rh(C2026Wb c2026Wb, String str, EnumC1702Jj enumC1702Jj, @Nullable AdSize adSize, int i) {
        this.A08 = c2026Wb;
        this.A0D = str;
        this.A0A = enumC1702Jj;
        this.A06 = adSize;
        this.A04 = i;
        this.A0B = new K6(this.A08);
        this.A0B.A0R(this);
        this.A07 = new C12560r();
        this.A03 = true;
        this.A05 = new Handler();
        this.A0C = new C1578Eh(this);
        this.A09 = c2026Wb.A06();
        DynamicLoaderFactory.makeLoader(this.A08).getInitApi().onAdLoadInvoked(this.A08);
    }

    private List<RD> A04() {
        C14498q c14498q = this.A01;
        ArrayList arrayList = new ArrayList(c14498q.A02());
        for (C14478o c14478oA04 = c14498q.A04(); c14478oA04 != null; c14478oA04 = c14498q.A04()) {
            InterfaceC12510m interfaceC12510mA00 = this.A07.A00(AdPlacementType.NATIVE);
            if (interfaceC12510mA00 != null && interfaceC12510mA00.A6p() == AdPlacementType.NATIVE) {
                HashMap map = new HashMap();
                map.put(A03(0, 4, 123), c14478oA04.A06());
                map.put(A03(4, 10, 49), c14498q.A05());
                RD rd = (RD) interfaceC12510mA00;
                rd.A0Y(this.A08, new C1903Rg(this, arrayList, rd), this.A09, map, C2213bT.A0I());
            }
        }
        return arrayList;
    }

    public final void A07() {
        this.A03 = false;
        this.A05.removeCallbacks(this.A0C);
    }

    public final void A08() {
        try {
            C1707Jo c1707Jo = new C1707Jo(this.A08, null, null, null);
            C2026Wb c2026Wb = this.A08;
            String str = this.A0D;
            AdSize adSize = this.A06;
            this.A0B.A0Q(new K3(c2026Wb, str, adSize != null ? new LA(adSize.getHeight(), this.A06.getWidth()) : null, this.A0A, null, this.A04, AdSettings.isTestMode(this.A08), AdSettings.isMixedAudience(), c1707Jo, LG.A01(C1693Iy.A0H(this.A08)), this.A02, null));
        } catch (C1698Je e2) {
            A9p(C1697Jd.A03(e2));
        }
    }

    public final void A09(InterfaceC12761l interfaceC12761l) {
        this.A00 = interfaceC12761l;
    }

    public final void A0A(String str) {
        this.A02 = str;
    }

    public final boolean A0B() {
        C14498q c14498q = this.A01;
        return c14498q == null || c14498q.A0A();
    }

    @Override // com.facebook.ads.redexgen.X.K5
    public final void A9p(C1697Jd c1697Jd) {
        if (this.A03) {
            this.A05.postDelayed(this.A0C, 1800000L);
        }
        InterfaceC12761l interfaceC12761l = this.A00;
        if (A0F[2].length() != 10) {
            throw new RuntimeException();
        }
        String[] strArr = A0F;
        strArr[2] = "yGn7NPCZVX";
        strArr[2] = "yGn7NPCZVX";
        if (interfaceC12761l != null) {
            interfaceC12761l.A9p(c1697Jd);
        }
    }

    @Override // com.facebook.ads.redexgen.X.K5
    public final void ABM(C2166ag c2166ag) {
        C14498q c14498qA00 = c2166ag.A00();
        if (c14498qA00 != null) {
            if (this.A03) {
                long jA0A = c14498qA00.A05().A0A();
                if (jA0A == 0) {
                    jA0A = 1800000;
                }
                this.A05.postDelayed(this.A0C, jA0A);
            }
            this.A01 = c14498qA00;
            List<RD> listA04 = A04();
            if (this.A00 != null) {
                if (listA04.isEmpty()) {
                    this.A00.A9p(C1697Jd.A02(AdErrorType.NO_FILL, A03(0, 0, 68)));
                    return;
                } else {
                    this.A00.AAb(listA04);
                    return;
                }
            }
            return;
        }
        throw new IllegalStateException(A03(14, 24, 67));
    }
}
