package com.sandboxol.decorate.manager;

import android.content.Context;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.decorate.manager.v;
import java.util.List;

/* JADX INFO: compiled from: UserDressInfoHolder.java */
/* JADX INFO: loaded from: classes3.dex */
class u extends OnResponseListener<List<SingleDressInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ v.a f17210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f17211b;

    u(v.a aVar, Context context) {
        this.f17210a = aVar;
        this.f17211b = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        com.sandboxol.decorate.web.u.a(this.f17211b, i);
        this.f17210a.a();
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f17211b, i);
        this.f17210a.a();
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<SingleDressInfo> list) {
        g.a();
        if (list != null && list.size() > 0) {
            for (SingleDressInfo singleDressInfo : list) {
                if (singleDressInfo.getStatus() == 1) {
                    v.a().b(singleDressInfo);
                    if (n.a(singleDressInfo)) {
                        n.b().a(v.a().f17213b, singleDressInfo);
                    }
                }
            }
            v.a().a(list);
        }
        g.a(v.a().f17213b);
        g.a(list);
        v.a().a(true);
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.decoration.type31");
        this.f17210a.a();
    }
}
