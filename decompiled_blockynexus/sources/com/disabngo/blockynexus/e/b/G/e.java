package com.disabngo.blockynexus.e.b.G;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import java.util.ArrayList;
import java.util.List;
import me.tatarka.bindingcollectionadapter2.g;

/* JADX INFO: compiled from: GroupNoticeListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends DataListModel<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<String> f9288a;

    public e(Context context, int i, ArrayList<String> arrayList) {
        super(context, i);
        this.f9288a = arrayList;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(g gVar, int i, ListItemViewModel<String> listItemViewModel) {
        gVar.a(288, R.layout.item_group_notice);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<String>> onResponseListener) {
        ArrayList<String> arrayList = this.f9288a;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        onResponseListener.onSuccess(this.f9288a);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public ListItemViewModel<String> getItemViewModel(String str) {
        return new c(this.context, str, this.f9288a);
    }
}
