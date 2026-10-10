package com.disabngo.blockynexus.service;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.disabngo.blockynexus.d.D;
import com.disabngo.blockynexus.e.b.x.J;
import com.disabngo.blockynexus.entity.FriendActivityIntentInfo;
import com.disabngo.blockynexus.view.activity.searchfriend.l;
import com.sandboxol.center.router.moduleApi.IFriendService;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.entity.Friend;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Route(path = RouterServicePath.EventFriend.FRIEND_SERVICE)
public class FriendService implements IFriendService {
    @Override // com.sandboxol.center.router.moduleApi.IFriendService
    public void addFriend(Context context, long j, ObservableField<Boolean> observableField, boolean z, ObservableField<String> observableField2) {
        new l().a(context, j, observableField, true, observableField2);
    }

    @Override // com.sandboxol.center.router.moduleApi.IFriendService
    public void getFriendDataAndEnterFriendInfo(Context context, Friend friend, long j) {
        J.a(context, (Friend) null, new FriendActivityIntentInfo(j, 2));
    }

    @Override // com.sandboxol.center.router.moduleApi.IFriendService
    public void getFriendsList(Context context, OnResponseListener<List<Friend>> onResponseListener, String str, boolean z) {
        J.a(context, onResponseListener, str, z);
    }

    @Override // com.sandboxol.center.router.moduleApi.IBaseService, com.alibaba.android.arouter.facade.template.IProvider
    public /* synthetic */ void init(Context context) {
        com.sandboxol.center.router.moduleApi.a.a(this, context);
    }

    @Override // com.sandboxol.center.router.moduleApi.IFriendService
    public void startSearchFiendActivity(Context context) {
        D.e(context);
    }

    @Override // com.sandboxol.center.router.moduleApi.IFriendService
    public void startSearchFiendActivity(Context context, boolean z) {
        D.c(context, z);
    }
}
