package com.disabngo.blockynexus.view.activity.searchfriend;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.FriendApi;
import com.facebook.internal.ServerProtocol;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.common.widget.rv.pagerv.PageListModel;
import com.sandboxol.greendao.entity.Friend;

/* JADX INFO: compiled from: SearchFriendPageListModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class p extends PageListModel<Friend> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ObservableField<Boolean> f11086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PageData<Friend> f11087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f11088d;

    public p(Context context, int i, String str, ObservableField<Boolean> observableField, boolean z) {
        super(context, i);
        this.f11087c = new PageData<>();
        this.f11085a = str;
        this.f11086b = observableField;
        this.f11088d = z;
    }

    @Override // com.sandboxol.common.base.model.DefaultListModel, com.sandboxol.common.base.model.IListModel
    public String getRefreshToken() {
        return MessageToken.TOKEN_REFRESH_SEARCH_FRIEND;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public int getViewTypeCount() {
        return 1;
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public void onBind(me.tatarka.bindingcollectionadapter2.g gVar, int i, ListItemViewModel<Friend> listItemViewModel) {
        gVar.a(2, R.layout.item_search_friend);
    }

    @Override // com.sandboxol.common.widget.rv.pagerv.PageListModel
    public void onLoad(int i, int i2, OnResponseListener<PageData<Friend>> onResponseListener) {
        if (!TextUtils.isEmpty(this.f11085a)) {
            this.f11087c = new PageData<>();
            FriendApi.friendSearchList(this.context, i, i2, this.f11085a, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, new n(this, onResponseListener));
        } else {
            onResponseListener.onSuccess(new PageData<>());
            this.f11086b.set(true);
            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_IS_CLICK_SEARCH);
        }
    }

    @Override // com.sandboxol.common.base.model.IListModel
    public ListItemViewModel<Friend> getItemViewModel(Friend friend) {
        return new i(this.context, friend, this.f11088d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PageData<Friend> pageData) {
        this.f11087c.setPageSize(pageData.getPageSize());
        this.f11087c.setTotalSize(pageData.getTotalSize());
        this.f11087c.setTotalPage(pageData.getTotalPage());
        this.f11087c.setPageNo(pageData.getPageNo());
        this.f11087c.setData(pageData.getData());
    }

    public void a(String str) {
        this.f11085a = str;
        Messenger.getDefault().send(RefreshMsg.create(), getRefreshToken());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(OnResponseListener<PageData<Friend>> onResponseListener) {
        FriendApi.searchFriendById(this.context, Long.valueOf(this.f11085a).longValue(), new o(this, onResponseListener));
    }
}
