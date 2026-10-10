package com.facebook.ads.redexgen.X;

import android.os.Build;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Up, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1988Up implements C6Y {
    public final /* synthetic */ C1991Us A00;

    public C1988Up(C1991Us c1991Us) {
        this.A00 = c1991Us;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        return this.A00.A09(Build.HARDWARE);
    }
}
