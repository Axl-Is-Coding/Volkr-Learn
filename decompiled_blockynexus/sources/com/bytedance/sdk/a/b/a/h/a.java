package com.bytedance.sdk.a.b.a.h;

import com.bytedance.sdk.a.a.j;
import com.bytedance.sdk.a.a.l;
import com.bytedance.sdk.a.b.a.c;
import com.bytedance.sdk.a.b.a.g.e;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PublicSuffixDatabase.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f5182a = {42};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f5183b = new String[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f5184c = {"*"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final a f5185d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f5186e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final CountDownLatch f5187f = new CountDownLatch(1);
    private byte[] g;
    private byte[] h;

    public static a a() {
        return f5185d;
    }

    private void b() {
        boolean z = false;
        while (true) {
            try {
                try {
                    c();
                    break;
                } catch (InterruptedIOException unused) {
                    z = true;
                } catch (IOException e2) {
                    e.b().a(5, "Failed to read public suffix list", e2);
                    if (z) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private void c() throws IOException {
        InputStream resourceAsStream = a.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        com.bytedance.sdk.a.a.e eVarA = l.a(new j(l.a(resourceAsStream)));
        try {
            byte[] bArr = new byte[eVarA.j()];
            eVarA.a(bArr);
            byte[] bArr2 = new byte[eVarA.j()];
            eVarA.a(bArr2);
            synchronized (this) {
                this.g = bArr;
                this.h = bArr2;
            }
            this.f5187f.countDown();
        } finally {
            c.a(eVarA);
        }
    }

    public String a(String str) {
        int length;
        int length2;
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] strArrSplit = IDN.toUnicode(str).split("\\.");
        String[] strArrA = a(strArrSplit);
        if (strArrSplit.length == strArrA.length && strArrA[0].charAt(0) != '!') {
            return null;
        }
        if (strArrA[0].charAt(0) == '!') {
            length = strArrSplit.length;
            length2 = strArrA.length;
        } else {
            length = strArrSplit.length;
            length2 = strArrA.length + 1;
        }
        StringBuilder sb = new StringBuilder();
        String[] strArrSplit2 = str.split("\\.");
        for (int i = length - length2; i < strArrSplit2.length; i++) {
            sb.append(strArrSplit2[i]);
            sb.append('.');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private String[] a(String[] strArr) {
        String strA;
        String strA2;
        String strA3;
        if (!this.f5186e.get() && this.f5186e.compareAndSet(false, true)) {
            b();
        } else {
            try {
                this.f5187f.await();
            } catch (InterruptedException unused) {
            }
        }
        synchronized (this) {
            if (this.g == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        byte[][] bArr = new byte[strArr.length][];
        for (int i = 0; i < strArr.length; i++) {
            bArr[i] = strArr[i].getBytes(c.f4968e);
        }
        int i2 = 0;
        while (true) {
            if (i2 >= bArr.length) {
                strA = null;
                break;
            }
            strA = a(this.g, bArr, i2);
            if (strA != null) {
                break;
            }
            i2++;
        }
        if (bArr.length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i3 = 0; i3 < bArr2.length - 1; i3++) {
                bArr2[i3] = f5182a;
                strA2 = a(this.g, bArr2, i3);
                if (strA2 != null) {
                    break;
                }
            }
            strA2 = null;
        } else {
            strA2 = null;
        }
        if (strA2 != null) {
            for (int i4 = 0; i4 < bArr.length - 1; i4++) {
                strA3 = a(this.h, bArr, i4);
                if (strA3 != null) {
                    break;
                }
            }
            strA3 = null;
        } else {
            strA3 = null;
        }
        if (strA3 != null) {
            return ("!" + strA3).split("\\.");
        }
        if (strA == null && strA2 == null) {
            return f5184c;
        }
        String[] strArrSplit = strA != null ? strA.split("\\.") : f5183b;
        String[] strArrSplit2 = strA2 != null ? strA2.split("\\.") : f5183b;
        return strArrSplit.length > strArrSplit2.length ? strArrSplit : strArrSplit2;
    }

    private static String a(byte[] bArr, byte[][] bArr2, int i) {
        int i2;
        int i3;
        int i4;
        int length = bArr.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = (i5 + length) / 2;
            while (i6 > -1 && bArr[i6] != 10) {
                i6--;
            }
            int i7 = i6 + 1;
            int i8 = 1;
            while (true) {
                i2 = i7 + i8;
                if (bArr[i2] == 10) {
                    break;
                }
                i8++;
            }
            int i9 = i2 - i7;
            int i10 = i;
            boolean z = false;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (z) {
                    z = false;
                    i3 = 46;
                } else {
                    i3 = bArr2[i10][i11] & 255;
                }
                i4 = i3 - (bArr[i7 + i12] & 255);
                if (i4 == 0) {
                    i12++;
                    i11++;
                    if (i12 == i9) {
                        break;
                    }
                    if (bArr2[i10].length == i11) {
                        if (i10 == bArr2.length - 1) {
                            break;
                        }
                        i10++;
                        z = true;
                        i11 = -1;
                    }
                } else {
                    break;
                }
            }
            if (i4 >= 0) {
                if (i4 <= 0) {
                    int i13 = i9 - i12;
                    int length2 = bArr2[i10].length - i11;
                    while (true) {
                        i10++;
                        if (i10 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i10].length;
                    }
                    if (length2 >= i13) {
                        if (length2 <= i13) {
                            return new String(bArr, i7, i9, c.f4968e);
                        }
                    }
                }
                i5 = i2 + 1;
            }
            length = i7 - 1;
        }
        return null;
    }
}
