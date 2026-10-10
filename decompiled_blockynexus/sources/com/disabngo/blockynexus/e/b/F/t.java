package com.disabngo.blockynexus.e.b.F;

import android.app.Activity;
import com.disabngo.blockynexus.d.y;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.web.error.GroupOnError;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.GroupUtilsProxy;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.imchat.config.ChatMessageToken;
import com.sandboxol.imchat.entity.GroupNameModify;

/* JADX INFO: compiled from: GroupMemberViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class t extends OnResponseListener<GroupInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ u f9277a;

    t(u uVar) {
        this.f9277a = uVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(GroupInfo groupInfo) {
        if (groupInfo != null) {
            y.b().g(groupInfo);
            GroupUtilsProxy.getInstance().storeUrls(groupInfo.getGroupId(), y.b().c(groupInfo));
            Messenger.getDefault().send(groupInfo, MessageToken.TOKEN_REFRESH_GROUP_ADMIN);
            Messenger.getDefault().send(RefreshMsg.create(), MessageToken.TOKEN_REFRESH_MEMBERS_LIST);
            Messenger.getDefault().send(new GroupNameModify(groupInfo.getGroupId(), groupInfo.getGroupName(), groupInfo.getGroupMembers().size()), ChatMessageToken.TOKEN_REFRESH_GROUP_NUM);
            if (groupInfo.getGroupMembers().size() < 18) {
                Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_CLOSE_VIEW_ALL);
            }
            ReportDataAdapter.onEvent(this.f9277a.f9278a, EventConstant.GROUP_KICK_SUCCESS);
            ((Activity) this.f9277a.f9278a).finish();
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        GroupOnError.showErrorTip(this.f9277a.f9278a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f9277a.f9278a, i);
    }
}
