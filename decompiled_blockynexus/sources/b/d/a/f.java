package b.d.a;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: compiled from: DataSource.java */
/* JADX INFO: loaded from: classes2.dex */
public interface f extends Closeable {
    long a(long j, long j2, WritableByteChannel writableByteChannel) throws IOException;

    ByteBuffer a(long j, long j2) throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    long position() throws IOException;

    void position(long j) throws IOException;
}
