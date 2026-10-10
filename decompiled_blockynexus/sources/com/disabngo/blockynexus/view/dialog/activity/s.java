package com.disabngo.blockynexus.view.dialog.activity;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.ActivityTaskActionReward;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import java.util.List;

/* JADX INFO: compiled from: ActivityTaskContentRewardListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class s extends DataListModel<ActivityTaskActionReward> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<ActivityTaskActionReward> f11505a;

    public s(Context context, int i, List<ActivityTaskActionReward> list) {
        super(context, i);
        this.f11505a = list;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<ActivityTaskActionReward> getItemViewModel(ActivityTaskActionReward activityTaskActionReward) {
        return new r(this.context, activityTaskActionReward);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<ActivityTaskActionReward> listItemViewModel) {
        gVar.a(2, R.layout.item_activity_task_content_reward);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<ActivityTaskActionReward>> onResponseListener) {
        onResponseListener.onSuccess(this.f11505a);
    }
}
