package com.disabngo.blockynexus.view.fragment.tribehas;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.TribeOnError;
import com.sandboxol.center.entity.TribeCenter;
import com.sandboxol.center.entity.TribeDetail;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: TribeHasModel.java */
/* JADX INFO: loaded from: classes2.dex */
class N extends OnResponseListener<TribeDetail> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Q f11981a;

    N(Q q) {
        this.f11981a = q;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(TribeDetail tribeDetail) {
        this.f11981a.f11985b.set(tribeDetail.getHeadPic());
        this.f11981a.f11986c.set(tribeDetail.getName());
        this.f11981a.f11987d.set(tribeDetail.getExperience());
        this.f11981a.f11988e.set(Integer.valueOf(tribeDetail.getLevel()));
        this.f11981a.f11989f.set(tribeDetail.getDetails());
        this.f11981a.g.set(tribeDetail.getTags());
        this.f11981a.h.set(tribeDetail.getCurrentPeopleTotalCount());
        TribeCenter.newInstance().updateBaseInfo((String) this.f11981a.f11986c.get(), (String) this.f11981a.f11985b.get(), ((Integer) this.f11981a.f11988e.get()).intValue(), tribeDetail.getFreeVerify(), new M(this));
        com.disabngo.blockynexus.utils.logic.N.a(tribeDetail.getClanId(), tribeDetail.getName() + "(" + this.f11981a.f11984a.getString(R.string.main_tribe) + ")", tribeDetail.getHeadPic());
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        TribeOnError.showErrorTip(this.f11981a.f11984a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f11981a.f11984a, i);
    }
}
