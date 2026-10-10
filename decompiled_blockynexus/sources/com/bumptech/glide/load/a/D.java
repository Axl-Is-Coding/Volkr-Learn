package com.bumptech.glide.load.a;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.a.u;
import io.rong.common.LibStorageUtils;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: UriLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class D<Data> implements u<Uri, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<String> f4218a = Collections.unmodifiableSet(new HashSet(Arrays.asList(LibStorageUtils.FILE, "android.resource", "content")));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c<Data> f4219b;

    /* JADX INFO: compiled from: UriLoader.java */
    public static final class a implements v<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentResolver f4220a;

        public a(ContentResolver contentResolver) {
            this.f4220a = contentResolver;
        }

        @Override // com.bumptech.glide.load.a.D.c
        public com.bumptech.glide.load.data.d<AssetFileDescriptor> a(Uri uri) {
            return new com.bumptech.glide.load.data.a(this.f4220a, uri);
        }

        @Override // com.bumptech.glide.load.a.v
        public u<Uri, AssetFileDescriptor> build(y yVar) {
            return new D(this);
        }
    }

    /* JADX INFO: compiled from: UriLoader.java */
    public static class b implements v<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentResolver f4221a;

        public b(ContentResolver contentResolver) {
            this.f4221a = contentResolver;
        }

        @Override // com.bumptech.glide.load.a.D.c
        public com.bumptech.glide.load.data.d<ParcelFileDescriptor> a(Uri uri) {
            return new com.bumptech.glide.load.data.j(this.f4221a, uri);
        }

        @Override // com.bumptech.glide.load.a.v
        public u<Uri, ParcelFileDescriptor> build(y yVar) {
            return new D(this);
        }
    }

    /* JADX INFO: compiled from: UriLoader.java */
    public interface c<Data> {
        com.bumptech.glide.load.data.d<Data> a(Uri uri);
    }

    /* JADX INFO: compiled from: UriLoader.java */
    public static class d implements v<Uri, InputStream>, c<InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentResolver f4222a;

        public d(ContentResolver contentResolver) {
            this.f4222a = contentResolver;
        }

        @Override // com.bumptech.glide.load.a.D.c
        public com.bumptech.glide.load.data.d<InputStream> a(Uri uri) {
            return new com.bumptech.glide.load.data.o(this.f4222a, uri);
        }

        @Override // com.bumptech.glide.load.a.v
        public u<Uri, InputStream> build(y yVar) {
            return new D(this);
        }
    }

    public D(c<Data> cVar) {
        this.f4219b = cVar;
    }

    @Override // com.bumptech.glide.load.a.u
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public u.a<Data> buildLoadData(Uri uri, int i, int i2, com.bumptech.glide.load.l lVar) {
        return new u.a<>(new com.bumptech.glide.d.d(uri), this.f4219b.a(uri));
    }

    @Override // com.bumptech.glide.load.a.u
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean handles(Uri uri) {
        return f4218a.contains(uri.getScheme());
    }
}
