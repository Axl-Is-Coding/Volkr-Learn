package com.sandboxol.center.utils;

import android.content.Context;
import com.sandboxol.common.utils.DateUtils;
import com.sandboxol.common.utils.SharedUtils;

/* JADX INFO: loaded from: classes3.dex */
public class BlockySharedUtils {
    public static boolean isTodayClick(Context context, String str) {
        return !DateUtils.timeStamp2Date(System.currentTimeMillis(), TimeUtil.DEFAULT_DAY_NO_SEPRATOR).equals(SharedUtils.getString(context, str));
    }
}
