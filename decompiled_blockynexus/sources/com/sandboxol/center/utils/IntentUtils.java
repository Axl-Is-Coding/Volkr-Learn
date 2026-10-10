package com.sandboxol.center.utils;

import android.content.Context;
import android.content.Intent;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.manager.ChannelManager;
import com.sandboxol.center.view.dialog.PasswordSettingDialog;
import com.sandboxol.center.view.dialog.RechargeDialog;
import com.sandboxol.center.view.dialog.TopLoadingDialog;
import com.sandboxol.center.view.dialog.VipGcubeGiftOneButtonDialog;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.greendao.c.va;

/* JADX INFO: loaded from: classes3.dex */
public class IntentUtils {
    public static void startGooglePayActivity(Context context, String str, String str2, String str3) {
        ChannelManager.startGooglePayActivity(context, str, str2, str3);
    }

    public static void startPasswordSettingDialog(final Context context, final boolean z) {
        if (AccountCenter.newInstance().hasPassword.get().booleanValue()) {
            return;
        }
        if (z) {
            Intent intent = new Intent(context, (Class<?>) PasswordSettingDialog.class);
            intent.setFlags(536870912);
            intent.putExtra(StringConstant.IS_FORCE_SHOW_PASSWORD_SETTING, z);
            context.startActivity(intent);
            return;
        }
        long j = SharedUtils.getLong(context, SharedConstant.KEY_PASSWORD_SETTING_TIME);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (j == 0 || jCurrentTimeMillis - j > 8640000) {
            va.newInstance().c(AccountCenter.newInstance().userId.get().longValue(), new com.sandboxol.greendao.a.c<Boolean>() { // from class: com.sandboxol.center.utils.IntentUtils.1
                @Override // com.sandboxol.greendao.a.c
                public void onError(int i, String str) {
                }

                @Override // com.sandboxol.greendao.a.c
                public void onSuccess(Boolean bool) {
                    if (bool.booleanValue()) {
                        return;
                    }
                    Intent intent2 = new Intent(context, (Class<?>) PasswordSettingDialog.class);
                    intent2.setFlags(536870912);
                    intent2.putExtra(StringConstant.IS_FORCE_SHOW_PASSWORD_SETTING, z);
                    context.startActivity(intent2);
                }
            });
        }
    }

    public static void startRechargeDialog(Context context, boolean z, String str) {
        Intent intent = new Intent(context, (Class<?>) RechargeDialog.class);
        intent.setFlags(268435456);
        intent.putExtra(StringConstant.RECHARGE_RESULT, z);
        intent.putExtra(StringConstant.RECHARGE_MESSAGE, str);
        context.startActivity(intent);
    }

    public static void startSubsGooglePayActivity(Context context, String str, String str2, String str3, String str4) {
        ChannelManager.startGooglePayActivity(context, str, str2, str3, str4);
    }

    public static void startTopLoadingDialog(Context context) {
        Intent intent = new Intent(context, (Class<?>) TopLoadingDialog.class);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static void startVipGcubeGiftOneButtonDialog(Context context, long j) {
        Intent intent = new Intent(context, (Class<?>) VipGcubeGiftOneButtonDialog.class);
        intent.setFlags(268435456);
        intent.putExtra(StringConstant.RECHARGE_MESSAGE, j);
        context.startActivity(intent);
    }

    public static void startGooglePayActivity(Context context, String str, String str2, String str3, String str4) {
        ChannelManager.startGooglePayActivity(context, str, str2, str4);
    }

    public static void startRechargeDialog(Context context, boolean z, String str, boolean z2) {
        Intent intent = new Intent(context, (Class<?>) RechargeDialog.class);
        intent.setFlags(268435456);
        intent.putExtra(StringConstant.RECHARGE_RESULT, z);
        intent.putExtra(StringConstant.RECHARGE_MESSAGE, str);
        intent.putExtra(StringConstant.RECHARGE_FROM_GAME, z2);
        context.startActivity(intent);
    }
}
