package okhttp3.internal.ws;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.util.Random;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Timeout;

/* JADX INFO: compiled from: WebSocketWriter.java */
/* JADX INFO: loaded from: classes5.dex */
final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f23413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Random f23414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final BufferedSink f23415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Buffer f23416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f23417e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Buffer f23418f = new Buffer();
    final a g = new a();
    boolean h;
    private final byte[] i;
    private final Buffer.UnsafeCursor j;

    /* JADX INFO: compiled from: WebSocketWriter.java */
    final class a implements Sink {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23419a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f23420b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f23421c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f23422d;

        a() {
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f23422d) {
                throw new IOException("closed");
            }
            e eVar = e.this;
            eVar.a(this.f23419a, eVar.f23418f.size(), this.f23421c, true);
            this.f23422d = true;
            e.this.h = false;
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (this.f23422d) {
                throw new IOException("closed");
            }
            e eVar = e.this;
            eVar.a(this.f23419a, eVar.f23418f.size(), this.f23421c, false);
            this.f23421c = false;
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return e.this.f23415c.timeout();
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            if (this.f23422d) {
                throw new IOException("closed");
            }
            e.this.f23418f.write(buffer, j);
            boolean z = this.f23421c && this.f23420b != -1 && e.this.f23418f.size() > this.f23420b - PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            long jCompleteSegmentByteCount = e.this.f23418f.completeSegmentByteCount();
            if (jCompleteSegmentByteCount <= 0 || z) {
                return;
            }
            e.this.a(this.f23419a, jCompleteSegmentByteCount, this.f23421c, false);
            this.f23421c = false;
        }
    }

    e(boolean z, BufferedSink bufferedSink, Random random) {
        if (bufferedSink == null) {
            throw new NullPointerException("sink == null");
        }
        if (random == null) {
            throw new NullPointerException("random == null");
        }
        this.f23413a = z;
        this.f23415c = bufferedSink;
        this.f23416d = bufferedSink.buffer();
        this.f23414b = random;
        this.i = z ? new byte[4] : null;
        this.j = z ? new Buffer.UnsafeCursor() : null;
    }

    void a(ByteString byteString) throws IOException {
        b(9, byteString);
    }

    void b(ByteString byteString) throws IOException {
        b(10, byteString);
    }

    private void b(int i, ByteString byteString) throws IOException {
        if (this.f23417e) {
            throw new IOException("closed");
        }
        int size = byteString.size();
        if (size > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        this.f23416d.writeByte(i | 128);
        if (this.f23413a) {
            this.f23416d.writeByte(size | 128);
            this.f23414b.nextBytes(this.i);
            this.f23416d.write(this.i);
            if (size > 0) {
                long size2 = this.f23416d.size();
                this.f23416d.write(byteString);
                this.f23416d.readAndWriteUnsafe(this.j);
                this.j.seek(size2);
                d.a(this.j, this.i);
                this.j.close();
            }
        } else {
            this.f23416d.writeByte(size);
            this.f23416d.write(byteString);
        }
        this.f23415c.flush();
    }

    void a(int i, ByteString byteString) throws IOException {
        ByteString byteString2 = ByteString.EMPTY;
        if (i != 0 || byteString != null) {
            if (i != 0) {
                d.b(i);
            }
            Buffer buffer = new Buffer();
            buffer.writeShort(i);
            if (byteString != null) {
                buffer.write(byteString);
            }
            byteString2 = buffer.readByteString();
        }
        try {
            b(8, byteString2);
        } finally {
            this.f23417e = true;
        }
    }

    Sink a(int i, long j) {
        if (!this.h) {
            this.h = true;
            a aVar = this.g;
            aVar.f23419a = i;
            aVar.f23420b = j;
            aVar.f23421c = true;
            aVar.f23422d = false;
            return aVar;
        }
        throw new IllegalStateException("Another message writer is active. Did you call close()?");
    }

    void a(int i, long j, boolean z, boolean z2) throws IOException {
        if (!this.f23417e) {
            if (!z) {
                i = 0;
            }
            if (z2) {
                i |= 128;
            }
            this.f23416d.writeByte(i);
            int i2 = this.f23413a ? 128 : 0;
            if (j <= 125) {
                this.f23416d.writeByte(((int) j) | i2);
            } else if (j <= 65535) {
                this.f23416d.writeByte(i2 | 126);
                this.f23416d.writeShort((int) j);
            } else {
                this.f23416d.writeByte(i2 | 127);
                this.f23416d.writeLong(j);
            }
            if (this.f23413a) {
                this.f23414b.nextBytes(this.i);
                this.f23416d.write(this.i);
                if (j > 0) {
                    long size = this.f23416d.size();
                    this.f23416d.write(this.f23418f, j);
                    this.f23416d.readAndWriteUnsafe(this.j);
                    this.j.seek(size);
                    d.a(this.j, this.i);
                    this.j.close();
                }
            } else {
                this.f23416d.write(this.f23418f, j);
            }
            this.f23415c.emit();
            return;
        }
        throw new IOException("closed");
    }
}
