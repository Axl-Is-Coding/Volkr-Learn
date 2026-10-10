package com.sandboxol.decorate.view.dialog.a;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.center.entity.BuyDecorationListBean;
import com.sandboxol.center.entity.BuySuitListBean;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import com.sandboxol.decorate.R;
import com.sandboxol.decorate.entity.ShopRecommendDecorationInfo;
import java.util.List;

/* JADX INFO: compiled from: DressBuyListModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class H extends DataListModel<ShopRecommendDecorationInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<ShopRecommendDecorationInfo> f17321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ObservableField<Long> f17322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ObservableField<Long> f17323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<BuyDecorationListBean> f17324d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<BuySuitListBean> f17325e;

    public H(Context context, int i, List<ShopRecommendDecorationInfo> list, ObservableField<Long> observableField, ObservableField<Long> observableField2, List<BuyDecorationListBean> list2, List<BuySuitListBean> list3) {
        super(context, i);
        this.f17321a = list;
        this.f17322b = observableField;
        this.f17323c = observableField2;
        this.f17324d = list2;
        this.f17325e = list3;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<ShopRecommendDecorationInfo> getItemViewModel(ShopRecommendDecorationInfo shopRecommendDecorationInfo) {
        return shopRecommendDecorationInfo.getShopSuitDecorationInfo() != null ? new I(this.context, shopRecommendDecorationInfo, this.f17322b, this.f17323c, this.f17325e) : new F(this.context, shopRecommendDecorationInfo, this.f17322b, this.f17323c, this.f17324d);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 2;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<ShopRecommendDecorationInfo> listItemViewModel) {
        if (this.f17321a.get(i).getShopSuitDecorationInfo() != null) {
            gVar.a(com.sandboxol.decorate.c.q, R.layout.item_dress_buy_suit);
        } else {
            gVar.a(com.sandboxol.decorate.c.p, R.layout.item_dress_buy);
        }
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<ShopRecommendDecorationInfo>> onResponseListener) {
        onResponseListener.onSuccess(this.f17321a);
    }
}
