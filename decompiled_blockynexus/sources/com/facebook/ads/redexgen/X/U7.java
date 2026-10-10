package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class U7 implements InterfaceC13966f<Integer> {
    public static byte[] A03;
    public final int A00;
    public final int A01;
    public final int A02;

    static {
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 10);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{114, 100, 91, 87, 77, 73};
    }

    public U7(int i, int i2, int i3) {
        this.A02 = i;
        this.A00 = i2;
        this.A01 = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.InterfaceC13966f
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final JSONObject ADp(Integer num, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(A00(4, 2, 42), this.A02);
        jSONObject2.put(A00(0, 2, 27), this.A00);
        jSONObject2.put(A00(2, 2, 60), this.A01);
        jSONObject.put(num.toString(), jSONObject2);
        return jSONObject;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC13966f
    public final boolean A7o(Object obj) {
        U7 u7 = (U7) obj;
        return this.A01 == u7.A01 && this.A00 == u7.A00 && this.A02 == u7.A02;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC13966f
    public final int ADV() {
        return A00(4, 2, 42).getBytes().length + A00(0, 2, 27).getBytes().length + A00(2, 2, 60).getBytes().length + 12;
    }
}
