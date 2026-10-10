package com.bumptech.glide.d;

import com.bumptech.glide.load.h;
import java.security.MessageDigest;

/* JADX INFO: compiled from: EmptySignature.java */
/* JADX INFO: loaded from: classes.dex */
public final class c implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f4140a = new c();

    private c() {
    }

    public static c a() {
        return f4140a;
    }

    public String toString() {
        return "EmptySignature";
    }

    @Override // com.bumptech.glide.load.h
    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }
}
