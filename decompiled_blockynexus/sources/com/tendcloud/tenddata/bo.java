package com.tendcloud.tenddata;

import com.facebook.places.model.PlaceFields;
import com.tendcloud.tenddata.zz;
import java.util.HashMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class bo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile bo f19875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashMap<String, Object> f19876b = new HashMap<>();

    /* JADX INFO: compiled from: td */
    final class a {
        private String pageName;
        private String refer;
        private long startTime;

        private String getPageName() {
            return this.pageName;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getRefer() {
            return this.refer;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long getStartTime() {
            return this.startTime;
        }

        public String toString() {
            return "pageName: " + this.pageName + "\nfrom: " + this.refer + "\nstartTime: " + this.startTime;
        }

        private a(long j, String str, String str2) {
            this.startTime = 0L;
            this.refer = "";
            this.pageName = "";
            this.startTime = j;
            this.refer = str;
            this.pageName = str2;
        }
    }

    static {
        try {
            ag.a().register(a());
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    private bo() {
    }

    public static bo a() {
        if (f19875a == null) {
            synchronized (bq.class) {
                if (f19875a == null) {
                    f19875a = new bo();
                }
            }
        }
        return f19875a;
    }

    public final void onTDEBEventPage(zz.a aVar) {
        if (aVar != null) {
            try {
                if (aVar.paraMap == null) {
                    return;
                }
                int i = Integer.parseInt(String.valueOf(aVar.paraMap.get("apiType")));
                if ((i == 4 || i == 5) && !String.valueOf(aVar.paraMap.get("occurTime")).trim().isEmpty()) {
                    a(aVar.paraMap);
                }
            } catch (Throwable th) {
                bp.postSDKError(th);
            }
        }
    }

    private void a(HashMap<String, Object> map) {
        try {
            int i = Integer.parseInt(String.valueOf(map.get("apiType")));
            com.tendcloud.tenddata.a aVar = (com.tendcloud.tenddata.a) map.get("service");
            if (i == 4) {
                a(Long.parseLong(String.valueOf(map.get("occurTime"))), String.valueOf(map.get("pageName")), ab.E == null ? n.d() : ab.E, aVar);
            } else {
                if (i != 5) {
                    return;
                }
                a(String.valueOf(map.get("pageName")), aVar);
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0031 A[Catch: Throwable -> 0x009c, TryCatch #0 {Throwable -> 0x009c, blocks: (B:7:0x0010, B:9:0x0016, B:12:0x0045, B:10:0x0031), top: B:17:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void a(long r9, java.lang.String r11, java.lang.String r12, com.tendcloud.tenddata.a r13) {
        /*
            r8 = this;
            r0 = 1
            com.tendcloud.tenddata.zz.f20076c = r0
            java.util.HashMap<java.lang.String, java.lang.Object> r0 = r8.f19876b
            boolean r0 = r0.containsKey(r11)
            if (r0 == 0) goto Lc
            return
        Lc:
            java.lang.String r0 = "onPageStart being called!  pagename: "
            if (r12 == 0) goto L31
            boolean r1 = r12.isEmpty()     // Catch: java.lang.Throwable -> L9c
            if (r1 != 0) goto L31
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9c
            r1.<init>()     // Catch: java.lang.Throwable -> L9c
            r1.append(r0)     // Catch: java.lang.Throwable -> L9c
            r1.append(r11)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r0 = ", refer: "
            r1.append(r0)     // Catch: java.lang.Throwable -> L9c
            r1.append(r12)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> L9c
            com.tendcloud.tenddata.m.iForDeveloper(r0)     // Catch: java.lang.Throwable -> L9c
            goto L43
        L31:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9c
            r1.<init>()     // Catch: java.lang.Throwable -> L9c
            r1.append(r0)     // Catch: java.lang.Throwable -> L9c
            r1.append(r11)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> L9c
            com.tendcloud.tenddata.m.iForDeveloper(r0)     // Catch: java.lang.Throwable -> L9c
        L43:
            if (r11 == 0) goto La0
            com.tendcloud.tenddata.bo$a r0 = new com.tendcloud.tenddata.bo$a     // Catch: java.lang.Throwable -> L9c
            r7 = 0
            r1 = r0
            r2 = r8
            r3 = r9
            r5 = r12
            r6 = r11
            r1.<init>(r3, r5, r6)     // Catch: java.lang.Throwable -> L9c
            java.util.HashMap<java.lang.String, java.lang.Object> r9 = r8.f19876b     // Catch: java.lang.Throwable -> L9c
            r9.put(r11, r0)     // Catch: java.lang.Throwable -> L9c
            com.tendcloud.tenddata.bx r9 = new com.tendcloud.tenddata.bx     // Catch: java.lang.Throwable -> L9c
            r9.<init>()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r10 = "page"
            r9.f19906b = r10     // Catch: java.lang.Throwable -> L9c
            java.lang.String r10 = "enter"
            r9.f19907c = r10     // Catch: java.lang.Throwable -> L9c
            java.util.TreeMap r10 = new java.util.TreeMap     // Catch: java.lang.Throwable -> L9c
            r10.<init>()     // Catch: java.lang.Throwable -> L9c
            java.lang.String r11 = "startTime"
            long r1 = com.tendcloud.tenddata.bo.a.access$100(r0)     // Catch: java.lang.Throwable -> L9c
            java.lang.Long r12 = java.lang.Long.valueOf(r1)     // Catch: java.lang.Throwable -> L9c
            r10.put(r11, r12)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r11 = "duration"
            r12 = 0
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch: java.lang.Throwable -> L9c
            r10.put(r11, r12)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r11 = "name"
            java.lang.String r12 = com.tendcloud.tenddata.bo.a.access$200(r0)     // Catch: java.lang.Throwable -> L9c
            r10.put(r11, r12)     // Catch: java.lang.Throwable -> L9c
            java.lang.String r11 = "from"
            java.lang.String r12 = com.tendcloud.tenddata.bo.a.access$300(r0)     // Catch: java.lang.Throwable -> L9c
            r10.put(r11, r12)     // Catch: java.lang.Throwable -> L9c
            r9.f19908d = r10     // Catch: java.lang.Throwable -> L9c
            r9.f19905a = r13     // Catch: java.lang.Throwable -> L9c
            com.tendcloud.tenddata.ag r10 = com.tendcloud.tenddata.ag.a()     // Catch: java.lang.Throwable -> L9c
            r10.post(r9)     // Catch: java.lang.Throwable -> L9c
            goto La0
        L9c:
            r9 = move-exception
            com.tendcloud.tenddata.bp.postSDKError(r9)
        La0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tendcloud.tenddata.bo.a(long, java.lang.String, java.lang.String, com.tendcloud.tenddata.a):void");
    }

    private final void a(String str, com.tendcloud.tenddata.a aVar) {
        if (this.f19876b.containsKey(str)) {
            try {
                m.iForDeveloper("onPageEnd being called! pageName: " + str);
                a aVar2 = (a) this.f19876b.remove(str);
                if (aVar2 != null) {
                    bx bxVar = new bx();
                    bxVar.f19906b = PlaceFields.PAGE;
                    bxVar.f19907c = "leave";
                    double dCurrentTimeMillis = System.currentTimeMillis() - aVar2.getStartTime();
                    Double.isNaN(dCurrentTimeMillis);
                    long jRound = Math.round(dCurrentTimeMillis / 1000.0d);
                    TreeMap treeMap = new TreeMap();
                    treeMap.put("startTime", Long.valueOf(aVar2.getStartTime()));
                    treeMap.put("name", str);
                    treeMap.put("from", aVar2.getRefer());
                    treeMap.put("duration", Long.valueOf(jRound));
                    bxVar.f19908d = treeMap;
                    bxVar.f19905a = aVar;
                    ag.a().post(bxVar);
                }
                if (ab.D) {
                    n.setLastActivity(str);
                }
                ab.E = str;
            } catch (Throwable th) {
                bp.postSDKError(th);
            }
        }
    }
}
