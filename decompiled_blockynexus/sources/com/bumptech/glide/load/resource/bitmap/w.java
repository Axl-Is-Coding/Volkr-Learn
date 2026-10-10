package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

/* JADX INFO: compiled from: ParcelFileDescriptorBitmapDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class w implements com.bumptech.glide.load.m<ParcelFileDescriptor, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f4704a;

    public w(m mVar) {
        this.f4704a = mVar;
    }

    @Override // com.bumptech.glide.load.m
    public boolean a(ParcelFileDescriptor parcelFileDescriptor, com.bumptech.glide.load.l lVar) {
        return this.f4704a.a(parcelFileDescriptor);
    }

    @Override // com.bumptech.glide.load.m
    public com.bumptech.glide.load.engine.C<Bitmap> a(ParcelFileDescriptor parcelFileDescriptor, int i, int i2, com.bumptech.glide.load.l lVar) throws IOException {
        return this.f4704a.a(parcelFileDescriptor, i, i2, lVar);
    }
}
