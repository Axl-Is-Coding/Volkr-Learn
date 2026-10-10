package com.disabngo.blockynexus.e.b.C;

import android.app.Activity;
import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.entity.GroupInfoParam;
import com.disabngo.blockynexus.web.error.GroupOnError;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: GroupEditModel.java */
/* JADX INFO: loaded from: classes2.dex */
class h extends OnResponseListener<GroupInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f9137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ GroupInfoParam f9138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ i f9139c;

    h(i iVar, Context context, GroupInfoParam groupInfoParam) {
        this.f9139c = iVar;
        this.f9137a = context;
        this.f9138b = groupInfoParam;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(GroupInfo groupInfo) {
        if (groupInfo == null || groupInfo.getGroupMembers() == null || groupInfo.getGroupMembers().size() <= 0) {
            return;
        }
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
        Context context = this.f9137a;
        AppToastUtils.showLongPositiveTipToast(context, context.getString(R.string.group_change_notice_success_tip));
        Messenger.getDefault().send(this.f9138b, MessageToken.TOKEN_REFRESH_GROUP_NOTICE_STATE);
        ReportDataAdapter.onEvent(this.f9137a, EventConstant.GROUP_ANN_SUC_LORD);
        ((Activity) this.f9137a).finish();
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        GroupOnError.showErrorTip(this.f9137a, i);
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        if (i == 4) {
            Context context = this.f9137a;
            AppToastUtils.showShortNegativeTipToast(context, context.getString(R.string.group_name_error_tip));
        } else {
            ServerOnError.showOnServerError(this.f9137a, i);
        }
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
    }
}
