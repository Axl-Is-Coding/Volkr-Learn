package com.squareup.picasso;

import android.content.Context;
import android.net.Uri;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.picasso.Downloader;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: OkHttpDownloader.java */
/* JADX INFO: loaded from: classes5.dex */
public class v implements Downloader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OkHttpClient f19322a;

    public v(Context context) {
        this(P.b(context));
    }

    private static OkHttpClient a() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectTimeout(15000L, TimeUnit.MILLISECONDS);
        okHttpClient.setReadTimeout(20000L, TimeUnit.MILLISECONDS);
        okHttpClient.setWriteTimeout(20000L, TimeUnit.MILLISECONDS);
        return okHttpClient;
    }

    public v(File file) {
        this(file, P.a(file));
    }

    public v(File file, long j) {
        this(a());
        try {
            this.f19322a.setCache(new Cache(file, j));
        } catch (IOException unused) {
        }
    }

    public v(OkHttpClient okHttpClient) {
        this.f19322a = okHttpClient;
    }

    @Override // com.squareup.picasso.Downloader
    public Downloader.a a(Uri uri, int i) throws IOException {
        CacheControl cacheControlBuild;
        if (i == 0) {
            cacheControlBuild = null;
        } else if (NetworkPolicy.isOfflineOnly(i)) {
            cacheControlBuild = CacheControl.FORCE_CACHE;
        } else {
            CacheControl.Builder builder = new CacheControl.Builder();
            if (!NetworkPolicy.shouldReadFromDiskCache(i)) {
                builder.noCache();
            }
            if (!NetworkPolicy.shouldWriteToDiskCache(i)) {
                builder.noStore();
            }
            cacheControlBuild = builder.build();
        }
        Request.Builder builderUrl = new Request.Builder().url(uri.toString());
        if (cacheControlBuild != null) {
            builderUrl.cacheControl(cacheControlBuild);
        }
        Response responseExecute = this.f19322a.newCall(builderUrl.build()).execute();
        int iCode = responseExecute.code();
        if (iCode < 300) {
            boolean z = responseExecute.cacheResponse() != null;
            ResponseBody responseBodyBody = responseExecute.body();
            return new Downloader.a(responseBodyBody.byteStream(), z, responseBodyBody.contentLength());
        }
        responseExecute.body().close();
        throw new Downloader.ResponseException(iCode + " " + responseExecute.message(), i, iCode);
    }
}
