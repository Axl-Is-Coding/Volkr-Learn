package com.facebook.ads.redexgen.X;

import android.os.Build;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class VU implements C6Y {
    public final /* synthetic */ C2003Ve A00;

    public VU(C2003Ve c2003Ve) {
        this.A00 = c2003Ve;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (Build.VERSION.SDK_INT < 26) {
            return this.A00.A08(EnumC14006j.A05);
        }
        if (this.A00.A02 != null) {
            C2003Ve c2003Ve = this.A00;
            return c2003Ve.A0G(c2003Ve.A02.canRequestPackageInstalls());
        }
        return this.A00.A08(EnumC14006j.A07);
    }
}
