package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class OI extends AbstractC1848Pd {
    public final /* synthetic */ J5 A00;
    public final /* synthetic */ LQ A01;
    public final /* synthetic */ ON A02;
    public final /* synthetic */ C1799Ng A03;
    public final /* synthetic */ String A04;
    public final /* synthetic */ Map A05;

    public OI(C1799Ng c1799Ng, String str, ON on, J5 j5, Map map, LQ lq) {
        this.A03 = c1799Ng;
        this.A04 = str;
        this.A02 = on;
        this.A00 = j5;
        this.A05 = map;
        this.A01 = lq;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1848Pd
    public final void A04() {
        if (!this.A03.A01.A0b() && !TextUtils.isEmpty(this.A04) && !this.A03.A07.get(this.A02.A02())) {
            this.A00.A8M(this.A04, new NQ(this.A05).A04(this.A03.A02).A03(this.A01).A06());
            this.A03.A07.put(this.A02.A02(), true);
        }
    }
}
