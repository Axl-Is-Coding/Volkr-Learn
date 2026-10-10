package com.sandboxol.center.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import androidx.databinding.ObservableList;
import com.just.agentweb.DefaultWebClient;
import com.sandboxol.center.R;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.greendao.entity.BannerEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class Helper {
    public static int convertToHigherDays(int i, int i2, int i3) {
        double d2;
        double d3;
        if (i <= 0) {
            return 0;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return 0;
                }
                return i;
            }
            if (i3 == 2) {
                return i;
            }
            double d4 = i;
            Double.isNaN(d4);
            d2 = d4 * 4.99d;
        } else {
            if (i3 == 1) {
                return i;
            }
            if (i3 == 2) {
                double d5 = i;
                Double.isNaN(d5);
                d3 = (d5 * 0.99d) / 4.99d;
                return (int) d3;
            }
            double d6 = i;
            Double.isNaN(d6);
            d2 = d6 * 0.99d;
        }
        d3 = d2 / 11.99d;
        return (int) d3;
    }

    @SuppressLint({"SimpleDateFormat"})
    public static int differentDaysByMillisecond(String str, long j) {
        Date date;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
        } catch (ParseException e2) {
            e2.printStackTrace();
            date = null;
        }
        if (date == null) {
            return 0;
        }
        return (int) ((date.getTime() - j) / 86400000);
    }

    public static int getResId(String str, int i) {
        Context context = BaseApplication.getContext();
        return TextUtils.isEmpty(str) ? i == 1 ? R.mipmap.ic_top_up_free : R.mipmap.ic_ads_good_gold : context.getResources().getIdentifier(str, "mipmap", context.getPackageName());
    }

    @SuppressLint({"SimpleDateFormat"})
    public static String getVipLeftTime(int i, int i2, int i3, String str) {
        long jCurrentTimeMillis;
        long j;
        if (i == 0) {
            jCurrentTimeMillis = System.currentTimeMillis();
            j = ((long) i2) * 30;
        } else {
            int iConvertToHigherDays = convertToHigherDays(differentDaysByMillisecond(str, System.currentTimeMillis()), i, i3);
            jCurrentTimeMillis = System.currentTimeMillis() + (((long) i2) * 30 * 24 * 60 * 60 * 1000);
            j = iConvertToHigherDays;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(jCurrentTimeMillis + (j * 24 * 60 * 60 * 1000)));
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    @SuppressLint({"WrongConstant"})
    public static boolean hasBrowserCount(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setData(Uri.parse(DefaultWebClient.HTTP_SCHEME));
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 32);
        return listQueryIntentActivities != null && listQueryIntentActivities.size() > 0;
    }

    public static boolean isBelowKitKat() {
        return Build.VERSION.SDK_INT <= 19;
    }

    public static boolean isInteger(String str) {
        try {
            return Pattern.compile("^[-\\+]?[\\d]*$").matcher(str).matches();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isValidContextForGlide(View view) {
        if (view.getContext() == null) {
            return false;
        }
        if (!(view.getContext() instanceof Activity)) {
            return true;
        }
        Activity activityByView = CommonHelper.getActivityByView(view);
        return (Build.VERSION.SDK_INT < 17 || !activityByView.isDestroyed()) && !activityByView.isFinishing();
    }

    public static void manageBannerData(List<BannerEntity> list, ObservableList<String> observableList, ObservableList<String> observableList2, ObservableList<BannerEntity> observableList3) {
        String str;
        if (list.size() > 0) {
            observableList.clear();
            observableList2.clear();
            observableList3.clear();
        }
        for (BannerEntity bannerEntity : list) {
            if (bannerEntity != null) {
                if (bannerEntity.getTitles() != null) {
                    str = bannerEntity.getTitles().get(CommonHelper.getLanguage());
                    if (str == null) {
                        str = bannerEntity.getTitles().get("en_US");
                    }
                } else {
                    str = "";
                }
                if (BaseApplication.getApp().getMetaDataAppVersion() >= bannerEntity.getVersion()) {
                    bannerEntity.setTitle(str);
                    observableList.add(str);
                    observableList2.add(bannerEntity.getImage());
                    observableList3.add(bannerEntity);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String payResult(android.content.Context r3, java.lang.String r4, boolean r5) {
        /*
            int r0 = r4.hashCode()
            r1 = -1402931637(0xffffffffac60f64b, float:-3.1969035E-12)
            r2 = 1
            if (r0 == r1) goto L1a
            r1 = -1281977283(0xffffffffb396943d, float:-7.011884E-8)
            if (r0 == r1) goto L10
            goto L24
        L10:
            java.lang.String r0 = "failed"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L24
            r4 = 0
            goto L25
        L1a:
            java.lang.String r0 = "completed"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L24
            r4 = 1
            goto L25
        L24:
            r4 = -1
        L25:
            if (r4 == 0) goto L49
            if (r4 == r2) goto L39
            if (r5 == 0) goto L32
            int r4 = com.sandboxol.center.R.string.base_recharge_failed
            java.lang.String r3 = r3.getString(r4)
            goto L58
        L32:
            int r4 = com.sandboxol.center.R.string.base_recharge_failed
            java.lang.String r3 = r3.getString(r4)
            goto L58
        L39:
            if (r5 == 0) goto L42
            int r4 = com.sandboxol.center.R.string.base_buy_vip_success
            java.lang.String r3 = r3.getString(r4)
            goto L58
        L42:
            int r4 = com.sandboxol.center.R.string.base_recharge_success
            java.lang.String r3 = r3.getString(r4)
            goto L58
        L49:
            if (r5 == 0) goto L52
            int r4 = com.sandboxol.center.R.string.base_recharge_failed
            java.lang.String r3 = r3.getString(r4)
            goto L58
        L52:
            int r4 = com.sandboxol.center.R.string.base_recharge_failed
            java.lang.String r3 = r3.getString(r4)
        L58:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.center.utils.Helper.payResult(android.content.Context, java.lang.String, boolean):java.lang.String");
    }

    public static String webContent2String(String str) {
        return str.replace("</p><p>", "<br />").replace("<p>", "").replace("</p>", "");
    }

    public static boolean isBelowKitKat(boolean z) {
        return Build.VERSION.SDK_INT <= 19 && z;
    }
}
