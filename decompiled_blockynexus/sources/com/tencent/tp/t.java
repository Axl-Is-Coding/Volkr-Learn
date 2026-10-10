package com.tencent.tp;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes5.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Map f19721a = new TreeMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Context f19722b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f19723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f19724d;

    private void b(String str) {
        try {
            r.c(str);
        } catch (Throwable unused) {
        }
    }

    public boolean a(Context context) {
        if (context == null || this.f19722b != null) {
            return false;
        }
        this.f19722b = context;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return true;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            this.f19723c = packageInfo.versionName;
            this.f19724d = packageInfo.versionCode;
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    public boolean a(String str) {
        if (this.f19722b == null || this.f19721a == null) {
            return false;
        }
        l lVarA = l.a();
        long j = Long.parseLong(str, 16);
        int i = ((2 & j) > 0L ? 1 : ((2 & j) == 0L ? 0 : -1));
        boolean z = (4 & j) != 0;
        boolean z2 = (j & 8) != 0;
        if (!z && s.a()) {
            this.f19721a.put(q.a("Wmviy"), lVarA.a(this.f19722b));
        }
        if (!z2) {
            this.f19721a.put(q.a("KvxfvbzIvhz"), this.f19722b.getPackageName());
        }
        this.f19721a.put(q.a("VkkIvhz"), s.d(this.f19722b));
        if (s.a()) {
            this.f19721a.put(q.a("XkpVwd"), s.j());
            String strA = s.a(this.f19722b);
            if (strA == null || strA.length() == 0) {
                strA = q.a("Pifijri");
            }
            this.f19721a.put(q.a("XkpHjyzg"), strA);
            r.a(q.a("xkp_hjyzg:") + strA);
            this.f19721a.put(q.a("Kgvoajmh"), s.g());
        }
        this.f19721a.put(q.a("Gvibpvbz"), s.f());
        this.f19721a.put(q.a("NdhpgvojmIvhz"), s.b(this.f19722b));
        for (String str2 : this.f19721a.keySet()) {
            if (str2 != null) {
                String strValueOf = (String) this.f19721a.get(str2);
                if (strValueOf == null) {
                    strValueOf = String.valueOf(strValueOf);
                }
                String strSubstring = str2 + ":" + strValueOf;
                if (strSubstring.length() > 63) {
                    strSubstring = strSubstring.substring(0, 63);
                }
                b(strSubstring);
            }
        }
        return true;
    }
}
