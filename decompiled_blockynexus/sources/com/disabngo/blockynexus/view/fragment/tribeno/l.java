package com.disabngo.blockynexus.view.fragment.tribeno;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.TribeRecommendation;
import com.disabngo.blockynexus.web.TribeApi;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import java.util.List;

/* JADX INFO: compiled from: TribeNoListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class l extends DataListModel<TribeRecommendation> {
    l(Context context, int i) {
        super(context, i);
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return MessageToken.TOKEN_TRIBE_RECOMMEND;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 2;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<TribeRecommendation> listItemViewModel) {
        if (listItemViewModel.getItem().isFirst()) {
            gVar.a(2, R.layout.item_tribe_create);
        } else {
            gVar.a(2, R.layout.item_tribe_no_recommend);
        }
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<TribeRecommendation>> onResponseListener) {
        TribeApi.tribeRecommendList(this.context, getData().size(), new k(this, onResponseListener));
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<TribeRecommendation> getItemViewModel(TribeRecommendation tribeRecommendation) {
        return tribeRecommendation.isFirst() ? new h(this.context, tribeRecommendation) : new i(this.context, tribeRecommendation);
    }
}
