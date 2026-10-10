package com.sandboxol.decorate.view.dialog.a;

import android.content.Context;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import com.sandboxol.decorate.R;
import java.util.List;

/* JADX INFO: compiled from: DressBuySuitPieceListModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class K extends DataListModel<SingleDressInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<SingleDressInfo> f17332a;

    public K(Context context, int i, List<SingleDressInfo> list) {
        super(context, i);
        this.f17332a = list;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<SingleDressInfo> getItemViewModel(SingleDressInfo singleDressInfo) {
        return new J(this.context, singleDressInfo);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<SingleDressInfo> listItemViewModel) {
        gVar.a(com.sandboxol.decorate.c.o, R.layout.item_dress_buy_suit_piece);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<SingleDressInfo>> onResponseListener) {
        onResponseListener.onSuccess(this.f17332a);
    }
}
