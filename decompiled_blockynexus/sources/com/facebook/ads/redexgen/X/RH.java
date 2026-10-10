package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class RH extends AbstractC12530o {
    public static String[] A05;
    public static final String A06;
    public RF A00;
    public boolean A01;
    public final C2026Wb A02;
    public final J5 A03;
    public final NG A04;

    public static void A04() {
        A05 = new String[]{"RwkPFHsv9wotgH8PCqYhpIij5lIi", "drIC7gYxypHASOm9CvVJaHIQeep0", "f0dvIXyq27iv5zRXvkJTu2cqkG", "fzusVvXWPget8SSdASQ7tAMFHi8p37he", "Ar6p", "jDkSEm6Ik6fEWWn08WKTicIvFe3Dtksc", "J7vaKr0jTjoObEFZmlhET1S0K8S4ujA7", "2rimL2d5m8eNJCurq2ysJBza56R6EvG7"};
    }

    static {
        A04();
        A06 = RH.class.getSimpleName();
    }

    public RH(C2026Wb c2026Wb, J5 j5, NG ng, C1849Pe c1849Pe, AbstractC12540p abstractC12540p) {
        super(c2026Wb, abstractC12540p, c1849Pe);
        this.A03 = j5;
        this.A04 = ng;
        this.A02 = c2026Wb;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12530o
    public final void A07(Map<String, String> map) {
        RF rf = this.A00;
        if (rf != null && !TextUtils.isEmpty(rf.A5q())) {
            this.A02.A0A().A2a();
            J5 j5 = this.A03;
            String strA5q = this.A00.A5q();
            String[] strArr = A05;
            if (strArr[7].charAt(31) != strArr[6].charAt(31)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[0] = "Tkg0tGhzpCvpbpNuTPjRHtf4b45H";
            strArr2[1] = "dBPpzaB1YNfwJk5banXGE19c57tB";
            j5.A8M(strA5q, map);
        }
    }

    public final synchronized void A08() {
        if (!this.A01 && this.A00 != null) {
            this.A01 = true;
            if (!TextUtils.isEmpty(this.A00.A04())) {
                LS.A00(new RG(this));
            }
        }
    }

    public final void A09(RF rf) {
        this.A00 = rf;
    }
}
