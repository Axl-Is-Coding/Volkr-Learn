package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

/* JADX INFO: compiled from: DiskCacheStrategy.java */
/* JADX INFO: loaded from: classes.dex */
class n extends p {
    n() {
    }

    @Override // com.bumptech.glide.load.engine.p
    public boolean a() {
        return false;
    }

    @Override // com.bumptech.glide.load.engine.p
    public boolean a(DataSource dataSource) {
        return false;
    }

    @Override // com.bumptech.glide.load.engine.p
    public boolean a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
        return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
    }

    @Override // com.bumptech.glide.load.engine.p
    public boolean b() {
        return true;
    }
}
