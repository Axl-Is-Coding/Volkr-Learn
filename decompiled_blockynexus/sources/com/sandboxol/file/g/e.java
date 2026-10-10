package com.sandboxol.file.g;

import com.sandboxol.file.d.g;

/* JADX INFO: compiled from: VerifyHandler.java */
/* JADX INFO: loaded from: classes3.dex */
class e implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.file.b.c f17621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ f f17622b;

    e(f fVar, com.sandboxol.file.b.c cVar) {
        this.f17622b = fVar;
        this.f17621a = cVar;
    }

    @Override // com.sandboxol.file.d.g
    public void error(Throwable th) {
        this.f17622b.a(-1);
        this.f17621a.c().error(th);
    }

    @Override // com.sandboxol.file.d.g
    public void success() {
        this.f17622b.a(4);
        this.f17621a.c().success();
        if (this.f17622b.c() == 4) {
            this.f17622b.f();
        }
    }
}
