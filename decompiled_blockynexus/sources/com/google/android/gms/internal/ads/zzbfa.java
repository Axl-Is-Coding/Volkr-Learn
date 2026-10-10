package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbfa implements zzeok {
    private final ByteBuffer zzamm;

    zzbfa(ByteBuffer byteBuffer) {
        this.zzamm = byteBuffer.duplicate();
    }

    @Override // com.google.android.gms.internal.ads.zzeok, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    @Override // com.google.android.gms.internal.ads.zzeok
    public final long position() throws IOException {
        return this.zzamm.position();
    }

    @Override // com.google.android.gms.internal.ads.zzeok
    public final int read(ByteBuffer byteBuffer) throws IOException {
        if (this.zzamm.remaining() == 0 && byteBuffer.remaining() > 0) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), this.zzamm.remaining());
        byte[] bArr = new byte[iMin];
        this.zzamm.get(bArr);
        byteBuffer.put(bArr);
        return iMin;
    }

    @Override // com.google.android.gms.internal.ads.zzeok
    public final long size() throws IOException {
        return this.zzamm.limit();
    }

    @Override // com.google.android.gms.internal.ads.zzeok
    public final void zzfc(long j) throws IOException {
        this.zzamm.position((int) j);
    }

    @Override // com.google.android.gms.internal.ads.zzeok
    public final ByteBuffer zzh(long j, long j2) throws IOException {
        int iPosition = this.zzamm.position();
        this.zzamm.position((int) j);
        ByteBuffer byteBufferSlice = this.zzamm.slice();
        byteBufferSlice.limit((int) j2);
        this.zzamm.position(iPosition);
        return byteBufferSlice;
    }
}
