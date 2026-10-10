package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

/* JADX INFO: compiled from: DiskCacheStrategy.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f4581a = new k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p f4582b = new l();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final p f4583c = new m();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final p f4584d = new n();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final p f4585e = new o();

    public abstract boolean a();

    public abstract boolean a(DataSource dataSource);

    public abstract boolean a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy);

    public abstract boolean b();
}
