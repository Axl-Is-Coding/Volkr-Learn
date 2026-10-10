package com.sandboxol.center.utils;

import android.content.Context;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.DateUtils;
import com.sandboxol.common.utils.SharedUtils;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public class FiveStarsLogicUtils {
    public static boolean fiveStartLogic(Context context, boolean z) {
        if (isFirstDayEvent(context).booleanValue()) {
            SharedUtils.putLong(context, "first.day.five.stars", new Date().getTime());
            return false;
        }
        if (!isFirstDayEvent(context).booleanValue() && isSecondDayEvent(context).booleanValue() && z) {
            SharedUtils.putLong(context, "second.day.five.stars", new Date().getTime());
            ReportDataAdapter.onEvent(context, EventConstant.SCORE_TIMES, "1");
            return true;
        }
        if (!isSecondDayEvent(context).booleanValue() && isSevenDayEvent(context).booleanValue() && z) {
            SharedUtils.putLong(context, "week.five.stars", new Date().getTime());
            ReportDataAdapter.onEvent(context, EventConstant.SCORE_TIMES, "2");
            return true;
        }
        if (isSevenDayEvent(context).booleanValue() || !isOneMonthEvent(context).booleanValue() || !z) {
            return false;
        }
        SharedUtils.putLong(context, "month.five.stars", new Date().getTime());
        ReportDataAdapter.onEvent(context, EventConstant.SCORE_TIMES, "3");
        return true;
    }

    private static Boolean isFirstDayEvent(Context context) {
        return Boolean.valueOf(SharedUtils.getLong(context, "first.day.five.stars") == 0);
    }

    private static Boolean isOneMonthEvent(Context context) {
        long j = SharedUtils.getLong(context, "week.five.stars");
        return Boolean.valueOf(j != 0 && SharedUtils.getLong(context, "month.five.stars") == 0 && (DateUtils.date2TimeStamp(DateUtils.timeStamp2Date(new Date().getTime(), "yyyy-MM-dd"), "yyyy-MM-dd") - DateUtils.date2TimeStamp(DateUtils.timeStamp2Date(j, "yyyy-MM-dd"), "yyyy-MM-dd")) / 86400000 >= 30);
    }

    private static Boolean isSecondDayEvent(Context context) {
        return Boolean.valueOf(SharedUtils.getLong(context, "second.day.five.stars") == 0 && DateUtils.date2TimeStamp(DateUtils.timeStamp2Date(new Date().getTime(), "yyyy-MM-dd"), "yyyy-MM-dd") - DateUtils.date2TimeStamp(DateUtils.timeStamp2Date(SharedUtils.getLong(context, "first.day.five.stars"), "yyyy-MM-dd"), "yyyy-MM-dd") >= 86400000);
    }

    private static Boolean isSevenDayEvent(Context context) {
        long j = SharedUtils.getLong(context, "second.day.five.stars");
        return Boolean.valueOf(j != 0 && SharedUtils.getLong(context, "week.five.stars") == 0 && (DateUtils.date2TimeStamp(DateUtils.timeStamp2Date(new Date().getTime(), "yyyy-MM-dd"), "yyyy-MM-dd") - DateUtils.date2TimeStamp(DateUtils.timeStamp2Date(j, "yyyy-MM-dd"), "yyyy-MM-dd")) / 86400000 >= 7);
    }
}
