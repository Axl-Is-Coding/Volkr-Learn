package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.just.agentweb.ActionActivity;
import com.umeng.analytics.pro.ci;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okio.Utf8;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RD implements InterfaceC12460h, InterfaceC12510m {
    public static byte[] A0a;
    public static String[] A0b;
    public static final String A0c;
    public int A00;
    public int A01;
    public int A03;
    public int A04;
    public int A06;
    public int A07;
    public long A08;
    public Uri A09;
    public EnumC12450g A0A;
    public AnonymousClass10 A0B;
    public C2026Wb A0C;

    @Nullable
    public J5 A0D;
    public JP A0E;
    public JQ A0F;
    public JQ A0G;
    public JQ A0H;
    public JR A0I;
    public JV A0J;
    public String A0K;
    public String A0L;
    public String A0M;
    public String A0N;
    public String A0O;
    public String A0P;
    public Collection<String> A0Q;
    public List<C2213bT> A0S;
    public boolean A0T;
    public boolean A0U;
    public boolean A0V;
    public boolean A0W;
    public boolean A0X;
    public boolean A0Y;
    public boolean A0Z;
    public HashMap<String, String> A0R = new HashMap<>();
    public int A05 = 200;
    public int A02 = -1;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0a, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 106);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A0a = new byte[]{124, 89, 126, 85, 82, 84, 94, 88, 78, 95, 122, 127, 110, 106, 123, 108, 62, 127, 114, 108, 123, 127, 122, 103, 62, 114, 113, 127, 122, 123, 122, 62, 122, 127, 106, 127, 106, 94, 79, 66, 78, 69, 72, 78, 11, 101, 78, 95, 92, 68, 89, 64, 11, 103, 68, 74, 79, 78, 79, 43, 4, 1, 11, 3, 72, 0, 9, 24, 24, ci.k, 6, ci.k, 12, 72, 7, 6, 72, 4, 7, 11, 3, 27, 11, 26, ci.k, ci.k, 6, 72, 9, 12, 96, 79, 74, 64, 72, 3, 79, 76, 68, 68, 70, 71, ci.n, 39, 39, 58, 39, 117, 48, 45, 48, 54, 32, 33, 60, 59, 50, 117, 52, 54, 33, 60, 58, 59, 113, 80, 31, 121, 86, 83, 83, 22, 45, 34, 33, 47, 38, 99, 55, 44, 99, 51, 34, 49, 48, 38, 99, 32, 34, 49, 44, 54, 48, 38, 47, 99, 39, 34, 55, 34, 109, 85, 80, 107, 87, 92, 91, 93, 87, 81, 71, 107, 93, 87, 91, 90, 93, 88, 99, 95, 84, 83, 85, 95, 89, 79, 99, 80, 85, 82, 87, 99, 73, 78, 80, 3, 6, 61, 22, ci.n, 3, 12, 17, ci.l, 3, 22, 11, ci.k, 12, 73, 76, 94, 77, 90, 92, 65, 91, 77, 90, 119, 70, 73, 69, 77, 3, 12, 61, ci.l, ci.k, 5, ci.k, 61, 22, 27, 18, 7, 28, 17, 26, 7, 50, 48, 61, 61, ci.l, 37, 62, ci.l, 48, 50, 37, 56, 62, Utf8.REPLACEMENT_BYTE, 79, 77, 94, 72, 79, 66, 88, 62, 60, 47, 57, 52, 51, 57, 18, ci.n, 3, 30, 4, 2, 20, 29, 6, 17, 0, 5, ci.n, 5, 36, 37, 38, 41, 46, 41, 52, 41, 47, 46, 122, 123, 106, 123, 125, 106, 119, 113, 112, 65, 109, 106, 108, 119, 112, 121, 109, 18, 25, 22, 21, 27, 18, 40, 4, 25, 22, 7, 4, 31, 24, 3, 40, 27, 24, ci.n, 39, 44, 35, 32, 46, 39, 29, 52, 43, 39, 53, 29, 46, 45, 37, 33, 37, 38, 35, 24, 36, 40, 42, 42, 38, 41, 35, 79, 66, 70, 67, 75, 78, 73, 66, 69, 79, 67, 66, 102, 98, 110, 104, 106, 25, 30, 6, 17, 28, 25, 20, 17, 4, 25, 31, 30, 47, 18, 21, 24, 17, 6, 25, 31, 2, 71, 66, 69, 64, 116, 79, 78, 88, 72, 89, 66, 91, 95, 66, 68, 69, 31, ci.l, 29, 28, 6, 1, 8, 75, 90, 78, 72, 94, 100, 79, 73, 90, 85, 72, 87, 90, 79, 82, 84, 85, 73, 85, 88, 64, 102, 77, 75, 88, 87, 74, 85, 88, 77, 80, 86, 87, 73, 75, 86, 84, 86, 77, 92, 93, 102, 77, 75, 88, 87, 74, 85, 88, 77, 80, 86, 87, 0, 23, 3, 7, 23, 1, 6, 45, 27, 22, 110, 115, 124, 109, 110, 117, 114, 105, 54, 43, 36, 53, 54, 45, 42, 49, 26, 38, 42, 40, 53, 55, 32, 54, 54, 26, 52, 48, 36, 41, 44, 49, 60, 4, 25, 22, 7, 4, 31, 24, 3, 40, 27, 24, ci.n, 40, 19, 18, 27, 22, ci.l, 40, 4, 18, 20, 24, 25, 19, 112, 108, 96, 106, 98, 111, 92, 96, 108, 109, 119, 102, 123, 119, 5, 6, 25, 24, 5, 25, 4, 19, 18, 41, 2, 4, 23, 24, 5, 26, 23, 2, 31, 25, 24, 39, 32, 53, 38, 11, 38, 53, 32, 61, 58, 51, 34, 36, 51, 37, 56, 37, 61, 52, 42, 55, 42, 50, 59, 72, 78, 88, 89, 98, 79, 88, 77, 82, 79, 73, 98, 72, 79, 81, 121, 102, 107, 106, 96, 80, 110, 122, 123, 96, 127, 99, 110, 118, 80, 106, 97, 110, 109, 99, 106, 107, 12, 19, 30, 31, 21, 37, 23, 10, 30, 36, 59, 54, 55, 61, ci.k, 34, 32, 55, 62, 61, 51, 54, ci.k, 33, 59, 40, 55, ci.k, 48, 43, 38, 55, 33, 107, 116, 121, 120, 114, 66, 104, 111, 113, 59, 36, 40, 58, 105, 118, 122, 104, 126, 125, 118, 115, 118, 107, 102, 64, 124, 119, 122, 124, 116, 64, 118, 113, 118, 107, 118, 126, 115, 64, 123, 122, 115, 126, 102, 87, 72, 68, 86, 64, 67, 72, 77, 72, 85, 88, 126, 66, 73, 68, 66, 74, 126, 72, 79, 85, 68, 83, 87, 64, 77};
    }

    public static void A06() {
        A0b = new String[]{"OTBhn", "woE0GsYsDC", "jJJsRhZ6eh", "RbmDZKGZyk", "MbYnCV2deeCvNEpfUSPgn7RvJuamywdV", "va4Mi1JJiq4w08mNkhVxy34L1bzftr4W", "QQZqW8pW387BdDH3gcXSwYVoWAeaIxNz", "E72k8"};
    }

    static {
        A06();
        A05();
        A0c = RD.class.getSimpleName();
    }

    private Map<String, String> A03(Map<String, String> map) {
        HashMap map2 = new HashMap();
        String strA01 = A01(675, 4, 39);
        if (map.containsKey(strA01)) {
            map2.put(strA01, map.get(strA01));
        }
        String strA012 = A01(479, 8, 119);
        if (map.containsKey(strA012)) {
            map2.put(strA012, map.get(strA012));
        }
        return map2;
    }

    private void A04() {
        if (!this.A0X) {
            J5 j5 = this.A0D;
            if (A0b[2].length() != 10) {
                throw new RuntimeException();
            }
            String[] strArr = A0b;
            strArr[5] = "8ArINtb0xmmgo9NmELWQk3NiIhKYvaDc";
            strArr[5] = "8ArINtb0xmmgo9NmELWQk3NiIhKYvaDc";
            if (j5 != null) {
                j5.ABy(this.A0N);
            }
            this.A0X = true;
        }
    }

    private void A07(C2026Wb c2026Wb, JSONObject jSONObject, J5 j5, String str, int i, int i2) {
        this.A0W = true;
        this.A0C = c2026Wb;
        this.A0D = j5;
        this.A02 = i;
        this.A01 = i2;
        A09(jSONObject, str);
    }

    private void A08(Map<String, String> map, Map<String, String> map2) {
        try {
            Map<String, String> urlParams = A03(map);
            new Handler().postDelayed(new RC(this, map2, urlParams), this.A04 * 1000);
        } catch (Exception unused) {
        }
    }

    private void A09(JSONObject jSONObject, String str) {
        if (!this.A0T) {
            if (jSONObject == null) {
                return;
            }
            C1733Kr.A02(this.A0C, A01(36, 23, 65));
            this.A0L = str;
            this.A0M = jSONObject.optString(A01(469, 10, 24));
            this.A00 = jSONObject.optInt(A01(224, 12, 8), 0);
            String strA02 = L6.A02(jSONObject, A01(343, 12, 45));
            this.A09 = TextUtils.isEmpty(strA02) ? null : Uri.parse(strA02);
            String[] strArr = new String[12];
            strArr[0] = A01(209, 15, 66);
            strArr[1] = A01(591, 5, 52);
            strArr[2] = A01(583, 8, 59);
            strArr[3] = A01(355, 8, 77);
            strArr[4] = A01(236, 4, 20);
            strArr[5] = A01(537, 14, 105);
            String[] strArr2 = A0b;
            if (strArr2[1].length() == strArr2[3].length()) {
                String[] strArr3 = A0b;
                strArr3[0] = "EgjH3";
                strArr3[7] = "aXmwT";
                strArr[6] = A01(393, 16, 65);
                strArr[7] = A01(551, 21, 28);
                strArr[8] = A01(195, 14, 8);
                strArr[9] = A01(449, 20, 83);
                strArr[10] = A01(433, 16, 83);
                strArr[11] = A01(416, 17, 81);
                for (String str2 : strArr) {
                    HashMap<String, String> map = this.A0R;
                    String key = L6.A02(jSONObject, str2);
                    map.put(str2, key);
                    if (A0b[4].charAt(15) == 'f') {
                        String[] strArr4 = A0b;
                        strArr4[5] = "eWhcqXkmKwACVp6tQL5WW3qntxITuvc7";
                        strArr4[5] = "eWhcqXkmKwACVp6tQL5WW3qntxITuvc7";
                    }
                }
                String strA01 = A01(240, 14, 59);
                String strA022 = L6.A02(jSONObject, strA01);
                if (!TextUtils.isEmpty(strA022)) {
                    HashMap<String, String> map2 = this.A0R;
                    if (A0b[6].charAt(13) != 'D') {
                        String[] strArr5 = A0b;
                        strArr5[6] = "fJLCRXTMzJxf7DhTFL7Dp6MTDwlQmm1t";
                        strArr5[6] = "fJLCRXTMzJxf7DhTFL7Dp6MTDwlQmm1t";
                        map2.put(strA01, strA022);
                    } else {
                        String[] strArr6 = A0b;
                        strArr6[2] = "EZfL37EHMq";
                        strArr6[2] = "EZfL37EHMq";
                        map2.put(strA01, strA022);
                    }
                }
                String callToAction = A01(363, 4, 70);
                this.A0G = JQ.A00(jSONObject.optJSONObject(callToAction));
                String callToAction2 = A01(367, 5, 101);
                this.A0H = JQ.A00(jSONObject.optJSONObject(callToAction2));
                String callToAction3 = A01(572, 11, 62);
                this.A0I = JR.A00(jSONObject.optJSONObject(callToAction3));
                String callToAction4 = A01(ActionActivity.REQUEST_CODE, 15, 87);
                this.A0N = L6.A02(jSONObject, callToAction4);
                String callToAction5 = A01(328, 15, 40);
                this.A0Y = jSONObject.optBoolean(callToAction5);
                String callToAction6 = A01(309, 19, 29);
                this.A0Z = jSONObject.optBoolean(callToAction6);
                String callToAction7 = A01(512, 25, 29);
                this.A04 = jSONObject.optInt(callToAction7, 4);
                String callToAction8 = A01(487, 25, 47);
                this.A03 = jSONObject.optInt(callToAction8, 0);
                String callToAction9 = A01(679, 31, 117);
                this.A06 = jSONObject.optInt(callToAction9, 0);
                String callToAction10 = A01(710, 26, 75);
                this.A07 = jSONObject.optInt(callToAction10, 1000);
                String callToAction11 = A01(161, 15, 94);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(callToAction11);
                if (jSONObjectOptJSONObject != null) {
                    this.A0F = JQ.A00(jSONObjectOptJSONObject);
                }
                String callToAction12 = A01(176, 19, 86);
                this.A0K = L6.A02(jSONObject, callToAction12);
                String callToAction13 = A01(372, 21, 26);
                this.A0A = EnumC12450g.A00(jSONObject.optString(callToAction13));
                JSONArray jSONArray = null;
                try {
                    jSONArray = new JSONArray(jSONObject.optString(A01(292, 17, 116)));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                this.A0Q = C12470i.A01(jSONArray);
                this.A0P = L6.A02(jSONObject, A01(666, 9, 119));
                this.A08 = jSONObject.optLong(A01(642, 24, 56), -1L);
                this.A0O = L6.A02(jSONObject, A01(633, 9, 16));
                String strA012 = A01(611, 22, 101);
                if (!jSONObject.has(strA012)) {
                    this.A0J = JV.A03;
                } else {
                    this.A0J = jSONObject.optBoolean(strA012) ? JV.A05 : JV.A04;
                }
                try {
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(A01(268, 8, 27));
                    if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                        int length = jSONArrayOptJSONArray.length();
                        ArrayList arrayList = new ArrayList(length);
                        for (int i = 0; i < length; i++) {
                            RD rd = new RD();
                            rd.A07(this.A0C, jSONArrayOptJSONArray.getJSONObject(i), this.A0D, this.A0L, i, length);
                            arrayList.add(new C2213bT(this.A0C, rd, (C14508r) null, this.A0E));
                        }
                        this.A0S = arrayList;
                    }
                } catch (JSONException e3) {
                    this.A0C.A04().A8H(A01(409, 7, 5), C8Y.A1q, new C8Z(e3));
                    String fbadCommand = A0c;
                    Log.e(fbadCommand, A01(131, 30, 41), e3);
                }
                this.A0T = true;
                this.A0U = A0A();
                return;
            }
            throw new RuntimeException();
        }
        throw new IllegalStateException(A01(9, 27, 116));
    }

    private boolean A0A() {
        if (((!this.A0W && !TextUtils.isEmpty(this.A0R.get(A01(209, 15, 66)))) || (!TextUtils.isEmpty(this.A0R.get(A01(591, 5, 52))) && this.A0W)) && (this.A0G != null || this.A0W)) {
            JQ jq = this.A0H;
            if (A0b[2].length() != 10) {
                throw new RuntimeException();
            }
            String[] strArr = A0b;
            strArr[6] = "coz4LHwVNN2LSDndRSBnj9WvwXuRM5HO";
            strArr[6] = "coz4LHwVNN2LSDndRSBnj9WvwXuRM5HO";
            if (jq != null || A6p() == AdPlacementType.NATIVE_BANNER) {
                return true;
            }
        }
        return false;
    }

    public final int A0B() {
        return this.A00;
    }

    public final int A0C() {
        return this.A01;
    }

    public final int A0D() {
        return this.A02;
    }

    public final int A0E() {
        int i = this.A03;
        if (i < 0 || i > 100) {
            return 0;
        }
        return i;
    }

    public final int A0F() {
        return this.A05;
    }

    public final int A0G() {
        return this.A06;
    }

    public final int A0H() {
        return this.A07;
    }

    public final JQ A0I() {
        if (!A0g()) {
            return null;
        }
        return this.A0F;
    }

    public final JQ A0J() {
        if (!A0g()) {
            return null;
        }
        return this.A0H;
    }

    public final JQ A0K() {
        if (!A0g()) {
            return null;
        }
        return this.A0G;
    }

    public final JR A0L() {
        if (!A0g()) {
            return null;
        }
        A04();
        return this.A0I;
    }

    public final JV A0M() {
        if (!A0g()) {
            return JV.A03;
        }
        return this.A0J;
    }

    public final Long A0N() {
        if (!A0g()) {
            return -1L;
        }
        return Long.valueOf(this.A08);
    }

    public final String A0O() {
        if (!A0g()) {
            return null;
        }
        A04();
        return LI.A01(this.A0R.get(A01(236, 4, 20)));
    }

    public final String A0P() {
        if (!A0g()) {
            return null;
        }
        return this.A0K;
    }

    public final String A0Q() {
        if (A0g()) {
            return A01(0, 9, 87);
        }
        if (A0b[6].charAt(13) != 'D') {
            throw new RuntimeException();
        }
        String[] strArr = A0b;
        strArr[4] = "6LnlrboEXfVkWbJfSSNj7sObvXF9GrkL";
        strArr[4] = "6LnlrboEXfVkWbJfSSNj7sObvXF9GrkL";
        return null;
    }

    public final String A0R() {
        return this.A0M;
    }

    public final String A0S() {
        if (!A0g()) {
            return null;
        }
        return this.A0O;
    }

    public final String A0T() {
        if (!A0g()) {
            return null;
        }
        return this.A0P;
    }

    @Nullable
    public final String A0U(String str) {
        if (!A0g()) {
            return null;
        }
        A04();
        return this.A0R.get(str);
    }

    public final List<C2213bT> A0V() {
        if (!A0g()) {
            return null;
        }
        return this.A0S;
    }

    public final void A0W() {
        Iterator<C2213bT> it;
        List<C2213bT> list = this.A0S;
        if (list == null) {
            return;
        }
        boolean zIsEmpty = list.isEmpty();
        if (A0b[6].charAt(13) != 'D') {
            throw new RuntimeException();
        }
        String[] strArr = A0b;
        strArr[6] = "kj4WnsmCok25qDrlf1kxSYggARLvW33C";
        strArr[6] = "kj4WnsmCok25qDrlf1kxSYggARLvW33C";
        if (!zIsEmpty) {
            List<C2213bT> list2 = this.A0S;
            if (A0b[2].length() != 10) {
                it = list2.iterator();
            } else {
                String[] strArr2 = A0b;
                strArr2[2] = "wGXHpE1nya";
                strArr2[2] = "wGXHpE1nya";
                it = list2.iterator();
            }
            while (true) {
                boolean zHasNext = it.hasNext();
                if (A0b[2].length() != 10) {
                    String[] strArr3 = A0b;
                    strArr3[6] = "0lb5BUzW8n1EJDWyWAqaA7d0lZJNpkzV";
                    strArr3[6] = "0lb5BUzW8n1EJDWyWAqaA7d0lZJNpkzV";
                    if (!zHasNext) {
                        return;
                    }
                } else {
                    String[] strArr4 = A0b;
                    strArr4[5] = "QJQdkpg5cmGOeaue26HVF3aLtsB2qwfM";
                    strArr4[5] = "QJQdkpg5cmGOeaue26HVF3aLtsB2qwfM";
                    if (!zHasNext) {
                        return;
                    }
                }
                C2213bT internalNativeAd = it.next();
                internalNativeAd.unregisterView();
            }
        }
    }

    public final void A0X(AnonymousClass10 anonymousClass10) {
        this.A0B = anonymousClass10;
    }

    public final void A0Y(C2026Wb c2026Wb, AnonymousClass10 anonymousClass10, J5 j5, Map<String, Object> map, JP jp) {
        int iA06;
        this.A0C = c2026Wb;
        this.A0B = anonymousClass10;
        this.A0D = j5;
        this.A0E = jp;
        JSONObject jSONObject = (JSONObject) map.get(A01(278, 4, 14));
        C14508r c14508r = (C14508r) map.get(A01(282, 10, 42));
        if (c14508r != null) {
            iA06 = c14508r.A06();
        } else {
            iA06 = 200;
        }
        this.A05 = iA06;
        A09(jSONObject, L6.A02(jSONObject, A01(276, 2, 15)));
        if (C12470i.A04(c2026Wb, this, j5)) {
            c2026Wb.A0A().A41();
            anonymousClass10.AAc(this, new C1697Jd(AdErrorType.NO_FILL, A01(124, 7, 85)));
        } else if (anonymousClass10 != null) {
            anonymousClass10.AAZ(this);
        }
    }

    public final void A0Z(Map<String, String> urlParams) {
        if (!A0g()) {
            return;
        }
        if (C1693Iy.A1A(this.A0C) && LY.A04(urlParams)) {
            String str = A0c;
            if (A0b[4].charAt(15) != 'f') {
                throw new RuntimeException();
            }
            String[] strArr = A0b;
            strArr[6] = "D3JUlaax70Z19DqZX7Vx94n8SobUQcIP";
            strArr[6] = "D3JUlaax70Z19DqZX7Vx94n8SobUQcIP";
            Log.e(str, A01(59, 31, 2));
            return;
        }
        HashMap map = new HashMap();
        if (urlParams != null) {
            map.putAll(urlParams);
        }
        C1733Kr.A02(this.A0C, A01(90, 12, 73));
        AnonymousClass10 anonymousClass10 = this.A0B;
        if (anonymousClass10 != null) {
            anonymousClass10.AAY(this);
        }
        if (this.A0W) {
            map.put(A01(261, 7, 55), String.valueOf(this.A02));
            map.put(A01(254, 7, 70), String.valueOf(this.A01));
        }
        AbstractC12430e adAction = C12440f.A00(this.A0C, this.A0D, this.A0L, this.A09, map);
        if (adAction != null) {
            try {
                adAction.A0D();
            } catch (Exception e2) {
                Log.e(A0c, A01(102, 22, 63), e2);
            }
        }
    }

    public final void A0a(Map<String, String> map) {
        J5 j5 = this.A0D;
        if (j5 != null) {
            j5.A8D(this.A0L, map);
        }
    }

    public final void A0b(Map<String, String> map) {
        if (A0g() && !this.A0V) {
            AnonymousClass10 anonymousClass10 = this.A0B;
            if (anonymousClass10 != null) {
                anonymousClass10.AAa(this);
            }
            HashMap map2 = new HashMap();
            if (map != null) {
                map2.putAll(map);
            }
            if (this.A0W) {
                map2.put(A01(261, 7, 55), String.valueOf(this.A02));
                map2.put(A01(254, 7, 70), String.valueOf(this.A01));
            }
            if (!TextUtils.isEmpty(A5q()) && this.A0D != null) {
                if (!this.A0W) {
                    this.A0C.A0A().A2a();
                }
                this.A0D.A8M(A5q(), map2);
            }
            if (A0i() || A0j()) {
                A08(map, map2);
            }
            this.A0V = true;
        }
    }

    public final void A0c(Map<String, String> map) {
        J5 j5 = this.A0D;
        if (j5 != null) {
            j5.A8c(this.A0L, map);
        }
    }

    public final void A0d(Map<String, String> map) {
        J5 j5 = this.A0D;
        if (j5 != null) {
            j5.A8d(this.A0L, map);
        }
    }

    public final boolean A0e() {
        return true;
    }

    public final boolean A0f() {
        return A0g() && this.A09 != null;
    }

    public final boolean A0g() {
        return this.A0T && this.A0U;
    }

    public final boolean A0h() {
        return this.A0W;
    }

    public final boolean A0i() {
        if (C1693Iy.A0u(this.A0C) && A0g()) {
            boolean z = this.A0Y;
            if (A0b[4].charAt(15) != 'f') {
                throw new RuntimeException();
            }
            String[] strArr = A0b;
            strArr[6] = "hsrOxssvGH6abDOIeI9T6FJFSNjQSl4a";
            strArr[6] = "hsrOxssvGH6abDOIeI9T6FJFSNjQSl4a";
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean A0j() {
        if (C1693Iy.A0u(this.A0C) && A0g()) {
            boolean z = this.A0Z;
            String[] strArr = A0b;
            if (strArr[0].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0b;
            strArr2[2] = "qputmJyOXU";
            strArr2[2] = "qputmJyOXU";
            if (z) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12460h, com.facebook.ads.redexgen.X.InterfaceC12510m
    public final String A5q() {
        return this.A0L;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12460h
    public final Collection<String> A68() {
        return this.A0Q;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12460h
    public final EnumC12450g A6X() {
        return this.A0A;
    }

    public AdPlacementType A6p() {
        return AdPlacementType.NATIVE;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12510m
    public final void onDestroy() {
    }
}
