package com.disabngo.blockynexus.web.error;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: loaded from: classes3.dex */
public class BindOnError {
    public static void showErrorTip(Context context, int i) {
        if (i == 3) {
            AppToastUtils.showLongNegativeTipToast(context, R.string.tips_error_bind_3);
        }
        if (i == 118) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.has_set_secret_question);
            return;
        }
        if (i == 119) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.not_set_secret_question);
            return;
        }
        if (i == 125) {
            AppToastUtils.showLongNegativeTipToast(context, R.string.tips_error_bind_125);
            return;
        }
        if (i == 126) {
            AppToastUtils.showLongNegativeTipToast(context, R.string.tips_error_bind_126);
            return;
        }
        switch (i) {
            case 102:
                AppToastUtils.showShortNegativeTipToast(context, R.string.account_not_exist);
                break;
            case 103:
                AppToastUtils.showShortNegativeTipToast(context, R.string.bind_phone_phone_has_been_bind);
                break;
            case 104:
                AppToastUtils.showShortNegativeTipToast(context, R.string.bind_phone_no_bind_phone);
                break;
            case 105:
                AppToastUtils.showShortNegativeTipToast(context, R.string.bind_phone_send_code_failed);
                break;
            case 106:
                AppToastUtils.showShortNegativeTipToast(context, R.string.bind_phone_user_has_bind);
                break;
            case 107:
                AppToastUtils.showShortNegativeTipToast(context, R.string.bind_phone_code_error);
                break;
            default:
                switch (i) {
                    case 111:
                        AppToastUtils.showShortNegativeTipToast(context, R.string.bind_email_pattern_error);
                        break;
                    case 112:
                        AppToastUtils.showShortNegativeTipToast(context, R.string.bind_email_not_exist);
                        break;
                    case 113:
                        AppToastUtils.showShortNegativeTipToast(context, R.string.bind_email_has_bind);
                        break;
                    case 114:
                        AppToastUtils.showShortNegativeTipToast(context, R.string.bind_email_user_has_bind);
                        break;
                    case 115:
                        AppToastUtils.showShortNegativeTipToast(context, R.string.bind_email_never_bind_email);
                        break;
                    case 116:
                        AppToastUtils.showShortNegativeTipToast(context, R.string.change_password_email_not_bind);
                        break;
                    default:
                        ServerOnError.showOnServerError(context, i, BindOnError.class.getName());
                        break;
                }
                break;
        }
    }
}
