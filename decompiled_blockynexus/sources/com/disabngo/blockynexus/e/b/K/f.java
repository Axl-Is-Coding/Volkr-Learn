package com.disabngo.blockynexus.e.b.K;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.HelpDetailInfo;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import java.util.List;

/* JADX INFO: compiled from: HelpDetailListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends DataListModel<HelpDetailInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<HelpDetailInfo> f9329a;

    public f(Context context, int i, List<HelpDetailInfo> list) {
        super(context, i);
        this.f9329a = list;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<HelpDetailInfo> getItemViewModel(HelpDetailInfo helpDetailInfo) {
        return new e(this.context, helpDetailInfo);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<HelpDetailInfo> listItemViewModel) {
        gVar.a(2, R.layout.item_help_detail);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<HelpDetailInfo>> onResponseListener) {
        onResponseListener.onSuccess(this.f9329a);
    }
}
