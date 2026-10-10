package com.disabngo.blockynexus.e.b.H;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.GroupOnError;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;

/* JADX INFO: compiled from: GroupVerificationItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class f extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f9299a;

    f(h hVar) {
        this.f9299a = hVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        GroupOnError.showErrorTip(((ListItemViewModel) this.f9299a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        AppToastUtils.showShortPositiveTipToast(((ListItemViewModel) this.f9299a).context, R.string.refuse_add_friend_failed);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        h hVar = this.f9299a;
        hVar.f9301a.set(((ListItemViewModel) hVar).context.getString(R.string.refuse_add_friend));
        this.f9299a.f9302b.set(true);
        AppToastUtils.showShortPositiveTipToast(((ListItemViewModel) this.f9299a).context, R.string.new_group_refuse_group_success);
    }
}
