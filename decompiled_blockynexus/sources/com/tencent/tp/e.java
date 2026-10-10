package com.tencent.tp;

import android.content.Context;
import android.content.pm.PackageInfo;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f19694a;

    e() {
    }

    public static void a(Context context) {
        r.a("i_beg");
        try {
            b(context);
            a(context, true);
        } catch (Throwable unused) {
        }
        r.a("i_end");
    }

    private static void a(Context context, boolean z) {
        List<PackageInfo> listB = l.a().b(context);
        if (listB == null) {
            return;
        }
        for (PackageInfo packageInfo : listB) {
            if (packageInfo != null && (!z || (packageInfo.applicationInfo.flags & 1) <= 0)) {
                String str = packageInfo.applicationInfo.packageName;
                String strA = new c(context, str).a();
                if (strA != null) {
                    r.a("moduls=" + strA + "|name=" + str);
                }
            }
        }
    }

    private static void b(Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        if (jCurrentTimeMillis - f19694a < 180) {
            return;
        }
        f19694a = jCurrentTimeMillis;
        List<PackageInfo> listB = l.a().b(context);
        if (listB == null) {
            return;
        }
        String strA = q.a("vkf_ivhz=");
        String strA2 = q.a("|vkf_kvoc=");
        String strA3 = q.a("|dn_ntn=");
        String strA4 = q.a("|dn_zso=");
        for (PackageInfo packageInfo : listB) {
            if (packageInfo != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(strA);
                sb.append(packageInfo.applicationInfo.packageName);
                sb.append(strA2);
                sb.append(packageInfo.applicationInfo.sourceDir);
                sb.append(strA3);
                if ((packageInfo.applicationInfo.flags & 1) > 0) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
                sb.append(strA4);
                if (packageInfo.packageName == null) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
                r.a(sb.toString());
            }
        }
    }
}
