package com.disabngo.blockynexus.view.dialog.i;

import android.content.Context;
import com.sandboxol.center.entity.RechargeEntity;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.SharedUtils;

/* JADX INFO: compiled from: SignInModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    @Deprecated
    public void a(Context context, int i, OnResponseListener<RechargeEntity> onResponseListener) {
        UserApi.signIn(context, i, onResponseListener);
    }

    public void a(Context context, int i) {
        SharedUtils.putLong(context, "last.time.watch.ads", System.currentTimeMillis());
        UserApi.newSignIn(context, new a(this, context));
    }
}
