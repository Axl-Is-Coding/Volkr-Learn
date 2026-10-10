package com.facebook.ads.redexgen.X;

import android.icu.util.TimeZone;
import android.os.Build;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class WA implements C6Y {
    public final /* synthetic */ WC A00;

    public WA(WC wc) {
        this.A00 = wc;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (Build.VERSION.SDK_INT < 24) {
            return this.A00.A08(EnumC14006j.A05);
        }
        return this.A00.A04(TimeZone.getDefault().getRawOffset() / 1000.0f);
    }
}
