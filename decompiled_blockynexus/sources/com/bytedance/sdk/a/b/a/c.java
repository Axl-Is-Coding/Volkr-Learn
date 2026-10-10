package com.bytedance.sdk.a.b.a;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.sdk.a.a.f;
import com.bytedance.sdk.a.a.s;
import com.bytedance.sdk.a.b.ab;
import com.bytedance.sdk.a.b.z;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: Util.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f4964a = new byte[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f4965b = new String[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ab f4966c = ab.a(null, f4964a);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final z f4967d = z.a(null, f4964a);
    private static final f i = f.b("efbbbf");
    private static final f j = f.b("feff");
    private static final f k = f.b("fffe");
    private static final f l = f.b("0000ffff");
    private static final f m = f.b("ffff0000");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Charset f4968e = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Charset f4969f = Charset.forName("ISO-8859-1");
    private static final Charset n = Charset.forName("UTF-16BE");
    private static final Charset o = Charset.forName("UTF-16LE");
    private static final Charset p = Charset.forName("UTF-32BE");
    private static final Charset q = Charset.forName("UTF-32LE");
    public static final TimeZone g = TimeZone.getTimeZone("GMT");
    public static final Comparator<String> h = new Comparator<String>() { // from class: com.bytedance.sdk.a.b.a.c.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    };
    private static final Pattern r = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    public static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    public static void a(long j2, long j3, long j4) {
        if ((j3 | j4) < 0 || j3 > j2 || j2 - j3 < j4) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static boolean b(s sVar, int i2, TimeUnit timeUnit) throws IOException {
        long jNanoTime = System.nanoTime();
        long jC_ = sVar.a().c() ? sVar.a().c_() - jNanoTime : Long.MAX_VALUE;
        sVar.a().a(Math.min(jC_, timeUnit.toNanos(i2)) + jNanoTime);
        try {
            com.bytedance.sdk.a.a.c cVar = new com.bytedance.sdk.a.a.c();
            while (sVar.a(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                cVar.r();
            }
            if (jC_ == Long.MAX_VALUE) {
                sVar.a().f();
            } else {
                sVar.a().a(jNanoTime + jC_);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (jC_ == Long.MAX_VALUE) {
                sVar.a().f();
            } else {
                sVar.a().a(jNanoTime + jC_);
            }
            return false;
        } catch (Throwable th) {
            if (jC_ == Long.MAX_VALUE) {
                sVar.a().f();
            } else {
                sVar.a().a(jNanoTime + jC_);
            }
            throw th;
        }
    }

    public static String c(String str, int i2, int i3) {
        int iA = a(str, i2, i3);
        return str.substring(iA, b(str, iA, i3));
    }

    private static boolean d(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt <= 31 || cCharAt >= 127 || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean c(String str) {
        return r.matcher(str).matches();
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x007d, code lost:
    
        if (r3 == r0.length) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x007f, code lost:
    
        if (r4 != (-1)) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0081, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0082, code lost:
    
        r11 = r3 - r4;
        java.lang.System.arraycopy(r0, r4, r0, r0.length - r11, r11);
        java.util.Arrays.fill(r0, r4, (r0.length - r3) + r4, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0093, code lost:
    
        return java.net.InetAddress.getByAddress(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x009a, code lost:
    
        throw new java.lang.AssertionError();
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.net.InetAddress d(java.lang.String r10, int r11, int r12) {
        /*
            r0 = 16
            byte[] r0 = new byte[r0]
            r1 = -1
            r2 = 0
            r3 = 0
            r4 = -1
            r5 = -1
        L9:
            r6 = 0
            if (r11 >= r12) goto L7c
            int r7 = r0.length
            if (r3 != r7) goto L10
            return r6
        L10:
            int r7 = r11 + 2
            if (r7 > r12) goto L29
            r8 = 2
            java.lang.String r9 = "::"
            boolean r8 = r10.regionMatches(r11, r9, r2, r8)
            if (r8 == 0) goto L29
            if (r4 == r1) goto L20
            return r6
        L20:
            int r3 = r3 + 2
            if (r7 != r12) goto L26
            r4 = r3
            goto L7c
        L26:
            r4 = r3
            r5 = r7
            goto L4d
        L29:
            if (r3 == 0) goto L4c
            r7 = 1
            java.lang.String r8 = ":"
            boolean r8 = r10.regionMatches(r11, r8, r2, r7)
            if (r8 == 0) goto L37
            int r11 = r11 + 1
            goto L4c
        L37:
            java.lang.String r8 = "."
            boolean r11 = r10.regionMatches(r11, r8, r2, r7)
            if (r11 == 0) goto L4b
            int r11 = r3 + (-2)
            boolean r10 = a(r10, r5, r12, r0, r11)
            if (r10 != 0) goto L48
            return r6
        L48:
            int r3 = r3 + 2
            goto L7c
        L4b:
            return r6
        L4c:
            r5 = r11
        L4d:
            r11 = r5
            r7 = 0
        L4f:
            if (r11 >= r12) goto L62
            char r8 = r10.charAt(r11)
            int r8 = a(r8)
            if (r8 != r1) goto L5c
            goto L62
        L5c:
            int r7 = r7 << 4
            int r7 = r7 + r8
            int r11 = r11 + 1
            goto L4f
        L62:
            int r8 = r11 - r5
            if (r8 == 0) goto L7b
            r9 = 4
            if (r8 <= r9) goto L6a
            goto L7b
        L6a:
            int r6 = r3 + 1
            int r8 = r7 >>> 8
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte r8 = (byte) r8
            r0[r3] = r8
            int r3 = r6 + 1
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r7 = (byte) r7
            r0[r6] = r7
            goto L9
        L7b:
            return r6
        L7c:
            int r10 = r0.length
            if (r3 == r10) goto L8f
            if (r4 != r1) goto L82
            return r6
        L82:
            int r10 = r0.length
            int r11 = r3 - r4
            int r10 = r10 - r11
            java.lang.System.arraycopy(r0, r4, r0, r10, r11)
            int r10 = r0.length
            int r10 = r10 - r3
            int r10 = r10 + r4
            java.util.Arrays.fill(r0, r4, r10, r2)
        L8f:
            java.net.InetAddress r10 = java.net.InetAddress.getByAddress(r0)     // Catch: java.net.UnknownHostException -> L94
            return r10
        L94:
            java.lang.AssertionError r10 = new java.lang.AssertionError
            r10.<init>()
            goto L9b
        L9a:
            throw r10
        L9b:
            goto L9a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.a.b.a.c.d(java.lang.String, int, int):java.net.InetAddress");
    }

    public static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e2) {
                if (!a(e2)) {
                    throw e2;
                }
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(s sVar, int i2, TimeUnit timeUnit) {
        try {
            return b(sVar, i2, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static <T> List<T> a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static ThreadFactory a(final String str, final boolean z) {
        return new ThreadFactory() { // from class: com.bytedance.sdk.a.b.a.c.2
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(z);
                return thread;
            }
        };
    }

    public static String[] a(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i2]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i2++;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean b(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static String a(com.bytedance.sdk.a.b.s sVar, boolean z) {
        String strF;
        if (sVar.f().contains(":")) {
            strF = "[" + sVar.f() + "]";
        } else {
            strF = sVar.f();
        }
        if (!z && sVar.g() == com.bytedance.sdk.a.b.s.a(sVar.b())) {
            return strF;
        }
        return strF + ":" + sVar.g();
    }

    public static int b(String str, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            char cCharAt = str.charAt(i4);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i4 + 1;
            }
        }
        return i2;
    }

    public static int b(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt <= 31 || cCharAt >= 127) {
                return i2;
            }
        }
        return -1;
    }

    public static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static int a(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (comparator.compare(strArr[i2], str) == 0) {
                return i2;
            }
        }
        return -1;
    }

    public static String[] a(String[] strArr, String str) {
        String[] strArr2 = new String[strArr.length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[strArr2.length - 1] = str;
        return strArr2;
    }

    public static int a(String str, int i2, int i3) {
        while (i2 < i3) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int a(String str, int i2, int i3, String str2) {
        while (i2 < i3) {
            if (str2.indexOf(str.charAt(i2)) != -1) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int a(String str, int i2, int i3, char c2) {
        while (i2 < i3) {
            if (str.charAt(i2) == c2) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static String a(String str) {
        InetAddress inetAddressD;
        if (str.contains(":")) {
            if (str.startsWith("[") && str.endsWith("]")) {
                inetAddressD = d(str, 1, str.length() - 1);
            } else {
                inetAddressD = d(str, 0, str.length());
            }
            if (inetAddressD == null) {
                return null;
            }
            byte[] address = inetAddressD.getAddress();
            if (address.length == 16) {
                return a(address);
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + "'");
        }
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (lowerCase.isEmpty()) {
                return null;
            }
            if (d(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static int a(String str, long j2, TimeUnit timeUnit) {
        if (j2 < 0) {
            throw new IllegalArgumentException(str + " < 0");
        }
        if (timeUnit != null) {
            long millis = timeUnit.toMillis(j2);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(str + " too large.");
            }
            if (millis != 0 || j2 <= 0) {
                return (int) millis;
            }
            throw new IllegalArgumentException(str + " too small.");
        }
        throw new NullPointerException("unit == null");
    }

    public static AssertionError a(String str, Exception exc) {
        return (AssertionError) new AssertionError(str).initCause(exc);
    }

    private static boolean a(String str, int i2, int i3, byte[] bArr, int i4) {
        int i5 = i4;
        while (i2 < i3) {
            if (i5 == bArr.length) {
                return false;
            }
            if (i5 != i4) {
                if (str.charAt(i2) != '.') {
                    return false;
                }
                i2++;
            }
            int i6 = i2;
            int i7 = 0;
            while (i6 < i3) {
                char cCharAt = str.charAt(i6);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                if ((i7 == 0 && i2 != i6) || (i7 = ((i7 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i6++;
            }
            if (i6 - i2 == 0) {
                return false;
            }
            bArr[i5] = (byte) i7;
            i5++;
            i2 = i6;
        }
        return i5 == i4 + 4;
    }

    private static String a(byte[] bArr) {
        int i2 = 0;
        int i3 = 0;
        int i4 = -1;
        int i5 = 0;
        while (i3 < bArr.length) {
            int i6 = i3;
            while (i6 < 16 && bArr[i6] == 0 && bArr[i6 + 1] == 0) {
                i6 += 2;
            }
            int i7 = i6 - i3;
            if (i7 > i5 && i7 >= 4) {
                i4 = i3;
                i5 = i7;
            }
            i3 = i6 + 2;
        }
        com.bytedance.sdk.a.a.c cVar = new com.bytedance.sdk.a.a.c();
        while (i2 < bArr.length) {
            if (i2 == i4) {
                cVar.i(58);
                i2 += i5;
                if (i2 == 16) {
                    cVar.i(58);
                }
            } else {
                if (i2 > 0) {
                    cVar.i(58);
                }
                cVar.k(((bArr[i2] & 255) << 8) | (bArr[i2 + 1] & 255));
                i2 += 2;
            }
        }
        return cVar.o();
    }
}
