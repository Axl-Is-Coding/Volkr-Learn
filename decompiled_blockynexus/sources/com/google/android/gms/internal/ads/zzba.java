package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzba extends FilterInputStream {
    private final long zzcp;
    private long zzcq;

    zzba(InputStream inputStream, long j) {
        super(inputStream);
        this.zzcp = j;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int i = super.read();
        if (i != -1) {
            this.zzcq++;
        }
        return i;
    }

    final long zzp() {
        return this.zzcp - this.zzcq;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = super.read(bArr, i, i2);
        if (i3 != -1) {
            this.zzcq += (long) i3;
        }
        return i3;
    }
}
