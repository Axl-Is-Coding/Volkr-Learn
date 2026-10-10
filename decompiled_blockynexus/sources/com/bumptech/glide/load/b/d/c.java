package com.bumptech.glide.load.b.d;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.C;
import com.bumptech.glide.load.l;
import com.bumptech.glide.load.resource.bitmap.C0503e;
import com.bumptech.glide.load.resource.gif.GifDrawable;

/* JADX INFO: compiled from: DrawableBytesTranscoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class c implements e<Drawable, byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.e f4344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e<Bitmap, byte[]> f4345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e<GifDrawable, byte[]> f4346c;

    public c(com.bumptech.glide.load.engine.a.e eVar, e<Bitmap, byte[]> eVar2, e<GifDrawable, byte[]> eVar3) {
        this.f4344a = eVar;
        this.f4345b = eVar2;
        this.f4346c = eVar3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static C<GifDrawable> a(C<Drawable> c2) {
        return c2;
    }

    @Override // com.bumptech.glide.load.b.d.e
    public C<byte[]> a(C<Drawable> c2, l lVar) {
        Drawable drawable = c2.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f4345b.a(C0503e.a(((BitmapDrawable) drawable).getBitmap(), this.f4344a), lVar);
        }
        if (!(drawable instanceof GifDrawable)) {
            return null;
        }
        e<GifDrawable, byte[]> eVar = this.f4346c;
        a(c2);
        return eVar.a(c2, lVar);
    }
}
