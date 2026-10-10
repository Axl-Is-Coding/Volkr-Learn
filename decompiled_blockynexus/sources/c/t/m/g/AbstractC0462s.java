package c.t.m.g;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import c.t.m.g.AbstractC0483z;
import c.t.m.g.D;
import c.t.m.g.qc;
import com.google.android.gms.gcm.Task;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: c.t.m.g.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0462s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f3371a = 20;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f3372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f3373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AbstractC0483z f3374d;
    public int k;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AtomicInteger f3375e = new AtomicInteger(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<String> f3376f = new ArrayList();
    private volatile boolean g = false;
    private volatile boolean h = false;
    protected AtomicInteger i = new AtomicInteger(0);
    public AtomicInteger j = new AtomicInteger(0);
    private int l = 0;
    private long m = 0;
    private AtomicInteger n = new AtomicInteger(0);
    private volatile boolean o = false;
    private AbstractC0483z.a p = new C0471v(this);
    private final Runnable q = new RunnableC0477x(this);
    private final Runnable r = new RunnableC0480y(this);

    /* JADX INFO: renamed from: c.t.m.g.s$a */
    public abstract class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(AbstractC0462s abstractC0462s, byte b2) {
            this();
        }

        public final void a(boolean z) {
            if (!z) {
                AbstractC0462s.this.f3373c.post(this);
            } else {
                if (AbstractC0462s.this.f3373c.postAtFrontOfQueue(this)) {
                    return;
                }
                AbstractC0462s.this.f3373c.post(this);
            }
        }
    }

    /* JADX INFO: renamed from: c.t.m.g.s$b */
    public final class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f3378b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f3379c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f3380d;

        public b(String str) {
            super(AbstractC0462s.this, (byte) 0);
            this.f3378b = str;
            this.f3379c = false;
            this.f3380d = true;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AbstractC0462s.this.j.decrementAndGet();
            if (TextUtils.isEmpty(this.f3378b)) {
                return;
            }
            int iA = qc.a.a("report_new_record_num", 1, 50, 10);
            if (D.a(AbstractC0462s.this.b()).b(this.f3378b) == -1) {
                AbstractC0462s.c();
                return;
            }
            if (AbstractC0462s.this.o) {
                AbstractC0462s.this.o = false;
                AbstractC0462s.this.b(false, false);
            }
            if (AbstractC0462s.this.f3375e.incrementAndGet() >= iA) {
                AbstractC0462s.this.a(false, this.f3380d);
            }
        }
    }

    /* JADX INFO: renamed from: c.t.m.g.s$c */
    final class c extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private d f3382b;

        public c(d dVar) {
            super(AbstractC0462s.this, (byte) 0);
            this.f3382b = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AbstractC0462s.g(AbstractC0462s.this);
            AbstractC0462s.this.m = SystemClock.elapsedRealtime();
            int i = 0;
            if (!this.f3382b.f3387e) {
                if (qc.h()) {
                    if (AbstractC0462s.this.l > 0) {
                        if (AbstractC0462s.this.l < qc.a.a("report_interval_forbid_limit", 30, 1440, 60)) {
                            AbstractC0462s.n(AbstractC0462s.this);
                        }
                    } else {
                        AbstractC0462s.o(AbstractC0462s.this);
                    }
                }
                d dVar = this.f3382b;
                if (dVar.f3386d && dVar.f3385c) {
                    int size = dVar.f3388f.size();
                    while (i < size) {
                        D.a(AbstractC0462s.this.b()).b(this.f3382b.f3388f.get(i).f2893b);
                        i++;
                    }
                    return;
                }
                return;
            }
            if (AbstractC0462s.this.l > 0) {
                AbstractC0462s.k(AbstractC0462s.this);
            }
            AbstractC0462s.this.i.addAndGet(this.f3382b.h);
            d dVar2 = this.f3382b;
            if (!dVar2.f3385c) {
                int size2 = dVar2.f3388f.size();
                ArrayList arrayList = new ArrayList();
                while (i < size2) {
                    arrayList.add(Long.valueOf(this.f3382b.f3388f.get(i).f2892a));
                    i++;
                }
                D.a(AbstractC0462s.this.b()).a(arrayList);
                if (AbstractC0462s.this.h) {
                    AbstractC0462s.m(AbstractC0462s.this);
                    AbstractC0462s.this.a(true, this.f3382b.f3386d);
                    return;
                }
            }
            if (this.f3382b.f3384b) {
                AbstractC0462s.this.o = true;
                return;
            }
            SystemClock.sleep(200L);
            AbstractC0462s abstractC0462s = AbstractC0462s.this;
            d dVar3 = this.f3382b;
            abstractC0462s.a(dVar3.f3385c, dVar3.f3386d);
        }
    }

    /* JADX INFO: renamed from: c.t.m.g.s$d */
    final class d extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3384b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f3385c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f3386d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f3387e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<D.a> f3388f;
        private int g;
        int h;

        public d(boolean z, boolean z2) {
            super(AbstractC0462s.this, (byte) 0);
            this.f3387e = false;
            this.f3385c = z;
            this.f3386d = z2;
            this.g = 0;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f3384b = false;
            int unused = AbstractC0462s.f3371a = qc.a.a("report_max_report_count", 10, 100, 20);
            List<D.a> listB = null;
            if (this.f3385c) {
                int size = AbstractC0462s.this.f3376f.size();
                if (size != 0) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    int i = 0;
                    for (int i2 = 0; i < size && i2 < AbstractC0462s.f3371a; i2++) {
                        String str = (String) AbstractC0462s.this.f3376f.get(i);
                        arrayList2.add(new D.a(0L, str));
                        arrayList.add(str);
                        i++;
                    }
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        AbstractC0462s.this.f3376f.remove(arrayList.get(i3));
                    }
                    if (AbstractC0462s.this.f3376f.size() == 0) {
                        this.f3384b = true;
                    }
                    listB = arrayList2;
                }
                this.f3388f = listB;
            } else {
                if (!D.a(AbstractC0462s.this.b()).a(qc.a.a("report_clear_db_num", 1, 10000, 1000))) {
                    listB = D.a(AbstractC0462s.this.b()).b(AbstractC0462s.f3371a + 1);
                    if (listB.size() <= AbstractC0462s.f3371a) {
                        this.f3384b = true;
                        AbstractC0462s.this.o = true;
                    } else {
                        listB.remove(listB.size() - 1);
                    }
                }
                this.f3388f = listB;
            }
            List<D.a> list = this.f3388f;
            if (list == null || list.size() == 0) {
                AbstractC0462s.g(AbstractC0462s.this);
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i4 = 0; i4 < this.f3388f.size(); i4++) {
                sb.append(this.f3388f.get(i4).f2893b);
                sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            }
            String string = sb.toString();
            if (this.f3385c && string.contains("client_report_time")) {
                string = string.replace("client_report_time", C0455pa.a(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
            }
            byte[] bytes = string.getBytes();
            int length = bytes.length;
            this.h = length;
            byte[] bArrA = qc.a.a(bytes);
            AbstractC0462s.b(bArrA.length);
            AbstractC0462s.this.f3374d.a(bArrA, length, this.f3385c, this, AbstractC0462s.this.p);
        }
    }

    public AbstractC0462s() {
        A.a(fc.a());
        this.f3373c = qc.a.a("ReportAction");
        this.f3374d = new C0465t();
        a(true);
        b(true, false);
        this.k = a();
    }

    private void a(boolean z) {
        if (z) {
            this.f3373c.postDelayed(new RunnableC0474w(this), 5000L);
        } else {
            if (this.f3372b == 0 || SystemClock.elapsedRealtime() - this.f3372b <= 1800000) {
                return;
            }
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z, boolean z2) {
        a(false);
        if (z && z2) {
            b(false, true);
        } else {
            b(false, false);
        }
        if (!this.g) {
            if (!z) {
                this.f3375e.set(0);
            }
            if (this.m != 0 && SystemClock.elapsedRealtime() - this.m < this.l * 60 * 1000) {
                return;
            }
            this.g = true;
            try {
                new d(z, z2).a(true);
            } catch (Throwable unused) {
                this.g = false;
            }
        } else if (z) {
            this.h = true;
        }
    }

    static /* synthetic */ void b(int i) {
        int iC = C0446ma.c("report_using_traffic");
        if (iC == 0) {
            C0446ma.a("report_traffic_last_time", System.currentTimeMillis());
        }
        C0446ma.a("report_using_traffic", iC + i);
    }

    static /* synthetic */ void c() {
        C0446ma.a("report_missing_event", C0446ma.c("report_missing_event") + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f3372b = SystemClock.elapsedRealtime();
        int iC = C0446ma.c("report_missing_event");
        int iC2 = C0446ma.c("report_using_traffic");
        int iA = qc.a.a("report_using_traffic_limit", 1, Task.EXTRAS_LIMIT_BYTES, 32);
        if (iC != 0 || iC2 >= (iA << 10)) {
            long jB = C0446ma.b("report_traffic_last_time");
            if (jB == 0) {
                C0446ma.a("report_traffic_last_time", System.currentTimeMillis());
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - jB;
            HashMap map = new HashMap();
            map.put("B110", String.valueOf(iC2));
            map.put("B112", jCurrentTimeMillis < 0 ? "0" : String.valueOf(jCurrentTimeMillis));
            if (iC == 0) {
                jc.b("HLReportEvent", fc.c(), 0, "", map, null, false);
            } else {
                map.put("B111", String.valueOf(iC));
                jc.b("HLReportEvent", fc.c(), -500, "", map, null, false);
                C0446ma.a("report_missing_event", 0);
            }
            C0446ma.a("report_using_traffic", 0);
        }
    }

    static /* synthetic */ boolean g(AbstractC0462s abstractC0462s) {
        abstractC0462s.g = false;
        return false;
    }

    static /* synthetic */ int k(AbstractC0462s abstractC0462s) {
        int i = abstractC0462s.l - 10;
        abstractC0462s.l = i;
        return i;
    }

    static /* synthetic */ boolean m(AbstractC0462s abstractC0462s) {
        abstractC0462s.h = false;
        return false;
    }

    static /* synthetic */ int n(AbstractC0462s abstractC0462s) {
        int i = abstractC0462s.l << 1;
        abstractC0462s.l = i;
        return i;
    }

    static /* synthetic */ int o(AbstractC0462s abstractC0462s) {
        abstractC0462s.l = 5;
        return 5;
    }

    public abstract int a();

    public abstract String b();

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, boolean z2) {
        if (z2) {
            if (this.n.get() > 3) {
                this.n.set(0);
                return;
            } else {
                C0430h.a().a(this.q, false, qc.a.a("report_real_timer_interval", 1, 60, 5) * 1000);
                return;
            }
        }
        if (z) {
            C0430h.a().a(this.r, false, 10000L);
        } else {
            if (this.o) {
                return;
            }
            C0430h.a().a(this.r, false, qc.a.a("report_timer_interval", 30000, 600000, 300000));
        }
    }
}
