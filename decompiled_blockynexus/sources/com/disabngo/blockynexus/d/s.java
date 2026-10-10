package com.disabngo.blockynexus.d;

import com.disabngo.blockynexus.d.y.a;
import com.disabngo.blockynexus.entity.ConversationClickStateHolder;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.entity.GroupMember;
import com.disabngo.blockynexus.utils.logic.N;
import com.disabngo.blockynexus.web.error.GroupOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.GroupUtilsProxy;
import com.sandboxol.common.utils.TextEllipsizeUtil;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.imchat.config.ChatMessageToken;
import com.sandboxol.imchat.entity.GroupNameModify;

/* JADX INFO: compiled from: GroupUtils.java */
/* JADX INFO: loaded from: classes2.dex */
class s extends OnResponseListener<GroupInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ y f7237a;

    s(y yVar) {
        this.f7237a = yVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(GroupInfo groupInfo) {
        if (groupInfo == null || groupInfo.getGroupMembers() == null || groupInfo.getGroupMembers().size() <= 0) {
            return;
        }
        this.f7237a.f7246c.put(Long.valueOf(groupInfo.getGroupId()), this.f7237a.new a(groupInfo.getGroupName(), ""));
        GroupUtilsProxy.getInstance().storeUrls(groupInfo.getGroupId(), this.f7237a.c(groupInfo));
        GroupUtilsProxy.getInstance().setOfficial(groupInfo.getGroupId(), groupInfo.getOfficialGroup() == 1);
        N.a(groupInfo.getGroupId(), TextEllipsizeUtil.ellipsizeString(20, groupInfo.getGroupName(), TextEllipsizeUtil.SignLib.END_POINT), "");
        this.f7237a.g(groupInfo);
        Messenger.getDefault().send(new GroupNameModify(groupInfo.getGroupId(), groupInfo.getGroupName()), "token.refresh.group.name");
        Messenger.getDefault().send(new GroupNameModify(groupInfo.getGroupId(), groupInfo.getGroupName(), groupInfo.getGroupMembers().size()), ChatMessageToken.TOKEN_REFRESH_GROUP_NUM);
        for (GroupMember groupMember : groupInfo.getGroupMembers()) {
            this.f7237a.a(groupMember.getUserId(), groupMember.getUserName());
            if (groupMember.getUserName() != null) {
                N.a(groupInfo.getGroupId(), groupMember.getUserId(), groupMember.getUserName(), groupMember.getPic());
            }
        }
        this.f7237a.f(groupInfo);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        GroupOnError.showErrorTip(this.f7237a.a(), i);
        if (i == 8102) {
            ConversationClickStateHolder.getInstance().setState(1);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f7237a.a(), i);
    }
}
