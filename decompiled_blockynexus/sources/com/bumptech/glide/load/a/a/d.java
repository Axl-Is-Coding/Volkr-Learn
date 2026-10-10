package com.bumptech.glide.load.a.a;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.a.u;
import com.bumptech.glide.load.a.v;
import com.bumptech.glide.load.a.y;
import com.bumptech.glide.load.l;
import com.bumptech.glide.load.resource.bitmap.D;
import java.io.InputStream;

/* JADX INFO: compiled from: MediaStoreVideoThumbLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements u<Uri, InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4237a;

    /* JADX INFO: compiled from: MediaStoreVideoThumbLoader.java */
    public static class a implements v<Uri, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f4238a;

        public a(Context context) {
            this.f4238a = context;
        }

        @Override // com.bumptech.glide.load.a.v
        public u<Uri, InputStream> build(y yVar) {
            return new d(this.f4238a);
        }
    }

    public d(Context context) {
        this.f4237a = context.getApplicationContext();
    }

    @Override // com.bumptech.glide.load.a.u
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public u.a<InputStream> buildLoadData(Uri uri, int i, int i2, l lVar) {
        if (com.bumptech.glide.load.data.a.b.a(i, i2) && a(lVar)) {
            return new u.a<>(new com.bumptech.glide.d.d(uri), com.bumptech.glide.load.data.a.c.b(this.f4237a, uri));
        }
        return null;
    }

    private boolean a(l lVar) {
        Long l = (Long) lVar.a(D.f4639a);
        return l != null && l.longValue() == -1;
    }

    @Override // com.bumptech.glide.load.a.u
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean handles(Uri uri) {
        return com.bumptech.glide.load.data.a.b.c(uri);
    }
}
