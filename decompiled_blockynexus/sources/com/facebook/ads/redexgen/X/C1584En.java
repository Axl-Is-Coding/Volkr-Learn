package com.facebook.ads.redexgen.X;

import android.content.ContentResolver;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.ads.AdError;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.En, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1584En extends RJ implements InterfaceC12600v {
    public static byte[] A0C;
    public static String[] A0D;
    public long A00;
    public AnonymousClass11 A01;
    public AnonymousClass12 A02;
    public AnonymousClass15 A03;
    public C2026Wb A04;
    public JC A05;
    public KC A06;
    public String A07;

    @Nullable
    public String A08;
    public String A09;
    public final String A0A = UUID.randomUUID().toString();
    public final AtomicBoolean A0B = new AtomicBoolean();

    static {
        A06();
        A05();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 126);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A0C = new byte[]{56, 52, 54, 54, 48, 57, 48, 39, 58, 56, 48, 33, 48, 39, 10, 39, 58, 33, 52, 33, 60, 58, 59, 110, 97, 100, 104, 99, 121, 89, 98, 102, 104, 99, ci.l, 11, 30, 11, 77, 76, 79, 64, 71, 64, 93, 64, 70, 71, 17, 25, 24, 21, 29, 8, 21, 19, 18, 56, 29, 8, 29, 87, 75, 70, 68, 66, 74, 66, 73, 83, 110, 67, 6, 4, 19, 18, 19, ci.n, 31, 24, 19, 18, 57, 4, 31, 19, 24, 2, 23, 2, 31, 25, 24, 61, 19, ci.m, 104, 127, 107, 111, 127, 105, 110, 78, 115, 119, 127, 25, ci.l, 28, 10, 25, ci.m, 56, ci.l, 25, 29, ci.l, 25, 62, 57, 39, 87, 64, 82, 68, 87, 65, 64, 65, 115, 76, 65, 64, 74, 100, 65, 97, 68, 81, 68, 103, 80, 75, 65, 73, 64, 123, 108, 126, 104, 123, 109, 108, 109, 86, 127, 96, 109, 108, 102, 80, 75, 76, 84, 80, 64, 108, 65, 88, 71, 75, 89, 122, 87, 94, 75};
    }

    public static void A06() {
        A0D = new String[]{"YJVWhBFSVFKs7NrWmWULGh", "0GvTyPfIpVaCupDTXIuhVv", "vKmpQ0k2zgunQxdAFsx7Wlk6dmYtSCUc", "dqRYVPDeGy45RCRFCWIUPRHRtp9NBigI", "NSweCua6lZ8ChPFZ3cKnaOBscLcsrWLc", "HenZyTRrHhMHTWT00jKprDJGPW9d4C4V", "lvvcgtkpn6JHhS0LrJ19j3FN0lJsZZOv", "GmBDkEWrzwPugE8SLtTHysECIxUFQGpg"};
    }

    private void A03() {
        C2E c2eA00 = C2E.A00(this.A04);
        AnonymousClass12 anonymousClass12 = this.A02;
        c2eA00.A07(anonymousClass12, anonymousClass12.A01());
    }

    private void A04() {
        if (this.A02 != null) {
            try {
                C2E.A00(this.A04).A06(this.A02);
            } catch (Exception unused) {
            }
        }
    }

    private void A07(Intent intent) {
        int i = super.A00;
        String strA01 = A01(72, 24, 8);
        if (i != -1) {
            ContentResolver contentResolver = this.A04.getContentResolver();
            if (A0D[3].charAt(29) != 'i') {
                throw new RuntimeException();
            }
            String[] strArr = A0D;
            strArr[7] = "ryaiaZaF8EzuUPZd67FeoIG9jUALGHZG";
            strArr[6] = "XITZtpYy2wf6QHmOozCOnY6Xlkm3ca51";
            if (Settings.System.getInt(contentResolver, A01(1, 22, 43), 0) != 1) {
                int i2 = super.A00;
                if (A0D[2].charAt(2) != 'm') {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0D;
                strArr2[1] = "mo2n49jFbf8CHvb7nubztA";
                strArr2[0] = "3h0LYrxRFByrgEG7Z48zJG";
                intent.putExtra(strA01, i2);
                return;
            }
        }
        if (!C1693Iy.A0c(this.A04)) {
            intent.putExtra(strA01, 6);
        }
    }

    private void A08(boolean z) {
        if (this.A06 == KC.A0B) {
            A0A(z);
            return;
        }
        KC kc = this.A06;
        String[] strArr = A0D;
        if (strArr[1].length() != strArr[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0D;
        strArr2[4] = "1yOiFacRiwJanRzqDJ6A5hJ77lYfziAe";
        strArr2[5] = "McEelBumOV7dKb1zb6BdvUT5HG6VvrgI";
        if (kc == KC.A0A) {
            A09(z);
        } else {
            A0A(z);
        }
    }

    private void A09(boolean z) {
        RE re = new RE(this, this);
        AnonymousClass77 anonymousClass77 = new AnonymousClass77(this.A04);
        C12671c c12671c = new C12671c(this, this.A03, A01(147, 14, 119), anonymousClass77);
        if (c12671c.A09()) {
            anonymousClass77.A0X(new JC(this.A03.A0Q(), this.A04.A06()));
            c12671c.A08();
        } else {
            C12721h.A03(this.A04, this.A03, z, re);
        }
    }

    private void A0A(boolean z) {
        AnonymousClass77 anonymousClass77 = new AnonymousClass77(this.A04);
        anonymousClass77.A0X(this.A05);
        AnonymousClass15 anonymousClass15 = this.A03;
        String strA01 = A01(147, 14, 119);
        C12671c c12671c = new C12671c(this, anonymousClass15, strA01, anonymousClass77);
        if (c12671c.A09()) {
            c12671c.A08();
            return;
        }
        RO ro = (RO) this.A03;
        if (TextUtils.isEmpty(ro.A0M().A0E().A08())) {
            this.A01.ABB(this, AdError.INTERNAL_ERROR);
        } else {
            C12731i.A02(anonymousClass77, ro);
            anonymousClass77.A0Q(new C1585Eo(this, z, this), new AnonymousClass70(ro.A0U(), strA01));
        }
    }

    @Override // com.facebook.ads.redexgen.X.RJ
    public final int A0B() {
        AnonymousClass15 anonymousClass15 = this.A03;
        if (anonymousClass15 != null) {
            return anonymousClass15.A0J();
        }
        String[] strArr = A0D;
        if (strArr[4].charAt(5) == strArr[5].charAt(5)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0D;
        strArr2[3] = "zy8kAWNFspHhc9OUOOhBHMIK4AaCMilm";
        strArr2[3] = "zy8kAWNFspHhc9OUOOhBHMIK4AaCMilm";
        return -1;
    }

    @Override // com.facebook.ads.redexgen.X.RJ
    public final boolean A0C() {
        if (!this.A0B.get()) {
            return false;
        }
        String strA03 = C1820Ob.A03(super.A01, this.A0A, this.A07);
        this.A03.A0a(super.A01);
        this.A03.A0d(strA03);
        AdActivityIntent adActivityIntentA04 = C1725Kh.A04(this.A04);
        adActivityIntentA04.putExtra(A01(169, 8, 80), this.A06);
        adActivityIntentA04.putExtra(A01(122, 25, 91), this.A03);
        adActivityIntentA04.putExtra(A01(161, 8, 91), this.A0A);
        if (strA03 != null) {
            adActivityIntentA04.putExtra(A01(107, 15, 21), strA03);
        }
        adActivityIntentA04.putExtra(A01(61, 11, 89), this.A09);
        adActivityIntentA04.putExtra(A01(96, 11, 100), this.A00);
        String str = this.A08;
        if (str != null) {
            adActivityIntentA04.putExtra(A01(48, 13, 2), str);
        }
        A07(adActivityIntentA04);
        adActivityIntentA04.setFlags(adActivityIntentA04.getFlags() | 268435456);
        adActivityIntentA04.putExtra(A01(23, 11, 115), this.A03.A0Q());
        C1728Kk.A04(this.A04);
        C1725Kh.A0A(this.A04, adActivityIntentA04);
        return true;
    }

    public final void A0D(C2026Wb c2026Wb, AnonymousClass11 anonymousClass11, Map<String, Object> map, boolean z, @Nullable String str, @Nullable String str2) {
        String strA01;
        this.A0B.set(false);
        this.A04 = c2026Wb;
        this.A01 = anonymousClass11;
        this.A09 = (String) map.get(A01(61, 11, 89));
        this.A00 = ((Long) map.get(A01(96, 11, 100))).longValue();
        this.A08 = str2;
        String str3 = this.A09;
        if (str3 == null) {
            strA01 = A01(0, 0, 20);
        } else {
            if (A0D[2].charAt(2) != 'm') {
                throw new RuntimeException();
            }
            String[] strArr = A0D;
            strArr[7] = "e6RM8yaPLIljQgE3BUpQbpnA92TvZvU8";
            strArr[6] = "ffjbG0C858y3IrNljjKglLsYE4qM5rpD";
            strA01 = str3.split(A01(0, 1, 25))[0];
        }
        this.A07 = strA01;
        this.A03 = RO.A01((JSONObject) map.get(A01(34, 4, 20)));
        this.A03.A0b(str);
        this.A03.A0Z(((C14508r) map.get(A01(38, 10, 87))).A06());
        this.A05 = new JC(this.A03.A0Q(), c2026Wb.A06());
        if (!TextUtils.isEmpty(this.A03.A0R()) && Build.VERSION.SDK_INT >= 21) {
            this.A06 = KC.A04;
            this.A04.A0A().ADQ(EnumC12410c.A05);
        } else {
            int iA0I = this.A03.A0I();
            if (iA0I == 0) {
                this.A06 = KC.A0B;
                this.A04.A0A().ADQ(EnumC12410c.A08);
            } else if (iA0I == 1) {
                this.A06 = KC.A0A;
                this.A04.A0A().ADQ(EnumC12410c.A07);
            }
        }
        this.A02 = new AnonymousClass12(this.A0A, this, anonymousClass11);
        A03();
        A08(z);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12510m
    public final String A5q() {
        return this.A03.A0Q();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12600v
    public final void A9O() {
        this.A0B.set(true);
        this.A01.AB8(this);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12600v
    public final void A9P() {
        this.A01.ABB(this, AdError.CACHE_ERROR);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12510m
    public final void onDestroy() {
        A04();
    }
}
