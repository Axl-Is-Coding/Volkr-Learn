package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import java.security.MessageDigest;

/* JADX INFO: compiled from: FitCenter.java */
/* JADX INFO: loaded from: classes.dex */
public class r extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f4688a = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(com.bumptech.glide.load.h.f4628a);

    @Override // com.bumptech.glide.load.resource.bitmap.f
    protected Bitmap a(com.bumptech.glide.load.engine.a.e eVar, Bitmap bitmap, int i, int i2) {
        return z.d(eVar, bitmap, i, i2);
    }

    @Override // com.bumptech.glide.load.h
    public boolean equals(Object obj) {
        return obj instanceof r;
    }

    @Override // com.bumptech.glide.load.h
    public int hashCode() {
        return "com.bumptech.glide.load.resource.bitmap.FitCenter".hashCode();
    }

    @Override // com.bumptech.glide.load.h
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(f4688a);
    }
}
