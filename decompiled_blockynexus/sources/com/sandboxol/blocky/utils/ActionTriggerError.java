package com.sandboxol.blocky.utils;

import android.content.Context;
import com.sandboxol.center.config.IntConstant;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.game.R;

/* JADX INFO: loaded from: classes.dex */
public class ActionTriggerError {
    public static void showErrorTip(Context context, int i) {
        if (i == 0) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.game_err_web_error);
        }
        switch (i) {
            case 1001:
                AppToastUtils.showShortNegativeTipToast(context, R.string.game_err_box_not_found);
                break;
            case 1002:
                AppToastUtils.showShortNegativeTipToast(context, R.string.game_err_not_init_database);
                break;
            case IntConstant.PERMISSION_STORAGE_DOWNLOAD /* 1003 */:
                AppToastUtils.showShortNegativeTipToast(context, R.string.game_err_repeat_receive);
                break;
            case 1004:
                AppToastUtils.showShortNegativeTipToast(context, R.string.game_err_not_enough_time);
                break;
            case 1005:
                AppToastUtils.showShortNegativeTipToast(context, R.string.game_err_server_disconnect);
                break;
            default:
                ServerOnError.showOnServerError(context, i, ActionTriggerError.class.getName());
                break;
        }
    }
}
