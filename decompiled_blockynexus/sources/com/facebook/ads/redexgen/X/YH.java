package com.facebook.ads.redexgen.X;

import com.sandboxol.center.config.VipSubscribeStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class YH extends CO {
    public static byte[] A01;
    public static String[] A02;
    public long A00;

    static {
        A0B();
        A0A();
    }

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 32);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        A01 = new byte[]{47, 62, 57, 42, Utf8.REPLACEMENT_BYTE, 34, 36, 37, 83, 82, 113, 89, 72, 93, 120, 93, 72, 93};
    }

    public static void A0B() {
        A02 = new String[]{"VtWAGSJcoPK1ZfQIT7kg70", "uvijoF7s18JkyzfLjC52JO", "UbwrKHlSsB9uBr4pHbp3GiHEJPcDIn2y", "M5IiKhc4TX4EBu4m9nlnlg4KrGcCYGid", "uZSF2L4tKNd9pS0dTFbwskwuDNdjgXB", VipSubscribeStatus.SUBSCRIPTION_ON_HOLD, "JxfitwILt0nkPD2n3YPqqh4", "RXlbAzoXPs3VSjVZyf6us5"};
    }

    public YH() {
        super(null);
        this.A00 = -9223372036854775807L;
    }

    public static int A00(IG ig) {
        return ig.A0F();
    }

    public static Boolean A01(IG ig) {
        return Boolean.valueOf(ig.A0F() == 1);
    }

    public static Double A02(IG ig) {
        return Double.valueOf(Double.longBitsToDouble(ig.A0M()));
    }

    public static Object A03(IG ig, int i) {
        if (i == 0) {
            return A02(ig);
        }
        if (i == 1) {
            return A01(ig);
        }
        if (i == 2) {
            return A05(ig);
        }
        if (i == 3) {
            return A09(ig);
        }
        if (i == 8) {
            HashMap<String, Object> mapA08 = A08(ig);
            if (A02[5].length() != 0) {
                String[] strArr = A02;
                strArr[7] = "dv1uUJDV50UY3341cCSHZj";
                strArr[6] = "lZLu8OCPwS2vewsoll9LjNz";
                return mapA08;
            }
        } else {
            if (i != 10) {
                if (i != 11) {
                    return null;
                }
                return A07(ig);
            }
            ArrayList<Object> arrayListA06 = A06(ig);
            String[] strArr2 = A02;
            if (strArr2[1].length() == strArr2[0].length()) {
                String[] strArr3 = A02;
                strArr3[4] = "2Wm";
                strArr3[4] = "2Wm";
                return arrayListA06;
            }
        }
        throw new RuntimeException();
    }

    public static String A05(IG ig) {
        int position = ig.A0J();
        int iA07 = ig.A07();
        ig.A0a(position);
        return new String(ig.A00, iA07, position);
    }

    public static ArrayList<Object> A06(IG ig) {
        int iA0I = ig.A0I();
        ArrayList<Object> arrayList = new ArrayList<>(iA0I);
        for (int type = 0; type < iA0I; type++) {
            arrayList.add(A03(ig, A00(ig)));
        }
        return arrayList;
    }

    public static Date A07(IG ig) {
        Date date = new Date((long) A02(ig).doubleValue());
        ig.A0a(2);
        return date;
    }

    public static HashMap<String, Object> A08(IG ig) {
        int iA0I = ig.A0I();
        HashMap<String, Object> map = new HashMap<>(iA0I);
        for (int i = 0; i < iA0I; i++) {
            map.put(A05(ig), A03(ig, A00(ig)));
        }
        return map;
    }

    public static HashMap<String, Object> A09(IG ig) {
        HashMap<String, Object> map = new HashMap<>();
        while (true) {
            String strA05 = A05(ig);
            int iA00 = A00(ig);
            if (A02[4].length() == 22) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[1] = "V4HwzONZDXYgxClN6ndm7q";
            strArr[0] = "UAxIIFeY73WGzRiRR4AY1i";
            if (iA00 == 9) {
                return map;
            }
            map.put(strA05, A03(ig, iA00));
        }
    }

    @Override // com.facebook.ads.redexgen.X.CO
    public final void A0C(IG ig, long j) throws AD {
        if (A00(ig) == 2) {
            if (!A04(8, 10, 28).equals(A05(ig)) || A00(ig) != 8) {
                return;
            }
            Map<String, Object> metadata = A08(ig);
            String strA04 = A04(0, 8, 107);
            if (metadata.containsKey(strA04)) {
                double dDoubleValue = ((Double) metadata.get(strA04)).doubleValue();
                if (dDoubleValue > 0.0d) {
                    this.A00 = (long) (1000000.0d * dDoubleValue);
                    return;
                }
                return;
            }
            return;
        }
        throw new AD();
    }

    @Override // com.facebook.ads.redexgen.X.CO
    public final boolean A0D(IG ig) {
        return true;
    }

    public final long A0E() {
        return this.A00;
    }
}
