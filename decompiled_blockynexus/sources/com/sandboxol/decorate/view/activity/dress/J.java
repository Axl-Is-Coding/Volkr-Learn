package com.sandboxol.decorate.view.activity.dress;

import android.content.Context;
import com.sandboxol.center.router.moduleInfo.decorate.SuitDressInfo;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.decorate.entity.ShopRecommendDecorationInfo;
import java.util.List;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: compiled from: DressShopModel.java */
/* JADX INFO: loaded from: classes3.dex */
class J extends OnResponseListener<List<SuitDressInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f17236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f17237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ K f17238c;

    J(K k, List list, Context context) {
        this.f17238c = k;
        this.f17236a = list;
        this.f17237b = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f17237b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<SuitDressInfo> list) {
        Observable observableFrom = Observable.from(list);
        final List list2 = this.f17236a;
        observableFrom.subscribe(new Action1() { // from class: com.sandboxol.decorate.view.activity.dress.g
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                list2.add(new ShopRecommendDecorationInfo((SuitDressInfo) obj));
            }
        });
        new com.sandboxol.decorate.view.dialog.a.E(this.f17237b, this.f17236a).show();
    }
}
