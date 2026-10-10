package com.sandboxol.file.c;

import com.sandboxol.file.entity.Progress;

/* JADX INFO: compiled from: DownloadHandler.java */
/* JADX INFO: loaded from: classes3.dex */
class c implements com.sandboxol.file.d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.file.b.a f17561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ d f17562b;

    c(d dVar, com.sandboxol.file.b.a aVar) {
        this.f17562b = dVar;
        this.f17561a = aVar;
    }

    @Override // com.sandboxol.file.d.c
    public void onComplete(Progress progress) {
        this.f17562b.a(4);
        this.f17561a.c().onComplete(progress);
        if (this.f17562b.c() == 4) {
            this.f17562b.g();
        }
    }

    @Override // com.sandboxol.file.d.c
    public void onError(Throwable th) {
        this.f17562b.a(-1);
        this.f17561a.c().onError(th);
    }

    @Override // com.sandboxol.file.d.c
    public void onNext(Progress progress) {
        this.f17562b.a(2);
        this.f17561a.c().onNext(progress);
    }

    @Override // com.sandboxol.file.d.c
    public void onSubscribe(Throwable th) {
        this.f17562b.a(1);
        this.f17561a.c().onSubscribe(th);
    }
}
