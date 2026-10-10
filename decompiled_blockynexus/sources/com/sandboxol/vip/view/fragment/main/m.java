package com.sandboxol.vip.view.fragment.main;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import com.sandboxol.vip.R;
import com.sandboxol.vip.entity.PrivilegeInfo;
import java.util.List;

/* JADX INFO: compiled from: MorePrivilegeListModel.java */
/* JADX INFO: loaded from: classes4.dex */
public class m extends DataListModel<PrivilegeInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<Integer> f19100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ObservableField<Boolean> f19101b;

    public m(Context context, ObservableField<Integer> observableField, ObservableField<Boolean> observableField2) {
        super(context, R.string.no_data);
        this.f19100a = observableField;
        this.f19101b = observableField2;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<PrivilegeInfo> getItemViewModel(PrivilegeInfo privilegeInfo) {
        return new k(this.context, privilegeInfo, this.f19101b);
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return "token.refresh.more.privilege.list";
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<PrivilegeInfo> listItemViewModel) {
        gVar.a(com.sandboxol.vip.a.g, R.layout.vip_list_item_more_privilege);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<PrivilegeInfo>> onResponseListener) {
        List<PrivilegeInfo> listB = com.sandboxol.vip.c.a.b(this.f19100a.get().intValue());
        if (listB.size() == 0) {
            return;
        }
        onResponseListener.onSuccess(listB);
    }
}
