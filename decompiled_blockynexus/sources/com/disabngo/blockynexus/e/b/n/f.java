package com.disabngo.blockynexus.e.b.n;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.center.entity.ModifyNameFreeResponse;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.base.model.IDefaultModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.entity.User;

/* JADX INFO: compiled from: ChangeNameModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class f implements IDefaultModel<User> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9962a;

    public f(String str) {
        this.f9962a = str;
    }

    public void a(Context context, ObservableField<ModifyNameFreeResponse> observableField, ObservableField<Boolean> observableField2) {
        UserApi.isChangeNameFree(context, new e(this, observableField, observableField2, context));
    }

    @Override // com.sandboxol.common.base.model.IDefaultModel
    public void loadData(Context context, OnResponseListener<User> onResponseListener) {
        UserApi.changeNickname(context, this.f9962a, onResponseListener);
    }

    public f() {
    }
}
