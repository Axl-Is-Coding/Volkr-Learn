package com.disabngo.blockynexus.e.b.z;

import android.app.Activity;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.y;
import com.disabngo.blockynexus.entity.GroupAdminsParam;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.web.error.GroupOnError;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.web.OnResponseDataListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.z.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: GroupAdminManageViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class C0965d extends OnResponseDataListener<GroupInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ GroupAdminsParam f10404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0966e f10405b;

    C0965d(C0966e c0966e, GroupAdminsParam groupAdminsParam) {
        this.f10405b = c0966e;
        this.f10404a = groupAdminsParam;
    }

    @Override // com.sandboxol.common.base.web.OnResponseDataListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onErrorWithData(int i, String str, GroupInfo groupInfo) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(GroupInfo groupInfo) {
        if (groupInfo == null || groupInfo.getGroupMembers() == null || groupInfo.getGroupMembers().size() <= 0) {
            return;
        }
        Messenger.getDefault().send(groupInfo, MessageToken.TOKEN_REFRESH_GROUP_ADMIN);
        AppToastUtils.showShortPositiveTipToast(this.f10405b.f10406a, R.string.toast_set_admin_success);
        if (this.f10405b.f10406a instanceof Activity) {
            ((Activity) this.f10405b.f10406a).finish();
        }
        Messenger.getDefault().send(groupInfo, MessageToken.TOKEN_REFRESH_LIST_AFTER_BAN);
        if (this.f10404a.getOperationType() == 0) {
            ReportDataAdapter.onEvent(this.f10405b.f10406a, EventConstant.GROUP_ADMIN_SUC);
        } else {
            ReportDataAdapter.onEvent(this.f10405b.f10406a, EventConstant.GROUP_ADMIN_DESUC);
        }
        y.b().f(groupInfo);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        GroupOnError.showErrorTip(this.f10405b.f10406a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f10405b.f10406a, i);
    }
}
