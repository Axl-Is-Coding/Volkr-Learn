package com.disabngo.blockynexus.e.b.ga;

import android.content.Context;
import com.sandboxol.center.entity.VerifyEmailForm;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.base.model.IModel;
import com.sandboxol.common.base.web.OnResponseListener;

/* JADX INFO: compiled from: SecretQuestionUnbindModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class f implements IModel {
    public void a(Context context, String str, OnResponseListener onResponseListener) {
        UserApi.sendEmailVerifyCode(context, str, 2, onResponseListener);
    }

    public void a(Context context, VerifyEmailForm verifyEmailForm, OnResponseListener onResponseListener) {
        UserApi.unbindUserSecretQuestion(context, verifyEmailForm, onResponseListener);
    }
}
