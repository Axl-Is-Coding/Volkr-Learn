package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import com.just.agentweb.WebIndicator;
import com.umeng.analytics.pro.ci;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2Y, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2Y extends AbstractC14779t {
    public final int A00;
    public final int A01;
    public final HX<? super HC> A02;
    public final String A03;
    public final boolean A04;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.HX != com.facebook.ads.internal.exoplayer2.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.upstream.DataSource> */
    public C2Y(String str, HX<? super HC> hx) {
        this(str, hx, WebIndicator.MAX_UNIFORM_SPEED_DURATION, WebIndicator.MAX_UNIFORM_SPEED_DURATION, false);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.HX != com.facebook.ads.internal.exoplayer2.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.upstream.DataSource> */
    public C2Y(String str, HX<? super HC> hx, int i, int i2, boolean z) {
        this.A03 = str;
        this.A02 = hx;
        this.A00 = i;
        this.A01 = i2;
        this.A04 = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.ads.redexgen.X.9v] */
    @Override // com.facebook.ads.redexgen.X.AbstractC14779t
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final C14799v A01(final HM hm) {
        final String str = this.A03;
        final HX<? super HC> hx = this.A02;
        final int i = this.A00;
        final int i2 = this.A01;
        final boolean z = this.A04;
        final II ii = null;
        return new InterfaceC2164ae(str, ii, hx, i, i2, z, hm) { // from class: com.facebook.ads.redexgen.X.9v
            public static byte[] A0G;
            public static String[] A0H;
            public static final AtomicReference<byte[]> A0I;
            public static final Pattern A0J;
            public long A00;
            public long A01;
            public long A02;
            public long A03;
            public HG A04;
            public InputStream A05;
            public HttpURLConnection A06;
            public boolean A07;
            public final int A08;
            public final int A09;
            public final HM A0A;
            public final HM A0B = new HM();
            public final HX<? super C14799v> A0C;
            public final II<String> A0D;
            public final String A0E;
            public final boolean A0F;

            public static String A03(int i3, int i4, int i5) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(A0G, i3, i3 + i4);
                for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
                    int i7 = bArrCopyOfRange[i6] ^ i5;
                    String[] strArr = A0H;
                    if (strArr[0].length() == strArr[1].length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A0H;
                    strArr2[0] = "a9yJ7ENBXfuIUHaNhs8YhzHERJT";
                    strArr2[1] = "38v";
                    bArrCopyOfRange[i6] = (byte) (i7 ^ 114);
                }
                return new String(bArrCopyOfRange);
            }

            public static void A09() {
                A0G = new byte[]{31, 92, 126, 126, 120, 109, 105, 48, 88, 115, 126, 114, 121, 116, 115, 122, 8, 36, 37, Utf8.REPLACEMENT_BYTE, 46, 37, Utf8.REPLACEMENT_BYTE, 102, 7, 46, 37, 44, Utf8.REPLACEMENT_BYTE, 35, 84, 120, 121, 99, 114, 121, 99, 58, 69, 118, 121, 112, 114, 22, 55, 52, 51, 39, 62, 38, 26, 38, 38, 34, 22, 51, 38, 51, 1, 61, 39, 32, 49, 55, 82, 117, 120, 116, 117, 104, 114, 104, 111, 126, 117, 111, 59, 115, 126, 122, 127, 126, 105, 104, 59, 64, 48, 19, 31, 29, 8, 21, 19, 18, 38, 29, 4, 4, 72, 4, 7, 11, 9, 28, 1, 7, 6, 72, 26, ci.k, 12, 1, 26, ci.k, 11, 28, 54, 41, 53, 50, 109, 94, 81, 88, 90, 7, 60, 60, 115, 62, 50, 61, 42, 115, 33, 54, 55, 58, 33, 54, 48, 39, 32, 105, 115, 6, 61, 50, 49, Utf8.REPLACEMENT_BYTE, 54, 115, 39, 60, 115, 48, 60, 61, 61, 54, 48, 39, 115, 39, 60, 115, 45, 22, 29, 0, 8, 29, 27, 12, 29, 28, 88, 59, 23, 22, 12, 29, 22, 12, 85, 52, 29, 22, 31, 12, ci.n, 88, 35, 127, 68, 79, 82, 90, 79, 73, 94, 79, 78, 10, 105, 69, 68, 94, 79, 68, 94, 7, 120, 75, 68, 77, 79, 10, 113, 59, 0, 11, 22, 30, 11, ci.k, 26, 11, 10, 78, 11, 28, 28, 1, 28, 78, 25, 6, 7, 2, 11, 78, 10, 7, 29, ci.k, 1, 0, 0, 11, ci.k, 26, 7, 0, 9, 59, 0, 29, 27, 30, 30, 1, 28, 26, 11, 10, 78, 30, 28, 1, 26, 1, ci.k, 1, 2, 78, 28, 11, 10, 7, 28, 11, ci.k, 26, 84, 78, 23, 49, 39, 48, 111, 3, 37, 39, 44, 54, 122, 2, 127, 4, 49, ci.k, 22, 27, 10, 28, 79, 71, 51, 11, 68, 70, 66, 71, 51, 11, 68, 70, 64, 71, 51, 11, 68, 70, 75, 11, ci.n, 29, 12, 26, 84, 115, 127, 125, 62, 113, 126, 116, 98, 127, 121, 116, 62, 127, 123, 120, 100, 100, 96, 62, 121, 126, 100, 117, 98, 126, 113, 124, 62, 120, 100, 100, 96, 62, 88, 100, 100, 96, 68, 98, 113, 126, 99, 96, 127, 98, 100, 52, 83, 120, 101, 126, 123, 117, 116, 89, 126, 96, 101, 100, 67, 100, 98, 117, 113, 125, 41, 37, 39, 100, 43, 36, 46, 56, 37, 35, 46, 100, 37, 33, 34, 62, 62, 58, 100, 35, 36, 62, 47, 56, 36, 43, 38, 100, 34, 62, 62, 58, 100, 2, 62, 62, 58, 30, 56, 43, 36, 57, 58, 37, 56, 62, 110, 12, 35, 50, 47, 46, 6, 47, 36, 45, 62, 34, 3, 36, 58, Utf8.REPLACEMENT_BYTE, 62, 25, 62, 56, 47, 43, 39, 55, 43, 43, 47, 11, 23, 23, 19, ci.n, 2, ci.m, ci.l, 5, 31, 2, 31, 18, 126, 101, 110, 115, 123, 110, 104, 127, 110, 111, 78, 101, 111, 68, 109, 66, 101, 123, 126, 127};
            }

            public static void A0A() {
                A0H = new String[]{"8Cwpq0myFqrjMYQXCF426Bvv7lF", "BCZ", "9QEkehaQ45REYiwwIXw9otHnKiruCzQN", "DxeLZUhsDe6Etn8eMTd", "i0KDABCUI1wPuXC", "cHzp87p", "Z4Mhgoj", "Wxs5ICSBRzcNleT3VwYrHD2lep8WMSnM"};
            }

            static {
                A0A();
                A09();
                A0J = Pattern.compile(A03(300, 25, 29));
                A0I = new AtomicReference<>();
            }

            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.HX != com.facebook.ads.internal.exoplayer2.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.upstream.DefaultHttpDataSource> */
            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.II != com.facebook.ads.internal.exoplayer2.util.Predicate<java.lang.String> */
            {
                this.A0E = C1662Hr.A02(str);
                this.A0D = ii;
                this.A0C = hx;
                this.A08 = i;
                this.A09 = i2;
                this.A0F = z;
                this.A0A = hm;
            }

            private int A00(byte[] bArr, int i3, int i4) throws IOException {
                if (i4 == 0) {
                    return 0;
                }
                long j = this.A02;
                String[] strArr = A0H;
                if (strArr[0].length() == strArr[1].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0H;
                strArr2[0] = "bWPLRd721NhcJPFUmTbRIXPAhQ9";
                strArr2[1] = "JEA";
                if (j != -1) {
                    long j2 = j - this.A00;
                    if (j2 == 0) {
                        return -1;
                    }
                    i4 = (int) Math.min(i4, j2);
                }
                int i5 = this.A05.read(bArr, i3, i4);
                String[] strArr3 = A0H;
                if (strArr3[6].length() != strArr3[5].length()) {
                    throw new RuntimeException();
                }
                String[] strArr4 = A0H;
                strArr4[0] = "AfChosDvH2k0xVUSu60NEuB2wOO";
                strArr4[1] = "7R7";
                if (i5 == -1) {
                    if (this.A02 == -1) {
                        return -1;
                    }
                    throw new EOFException();
                }
                this.A00 += (long) i5;
                HX<? super C14799v> hx2 = this.A0C;
                if (hx2 != null) {
                    hx2.A9N(this, i5);
                }
                return i5;
            }

            private final long A01() {
                long j = this.A02;
                return j == -1 ? j : j - this.A00;
            }

            public static long A02(HttpURLConnection httpURLConnection) {
                long jMax = -1;
                String headerField = httpURLConnection.getHeaderField(A03(16, 14, 57));
                boolean zIsEmpty = TextUtils.isEmpty(headerField);
                String strA03 = A03(296, 1, 85);
                String strA032 = A03(43, 21, 32);
                if (!zIsEmpty) {
                    try {
                        jMax = Long.parseLong(headerField);
                    } catch (NumberFormatException unused) {
                        Log.e(strA032, A03(166, 27, 10) + headerField + strA03);
                    }
                }
                String headerField2 = httpURLConnection.getHeaderField(A03(30, 13, 101));
                if (!TextUtils.isEmpty(headerField2)) {
                    Matcher matcher = A0J.matcher(headerField2);
                    if (matcher.find()) {
                        try {
                            long j = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                            if (jMax < 0) {
                                return j;
                            }
                            if (jMax != j) {
                                Log.w(strA032, A03(64, 22, 105) + headerField + A03(297, 3, 45) + headerField2 + strA03);
                                jMax = Math.max(jMax, j);
                                return jMax;
                            }
                            return jMax;
                        } catch (NumberFormatException unused2) {
                            Log.e(strA032, A03(193, 26, 88) + headerField2 + strA03);
                            return jMax;
                        }
                    }
                    return jMax;
                }
                return jMax;
            }

            private HttpURLConnection A04(HG hg) throws IOException {
                HttpURLConnection httpURLConnectionA05;
                URL url = new URL(hg.A04.toString());
                byte[] bArr = hg.A06;
                long j = hg.A03;
                long j2 = hg.A02;
                boolean zA02 = hg.A02(1);
                if (!this.A0F) {
                    if (A0H[4].length() == 2) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A0H;
                    strArr[3] = "AfmLjTAqEjfBoFvfwAy";
                    strArr[3] = "AfmLjTAqEjfBoFvfwAy";
                    return A05(url, bArr, j, j2, zA02, true);
                }
                int redirectCount = 0;
                while (true) {
                    int i3 = redirectCount + 1;
                    if (redirectCount <= 20) {
                        httpURLConnectionA05 = A05(url, bArr, j, j2, zA02, false);
                        int responseCode = httpURLConnectionA05.getResponseCode();
                        if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && (bArr != null || (responseCode != 307 && responseCode != 308))) {
                            break;
                        }
                        bArr = null;
                        String headerField = httpURLConnectionA05.getHeaderField(A03(86, 8, 14));
                        httpURLConnectionA05.disconnect();
                        url = A06(url, headerField);
                        redirectCount = i3;
                    } else {
                        throw new NoRouteToHostException(A03(125, 20, 33) + i3);
                    }
                }
                return httpURLConnectionA05;
            }

            private HttpURLConnection A05(URL url, byte[] bArr, long j, long j2, boolean z2, boolean z3) throws IOException {
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(this.A08);
                httpURLConnection.setReadTimeout(this.A09);
                HM hm2 = this.A0A;
                if (hm2 != null) {
                    for (Map.Entry<String, String> entry : hm2.A00().entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                for (Map.Entry<String, String> entry2 : this.A0B.A00().entrySet()) {
                    httpURLConnection.setRequestProperty(entry2.getKey(), entry2.getValue());
                }
                if (j != 0 || j2 != -1) {
                    String str2 = A03(325, 6, 27) + j + A03(0, 1, 64);
                    if (j2 != -1) {
                        str2 = str2 + ((j + j2) - 1);
                    }
                    httpURLConnection.setRequestProperty(A03(120, 5, 77), str2);
                }
                httpURLConnection.setRequestProperty(A03(286, 10, 48), this.A0E);
                if (!z2) {
                    httpURLConnection.setRequestProperty(A03(1, 15, 111), A03(474, 8, 25));
                }
                httpURLConnection.setInstanceFollowRedirects(z3);
                httpURLConnection.setDoOutput(bArr != null);
                if (A0H[2].charAt(11) != 'E') {
                    throw new RuntimeException();
                }
                String[] strArr = A0H;
                strArr[7] = "Y4214PJ0d833V29vzm0V8RPiGXomA3ZU";
                strArr[7] = "Y4214PJ0d833V29vzm0V8RPiGXomA3ZU";
                if (bArr != null) {
                    httpURLConnection.setRequestMethod(A03(116, 4, 20));
                    if (bArr.length == 0) {
                        httpURLConnection.connect();
                    } else {
                        httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                        httpURLConnection.connect();
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        outputStream.write(bArr);
                        outputStream.close();
                    }
                } else {
                    httpURLConnection.connect();
                }
                return httpURLConnection;
            }

            public static URL A06(URL url, String str2) throws IOException {
                if (str2 != null) {
                    URL url2 = new URL(url, str2);
                    String protocol = url2.getProtocol();
                    if (A03(469, 5, 17).equals(protocol) || A03(465, 4, 45).equals(protocol)) {
                        return url2;
                    }
                    throw new ProtocolException(A03(255, 31, 28) + protocol);
                }
                throw new ProtocolException(A03(94, 22, 26));
            }

            private void A07() {
                HttpURLConnection httpURLConnection = this.A06;
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception e2) {
                        Log.e(A03(43, 21, 32), A03(219, 36, 28), e2);
                    }
                    this.A06 = null;
                }
            }

            private void A08() throws IOException {
                if (this.A01 == this.A03) {
                    return;
                }
                byte[] andSet = A0I.getAndSet(null);
                if (andSet == null) {
                    andSet = new byte[4096];
                }
                while (true) {
                    long j = this.A01;
                    long j2 = this.A03;
                    if (j != j2) {
                        int readLength = (int) Math.min(j2 - j, andSet.length);
                        int i3 = this.A05.read(andSet, 0, readLength);
                        if (Thread.currentThread().isInterrupted()) {
                            throw new InterruptedIOException();
                        }
                        String[] strArr = A0H;
                        if (strArr[0].length() == strArr[1].length()) {
                            throw new RuntimeException();
                        }
                        String[] strArr2 = A0H;
                        strArr2[2] = "xCxIxiNgjMSECsgVhCWdWfEPU1XUNw0H";
                        strArr2[2] = "xCxIxiNgjMSECsgVhCWdWfEPU1XUNw0H";
                        if (i3 != -1) {
                            this.A01 += (long) i3;
                            HX<? super C14799v> hx2 = this.A0C;
                            if (hx2 != null) {
                                hx2.A9N(this, i3);
                            }
                        } else {
                            throw new EOFException();
                        }
                    } else {
                        A0I.set(andSet);
                        return;
                    }
                }
            }

            public static void A0B(HttpURLConnection httpURLConnection, long j) {
                if (IW.A02 != 19 && IW.A02 != 20) {
                    return;
                }
                try {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (j == -1) {
                        if (inputStream.read() == -1) {
                            return;
                        }
                    } else {
                        if (A0H[4].length() == 2) {
                            throw new RuntimeException();
                        }
                        String[] strArr = A0H;
                        strArr[7] = "fvAwzL9wombuya3LmhGM8hGg4ouN1XgQ";
                        strArr[7] = "fvAwzL9wombuya3LmhGM8hGg4ouN1XgQ";
                        if (j <= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH) {
                            return;
                        }
                    }
                    String name = inputStream.getClass().getName();
                    if (A03(331, 65, 98).equals(name) || A03(396, 69, 56).equals(name)) {
                        Method unexpectedEndOfInput = inputStream.getClass().getSuperclass().getDeclaredMethod(A03(482, 20, 121), new Class[0]);
                        unexpectedEndOfInput.setAccessible(true);
                        unexpectedEndOfInput.invoke(inputStream, new Object[0]);
                    }
                } catch (Exception unused) {
                }
            }

            @Override // com.facebook.ads.redexgen.X.HC
            public final Uri A7J() {
                HttpURLConnection httpURLConnection = this.A06;
                if (httpURLConnection == null) {
                    return null;
                }
                return Uri.parse(httpURLConnection.getURL().toString());
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00ac  */
            /* JADX WARN: Removed duplicated region for block: B:34:0x00b8 A[PHI: r2
              0x00b8: PHI (r2v6 long) = (r2v5 long), (r2v10 long) binds: [B:32:0x00b5, B:29:0x00aa] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r7v2 */
            @Override // com.facebook.ads.redexgen.X.HC
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final long ABi(com.facebook.ads.redexgen.X.HG r11) throws com.facebook.ads.redexgen.X.HL {
                /*
                    Method dump skipped, instruction units count: 303
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C14799v.ABi(com.facebook.ads.redexgen.X.HG):long");
            }

            @Override // com.facebook.ads.redexgen.X.HC
            public final void close() throws HL {
                try {
                    if (this.A05 != null) {
                        A0B(this.A06, A01());
                        try {
                            this.A05.close();
                        } catch (IOException e2) {
                            throw new HL(e2, this.A04, 3);
                        }
                    }
                    this.A05 = null;
                    if (A0H[3].length() != 19) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A0H;
                    strArr[0] = "hQ3mc1CdxqPeh2AA8lkYs0MW7MP";
                    strArr[1] = "PCj";
                    A07();
                    if (this.A07) {
                        this.A07 = false;
                        HX<? super C14799v> hx2 = this.A0C;
                        if (hx2 != null) {
                            hx2.ABS(this);
                        }
                    }
                } catch (Throwable th) {
                    this.A05 = null;
                    A07();
                    if (this.A07) {
                        this.A07 = false;
                        HX<? super C14799v> hx3 = this.A0C;
                        if (hx3 != null) {
                            hx3.ABS(this);
                        }
                    }
                    throw th;
                }
            }

            @Override // com.facebook.ads.redexgen.X.HC
            public final int read(byte[] bArr, int i3, int i4) throws HL {
                try {
                    A08();
                    return A00(bArr, i3, i4);
                } catch (IOException e2) {
                    throw new HL(e2, this.A04, 2);
                }
            }
        };
    }
}
