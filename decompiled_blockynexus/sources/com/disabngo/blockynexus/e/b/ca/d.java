package com.disabngo.blockynexus.e.b.ca;

import android.content.Context;
import com.sandboxol.center.entity.SecretQuestionInfo;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.base.web.OnResponseListener;
import java.util.List;

/* JADX INFO: compiled from: SafeSettingModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9684a;

    public d(Context context) {
        this.f9684a = context;
    }

    public void a(Context context, int i, OnResponseListener<List<SecretQuestionInfo>> onResponseListener) {
        UserApi.getUserQuestion(context, i, onResponseListener);
    }

    public void a(Context context, String str, OnResponseListener onResponseListener) {
        UserApi.sendEmailVerifyCode(context, str, 1, onResponseListener);
    }
}
