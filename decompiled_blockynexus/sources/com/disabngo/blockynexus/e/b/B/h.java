package com.disabngo.blockynexus.e.b.B;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.y;
import com.disabngo.blockynexus.entity.GroupInfo;
import com.disabngo.blockynexus.web.GroupChatApi;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.common.widget.rv.pagerv.PageListModel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: GroupChatListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends PageListModel<GroupInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObservableField<Boolean> f9118a;

    public h(Context context, int i, ObservableField<Boolean> observableField) {
        super(context, i);
        this.f9118a = observableField;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<GroupInfo> listItemViewModel) {
        gVar.a(2, R.layout.item_group);
    }

    @Override // com.sandboxol.common.widget.rv.pagerv.PageListModel
    public void onLoad(int i, int i2, OnResponseListener<PageData<GroupInfo>> onResponseListener) {
        GroupChatApi.getGroupChatList(this.context, i, i2, new g(this, onResponseListener));
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<GroupInfo> getItemViewModel(GroupInfo groupInfo) {
        return new e(this.context, groupInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<GroupInfo> a(List<GroupInfo> list) {
        if (!y.b().h()) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (GroupInfo groupInfo : list) {
            if (groupInfo.getOfficialGroup() == 0) {
                arrayList.add(groupInfo);
            }
        }
        return arrayList;
    }
}
