package com.disabngo.blockynexus.e.b.m;

import android.content.Context;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.base.model.IDefaultModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.entity.User;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.m.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ChangeDetailModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0871c implements IDefaultModel<User> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private User f9929a;

    public C0871c(User user) {
        this.f9929a = user;
    }

    @Override // com.sandboxol.common.base.model.IDefaultModel
    public void loadData(Context context, OnResponseListener<User> onResponseListener) {
        UserApi.changeInfo(context, this.f9929a, onResponseListener);
    }
}
