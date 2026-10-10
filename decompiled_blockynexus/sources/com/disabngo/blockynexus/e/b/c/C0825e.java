package com.disabngo.blockynexus.e.b.c;

import com.disabngo.blockynexus.entity.ActivityTaskTitleList;
import com.disabngo.blockynexus.view.activity.main.bc;
import com.disabngo.blockynexus.view.dialog.activity.w;
import com.disabngo.blockynexus.web.error.CampaignOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.c.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class C0825e extends OnResponseListener<ActivityTaskTitleList> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f9677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0826f f9678b;

    C0825e(C0826f c0826f, OnResponseListener onResponseListener) {
        this.f9678b = c0826f;
        this.f9677a = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(ActivityTaskTitleList activityTaskTitleList) {
        C0826f.a(activityTaskTitleList.getActivityTitleList());
        this.f9677a.onSuccess(activityTaskTitleList.getActivityTitleList());
        if (activityTaskTitleList.getActivityTitleList().size() == 0) {
            return;
        }
        w.a(this.f9678b.context).a(activityTaskTitleList);
        C0826f.b(activityTaskTitleList.getActivityTitleList());
        if (activityTaskTitleList == null || activityTaskTitleList.getActivityTitleList() == null || activityTaskTitleList.getActivityTitleList().size() == 0) {
            return;
        }
        if (w.a(this.f9678b.context).b()) {
            new bc().a(this.f9678b.context, "weekend");
        } else {
            new bc().a(this.f9678b.context, "weekday");
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        CampaignOnError.showErrorTip(this.f9678b.context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f9678b.context, i);
    }
}
