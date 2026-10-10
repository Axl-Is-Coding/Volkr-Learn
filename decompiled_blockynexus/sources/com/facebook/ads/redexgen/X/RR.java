package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.ads.AdError;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.RewardData;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class RR implements InterfaceC12600v {
    public static byte[] A04;
    public static String[] A05;

    @Nullable
    public AnonymousClass77 A00;
    public NR A01 = NR.A06;
    public final RN A02;
    public final C1X A03;

    static {
        A06();
        A05();
    }

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 96);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A04 = new byte[]{-97, -39, -27, -34, -35, -81, -44, -38, -53, -40, -44, -57, -46, -122, -85, -40, -40, -43, -40, -122, -104, -106, -106, -100, -122, -35, -49, -38, -50, -43, -37, -38, -122, -57, -122, -36, -57, -46, -49, -54, -122, -89, -54, -81, -44, -52, -43, -108, 31, 34, 29, 34, 31, 50, 31, 29, 32, 51, 44, 34, 42, 35, -45, -30, -37, -58, -61, -42, -61, -41, -40, -39, -36, -31, -36, -25, -36, -30, -31, -38, -33, -27, -42, -29, -28, -27, -38, -27, -38, -46, -35};
    }

    public static void A06() {
        A05 = new String[]{"jJreqFAWfQsm2UlBXjWleQZy51A8w9r3", "B5vxrqY9e1pfFDILbPSJEQZe5Zep9JAF", "7hwRhDIA2xM98ucsNVPICP0872", "8yYdfjKxcW1uK5E8nS4F9bT", "cwoTvwLLOWGZrFwonmn2qn9xu", "wuc4L", "VoE60CbUCih", "1JGxuEjawtyxaKItdz1AQ1lnM"};
    }

    public RR(C2026Wb c2026Wb, Map<String, Object> map, C1X c1x, @Nullable String str) {
        this.A02 = A01(c2026Wb, map, str, (JSONObject) map.get(A04(65, 4, 2)));
        this.A03 = c1x;
    }

    @Nullable
    private AdError A00(C2026Wb c2026Wb) {
        if (this.A02.A0W().isEmpty()) {
            c2026Wb.A04().A8H(A04(62, 3, 18), C8Y.A0O, new C8Z(A04(5, 43, 6)));
            return AdError.internalError(AdError.INTERNAL_ERROR_2006);
        }
        return null;
    }

    public static RN A01(C2026Wb c2026Wb, Map<String, Object> map, @Nullable String str, JSONObject jSONObject) {
        RN adDataBundle = RN.A01(jSONObject, c2026Wb);
        adDataBundle.A0b(str);
        C14508r c14508r = (C14508r) map.get(A04(69, 10, 19));
        if (c14508r != null) {
            adDataBundle.A0Z(c14508r.A06());
        }
        return adDataBundle;
    }

    private AnonymousClass77 A03(C2026Wb c2026Wb) {
        AnonymousClass77 anonymousClass77 = this.A00;
        return anonymousClass77 != null ? anonymousClass77 : new AnonymousClass77(c2026Wb);
    }

    private void A07(C2026Wb c2026Wb, EnumSet<CacheFlag> enumSet) {
        C1R c1rA06 = this.A02.A0M().A0E().A06();
        A09(c1rA06 != null ? c1rA06.A0B() : NR.A06);
        RQ rq = new RQ(this);
        AnonymousClass77 anonymousClass77 = new AnonymousClass77(c2026Wb);
        C12671c c12671c = new C12671c(this, this.A02, A04(79, 12, 17), anonymousClass77);
        if (c12671c.A09()) {
            anonymousClass77.A0X(new JC(this.A02.A0Q(), c2026Wb.A06()));
            c12671c.A08();
            return;
        }
        RN rn = this.A02;
        if (A05[5].length() != 5) {
            throw new RuntimeException();
        }
        String[] strArr = A05;
        strArr[5] = "kxumv";
        strArr[5] = "kxumv";
        C12721h.A03(c2026Wb, rn, true, rq);
    }

    private void A08(C2026Wb c2026Wb, EnumSet<CacheFlag> enumSet) {
        AnonymousClass77 anonymousClass77A03 = A03(c2026Wb);
        JC funnelLoggingHandler = new JC(this.A02.A0Q(), c2026Wb.A06());
        anonymousClass77A03.A0X(funnelLoggingHandler);
        RN rn = this.A02;
        String strA04 = A04(79, 12, 17);
        C12671c c12671c = new C12671c(this, rn, strA04, anonymousClass77A03);
        if (c12671c.A09()) {
            c12671c.A08();
            return;
        }
        boolean z = !TextUtils.isEmpty(this.A02.A0R());
        if (z) {
            AnonymousClass76 anonymousClass76 = new AnonymousClass76(this.A02.A0R(), this.A02.A0U(), strA04);
            anonymousClass76.A04 = true;
            anonymousClass76.A03 = A04(0, 5, 17);
            anonymousClass77A03.A0T(anonymousClass76);
        }
        anonymousClass77A03.A0S(new AnonymousClass74(this.A02.A0O().A01(), OM.A04, OM.A04, this.A02.A0U(), A04(79, 12, 17)));
        boolean zContains = enumSet.contains(CacheFlag.VIDEO);
        int i = 0;
        for (AnonymousClass18 anonymousClass18 : this.A02.A0W()) {
            AnonymousClass74 anonymousClass74 = new AnonymousClass74(anonymousClass18.A0E().A07(), C12681d.A00(anonymousClass18.A0E()), C12681d.A01(anonymousClass18.A0E()), this.A02.A0U(), A04(79, 12, 17));
            if (i == 0) {
                anonymousClass77A03.A0R(anonymousClass74);
            } else {
                anonymousClass77A03.A0S(anonymousClass74);
            }
            Iterator<String> it = anonymousClass18.A0H().A00().iterator();
            while (it.hasNext()) {
                anonymousClass77A03.A0S(new AnonymousClass74(it.next(), -1, -1, this.A02.A0U(), A04(79, 12, 17)));
            }
            if (zContains && !TextUtils.isEmpty(anonymousClass18.A0E().A08())) {
                AnonymousClass76 anonymousClass762 = new AnonymousClass76(anonymousClass18.A0E().A08(), this.A02.A0U(), A04(79, 12, 17), anonymousClass18.A0E().A05());
                anonymousClass762.A04 = false;
                if (i == 0) {
                    if (z) {
                        anonymousClass77A03.A0T(anonymousClass762);
                    } else {
                        anonymousClass77A03.A0W(anonymousClass762);
                    }
                } else if (z) {
                    anonymousClass77A03.A0U(anonymousClass762);
                } else {
                    anonymousClass77A03.A0V(anonymousClass762);
                }
            }
            i++;
        }
        anonymousClass77A03.A0Q(new RP(this), new AnonymousClass70(this.A02.A0U(), strA04));
    }

    private void A09(NR nr) {
        this.A01 = nr;
    }

    public final KC A0A() {
        if (!TextUtils.isEmpty(this.A02.A0R()) && Build.VERSION.SDK_INT >= 21) {
            KC kc = KC.A03;
            String[] strArr = A05;
            if (strArr[6].length() != strArr[2].length()) {
                String[] strArr2 = A05;
                strArr2[3] = "f4kXngrP8CD5dz";
                strArr2[3] = "f4kXngrP8CD5dz";
                return kc;
            }
        } else {
            if (this.A02.A0W().size() > 1) {
                return KC.A06;
            }
            RN rn = this.A02;
            String[] strArr3 = A05;
            if (strArr3[7].length() == strArr3[4].length()) {
                String[] strArr4 = A05;
                strArr4[3] = "ny";
                strArr4[3] = "ny";
                if (rn.A0M().A0E().A06() != null) {
                    return KC.A08;
                }
                boolean zA0G = A0G();
                String[] strArr5 = A05;
                if (strArr5[6].length() == strArr5[2].length()) {
                    throw new RuntimeException();
                }
                String[] strArr6 = A05;
                strArr6[3] = "JH";
                strArr6[3] = "JH";
                if (zA0G) {
                    KC kc2 = KC.A09;
                    if (A05[3].length() != 32) {
                        String[] strArr7 = A05;
                        strArr7[1] = "93R6MUXHMTxUt8WfLt1oZ3ea5zubl3sl";
                        strArr7[0] = "9xXPI1nVQC4CSUB4soKlPH985bh9DAt9";
                        return kc2;
                    }
                    String[] strArr8 = A05;
                    strArr8[3] = "ySAy4b6nQ";
                    strArr8[3] = "ySAy4b6nQ";
                    return kc2;
                }
                return KC.A07;
            }
        }
        throw new RuntimeException();
    }

    public final NR A0B() {
        return this.A01;
    }

    public final String A0C() {
        return this.A02.A0Q();
    }

    public final void A0D() {
        this.A03.ADu();
    }

    public final void A0E(Intent intent, RewardData rewardData, String str) {
        this.A02.A0a(rewardData);
        this.A02.A0d(str);
        intent.putExtra(A04(48, 14, 94), this.A02);
    }

    public final void A0F(C2026Wb c2026Wb, EnumSet<CacheFlag> enumSet) {
        AdError adErrorA00 = A00(c2026Wb);
        if (adErrorA00 != null) {
            this.A03.A92(adErrorA00);
            return;
        }
        this.A03.ACT();
        if (A0A() == KC.A08) {
            A07(c2026Wb, enumSet);
        } else {
            A08(c2026Wb, enumSet);
        }
    }

    public final boolean A0G() {
        return !TextUtils.isEmpty(this.A02.A0M().A0E().A08());
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12600v
    public final void A9O() {
        this.A03.A93();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12600v
    public final void A9P() {
        this.A03.A92(AdError.CACHE_ERROR);
    }
}
