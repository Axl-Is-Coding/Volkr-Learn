package com.disabngo.blockynexus.e.b.ta;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.TribeShopPageList;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import java.util.List;

/* JADX INFO: compiled from: TribeShopListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends DataListModel<TribeShopPageList> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<TribeShopPageList> f10196a;

    public i(Context context, int i, List<TribeShopPageList> list) {
        super(context, i);
        this.f10196a = list;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<TribeShopPageList> getItemViewModel(TribeShopPageList tribeShopPageList) {
        return new f(this.context, tribeShopPageList);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<TribeShopPageList> listItemViewModel) {
        gVar.a(2, R.layout.item_tribe_shop_car_view);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<TribeShopPageList>> onResponseListener) {
        onResponseListener.onSuccess(this.f10196a);
    }
}
