package com.disabngo.blockynexus.e.b.S;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.AllGameIdInfo;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.common.widget.rv.pagerv.PageListModel;
import java.util.List;

/* JADX INFO: compiled from: PartyCreateListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class o extends PageListModel<AllGameIdInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<AllGameIdInfo> f9422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<AllGameIdInfo> f9423b;

    public o(Context context, int i, List<AllGameIdInfo> list, ObservableField<AllGameIdInfo> observableField) {
        super(context, i);
        this.f9422a = list;
        this.f9423b = observableField;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<AllGameIdInfo> getItemViewModel(AllGameIdInfo allGameIdInfo) {
        return new m(this.context, allGameIdInfo, this.f9423b, this.f9422a.get(0));
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<AllGameIdInfo> listItemViewModel) {
        gVar.a(2, R.layout.app_party_create_game_item);
    }

    @Override // com.sandboxol.common.widget.rv.pagerv.PageListModel
    public void onLoad(int i, int i2, OnResponseListener<PageData<AllGameIdInfo>> onResponseListener) {
        PageData<AllGameIdInfo> pageData = new PageData<>();
        pageData.setPageNo(i);
        pageData.setPageSize(100);
        pageData.setTotalSize(1);
        pageData.setData(this.f9422a);
        onResponseListener.onSuccess(pageData);
    }
}
