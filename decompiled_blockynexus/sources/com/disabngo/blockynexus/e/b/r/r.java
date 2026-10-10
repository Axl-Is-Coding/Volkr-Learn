package com.disabngo.blockynexus.e.b.r;

import com.sandboxol.common.interfaces.ReportDataAdapter;
import io.reactivex.w;

/* JADX INFO: compiled from: DiskSpaceViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class r implements w<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ s f10117a;

    r(s sVar) {
        this.f10117a = sVar;
    }

    @Override // io.reactivex.w
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNext(Long l) {
    }

    @Override // io.reactivex.w
    public void onComplete() {
        s sVar = this.f10117a;
        sVar.f10119b.j = ((Long) sVar.f10118a.get()).longValue();
    }

    @Override // io.reactivex.w
    public void onError(Throwable th) {
        ReportDataAdapter.onError(this.f10117a.f10119b.f10122a, th);
    }

    @Override // io.reactivex.w
    public void onSubscribe(io.reactivex.disposables.b bVar) {
    }
}
