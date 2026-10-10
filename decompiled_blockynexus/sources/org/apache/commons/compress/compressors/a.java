package org.apache.commons.compress.compressors;

import java.io.InputStream;

/* JADX INFO: compiled from: CompressorInputStream.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f23537a = 0;

    protected void a(int i) {
        b(i);
    }

    protected void b(long j) {
        if (j != -1) {
            this.f23537a += j;
        }
    }
}
