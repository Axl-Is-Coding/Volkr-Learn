package com.facebook.ads.redexgen.X;

import android.os.SystemClock;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2014Vp implements C6Y {
    public final /* synthetic */ C2016Vr A00;

    public C2014Vp(C2016Vr c2016Vr) {
        this.A00 = c2016Vr;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        return this.A00.A04(SystemClock.elapsedRealtime() / 1000.0f);
    }
}
