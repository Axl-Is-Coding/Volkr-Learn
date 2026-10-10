package com.disabngo.blockynexus.web.error;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.HttpUtils;

/* JADX INFO: loaded from: classes3.dex */
public class VideoOnError {
    public static void showErrorTip(Context context, int i) {
        if (i == 10000) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.activity_video_not_exist);
        } else {
            if (i != 10001) {
                return;
            }
            AppToastUtils.showShortNegativeTipToast(context, R.string.activity_video_have_evaluation);
        }
    }

    public static void showOnServerError(Context context, int i) {
        AppToastUtils.showShortNegativeTipToast(context, HttpUtils.getHttpErrorMsg(context, i));
    }
}
