package com.tendcloud.tenddata;

import com.tendcloud.tenddata.bw;
import com.tendcloud.tenddata.zz;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.UUID;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class bq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile bq f19880a;

    static {
        try {
            ag.a().register(a());
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    private bq() {
    }

    private final void b(HashMap<String, Object> map) {
        try {
            a aVar = (a) map.get("service");
            long j = Long.parseLong(String.valueOf(map.get("occurTime")));
            if (map.containsKey("sessionEnd")) {
                a(aVar);
                return;
            }
            if (map.containsKey("pageName")) {
                n.setLastActivity(String.valueOf(map.get("pageName")));
            }
            b(aVar);
            n.c(j, aVar);
            ab.E = null;
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    public final void onTDEBEventSession(zz.a aVar) {
        HashMap<String, Object> map;
        if (aVar == null || (map = aVar.paraMap) == null) {
            return;
        }
        try {
            int i = Integer.parseInt(String.valueOf(map.get("apiType")));
            if (i == 10) {
                a(aVar.paraMap);
            } else if (i == 11) {
                b(aVar.paraMap);
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    private final void a(HashMap<String, Object> map) {
        try {
            a aVar = (a) map.get("service");
            long j = Long.parseLong(String.valueOf(map.get("occurTime")));
            long jC = n.c(aVar);
            long jF = n.f(aVar);
            if (jF <= jC) {
                jF = jC;
            }
            if (j - jF > ab.R) {
                a(aVar);
                a(j, aVar);
                n.setLastActivity("");
            } else {
                String strA = n.a(aVar);
                if (strA == null) {
                    a(j, aVar);
                    n.setLastActivity("");
                } else {
                    m.iForDeveloper("[" + aVar.name() + "][Session] - Same session as before! Session id is " + strA);
                    cs.a().setSessionId(strA);
                    cs.a().setSessionStartTime(jC);
                }
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        bw bwVar = new bw();
        bwVar.f19903a = aVar;
        bwVar.f19904b = bw.a.IMMEDIATELY;
        ag.a().post(bwVar);
    }

    private void a(final a aVar) {
        try {
            String strA = n.a(aVar);
            if (strA == null || strA.trim().isEmpty()) {
                return;
            }
            long jC = n.c(aVar);
            long jF = n.f(aVar) - jC;
            if ((aVar.name().equals("APP") || aVar.name().equals("APP_SQL") || aVar.name().equals("TRACKING") || aVar.name().equals("FINTECH")) && jF < 500) {
                jF = -1000;
            }
            bx bxVar = new bx();
            bxVar.f19906b = com.umeng.analytics.pro.b.at;
            bxVar.f19907c = "end";
            TreeMap treeMap = new TreeMap();
            treeMap.put("sessionId", strA);
            treeMap.put("start", Long.valueOf(jC));
            treeMap.put("duration", Long.valueOf(jF / 1000));
            bxVar.f19908d = treeMap;
            bxVar.f19905a = aVar;
            bxVar.f19910f = new cr() { // from class: com.tendcloud.tenddata.bq.1
                @Override // com.tendcloud.tenddata.cr
                public void onStoreFailed() {
                }

                @Override // com.tendcloud.tenddata.cr
                public void onStoreSuccess() {
                    try {
                        bq.this.b(aVar);
                    } catch (Throwable unused) {
                    }
                }
            };
            ag.a().post(bxVar);
            n.a((String) null, aVar);
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    private void a(long j, final a aVar) {
        try {
            m.iForDeveloper("[" + aVar.name() + "][Session] - New session!");
            String string = UUID.randomUUID().toString();
            m.iForDeveloper("[" + aVar.name() + "][Session] - Id: " + string);
            long jF = n.f(aVar);
            long j2 = j - jF;
            if (0 == jF) {
                j2 = 0;
            }
            n.a(string, aVar);
            n.a(j, aVar);
            n.b(string, aVar);
            cs.a().setSessionId(string);
            cs.a().setSessionStartTime(j);
            bx bxVar = new bx();
            bxVar.f19906b = com.umeng.analytics.pro.b.at;
            bxVar.f19907c = "begin";
            TreeMap treeMap = new TreeMap();
            treeMap.put("sessionId", string);
            treeMap.put(com.umeng.analytics.pro.au.aJ, Long.valueOf(j2 / 1000));
            bxVar.f19908d = treeMap;
            bxVar.f19905a = aVar;
            bxVar.f19910f = new cr() { // from class: com.tendcloud.tenddata.bq.2
                @Override // com.tendcloud.tenddata.cr
                public void onStoreFailed() {
                }

                @Override // com.tendcloud.tenddata.cr
                public void onStoreSuccess() {
                    try {
                        bq.this.b(aVar);
                    } catch (Throwable unused) {
                    }
                }
            };
            ag.a().post(bxVar);
            ab.Q.set(false);
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    public static bq a() {
        if (f19880a == null) {
            synchronized (bq.class) {
                if (f19880a == null) {
                    f19880a = new bq();
                }
            }
        }
        return f19880a;
    }
}
