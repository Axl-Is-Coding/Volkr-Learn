package com.disabngo.blockynexus.e.b.E;

import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.web.error.GroupOnError;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: GroupManageViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class v extends OnResponseListener<GroupInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ x f9233a;

    v(x xVar) {
        this.f9233a = xVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(GroupInfo groupInfo) {
        if (groupInfo == null || groupInfo.getGroupMembers() == null || groupInfo.getGroupMembers().size() <= 0) {
            return;
        }
        x xVar = this.f9233a;
        xVar.f9239e.set(Integer.valueOf(xVar.f9237c.getInviteStatus()));
        this.f9233a.f9235a = groupInfo;
        Messenger.getDefault().send(this.f9233a.f9235a, MessageToken.TOKEN_REFRESH_GROUP_INVITE_STATUS);
        if (this.f9233a.f9237c.getInviteStatus() == 1) {
            ReportDataAdapter.onEvent(this.f9233a.f9236b, EventConstant.GROUP_OPEN_INVITE);
        } else {
            ReportDataAdapter.onEvent(this.f9233a.f9236b, EventConstant.GROUP_CLOSE_INVITE);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        GroupOnError.showErrorTip(this.f9233a.f9236b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f9233a.f9236b, i);
    }
}
