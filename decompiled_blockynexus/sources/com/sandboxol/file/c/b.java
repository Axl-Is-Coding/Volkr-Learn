package com.sandboxol.file.c;

import com.sandboxol.file.entity.Progress;

/* JADX INFO: compiled from: DownloadHandler.java */
/* JADX INFO: loaded from: classes3.dex */
class b implements com.sandboxol.file.d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.file.b.a f17559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ d f17560b;

    b(d dVar, com.sandboxol.file.b.a aVar) {
        this.f17560b = dVar;
        this.f17559a = aVar;
    }

    @Override // com.sandboxol.file.d.c
    public void onComplete(Progress progress) {
        this.f17560b.a(4);
        this.f17559a.c().onComplete(progress);
        if (this.f17560b.c() == 4) {
            this.f17560b.g();
        }
    }

    @Override // com.sandboxol.file.d.c
    public void onError(Throwable th) {
        this.f17560b.a(-1);
        this.f17559a.c().onError(th);
    }

    @Override // com.sandboxol.file.d.c
    public void onNext(Progress progress) {
        this.f17560b.a(2);
        this.f17559a.c().onNext(progress);
    }

    @Override // com.sandboxol.file.d.c
    public void onSubscribe(Throwable th) {
        this.f17560b.a(1);
        this.f17559a.c().onSubscribe(th);
    }
}
