package okhttp3.internal.ws;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: loaded from: classes5.dex */
final class WebSocketReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f23388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final BufferedSource f23389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final FrameCallback f23390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f23391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f23392e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f23393f;
    boolean g;
    boolean h;
    private final Buffer i = new Buffer();
    private final Buffer j = new Buffer();
    private final byte[] k;
    private final Buffer.UnsafeCursor l;

    public interface FrameCallback {
        void onReadClose(int i, String str);

        void onReadMessage(String str) throws IOException;

        void onReadMessage(ByteString byteString) throws IOException;

        void onReadPing(ByteString byteString);

        void onReadPong(ByteString byteString);
    }

    WebSocketReader(boolean z, BufferedSource bufferedSource, FrameCallback frameCallback) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        }
        if (frameCallback == null) {
            throw new NullPointerException("frameCallback == null");
        }
        this.f23388a = z;
        this.f23389b = bufferedSource;
        this.f23390c = frameCallback;
        this.k = z ? null : new byte[4];
        this.l = z ? null : new Buffer.UnsafeCursor();
    }

    private void b() throws IOException {
        String utf8;
        long j = this.f23393f;
        if (j > 0) {
            this.f23389b.readFully(this.i, j);
            if (!this.f23388a) {
                this.i.readAndWriteUnsafe(this.l);
                this.l.seek(0L);
                d.a(this.l, this.k);
                this.l.close();
            }
        }
        switch (this.f23392e) {
            case 8:
                short s = 1005;
                long size = this.i.size();
                if (size == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (size != 0) {
                    s = this.i.readShort();
                    utf8 = this.i.readUtf8();
                    String strA = d.a(s);
                    if (strA != null) {
                        throw new ProtocolException(strA);
                    }
                } else {
                    utf8 = "";
                }
                this.f23390c.onReadClose(s, utf8);
                this.f23391d = true;
                return;
            case 9:
                this.f23390c.onReadPing(this.i.readByteString());
                return;
            case 10:
                this.f23390c.onReadPong(this.i.readByteString());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.f23392e));
        }
    }

    /* JADX WARN: Finally extract failed */
    private void c() throws IOException {
        if (this.f23391d) {
            throw new IOException("closed");
        }
        long jTimeoutNanos = this.f23389b.timeout().timeoutNanos();
        this.f23389b.timeout().clearTimeout();
        try {
            int i = this.f23389b.readByte() & 255;
            this.f23389b.timeout().timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
            this.f23392e = i & 15;
            this.g = (i & 128) != 0;
            this.h = (i & 8) != 0;
            if (this.h && !this.g) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z = (i & 64) != 0;
            boolean z2 = (i & 32) != 0;
            boolean z3 = (i & 16) != 0;
            if (z || z2 || z3) {
                throw new ProtocolException("Reserved flags are unsupported.");
            }
            boolean z4 = ((this.f23389b.readByte() & 255) & 128) != 0;
            boolean z5 = this.f23388a;
            if (z4 == z5) {
                throw new ProtocolException(z5 ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            this.f23393f = r0 & 127;
            long j = this.f23393f;
            if (j == 126) {
                this.f23393f = ((long) this.f23389b.readShort()) & 65535;
            } else if (j == 127) {
                this.f23393f = this.f23389b.readLong();
                if (this.f23393f < 0) {
                    throw new ProtocolException("Frame length 0x" + Long.toHexString(this.f23393f) + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.h && this.f23393f > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z4) {
                this.f23389b.readFully(this.k);
            }
        } catch (Throwable th) {
            this.f23389b.timeout().timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    private void d() throws IOException {
        while (!this.f23391d) {
            long j = this.f23393f;
            if (j > 0) {
                this.f23389b.readFully(this.j, j);
                if (!this.f23388a) {
                    this.j.readAndWriteUnsafe(this.l);
                    this.l.seek(this.j.size() - this.f23393f);
                    d.a(this.l, this.k);
                    this.l.close();
                }
            }
            if (this.g) {
                return;
            }
            f();
            if (this.f23392e != 0) {
                throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.f23392e));
            }
        }
        throw new IOException("closed");
    }

    private void e() throws IOException {
        int i = this.f23392e;
        if (i != 1 && i != 2) {
            throw new ProtocolException("Unknown opcode: " + Integer.toHexString(i));
        }
        d();
        if (i == 1) {
            this.f23390c.onReadMessage(this.j.readUtf8());
        } else {
            this.f23390c.onReadMessage(this.j.readByteString());
        }
    }

    private void f() throws IOException {
        while (!this.f23391d) {
            c();
            if (!this.h) {
                return;
            } else {
                b();
            }
        }
    }

    void a() throws IOException {
        c();
        if (this.h) {
            b();
        } else {
            e();
        }
    }
}
