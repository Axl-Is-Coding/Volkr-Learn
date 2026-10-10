package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.b;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.w;
import com.bytedance.sdk.openadsdk.core.widget.e;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.o;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.t;
import com.localapi.Tribe;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: NativeVideoController.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements c, d, ad.a {
    private WeakReference<c.InterfaceC0084c> C;
    private WeakReference<a> D;
    private int E;
    private int F;
    private long R;
    private int T;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h f6507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WeakReference<ViewGroup> f6508c;
    private com.bytedance.sdk.openadsdk.core.video.e.d g;
    private c.a h;
    private long k;
    private List<Runnable> l;
    private boolean m;
    private final WeakReference<Context> n;
    private final boolean o;
    private final com.bytedance.sdk.openadsdk.core.d.h r;
    private String u;
    private WeakReference<e> v;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ad f6509d = new ad(this);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f6510e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f6511f = 0;
    private long i = 0;
    private long j = 0;
    private boolean p = false;
    private boolean q = false;
    private boolean s = true;
    private boolean t = false;
    private long w = 0;
    private boolean x = false;
    private boolean y = false;
    private boolean z = false;
    private boolean A = false;
    private boolean B = true;
    private int G = 0;
    private boolean H = false;
    private boolean I = true;
    private final Runnable J = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.3
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.g != null) {
                f.this.g.e();
            }
        }
    };
    private final Runnable K = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.4
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.h != null) {
                f.this.h.a();
            }
        }
    };
    private final Runnable L = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.5
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.g != null) {
                if (f.this.k <= 0) {
                    f.this.g.e();
                }
                f.this.g.f();
            }
            f.this.f6509d.postDelayed(this, 200L);
        }
    };
    private int M = 0;
    private long N = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Runnable f6506a = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.6
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f6507b != null) {
                f.this.f6507b.a(f.this.r, f.this.n, false);
                f.this.f6507b.w();
                f.this.d(true);
                o.e("NativeVideoController", "出错后展示结果页、、、、、、、showAdCard");
            }
        }
    };
    private long O = 0;
    private long P = 0;
    private boolean Q = false;
    private final BroadcastReceiver S = new BroadcastReceiver() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.7
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                f.this.h();
            } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                f.this.d(context);
            }
        }
    };
    private boolean U = false;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.video.nativevideo.f$8, reason: invalid class name */
    /* JADX INFO: compiled from: NativeVideoController.java */
    static /* synthetic */ class AnonymousClass8 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6520a = new int[e.a.values().length];

        static {
            try {
                f6520a[e.a.PAUSE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6520a[e.a.RELEASE_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6520a[e.a.START_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: NativeVideoController.java */
    public interface a {
        void a(int i);

        void f();
    }

    public f(Context context, ViewGroup viewGroup, com.bytedance.sdk.openadsdk.core.d.h hVar, String str, boolean z) {
        this.u = "embeded_ad";
        this.E = 0;
        this.F = 0;
        this.T = 1;
        this.T = q.c(context);
        b(z);
        this.u = str;
        try {
            this.E = viewGroup.getWidth();
            this.F = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        this.f6508c = new WeakReference<>(viewGroup);
        this.n = new WeakReference<>(context);
        this.r = hVar;
        b(context);
        this.o = Build.VERSION.SDK_INT >= 17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        B();
        this.f6509d.postDelayed(this.L, 800L);
    }

    private void B() {
        this.f6509d.removeCallbacks(this.L);
    }

    private boolean C() {
        WeakReference<Context> weakReference = this.n;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    private void D() {
        List<Runnable> list = this.l;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = new ArrayList(this.l).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.l.clear();
    }

    private void E() {
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.g;
        if (dVar != null) {
            dVar.a(false, this.i, !this.t);
            A();
        }
        if (this.p) {
            com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_continue", o(), q(), c());
        }
    }

    private void F() {
        this.P = SystemClock.elapsedRealtime() - this.O;
        if (this.p) {
            return;
        }
        Map<String, Object> mapA = ab.a(this.P, this.r, t());
        if (this.B) {
            com.bytedance.sdk.openadsdk.c.d.b(this.n.get(), this.r, this.u, "feed_auto_play", mapA);
        } else if (this.i <= 0) {
            com.bytedance.sdk.openadsdk.c.d.b(this.n.get(), this.r, this.u, "feed_play", mapA);
        }
        this.p = true;
    }

    private void G() {
        if (this.f6508c.get() == null || w.a(this.f6508c.get(), 20, 0)) {
            return;
        }
        o.e("NativeVideoController", "onStateError 出错后展示结果页、、、、、、、");
        this.f6507b.a(this.r, this.n, false);
        d(true);
        l();
    }

    private void H() {
        o.b("NativeVideoController", "before auseWhenInvisible、、、、、、、");
        if (this.f6508c.get() == null || w.a(this.f6508c.get(), 20, 0)) {
            return;
        }
        o.b("NativeVideoController", "in pauseWhenInvisible、、、、、、、");
        d();
    }

    private void I() {
        int i;
        int i2;
        o.b("ChangeVideoSize", "[step-0]  TAG is 'ChangeVideoSize' ....... start  changeVideoSize >>>>>>>>>>>>>>>>>>>>>>>");
        try {
            if (this.n != null && this.n.get() != null && J() != null && this.g != null && this.g.a() != null && this.f6508c != null && this.f6508c.get() != null) {
                MediaPlayer mediaPlayerA = this.g.a();
                int videoWidth = mediaPlayerA.getVideoWidth();
                int videoHeight = mediaPlayerA.getVideoHeight();
                int width = this.f6508c.get().getWidth();
                int height = this.f6508c.get().getHeight();
                if (width <= 0 || height <= 0 || videoHeight <= 0 || videoWidth <= 0) {
                    o.b("ChangeVideoSize", " container or video exist size <= 0");
                    return;
                }
                if (videoWidth == videoHeight) {
                    i2 = width > height ? height : width;
                    i = i2;
                } else if (videoWidth > videoHeight) {
                    double d2 = width;
                    Double.isNaN(d2);
                    double d3 = (videoWidth * 1.0f) / videoHeight;
                    Double.isNaN(d3);
                    i2 = (int) ((d2 * 1.0d) / d3);
                    i = width;
                } else {
                    double d4 = height;
                    Double.isNaN(d4);
                    double d5 = (videoHeight * 1.0f) / videoWidth;
                    Double.isNaN(d5);
                    i = (int) ((d4 * 1.0d) / d5);
                    i2 = height;
                }
                if (i2 > height || i2 <= 0) {
                    i2 = height;
                }
                if (i > width || i <= 0) {
                    i = width;
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i2);
                layoutParams.addRule(13);
                if (J() instanceof TextureView) {
                    ((TextureView) J()).setLayoutParams(layoutParams);
                    o.b("ChangeVideoSize", "[step-9] >>>>> setLayoutParams to TextureView complete ! >>>>>>>");
                    return;
                } else {
                    if (J() instanceof SurfaceView) {
                        ((SurfaceView) J()).setLayoutParams(layoutParams);
                        o.b("ChangeVideoSize", "[step-9] >>>>> setLayoutParams to SurfaceView complete !>>>>>>>");
                        return;
                    }
                    return;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[step-1] >>>>> mContextRef=");
            sb.append(this.n);
            sb.append(",mContextRef.get()=");
            sb.append(this.n != null ? this.n.get() : null);
            sb.append(",getIRenderView() =");
            sb.append(J());
            o.b("ChangeVideoSize", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[step-1] >>>>> mMediaPlayerProxy == null:");
            boolean z = true;
            sb2.append(this.g == null);
            sb2.append(",mMediaPlayerProxy.getMediaPlayer() == null:");
            if (this.g == null || this.g.a() != null) {
                z = false;
            }
            sb2.append(z);
            o.b("ChangeVideoSize", sb2.toString());
        } catch (Throwable th) {
            o.b("ChangeVideoSize", "[step-11] >>>>> changeVideoSize error !!!!! ：" + th.toString());
        }
    }

    private com.bytedance.sdk.openadsdk.core.video.renderview.b J() {
        h hVar;
        WeakReference<Context> weakReference = this.n;
        if (weakReference == null || weakReference.get() == null || this.n.get().getResources().getConfiguration().orientation != 1 || (hVar = this.f6507b) == null) {
            return null;
        }
        return hVar.o();
    }

    private void K() {
        if (C()) {
            h(!this.Q);
            if (!(this.n.get() instanceof Activity)) {
                o.b("NativeVideoController", "context is not activity, not support this function.");
                return;
            }
            h hVar = this.f6507b;
            if (hVar != null) {
                hVar.b(this.f6508c.get());
                this.f6507b.b(false);
            }
            a(1);
            WeakReference<e> weakReference = this.v;
            e eVar = weakReference != null ? weakReference.get() : null;
            if (eVar != null) {
                eVar.a(this.Q);
            }
        }
    }

    private void L() {
        h hVar = this.f6507b;
        if (hVar != null) {
            hVar.c(0);
            this.f6507b.a(false, false);
            this.f6507b.b(false);
            this.f6507b.b();
            this.f6507b.d();
        }
    }

    private void M() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.r;
        if (hVar != null) {
            com.bytedance.sdk.openadsdk.core.o.g().a(com.bytedance.sdk.openadsdk.j.e.a(hVar.F(), true, this.r));
        }
    }

    private boolean z() {
        o.b("NativeVideoController", "retryCount=" + this.G);
        int i = this.G;
        if (1 <= i) {
            h hVar = this.f6507b;
            if (hVar != null) {
                hVar.w();
                this.f6507b.a(this.r, this.n, false);
            }
            return false;
        }
        if (this.g == null) {
            return false;
        }
        this.G = i + 1;
        o.b("NativeVideoController", "isPlaying=" + this.g.g() + ",isPaused=" + this.g.i() + ",isPrepared=" + this.g.k() + ",isStarted=" + this.g.h());
        return (this.g.g() && this.g.i() && this.g.k() && this.g.h()) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(Map<String, Object> map) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void f(b bVar, View view) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void l() {
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.g;
        if (dVar != null) {
            dVar.c();
            this.g = null;
        }
        if (!ab.a(this.r) || this.M == 2) {
            this.f6507b.a(this.r, this.n, true);
        }
        ad adVar = this.f6509d;
        if (adVar != null) {
            adVar.removeCallbacks(this.L);
            this.f6509d.removeCallbacks(this.K);
            this.f6509d.removeCallbacks(this.J);
            this.f6509d.removeCallbacksAndMessages(null);
        }
        B();
        List<Runnable> list = this.l;
        if (list != null) {
            list.clear();
        }
        if (this.s) {
            y();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long m() {
        return this.i;
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
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.g;
        if (dVar == null) {
            return 0L;
        }
        return dVar.o() + this.w;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long p() {
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public int q() {
        return com.bytedance.sdk.openadsdk.core.video.f.a.a(this.j, this.k);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long r() {
        return this.k;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean s() {
        return this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public com.bytedance.sdk.openadsdk.core.video.e.d t() {
        return this.g;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public h u() {
        return this.f6507b;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean v() {
        return this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean w() {
        return this.H;
    }

    public void x() {
        if (this.U || !this.I) {
            return;
        }
        Context applicationContext = com.bytedance.sdk.openadsdk.core.o.a().getApplicationContext();
        this.U = true;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            applicationContext.registerReceiver(this.S, intentFilter);
        } catch (Exception unused) {
        }
    }

    public void y() {
        if (this.U && this.I) {
            Context applicationContext = com.bytedance.sdk.openadsdk.core.o.a().getApplicationContext();
            this.U = false;
            try {
                applicationContext.unregisterReceiver(this.S);
            } catch (Exception unused) {
            }
        }
    }

    @SuppressLint({"InflateParams"})
    private void b(Context context) {
        EnumSet enumSetNoneOf = EnumSet.noneOf(b.a.class);
        enumSetNoneOf.add(b.a.hideCloseBtn);
        enumSetNoneOf.add(b.a.hideBackBtn);
        View viewC = this.s ? c(context) : LayoutInflater.from(context.getApplicationContext()).inflate(t.f(context, "tt_video_detail_layout"), (ViewGroup) null, false);
        if (viewC == null) {
            return;
        }
        if (this.s) {
            this.f6507b = new h(context, viewC, true, enumSetNoneOf, this.r, this, a());
        } else {
            this.f6507b = new g(context, viewC, true, enumSetNoneOf, this.r, this, false);
        }
        this.f6507b.a(this);
    }

    private View c(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(t.e(context, "tt_root_view"));
        relativeLayout.setBackgroundColor(-16777216);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout2.setId(t.e(context, "tt_video_loading_retry_layout"));
        relativeLayout2.setBackgroundColor(0);
        relativeLayout2.setGravity(17);
        relativeLayout2.setLayoutParams(layoutParams);
        relativeLayout.addView(relativeLayout2);
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        imageView.setId(t.e(context, "tt_video_loading_cover_image"));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(layoutParams2);
        relativeLayout2.addView(imageView);
        ProgressBar progressBar = new ProgressBar(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        progressBar.setId(t.e(context, "tt_video_loading_progress"));
        layoutParams3.addRule(13, -1);
        progressBar.setLayoutParams(layoutParams3);
        progressBar.setIndeterminateDrawable(t.c(context, "tt_video_loading_progress_bar"));
        relativeLayout2.addView(progressBar);
        ImageView imageView2 = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        imageView2.setId(t.e(context, "tt_video_play"));
        layoutParams4.addRule(13, -1);
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        imageView2.setImageResource(t.d(context, "tt_play_movebar_textpage"));
        imageView2.setVisibility(8);
        imageView2.setLayoutParams(layoutParams4);
        relativeLayout.addView(imageView2);
        ProgressBar progressBar2 = new ProgressBar(context, null, t.g(context, "tt_Widget_ProgressBar_Horizontal"));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 1.5f, resources.getDisplayMetrics()));
        progressBar2.setMax(100);
        progressBar2.setId(t.e(context, "tt_video_progress"));
        progressBar2.setBackgroundColor(0);
        progressBar2.setIndeterminateDrawable(null);
        progressBar2.setProgressDrawable(t.c(context, "tt_video_progress_drawable"));
        progressBar2.setVisibility(8);
        layoutParams5.addRule(12, -1);
        progressBar2.setLayoutParams(layoutParams5);
        relativeLayout.addView(progressBar2);
        ViewStub viewStub = new ViewStub(context);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -1);
        viewStub.setId(t.e(context, "tt_video_ad_cover"));
        viewStub.setLayoutParams(layoutParams6);
        viewStub.setLayoutResource(t.f(context, "tt_video_ad_cover_layout"));
        relativeLayout.addView(viewStub);
        ViewStub viewStub2 = new ViewStub(context);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(13, -1);
        viewStub2.setId(t.e(context, "tt_video_draw_layout_viewStub"));
        viewStub2.setLayoutParams(layoutParams7);
        viewStub2.setLayoutResource(t.f(context, "tt_video_draw_btn_layout"));
        relativeLayout.addView(viewStub2);
        return relativeLayout;
    }

    public void d() {
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.g;
        if (dVar != null) {
            dVar.b();
        }
    }

    public void e(long j) {
        this.N = j;
    }

    public boolean f() {
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.g;
        return dVar != null && dVar.g();
    }

    public void g(boolean z) {
        h hVar = this.f6507b;
        if (hVar != null) {
            hVar.e();
        }
        h hVar2 = this.f6507b;
        if (hVar2 != null && z) {
            hVar2.u();
        }
        E();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void h() {
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.g;
        if (dVar != null) {
            dVar.b();
        }
        if (this.q || !this.p) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            if (com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_single_app_data_class", "IsCanLoadPauseLog", true)) {
                com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_pause", o(), q(), c());
            }
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_single_app_data_class", "IsCanLoadPauseLog", (Boolean) true);
        } else {
            if (s.a().b()) {
                com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_pause", o(), q(), c());
            }
            s.a().a(true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void i() {
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.g;
        if (dVar != null) {
            dVar.d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void j() {
        h hVar = this.f6507b;
        if (hVar != null) {
            hVar.e();
        }
        h hVar2 = this.f6507b;
        if (hVar2 != null) {
            hVar2.u();
        }
        E();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void k() {
        a(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void e(b bVar, View view) {
        a(bVar, view, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void f(boolean z) {
        this.I = z;
    }

    public void a(final NativeVideoTsView.b bVar) {
        h hVar;
        if (!this.s || (hVar = this.f6507b) == null) {
            return;
        }
        hVar.a(new NativeVideoTsView.b() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.1
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.b
            public void a(View view, int i) {
                NativeVideoTsView.b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a(view, i);
                }
            }
        });
    }

    public void d(long j) {
        this.i = j;
        long j2 = this.j;
        long j3 = this.i;
        if (j2 <= j3) {
            j2 = j3;
        }
        this.j = j2;
        h hVar = this.f6507b;
        if (hVar != null) {
            hVar.e();
        }
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.g;
        if (dVar != null) {
            dVar.a(true, this.i, !this.t);
            A();
        }
    }

    public boolean e() {
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.g;
        return dVar == null || dVar.l();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void e(boolean z) {
        this.B = z;
    }

    public void a(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        h hVar = this.f6507b;
        if (hVar != null) {
            hVar.a(drawVideoListener);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void g() {
        if (q.c(com.bytedance.sdk.openadsdk.core.o.a()) == 0) {
            return;
        }
        l();
        a(this.r.v().h(), this.r.J(), this.E, this.F, null, this.r.M(), 0L, b());
        d(false);
    }

    public void a(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return;
        }
        this.E = i;
        this.F = i2;
        o.b("NativeVideoController", "width=" + i + "height=" + i2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(c.InterfaceC0084c interfaceC0084c) {
        this.C = new WeakReference<>(interfaceC0084c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void d(b bVar, View view) {
        if (this.Q) {
            h(false);
            h hVar = this.f6507b;
            if (hVar != null) {
                hVar.b(this.f6508c.get());
            }
            a(1);
            return;
        }
        a(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean a(String str, String str2, int i, int i2, List<String> list, String str3, long j, boolean z) {
        o.b("tag_video_play", "[video] start NativeVideoController#playVideoUrl and video url is :\r\n" + str);
        if (TextUtils.isEmpty(str)) {
            o.e("tag_video_play", "[video] play video stop , because no video info");
            return false;
        }
        this.t = z;
        this.i = j;
        if (j <= 0) {
            this.q = false;
            this.p = false;
        }
        if (j > 0) {
            this.i = j;
            long j2 = this.j;
            long j3 = this.i;
            if (j2 <= j3) {
                j2 = j3;
            }
            this.j = j2;
        }
        h hVar = this.f6507b;
        if (hVar != null) {
            hVar.e();
            if (this.M == 0) {
                this.f6507b.d();
            }
            this.f6507b.c(i, i2);
            this.f6507b.c(this.f6508c.get());
            this.f6507b.a(i, i2);
        }
        if (this.g == null) {
            this.g = new com.bytedance.sdk.openadsdk.core.video.e.d(this.f6509d);
        }
        o.b("tag_video_play", "[video] new MediaPlayer");
        this.f6511f = 0L;
        try {
            a(str);
            return true;
        } catch (Exception e2) {
            o.e("tag_video_play", "[video] invoke NativeVideoController#playVideo cause exception :" + e2.toString());
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b(boolean z) {
        this.s = z;
        h hVar = this.f6507b;
        if (hVar != null) {
            hVar.c(z);
        }
    }

    private void h(boolean z) {
        this.Q = z;
    }

    private boolean d(int i) {
        com.bytedance.sdk.openadsdk.core.d.h hVar;
        int iC = q.c(com.bytedance.sdk.openadsdk.core.o.a());
        if (iC == 0) {
            h();
            this.x = true;
            h hVar2 = this.f6507b;
            if (hVar2 != null) {
                hVar2.a(this.r, this.n, false);
            }
        }
        if (iC != 4 && iC != 0) {
            h hVar3 = this.f6507b;
            if (hVar3 != null) {
                hVar3.e();
            }
            h();
            this.x = true;
            this.y = false;
            h hVar4 = this.f6507b;
            if (hVar4 != null && (hVar = this.r) != null) {
                return hVar4.a(i, hVar.v());
            }
        } else if (iC == 4) {
            this.x = false;
            h hVar5 = this.f6507b;
            if (hVar5 != null) {
                hVar5.q();
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b(long j) {
        this.w = j;
    }

    public boolean b() {
        return this.t;
    }

    private void b(int i) {
        h hVar;
        this.M++;
        if (C() && (hVar = this.f6507b) != null) {
            hVar.w();
            c.a aVar = this.h;
            if (aVar != null) {
                aVar.a(this.f6511f, com.bytedance.sdk.openadsdk.core.video.f.a.a(this.i, this.k));
            }
            this.f6511f = System.currentTimeMillis() - this.f6510e;
            if (!ab.a(this.r) || this.M >= 2) {
                this.f6507b.a(this.r, this.n, true);
            }
            if (!this.q) {
                com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_over", o(), 100, c());
                this.q = true;
                long j = this.k;
                a(j, j);
                long j2 = this.k;
                this.i = j2;
                this.j = j2;
            }
            if (!this.s && this.Q) {
                e(this.f6507b, null);
            }
            this.z = true;
            if (!ab.a(this.r) || this.M >= 2) {
                return;
            }
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context) {
        int iC = q.c(context);
        a(context, iC);
        if (iC == 4) {
            this.x = false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(long j) {
        this.i = j;
        long j2 = this.j;
        long j3 = this.i;
        if (j2 <= j3) {
            j2 = j3;
        }
        this.j = j2;
    }

    public boolean a() {
        return this.s;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void d(boolean z) {
        this.z = z;
    }

    private void a(String str) {
        o.b("tag_video_play", "[video] NativeVideoController#playVideo has invoke !");
        if (this.g != null) {
            com.bytedance.sdk.openadsdk.core.video.b.a aVar = new com.bytedance.sdk.openadsdk.core.video.b.a();
            aVar.f6419a = str;
            com.bytedance.sdk.openadsdk.core.d.h hVar = this.r;
            if (hVar != null) {
                if (hVar.v() != null) {
                    aVar.f6422d = this.r.v().k();
                }
                aVar.f6420b = String.valueOf(ab.d(this.r.M()));
            }
            aVar.f6421c = 0;
            this.g.a(aVar);
            o.b("tag_video_play", "[video] MediaPlayerProxy has setDataSource !");
        }
        this.f6510e = System.currentTimeMillis();
        if (!TextUtils.isEmpty(str)) {
            this.f6507b.d(8);
            this.f6507b.d(0);
            a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.2
                @Override // java.lang.Runnable
                public void run() {
                    f.this.f6510e = System.currentTimeMillis();
                    f.this.f6507b.c(0);
                    if (f.this.g != null && f.this.i == 0) {
                        f.this.g.a(true, 0L, !f.this.t);
                    } else if (f.this.g != null) {
                        f.this.g.a(true, f.this.i, !f.this.t);
                    }
                    if (f.this.f6509d != null) {
                        f.this.f6509d.postDelayed(f.this.J, 100L);
                    }
                    f.this.A();
                }
            });
        }
        if (this.s) {
            x();
        }
    }

    private void b(Runnable runnable) {
        if (this.l == null) {
            this.l = Collections.synchronizedList(new ArrayList());
        }
        this.l.add(runnable);
    }

    private void b(int i, int i2) {
        if (this.r == null) {
            return;
        }
        boolean zF = f();
        String str = zF ? "play_error" : "play_start_error";
        Map<String, Object> mapA = ab.a(this.r, i, i2, t());
        if (zF) {
            mapA.put("duration", Long.valueOf(o()));
            mapA.put("percent", Integer.valueOf(q()));
            mapA.put("buffers_time", Long.valueOf(n()));
        }
        com.bytedance.sdk.openadsdk.c.d.c(this.n.get(), this.r, this.u, str, mapA);
    }

    public f(Context context, ViewGroup viewGroup, com.bytedance.sdk.openadsdk.core.d.h hVar, String str) {
        this.u = "embeded_ad";
        this.E = 0;
        this.F = 0;
        this.T = 1;
        this.T = q.c(context);
        try {
            this.E = viewGroup.getWidth();
            this.F = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        this.f6508c = new WeakReference<>(viewGroup);
        this.u = str;
        this.n = new WeakReference<>(context);
        this.r = hVar;
        b(context);
        this.o = Build.VERSION.SDK_INT >= 17;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, int i) {
        if (this.g != null) {
            B();
        }
        h hVar = this.f6507b;
        if (hVar != null) {
            hVar.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(e eVar) {
        this.v = new WeakReference<>(eVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, View view) {
        b(bVar, view, false, false);
    }

    private void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (this.f6507b.k() && this.m) {
            runnable.run();
        } else {
            b(runnable);
        }
    }

    public void b(b bVar, View view, boolean z, boolean z2) {
        if (C()) {
            h(!this.Q);
            if (!(this.n.get() instanceof Activity)) {
                o.b("NativeVideoController", "context is not activity, not support this function.");
                return;
            }
            if (this.Q) {
                a(z ? 8 : 0);
                h hVar = this.f6507b;
                if (hVar != null) {
                    hVar.a(this.f6508c.get());
                    this.f6507b.b(false);
                }
            } else {
                a(1);
                h hVar2 = this.f6507b;
                if (hVar2 != null) {
                    hVar2.b(this.f6508c.get());
                    this.f6507b.b(false);
                }
            }
            WeakReference<e> weakReference = this.v;
            e eVar = weakReference != null ? weakReference.get() : null;
            if (eVar != null) {
                eVar.a(this.Q);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(c.a aVar) {
        this.h = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(boolean z) {
        if (this.s) {
            this.N = o();
        }
        if (!this.q && this.p) {
            if (z) {
                com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_break", this.N, q(), c());
                this.q = false;
            } else {
                com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_pause", this.N, q(), c());
            }
        }
        l();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(long j) {
        this.k = j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(boolean z) {
        this.t = z;
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.g;
        if (dVar != null) {
            dVar.a(z);
        }
    }

    protected Map<String, Object> c() {
        return ab.a(this.r, n(), t());
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void c(b bVar, View view) {
        h hVar = this.f6507b;
        if (hVar != null) {
            hVar.g();
        }
        a(true);
    }

    private boolean c(int i) {
        return this.f6507b.b(i);
    }

    private boolean c(int i, int i2) {
        o.b("TTVideoLandingPageActivity", "OnError - Error code: " + i + " Extra code: " + i2);
        boolean z = i == -1010 || i == -1007 || i == -1004 || i == -110 || i == 100 || i == 200;
        if (i2 == 1 || i2 == 700 || i2 == 800) {
            return true;
        }
        return z;
    }

    @Override // com.bytedance.sdk.openadsdk.utils.ad.a
    public void a(Message message) {
        WeakReference<Context> weakReference;
        WeakReference<a> weakReference2;
        if (this.f6507b == null || message == null || (weakReference = this.n) == null || weakReference.get() == null) {
            return;
        }
        int i = message.what;
        if (i == 108) {
            Object obj = message.obj;
            if (!(obj instanceof Long) || ((Long) obj).longValue() <= 0) {
                return;
            }
            this.k = ((Long) message.obj).longValue();
            return;
        }
        if (i == 109) {
            Object obj2 = message.obj;
            if (obj2 instanceof Long) {
                this.i = ((Long) obj2).longValue();
                long j = this.j;
                long j2 = this.i;
                if (j <= j2) {
                    j = j2;
                }
                this.j = j;
                a(this.i, this.k);
                return;
            }
            return;
        }
        if (i == 308) {
            o.e("NativeVideoController", "播放器状态出错 STAT_ERROR 200 、、、、、、、");
            G();
            b(308, 0);
            return;
        }
        if (i != 309) {
            switch (i) {
                case 302:
                    b(i);
                    break;
                case 303:
                    int i2 = message.arg1;
                    int i3 = message.arg2;
                    b(i2, i3);
                    o.e("NativeVideoController", "CALLBACK_ON_ERROR、、before isVideoPlaying、、、、、");
                    if (!f() || i3 == -1004) {
                        o.e("NativeVideoController", "出错后 errorcode,extra、、、、、、、" + i2 + "," + i3);
                        if (c(i2, i3)) {
                            o.e("NativeVideoController", "出错后展示结果页、、、、、、、");
                            this.f6507b.a(this.r, this.n, false);
                            d(true);
                            l();
                        }
                        h hVar = this.f6507b;
                        if (hVar != null) {
                            hVar.w();
                        }
                        c.a aVar = this.h;
                        if (aVar != null) {
                            aVar.b(this.f6511f, com.bytedance.sdk.openadsdk.core.video.f.a.a(this.i, this.k));
                        }
                        WeakReference<c.InterfaceC0084c> weakReference3 = this.C;
                        if (weakReference3 != null && weakReference3.get() != null && !f()) {
                            this.C.get().a(i2, i3);
                            break;
                        }
                    }
                    break;
                case 304:
                    int i4 = message.arg1;
                    h hVar2 = this.f6507b;
                    if (hVar2 != null) {
                        if (i4 == 3 || i4 == 702) {
                            this.f6507b.w();
                            this.f6509d.removeCallbacks(this.f6506a);
                            this.H = false;
                        } else if (i4 == 701) {
                            hVar2.t();
                            this.f6509d.postDelayed(this.f6506a, Tribe.CREATE_FEE_GOLDS);
                            this.H = true;
                        }
                    }
                    if (this.o && i4 == 3) {
                        if (this.s && (weakReference2 = this.D) != null && weakReference2.get() != null) {
                            this.D.get().f();
                        }
                        M();
                        this.f6509d.removeCallbacks(this.f6506a);
                    }
                    if (this.o && i4 == 3) {
                        F();
                        break;
                    }
                    break;
                case 305:
                    WeakReference<c.InterfaceC0084c> weakReference4 = this.C;
                    if (weakReference4 != null && weakReference4.get() != null) {
                        this.C.get().f();
                    }
                    ad adVar = this.f6509d;
                    if (adVar != null) {
                        adVar.removeCallbacks(this.K);
                    }
                    if (!this.o) {
                        F();
                    }
                    h hVar3 = this.f6507b;
                    if (hVar3 != null) {
                        hVar3.w();
                    }
                    this.f6509d.removeCallbacks(this.f6506a);
                    break;
                case 306:
                    h hVar4 = this.f6507b;
                    if (hVar4 != null) {
                        hVar4.w();
                    }
                    break;
                default:
                    switch (i) {
                        case 311:
                            I();
                            break;
                        case 312:
                            if (z()) {
                                o.e("NativeVideoController", "CALLBACK_ON_RETRY_VIDEO_TIME-....重试....");
                                l();
                                this.g = null;
                                a(this.r.v().h(), this.r.J(), this.E, this.F, null, this.r.M(), 0L, b());
                            } else {
                                o.c("NativeVideoController", "不满足条件，无法重试");
                            }
                            break;
                        case 313:
                            H();
                            break;
                        case 314:
                            this.O = SystemClock.elapsedRealtime();
                            break;
                    }
                    break;
            }
            return;
        }
        o.c("NativeVideoController", "SSMediaPlayerWrapper 释放了。。。。。");
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, SurfaceHolder surfaceHolder) {
        this.m = false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, SurfaceTexture surfaceTexture) {
        this.m = false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, View view) {
        if (this.g == null || !C()) {
            return;
        }
        if (this.g.g()) {
            h();
            this.f6507b.b(true, false);
            this.f6507b.c();
            return;
        }
        if (!this.g.i()) {
            h hVar = this.f6507b;
            if (hVar != null) {
                hVar.c(this.f6508c.get());
            }
            d(this.i);
            h hVar2 = this.f6507b;
            if (hVar2 != null) {
                hVar2.b(false, false);
                return;
            }
            return;
        }
        g(false);
        h hVar3 = this.f6507b;
        if (hVar3 != null) {
            hVar3.b(false, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, int i) {
        if (this.g == null) {
            return;
        }
        A();
        a(this.R, c(i));
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, int i, boolean z) {
        if (C()) {
            long jL = (long) (((((long) i) * this.k) * 1.0f) / t.l(this.n.get(), "tt_video_progress_max"));
            if (this.k > 0) {
                this.R = (int) jL;
            } else {
                this.R = 0L;
            }
            h hVar = this.f6507b;
            if (hVar != null) {
                hVar.a(this.R);
            }
        }
    }

    private void a(long j, long j2) {
        this.i = j;
        this.k = j2;
        this.f6507b.a(j, j2);
        this.f6507b.a(com.bytedance.sdk.openadsdk.core.video.f.a.a(j, j2));
        try {
            if (this.h != null) {
                this.h.a(j, j2);
            }
        } catch (Throwable th) {
            o.c("NativeVideoController", "onProgressUpdate error: ", th);
        }
    }

    public void a(int i) {
        if (C()) {
            boolean z = i == 0 || i == 8;
            Context context = this.n.get();
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
    public void a(b bVar, View view, boolean z, boolean z2) {
        if (this.s) {
            h();
        }
        if (z && !this.s && !e()) {
            this.f6507b.b(!f(), false);
            this.f6507b.a(z2, true, false);
        }
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.g;
        if (dVar != null && dVar.g()) {
            this.f6507b.c();
            this.f6507b.b();
        } else {
            this.f6507b.c();
        }
    }

    public void a(b bVar, View view, boolean z) {
        K();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, SurfaceHolder surfaceHolder) {
        this.m = true;
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.g;
        if (dVar == null) {
            return;
        }
        dVar.a(surfaceHolder);
        D();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, SurfaceTexture surfaceTexture) {
        this.m = true;
        com.bytedance.sdk.openadsdk.core.video.e.d dVar = this.g;
        if (dVar == null) {
            return;
        }
        dVar.a(surfaceTexture);
        D();
    }

    private void a(long j, boolean z) {
        if (this.g == null) {
            return;
        }
        if (z) {
            L();
        }
        this.g.a(j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.d
    public void a(e.a aVar, String str) {
        int i = AnonymousClass8.f6520a[aVar.ordinal()];
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
            this.x = false;
            this.y = true;
        }
    }

    private void a(Context context, int i) {
        if (!C() || context == null || this.T == i) {
            return;
        }
        this.T = i;
        if (i != 4 && i != 0) {
            this.y = false;
        }
        if (!this.y && !v()) {
            d(2);
        }
        WeakReference<a> weakReference = this.D;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.D.get().a(this.T);
    }

    public void a(Context context) {
        int iC = q.c(context);
        a(context, iC);
        if (iC == 4) {
            this.x = false;
            j();
        }
    }

    public void a(a aVar) {
        this.D = new WeakReference<>(aVar);
    }
}
