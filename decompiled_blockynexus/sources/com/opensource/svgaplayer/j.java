package com.opensource.svgaplayer;

import android.net.http.HttpResponseCache;
import android.util.Log;
import com.opensource.svgaplayer.SVGAParser;
import io.rong.imageloader.core.download.BaseImageDownloader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.jvm.internal.Ref$BooleanRef;

/* JADX INFO: compiled from: SVGAParser.kt */
/* JADX INFO: loaded from: classes2.dex */
final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SVGAParser.b f15548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ URL f15549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Ref$BooleanRef f15550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ kotlin.jvm.a.b f15551d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ kotlin.jvm.a.b f15552e;

    j(SVGAParser.b bVar, URL url, Ref$BooleanRef ref$BooleanRef, kotlin.jvm.a.b bVar2, kotlin.jvm.a.b bVar3) {
        this.f15548a = bVar;
        this.f15549b = url;
        this.f15550c = ref$BooleanRef;
        this.f15551d = bVar2;
        this.f15552e = bVar3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.Closeable, java.io.InputStream] */
    @Override // java.lang.Runnable
    public final void run() {
        Throwable th;
        Throwable th2;
        int i;
        try {
            if (HttpResponseCache.getInstalled() == null && !this.f15548a.a()) {
                Log.e("SVGAParser", "SVGAParser can not handle cache before install HttpResponseCache. see https://github.com/yyued/SVGAPlayer-Android#cache");
                Log.e("SVGAParser", "在配置 HttpResponseCache 前 SVGAParser 无法缓存. 查看 https://github.com/yyued/SVGAPlayer-Android#cache ");
            }
            URLConnection uRLConnectionOpenConnection = this.f15549b.openConnection();
            if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
                uRLConnectionOpenConnection = null;
            }
            ?? inputStream = (HttpURLConnection) uRLConnectionOpenConnection;
            if (inputStream != 0) {
                try {
                    inputStream.setConnectTimeout(BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT);
                    inputStream.setRequestMethod("GET");
                    inputStream.connect();
                    inputStream = inputStream.getInputStream();
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[4096];
                        while (!this.f15550c.element && (i = inputStream.read(bArr, 0, 4096)) != -1) {
                            byteArrayOutputStream.write(bArr, 0, i);
                        }
                        if (this.f15550c.element) {
                            kotlin.io.a.a(byteArrayOutputStream, null);
                            return;
                        }
                        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                        try {
                            this.f15551d.invoke(byteArrayInputStream);
                            kotlin.l lVar = kotlin.l.f22855a;
                            kotlin.io.a.a(byteArrayInputStream, null);
                            kotlin.l lVar2 = kotlin.l.f22855a;
                            kotlin.io.a.a(byteArrayOutputStream, null);
                            kotlin.l lVar3 = kotlin.l.f22855a;
                        } catch (Throwable th3) {
                            th = th3;
                            th2 = null;
                            kotlin.io.a.a(byteArrayInputStream, th2);
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        th = null;
                        kotlin.io.a.a(byteArrayOutputStream, th);
                        throw th;
                    }
                } finally {
                    kotlin.io.a.a(inputStream, null);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            this.f15552e.invoke(e2);
        }
    }
}
