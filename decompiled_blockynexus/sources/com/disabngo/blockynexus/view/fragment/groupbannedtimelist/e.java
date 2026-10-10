package com.disabngo.blockynexus.view.fragment.groupbannedtimelist;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import java.util.List;

/* JADX INFO: compiled from: GroupBannedTimeListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends DataListModel<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<String> f11725a;

    public e(Context context, int i, ObservableField<String> observableField) {
        super(context, i);
        this.f11725a = observableField;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<String> listItemViewModel) {
        gVar.a(313, R.layout.item_group_ban_time);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<String>> onResponseListener) {
        onResponseListener.onSuccess(new g().a(this.context));
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public ListItemViewModel<String> getItemViewModel(String str) {
        return new GroupBannedTimeItemViewModel(this.context, str, this.f11725a);
    }
}
