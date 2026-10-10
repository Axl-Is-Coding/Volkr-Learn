package com.disabngo.blockynexus.view.activity.main;

import android.content.Context;
import com.disabngo.blockynexus.entity.ActivityTaskAction;
import com.disabngo.blockynexus.web.error.CampaignOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: MainModel.java */
/* JADX INFO: loaded from: classes2.dex */
class Mb extends OnResponseListener<List<ActivityTaskAction>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ bc f10809b;

    Mb(bc bcVar, Context context) {
        this.f10809b = bcVar;
        this.f10808a = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        CampaignOnError.showErrorTip(this.f10808a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f10808a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<ActivityTaskAction> list) {
        ArrayList arrayList = new ArrayList();
        for (ActivityTaskAction activityTaskAction : list) {
            if ("online_time".equals(activityTaskAction.getActionFlag())) {
                if (activityTaskAction.getStatus() == 2) {
                    arrayList.add(-1L);
                } else {
                    arrayList.add(Long.valueOf(((long) (activityTaskAction.getQuantity() * 60)) * 1000));
                }
            }
        }
        if (com.disabngo.blockynexus.view.dialog.activity.w.a(this.f10808a).b()) {
            com.disabngo.blockynexus.view.dialog.activity.w.a(this.f10808a).b(arrayList);
        } else {
            com.disabngo.blockynexus.view.dialog.activity.w.a(this.f10808a).a(arrayList);
        }
    }
}
