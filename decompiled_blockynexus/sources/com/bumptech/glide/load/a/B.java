package com.bumptech.glide.load.a;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.bumptech.glide.load.a.u;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: compiled from: StringLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class B<Data> implements u<String, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u<Uri, Data> f4214a;

    /* JADX INFO: compiled from: StringLoader.java */
    public static final class a implements v<String, AssetFileDescriptor> {
        @Override // com.bumptech.glide.load.a.v
        public u<String, AssetFileDescriptor> build(y yVar) {
            return new B(yVar.a(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* JADX INFO: compiled from: StringLoader.java */
    public static class b implements v<String, ParcelFileDescriptor> {
        @Override // com.bumptech.glide.load.a.v
        public u<String, ParcelFileDescriptor> build(y yVar) {
            return new B(yVar.a(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* JADX INFO: compiled from: StringLoader.java */
    public static class c implements v<String, InputStream> {
        @Override // com.bumptech.glide.load.a.v
        public u<String, InputStream> build(y yVar) {
            return new B(yVar.a(Uri.class, InputStream.class));
        }
    }

    public B(u<Uri, Data> uVar) {
        this.f4214a = uVar;
    }

    private static Uri b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return c(str);
        }
        Uri uri = Uri.parse(str);
        return uri.getScheme() == null ? c(str) : uri;
    }

    private static Uri c(String str) {
        return Uri.fromFile(new File(str));
    }

    @Override // com.bumptech.glide.load.a.u
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public u.a<Data> buildLoadData(String str, int i, int i2, com.bumptech.glide.load.l lVar) {
        Uri uriB = b(str);
        if (uriB == null || !this.f4214a.handles(uriB)) {
            return null;
        }
        return this.f4214a.buildLoadData(uriB, i, i2, lVar);
    }

    @Override // com.bumptech.glide.load.a.u
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean handles(String str) {
        return true;
    }
}
