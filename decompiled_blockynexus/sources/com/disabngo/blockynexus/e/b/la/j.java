package com.disabngo.blockynexus.e.b.la;

import android.content.Context;
import android.os.Bundle;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.TribeClanRequest;
import com.disabngo.blockynexus.web.error.TribeOnError;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.imchat.config.ChatMessageToken;

/* JADX INFO: compiled from: TribeCreateModel.java */
/* JADX INFO: loaded from: classes2.dex */
class j extends OnResponseListener<TribeClanRequest> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f9914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ l f9915b;

    j(l lVar, int i) {
        this.f9915b = lVar;
        this.f9914a = i;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(TribeClanRequest tribeClanRequest) {
        this.f9915b.f9919c.set(true);
        AppToastUtils.showShortPositiveTipToast(this.f9915b.f9917a, R.string.tribe_create_success);
        BillingManager.getInstance().updateUserMoney((Context) this.f9915b.f9917a, true);
        Messenger.getDefault().send(true, ChatMessageToken.TOKEN_TRIBE_JOIN_OR_EXIT);
        Bundle bundle = new Bundle();
        bundle.putBoolean(StringConstant.TRIBE_IS_FINISH_INVITE, true);
        TemplateUtils.startTemplate(this.f9915b.f9917a, com.disabngo.blockynexus.e.b.na.c.class, this.f9915b.f9917a.getString(R.string.tribe_invite_friend), bundle);
        if (this.f9914a == 2) {
            ReportDataAdapter.onEvent(this.f9915b.f9917a, EventConstant.CLAN_BUILD_SUC, StringConstant.CHRISTMAS_GOLDS);
        } else {
            ReportDataAdapter.onEvent(this.f9915b.f9917a, EventConstant.CLAN_BUILD_SUC, StringConstant.MONEY_TYPE_DIAMOND);
        }
        if (this.f9915b.f9917a.isFinishing()) {
            return;
        }
        this.f9915b.f9917a.finish();
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f9915b.f9919c.set(true);
        TribeOnError.showErrorTip(this.f9915b.f9917a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f9915b.f9919c.set(true);
        ServerOnError.showOnServerError(this.f9915b.f9917a, i);
    }
}
