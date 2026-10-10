package com.disabngo.blockynexus.view.dialog.activity;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.ActivityTaskAction;
import com.disabngo.blockynexus.web.CampaignApi;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import java.util.List;

/* JADX INFO: compiled from: ActivityTaskContentListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class q extends DataListModel<ActivityTaskAction> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f11503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f11504d;

    public q(Context context, int i, String str, String str2, String str3, String str4) {
        super(context, i);
        this.f11501a = str;
        this.f11502b = str2;
        this.f11503c = str3;
        this.f11504d = str4;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 2;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<ActivityTaskAction> listItemViewModel) {
        if (listItemViewModel.getItem().isFirst()) {
            gVar.a(2, R.layout.item_activity_task_content_top);
        } else {
            gVar.a(2, R.layout.item_activity_task_content);
        }
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<ActivityTaskAction>> onResponseListener) {
        CampaignApi.getActivityTaskActionList(this.context, this.f11504d, new p(this, onResponseListener));
    }

    private void b(ActivityTaskAction activityTaskAction) {
        long jA = w.a(this.context).a();
        int status = activityTaskAction.getStatus();
        if (status == 0) {
            if (jA != 0) {
                activityTaskAction.setCompleteQuantity((((int) jA) / 1000) / 60);
            }
        } else if (status == 1 || status == 2) {
            activityTaskAction.setCompleteQuantity(activityTaskAction.getQuantity());
        }
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<ActivityTaskAction> getItemViewModel(ActivityTaskAction activityTaskAction) {
        if (activityTaskAction.isFirst()) {
            return new t(this.context, activityTaskAction);
        }
        if ("online_time".equals(activityTaskAction.getActionFlag())) {
            if (w.a(this.context).b()) {
                if ("weekend".equals(this.f11504d)) {
                    b(activityTaskAction);
                }
            } else if ("weekday".equals(this.f11504d)) {
                b(activityTaskAction);
            }
        }
        return new o(this.context, activityTaskAction, this.f11504d);
    }
}
