package com.facebook.ads.redexgen.X;

import android.os.Build;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class TW implements C6Y {
    public final /* synthetic */ C1953Tg A00;

    public TW(C1953Tg c1953Tg) {
        this.A00 = c1953Tg;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (Build.VERSION.SDK_INT < 23) {
            return this.A00.A08(EnumC14006j.A05);
        }
        if (this.A00.A02 != null) {
            C1953Tg c1953Tg = this.A00;
            return c1953Tg.A05(c1953Tg.A02.getLockTaskModeState());
        }
        return this.A00.A08(EnumC14006j.A07);
    }
}
