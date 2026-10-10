package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: InputStreamBitmapImageDecoderResourceDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class u implements com.bumptech.glide.load.m<InputStream, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0502d f4701a = new C0502d();

    @Override // com.bumptech.glide.load.m
    public boolean a(InputStream inputStream, com.bumptech.glide.load.l lVar) throws IOException {
        return true;
    }

    @Override // com.bumptech.glide.load.m
    public com.bumptech.glide.load.engine.C<Bitmap> a(InputStream inputStream, int i, int i2, com.bumptech.glide.load.l lVar) throws IOException {
        return this.f4701a.a(ImageDecoder.createSource(com.bumptech.glide.e.a.a(inputStream)), i, i2, lVar);
    }
}
