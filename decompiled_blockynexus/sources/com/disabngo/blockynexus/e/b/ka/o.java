package com.disabngo.blockynexus.e.b.ka;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.TribeDonationResponse;
import com.disabngo.blockynexus.web.error.TribeOnError;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.listener.OnViewClickListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;

/* JADX INFO: compiled from: TribeContributionViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class o extends OnResponseListener<TribeDonationResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f9877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ p f9878b;

    o(p pVar, int i) {
        this.f9878b = pVar;
        this.f9877a = i;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(TribeDonationResponse tribeDonationResponse) {
        this.f9878b.a(tribeDonationResponse.getExperienceGot(), tribeDonationResponse.getTribeCurrencyGot(), new OnViewClickListener() { // from class: com.disabngo.blockynexus.e.b.ka.b
            @Override // com.sandboxol.common.listener.OnViewClickListener
            public final void onClick() {
                this.f9870a.a();
            }
        });
        Messenger.getDefault().send(RefreshMsg.create(), MessageToken.TOKEN_TRIBE_CONTRIBUTION);
        Messenger.getDefault().send(RefreshMsg.create(), MessageToken.TOKEN_TRIBE_MEMBER);
        this.f9878b.j();
        if (this.f9877a == 2) {
            ReportDataAdapter.onEvent(this.f9878b.f9879a, EventConstant.CLAN_GOLD_DONATE_SUC);
        }
        if (this.f9877a == 1) {
            ReportDataAdapter.onEvent(this.f9878b.f9879a, EventConstant.CLAN_CUBE_DONATE_SUC);
        }
        SandboxReportManager.onEvent(ReportEvent.USER_CLICK_DONATE, ReportEventType.USER_ORDINARY_BEHAVIOR, "android", "1");
        SandboxReportManager.onEvent(ReportEvent.USER_CLICK_DONATE, ReportEventType.USER_FIRST_BEHAVIOR, "android", "1");
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i == 5006) {
            AppToastUtils.showShortNegativeTipToast(this.f9878b.f9879a, R.string.tribe_not_enough_diamond_or_gold);
        } else {
            TribeOnError.showErrorTip(this.f9878b.f9879a, i);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f9878b.f9879a, i);
    }

    public /* synthetic */ void a() {
        BillingManager.getInstance().updateUserMoney(this.f9878b.f9879a, true);
    }
}
