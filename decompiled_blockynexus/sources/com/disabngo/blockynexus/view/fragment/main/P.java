package com.disabngo.blockynexus.view.fragment.main;

import android.content.Context;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.PartyAuthInfo;
import com.sandboxol.center.utils.DialogUtils;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.entity.FriendPartyStatus;
import com.sandboxol.imchat.web.PartyApi;
import com.sandboxol.imchat.web.error.PartyOnError;

/* JADX INFO: compiled from: OtherWayEnterGameLogic.java */
/* JADX INFO: loaded from: classes2.dex */
class P extends OnResponseListener<PartyAuthInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f11786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ FriendPartyStatus f11787b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f11788c;

    P(Context context, FriendPartyStatus friendPartyStatus, String str) {
        this.f11786a = context;
        this.f11787b = friendPartyStatus;
        this.f11788c = str;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        DialogUtils.newsInstant().hideLoadingDialog();
        PartyOnError.showErrorTip(this.f11786a, i);
        com.disabngo.blockynexus.d.n.a(this.f11786a, "getPartyAuth, " + i + ": " + str);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        DialogUtils.newsInstant().hideLoadingDialog();
        PartyOnError.showServerError(this.f11786a, i);
        com.disabngo.blockynexus.d.n.a(this.f11786a, "getPartyAuth, " + String.valueOf(i));
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(PartyAuthInfo partyAuthInfo) {
        PartyApi.isPartyExist(this.f11786a, partyAuthInfo.getPartyQuerierService(), AccountCenter.newInstance().userId.get().longValue(), AccountCenter.newInstance().token.get(), this.f11787b.getTeamId(), new O(this, partyAuthInfo));
    }
}
