package com.bumptech.glide.load.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.u;
import com.bumptech.glide.load.data.d;
import java.io.File;
import java.io.FileNotFoundException;

/* JADX INFO: compiled from: MediaStoreFileLoader.java */
/* JADX INFO: loaded from: classes.dex */
public final class q implements u<Uri, File> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4285a;

    /* JADX INFO: compiled from: MediaStoreFileLoader.java */
    public static final class a implements v<Uri, File> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f4286a;

        public a(Context context) {
            this.f4286a = context;
        }

        @Override // com.bumptech.glide.load.a.v
        public u<Uri, File> build(y yVar) {
            return new q(this.f4286a);
        }
    }

    public q(Context context) {
        this.f4285a = context;
    }

    @Override // com.bumptech.glide.load.a.u
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public u.a<File> buildLoadData(Uri uri, int i, int i2, com.bumptech.glide.load.l lVar) {
        return new u.a<>(new com.bumptech.glide.d.d(uri), new b(this.f4285a, uri));
    }

    @Override // com.bumptech.glide.load.a.u
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean handles(Uri uri) {
        return com.bumptech.glide.load.data.a.b.b(uri);
    }

    /* JADX INFO: compiled from: MediaStoreFileLoader.java */
    private static class b implements com.bumptech.glide.load.data.d<File> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String[] f4287a = {"_data"};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Context f4288b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Uri f4289c;

        b(Context context, Uri uri) {
            this.f4288b = context;
            this.f4289c = uri;
        }

        @Override // com.bumptech.glide.load.data.d
        public void a(Priority priority, d.a<? super File> aVar) {
            Cursor cursorQuery = this.f4288b.getContentResolver().query(this.f4289c, f4287a, null, null, null);
            if (cursorQuery != null) {
                try {
                    string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")) : null;
                } finally {
                    cursorQuery.close();
                }
            }
            if (!TextUtils.isEmpty(string)) {
                aVar.a(new File(string));
                return;
            }
            aVar.a((Exception) new FileNotFoundException("Failed to find file path for: " + this.f4289c));
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.d
        public DataSource c() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.d
        public Class<File> a() {
            return File.class;
        }
    }
}
