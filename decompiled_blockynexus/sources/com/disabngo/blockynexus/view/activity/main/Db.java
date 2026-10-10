package com.disabngo.blockynexus.view.activity.main;

import android.content.Context;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.PartyAuthInfo;
import com.sandboxol.center.utils.DialogUtils;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.entity.InviteMessage;
import com.sandboxol.imchat.web.PartyApi;
import com.sandboxol.imchat.web.error.PartyOnError;

/* JADX INFO: compiled from: MainModel.java */
/* JADX INFO: loaded from: classes2.dex */
class Db extends OnResponseListener<PartyAuthInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ InviteMessage f10762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f10763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ bc f10764d;

    Db(bc bcVar, Context context, InviteMessage inviteMessage, int i) {
        this.f10764d = bcVar;
        this.f10761a = context;
        this.f10762b = inviteMessage;
        this.f10763c = i;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        DialogUtils.newsInstant().hideLoadingDialog();
        PartyOnError.showErrorTip(this.f10761a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        DialogUtils.newsInstant().hideLoadingDialog();
        PartyOnError.showServerError(this.f10761a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(PartyAuthInfo partyAuthInfo) {
        PartyApi.isPartyExist(this.f10761a, partyAuthInfo.getPartyQuerierService(), AccountCenter.newInstance().userId.get().longValue(), AccountCenter.newInstance().token.get(), this.f10762b.getTeamId(), new Cb(this, partyAuthInfo));
    }
}
