package com.facebook.ads.redexgen.X;

import android.app.ActivityManager;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Tf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1952Tf implements C6Y {
    public final /* synthetic */ C1953Tg A00;

    public C1952Tf(C1953Tg c1953Tg) {
        this.A00 = c1953Tg;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (this.A00.A02 != null) {
            return this.A00.A0G(ActivityManager.isRunningInTestHarness());
        }
        return this.A00.A08(EnumC14006j.A07);
    }
}
