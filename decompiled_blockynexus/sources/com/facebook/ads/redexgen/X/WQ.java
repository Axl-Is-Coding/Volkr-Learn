package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class WQ<T> extends AbstractC14046n<List<T>> {
    public static byte[] A02;
    public static String[] A03;
    public final EnumC14036m A00;
    public final List<T> A01;

    static {
        A04();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 25);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{113};
    }

    public static void A04() {
        A03 = new String[]{"9itrjnnCMeXzcKw4LDwr3", "0ZUpi3OgdlmKuABHcG8PMsqc4Oj", "fTRPCIaWt84rUUsVk3HDIivZKs", "V5Apl", "JVZfUK34SIuqNwHf2oV3ojB3sFjQruRb", "fsV6jHlkXkNImPX103xxf", "wiQZRNNXqXk8QOUIHtx5EDu7Qpw", "6g7apQMvF8ZkxnUyBbRCBajSKJlIo"};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WQ != com.facebook.ads.internal.botdetection.signals.model.signal_value.ListSignalValueType<T> */
    public WQ(long j, @Nullable C14026l c14026l, List<T> list, EnumC14036m enumC14036m) {
        super(j, c14026l, list, EnumC14036m.A08);
        this.A01 = list;
        this.A00 = enumC14036m;
        if (A05()) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WQ != com.facebook.ads.internal.botdetection.signals.model.signal_value.ListSignalValueType<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    private int A00(T t) {
        int i = C13976g.A00[this.A00.ordinal()];
        if (i == 1) {
            return 4;
        }
        if (i == 2) {
            return ((String) t).length();
        }
        if (i == 3) {
            return ((InterfaceC13956e) t).ADV();
        }
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WQ != com.facebook.ads.internal.botdetection.signals.model.signal_value.ListSignalValueType<T> */
    private boolean A05() {
        int i = C13976g.A00[this.A00.ordinal()];
        if (i != 1 && i != 2) {
            String[] strArr = A03;
            if (strArr[3].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[4] = "pkJoykusnl5HLvmmS2nCUwVdsFz02CDm";
            strArr2[4] = "pkJoykusnl5HLvmmS2nCUwVdsFz02CDm";
            if (i != 3) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WQ != com.facebook.ads.internal.botdetection.signals.model.signal_value.ListSignalValueType<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.ads.redexgen.X.AbstractC14046n
    public final int A07() {
        int iA00 = 0;
        if (A08() == null || ((List) A08()).isEmpty()) {
            return 0;
        }
        Iterator it = ((List) A08()).iterator();
        while (it.hasNext()) {
            iA00 += A00(it.next());
        }
        return iA00;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WQ != com.facebook.ads.internal.botdetection.signals.model.signal_value.ListSignalValueType<T> */
    @Override // com.facebook.ads.redexgen.X.AbstractC14046n
    public final JSONObject A09(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (T t : this.A01) {
            int i = C13976g.A00[this.A00.ordinal()];
            if (i == 1 || i == 2) {
                jSONArray.put(t);
            } else {
                String[] strArr = A03;
                if (strArr[3].length() == strArr[0].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A03;
                strArr2[3] = "TE27R";
                strArr2[0] = "fy5SSQFd7I5OAEL1WcIst";
                if (i == 3) {
                    jSONArray.put(((InterfaceC13956e) t).ADo());
                }
            }
        }
        jSONObject.put(A01(0, 1, 30), jSONArray);
        return jSONObject;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.6n != com.facebook.ads.internal.botdetection.signals.model.signal_value.SignalValueTypeDef<java.util.List<T>> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.WQ != com.facebook.ads.internal.botdetection.signals.model.signal_value.ListSignalValueType<T> */
    @Override // com.facebook.ads.redexgen.X.AbstractC14046n
    public final boolean A0B(AbstractC14046n<List<T>> abstractC14046n) {
        List<T> listA08 = abstractC14046n.A08();
        List list = (List) A08();
        if (list == null || listA08 == null) {
            return list == null && listA08 == null;
        }
        if (abstractC14046n.A08().size() != ((List) A08()).size()) {
            return false;
        }
        int i = 0;
        while (true) {
            int size = listA08.size();
            if (A03[4].charAt(25) != 'F') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[3] = "t4r48";
            strArr[0] = "skb916f7am8mTaTTklPg2";
            if (i >= size) {
                return true;
            }
            T t = listA08.get(i);
            Object obj = list.get(i);
            int i2 = C13976g.A00[this.A00.ordinal()];
            if (i2 != 1 && i2 != 2) {
                if (i2 == 3 && !((InterfaceC13956e) t).A7o(obj)) {
                    return false;
                }
            } else if (!listA08.get(i).equals(list.get(i))) {
                return false;
            }
            i++;
        }
    }
}
