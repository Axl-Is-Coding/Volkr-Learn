package com.disabngo.blockynexus.e.b.A;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.GroupMember;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import java.util.List;

/* JADX INFO: compiled from: GroupBannedListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class j extends DataListModel<GroupMember> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<GroupMember> f9100b;

    public j(Context context, int i, long j, List<GroupMember> list) {
        super(context, i);
        this.f9099a = j;
        this.f9100b = list;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<GroupMember> getItemViewModel(GroupMember groupMember) {
        return new h(this.context, groupMember, this.f9099a);
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return MessageToken.TOKEN_REFRESH_BAN_LIST;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<GroupMember> listItemViewModel) {
        gVar.a(248, R.layout.item_group_banned);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<GroupMember>> onResponseListener) {
        List<GroupMember> list = this.f9100b;
        if (list != null) {
            onResponseListener.onSuccess(list);
        }
    }
}
