package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class WS<K, V> extends AbstractC14046n<HashMap<K, InterfaceC13966f>> {
    public static byte[] A02;
    public static String[] A03;
    public final EnumC14036m A00;
    public final HashMap<K, InterfaceC13966f> A01;

    static {
        A04();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 110);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{104};
    }

    public static void A04() {
        A03 = new String[]{"cKuQ341bpQpj1np", "NRRRR4TEAm42mDR", "Q3CZak00lhavTOo6A", "zaO6DFhzYxSygkW1IzlMUY8ES4dk", "HbJVSBx3MNS6tqQ9XVLKo36QU0gI1Znv", "JrCrl10lt1AHnaihPuUoLOH", "SHM67NRdcA0GW9YM4", "2pIXYY"};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WS != com.facebook.ads.internal.botdetection.signals.model.signal_value.MapSignalValueType<K, V> */
    public WS(long j, @Nullable C14026l c14026l, HashMap<K, InterfaceC13966f> map, EnumC14036m enumC14036m) {
        super(j, c14026l, map, EnumC14036m.A0A);
        this.A01 = map;
        this.A00 = enumC14036m;
        if (A05()) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WS != com.facebook.ads.internal.botdetection.signals.model.signal_value.MapSignalValueType<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    private int A00(K k) {
        int i = C13986h.A00[this.A00.ordinal()];
        if (i == 1) {
            return 4;
        }
        if (i == 2) {
            return ((String) k).length();
        }
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WS != com.facebook.ads.internal.botdetection.signals.model.signal_value.MapSignalValueType<K, V> */
    private boolean A05() {
        int i = C13986h.A00[this.A00.ordinal()];
        return i == 1 || i == 2;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WS != com.facebook.ads.internal.botdetection.signals.model.signal_value.MapSignalValueType<K, V> */
    @Override // com.facebook.ads.redexgen.X.AbstractC14046n
    public final int A07() {
        int iADV = 0;
        if (A08() == null || ((HashMap) A08()).isEmpty()) {
            return 0;
        }
        for (Map.Entry<K, V> entry : ((HashMap) A08()).entrySet()) {
            int iA00 = iADV + A00(entry.getKey());
            if (A03[5].length() == 26) {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[4] = "UsP7Xgcu0nWDAT33HhVsw8aoixo7a0Y1";
            strArr[4] = "UsP7Xgcu0nWDAT33HhVsw8aoixo7a0Y1";
            iADV = iA00 + ((InterfaceC13966f) entry.getValue()).ADV();
        }
        return iADV;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WS != com.facebook.ads.internal.botdetection.signals.model.signal_value.MapSignalValueType<K, V> */
    @Override // com.facebook.ads.redexgen.X.AbstractC14046n
    public final JSONObject A09(JSONObject mapJsonObject) throws JSONException {
        Set<K> setKeySet = this.A01.keySet();
        JSONObject jSONObject = new JSONObject();
        for (K k : setKeySet) {
            InterfaceC13966f interfaceC13966f = this.A01.get(k);
            if (A03[5].length() == 26) {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[5] = "RtRjz";
            strArr[5] = "RtRjz";
            if (interfaceC13966f != null) {
                interfaceC13966f.ADp(k, jSONObject);
            }
        }
        mapJsonObject.put(A01(0, 1, 112), jSONObject);
        return mapJsonObject;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6n != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<java.util.HashMap<K, com.facebook.ads.internal.botdetection.signals.model.signal_value.IMapSignalValueDef>> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WS != com.facebook.ads.internal.botdetection.signals.model.signal_value.MapSignalValueType<K, V> */
    @Override // com.facebook.ads.redexgen.X.AbstractC14046n
    @SuppressLint({"Nullable Dereference"})
    public final boolean A0B(AbstractC14046n<HashMap<K, InterfaceC13966f>> abstractC14046n) {
        boolean zA7o;
        if (A08() == null || abstractC14046n.A08() == null) {
            return A08() == null && abstractC14046n.A08() == null;
        }
        if (abstractC14046n.A08().size() != A08().size()) {
            return false;
        }
        HashMap<K, InterfaceC13966f> mapA08 = abstractC14046n.A08();
        HashMap<K, InterfaceC13966f> mapA082 = A08();
        Iterator<K> it = mapA08.keySet().iterator();
        Iterator<K> it2 = mapA082.keySet().iterator();
        do {
            boolean zHasNext = it.hasNext();
            String[] strArr = A03;
            if (strArr[1].length() == strArr[0].length()) {
                String[] strArr2 = A03;
                strArr2[1] = "rUsYWVrpG3VWCqr";
                strArr2[0] = "lLqYbR21ojeq3r6";
                if (!zHasNext || !it2.hasNext()) {
                    return true;
                }
                K next = it.next();
                K next2 = it2.next();
                if (!next.equals(next2) || !mapA08.containsKey(next) || !mapA082.containsKey(next2)) {
                    return false;
                }
                InterfaceC13966f interfaceC13966f = mapA08.get(next);
                InterfaceC13966f newSignal = mapA082.get(next2);
                InterfaceC13966f prevSignal = newSignal;
                if (interfaceC13966f == null || prevSignal == null) {
                    return interfaceC13966f == null && prevSignal == null;
                }
                zA7o = interfaceC13966f.A7o(prevSignal);
                String[] strArr3 = A03;
                if (strArr3[7].length() != strArr3[3].length()) {
                    String[] strArr4 = A03;
                    strArr4[6] = "3Jq7wk4KgDHXBRv7A";
                    strArr4[2] = "zXvlpWgAojYXCnWeF";
                }
            }
            throw new RuntimeException();
        } while (zA7o);
        return false;
    }
}
