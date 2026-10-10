package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.EncodeStrategy;
import java.io.File;

/* JADX INFO: renamed from: com.bumptech.glide.load.resource.bitmap.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BitmapDrawableEncoder.java */
/* JADX INFO: loaded from: classes.dex */
public class C0500b implements com.bumptech.glide.load.n<BitmapDrawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.e f4666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.n<Bitmap> f4667b;

    public C0500b(com.bumptech.glide.load.engine.a.e eVar, com.bumptech.glide.load.n<Bitmap> nVar) {
        this.f4666a = eVar;
        this.f4667b = nVar;
    }

    @Override // com.bumptech.glide.load.a
    public boolean a(com.bumptech.glide.load.engine.C<BitmapDrawable> c2, File file, com.bumptech.glide.load.l lVar) {
        return this.f4667b.a((Bitmap) new C0503e(c2.get().getBitmap(), this.f4666a), file, lVar);
    }

    @Override // com.bumptech.glide.load.n
    public EncodeStrategy a(com.bumptech.glide.load.l lVar) {
        return this.f4667b.a(lVar);
    }
}
