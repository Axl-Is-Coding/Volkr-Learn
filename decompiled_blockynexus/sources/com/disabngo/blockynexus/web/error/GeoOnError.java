package com.disabngo.blockynexus.web.error;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: loaded from: classes3.dex */
public class GeoOnError {
    public static void showErrorTip(Context context, int i) {
        if (i != 7) {
            ServerOnError.showOnServerError(context, i, GeoOnError.class.getName());
        } else {
            AppToastUtils.showShortNegativeTipToast(context, R.string.visitor_must_login);
        }
    }
}
