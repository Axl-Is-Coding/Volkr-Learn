package com.google.protobuf;

import com.google.protobuf.Utf8;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CodedOutputStream extends AbstractC2299e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f14274a = Logger.getLogger(CodedOutputStream.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f14275b = M.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f14276c = M.a();

    public static class OutOfSpaceException extends IOException {
        private static final String MESSAGE = "CodedOutputStream was writing to a flat byte array and ran out of space.";
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException() {
            super(MESSAGE);
        }

        OutOfSpaceException(Throwable th) {
            super(MESSAGE, th);
        }

        OutOfSpaceException(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }
    }

    private static abstract class a extends CodedOutputStream {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final byte[] f14277d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final int f14278e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f14279f;
        int g;

        a(int i) {
            super();
            if (i < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            this.f14277d = new byte[Math.max(i, 20)];
            this.f14278e = this.f14277d.length;
        }

        final void a(byte b2) {
            byte[] bArr = this.f14277d;
            int i = this.f14279f;
            this.f14279f = i + 1;
            bArr[i] = b2;
            this.g++;
        }

        final void c(long j) {
            if (CodedOutputStream.f14275b) {
                long j2 = CodedOutputStream.f14276c + ((long) this.f14279f);
                long j3 = j;
                long j4 = j2;
                while ((j3 & (-128)) != 0) {
                    M.a(this.f14277d, j4, (byte) ((((int) j3) & 127) | 128));
                    j3 >>>= 7;
                    j4++;
                }
                M.a(this.f14277d, j4, (byte) j3);
                int i = (int) ((1 + j4) - j2);
                this.f14279f += i;
                this.g += i;
                return;
            }
            long j5 = j;
            while ((j5 & (-128)) != 0) {
                byte[] bArr = this.f14277d;
                int i2 = this.f14279f;
                this.f14279f = i2 + 1;
                bArr[i2] = (byte) ((((int) j5) & 127) | 128);
                this.g++;
                j5 >>>= 7;
            }
            byte[] bArr2 = this.f14277d;
            int i3 = this.f14279f;
            this.f14279f = i3 + 1;
            bArr2[i3] = (byte) j5;
            this.g++;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int e() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }

        final void j(int i) {
            if (i >= 0) {
                k(i);
            } else {
                c(i);
            }
        }

        final void k(int i) {
            if (CodedOutputStream.f14275b) {
                long j = CodedOutputStream.f14276c + ((long) this.f14279f);
                long j2 = j;
                while ((i & (-128)) != 0) {
                    M.a(this.f14277d, j2, (byte) ((i & 127) | 128));
                    i >>>= 7;
                    j2 = 1 + j2;
                }
                M.a(this.f14277d, j2, (byte) i);
                int i2 = (int) ((1 + j2) - j);
                this.f14279f += i2;
                this.g += i2;
                return;
            }
            while ((i & (-128)) != 0) {
                byte[] bArr = this.f14277d;
                int i3 = this.f14279f;
                this.f14279f = i3 + 1;
                bArr[i3] = (byte) ((i & 127) | 128);
                this.g++;
                i >>>= 7;
            }
            byte[] bArr2 = this.f14277d;
            int i4 = this.f14279f;
            this.f14279f = i4 + 1;
            bArr2[i4] = (byte) i;
            this.g++;
        }

        final void e(int i, int i2) {
            k(WireFormat.a(i, i2));
        }
    }

    private static class b extends CodedOutputStream {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final byte[] f14280d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f14281e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f14282f;
        private int g;

        b(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i3 = i + i2;
            if ((i | i2 | (bArr.length - i3)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            this.f14280d = bArr;
            this.f14281e = i;
            this.g = i;
            this.f14282f = i3;
        }

        public final void a(byte b2) throws IOException {
            try {
                byte[] bArr = this.f14280d;
                int i = this.g;
                this.g = i + 1;
                bArr[i] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f14282f), 1), e2);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void b(int i, boolean z) throws IOException {
            e(i, 0);
            a(z ? (byte) 1 : (byte) 0);
        }

        public final void c(long j) throws IOException {
            if (CodedOutputStream.f14275b && e() >= 10) {
                long j2 = CodedOutputStream.f14276c + ((long) this.g);
                while ((j & (-128)) != 0) {
                    M.a(this.f14280d, j2, (byte) ((((int) j) & 127) | 128));
                    this.g++;
                    j >>>= 7;
                    j2 = 1 + j2;
                }
                M.a(this.f14280d, j2, (byte) j);
                this.g++;
                return;
            }
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr = this.f14280d;
                    int i = this.g;
                    this.g = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f14282f), 1), e2);
                }
            }
            byte[] bArr2 = this.f14280d;
            int i2 = this.g;
            this.g = i2 + 1;
            bArr2[i2] = (byte) j;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void d() {
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void d(int i, int i2) throws IOException {
            e(i, 0);
            j(i2);
        }

        public final void e(int i, int i2) throws IOException {
            i(WireFormat.a(i, i2));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void i(int i) throws IOException {
            if (CodedOutputStream.f14275b && e() >= 10) {
                long j = CodedOutputStream.f14276c + ((long) this.g);
                while ((i & (-128)) != 0) {
                    M.a(this.f14280d, j, (byte) ((i & 127) | 128));
                    this.g++;
                    i >>>= 7;
                    j = 1 + j;
                }
                M.a(this.f14280d, j, (byte) i);
                this.g++;
                return;
            }
            while ((i & (-128)) != 0) {
                try {
                    byte[] bArr = this.f14280d;
                    int i2 = this.g;
                    this.g = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f14282f), 1), e2);
                }
            }
            byte[] bArr2 = this.f14280d;
            int i3 = this.g;
            this.g = i3 + 1;
            bArr2[i3] = (byte) i;
        }

        public final void j(int i) throws IOException {
            if (i >= 0) {
                i(i);
            } else {
                c(i);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int e() {
            return this.f14282f - this.g;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void b(int i, String str) throws IOException {
            e(i, 2);
            b(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void d(int i, long j) throws IOException {
            e(i, 0);
            c(j);
        }

        @Override // com.google.protobuf.AbstractC2299e
        public final void a(byte[] bArr, int i, int i2) throws IOException {
            c(bArr, i, i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void b(int i, x xVar) throws IOException {
            e(i, 2);
            b(xVar);
        }

        public final void b(x xVar) throws IOException {
            i(xVar.getSerializedSize());
            xVar.writeTo(this);
        }

        public final void b(String str) throws IOException {
            int i = this.g;
            try {
                int iG = CodedOutputStream.g(str.length() * 3);
                int iG2 = CodedOutputStream.g(str.length());
                if (iG2 == iG) {
                    this.g = i + iG2;
                    int iA = Utf8.a(str, this.f14280d, this.g, e());
                    this.g = i;
                    i((iA - i) - iG2);
                    this.g = iA;
                } else {
                    i(Utf8.a(str));
                    this.g = Utf8.a(str, this.f14280d, this.g, e());
                }
            } catch (Utf8.UnpairedSurrogateException e2) {
                this.g = i;
                a(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException(e3);
            }
        }

        public final void c(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.f14280d, this.g, i2);
                this.g += i2;
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f14282f), Integer.valueOf(i2)), e2);
            }
        }
    }

    private static final class c extends a {
        private final OutputStream h;

        c(OutputStream outputStream, int i) {
            super(i);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.h = outputStream;
        }

        private void l(int i) throws IOException {
            if (this.f14278e - this.f14279f < i) {
                f();
            }
        }

        @Override // com.google.protobuf.AbstractC2299e
        public void a(byte[] bArr, int i, int i2) throws IOException {
            c(bArr, i, i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void b(int i, boolean z) throws IOException {
            l(11);
            e(i, 0);
            a(z ? (byte) 1 : (byte) 0);
        }

        public void c(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.f14278e;
            int i4 = this.f14279f;
            if (i3 - i4 >= i2) {
                System.arraycopy(bArr, i, this.f14277d, i4, i2);
                this.f14279f += i2;
                this.g += i2;
                return;
            }
            int i5 = i3 - i4;
            System.arraycopy(bArr, i, this.f14277d, i4, i5);
            int i6 = i + i5;
            int i7 = i2 - i5;
            this.f14279f = this.f14278e;
            this.g += i5;
            f();
            if (i7 <= this.f14278e) {
                System.arraycopy(bArr, i6, this.f14277d, 0, i7);
                this.f14279f = i7;
            } else {
                this.h.write(bArr, i6, i7);
            }
            this.g += i7;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void d(int i, int i2) throws IOException {
            l(20);
            e(i, 0);
            j(i2);
        }

        public void f(int i, int i2) throws IOException {
            i(WireFormat.a(i, i2));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void i(int i) throws IOException {
            l(10);
            k(i);
        }

        private void f() throws IOException {
            this.h.write(this.f14277d, 0, this.f14279f);
            this.f14279f = 0;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void b(int i, String str) throws IOException {
            f(i, 2);
            b(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void d(int i, long j) throws IOException {
            l(20);
            e(i, 0);
            c(j);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void b(int i, x xVar) throws IOException {
            f(i, 2);
            b(xVar);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void d() throws IOException {
            if (this.f14279f > 0) {
                f();
            }
        }

        public void b(x xVar) throws IOException {
            i(xVar.getSerializedSize());
            xVar.writeTo(this);
        }

        public void b(String str) throws IOException {
            int iA;
            try {
                int length = str.length() * 3;
                int iG = CodedOutputStream.g(length);
                int i = iG + length;
                if (i > this.f14278e) {
                    byte[] bArr = new byte[length];
                    int iA2 = Utf8.a(str, bArr, 0, length);
                    i(iA2);
                    a(bArr, 0, iA2);
                    return;
                }
                if (i > this.f14278e - this.f14279f) {
                    f();
                }
                int iG2 = CodedOutputStream.g(str.length());
                int i2 = this.f14279f;
                try {
                    if (iG2 == iG) {
                        this.f14279f = i2 + iG2;
                        int iA3 = Utf8.a(str, this.f14277d, this.f14279f, this.f14278e - this.f14279f);
                        this.f14279f = i2;
                        iA = (iA3 - i2) - iG2;
                        k(iA);
                        this.f14279f = iA3;
                    } else {
                        iA = Utf8.a(str);
                        k(iA);
                        this.f14279f = Utf8.a(str, this.f14277d, this.f14279f, iA);
                    }
                    this.g += iA;
                } catch (Utf8.UnpairedSurrogateException e2) {
                    this.g -= this.f14279f - i2;
                    this.f14279f = i2;
                    throw e2;
                } catch (ArrayIndexOutOfBoundsException e3) {
                    throw new OutOfSpaceException(e3);
                }
            } catch (Utf8.UnpairedSurrogateException e4) {
                a(str, e4);
            }
        }
    }

    public static int a(boolean z) {
        return 1;
    }

    public static int b(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    static int d(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    @Deprecated
    public static int e(int i) {
        return g(i);
    }

    public static int f(int i) {
        return g(WireFormat.a(i, 0));
    }

    public static int g(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public abstract void b(int i, x xVar) throws IOException;

    public abstract void b(int i, String str) throws IOException;

    public abstract void b(int i, boolean z) throws IOException;

    public final void c(int i, long j) throws IOException {
        d(i, j);
    }

    public abstract void d() throws IOException;

    public abstract void d(int i, int i2) throws IOException;

    public abstract void d(int i, long j) throws IOException;

    public abstract int e();

    @Deprecated
    public final void h(int i) throws IOException {
        i(i);
    }

    public abstract void i(int i) throws IOException;

    private CodedOutputStream() {
    }

    public static CodedOutputStream a(OutputStream outputStream, int i) {
        return new c(outputStream, i);
    }

    public static CodedOutputStream b(byte[] bArr, int i, int i2) {
        return new b(bArr, i, i2);
    }

    public final void c(int i, int i2) throws IOException {
        d(i, i2);
    }

    public static CodedOutputStream a(byte[] bArr) {
        return b(bArr, 0, bArr.length);
    }

    public static int b(int i, int i2) {
        return f(i) + b(i2);
    }

    static int c(int i) {
        return g(i) + i;
    }

    public static int a(int i, long j) {
        return f(i) + a(j);
    }

    public static int b(int i, long j) {
        return f(i) + b(j);
    }

    public final void c() {
        if (e() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public static int a(int i, boolean z) {
        return f(i) + a(z);
    }

    public static int b(int i) {
        if (i >= 0) {
            return g(i);
        }
        return 10;
    }

    public static int a(int i, int i2) {
        return f(i) + a(i2);
    }

    public static int a(int i, String str) {
        return f(i) + a(str);
    }

    public static int a(int i, x xVar) {
        return f(i) + a(xVar);
    }

    public static int a(long j) {
        return b(j);
    }

    public static int a(int i) {
        return b(i);
    }

    public static int a(String str) {
        int length;
        try {
            length = Utf8.a(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            length = str.getBytes(r.f14375a).length;
        }
        return c(length);
    }

    public static int a(x xVar) {
        return c(xVar.getSerializedSize());
    }

    final void a(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) throws IOException {
        f14274a.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) unpairedSurrogateException);
        byte[] bytes = str.getBytes(r.f14375a);
        try {
            i(bytes.length);
            a(bytes, 0, bytes.length);
        } catch (OutOfSpaceException e2) {
            throw e2;
        } catch (IndexOutOfBoundsException e3) {
            throw new OutOfSpaceException(e3);
        }
    }
}
