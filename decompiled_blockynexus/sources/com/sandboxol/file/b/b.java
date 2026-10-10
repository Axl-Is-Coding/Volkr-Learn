package com.sandboxol.file.b;

import com.sandboxol.file.d.e;
import com.sandboxol.file.entity.UnzipInfo;

/* JADX INFO: compiled from: UnzipBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends com.sandboxol.file.a.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private e f17551d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private UnzipInfo[] f17552e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f17550c = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f17553f = 1;

    public b a(e eVar) {
        this.f17551d = eVar;
        return this;
    }

    public UnzipInfo[] b() {
        return this.f17552e;
    }

    public int c() {
        return this.f17553f;
    }

    public e d() {
        return this.f17551d;
    }

    public int e() {
        return this.f17550c;
    }

    public b a(UnzipInfo... unzipInfoArr) {
        this.f17552e = unzipInfoArr;
        return this;
    }

    @Override // com.sandboxol.file.a.a
    public b a(int i) {
        super.a(i);
        return this;
    }
}
