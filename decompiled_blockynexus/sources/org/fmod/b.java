package org.fmod;

import android.media.MediaDataSource;

/* JADX INFO: compiled from: MediaCodec.java */
/* JADX INFO: loaded from: classes5.dex */
class b extends MediaDataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaCodec f23549a;

    b(MediaCodec mediaCodec) {
        this.f23549a = mediaCodec;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // android.media.MediaDataSource
    public long getSize() {
        return MediaCodec.fmodGetSize(this.f23549a.mCodecPtr);
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) {
        return MediaCodec.fmodReadAt(this.f23549a.mCodecPtr, j, bArr, i, i2);
    }
}
