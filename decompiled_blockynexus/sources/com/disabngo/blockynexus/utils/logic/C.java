package com.disabngo.blockynexus.utils.logic;

import android.content.Context;
import android.os.Bundle;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.web.error.GroupOnError;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: RongIMLogic.java */
/* JADX INFO: loaded from: classes2.dex */
class C extends OnResponseListener<GroupInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f10518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ D f10519c;

    C(D d2, Context context, long j) {
        this.f10519c = d2;
        this.f10517a = context;
        this.f10518b = j;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(GroupInfo groupInfo) {
        if (groupInfo == null || groupInfo.getGroupMembers() == null) {
            AppToastUtils.showShortNegativeTipToast(this.f10517a, R.string.toast_group_not_exit);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(SharedConstant.KEY_GROUP_FROM_INVITE_CARD, true);
        bundle.putString("key.group.id", String.valueOf(this.f10518b));
        Context context = this.f10517a;
        TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.D.v.class, context.getString(R.string.group_info), bundle);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        GroupOnError.showErrorTip(this.f10517a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f10517a, i);
    }
}
