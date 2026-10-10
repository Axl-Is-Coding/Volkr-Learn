package com.disabngo.blockynexus.view.activity.newsearch;

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
class l extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f11012a;

    l(m mVar) {
        this.f11012a = mVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        FriendOnError.showErrorTip(this.f11012a.f11014b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f11012a.f11014b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        m mVar = this.f11012a;
        ObservableField observableField = mVar.f11016d;
        if (observableField != null) {
            observableField.set(mVar.f11014b.getString(R.string.send));
        }
        this.f11012a.f11017e.set(true);
        m mVar2 = this.f11012a;
        if (!mVar2.f11018f) {
            AppToastUtils.showShortPositiveTipToast(mVar2.f11014b, R.string.send);
        }
        m mVar3 = this.f11012a;
        ReportDataAdapter.onEvent(mVar3.f11014b, EventConstant.CHAT_ADD_FRIEND, mVar3.f11018f ? "App" : "Recommend");
    }
}
