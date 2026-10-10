package com.tendcloud.tenddata;

import android.net.TrafficStats;
import java.util.TreeMap;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class br {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile br f19881a;

    static {
        try {
            ag.a().register(a());
        } catch (Throwable unused) {
        }
    }

    public static br a() {
        if (f19881a == null) {
            synchronized (br.class) {
                if (f19881a == null) {
                    f19881a = new br();
                }
            }
        }
        return f19881a;
    }

    public void b() {
        try {
            ad.f19754a.execute(new Runnable() { // from class: com.tendcloud.tenddata.br.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (af.a(8)) {
                            TreeMap treeMap = new TreeMap();
                            treeMap.put("wifiTx", Long.valueOf(TrafficStats.getTotalTxBytes()));
                            treeMap.put("wifiRx", Long.valueOf(TrafficStats.getTotalRxBytes()));
                            treeMap.put("mobileTx", Long.valueOf(TrafficStats.getMobileTxBytes()));
                            treeMap.put("mobileRx", Long.valueOf(TrafficStats.getMobileRxBytes()));
                            bx bxVar = new bx();
                            bxVar.f19906b = "env";
                            bxVar.f19907c = com.umeng.analytics.pro.b.E;
                            bxVar.f19908d = treeMap;
                            bxVar.f19905a = a.ENV;
                            ag.a().post(bxVar);
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }
}
