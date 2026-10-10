package com.facebook.ads.redexgen.X;

import android.text.TextUtils;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2086Yj implements OT {
    public final /* synthetic */ Y5 A00;

    public C2086Yj(Y5 y5) {
        this.A00 = y5;
    }

    public /* synthetic */ C2086Yj(Y5 y5, ZS zs) {
        this(y5);
    }

    @Override // com.facebook.ads.redexgen.X.OT
    public final void A9Y() {
        this.A00.A0V(true);
    }

    @Override // com.facebook.ads.redexgen.X.OT
    public final void AA1() {
        if (!TextUtils.isEmpty(this.A00.A09.A0Q())) {
            this.A00.A0D.A8M(this.A00.A09.A0Q(), new NQ().A04(this.A00.A06.getViewabilityChecker()).A03(this.A00.A06.getTouchDataRecorder()).A06());
            this.A00.A0C.A0A().A2a();
        }
        this.A00.A0H.A3s(this.A00.A0I.A6U());
    }

    @Override // com.facebook.ads.redexgen.X.OT
    public final void AAL() {
        this.A00.A0H.A3s(this.A00.A0I.A6J());
    }
}
