package com.disabngo.blockynexus.view.activity.friends;

import com.disabngo.blockynexus.web.error.FriendOnError;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.greendao.entity.Friend;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: FriendInfoViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class K extends OnResponseListener<Friend> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ M f10651a;

    K(M m) {
        this.f10651a = m;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        FriendOnError.showErrorTip(this.f10651a.f10653a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f10651a.f10653a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Friend friend) {
        if (friend != null) {
            if (friend.isFriend()) {
                if (this.f10651a.g.getType() == 2 || this.f10651a.g.getType() == 1) {
                    this.f10651a.g.setType(0);
                }
            } else if (friend.getUserId() != AccountCenter.newInstance().userId.get().longValue() && (this.f10651a.g.getType() == 0 || this.f10651a.g.getType() == 3)) {
                this.f10651a.g.setType(2);
            }
            this.f10651a.i.set(friend);
            com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
            fVar.a("friend", friend);
            MessagerClient.getIns().sendMsg1("token.refresh.friend.list", fVar);
        }
        this.f10651a.K();
        this.f10651a.F();
    }
}
