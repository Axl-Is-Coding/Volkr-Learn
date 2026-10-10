package com.disabngo.blockynexus.view.activity.searchfriend;

import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.FriendOnError;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: SearchFriendModel.java */
/* JADX INFO: loaded from: classes2.dex */
class j extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f11074a;

    j(k kVar) {
        this.f11074a = kVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        FriendOnError.showErrorTip(this.f11074a.f11076b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f11074a.f11076b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        k kVar = this.f11074a;
        ObservableField observableField = kVar.f11077c;
        if (observableField != null) {
            observableField.set(kVar.f11076b.getString(R.string.send));
        }
        this.f11074a.f11078d.set(true);
        k kVar2 = this.f11074a;
        if (!kVar2.f11079e) {
            AppToastUtils.showShortPositiveTipToast(kVar2.f11076b, R.string.send);
        }
        k kVar3 = this.f11074a;
        ReportDataAdapter.onEvent(kVar3.f11076b, EventConstant.CHAT_ADD_FRIEND, kVar3.f11079e ? "App" : "Recommend");
    }
}
