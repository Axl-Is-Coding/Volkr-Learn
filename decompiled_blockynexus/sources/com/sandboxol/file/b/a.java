package com.sandboxol.file.b;

import com.sandboxol.file.entity.DownloadConfig;
import com.sandboxol.file.entity.DownloadInfo;

/* JADX INFO: compiled from: DownloadBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends com.sandboxol.file.a.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private DownloadInfo[] f17547d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.sandboxol.file.d.c f17548e;
    private DownloadConfig g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f17546c = "RxDownload4";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f17549f = 2;

    public a a(DownloadInfo... downloadInfoArr) {
        this.f17547d = downloadInfoArr;
        return this;
    }

    public DownloadConfig b() {
        return this.g;
    }

    public com.sandboxol.file.d.c c() {
        return this.f17548e;
    }

    public String d() {
        return this.f17546c;
    }

    public DownloadInfo[] e() {
        return this.f17547d;
    }

    public int f() {
        return this.f17549f;
    }

    public a a(com.sandboxol.file.d.c cVar) {
        this.f17548e = cVar;
        return this;
    }

    public a a(DownloadConfig downloadConfig) {
        this.g = downloadConfig;
        return this;
    }

    @Override // com.sandboxol.file.a.a
    public a a(int i) {
        super.a(i);
        return this;
    }
}
