package com.bumptech.glide.load;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/* JADX INFO: compiled from: Key.java */
/* JADX INFO: loaded from: classes.dex */
public interface h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f4628a = Charset.forName("UTF-8");

    boolean equals(Object obj);

    int hashCode();

    void updateDiskCacheKey(MessageDigest messageDigest);
}
