package com.bumptech.glide.load.engine.b;

import com.bumptech.glide.load.engine.b.a;
import java.io.File;

/* JADX INFO: compiled from: DiskLruCacheFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements a.InterfaceC0061a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f4510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f4511b;

    /* JADX INFO: compiled from: DiskLruCacheFactory.java */
    public interface a {
        File a();
    }

    public d(a aVar, long j) {
        this.f4510a = j;
        this.f4511b = aVar;
    }

    @Override // com.bumptech.glide.load.engine.b.a.InterfaceC0061a
    public com.bumptech.glide.load.engine.b.a build() {
        File fileA = this.f4511b.a();
        if (fileA == null) {
            return null;
        }
        if (fileA.mkdirs() || (fileA.exists() && fileA.isDirectory())) {
            return e.a(fileA, this.f4510a);
        }
        return null;
    }
}
