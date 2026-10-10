package com.disabngo.blockynexus.e.b.sa;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.ClanResponse;
import com.disabngo.blockynexus.web.error.TribeOnError;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.TribeCenter;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: TribeSettingModel.java */
/* JADX INFO: loaded from: classes2.dex */
class c extends OnResponseListener<ClanResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ObservableField f10169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f10170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ d f10171c;

    c(d dVar, ObservableField observableField, Context context) {
        this.f10171c = dVar;
        this.f10169a = observableField;
        this.f10170b = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(ClanResponse clanResponse) {
        TribeCenter.newInstance().verification.set(Integer.valueOf(clanResponse.getFreeVerify()));
        this.f10169a.set(true);
        if (clanResponse.getFreeVerify() == 1) {
            ReportDataAdapter.onEvent(this.f10170b, EventConstant.CLAN_VERFREE_OPEN);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i == 7006) {
            AppToastUtils.showShortPositiveTipToast(this.f10170b, R.string.tribe_verification_no_tribe);
        } else if (i == 7003) {
            AppToastUtils.showShortPositiveTipToast(this.f10170b, R.string.tribe_verification_not_chief);
        } else {
            TribeOnError.showErrorTip(this.f10170b, i);
        }
        this.f10169a.set(true);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f10170b, i);
        this.f10169a.set(true);
    }
}
