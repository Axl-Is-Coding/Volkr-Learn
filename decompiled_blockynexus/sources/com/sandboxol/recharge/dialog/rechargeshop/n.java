package com.sandboxol.recharge.dialog.rechargeshop;

import com.sandboxol.center.entity.ProductEntity;
import com.sandboxol.common.base.model.DefaultListModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.web.error.ServerOnError;
import java.util.List;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: compiled from: RechargeShopListModel.java */
/* JADX INFO: loaded from: classes4.dex */
class n extends OnResponseListener<List<ProductEntity>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f18882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ o f18883b;

    n(o oVar, OnResponseListener onResponseListener) {
        this.f18883b = oVar;
        this.f18882a = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f18882a.onError(i, str);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f18882a.onServerError(i);
        ServerOnError.showOnServerError(((DefaultListModel) this.f18883b).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<ProductEntity> list) {
        Observable.from(list).subscribe(new Action1() { // from class: com.sandboxol.recharge.dialog.rechargeshop.h
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                ProductEntity productEntity = (ProductEntity) obj;
                productEntity.setResourcePic("ic_diamond_" + productEntity.getId());
            }
        });
        SharedUtils.putString(((DefaultListModel) this.f18883b).context, "backup.product.info", new com.google.gson.j().a(list));
        this.f18882a.onSuccess(list);
    }
}
