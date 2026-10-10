package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: renamed from: com.bumptech.glide.load.resource.bitmap.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BitmapImageDecoderResourceDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0502d extends com.bumptech.glide.load.b.c<Bitmap> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.e f4671b = new com.bumptech.glide.load.engine.a.f();

    @Override // com.bumptech.glide.load.b.c
    protected com.bumptech.glide.load.engine.C<Bitmap> a(ImageDecoder.Source source, int i, int i2, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException {
        Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(source, onHeaderDecodedListener);
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            Log.v("BitmapImageDecoder", "Decoded [" + bitmapDecodeBitmap.getWidth() + "x" + bitmapDecodeBitmap.getHeight() + "] for [" + i + "x" + i2 + "]");
        }
        return new C0503e(bitmapDecodeBitmap, this.f4671b);
    }
}
