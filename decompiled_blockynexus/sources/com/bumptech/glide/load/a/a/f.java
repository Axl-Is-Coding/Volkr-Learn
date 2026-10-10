package com.bumptech.glide.load.a.a;

import com.bumptech.glide.load.a.l;
import com.bumptech.glide.load.a.u;
import com.bumptech.glide.load.a.v;
import com.bumptech.glide.load.a.y;
import java.io.InputStream;
import java.net.URL;

/* JADX INFO: compiled from: UrlLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements u<URL, InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u<l, InputStream> f4251a;

    /* JADX INFO: compiled from: UrlLoader.java */
    public static class a implements v<URL, InputStream> {
        @Override // com.bumptech.glide.load.a.v
        public u<URL, InputStream> build(y yVar) {
            return new f(yVar.a(l.class, InputStream.class));
        }
    }

    public f(u<l, InputStream> uVar) {
        this.f4251a = uVar;
    }

    @Override // com.bumptech.glide.load.a.u
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public u.a<InputStream> buildLoadData(URL url, int i, int i2, com.bumptech.glide.load.l lVar) {
        return this.f4251a.buildLoadData(new l(url), i, i2, lVar);
    }

    @Override // com.bumptech.glide.load.a.u
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean handles(URL url) {
        return true;
    }
}
