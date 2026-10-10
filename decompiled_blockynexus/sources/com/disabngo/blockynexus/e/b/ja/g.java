package com.disabngo.blockynexus.e.b.ja;

import android.content.Context;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.utils.SharedUtils;

/* JADX INFO: compiled from: ShareModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {
    public void a(Context context, String str) {
        if (SharedUtils.getBoolean(context, "share.success.email" + AccountCenter.newInstance().userId.get())) {
            return;
        }
        UserApi.shareReward(context, str, new f(this, context));
    }
}
