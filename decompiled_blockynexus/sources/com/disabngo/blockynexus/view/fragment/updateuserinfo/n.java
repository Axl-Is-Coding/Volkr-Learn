package com.disabngo.blockynexus.view.fragment.updateuserinfo;

import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.BuyGameResponse;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.center.view.dialog.CampaignGetIntegralRewardDialog;
import com.sandboxol.center.web.UserOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: UpdateUserInfoViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class n extends OnResponseListener<BuyGameResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UpdateUserInfoViewModel f12068a;

    n(UpdateUserInfoViewModel updateUserInfoViewModel) {
        this.f12068a = updateUserInfoViewModel;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(BuyGameResponse buyGameResponse) {
        ReportDataAdapter.onEvent(this.f12068a.f12048a, EventConstant.MORE_PERSINFO_SET_SUC);
        SharedUtils.putBoolean(this.f12068a.f12048a, AccountCenter.newInstance().userId.get() + SharedConstant.FRIEND_MATCH_IS_PERFECT_DATA, true);
        this.f12068a.f12052e.set(false);
        this.f12068a.f12053f.set(false);
        new CampaignGetIntegralRewardDialog(this.f12068a.f12048a).setIntData(R.mipmap.ic_diamond, String.valueOf(5)).show();
        AccountCenter.newInstance().golds.set(Long.valueOf(buyGameResponse.getGolds()));
        AccountCenter.newInstance().diamonds.set(Long.valueOf(buyGameResponse.getDiamonds()));
        AccountCenter.putAccountInfo();
        Messenger.getDefault().sendNoMsg(MessageToken.UPDATE_USER_INFO_RED_POINT);
        com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
        fVar.a(StringConstant.FRIEND_MATCH_PERFECT_USER_INFO_GET_REWARD, buyGameResponse);
        MessagerClient.getIns().sendMsg1(BroadcastType.BROADCAST_FRIEND_MATCH_PERFECT_USER_INFO, fVar);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        UserOnError.showErrorTip(this.f12068a.f12048a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f12068a.f12048a, i);
    }
}
