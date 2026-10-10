package com.disabngo.blockynexus.view.fragment.groupbannedtimelist;

import android.app.Activity;
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

/* JADX INFO: compiled from: GroupBannedTimeModel.java */
/* JADX INFO: loaded from: classes2.dex */
class f extends OnResponseListener<GroupInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f11726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f11727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f11728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ g f11729d;

    f(g gVar, Context context, String str, String str2) {
        this.f11729d = gVar;
        this.f11726a = context;
        this.f11727b = str;
        this.f11728c = str2;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(GroupInfo groupInfo) {
        if (groupInfo != null) {
            ReportDataAdapter.onEvent(this.f11726a, EventConstant.GROUP_BAN_SUC);
            Context context = this.f11726a;
            AppToastUtils.showShortPositiveTipToast(context, context.getString(R.string.new_group_ban_success, this.f11727b, this.f11728c));
            Messenger.getDefault().send(groupInfo, MessageToken.TOKEN_REFRESH_LIST_AFTER_BAN);
            ((Activity) this.f11726a).finish();
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        GroupOnError.showErrorTip(this.f11726a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f11726a, i);
    }
}
