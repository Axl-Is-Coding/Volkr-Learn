package com.bumptech.glide.load.engine.b;

import android.content.Context;
import com.bumptech.glide.load.engine.b.d;
import java.io.File;

/* JADX INFO: compiled from: InternalCacheDiskCacheFactory.java */
/* JADX INFO: loaded from: classes.dex */
class f implements d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f4517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f4518b;

    f(Context context, String str) {
        this.f4517a = context;
        this.f4518b = str;
    }

    @Override // com.bumptech.glide.load.engine.b.d.a
    public File a() {
        File cacheDir = this.f4517a.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = this.f4518b;
        return str != null ? new File(cacheDir, str) : cacheDir;
    }
}
