package com.sandboxol.adsoversea.utils;

import android.content.Context;
import com.sandboxol.common.utils.DateUtils;
import com.sandboxol.common.utils.SharedUtils;

/* JADX INFO: loaded from: classes2.dex */
public class AdsTimeUtils {
    private static final String SHOW_ADS_DATE = "ShowAdsDate";
    private static final String SHOW_ADS_TIMES = "ShowAdsTimes";
    private static final String SHOW_ADS_USER = "ShowAdsUser";

    public static void clickToShowVideo(Context context, long j) {
        SharedUtils.putInt(context, "ShowAdsTimes", SharedUtils.getInt(context, "ShowAdsTimes") + 1);
        SharedUtils.putLong(context, "ShowAdsDate", System.currentTimeMillis());
        SharedUtils.putLong(context, SHOW_ADS_USER, j);
    }

    public static void initShowVideoTimes(Context context) {
        SharedUtils.putInt(context, "ShowAdsTimes", 0);
    }

    public static boolean isShowAds(Context context, int i, long j) {
        long jDate2TimeStamp = DateUtils.date2TimeStamp(DateUtils.timeStamp2Date(System.currentTimeMillis(), "yyyy-MM-dd"), "yyyy-MM-dd");
        long jDate2TimeStamp2 = DateUtils.date2TimeStamp(DateUtils.timeStamp2Date(SharedUtils.getLong(context, "ShowAdsDate"), "yyyy-MM-dd"), "yyyy-MM-dd");
        if (jDate2TimeStamp2 <= 0) {
            jDate2TimeStamp2 = jDate2TimeStamp;
        }
        if (jDate2TimeStamp - jDate2TimeStamp2 >= 86400000 || SharedUtils.getLong(context, SHOW_ADS_USER) != j) {
            SharedUtils.putInt(context, "ShowAdsTimes", 0);
            SharedUtils.putLong(context, SHOW_ADS_USER, j);
        }
        return SharedUtils.getInt(context, "ShowAdsTimes") < i;
    }
}
