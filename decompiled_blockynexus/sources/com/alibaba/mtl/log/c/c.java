package com.alibaba.mtl.log.c;

import com.alibaba.mtl.log.d.i;
import com.alibaba.mtl.log.d.s;
import com.alibaba.mtl.log.upload.UploadEngine;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: LogStoreMgr.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private static int A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f3620a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f3621d = new Object();
    private List<com.alibaba.mtl.log.model.a> l = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Runnable f3622b = new Runnable() { // from class: com.alibaba.mtl.log.c.c.1
        @Override // java.lang.Runnable
        public void run() {
            c.this.E();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.alibaba.mtl.log.c.a f59a = new com.alibaba.mtl.log.c.b(com.alibaba.mtl.log.a.getContext());

    /* JADX INFO: compiled from: LogStoreMgr.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.F();
            int iG = c.this.f59a.g();
            if (iG > 9000) {
                c.this.e(iG);
            }
        }
    }

    /* JADX INFO: compiled from: LogStoreMgr.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.a("LogStoreMgr", "CleanLogTask");
            int iG = c.this.f59a.g();
            if (iG > 9000) {
                c.this.e(iG);
            }
        }
    }

    private c() {
        UploadEngine.getInstance().start();
        s.a().b(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -3);
        this.f59a.c("time", String.valueOf(calendar.getTimeInMillis()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i) {
        if (i > 9000) {
            this.f59a.e((i - 9000) + 1000);
        }
    }

    public synchronized void E() {
        i.a("LogStoreMgr", "[store]");
        ArrayList arrayList = null;
        try {
            synchronized (this.l) {
                if (this.l.size() > 0) {
                    arrayList = new ArrayList(this.l);
                    this.l.clear();
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                this.f59a.mo21a((List<com.alibaba.mtl.log.model.a>) arrayList);
            }
        } catch (Throwable unused) {
        }
    }

    public void clear() {
        i.a("LogStoreMgr", "[clear]");
        this.f59a.clear();
        this.l.clear();
    }

    public static synchronized c a() {
        if (f3620a == null) {
            f3620a = new c();
        }
        return f3620a;
    }

    public void a(com.alibaba.mtl.log.model.a aVar) {
        i.a("LogStoreMgr", "[add] :", aVar.ab);
        com.alibaba.mtl.log.b.a.n(aVar.X);
        this.l.add(aVar);
        if (this.l.size() >= 100) {
            s.a().f(1);
            s.a().a(1, this.f3622b, 0L);
        } else if (!s.a().b(1)) {
            s.a().a(1, this.f3622b, 5000L);
        }
        synchronized (f3621d) {
            A++;
            if (A > 5000) {
                A = 0;
                s.a().b(new b());
            }
        }
    }

    public int a(List<com.alibaba.mtl.log.model.a> list) {
        i.a("LogStoreMgr", list);
        return this.f59a.a(list);
    }

    public List<com.alibaba.mtl.log.model.a> a(String str, int i) {
        List<com.alibaba.mtl.log.model.a> listA = this.f59a.a(str, i);
        i.a("LogStoreMgr", "[get]", listA);
        return listA;
    }
}
