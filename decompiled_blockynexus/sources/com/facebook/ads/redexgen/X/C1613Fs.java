package com.facebook.ads.redexgen.X;

import android.net.TrafficStats;
import androidx.annotation.Nullable;
import com.umeng.analytics.pro.ci;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.net.ssl.HttpsURLConnection;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1613Fs implements InterfaceC1854Pj {
    public static byte[] A07;
    public static String[] A08;
    public static final String A09;
    public C8X A00;
    public Executor A01;
    public boolean A02;
    public C1859Po A03;
    public final InterfaceC1869Py A06;
    public final InterfaceC1864Pt A05 = new C1620Fz();
    public InterfaceC1870Pz A04 = new C1612Fr();

    public static String A07(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 93);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A09() {
        A07 = new byte[]{ci.n, 18, 55, 58, 95, 55, 53, 74, 71, ci.l, 74, 72, ci.m, 76, 90, 93, 67, ci.m, ci.l, 71, 93, ci.l, 64, 65, 90, ci.l, 79, ci.l, 88, 79, 66, 71, 74, ci.l, 123, 124, 98, ci.l, 65, 72, ci.l, 94, 102, 106, 9, 30, 106, 119, 106, 28, ci.n, 98, 100, ci.n, ci.k, ci.n, 55, 59, 111, 105, 98, 114, 117, 124, 59, 81, 17, 59, 50, Utf8.REPLACEMENT_BYTE, 46, 45, 59, 58, 94, 42, 55, 51, 59, 94, 67, 94, 1, 35, 50, 50, 47, 40, 33, 102, 50, 46, 35, 102, 46, 50, 50, 54, 102, 52, 35, 53, 54, 41, 40, 53, 35, 102, 50, 47, 43, 35, 34, 102, 41, 51, 50, 61, 60, 46, 69, 80, 22, 7, 7, 27, 30, 20, 22, 3, 30, 24, 25, 88, ci.m, 90, 0, 0, 0, 90, 17, 24, 5, 26, 90, 2, 5, 27, 18, 25, 20, 24, 19, 18, 19, 76, 20, 31, 22, 5, 4, 18, 3, 74, 34, 35, 49, 90, 79, 120, 110, 105, 119, 59, 54, 112, 59, 54, 114, 34, 41, 56, 59, 35, 62, 39};
    }

    public static void A0A() {
        A08 = new String[]{"Z3ZBH3trhaxMswGoeO0i3WMhBsCqcWgs", "P814sFImmOC", "INcscN3Z5kcfIuBeknVxelrdNm8ANoXs", "RvJjsajerkLdUat3TDI8NPR3DDSWtO", "ZLSXhw", "wxtWSqUF9a7Aw2d1StIocmcoa4QX", "58xAXbC3p", "Zj1UZNXOzFX"};
    }

    static {
        A0A();
        A09();
        A09 = InterfaceC1854Pj.class.getSimpleName();
    }

    public C1613Fs(C1859Po c1859Po, C8X c8x, Executor executor) {
        A0B();
        this.A03 = c1859Po;
        this.A06 = new AbstractC1619Fy() { // from class: com.facebook.ads.redexgen.X.4D
        };
        this.A01 = executor;
        this.A00 = c8x;
    }

    private final int A00(HttpURLConnection httpURLConnection, byte[] bArr) throws Exception {
        OutputStream outputStreamABn = null;
        try {
            outputStreamABn = this.A06.ABn(httpURLConnection);
            if (outputStreamABn != null) {
                this.A06.AEG(outputStreamABn, bArr);
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (outputStreamABn != null) {
                try {
                    outputStreamABn.close();
                } catch (Exception unused) {
                }
            }
            return responseCode;
        } catch (Throwable th) {
            if (outputStreamABn != null) {
                try {
                    outputStreamABn.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    private final InterfaceC1853Pi A01(AbstractC1866Pv abstractC1866Pv) throws Exception {
        Exception e2;
        InterfaceC1853Pi c1614Ft;
        String strA07 = A07(179, 7, 17);
        HttpURLConnection httpURLConnection = null;
        InterfaceC1853Pi interfaceC1853PiA05 = null;
        boolean z = false;
        try {
            try {
                this.A02 = false;
                HttpURLConnection httpURLConnectionA08 = A08(abstractC1866Pv.A05());
                A0H(httpURLConnectionA08, abstractC1866Pv);
                A0G(httpURLConnectionA08, abstractC1866Pv);
                if (this.A04.A7t()) {
                    this.A04.A8V(httpURLConnectionA08, abstractC1866Pv.A06());
                }
                httpURLConnectionA08.connect();
                this.A02 = true;
                Set<String> setA01 = this.A03.A01();
                Set<String> setA02 = this.A03.A02();
                boolean pinKeys = (setA01 == null || setA01.isEmpty()) ? false : true;
                if (setA02 != null && !setA02.isEmpty()) {
                    z = true;
                }
                if ((httpURLConnectionA08 instanceof HttpsURLConnection) && (pinKeys || z)) {
                    try {
                        Q0.A03((HttpsURLConnection) httpURLConnectionA08, setA01, setA02);
                    } catch (CertificateException e3) {
                        this.A00.A8X(strA07, C8Y.A1f, new C8Z(e3));
                    } catch (Exception e4) {
                        this.A00.A8X(strA07, C8Y.A1e, new C8Z(e4));
                    }
                }
                if (httpURLConnectionA08.getDoOutput() && abstractC1866Pv.A06() != null) {
                    A00(httpURLConnectionA08, abstractC1866Pv.A06());
                }
                if (httpURLConnectionA08.getDoInput()) {
                    c1614Ft = A06(httpURLConnectionA08);
                } else {
                    c1614Ft = new C1614Ft(httpURLConnectionA08, null);
                }
                if (this.A04.A7t()) {
                    this.A04.A8W(c1614Ft);
                }
                httpURLConnectionA08.disconnect();
                return c1614Ft;
            } catch (Exception ee) {
                try {
                    try {
                        interfaceC1853PiA05 = A05(null);
                    } catch (Throwable unused) {
                        if (interfaceC1853PiA05 != null && interfaceC1853PiA05.A7B() > 0) {
                            if (this.A04.A7t()) {
                                this.A04.A8W(interfaceC1853PiA05);
                            }
                            if (0 != 0) {
                                httpURLConnection.disconnect();
                            }
                            return interfaceC1853PiA05;
                        }
                        Exception e5 = new C1867Pw(ee, interfaceC1853PiA05);
                        throw e5;
                    }
                } catch (Exception unused2) {
                    ee.printStackTrace();
                    if (interfaceC1853PiA05 != null && interfaceC1853PiA05.A7B() > 0) {
                        if (this.A04.A7t()) {
                            InterfaceC1870Pz interfaceC1870Pz = this.A04;
                            String[] strArr = A08;
                            if (strArr[0].charAt(28) == strArr[2].charAt(28)) {
                                Exception e6 = new RuntimeException();
                                throw e6;
                            }
                            String[] strArr2 = A08;
                            strArr2[1] = "yaq9HQ3M3BI";
                            strArr2[7] = "lkFDbfWlXmK";
                            interfaceC1870Pz.A8W(interfaceC1853PiA05);
                        }
                        if (0 != 0) {
                            httpURLConnection.disconnect();
                        }
                        return interfaceC1853PiA05;
                    }
                    e2 = new C1867Pw(ee, interfaceC1853PiA05);
                }
                if (interfaceC1853PiA05 == null || interfaceC1853PiA05.A7B() <= 0) {
                    e2 = new C1867Pw(ee, interfaceC1853PiA05);
                    throw e2;
                }
                if (this.A04.A7t()) {
                    this.A04.A8W(interfaceC1853PiA05);
                }
                if (0 != 0) {
                    httpURLConnection.disconnect();
                }
                return interfaceC1853PiA05;
            }
        } catch (Throwable th) {
            if (this.A04.A7t()) {
                this.A04.A8W(interfaceC1853PiA05);
            }
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    @Nullable
    private final InterfaceC1853Pi A02(AbstractC1866Pv abstractC1866Pv) {
        if (this.A03.A04()) {
            A0C(abstractC1866Pv);
        }
        InterfaceC1853Pi interfaceC1853PiA01 = null;
        try {
            interfaceC1853PiA01 = A01(abstractC1866Pv);
            return interfaceC1853PiA01;
        } catch (C1867Pw e2) {
            this.A06.A9r(e2);
            return interfaceC1853PiA01;
        } catch (Exception e3) {
            this.A06.A9r(new C1867Pw(e3, interfaceC1853PiA01));
            return interfaceC1853PiA01;
        }
    }

    @Nullable
    private final InterfaceC1853Pi A03(String str, C1868Px c1868Px, C1862Pr c1862Pr) {
        return A02(new C1617Fw(str, c1868Px, c1862Pr));
    }

    @Nullable
    private final InterfaceC1853Pi A04(String str, String str2, byte[] bArr, C1862Pr c1862Pr) {
        return A02(new C1616Fv(str, null, str2, bArr, c1862Pr));
    }

    private final InterfaceC1853Pi A05(HttpURLConnection httpURLConnection) throws Exception {
        InputStream errorStream = null;
        byte[] bArrACN = null;
        try {
            errorStream = httpURLConnection.getErrorStream();
            if (errorStream != null) {
                bArrACN = this.A06.ACN(errorStream);
            }
            C1614Ft c1614Ft = new C1614Ft(httpURLConnection, bArrACN);
            if (errorStream != null) {
                try {
                    errorStream.close();
                } catch (Exception unused) {
                }
            }
            return c1614Ft;
        } catch (Throwable th) {
            if (errorStream != null) {
                try {
                    errorStream.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    private final InterfaceC1853Pi A06(HttpURLConnection httpURLConnection) throws Exception {
        InputStream inputStreamABm = null;
        byte[] bArrACN = null;
        try {
            inputStreamABm = this.A06.ABm(httpURLConnection);
            if (inputStreamABm != null) {
                bArrACN = this.A06.ACN(inputStreamABm);
            }
            C1614Ft c1614Ft = new C1614Ft(httpURLConnection, bArrACN);
            if (inputStreamABm != null) {
                try {
                    inputStreamABm.close();
                } catch (Exception unused) {
                }
            }
            return c1614Ft;
        } catch (Throwable th) {
            if (inputStreamABm != null) {
                try {
                    inputStreamABm.close();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    private final HttpURLConnection A08(String str) throws IOException {
        try {
            new URL(str);
            TrafficStats.setThreadStatsTag(61453);
            return this.A06.ABl(str);
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException(str + A07(18, 19, 115), e2);
        }
    }

    public static synchronized void A0B() {
        if (CookieHandler.getDefault() == null) {
            CookieHandler.setDefault(new CookieManager());
        }
    }

    private void A0C(AbstractC1866Pv abstractC1866Pv) {
        StringBuilder sb = new StringBuilder(A07(169, 10, 70));
        boolean zEquals = abstractC1866Pv.A03().equals(EnumC1865Pu.A06);
        String strA07 = A07(41, 1, 33);
        if (zEquals && abstractC1866Pv.A06() != null) {
            sb.append(A07(7, 5, 55));
            sb.append(new String(abstractC1866Pv.A06(), Charset.forName(A07(117, 5, 53))));
            sb.append(strA07);
        }
        Map<String, String> mapA06 = abstractC1866Pv.A02().A06();
        String[] strArr = A08;
        if (strArr[1].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A08;
        strArr2[3] = "s0c02ga9sXqOOqZgqzjFkG4II3gfLx";
        strArr2[6] = "iECV1gT3x";
        for (Map.Entry<String, String> entry : mapA06.entrySet()) {
            sb.append(A07(2, 5, 74));
            sb.append(entry.getKey());
            sb.append(A07(66, 1, 118));
            sb.append(entry.getValue());
            sb.append(strA07);
        }
        sb.append(A07(0, 2, 109));
        sb.append(abstractC1866Pv.A05());
        sb.append(strA07);
        String string = sb.toString();
        A0E(string, 1, (string.length() / 4000) + 1);
    }

    private void A0D(AbstractC1866Pv abstractC1866Pv, InterfaceC1855Pk interfaceC1855Pk) {
        this.A05.A5W(this, interfaceC1855Pk, this.A01).A57(abstractC1866Pv);
        if (this.A03.A04()) {
            A0C(abstractC1866Pv);
        }
    }

    private void A0E(String str, int i, int i2) {
        String str2 = A09 + A07(12, 6, 114) + i + A07(65, 1, 35) + i2;
        if (str.length() > 4000) {
            str.substring(0, 4000);
            A0E(str.substring(4000), i + 1, i2);
        }
    }

    private void A0F(String str, String str2, byte[] bArr, InterfaceC1855Pk interfaceC1855Pk, C1862Pr c1862Pr) {
        A0D(new C1616Fv(str, null, str2, bArr, c1862Pr), interfaceC1855Pk);
    }

    private void A0G(HttpURLConnection httpURLConnection, AbstractC1866Pv abstractC1866Pv) {
        Map<String, String> mapA06 = abstractC1866Pv.A02().A06();
        InterfaceC1852Ph interfaceC1852PhA05 = abstractC1866Pv.A02().A05();
        for (String str : mapA06.keySet()) {
            String name = mapA06.get(str);
            httpURLConnection.setRequestProperty(str, name);
        }
        if (interfaceC1852PhA05 != null) {
            Map<String, String> mapA5J = interfaceC1852PhA05.A5J(this.A03.A03());
            for (String str2 : mapA5J.keySet()) {
                String value = mapA5J.get(str2);
                httpURLConnection.setRequestProperty(str2, value);
            }
        }
    }

    private final void A0H(HttpURLConnection httpURLConnection, AbstractC1866Pv abstractC1866Pv) throws IOException {
        C1862Pr c1862PrA02 = abstractC1866Pv.A02();
        httpURLConnection.setConnectTimeout(c1862PrA02.A00());
        httpURLConnection.setReadTimeout(c1862PrA02.A02());
        this.A06.AC3(httpURLConnection, abstractC1866Pv.A03(), abstractC1866Pv.A04());
    }

    private final boolean A0I(Throwable th, long j, AbstractC1866Pv abstractC1866Pv) {
        C1862Pr c1862PrA02 = abstractC1866Pv.A02();
        long jCurrentTimeMillis = (System.currentTimeMillis() - j) + 10;
        if (this.A04.A7t()) {
            this.A04.A88(A07(67, 15, 35) + jCurrentTimeMillis + A07(42, 7, 23) + c1862PrA02.A00() + A07(49, 7, 109) + c1862PrA02.A02());
        }
        if (this.A02) {
            return jCurrentTimeMillis >= ((long) c1862PrA02.A02());
        }
        long jA00 = c1862PrA02.A00();
        if (A08[5].length() != 28) {
            throw new RuntimeException();
        }
        String[] strArr = A08;
        strArr[3] = "UT6xnSlzbr9JaeC9T1uoRQiwoDXC3Y";
        strArr[6] = "g5URFCrsk";
        return jCurrentTimeMillis >= jA00;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.InterfaceC1853Pi A0J(com.facebook.ads.redexgen.X.AbstractC1866Pv r31) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 534
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1613Fs.A0J(com.facebook.ads.redexgen.X.Pv):com.facebook.ads.redexgen.X.Pi");
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1854Pj
    @Nullable
    @Deprecated
    public final InterfaceC1853Pi ABv(String str, Map<String, String> map) {
        return A03(str, new C1868Px(map), this.A03.A00());
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1854Pj
    @Nullable
    @Deprecated
    public final InterfaceC1853Pi ABw(String str, byte[] bArr) {
        return A04(str, A07(122, 47, 42), bArr, this.A03.A00());
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1854Pj
    public final void ABx(String str, byte[] bArr, InterfaceC1855Pk interfaceC1855Pk) {
        A0F(str, A07(122, 47, 42), bArr, interfaceC1855Pk, this.A03.A00());
    }
}
