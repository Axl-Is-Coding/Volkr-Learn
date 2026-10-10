package freemarker.core;

import java.io.IOException;
import java.io.Writer;

/* JADX INFO: renamed from: freemarker.core.zb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: Environment.java */
/* JADX INFO: loaded from: classes5.dex */
final class C2854zb extends Writer {
    C2854zb() {
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws IOException {
        if (i2 > 0) {
            throw new IOException("This transform does not allow nested content.");
        }
    }
}
