package com.disabngo.blockynexus.view.activity.overviewrank;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.RankingApi;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import com.sandboxol.greendao.entity.TopRankInfo;
import java.util.List;

/* JADX INFO: compiled from: OverViewRankListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends DataListModel<TopRankInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ObservableField<String> f11049b;
    private Context context;

    public i(Context context, int i, String str, ObservableField<String> observableField) {
        super(context, i);
        this.context = context;
        this.f11048a = str;
        this.f11049b = observableField;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<TopRankInfo> listItemViewModel) {
        if (i % 2 == 0) {
            gVar.a(260, R.layout.item_rank_left_type);
        } else {
            gVar.a(260, R.layout.item_rank_right_type);
        }
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<TopRankInfo>> onResponseListener) {
        RankingApi.getRegionRankHomePageInfoResponse(this.context, this.f11048a, new h(this, onResponseListener));
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<TopRankInfo> getItemViewModel(TopRankInfo topRankInfo) {
        return new f(this.context, this.f11048a, topRankInfo);
    }
}
