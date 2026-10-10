package com.disabngo.blockynexus.e.b.f;

import android.content.Context;
import com.sandboxol.center.entity.PhoneBindForm;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.base.model.IModel;
import com.sandboxol.common.base.web.OnResponseListener;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.f.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BindPhoneModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0845f implements IModel {
    public void a(Context context, PhoneBindForm phoneBindForm, String str, OnResponseListener onResponseListener) {
        UserApi.bindPhone(context, str, phoneBindForm, onResponseListener);
    }

    public void a(Context context, String str, String str2, OnResponseListener onResponseListener) {
        UserApi.sendCode(context, str, str2, onResponseListener);
    }
}
