package com.disabngo.blockynexus.b;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.TurntableStatus;
import com.disabngo.blockynexus.web.error.CampaignOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: CampaignControl.java */
/* JADX INFO: loaded from: classes.dex */
class a extends OnResponseListener<TurntableStatus> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ObservableField f7161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f7162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ b f7163c;

    a(b bVar, ObservableField observableField, Context context) {
        this.f7163c = bVar;
        this.f7161a = observableField;
        this.f7162b = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(TurntableStatus turntableStatus) {
        if (turntableStatus != null) {
            this.f7161a.set(Integer.valueOf(turntableStatus.getIsFree() > 0 ? R.mipmap.ic_jackpot_red_point_logo : R.mipmap.ic_jackpot_logo));
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        CampaignOnError.showErrorTip(this.f7162b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f7162b, i);
    }
}
