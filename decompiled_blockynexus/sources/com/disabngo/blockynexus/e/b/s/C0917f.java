package com.disabngo.blockynexus.e.b.s;

import android.content.Context;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.base.web.OnResponseListener;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.s.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: EmailModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0917f {
    public void a(Context context, String str, String str2, OnResponseListener onResponseListener) {
        UserApi.unbindEmail(context, str, str2, onResponseListener);
    }
}
