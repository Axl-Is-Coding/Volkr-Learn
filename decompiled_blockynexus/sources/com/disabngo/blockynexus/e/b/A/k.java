package com.disabngo.blockynexus.e.b.A;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.web.error.GroupOnError;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: GroupBannedModel.java */
/* JADX INFO: loaded from: classes2.dex */
class k extends OnResponseListener<GroupInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f9101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ l f9102b;

    k(l lVar, Context context) {
        this.f9102b = lVar;
        this.f9101a = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(GroupInfo groupInfo) {
        if (groupInfo == null || groupInfo.getGroupMembers() == null || groupInfo.getGroupMembers().size() <= 0) {
            return;
        }
        ReportDataAdapter.onEvent(this.f9101a, EventConstant.GROUP_ADMIN_DESUC);
        AppToastUtils.showShortPositiveTipToast(this.f9101a, R.string.new_group_remove_ban_success);
        Messenger.getDefault().send(groupInfo, MessageToken.TOKEN_REFRESH_LIST_AFTER_BAN);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        GroupOnError.showErrorTip(this.f9101a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f9101a, i);
    }
}
