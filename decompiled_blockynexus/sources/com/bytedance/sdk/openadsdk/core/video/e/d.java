package com.bytedance.sdk.openadsdk.core.video.e;

import android.annotation.SuppressLint;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.SparseIntArray;
import android.view.SurfaceHolder;
import cn.qqtheme.framework.widget.WheelView;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.e.c;
import com.bytedance.sdk.openadsdk.utils.ad;
import io.rong.common.LibStorageUtils;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: SSMediaPlayerWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements c.a, c.b, c.InterfaceC0082c, c.d, c.e, c.f, c.g, ad.a {
    private static boolean m;
    private static final SparseIntArray o = new SparseIntArray();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f6472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f6473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f6475d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f6476e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f6477f;
    private long g;
    private final Handler h;
    private Handler i;
    private ArrayList<Runnable> j;
    private int k;
    private int l;
    private String n;
    private boolean p;
    private final Object q;
    private StringBuilder r;
    private boolean s;
    private long t;
    private long u;
    private long v;
    private long w;
    private boolean x;

    public d(Handler handler) {
        this(handler, -1);
    }

    private int A() {
        AudioManager audioManager = (AudioManager) o.a().getSystemService(LibStorageUtils.AUDIO);
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return -1;
    }

    private void B() {
        if (m) {
            a(this.l, false);
            m = false;
        }
    }

    private void C() {
        if (this.u <= 0) {
            this.u = System.currentTimeMillis();
        }
    }

    private void D() {
        if (this.u > 0) {
            this.t += System.currentTimeMillis() - this.u;
            this.u = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.f6472a == null) {
            com.bytedance.sdk.openadsdk.utils.o.b("SSMediaPlayeWrapper", "SSMediaPlayerWrapper use System Mediaplayer");
            this.f6472a = new b();
            this.n = "0";
            this.f6472a.a((c.e) this);
            this.f6472a.a((c.b) this);
            this.f6472a.a((c.InterfaceC0082c) this);
            this.f6472a.a((c.a) this);
            this.f6472a.a((c.f) this);
            this.f6472a.a((c.d) this);
            this.f6472a.a((c.g) this);
            try {
                this.f6472a.b(this.f6473b);
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.o.a("SSMediaPlayeWrapper", "setLooping error: ", th);
            }
            this.f6474c = false;
        }
    }

    private void r() {
        com.bytedance.sdk.openadsdk.utils.o.b("tag_video_play", "[video] MediaPlayerProxy#start first play prepare invoke !");
        b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.e.d.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.h != null) {
                    d.this.h.sendEmptyMessage(104);
                    com.bytedance.sdk.openadsdk.utils.o.b("tag_video_play", "[video] MediaPlayerProxy#start first play prepare invoke ! sendMsg --> OP_PREPARE_ASYNC");
                }
            }
        });
    }

    private void s() {
        c cVar = this.f6472a;
        if (cVar == null) {
            return;
        }
        try {
            cVar.l();
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.o.a("SSMediaPlayeWrapper", "releaseMediaplayer error1: ", th);
        }
        this.f6472a.a((c.b) null);
        this.f6472a.a((c.g) null);
        this.f6472a.a((c.a) null);
        this.f6472a.a((c.d) null);
        this.f6472a.a((c.InterfaceC0082c) null);
        this.f6472a.a((c.e) null);
        this.f6472a.a((c.f) null);
        try {
            this.f6472a.k();
        } catch (Throwable th2) {
            com.bytedance.sdk.openadsdk.utils.o.a("SSMediaPlayeWrapper", "releaseMediaplayer error2: ", th2);
        }
    }

    private void t() {
        Handler handler = this.h;
        if (handler == null || handler.getLooper() == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.utils.o.b("SSMediaPlayeWrapper", "onDestory............");
            this.h.getLooper().quit();
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.o.a("SSMediaPlayeWrapper", "onDestroy error: ", th);
        }
    }

    private void u() {
        Integer numValueOf = Integer.valueOf(o.get(this.k));
        if (numValueOf == null) {
            o.put(this.k, 1);
        } else {
            o.put(this.k, Integer.valueOf(numValueOf.intValue() + 1).intValue());
        }
    }

    private void v() {
        if (this.x || this.u > 0) {
            return;
        }
        this.u = System.currentTimeMillis();
    }

    private void w() {
        if (this.f6475d) {
            return;
        }
        this.f6475d = true;
        Iterator it = new ArrayList(this.j).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.j.clear();
        this.f6475d = false;
    }

    private void x() {
        ArrayList<Runnable> arrayList = this.j;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        w();
    }

    private void y() {
        ArrayList<Runnable> arrayList = this.j;
        if (arrayList == null || arrayList.isEmpty()) {
            t();
        } else {
            w();
        }
    }

    private void z() {
        ArrayList<Runnable> arrayList = this.j;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.j.clear();
    }

    public void d() {
        b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.e.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.h != null) {
                    d.this.h.sendEmptyMessage(105);
                }
            }
        });
    }

    public void e() {
        Handler handler = this.h;
        if (handler != null) {
            handler.obtainMessage(108).sendToTarget();
        }
    }

    public void f() {
        Handler handler = this.h;
        if (handler != null) {
            handler.obtainMessage(109).sendToTarget();
        }
    }

    public boolean g() {
        return (this.f6477f == 206 || this.h.hasMessages(100)) && !this.p;
    }

    public boolean h() {
        return k() || g() || i();
    }

    public boolean i() {
        return (this.f6477f == 207 || this.p) && !this.h.hasMessages(100);
    }

    public boolean j() {
        return this.f6477f == 203;
    }

    public boolean k() {
        return this.f6477f == 205;
    }

    public boolean l() {
        return this.f6477f == 209;
    }

    public void m() {
        this.t = 0L;
        this.u = System.currentTimeMillis();
    }

    public long n() {
        return this.w;
    }

    public long o() {
        D();
        return this.t;
    }

    public long p() {
        if (this.u > 0) {
            this.t += System.currentTimeMillis() - this.u;
            this.u = System.currentTimeMillis();
        }
        return this.t;
    }

    @SuppressLint({"unused"})
    public d(Handler handler, int i) {
        this.f6472a = null;
        this.f6473b = false;
        this.f6474c = false;
        this.f6477f = 201;
        this.g = -1L;
        this.k = 0;
        this.n = "0";
        this.q = new Object();
        this.r = null;
        this.s = false;
        this.t = 0L;
        this.u = 0L;
        this.v = 0L;
        this.w = 0L;
        this.x = false;
        this.k = 0;
        this.i = handler;
        HandlerThread handlerThread = new HandlerThread("VideoManager");
        handlerThread.start();
        this.h = new ad(handlerThread.getLooper(), this);
        this.x = Build.VERSION.SDK_INT >= 17;
        q();
    }

    public void b() {
        this.h.removeMessages(100);
        this.p = true;
        this.h.sendEmptyMessage(101);
        D();
    }

    public void c() {
        this.f6477f = 203;
        D();
        z();
        if (this.h != null) {
            try {
                b("release");
                this.h.removeCallbacksAndMessages(null);
                if (this.f6472a != null) {
                    this.f6476e = true;
                    this.h.sendEmptyMessage(103);
                }
            } catch (Throwable th) {
                t();
                com.bytedance.sdk.openadsdk.utils.o.a("SSMediaPlayeWrapper", "release error: ", th);
            }
        }
    }

    public MediaPlayer a() throws Throwable {
        c cVar = this.f6472a;
        if (cVar != null) {
            return ((b) cVar).e();
        }
        return null;
    }

    public void a(boolean z, long j, boolean z2) {
        com.bytedance.sdk.openadsdk.utils.o.b("tag_video_play", "[video] MediaPlayerProxy#start firstSeekToPosition=" + j + ",firstPlay :" + z + ",isPauseOtherMusicVolume=" + z2);
        this.p = false;
        if (!z2) {
            if (this.f6472a != null) {
                a(true);
            }
        } else if (this.f6472a != null) {
            a(false);
        }
        if (z) {
            r();
            this.g = j;
            return;
        }
        C();
        c cVar = this.f6472a;
        if (cVar != null) {
            try {
                if (j <= cVar.i()) {
                    j = this.f6472a.i();
                }
                this.g = j;
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.o.b("tag_video_play", "[video] MediaPlayerProxy#start  error: getCurrentPosition :" + th.toString());
            }
        }
        b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.e.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.h.sendEmptyMessageDelayed(100, 0L);
                com.bytedance.sdk.openadsdk.utils.o.b("tag_video_play", "[video] MediaPlayerProxy#start not first play ! sendMsg --> OP_START , video start to play !");
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c.d
    public boolean b(c cVar, int i, int i2) {
        com.bytedance.sdk.openadsdk.utils.o.e("SSMediaPlayeWrapper", "what,extra:" + i + "," + i2);
        if (this.f6472a != cVar) {
            return false;
        }
        Handler handler = this.i;
        if (handler != null) {
            handler.obtainMessage(304, i, i2).sendToTarget();
            if (i2 == -1004) {
                this.i.obtainMessage(303, i, i2).sendToTarget();
            }
        }
        b(i, i2);
        return false;
    }

    private void b(int i, int i2) {
        if (i == 701) {
            D();
            this.v = SystemClock.elapsedRealtime();
            return;
        }
        if (i != 702) {
            if (this.x && i == 3 && this.u <= 0) {
                this.u = System.currentTimeMillis();
                return;
            }
            return;
        }
        if (this.u <= 0) {
            this.u = System.currentTimeMillis();
        }
        if (this.v > 0) {
            this.w += SystemClock.elapsedRealtime() - this.v;
            this.v = 0L;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c.f
    public void c(c cVar) {
        Handler handler = this.i;
        if (handler != null) {
            handler.sendEmptyMessage(306);
        }
    }

    public void a(final long j) {
        D();
        int i = this.f6477f;
        if (i == 207 || i == 206 || i == 209) {
            b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.e.d.4
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.h != null) {
                        d.this.h.obtainMessage(106, Long.valueOf(j)).sendToTarget();
                    }
                }
            });
        }
    }

    public void a(final SurfaceTexture surfaceTexture) {
        b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.e.d.5
            @Override // java.lang.Runnable
            public void run() {
                d.this.q();
                if (d.this.h != null) {
                    d.this.h.obtainMessage(111, surfaceTexture).sendToTarget();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c.e
    public void b(c cVar) {
        this.f6477f = 205;
        if (this.p) {
            this.h.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.e.d.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        d.this.f6472a.h();
                        d.this.f6477f = 207;
                        d.this.p = false;
                    } catch (Throwable th) {
                        com.bytedance.sdk.openadsdk.utils.o.a("SSMediaPlayeWrapper", "onPrepared error: ", th);
                    }
                }
            });
        } else {
            Handler handler = this.h;
            handler.sendMessage(handler.obtainMessage(100, -1, -1));
        }
        o.delete(this.k);
        Handler handler2 = this.i;
        if (handler2 != null) {
            handler2.sendEmptyMessage(305);
        }
        v();
    }

    public void a(final SurfaceHolder surfaceHolder) {
        b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.e.d.6
            @Override // java.lang.Runnable
            public void run() {
                d.this.q();
                if (d.this.h != null) {
                    d.this.h.obtainMessage(110, surfaceHolder).sendToTarget();
                }
            }
        });
    }

    public void a(final com.bytedance.sdk.openadsdk.core.video.b.a aVar) {
        b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.e.d.7
            @Override // java.lang.Runnable
            public void run() {
                d.this.q();
                if (d.this.h != null) {
                    d.this.h.obtainMessage(107, aVar).sendToTarget();
                }
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01dc  */
    @Override // com.bytedance.sdk.openadsdk.utils.ad.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.os.Message r19) {
        /*
            Method dump skipped, instruction units count: 716
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.e.d.a(android.os.Message):void");
    }

    private void b(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (!this.f6476e) {
            runnable.run();
        } else {
            a(runnable);
        }
    }

    private void b(String str) {
        Handler handler = this.h;
        if (handler != null) {
            handler.removeMessages(201);
        }
        synchronized (this.q) {
            if (this.r != null) {
                this.r = null;
            }
        }
    }

    private void a(String str) throws Throwable {
        FileInputStream fileInputStream = new FileInputStream(str);
        this.f6472a.a(fileInputStream.getFD());
        fileInputStream.close();
    }

    private void a(int i, Object obj) {
        if (i == 309) {
            B();
        }
        Handler handler = this.i;
        if (handler != null) {
            handler.obtainMessage(i, obj).sendToTarget();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c.a
    public void a(c cVar, int i) {
        Handler handler;
        if (this.f6472a == cVar && (handler = this.i) != null) {
            handler.obtainMessage(301, Integer.valueOf(i)).sendToTarget();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c.b
    public void a(c cVar) {
        this.f6477f = !this.f6473b ? 209 : 206;
        o.delete(this.k);
        Handler handler = this.i;
        if (handler != null) {
            handler.obtainMessage(302).sendToTarget();
        }
        b("completion");
        D();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c.InterfaceC0082c
    public boolean a(c cVar, int i, int i2) {
        com.bytedance.sdk.openadsdk.utils.o.e("SSMediaPlayeWrapper", "what=" + i + "extra=" + i2);
        u();
        this.f6477f = 200;
        Handler handler = this.i;
        if (handler != null) {
            handler.obtainMessage(303, i, i2).sendToTarget();
        }
        Handler handler2 = this.h;
        if (handler2 != null) {
            handler2.removeMessages(108);
            this.h.removeMessages(109);
        }
        if (!this.f6474c) {
            a(308, Integer.valueOf(i));
            this.f6474c = true;
        }
        if (a(i, i2)) {
            t();
        }
        return true;
    }

    private boolean a(int i, int i2) {
        com.bytedance.sdk.openadsdk.utils.o.b("SSMediaPlayeWrapper", "OnError - Error code: " + i + " Extra code: " + i2);
        boolean z = i == -1010 || i == -1007 || i == -1004 || i == -110 || i == 100 || i == 200;
        if (i2 == 1 || i2 == 700 || i2 == 800) {
            return true;
        }
        return z;
    }

    private void a(Runnable runnable) {
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.add(runnable);
    }

    private void a(int i, boolean z) {
        int iA;
        if (z && (iA = A()) != i) {
            m = true;
            this.l = iA;
        }
        AudioManager audioManager = (AudioManager) o.a().getSystemService(LibStorageUtils.AUDIO);
        if (audioManager != null) {
            audioManager.setStreamVolume(3, i, 0);
        }
    }

    public void a(boolean z) {
        try {
            if (z) {
                this.f6472a.a(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL);
            } else {
                this.f6472a.a(1.0f, 1.0f);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.o.a("SSMediaPlayeWrapper", "setQuietPlay error: ", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.e.c.g
    public void a(c cVar, int i, int i2, int i3, int i4) {
        Handler handler = this.i;
        if (handler != null) {
            handler.obtainMessage(311, i, i2).sendToTarget();
        }
    }
}
