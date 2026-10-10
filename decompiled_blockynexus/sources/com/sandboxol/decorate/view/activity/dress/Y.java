package com.sandboxol.decorate.view.activity.dress;

import android.content.Context;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.router.moduleInfo.decorate.SuitDressInfo;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.decorate.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: compiled from: DressShopSuitPageListModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class Y extends DataListModel<SuitDressInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f17267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f17268b;

    public Y(Context context, int i, int i2, int i3) {
        super(context, i);
        this.f17267a = i2;
        this.f17268b = i3;
        b();
    }

    static /* synthetic */ List c(Y y, List list) {
        y.c(list);
        return list;
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return MessageToken.TOKEN_REFRESH_SHOP_LIST + this.f17267a;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<SuitDressInfo> listItemViewModel) {
        gVar.a(com.sandboxol.decorate.c.D, R.layout.item_new_dress_shop_suit);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<SuitDressInfo>> onResponseListener) {
        if (com.sandboxol.decorate.manager.j.d().b(this.f17267a)) {
            if (com.sandboxol.decorate.manager.j.d().c(this.f17267a)) {
                com.sandboxol.decorate.manager.j.d().a(this.f17267a, false);
                if (com.sandboxol.decorate.manager.j.d().b().size() > 0) {
                    List<SuitDressInfo> listA = a(com.sandboxol.decorate.manager.j.d().b());
                    c(listA);
                    onResponseListener.onSuccess(listA);
                    return;
                }
            }
            com.sandboxol.decorate.web.w.b(this.context, new X(this, onResponseListener));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<SuitDressInfo> list) {
        if (!com.sandboxol.decorate.manager.j.d().e()) {
            com.sandboxol.decorate.manager.j.d().b(true);
        }
        for (SuitDressInfo suitDressInfo : list) {
            if (suitDressInfo.getShopDecorationInfos() != null) {
                suitDressInfo.setDecorationInfoList(suitDressInfo.getShopDecorationInfos());
            }
        }
    }

    private List<SuitDressInfo> c(List<SuitDressInfo> list) {
        if (com.sandboxol.decorate.manager.s.c().g().equals(this.context.getString(R.string.decorate_new_dress_sort_default))) {
            Collections.sort(list, new com.sandboxol.decorate.f.e());
            return list;
        }
        if (com.sandboxol.decorate.manager.s.c().g().equals(this.context.getString(R.string.decorate_new_dress_sort_time))) {
            Collections.sort(list, new com.sandboxol.decorate.f.g());
            return list;
        }
        if (com.sandboxol.decorate.manager.s.c().g().equals(this.context.getString(R.string.decorate_new_dress_sort_price))) {
            Collections.sort(list, new com.sandboxol.decorate.f.f());
            return list;
        }
        Collections.sort(list, new com.sandboxol.decorate.f.e());
        return list;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<SuitDressInfo> getItemViewModel(SuitDressInfo suitDressInfo) {
        return new W(this.context, suitDressInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<SuitDressInfo> a(List<SuitDressInfo> list) {
        if (com.sandboxol.decorate.manager.s.c().b().equals(this.context.getString(R.string.decorate_new_dress_filter_default))) {
            return list;
        }
        if (com.sandboxol.decorate.manager.s.c().b().equals(this.context.getString(R.string.decorate_new_dress_filter_gold))) {
            ArrayList arrayList = new ArrayList();
            for (SuitDressInfo suitDressInfo : list) {
                boolean z = suitDressInfo.getIsActivity() == 0;
                if (suitDressInfo.getCurrency() == 2 && z) {
                    arrayList.add(suitDressInfo);
                }
            }
            return arrayList;
        }
        if (com.sandboxol.decorate.manager.s.c().b().equals(this.context.getString(R.string.decorate_new_dress_filter_diamond))) {
            ArrayList arrayList2 = new ArrayList();
            for (SuitDressInfo suitDressInfo2 : list) {
                boolean z2 = suitDressInfo2.getIsActivity() == 0;
                if (suitDressInfo2.getCurrency() == 1 && z2) {
                    arrayList2.add(suitDressInfo2);
                }
            }
            return arrayList2;
        }
        if (!com.sandboxol.decorate.manager.s.c().b().equals(this.context.getString(R.string.decorate_new_dress_filter_has))) {
            return list;
        }
        ArrayList arrayList3 = new ArrayList();
        for (SuitDressInfo suitDressInfo3 : list) {
            if (suitDressInfo3.getHasPurchase() == 1) {
                arrayList3.add(suitDressInfo3);
            }
        }
        return arrayList3;
    }

    private void b() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_REFRESH_SHOP_LIST_CHECK + this.f17267a, new Action0() { // from class: com.sandboxol.decorate.view.activity.dress.H
            @Override // rx.functions.Action0
            public final void call() {
                this.f17229a.a();
            }
        });
    }

    public /* synthetic */ void a() {
        com.sandboxol.decorate.manager.j.d().a(this.f17267a, true);
        Messenger.getDefault().send(RefreshMsg.create(), MessageToken.TOKEN_REFRESH_SHOP_LIST + this.f17267a);
    }
}
