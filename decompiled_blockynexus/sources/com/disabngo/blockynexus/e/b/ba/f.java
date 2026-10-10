package com.disabngo.blockynexus.e.b.ba;

import android.content.Context;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.base.web.OnResponseListener;

/* JADX INFO: compiled from: ResetPasswordModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {
    void a(Context context, Long l, String str, String str2, OnResponseListener onResponseListener) {
        UserApi.resetPasswordBySecretQuestion(context, l, str, str2, onResponseListener);
    }
}
