package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: UnitBitmapDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class A implements com.bumptech.glide.load.m<Bitmap, Bitmap> {

    /* JADX INFO: compiled from: UnitBitmapDecoder.java */
    private static final class a implements com.bumptech.glide.load.engine.C<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Bitmap f4636a;

        a(Bitmap bitmap) {
            this.f4636a = bitmap;
        }

        @Override // com.bumptech.glide.load.engine.C
        public Class<Bitmap> a() {
            return Bitmap.class;
        }

        @Override // com.bumptech.glide.load.engine.C
        public int getSize() {
            return com.bumptech.glide.e.n.a(this.f4636a);
        }

        @Override // com.bumptech.glide.load.engine.C
        public void recycle() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.load.engine.C
        public Bitmap get() {
            return this.f4636a;
        }
    }

    @Override // com.bumptech.glide.load.m
    public boolean a(Bitmap bitmap, com.bumptech.glide.load.l lVar) {
        return true;
    }

    @Override // com.bumptech.glide.load.m
    public com.bumptech.glide.load.engine.C<Bitmap> a(Bitmap bitmap, int i, int i2, com.bumptech.glide.load.l lVar) {
        return new a(bitmap);
    }
}
