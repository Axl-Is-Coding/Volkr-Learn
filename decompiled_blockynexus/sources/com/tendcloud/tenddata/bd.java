package com.tendcloud.tenddata;

import java.util.Map;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class bd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile bd f19842a;

    static {
        try {
            ag.a().register(a());
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    public static bd a() {
        if (f19842a == null) {
            synchronized (bd.class) {
                if (f19842a == null) {
                    f19842a = new bd();
                }
            }
        }
        return f19842a;
    }

    public void b() {
        try {
            ad.f19754a.execute(new Runnable() { // from class: com.tendcloud.tenddata.bd.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Map<String, Object> mapD = u.D(ab.g);
                        if (mapD != null) {
                            bx bxVar = new bx();
                            bxVar.f19906b = "env";
                            bxVar.f19907c = "arp";
                            bxVar.f19908d = mapD;
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

    public final void onTDEBEventCommonEnvironment(bv bvVar) {
        try {
            if (bvVar.f19899a != 3) {
                return;
            }
            b();
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }
}
