package com.disabngo.blockynexus.e.b.r;

import androidx.databinding.ObservableField;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.download.utils.ProgressUtils;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import io.reactivex.w;

/* JADX INFO: compiled from: DiskSpaceViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class t implements w<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ v f10120a;

    t(v vVar) {
        this.f10120a = vVar;
    }

    @Override // io.reactivex.w
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNext(Long l) {
        v vVar = this.f10120a;
        vVar.g.set(ProgressUtils.formatSize(Long.valueOf((vVar.k + vVar.i) - vVar.l)));
        v vVar2 = this.f10120a;
        vVar2.f10126e.set(Integer.valueOf((int) (((vVar2.k + vVar2.i) - vVar2.l) / 1048576)));
        ObservableField<Integer> observableField = this.f10120a.f10125d;
        observableField.set(Integer.valueOf(observableField.get().intValue() - (((int) this.f10120a.l) / 1048576)));
        this.f10120a.l = l.longValue();
        this.f10120a.f10127f.set(ProgressUtils.formatSize(l));
        this.f10120a.r.set(false);
    }

    @Override // io.reactivex.w
    public void onComplete() {
        this.f10120a.r.set(false);
        ReportDataAdapter.onEvent(this.f10120a.f10122a, EventConstant.CLEAM_CACHE_SUC);
    }

    @Override // io.reactivex.w
    public void onError(Throwable th) {
        ReportDataAdapter.onError(this.f10120a.f10122a, th);
        this.f10120a.r.set(false);
    }

    @Override // io.reactivex.w
    public void onSubscribe(io.reactivex.disposables.b bVar) {
    }
}
