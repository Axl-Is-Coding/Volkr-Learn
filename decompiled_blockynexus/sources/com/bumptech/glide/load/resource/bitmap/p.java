package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.security.MessageDigest;

/* JADX INFO: compiled from: DrawableTransformation.java */
/* JADX INFO: loaded from: classes.dex */
public class p implements com.bumptech.glide.load.o<Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.o<Bitmap> f4686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f4687b;

    public p(com.bumptech.glide.load.o<Bitmap> oVar, boolean z) {
        this.f4686a = oVar;
        this.f4687b = z;
    }

    private com.bumptech.glide.load.engine.C<Drawable> a(Context context, com.bumptech.glide.load.engine.C<Bitmap> c2) {
        return v.a(context.getResources(), c2);
    }

    public com.bumptech.glide.load.o<BitmapDrawable> a() {
        return this;
    }

    @Override // com.bumptech.glide.load.h
    public boolean equals(Object obj) {
        if (obj instanceof p) {
            return this.f4686a.equals(((p) obj).f4686a);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.h
    public int hashCode() {
        return this.f4686a.hashCode();
    }

    @Override // com.bumptech.glide.load.o
    public com.bumptech.glide.load.engine.C<Drawable> transform(Context context, com.bumptech.glide.load.engine.C<Drawable> c2, int i, int i2) {
        com.bumptech.glide.load.engine.a.e eVarC = com.bumptech.glide.c.a(context).c();
        Drawable drawable = c2.get();
        com.bumptech.glide.load.engine.C<Bitmap> cA = o.a(eVarC, drawable, i, i2);
        if (cA != null) {
            com.bumptech.glide.load.engine.C<Bitmap> cTransform = this.f4686a.transform(context, cA, i, i2);
            if (!cTransform.equals(cA)) {
                return a(context, cTransform);
            }
            cTransform.recycle();
            return c2;
        }
        if (!this.f4687b) {
            return c2;
        }
        throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }

    @Override // com.bumptech.glide.load.h
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.f4686a.updateDiskCacheKey(messageDigest);
    }
}
