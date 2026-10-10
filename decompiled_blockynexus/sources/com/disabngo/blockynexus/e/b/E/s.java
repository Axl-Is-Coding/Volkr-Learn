package com.disabngo.blockynexus.e.b.E;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.y;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.web.error.GroupOnError;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.web.OnResponseDataListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: GroupAdminItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class s extends OnResponseDataListener<GroupInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ t f9226a;

    s(t tVar) {
        this.f9226a = tVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseDataListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onErrorWithData(int i, String str, GroupInfo groupInfo) {
        AppToastUtils.showShortNegativeTipToast(this.f9226a.context, str);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        GroupOnError.showErrorTip(this.f9226a.context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f9226a.context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(GroupInfo groupInfo) {
        if (!(this.f9226a.context instanceof Activity) || groupInfo == null || groupInfo.getGroupMembers() == null || groupInfo.getGroupMembers().size() <= 0) {
            return;
        }
        ReportDataAdapter.onEvent(this.f9226a.context, EventConstant.GROUP_MASTER_TRANSFER_SUC);
        AppToastUtils.showShortPositiveTipToast(this.f9226a.context, R.string.success);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_TRANSFER_GROUP_OWNER);
        Activity activity = (Activity) this.f9226a.context;
        Bundle bundle = new Bundle();
        bundle.putString("key.group.id", String.valueOf(this.f9226a.g.getGroupId()));
        Context context = this.f9226a.context;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.D.v.class, context.getString(R.string.group_info), bundle);
        y.b().f(groupInfo);
        activity.finish();
    }
}
