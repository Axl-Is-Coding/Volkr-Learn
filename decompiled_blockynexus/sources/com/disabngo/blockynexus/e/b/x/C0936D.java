package com.disabngo.blockynexus.e.b.x;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import com.sandboxol.greendao.entity.Friend;
import java.util.List;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.x.D, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FriendListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0936D extends DataListModel<Friend> {
    public C0936D(Context context, int i) {
        super(context, i);
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return "token.refresh.friend.list";
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<Friend> listItemViewModel) {
        gVar.a(2, R.layout.item_friend);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<Friend>> onResponseListener) {
        J.a(this.context, onResponseListener, getRefreshToken(), true);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public ListItemViewModel<Friend> getItemViewModel(Friend friend) {
        return new C0934B(this.context, friend);
    }
}
