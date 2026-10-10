package com.disabngo.blockynexus.view.dialog.activity;

import com.disabngo.blockynexus.entity.ActivityTaskAction;
import com.disabngo.blockynexus.web.error.CampaignOnError;
import com.sandboxol.common.base.model.DefaultListModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: ActivityTaskContentListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class p extends OnResponseListener<List<ActivityTaskAction>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f11499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ q f11500b;

    p(q qVar, OnResponseListener onResponseListener) {
        this.f11500b = qVar;
        this.f11499a = onResponseListener;
    }

    static /* synthetic */ int a(ActivityTaskAction activityTaskAction, ActivityTaskAction activityTaskAction2) {
        int status = activityTaskAction.getStatus() * 2;
        int status2 = activityTaskAction2.getStatus() * 2;
        if (status == 0) {
            status = 3;
        }
        if (status2 == 0) {
            status2 = 3;
        }
        return status - status2;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        CampaignOnError.showErrorTip(((DefaultListModel) this.f11500b).context, i);
        this.f11499a.onError(i, str);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(((DefaultListModel) this.f11500b).context, i);
        this.f11499a.onServerError(i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<ActivityTaskAction> list) {
        Collections.sort(list, new Comparator() { // from class: com.disabngo.blockynexus.view.dialog.activity.f
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return p.a((ActivityTaskAction) obj, (ActivityTaskAction) obj2);
            }
        });
        list.add(0, new ActivityTaskAction(this.f11500b.f11501a, this.f11500b.f11502b, this.f11500b.f11503c, true));
        this.f11499a.onSuccess(list);
    }
}
