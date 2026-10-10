package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.e.l;
import com.bumptech.glide.load.engine.C;
import com.bumptech.glide.load.o;
import com.bumptech.glide.load.resource.bitmap.C0503e;
import java.security.MessageDigest;

/* JADX INFO: compiled from: GifDrawableTransformation.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements o<GifDrawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o<Bitmap> f4735a;

    public e(o<Bitmap> oVar) {
        l.a(oVar);
        this.f4735a = oVar;
    }

    @Override // com.bumptech.glide.load.h
    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f4735a.equals(((e) obj).f4735a);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.h
    public int hashCode() {
        return this.f4735a.hashCode();
    }

    @Override // com.bumptech.glide.load.o
    public C<GifDrawable> transform(Context context, C<GifDrawable> c2, int i, int i2) {
        GifDrawable gifDrawable = c2.get();
        C<Bitmap> c0503e = new C0503e(gifDrawable.c(), com.bumptech.glide.c.a(context).c());
        C<Bitmap> cTransform = this.f4735a.transform(context, c0503e, i, i2);
        if (!c0503e.equals(cTransform)) {
            c0503e.recycle();
        }
        gifDrawable.a(this.f4735a, cTransform.get());
        return c2;
    }

    @Override // com.bumptech.glide.load.h
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.f4735a.updateDiskCacheKey(messageDigest);
    }
}
