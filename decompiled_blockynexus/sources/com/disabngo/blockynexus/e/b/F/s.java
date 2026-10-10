package com.disabngo.blockynexus.e.b.F;

import android.app.Activity;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.GroupOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: GroupMemberViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class s extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ u f9276a;

    s(u uVar) {
        this.f9276a = uVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        GroupOnError.showErrorTip(this.f9276a.f9278a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f9276a.f9278a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        AppToastUtils.showShortPositiveTipToast(this.f9276a.f9278a, R.string.new_group_invite_success);
        ((Activity) this.f9276a.f9278a).finish();
    }
}
