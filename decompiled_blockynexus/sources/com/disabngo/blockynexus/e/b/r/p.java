package com.disabngo.blockynexus.e.b.r;

import com.sandboxol.common.interfaces.ReportDataAdapter;
import io.reactivex.w;

/* JADX INFO: compiled from: DiskSpaceViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class p implements w<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ v f10115a;

    p(v vVar) {
        this.f10115a = vVar;
    }

    @Override // io.reactivex.w
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNext(Long l) {
        this.f10115a.k = l.longValue();
        this.f10115a.o.set(false);
    }

    @Override // io.reactivex.w
    public void onComplete() {
        this.f10115a.o.set(false);
    }

    @Override // io.reactivex.w
    public void onError(Throwable th) {
        ReportDataAdapter.onError(this.f10115a.f10122a, th);
        this.f10115a.o.set(false);
    }

    @Override // io.reactivex.w
    public void onSubscribe(io.reactivex.disposables.b bVar) {
    }
}
