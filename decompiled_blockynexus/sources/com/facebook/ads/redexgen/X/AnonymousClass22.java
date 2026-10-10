package com.facebook.ads.redexgen.X;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.umeng.analytics.pro.ci;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.22, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass22 {
    public static AnonymousClass22 A01;
    public static byte[] A02;
    public static String[] A03;
    public static final String[] A04;
    public final SharedPreferences A00;

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 96);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0N() {
        A02 = new byte[]{-90, -45, -25, -8, -15, -90, -25, -22, -90, -25, -7, -90, -11, -20, -20, -21, -12, -7, -17, -4, -21, -90, -11, -8, -90, -17, -12, -25, -10, -10, -8, -11, -10, -8, -17, -25, -6, -21, -69, -34, -102, -30, -29, -34, -34, -33, -24, -88, -86, -51, -119, -37, -50, -39, -40, -37, -35, -50, -51, -105, 33, 62, 69, 73, -7, 78, 76, -7, 78, 71, 61, 62, 75, 76, 77, 58, 71, 61, -7, 80, 65, 58, 77, -7, 66, 76, -7, 65, 58, 73, 73, 62, 71, 66, 71, 64, 7, -7, 48, 65, 82, -7, 61, 72, 71, 0, 77, -7, 82, 72, 78, -7, 80, 58, 71, 77, -7, 77, 72, -7, 76, 62, 62, -7, 77, 65, 66, 76, 24, -54, -25, -18, -14, -94, -9, -11, -94, -9, -16, -26, -25, -12, -11, -10, -29, -16, -26, -94, -7, -22, -29, -10, -94, -21, -11, -94, -22, -29, -14, -14, -25, -16, -21, -16, -23, -80, -94, -39, -22, -5, -94, -21, -11, -94, -10, -22, -21, -11, -94, -21, -16, -29, -14, -14, -12, -15, -14, -12, -21, -29, -10, -25, -63, -61, -28, -33, -32, -101, -68, -33, 8, 28, 41, 28, 34, 32, -37, 28, 31, -37, 43, 45, 32, 33, 32, 45, 32, 41, 30, 32, 46, -72, -39, -118, -46, -45, -50, -49, -118, -53, -50, -118, -39, -38, -34, -45, -39, -40, -35, 19, 52, -27, 55, 42, 53, 52, 55, 57, -27, 38, 41, -27, 52, 53, 57, 46, 52, 51, 56, -37, -18, -7, -8, -5, -3, -87, -54, -19, -18, 0, 0, -69, 1, 0, 18, 0, ci.k, -69, -4, -1, ci.l, -69, 7, 4, 6, 0, -69, ci.m, 3, 4, ci.l, -56, -39, -22, -111, -46, -34, -111, -70, -111, -28, -42, -42, -38, -33, -40, -111, -27, -39, -38, -28, -80, 0, 22, 28, 25, -57, 26, 28, 9, 20, ci.n, 26, 26, ci.n, 22, 21, -57, ci.n, 26, -57, 21, 22, 30, -57, 9, 12, ci.n, 21, ci.l, -57, 25, 12, 29, ci.n, 12, 30, 12, 11, -43, -4, -2, -17, -14, -19, -15, -10, -3, -9, -15, -13, 1, -19, 3, 0, -9, -44, -39, -38, -35, -43, -29, -42, -33, -48, -39, -42, -46, -43, -38, -33, -40, 39, 44, 45, 48, 40, 54, 41, 50, 35, 51, 52, 56, 45, 51, 50, 55, 17, 29, 27, -36, 20, ci.m, 17, 19, ci.n, 29, 29, 25, -36, ci.m, 18, 33, -36, -17, -14, ci.k, 0, -13, -2, -3, 0, 2, -9, -4, -11, ci.k, -15, -3, -4, -12, -9, -11, 25, 28, 33, 28, 38, 27, 24, 23, 18, 23, 24, 38, 22, 37, 28, 35, 39, 28, 34, 33, 33, 36, 41, 36, 46, 35, 32, 31, 26, 35, 36, 31, 32, 26, 28, 31, -38, -35, -30, -35, -25, -36, -39, -40, -45, -26, -39, -28, -29, -26, -24, -45, -43, -40, 49, 50, 45, 46, 40, 42, 45, 40, 41, 36, 37, 31, 33, 36, 31, 36, 37, 51, 35, 50, 41, 48, 52, 41, 47, 46, -26, -25, -30, -29, -35, -33, -30, -35, -28, -19, -22, -22, -19, -11, -35, -13, -18, -35, -26, -29, -33, -30, -25, -20, -27, 64, 65, 60, 61, 55, 57, 60, 55, 71, 72, 76, 65, 71, 70, 75, -29, -40, -22, -21, -42, -20, -25, -37, -40, -21, -36, -37, -42, -21, -32, -28, -36, -22, -21, -40, -28, -25, 61, 49, 62, 49, 55, 53, 47, 49, 52, 47, 64, 66, 53, 54, 53, 66, 53, 62, 51, 53, 67, -12, -24, -11, -24, -18, -20, -26, -24, -21, -26, -9, -7, -20, -19, -20, -7, -20, -11, -22, -20, -6, -26, -4, -7, -16, -17, -10, -19, -19, 74, 75, 79, 68, 74, 73, 58, 79, 64, 83, 79, 50, 51, 55, 44, 50, 49, 34, 57, 36, 47, 56, 40, -38, -51, -40, -41, -38, -36, -57, -55, -52, 22, 9, 20, 19, 22, 24, 3, 5, 8, 3, 8, 9, 23, 7, 22, ci.k, 20, 24, ci.k, 19, 18, 7, -6, 5, 4, 7, 9, -12, -10, -7, -12, -5, 4, 1, 1, 4, 12, -12, 10, 5, -12, -3, -6, -10, -7, -2, 3, -4, -41, -54, -43, -44, -41, -39, -60, -58, -55, -60, -44, -43, -39, -50, -44, -45, -40, 70, 57, 68, 67, 70, 72, 61, 66, 59, 5, -10, 7, -19, -17, -5, -19, -9, -19, 1, -13, -13, -9, -4, -11, -19, 2, -10, -9, 1};
    }

    public static void A0O() {
        A03 = new String[]{"9okEwBsJnxm4XP2uMdCs1TTs0ipxbCrx", "KwR5WWC5sufK43WzM862skA54ooPALBv", "gy93sI55ZIYYvh5J8OUT9qm2p9", "dxYBmhUa98SUIpbIHX6MiqZ5bWUPty4B", "67xZp2aOxtSOd7RgrTL8HL2Ne7", "07dtCbgrw0W8dRsWClXlOnRD4KzojNVd", "fNc2y58JlCy0XZUWB5ryiRvO0DobwJiD", "gLrzPSgUGRY8V9c6gRfYWq9AMfEa3UYZ"};
    }

    static {
        A0O();
        A0N();
        A04 = new String[]{A05(488, 7, 105), A05(495, 19, 96), A05(514, 25, 30), A05(539, 15, 120), A05(649, 9, 8), A05(658, 21, 68), A05(679, 27, 53), A05(706, 17, 5), A05(576, 21, 112), A05(454, 16, 91), A05(470, 18, 20), A05(434, 20, 83), A05(732, 20, 46), A05(352, 14, 46), A05(597, 25, 39)};
    }

    public AnonymousClass22(C2027Wc c2027Wc) {
        this.A00 = c2027Wc.getSharedPreferences(ProcessUtils.getProcessSpecificName(A05(398, 36, 78), c2027Wc), 0);
    }

    public static long A00(C2027Wc c2027Wc) {
        return A02(c2027Wc).A01(A05(554, 22, 23), 0L);
    }

    private long A01(String str, long j) {
        return this.A00.getLong(str, j);
    }

    public static AnonymousClass22 A02(C2027Wc c2027Wc) {
        if (A01 == null) {
            synchronized (AnonymousClass22.class) {
                if (A01 == null) {
                    A01 = new AnonymousClass22(c2027Wc);
                }
            }
        }
        return A01;
    }

    public static AnonymousClass25 A03(C2027Wc c2027Wc) {
        AnonymousClass25 anonymousClass25 = new AnonymousClass25(A0H(c2027Wc));
        try {
            Iterator<AnonymousClass25> it = A0K(A02(c2027Wc).A0J(A05(539, 15, 120), A05(0, 0, 94))).iterator();
            while (it.hasNext()) {
                anonymousClass25.A06(it.next());
            }
        } catch (JSONException e2) {
            A02(c2027Wc).A0M();
            c2027Wc.A04().A8H(A05(723, 9, 116), C8Y.A1m, new C8Z(e2));
        }
        return anonymousClass25;
    }

    public static AnonymousClass25 A04(C2027Wc c2027Wc) {
        AnonymousClass25 anonymousClass25 = new AnonymousClass25(A0I(c2027Wc));
        try {
            Iterator<AnonymousClass25> it = A0K(A02(c2027Wc).A0J(A05(706, 17, 5), A05(0, 0, 94))).iterator();
            while (it.hasNext()) {
                anonymousClass25.A06(it.next());
            }
        } catch (JSONException e2) {
            A02(c2027Wc).A0M();
            c2027Wc.A04().A8H(A05(723, 9, 116), C8Y.A1p, new C8Z(e2));
        }
        return anonymousClass25;
    }

    public static String A06(C2027Wc c2027Wc) {
        return A02(c2027Wc).A0J(A05(352, 14, 46), A05(0, 0, 94));
    }

    public static String A07(C2027Wc c2027Wc) {
        return A02(c2027Wc).A0J(A05(434, 20, 83), A05(312, 38, 71));
    }

    public static String A08(C2027Wc c2027Wc) {
        return A02(c2027Wc).A0J(A05(454, 16, 91), A05(38, 10, 26));
    }

    public static String A09(C2027Wc c2027Wc) {
        return A02(c2027Wc).A0J(A05(470, 18, 20), A05(48, 12, 9));
    }

    public static String A0A(C2027Wc c2027Wc) {
        return A02(c2027Wc).A0J(A05(495, 19, 96), A05(268, 23, 59));
    }

    public static String A0B(C2027Wc c2027Wc) {
        return A02(c2027Wc).A0J(A05(488, 7, 105), A05(193, 7, 27));
    }

    public static String A0C(C2027Wc c2027Wc) {
        return A02(c2027Wc).A0J(A05(597, 25, 39), A05(0, 0, 94));
    }

    public static String A0D(C2027Wc c2027Wc) {
        return A02(c2027Wc).A0J(A05(576, 21, 112), A05(200, 21, 91));
    }

    public static String A0E(C2027Wc c2027Wc) {
        return A02(c2027Wc).A0J(A05(658, 21, 68), A05(0, 38, 38));
    }

    public static String A0F(C2027Wc c2027Wc) {
        return A02(c2027Wc).A0J(A05(649, 9, 8), A05(259, 9, 41));
    }

    public static String A0G(C2027Wc c2027Wc) {
        return A02(c2027Wc).A0J(A05(732, 20, 46), A05(291, 21, 17));
    }

    public static String A0H(C2027Wc c2027Wc) {
        return A02(c2027Wc).A0J(A05(514, 25, 30), A05(60, 69, 121));
    }

    public static String A0I(C2027Wc c2027Wc) {
        return A02(c2027Wc).A0J(A05(679, 27, 53), A05(129, 64, 34));
    }

    private String A0J(String str, String str2) {
        String string = this.A00.getString(str, str2);
        return (string == null || string.equals(A05(622, 4, 33))) ? str2 : string;
    }

    public static List<AnonymousClass25> A0K(String str) throws JSONException {
        if (TextUtils.isEmpty(str) || str.equalsIgnoreCase(A05(622, 4, 33))) {
            return new ArrayList();
        }
        JSONArray jSONArray = new JSONArray(str);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = (JSONObject) jSONArray.get(i);
            AnonymousClass25 anonymousClass25 = new AnonymousClass25(jSONObject.getInt(A05(637, 12, 99)), jSONObject.getString(A05(626, 11, 123)), jSONObject.optString(A05(366, 16, 17)));
            for (AnonymousClass25 child : A0K(jSONObject.optString(A05(382, 16, 100)))) {
                anonymousClass25.A06(child);
            }
            arrayList.add(anonymousClass25);
            if (A03[0].charAt(8) == 'D') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[1] = "UoOnH9Hv65m0hYQCpY1Dh";
            strArr[1] = "UoOnH9Hv65m0hYQCpY1Dh";
        }
        return arrayList;
    }

    @Nullable
    public static Map<String, String> A0L(C2027Wc c2027Wc, @Nullable String str) {
        String strA05 = A05(723, 9, 116);
        if (str != null && !str.isEmpty()) {
            String strA052 = A05(350, 2, 65);
            if (A03[0].charAt(8) == 'D') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[6] = "bTfioiehYpOD4cPpoFnYi1pLXgWmuwWb";
            strArr[3] = "z1GRGxuKCZrDa1o5qQYziq9PHvTpBdUj";
            if (!str.equals(strA052)) {
                HashMap map = new HashMap();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    for (String str2 : A04) {
                        if (!jSONObject.has(str2)) {
                            return null;
                        }
                        String key = jSONObject.getString(str2);
                        map.put(str2, key);
                    }
                    if (A0K(jSONObject.getString(A05(706, 17, 5))).size() == 0) {
                        c2027Wc.A04().A8H(strA05, C8Y.A1o, new C8Z(A05(239, 20, 101)));
                        return null;
                    }
                    if (A0K(jSONObject.getString(A05(539, 15, 120))).size() == 0) {
                        c2027Wc.A04().A8H(strA05, C8Y.A1l, new C8Z(A05(221, 18, 10)));
                        return null;
                    }
                    return map;
                } catch (JSONException e2) {
                    c2027Wc.A04().A8H(strA05, C8Y.A1n, new C8Z(e2));
                    return null;
                }
            }
        }
        return null;
    }

    private void A0M() {
        SharedPreferences.Editor editorEdit = this.A00.edit();
        editorEdit.putLong(A05(554, 22, 23), 0L);
        editorEdit.apply();
    }

    public static void A0P(C2027Wc c2027Wc, @Nullable String str) {
        Map<String, String> mapA0L = A0L(c2027Wc, str);
        if (mapA0L == null || mapA0L.size() != A04.length) {
            return;
        }
        SharedPreferences.Editor editorEdit = A02(c2027Wc).A00.edit();
        for (String str2 : A04) {
            String key = mapA0L.get(str2);
            editorEdit.putString(str2, key);
        }
        editorEdit.putLong(A05(554, 22, 23), System.currentTimeMillis());
        editorEdit.apply();
    }

    public static boolean A0Q(C2027Wc c2027Wc, boolean z) {
        boolean z2 = z || C1693Iy.A1V(c2027Wc);
        boolean isNativeReportingAvailable = A00(c2027Wc) > 0;
        return z2 && isNativeReportingAvailable;
    }
}
