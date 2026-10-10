package com.tendcloud.tenddata;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public final class bg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile bg f19850a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<String, Object> f19851b = new TreeMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f19852c = 10800000;

    private bg() {
        try {
            if (c()) {
                b();
                d();
                e();
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    public static bg a() {
        if (f19850a == null) {
            synchronized (bg.class) {
                if (f19850a == null) {
                    f19850a = new bg();
                }
            }
        }
        return f19850a;
    }

    private void b() {
        try {
            ArrayList arrayList = new ArrayList();
            if (af.a(21)) {
                for (k kVar : x.a()) {
                    if (!kVar.f20029c.startsWith("android.") && !kVar.f20029c.equals("system")) {
                        arrayList.add(kVar.f20029c);
                    }
                }
            } else {
                ActivityManager activityManager = (ActivityManager) ab.g.getSystemService("activity");
                if (activityManager != null) {
                    PackageManager packageManager = ab.g.getPackageManager();
                    List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                    if (runningAppProcesses != null) {
                        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                        while (it.hasNext()) {
                            String str = it.next().processName;
                            try {
                                if (packageManager.getLaunchIntentForPackage(str) != null) {
                                    arrayList.add(str);
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
            }
            f19851b.put("ras", arrayList.toString());
            n.setCollectRunningTime(System.currentTimeMillis());
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    private boolean c() {
        try {
            return System.currentTimeMillis() - n.g() > 10800000;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void d() {
        try {
            f19851b.put("aas", a(ab.g).toString());
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    private void e() {
        JSONArray jSONArrayA;
        bx bxVar = new bx();
        try {
            try {
                t.getFileLock(bh.a().b());
                jSONArrayA = bh.a().a("AppList");
            } catch (Throwable th) {
                bp.postSDKError(th);
                t.releaseFileLock(bh.a().b());
                jSONArrayA = null;
            }
            if (jSONArrayA != null) {
                if (jSONArrayA.length() > 0) {
                    bxVar.f19909e = new Pair<>("AppList", jSONArrayA);
                }
                bxVar.f19906b = "env";
                bxVar.f19907c = "apps";
                bxVar.f19908d = f19851b;
                bxVar.f19905a = a.ENV;
                ag.a().post(bxVar);
            }
        } finally {
            t.releaseFileLock(bh.a().b());
        }
    }

    private List<String> a(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            PackageManager packageManager = context.getPackageManager();
            List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
            if (installedPackages != null) {
                a(installedPackages);
                for (PackageInfo packageInfo : installedPackages) {
                    arrayList.add(packageInfo.packageName);
                    try {
                        arrayList.add(af.b(packageManager.getApplicationLabel(packageInfo.applicationInfo).toString().getBytes()));
                    } catch (Throwable unused) {
                        arrayList.add("");
                    }
                    if ((packageInfo.applicationInfo.flags & 1) > 0) {
                        arrayList.add("1");
                    } else {
                        arrayList.add("0");
                    }
                }
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
        return arrayList;
    }

    private void a(List<PackageInfo> list) {
        try {
            f fVarA = f.a(g.f20021a + h.f20022a + i.f20023a);
            HashMap map = new HashMap();
            if (list != null && fVarA != null) {
                for (PackageInfo packageInfo : list) {
                    for (String str : e.f20016a) {
                        try {
                            if (fVarA.b(packageInfo.packageName + str)) {
                                map.put(packageInfo.packageName, str);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
            f19851b.put("aac", map);
        } catch (Throwable unused2) {
        }
    }
}
