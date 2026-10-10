package com.disabngo.blockynexus.view.dialog;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.FriendOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: renamed from: com.disabngo.blockynexus.view.dialog.qa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ApplyFriendDialog.java */
/* JADX INFO: loaded from: classes2.dex */
class C1113qa extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DialogC1114ra f11674a;

    C1113qa(DialogC1114ra dialogC1114ra) {
        this.f11674a = dialogC1114ra;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        FriendOnError.showErrorTip(((FullScreenDialog) this.f11674a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(((FullScreenDialog) this.f11674a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        AppToastUtils.showShortPositiveTipToast(((FullScreenDialog) this.f11674a).context, R.string.send);
        if (this.f11674a.isShowing()) {
            this.f11674a.cancel();
        }
    }
}
