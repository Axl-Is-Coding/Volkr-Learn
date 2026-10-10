package com.bytedance.sdk.openadsdk.core.video.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import cn.qqtheme.framework.widget.WheelView;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.b;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.d;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.e;
import com.bytedance.sdk.openadsdk.core.widget.e;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.t;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: BaseVideoController.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements c, d, ad.a {
    private WeakReference<e> C;
    private int D;
    private long K;
    private int M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Context> f6446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f6447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f6448c;
    public long h;
    private com.bytedance.sdk.openadsdk.core.video.nativevideo.h i;
    private final ViewGroup j;
    private com.bytedance.sdk.openadsdk.core.video.e.d n;
    private c.a o;
    private ArrayList<Runnable> r;
    private boolean s;
    private final boolean t;
    private final ad k = new ad(this);
    private long l = 0;
    private long m = 0;
    private long p = 0;
    private long q = 0;
    private boolean u = false;
    private boolean v = false;
    private boolean w = true;
    private boolean x = false;
    private long y = 0;
    private boolean z = false;
    private boolean A = false;
    private boolean B = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Map<String, Object> f6449d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected long f6450e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected long f6451f = 0;
    protected boolean g = false;
    private boolean E = false;
    private boolean F = true;
    private final Runnable G = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.d.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.n != null) {
                a.this.n.e();
            }
        }
    };
    private final Runnable H = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.d.a.3
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.o != null) {
                a.this.o.a();
            }
        }
    };
    private final Runnable I = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.d.a.4
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.n != null) {
                a aVar = a.this;
                if (aVar.f6448c <= 0) {
                    aVar.n.e();
                }
                a.this.n.f();
            }
            a.this.k.postDelayed(this, 200L);
        }
    };
    private boolean J = false;
    private final BroadcastReceiver L = new BroadcastReceiver() { // from class: com.bytedance.sdk.openadsdk.core.video.d.a.5
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                a.this.h();
            } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                a.this.b(context);
            }
        }
    };
    private boolean N = false;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.video.d.a$6, reason: invalid class name */
    /* JADX INFO: compiled from: BaseVideoController.java */
    static /* synthetic */ class AnonymousClass6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6457a = new int[e.a.values().length];

        static {
            try {
                f6457a[e.a.PAUSE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6457a[e.a.RELEASE_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6457a[e.a.START_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    protected a(Context context, ViewGroup viewGroup, h hVar) {
        this.M = 1;
        this.M = q.c(context);
        this.j = viewGroup;
        this.f6446a = new WeakReference<>(context);
        this.f6447b = hVar;
        a(context);
        this.D = ab.d(this.f6447b.M());
        this.t = Build.VERSION.SDK_INT >= 17;
    }

    private void C() {
        int iA = a();
        int iV = (iA == 2 || iA == 1) ? o.h().v() * 1000 : iA == 3 ? o.h().f(String.valueOf(this.D)) : 5;
        this.k.removeCallbacks(this.H);
        this.k.postDelayed(this.H, iV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        E();
        this.k.postDelayed(this.I, 800L);
    }

    private void E() {
        this.k.removeCallbacks(this.I);
    }

    private boolean F() {
        WeakReference<Context> weakReference = this.f6446a;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    private void G() {
        ArrayList<Runnable> arrayList = this.r;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator it = new ArrayList(this.r).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.r.clear();
    }

    private void H() {
        h hVar = this.f6447b;
        if (hVar != null) {
            o.g().a(com.bytedance.sdk.openadsdk.j.e.a(hVar.F(), true, this.f6447b));
        }
    }

    private boolean I() throws Throwable {
        com.bytedance.sdk.openadsdk.core.video.e.d dVar;
        h hVar;
        WeakReference<Context> weakReference = this.f6446a;
        return weakReference == null || weakReference.get() == null || L() == null || (dVar = this.n) == null || dVar.a() == null || (hVar = this.f6447b) == null || hVar.u() != null || this.f6447b.i() == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void J() {
        /*
            Method dump skipped, instruction units count: 405
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.d.a.J():void");
    }

    private void K() {
        try {
            if (this.f6446a != null && this.f6446a.get() != null && L() != null && this.n != null && this.n.a() != null && this.f6447b != null) {
                boolean z = this.f6447b.N() == 15;
                int[] iArrB = ac.b(o.a());
                float f2 = iArrB[0];
                float f3 = iArrB[1];
                MediaPlayer mediaPlayerA = this.n.a();
                a(f2, f3, mediaPlayerA.getVideoWidth(), mediaPlayerA.getVideoHeight(), z);
                com.bytedance.sdk.openadsdk.utils.o.b("changeVideoSize", "changeSize=end");
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.o.a("changeVideoSize", "changeSize error", th);
        }
    }

    private com.bytedance.sdk.openadsdk.core.video.renderview.b L() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar;
        WeakReference<Context> weakReference = this.f6446a;
        if (weakReference == null || weakReference.get() == null || (hVar = this.i) == null) {
            return null;
        }
        return hVar.o();
    }

    private void M() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.i;
        if (hVar != null) {
            hVar.c(0);
            this.i.a(false, false);
            this.i.b(false);
            this.i.b();
            this.i.d();
        }
    }

    protected Map<String, Object> A() {
        HashMap map = new HashMap();
        Map<String, Object> map2 = this.f6449d;
        if (map2 != null) {
            for (Map.Entry<String, Object> entry : map2.entrySet()) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        Map<String, Object> mapA = ab.a(this.f6451f, this.f6447b, t());
        if (mapA != null) {
            for (Map.Entry<String, Object> entry2 : mapA.entrySet()) {
                map.put(entry2.getKey(), entry2.getValue());
            }
        }
        return map;
    }

    protected Map<String, Object> B() {
        HashMap map = new HashMap();
        Map<String, Object> mapA = ab.a(this.f6447b, n(), t());
        if (mapA != null) {
            for (Map.Entry<String, Object> entry : mapA.entrySet()) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        Map<String, Object> map2 = this.f6449d;
        if (map2 != null) {
            for (Map.Entry<String, Object> entry2 : map2.entrySet()) {
                map.put(entry2.getKey(), entry2.getValue());
            }
        }
        return map;
    }

    protected abstract int a();

    protected abstract void a(int i, int i2);

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view, boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(c.InterfaceC0084c interfaceC0084c) {
    }

    protected abstract void b();

    protected abstract void c();

    protected abstract void d();

    protected abstract void e();

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void e(boolean z) {
    }

    protected abstract void f();

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void f(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void i() {
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.n;
        if (dVar != null) {
            dVar.d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void j() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.i;
        if (hVar != null) {
            hVar.e();
            this.i.q();
            this.i.u();
        }
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.n;
        if (dVar != null) {
            dVar.a(false, this.p, !this.x);
            D();
        }
        if (this.v || !this.u) {
            return;
        }
        d();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void k() {
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.n;
        if (dVar != null) {
            dVar.c();
            this.n = null;
        }
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.i;
        if (hVar != null) {
            hVar.g();
        }
        ad adVar = this.k;
        if (adVar != null) {
            adVar.removeCallbacks(this.H);
            this.k.removeCallbacks(this.G);
            this.k.removeCallbacksAndMessages(null);
            E();
        }
        this.o = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void l() {
        k();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long m() {
        return this.p;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long n() {
        if (t() == null) {
            return 0L;
        }
        return t().n();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long o() {
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.n;
        if (dVar == null) {
            return 0L;
        }
        return dVar.o() + this.y;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long p() {
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.n;
        if (dVar == null) {
            return 0L;
        }
        return dVar.p() + this.y;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public int q() {
        return com.bytedance.sdk.openadsdk.core.video.f.a.a(this.q, this.f6448c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long r() {
        return this.f6448c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean s() {
        return this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public com.bytedance.sdk.openadsdk.core.video.e.d t() {
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public com.bytedance.sdk.openadsdk.core.video.nativevideo.h u() {
        return this.i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean v() {
        return this.B;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean w() {
        return this.E;
    }

    public void x() {
        if (this.v || !this.u) {
            return;
        }
        d();
    }

    public boolean y() {
        return this.n.l();
    }

    public boolean z() {
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.n;
        return dVar != null && dVar.g();
    }

    private void g(boolean z) {
        this.J = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b(boolean z) {
        this.w = z;
        this.i.c(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(long j) {
        this.f6448c = j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void d(boolean z) {
        this.B = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void e(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
        a(bVar, view, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void f(boolean z) {
        this.F = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void h() {
        this.h = o();
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.n;
        if (dVar != null) {
            dVar.b();
        }
        if (this.v || !this.u) {
            return;
        }
        c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(boolean z) {
        this.x = z;
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.n;
        if (dVar != null) {
            dVar.a(z);
        }
    }

    public void d(long j) {
        this.p = j;
        long j2 = this.q;
        long j3 = this.p;
        if (j2 <= j3) {
            j2 = j3;
        }
        this.q = j2;
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.i;
        if (hVar != null) {
            hVar.e();
        }
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.n;
        if (dVar != null) {
            dVar.a(true, this.p, !this.x);
            D();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void g() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.i;
        if (hVar != null) {
            hVar.b();
            this.i.e();
        }
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar2 = this.i;
        if (hVar2 != null) {
            hVar2.u();
        }
        d(-1L);
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.n;
        if (dVar != null) {
            dVar.m();
        }
    }

    @SuppressLint({"InflateParams"})
    private void a(Context context) {
        EnumSet enumSetNoneOf = EnumSet.noneOf(b.a.class);
        enumSetNoneOf.add(b.a.hideCloseBtn);
        enumSetNoneOf.add(b.a.hideBackBtn);
        this.i = new com.bytedance.sdk.openadsdk.core.video.nativevideo.h(context.getApplicationContext(), LayoutInflater.from(context.getApplicationContext()).inflate(t.f(context, "tt_video_play_layout_for_live"), (ViewGroup) null, false), true, enumSetNoneOf, this.f6447b, this);
        this.i.a(this);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b(long j) {
        this.y = j;
    }

    private void b(int i) {
        if (F() && this.i != null) {
            this.k.removeCallbacks(this.H);
            this.i.w();
            this.m = System.currentTimeMillis() - this.l;
            c.a aVar = this.o;
            if (aVar != null) {
                aVar.a(this.m, com.bytedance.sdk.openadsdk.core.video.f.a.a(this.p, this.f6448c));
            }
            if (ab.b(this.f6447b)) {
                this.i.a(this.f6447b, this.f6446a, true);
            }
            if (!this.v) {
                b();
                this.v = true;
                long j = this.f6448c;
                a(j, j);
                long j2 = this.f6448c;
                this.p = j2;
                this.q = j2;
            }
            this.B = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void c(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.i;
        if (hVar != null) {
            hVar.g();
        }
        a(true);
    }

    private boolean c(int i) {
        return this.i.b(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void d(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
        if (this.J) {
            g(false);
            com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.i;
            if (hVar != null) {
                hVar.b(this.j);
            }
            a(1);
            return;
        }
        a(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean a(String str, String str2, int i, int i2, List<String> list, String str3, long j, boolean z) {
        com.bytedance.sdk.openadsdk.utils.o.b("BaseVideoController", "video local url " + str);
        if (TextUtils.isEmpty(str)) {
            com.bytedance.sdk.openadsdk.utils.o.e("BaseVideoController", "No video info");
            return false;
        }
        this.g = !str.startsWith("http");
        this.x = z;
        if (j > 0) {
            this.p = j;
            long j2 = this.q;
            long j3 = this.p;
            if (j2 <= j3) {
                j2 = j3;
            }
            this.q = j2;
        }
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.i;
        if (hVar != null) {
            hVar.e();
            this.i.d();
            this.i.c(i, i2);
            this.i.c(this.j);
        }
        if (this.n == null) {
            this.n = new com.bytedance.sdk.openadsdk.core.video.e.d(this.k);
        }
        this.m = 0L;
        try {
            a(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean d(int i) {
        h hVar;
        int iC = q.c(o.a());
        if (iC != 4 && iC != 0) {
            h();
            this.z = true;
            this.A = false;
            com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar2 = this.i;
            if (hVar2 != null && (hVar = this.f6447b) != null) {
                return hVar2.a(i, hVar.v());
            }
        } else if (iC == 4) {
            this.z = false;
            com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar3 = this.i;
            if (hVar3 != null) {
                hVar3.q();
            }
        }
        return true;
    }

    private void b(Runnable runnable) {
        if (this.r == null) {
            this.r = new ArrayList<>();
        }
        this.r.add(runnable);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, int i) {
        if (this.n != null) {
            E();
        }
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.i;
        if (hVar != null) {
            hVar.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
        b(bVar, view, false, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(long j) {
        this.p = j;
        long j2 = this.q;
        long j3 = this.p;
        if (j2 <= j3) {
            j2 = j3;
        }
        this.q = j2;
    }

    public void b(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view, boolean z, boolean z2) {
        if (F()) {
            g(!this.J);
            if (!(this.f6446a.get() instanceof Activity)) {
                com.bytedance.sdk.openadsdk.utils.o.b("BaseVideoController", "context is not activity, not support this function.");
                return;
            }
            if (this.J) {
                a(z ? 8 : 0);
                com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.i;
                if (hVar != null) {
                    hVar.a(this.j);
                    this.i.b(false);
                }
            } else {
                a(1);
                com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar2 = this.i;
                if (hVar2 != null) {
                    hVar2.b(this.j);
                    this.i.b(false);
                }
            }
            WeakReference<com.bytedance.sdk.openadsdk.core.video.nativevideo.e> weakReference = this.C;
            com.bytedance.sdk.openadsdk.core.video.nativevideo.e eVar = weakReference != null ? weakReference.get() : null;
            if (eVar != null) {
                eVar.a(this.J);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(Map<String, Object> map) {
        this.f6449d = map;
    }

    private void a(String str) throws Exception {
        if (this.n != null) {
            com.bytedance.sdk.openadsdk.core.video.b.a aVar = new com.bytedance.sdk.openadsdk.core.video.b.a();
            aVar.f6419a = str;
            h hVar = this.f6447b;
            if (hVar != null) {
                if (hVar.v() != null) {
                    aVar.f6422d = this.f6447b.v().k();
                }
                aVar.f6420b = String.valueOf(ab.d(this.f6447b.M()));
            }
            aVar.f6421c = 1;
            this.n.a(aVar);
        }
        this.l = System.currentTimeMillis();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.i.d(8);
        this.i.d(0);
        a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.d.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.l = System.currentTimeMillis();
                a.this.i.c(0);
                if (a.this.n != null && a.this.p == 0) {
                    a.this.n.a(true, 0L, !a.this.x);
                } else if (a.this.n != null) {
                    a.this.n.a(true, a.this.p, !a.this.x);
                }
                if (a.this.k != null) {
                    a.this.k.postDelayed(a.this.G, 100L);
                }
                a.this.D();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceHolder surfaceHolder) {
        this.s = false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceTexture surfaceTexture) {
        this.s = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        int iC;
        if (F() && this.M != (iC = q.c(context))) {
            if (!this.A) {
                d(2);
            }
            this.M = iC;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.e eVar) {
        this.C = new WeakReference<>(eVar);
    }

    private void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (this.i.k() && this.s) {
            runnable.run();
        } else {
            b(runnable);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(c.a aVar) {
        this.o = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(boolean z) {
        k();
    }

    @Override // com.bytedance.sdk.openadsdk.utils.ad.a
    public void a(Message message) {
        WeakReference<Context> weakReference;
        if (this.i == null || message == null || (weakReference = this.f6446a) == null || weakReference.get() == null) {
            return;
        }
        int i = message.what;
        if (i == 108) {
            Object obj = message.obj;
            if (!(obj instanceof Long) || ((Long) obj).longValue() <= 0) {
                return;
            }
            this.f6448c = ((Long) message.obj).longValue();
            return;
        }
        if (i == 109) {
            Object obj2 = message.obj;
            if (obj2 instanceof Long) {
                this.p = ((Long) obj2).longValue();
                long j = this.q;
                long j2 = this.p;
                if (j <= j2) {
                    j = j2;
                }
                this.q = j;
                a(this.p, this.f6448c);
                return;
            }
            return;
        }
        if (i == 308) {
            a(308, 0);
            return;
        }
        if (i == 311) {
            h hVar = this.f6447b;
            if (hVar != null && hVar.g() == 0) {
                K();
                return;
            } else {
                J();
                return;
            }
        }
        if (i != 314) {
            switch (i) {
                case 302:
                    b(i);
                    break;
                case 303:
                    a(message.arg1, message.arg2);
                    this.k.removeCallbacks(this.H);
                    com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar2 = this.i;
                    if (hVar2 != null) {
                        hVar2.w();
                    }
                    c.a aVar = this.o;
                    if (aVar != null) {
                        aVar.b(this.m, com.bytedance.sdk.openadsdk.core.video.f.a.a(this.p, this.f6448c));
                    }
                    break;
                case 304:
                    int i2 = message.arg1;
                    com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar3 = this.i;
                    if (hVar3 != null) {
                        if (i2 == 3 || i2 == 702) {
                            this.i.w();
                            this.k.removeCallbacks(this.H);
                            this.E = false;
                        } else if (i2 == 701) {
                            hVar3.t();
                            C();
                            this.E = true;
                        }
                    }
                    if (this.t && i2 == 3 && !this.u) {
                        this.f6451f = SystemClock.elapsedRealtime() - this.f6450e;
                        c.a aVar2 = this.o;
                        if (aVar2 != null) {
                            aVar2.b();
                        }
                        e();
                        H();
                        this.u = true;
                        break;
                    }
                    break;
                case 305:
                    ad adVar = this.k;
                    if (adVar != null) {
                        adVar.removeCallbacks(this.H);
                    }
                    if (!this.t && !this.u) {
                        this.f6451f = SystemClock.elapsedRealtime() - this.f6450e;
                        f();
                        this.u = true;
                    }
                    com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar4 = this.i;
                    if (hVar4 != null) {
                        hVar4.w();
                    }
                    break;
                case 306:
                    this.k.removeCallbacks(this.H);
                    com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar5 = this.i;
                    if (hVar5 != null) {
                        hVar5.w();
                    }
                    break;
            }
            return;
        }
        this.f6450e = SystemClock.elapsedRealtime();
    }

    private void a(float f2, float f3, float f4, float f5, boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        try {
            com.bytedance.sdk.openadsdk.utils.o.b("changeVideoSize", "screenWidth=" + f2 + ",screenHeight=" + f3);
            com.bytedance.sdk.openadsdk.utils.o.b("changeVideoSize", "videoHeight=" + f5 + ",videoWidth=" + f4);
            if (f4 <= WheelView.DividerConfig.FILL || f5 <= WheelView.DividerConfig.FILL) {
                f4 = this.f6447b.v().c();
                f5 = this.f6447b.v().b();
            }
            if (f5 > WheelView.DividerConfig.FILL && f4 > WheelView.DividerConfig.FILL) {
                if (z) {
                    if (f4 < f5) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.utils.o.b("changeVideoSize", "竖屏模式下按视频宽度计算放大倍数值");
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) f2, (int) ((f5 * f2) / f4));
                    layoutParams2.addRule(13);
                    layoutParams = layoutParams2;
                } else {
                    if (f4 > f5) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.utils.o.b("changeVideoSize", "横屏模式下按视频高度计算放大倍数值");
                    layoutParams = new RelativeLayout.LayoutParams((int) ((f4 * f3) / f5), (int) f3);
                    layoutParams.addRule(13);
                }
                if (L() != null) {
                    if (L() instanceof TextureView) {
                        ((TextureView) L()).setLayoutParams(layoutParams);
                    } else if (L() instanceof SurfaceView) {
                        ((SurfaceView) L()).setLayoutParams(layoutParams);
                    }
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.o.a("changeVideoSize", "changeSize error", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
        if (this.n == null || !F()) {
            return;
        }
        if (this.n.g()) {
            h();
            this.i.b(true, false);
            this.i.c();
            return;
        }
        if (!this.n.i()) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.i;
            if (hVar != null) {
                hVar.c(this.j);
            }
            d(this.p);
            com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar2 = this.i;
            if (hVar2 != null) {
                hVar2.b(false, false);
                return;
            }
            return;
        }
        j();
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar3 = this.i;
        if (hVar3 != null) {
            hVar3.b(false, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, int i) {
        if (this.n == null) {
            return;
        }
        D();
        a(this.K, c(i));
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, int i, boolean z) {
        if (F()) {
            long jL = (long) (((((long) i) * this.f6448c) * 1.0f) / t.l(this.f6446a.get(), "tt_video_progress_max"));
            if (this.f6448c > 0) {
                this.K = (int) jL;
            } else {
                this.K = 0L;
            }
            com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.i;
            if (hVar != null) {
                hVar.a(this.K);
            }
        }
    }

    private void a(long j, long j2) {
        this.p = j;
        this.f6448c = j2;
        this.i.a(j, j2);
        this.i.a(com.bytedance.sdk.openadsdk.core.video.f.a.a(j, j2));
        try {
            if (this.o != null) {
                this.o.a(j, j2);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.o.c("BaseVideoController", "onProgressUpdate error: ", th);
        }
    }

    public void a(int i) {
        if (F()) {
            boolean z = i == 0 || i == 8;
            Context context = this.f6446a.get();
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                try {
                    activity.setRequestedOrientation(i);
                } catch (Throwable unused) {
                }
                if (!z) {
                    activity.getWindow().setFlags(1024, 1024);
                } else {
                    activity.getWindow().clearFlags(1024);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view, boolean z, boolean z2) {
        if (this.w) {
            h();
        }
        if (z && !this.w && !y()) {
            this.i.b(!z(), false);
            this.i.a(z2, true, false);
        }
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.n;
        if (dVar != null && dVar.g()) {
            this.i.c();
            this.i.b();
        } else {
            this.i.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceHolder surfaceHolder) {
        this.s = true;
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.n;
        if (dVar == null) {
            return;
        }
        dVar.a(surfaceHolder);
        G();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceTexture surfaceTexture) {
        this.s = true;
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.n;
        if (dVar == null) {
            return;
        }
        dVar.a(surfaceTexture);
        G();
    }

    private void a(long j, boolean z) {
        if (this.n == null) {
            return;
        }
        if (z) {
            M();
        }
        this.n.a(j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.d
    public void a(e.a aVar, String str) {
        int i = AnonymousClass6.f6457a[aVar.ordinal()];
        if (i == 1) {
            h();
            return;
        }
        if (i == 2) {
            a(true);
        } else {
            if (i != 3) {
                return;
            }
            j();
            this.z = false;
            this.A = true;
        }
    }
}
