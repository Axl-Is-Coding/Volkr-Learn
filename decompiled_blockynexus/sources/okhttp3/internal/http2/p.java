package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.a;
import okio.Buffer;
import okio.BufferedSink;

/* JADX INFO: compiled from: Http2Writer.java */
/* JADX INFO: loaded from: classes5.dex */
final class p implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f23364a = Logger.getLogger(b.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BufferedSink f23365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f23366c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f23369f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Buffer f23367d = new Buffer();
    final a.b g = new a.b(this.f23367d);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f23368e = 16384;

    p(BufferedSink bufferedSink, boolean z) {
        this.f23365b = bufferedSink;
        this.f23366c = z;
    }

    public synchronized void a(s sVar) throws IOException {
        if (this.f23369f) {
            throw new IOException("closed");
        }
        this.f23368e = sVar.c(this.f23368e);
        if (sVar.b() != -1) {
            this.g.a(sVar.b());
        }
        a(0, 0, (byte) 4, (byte) 1);
        this.f23365b.flush();
    }

    public synchronized void b(s sVar) throws IOException {
        if (this.f23369f) {
            throw new IOException("closed");
        }
        int i = 0;
        a(0, sVar.d() * 6, (byte) 4, (byte) 0);
        while (i < 10) {
            if (sVar.d(i)) {
                this.f23365b.writeShort(i == 4 ? 3 : i == 7 ? 4 : i);
                this.f23365b.writeInt(sVar.a(i));
            }
            i++;
        }
        this.f23365b.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f23369f = true;
        this.f23365b.close();
    }

    public synchronized void connectionPreface() throws IOException {
        if (this.f23369f) {
            throw new IOException("closed");
        }
        if (this.f23366c) {
            if (f23364a.isLoggable(Level.FINE)) {
                f23364a.fine(okhttp3.a.e.a(">> CONNECTION %s", b.f23289a.hex()));
            }
            this.f23365b.write(b.f23289a.toByteArray());
            this.f23365b.flush();
        }
    }

    public synchronized void data(boolean z, int i, Buffer buffer, int i2) throws IOException {
        if (this.f23369f) {
            throw new IOException("closed");
        }
        a(i, z ? (byte) 1 : (byte) 0, buffer, i2);
    }

    public synchronized void flush() throws IOException {
        if (this.f23369f) {
            throw new IOException("closed");
        }
        this.f23365b.flush();
    }

    public int maxDataLength() {
        return this.f23368e;
    }

    public synchronized void ping(boolean z, int i, int i2) throws IOException {
        if (this.f23369f) {
            throw new IOException("closed");
        }
        a(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
        this.f23365b.writeInt(i);
        this.f23365b.writeInt(i2);
        this.f23365b.flush();
    }

    public synchronized void pushPromise(int i, int i2, List<Header> list) throws IOException {
        if (this.f23369f) {
            throw new IOException("closed");
        }
        this.g.a(list);
        long size = this.f23367d.size();
        int iMin = (int) Math.min(this.f23368e - 4, size);
        long j = iMin;
        a(i, iMin + 4, (byte) 5, size == j ? (byte) 4 : (byte) 0);
        this.f23365b.writeInt(i2 & Integer.MAX_VALUE);
        this.f23365b.write(this.f23367d, j);
        if (size > j) {
            a(i, size - j);
        }
    }

    public synchronized void windowUpdate(int i, long j) throws IOException {
        if (this.f23369f) {
            throw new IOException("closed");
        }
        if (j == 0 || j > 2147483647L) {
            b.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
            throw null;
        }
        a(i, 4, (byte) 8, (byte) 0);
        this.f23365b.writeInt((int) j);
        this.f23365b.flush();
    }

    public synchronized void a(boolean z, int i, int i2, List<Header> list) throws IOException {
        if (!this.f23369f) {
            a(z, i, list);
        } else {
            throw new IOException("closed");
        }
    }

    public synchronized void a(int i, ErrorCode errorCode) throws IOException {
        if (!this.f23369f) {
            if (errorCode.httpCode != -1) {
                a(i, 4, (byte) 3, (byte) 0);
                this.f23365b.writeInt(errorCode.httpCode);
                this.f23365b.flush();
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IOException("closed");
        }
    }

    void a(int i, byte b2, Buffer buffer, int i2) throws IOException {
        a(i, i2, (byte) 0, b2);
        if (i2 > 0) {
            this.f23365b.write(buffer, i2);
        }
    }

    public synchronized void a(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
        if (!this.f23369f) {
            if (errorCode.httpCode != -1) {
                a(0, bArr.length + 8, (byte) 7, (byte) 0);
                this.f23365b.writeInt(i);
                this.f23365b.writeInt(errorCode.httpCode);
                if (bArr.length > 0) {
                    this.f23365b.write(bArr);
                }
                this.f23365b.flush();
            } else {
                b.a("errorCode.httpCode == -1", new Object[0]);
                throw null;
            }
        } else {
            throw new IOException("closed");
        }
    }

    public void a(int i, int i2, byte b2, byte b3) throws IOException {
        if (f23364a.isLoggable(Level.FINE)) {
            f23364a.fine(b.a(false, i, i2, b2, b3));
        }
        int i3 = this.f23368e;
        if (i2 > i3) {
            b.a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
            throw null;
        }
        if ((Integer.MIN_VALUE & i) == 0) {
            a(this.f23365b, i2);
            this.f23365b.writeByte(b2 & 255);
            this.f23365b.writeByte(b3 & 255);
            this.f23365b.writeInt(i & Integer.MAX_VALUE);
            return;
        }
        b.a("reserved bit set: %s", Integer.valueOf(i));
        throw null;
    }

    private static void a(BufferedSink bufferedSink, int i) throws IOException {
        bufferedSink.writeByte((i >>> 16) & 255);
        bufferedSink.writeByte((i >>> 8) & 255);
        bufferedSink.writeByte(i & 255);
    }

    private void a(int i, long j) throws IOException {
        while (j > 0) {
            int iMin = (int) Math.min(this.f23368e, j);
            long j2 = iMin;
            j -= j2;
            a(i, iMin, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.f23365b.write(this.f23367d, j2);
        }
    }

    void a(boolean z, int i, List<Header> list) throws IOException {
        if (!this.f23369f) {
            this.g.a(list);
            long size = this.f23367d.size();
            int iMin = (int) Math.min(this.f23368e, size);
            long j = iMin;
            byte b2 = size == j ? (byte) 4 : (byte) 0;
            if (z) {
                b2 = (byte) (b2 | 1);
            }
            a(i, iMin, (byte) 1, b2);
            this.f23365b.write(this.f23367d, j);
            if (size > j) {
                a(i, size - j);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
