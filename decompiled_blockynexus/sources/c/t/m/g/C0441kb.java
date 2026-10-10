package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.gsm.GsmCellLocation;

/* JADX INFO: renamed from: c.t.m.g.kb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
final class C0441kb extends PhoneStateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile boolean f3267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C0423eb f3268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f3269c = new byte[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CellLocation f3270d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SignalStrength f3271e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ServiceState f3272f = null;
    private long g;
    private HandlerThread h;
    private a i;

    /* JADX INFO: renamed from: c.t.m.g.kb$a */
    /* JADX INFO: compiled from: TL */
    final class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        volatile boolean f3273a;

        /* synthetic */ a(C0441kb c0441kb, Looper looper, byte b2) {
            this(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (C0441kb.this.f3267a) {
                synchronized (C0441kb.this.f3269c) {
                    if (C0441kb.this.i != null && !this.f3273a) {
                        sendEmptyMessageDelayed(0, com.tendcloud.tenddata.ab.R);
                    }
                }
                C0441kb.this.onCellLocationChanged(Pb.a(C0441kb.this.f3268b));
            }
        }

        private a(Looper looper) {
            super(looper);
            this.f3273a = false;
            this.f3273a = false;
        }
    }

    /* JADX INFO: renamed from: c.t.m.g.kb$b */
    /* JADX INFO: compiled from: TL */
    static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private C0423eb f3275a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ek f3276b;

        public b(C0423eb c0423eb) {
            this.f3275a = c0423eb;
        }

        @Override // java.lang.Runnable
        public final void run() {
            C0423eb c0423eb = this.f3275a;
            ek ekVar = this.f3276b;
            if (ekVar != null) {
                ekVar.a(Pb.b(c0423eb));
                c0423eb.b(ekVar);
            }
        }
    }

    public C0441kb(C0423eb c0423eb) {
        this.f3268b = c0423eb;
    }

    private void d() {
        ek ekVarA = ek.a(this.f3268b, this.f3270d, this.f3271e);
        synchronized (this.f3269c) {
            if (this.i != null && ekVarA != null) {
                b bVar = new b(this.f3268b);
                bVar.f3276b = ekVarA;
                this.i.post(bVar);
            }
        }
    }

    @Override // android.telephony.PhoneStateListener
    public final void onCellLocationChanged(CellLocation cellLocation) {
        super.onCellLocationChanged(cellLocation);
        if (a(cellLocation)) {
            this.f3270d = cellLocation;
            c();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0032  */
    @Override // android.telephony.PhoneStateListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onServiceStateChanged(android.telephony.ServiceState r6) {
        /*
            r5 = this;
            super.onServiceStateChanged(r6)
            if (r6 != 0) goto L6
            return
        L6:
            android.telephony.ServiceState r0 = r5.f3272f
            if (r0 == 0) goto L14
            int r0 = r0.getState()
            int r1 = r6.getState()
            if (r0 == r1) goto L61
        L14:
            r5.f3272f = r6
            boolean r6 = r5.f3267a
            if (r6 == 0) goto L61
            android.telephony.ServiceState r6 = r5.f3272f
            r0 = 1
            r1 = 0
            if (r6 == 0) goto L32
            int r6 = r6.getState()
            if (r6 != 0) goto L28
            r6 = 1
            goto L33
        L28:
            android.telephony.ServiceState r6 = r5.f3272f
            int r6 = r6.getState()
            if (r6 != r0) goto L32
            r6 = 0
            goto L33
        L32:
            r6 = -1
        L33:
            c.t.m.g.eb r2 = r5.f3268b
            android.telephony.TelephonyManager r3 = r2.h
            android.content.Context r2 = r2.f3147c
            boolean r2 = c.t.m.g.Pb.a(r2)
            if (r3 == 0) goto L47
            int r3 = r3.getSimState()
            r4 = 5
            if (r3 != r4) goto L47
            goto L48
        L47:
            r0 = 0
        L48:
            if (r2 != 0) goto L4c
            if (r0 != 0) goto L4d
        L4c:
            r6 = 0
        L4d:
            android.os.Message r0 = new android.os.Message
            r0.<init>()
            r1 = 12999(0x32c7, float:1.8215E-41)
            r0.what = r1
            r1 = 12003(0x2ee3, float:1.682E-41)
            r0.arg1 = r1
            r0.arg2 = r6
            c.t.m.g.eb r6 = r5.f3268b
            r6.b(r0)
        L61:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.C0441kb.onServiceStateChanged(android.telephony.ServiceState):void");
    }

    @Override // android.telephony.PhoneStateListener
    public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
        super.onSignalStrengthsChanged(signalStrength);
        if (signalStrength == null) {
            return;
        }
        try {
            SignalStrength signalStrength2 = this.f3271e;
            int i = this.f3268b.f3148d.f3058b;
            if (signalStrength2 == null || Pb.a(i, signalStrength2, signalStrength)) {
                this.f3271e = signalStrength;
                c();
            }
        } catch (Exception unused) {
        }
    }

    private void c() {
        if (this.f3267a && this.f3270d != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.g > 2000) {
                this.g = jCurrentTimeMillis;
                d();
            }
        }
    }

    public final void a() {
        ek ekVarA;
        if (this.f3267a) {
            return;
        }
        this.f3267a = true;
        synchronized (this.f3269c) {
            this.h = new HandlerThread("CellProvider");
            this.h.start();
            this.i = new a(this, this.h.getLooper(), (byte) 0);
            this.i.sendEmptyMessageDelayed(0, 3000L);
        }
        CellLocation cellLocationA = Pb.a(this.f3268b);
        if (a(cellLocationA) && (ekVarA = ek.a(this.f3268b, cellLocationA, null)) != null) {
            this.f3270d = cellLocationA;
            this.f3268b.b(ekVarA);
        }
        a(273);
    }

    public final void b() {
        if (this.f3267a) {
            this.f3267a = false;
            a(0);
            synchronized (this.f3269c) {
                if (this.i != null) {
                    this.i.f3273a = true;
                    this.i.removeCallbacksAndMessages(null);
                    this.i = null;
                }
                if (this.h != null) {
                    this.h.quit();
                    this.h = null;
                }
                this.f3270d = null;
                this.f3271e = null;
                this.f3272f = null;
                this.g = 0L;
            }
        }
    }

    private void a(int i) {
        try {
            this.f3268b.h.listen(this, i);
        } catch (Exception unused) {
        }
    }

    private boolean a(CellLocation cellLocation) {
        if (cellLocation == null) {
            return false;
        }
        try {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            if (gsmCellLocation.getCid() == 0) {
                if (gsmCellLocation.getLac() == 0) {
                    return false;
                }
            }
        } catch (ClassCastException unused) {
        }
        if (Pb.a(cellLocation) < 0 || Pb.a(this.f3270d, cellLocation)) {
            return false;
        }
        ek ekVarA = ek.a(this.f3268b, cellLocation, null);
        return ekVarA == null ? true : Pb.a(ekVarA);
    }
}
