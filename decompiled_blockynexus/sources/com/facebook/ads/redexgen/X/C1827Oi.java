package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Oi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1827Oi extends AbstractC1848Pd {
    public static byte[] A01;
    public final /* synthetic */ C14307t A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 21);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{2, ci.l, 12, 79, 7, 0, 2, 4, 3, ci.l, ci.l, 10, 79, 0, 5, 18, 79, 8, ci.m, 21, 4, 19, 18, 21, 8, 21, 8, 0, ci.k, 79, 8, 12, 17, 19, 4, 18, 18, 8, ci.l, ci.m, 79, ci.k, ci.l, 6, 6, 4, 5};
    }

    public C1827Oi(C14307t c14307t) {
        this.A00 = c14307t;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1848Pd
    public final void A04() {
        if (!this.A00.A0D.A08()) {
            this.A00.A0D.A06();
            if (this.A00.getAudienceNetworkListener() != null) {
                this.A00.getAudienceNetworkListener().A3s(A00(0, 47, 116));
            }
            if (!TextUtils.isEmpty(this.A00.A0A)) {
                ((ZU) ((ZU) this.A00)).A0A.A8M(this.A00.A0A, new NQ().A04(this.A00.A09).A03(this.A00.A0D).A05(((ZU) ((ZU) this.A00)).A08.A0S()).A06());
                this.A00.A0C.A0A().A2a();
            }
        }
    }
}
