package com.disabngo.blockynexus.view.dialog.partyfriend;

import com.disabngo.blockynexus.web.error.FriendOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.greendao.entity.Friend;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: PartyFriendInfoViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class i extends OnResponseListener<Friend> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f11665a;

    i(j jVar) {
        this.f11665a = jVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        FriendOnError.showErrorTip(this.f11665a.f11666a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f11665a.f11666a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Friend friend) {
        if (friend != null) {
            this.f11665a.f11670e.set(friend);
            com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
            fVar.a("friend", friend);
            MessagerClient.getIns().sendMsg1("token.refresh.friend.list", fVar);
        }
        this.f11665a.k();
        this.f11665a.k.set(true);
    }
}
