package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RC extends KT {
    public final /* synthetic */ RD A00;
    public final /* synthetic */ Map A01;
    public final /* synthetic */ Map A02;

    public RC(RD rd, Map map, Map map2) {
        this.A00 = rd;
        this.A02 = map;
        this.A01 = map2;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A07() {
        if (!TextUtils.isEmpty(this.A00.A0L)) {
            HashMap map = new HashMap();
            map.putAll(this.A02);
            map.putAll(this.A01);
            if (this.A00.A0D == null) {
                return;
            }
            this.A00.A0D.A8a(this.A00.A0L, map);
        }
    }
}
