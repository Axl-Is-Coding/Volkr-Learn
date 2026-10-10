package com.bumptech.glide.load.a;

import android.net.Uri;
import com.bumptech.glide.load.a.u;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: UrlUriLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class E<Data> implements u<Uri, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<String> f4223a = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u<l, Data> f4224b;

    /* JADX INFO: compiled from: UrlUriLoader.java */
    public static class a implements v<Uri, InputStream> {
        @Override // com.bumptech.glide.load.a.v
        public u<Uri, InputStream> build(y yVar) {
            return new E(yVar.a(l.class, InputStream.class));
        }
    }

    public E(u<l, Data> uVar) {
        this.f4224b = uVar;
    }

    @Override // com.bumptech.glide.load.a.u
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public u.a<Data> buildLoadData(Uri uri, int i, int i2, com.bumptech.glide.load.l lVar) {
        return this.f4224b.buildLoadData(new l(uri.toString()), i, i2, lVar);
    }

    @Override // com.bumptech.glide.load.a.u
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean handles(Uri uri) {
        return f4223a.contains(uri.getScheme());
    }
}
