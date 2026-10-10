package com.facebook.ads.redexgen.X;

import android.util.Log;
import androidx.annotation.Nullable;
import com.umeng.analytics.pro.ci;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1891Qu implements C0K {
    public static String A07;
    public static byte[] A08;
    public static String[] A09;
    public int A00;
    public InputStream A01;
    public HttpURLConnection A02;
    public final String A03;
    public volatile int A04;
    public volatile int A05;

    @Nullable
    public volatile String A06;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            byte b2 = (byte) ((bArrCopyOfRange[i4] - i3) - 93);
            if (A09[7].charAt(10) == 'N') {
                throw new RuntimeException();
            }
            String[] strArr = A09;
            strArr[3] = "xmylGJpTyqy6yVXTtCE3KaogQJsBWdto";
            strArr[3] = "xmylGJpTyqy6yVXTtCE3KaogQJsBWdto";
            bArrCopyOfRange[i4] = b2;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A08 = new byte[]{-65, 8, 18, -65, 8, ci.k, 19, 4, 17, 17, 20, ci.m, 19, 4, 3, -65, 19, ci.l, -65, -45, 42, 28, 39, 27, -45, 34, 25, 25, 38, 24, 39, -45, -19, -31, 36, 48, 47, 53, 38, 47, 53, -18, 45, 38, 47, 40, 53, 41, -5, -31, -100, -84, -110, -43, -31, -32, -32, -41, -43, -26, -37, -31, -32, -110, -37, -27, -110, -45, -44, -27, -41, -32, -26, -109, 8, 52, 51, 57, 42, 51, 57, -27, 46, 51, 43, 52, -27, 43, 52, 55, -27, 37, -1, 44, 44, 41, 44, -38, 30, 35, 45, 29, 41, 40, 40, 31, 29, 46, 35, 40, 33, -38, 2, 46, 46, 42, ci.m, 44, 38, -3, 41, 40, 40, 31, 29, 46, 35, 41, 40, -17, 28, 28, 25, 28, -54, ci.n, ci.m, 30, ci.k, 18, 19, 24, 17, -54, 19, 24, ci.n, 25, -54, ci.n, 28, 25, 23, -54, -31, ci.l, ci.l, 11, ci.l, -68, 11, 12, 1, 10, 5, 10, 3, -68, -1, 11, 10, 10, 1, -1, ci.n, 5, 11, 10, -68, 2, 11, ci.l, -68, 10, 55, 55, 52, 55, -27, 55, 42, 38, 41, 46, 51, 44, -27, 41, 38, 57, 38, -27, 43, 55, 52, 50, -27, -50, -6, -6, -10, -37, -8, -14, -39, -11, -5, -8, -23, -21, 1, -5, -8, -14, -61, -83, -38, -3, -15, -17, 2, -9, -3, -4, 18, 51, 40, 49, -29, 38, 50, 49, 49, 40, 38, 55, 44, 50, 49, -29, -21, -6, 7, 0, -2, -53, -34, -38, -35, -103, -36, -24, -25, -19, -34, -25, -19, -103, -30, -25, -33, -24, -103, -33, -21, -24, -26, -103, ci.m, 34, 30, 33, 38, 43, 36, -35, 48, 44, 50, 47, 32, 34, -35, 27, 54, 54, -25, 52, 40, 53, 64, -25, 57, 44, 43, 48, 57, 44, 42, 59, 58, 1, -25, -9, -47, -73, 4, 0, 4, -4, -47, -73, 62, 85, 80, 65, 79, 25, 49};
    }

    public static void A05() {
        A09 = new String[]{"0sQYFfkZHHeVMKUBSEw8nV", "OMjsYZjecgzBPFsO2qu9DXSbxh5JXpo7", "UT2rHb55ERwVxNOqpRWPVvfe1UkWVyPP", "dnZnJ0uYb7k8tLcQy7f3QyFDUQrwjEiR", "oxpcdWRNT0kUjhHWpmvIkR5l", "M5dLDfrAE2TxcxVuZGCd0hZ7u7RiqVG3", "YVmAwTI", "30bRwIya64cDsyZ9K4ZP4bQrXzvqCneG"};
    }

    static {
        A05();
        A04();
        A07 = C1891Qu.class.getSimpleName();
    }

    public C1891Qu(String str) {
        this(str, C0I.A01(str));
    }

    public C1891Qu(String str, int i) {
        this(str);
        this.A00 = i;
    }

    public C1891Qu(String str, @Nullable String str2) {
        this.A05 = Integer.MIN_VALUE;
        this.A00 = -1;
        this.A03 = (String) C0J.A00(str);
        this.A06 = str2;
    }

    private int A00(HttpURLConnection httpURLConnection, int i, int i2) throws IOException {
        int contentLength = httpURLConnection.getContentLength();
        return i2 == 200 ? contentLength : i2 == 206 ? contentLength + i : this.A05;
    }

    private HttpURLConnection A02(int i, int i2) throws C1889Qs, IOException {
        String strA01;
        HttpURLConnection httpURLConnection;
        boolean z;
        int code = 0;
        String headerField = this.A03;
        do {
            StringBuilder sb = new StringBuilder();
            sb.append(A01(234, 16, 102));
            if (i > 0) {
                strA01 = A01(19, 13, 86) + i;
            } else {
                strA01 = A01(0, 0, 78);
            }
            sb.append(strA01);
            sb.append(A01(15, 4, 66));
            sb.append(headerField);
            sb.toString();
            httpURLConnection = (HttpURLConnection) new URL(headerField).openConnection();
            if (i > 0) {
                httpURLConnection.setRequestProperty(A01(250, 5, 60), A01(322, 6, 127) + i + A01(50, 1, 18));
            }
            if (i2 > 0) {
                httpURLConnection.setConnectTimeout(i2);
                httpURLConnection.setReadTimeout(i2);
            }
            int responseCode = httpURLConnection.getResponseCode();
            this.A04 = responseCode;
            String[] strArr = A09;
            if (strArr[1].charAt(4) == strArr[5].charAt(4)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A09;
            strArr2[2] = "PLgwygtF0FJvu0SiSas8utQP577qcxnM";
            strArr2[0] = "YPLv6eSsZkmOoYsRk43xhT";
            z = responseCode == 301 || responseCode == 302 || responseCode == 303;
            if (z) {
                headerField = httpURLConnection.getHeaderField(A01(226, 8, 49));
                code++;
                httpURLConnection.disconnect();
            }
            if (code > 5) {
                throw new C1889Qs(A01(293, 20, 106) + code);
            }
        } while (z);
        return httpURLConnection;
    }

    private void A03() throws C1889Qs {
        String str = A01(255, 23, 28) + this.A03;
        HttpURLConnection httpURLConnectionA02 = null;
        InputStream inputStream = null;
        try {
            try {
                httpURLConnectionA02 = A02(0, 10000);
                this.A05 = httpURLConnectionA02.getContentLength();
                this.A06 = httpURLConnectionA02.getContentType();
                inputStream = httpURLConnectionA02.getInputStream();
                Log.i(A07, A01(74, 18, 104) + this.A03 + A01(313, 9, 58) + this.A06 + A01(32, 18, 100) + this.A05);
                C0I.A06(inputStream);
            } catch (IOException e2) {
                Log.e(A07, A01(129, 25, 77) + this.A03, e2);
                C0I.A06(inputStream);
                if (httpURLConnectionA02 == null) {
                    return;
                }
            }
            httpURLConnectionA02.disconnect();
        } catch (Throwable th) {
            C0I.A06(inputStream);
            if (httpURLConnectionA02 != null) {
                httpURLConnectionA02.disconnect();
            }
            throw th;
        }
    }

    private final void A06(int i, int i2) throws C1889Qs {
        try {
            this.A02 = A02(i, i2);
            this.A06 = this.A02.getContentType();
            this.A01 = new BufferedInputStream(this.A02.getInputStream(), 8192);
            this.A05 = A00(this.A02, i, this.A02.getResponseCode());
        } catch (IOException e2) {
            throw new C1889Qs(A01(154, 29, 63) + this.A03 + A01(19, 13, 86) + i, e2);
        }
    }

    public final int A07() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.C0K
    public final void ABj(int i) throws C1889Qs {
        A06(i, this.A00);
    }

    @Override // com.facebook.ads.redexgen.X.C0K
    public final void close() throws C1889Qs {
        HttpURLConnection httpURLConnection = this.A02;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (NullPointerException e2) {
                throw new C1889Qs(A01(92, 37, 93), e2);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0K
    public final synchronized int length() throws C1889Qs {
        int i;
        int i2 = this.A05;
        if (A09[3].charAt(23) != 'b') {
            String[] strArr = A09;
            strArr[6] = "Gd5nVqL";
            strArr[4] = "KpxMbBcDmaRKResopmSYXqpZ";
            if (i2 == Integer.MIN_VALUE) {
                A03();
            }
            i = this.A05;
        } else {
            throw new RuntimeException();
        }
        String[] strArr2 = A09;
        if (strArr2[6].length() != strArr2[4].length()) {
            String[] strArr3 = A09;
            strArr3[3] = "gS2RFCMrZVvAwZylX045evNEUJ7fs3DK";
            strArr3[3] = "gS2RFCMrZVvAwZylX045evNEUJ7fs3DK";
            return i;
        }
        String[] strArr4 = A09;
        strArr4[6] = "lavKIXl";
        strArr4[4] = "xddCZzh8okNZPw2KOzu6FC9g";
        return i;
    }

    @Override // com.facebook.ads.redexgen.X.C0K
    public final int read(byte[] bArr) throws C1889Qs {
        InputStream inputStream = this.A01;
        String strA01 = A01(183, 24, 104);
        if (inputStream != null) {
            try {
                return inputStream.read(bArr, 0, bArr.length);
            } catch (InterruptedIOException e2) {
                throw new FW(A01(278, 15, 96) + this.A03 + A01(0, 15, 66), e2);
            } catch (IOException e3) {
                throw new C1889Qs(strA01 + this.A03, e3);
            }
        }
        throw new C1889Qs(strA01 + this.A03 + A01(51, 23, 21));
    }

    public final String toString() {
        return A01(207, 19, 41) + this.A03 + A01(328, 1, 87);
    }
}
