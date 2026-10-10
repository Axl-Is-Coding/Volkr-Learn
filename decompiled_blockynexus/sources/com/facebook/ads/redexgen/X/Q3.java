package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.umeng.analytics.pro.ci;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Q3 extends AsyncTask<String, Void, Q4> {
    public static byte[] A05;
    public static String[] A06;
    public static final String A07;
    public static final Set<String> A08;
    public AnonymousClass87 A00;
    public InterfaceC1853Pi A01;
    public Q2 A02;
    public Map<String, String> A03;
    public Map<String, String> A04;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 90);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A05 = new byte[]{48, 0, 3, 57, 33, 22, 22, 11, 22, 68, 11, 20, 1, 10, ci.k, 10, 3, 68, 17, 22, 8, 94, 68, 122, 117, 122, 119, 116, 124, 44, 55, 46, 46};
    }

    public static void A05() {
        A06 = new String[]{"iMGBqiSHm2uYyOurEO", "JHkNge3qKUrOixxb", "Efd0ZU7p6XsOViiGEn9FTnCEMV0phXsZ", "Qqux8MYyckh5CceEy", "ksejtLtP", "6qwv67", "yXEFufBpuo", "JuPO8KFa"};
    }

    static {
        A05();
        A04();
        A07 = Q3.class.getSimpleName();
        A08 = new HashSet();
        A08.add(A01(0, 1, 73));
        A08.add(A01(29, 4, 24));
    }

    public Q3(AnonymousClass87 anonymousClass87) {
        this(anonymousClass87, null, null);
    }

    public Q3(AnonymousClass87 anonymousClass87, Map<String, String> map) {
        this(anonymousClass87, map, null);
    }

    public Q3(AnonymousClass87 anonymousClass87, Map<String, String> map, Map<String, String> map2) {
        this.A00 = anonymousClass87;
        Map<String, String> postData = map != null ? new HashMap<>(map) : null;
        this.A03 = postData;
        Map<String, String> extraData = map2 != null ? new HashMap<>(map2) : null;
        this.A04 = extraData;
    }

    private final Q4 A00(String... strArr) throws Throwable {
        if (KL.A02(this)) {
            return null;
        }
        try {
            String str = strArr[0];
            if (!TextUtils.isEmpty(str) && !A08.contains(str)) {
                String strA02 = A02(str);
                if (this.A03 != null && !this.A03.isEmpty()) {
                    for (Map.Entry<String, String> entry : this.A03.entrySet()) {
                        String key = entry.getKey();
                        String url = entry.getValue();
                        strA02 = A03(strA02, key, url);
                    }
                }
                int i = 1;
                while (true) {
                    int i2 = i + 1;
                    if (i > 2) {
                        return null;
                    }
                    if (A07(strA02)) {
                        return new Q4(this.A01);
                    }
                    i = i2;
                }
            }
            return null;
        } catch (Throwable th) {
            if (A06[6].length() == 31) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[6] = "dO3qGWbyMuVAZQTwO1X30zVxIjEEo";
            strArr2[6] = "dO3qGWbyMuVAZQTwO1X30zVxIjEEo";
            KL.A00(th, this);
            return null;
        }
    }

    private String A02(String str) {
        try {
            return A03(str, A01(23, 6, 65), L6.A01(this.A00.A02().A5U()));
        } catch (Exception unused) {
            return str;
        }
    }

    private String A03(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return str;
        }
        String strA01 = A01(3, 1, 92);
        if (str.contains(strA01)) {
            strA01 = A01(1, 1, 124);
        }
        return str + strA01 + str2 + A01(2, 1, 100) + URLEncoder.encode(str3);
    }

    private final void A06(Q4 q4) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            if (this.A02 != null) {
                this.A02.AC9(q4);
            }
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @SuppressLint({"CatchGeneralException"})
    private boolean A07(String str) {
        InterfaceC1853Pi interfaceC1853PiABv;
        InterfaceC1854Pj interfaceC1854PjA00 = Q1.A00(this.A00);
        try {
            if (this.A04 == null || this.A04.size() == 0) {
                interfaceC1853PiABv = interfaceC1854PjA00.ABv(str, new C1868Px());
            } else {
                C1868Px c1868Px = new C1868Px();
                c1868Px.A06(this.A04);
                interfaceC1853PiABv = interfaceC1854PjA00.ABw(str, c1868Px.A09());
            }
            this.A01 = interfaceC1853PiABv;
        } catch (Exception e2) {
            Log.e(A07, A01(4, 19, 62) + str, e2);
        }
        InterfaceC1853Pi interfaceC1853Pi = this.A01;
        return interfaceC1853Pi != null && interfaceC1853Pi.A7B() == 200;
    }

    public final void A08(Q2 q2) {
        this.A02 = q2;
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ Q4 doInBackground(String[] strArr) throws Throwable {
        if (KL.A02(this)) {
            return null;
        }
        try {
            return A00(strArr);
        } catch (Throwable th) {
            KL.A00(th, this);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final void onCancelled() {
        Q2 q2 = this.A02;
        if (q2 != null) {
            q2.AC7();
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(Q4 q4) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A06(q4);
        } catch (Throwable th) {
            if (A06[3].length() != 17) {
                throw new RuntimeException();
            }
            String[] strArr = A06;
            strArr[2] = "KahWFkeddZk466vYoInqTxrEqXEaISmf";
            strArr[2] = "KahWFkeddZk466vYoInqTxrEqXEaISmf";
            KL.A00(th, this);
        }
    }
}
