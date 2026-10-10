package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;

/* JADX INFO: renamed from: com.bumptech.glide.load.engine.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DataFetcherGenerator.java */
/* JADX INFO: loaded from: classes.dex */
interface InterfaceC0497g {

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.g$a */
    /* JADX INFO: compiled from: DataFetcherGenerator.java */
    public interface a {
        void a(com.bumptech.glide.load.h hVar, Exception exc, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource);

        void a(com.bumptech.glide.load.h hVar, Object obj, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource, com.bumptech.glide.load.h hVar2);

        void c();
    }

    boolean a();

    void cancel();
}
