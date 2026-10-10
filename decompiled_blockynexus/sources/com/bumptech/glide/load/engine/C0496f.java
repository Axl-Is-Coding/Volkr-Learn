package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.engine.b.a;
import java.io.File;

/* JADX INFO: renamed from: com.bumptech.glide.load.engine.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DataCacheWriter.java */
/* JADX INFO: loaded from: classes.dex */
class C0496f<DataType> implements a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.a<DataType> f4564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DataType f4565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.l f4566c;

    C0496f(com.bumptech.glide.load.a<DataType> aVar, DataType datatype, com.bumptech.glide.load.l lVar) {
        this.f4564a = aVar;
        this.f4565b = datatype;
        this.f4566c = lVar;
    }

    @Override // com.bumptech.glide.load.engine.b.a.b
    public boolean a(File file) {
        return this.f4564a.a(this.f4565b, file, this.f4566c);
    }
}
