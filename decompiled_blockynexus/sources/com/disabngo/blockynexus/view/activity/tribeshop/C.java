package com.disabngo.blockynexus.view.activity.tribeshop;

import android.content.Context;
import androidx.databinding.ObservableMap;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.TribeShopPageList;
import com.disabngo.blockynexus.web.TribeApi;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.common.widget.rv.pagerv.PageListModel;

/* JADX INFO: compiled from: TribeShopPageListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class C extends PageListModel<TribeShopPageList> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f11154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ObservableMap<Long, String> f11155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ObservableMap<Long, String> f11156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ObservableMap<Long, TribeShopPageList> f11157d;

    public C(Context context, int i, long j, ObservableMap<Long, String> observableMap, ObservableMap<Long, String> observableMap2, ObservableMap<Long, TribeShopPageList> observableMap3) {
        super(context, i);
        this.f11154a = j;
        this.f11155b = observableMap;
        this.f11156c = observableMap2;
        this.f11157d = observableMap3;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<TribeShopPageList> getItemViewModel(TribeShopPageList tribeShopPageList) {
        return new B(this.context, tribeShopPageList, this.f11155b, this.f11156c, this.f11157d);
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return MessageToken.TOKEN_TRIBE_SHOP_LIST;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<TribeShopPageList> listItemViewModel) {
        gVar.a(2, R.layout.item_tribe_shop);
    }

    @Override // com.sandboxol.common.widget.rv.pagerv.PageListModel
    public void onLoad(int i, int i2, OnResponseListener<PageData<TribeShopPageList>> onResponseListener) {
        TribeApi.getTribeShopGoodsList(this.context, this.f11154a, i, i2, onResponseListener);
    }
}
