package com.bumptech.glide.load.data.a;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.g;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: ThumbnailStreamOpener.java */
/* JADX INFO: loaded from: classes.dex */
class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f4365a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f4366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d f4367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.b f4368d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ContentResolver f4369e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<ImageHeaderParser> f4370f;

    e(List<ImageHeaderParser> list, d dVar, com.bumptech.glide.load.engine.a.b bVar, ContentResolver contentResolver) {
        this(list, f4365a, dVar, bVar, contentResolver);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String c(android.net.Uri r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.String r0 = "ThumbStreamOpener"
            r1 = 0
            com.bumptech.glide.load.data.a.d r2 = r6.f4367c     // Catch: java.lang.Throwable -> L24 java.lang.SecurityException -> L27
            android.database.Cursor r2 = r2.a(r7)     // Catch: java.lang.Throwable -> L24 java.lang.SecurityException -> L27
            if (r2 == 0) goto L1e
            boolean r3 = r2.moveToFirst()     // Catch: java.lang.SecurityException -> L1c java.lang.Throwable -> L4a
            if (r3 == 0) goto L1e
            r3 = 0
            java.lang.String r7 = r2.getString(r3)     // Catch: java.lang.SecurityException -> L1c java.lang.Throwable -> L4a
            if (r2 == 0) goto L1b
            r2.close()
        L1b:
            return r7
        L1c:
            r3 = move-exception
            goto L29
        L1e:
            if (r2 == 0) goto L23
            r2.close()
        L23:
            return r1
        L24:
            r7 = move-exception
            r2 = r1
            goto L4b
        L27:
            r3 = move-exception
            r2 = r1
        L29:
            r4 = 3
            boolean r4 = android.util.Log.isLoggable(r0, r4)     // Catch: java.lang.Throwable -> L4a
            if (r4 == 0) goto L44
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4a
            r4.<init>()     // Catch: java.lang.Throwable -> L4a
            java.lang.String r5 = "Failed to query for thumbnail for Uri: "
            r4.append(r5)     // Catch: java.lang.Throwable -> L4a
            r4.append(r7)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L4a
            android.util.Log.d(r0, r7, r3)     // Catch: java.lang.Throwable -> L4a
        L44:
            if (r2 == 0) goto L49
            r2.close()
        L49:
            return r1
        L4a:
            r7 = move-exception
        L4b:
            if (r2 == 0) goto L50
            r2.close()
        L50:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.data.a.e.c(android.net.Uri):java.lang.String");
    }

    int a(Uri uri) {
        InputStream inputStreamOpenInputStream = null;
        try {
            try {
                inputStreamOpenInputStream = this.f4369e.openInputStream(uri);
                int iA = g.a(this.f4370f, inputStreamOpenInputStream, this.f4368d);
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return iA;
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (IOException | NullPointerException e2) {
            if (Log.isLoggable("ThumbStreamOpener", 3)) {
                Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e2);
            }
            if (inputStreamOpenInputStream == null) {
                return -1;
            }
            try {
                inputStreamOpenInputStream.close();
                return -1;
            } catch (IOException unused3) {
                return -1;
            }
        }
    }

    public InputStream b(Uri uri) throws Throwable {
        String strC = c(uri);
        if (TextUtils.isEmpty(strC)) {
            return null;
        }
        File fileA = this.f4366b.a(strC);
        if (!a(fileA)) {
            return null;
        }
        Uri uriFromFile = Uri.fromFile(fileA);
        try {
            return this.f4369e.openInputStream(uriFromFile);
        } catch (NullPointerException e2) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + uriFromFile).initCause(e2));
        }
    }

    e(List<ImageHeaderParser> list, a aVar, d dVar, com.bumptech.glide.load.engine.a.b bVar, ContentResolver contentResolver) {
        this.f4366b = aVar;
        this.f4367c = dVar;
        this.f4368d = bVar;
        this.f4369e = contentResolver;
        this.f4370f = list;
    }

    private boolean a(File file) {
        return this.f4366b.a(file) && 0 < this.f4366b.b(file);
    }
}
