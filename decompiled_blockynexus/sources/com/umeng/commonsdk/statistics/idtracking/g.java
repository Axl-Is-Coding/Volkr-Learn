package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.bf;
import com.umeng.analytics.pro.bl;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: IdTracker.java */
/* JADX INFO: loaded from: classes5.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f21193a = 86400000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static g f21194b;
    private static Object k = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private File f21196d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f21198f;
    private a i;
    private Context j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f21195c = "umeng_it_sl.cache";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.umeng.commonsdk.statistics.proto.c f21197e = null;
    private Set<com.umeng.commonsdk.statistics.idtracking.a> h = new HashSet();
    private long g = 86400000;

    /* JADX INFO: compiled from: IdTracker.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f21199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Set<String> f21200b = new HashSet();

        public a(Context context) {
            this.f21199a = context;
        }

        public synchronized boolean a(String str) {
            return !this.f21200b.contains(str);
        }

        public synchronized void b(String str) {
            this.f21200b.add(str);
        }

        public void c(String str) {
            this.f21200b.remove(str);
        }

        public synchronized void a() {
            if (!this.f21200b.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<String> it = this.f21200b.iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                    sb.append(',');
                }
                sb.deleteCharAt(sb.length() - 1);
                PreferenceWrapper.getDefault(this.f21199a).edit().putString("invld_id", sb.toString()).commit();
            }
        }

        public synchronized void b() {
            String[] strArrSplit;
            String string = PreferenceWrapper.getDefault(this.f21199a).getString("invld_id", null);
            if (!TextUtils.isEmpty(string) && (strArrSplit = string.split(",")) != null) {
                for (String str : strArrSplit) {
                    if (!TextUtils.isEmpty(str)) {
                        this.f21200b.add(str);
                    }
                }
            }
        }
    }

    g(Context context) {
        this.i = null;
        this.j = null;
        this.f21196d = new File(context.getFilesDir(), "umeng_it_sl.cache");
        this.i = new a(context);
        this.i.b();
        this.j = context.getApplicationContext();
    }

    public static synchronized g a(Context context) {
        if (f21194b == null) {
            f21194b = new g(context);
            f21194b.a(new i(context));
            f21194b.a(new b(context));
            f21194b.a(new t(context));
            f21194b.a(new f(context));
            f21194b.a(new d(context));
            f21194b.a(new k(context));
            f21194b.a(new p());
            f21194b.a(new n(context));
            r rVar = new r(context);
            if (!TextUtils.isEmpty(rVar.f())) {
                f21194b.a(rVar);
            }
            o oVar = new o(context);
            if (oVar.g()) {
                f21194b.a(oVar);
                f21194b.a(new m(context));
                oVar.i();
            }
            f21194b.e();
        }
        return f21194b;
    }

    private synchronized void g() {
        com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.h) {
            if (aVar.c()) {
                if (aVar.d() != null) {
                    map.put(aVar.b(), aVar.d());
                }
                if (aVar.e() != null && !aVar.e().isEmpty()) {
                    arrayList.addAll(aVar.e());
                }
            }
        }
        cVar.a(arrayList);
        cVar.a(map);
        synchronized (this) {
            this.f21197e = cVar;
        }
    }

    private com.umeng.commonsdk.statistics.proto.c h() {
        Throwable th;
        FileInputStream fileInputStream;
        synchronized (k) {
            if (!this.f21196d.exists()) {
                return null;
            }
            try {
                fileInputStream = new FileInputStream(this.f21196d);
                try {
                    try {
                        byte[] streamToByteArray = HelperUtils.readStreamToByteArray(fileInputStream);
                        com.umeng.commonsdk.statistics.proto.c cVar = new com.umeng.commonsdk.statistics.proto.c();
                        new bf().a(cVar, streamToByteArray);
                        HelperUtils.safeClose(fileInputStream);
                        return cVar;
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        HelperUtils.safeClose(fileInputStream);
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    HelperUtils.safeClose(fileInputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                HelperUtils.safeClose(fileInputStream);
                throw th;
            }
        }
    }

    public synchronized com.umeng.commonsdk.statistics.proto.c b() {
        return this.f21197e;
    }

    public String c() {
        return null;
    }

    public synchronized void d() {
        boolean z = false;
        for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.h) {
            if (aVar.c() && aVar.e() != null && !aVar.e().isEmpty()) {
                aVar.a((List<com.umeng.commonsdk.statistics.proto.a>) null);
                z = true;
            }
        }
        if (z) {
            this.f21197e.b(false);
            f();
        }
    }

    public synchronized void e() {
        com.umeng.commonsdk.statistics.proto.c cVarH = h();
        if (cVarH == null) {
            return;
        }
        a(cVarH);
        ArrayList arrayList = new ArrayList(this.h.size());
        synchronized (this) {
            this.f21197e = cVarH;
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.h) {
                aVar.a(this.f21197e);
                if (!aVar.c()) {
                    arrayList.add(aVar);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.h.remove((com.umeng.commonsdk.statistics.idtracking.a) it.next());
            }
            g();
        }
    }

    public synchronized void f() {
        if (this.f21197e != null) {
            b(this.f21197e);
        }
    }

    private void b(com.umeng.commonsdk.statistics.proto.c cVar) {
        byte[] bArrA;
        synchronized (k) {
            if (cVar != null) {
                try {
                    synchronized (this) {
                        a(cVar);
                        bArrA = new bl().a(cVar);
                    }
                    if (bArrA != null) {
                        HelperUtils.writeFile(this.f21196d, bArrA);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private boolean a(com.umeng.commonsdk.statistics.idtracking.a aVar) throws Throwable {
        if (this.i.a(aVar.b())) {
            return this.h.add(aVar);
        }
        if (!AnalyticsConstants.UM_DEBUG) {
            return false;
        }
        MLog.w("invalid domain: " + aVar.b());
        return false;
    }

    public void a(long j) {
        this.g = j;
    }

    public synchronized void a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f21198f >= this.g) {
            boolean z = false;
            for (com.umeng.commonsdk.statistics.idtracking.a aVar : this.h) {
                if (aVar.c() && aVar.a()) {
                    z = true;
                    if (!aVar.c()) {
                        this.i.b(aVar.b());
                    }
                }
            }
            if (z) {
                g();
                this.i.a();
                f();
            }
            this.f21198f = jCurrentTimeMillis;
        }
    }

    private void a(com.umeng.commonsdk.statistics.proto.c cVar) {
        Map<String, com.umeng.commonsdk.statistics.proto.b> map;
        if (cVar == null || (map = cVar.f21290a) == null || !map.containsKey("idfa") || !com.umeng.commonsdk.statistics.common.a.c(this.j)) {
            return;
        }
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> idTracker: remove idfa from snapshots.");
        cVar.f21290a.remove("idfa");
    }
}
