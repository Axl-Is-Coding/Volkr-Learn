package com.sandboxol.recharge.dialog.rechargeshop;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.center.entity.ProductEntity;
import com.sandboxol.center.entity.StarCodeUser;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import com.sandboxol.game.R;
import java.util.List;

/* JADX INFO: compiled from: RechargeShopListModel.java */
/* JADX INFO: loaded from: classes4.dex */
public class o extends DataListModel<ProductEntity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f18884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ObservableField<StarCodeUser> f18885b;

    public o(Context context, ObservableField<StarCodeUser> observableField, int i, String str) {
        super(context, i);
        this.f18884a = str;
        this.f18885b = observableField;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<ProductEntity> listItemViewModel) {
        gVar.a(com.sandboxol.game.a.f17627b, R.layout.item_recharge_shop);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<ProductEntity>> onResponseListener) {
        List<ProductEntity> list;
        if (getData().isEmpty() && (list = (List) new com.google.gson.j().a(SharedUtils.getString(this.context, "backup.product.info"), new m(this).getType())) != null && list.size() > 0) {
            if (list.get(0).isFree()) {
                list.remove(0);
            }
            onResponseListener.onSuccess(list);
        }
        BillingManager.getInstance().productsList(this.context, new n(this, onResponseListener));
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<ProductEntity> getItemViewModel(ProductEntity productEntity) {
        return new l(this.context, this.f18885b, productEntity, this.f18884a);
    }
}
