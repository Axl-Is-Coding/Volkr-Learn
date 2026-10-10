package com.bumptech.glide.load.b.d;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.e.l;
import com.bumptech.glide.load.engine.C;
import com.bumptech.glide.load.resource.bitmap.v;

/* JADX INFO: compiled from: BitmapDrawableTranscoder.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements e<Bitmap, BitmapDrawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Resources f4343a;

    public b(Resources resources) {
        l.a(resources);
        this.f4343a = resources;
    }

    @Override // com.bumptech.glide.load.b.d.e
    public C<BitmapDrawable> a(C<Bitmap> c2, com.bumptech.glide.load.l lVar) {
        return v.a(this.f4343a, c2);
    }
}
