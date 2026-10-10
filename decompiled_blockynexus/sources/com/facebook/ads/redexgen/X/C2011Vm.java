package com.facebook.ads.redexgen.X;

import java.util.HashMap;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2011Vm implements C6Y {
    public final /* synthetic */ C6U A00;
    public final /* synthetic */ C2013Vo A01;
    public final /* synthetic */ List A02;

    public C2011Vm(C2013Vo c2013Vo, List list, C6U c6u) {
        this.A01 = c2013Vo;
        this.A02 = list;
        this.A00 = c6u;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        HashMap map = new HashMap();
        for (C6X c6x : this.A02) {
            if (c6x.A02()) {
                String str = (String) c6x.A01();
                map.put(str, new C2012Vn(this.A01.A00, str, this.A00));
            }
        }
        return this.A01.A03(map);
    }
}
