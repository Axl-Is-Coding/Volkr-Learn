package com.disabngo.blockynexus.view.activity.tribeshop;

import androidx.databinding.ObservableMap;
import com.disabngo.blockynexus.d.K;
import com.sandboxol.center.router.manager.DressManager;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: compiled from: TribeShopModel.java */
/* JADX INFO: loaded from: classes2.dex */
class z extends OnResponseListener<List<SingleDressInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Action0 f11188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ A f11189b;

    z(A a2, Action0 action0) {
        this.f11189b = a2;
        this.f11188a = action0;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        com.sandboxol.decorate.web.u.a(this.f11189b.f11143a, i);
        Action0 action0 = this.f11188a;
        if (action0 != null) {
            action0.call();
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f11189b.f11143a, i);
        Action0 action0 = this.f11188a;
        if (action0 != null) {
            action0.call();
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<SingleDressInfo> list) {
        K.a((ObservableMap<Long, String>) this.f11189b.f11145c);
        for (SingleDressInfo singleDressInfo : list) {
            this.f11189b.f11145c.put(Long.valueOf(singleDressInfo.getTypeId()), singleDressInfo.getResourceId());
            this.f11189b.f11144b.put(Long.valueOf(singleDressInfo.getTypeId()), singleDressInfo.getIconUrl());
        }
        DressManager.handleOnesies(list, this.f11189b.f11145c, this.f11189b.f11144b, true);
        DressManager.useClothes(this.f11189b.f11145c);
        Action0 action0 = this.f11188a;
        if (action0 != null) {
            action0.call();
        }
    }
}
