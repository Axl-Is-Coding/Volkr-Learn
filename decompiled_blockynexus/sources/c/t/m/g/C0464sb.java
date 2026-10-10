package c.t.m.g;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import java.util.List;

/* JADX INFO: renamed from: c.t.m.g.sb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
final class C0464sb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile boolean f3390a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final C0423eb f3392c;
    private HandlerThread h;
    a i;
    b j;
    private Handler k;
    SignalStrength l;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    byte[] f3391b = new byte[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ek f3393d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ek f3394e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ek f3395f = null;
    ServiceState g = null;
    private int m = 0;

    /* JADX INFO: renamed from: c.t.m.g.sb$a */
    /* JADX INFO: compiled from: TL */
    final class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        volatile boolean f3396a;

        /* synthetic */ a(C0464sb c0464sb, Looper looper, byte b2) {
            this(looper);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
        @Override // android.os.Handler
        @android.annotation.SuppressLint({"NewApi", "MissingPermission"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void handleMessage(android.os.Message r6) {
            /*
                r5 = this;
                c.t.m.g.sb r6 = c.t.m.g.C0464sb.this
                boolean r6 = r6.f3390a
                if (r6 != 0) goto L7
                return
            L7:
                c.t.m.g.sb r6 = c.t.m.g.C0464sb.this
                c.t.m.g.eb r6 = r6.f3392c
                java.util.List r6 = c.t.m.g.Pb.b(r6)
                c.t.m.g.sb r0 = c.t.m.g.C0464sb.this
                c.t.m.g.ek r0 = r0.f3393d
                if (r0 == 0) goto L18
                r0.a(r6)
            L18:
                if (r6 == 0) goto L2f
                int r0 = r6.size()
                if (r0 != 0) goto L21
                goto L2f
            L21:
                java.util.Iterator r6 = r6.iterator()
            L25:
                boolean r0 = r6.hasNext()
                if (r0 == 0) goto L2f
                r6.next()
                goto L25
            L2f:
                c.t.m.g.sb r6 = c.t.m.g.C0464sb.this
                c.t.m.g.ek r6 = r6.f3393d
                r0 = 0
                if (r6 == 0) goto L48
                long r1 = java.lang.System.currentTimeMillis()
                long r3 = r6.i
                long r1 = r1 - r3
                r3 = 10000(0x2710, double:4.9407E-320)
                int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r6 >= 0) goto L45
                r6 = 1
                goto L46
            L45:
                r6 = 0
            L46:
                if (r6 != 0) goto L7a
            L48:
                c.t.m.g.sb r6 = c.t.m.g.C0464sb.this
                c.t.m.g.eb r6 = r6.f3392c
                android.telephony.TelephonyManager r1 = r6.h
                if (r1 == 0) goto L7a
                java.util.List r6 = c.t.m.g.Pb.c(r6)
                c.t.m.g.sb r1 = c.t.m.g.C0464sb.this
                c.t.m.g.eb r1 = r1.f3392c
                c.t.m.g.ek r6 = c.t.m.g.ek.a(r1, r6)
                if (r6 == 0) goto L62
                boolean r1 = r6.j
                if (r1 != 0) goto L74
            L62:
                c.t.m.g.sb r6 = c.t.m.g.C0464sb.this
                c.t.m.g.eb r6 = r6.f3392c
                android.telephony.CellLocation r6 = c.t.m.g.Pb.a(r6)
                c.t.m.g.sb r1 = c.t.m.g.C0464sb.this
                c.t.m.g.eb r2 = r1.f3392c
                android.telephony.SignalStrength r1 = r1.l
                c.t.m.g.ek r6 = c.t.m.g.ek.a(r2, r6, r1)
            L74:
                c.t.m.g.sb r1 = c.t.m.g.C0464sb.this
                r2 = 2
                c.t.m.g.C0464sb.a(r1, r6, r2)
            L7a:
                c.t.m.g.sb r6 = c.t.m.g.C0464sb.this
                byte[] r6 = r6.f3391b
                monitor-enter(r6)
                c.t.m.g.sb r1 = c.t.m.g.C0464sb.this     // Catch: java.lang.Throwable -> L94
                c.t.m.g.sb$a r1 = r1.i     // Catch: java.lang.Throwable -> L94
                if (r1 == 0) goto L92
                boolean r1 = r5.f3396a     // Catch: java.lang.Throwable -> L94
                if (r1 != 0) goto L92
                c.t.m.g.sb r1 = c.t.m.g.C0464sb.this     // Catch: java.lang.Throwable -> L94
                c.t.m.g.sb$a r1 = r1.i     // Catch: java.lang.Throwable -> L94
                r2 = 30000(0x7530, double:1.4822E-319)
                c.t.m.g.C0458qa.a(r1, r0, r2)     // Catch: java.lang.Throwable -> L94
            L92:
                monitor-exit(r6)     // Catch: java.lang.Throwable -> L94
                return
            L94:
                r0 = move-exception
                monitor-exit(r6)     // Catch: java.lang.Throwable -> L94
                goto L98
            L97:
                throw r0
            L98:
                goto L97
            */
            throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.C0464sb.a.handleMessage(android.os.Message):void");
        }

        private a(Looper looper) {
            super(looper);
            this.f3396a = false;
            this.f3396a = false;
        }
    }

    /* JADX INFO: renamed from: c.t.m.g.sb$b */
    /* JADX INFO: compiled from: TL */
    final class b extends PhoneStateListener {
        public b() {
            a(1297);
        }

        final void a(int i) {
            try {
                C0464sb.this.f3392c.h.listen(this, i);
            } catch (Throwable unused) {
            }
        }

        @Override // android.telephony.PhoneStateListener
        @SuppressLint({"NewApi"})
        public final void onCellInfoChanged(List<CellInfo> list) {
            if (list != null) {
                list.size();
            }
            C0464sb.a(C0464sb.this, ek.a(C0464sb.this.f3392c, list), 0);
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellLocationChanged(CellLocation cellLocation) {
            super.onCellLocationChanged(cellLocation);
            C0464sb c0464sb = C0464sb.this;
            C0464sb.a(C0464sb.this, ek.a(c0464sb.f3392c, cellLocation, c0464sb.l), 1);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
        @Override // android.telephony.PhoneStateListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onServiceStateChanged(android.telephony.ServiceState r7) {
            /*
                r6 = this;
                super.onServiceStateChanged(r7)
                if (r7 != 0) goto L6
                return
            L6:
                c.t.m.g.sb r0 = c.t.m.g.C0464sb.this     // Catch: java.lang.Throwable -> L6b
                android.telephony.ServiceState r0 = r0.g     // Catch: java.lang.Throwable -> L6b
                if (r0 == 0) goto L16
                int r0 = r0.getState()     // Catch: java.lang.Throwable -> L6b
                int r1 = r7.getState()     // Catch: java.lang.Throwable -> L6b
                if (r0 == r1) goto L6b
            L16:
                c.t.m.g.sb r0 = c.t.m.g.C0464sb.this     // Catch: java.lang.Throwable -> L6b
                r0.g = r7     // Catch: java.lang.Throwable -> L6b
                c.t.m.g.sb r7 = c.t.m.g.C0464sb.this     // Catch: java.lang.Throwable -> L6b
                boolean r0 = r7.f3390a     // Catch: java.lang.Throwable -> L6b
                if (r0 == 0) goto L6b
                android.telephony.ServiceState r0 = r7.g     // Catch: java.lang.Throwable -> L6b
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L3a
                android.telephony.ServiceState r0 = r7.g     // Catch: java.lang.Throwable -> L6b
                int r0 = r0.getState()     // Catch: java.lang.Throwable -> L6b
                if (r0 != 0) goto L30
                r0 = 1
                goto L3b
            L30:
                android.telephony.ServiceState r0 = r7.g     // Catch: java.lang.Throwable -> L6b
                int r0 = r0.getState()     // Catch: java.lang.Throwable -> L6b
                if (r0 != r1) goto L3a
                r0 = 0
                goto L3b
            L3a:
                r0 = -1
            L3b:
                c.t.m.g.eb r3 = r7.f3392c     // Catch: java.lang.Throwable -> L6b
                android.telephony.TelephonyManager r3 = r3.h     // Catch: java.lang.Throwable -> L6b
                c.t.m.g.eb r4 = r7.f3392c     // Catch: java.lang.Throwable -> L6b
                android.content.Context r4 = r4.f3147c     // Catch: java.lang.Throwable -> L6b
                boolean r4 = c.t.m.g.Pb.a(r4)     // Catch: java.lang.Throwable -> L6b
                if (r3 == 0) goto L51
                int r3 = r3.getSimState()     // Catch: java.lang.Throwable -> L6b
                r5 = 5
                if (r3 != r5) goto L51
                goto L52
            L51:
                r1 = 0
            L52:
                if (r4 != 0) goto L56
                if (r1 != 0) goto L57
            L56:
                r0 = 0
            L57:
                android.os.Message r1 = new android.os.Message     // Catch: java.lang.Throwable -> L6b
                r1.<init>()     // Catch: java.lang.Throwable -> L6b
                r2 = 12999(0x32c7, float:1.8215E-41)
                r1.what = r2     // Catch: java.lang.Throwable -> L6b
                r2 = 12003(0x2ee3, float:1.682E-41)
                r1.arg1 = r2     // Catch: java.lang.Throwable -> L6b
                r1.arg2 = r0     // Catch: java.lang.Throwable -> L6b
                c.t.m.g.eb r7 = r7.f3392c     // Catch: java.lang.Throwable -> L6b
                r7.b(r1)     // Catch: java.lang.Throwable -> L6b
            L6b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.C0464sb.b.onServiceStateChanged(android.telephony.ServiceState):void");
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
            super.onSignalStrengthsChanged(signalStrength);
            C0464sb.this.l = signalStrength;
        }
    }

    public C0464sb(C0423eb c0423eb) {
        this.f3392c = c0423eb;
    }

    @SuppressLint({"NewApi"})
    public final void a(Handler handler, boolean z) {
        if (this.f3390a) {
            return;
        }
        this.k = handler;
        this.h = new HandlerThread("new_cell_provider");
        HandlerThread handlerThread = this.h;
        if (handlerThread != null) {
            byte b2 = 0;
            try {
                handlerThread.start();
                this.i = new a(this, this.h.getLooper(), b2);
            } catch (Throwable unused) {
                this.i = new a(this, this.k.getLooper(), b2);
            }
            this.f3390a = true;
            if (!z) {
                C0458qa.a(this.i, 0, 0L);
            }
            this.i.postDelayed(new RunnableC0461rb(this), 1000L);
        }
    }

    public final void a() {
        if (this.f3390a) {
            this.f3390a = false;
            synchronized (this.f3391b) {
                if (this.j != null) {
                    this.j.a(0);
                }
                if (this.i != null) {
                    this.i.f3396a = true;
                    this.i.removeCallbacksAndMessages(null);
                    this.i = null;
                }
                if (this.h != null) {
                    this.h.quit();
                    this.h = null;
                }
                this.f3393d = null;
                this.g = null;
                this.j = null;
                this.l = null;
            }
        }
    }

    private void a(ek ekVar) {
        if (!this.f3390a || ekVar == null || this.f3392c == null) {
            return;
        }
        synchronized (this) {
            if (this.f3393d != null) {
                ekVar.a(this.f3393d.a());
            }
            this.f3393d = ekVar;
            this.f3392c.b(ekVar);
        }
    }

    static /* synthetic */ void a(C0464sb c0464sb, ek ekVar, int i) {
        if (c0464sb.f3393d != null || ekVar == null || !ekVar.j) {
            if (i == 0) {
                if (ekVar == null || !ekVar.j) {
                    return;
                }
                ek ekVar2 = c0464sb.f3393d;
                if (ekVar2 == null || !ekVar2.m.containsAll(ekVar.m)) {
                    c0464sb.a(ekVar);
                    return;
                }
                return;
            }
            if (i != 1) {
                if (i != 2 || ekVar == null || !ekVar.j) {
                    return;
                }
                ek ekVar3 = c0464sb.f3393d;
                if (ekVar3 != null && ekVar3.m.containsAll(ekVar.m)) {
                    return;
                }
            } else {
                if (ekVar == null || !ekVar.j) {
                    return;
                }
                ek ekVar4 = c0464sb.f3393d;
                if (ekVar4 == null || !ekVar4.m.contains(ekVar.b())) {
                    c0464sb.a(ekVar);
                    return;
                }
                return;
            }
        }
        c0464sb.a(ekVar);
    }
}
