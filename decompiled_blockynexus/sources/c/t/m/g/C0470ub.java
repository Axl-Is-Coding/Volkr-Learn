package c.t.m.g;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: renamed from: c.t.m.g.ub, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class C0470ub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final LinkedBlockingQueue<a> f3414a = new LinkedBlockingQueue<>(3);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final C0423eb f3415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f3416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f3417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    long f3418e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f3419f;
    volatile boolean g;
    boolean h;
    volatile Handler i;

    C0470ub(C0423eb c0423eb) {
        this.f3415b = c0423eb;
    }

    private void b() {
        this.f3416c = 0L;
        this.f3417d = 0L;
        this.f3418e = 0L;
        this.f3419f = 0L;
    }

    public final void a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            byte[] bArrA = Vb.a(str.getBytes("UTF-8"));
            com.tencent.tencentmap.lbssdk.service.e.o(bArrA, 2);
            a aVar = new a(2, bArrA, "https://ue.indoorloc.map.qq.com/", null);
            aVar.g = str;
            a(aVar);
        } catch (Throwable unused) {
        }
    }

    final void b(a aVar) {
        boolean z;
        a.d(aVar);
        Iterator<a> it = this.f3414a.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (it.next().f3421b == aVar.f3421b) {
                z = true;
                break;
            }
        }
        if (aVar.f3425f <= 0 || z) {
            return;
        }
        this.f3414a.offer(aVar);
    }

    /* JADX INFO: renamed from: c.t.m.g.ub$a */
    /* JADX INFO: compiled from: TL */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f3420a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f3421b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final byte[] f3422c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f3423d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final Object f3424e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f3425f;
        public String g;
        public long h;

        private a() {
            this.f3425f = 1;
            this.f3421b = 0;
            this.f3422c = null;
            this.f3423d = null;
            this.f3424e = null;
        }

        static /* synthetic */ int d(a aVar) {
            int i = aVar.f3425f;
            aVar.f3425f = i - 1;
            return i;
        }

        a(int i, byte[] bArr, String str, Object obj) {
            this.f3425f = 1;
            this.f3421b = i;
            this.f3422c = bArr;
            this.f3423d = str;
            this.f3424e = obj;
        }
    }

    public final void a(String str, Bb bb, int i) {
        try {
            byte[] bArrA = Wb.a(str.getBytes("GBK"));
            a aVar = new a(1, bArrA, a(bArrA, i), bb);
            aVar.g = str;
            a(aVar);
        } catch (Throwable unused) {
        }
    }

    final boolean a(a aVar) {
        boolean zOffer = aVar.f3422c != null ? this.f3414a.offer(aVar) : false;
        if (!zOffer) {
            this.f3414a.clear();
            this.f3414a.offer(aVar);
            if (aVar.f3421b != 2 && aVar.f3421b != 3) {
                int unused = aVar.f3421b;
            }
        }
        return zOffer;
    }

    public final void a(Handler handler, boolean z) {
        if (this.g) {
            return;
        }
        this.g = true;
        this.i = handler;
        this.h = z;
        this.f3415b.f3149e.execute(new RunnableC0467tb(this));
        this.f3419f = SystemClock.elapsedRealtime();
    }

    public final void a() {
        if (this.g) {
            this.g = false;
            this.f3414a.clear();
            this.f3414a.offer(a.f3420a);
            this.i = null;
            if (this.f3419f != 0) {
                String.format(Locale.ENGLISH, "shutdown: duration=%ds, sent=%dB, recv=%dB, reqCount=%d", Long.valueOf((SystemClock.elapsedRealtime() - this.f3419f) / 1000), Long.valueOf(this.f3417d), Long.valueOf(this.f3418e), Long.valueOf(this.f3416c));
            }
            b();
        }
    }

    private static String a(byte[] bArr, int i) {
        if (bArr != null) {
            try {
                if (com.tencent.tencentmap.lbssdk.service.e.o(bArr, 1) >= 0) {
                    return C0444lb.a(i, 1);
                }
            } catch (UnsatisfiedLinkError unused) {
                return null;
            }
        }
        return C0444lb.a(i, 0);
    }
}
