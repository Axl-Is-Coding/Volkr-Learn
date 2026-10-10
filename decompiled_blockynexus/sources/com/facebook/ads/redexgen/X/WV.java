package com.facebook.ads.redexgen.X;

import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class WV extends AbstractC14046n<C6J> {
    public WV(long j, @Nullable C14026l c14026l, C6J c6j) {
        super(j, c14026l, c6j, EnumC14036m.A0D);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC14046n
    public final int A07() {
        return A08().A0A();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC14046n
    public final JSONObject A09(JSONObject jSONObject) throws JSONException {
        return A08().A0B(jSONObject);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6n != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<com.facebook.ads.internal.botdetection.signals.biometric.model.TouchSignalRawValue> */
    @Override // com.facebook.ads.redexgen.X.AbstractC14046n
    public final boolean A0B(AbstractC14046n<C6J> abstractC14046n) {
        return A08().A0C(abstractC14046n.A08());
    }
}
