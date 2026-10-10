package com.facebook.ads.redexgen.X;

import android.os.Build;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class V8 implements C6Y {
    public final /* synthetic */ VC A00;

    public V8(VC vc) {
        this.A00 = vc;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (Build.VERSION.SDK_INT < 22) {
            return this.A00.A08(EnumC14006j.A05);
        }
        if (this.A00.A00 == null) {
            return this.A00.A08(EnumC14006j.A07);
        }
        VC vc = this.A00;
        return vc.A0G(vc.A00.isDeviceLocked());
    }
}
