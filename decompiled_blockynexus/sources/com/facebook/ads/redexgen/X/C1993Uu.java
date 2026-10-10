package com.facebook.ads.redexgen.X;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Uu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1993Uu implements InterfaceC13966f<String> {
    public final String A00;
    public final boolean A01;

    public C1993Uu(String str) {
        this.A00 = str;
        this.A01 = C1994Uv.A01().hasSystemFeature(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.InterfaceC13966f
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final JSONObject ADp(String str, JSONObject jSONObject) throws JSONException {
        jSONObject.put(this.A00, this.A01);
        return jSONObject;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC13966f
    public final boolean A7o(Object obj) {
        C1993Uu c1993Uu = (C1993Uu) obj;
        return this.A00.equals(c1993Uu.A00) && this.A01 == c1993Uu.A01;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC13966f
    public final int ADV() {
        return this.A00.getBytes().length + 8;
    }
}
