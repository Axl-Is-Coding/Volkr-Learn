package com.disabngo.blockynexus.e.b.F;

import android.app.Activity;
import com.disabngo.blockynexus.d.y;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.utils.logic.N;
import com.disabngo.blockynexus.web.error.GroupOnError;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.GroupUtilsProxy;
import com.sandboxol.common.utils.TextEllipsizeUtil;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: GroupMemberViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class r extends OnResponseListener<GroupInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ u f9275a;

    r(u uVar) {
        this.f9275a = uVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(GroupInfo groupInfo) {
        this.f9275a.n.set(true);
        if (groupInfo != null) {
            BillingManager.getInstance().updateUserMoney(this.f9275a.f9278a, true);
            String strEllipsizeString = TextEllipsizeUtil.ellipsizeString(20, groupInfo.getGroupName(), TextEllipsizeUtil.SignLib.END_POINT);
            y.b().g(groupInfo);
            y.b().f(groupInfo);
            GroupUtilsProxy.getInstance().storeUrls(groupInfo.getGroupId(), y.b().c(groupInfo));
            N.a(this.f9275a.f9278a, String.valueOf(groupInfo.getGroupId()), strEllipsizeString, false, groupInfo.getGroupMembers().size());
            ReportDataAdapter.onEvent(this.f9275a.f9278a, EventConstant.GROUP_START_SUCCESS);
            ((Activity) this.f9275a.f9278a).finish();
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f9275a.n.set(true);
        GroupOnError.showErrorTip(this.f9275a.f9278a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f9275a.n.set(true);
        ServerOnError.showOnServerError(this.f9275a.f9278a, i);
    }
}
