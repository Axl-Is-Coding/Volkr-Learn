package com.disabngo.blockynexus.e.b.w;

import android.content.Context;
import com.sandboxol.center.entity.UserVerifySettingsInfo;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.base.web.OnResponseListener;

/* JADX INFO: compiled from: ForgetPswByEmailOrSecretQuestionModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {
    public void a(Context context, String str, OnResponseListener<UserVerifySettingsInfo> onResponseListener) {
        UserApi.getUserVerifySettingsInfo(context, str, onResponseListener);
    }
}
