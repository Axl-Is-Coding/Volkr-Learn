package com.disabngo.blockynexus.e.b.H;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.entity.GroupRequest;
import com.disabngo.blockynexus.web.error.GroupOnError;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;

/* JADX INFO: compiled from: GroupVerificationItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class g extends OnResponseListener<GroupInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f9300a;

    g(h hVar) {
        this.f9300a = hVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(GroupInfo groupInfo) {
        if (groupInfo == null || groupInfo.getGroupMembers() == null || groupInfo.getGroupMembers().size() <= 0) {
            return;
        }
        h hVar = this.f9300a;
        hVar.f9301a.set(((ListItemViewModel) hVar).context.getString(R.string.agree_add_friend));
        this.f9300a.f9302b.set(true);
        AppToastUtils.showShortPositiveTipToast(((ListItemViewModel) this.f9300a).context, R.string.new_group_join_group_success);
        if (((GroupRequest) ((ListItemViewModel) this.f9300a).item).getType() == 0) {
            ReportDataAdapter.onEvent(((ListItemViewModel) this.f9300a).context, EventConstant.GROUP_AGREE_ENTERGROUP);
        } else if (((GroupRequest) ((ListItemViewModel) this.f9300a).item).getType() == 1) {
            ReportDataAdapter.onEvent(((ListItemViewModel) this.f9300a).context, EventConstant.GROUP_AGREE_JOINGROUP);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        GroupOnError.showErrorTip(((ListItemViewModel) this.f9300a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        AppToastUtils.showShortPositiveTipToast(((ListItemViewModel) this.f9300a).context, R.string.refuse_add_friend_failed);
    }
}
