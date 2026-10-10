package com.bytedance.sdk.openadsdk.core.video.a;

import android.content.Context;
import android.media.MediaDataSource;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.video.a.a.c;
import com.bytedance.sdk.openadsdk.utils.o;
import java.io.IOException;

/* JADX INFO: compiled from: SdkMediaDataSource.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends MediaDataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f6409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.video.a.a.a f6410c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f6411d = -2147483648L;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f6412e;

    public b(Context context, String str, String str2) {
        this.f6412e = context;
        this.f6408a = str;
        if (TextUtils.isEmpty(str2)) {
            this.f6409b = com.bytedance.sdk.openadsdk.h.g.b.a(str);
        } else {
            this.f6409b = str2;
        }
    }

    private void b() {
        if (this.f6410c == null) {
            String str = this.f6408a;
            String str2 = this.f6409b;
            this.f6410c = new com.bytedance.sdk.openadsdk.core.video.a.a.b(str, str2, c.a(this.f6412e, str2));
        }
    }

    public boolean a() {
        b();
        return this.f6410c.c();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        o.c("SdkMediaDataSource", "close: " + this.f6408a);
        com.bytedance.sdk.openadsdk.core.video.a.a.a aVar = this.f6410c;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.media.MediaDataSource
    public long getSize() throws IOException {
        b();
        if (this.f6411d == -2147483648L) {
            if (this.f6412e == null || TextUtils.isEmpty(this.f6408a)) {
                return -1L;
            }
            this.f6411d = this.f6410c.b();
            o.c("SdkMediaDataSource", "getSize: " + this.f6411d);
        }
        return this.f6411d;
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
        b();
        int iA = this.f6410c.a(j, bArr, i, i2);
        o.c("SdkMediaDataSource", "readAt: position = " + j + "  buffer.length =" + bArr.length + "  offset = " + i + " size =" + iA + "  current = " + Thread.currentThread());
        return iA;
    }
}
