package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: LocalUriFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class m<T> implements d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f4394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ContentResolver f4395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private T f4396c;

    public m(ContentResolver contentResolver, Uri uri) {
        this.f4395b = contentResolver;
        this.f4394a = uri;
    }

    protected abstract T a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    @Override // com.bumptech.glide.load.data.d
    public final void a(Priority priority, d.a<? super T> aVar) {
        try {
            this.f4396c = a(this.f4394a, this.f4395b);
            aVar.a(this.f4396c);
        } catch (FileNotFoundException e2) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e2);
            }
            aVar.a((Exception) e2);
        }
    }

    protected abstract void a(T t) throws IOException;

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        T t = this.f4396c;
        if (t != null) {
            try {
                a(t);
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public DataSource c() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
    }
}
