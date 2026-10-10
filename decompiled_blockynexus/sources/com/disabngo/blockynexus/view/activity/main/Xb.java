package com.disabngo.blockynexus.view.activity.main;

import android.content.Context;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.DailySignInfo;
import com.sandboxol.center.web.UserOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: MainModel.java */
/* JADX INFO: loaded from: classes2.dex */
class Xb extends OnResponseListener<Map<String, DailySignInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ bc f10860b;

    Xb(bc bcVar, Context context) {
        this.f10860b = bcVar;
        this.f10859a = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Map<String, DailySignInfo> map) {
        ArrayList arrayList = new ArrayList(map.values());
        ArrayList arrayList2 = new ArrayList();
        boolean z = false;
        for (int i = 1; i <= 7; i++) {
            int i2 = i - 1;
            ((DailySignInfo) arrayList.get(i2)).setDailyId(i);
            if (((DailySignInfo) arrayList.get(i2)).getStatus() == 1) {
                z = true;
            }
        }
        this.f10860b.a((Map<String, DailySignInfo>) map, (List<DailySignInfo>) arrayList2);
        if (z) {
            Context context = this.f10859a;
            if (arrayList2.size() != 0) {
                arrayList = arrayList2;
            }
            new com.disabngo.blockynexus.view.dialog.j.g(context, arrayList).show();
        }
        com.sandboxol.greendao.c.ya.newInstance().b(AccountCenter.newInstance().userId.get().longValue(), true);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        UserOnError.showErrorTip(this.f10859a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f10859a, i);
    }
}
