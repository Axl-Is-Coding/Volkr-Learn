package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: ByteBufferBitmapDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class g implements com.bumptech.glide.load.m<ByteBuffer, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f4674a;

    public g(m mVar) {
        this.f4674a = mVar;
    }

    @Override // com.bumptech.glide.load.m
    public boolean a(ByteBuffer byteBuffer, com.bumptech.glide.load.l lVar) {
        return this.f4674a.a(byteBuffer);
    }

    @Override // com.bumptech.glide.load.m
    public com.bumptech.glide.load.engine.C<Bitmap> a(ByteBuffer byteBuffer, int i, int i2, com.bumptech.glide.load.l lVar) throws IOException {
        return this.f4674a.a(com.bumptech.glide.e.a.b(byteBuffer), i, i2, lVar);
    }
}
