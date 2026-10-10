package com.disabngo.blockynexus.e.b.x;

import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.imchat.config.ChatMessageToken;

/* JADX INFO: compiled from: FriendFragment.java */
/* JADX INFO: loaded from: classes2.dex */
class t implements com.sandboxol.messager.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ v f10316a;

    t(v vVar) {
        this.f10316a = vVar;
    }

    @Override // com.sandboxol.messager.a.b
    public void onCall(com.sandboxol.messager.a.f fVar) {
        Messenger.getDefault().send(Long.valueOf(fVar.a(StringConstant.FRIEND_INFO_ACTIVITY_FRIEND_ID, 0L)), ChatMessageToken.TOKEN_CHAT_NEW_FRIEND_REMOVE);
        Messenger.getDefault().send(RefreshMsg.create(), MessageToken.TOKEN_REFRESH_FRIEND_APPLY_LIST);
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.friend.list");
    }
}
