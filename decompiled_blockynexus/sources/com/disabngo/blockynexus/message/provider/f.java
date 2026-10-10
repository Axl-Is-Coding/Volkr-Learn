package com.disabngo.blockynexus.message.provider;

import android.content.Context;
import com.sandboxol.center.entity.PartyAuthInfo;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.imchat.message.entity.InviteTeamMessage;
import com.sandboxol.imchat.utils.DialogUtils;
import com.sandboxol.imchat.web.PartyApi;
import com.sandboxol.imchat.web.error.PartyOnError;
import io.rong.imkit.model.UIMessage;

/* JADX INFO: compiled from: InviteTeamMessageProvider.java */
/* JADX INFO: loaded from: classes2.dex */
class f extends OnResponseListener<PartyAuthInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ InviteTeamMessage f10455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ UIMessage f10456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ h f10457d;

    f(h hVar, Context context, InviteTeamMessage inviteTeamMessage, UIMessage uIMessage) {
        this.f10457d = hVar;
        this.f10454a = context;
        this.f10455b = inviteTeamMessage;
        this.f10456c = uIMessage;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        DialogUtils.newsInstant().hideLoadingDialog();
        PartyOnError.showErrorTip(this.f10454a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        DialogUtils.newsInstant().hideLoadingDialog();
        PartyOnError.showServerError(this.f10454a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(PartyAuthInfo partyAuthInfo) {
        PartyApi.isPartyExist(this.f10454a, partyAuthInfo.getPartyQuerierService(), this.f10457d.f10461c, this.f10457d.f10462d, this.f10455b.getTeamId(), new e(this, partyAuthInfo));
    }
}
