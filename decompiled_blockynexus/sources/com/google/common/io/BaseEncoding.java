package com.google.common.io;

import com.google.common.base.m;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseEncoding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final BaseEncoding f13969a = new c("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final BaseEncoding f13970b = new c("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final BaseEncoding f13971c = new d("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final BaseEncoding f13972d = new d("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final BaseEncoding f13973e = new b("base16()", "0123456789ABCDEF");

    public static final class DecodingException extends IOException {
        DecodingException(String str) {
            super(str);
        }

        DecodingException(Throwable th) {
            super(th);
        }
    }

    private static final class a extends com.google.common.base.c {
        private final String o;
        private final char[] p;
        final int q;
        final int r;
        final int s;
        final int t;
        private final byte[] u;
        private final boolean[] v;

        a(String str, char[] cArr) {
            m.a(str);
            this.o = str;
            m.a(cArr);
            this.p = cArr;
            try {
                this.r = b.c.b.a.b.a(cArr.length, RoundingMode.UNNECESSARY);
                int iMin = Math.min(8, Integer.lowestOneBit(this.r));
                this.s = 8 / iMin;
                this.t = this.r / iMin;
                this.q = cArr.length - 1;
                byte[] bArr = new byte[128];
                Arrays.fill(bArr, (byte) -1);
                for (int i = 0; i < cArr.length; i++) {
                    char c2 = cArr[i];
                    m.a(com.google.common.base.c.f13735c.c(c2), "Non-ASCII character: %s", Character.valueOf(c2));
                    m.a(bArr[c2] == -1, "Duplicate character: %s", Character.valueOf(c2));
                    bArr[c2] = (byte) i;
                }
                this.u = bArr;
                boolean[] zArr = new boolean[this.s];
                for (int i2 = 0; i2 < this.t; i2++) {
                    zArr[b.c.b.a.b.a(i2 * 8, this.r, RoundingMode.CEILING)] = true;
                }
                this.v = zArr;
            } catch (ArithmeticException e2) {
                throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e2);
            }
        }

        boolean b(int i) {
            return this.v[i % this.s];
        }

        @Override // com.google.common.base.c
        public boolean c(char c2) {
            return com.google.common.base.c.f13735c.c(c2) && this.u[c2] != -1;
        }

        int d(char c2) throws DecodingException {
            Object objValueOf;
            if (c2 <= 127) {
                byte[] bArr = this.u;
                if (bArr[c2] != -1) {
                    return bArr[c2];
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unrecognized character: ");
            if (com.google.common.base.c.k.c(c2)) {
                objValueOf = "0x" + Integer.toHexString(c2);
            } else {
                objValueOf = Character.valueOf(c2);
            }
            sb.append(objValueOf);
            throw new DecodingException(sb.toString());
        }

        public String toString() {
            return this.o;
        }

        char a(int i) {
            return this.p[i];
        }
    }

    static final class b extends d {
        final char[] h;

        b(String str, String str2) {
            this(new a(str, str2.toCharArray()));
        }

        @Override // com.google.common.io.BaseEncoding.d, com.google.common.io.BaseEncoding
        void a(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            m.a(appendable);
            m.a(i, i + i2, bArr.length);
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = bArr[i + i3] & 255;
                appendable.append(this.h[i4]);
                appendable.append(this.h[i4 | 256]);
            }
        }

        private b(a aVar) {
            super(aVar, null);
            this.h = new char[512];
            m.a(aVar.p.length == 16);
            for (int i = 0; i < 256; i++) {
                this.h[i] = aVar.a(i >>> 4);
                this.h[i | 256] = aVar.a(i & 15);
            }
        }

        @Override // com.google.common.io.BaseEncoding.d, com.google.common.io.BaseEncoding
        int a(byte[] bArr, CharSequence charSequence) throws DecodingException {
            m.a(bArr);
            if (charSequence.length() % 2 != 1) {
                int i = 0;
                int i2 = 0;
                while (i < charSequence.length()) {
                    bArr[i2] = (byte) ((this.f13974f.d(charSequence.charAt(i)) << 4) | this.f13974f.d(charSequence.charAt(i + 1)));
                    i += 2;
                    i2++;
                }
                return i2;
            }
            throw new DecodingException("Invalid input length " + charSequence.length());
        }
    }

    static final class c extends d {
        c(String str, String str2, Character ch) {
            this(new a(str, str2.toCharArray()), ch);
        }

        @Override // com.google.common.io.BaseEncoding.d, com.google.common.io.BaseEncoding
        void a(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            m.a(appendable);
            int i3 = i + i2;
            m.a(i, i3, bArr.length);
            while (i2 >= 3) {
                int i4 = i + 1;
                int i5 = i4 + 1;
                int i6 = ((bArr[i] & 255) << 16) | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                appendable.append(this.f13974f.a(i6 >>> 18));
                appendable.append(this.f13974f.a((i6 >>> 12) & 63));
                appendable.append(this.f13974f.a((i6 >>> 6) & 63));
                appendable.append(this.f13974f.a(i6 & 63));
                i2 -= 3;
                i = i5 + 1;
            }
            if (i < i3) {
                b(appendable, bArr, i, i3 - i);
            }
        }

        private c(a aVar, Character ch) {
            super(aVar, ch);
            m.a(aVar.p.length == 64);
        }

        @Override // com.google.common.io.BaseEncoding.d, com.google.common.io.BaseEncoding
        int a(byte[] bArr, CharSequence charSequence) throws DecodingException {
            m.a(bArr);
            String strA = b().a(charSequence);
            if (this.f13974f.b(strA.length())) {
                int i = 0;
                int i2 = 0;
                while (i < strA.length()) {
                    int i3 = i + 1;
                    int i4 = i3 + 1;
                    int iD = (this.f13974f.d(strA.charAt(i)) << 18) | (this.f13974f.d(strA.charAt(i3)) << 12);
                    int i5 = i2 + 1;
                    bArr[i2] = (byte) (iD >>> 16);
                    if (i4 < strA.length()) {
                        int i6 = i4 + 1;
                        int iD2 = iD | (this.f13974f.d(strA.charAt(i4)) << 6);
                        i2 = i5 + 1;
                        bArr[i5] = (byte) ((iD2 >>> 8) & 255);
                        if (i6 < strA.length()) {
                            i4 = i6 + 1;
                            i5 = i2 + 1;
                            bArr[i2] = (byte) ((iD2 | this.f13974f.d(strA.charAt(i6))) & 255);
                        } else {
                            i = i6;
                        }
                    }
                    i2 = i5;
                    i = i4;
                }
                return i2;
            }
            throw new DecodingException("Invalid input length " + strA.length());
        }
    }

    static class d extends BaseEncoding {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final a f13974f;
        final Character g;

        d(String str, String str2, Character ch) {
            this(new a(str, str2.toCharArray()), ch);
        }

        @Override // com.google.common.io.BaseEncoding
        void a(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            m.a(appendable);
            m.a(i, i + i2, bArr.length);
            int i3 = 0;
            while (i3 < i2) {
                b(appendable, bArr, i + i3, Math.min(this.f13974f.t, i2 - i3));
                i3 += this.f13974f.t;
            }
        }

        @Override // com.google.common.io.BaseEncoding
        com.google.common.base.c b() {
            Character ch = this.g;
            return ch == null ? com.google.common.base.c.n : com.google.common.base.c.b(ch.charValue());
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("BaseEncoding.");
            sb.append(this.f13974f.toString());
            if (8 % this.f13974f.r != 0) {
                if (this.g == null) {
                    sb.append(".omitPadding()");
                } else {
                    sb.append(".withPadChar(");
                    sb.append(this.g);
                    sb.append(')');
                }
            }
            return sb.toString();
        }

        d(a aVar, Character ch) {
            m.a(aVar);
            this.f13974f = aVar;
            m.a(ch == null || !aVar.c(ch.charValue()), "Padding character %s was already in alphabet", ch);
            this.g = ch;
        }

        @Override // com.google.common.io.BaseEncoding
        int b(int i) {
            a aVar = this.f13974f;
            return aVar.s * b.c.b.a.b.a(i, aVar.t, RoundingMode.CEILING);
        }

        void b(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            m.a(appendable);
            m.a(i, i + i2, bArr.length);
            int i3 = 0;
            m.a(i2 <= this.f13974f.t);
            long j = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                j = (j | ((long) (bArr[i + i4] & 255))) << 8;
            }
            int i5 = ((i2 + 1) * 8) - this.f13974f.r;
            while (i3 < i2 * 8) {
                a aVar = this.f13974f;
                appendable.append(aVar.a(((int) (j >>> (i5 - i3))) & aVar.q));
                i3 += this.f13974f.r;
            }
            if (this.g != null) {
                while (i3 < this.f13974f.t * 8) {
                    appendable.append(this.g.charValue());
                    i3 += this.f13974f.r;
                }
            }
        }

        @Override // com.google.common.io.BaseEncoding
        int a(int i) {
            return (int) (((((long) this.f13974f.r) * ((long) i)) + 7) / 8);
        }

        @Override // com.google.common.io.BaseEncoding
        int a(byte[] bArr, CharSequence charSequence) throws DecodingException {
            a aVar;
            m.a(bArr);
            String strA = b().a(charSequence);
            if (this.f13974f.b(strA.length())) {
                int i = 0;
                int i2 = 0;
                while (i < strA.length()) {
                    long jD = 0;
                    int i3 = 0;
                    int i4 = 0;
                    while (true) {
                        aVar = this.f13974f;
                        if (i3 >= aVar.s) {
                            break;
                        }
                        jD <<= aVar.r;
                        if (i + i3 < strA.length()) {
                            jD |= (long) this.f13974f.d(strA.charAt(i4 + i));
                            i4++;
                        }
                        i3++;
                    }
                    int i5 = aVar.t;
                    int i6 = (i5 * 8) - (i4 * aVar.r);
                    int i7 = (i5 - 1) * 8;
                    while (i7 >= i6) {
                        bArr[i2] = (byte) ((jD >>> i7) & 255);
                        i7 -= 8;
                        i2++;
                    }
                    i += this.f13974f.s;
                }
                return i2;
            }
            throw new DecodingException("Invalid input length " + strA.length());
        }
    }

    BaseEncoding() {
    }

    abstract int a(int i);

    abstract int a(byte[] bArr, CharSequence charSequence) throws DecodingException;

    public String a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    abstract void a(Appendable appendable, byte[] bArr, int i, int i2) throws IOException;

    abstract int b(int i);

    abstract com.google.common.base.c b();

    final byte[] b(CharSequence charSequence) throws DecodingException {
        String strA = b().a(charSequence);
        byte[] bArr = new byte[a(strA.length())];
        return a(bArr, a(bArr, strA));
    }

    public final String a(byte[] bArr, int i, int i2) {
        m.a(i, i + i2, bArr.length);
        StringBuilder sb = new StringBuilder(b(i2));
        try {
            a(sb, bArr, i, i2);
            return sb.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    private static byte[] a(byte[] bArr, int i) {
        if (i == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        return bArr2;
    }

    public final byte[] a(CharSequence charSequence) {
        try {
            return b(charSequence);
        } catch (DecodingException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static BaseEncoding a() {
        return f13969a;
    }
}
