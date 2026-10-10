package com.bumptech.glide.load.data.a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.h;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: ThumbFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements com.bumptech.glide.load.data.d<InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f4358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f4359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private InputStream f4360c;

    /* JADX INFO: compiled from: ThumbFetcher.java */
    static class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String[] f4361a = {"_data"};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ContentResolver f4362b;

        a(ContentResolver contentResolver) {
            this.f4362b = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.a.d
        public Cursor a(Uri uri) {
            return this.f4362b.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f4361a, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* JADX INFO: compiled from: ThumbFetcher.java */
    static class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String[] f4363a = {"_data"};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ContentResolver f4364b;

        b(ContentResolver contentResolver) {
            this.f4364b = contentResolver;
        }

        @Override // com.bumptech.glide.load.data.a.d
        public Cursor a(Uri uri) {
            return this.f4364b.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f4363a, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    c(Uri uri, e eVar) {
        this.f4358a = uri;
        this.f4359b = eVar;
    }

    public static c a(Context context, Uri uri) {
        return a(context, uri, new a(context.getContentResolver()));
    }

    public static c b(Context context, Uri uri) {
        return a(context, uri, new b(context.getContentResolver()));
    }

    private InputStream d() throws Throwable {
        InputStream inputStreamB = this.f4359b.b(this.f4358a);
        int iA = inputStreamB != null ? this.f4359b.a(this.f4358a) : -1;
        return iA != -1 ? new h(inputStreamB, iA) : inputStreamB;
    }

    @Override // com.bumptech.glide.load.data.d
    public DataSource c() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
    }

    private static c a(Context context, Uri uri, d dVar) {
        return new c(uri, new e(com.bumptech.glide.c.a(context).g().a(), dVar, com.bumptech.glide.c.a(context).b(), context.getContentResolver()));
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        InputStream inputStream = this.f4360c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public void a(Priority priority, d.a<? super InputStream> aVar) {
        try {
            this.f4360c = d();
            aVar.a(this.f4360c);
        } catch (FileNotFoundException e2) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e2);
            }
            aVar.a((Exception) e2);
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public Class<InputStream> a() {
        return InputStream.class;
    }
}
