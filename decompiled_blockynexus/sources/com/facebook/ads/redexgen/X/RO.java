package com.facebook.ads.redexgen.X;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class RO extends AnonymousClass15 implements Serializable {
    public static byte[] A00 = null;
    public static final long serialVersionUID = 2751287062553772011L;

    static {
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 1);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{123, 108, 126, 104, 123, 109, 108, 109, 86, 127, 96, 109, 108, 102};
    }

    public RO(List<AnonymousClass18> list) {
        super(list);
    }

    public static RO A01(JSONObject jSONObject) {
        AnonymousClass18 anonymousClass18A00 = AnonymousClass18.A00(jSONObject);
        anonymousClass18A00.A0K(true);
        anonymousClass18A00.A0J(jSONObject);
        ArrayList arrayList = new ArrayList();
        arrayList.add(anonymousClass18A00);
        RO ro = new RO(arrayList);
        ro.A0e(jSONObject);
        ro.A0c(A02(0, 14, 8));
        return ro;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass15
    public final int A0I() {
        if (A0M().A0E().A06() != null) {
            return 1;
        }
        return 0;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass15
    public final int A0J() {
        return A0M().A0E().A04();
    }
}
