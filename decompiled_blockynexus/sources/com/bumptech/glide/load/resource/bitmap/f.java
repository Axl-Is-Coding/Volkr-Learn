package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;

/* JADX INFO: compiled from: BitmapTransformation.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class f implements com.bumptech.glide.load.o<Bitmap> {
    protected abstract Bitmap a(com.bumptech.glide.load.engine.a.e eVar, Bitmap bitmap, int i, int i2);

    @Override // com.bumptech.glide.load.o
    public final com.bumptech.glide.load.engine.C<Bitmap> transform(Context context, com.bumptech.glide.load.engine.C<Bitmap> c2, int i, int i2) {
        if (!com.bumptech.glide.e.n.b(i, i2)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        com.bumptech.glide.load.engine.a.e eVarC = com.bumptech.glide.c.a(context).c();
        Bitmap bitmap = c2.get();
        if (i == Integer.MIN_VALUE) {
            i = bitmap.getWidth();
        }
        if (i2 == Integer.MIN_VALUE) {
            i2 = bitmap.getHeight();
        }
        Bitmap bitmapA = a(eVarC, bitmap, i, i2);
        return bitmap.equals(bitmapA) ? c2 : C0503e.a(bitmapA, eVarC);
    }
}
