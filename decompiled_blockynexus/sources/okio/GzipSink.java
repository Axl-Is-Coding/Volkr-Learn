package okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import kotlin.jvm.internal.i;

/* JADX INFO: compiled from: GzipSink.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class GzipSink implements Sink {
    private boolean closed;
    private final CRC32 crc;
    private final Deflater deflater;
    private final DeflaterSink deflaterSink;
    private final RealBufferedSink sink;

    public GzipSink(Sink sink) {
        i.b(sink, "sink");
        this.sink = new RealBufferedSink(sink);
        this.deflater = new Deflater(-1, true);
        this.deflaterSink = new DeflaterSink((BufferedSink) this.sink, this.deflater);
        this.crc = new CRC32();
        Buffer buffer = this.sink.bufferField;
        buffer.writeShort(8075);
        buffer.writeByte(8);
        buffer.writeByte(0);
        buffer.writeInt(0);
        buffer.writeByte(0);
        buffer.writeByte(0);
    }

    private final void updateCrc(Buffer buffer, long j) {
        Segment segment = buffer.head;
        if (segment == null) {
            i.a();
            throw null;
        }
        while (j > 0) {
            int iMin = (int) Math.min(j, segment.limit - segment.pos);
            this.crc.update(segment.data, segment.pos, iMin);
            j -= (long) iMin;
            segment = segment.next;
            if (segment == null) {
                i.a();
                throw null;
            }
        }
    }

    private final void writeFooter() {
        this.sink.writeIntLe((int) this.crc.getValue());
        this.sink.writeIntLe((int) this.deflater.getBytesRead());
    }

    /* JADX INFO: renamed from: -deprecated_deflater, reason: not valid java name */
    public final Deflater m140deprecated_deflater() {
        return this.deflater;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.closed) {
            return;
        }
        Throwable th = null;
        try {
            this.deflaterSink.finishDeflate$okio();
            writeFooter();
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.deflater.end();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        try {
            this.sink.close();
        } catch (Throwable th4) {
            if (th == null) {
                th = th4;
            }
        }
        this.closed = true;
        if (th != null) {
            throw th;
        }
    }

    public final Deflater deflater() {
        return this.deflater;
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.deflaterSink.flush();
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) throws IOException {
        i.b(buffer, "source");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j).toString());
        }
        if (j == 0) {
            return;
        }
        updateCrc(buffer, j);
        this.deflaterSink.write(buffer, j);
    }
}
