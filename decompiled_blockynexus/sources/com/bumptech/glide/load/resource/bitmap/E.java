package com.bumptech.glide.load.resource.bitmap;

import android.media.MediaDataSource;
import com.bumptech.glide.load.resource.bitmap.D;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: VideoDecoder.java */
/* JADX INFO: loaded from: classes.dex */
class E extends MediaDataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ByteBuffer f4656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ D.b f4657b;

    E(D.b bVar, ByteBuffer byteBuffer) {
        this.f4657b = bVar;
        this.f4656a = byteBuffer;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // android.media.MediaDataSource
    public long getSize() {
        return this.f4656a.limit();
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) {
        if (j >= this.f4656a.limit()) {
            return -1;
        }
        this.f4656a.position((int) j);
        int iMin = Math.min(i2, this.f4656a.remaining());
        this.f4656a.get(bArr, i, iMin);
        return iMin;
    }
}
