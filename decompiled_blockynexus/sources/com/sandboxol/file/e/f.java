package com.sandboxol.file.e;

import com.sandboxol.file.entity.Progress;
import com.sandboxol.file.entity.UnzipInfo;

/* JADX INFO: compiled from: BlockyUnzip.java */
/* JADX INFO: loaded from: classes3.dex */
class f implements com.sandboxol.file.d.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ io.reactivex.f f17601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ UnzipInfo f17602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ g f17603c;

    f(g gVar, io.reactivex.f fVar, UnzipInfo unzipInfo) {
        this.f17603c = gVar;
        this.f17601a = fVar;
        this.f17602b = unzipInfo;
    }

    @Override // com.sandboxol.file.d.e
    public void error(Throwable th) {
        this.f17601a.onError(th);
    }

    @Override // com.sandboxol.file.d.e
    public void progress(Progress progress) {
        progress.setName(this.f17602b.getZipName());
        this.f17601a.onNext(progress);
    }

    @Override // com.sandboxol.file.d.e
    public void success() {
    }
}
