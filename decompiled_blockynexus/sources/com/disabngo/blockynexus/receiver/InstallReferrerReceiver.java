package com.disabngo.blockynexus.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.apkfuns.logutils.c;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.utils.SharedUtils;

/* JADX INFO: loaded from: classes2.dex */
public class InstallReferrerReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra("referrer");
        c.a("referrer").c("referrer:" + stringExtra);
        if (stringExtra == null || stringExtra.length() <= 0) {
            return;
        }
        c.a("referrer").c("referrer:" + stringExtra);
        if (stringExtra.contains(StringConstant.THIRD_PART_LOGIN_GOOGLE) || stringExtra.contains("utm")) {
            return;
        }
        SharedUtils.putString(context, SharedConstant.REFERRER_KEY, stringExtra);
    }
}
