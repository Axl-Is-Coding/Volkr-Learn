package com.disabngo.blockynexus.e.b.e;

import android.content.Context;
import com.sandboxol.center.entity.EmailBindForm;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.base.model.IModel;
import com.sandboxol.common.base.web.OnResponseListener;
import java.util.List;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.e.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BindEmailModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0835g implements IModel {
    public void a(Context context, String str, OnResponseListener onResponseListener) {
        UserApi.sendEmailCode(context, str, onResponseListener);
    }

    public void b(Context context, String str, OnResponseListener onResponseListener) {
        UserApi.sendEmailVerifyCode(context, str, 1, onResponseListener);
    }

    public void a(Context context, String str, EmailBindForm emailBindForm, List<String> list, OnResponseListener onResponseListener) {
        UserApi.bindEmail(context, str, emailBindForm, list, onResponseListener);
    }
}
