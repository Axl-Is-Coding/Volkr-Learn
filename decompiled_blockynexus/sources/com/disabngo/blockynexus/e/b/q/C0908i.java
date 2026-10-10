package com.disabngo.blockynexus.e.b.q;

import com.sandboxol.common.base.model.DefaultListModel;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import io.reactivex.w;
import java.util.List;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.q.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DiskGameManageListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class C0908i implements w<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f10077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0909j f10078b;

    C0908i(C0909j c0909j, List list) {
        this.f10078b = c0909j;
        this.f10077a = list;
    }

    @Override // io.reactivex.w
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNext(Long l) {
    }

    @Override // io.reactivex.w
    public void onComplete() {
        this.f10078b.f10080b.f10084d.set(Boolean.valueOf(this.f10077a.size() != 0));
        this.f10078b.f10079a.onSuccess(this.f10077a);
    }

    @Override // io.reactivex.w
    public void onError(Throwable th) {
        ReportDataAdapter.onError(((DefaultListModel) this.f10078b.f10080b).context, th);
        this.f10078b.f10079a.onSuccess(this.f10077a);
    }

    @Override // io.reactivex.w
    public void onSubscribe(io.reactivex.disposables.b bVar) {
    }
}
