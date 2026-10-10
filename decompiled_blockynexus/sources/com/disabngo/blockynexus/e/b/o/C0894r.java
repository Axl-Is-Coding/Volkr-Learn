package com.disabngo.blockynexus.e.b.o;

import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.greendao.entity.Friend;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.o.r, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ChatModel.java */
/* JADX INFO: loaded from: classes2.dex */
class C0894r implements com.sandboxol.greendao.a.c<Friend> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0895s f10010a;

    C0894r(C0895s c0895s) {
        this.f10010a = c0895s;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Friend friend) {
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.friend.list");
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
