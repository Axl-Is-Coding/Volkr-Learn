package com.bumptech.glide.request;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.C;
import com.bumptech.glide.load.engine.GlideException;

/* JADX INFO: compiled from: ResourceCallback.java */
/* JADX INFO: loaded from: classes.dex */
public interface g {
    void a(C<?> c2, DataSource dataSource);

    void a(GlideException glideException);

    Object c();
}
