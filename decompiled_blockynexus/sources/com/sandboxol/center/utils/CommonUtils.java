package com.sandboxol.center.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.SharedUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class CommonUtils {
    public static boolean isAppInstalled(Context context, String str) {
        List<PackageInfo> installedPackages;
        if (str != null && !str.isEmpty() && (installedPackages = context.getPackageManager().getInstalledPackages(0)) != null && !installedPackages.isEmpty()) {
            for (int i = 0; i < installedPackages.size(); i++) {
                if (str.equals(installedPackages.get(i).packageName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isNewEngineCommonGame(String str) {
        if (AppInfoCenter.newInstance().getAppConfig() == null || AppInfoCenter.newInstance().getAppConfig().getV2CommonGameList() == null) {
            return false;
        }
        return AppInfoCenter.newInstance().getAppConfig().getV2CommonGameList().contains(str);
    }

    public static void reportAppPackage(Context context) {
        if (SharedUtils.getBoolean(context, SharedConstant.IS_REPORT_PACKAGE)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.zhiliaoapp.musically");
        arrayList.add("com.snapchat.android");
        arrayList.add("video.like");
        arrayList.add("com.quvideo.xiaoying");
        arrayList.add("com.xvideostudio.videoeditor");
        arrayList.add("com.google.android.youtube");
        arrayList.add("sg.bigo.live");
        arrayList.add("com.instagram.android");
        arrayList.add("app.buzz.share");
        arrayList.add("app.rajusapps.uvideoapp");
        reportAppPackage(context, arrayList);
        SharedUtils.putBoolean(context, SharedConstant.IS_REPORT_PACKAGE, true);
    }

    public static void reportAppPackage(Context context, List<String> list) {
        List<PackageInfo> installedPackages;
        if (list != null) {
            try {
                if (!list.isEmpty() && (installedPackages = context.getPackageManager().getInstalledPackages(0)) != null && !installedPackages.isEmpty()) {
                    for (int i = 0; i < installedPackages.size(); i++) {
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            if (list.get(i2).equals(installedPackages.get(i).packageName)) {
                                ReportDataAdapter.onEvent(context, EventConstant.TOKEN_PKG + installedPackages.get(i).packageName, CommonHelper.getLanguage());
                            }
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
    }
}
