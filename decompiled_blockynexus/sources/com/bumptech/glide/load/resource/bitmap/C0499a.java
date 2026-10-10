package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import java.io.IOException;

/* JADX INFO: renamed from: com.bumptech.glide.load.resource.bitmap.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BitmapDrawableDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class C0499a<DataType> implements com.bumptech.glide.load.m<DataType, BitmapDrawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.m<DataType, Bitmap> f4664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Resources f4665b;

    public C0499a(Resources resources, com.bumptech.glide.load.m<DataType, Bitmap> mVar) {
        com.bumptech.glide.e.l.a(resources);
        this.f4665b = resources;
        com.bumptech.glide.e.l.a(mVar);
        this.f4664a = mVar;
    }

    @Override // com.bumptech.glide.load.m
    public boolean a(DataType datatype, com.bumptech.glide.load.l lVar) throws IOException {
        return this.f4664a.a(datatype, lVar);
    }

    @Override // com.bumptech.glide.load.m
    public com.bumptech.glide.load.engine.C<BitmapDrawable> a(DataType datatype, int i, int i2, com.bumptech.glide.load.l lVar) throws IOException {
        return v.a(this.f4665b, this.f4664a.a(datatype, i, i2, lVar));
    }
}
