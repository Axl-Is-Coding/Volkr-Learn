package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class WO extends AbstractC14046n<HashMap<String, Integer>> {
    public static byte[] A00;
    public static String[] A01;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 81);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        byte[] bArr = {-44};
        if (A01[1].length() != 32) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[5] = "SxUYlD3A0WMAhXB5PTE";
        strArr[5] = "SxUYlD3A0WMAhXB5PTE";
        A00 = bArr;
    }

    public static void A02() {
        A01 = new String[]{"Nq1Kb9TOHvzWwANjwVGizSKF", "JWM4IVLufHQSkDOJGyecwcJ9XG51cvJk", "QEyZFLJTZNzdsjJkYvljVioyRUG2XSKd", "n7SG", "D5E01LJ4kvbqK2OQmpgiuXTPXhrvg0RI", "iCSdHB", "iogVWxzO6MdlKqT6F77t9UC3cqMLTkpE", "gUxLojtchnnArKauALgqkHsSrkkPr"};
    }

    public WO(long j, @Nullable C14026l c14026l, HashMap<String, Integer> signalValues) {
        super(j, c14026l, signalValues, EnumC14036m.A07);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC14046n
    public final int A07() {
        int length = 0;
        for (String key : A08().keySet()) {
            length += key.getBytes().length;
        }
        return (A08().size() * 4) + length;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC14046n
    public final JSONObject A09(JSONObject jSONObject) throws JSONException {
        HashMap<String, Integer> mapA08 = A08();
        Set<String> setKeySet = mapA08.keySet();
        JSONObject jSONObject2 = new JSONObject();
        for (String str : setKeySet) {
            jSONObject2.put(str, mapA08.get(str));
        }
        jSONObject.put(A00(0, 1, 13), jSONObject2);
        return jSONObject;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6n != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<java.util.HashMap<java.lang.String, java.lang.Integer>> */
    @Override // com.facebook.ads.redexgen.X.AbstractC14046n
    @SuppressLint({"Nullable Dereference"})
    public final boolean A0B(AbstractC14046n<HashMap<String, Integer>> abstractC14046n) {
        if (A08() != null) {
            HashMap<String, Integer> mapA08 = abstractC14046n.A08();
            if (A01[6].charAt(14) == 'I') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[1] = "ZRsxwV5SobJQ5cDwe7XAzXaVJFGFHkOZ";
            strArr[1] = "ZRsxwV5SobJQ5cDwe7XAzXaVJFGFHkOZ";
            if (mapA08 != null) {
                if (A08().size() != abstractC14046n.A08().size()) {
                    return false;
                }
                HashMap<String, Integer> mapA082 = abstractC14046n.A08();
                HashMap<String, Integer> mapA083 = A08();
                Iterator<String> it = mapA082.keySet().iterator();
                Iterator<String> prevSignalValueKeys = mapA083.keySet().iterator();
                while (it.hasNext() && prevSignalValueKeys.hasNext()) {
                    String newSignalValueKey = it.next();
                    String next = prevSignalValueKeys.next();
                    if (!newSignalValueKey.equals(next) || !mapA082.containsKey(newSignalValueKey) || !mapA083.containsKey(next) || !mapA082.get(newSignalValueKey).equals(mapA083.get(next))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return A08() == null && abstractC14046n.A08() == null;
    }
}
