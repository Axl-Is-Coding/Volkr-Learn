package com.sandboxol.videosubmit.web;

import android.content.Context;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.videosubmit.R;

/* JADX INFO: loaded from: classes4.dex */
public class VideoSubmitError {
    public static void showErrorTip(Context context, int i) {
        if (i == 102) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.videosubmit_dialog_register_userid_error_102);
        }
        switch (i) {
            case 8050:
                AppToastUtils.showShortNegativeTipToast(context, R.string.videosubmit_submited_link_exist);
                break;
            case 8051:
                AppToastUtils.showShortNegativeTipToast(context, R.string.videosubmit_submited_link_max);
                break;
            case 8052:
                AppToastUtils.showShortNegativeTipToast(context, R.string.videosubmit_dialog_link_too_long);
                break;
            case 8053:
                AppToastUtils.showShortNegativeTipToast(context, R.string.videosubmit_end_tip);
                break;
            case 8054:
                AppToastUtils.showShortNegativeTipToast(context, R.string.videosubmit_dialog_link_error);
                break;
            case 8055:
                AppToastUtils.showShortNegativeTipToast(context, R.string.videosubmit_start_tip);
                break;
            case 8056:
                AppToastUtils.showShortNegativeTipToast(context, R.string.videosubmit_dialog_submit_link_fail);
                break;
            case 8057:
                AppToastUtils.showShortNegativeTipToast(context, R.string.base_err_config_error);
                break;
            default:
                ServerOnError.showOnServerError(context, i, VideoSubmitError.class.getName());
                break;
        }
    }
}
