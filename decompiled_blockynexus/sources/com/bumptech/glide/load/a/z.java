package com.bumptech.glide.load.a;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.a.u;
import java.io.InputStream;

/* JADX INFO: compiled from: ResourceLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class z<Data> implements u<Integer, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u<Uri, Data> f4320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Resources f4321b;

    /* JADX INFO: compiled from: ResourceLoader.java */
    public static final class a implements v<Integer, AssetFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Resources f4322a;

        public a(Resources resources) {
            this.f4322a = resources;
        }

        @Override // com.bumptech.glide.load.a.v
        public u<Integer, AssetFileDescriptor> build(y yVar) {
            return new z(this.f4322a, yVar.a(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* JADX INFO: compiled from: ResourceLoader.java */
    public static class b implements v<Integer, ParcelFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Resources f4323a;

        public b(Resources resources) {
            this.f4323a = resources;
        }

        @Override // com.bumptech.glide.load.a.v
        public u<Integer, ParcelFileDescriptor> build(y yVar) {
            return new z(this.f4323a, yVar.a(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* JADX INFO: compiled from: ResourceLoader.java */
    public static class c implements v<Integer, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Resources f4324a;

        public c(Resources resources) {
            this.f4324a = resources;
        }

        @Override // com.bumptech.glide.load.a.v
        public u<Integer, InputStream> build(y yVar) {
            return new z(this.f4324a, yVar.a(Uri.class, InputStream.class));
        }
    }

    /* JADX INFO: compiled from: ResourceLoader.java */
    public static class d implements v<Integer, Uri> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Resources f4325a;

        public d(Resources resources) {
            this.f4325a = resources;
        }

        @Override // com.bumptech.glide.load.a.v
        public u<Integer, Uri> build(y yVar) {
            return new z(this.f4325a, C.a());
        }
    }

    public z(Resources resources, u<Uri, Data> uVar) {
        this.f4321b = resources;
        this.f4320a = uVar;
    }

    private Uri b(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f4321b.getResourcePackageName(num.intValue()) + '/' + this.f4321b.getResourceTypeName(num.intValue()) + '/' + this.f4321b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e2) {
            if (!Log.isLoggable("ResourceLoader", 5)) {
                return null;
            }
            Log.w("ResourceLoader", "Received invalid resource id: " + num, e2);
            return null;
        }
    }

    @Override // com.bumptech.glide.load.a.u
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public u.a<Data> buildLoadData(Integer num, int i, int i2, com.bumptech.glide.load.l lVar) {
        Uri uriB = b(num);
        if (uriB == null) {
            return null;
        }
        return this.f4320a.buildLoadData(uriB, i, i2, lVar);
    }

    @Override // com.bumptech.glide.load.a.u
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean handles(Integer num) {
        return true;
    }
}
