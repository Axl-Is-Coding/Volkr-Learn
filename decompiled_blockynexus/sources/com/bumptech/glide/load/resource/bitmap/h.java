package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: ByteBufferBitmapImageDecoderResourceDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class h implements com.bumptech.glide.load.m<ByteBuffer, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0502d f4675a = new C0502d();

    @Override // com.bumptech.glide.load.m
    public boolean a(ByteBuffer byteBuffer, com.bumptech.glide.load.l lVar) throws IOException {
        return true;
    }

    @Override // com.bumptech.glide.load.m
    public com.bumptech.glide.load.engine.C<Bitmap> a(ByteBuffer byteBuffer, int i, int i2, com.bumptech.glide.load.l lVar) throws IOException {
        return this.f4675a.a(ImageDecoder.createSource(byteBuffer), i, i2, lVar);
    }
}
