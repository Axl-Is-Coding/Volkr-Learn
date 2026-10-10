package com.disabngo.blockynexus.e.b.r;

import com.sandboxol.common.interfaces.ReportDataAdapter;
import io.reactivex.w;

/* JADX INFO: compiled from: DiskSpaceViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class q implements w<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ v f10116a;

    q(v vVar) {
        this.f10116a = vVar;
    }

    @Override // io.reactivex.w
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNext(Long l) {
        this.f10116a.i = l.longValue();
        this.f10116a.q.set(false);
    }

    @Override // io.reactivex.w
    public void onComplete() {
        this.f10116a.q.set(false);
    }

    @Override // io.reactivex.w
    public void onError(Throwable th) {
        ReportDataAdapter.onError(this.f10116a.f10122a, th);
        this.f10116a.q.set(false);
    }

    @Override // io.reactivex.w
    public void onSubscribe(io.reactivex.disposables.b bVar) {
    }
}
