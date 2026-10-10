package com.disabngo.blockynexus.view.dialog.j;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.DailySignInfo;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import java.util.List;

/* JADX INFO: compiled from: WeekSignListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends DataListModel<DailySignInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<DailySignInfo> f11623a;

    public i(Context context, int i, List<DailySignInfo> list) {
        super(context, i);
        this.f11623a = list;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<DailySignInfo> getItemViewModel(DailySignInfo dailySignInfo) {
        return new h(this.context, dailySignInfo);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<DailySignInfo> listItemViewModel) {
        gVar.a(2, R.layout.item_week_sign);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<DailySignInfo>> onResponseListener) {
        onResponseListener.onSuccess(this.f11623a);
    }
}
