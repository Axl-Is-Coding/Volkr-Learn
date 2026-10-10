package com.disabngo.blockynexus.view.fragment.partyhall;

import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.PartyAuthInfo;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyItem;
import com.sandboxol.center.utils.DialogUtils;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.imchat.web.PartyApi;
import com.sandboxol.imchat.web.error.PartyOnError;

/* JADX INFO: compiled from: PartyHallItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class t extends OnResponseListener<PartyAuthInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ u f11943a;

    t(u uVar) {
        this.f11943a = uVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        DialogUtils.newsInstant().hideLoadingDialog();
        PartyOnError.showErrorTip(((ListItemViewModel) this.f11943a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        DialogUtils.newsInstant().hideLoadingDialog();
        PartyOnError.showServerError(((ListItemViewModel) this.f11943a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(PartyAuthInfo partyAuthInfo) {
        PartyApi.isPartyExist(((ListItemViewModel) this.f11943a).context, partyAuthInfo.getPartyQuerierService(), AccountCenter.newInstance().userId.get().longValue(), AccountCenter.newInstance().token.get(), ((PartyItem) ((ListItemViewModel) this.f11943a).item).getTeamId(), new s(this, partyAuthInfo));
    }
}
