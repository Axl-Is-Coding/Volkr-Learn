package com.disabngo.blockynexus.view.activity.webview.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import java.util.List;

/* JADX INFO: compiled from: Tools.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static boolean a(Context context, String str) {
        try {
            List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
            if (installedPackages != null) {
                for (int i = 0; i < installedPackages.size(); i++) {
                    if (str.equals(installedPackages.get(i).packageName)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
