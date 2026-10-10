package com.disabngo.blockynexus.view.activity.main;

import android.content.Context;
import com.disabngo.blockynexus.e.b.c.C0826f;
import com.disabngo.blockynexus.entity.ActivityTaskTitleList;
import com.disabngo.blockynexus.web.error.CampaignOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: MainModel.java */
/* JADX INFO: loaded from: classes2.dex */
class Lb extends OnResponseListener<ActivityTaskTitleList> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ bc f10799b;

    Lb(bc bcVar, Context context) {
        this.f10799b = bcVar;
        this.f10798a = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(ActivityTaskTitleList activityTaskTitleList) {
        C0826f.a(activityTaskTitleList.getActivityTitleList());
        if (activityTaskTitleList.getActivityTitleList().size() == 0) {
            return;
        }
        com.disabngo.blockynexus.view.dialog.activity.w.a(this.f10798a).a(activityTaskTitleList);
        C0826f.b(activityTaskTitleList.getActivityTitleList());
        if (activityTaskTitleList == null || activityTaskTitleList.getActivityTitleList() == null || activityTaskTitleList.getActivityTitleList().size() == 0) {
            return;
        }
        if (com.disabngo.blockynexus.view.dialog.activity.w.a(this.f10798a).b()) {
            this.f10799b.a(this.f10798a, "weekend");
        } else {
            this.f10799b.a(this.f10798a, "weekday");
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        CampaignOnError.showErrorTip(this.f10798a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f10798a, i);
    }
}
