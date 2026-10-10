package com.sandboxol.halloween.view.dialog.a;

import android.content.Context;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import com.sandboxol.halloween.R;
import com.sandboxol.halloween.entity.RewardDetailInfo;
import java.util.List;
import me.tatarka.bindingcollectionadapter2.g;

/* JADX INFO: compiled from: HalloweenRewardListModel.java */
/* JADX INFO: loaded from: classes4.dex */
public class e extends DataListModel<RewardDetailInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<RewardDetailInfo> f18682a;

    public e(Context context, int i, List<RewardDetailInfo> list) {
        super(context, i);
        this.f18682a = list;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<RewardDetailInfo> getItemViewModel(RewardDetailInfo rewardDetailInfo) {
        return new c(this.context, rewardDetailInfo);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(g gVar, int i, ListItemViewModel<RewardDetailInfo> listItemViewModel) {
        gVar.a(com.sandboxol.halloween.a.f18578b, R.layout.halloween_item_reward);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<RewardDetailInfo>> onResponseListener) {
        onResponseListener.onSuccess(this.f18682a);
    }
}
