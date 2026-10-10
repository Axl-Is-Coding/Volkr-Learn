package c.t.m.g;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.format.DateFormat;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.map.geolocation.fence.TxGeofenceManagerState;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class du extends BroadcastReceiver implements PendingIntent.OnFinished, TencentLocationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ec f3128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PowerManager.WakeLock f3129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PowerManager.WakeLock f3130d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a f3131e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c f3132f;
    public final b g;
    public boolean h;
    public boolean i;
    private PendingIntent j;
    private final TencentLocationRequest k;
    private double l;

    /* JADX INFO: compiled from: TL */
    final class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                du.this.a(true);
            } else {
                if (i != 2) {
                    return;
                }
                du.e();
                du.this.f3127a.sendBroadcast(du.k());
            }
        }
    }

    /* JADX INFO: compiled from: TL */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<dn> f3134a = new LinkedList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f3135b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f3136c = 60000;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Location f3137d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f3138e = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float[] f3139f = {-1.0f, -1.0f};

        b() {
        }

        final void a() {
            this.f3134a.clear();
            this.f3135b = false;
            this.f3136c = 60000L;
            this.f3137d = null;
            this.f3138e = false;
        }
    }

    private du(Context context, Looper looper) {
        this.g = new b();
        this.h = false;
        this.i = false;
        this.k = TencentLocationRequest.create().setRequestLevel(0).setInterval(0L).setAllowCache(false);
        this.l = 1.0d;
        this.f3127a = context;
        this.f3128b = new ec(C0423eb.a(context));
        PowerManager powerManager = (PowerManager) this.f3127a.getSystemService("power");
        this.f3129c = powerManager.newWakeLock(1, "GeofenceManager");
        this.f3130d = powerManager.newWakeLock(1, "tencent_location");
        this.f3130d.setReferenceCounted(false);
        this.f3131e = new a(looper);
        this.f3132f = new c(this, (byte) 0);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("com.tencent.map.geolocation.wakeup");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.f3127a.registerReceiver(this, intentFilter, null, this.f3131e);
    }

    static /* synthetic */ void e() {
    }

    private void g() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<dn> it = this.g.f3134a.iterator();
        while (it.hasNext()) {
            if (it.next().f3120c < jElapsedRealtime) {
                it.remove();
            }
        }
    }

    private Location h() {
        b bVar = this.g;
        Location locationA = bVar.f3137d;
        List<dn> list = bVar.f3134a;
        if (locationA == null && !list.isEmpty()) {
            locationA = C0458qa.a(this.f3128b.a());
        }
        if (locationA != null && System.currentTimeMillis() - locationA.getTime() < 60000) {
            return locationA;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double i() {
        float f2;
        float f3;
        if (Xb.a(C0423eb.a(this.f3127a))) {
            f3 = 15.0f;
            f2 = 1.0f;
        } else {
            f2 = 3.0f;
            f3 = 25.0f;
        }
        float f4 = this.g.f3139f[0];
        if (f4 < f2) {
            if (!C0458qa.c(this.f3127a)) {
                return f3;
            }
            double d2 = f3;
            Double.isNaN(d2);
            return d2 * 0.3d;
        }
        double dMin = Math.min(Math.max(f2, f4), 10.0f + f3);
        Double.isNaN(dMin);
        double d3 = f3 + f2;
        Double.isNaN(d3);
        double d4 = (dMin * 0.8d) + (d3 * 0.1d);
        double d5 = f2;
        return d4 < d5 ? d5 : d4;
    }

    private PendingIntent j() {
        return PendingIntent.getBroadcast(this.f3127a, 0, k(), 134217728);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Intent k() {
        Intent intent = new Intent("com.tencent.map.geolocation.wakeup");
        intent.putExtra("com.tencent.map.geolocation.from_alarm", true);
        return intent;
    }

    public final void d() {
        b bVar = this.g;
        if (bVar.f3138e) {
            return;
        }
        bVar.f3138e = true;
        this.f3131e.sendEmptyMessage(1);
    }

    @Override // com.tencent.map.geolocation.TencentLocationListener
    public final void onLocationChanged(TencentLocation tencentLocation, int i, String str) {
        Location locationA = C0458qa.a(tencentLocation);
        CharSequence charSequence = DateFormat.format("yyyy-MM-dd kk:mm:ss", tencentLocation == null ? System.currentTimeMillis() : tencentLocation.getTime());
        StringBuilder sb = new StringBuilder();
        sb.append((Object) charSequence);
        sb.append(" error=");
        sb.append(i);
        sb.append(tencentLocation);
        sb.append(UMCustomLogInfoBuilder.LINE_SEP);
        this.f3128b.b();
        synchronized (this.g) {
            if (i == 0) {
                this.f3132f.add(i, tencentLocation);
                if (this.g.f3135b) {
                    this.g.f3137d = locationA;
                }
                if (this.g.f3138e) {
                    this.f3131e.removeMessages(1);
                } else {
                    this.g.f3138e = true;
                }
                a(false);
            } else {
                this.g.f3136c = 60000L;
                this.f3132f.add(i, tencentLocation);
            }
            if (this.g.f3135b) {
                new StringBuilder("onLocationChanged: set a new repeat alarm, interval=").append(this.g.f3136c);
                a(this.g.f3136c);
            }
        }
        if (this.f3130d.isHeld()) {
            this.f3130d.release();
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        synchronized (this.g) {
            boolean z = h() == null;
            if ("android.intent.action.SCREEN_ON".equals(action)) {
                if (z) {
                    a("onReceive: screen_on and no_fresh_location --> schedule update fence");
                }
            } else if ("com.tencent.map.geolocation.wakeup".equals(action)) {
                Context context2 = this.f3127a;
                if (AbstractC0432hb.f3226a != null && AbstractC0432hb.f3226a.isHeld()) {
                    AbstractC0432hb.f3226a.release();
                }
                PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) context2.getSystemService("power")).newWakeLock(1, "WakeLocker");
                AbstractC0432hb.f3226a = wakeLockNewWakeLock;
                wakeLockNewWakeLock.acquire(5000L);
                this.f3131e.removeMessages(2);
                d();
                if (AbstractC0432hb.f3226a != null && AbstractC0432hb.f3226a.isHeld()) {
                    AbstractC0432hb.f3226a.release();
                }
                AbstractC0432hb.f3226a = null;
            } else if ("android.intent.action.ACTION_POWER_DISCONNECTED".equals(action)) {
                if (z) {
                    a("onReceive: power_disconnected --> schedule update fence");
                }
            } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                if (!C0458qa.e(this.f3127a)) {
                    this.g.f3135b = false;
                    this.g.f3136c = 60000L;
                    b();
                }
                a("onReceive: connected and no_fresh_location --> schedule update fence");
            }
        }
    }

    @Override // android.app.PendingIntent.OnFinished
    public final void onSendFinished(PendingIntent pendingIntent, Intent intent, int i, String str, Bundle bundle) {
        this.f3129c.release();
    }

    @Override // com.tencent.map.geolocation.TencentLocationListener
    public final void onStatusUpdate(String str, int i, String str2) {
    }

    public final void a() {
        if (this.h) {
            throw new IllegalStateException("this object has been destroyed!");
        }
    }

    public final void b() {
        a(-1L);
        this.f3131e.removeMessages(2);
        this.f3128b.b();
    }

    public final void c() {
        this.g.a();
        this.f3132f.reset();
    }

    /* JADX INFO: compiled from: TL */
    final class c implements TxGeofenceManagerState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private LinkedList<TencentLocation> f3140a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        List<Map<String, String>> f3141b;

        private c() {
            this.f3140a = new LinkedList<>();
            this.f3141b = new ArrayList();
        }

        @Override // com.tencent.map.geolocation.fence.TxGeofenceManagerState
        public final void add(int i, TencentLocation tencentLocation) {
            if (i == 0) {
                this.f3140a.add(tencentLocation);
                return;
            }
            LinkedList<TencentLocation> linkedList = this.f3140a;
            Ob ob = Ob.f2969a;
            ob.l = System.currentTimeMillis();
            linkedList.add(ob);
        }

        @Override // com.tencent.map.geolocation.fence.TxGeofenceManagerState
        public final long getLastInterval() {
            return du.this.g.f3136c;
        }

        @Override // com.tencent.map.geolocation.fence.TxGeofenceManagerState
        public final TencentLocation getLastLocation() {
            return this.f3140a.isEmpty() ? Ob.f2969a : this.f3140a.getLast();
        }

        @Override // com.tencent.map.geolocation.fence.TxGeofenceManagerState
        public final long getLastLocationTime() {
            if (this.f3140a.isEmpty()) {
                return 0L;
            }
            return this.f3140a.getLast().getTime();
        }

        @Override // com.tencent.map.geolocation.fence.TxGeofenceManagerState
        public final Map<String, String> getLastSummary() {
            if (this.f3141b.isEmpty()) {
                return Collections.emptyMap();
            }
            return this.f3141b.get(r0.size() - 1);
        }

        @Override // com.tencent.map.geolocation.fence.TxGeofenceManagerState
        public final String getLocationTimes() {
            int size = this.f3140a.size();
            Iterator<TencentLocation> it = this.f3140a.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (it.next() == Ob.f2969a) {
                    i++;
                }
            }
            return size + "/" + i;
        }

        @Override // com.tencent.map.geolocation.fence.TxGeofenceManagerState
        public final List<TencentLocation> getLocations() {
            return new ArrayList(this.f3140a);
        }

        @Override // com.tencent.map.geolocation.fence.TxGeofenceManagerState
        public final long getNextLocationTime() {
            return getLastLocationTime() + du.this.g.f3136c;
        }

        @Override // com.tencent.map.geolocation.fence.TxGeofenceManagerState
        public final double getSpeed() {
            return du.this.i();
        }

        @Override // com.tencent.map.geolocation.fence.TxGeofenceManagerState
        public final List<Map<String, String>> getSummary() {
            return this.f3141b;
        }

        @Override // com.tencent.map.geolocation.fence.TxGeofenceManagerState
        public final void reset() {
        }

        /* synthetic */ c(du duVar, byte b2) {
            this();
        }
    }

    private void a(PendingIntent pendingIntent) {
        synchronized (this.g) {
            Iterator<dn> it = this.g.f3134a.iterator();
            while (it.hasNext()) {
                if (it.next().f3122e.equals(pendingIntent)) {
                    it.remove();
                }
            }
            d();
        }
    }

    private void a(String str) {
        if (!C0458qa.e(this.f3127a)) {
            StringBuilder sb = new StringBuilder("no data conn. skip [");
            sb.append(str);
            sb.append("]");
        } else {
            b bVar = this.g;
            if (bVar.f3138e) {
                return;
            }
            bVar.f3138e = true;
            this.f3131e.sendEmptyMessage(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0155 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e4 A[Catch: all -> 0x0322, TryCatch #0 {, blocks: (B:4:0x000f, B:6:0x0036, B:8:0x0040, B:9:0x0043, B:10:0x004c, B:12:0x0054, B:14:0x0060, B:28:0x00c4, B:33:0x00e4, B:41:0x00fa, B:43:0x00fe, B:44:0x0103, B:46:0x0107, B:47:0x010c, B:56:0x0136, B:58:0x013b, B:63:0x014a, B:50:0x011f, B:52:0x012c, B:36:0x00ea, B:21:0x00a1, B:65:0x0160, B:67:0x016d, B:68:0x017e, B:70:0x0189, B:72:0x01a1, B:77:0x01b8, B:79:0x01c3, B:81:0x01ce, B:91:0x0203, B:95:0x0224, B:100:0x022f, B:102:0x0270, B:108:0x02b8, B:109:0x02c1, B:111:0x02c7, B:112:0x02db, B:113:0x02e2, B:104:0x028a, B:94:0x0220, B:105:0x02a7, B:107:0x02ad, B:73:0x01a4), top: B:128:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ea A[Catch: all -> 0x0322, TryCatch #0 {, blocks: (B:4:0x000f, B:6:0x0036, B:8:0x0040, B:9:0x0043, B:10:0x004c, B:12:0x0054, B:14:0x0060, B:28:0x00c4, B:33:0x00e4, B:41:0x00fa, B:43:0x00fe, B:44:0x0103, B:46:0x0107, B:47:0x010c, B:56:0x0136, B:58:0x013b, B:63:0x014a, B:50:0x011f, B:52:0x012c, B:36:0x00ea, B:21:0x00a1, B:65:0x0160, B:67:0x016d, B:68:0x017e, B:70:0x0189, B:72:0x01a1, B:77:0x01b8, B:79:0x01c3, B:81:0x01ce, B:91:0x0203, B:95:0x0224, B:100:0x022f, B:102:0x0270, B:108:0x02b8, B:109:0x02c1, B:111:0x02c7, B:112:0x02db, B:113:0x02e2, B:104:0x028a, B:94:0x0220, B:105:0x02a7, B:107:0x02ad, B:73:0x01a4), top: B:128:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fe A[Catch: all -> 0x0322, TryCatch #0 {, blocks: (B:4:0x000f, B:6:0x0036, B:8:0x0040, B:9:0x0043, B:10:0x004c, B:12:0x0054, B:14:0x0060, B:28:0x00c4, B:33:0x00e4, B:41:0x00fa, B:43:0x00fe, B:44:0x0103, B:46:0x0107, B:47:0x010c, B:56:0x0136, B:58:0x013b, B:63:0x014a, B:50:0x011f, B:52:0x012c, B:36:0x00ea, B:21:0x00a1, B:65:0x0160, B:67:0x016d, B:68:0x017e, B:70:0x0189, B:72:0x01a1, B:77:0x01b8, B:79:0x01c3, B:81:0x01ce, B:91:0x0203, B:95:0x0224, B:100:0x022f, B:102:0x0270, B:108:0x02b8, B:109:0x02c1, B:111:0x02c7, B:112:0x02db, B:113:0x02e2, B:104:0x028a, B:94:0x0220, B:105:0x02a7, B:107:0x02ad, B:73:0x01a4), top: B:128:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0107 A[Catch: all -> 0x0322, TryCatch #0 {, blocks: (B:4:0x000f, B:6:0x0036, B:8:0x0040, B:9:0x0043, B:10:0x004c, B:12:0x0054, B:14:0x0060, B:28:0x00c4, B:33:0x00e4, B:41:0x00fa, B:43:0x00fe, B:44:0x0103, B:46:0x0107, B:47:0x010c, B:56:0x0136, B:58:0x013b, B:63:0x014a, B:50:0x011f, B:52:0x012c, B:36:0x00ea, B:21:0x00a1, B:65:0x0160, B:67:0x016d, B:68:0x017e, B:70:0x0189, B:72:0x01a1, B:77:0x01b8, B:79:0x01c3, B:81:0x01ce, B:91:0x0203, B:95:0x0224, B:100:0x022f, B:102:0x0270, B:108:0x02b8, B:109:0x02c1, B:111:0x02c7, B:112:0x02db, B:113:0x02e2, B:104:0x028a, B:94:0x0220, B:105:0x02a7, B:107:0x02ad, B:73:0x01a4), top: B:128:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x011f A[Catch: all -> 0x0322, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x000f, B:6:0x0036, B:8:0x0040, B:9:0x0043, B:10:0x004c, B:12:0x0054, B:14:0x0060, B:28:0x00c4, B:33:0x00e4, B:41:0x00fa, B:43:0x00fe, B:44:0x0103, B:46:0x0107, B:47:0x010c, B:56:0x0136, B:58:0x013b, B:63:0x014a, B:50:0x011f, B:52:0x012c, B:36:0x00ea, B:21:0x00a1, B:65:0x0160, B:67:0x016d, B:68:0x017e, B:70:0x0189, B:72:0x01a1, B:77:0x01b8, B:79:0x01c3, B:81:0x01ce, B:91:0x0203, B:95:0x0224, B:100:0x022f, B:102:0x0270, B:108:0x02b8, B:109:0x02c1, B:111:0x02c7, B:112:0x02db, B:113:0x02e2, B:104:0x028a, B:94:0x0220, B:105:0x02a7, B:107:0x02ad, B:73:0x01a4), top: B:128:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x013b A[Catch: all -> 0x0322, TryCatch #0 {, blocks: (B:4:0x000f, B:6:0x0036, B:8:0x0040, B:9:0x0043, B:10:0x004c, B:12:0x0054, B:14:0x0060, B:28:0x00c4, B:33:0x00e4, B:41:0x00fa, B:43:0x00fe, B:44:0x0103, B:46:0x0107, B:47:0x010c, B:56:0x0136, B:58:0x013b, B:63:0x014a, B:50:0x011f, B:52:0x012c, B:36:0x00ea, B:21:0x00a1, B:65:0x0160, B:67:0x016d, B:68:0x017e, B:70:0x0189, B:72:0x01a1, B:77:0x01b8, B:79:0x01c3, B:81:0x01ce, B:91:0x0203, B:95:0x0224, B:100:0x022f, B:102:0x0270, B:108:0x02b8, B:109:0x02c1, B:111:0x02c7, B:112:0x02db, B:113:0x02e2, B:104:0x028a, B:94:0x0220, B:105:0x02a7, B:107:0x02ad, B:73:0x01a4), top: B:128:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x014a A[Catch: all -> 0x0322, TryCatch #0 {, blocks: (B:4:0x000f, B:6:0x0036, B:8:0x0040, B:9:0x0043, B:10:0x004c, B:12:0x0054, B:14:0x0060, B:28:0x00c4, B:33:0x00e4, B:41:0x00fa, B:43:0x00fe, B:44:0x0103, B:46:0x0107, B:47:0x010c, B:56:0x0136, B:58:0x013b, B:63:0x014a, B:50:0x011f, B:52:0x012c, B:36:0x00ea, B:21:0x00a1, B:65:0x0160, B:67:0x016d, B:68:0x017e, B:70:0x0189, B:72:0x01a1, B:77:0x01b8, B:79:0x01c3, B:81:0x01ce, B:91:0x0203, B:95:0x0224, B:100:0x022f, B:102:0x0270, B:108:0x02b8, B:109:0x02c1, B:111:0x02c7, B:112:0x02db, B:113:0x02e2, B:104:0x028a, B:94:0x0220, B:105:0x02a7, B:107:0x02ad, B:73:0x01a4), top: B:128:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r29) {
        /*
            Method dump skipped, instruction units count: 807
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.du.a(boolean):void");
    }

    public du(Context context) {
        this(context, Looper.myLooper());
    }

    @SuppressLint({"Wakelock"})
    private void a(PendingIntent pendingIntent, Intent intent) {
        this.f3129c.acquire();
        try {
            pendingIntent.send(this.f3127a, 0, intent, this, null);
        } catch (PendingIntent.CanceledException unused) {
            a(pendingIntent);
            this.f3129c.release();
        }
    }

    private PendingIntent a(long j) {
        AlarmManager alarmManager = (AlarmManager) this.f3127a.getSystemService("alarm");
        PendingIntent pendingIntentJ = null;
        if (alarmManager == null) {
            return null;
        }
        String str = Build.MANUFACTURER;
        boolean zContains = str != null ? str.toLowerCase(Locale.US).contains("xiaomi") : false;
        PendingIntent pendingIntent = this.j;
        if (pendingIntent != null) {
            alarmManager.cancel(pendingIntent);
            this.j = null;
            if (zContains) {
                this.f3131e.removeMessages(2);
            }
        }
        if (j > 0) {
            pendingIntentJ = j();
            this.j = pendingIntentJ;
            alarmManager.setRepeating(2, SystemClock.elapsedRealtime() + j, j, pendingIntentJ);
            if (zContains) {
                this.f3131e.sendEmptyMessageDelayed(2, 10000 + j);
            }
            StringBuilder sb = new StringBuilder("setLocationAlarm: will triggered after ");
            sb.append(j);
            sb.append(" ms, isXiaomi=");
            sb.append(zContains);
        }
        return pendingIntentJ;
    }
}
