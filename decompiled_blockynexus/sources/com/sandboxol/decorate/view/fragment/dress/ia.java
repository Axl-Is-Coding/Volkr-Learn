package com.sandboxol.decorate.view.fragment.dress;

import android.content.Context;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.decorate.R;
import java.util.LinkedList;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: compiled from: DressPageListModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class ia extends DataListModel<SingleDressInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f17432a;

    public ia(Context context, int i, int i2) {
        super(context, i);
        this.f17432a = i2;
        c();
    }

    private void b(OnResponseListener<List<SingleDressInfo>> onResponseListener) {
        if (com.sandboxol.decorate.manager.j.c().c(this.f17432a)) {
            com.sandboxol.decorate.manager.j.c().a(this.f17432a, false);
            if (com.sandboxol.decorate.manager.j.c().a(this.f17432a).size() > 0) {
                onResponseListener.onSuccess(com.sandboxol.decorate.manager.j.c().a(this.f17432a));
                return;
            }
        }
        com.sandboxol.decorate.web.t.a(this.context, this.f17432a, (OnResponseListener<List<SingleDressInfo>>) new ga(this, onResponseListener));
    }

    private void c() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_REFRESH_DRESS_LIST_CHECK + this.f17432a, new Action0() { // from class: com.sandboxol.decorate.view.fragment.dress.i
            @Override // rx.functions.Action0
            public final void call() {
                this.f17431a.a();
            }
        });
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return MessageToken.TOKEN_REFRESH_DECORATION_TYPE + this.f17432a;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 3;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<SingleDressInfo> listItemViewModel) {
        if (listItemViewModel.getItem().getId() > 0) {
            gVar.a(com.sandboxol.decorate.c.f16980b, R.layout.item_dress);
        } else if (listItemViewModel.getItem().getId() == -3) {
            gVar.a(com.sandboxol.decorate.c.H, R.layout.item_dress_blank);
        } else {
            gVar.a(com.sandboxol.decorate.c.w, R.layout.item_dress_special);
        }
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<SingleDressInfo>> onResponseListener) {
        if (com.sandboxol.decorate.manager.j.c().b(this.f17432a)) {
            if (this.f17432a == 32) {
                a(onResponseListener);
            } else {
                b(onResponseListener);
            }
        }
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<SingleDressInfo> getItemViewModel(SingleDressInfo singleDressInfo) {
        if (singleDressInfo.getId() > 0) {
            return new fa(this.context, singleDressInfo, this.f17432a);
        }
        if (singleDressInfo.getId() == -3) {
            return new Z(this.context, singleDressInfo);
        }
        return new DressExtraItemViewModel(this.context, singleDressInfo, this.f17432a);
    }

    private List<SingleDressInfo> b() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(com.sandboxol.decorate.manager.l.c().b());
        if (linkedList.size() == 0 || !(linkedList.getFirst() == null || ((SingleDressInfo) linkedList.getFirst()).getId() == -2)) {
            SingleDressInfo singleDressInfo = new SingleDressInfo();
            singleDressInfo.setId(-2L);
            linkedList.addFirst(singleDressInfo);
        }
        com.sandboxol.decorate.f.b.a(linkedList);
        com.sandboxol.decorate.f.b.c(linkedList);
        return linkedList;
    }

    private void a(OnResponseListener<List<SingleDressInfo>> onResponseListener) {
        onResponseListener.onSuccess(b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<SingleDressInfo> list, OnResponseListener<List<SingleDressInfo>> onResponseListener) {
        com.sandboxol.decorate.web.t.a(this.context, this.f17432a, false, new ha(this, list, onResponseListener));
    }

    public /* synthetic */ void a() {
        com.sandboxol.decorate.manager.j.c().a(this.f17432a, true);
        Messenger.getDefault().send(RefreshMsg.create(), MessageToken.TOKEN_REFRESH_DECORATION_TYPE + this.f17432a);
    }
}
