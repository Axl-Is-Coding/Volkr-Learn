package com.sandboxol.halloween.view.fragment.exchange;

import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ExchangeViewModel.java */
/* JADX INFO: loaded from: classes4.dex */
class s extends OnResponseListener<List<SingleDressInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f18732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ExchangeViewModel f18733b;

    s(ExchangeViewModel exchangeViewModel, String str) {
        this.f18733b = exchangeViewModel;
        this.f18732a = str;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f18733b.b(this.f18732a);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f18733b.f18703a, i);
        this.f18733b.b(this.f18732a);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<SingleDressInfo> list) {
        this.f18733b.f18705c = new ArrayList();
        this.f18733b.f18705c.addAll(list);
        this.f18733b.a((List<SingleDressInfo>) list);
        this.f18733b.b(this.f18732a);
    }
}
