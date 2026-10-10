package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.d;
import com.just.agentweb.AgentWebPermissions;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: compiled from: HttpUrlFetcher.java */
/* JADX INFO: loaded from: classes.dex */
public class k implements d<InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final b f4386a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.a.l f4387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f4388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f4389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HttpURLConnection f4390e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private InputStream f4391f;
    private volatile boolean g;

    /* JADX INFO: compiled from: HttpUrlFetcher.java */
    private static class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.load.data.k.b
        public HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* JADX INFO: compiled from: HttpUrlFetcher.java */
    interface b {
        HttpURLConnection a(URL url) throws IOException;
    }

    public k(com.bumptech.glide.load.a.l lVar, int i) {
        this(lVar, i, f4386a);
    }

    private static boolean b(int i) {
        return i / 100 == 3;
    }

    @Override // com.bumptech.glide.load.data.d
    public void a(Priority priority, d.a<? super InputStream> aVar) {
        StringBuilder sb;
        long jA = com.bumptech.glide.e.h.a();
        try {
            try {
                aVar.a(a(this.f4387b.c(), 0, null, this.f4387b.b()));
            } catch (IOException e2) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e2);
                }
                aVar.a((Exception) e2);
                if (!Log.isLoggable("HttpUrlFetcher", 2)) {
                    return;
                } else {
                    sb = new StringBuilder();
                }
            }
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(com.bumptech.glide.e.h.a(jA));
                Log.v("HttpUrlFetcher", sb.toString());
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + com.bumptech.glide.e.h.a(jA));
            }
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public DataSource c() {
        return DataSource.REMOTE;
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
        this.g = true;
    }

    k(com.bumptech.glide.load.a.l lVar, int i, b bVar) {
        this.f4387b = lVar;
        this.f4388c = i;
        this.f4389d = bVar;
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        InputStream inputStream = this.f4391f;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f4390e;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f4390e = null;
    }

    private InputStream a(URL url, int i, URL url2, Map<String, String> map) throws IOException {
        if (i < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.f4390e = this.f4389d.a(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f4390e.addRequestProperty(entry.getKey(), entry.getValue());
            }
            this.f4390e.setConnectTimeout(this.f4388c);
            this.f4390e.setReadTimeout(this.f4388c);
            this.f4390e.setUseCaches(false);
            this.f4390e.setDoInput(true);
            this.f4390e.setInstanceFollowRedirects(false);
            this.f4390e.connect();
            this.f4391f = this.f4390e.getInputStream();
            if (this.g) {
                return null;
            }
            int responseCode = this.f4390e.getResponseCode();
            if (a(responseCode)) {
                return a(this.f4390e);
            }
            if (!b(responseCode)) {
                if (responseCode == -1) {
                    throw new HttpException(responseCode);
                }
                throw new HttpException(this.f4390e.getResponseMessage(), responseCode);
            }
            String headerField = this.f4390e.getHeaderField(AgentWebPermissions.ACTION_LOCATION);
            if (!TextUtils.isEmpty(headerField)) {
                URL url3 = new URL(url, headerField);
                b();
                return a(url3, i + 1, url, map);
            }
            throw new HttpException("Received empty or null redirect url");
        }
        throw new HttpException("Too many (> 5) redirects!");
    }

    private static boolean a(int i) {
        return i / 100 == 2;
    }

    private InputStream a(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f4391f = com.bumptech.glide.e.c.a(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.f4391f = httpURLConnection.getInputStream();
        }
        return this.f4391f;
    }

    @Override // com.bumptech.glide.load.data.d
    public Class<InputStream> a() {
        return InputStream.class;
    }
}
