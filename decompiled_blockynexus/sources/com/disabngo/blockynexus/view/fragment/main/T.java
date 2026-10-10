package com.disabngo.blockynexus.view.fragment.main;

import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.greendao.entity.FriendFollowResponse;

/* JADX INFO: compiled from: PageFollowFriendsItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class T extends OnResponseListener<PageData<FriendFollowResponse>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ U f11797a;

    T(U u) {
        this.f11797a = u;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(PageData<FriendFollowResponse> pageData) {
        if (pageData == null || pageData.getData() == null || pageData.getData().size() == 0) {
            this.f11797a.f11800c.set(false);
            return;
        }
        this.f11797a.f11800c.set(Boolean.valueOf(AppInfoCenter.newInstance().getAppConfig().isShowFriendFollow()));
        FriendFollowResponse friendFollowResponse = new FriendFollowResponse();
        friendFollowResponse.setNickName(((ListItemViewModel) this.f11797a).context.getString(R.string.add_friend));
        friendFollowResponse.setAlias(((ListItemViewModel) this.f11797a).context.getString(R.string.add_friend));
        pageData.getData().add(friendFollowResponse);
        this.f11797a.f11799b.clear();
        this.f11797a.f11799b.addAll(pageData.getData());
        U u = this.f11797a;
        u.f11798a.a(u.f11799b);
    }
}
