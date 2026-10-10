package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class WP extends AbstractC14046n<Integer> {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 48);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{82};
    }

    public WP(long j, @Nullable C14026l c14026l, int i) {
        super(j, c14026l, Integer.valueOf(i), EnumC14036m.A06);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC14046n
    public final int A07() {
        return 4;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC14046n
    public final JSONObject A09(JSONObject jSONObject) throws JSONException {
        jSONObject.put(A00(0, 1, 20), A08());
        return jSONObject;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6n != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<java.lang.Integer> */
    @Override // com.facebook.ads.redexgen.X.AbstractC14046n
    public final boolean A0B(AbstractC14046n<Integer> abstractC14046n) {
        return A08().equals(abstractC14046n.A08());
    }
}
