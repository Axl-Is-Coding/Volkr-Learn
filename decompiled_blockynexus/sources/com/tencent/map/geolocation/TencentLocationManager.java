package com.tencent.map.geolocation;

import android.content.Context;
import android.os.Looper;
import c.t.m.g.C0423eb;
import c.t.m.g.C0458qa;
import c.t.m.g.Ya;
import c.t.m.g.ec;
import com.tendcloud.tenddata.ab;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes5.dex */
public final class TencentLocationManager {
    public static final int COORDINATE_TYPE_GCJ02 = 1;
    public static final int COORDINATE_TYPE_WGS84 = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static TencentLocationManager f19398d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f19399a = new byte[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C0423eb f19400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ec f19401c;

    private TencentLocationManager(Context context) {
        C0458qa.a(context);
        this.f19400b = C0423eb.a(context);
        this.f19401c = new ec(this.f19400b);
    }

    public static synchronized TencentLocationManager getInstance(Context context) throws IllegalArgumentException, NullPointerException {
        if (f19398d == null) {
            if (context == null) {
                throw new NullPointerException("context is null");
            }
            if (context.getApplicationContext() == null) {
                throw new NullPointerException("application context is null");
            }
            f19398d = new TencentLocationManager(context.getApplicationContext());
        }
        return f19398d;
    }

    public final String getBuild() {
        Ya yaE = this.f19400b.e();
        return yaE != null ? yaE.e() : "None";
    }

    public final int getCoordinateType() {
        return this.f19401c.f3153c;
    }

    public final TencentLocation getLastKnownLocation() {
        return this.f19401c.a();
    }

    public final String getVersion() {
        Ya yaE = this.f19400b.e();
        return yaE != null ? yaE.d() : "None";
    }

    public final void removeUpdates(TencentLocationListener tencentLocationListener) {
        synchronized (this.f19399a) {
            this.f19401c.b();
        }
    }

    public final int requestLocationUpdates(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener) {
        return requestLocationUpdates(tencentLocationRequest, tencentLocationListener, Looper.myLooper());
    }

    public final int requestSingleFreshLocation(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener, Looper looper) {
        int iA;
        if (tencentLocationListener == null) {
            throw new NullPointerException("listener is null");
        }
        if (looper == null) {
            throw new NullPointerException("looper is null");
        }
        synchronized (this.f19399a) {
            ec ecVar = this.f19401c;
            iA = 0;
            if (ecVar.q != 0) {
                iA = ecVar.q;
            } else {
                if (tencentLocationListener != null && ecVar.z != null) {
                    ecVar.z.add(tencentLocationListener);
                }
                if (System.currentTimeMillis() - ecVar.A >= 2000) {
                    ecVar.A = System.currentTimeMillis();
                    if (ecVar.z != null && ecVar.O == 0 && ecVar.K != null && ((ecVar.K.getProvider().equals("gps") && System.currentTimeMillis() - ecVar.K.getTime() <= 90000) || (ecVar.K.getProvider().equals(TencentLocation.NETWORK_PROVIDER) && System.currentTimeMillis() - ecVar.K.getTime() <= ab.R))) {
                        ecVar.a(ecVar.K, ecVar.O, 3103);
                        ecVar.A = 0L;
                    } else if (ecVar.Q == ec.b.f3162a) {
                        ecVar.a(3997);
                    } else {
                        TencentLocationRequest interval = TencentLocationRequest.create().setInterval(0L);
                        if (tencentLocationRequest != null) {
                            interval.setSmallAppKey(tencentLocationRequest.getSmallAppKey());
                        }
                        iA = ecVar.a(interval, ec.f3152b, looper);
                        ecVar.Q = ec.b.f3164c;
                    }
                }
            }
        }
        return iA;
    }

    public final void setCoordinateType(int i) {
        boolean z = true;
        if (i != 1 && i != 0) {
            throw new IllegalArgumentException("unknown coordinate type: ".concat(String.valueOf(i)));
        }
        synchronized (this.f19399a) {
            ec ecVar = this.f19401c;
            if (ecVar.f3153c != i) {
                synchronized (ecVar.I) {
                    if (ecVar.y == null) {
                        z = false;
                    }
                    if (z) {
                        throw new IllegalStateException("removeUpdates MUST called before set coordinate type!");
                    }
                }
                ecVar.f3153c = i;
            }
        }
    }

    @Deprecated
    public final boolean startIndoorLocation() {
        this.f19401c.D = 1;
        return true;
    }

    @Deprecated
    public final boolean stopIndoorLocation() {
        ec ecVar = this.f19401c;
        if (ecVar.D > 0) {
            if (ecVar.l != null) {
                ecVar.l.o = ecVar.x.m;
            }
            if (Long.valueOf(ecVar.C) != null) {
                ecVar.C = ecVar.J.getInterval();
            }
            ecVar.D = 0;
        }
        return true;
    }

    public final int requestLocationUpdates(TencentLocationRequest tencentLocationRequest, TencentLocationListener tencentLocationListener, Looper looper) {
        int iA;
        if (tencentLocationRequest == null) {
            throw new NullPointerException("request is null");
        }
        if (tencentLocationListener == null) {
            throw new NullPointerException("listener is null");
        }
        if (looper == null) {
            throw new NullPointerException("looper is null");
        }
        synchronized (this.f19399a) {
            iA = this.f19401c.a(tencentLocationRequest, tencentLocationListener, looper);
        }
        return iA;
    }
}
