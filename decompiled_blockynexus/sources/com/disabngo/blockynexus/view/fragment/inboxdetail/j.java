package com.disabngo.blockynexus.view.fragment.inboxdetail;

import com.disabngo.blockynexus.d.y;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.utils.logic.N;
import com.disabngo.blockynexus.web.error.GroupOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.GroupUtilsProxy;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.imchat.config.ChatMessageToken;

/* JADX INFO: compiled from: InboxDetailViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class j extends OnResponseListener<GroupInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f11747a;

    j(k kVar) {
        this.f11747a = kVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(GroupInfo groupInfo) {
        y.b().f(groupInfo);
        y.b().g(groupInfo);
        if (groupInfo.getGroupPic() == null) {
            N.a(groupInfo.getGroupId(), groupInfo.getGroupName(), "");
        } else {
            N.a(groupInfo.getGroupId(), groupInfo.getGroupName(), groupInfo.getGroupPic());
        }
        GroupUtilsProxy.getInstance().storeUrls(groupInfo.getGroupId(), y.b().c(groupInfo));
        Messenger.getDefault().sendNoMsg(ChatMessageToken.TOKEN_REFRESH_GROUP_PIC);
        N.a(this.f11747a.f11748a, String.valueOf(groupInfo.getGroupId()), groupInfo.getGroupName(), false, groupInfo.getGroupMembers().size());
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        GroupOnError.showErrorTip(this.f11747a.f11748a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f11747a.f11748a, i);
    }
}
