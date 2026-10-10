package com.facebook.ads.redexgen.X;

import android.os.Build;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class VF implements C6Y {
    public final /* synthetic */ VH A00;

    public VF(VH vh) {
        this.A00 = vh;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (Build.VERSION.SDK_INT < 21) {
            return this.A00.A08(EnumC14006j.A05);
        }
        return this.A00.A09(Locale.getDefault().getScript());
    }
}
