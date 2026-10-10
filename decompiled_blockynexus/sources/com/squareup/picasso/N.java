package com.squareup.picasso;

import android.content.Context;
import android.net.Uri;
import android.net.http.HttpResponseCache;
import android.os.Build;
import com.squareup.picasso.Downloader;
import io.rong.imageloader.core.download.BaseImageDownloader;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: compiled from: UrlConnectionDownloader.java */
/* JADX INFO: loaded from: classes5.dex */
public class N implements Downloader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static volatile Object f19252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f19253b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ThreadLocal<StringBuilder> f19254c = new M();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f19255d;

    /* JADX INFO: compiled from: UrlConnectionDownloader.java */
    private static class a {
        static Object a(Context context) throws IOException {
            File fileB = P.b(context);
            HttpResponseCache installed = HttpResponseCache.getInstalled();
            return installed == null ? HttpResponseCache.install(fileB, P.a(fileB)) : installed;
        }
    }

    public N(Context context) {
        this.f19255d = context.getApplicationContext();
    }

    protected HttpURLConnection a(Uri uri) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri.toString()).openConnection();
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT);
        return httpURLConnection;
    }

    @Override // com.squareup.picasso.Downloader
    public Downloader.a a(Uri uri, int i) throws IOException {
        String string;
        if (Build.VERSION.SDK_INT >= 14) {
            a(this.f19255d);
        }
        HttpURLConnection httpURLConnectionA = a(uri);
        httpURLConnectionA.setUseCaches(true);
        if (i != 0) {
            if (NetworkPolicy.isOfflineOnly(i)) {
                string = "only-if-cached,max-age=2147483647";
            } else {
                StringBuilder sb = f19254c.get();
                sb.setLength(0);
                if (!NetworkPolicy.shouldReadFromDiskCache(i)) {
                    sb.append("no-cache");
                }
                if (!NetworkPolicy.shouldWriteToDiskCache(i)) {
                    if (sb.length() > 0) {
                        sb.append(',');
                    }
                    sb.append("no-store");
                }
                string = sb.toString();
            }
            httpURLConnectionA.setRequestProperty("Cache-Control", string);
        }
        int responseCode = httpURLConnectionA.getResponseCode();
        if (responseCode < 300) {
            return new Downloader.a(httpURLConnectionA.getInputStream(), P.a(httpURLConnectionA.getHeaderField("X-Android-Response-Source")), httpURLConnectionA.getHeaderFieldInt("Content-Length", -1));
        }
        httpURLConnectionA.disconnect();
        throw new Downloader.ResponseException(responseCode + " " + httpURLConnectionA.getResponseMessage(), i, responseCode);
    }

    private static void a(Context context) {
        if (f19252a == null) {
            try {
                synchronized (f19253b) {
                    if (f19252a == null) {
                        f19252a = a.a(context);
                    }
                }
            } catch (IOException unused) {
            }
        }
    }
}
