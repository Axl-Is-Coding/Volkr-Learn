package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import java.io.IOException;

/* JADX INFO: compiled from: AssetPathFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b<T> implements d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AssetManager f4372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private T f4373c;

    public b(AssetManager assetManager, String str) {
        this.f4372b = assetManager;
        this.f4371a = str;
    }

    protected abstract T a(AssetManager assetManager, String str) throws IOException;

    @Override // com.bumptech.glide.load.data.d
    public void a(Priority priority, d.a<? super T> aVar) {
        try {
            this.f4373c = a(this.f4372b, this.f4371a);
            aVar.a(this.f4373c);
        } catch (IOException e2) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e2);
            }
            aVar.a((Exception) e2);
        }
    }

    protected abstract void a(T t) throws IOException;

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        T t = this.f4373c;
        if (t == null) {
            return;
        }
        try {
            a(t);
        } catch (IOException unused) {
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
