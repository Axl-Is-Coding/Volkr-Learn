package com.disabngo.blockynexus.web.error;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: loaded from: classes3.dex */
public class FriendOnError {
    public static void showErrorTip(Context context, int i) {
        switch (i) {
            case 3001:
                AppToastUtils.showShortNegativeTipToast(context, R.string.is_friend_already);
                break;
            case AuthApiStatusCodes.AUTH_API_CLIENT_ERROR /* 3002 */:
                AppToastUtils.showShortNegativeTipToast(context, R.string.exceed_max_friend_number);
                break;
            case AuthApiStatusCodes.AUTH_API_SERVER_ERROR /* 3003 */:
                AppToastUtils.showShortNegativeTipToast(context, R.string.no_friend);
                break;
            case AuthApiStatusCodes.AUTH_TOKEN_ERROR /* 3004 */:
                AppToastUtils.showShortNegativeTipToast(context, R.string.not_valid_user);
                break;
            case AuthApiStatusCodes.AUTH_URL_RESOLUTION /* 3005 */:
                AppToastUtils.showShortNegativeTipToast(context, "His/Her friends list full");
                break;
            default:
                ServerOnError.showOnServerError(context, i, FriendOnError.class.getName());
                break;
        }
    }
}
