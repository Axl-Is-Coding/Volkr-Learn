package io.rong.imkit.utils;

import android.content.Context;
import io.rong.common.RLog;

/* JADX INFO: loaded from: classes5.dex */
public class RongOperationPermissionUtils {
    private static final String TAG = "RongOperationPermissionUtils";

    public static boolean isMediaOperationPermit(Context context) {
        try {
        } catch (Exception e2) {
            RLog.e(TAG, "isMediaOperationPermit", e2);
        }
        return !((Boolean) Class.forName("io.rong.callkit.RongCallKit").getMethod("isInVoipCall", Context.class).invoke(null, context)).booleanValue();
    }
}
