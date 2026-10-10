package com.facebook.ads.redexgen.X;

import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2000Vb implements C6Y {
    public final /* synthetic */ C2003Ve A00;

    public C2000Vb(C2003Ve c2003Ve) {
        this.A00 = c2003Ve;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (this.A00.A04 != null) {
            ArrayList arrayList = new ArrayList();
            int iMin = Math.min(this.A00.A04.length, this.A00.A03.A0U());
            for (int i = 0; i < iMin; i++) {
                arrayList.add(this.A00.A04[i].name);
            }
            return this.A00.A0F(arrayList);
        }
        return this.A00.A08(EnumC14006j.A07);
    }
}
