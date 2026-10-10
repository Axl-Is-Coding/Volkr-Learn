package com.facebook.ads.redexgen.X;

import android.os.Build;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Uh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1980Uh implements C6Y {
    public final /* synthetic */ C1991Us A00;

    public C1980Uh(C1991Us c1991Us) {
        this.A00 = c1991Us;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (Build.VERSION.SDK_INT < 23) {
            return this.A00.A08(EnumC14006j.A05);
        }
        return this.A00.A09(Build.VERSION.SECURITY_PATCH);
    }
}
