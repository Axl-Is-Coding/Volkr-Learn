package com.facebook.ads.redexgen.X;

import android.content.SharedPreferences;
import androidx.annotation.VisibleForTesting;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.util.process.ProcessUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class JF {
    public static byte[] A00;
    public static final String A01;
    public static final AtomicBoolean A02;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 7);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{57, 43, 89, 112, -126, 43, -127, 108, 119, -128, 112, 69, 43, 96, 111, 92, -127, 118, -123, 120, -128, 120, -127, -121, 124, -127, 122, 51, 118, -126, -120, -127, -121, 120, -123, 77, 51, 125, -96, -108, -110, -99, 116, -96, -90, -97, -91, -106, -93, -92, -54, -21, -16, -100, -27, -22, -27, -16, -27, -35, -24, -27, -10, -31, -32, -99, 116, 119, 119, 124, -121, 124, -126, -127, 116, 127, 114, 124, -127, 121, -126, -43, -24, -24, -39, -31, -28, -24, -111, -113, -93, -107, -106, -94, -115, -109, -90, -111, -109, -98, -94, -105, -99, -100, -46, -34, -36, -99, -43, -48, -46, -44, -47, -34, -34, -38, -99, -48, -45, -30, -99, -69, -66, -78, -80, -69, -50, -78, -66, -60, -67, -61, -76, -63, -62, -103, -106, -87, -106, -42, -25, -42, -33, -27, -28, -49, -46, -58, -60, -49, -62, -58, -46, -40, -47, -41, -56, -43, -42, -121, 120, -112, -125, -122, 120, 123, -95, -94, -113, -111, -103, -94, -96, -113, -111, -109, -124, -122, 115, -123, -118, -127, 118, -37, -35, -54, -36, -31, -40, -51, -57, -53, -41, -52, -51};
    }

    static {
        A02();
        A01 = JF.class.getSimpleName();
        A02 = new AtomicBoolean();
    }

    public static void A03(AnonymousClass87 anonymousClass87) {
        if (A09(anonymousClass87) || A02.getAndSet(true)) {
            return;
        }
        ExecutorC1744Lc.A06.execute(new C2195bA(anonymousClass87));
    }

    public static void A04(AnonymousClass87 anonymousClass87, InterfaceC1854Pj interfaceC1854Pj, Map<String, ?> map) throws JSONException {
        HashMap map2 = new HashMap();
        map2.put(A01(81, 7, 109), A01(13, 1, 41));
        A07(anonymousClass87, map2);
        HashMap map3 = new HashMap();
        map3.put(A01(176, 7, 10), A01(145, 14, 92));
        map3.put(A01(183, 12, 97), String.valueOf(3501));
        map3.put(A01(88, 16, 39), A01(14, 1, 55));
        map3.put(A01(166, 10, 39), A01(37, 13, 42));
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            jSONObject.put(entry.getKey(), String.valueOf(entry.getValue()));
        }
        map3.put(A01(66, 15, 12), jSONObject.toString());
        A07(anonymousClass87, map3);
        C14558x c14558xA05 = anonymousClass87.A05();
        JSONObject jSONObjectA05 = C14338a.A05(new C14358c(c14558xA05.A01(), c14558xA05.A02(), map3));
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObjectA05);
        JSONObject jSONObject2 = new JSONObject();
        JSONObject eventsJSON = new JSONObject(map2);
        jSONObject2.put(A01(135, 4, 46), eventsJSON);
        jSONObject2.put(A01(139, 6, 106), jSONArray);
        C1868Px c1868Px = new C1868Px();
        c1868Px.put(A01(159, 7, 16), jSONObject2.toString());
        interfaceC1854Pj.ABx(anonymousClass87.A03().A6O(), c1868Px.A09(), new C2196bB());
    }

    public static void A06(AnonymousClass87 anonymousClass87, String str) {
        if (A09(anonymousClass87)) {
            return;
        }
        if (!A02.get()) {
            anonymousClass87.A04().A8X(A01(145, 14, 92), 3502, new C8Z(A01(50, 16, 117)));
            return;
        }
        synchronized (JF.class) {
            SharedPreferences sharedPreferences = anonymousClass87.getApplicationContext().getSharedPreferences(ProcessUtils.getProcessSpecificName(A01(104, 31, 104), anonymousClass87), 0);
            int i = sharedPreferences.getInt(str, 0) + 1;
            sharedPreferences.edit().putInt(str, i).apply();
            if (BuildConfigApi.isDebug()) {
                String str2 = A01(15, 22, 12) + str + A01(0, 13, 4) + i;
            }
        }
    }

    public static void A07(AnonymousClass87 anonymousClass87, Map<String, String> map) {
        Map<String, String> dataMap = anonymousClass87.A02().A4S();
        map.putAll(dataMap);
    }

    @VisibleForTesting
    public static boolean A08(double d2, int i) {
        return i <= 0 || d2 >= 1.0d / ((double) i);
    }

    public static boolean A09(AnonymousClass87 anonymousClass87) {
        if (BuildConfigApi.isDebug()) {
            return false;
        }
        if (!J0.A0V(anonymousClass87)) {
            return true;
        }
        return A08(anonymousClass87.A05().A00(), J0.A0C(anonymousClass87));
    }
}
