package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.C;
import com.bumptech.glide.load.l;
import com.bumptech.glide.load.m;
import com.bumptech.glide.load.resource.bitmap.C0503e;

/* JADX INFO: compiled from: GifFrameResourceDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public final class f implements m<com.bumptech.glide.gifdecoder.a, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.e f4736a;

    public f(com.bumptech.glide.load.engine.a.e eVar) {
        this.f4736a = eVar;
    }

    @Override // com.bumptech.glide.load.m
    public boolean a(com.bumptech.glide.gifdecoder.a aVar, l lVar) {
        return true;
    }

    @Override // com.bumptech.glide.load.m
    public C<Bitmap> a(com.bumptech.glide.gifdecoder.a aVar, int i, int i2, l lVar) {
        return C0503e.a(aVar.a(), this.f4736a);
    }
}
