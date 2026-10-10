package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.a;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes5.dex */
final class Http2Reader implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Logger f23264a = Logger.getLogger(b.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BufferedSource f23265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f23266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f23267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final a.C0251a f23268e;

    interface Handler {
        void ackSettings();

        void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j);

        void data(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException;

        void goAway(int i, ErrorCode errorCode, ByteString byteString);

        void headers(boolean z, int i, int i2, List<Header> list);

        void ping(boolean z, int i, int i2);

        void priority(int i, int i2, int i3, boolean z);

        void pushPromise(int i, int i2, List<Header> list) throws IOException;

        void rstStream(int i, ErrorCode errorCode);

        void settings(boolean z, s sVar);

        void windowUpdate(int i, long j);
    }

    static final class a implements Source {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BufferedSource f23269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f23270b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        byte f23271c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f23272d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f23273e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        short f23274f;

        a(BufferedSource bufferedSource) {
            this.f23269a = bufferedSource;
        }

        private void a() throws IOException {
            int i = this.f23272d;
            int iA = Http2Reader.a(this.f23269a);
            this.f23273e = iA;
            this.f23270b = iA;
            byte b2 = (byte) (this.f23269a.readByte() & 255);
            this.f23271c = (byte) (this.f23269a.readByte() & 255);
            if (Http2Reader.f23264a.isLoggable(Level.FINE)) {
                Http2Reader.f23264a.fine(b.a(true, this.f23272d, this.f23270b, b2, this.f23271c));
            }
            this.f23272d = this.f23269a.readInt() & Integer.MAX_VALUE;
            if (b2 != 9) {
                b.b("%s != TYPE_CONTINUATION", Byte.valueOf(b2));
                throw null;
            }
            if (this.f23272d == i) {
                return;
            }
            b.b("TYPE_CONTINUATION streamId changed", new Object[0]);
            throw null;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            while (true) {
                int i = this.f23273e;
                if (i != 0) {
                    long j2 = this.f23269a.read(buffer, Math.min(j, i));
                    if (j2 == -1) {
                        return -1L;
                    }
                    this.f23273e = (int) (((long) this.f23273e) - j2);
                    return j2;
                }
                this.f23269a.skip(this.f23274f);
                this.f23274f = (short) 0;
                if ((this.f23271c & 4) != 0) {
                    return -1L;
                }
                a();
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.f23269a.timeout();
        }
    }

    Http2Reader(BufferedSource bufferedSource, boolean z) {
        this.f23265b = bufferedSource;
        this.f23267d = z;
        this.f23266c = new a(this.f23265b);
        this.f23268e = new a.C0251a(4096, this.f23266c);
    }

    private void b(Handler handler, int i, byte b2, int i2) throws IOException {
        if (i < 8) {
            b.b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
            throw null;
        }
        if (i2 != 0) {
            b.b("TYPE_GOAWAY streamId != 0", new Object[0]);
            throw null;
        }
        int i3 = this.f23265b.readInt();
        int i4 = this.f23265b.readInt();
        int i5 = i - 8;
        ErrorCode errorCodeFromHttp2 = ErrorCode.fromHttp2(i4);
        if (errorCodeFromHttp2 == null) {
            b.b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(i4));
            throw null;
        }
        ByteString byteString = ByteString.EMPTY;
        if (i5 > 0) {
            byteString = this.f23265b.readByteString(i5);
        }
        handler.goAway(i3, errorCodeFromHttp2, byteString);
    }

    private void c(Handler handler, int i, byte b2, int i2) throws IOException {
        if (i2 == 0) {
            b.b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            throw null;
        }
        boolean z = (b2 & 1) != 0;
        short s = (b2 & 8) != 0 ? (short) (this.f23265b.readByte() & 255) : (short) 0;
        if ((b2 & 32) != 0) {
            a(handler, i2);
            i -= 5;
        }
        handler.headers(z, i2, -1, a(a(i, b2, s), s, b2, i2));
    }

    private void d(Handler handler, int i, byte b2, int i2) throws IOException {
        if (i != 8) {
            b.b("TYPE_PING length != 8: %s", Integer.valueOf(i));
            throw null;
        }
        if (i2 != 0) {
            b.b("TYPE_PING streamId != 0", new Object[0]);
            throw null;
        }
        handler.ping((b2 & 1) != 0, this.f23265b.readInt(), this.f23265b.readInt());
    }

    private void e(Handler handler, int i, byte b2, int i2) throws IOException {
        if (i != 5) {
            b.b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
            throw null;
        }
        if (i2 != 0) {
            a(handler, i2);
        } else {
            b.b("TYPE_PRIORITY streamId == 0", new Object[0]);
            throw null;
        }
    }

    private void f(Handler handler, int i, byte b2, int i2) throws IOException {
        if (i2 == 0) {
            b.b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            throw null;
        }
        short s = (b2 & 8) != 0 ? (short) (this.f23265b.readByte() & 255) : (short) 0;
        handler.pushPromise(i2, this.f23265b.readInt() & Integer.MAX_VALUE, a(a(i - 4, b2, s), s, b2, i2));
    }

    private void g(Handler handler, int i, byte b2, int i2) throws IOException {
        if (i != 4) {
            b.b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
            throw null;
        }
        if (i2 == 0) {
            b.b("TYPE_RST_STREAM streamId == 0", new Object[0]);
            throw null;
        }
        int i3 = this.f23265b.readInt();
        ErrorCode errorCodeFromHttp2 = ErrorCode.fromHttp2(i3);
        if (errorCodeFromHttp2 != null) {
            handler.rstStream(i2, errorCodeFromHttp2);
        } else {
            b.b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i3));
            throw null;
        }
    }

    private void h(Handler handler, int i, byte b2, int i2) throws IOException {
        if (i2 != 0) {
            b.b("TYPE_SETTINGS streamId != 0", new Object[0]);
            throw null;
        }
        if ((b2 & 1) != 0) {
            if (i == 0) {
                handler.ackSettings();
                return;
            } else {
                b.b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                throw null;
            }
        }
        if (i % 6 != 0) {
            b.b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
            throw null;
        }
        s sVar = new s();
        for (int i3 = 0; i3 < i; i3 += 6) {
            int i4 = this.f23265b.readShort() & 65535;
            int i5 = this.f23265b.readInt();
            switch (i4) {
                case 2:
                    if (i5 != 0 && i5 != 1) {
                        b.b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                        throw null;
                    }
                    break;
                    break;
                case 3:
                    i4 = 4;
                    break;
                case 4:
                    i4 = 7;
                    if (i5 < 0) {
                        b.b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        throw null;
                    }
                    break;
                    break;
                case 5:
                    if (i5 < 16384 || i5 > 16777215) {
                        b.b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(i5));
                        throw null;
                    }
                    break;
                    break;
            }
            sVar.a(i4, i5);
        }
        handler.settings(false, sVar);
    }

    private void i(Handler handler, int i, byte b2, int i2) throws IOException {
        if (i != 4) {
            b.b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
            throw null;
        }
        long j = ((long) this.f23265b.readInt()) & 2147483647L;
        if (j != 0) {
            handler.windowUpdate(i2, j);
        } else {
            b.b("windowSizeIncrement was 0", Long.valueOf(j));
            throw null;
        }
    }

    public void a(Handler handler) throws IOException {
        if (this.f23267d) {
            if (a(true, handler)) {
                return;
            }
            b.b("Required SETTINGS preface not received", new Object[0]);
            throw null;
        }
        ByteString byteString = this.f23265b.readByteString(b.f23289a.size());
        if (f23264a.isLoggable(Level.FINE)) {
            f23264a.fine(okhttp3.a.e.a("<< CONNECTION %s", byteString.hex()));
        }
        if (b.f23289a.equals(byteString)) {
            return;
        }
        b.b("Expected a connection header but was %s", byteString.utf8());
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f23265b.close();
    }

    public boolean a(boolean z, Handler handler) throws IOException {
        try {
            this.f23265b.require(9L);
            int iA = a(this.f23265b);
            if (iA >= 0 && iA <= 16384) {
                byte b2 = (byte) (this.f23265b.readByte() & 255);
                if (z && b2 != 4) {
                    b.b("Expected a SETTINGS frame but was %s", Byte.valueOf(b2));
                    throw null;
                }
                byte b3 = (byte) (this.f23265b.readByte() & 255);
                int i = this.f23265b.readInt() & Integer.MAX_VALUE;
                if (f23264a.isLoggable(Level.FINE)) {
                    f23264a.fine(b.a(true, i, iA, b2, b3));
                }
                switch (b2) {
                    case 0:
                        a(handler, iA, b3, i);
                        return true;
                    case 1:
                        c(handler, iA, b3, i);
                        return true;
                    case 2:
                        e(handler, iA, b3, i);
                        return true;
                    case 3:
                        g(handler, iA, b3, i);
                        return true;
                    case 4:
                        h(handler, iA, b3, i);
                        return true;
                    case 5:
                        f(handler, iA, b3, i);
                        return true;
                    case 6:
                        d(handler, iA, b3, i);
                        return true;
                    case 7:
                        b(handler, iA, b3, i);
                        return true;
                    case 8:
                        i(handler, iA, b3, i);
                        return true;
                    default:
                        this.f23265b.skip(iA);
                        return true;
                }
            }
            b.b("FRAME_SIZE_ERROR: %s", Integer.valueOf(iA));
            throw null;
        } catch (IOException unused) {
            return false;
        }
    }

    private List<Header> a(int i, short s, byte b2, int i2) throws IOException {
        a aVar = this.f23266c;
        aVar.f23273e = i;
        aVar.f23270b = i;
        aVar.f23274f = s;
        aVar.f23271c = b2;
        aVar.f23272d = i2;
        this.f23268e.c();
        return this.f23268e.a();
    }

    private void a(Handler handler, int i, byte b2, int i2) throws IOException {
        if (i2 == 0) {
            b.b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
            throw null;
        }
        boolean z = (b2 & 1) != 0;
        if (!((b2 & 32) != 0)) {
            short s = (b2 & 8) != 0 ? (short) (this.f23265b.readByte() & 255) : (short) 0;
            handler.data(z, i2, this.f23265b, a(i, b2, s));
            this.f23265b.skip(s);
            return;
        }
        b.b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        throw null;
    }

    private void a(Handler handler, int i) throws IOException {
        int i2 = this.f23265b.readInt();
        handler.priority(i, i2 & Integer.MAX_VALUE, (this.f23265b.readByte() & 255) + 1, (Integer.MIN_VALUE & i2) != 0);
    }

    static int a(BufferedSource bufferedSource) throws IOException {
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8);
    }

    static int a(int i, byte b2, short s) throws IOException {
        if ((b2 & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        b.b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
        throw null;
    }
}
