package com.bumptech.glide.load.engine.b;

import java.io.File;

/* JADX INFO: compiled from: DiskCache.java */
/* JADX INFO: loaded from: classes.dex */
public interface a {

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DiskCache.java */
    public interface InterfaceC0061a {
        a build();
    }

    /* JADX INFO: compiled from: DiskCache.java */
    public interface b {
        boolean a(File file);
    }

    File a(com.bumptech.glide.load.h hVar);

    void a(com.bumptech.glide.load.h hVar, b bVar);

    void clear();
}
