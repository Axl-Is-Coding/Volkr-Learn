package com.disabngo.blockynexus.view.activity.searchfriend;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.RecommendFriendEntity;
import com.disabngo.blockynexus.web.FriendApi;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.datarv.DataListModel;
import java.util.List;

/* JADX INFO: compiled from: SearchRecommendListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class s extends DataListModel<RecommendFriendEntity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f11100a;

    public s(Context context, int i, boolean z) {
        super(context, i);
        this.f11100a = z;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<RecommendFriendEntity> getItemViewModel(RecommendFriendEntity recommendFriendEntity) {
        return new r(this.context, recommendFriendEntity, this.f11100a);
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return MessageToken.TOKEN_REFRESH_RECOMMEND_FRIEND;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<RecommendFriendEntity> listItemViewModel) {
        gVar.a(2, R.layout.item_recommand_friend);
    }

    @Override // com.sandboxol.common.widget.rv.datarv.DataListModel
    public void onLoad(OnResponseListener<List<RecommendFriendEntity>> onResponseListener) {
        FriendApi.friendRecommendation(this.context, onResponseListener);
    }
}
