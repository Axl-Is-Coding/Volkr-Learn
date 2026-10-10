package com.ironsource.mediationsdk;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.ironsource.environment.NetworkStateReceiver;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.U;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
class MediationInitializer implements NetworkStateReceiver.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static MediationInitializer f14689a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14692d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14693e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f14694f;
    private int g;
    private int h;
    private boolean i;
    private HandlerThread k;
    private Handler l;
    private AtomicBoolean n;
    private NetworkStateReceiver o;
    private CountDownTimer p;
    private Activity r;
    private String s;
    private String t;
    private com.ironsource.mediationsdk.utils.k u;
    private String w;
    private com.ironsource.mediationsdk.sdk.Y x;
    private boolean y;
    private long z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14690b = "appKey";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f14691c = MediationInitializer.class.getSimpleName();
    private boolean j = false;
    private boolean m = false;
    private List<b> q = new ArrayList();
    private a A = new C2312ba(this);
    private EInitStatus v = EInitStatus.NOT_INIT;

    enum EInitStatus {
        NOT_INIT,
        INIT_IN_PROGRESS,
        INIT_FAILED,
        INITIATED
    }

    abstract class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f14696b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f14695a = true;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected U.a f14697c = new C2318ea(this);

        a() {
        }
    }

    interface b {
        void a();

        void a(String str);

        void a(List<IronSource.AD_UNIT> list, boolean z);
    }

    private MediationInitializer() {
        this.k = null;
        this.k = new HandlerThread("IronSourceInitiatorHandler");
        this.k.start();
        this.l = new Handler(this.k.getLooper());
        this.f14692d = 1;
        this.f14693e = 0;
        this.f14694f = 62;
        this.g = 12;
        this.h = 5;
        this.n = new AtomicBoolean(true);
        this.i = false;
        this.y = false;
    }

    static /* synthetic */ int f(MediationInitializer mediationInitializer) {
        int i = mediationInitializer.f14693e;
        mediationInitializer.f14693e = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        return this.i;
    }

    void d() {
        a(EInitStatus.INIT_FAILED);
    }

    public static synchronized MediationInitializer b() {
        if (f14689a == null) {
            f14689a = new MediationInitializer();
        }
        return f14689a;
    }

    public synchronized boolean c() {
        return this.y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(EInitStatus eInitStatus) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, "setInitStatus(old status: " + this.v + ", new status: " + eInitStatus + ")", 0);
        this.v = eInitStatus;
    }

    public synchronized void a(Activity activity, String str, String str2, IronSource.AD_UNIT... ad_unitArr) {
        try {
            if (this.n != null && this.n.compareAndSet(true, false)) {
                a(EInitStatus.INIT_IN_PROGRESS);
                this.r = activity;
                this.s = str2;
                this.t = str;
                if (com.ironsource.mediationsdk.utils.j.d(activity)) {
                    this.l.post(this.A);
                } else {
                    this.m = true;
                    if (this.o == null) {
                        this.o = new NetworkStateReceiver(activity, this);
                    }
                    activity.getApplicationContext().registerReceiver(this.o, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    new Handler(Looper.getMainLooper()).post(new RunnableC2316da(this));
                }
            } else {
                com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.API, this.f14691c + ": Multiple calls to init are not allowed", 2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ironsource.environment.NetworkStateReceiver.a
    public void a(boolean z) {
        if (this.m && z) {
            CountDownTimer countDownTimer = this.p;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.m = false;
            this.i = true;
            this.l.post(this.A);
        }
    }

    public synchronized EInitStatus a() {
        return this.v;
    }

    public void a(b bVar) {
        if (bVar == null) {
            return;
        }
        this.q.add(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ironsource.mediationsdk.a.b a(String str) {
        com.ironsource.mediationsdk.a.b bVar = new com.ironsource.mediationsdk.a.b();
        if (str != null) {
            if (!a(str, 1, 64)) {
                bVar.a(com.ironsource.mediationsdk.utils.g.a("userId", str, null));
            }
        } else {
            bVar.a(com.ironsource.mediationsdk.utils.g.a("userId", str, "it's missing"));
        }
        return bVar;
    }

    private boolean a(String str, int i, int i2) {
        return str != null && str.length() >= i && str.length() <= i2;
    }
}
