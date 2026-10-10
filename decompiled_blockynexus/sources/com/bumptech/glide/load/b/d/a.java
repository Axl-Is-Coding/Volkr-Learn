package com.bumptech.glide.load.b.d;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.C;
import com.bumptech.glide.load.l;
import java.io.ByteArrayOutputStream;

/* JADX INFO: compiled from: BitmapBytesTranscoder.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements e<Bitmap, byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bitmap.CompressFormat f4341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f4342b;

    public a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    @Override // com.bumptech.glide.load.b.d.e
    public C<byte[]> a(C<Bitmap> c2, l lVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        c2.get().compress(this.f4341a, this.f4342b, byteArrayOutputStream);
        c2.recycle();
        return new com.bumptech.glide.load.b.a.b(byteArrayOutputStream.toByteArray());
    }

    public a(Bitmap.CompressFormat compressFormat, int i) {
        this.f4341a = compressFormat;
        this.f4342b = i;
    }
}
