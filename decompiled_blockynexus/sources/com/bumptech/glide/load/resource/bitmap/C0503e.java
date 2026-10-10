package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;

/* JADX INFO: renamed from: com.bumptech.glide.load.resource.bitmap.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BitmapResource.java */
/* JADX INFO: loaded from: classes.dex */
public class C0503e implements com.bumptech.glide.load.engine.C<Bitmap>, com.bumptech.glide.load.engine.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bitmap f4672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.e f4673b;

    public C0503e(Bitmap bitmap, com.bumptech.glide.load.engine.a.e eVar) {
        com.bumptech.glide.e.l.a(bitmap, "Bitmap must not be null");
        this.f4672a = bitmap;
        com.bumptech.glide.e.l.a(eVar, "BitmapPool must not be null");
        this.f4673b = eVar;
    }

    public static C0503e a(Bitmap bitmap, com.bumptech.glide.load.engine.a.e eVar) {
        if (bitmap == null) {
            return null;
        }
        return new C0503e(bitmap, eVar);
    }

    @Override // com.bumptech.glide.load.engine.C
    public int getSize() {
        return com.bumptech.glide.e.n.a(this.f4672a);
    }

    @Override // com.bumptech.glide.load.engine.x
    public void initialize() {
        this.f4672a.prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.C
    public void recycle() {
        this.f4673b.a(this.f4672a);
    }

    @Override // com.bumptech.glide.load.engine.C
    public Class<Bitmap> a() {
        return Bitmap.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.engine.C
    public Bitmap get() {
        return this.f4672a;
    }
}
