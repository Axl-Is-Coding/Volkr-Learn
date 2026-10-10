package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.Collections;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class VL implements C6Y {
    public final /* synthetic */ C2003Ve A00;

    public VL(C2003Ve c2003Ve) {
        this.A00 = c2003Ve;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (this.A00.A05 != null) {
            ArrayList arrayList = new ArrayList();
            int iMin = Math.min(this.A00.A05.length, this.A00.A03.A0U());
            for (int i = 0; i < iMin; i++) {
                arrayList.add(this.A00.A05[i].name);
            }
            Collections.sort(arrayList);
            return this.A00.A0F(arrayList);
        }
        return this.A00.A08(EnumC14006j.A07);
    }
}
