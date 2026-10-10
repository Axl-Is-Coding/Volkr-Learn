package com.bumptech.glide.load.a.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.u;
import com.bumptech.glide.load.a.v;
import com.bumptech.glide.load.a.y;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.l;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* JADX INFO: compiled from: QMediaStoreUriLoader.java */
/* JADX INFO: loaded from: classes.dex */
public final class e<DataT> implements u<Uri, DataT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u<File, DataT> f4240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final u<Uri, DataT> f4241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Class<DataT> f4242d;

    /* JADX INFO: compiled from: QMediaStoreUriLoader.java */
    private static abstract class a<DataT> implements v<Uri, DataT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f4243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class<DataT> f4244b;

        a(Context context, Class<DataT> cls) {
            this.f4243a = context;
            this.f4244b = cls;
        }

        @Override // com.bumptech.glide.load.a.v
        public final u<Uri, DataT> build(y yVar) {
            return new e(this.f4243a, yVar.a(File.class, this.f4244b), yVar.a(Uri.class, this.f4244b), this.f4244b);
        }
    }

    /* JADX INFO: compiled from: QMediaStoreUriLoader.java */
    public static final class b extends a<ParcelFileDescriptor> {
        public b(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    /* JADX INFO: compiled from: QMediaStoreUriLoader.java */
    public static final class c extends a<InputStream> {
        public c(Context context) {
            super(context, InputStream.class);
        }
    }

    e(Context context, u<File, DataT> uVar, u<Uri, DataT> uVar2, Class<DataT> cls) {
        this.f4239a = context.getApplicationContext();
        this.f4240b = uVar;
        this.f4241c = uVar2;
        this.f4242d = cls;
    }

    @Override // com.bumptech.glide.load.a.u
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public u.a<DataT> buildLoadData(Uri uri, int i, int i2, l lVar) {
        return new u.a<>(new com.bumptech.glide.d.d(uri), new d(this.f4239a, this.f4240b, this.f4241c, uri, i, i2, lVar, this.f4242d));
    }

    @Override // com.bumptech.glide.load.a.u
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean handles(Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && com.bumptech.glide.load.data.a.b.b(uri);
    }

    /* JADX INFO: compiled from: QMediaStoreUriLoader.java */
    private static final class d<DataT> implements com.bumptech.glide.load.data.d<DataT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String[] f4245a = {"_data"};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Context f4246b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final u<File, DataT> f4247c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final u<Uri, DataT> f4248d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Uri f4249e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f4250f;
        private final int g;
        private final l h;
        private final Class<DataT> i;
        private volatile boolean j;
        private volatile com.bumptech.glide.load.data.d<DataT> k;

        d(Context context, u<File, DataT> uVar, u<Uri, DataT> uVar2, Uri uri, int i, int i2, l lVar, Class<DataT> cls) {
            this.f4246b = context.getApplicationContext();
            this.f4247c = uVar;
            this.f4248d = uVar2;
            this.f4249e = uri;
            this.f4250f = i;
            this.g = i2;
            this.h = lVar;
            this.i = cls;
        }

        private u.a<DataT> d() throws FileNotFoundException {
            if (Environment.isExternalStorageLegacy()) {
                return this.f4247c.buildLoadData(a(this.f4249e), this.f4250f, this.g, this.h);
            }
            return this.f4248d.buildLoadData(f() ? MediaStore.setRequireOriginal(this.f4249e) : this.f4249e, this.f4250f, this.g, this.h);
        }

        private com.bumptech.glide.load.data.d<DataT> e() throws FileNotFoundException {
            u.a<DataT> aVarD = d();
            if (aVarD != null) {
                return aVarD.f4298c;
            }
            return null;
        }

        private boolean f() {
            return this.f4246b.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
        }

        @Override // com.bumptech.glide.load.data.d
        public void a(Priority priority, d.a<? super DataT> aVar) {
            try {
                com.bumptech.glide.load.data.d<DataT> dVarE = e();
                if (dVarE == null) {
                    aVar.a((Exception) new IllegalArgumentException("Failed to build fetcher for: " + this.f4249e));
                    return;
                }
                this.k = dVarE;
                if (this.j) {
                    cancel();
                } else {
                    dVarE.a(priority, aVar);
                }
            } catch (FileNotFoundException e2) {
                aVar.a((Exception) e2);
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            com.bumptech.glide.load.data.d<DataT> dVar = this.k;
            if (dVar != null) {
                dVar.b();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public DataSource c() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
            this.j = true;
            com.bumptech.glide.load.data.d<DataT> dVar = this.k;
            if (dVar != null) {
                dVar.cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public Class<DataT> a() {
            return this.i;
        }

        private File a(Uri uri) throws FileNotFoundException {
            Cursor cursor = null;
            try {
                Cursor cursorQuery = this.f4246b.getContentResolver().query(uri, f4245a, null, null, null);
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                    if (!TextUtils.isEmpty(string)) {
                        File file = new File(string);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return file;
                    }
                    throw new FileNotFoundException("File path was empty in media store for: " + uri);
                }
                throw new FileNotFoundException("Failed to media store entry for: " + uri);
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }
    }
}
