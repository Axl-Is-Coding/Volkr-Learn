package com.sandboxol.decorate.view.activity.dress;

import android.content.Context;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.decorate.R;
import com.sandboxol.decorate.entity.DressShopRecommendUnit;
import com.sandboxol.decorate.entity.ShopRecommendDecorationInfo;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: compiled from: DressShopRecommendPageListModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class U extends DataListModel<DressShopRecommendUnit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f17257a;

    public U(Context context, int i, int i2) {
        super(context, i);
        this.f17257a = i2;
        b();
    }

    private void b() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_REFRESH_SHOP_LIST_CHECK + this.f17257a, new Action0() { // from class: com.sandboxol.decorate.view.activity.dress.A
            @Override // rx.functions.Action0
            public final void call() {
                this.f17220a.a();
            }
        });
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return MessageToken.TOKEN_REFRESH_SHOP_LIST + this.f17257a;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<DressShopRecommendUnit> listItemViewModel) {
        gVar.a(com.sandboxol.decorate.c.G, R.layout.item_new_dress_shop_recommend);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<DressShopRecommendUnit>> onResponseListener) {
        if (com.sandboxol.decorate.manager.j.d().b(this.f17257a)) {
            if (com.sandboxol.decorate.manager.j.d().c(this.f17257a)) {
                com.sandboxol.decorate.manager.j.d().a(this.f17257a, false);
                if (com.sandboxol.decorate.manager.j.d().a().size() > 0) {
                    onResponseListener.onSuccess(a(com.sandboxol.decorate.manager.j.d().a()));
                    return;
                }
            }
            com.sandboxol.decorate.web.w.a(this.context, new T(this, onResponseListener));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<DressShopRecommendUnit> a(List<ShopRecommendDecorationInfo> list) {
        int size = list.size() / 4;
        if (list.size() % 4 > 0) {
            size++;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            arrayList.add(new DressShopRecommendUnit());
        }
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (((DressShopRecommendUnit) arrayList.get(i2)).addItem(list.get(i3), i3)) {
                i2++;
            }
        }
        return arrayList;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<DressShopRecommendUnit> getItemViewModel(DressShopRecommendUnit dressShopRecommendUnit) {
        return new S(this.context, dressShopRecommendUnit);
    }

    public /* synthetic */ void a() {
        com.sandboxol.decorate.manager.j.d().a(this.f17257a, true);
        Messenger.getDefault().send(RefreshMsg.create(), MessageToken.TOKEN_REFRESH_SHOP_LIST + this.f17257a);
    }
}
