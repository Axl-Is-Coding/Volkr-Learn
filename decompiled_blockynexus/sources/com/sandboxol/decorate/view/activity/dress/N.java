package com.sandboxol.decorate.view.activity.dress;

import android.content.Context;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.decorate.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: DressShopPageListModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class N extends DataListModel<SingleDressInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f17244a;

    public N(Context context, int i, int i2) {
        super(context, i);
        this.f17244a = i2;
        b();
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return MessageToken.TOKEN_REFRESH_SHOP_LIST + this.f17244a;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 2;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<SingleDressInfo> listItemViewModel) {
        if (listItemViewModel.getItem().getTypeId() > 0) {
            gVar.a(com.sandboxol.decorate.c.f16980b, R.layout.item_new_dress_shop);
        } else {
            gVar.a(com.sandboxol.decorate.c.w, R.layout.item_dress_shop_clear_history);
        }
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<SingleDressInfo>> onResponseListener) {
        if (com.sandboxol.decorate.manager.j.d().b(this.f17244a)) {
            int i = this.f17244a;
            if (i == 6) {
                a(onResponseListener);
                return;
            }
            if (i != 32) {
                a(this.context, i, onResponseListener);
                return;
            }
            LinkedList linkedList = new LinkedList(com.sandboxol.decorate.manager.l.d().b());
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((SingleDressInfo) it.next()).getId() == -2) {
                    it.remove();
                    break;
                }
            }
            List<SingleDressInfo> listB = b(linkedList);
            a(listB, true);
            LinkedList linkedList2 = new LinkedList(listB);
            SingleDressInfo singleDressInfo = new SingleDressInfo();
            singleDressInfo.setId(-2L);
            linkedList2.addFirst(singleDressInfo);
            onResponseListener.onSuccess(linkedList2);
        }
    }

    static /* synthetic */ List a(N n, List list, boolean z) {
        n.a((List<SingleDressInfo>) list, z);
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<SingleDressInfo> b(List<SingleDressInfo> list) {
        if (com.sandboxol.decorate.manager.s.c().b().equals(this.context.getString(R.string.decorate_new_dress_filter_default))) {
            return list;
        }
        if (com.sandboxol.decorate.manager.s.c().b().equals(this.context.getString(R.string.decorate_new_dress_filter_gold))) {
            ArrayList arrayList = new ArrayList();
            for (SingleDressInfo singleDressInfo : list) {
                boolean z = singleDressInfo.getIsActivity() == 0;
                if (singleDressInfo.getCurrency() == 2 && z) {
                    arrayList.add(singleDressInfo);
                }
            }
            return arrayList;
        }
        if (com.sandboxol.decorate.manager.s.c().b().equals(this.context.getString(R.string.decorate_new_dress_filter_diamond))) {
            ArrayList arrayList2 = new ArrayList();
            for (SingleDressInfo singleDressInfo2 : list) {
                boolean z2 = singleDressInfo2.getIsActivity() == 0;
                if (singleDressInfo2.getCurrency() == 1 && z2) {
                    arrayList2.add(singleDressInfo2);
                }
            }
            return arrayList2;
        }
        if (!com.sandboxol.decorate.manager.s.c().b().equals(this.context.getString(R.string.decorate_new_dress_filter_has))) {
            return list;
        }
        ArrayList arrayList3 = new ArrayList();
        for (SingleDressInfo singleDressInfo3 : list) {
            if (singleDressInfo3.getHasPurchase() == 1) {
                arrayList3.add(singleDressInfo3);
            }
        }
        return arrayList3;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<SingleDressInfo> getItemViewModel(SingleDressInfo singleDressInfo) {
        if (singleDressInfo.getTypeId() > 0) {
            return new I(this.context, singleDressInfo);
        }
        return new DressExtraItemViewModel(this.context, singleDressInfo);
    }

    private void a(Context context, long j, OnResponseListener<List<SingleDressInfo>> onResponseListener) {
        int i = (int) j;
        if (com.sandboxol.decorate.manager.j.d().c(i)) {
            com.sandboxol.decorate.manager.j.d().a(i, false);
            if (com.sandboxol.decorate.manager.j.d().a(i).size() > 0) {
                List<SingleDressInfo> listB = b(com.sandboxol.decorate.manager.j.d().a(i));
                a(listB, false);
                onResponseListener.onSuccess(listB);
                return;
            }
        }
        com.sandboxol.decorate.web.w.a(context, j, new L(this, j, onResponseListener));
    }

    private void a(OnResponseListener<List<SingleDressInfo>> onResponseListener) {
        com.sandboxol.decorate.web.t.a(this.context, this.f17244a, (OnResponseListener<List<SingleDressInfo>>) new M(this, onResponseListener));
    }

    private List<SingleDressInfo> a(List<SingleDressInfo> list, boolean z) {
        if (com.sandboxol.decorate.manager.s.c().g().equals(this.context.getString(R.string.decorate_new_dress_sort_default))) {
            if (z) {
                return list;
            }
            Collections.sort(list, new com.sandboxol.decorate.f.c());
            return list;
        }
        if (com.sandboxol.decorate.manager.s.c().g().equals(this.context.getString(R.string.decorate_new_dress_sort_time))) {
            Collections.sort(list, new com.sandboxol.decorate.f.h());
            return list;
        }
        if (com.sandboxol.decorate.manager.s.c().g().equals(this.context.getString(R.string.decorate_new_dress_sort_price))) {
            Collections.sort(list, new com.sandboxol.decorate.f.d());
            return list;
        }
        Collections.sort(list, new com.sandboxol.decorate.f.c());
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<SingleDressInfo> a(List<SingleDressInfo> list) {
        if (list == null) {
            return new ArrayList();
        }
        final ArrayList arrayList = new ArrayList();
        Observable.from(list).subscribe(new Action1() { // from class: com.sandboxol.decorate.view.activity.dress.j
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                N.a(arrayList, (SingleDressInfo) obj);
            }
        });
        return arrayList;
    }

    private void b() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_REFRESH_SHOP_LIST_CHECK + this.f17244a, new Action0() { // from class: com.sandboxol.decorate.view.activity.dress.k
            @Override // rx.functions.Action0
            public final void call() {
                this.f17282a.a();
            }
        });
    }

    static /* synthetic */ void a(List list, SingleDressInfo singleDressInfo) {
        SingleDressInfo singleDressInfo2 = new SingleDressInfo();
        singleDressInfo2.setId(singleDressInfo.getId());
        singleDressInfo2.setIconUrl(singleDressInfo.getIconUrl());
        singleDressInfo2.setTypeId(singleDressInfo.getTypeId());
        singleDressInfo2.setResourceId(singleDressInfo.getResourceId());
        singleDressInfo2.setHasPurchase(1);
        list.add(singleDressInfo2);
    }

    public /* synthetic */ void a() {
        com.sandboxol.decorate.manager.j.d().a(this.f17244a, true);
        Messenger.getDefault().send(RefreshMsg.create(), MessageToken.TOKEN_REFRESH_SHOP_LIST + this.f17244a);
    }
}
