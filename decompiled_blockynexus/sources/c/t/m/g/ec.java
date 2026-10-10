package c.t.m.g;

import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import c.t.m.g.C0470ub;
import c.t.m.g.C0473vb;
import c.t.m.g.Ob;
import cn.qqtheme.framework.widget.WheelView;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManagerOptions;
import com.tencent.map.geolocation.TencentLocationRequest;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class ec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SparseArray<String> f3151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TencentLocationListener f3152b;
    private long H;
    public Ob K;
    private double L;
    private double M;
    private Ob N;
    private long P;
    private String R;
    private C0458qa T;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f3154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c f3155e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Handler f3156f;
    private boolean g;
    private C0441kb h;
    private C0464sb i;
    private boolean j;
    private C0453ob k;
    public eh l;
    private C0450nb m;
    private C0438jb n;
    private ed o;
    private C0470ub p;
    public volatile int q;
    private C0473vb r;
    private ek s;
    private Db t;
    private Db u;
    private el v;
    private final C0423eb w;
    public Ya x;
    public TencentLocationListener y;
    public List<TencentLocationListener> z;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3153c = 1;
    public long A = 0;
    private volatile boolean B = false;
    public volatile long C = 0;
    public volatile int D = 0;
    private int E = 0;
    private int F = 0;
    private int G = 0;
    public final Object I = new Object();
    public final TencentLocationRequest J = TencentLocationRequest.create();
    public int O = 404;
    public volatile int Q = b.f3165d;
    private volatile boolean S = false;
    private boolean U = false;
    private byte[] V = new byte[0];

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: TL */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f3162a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f3163b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f3164c = 3;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f3165d = 4;

        static {
            int[] iArr = {1, 2, 3, 4};
        }
    }

    /* JADX INFO: compiled from: TL */
    class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            TencentLocationListener tencentLocationListener;
            TencentLocationListener tencentLocationListener2;
            Bundle data = message.getData();
            if (data == null) {
                return;
            }
            switch (message.what) {
                case 3101:
                case 3103:
                    int i = data.getInt(NativeProtocol.BRIDGE_ARG_ERROR_CODE);
                    Ob ob = Ob.f2969a;
                    if (i == 0) {
                        ob = (Ob) data.getParcelable("tx_location");
                    }
                    int i2 = message.what;
                    if (i2 == 3101) {
                        synchronized (ec.this.I) {
                            tencentLocationListener = ec.this.y;
                            break;
                        }
                        if (tencentLocationListener != null) {
                            tencentLocationListener.onLocationChanged(ob, i, (String) ec.f3151a.get(i));
                            return;
                        }
                        return;
                    }
                    if (i2 != 3103 || ec.this.z == null) {
                        return;
                    }
                    for (TencentLocationListener tencentLocationListener3 : ec.this.z) {
                        if (tencentLocationListener3 != null) {
                            tencentLocationListener3.onLocationChanged(ob, i, (String) ec.f3151a.get(i));
                        }
                    }
                    ec.this.z.clear();
                    return;
                case 3102:
                    String string = data.getString("name");
                    int i3 = data.getInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
                    String string2 = data.getString("desc");
                    synchronized (ec.this.I) {
                        tencentLocationListener2 = ec.this.y;
                        break;
                    }
                    if (tencentLocationListener2 != null) {
                        tencentLocationListener2.onStatusUpdate(string, i3, string2);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        f3151a = sparseArray;
        sparseArray.put(0, "OK");
        f3151a.put(1, "ERROR_NETWORK");
        f3151a.put(2, "ERROR_NOCELL&WIFI_LOCATIONSWITCHOFF");
        f3151a.put(4, "DEFLECT_FAILED");
        f3151a.put(404, "ERROR_SERVER_NOT_LOCATION");
        HashMap map = new HashMap();
        map.put("https", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        map.put("up_apps", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        map.put("start_daemon", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        map.put("up_daemon_delay", "300000");
        map.put("gps_kalman", "false");
        map.put("callback_wifis", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        map.put("min_wifi_scan_interval", "8000");
        map.put("collect_bles", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        map.put("start_event_track", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        map.put("f_coll_item", "2");
        map.put("f_coll_up_net", "w");
        Ga.a((HashMap<String, String>) map);
        f3152b = new C0456pb();
    }

    public ec(C0423eb c0423eb) {
        this.q = 0;
        this.w = c0423eb;
        if (TencentLocationManagerOptions.isLoadLibraryEnabled()) {
            try {
                System.loadLibrary("tencentloc");
            } catch (Throwable unused) {
                this.q = 3;
                return;
            }
        }
        this.x = this.w.f3148d;
        try {
            if (!TextUtils.isEmpty(TencentLocationManagerOptions.getKey())) {
                this.x.i = TencentLocationManagerOptions.getKey();
            }
        } catch (Throwable unused2) {
        }
        this.R = a(C0458qa.a(this.x.i));
        if (TextUtils.isEmpty(this.R)) {
            this.q = 2;
            return;
        }
        this.w.a(this);
        this.r = new C0473vb();
        this.z = new CopyOnWriteArrayList();
        this.o = new ed(this.w);
        this.p = new C0470ub(this.w);
        this.m = C0450nb.a(c0423eb.f3147c);
        if (Build.VERSION.SDK_INT >= 21) {
            this.n = new C0438jb(this.w.f3147c);
        }
        this.j = Build.VERSION.SDK_INT >= 18;
        if (this.j) {
            this.h = null;
            this.l = n();
            this.i = this.w.b() ? new C0464sb(this.w) : null;
            C0453ob c0453obM = m();
            this.k = c0453obM;
            new Object[1][0] = c0453obM;
            this.g = false;
        } else {
            this.i = null;
            this.l = n();
            this.h = this.w.b() ? new C0441kb(this.w) : null;
            C0453ob c0453obM2 = m();
            this.k = c0453obM2;
            new Object[1][0] = c0453obM2;
            this.g = false;
        }
        try {
            Ga.a(this.w.f3147c, "txsdk", this.w.f3148d.d());
            Ga.a(this.R);
        } catch (Throwable unused3) {
        }
    }

    static /* synthetic */ boolean c() {
        return false;
    }

    private C0453ob m() {
        if (this.w.d()) {
            return new C0453ob(this.w);
        }
        return null;
    }

    static /* synthetic */ boolean t(ec ecVar) {
        ecVar.S = true;
        return true;
    }

    static /* synthetic */ Db v(ec ecVar) {
        ecVar.t = null;
        return null;
    }

    static /* synthetic */ long x(ec ecVar) {
        ecVar.A = 0L;
        return 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onCellInfoEvent(c.t.m.g.ek r9) throws java.lang.Throwable {
        /*
            r8 = this;
            r8.s = r9
            com.tencent.map.geolocation.TencentLocationRequest r0 = r8.J
            long r0 = r0.getInterval()
            r2 = 20000(0x4e20, double:9.8813E-320)
            long r0 = java.lang.Math.max(r0, r2)
            java.util.List r2 = java.util.Collections.emptyList()
            c.t.m.g.eh r3 = r8.l
            r4 = 1
            if (r3 == 0) goto L1d
            boolean r3 = r3.b()
            r3 = r3 ^ r4
            goto L1e
        L1d:
            r3 = 1
        L1e:
            if (r3 == 0) goto L23
            r5 = 0
            r8.t = r5
        L23:
            if (r3 == r4) goto L32
            c.t.m.g.eb r5 = r8.w
            if (r5 == 0) goto L32
            android.net.wifi.WifiManager r2 = r5.i
            java.util.List r2 = c.t.m.g.Xb.c(r2)
            r2.size()
        L32:
            if (r3 == r4) goto L53
            int r2 = r2.size()
            if (r2 == 0) goto L53
            long r2 = r8.H
            r4 = -1
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L53
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L58
            long r2 = java.lang.System.currentTimeMillis()
            long r4 = r8.H
            long r2 = r2 - r4
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 <= 0) goto L58
        L53:
            r0 = 3999(0xf9f, float:5.604E-42)
            r8.a(r0)
        L58:
            c.t.m.g.qa r0 = r8.T
            if (r0 == 0) goto L7f
            c.t.m.g.cp r0 = new c.t.m.g.cp
            int r2 = r9.f3177b
            int r3 = r9.f3178c
            int r4 = r9.f3179d
            int r5 = r9.f3180e
            int r6 = r9.f3181f
            c.t.m.g.ek$a r9 = r9.f3176a
            int r7 = r9.ordinal()
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r9.add(r0)
            c.t.m.g.qa r1 = r8.T
            r1.a(r0, r9)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.ec.onCellInfoEvent(c.t.m.g.ek):void");
    }

    public final void onGpsInfoEvent(el elVar) {
        double d2;
        double d3;
        Ob obA;
        if (elVar.f3187a != C0444lb.f3290a) {
            this.v = elVar;
            int i = this.f3153c;
            int requestLevel = this.J.getRequestLevel();
            Ob ob = this.N;
            Location location = new Location(elVar.f3187a);
            Bundle extras = location.getExtras();
            if (extras != null) {
                d2 = extras.getDouble(com.umeng.analytics.pro.b.B);
                d3 = extras.getDouble(com.umeng.analytics.pro.b.C);
            } else {
                d2 = 0.0d;
                d3 = 0.0d;
            }
            if (i == 0) {
                Ob.a aVar = new Ob.a();
                aVar.f2976b = ob;
                aVar.f2978d = "gps";
                aVar.f2977c = requestLevel;
                aVar.a(new Location(elVar.f3187a));
                obA = aVar.a();
                location.setLatitude(d2);
                location.setLongitude(d3);
                obA.a(location);
            } else {
                if (k()) {
                    a(3999);
                }
                Ob.a aVar2 = new Ob.a();
                aVar2.f2976b = ob;
                aVar2.f2978d = "gps";
                aVar2.f2977c = requestLevel;
                aVar2.a(new Location(elVar.f3187a));
                obA = aVar2.a();
                location.setLatitude(d2);
                location.setLongitude(d3);
                obA.a(location);
            }
            if (this.D != 2) {
                a(0, obA);
            }
            a(12004, 3);
        }
        C0458qa c0458qa = this.T;
        if (c0458qa != null) {
            Location location2 = elVar.f3187a;
            synchronized (c0458qa.f3350b) {
                if (c0458qa.c()) {
                    if (location2 != null && "gps".equals(location2.getProvider()) && location2.getAltitude() != 0.0d) {
                        boolean z = C0481ya.h;
                        if (Build.VERSION.SDK_INT >= 18 && location2.isFromMockProvider()) {
                            return;
                        }
                        c0458qa.f3354f = C0458qa.a(c0458qa.f3354f, location2);
                        if (c0458qa.g == null || (c0458qa.f3354f != null && c0458qa.f3354f.distanceTo(c0458qa.g) >= 50.0f && System.currentTimeMillis() - c0458qa.o >= 5000)) {
                            c0458qa.b();
                        }
                    }
                }
            }
        }
    }

    public final void onNetworkEvent(Integer num) {
        C0458qa.d(this.w.f3147c);
        int iIntValue = num.intValue();
        if (iIntValue == -1 || iIntValue == 0 || iIntValue != 1) {
            return;
        }
        a(7999, 1000L);
    }

    public final void onStatusEvent(Message message) {
        int i = message.what;
        a(message.arg1, message.arg2);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onWifiInfoEvent(c.t.m.g.Db r13) {
        /*
            Method dump skipped, instruction units count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.ec.onWifiInfoEvent(c.t.m.g.Db):void");
    }

    /* JADX INFO: compiled from: TL */
    class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f3157a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f3158b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f3159c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f3160d;

        a(Looper looper) {
            super(looper);
            this.f3160d = 0;
            this.f3157a = 0L;
            this.f3158b = false;
            this.f3159c = false;
        }

        private void b(int i) {
            double d2;
            Location locationA = ec.this.k.a();
            if (locationA == C0444lb.f3290a || ec.this.H != 0 || System.currentTimeMillis() - locationA.getTime() > 120000) {
                if (ec.this.O == 0 && ec.this.K != null && System.currentTimeMillis() - ec.this.K.getTime() < 60000) {
                    a(0);
                    return;
                } else {
                    ec.this.a(i, Ob.f2969a);
                    a(i);
                    return;
                }
            }
            Location location = new Location(locationA);
            Bundle extras = location.getExtras();
            double d3 = 0.0d;
            if (extras != null) {
                d3 = extras.getDouble(com.umeng.analytics.pro.b.B);
                d2 = extras.getDouble(com.umeng.analytics.pro.b.C);
            } else {
                d2 = 0.0d;
            }
            Ob.a aVar = new Ob.a();
            aVar.f2978d = TencentLocation.NETWORK_PROVIDER;
            aVar.a(locationA);
            Ob obA = aVar.a();
            if (ec.this.f3153c == 1) {
                location.setLatitude(d3);
                location.setLongitude(d2);
                obA.a(location);
            }
            if (!ec.this.l()) {
                ec.this.a(0, obA);
            }
            a(0);
        }

        public final void a() {
            this.f3160d = 0;
            removeCallbacksAndMessages(null);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            synchronized (ec.this.I) {
                if ((ec.this.y != null) || ec.this.Q != b.f3162a) {
                    TencentLocationRequest tencentLocationRequest = ec.this.J;
                    int requestLevel = tencentLocationRequest.getRequestLevel();
                    long j = ec.this.C;
                    try {
                        int i = message.what;
                        if (i == 554) {
                            Bundle data = message.getData();
                            if (data != null) {
                                String string = data.getString("WIFIS");
                                if (TextUtils.isEmpty(string)) {
                                    return;
                                }
                                C0470ub c0470ub = ec.this.p;
                                if (TextUtils.isEmpty(string)) {
                                    return;
                                }
                                byte[] bArrA = Vb.a(string.getBytes("UTF-8"));
                                com.tencent.tencentmap.lbssdk.service.e.o(bArrA, 2);
                                C0470ub.a aVar = new C0470ub.a(3, bArrA, "https://ue.indoorloc.map.qq.com/?wl", null);
                                aVar.g = string;
                                c0470ub.a(aVar);
                                return;
                            }
                            return;
                        }
                        if (i == 555) {
                            ec.v(ec.this);
                            sendEmptyMessage(3999);
                            return;
                        }
                        if (i == 3997) {
                            Bb bbM = ec.m(ec.this);
                            String strA = bbM.a(requestLevel, ec.this.R, ec.this.w, false, false, false);
                            if (!Vb.a(strA)) {
                                b(2);
                                return;
                            } else {
                                ec.this.p.a(strA, bbM, ec.this.f3153c);
                                return;
                            }
                        }
                        if (i != 3999) {
                            if (i != 7999) {
                                if (i == 4998) {
                                    if (ec.this.x.o == 0) {
                                        ec.this.x.o = -1L;
                                    }
                                    b(1);
                                    ec.this.H = -1L;
                                    return;
                                }
                                if (i != 4999) {
                                    if (i == 11998) {
                                        if (ec.this.K != null) {
                                            ec.this.a(ec.this.K);
                                            ec.this.a(ec.this.K, ec.this.O, 3101);
                                            return;
                                        }
                                        return;
                                    }
                                    if (i != 11999) {
                                        return;
                                    }
                                    if (ec.this.K != null && tencentLocationRequest.getInterval() > 0) {
                                        ec.this.a(ec.this.K);
                                        ec.this.a(ec.this.K, ec.this.O, 3101);
                                    }
                                    if (j > 0) {
                                        sendEmptyMessageDelayed(11999, j);
                                        return;
                                    }
                                    return;
                                }
                                if (ec.this.x.o == 0) {
                                    ec.this.x.o = System.currentTimeMillis() - ec.this.x.n;
                                }
                                removeMessages(4998);
                                Pair pair = (Pair) message.obj;
                                String string2 = pair.first.toString();
                                C0470ub.a aVar2 = (C0470ub.a) pair.second;
                                Bb bb = (Bb) aVar2.f3424e;
                                ec.this.u = bb.f2879b;
                                String str = aVar2.g;
                                try {
                                    Ob.a aVar3 = new Ob.a();
                                    aVar3.f2975a = string2;
                                    aVar3.f2977c = requestLevel;
                                    aVar3.f2978d = TencentLocation.NETWORK_PROVIDER;
                                    Ob obA = aVar3.a();
                                    obA.getExtra().putString(TencentLocation.EXTRA_RESP_JSON, string2);
                                    if (obA.isMockGps() == 1) {
                                        this.f3159c = true;
                                    }
                                    Ob.a(obA);
                                    try {
                                        Fb.a(obA, str);
                                        obA.getExtra().putInt("sat_num", bb.f2881d != null ? bb.f2881d.f3190d : 0);
                                        obA.getExtra().putLong("req_cost", message.arg1);
                                        obA.getExtra().putLong("req_start", aVar2.h);
                                        if (Ha.a().d("callback_wifis")) {
                                            obA.getExtra().putLong("wifi_collect_time", aVar2.h);
                                            obA.getExtra().putString("wlan", Xb.c(ec.this.w));
                                            obA.getExtra().putString("wifis", ec.this.l.n.toString());
                                        }
                                    } catch (Throwable unused) {
                                    }
                                    ec.this.H = System.currentTimeMillis();
                                    boolean z = !TextUtils.isEmpty(obA.getIndoorBuildingId());
                                    if (z && ec.this.D == 1) {
                                        ec.this.D = 2;
                                        this.f3160d = 0;
                                    }
                                    if (ec.this.D == 2) {
                                        if (z) {
                                            this.f3160d = 0;
                                        } else {
                                            this.f3160d++;
                                        }
                                        if (this.f3160d >= 5) {
                                            ec.this.D = 1;
                                            this.f3160d = 0;
                                        }
                                    }
                                    if (!ec.this.l() || (z && ec.this.D > 0)) {
                                        Ob.a(obA, z);
                                        ec.this.a(0, obA);
                                    }
                                    if (ec.this.K != null) {
                                        Ob.a(ec.this.K, obA);
                                    }
                                    a(0);
                                    ec.this.N = obA;
                                    if (ec.this.Q != b.f3162a || ec.this.S) {
                                        return;
                                    }
                                    Ga.a().b();
                                    ec.t(ec.this);
                                    return;
                                } catch (JSONException unused2) {
                                    b(404);
                                    return;
                                }
                            }
                            if (ec.this.k()) {
                                return;
                            }
                            long jMax = Math.max(ec.this.J.getInterval(), 4000L);
                            if (ec.this.H == 0 || System.currentTimeMillis() - ec.this.H < jMax) {
                                return;
                            }
                        }
                        removeMessages(3999);
                        if (ec.this.Q != b.f3163b) {
                            ec.c();
                        } else {
                            long jC = Ha.a().c("up_daemon_delay");
                            if (jC < 120000) {
                                jC = 120000;
                            }
                            if (System.currentTimeMillis() - ec.this.P < jC) {
                                return;
                            } else {
                                ec.this.P = System.currentTimeMillis();
                            }
                        }
                        int i2 = ec.this.f3153c;
                        Bb bbM2 = ec.m(ec.this);
                        if (!(bbM2.f2881d != null) || System.currentTimeMillis() - this.f3157a <= 60000) {
                            this.f3158b = false;
                        } else {
                            this.f3158b = true;
                            this.f3159c = false;
                            this.f3157a = System.currentTimeMillis();
                        }
                        String strA2 = bbM2.a(requestLevel, ec.this.R, ec.this.w, this.f3158b, this.f3159c, ec.this.Q == b.f3163b);
                        if (strA2 == null || !Vb.a(strA2)) {
                            b(2);
                            return;
                        }
                        if (ec.this.Q != b.f3162a || !Fb.a(tencentLocationRequest)) {
                            if (Fb.f2904a) {
                                ec.this.p.a(strA2, bbM2, i2);
                                return;
                            }
                            return;
                        }
                        Ob.a aVar4 = new Ob.a();
                        aVar4.f2976b = null;
                        aVar4.f2977c = requestLevel;
                        Ob obA2 = aVar4.a();
                        Fb.a(obA2, strA2.getBytes("UTF-8"));
                        ec.this.a(obA2);
                        ec.this.a(obA2, 0, 3101);
                    } catch (Throwable unused3) {
                    }
                }
            }
        }

        private void a(int i) {
            if (ec.this.z != null) {
                if (ec.this.O == 0) {
                    ec ecVar = ec.this;
                    ecVar.a(ecVar.K, ec.this.O, 3103);
                } else {
                    ec.this.a(Ob.f2969a, i, 3103);
                }
                ec.x(ec.this);
                if (ec.this.Q == b.f3164c) {
                    ec.this.b();
                }
            }
        }
    }

    private void e() {
        a aVar = this.f3154d;
        if (aVar == null) {
            this.f3154d = new a(C0423eb.f().getLooper());
        } else {
            aVar.a();
        }
        boolean zF = f();
        boolean z = b.f3163b == this.Q;
        a aVar2 = this.f3154d;
        this.p.a(aVar2, z);
        if (this.j) {
            if (zF) {
                if (this.i != null) {
                    if (aVar2 != null) {
                        this.i.a(aVar2, z);
                    }
                }
            }
        } else if (zF) {
            if (this.h != null) {
                if (aVar2 != null) {
                    this.h.a();
                }
            }
        }
        if (zF) {
            if (this.l != null) {
                if (aVar2 != null) {
                    eh ehVar = this.l;
                    ehVar.o = this.x.m;
                    ehVar.a(aVar2, this.f3155e, z);
                }
            }
        }
        if ((this.k != null) && this.J.isAllowGPS()) {
            if (aVar2 != null) {
                this.k.m = this.f3153c == 1;
                this.k.a(aVar2, z);
            }
        }
        if (z) {
            this.p.a(this.w.g());
        } else {
            if (!Ha.a().d("collect_bles")) {
                this.n = null;
            }
            if (this.n != null) {
                if (aVar2 != null) {
                    this.n.a(aVar2);
                }
            }
            if (aVar2 != null) {
                this.o.a(aVar2);
            }
            if ((this.m != null) && this.J.isAllowDirection()) {
                if (aVar2 != null) {
                    this.m.a(aVar2);
                }
            }
        }
        if (aVar2 != null) {
            int iB = Ha.a().b("f_coll_item");
            if ((iB == 1 || iB == 2) && this.T == null) {
                this.T = new C0458qa(this.w.f3147c);
            }
            if (this.T == null || aVar2 == null) {
                return;
            }
            if (iB == 2 || (iB == 1 && !z)) {
                this.T.a(g());
                this.T.a("D_UP_NET", Ha.a().e("f_coll_up_net"));
                this.T.a(aVar2.getLooper());
            }
        }
    }

    private boolean f() {
        return this.J.getExtras().getBoolean("use_network", true);
    }

    private Da g() {
        try {
            Ya ya = this.w.f3148d;
            return new Da(ya.l, ya.d(), ya.f());
        } catch (Throwable unused) {
            return new Da("unknown", "unknown", "unknown");
        }
    }

    private void h() {
        if (!Ha.a().d("start_daemon")) {
            this.Q = b.f3165d;
            return;
        }
        if (this.Q == b.f3162a && Xb.c(this.w).equalsIgnoreCase("{}")) {
            try {
                new Handler(C0423eb.f().getLooper()).postDelayed(new RunnableC0459qb(this), 5000L);
                this.P = System.currentTimeMillis();
            } catch (Throwable unused) {
            }
        }
        this.Q = b.f3165d;
    }

    private void i() {
        Pb.f2988a = false;
        if (this.o != null) {
            this.o.a();
        }
        if (this.p != null) {
            this.p.a();
        }
        if (this.r != null) {
            this.r.a();
        }
        if (this.l != null) {
            this.l.a();
        }
        if (this.j) {
            if (this.i != null) {
                this.i.a();
            }
        } else {
            if (this.h != null) {
                this.h.b();
            }
        }
        if (this.k != null) {
            this.k.b();
        }
        if ((this.m != null) && this.J.isAllowDirection()) {
            this.m.a();
        }
        if (this.n != null) {
            this.n.a();
        }
        if (this.S) {
            Ga.a().c();
            this.S = false;
        }
        C0458qa c0458qa = this.T;
        if (c0458qa != null) {
            c0458qa.a();
        }
    }

    private void j() {
        AbstractC0426fb abstractC0426fbA;
        this.D = 0;
        this.t = null;
        this.s = null;
        this.v = null;
        this.N = null;
        this.H = 0L;
        Bb.f2878a = 0;
        this.U = false;
        if (Build.VERSION.SDK_INT >= 12 && (abstractC0426fbA = this.w.a(TencentLocationListener.CELL)) != null) {
            abstractC0426fbA.a();
        }
        Ya ya = this.x;
        if (ya != null) {
            ya.q = "";
            ya.p = 0L;
            ya.o = 0L;
            ya.n = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k() {
        return this.O == 404;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l() {
        C0453ob c0453ob = this.k;
        if (c0453ob == null || !c0453ob.c()) {
            return false;
        }
        return ((System.currentTimeMillis() - this.k.f3330e) > 20000L ? 1 : ((System.currentTimeMillis() - this.k.f3330e) == 20000L ? 0 : -1)) < 0;
    }

    private eh n() {
        if (this.w.c()) {
            return new eh(this.w);
        }
        return null;
    }

    static /* synthetic */ Bb m(ec ecVar) {
        Db db = ecVar.t;
        ek ekVarA = ecVar.s;
        el elVar = ecVar.v;
        if (elVar != null && !ecVar.l()) {
            elVar = null;
        }
        if (ekVarA == null) {
            C0423eb c0423eb = ecVar.w;
            ekVarA = ek.a(c0423eb, Pb.a(c0423eb), null);
            if (!Pb.a(ekVarA)) {
                ekVarA = null;
            }
        }
        if (db != null) {
            if (!(System.currentTimeMillis() - db.f2899c < 60000)) {
                db = null;
            }
        }
        if (ekVarA != null && elVar != null && Build.VERSION.SDK_INT >= 12) {
            int i = ekVarA.f3179d;
            int i2 = ekVarA.f3180e;
            Location location = elVar.f3187a;
            Bundle bundle = new Bundle();
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append(i2);
            bundle.putString("cellkey", sb.toString());
            bundle.putParcelable("location", location);
            AbstractC0426fb abstractC0426fbA = ecVar.w.a(TencentLocationListener.CELL);
            if (abstractC0426fbA != null && !abstractC0426fbA.a(bundle)) {
                ekVarA = null;
            }
        }
        C0438jb c0438jb = ecVar.n;
        return new Bb(db, ekVarA, elVar, c0438jb != null ? c0438jb.b() : null);
    }

    private void b(Looper looper) {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        if ((this.f3155e == null) || this.f3155e.getLooper() != looper) {
            this.f3155e = new c(looper);
        }
        this.f3155e.removeCallbacksAndMessages(null);
        Handler handler = this.f3156f;
        if (handler == null || handler.getLooper() != Looper.getMainLooper()) {
            this.f3156f = new Handler(Looper.getMainLooper());
        }
    }

    public final int a(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener, Looper looper) {
        if (this.q != 0) {
            return this.q;
        }
        j();
        this.O = 404;
        this.K = null;
        synchronized (this.I) {
            this.y = tencentLocationListener;
        }
        TencentLocationRequest.copy(this.J, tencentLocationRequest);
        if (this.J.isIndoorLocationMode()) {
            this.D = 1;
        }
        Ya ya = this.x;
        if (ya != null) {
            ya.n = System.currentTimeMillis();
            if ("0123456789ABCDEF".equals(this.x.a())) {
                this.w.a();
            }
            this.x.g = tencentLocationRequest.getQQ();
            this.x.h = tencentLocationRequest.getSmallAppKey();
            if (TextUtils.isEmpty(C0458qa.a(this.x.f3061e))) {
                this.x.f3061e = tencentLocationRequest.getPhoneNumber();
            }
            Ya ya2 = this.x;
            long interval = tencentLocationRequest.getInterval();
            boolean zIsIndoorLocationMode = this.J.isIndoorLocationMode();
            ya2.m = Math.max(Ha.a().c("min_wifi_scan_interval"), interval);
            if (zIsIndoorLocationMode) {
                ya2.m = 5000L;
            }
        }
        this.C = tencentLocationRequest.getInterval();
        this.Q = b.f3162a;
        a(looper);
        return 0;
    }

    public final void b() {
        synchronized (this.V) {
            i();
            try {
                if (this.f3154d != null) {
                    this.f3154d.a();
                    this.f3154d = null;
                }
            } catch (Throwable unused) {
            }
        }
        synchronized (this.I) {
            this.y = null;
            if (this.z != null) {
                this.z.clear();
            }
        }
        j();
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Looper looper) {
        synchronized (this.V) {
            b(looper);
            i();
            e();
        }
    }

    public final TencentLocation a() {
        if (this.O != 0) {
            return null;
        }
        a(this.K);
        return this.K;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Ob ob) {
        if (ob != null) {
            if (this.m != null && this.J.isAllowDirection()) {
                ob.getExtra().putDouble(TencentLocation.EXTRA_DIRECTION, this.m.b());
            }
            try {
                ob.getExtra().putAll(this.J.getExtras());
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Ob ob) {
        if (ob == null) {
            return;
        }
        if (i == 0 && ob.getLatitude() != 0.0d && ob.getLongitude() != 0.0d) {
            Ob.a(ob, (this.f3153c == 1 && Qb.a(ob.getLatitude(), ob.getLongitude())) ? 1 : 0);
        }
        if (k()) {
            if (ob.getAccuracy() < 5000.0f && ob.getAccuracy() > WheelView.DividerConfig.FILL) {
                this.r.a((TencentLocation) ob);
                boolean z = this.B;
            }
            this.L = ob.getLatitude();
            this.M = ob.getLongitude();
            if ((this.y != null) && this.J.getInterval() > 0) {
                a(11999, this.J.getInterval());
            }
        } else if (i == 0 && ob.getLatitude() != 0.0d && ob.getLongitude() != 0.0d && Math.abs(ob.getLatitude() - this.L) >= 1.0E-8d && Math.abs(ob.getLongitude() - this.M) >= 1.0E-8d) {
            if (!this.r.a(C0473vb.a.a(ob), this.w, this.k.c())) {
                return;
            }
            this.L = ob.getLatitude();
            this.M = ob.getLongitude();
            if (ob.getAccuracy() < 5000.0f && ob.getAccuracy() > WheelView.DividerConfig.FILL) {
                this.r.a(ob);
                this.r.a((TencentLocation) ob);
                boolean z2 = this.B;
            }
        }
        boolean z3 = this.O != 0 && i == 0;
        this.O = i;
        this.K = ob;
        if (this.J.getInterval() == 0) {
            if (this.y != null) {
                a(11998);
                return;
            }
        }
        if (z3) {
            if (this.y != null) {
                a(11998);
            }
        }
    }

    public final void a(int i) {
        a aVar = this.f3154d;
        if (aVar != null) {
            aVar.sendEmptyMessage(i);
        }
    }

    private void a(int i, long j) {
        a aVar = this.f3154d;
        if (aVar != null) {
            aVar.removeMessages(i);
            this.f3154d.sendEmptyMessageDelayed(i, j);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r9, int r10) {
        /*
            r8 = this;
            java.lang.String r0 = "location permission denied"
            r1 = 2
            java.lang.String r2 = "gps"
            r3 = 0
            r4 = 1
            java.lang.String r5 = "unknown"
            java.lang.String r6 = "wifi"
            java.lang.String r7 = "cell"
            switch(r9) {
                case 12001: goto L42;
                case 12002: goto L36;
                case 12003: goto L21;
                case 12004: goto L14;
                default: goto L10;
            }
        L10:
            r0 = r3
            r2 = r0
            goto L5d
        L14:
            r9 = 3
            if (r10 == r9) goto L1e
            r9 = 4
            if (r10 == r9) goto L1b
            goto L3a
        L1b:
            java.lang.String r0 = "gps unavailable"
            goto L5d
        L1e:
            java.lang.String r0 = "gps available"
            goto L5d
        L21:
            if (r10 != r4) goto L26
            java.lang.String r9 = "cell enabled"
            goto L2c
        L26:
            if (r10 != 0) goto L2b
            java.lang.String r9 = "cell disabled"
            goto L2c
        L2b:
            r9 = r5
        L2c:
            boolean r2 = c.t.m.g.Pb.f2988a
            if (r2 == 0) goto L33
            r2 = r7
        L31:
            r10 = 2
            goto L5d
        L33:
            r0 = r9
            r2 = r7
            goto L5d
        L36:
            if (r10 == 0) goto L3f
            if (r10 == r4) goto L3c
        L3a:
            r0 = r5
            goto L5d
        L3c:
            java.lang.String r0 = "gps enabled"
            goto L5d
        L3f:
            java.lang.String r0 = "gps disabled"
            goto L5d
        L42:
            r9 = 5
            if (r10 == 0) goto L51
            if (r10 == r4) goto L4e
            if (r10 == r9) goto L4b
            r2 = r5
            goto L53
        L4b:
            java.lang.String r2 = "location service switch is off"
            goto L53
        L4e:
            java.lang.String r2 = "wifi enabled"
            goto L53
        L51:
            java.lang.String r2 = "wifi disabled"
        L53:
            if (r10 == r9) goto L5b
            boolean r9 = c.t.m.g.Xb.f3053a
            if (r9 == 0) goto L5b
            r2 = r6
            goto L31
        L5b:
            r0 = r2
            r2 = r6
        L5d:
            c.t.m.g.ec$c r9 = r8.f3155e
            if (r9 == 0) goto L8a
            r1 = 3102(0xc1e, float:4.347E-42)
            android.os.Message r9 = r9.obtainMessage(r1)
            android.os.Bundle r1 = r9.getData()
            if (r1 != 0) goto L72
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
        L72:
            r1.clear()
            java.lang.String r3 = "name"
            r1.putString(r3, r2)
            java.lang.String r2 = "status"
            r1.putInt(r2, r10)
            java.lang.String r10 = "desc"
            r1.putString(r10, r0)
            r9.setData(r1)
            r9.sendToTarget()
        L8a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.ec.a(int, int):void");
    }

    public final void a(Ob ob, int i, int i2) {
        c cVar;
        if (ob == null || (cVar = this.f3155e) == null) {
            return;
        }
        Message messageObtainMessage = cVar.obtainMessage(i2);
        Bundle data = messageObtainMessage.getData();
        if (data == null) {
            data = new Bundle();
        }
        data.clear();
        data.putInt(NativeProtocol.BRIDGE_ARG_ERROR_CODE, i);
        data.putParcelable("tx_location", ob);
        messageObtainMessage.setData(data);
        messageObtainMessage.sendToTarget();
    }

    private static String a(String str) {
        try {
            if (str.contains(",")) {
                String[] strArrSplit = str.split(",");
                boolean z = true;
                if (strArrSplit == null || strArrSplit.length <= 1 || strArrSplit[0] == null || strArrSplit[1] == null || com.tencent.tencentmap.lbssdk.service.e.w(strArrSplit[0], strArrSplit[1]) <= 0) {
                    z = false;
                }
                return z ? strArrSplit[0] : "";
            }
            int iV = com.tencent.tencentmap.lbssdk.service.e.v(str);
            return iV >= 0 ? Integer.toString(iV) : "";
        } catch (UnsatisfiedLinkError unused) {
            return null;
        }
    }
}
