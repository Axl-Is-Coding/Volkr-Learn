package com.disabngo.blockynexus.view.dialog;

import com.sandboxol.center.web.UserOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.interfaces.OnDataListener;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.greendao.entity.Friend;
import java.util.List;

/* JADX INFO: compiled from: MapFriendInfoDialog.java */
/* JADX INFO: loaded from: classes2.dex */
class Ca extends OnResponseListener<List<String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnDataListener f11270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Da f11271b;

    Ca(Da da, OnDataListener onDataListener) {
        this.f11271b = da;
        this.f11270a = onDataListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        UserOnError.showErrorTip(((FullScreenDialog) this.f11271b).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(((FullScreenDialog) this.f11271b).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<String> list) {
        Friend friend;
        if (list == null || (friend = this.f11271b.f11275a) == null || friend.getUserGameDataResponse() == null || this.f11271b.f11275a.getUserGameDataResponse().getUserGameCareerInfo() == null || this.f11271b.f11275a.getUserGameDataResponse().getUserGameCareerInfo().getGameTimeMap() == null) {
            this.f11270a.onSuccess(null);
        } else {
            list.retainAll(this.f11271b.f11275a.getUserGameDataResponse().getUserGameCareerInfo().getGameTimeMap().keySet());
            this.f11270a.onSuccess(list);
        }
    }
}
