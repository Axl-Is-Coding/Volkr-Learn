package com.tendcloud.tenddata;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import com.tencent.map.geolocation.TencentLocationListener;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public final class bm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static Handler f19863a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static HandlerThread f19864b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f19865c = "check_wifi_permission";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f19866d = "check_bs_permission";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f19867e = "check_gps_permission";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f19868f = 1;
    private static final int g = 2;
    private static final int h = 3;
    private static final int i = 4;
    private static final long j = 600000;
    private static volatile bm k;
    private static WifiManager l;

    static {
        try {
            ag.a().register(a());
        } catch (Throwable unused) {
        }
    }

    private bm() {
        try {
            f19864b = new HandlerThread("locHandlerThread", 10);
            f19864b.start();
            f19863a = new Handler(f19864b.getLooper()) { // from class: com.tendcloud.tenddata.bm.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    int i2 = message.what;
                    if (i2 == 1) {
                        bm.this.b();
                        return;
                    }
                    if (i2 == 2) {
                        bm.this.c();
                        return;
                    }
                    if (i2 == 3) {
                        bm.this.d();
                    } else {
                        if (i2 != 4) {
                            return;
                        }
                        bm.this.d();
                        bm.this.b();
                        bm.this.a(2, bm.j);
                    }
                }
            };
            a(4, 0L);
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(23)
    public void d() {
        try {
            if (!a(f19866d)) {
                a(3, 180000L);
                return;
            }
            if (ab.g != null) {
                try {
                    Context context = ab.g;
                    Context context2 = ab.g;
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager.getSimState() == 5) {
                        telephonyManager.getCellLocation();
                        telephonyManager.listen(new bs(), 16);
                        CellLocation.requestLocationUpdate();
                    }
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    public final void onTDEBEventLocationEvent(bu buVar) {
    }

    public static bm a() {
        if (k == null) {
            synchronized (bm.class) {
                if (k == null) {
                    k = new bm();
                }
            }
        }
        return k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            if (!a(f19865c)) {
                a(1, 180000L);
                return;
            }
            Context context = ab.g;
            Context context2 = ab.g;
            l = (WifiManager) context.getSystemService(TencentLocationListener.WIFI);
            if (l.isWifiEnabled()) {
                ab.g.registerReceiver(new bt(l), new IntentFilter("android.net.wifi.SCAN_RESULTS"));
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (!a(f19867e)) {
            a(2, j);
            return;
        }
        try {
            bx bxVar = new bx();
            bxVar.f19906b = "env";
            bxVar.f19907c = "locationUpdate";
            bxVar.f19905a = a.ENV;
            ag.a().post(bxVar);
            a(2, j);
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    protected void a(int i2, long j2) {
        try {
            Message messageObtain = Message.obtain();
            messageObtain.what = i2;
            f19863a.sendMessageDelayed(messageObtain, j2);
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    protected boolean a(String str) {
        try {
            boolean zB = af.b(ab.g, "android.permission.READ_PHONE_STATE");
            boolean z = af.b(ab.g, "android.permission.ACCESS_COARSE_LOCATION") || af.b(ab.g, "android.permission.ACCESS_FINE_LOCATION");
            boolean zB2 = af.b(ab.g, "android.permission.ACCESS_WIFI_STATE");
            byte b2 = -1;
            int iHashCode = str.hashCode();
            if (iHashCode != -1215157370) {
                if (iHashCode != 1219872770) {
                    if (iHashCode == 1355887771 && str.equals(f19867e)) {
                        b2 = 1;
                    }
                } else if (str.equals(f19865c)) {
                    b2 = 2;
                }
            } else if (str.equals(f19866d)) {
                b2 = 0;
            }
            if (b2 == 0) {
                return z && zB;
            }
            if (b2 == 1) {
                return z;
            }
            if (b2 != 2) {
                return false;
            }
            return af.a(23) ? zB2 && z : zB2;
        } catch (Throwable unused) {
            return false;
        }
    }
}
