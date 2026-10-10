package com.bumptech.glide.load.a.a;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.a.u;
import com.bumptech.glide.load.a.v;
import com.bumptech.glide.load.a.y;
import com.bumptech.glide.load.l;
import java.io.InputStream;

/* JADX INFO: compiled from: MediaStoreImageThumbLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements u<Uri, InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4235a;

    /* JADX INFO: compiled from: MediaStoreImageThumbLoader.java */
    public static class a implements v<Uri, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f4236a;

        public a(Context context) {
            this.f4236a = context;
        }

        @Override // com.bumptech.glide.load.a.v
        public u<Uri, InputStream> build(y yVar) {
            return new c(this.f4236a);
        }
    }

    public c(Context context) {
        this.f4235a = context.getApplicationContext();
    }

    @Override // com.bumptech.glide.load.a.u
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public u.a<InputStream> buildLoadData(Uri uri, int i, int i2, l lVar) {
        if (com.bumptech.glide.load.data.a.b.a(i, i2)) {
            return new u.a<>(new com.bumptech.glide.d.d(uri), com.bumptech.glide.load.data.a.c.a(this.f4235a, uri));
        }
        return null;
    }

    @Override // com.bumptech.glide.load.a.u
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean handles(Uri uri) {
        return com.bumptech.glide.load.data.a.b.a(uri);
    }
}
