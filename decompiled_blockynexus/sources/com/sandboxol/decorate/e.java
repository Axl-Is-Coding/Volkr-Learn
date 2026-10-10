package com.sandboxol.decorate;

import android.content.Context;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.decorate.manager.g;
import com.sandboxol.decorate.manager.j;
import com.sandboxol.decorate.manager.l;
import com.sandboxol.decorate.manager.n;
import com.sandboxol.decorate.manager.v;
import com.sandboxol.decorate.web.u;
import java.util.List;

/* JADX INFO: compiled from: DressService.java */
/* JADX INFO: loaded from: classes3.dex */
class e extends OnResponseListener<List<SingleDressInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f17149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ DressService f17150b;

    e(DressService dressService, Context context) {
        this.f17150b = dressService;
        this.f17149a = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        u.a(this.f17149a, i);
        this.f17150b.c();
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f17149a, i);
        this.f17150b.c();
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<SingleDressInfo> list) {
        g.a();
        j.l();
        if (list != null && list.size() > 0) {
            for (SingleDressInfo singleDressInfo : list) {
                if (singleDressInfo.getStatus() == 1) {
                    v.a().b(singleDressInfo);
                    if (n.a(singleDressInfo)) {
                        n.b().a(v.a().f17213b, singleDressInfo);
                    }
                    l.c().a(singleDressInfo);
                }
            }
            v.a().a(list);
        }
        this.f17150b.useClothes(v.a().f17213b);
        g.a(list);
        this.f17150b.c();
        v.a().a(true);
    }
}
