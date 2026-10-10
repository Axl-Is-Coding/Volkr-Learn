package com.tendcloud.tenddata;

import android.os.Environment;
import org.json.JSONArray;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class da extends cx {
    public da() {
        a("manufacture", p.c());
        a("brand", p.d());
        a("model", p.e());
        JSONArray jSONArray = new JSONArray();
        for (String str : p.m()) {
            jSONArray.put(str);
        }
        a("cpuInfo", jSONArray);
        JSONArray jSONArray2 = new JSONArray();
        for (int i : p.r()) {
            jSONArray2.put(i);
        }
        a("memoryInfo", jSONArray2);
        JSONArray jSONArray3 = new JSONArray();
        for (int i2 : p.q()) {
            jSONArray3.put(i2);
        }
        a("sdCardInfo", jSONArray3);
        p.a(ab.g, this.f19979b);
        p.b(ab.g, this.f19979b);
        a("totalDiskSpace", Integer.valueOf(b()));
        a("support", p.g(ab.g));
        a(com.umeng.analytics.pro.au.v, p.n());
        a("nfcHce", p.b(ab.g));
    }

    public static int b() {
        try {
            int[] iArrS = p.s();
            if (iArrS != null) {
                return !Environment.isExternalStorageEmulated() ? iArrS[0] + iArrS[2] : iArrS[0];
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public void c() {
        try {
            a("support", (Object) p.g(ab.g));
        } catch (Throwable unused) {
        }
    }

    public void setSlots(int i) {
        a("slots", Integer.valueOf(i));
    }
}
