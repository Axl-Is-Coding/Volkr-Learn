package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

/* JADX INFO: compiled from: LazyBitmapDrawableResource.java */
/* JADX INFO: loaded from: classes.dex */
public final class v implements com.bumptech.glide.load.engine.C<BitmapDrawable>, com.bumptech.glide.load.engine.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Resources f4702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.C<Bitmap> f4703b;

    private v(Resources resources, com.bumptech.glide.load.engine.C<Bitmap> c2) {
        com.bumptech.glide.e.l.a(resources);
        this.f4702a = resources;
        com.bumptech.glide.e.l.a(c2);
        this.f4703b = c2;
    }

    public static com.bumptech.glide.load.engine.C<BitmapDrawable> a(Resources resources, com.bumptech.glide.load.engine.C<Bitmap> c2) {
        if (c2 == null) {
            return null;
        }
        return new v(resources, c2);
    }

    @Override // com.bumptech.glide.load.engine.C
    public int getSize() {
        return this.f4703b.getSize();
    }

    @Override // com.bumptech.glide.load.engine.x
    public void initialize() {
        com.bumptech.glide.load.engine.C<Bitmap> c2 = this.f4703b;
        if (c2 instanceof com.bumptech.glide.load.engine.x) {
            ((com.bumptech.glide.load.engine.x) c2).initialize();
        }
    }

    @Override // com.bumptech.glide.load.engine.C
    public void recycle() {
        this.f4703b.recycle();
    }

    @Override // com.bumptech.glide.load.engine.C
    public Class<BitmapDrawable> a() {
        return BitmapDrawable.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.engine.C
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f4702a, this.f4703b.get());
    }
}
