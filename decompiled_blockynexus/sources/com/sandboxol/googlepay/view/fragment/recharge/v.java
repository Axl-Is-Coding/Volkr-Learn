package com.sandboxol.googlepay.view.fragment.recharge;

import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.StarCodeUser;
import com.sandboxol.center.web.UserOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.googlepay.R;

/* JADX INFO: compiled from: RechargeViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
class v extends OnResponseListener<StarCodeUser> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ w f18389a;

    v(w wVar) {
        this.f18389a = wVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(StarCodeUser starCodeUser) {
        if (starCodeUser == null) {
            return;
        }
        this.f18389a.h.set(starCodeUser);
        if (starCodeUser.getDisable() != 0) {
            this.f18389a.f18391b.k.setVisibility(0);
            this.f18389a.f18391b.k.setText(R.string.googleplay_recharge_tv_star_code_invalid_tip);
            this.f18389a.f18391b.f18185b.getBackground().setLevel(1);
            ReportDataAdapter.onEvent(this.f18389a.f18390a, EventConstant.STAR_PLFSHOW_INVALIDCODE);
            return;
        }
        this.f18389a.f18391b.f18185b.setVisibility(8);
        this.f18389a.f18391b.f18184a.setVisibility(8);
        this.f18389a.f18391b.k.setVisibility(8);
        this.f18389a.f18391b.f18185b.getBackground().setLevel(0);
        this.f18389a.f18391b.f18187d.setVisibility(0);
        this.f18389a.f18391b.j.setVisibility(0);
        this.f18389a.f18391b.i.setText(this.f18389a.f18390a.getString(R.string.googleplay_recharge_tv_star_support, starCodeUser.getNickName()));
        ReportDataAdapter.onEvent(this.f18389a.f18390a, EventConstant.STAR_PLFSHOW_ADDSCC);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f18389a.f18391b.k.setVisibility(0);
        this.f18389a.f18391b.k.setText(R.string.googleplay_recharge_tv_star_code_invalid_tip);
        this.f18389a.f18391b.f18185b.getBackground().setLevel(1);
        UserOnError.showErrorTip(this.f18389a.f18390a, i);
        ReportDataAdapter.onEvent(this.f18389a.f18390a, EventConstant.STAR_PLFSHOW_INVALIDCODE);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f18389a.f18390a, i);
    }
}
