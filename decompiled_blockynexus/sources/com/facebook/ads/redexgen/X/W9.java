package com.facebook.ads.redexgen.X;

import android.icu.util.TimeZone;
import android.os.Build;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class W9 implements C6Y {
    public final /* synthetic */ WC A00;

    public W9(WC wc) {
        this.A00 = wc;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (Build.VERSION.SDK_INT < 24) {
            return this.A00.A08(EnumC14006j.A05);
        }
        return this.A00.A09(TimeZone.getDefault().getID());
    }
}
