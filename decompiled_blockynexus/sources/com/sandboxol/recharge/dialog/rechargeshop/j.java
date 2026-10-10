package com.sandboxol.recharge.dialog.rechargeshop;

import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.StarCodeUser;
import com.sandboxol.center.web.UserOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.game.R;

/* JADX INFO: compiled from: RechargeShopDialog.java */
/* JADX INFO: loaded from: classes4.dex */
class j extends OnResponseListener<StarCodeUser> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f18870a;

    j(k kVar) {
        this.f18870a = kVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(StarCodeUser starCodeUser) {
        if (starCodeUser == null) {
            return;
        }
        this.f18870a.f18875e.set(starCodeUser);
        if (starCodeUser.getDisable() != 0) {
            this.f18870a.f18873c.f17684a.i.setVisibility(0);
            this.f18870a.f18873c.f17684a.i.setText(R.string.dialog_recharge_tv_star_code_invalid_tip);
            this.f18870a.f18873c.f17684a.f17691b.getBackground().setLevel(1);
            return;
        }
        this.f18870a.f18873c.f17684a.f17691b.setVisibility(8);
        this.f18870a.f18873c.f17684a.f17690a.setVisibility(8);
        this.f18870a.f18873c.f17684a.i.setVisibility(8);
        this.f18870a.f18873c.f17684a.f17691b.getBackground().setLevel(0);
        this.f18870a.f18873c.f17684a.f17694e.setVisibility(0);
        this.f18870a.f18873c.f17684a.h.setVisibility(0);
        this.f18870a.f18873c.f17684a.g.setText(((FullScreenDialog) this.f18870a).context.getString(R.string.dialog_recharge_tv_star_support, starCodeUser.getNickName()));
        ReportDataAdapter.onEvent(((FullScreenDialog) this.f18870a).context, EventConstant.STAR_GAMESHOW_ADDSCC);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f18870a.f18873c.f17684a.i.setVisibility(0);
        this.f18870a.f18873c.f17684a.i.setText(R.string.dialog_recharge_tv_star_code_invalid_tip);
        this.f18870a.f18873c.f17684a.f17691b.getBackground().setLevel(1);
        UserOnError.showErrorTip(((FullScreenDialog) this.f18870a).context, i);
        ReportDataAdapter.onEvent(((FullScreenDialog) this.f18870a).context, EventConstant.STAR_GAMESHOW_INVALIDCODE);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(((FullScreenDialog) this.f18870a).context, i);
    }
}
