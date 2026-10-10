package com.disabngo.blockynexus.view.activity.main;

import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.greendao.entity.Friend;

/* JADX INFO: compiled from: MainViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class dc implements com.sandboxol.messager.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ nc f10892a;

    dc(nc ncVar) {
        this.f10892a = ncVar;
    }

    @Override // com.sandboxol.messager.a.b
    public void onCall(com.sandboxol.messager.a.f fVar) {
        fVar.a(Friend.class.getClassLoader());
        Friend friend = (Friend) fVar.a("friend");
        if (friend == null || !friend.isFriend()) {
            return;
        }
        com.sandboxol.greendao.c.P.newInstance().a(friend);
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.friend.list");
    }
}
