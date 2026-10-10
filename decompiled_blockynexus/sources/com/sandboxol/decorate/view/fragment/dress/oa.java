package com.sandboxol.decorate.view.fragment.dress;

import android.content.Context;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.router.moduleInfo.decorate.SuitDressInfo;
import com.sandboxol.common.BR;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.decorate.R;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: compiled from: DressSuitPageListModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class oa extends DataListModel<SuitDressInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f17450a;

    public oa(Context context, int i, int i2) {
        super(context, i);
        this.f17450a = i2;
        b();
    }

    private void b() {
        Messenger.getDefault().register(this, MessageToken.TOKEN_REFRESH_DRESS_LIST_CHECK + this.f17450a, new Action0() { // from class: com.sandboxol.decorate.view.fragment.dress.r
            @Override // rx.functions.Action0
            public final void call() {
                this.f17455a.a();
            }
        });
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getInsertToken() {
        return super.getInsertToken();
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return MessageToken.TOKEN_REFRESH_DECORATION_TYPE + this.f17450a;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 3;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<SuitDressInfo> listItemViewModel) {
        if (listItemViewModel.getItem().getSuitId() > 0) {
            gVar.a(BR.DressSuitItemViewModel, R.layout.item_new_dress_suit);
        } else if (listItemViewModel.getItem().getSuitId() == -3) {
            gVar.a(BR.DressSuitItemBlankViewModel, R.layout.item_dress_suit_blank);
        } else {
            gVar.a(BR.DressSuitExtraItemViewModel, R.layout.item_dress_shop_special);
        }
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<SuitDressInfo>> onResponseListener) {
        if (com.sandboxol.decorate.manager.j.c().b(this.f17450a)) {
            if (com.sandboxol.decorate.manager.j.c().c(this.f17450a)) {
                com.sandboxol.decorate.manager.j.c().a(this.f17450a, false);
                if (com.sandboxol.decorate.manager.j.c().b().size() > 0) {
                    onResponseListener.onSuccess(com.sandboxol.decorate.manager.j.c().b());
                    return;
                }
            }
            com.sandboxol.decorate.web.t.b(this.context, new ma(this, onResponseListener));
        }
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<SuitDressInfo> getItemViewModel(SuitDressInfo suitDressInfo) {
        return suitDressInfo.getSuitId() > 0 ? new la(this.context, suitDressInfo) : suitDressInfo.getSuitId() == -3 ? new ka(this.context, suitDressInfo) : new DressSuitExtraItemViewModel(this.context, suitDressInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<SuitDressInfo> list, OnResponseListener<List<SuitDressInfo>> onResponseListener) {
        com.sandboxol.decorate.web.t.a(this.context, 31L, true, new na(this, list, onResponseListener));
    }

    public /* synthetic */ void a() {
        com.sandboxol.decorate.manager.j.c().a(this.f17450a, true);
        Messenger.getDefault().send(RefreshMsg.create(), MessageToken.TOKEN_REFRESH_DECORATION_TYPE + this.f17450a);
    }
}
