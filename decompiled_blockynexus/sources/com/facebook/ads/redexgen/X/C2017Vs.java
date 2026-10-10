package com.facebook.ads.redexgen.X;

import java.util.HashMap;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2017Vs implements C6Y {
    public final /* synthetic */ C2019Vu A00;
    public final /* synthetic */ List A01;

    public C2017Vs(C2019Vu c2019Vu, List list) {
        this.A00 = c2019Vu;
        this.A01 = list;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        HashMap map = new HashMap();
        for (C6X c6x : this.A01) {
            if (c6x.A02()) {
                String str = (String) c6x.A01();
                C2018Vt systemProperty = new C2018Vt(str);
                map.put(str, systemProperty);
            }
        }
        return this.A00.A02(map);
    }
}
