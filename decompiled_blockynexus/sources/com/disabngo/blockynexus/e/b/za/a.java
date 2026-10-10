package com.disabngo.blockynexus.e.b.za;

import android.content.Context;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.BuyVipEntity;
import com.sandboxol.center.web.UserOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: VipModel.java */
/* JADX INFO: loaded from: classes.dex */
class a extends OnResponseListener<BuyVipEntity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ b f10413b;

    a(b bVar, Context context) {
        this.f10413b = bVar;
        this.f10412a = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(BuyVipEntity buyVipEntity) {
        AccountCenter.newInstance().vip.set(Integer.valueOf(buyVipEntity.getVip()));
        AccountCenter.newInstance().expireDate.set(buyVipEntity.getExpireDate());
        AccountCenter.putAccountInfo();
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        UserOnError.showErrorTip(this.f10412a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f10412a, i);
    }
}
