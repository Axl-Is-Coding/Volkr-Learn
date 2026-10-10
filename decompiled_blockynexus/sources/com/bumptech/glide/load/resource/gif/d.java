package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.load.engine.x;

/* JADX INFO: compiled from: GifDrawableResource.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends com.bumptech.glide.load.b.b.b<GifDrawable> implements x {
    public d(GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    @Override // com.bumptech.glide.load.engine.C
    public Class<GifDrawable> a() {
        return GifDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.C
    public int getSize() {
        return ((GifDrawable) this.f4337a).f();
    }

    @Override // com.bumptech.glide.load.b.b.b, com.bumptech.glide.load.engine.x
    public void initialize() {
        ((GifDrawable) this.f4337a).c().prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.C
    public void recycle() {
        ((GifDrawable) this.f4337a).stop();
        ((GifDrawable) this.f4337a).g();
    }
}
