package com.disabngo.blockynexus.view.activity.tribesearch;

import android.content.Context;
import android.text.TextUtils;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.TribeRecommendation;
import com.disabngo.blockynexus.web.TribeApi;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.common.widget.rv.pagerv.PageListModel;

/* JADX INFO: compiled from: TribeSearchPageListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class j extends PageListModel<TribeRecommendation> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11136a;

    public j(Context context, int i) {
        super(context, i);
    }

    @Override // com.sandboxol.common.base.model.IListModel
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListItemViewModel<TribeRecommendation> getItemViewModel(TribeRecommendation tribeRecommendation) {
        return new h(this.context, tribeRecommendation);
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return MessageToken.TOKEN_TRIBE_SEARCH;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<TribeRecommendation> listItemViewModel) {
        gVar.a(2, R.layout.item_tribe_search);
    }

    @Override // com.sandboxol.common.widget.rv.pagerv.PageListModel
    public void onLoad(int i, int i2, OnResponseListener<PageData<TribeRecommendation>> onResponseListener) {
        if (TextUtils.isEmpty(this.f11136a)) {
            onResponseListener.onSuccess(new PageData<>());
        } else {
            TribeApi.searchTribe(this.context, this.f11136a, i, i2, onResponseListener);
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            AppToastUtils.showShortNegativeTipToast(this.context, R.string.tribe_name_empty);
        } else {
            this.f11136a = str;
            Messenger.getDefault().send(RefreshMsg.create(), getRefreshToken());
        }
    }
}
