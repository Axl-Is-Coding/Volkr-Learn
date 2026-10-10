package com.bytedance.sdk.a.a;

import com.umeng.analytics.pro.ci;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* JADX INFO: compiled from: ByteString.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements Serializable, Comparable<f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final char[] f4854a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f4855b = a(new byte[0]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final byte[] f4856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    transient int f4857d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    transient String f4858e;

    f(byte[] bArr) {
        this.f4856c = bArr;
    }

    public static f a(byte... bArr) {
        if (bArr != null) {
            return new f((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public String b() {
        return b.a(this.f4856c);
    }

    public f c() {
        return c("SHA-1");
    }

    public f d() {
        return c("SHA-256");
    }

    public String e() {
        byte[] bArr = this.f4856c;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            char[] cArr2 = f4854a;
            cArr[i] = cArr2[(b2 >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b2 & ci.m];
        }
        return new String(cArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            int iG = fVar.g();
            byte[] bArr = this.f4856c;
            if (iG == bArr.length && fVar.a(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public f f() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f4856c;
            if (i >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i];
            if (b2 >= 65 && b2 <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b2 + 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b3 = bArr2[i2];
                    if (b3 >= 65 && b3 <= 90) {
                        bArr2[i2] = (byte) (b3 + 32);
                    }
                }
                return new f(bArr2);
            }
            i++;
        }
    }

    public int g() {
        return this.f4856c.length;
    }

    public byte[] h() {
        return (byte[]) this.f4856c.clone();
    }

    public int hashCode() {
        int i = this.f4857d;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.f4856c);
        this.f4857d = iHashCode;
        return iHashCode;
    }

    public String toString() {
        StringBuilder sb;
        if (this.f4856c.length == 0) {
            return "[size=0]";
        }
        String strA = a();
        int iA = a(strA, 64);
        if (iA == -1) {
            if (this.f4856c.length <= 64) {
                return "[hex=" + e() + "]";
            }
            return "[size=" + this.f4856c.length + " hex=" + a(0, 64).e() + "…]";
        }
        String strReplace = strA.substring(0, iA).replace("\\", "\\\\").replace(UMCustomLogInfoBuilder.LINE_SEP, "\\n").replace("\r", "\\r");
        if (iA < strA.length()) {
            sb = new StringBuilder();
            sb.append("[size=");
            sb.append(this.f4856c.length);
            sb.append(" text=");
            sb.append(strReplace);
            sb.append("…]");
        } else {
            sb = new StringBuilder();
            sb.append("[text=");
            sb.append(strReplace);
            sb.append("]");
        }
        return sb.toString();
    }

    public static f b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        }
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
        byte[] bArr = new byte[str.length() / 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((a(str.charAt(i2)) << 4) + a(str.charAt(i2 + 1)));
        }
        return a(bArr);
    }

    private f c(String str) {
        try {
            return a(MessageDigest.getInstance(str).digest(this.f4856c));
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public static f a(String str) {
        if (str != null) {
            f fVar = new f(str.getBytes(u.f4897a));
            fVar.f4858e = str;
            return fVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    public String a() {
        String str = this.f4858e;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f4856c, u.f4897a);
        this.f4858e = str2;
        return str2;
    }

    private static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                throw new IllegalArgumentException("Unexpected hex digit: " + c2);
            }
        }
        return (c2 - c3) + 10;
    }

    public f a(int i, int i2) {
        if (i >= 0) {
            byte[] bArr = this.f4856c;
            if (i2 > bArr.length) {
                throw new IllegalArgumentException("endIndex > length(" + this.f4856c.length + ")");
            }
            int i3 = i2 - i;
            if (i3 >= 0) {
                if (i == 0 && i2 == bArr.length) {
                    return this;
                }
                byte[] bArr2 = new byte[i3];
                System.arraycopy(this.f4856c, i, bArr2, 0, i3);
                return new f(bArr2);
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(f fVar) {
        int iG = g();
        int iG2 = fVar.g();
        int iMin = Math.min(iG, iG2);
        for (int i = 0; i < iMin; i++) {
            int iA = a(i) & 255;
            int iA2 = fVar.a(i) & 255;
            if (iA != iA2) {
                return iA < iA2 ? -1 : 1;
            }
        }
        if (iG == iG2) {
            return 0;
        }
        return iG < iG2 ? -1 : 1;
    }

    public byte a(int i) {
        return this.f4856c[i];
    }

    void a(c cVar) {
        byte[] bArr = this.f4856c;
        cVar.c(bArr, 0, bArr.length);
    }

    public boolean a(int i, f fVar, int i2, int i3) {
        return fVar.a(i2, this.f4856c, i, i3);
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0) {
            byte[] bArr2 = this.f4856c;
            if (i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && u.a(bArr2, i, bArr, i2, i3)) {
                return true;
            }
        }
        return false;
    }

    public final boolean a(f fVar) {
        return a(0, fVar, 0, fVar.g());
    }

    static int a(String str, int i) {
        int length = str.length();
        int iCharCount = 0;
        int i2 = 0;
        while (iCharCount < length) {
            if (i2 == i) {
                return iCharCount;
            }
            int iCodePointAt = str.codePointAt(iCharCount);
            if ((Character.isISOControl(iCodePointAt) && iCodePointAt != 10 && iCodePointAt != 13) || iCodePointAt == 65533) {
                return -1;
            }
            i2++;
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.length();
    }
}
