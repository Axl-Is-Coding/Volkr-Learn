package com.bumptech.glide.load.b.b;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.C;

/* JADX INFO: compiled from: NonOwnedDrawableResource.java */
/* JADX INFO: loaded from: classes.dex */
final class c extends b<Drawable> {
    private c(Drawable drawable) {
        super(drawable);
    }

    static C<Drawable> a(Drawable drawable) {
        if (drawable != null) {
            return new c(drawable);
        }
        return null;
    }

    @Override // com.bumptech.glide.load.engine.C
    public int getSize() {
        return Math.max(1, this.f4337a.getIntrinsicWidth() * this.f4337a.getIntrinsicHeight() * 4);
    }

    @Override // com.bumptech.glide.load.engine.C
    public void recycle() {
    }

    @Override // com.bumptech.glide.load.engine.C
    public Class<Drawable> a() {
        return this.f4337a.getClass();
    }
}
