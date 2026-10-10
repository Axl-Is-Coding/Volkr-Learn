package com.disabngo.blockynexus.e.b.H;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.GroupRequest;
import com.disabngo.blockynexus.web.GroupChatApi;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.common.widget.rv.pagerv.PageListModel;

/* JADX INFO: compiled from: GroupVerificationListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends PageListModel<GroupRequest> {
    public i(Context context, int i) {
        super(context, i);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<GroupRequest> getItemViewModel(GroupRequest groupRequest) {
        return new h(this.context, groupRequest);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<GroupRequest> listItemViewModel) {
        gVar.a(2, R.layout.item_group_verification);
    }

    @Override // com.sandboxol.common.widget.rv.pagerv.PageListModel
    public void onLoad(int i, int i2, OnResponseListener<PageData<GroupRequest>> onResponseListener) {
        GroupChatApi.getGroupRequestMessage(this.context, i, i2, onResponseListener);
    }
}
