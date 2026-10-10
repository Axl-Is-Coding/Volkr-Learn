package com.disabngo.blockynexus.view.fragment.updateuserinfo;

import android.content.Context;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.base.model.IDefaultModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.entity.User;

/* JADX INFO: compiled from: UpdateUserInfoModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class j implements IDefaultModel<User> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private User f12064a;

    public j(User user) {
        this.f12064a = user;
    }

    public void a(Context context, OnResponseListener<Boolean> onResponseListener) {
        UserApi.isRewardCheck(context, onResponseListener);
    }

    @Override // com.sandboxol.common.base.model.IDefaultModel
    public void loadData(Context context, OnResponseListener<User> onResponseListener) {
        UserApi.changeInfo(context, this.f12064a, onResponseListener);
    }
}
