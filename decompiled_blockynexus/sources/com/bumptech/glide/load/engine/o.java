package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

/* JADX INFO: compiled from: DiskCacheStrategy.java */
/* JADX INFO: loaded from: classes.dex */
class o extends p {
    o() {
    }

    @Override // com.bumptech.glide.load.engine.p
    public boolean a() {
        return true;
    }

    @Override // com.bumptech.glide.load.engine.p
    public boolean a(DataSource dataSource) {
        return dataSource == DataSource.REMOTE;
    }

    @Override // com.bumptech.glide.load.engine.p
    public boolean b() {
        return true;
    }

    @Override // com.bumptech.glide.load.engine.p
    public boolean a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
        return ((z && dataSource == DataSource.DATA_DISK_CACHE) || dataSource == DataSource.LOCAL) && encodeStrategy == EncodeStrategy.TRANSFORMED;
    }
}
