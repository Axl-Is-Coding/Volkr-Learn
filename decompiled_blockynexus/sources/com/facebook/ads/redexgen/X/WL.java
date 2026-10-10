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
public final class WL<T> extends AbstractC14046n<InterfaceC13956e> {
    public static byte[] A00;
    public static String[] A01;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 40);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        byte[] bArr = {-73};
        String[] strArr = A01;
        if (strArr[0].charAt(26) != strArr[6].charAt(26)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[2] = "4uyIqP7n4WtKVi9Rm5fO0ecCuIXu1zOj";
        strArr2[2] = "4uyIqP7n4WtKVi9Rm5fO0ecCuIXu1zOj";
        A00 = bArr;
    }

    public static void A02() {
        A01 = new String[]{"FFbUiuFwozfA0TvCJPANz8giqJj3Ey6e", "FdrdBbAzaIA4fvIQziUETi0i5pzm7d41", "y8Q9G33rxS5LLrNXiYcm9QLiBdw97p1I", "zt8", "kKbJCUSdm2baWh6S7cWsva6nWBGnb0Bq", "lZC5QmFNV9qqPs7G4jyYJaaKbEwmE4", "OkQ3tI89WJ1Nk7Gpl9REz34W9wj5LbGl", "vzboBPdl2BbWH2MdrrRCAvv17E0LNPzE"};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WL != com.facebook.ads.internal.botdetection.signals.model.signal_value.CustomObjectSignalValueType<T> */
    public WL(long j, @Nullable C14026l c14026l, InterfaceC13956e interfaceC13956e) {
        super(j, c14026l, interfaceC13956e, EnumC14036m.A03);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WL != com.facebook.ads.internal.botdetection.signals.model.signal_value.CustomObjectSignalValueType<T> */
    @Override // com.facebook.ads.redexgen.X.AbstractC14046n
    public final int A07() {
        return ((InterfaceC13956e) A08()).ADV();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WL != com.facebook.ads.internal.botdetection.signals.model.signal_value.CustomObjectSignalValueType<T> */
    @Override // com.facebook.ads.redexgen.X.AbstractC14046n
    public final JSONObject A09(JSONObject jSONObject) throws JSONException {
        return jSONObject.put(A00(0, 1, 25), ((InterfaceC13956e) A08()).ADo());
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6n != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<com.facebook.ads.internal.botdetection.signals.model.signal_value.ICustomObjectSignalValueDef> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WL != com.facebook.ads.internal.botdetection.signals.model.signal_value.CustomObjectSignalValueType<T> */
    @Override // com.facebook.ads.redexgen.X.AbstractC14046n
    public final boolean A0B(AbstractC14046n<InterfaceC13956e> abstractC14046n) {
        if (A08() == null || abstractC14046n.A08() == null) {
            return A08() == null && abstractC14046n.A08() == null;
        }
        return ((InterfaceC13956e) A08()).A7o(abstractC14046n.A08());
    }
}
