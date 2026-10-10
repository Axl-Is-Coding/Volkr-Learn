package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.AdError;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.proguard.annotations.DoNotStrip;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class RA implements InterfaceC12510m {
    public static byte[] A0B;
    public static String[] A0C;
    public static final String A0D;
    public InterfaceC12590u A00;
    public RH A01;
    public C1534Cl A02;

    @Nullable
    public J5 A03;

    @Nullable
    @DoNotStrip
    public NJ A04;

    @Nullable
    public C2044Wt A05;
    public String A06;
    public Map<String, Object> A07;
    public boolean A08 = false;
    public boolean A09 = false;
    public boolean A0A = false;

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 19);
            if (A0C[2].length() == 29) {
                throw new RuntimeException();
            }
            String[] strArr = A0C;
            strArr[3] = "viF0h1063r6cbXDqGfnWrC6qPBVBGzAv";
            strArr[7] = "3ywSXssJKLxMazlfVUMLvW6ymO505mlb";
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A0B = new byte[]{-27, -30, -11, -30, -40, -39, -38, -35, -30, -35, -24, -35, -29, -30, -69, -84, -65, -69, 118, -81, -69, -76, -77, 5, 4, -10, -67, -56};
    }

    public static void A08() {
        A0C = new String[]{"1VlIdrj3fRAASVh0IRQbA", "AKXoeI10d8PJONEXEmQHjWIEkAB2E", "HfXt1ktTFXNYFvURT1ePpe", "VNbNAjzqH3UXN3t9RrTP5z6I5Qa6gPQJ", "DeawL9PzUIlDumNdtXISYTaSpfy6P3Cj", "KNbO6MhxkLbBAZAqlm1H7U8Ouut8mEhI", "i536pd2CEb7n0lc", "TelURl5RBqiFivFSJRRvco6RCKborqoX"};
    }

    static {
        A08();
        A07();
        A0D = RA.class.getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A06() {
        if (this.A00 != null && this.A08 && (this.A09 || !this.A0A)) {
            this.A00.A9K(this, this.A05);
        }
        this.A02.A0A().A3Y(this.A00 != null);
        if (A0C[2].length() == 29) {
            throw new RuntimeException();
        }
        String[] strArr = A0C;
        strArr[2] = "DQYu3GBVfiN4Ml";
        strArr[2] = "DQYu3GBVfiN4Ml";
    }

    private void A0A(C14508r c14508r) {
        RF rfA00 = RF.A00((JSONObject) this.A07.get(A05(0, 4, 110)));
        this.A06 = rfA00.A5q();
        if (C12470i.A04(this.A02, rfA00, this.A03)) {
            this.A02.A0A().A41();
            this.A00.A9L(this, AdError.internalError(AdError.INTERNAL_ERROR_2006));
            return;
        }
        this.A04 = new C1587Eq(this, rfA00);
        this.A05 = new C2044Wt(this.A02, new WeakReference(this.A04), c14508r.A04());
        this.A05.A0E(c14508r.A07(), c14508r.A08());
        R9 r9 = new R9(this);
        C1534Cl c1534Cl = this.A02;
        J5 j5 = this.A03;
        C2044Wt c2044Wt = this.A05;
        this.A01 = new RH(c1534Cl, j5, c2044Wt, c2044Wt.getViewabilityChecker(), r9);
        this.A01.A09(rfA00);
        this.A05.loadDataWithBaseURL(NM.A00(), rfA00.A05(), A05(14, 9, 52), A05(23, 5, 125), null);
        this.A08 = true;
        A06();
    }

    public final void A0D(C1534Cl c1534Cl, J5 j5, EnumC1701Ji enumC1701Ji, InterfaceC12590u interfaceC12590u, Map<String, Object> map) {
        c1534Cl.A0A().A3X();
        this.A02 = c1534Cl;
        this.A03 = j5;
        this.A00 = interfaceC12590u;
        this.A07 = map;
        this.A0A = C1693Iy.A11(this.A02.getApplicationContext());
        A0A((C14508r) this.A07.get(A05(4, 10, 97)));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12510m
    public final String A5q() {
        return this.A06;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12510m
    public final AdPlacementType A6p() {
        return AdPlacementType.BANNER;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12510m
    public final void onDestroy() {
        this.A02.A0A().A3V(this.A05 != null);
        C2044Wt c2044Wt = this.A05;
        if (c2044Wt != null) {
            c2044Wt.destroy();
            this.A05 = null;
            this.A04 = null;
        }
    }
}
