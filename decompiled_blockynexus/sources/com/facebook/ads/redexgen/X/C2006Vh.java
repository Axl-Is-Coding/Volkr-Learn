package com.facebook.ads.redexgen.X;

import android.os.Build;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2006Vh implements C6Y {
    public final /* synthetic */ C2007Vi A00;

    public C2006Vh(C2007Vi c2007Vi) {
        this.A00 = c2007Vi;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (Build.VERSION.SDK_INT < 21) {
            return this.A00.A08(EnumC14006j.A05);
        }
        if (this.A00.A00 != null) {
            C2007Vi c2007Vi = this.A00;
            return c2007Vi.A0G(c2007Vi.A00.isPowerSaveMode());
        }
        return this.A00.A08(EnumC14006j.A07);
    }
}
