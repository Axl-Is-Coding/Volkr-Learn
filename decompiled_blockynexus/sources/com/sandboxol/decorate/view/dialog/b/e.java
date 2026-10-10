package com.sandboxol.decorate.view.dialog.b;

import android.content.Context;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import com.sandboxol.decorate.R;
import com.sandboxol.decorate.entity.DressExpireInfo;
import java.util.List;
import me.tatarka.bindingcollectionadapter2.g;

/* JADX INFO: compiled from: DressExpiredListModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class e extends DataListModel<DressExpireInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<DressExpireInfo> f17366a;

    public e(Context context, int i, List<DressExpireInfo> list) {
        super(context, i);
        this.f17366a = list;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<DressExpireInfo> getItemViewModel(DressExpireInfo dressExpireInfo) {
        return new d(this.context, dressExpireInfo);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(g gVar, int i, ListItemViewModel<DressExpireInfo> listItemViewModel) {
        gVar.a(com.sandboxol.decorate.c.t, R.layout.item_dress_expired);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<DressExpireInfo>> onResponseListener) {
        onResponseListener.onSuccess(this.f17366a);
    }
}
