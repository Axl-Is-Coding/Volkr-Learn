package com.disabngo.blockynexus.e.b.ea;

import android.content.Context;
import com.sandboxol.center.entity.SecretQuestionInfo;
import com.sandboxol.center.entity.SecurityVerifyResponse;
import com.sandboxol.center.entity.VerifyEmailForm;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.base.web.OnResponseListener;
import java.util.List;

/* JADX INFO: compiled from: SecretEmailVerifyModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {
    public void a(Context context, VerifyEmailForm verifyEmailForm, OnResponseListener<SecurityVerifyResponse> onResponseListener) {
        UserApi.verifyEmailBeforeSetSecretQuestion(context, verifyEmailForm, onResponseListener);
    }

    public void a(Context context, int i, OnResponseListener<List<SecretQuestionInfo>> onResponseListener) {
        UserApi.getUserQuestion(context, i, onResponseListener);
    }

    public void a(Context context, String str, OnResponseListener onResponseListener) {
        UserApi.sendEmailVerifyCode(context, str, 1, onResponseListener);
    }
}
