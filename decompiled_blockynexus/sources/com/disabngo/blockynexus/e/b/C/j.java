package com.disabngo.blockynexus.e.b.C;

import android.app.Activity;
import android.text.TextUtils;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.y;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.utils.logic.N;
import com.disabngo.blockynexus.web.error.GroupOnError;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: GroupEditViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class j extends OnResponseListener<GroupInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f9140a;

    j(l lVar) {
        this.f9140a = lVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(GroupInfo groupInfo) {
        if (groupInfo == null || groupInfo.getGroupMembers() == null || groupInfo.getGroupMembers().size() <= 0) {
            return;
        }
        Messenger.getDefault().send(this.f9140a.f9150f.toString(), "token.refresh.group.name");
        if (TextUtils.isEmpty(groupInfo.getGroupPic())) {
            N.a(groupInfo.getGroupId(), groupInfo.getGroupName(), "");
        } else {
            N.a(groupInfo.getGroupId(), groupInfo.getGroupName(), groupInfo.getGroupPic());
        }
        y.b().f(groupInfo);
        AppToastUtils.showLongPositiveTipToast(this.f9140a.f9145a, this.f9140a.f9145a.getString(R.string.group_change_name_success_content));
        ReportDataAdapter.onEvent(this.f9140a.f9145a, EventConstant.GROUP_MODIFYNAME_SUCCESS);
        ((Activity) this.f9140a.f9145a).finish();
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        GroupOnError.showErrorTip(this.f9140a.f9145a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        if (i == 4) {
            AppToastUtils.showShortNegativeTipToast(this.f9140a.f9145a, this.f9140a.f9145a.getString(R.string.group_name_error_tip));
        } else {
            ServerOnError.showOnServerError(this.f9140a.f9145a, i);
        }
    }
}
