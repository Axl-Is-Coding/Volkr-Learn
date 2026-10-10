package com.tendcloud.tenddata;

import android.content.Context;
import android.util.Log;
import com.tendcloud.tenddata.bw;
import com.tendcloud.tenddata.zz;
import io.rong.imlib.statistics.UserData;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class bl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile bl f19861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f19862b;

    static {
        try {
            ag.a().register(a());
        } catch (Throwable unused) {
        }
        f19861a = null;
        f19862b = false;
    }

    private bl() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c() {
        try {
            if (n.e() == 0) {
                n.setInitTime(System.currentTimeMillis());
            }
        } catch (Throwable unused) {
        }
    }

    private static void d(final a aVar) {
        try {
            new Timer().schedule(new TimerTask() { // from class: com.tendcloud.tenddata.bl.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    bl.c(aVar);
                    bl.c();
                    bl.e(aVar);
                }
            }, ab.r);
        } catch (Throwable th) {
            m.eForInternal(th);
            e(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(final a aVar) {
        try {
            if (aVar == null) {
                m.eForInternal("TDFeatures is null...");
                return;
            }
            TreeMap treeMap = new TreeMap();
            boolean zA = ab.a(aVar);
            treeMap.put("first", Boolean.valueOf(zA));
            if (!af.b(zz.f20074a)) {
                treeMap.put(UserData.CUSTOM_KEY, af.a(zz.f20074a));
            }
            bx bxVar = new bx();
            try {
                bxVar.f19906b = "app";
                bxVar.f19907c = "init";
                bxVar.f19908d = treeMap;
                bxVar.f19905a = aVar;
                if (zA) {
                    bxVar.f19910f = new cr() { // from class: com.tendcloud.tenddata.bl.2
                        @Override // com.tendcloud.tenddata.cr
                        public void onStoreFailed() {
                            try {
                                bp.postSDKError(new Exception("init event store failed"));
                            } catch (Throwable th) {
                                bp.postSDKError(th);
                            }
                        }

                        @Override // com.tendcloud.tenddata.cr
                        public void onStoreSuccess() {
                            try {
                                n.a(false, aVar);
                            } catch (Throwable unused) {
                            }
                        }
                    };
                }
                ag.a().post(bxVar);
            } catch (Throwable th) {
                bp.postSDKError(th);
            }
            bw bwVar = new bw();
            bwVar.f19903a = aVar;
            bwVar.f19904b = bw.a.IMMEDIATELY;
            ag.a().post(bwVar);
            if (zA) {
                d();
            }
        } catch (Throwable th2) {
            bp.postSDKError(th2);
        }
    }

    public final void onTDEBEventInitEvent(zz.a aVar) {
        try {
            if (Integer.parseInt(String.valueOf(aVar.paraMap.get("apiType"))) != 1) {
                return;
            }
            String strValueOf = String.valueOf(aVar.paraMap.get("action"));
            a aVar2 = (a) aVar.paraMap.get("service");
            if (strValueOf.equals("install") && aVar2.name().equals("TRACKING")) {
                bx bxVar = new bx();
                Object obj = aVar.paraMap.get("data");
                bxVar.f19906b = String.valueOf(aVar.paraMap.get("domain"));
                bxVar.f19907c = strValueOf;
                if (obj != null && (obj instanceof Map)) {
                    bxVar.f19908d = (Map) obj;
                }
                bxVar.f19905a = aVar2;
                ag.a().post(bxVar);
                return;
            }
            if (strValueOf.equals("init")) {
                Context context = ab.g;
                bq.a();
                be.a();
                bk.a();
                bf.a();
                bo.a();
                bg.a();
                if (!af.a(context)) {
                    bd.a().b();
                    bn.a().b();
                    br.a().b();
                }
                ab.f19748b = true;
                if (aVar2.name().equals("APP")) {
                    a(context, aVar2);
                }
                d(aVar2);
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    private void a(Context context, a aVar) {
        System.currentTimeMillis();
        af.f19761b = ab.u;
        if (f19862b) {
            return;
        }
        try {
            String str = "TalkingData App Analytics SDK init...\n\tSDK_VERSION is: Android+TD+V4.0.56 gp Type:" + ab.c() + "  Build_Num:" + ab.v + "\n\tApp ID is: " + ab.a(context, aVar) + "\n\tApp Channel is: " + ab.b(context, aVar) + "\n\tSDK_OVC is: " + d.f19990e;
            if (ab.f19748b || m.f20034a) {
                Log.i(ab.u, str);
            }
            f19862b = true;
        } catch (Throwable th) {
            m.a("[SDKInit] Failed to initialize!", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(a aVar) {
        try {
            if (aVar == null) {
                m.eForInternal("TDFeatures is null...");
            } else if (n.d(aVar) == 0) {
                n.b(System.currentTimeMillis(), aVar);
            } else if (System.currentTimeMillis() - n.d(aVar) > 86400000) {
                af.f19762c = true;
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    private static void d() {
        try {
            bx bxVar = new bx();
            bxVar.f19906b = "env";
            bxVar.f19907c = "getProp";
            TreeMap treeMap = new TreeMap();
            treeMap.put("sysproperty", af.a());
            bxVar.f19908d = treeMap;
            bxVar.f19905a = a.ENV;
            ag.a().post(bxVar);
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    public static bl a() {
        if (f19861a == null) {
            synchronized (bl.class) {
                if (f19861a == null) {
                    f19861a = new bl();
                }
            }
        }
        return f19861a;
    }
}
