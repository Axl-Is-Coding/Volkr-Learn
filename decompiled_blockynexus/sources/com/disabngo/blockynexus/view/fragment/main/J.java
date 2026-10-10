package com.disabngo.blockynexus.view.fragment.main;

import com.sandboxol.center.web.error.ScrapOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: MainFragmentViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class J extends OnResponseListener<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MainFragmentViewModel f11774a;

    J(MainFragmentViewModel mainFragmentViewModel) {
        this.f11774a = mainFragmentViewModel;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i == 10104) {
            this.f11774a.scrapRedPointNum.set(0);
        } else {
            ScrapOnError.showErrorTip(this.f11774a.context, i);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f11774a.context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Integer num) {
        this.f11774a.scrapRedPointNum.set(num);
    }
}
