package com.bumptech.glide.load.a.a;

import android.net.Uri;
import com.bumptech.glide.load.a.l;
import com.bumptech.glide.load.a.u;
import com.bumptech.glide.load.a.v;
import com.bumptech.glide.load.a.y;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: HttpUriLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements u<Uri, InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<String> f4233a = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u<l, InputStream> f4234b;

    /* JADX INFO: compiled from: HttpUriLoader.java */
    public static class a implements v<Uri, InputStream> {
        @Override // com.bumptech.glide.load.a.v
        public u<Uri, InputStream> build(y yVar) {
            return new b(yVar.a(l.class, InputStream.class));
        }
    }

    public b(u<l, InputStream> uVar) {
        this.f4234b = uVar;
    }

    @Override // com.bumptech.glide.load.a.u
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public u.a<InputStream> buildLoadData(Uri uri, int i, int i2, com.bumptech.glide.load.l lVar) {
        return this.f4234b.buildLoadData(new l(uri.toString()), i, i2, lVar);
    }

    @Override // com.bumptech.glide.load.a.u
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean handles(Uri uri) {
        return f4233a.contains(uri.getScheme());
    }
}
