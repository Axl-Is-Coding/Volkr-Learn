package com.disabngo.blockynexus.e.b.Q;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.FriendRequests;
import com.disabngo.blockynexus.web.FriendApi;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.common.widget.rv.pagerv.PageListModel;

/* JADX INFO: compiled from: NewFriendListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends PageListModel<FriendRequests> {
    public h(Context context, int i) {
        super(context, i);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<FriendRequests> getItemViewModel(FriendRequests friendRequests) {
        return new g(this.context, friendRequests);
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return MessageToken.TOKEN_REFRESH_FRIEND_APPLY_LIST;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<FriendRequests> listItemViewModel) {
        gVar.a(2, R.layout.item_new_friend);
    }

    @Override // com.sandboxol.common.widget.rv.pagerv.PageListModel
    public void onLoad(int i, int i2, OnResponseListener<PageData<FriendRequests>> onResponseListener) {
        FriendApi.friendRequestsList(this.context, i, i2, onResponseListener);
    }
}
