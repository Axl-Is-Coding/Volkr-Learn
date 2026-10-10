package com.disabngo.blockynexus.e.b.D;

import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.web.error.GroupOnError;
import com.sandboxol.common.base.model.DefaultListModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: GroupInfoListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class z extends OnResponseListener<GroupInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f9201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ A f9202b;

    z(A a2, OnResponseListener onResponseListener) {
        this.f9202b = a2;
        this.f9201a = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(GroupInfo groupInfo) {
        if (groupInfo == null || groupInfo.getGroupMembers() == null || groupInfo.getGroupMembers().size() <= 0) {
            return;
        }
        this.f9202b.b(groupInfo);
        Messenger.getDefault().send(groupInfo, "token.refresh.group.info");
        this.f9201a.onSuccess(this.f9202b.a(groupInfo));
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        GroupOnError.showErrorTip(((DefaultListModel) this.f9202b).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(((DefaultListModel) this.f9202b).context, i);
    }
}
