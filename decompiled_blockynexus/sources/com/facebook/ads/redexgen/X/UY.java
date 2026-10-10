package com.facebook.ads.redexgen.X;

import android.os.Build;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class UY implements C6Y {
    public final /* synthetic */ C1991Us A00;

    public UY(C1991Us c1991Us) {
        this.A00 = c1991Us;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (Build.VERSION.SDK_INT < 21) {
            return this.A00.A08(EnumC14006j.A05);
        }
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr != null) {
            return this.A00.A0F(Arrays.asList(strArr));
        }
        return this.A00.A08(EnumC14006j.A07);
    }
}
