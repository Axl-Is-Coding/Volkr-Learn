package com.sandboxol.gamedetail.c.a.c;

import android.content.Context;
import com.sandboxol.center.entity.CampaignRank;
import com.sandboxol.center.web.GameApi;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.common.widget.rv.pagerv.PageListModel;
import com.sandboxol.gamedetail.R;

/* JADX INFO: compiled from: GameDetailRankPageListModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class l extends PageListModel<CampaignRank> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f18090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f18091b;

    public l(Context context, int i, String str, String str2) {
        super(context, i);
        this.f18090a = str;
        this.f18091b = str2;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 2;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<CampaignRank> listItemViewModel) {
        if (listItemViewModel.getItem().isFirst()) {
            gVar.a(com.sandboxol.gamedetail.a.f17769b, R.layout.item_game_detail_first_rank);
        } else {
            gVar.a(com.sandboxol.gamedetail.a.f17769b, R.layout.item_game_detail_rank);
        }
    }

    @Override // com.sandboxol.common.widget.rv.pagerv.PageListModel
    public void onLoad(int i, int i2, OnResponseListener<PageData<CampaignRank>> onResponseListener) {
        if (i < 50) {
            GameApi.getGameRank(this.context, this.f18090a, this.f18091b, i, i2, new k(this, i, onResponseListener));
        } else {
            onResponseListener.onSuccess(new PageData<>());
        }
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<CampaignRank> getItemViewModel(CampaignRank campaignRank) {
        return new i(this.context, campaignRank);
    }
}
