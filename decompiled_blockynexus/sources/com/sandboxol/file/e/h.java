package com.sandboxol.file.e;

import com.sandboxol.file.entity.Progress;

/* JADX INFO: compiled from: UnzipHandler.java */
/* JADX INFO: loaded from: classes3.dex */
class h implements com.sandboxol.file.d.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.file.b.b f17606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ i f17607b;

    h(i iVar, com.sandboxol.file.b.b bVar) {
        this.f17607b = iVar;
        this.f17606a = bVar;
    }

    @Override // com.sandboxol.file.d.e
    public void error(Throwable th) {
        this.f17607b.a(-1);
        this.f17606a.d().error(th);
    }

    @Override // com.sandboxol.file.d.e
    public void progress(Progress progress) {
        this.f17607b.a(2);
        this.f17606a.d().progress(progress);
    }

    @Override // com.sandboxol.file.d.e
    public void success() {
        this.f17607b.a(4);
        this.f17606a.d().success();
        if (this.f17607b.c() == 4) {
            this.f17607b.f();
        }
    }
}
