package com.disabngo.blockynexus.e.b.ha;

import android.content.Context;
import com.sandboxol.center.entity.SecretQuestionInfo;
import com.sandboxol.center.entity.UserVerifyInfo;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.base.model.IModel;
import com.sandboxol.common.base.web.OnResponseListener;

/* JADX INFO: compiled from: SecretQuestionVerifyModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class g implements IModel {
    void a(Context context, Long l, SecretQuestionInfo secretQuestionInfo, int i, OnResponseListener<UserVerifyInfo> onResponseListener) {
        UserApi.authUserQuestion(context, l, secretQuestionInfo, i, onResponseListener);
    }
}
