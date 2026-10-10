package com.disabngo.blockynexus.e.b.ka;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.TribeDonationHistory;
import com.disabngo.blockynexus.web.TribeApi;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.common.widget.rv.pagerv.PageListModel;

/* JADX INFO: compiled from: TribeContributionHistoryListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class j extends PageListModel<TribeDonationHistory> {
    public j(Context context, int i) {
        super(context, i);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<TribeDonationHistory> getItemViewModel(TribeDonationHistory tribeDonationHistory) {
        return new i(this.context, tribeDonationHistory);
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return MessageToken.TOKEN_TRIBE_CONTRIBUTION;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<TribeDonationHistory> listItemViewModel) {
        gVar.a(2, R.layout.item_tribe_contribution_history);
    }

    @Override // com.sandboxol.common.widget.rv.pagerv.PageListModel
    public void onLoad(int i, int i2, OnResponseListener<PageData<TribeDonationHistory>> onResponseListener) {
        TribeApi.donationHistory(this.context, i, i2, onResponseListener);
    }
}
