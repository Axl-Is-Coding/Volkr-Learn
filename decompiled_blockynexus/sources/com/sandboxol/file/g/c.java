package com.sandboxol.file.g;

import com.sandboxol.file.d.g;

/* JADX INFO: compiled from: BlockyVerify.java */
/* JADX INFO: loaded from: classes3.dex */
class c implements f.b.c<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f17619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ d f17620b;

    c(d dVar, g gVar) {
        this.f17620b = dVar;
        this.f17619a = gVar;
    }

    @Override // f.b.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNext(Boolean bool) {
        if (bool.booleanValue()) {
            return;
        }
        this.f17620b.b();
        this.f17619a.error(new Exception("verify fail"));
    }

    @Override // f.b.c
    public void onComplete() {
        this.f17620b.b();
        this.f17619a.success();
    }

    @Override // f.b.c
    public void onError(Throwable th) {
        this.f17620b.b();
        this.f17619a.error(th);
    }

    @Override // f.b.c
    public void onSubscribe(f.b.d dVar) {
        this.f17620b.a(dVar);
        dVar.request(Long.MAX_VALUE);
    }
}
