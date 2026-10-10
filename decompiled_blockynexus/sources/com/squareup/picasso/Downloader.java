package com.squareup.picasso;

import android.graphics.Bitmap;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public interface Downloader {

    public static class ResponseException extends IOException {
        final boolean localCacheOnly;
        final int responseCode;

        public ResponseException(String str, int i, int i2) {
            super(str);
            this.localCacheOnly = NetworkPolicy.isOfflineOnly(i);
            this.responseCode = i2;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final InputStream f19227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Bitmap f19228b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f19229c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final long f19230d;

        public a(InputStream inputStream, boolean z, long j) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Stream may not be null.");
            }
            this.f19227a = inputStream;
            this.f19228b = null;
            this.f19229c = z;
            this.f19230d = j;
        }

        @Deprecated
        public Bitmap a() {
            return this.f19228b;
        }

        public long b() {
            return this.f19230d;
        }

        public InputStream c() {
            return this.f19227a;
        }
    }

    a a(Uri uri, int i) throws IOException;
}
