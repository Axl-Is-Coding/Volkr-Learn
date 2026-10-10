package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;

/* JADX INFO: compiled from: ResourceBitmapDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class x implements com.bumptech.glide.load.m<Uri, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.b.b.d f4705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.e f4706b;

    public x(com.bumptech.glide.load.b.b.d dVar, com.bumptech.glide.load.engine.a.e eVar) {
        this.f4705a = dVar;
        this.f4706b = eVar;
    }

    @Override // com.bumptech.glide.load.m
    public boolean a(Uri uri, com.bumptech.glide.load.l lVar) {
        return "android.resource".equals(uri.getScheme());
    }

    @Override // com.bumptech.glide.load.m
    public com.bumptech.glide.load.engine.C<Bitmap> a(Uri uri, int i, int i2, com.bumptech.glide.load.l lVar) {
        com.bumptech.glide.load.engine.C<Drawable> cA = this.f4705a.a(uri, i, i2, lVar);
        if (cA == null) {
            return null;
        }
        return o.a(this.f4706b, cA.get(), i, i2);
    }
}
