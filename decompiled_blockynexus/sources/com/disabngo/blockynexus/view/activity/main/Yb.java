package com.disabngo.blockynexus.view.activity.main;

import android.content.Context;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.entity.Game;
import java.util.List;

/* JADX INFO: compiled from: MainModel.java */
/* JADX INFO: loaded from: classes2.dex */
class Yb extends OnResponseListener<List<Game>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ bc f10864b;

    Yb(bc bcVar, Context context) {
        this.f10864b = bcVar;
        this.f10863a = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f10864b.c(this.f10863a, false);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f10864b.c(this.f10863a, false);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<Game> list) {
        if (list != null && list.size() > 0) {
            com.sandboxol.greendao.c.ya.newInstance().a(AccountCenter.newInstance().userId.get().longValue(), true);
        }
        this.f10864b.c(this.f10863a, false);
    }
}
