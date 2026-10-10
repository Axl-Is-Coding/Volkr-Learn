package com.sandboxol.center.web;

import android.content.Context;
import com.sandboxol.center.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.IntConstant;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: loaded from: classes3.dex */
public class UserOnError {
    public static void showErrorTip(Context context, int i) {
        if (i == 7) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.visitor_must_login);
        }
        if (i == 10) {
            SharedUtils.putBoolean(context, AccountCenter.newInstance().userId.get() + SharedConstant.FRIEND_MATCH_IS_PERFECT_DATA, true);
            AppToastUtils.showShortNegativeTipToast(context, R.string.week_sign_in_has_sign_in);
            return;
        }
        if (i == 5017) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.money_excess_tips);
            return;
        }
        if (i == 7012) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.sign_in_has_get);
            return;
        }
        if (i == 7020) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.has_illegal_character);
            ReportDataAdapter.onEvent(context, EventConstant.BUILDWIN_CLICK_CONFIRM, "Exist illegal characters");
            return;
        }
        if (i == 101) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.base_account_exists);
            return;
        }
        if (i == 102) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.account_not_exist);
            ReportDataAdapter.onEvent(context, EventConstant.BUILDWIN_CLICK_CONFIRM, "User does not exist");
            return;
        }
        if (i == 1011) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.user_data_no_perfect);
            return;
        }
        if (i == 1012) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.upload_fail_sex);
            return;
        }
        if (i == 6002) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.sign_in_has_get);
            return;
        }
        if (i == 6003) {
            AppToastUtils.showLongNegativeTipToast(context, R.string.sign_in_no_power);
            return;
        }
        switch (i) {
            case 129:
                AppToastUtils.showShortNegativeTipToast(context, R.string.money_invalid);
                break;
            case 130:
                AppToastUtils.showShortNegativeTipToast(context, R.string.diamond_has_not_enough);
                break;
            case 131:
                AppToastUtils.showShortNegativeTipToast(context, R.string.star_code_user_not_exist);
                break;
            case 132:
                AppToastUtils.showShortNegativeTipToast(context, R.string.star_code_user_disable);
                break;
            case 133:
                AppToastUtils.showShortNegativeTipToast(context, R.string.cash_apply_not_repeat);
                break;
            default:
                switch (i) {
                    case 1001:
                        AppToastUtils.showShortNegativeTipToast(context, R.string.account_not_exist);
                        ReportDataAdapter.onEvent(context, EventConstant.BUILDWIN_CLICK_CONFIRM, "User does not exist");
                        break;
                    case 1002:
                        AppToastUtils.showShortNegativeTipToast(context, R.string.account_not_exist);
                        break;
                    case IntConstant.PERMISSION_STORAGE_DOWNLOAD /* 1003 */:
                        AppToastUtils.showShortNegativeTipToast(context, R.string.account_nickname_exist);
                        ReportDataAdapter.onEvent(context, EventConstant.BUILDWIN_CLICK_CONFIRM, "Nickname already exists");
                        break;
                    default:
                        ServerOnError.showOnServerError(context, i, UserOnError.class.getName());
                        ReportDataAdapter.onEvent(context, EventConstant.BUILDWIN_CLICK_CONFIRM, "unknown");
                        break;
                }
                break;
        }
    }
}
