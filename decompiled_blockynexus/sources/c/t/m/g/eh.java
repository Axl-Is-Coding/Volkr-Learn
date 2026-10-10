package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class eh extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Comparator<ScanResult> f3169a = new C0482yb();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f3170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C0423eb f3171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WifiManager f3172d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f3173e;
    private volatile boolean g;
    private volatile Handler h;
    private volatile a i;
    private volatile List<ScanResult> j;
    private volatile List<ScanResult> k;
    StringBuilder n = new StringBuilder();
    public long o = com.tendcloud.tenddata.ab.R;
    private final byte[] p = new byte[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private HashSet<String> f3174f = new HashSet<>();
    private Runnable l = new RunnableC0476wb(this);
    private Runnable m = new RunnableC0479xb(this);

    /* JADX INFO: compiled from: TL */
    class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            synchronized (eh.this.p) {
                int i = message.what;
                if (i == 1201) {
                    eh.this.d();
                } else if (i == 1202) {
                    try {
                        List<ScanResult> list = eh.this.j;
                        if (list == null || list.size() <= 0) {
                            eh.this.f3171c.b(Db.f2897a);
                            eh.this.n.setLength(0);
                        } else {
                            if (eh.this.k == null) {
                                eh.this.k = new ArrayList();
                            }
                            try {
                                eh.this.n.setLength(0);
                                int i2 = 1;
                                for (ScanResult scanResult : list) {
                                    if (i2 <= 20) {
                                        StringBuilder sb = eh.this.n;
                                        sb.append(scanResult.SSID);
                                        sb.append(',');
                                        sb.append(scanResult.BSSID);
                                        sb.append('|');
                                        i2++;
                                    }
                                }
                            } catch (Throwable unused) {
                            }
                            eh.this.k.clear();
                            eh.this.k.addAll(list);
                            C0485zb.a(eh.this.k);
                            if (eh.this.k != null && eh.this.k.size() > 0) {
                                Collections.sort(eh.this.k, eh.f3169a);
                                eh.j(eh.this);
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
    }

    public eh(C0423eb c0423eb) {
        this.f3171c = c0423eb;
        this.f3172d = c0423eb.i;
    }

    static /* synthetic */ void j(eh ehVar) {
        List<ScanResult> list = ehVar.k;
        if (ehVar.f3174f == null) {
            ehVar.f3174f = new HashSet<>();
        }
        if (list != null) {
            if (ehVar.f3174f.size() == 0) {
                for (ScanResult scanResult : list) {
                    ehVar.f3174f.add(scanResult.BSSID + scanResult.level);
                }
                ehVar.f3173e = System.currentTimeMillis();
                ehVar.a(list);
                return;
            }
            int size = ehVar.f3174f.size();
            if (size != list.size()) {
                ehVar.f3174f.clear();
                for (ScanResult scanResult2 : list) {
                    ehVar.f3174f.add(scanResult2.BSSID + scanResult2.level);
                }
                ehVar.f3173e = System.currentTimeMillis();
                ehVar.a(list);
                return;
            }
            for (ScanResult scanResult3 : list) {
                ehVar.f3174f.add(scanResult3.BSSID + scanResult3.level);
            }
            if (size != ehVar.f3174f.size()) {
                ehVar.f3174f.clear();
                for (ScanResult scanResult4 : list) {
                    ehVar.f3174f.add(scanResult4.BSSID + scanResult4.level);
                }
                ehVar.f3173e = System.currentTimeMillis();
                ehVar.a(list);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            String action = intent.getAction();
            boolean zEquals = "android.net.wifi.WIFI_STATE_CHANGED".equals(action);
            if (zEquals) {
                a(1201);
            }
            if (zEquals || "android.net.wifi.SCAN_RESULTS".equals(action)) {
                try {
                    this.j = Xb.c(this.f3172d);
                } catch (Throwable unused) {
                    this.j = null;
                }
                a(1202);
            }
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            int iA = Xb.a(this.f3172d);
            int i = 1;
            if (iA == 3) {
                a(0L);
            } else if (iA == 1) {
                i = 0;
                if (!Xb.b(this.f3171c)) {
                    if (this.k != null) {
                        this.k.clear();
                    }
                    if (this.h != null) {
                        this.h.sendEmptyMessage(555);
                    }
                }
            } else {
                i = -1;
            }
            try {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (Settings.Secure.getInt(this.f3171c.f3147c.getContentResolver(), "location_mode") == 0) {
                        i = 5;
                    }
                }
            } catch (Throwable unused) {
            }
            Message message = new Message();
            message.what = 12999;
            message.arg1 = 12001;
            message.arg2 = i;
            this.f3171c.b(message);
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b() {
        if (!this.g && Xb.b(this.f3171c)) {
            return Xb.b(this.f3172d);
        }
        return false;
    }

    public final void a(Handler handler, Handler handler2, boolean z) {
        synchronized (this.p) {
            if (this.f3170b) {
                return;
            }
            this.f3170b = true;
            this.g = z;
            this.h = handler;
            Looper looper = this.h == null ? null : this.h.getLooper();
            if (this.i == null || this.i.getLooper() != looper) {
                if (this.i != null) {
                    this.i.removeCallbacksAndMessages(null);
                }
                if (looper != null) {
                    this.i = new a(looper);
                }
            }
            handler2.post(this.m);
            if (!this.g) {
                a(0L);
            }
        }
    }

    public final void a() {
        synchronized (this.p) {
            if (this.f3170b) {
                this.f3170b = false;
                try {
                    this.f3171c.f3147c.unregisterReceiver(this);
                } catch (Exception unused) {
                }
                this.f3174f = null;
                if (this.k != null) {
                    this.k.clear();
                }
                if (this.f3174f != null) {
                    this.f3174f.clear();
                }
                if (this.i != null) {
                    this.i.removeCallbacksAndMessages(null);
                    this.i = null;
                }
            }
        }
    }

    private void a(int i) {
        a aVar = this.i;
        if (aVar != null) {
            aVar.obtainMessage(i).sendToTarget();
        }
    }

    public final void a(long j) {
        Handler handler = this.h;
        Runnable runnable = this.l;
        Looper looper = handler == null ? null : handler.getLooper();
        if (looper != null) {
            try {
                if (looper.getThread().isAlive()) {
                    handler.removeCallbacks(runnable);
                    handler.postDelayed(runnable, j);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void a(List<ScanResult> list) {
        if (list != null && list.size() != 0) {
            if (Xb.f3053a) {
                Xb.f3053a = false;
                d();
            }
        } else {
            d();
        }
        this.f3171c.b(new Db(list, this.f3173e, Xb.a(this.f3172d)));
    }
}
