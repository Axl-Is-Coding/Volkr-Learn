package com.bumptech.glide.load.a;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.a.u;
import io.rong.common.LibStorageUtils;
import java.io.InputStream;

/* JADX INFO: renamed from: com.bumptech.glide.load.a.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AssetUriLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class C0486a<Data> implements u<Uri, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f4225a = 22;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AssetManager f4226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InterfaceC0056a<Data> f4227c;

    /* JADX INFO: renamed from: com.bumptech.glide.load.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AssetUriLoader.java */
    public interface InterfaceC0056a<Data> {
        com.bumptech.glide.load.data.d<Data> a(AssetManager assetManager, String str);
    }

    /* JADX INFO: renamed from: com.bumptech.glide.load.a.a$b */
    /* JADX INFO: compiled from: AssetUriLoader.java */
    public static class b implements v<Uri, ParcelFileDescriptor>, InterfaceC0056a<ParcelFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AssetManager f4228a;

        public b(AssetManager assetManager) {
            this.f4228a = assetManager;
        }

        @Override // com.bumptech.glide.load.a.C0486a.InterfaceC0056a
        public com.bumptech.glide.load.data.d<ParcelFileDescriptor> a(AssetManager assetManager, String str) {
            return new com.bumptech.glide.load.data.i(assetManager, str);
        }

        @Override // com.bumptech.glide.load.a.v
        public u<Uri, ParcelFileDescriptor> build(y yVar) {
            return new C0486a(this.f4228a, this);
        }
    }

    /* JADX INFO: renamed from: com.bumptech.glide.load.a.a$c */
    /* JADX INFO: compiled from: AssetUriLoader.java */
    public static class c implements v<Uri, InputStream>, InterfaceC0056a<InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AssetManager f4229a;

        public c(AssetManager assetManager) {
            this.f4229a = assetManager;
        }

        @Override // com.bumptech.glide.load.a.C0486a.InterfaceC0056a
        public com.bumptech.glide.load.data.d<InputStream> a(AssetManager assetManager, String str) {
            return new com.bumptech.glide.load.data.n(assetManager, str);
        }

        @Override // com.bumptech.glide.load.a.v
        public u<Uri, InputStream> build(y yVar) {
            return new C0486a(this.f4229a, this);
        }
    }

    public C0486a(AssetManager assetManager, InterfaceC0056a<Data> interfaceC0056a) {
        this.f4226b = assetManager;
        this.f4227c = interfaceC0056a;
    }

    @Override // com.bumptech.glide.load.a.u
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public u.a<Data> buildLoadData(Uri uri, int i, int i2, com.bumptech.glide.load.l lVar) {
        return new u.a<>(new com.bumptech.glide.d.d(uri), this.f4227c.a(this.f4226b, uri.toString().substring(f4225a)));
    }

    @Override // com.bumptech.glide.load.a.u
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean handles(Uri uri) {
        return LibStorageUtils.FILE.equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }
}
