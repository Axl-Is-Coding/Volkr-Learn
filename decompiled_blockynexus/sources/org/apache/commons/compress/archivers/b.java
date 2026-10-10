package org.apache.commons.compress.archivers;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: ArchiveInputStream.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f23527a = new byte[1];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f23528b = 0;

    protected void a(int i) {
        b(i);
    }

    protected void b(long j) {
        if (j != -1) {
            this.f23528b += j;
        }
    }

    protected void d(long j) {
        this.f23528b -= j;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.f23527a, 0, 1) == -1) {
            return -1;
        }
        return this.f23527a[0] & 255;
    }

    public long b() {
        return this.f23528b;
    }
}
