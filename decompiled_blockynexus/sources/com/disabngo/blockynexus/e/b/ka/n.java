package com.disabngo.blockynexus.e.b.ka;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.TribeDonationInfo;
import com.disabngo.blockynexus.web.error.TribeOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: TribeContributionViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class n extends OnResponseListener<TribeDonationInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ p f9876a;

    n(p pVar) {
        this.f9876a = pVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(TribeDonationInfo tribeDonationInfo) {
        this.f9876a.f9880b.set(Integer.valueOf(tribeDonationInfo.getLevel()));
        this.f9876a.f9881c.set(Integer.valueOf(tribeDonationInfo.getCurrentExperience()));
        this.f9876a.f9882d.set(Integer.valueOf(tribeDonationInfo.getMaxExperience()));
        p pVar = this.f9876a;
        pVar.f9883e.set(pVar.f9879a.getString(R.string.tribe_current_total, Integer.valueOf(tribeDonationInfo.getCurrentExperience()), Integer.valueOf(tribeDonationInfo.getMaxExperience())));
        p pVar2 = this.f9876a;
        pVar2.f9884f.set(pVar2.f9879a.getString(R.string.tribe_current_total, Integer.valueOf(tribeDonationInfo.getCurrentTask()), Integer.valueOf(tribeDonationInfo.getMaxTask())));
        p pVar3 = this.f9876a;
        pVar3.g.set(pVar3.f9879a.getString(R.string.tribe_current_total, Integer.valueOf(tribeDonationInfo.getCurrentGold()), Integer.valueOf(tribeDonationInfo.getMaxGold())));
        p pVar4 = this.f9876a;
        pVar4.h.set(pVar4.f9879a.getString(R.string.tribe_current_total, Integer.valueOf(tribeDonationInfo.getCurrentDiamond()), Integer.valueOf(tribeDonationInfo.getMaxDiamond())));
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        TribeOnError.showErrorTip(this.f9876a.f9879a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f9876a.f9879a, i);
    }
}
