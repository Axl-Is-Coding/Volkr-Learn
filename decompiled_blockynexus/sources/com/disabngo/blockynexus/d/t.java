package com.disabngo.blockynexus.d;

import com.disabngo.blockynexus.entity.ConversationClickStateHolder;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.utils.logic.N;
import com.disabngo.blockynexus.web.error.GroupOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.GroupUtilsProxy;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.imchat.config.ChatMessageToken;
import com.sandboxol.imchat.entity.GroupNameModify;

/* JADX INFO: compiled from: GroupUtils.java */
/* JADX INFO: loaded from: classes2.dex */
class t extends OnResponseListener<GroupInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ y f7238a;

    t(y yVar) {
        this.f7238a = yVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(GroupInfo groupInfo) {
        if (groupInfo == null || groupInfo.getGroupMembers() == null || groupInfo.getGroupMembers().size() <= 0) {
            return;
        }
        this.f7238a.f(groupInfo);
        this.f7238a.g(groupInfo);
        if (groupInfo.getGroupPic() == null) {
            N.a(groupInfo.getGroupId(), groupInfo.getGroupName(), "");
        } else {
            N.a(groupInfo.getGroupId(), groupInfo.getGroupName(), groupInfo.getGroupPic());
        }
        GroupUtilsProxy.getInstance().storeUrls(groupInfo.getGroupId(), this.f7238a.c(groupInfo));
        Messenger.getDefault().sendNoMsg(ChatMessageToken.TOKEN_REFRESH_GROUP_PIC);
        Messenger.getDefault().send(new GroupNameModify(groupInfo.getGroupId(), groupInfo.getGroupName(), groupInfo.getGroupMembers().size()), ChatMessageToken.TOKEN_REFRESH_GROUP_NUM);
        Messenger.getDefault().send(new GroupNameModify(groupInfo.getGroupId(), groupInfo.getGroupName()), "token.refresh.group.name");
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        GroupOnError.showErrorTip(this.f7238a.a(), i);
        if (i == 8102) {
            ConversationClickStateHolder.getInstance().setState(1);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f7238a.a(), i);
    }
}
