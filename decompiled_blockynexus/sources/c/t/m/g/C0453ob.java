package c.t.m.g;

import android.annotation.SuppressLint;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import c.t.m.g.el;
import cn.qqtheme.framework.widget.WheelView;
import com.tencent.map.geolocation.TencentLocation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: renamed from: c.t.m.g.ob, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
final class C0453ob implements GpsStatus.Listener, LocationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C0423eb f3326a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile GpsStatus f3328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile Location f3329d;
    private volatile boolean l;
    boolean m;
    private a p;
    private LocationManager q;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile int f3327b = 1024;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    volatile long f3330e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f3331f = false;
    private boolean g = false;
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private ArrayList<Float> k = new ArrayList<>();
    private long o = -1;
    private final double[] r = new double[2];
    private C0435ib n = C0435ib.a();

    /* JADX INFO: renamed from: c.t.m.g.ob$a */
    /* JADX INFO: compiled from: TL */
    class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message == null) {
            }
            try {
                removeMessages(message.what);
                boolean z = false;
                switch (message.what) {
                    case 1101:
                        Location location = C0453ob.this.f3329d;
                        if (location != null && C0453ob.b(location)) {
                            C0453ob c0453ob = C0453ob.this;
                            C0423eb unused = C0453ob.this.f3326a;
                            if (!c0453ob.c(location)) {
                                C0453ob.b(C0453ob.this, location);
                                C0453ob.c(C0453ob.this);
                                C0453ob.this.f3327b |= 2;
                                if (C0453ob.this.o == -1 || C0453ob.this.o == 0) {
                                    C0453ob.a(C0453ob.this, true);
                                    C0453ob.this.o = System.currentTimeMillis();
                                }
                            }
                            break;
                        }
                        break;
                    case 1102:
                        C0453ob.c(C0453ob.this);
                        C0453ob.f(C0453ob.this);
                        if (C0453ob.this.f3328c != null && C0453ob.this.k != null && C0453ob.this.k.size() > 0) {
                            try {
                                C0435ib c0435ib = C0453ob.this.n;
                                ArrayList arrayList = C0453ob.this.k;
                                int unused2 = C0453ob.this.h;
                                if (arrayList.size() >= 5) {
                                    float[] fArr = new float[arrayList.size()];
                                    int i = 0;
                                    while (true) {
                                        int length = fArr.length;
                                        float fFloatValue = WheelView.DividerConfig.FILL;
                                        if (i < length) {
                                            Float f2 = (Float) arrayList.get(i);
                                            if (f2 != null) {
                                                fFloatValue = f2.floatValue();
                                            }
                                            fArr[i] = fFloatValue;
                                            i++;
                                        } else {
                                            Arrays.sort(fArr);
                                            float[] fArr2 = new float[5];
                                            for (int i2 = 0; i2 < 5; i2++) {
                                                fArr2[i2] = fArr[(fArr.length - 1) - i2];
                                                fFloatValue += fArr2[i2];
                                            }
                                            float f3 = fFloatValue / 5.0f;
                                            if (fArr2[0] > 35.0f || f3 > 30.0f) {
                                                c0435ib.f3243e = true;
                                            }
                                            if (f3 < 22.0f) {
                                                c0435ib.f3243e = false;
                                            }
                                            if (c0435ib.f3241c < f3) {
                                                c0435ib.f3241c = f3;
                                            }
                                            if (c0435ib.f3242d > f3) {
                                                c0435ib.f3242d = f3;
                                            }
                                            c0435ib.f3240b = f3;
                                            if (c0435ib.f3240b - f3 > 2.0f) {
                                                c0435ib.f3244f = false;
                                            }
                                            if (f3 > (c0435ib.f3241c + c0435ib.f3242d) / 2.0f) {
                                                c0435ib.f3244f = true;
                                            } else if (f3 < 22.0f) {
                                                c0435ib.f3244f = false;
                                            }
                                        }
                                    }
                                }
                                z = c0435ib.f3244f;
                                break;
                            } catch (Throwable unused3) {
                            }
                        }
                        if (z) {
                            if (C0453ob.this.o == -1 || C0453ob.this.o == 0) {
                                C0453ob.a(C0453ob.this, z);
                            }
                            C0453ob.this.o = System.currentTimeMillis();
                        } else if (C0453ob.this.o == -1 || (System.currentTimeMillis() - C0453ob.this.o > 40000 && C0453ob.this.o != 0)) {
                            C0453ob.a(C0453ob.this, z);
                            C0453ob.this.o = 0L;
                        }
                        break;
                    case 1103:
                        C0453ob.this.f3327b = 4;
                        C0453ob.this.d();
                        break;
                    case 1104:
                        C0453ob.this.h = C0453ob.l(C0453ob.this);
                        C0453ob.this.f3327b = 0;
                        C0453ob.m(C0453ob.this);
                        C0453ob.this.d();
                        break;
                }
            } catch (Throwable unused4) {
            }
        }
    }

    public C0453ob(C0423eb c0423eb) {
        this.f3326a = c0423eb;
        this.q = this.f3326a.j;
    }

    static /* synthetic */ boolean f(C0453ob c0453ob) {
        int i = c0453ob.h;
        int i2 = c0453ob.i;
        if (i > 0) {
            c0453ob.g = true;
        }
        if (i2 > 0) {
            c0453ob.f3331f = true;
        }
        if (!c0453ob.g || i > 2) {
            return c0453ob.f3331f ? i2 >= 3 || i2 == 0 : i2 == 0;
        }
        return false;
    }

    static /* synthetic */ int l(C0453ob c0453ob) {
        c0453ob.i = 0;
        return 0;
    }

    static /* synthetic */ boolean m(C0453ob c0453ob) {
        c0453ob.f3331f = false;
        return false;
    }

    public final boolean c() {
        try {
            return this.f3326a.j.isProviderEnabled("gps");
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // android.location.GpsStatus.Listener
    @SuppressLint({"MissingPermission"})
    public final void onGpsStatusChanged(int i) {
        if (i == 1) {
            this.f3327b |= 1;
            return;
        }
        if (i == 2) {
            this.f3327b = 0;
            return;
        }
        if (i == 3) {
            this.f3327b |= 2;
            return;
        }
        if (i != 4) {
            return;
        }
        LocationManager locationManager = this.f3326a.j;
        try {
            if (this.f3328c == null) {
                this.f3328c = locationManager.getGpsStatus(null);
            } else {
                locationManager.getGpsStatus(this.f3328c);
            }
        } catch (Throwable unused) {
        }
        a(1102);
    }

    @Override // android.location.LocationListener
    public final void onLocationChanged(Location location) {
        if (location == null) {
            return;
        }
        try {
            if ("gps".equals(location.getProvider())) {
                this.f3329d = location;
                a(1101);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.location.LocationListener
    public final void onProviderDisabled(String str) {
        if ("gps".equals(str)) {
            a(1104);
        }
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String str) {
        if ("gps".equals(str)) {
            a(1103);
        }
    }

    @Override // android.location.LocationListener
    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int i = this.f3327b == 4 ? 1 : this.f3327b == 0 ? 0 : -1;
        Message message = new Message();
        message.what = 12999;
        message.arg1 = 12002;
        message.arg2 = i;
        this.f3326a.b(message);
    }

    public final void b() {
        if (this.l) {
            this.l = false;
            this.f3327b = 1024;
            this.f3331f = false;
            this.g = false;
            this.j = 0;
            this.i = 0;
            this.h = 0;
            this.k.clear();
            this.o = -1L;
            this.m = false;
            Arrays.fill(this.r, 0.0d);
            LocationManager locationManager = this.f3326a.j;
            try {
                locationManager.removeGpsStatusListener(this);
            } catch (Exception unused) {
            }
            try {
                locationManager.removeUpdates(this);
            } catch (Exception unused2) {
            }
            this.p = null;
            this.f3329d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public boolean c(Location location) {
        if (!Fb.f2904a) {
            return false;
        }
        try {
            if (!this.f3326a.j.isProviderEnabled("gps")) {
                return true;
            }
            if (Build.VERSION.SDK_INT >= 18) {
                if (location.isFromMockProvider()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:24:0x004b
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    @android.annotation.SuppressLint({"MissingPermission"})
    public final void a(android.os.Handler r11, boolean r12) {
        /*
            r10 = this;
            boolean r0 = r10.l
            if (r0 == 0) goto L5
            return
        L5:
            r0 = 1
            r10.l = r0
            r1 = 0
            r10.f3330e = r1
            r1 = 0
            if (r11 != 0) goto L11
            r11 = r1
            goto L15
        L11:
            android.os.Looper r11 = r11.getLooper()
        L15:
            c.t.m.g.ob$a r2 = r10.p
            if (r2 == 0) goto L1f
            android.os.Looper r2 = r2.getLooper()
            if (r2 == r11) goto L28
        L1f:
            if (r11 == 0) goto L28
            c.t.m.g.ob$a r2 = new c.t.m.g.ob$a
            r2.<init>(r11)
            r10.p = r2
        L28:
            if (r12 != 0) goto L4d
            android.location.LocationManager r3 = r10.q     // Catch: java.lang.Throwable -> L43
            java.lang.String r4 = "gps"
            r5 = 1000(0x3e8, double:4.94E-321)
            r7 = 0
            c.t.m.g.ob$a r11 = r10.p     // Catch: java.lang.Throwable -> L43
            if (r11 != 0) goto L37
        L35:
            r9 = r1
            goto L3e
        L37:
            c.t.m.g.ob$a r11 = r10.p     // Catch: java.lang.Throwable -> L43
            android.os.Looper r1 = r11.getLooper()     // Catch: java.lang.Throwable -> L43
            goto L35
        L3e:
            r8 = r10
            r3.requestLocationUpdates(r4, r5, r7, r8, r9)     // Catch: java.lang.Throwable -> L43
            goto L45
        L43:
            c.t.m.g.Pb.f2988a = r0
        L45:
            android.location.LocationManager r11 = r10.q     // Catch: java.lang.Throwable -> L4b
            r11.addGpsStatusListener(r10)     // Catch: java.lang.Throwable -> L4b
            goto L59
        L4b:
            goto L59
        L4d:
            android.location.LocationManager r0 = r10.q     // Catch: java.lang.Throwable -> L4b
            java.lang.String r1 = "passive"
            r2 = 2000(0x7d0, double:9.88E-321)
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = r10
            r0.requestLocationUpdates(r1, r2, r4, r5)     // Catch: java.lang.Throwable -> L4b
        L59:
            boolean r11 = r10.c()
            if (r11 == 0) goto L65
            r11 = 4
            r10.f3327b = r11
            r10.d()
        L65:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.C0453ob.a(android.os.Handler, boolean):void");
    }

    static /* synthetic */ void c(C0453ob c0453ob) {
        try {
            c0453ob.j = 0;
            c0453ob.i = 0;
            c0453ob.h = 0;
            GpsStatus gpsStatus = c0453ob.f3328c;
            if (gpsStatus == null) {
                return;
            }
            c0453ob.k.clear();
            c0453ob.j = gpsStatus.getMaxSatellites();
            Iterator<GpsSatellite> it = gpsStatus.getSatellites().iterator();
            if (it == null) {
                return;
            }
            while (it.hasNext() && c0453ob.h <= c0453ob.j) {
                GpsSatellite next = it.next();
                c0453ob.h++;
                c0453ob.k.add(Float.valueOf(next.getSnr()));
                if (next.usedInFix()) {
                    c0453ob.i++;
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Location location) {
        try {
            if (location.getAccuracy() > 10000.0f) {
                return false;
            }
            if ((!a(location.getLatitude()) || !a(location.getLongitude())) && Math.abs(location.getLatitude()) >= 1.0E-8d && Math.abs(location.getLongitude()) >= 1.0E-8d && Math.abs(location.getLatitude() - 1.0d) >= 1.0E-8d && Math.abs(location.getLongitude() - 1.0d) >= 1.0E-8d && location.getLatitude() >= -90.0d && location.getLatitude() <= 90.0d && location.getLongitude() >= -180.0d) {
                if (location.getLongitude() <= 180.0d) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    @SuppressLint({"MissingPermission"})
    public final Location a() {
        Location lastKnownLocation;
        try {
            lastKnownLocation = this.f3326a.j.getLastKnownLocation(TencentLocation.NETWORK_PROVIDER);
        } catch (Throwable unused) {
            lastKnownLocation = null;
        }
        if (lastKnownLocation == null) {
            return C0444lb.f3290a;
        }
        if (this.m && Qb.a(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude())) {
            Vb.a(lastKnownLocation, this.r);
            double[] dArr = this.r;
            a(lastKnownLocation, dArr[0], dArr[1], 0);
        } else {
            a(lastKnownLocation, lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude(), 0);
        }
        return lastKnownLocation;
    }

    static /* synthetic */ void b(C0453ob c0453ob, Location location) {
        int i;
        int i2 = c0453ob.i;
        if (i2 < 4 || i2 > 6) {
            i = c0453ob.i >= 7 ? 3 : 1;
        } else {
            i = 2;
        }
        if (c0453ob.m && Qb.a(location.getLatitude(), location.getLongitude())) {
            Vb.a(location, c0453ob.r);
            double[] dArr = c0453ob.r;
            a(location, dArr[0], dArr[1], i);
        } else {
            a(location, location.getLatitude(), location.getLongitude(), i);
        }
        c0453ob.f3330e = System.currentTimeMillis();
        c0453ob.f3326a.b(new el(location, c0453ob.f3330e, c0453ob.h, c0453ob.i, c0453ob.f3327b, el.a.f3193a));
    }

    private static boolean a(double d2) {
        double dLongValue = Double.valueOf(d2).longValue();
        Double.isNaN(dLongValue);
        return Math.abs(dLongValue - d2) < Double.MIN_VALUE;
    }

    private void a(int i) {
        a aVar = this.p;
        if (aVar != null) {
            aVar.obtainMessage(i).sendToTarget();
        }
    }

    private static void a(Location location, double d2, double d3, int i) {
        Bundle extras = location.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putDouble(com.umeng.analytics.pro.b.B, d2);
        extras.putDouble(com.umeng.analytics.pro.b.C, d3);
        extras.putInt("rssi", i);
        location.setExtras(extras);
    }

    static /* synthetic */ void a(C0453ob c0453ob, boolean z) {
        int i = z ? 3 : 4;
        Message message = new Message();
        message.what = 12999;
        message.arg1 = 12004;
        message.arg2 = i;
        c0453ob.f3326a.b(message);
    }
}
