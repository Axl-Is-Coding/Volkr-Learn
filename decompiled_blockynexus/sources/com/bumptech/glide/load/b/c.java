package com.bumptech.glide.load.b;

import android.graphics.ImageDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.engine.C;
import com.bumptech.glide.load.l;
import com.bumptech.glide.load.m;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.s;
import java.io.IOException;

/* JADX INFO: compiled from: ImageDecoderResourceDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c<T> implements m<ImageDecoder.Source, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final s f4339a = s.a();

    protected abstract C<T> a(ImageDecoder.Source source, int i, int i2, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException;

    @Override // com.bumptech.glide.load.m
    public final boolean a(ImageDecoder.Source source, l lVar) {
        return true;
    }

    @Override // com.bumptech.glide.load.m
    public final C<T> a(ImageDecoder.Source source, int i, int i2, l lVar) throws IOException {
        return a(source, i, i2, new b(this, i, i2, lVar.a(com.bumptech.glide.load.resource.bitmap.m.f4683e) != null && ((Boolean) lVar.a(com.bumptech.glide.load.resource.bitmap.m.f4683e)).booleanValue(), (DecodeFormat) lVar.a(com.bumptech.glide.load.resource.bitmap.m.f4679a), (DownsampleStrategy) lVar.a(DownsampleStrategy.h), (PreferredColorSpace) lVar.a(com.bumptech.glide.load.resource.bitmap.m.f4680b)));
    }
}
