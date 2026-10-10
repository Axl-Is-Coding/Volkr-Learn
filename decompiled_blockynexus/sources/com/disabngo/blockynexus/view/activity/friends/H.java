package com.disabngo.blockynexus.view.activity.friends;

import androidx.databinding.ObservableField;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import java.util.List;

/* JADX INFO: compiled from: FriendGoodsListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class H extends OnResponseListener<List<SingleDressInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f10643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ I f10644b;

    H(I i, OnResponseListener onResponseListener) {
        this.f10644b = i;
        this.f10643a = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f10643a.onError(i, str);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f10643a.onServerError(i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<SingleDressInfo> list) {
        this.f10643a.onSuccess(list);
        if (list.size() == 0) {
            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_FRIEND_NO_DECORATION);
        }
        ObservableField<Boolean> observableField = this.f10644b.f10648d;
        if (observableField != null) {
            observableField.set(true);
        }
    }
}
