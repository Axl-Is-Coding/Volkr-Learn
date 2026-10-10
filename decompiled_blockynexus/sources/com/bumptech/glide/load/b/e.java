package com.bumptech.glide.load.b;

import android.content.Context;
import com.bumptech.glide.load.engine.C;
import com.bumptech.glide.load.o;
import java.security.MessageDigest;

/* JADX INFO: compiled from: UnitTransformation.java */
/* JADX INFO: loaded from: classes.dex */
public final class e<T> implements o<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final o<?> f4352a = new e();

    private e() {
    }

    public static <T> e<T> a() {
        return (e) f4352a;
    }

    @Override // com.bumptech.glide.load.o
    public C<T> transform(Context context, C<T> c2, int i, int i2) {
        return c2;
    }

    @Override // com.bumptech.glide.load.h
    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }
}
