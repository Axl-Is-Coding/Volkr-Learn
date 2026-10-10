package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.d.n;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.f.b;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.b;
import com.bytedance.sdk.openadsdk.core.video.renderview.SSRenderSurfaceView;
import com.bytedance.sdk.openadsdk.core.video.renderview.SSRenderTextureView;
import com.bytedance.sdk.openadsdk.core.widget.RoundImageView;
import com.bytedance.sdk.openadsdk.core.widget.d;
import com.bytedance.sdk.openadsdk.core.widget.e;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.t;
import java.lang.ref.WeakReference;
import java.util.EnumSet;

/* JADX INFO: compiled from: NativeVideoLayout.java */
/* JADX INFO: loaded from: classes.dex */
public class h implements b, com.bytedance.sdk.openadsdk.core.video.renderview.a, d.a, e.b, ad.a {
    com.bytedance.sdk.openadsdk.core.widget.e A;
    d B;
    boolean C;
    b.a.a.a.a.a.b D;
    c E;
    com.bytedance.sdk.openadsdk.core.a.a F;
    com.bytedance.sdk.openadsdk.core.a.a G;
    TTDrawFeedAd.DrawVideoListener H;
    boolean I;
    private View J;
    private TextView K;
    private TextView L;
    private NativeVideoTsView.b M;
    private final String N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    View f6529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    com.bytedance.sdk.openadsdk.core.video.renderview.b f6530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ImageView f6531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    View f6532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    View f6533e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    ImageView f6534f;
    ViewStub g;
    View h;
    ImageView i;
    View j;
    RoundImageView k;
    TextView l;
    TextView m;
    TextView n;
    ProgressBar o;
    ViewStub p;
    int q;
    int r;
    int s;
    int t;
    boolean u;
    boolean v;
    int w;
    EnumSet<b.a> x;
    com.bytedance.sdk.openadsdk.core.d.h y;
    Context z;

    public h(Context context, View view, boolean z, EnumSet<b.a> enumSet, com.bytedance.sdk.openadsdk.core.d.h hVar, c cVar, boolean z2) throws Throwable {
        this.u = true;
        this.C = true;
        this.I = true;
        this.N = Build.MODEL;
        if (this instanceof g) {
            return;
        }
        this.z = o.a().getApplicationContext();
        c(z2);
        this.f6529a = view;
        this.u = z;
        this.x = enumSet == null ? EnumSet.noneOf(b.a.class) : enumSet;
        this.E = cVar;
        this.y = hVar;
        c(8);
        a(context, this.f6529a);
        a();
        n();
    }

    private boolean A() {
        return "C8817D".equals(this.N) || "M5".equals(this.N) || "R7t".equals(this.N);
    }

    private void b(View view, Context context) {
        ViewStub viewStub;
        if (view == null || context == null || (viewStub = this.p) == null || viewStub.getParent() == null || this.J != null) {
            return;
        }
        this.p.inflate();
        this.J = view.findViewById(t.e(context, "tt_video_ad_cover_center_layout_draw"));
        this.K = (TextView) view.findViewById(t.e(context, "tt_video_ad_button_draw"));
        this.L = (TextView) view.findViewById(t.e(context, "tt_video_ad_replay"));
    }

    private int e(int i) {
        if (this.s <= 0 || this.t <= 0) {
            return 0;
        }
        int dimensionPixelSize = this.z.getResources().getDimensionPixelSize(t.h(this.z, "tt_video_container_maxheight"));
        int dimensionPixelSize2 = this.z.getResources().getDimensionPixelSize(t.h(this.z, "tt_video_container_minheight"));
        int i2 = (int) (this.t * ((i * 1.0f) / this.s));
        return i2 > dimensionPixelSize ? dimensionPixelSize : i2 < dimensionPixelSize2 ? dimensionPixelSize2 : i2;
    }

    private void f(int i) {
        ac.a(this.j, i);
        ac.a(this.J, i);
    }

    private boolean y() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.y;
        return hVar != null && hVar.u() == null && this.y.e() == 1 && (this.y.N() == 5 || this.y.N() == 15);
    }

    private void z() {
        Context context = this.z;
        if (context == null || this.f6529a == null) {
            return;
        }
        View view = new View(context) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.3
            private void a() {
            }

            private void b() {
            }

            @Override // android.view.View
            protected void onDetachedFromWindow() {
                super.onDetachedFromWindow();
                b();
            }

            @Override // android.view.View
            public void onFinishTemporaryDetach() {
                super.onFinishTemporaryDetach();
                a();
            }

            @Override // android.view.View
            public void onStartTemporaryDetach() {
                super.onStartTemporaryDetach();
                b();
            }
        };
        View view2 = this.f6529a;
        if (view2 instanceof ViewGroup) {
            ((ViewGroup) view2).addView(view, 0, new RelativeLayout.LayoutParams(0, 0));
        }
    }

    public void a(long j) {
    }

    public void a(long j, long j2) {
    }

    public void a(Message message) {
    }

    public void a(View view, boolean z) {
    }

    public void a(ViewGroup viewGroup) {
    }

    public void a(String str) {
    }

    public void a(boolean z) {
    }

    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void b(SurfaceTexture surfaceTexture) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void b(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public void b(ViewGroup viewGroup) {
    }

    public void b(boolean z) {
    }

    public boolean b(int i) {
        return false;
    }

    public void c() {
    }

    public void c(boolean z) {
        this.C = z;
        if (this.C) {
            com.bytedance.sdk.openadsdk.core.a.a aVar = this.F;
            if (aVar != null) {
                aVar.a(true);
            }
            com.bytedance.sdk.openadsdk.core.a.a aVar2 = this.G;
            if (aVar2 != null) {
                aVar2.a(true);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.a.a aVar3 = this.F;
        if (aVar3 != null) {
            aVar3.a(false);
        }
        com.bytedance.sdk.openadsdk.core.a.a aVar4 = this.G;
        if (aVar4 != null) {
            aVar4.a(false);
        }
    }

    public void d(int i) {
        ac.a(this.f6529a, 0);
        com.bytedance.sdk.openadsdk.core.video.renderview.b bVar = this.f6530b;
        if (bVar != null) {
            bVar.setVisibility(i);
        }
    }

    public void g() {
        this.o.setProgress(0);
        this.o.setSecondaryProgress(0);
        c(8);
        if (x()) {
            this.f6530b.setVisibility(8);
        }
        ImageView imageView = this.f6534f;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        c(8);
        ac.a(this.h, 8);
        ac.a((View) this.i, 8);
        ac.a(this.j, 8);
        ac.a((View) this.k, 8);
        ac.a((View) this.l, 8);
        ac.a((View) this.m, 8);
        com.bytedance.sdk.openadsdk.core.widget.e eVar = this.A;
        if (eVar != null) {
            eVar.a(true);
        }
    }

    public boolean h() {
        return false;
    }

    public boolean i() {
        return this.u;
    }

    public void j() {
        a(true, false);
    }

    public boolean k() {
        return this.v;
    }

    public void l() {
    }

    public boolean m() {
        com.bytedance.sdk.openadsdk.core.widget.e eVar = this.A;
        return eVar != null && eVar.a();
    }

    void n() {
        String str;
        int i;
        com.bytedance.sdk.openadsdk.core.a.a aVar;
        String str2 = this.C ? "embeded_ad" : "embeded_ad_landingpage";
        if (ab.a(this.y)) {
            str = this.C ? "draw_ad" : "draw_ad_landingpage";
            i = 6;
        } else if (ab.c(this.y)) {
            str = "rewarded_video";
            i = 7;
        } else if (ab.d(this.y)) {
            str = "fullscreen_interstitial_ad";
            i = 5;
        } else {
            str = str2;
            i = 1;
        }
        if (this.y.x() == 4) {
            this.D = b.a.a.a.a.a.c.a(this.z, this.y, str);
        }
        z();
        this.F = new com.bytedance.sdk.openadsdk.core.a.a(this.z, this.y, str, i);
        this.F.b(true);
        if (this.C) {
            this.F.a(true);
        } else {
            this.F.a(false);
            this.F.c(true);
        }
        this.F.a(this.E);
        this.F.d(true);
        b.a.a.a.a.a.b bVar = this.D;
        if (bVar != null && (aVar = this.F) != null) {
            aVar.a(bVar);
        }
        if (y()) {
            this.G = new com.bytedance.sdk.openadsdk.core.a.a(this.z, this.y, str, i) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.1
                @Override // com.bytedance.sdk.openadsdk.core.a.a
                public boolean b() {
                    com.bytedance.sdk.openadsdk.core.widget.e eVar = h.this.A;
                    boolean zA = eVar != null ? eVar.a() : false;
                    StringBuilder sb = new StringBuilder();
                    sb.append("isVisible=");
                    sb.append(zA);
                    sb.append(",mPlayBtn.getVisibility() == VISIBLE->");
                    sb.append(h.this.f6531c.getVisibility() == 0);
                    com.bytedance.sdk.openadsdk.utils.o.c("ClickCreativeListener", sb.toString());
                    return zA || h.this.f6531c.getVisibility() == 0;
                }

                @Override // com.bytedance.sdk.openadsdk.core.a.a
                public boolean c() {
                    View view;
                    RoundImageView roundImageView;
                    TextView textView;
                    View view2 = h.this.h;
                    return (view2 != null && view2.getVisibility() == 0) || ((view = h.this.j) != null && view.getVisibility() == 0) || (((roundImageView = h.this.k) != null && roundImageView.getVisibility() == 0) || ((textView = h.this.l) != null && textView.getVisibility() == 0));
                }
            };
            this.G.a(new b.a() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.2
                @Override // com.bytedance.sdk.openadsdk.core.a.b.a
                public void a(View view, int i2) {
                    if (h.this.M != null) {
                        h.this.M.a(view, i2);
                    }
                }
            });
            this.G.b(true);
            if (this.C) {
                this.G.a(true);
            } else {
                this.G.a(false);
            }
            this.G.a(this.E);
            this.G.d(true);
            b.a.a.a.a.a.b bVar2 = this.D;
            if (bVar2 != null) {
                this.G.a(bVar2);
            }
            View view = this.f6529a;
            if (view != null) {
                view.setOnClickListener(this.G);
                this.f6529a.setOnTouchListener(this.G);
            }
        }
    }

    public com.bytedance.sdk.openadsdk.core.video.renderview.b o() {
        return this.f6530b;
    }

    void p() {
        if (this.B == null || this.A != null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.A = new com.bytedance.sdk.openadsdk.core.widget.e();
        this.A.a(this.z, this.f6529a);
        this.A.a(this.B, this);
        com.bytedance.sdk.openadsdk.utils.o.b("useTime", "mVideoTrafficTipLayout use time :" + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    public void q() {
        com.bytedance.sdk.openadsdk.core.widget.e eVar = this.A;
        if (eVar != null) {
            eVar.a(false);
        }
    }

    boolean r() {
        if (this.B != null) {
            return true;
        }
        com.bytedance.sdk.openadsdk.utils.o.e("NewLiveViewLayout", "callback is null");
        return false;
    }

    public View s() {
        return this.f6529a;
    }

    public void t() {
        ac.g(this.f6532d);
        ac.g(this.f6533e);
        if (this.f6531c.getVisibility() == 0) {
            ac.a((View) this.f6531c, 8);
        }
    }

    @TargetApi(14)
    public void u() {
        ac.a(this.f6529a, 0);
        com.bytedance.sdk.openadsdk.core.video.renderview.b bVar = this.f6530b;
        if (bVar != null) {
            View view = bVar.getView();
            if (view instanceof TextureView) {
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    int iIndexOfChild = viewGroup.indexOfChild(view);
                    viewGroup.removeView(view);
                    viewGroup.addView(view, iIndexOfChild);
                }
            }
            ac.a(view, 8);
            ac.a(view, 0);
        }
    }

    void v() {
        ac.a(this.h, 8);
        ac.a((View) this.i, 8);
        ac.a(this.j, 8);
        ac.a((View) this.k, 8);
        ac.a((View) this.l, 8);
        ac.a((View) this.m, 8);
        ac.a((View) this.n, 8);
    }

    public void w() {
        ac.f(this.f6532d);
        ac.f(this.f6533e);
        ImageView imageView = this.f6534f;
        if (imageView != null) {
            ac.f(imageView);
        }
    }

    boolean x() {
        return !this.x.contains(b.a.alwayShowMediaView) || this.u;
    }

    public void a(NativeVideoTsView.b bVar) {
        this.M = bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v7, types: [android.view.View, com.bytedance.sdk.openadsdk.core.video.renderview.b] */
    /* JADX WARN: Type inference failed for: r4v5, types: [android.widget.RelativeLayout] */
    void a(Context context, View view) throws Throwable {
        ?? r2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strA = ab.a(context);
        if (strA == null) {
            strA = "0";
        }
        boolean z = Build.VERSION.SDK_INT != 20 || Integer.valueOf(strA).intValue() >= 1572864;
        if (!A() && z && com.bytedance.sdk.openadsdk.core.h.b().p() && Build.VERSION.SDK_INT >= 14) {
            SSRenderTextureView sSRenderTextureView = new SSRenderTextureView(this.z);
            com.bytedance.sdk.openadsdk.utils.o.b("NewLiveViewLayout", "use TextureView......");
            r2 = sSRenderTextureView;
        } else {
            SSRenderSurfaceView sSRenderSurfaceView = new SSRenderSurfaceView(this.z);
            com.bytedance.sdk.openadsdk.utils.o.b("NewLiveViewLayout", "use SurfaceView......");
            r2 = sSRenderSurfaceView;
        }
        if (view instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            ((RelativeLayout) view).addView(r2, 0, layoutParams);
        }
        ac.a((View) r2, 8);
        this.f6530b = r2;
        this.f6531c = (ImageView) view.findViewById(t.e(context, "tt_video_play"));
        this.o = (ProgressBar) view.findViewById(t.e(context, "tt_video_progress"));
        this.f6532d = view.findViewById(t.e(context, "tt_video_loading_retry_layout"));
        this.f6533e = view.findViewById(t.e(context, "tt_video_loading_progress"));
        this.f6534f = (ImageView) view.findViewById(t.e(context, "tt_video_loading_cover_image"));
        this.g = (ViewStub) view.findViewById(t.e(context, "tt_video_ad_cover"));
        this.p = (ViewStub) view.findViewById(t.e(context, "tt_video_draw_layout_viewStub"));
        com.bytedance.sdk.openadsdk.utils.o.b("useTime", "NativeVideoLayout**findViews use time :" + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    public void f() {
        ac.f(this.f6532d);
    }

    public void d() {
        com.bytedance.sdk.openadsdk.core.d.h hVar;
        ac.g(this.f6532d);
        ac.g(this.f6533e);
        if (this.f6534f != null && (hVar = this.y) != null && hVar.v() != null && this.y.v().g() != null) {
            ac.g(this.f6534f);
            com.bytedance.sdk.openadsdk.g.d.a(this.z).a(this.y.v().g(), this.f6534f);
        }
        if (this.f6531c.getVisibility() == 0) {
            ac.a((View) this.f6531c, 8);
        }
    }

    public void e() {
        a(false, this.u);
        v();
    }

    public void b(boolean z, boolean z2) {
        ImageView imageView = this.f6531c;
        if (imageView != null) {
            if (z) {
                imageView.setImageResource(t.d(this.z, "tt_play_movebar_textpage"));
            } else {
                imageView.setImageResource(t.d(this.z, "tt_stop_movebar_textpage"));
            }
        }
    }

    public void b(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.f6529a.getLayoutParams();
        if (i == -1 || i == -2 || i > 0) {
            layoutParams.width = i;
        }
        if (i2 == -1 || i2 == -2 || i2 > 0) {
            layoutParams.height = i2;
        }
        this.f6529a.setLayoutParams(layoutParams);
    }

    public void c(int i, int i2) {
        this.s = i;
        this.t = i2;
    }

    public void d(boolean z) {
        this.I = z;
    }

    public void c(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        if (this.f6529a.getParent() != null) {
            ((ViewGroup) this.f6529a.getParent()).removeView(this.f6529a);
        }
        viewGroup.addView(this.f6529a);
        c(0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void b(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != this.f6530b.getHolder()) {
            return;
        }
        this.v = false;
        if (r()) {
            this.B.b(this, surfaceHolder);
        }
    }

    public h(Context context, View view, boolean z, EnumSet<b.a> enumSet, com.bytedance.sdk.openadsdk.core.d.h hVar, c cVar) {
        this(context, view, z, enumSet, hVar, cVar, true);
    }

    public void c(int i) {
        this.w = i;
        ac.a(this.f6529a, i);
    }

    void a(View view, Context context) {
        ViewStub viewStub;
        if (view == null || context == null || (viewStub = this.g) == null || viewStub.getParent() == null || this.h != null) {
            return;
        }
        this.h = this.g.inflate();
        this.i = (ImageView) view.findViewById(t.e(context, "tt_video_ad_finish_cover_image"));
        this.j = view.findViewById(t.e(context, "tt_video_ad_cover_center_layout"));
        this.k = (RoundImageView) view.findViewById(t.e(context, "tt_video_ad_logo_image"));
        this.l = (TextView) view.findViewById(t.e(context, "tt_video_btn_ad_image_tv"));
        this.m = (TextView) view.findViewById(t.e(context, "tt_video_ad_name"));
        this.n = (TextView) view.findViewById(t.e(context, "tt_video_ad_button"));
    }

    public boolean a(int i, n nVar) {
        com.bytedance.sdk.openadsdk.core.widget.e eVar = this.A;
        return eVar == null || eVar.a(i, nVar);
    }

    public void a(a aVar) {
        if (aVar instanceof d) {
            this.B = (d) aVar;
            p();
        }
    }

    void a() {
        this.f6530b.a(this);
        this.f6531c.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.r()) {
                    TextView textView = h.this.n;
                    if (textView == null || textView.getVisibility() != 0) {
                        h hVar = h.this;
                        hVar.B.a(hVar, view);
                    }
                }
            }
        });
    }

    public void a(int i, int i2) {
        if (i == -1) {
            i = ac.c(this.z);
        }
        if (i <= 0) {
            return;
        }
        this.q = i;
        if (!i() && !h() && !this.x.contains(b.a.fixedSize)) {
            this.r = e(i);
        } else {
            this.r = i2;
        }
        b(this.q, this.r);
    }

    public void a(int i) {
        com.bytedance.sdk.openadsdk.utils.o.c("Progress", "setSeekProgress-percent=" + i);
        ac.a((View) this.o, 0);
        this.o.setProgress(i);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void a(com.bytedance.sdk.openadsdk.core.d.h hVar, WeakReference<Context> weakReference, boolean z) {
        com.bytedance.sdk.openadsdk.core.d.h hVar2;
        String strH;
        String strA;
        com.bytedance.sdk.openadsdk.core.d.h hVar3;
        com.bytedance.sdk.openadsdk.core.d.h hVar4;
        if (hVar == null) {
            return;
        }
        a(false, this.u);
        a(this.f6529a, o.a());
        View view = this.h;
        if (view != null) {
            ac.a(view, 0);
        }
        ImageView imageView = this.i;
        if (imageView != null) {
            ac.a((View) imageView, 0);
        }
        if (ab.a(this.y)) {
            b(this.f6529a, o.a());
            ac.a(this.j, 8);
            ac.a((View) this.i, 0);
            ac.a(this.J, 0);
            ac.a((View) this.K, 0);
            ac.a((View) this.L, 0);
            if (this.L != null && q.c(o.a()) == 0) {
                ac.a((View) this.L, 8);
            }
            View view2 = this.h;
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        c cVar = h.this.E;
                        if (cVar != null) {
                            ((a) cVar).g();
                            TTDrawFeedAd.DrawVideoListener drawVideoListener = h.this.H;
                            if (drawVideoListener != null) {
                                drawVideoListener.onClickRetry();
                            }
                        }
                    }
                });
            }
            if (this.i != null && (hVar4 = this.y) != null && hVar4.v() != null && this.y.v().g() != null) {
                com.bytedance.sdk.openadsdk.core.video.f.b.a((long) this.y.v().e(), this.y.v().h(), new b.InterfaceC0083b() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.6
                    @Override // com.bytedance.sdk.openadsdk.core.video.f.b.InterfaceC0083b
                    public void a(Bitmap bitmap) {
                        if (bitmap == null) {
                            com.bytedance.sdk.openadsdk.g.d.a(h.this.z).a(h.this.y.v().g(), h.this.i);
                            return;
                        }
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) h.this.i.getLayoutParams();
                        if (bitmap.getWidth() > bitmap.getHeight()) {
                            float height = (bitmap.getHeight() * ac.c(o.a())) / bitmap.getWidth();
                            layoutParams.width = ac.c(o.a());
                            layoutParams.height = (int) height;
                            layoutParams.addRule(13);
                            h.this.i.setLayoutParams(layoutParams);
                        }
                        h.this.i.setImageBitmap(bitmap);
                    }
                });
            }
        } else {
            ac.a(this.j, 0);
            if (this.i != null && (hVar2 = this.y) != null && hVar2.v() != null && this.y.v().g() != null) {
                com.bytedance.sdk.openadsdk.g.d.a(this.z).a(this.y.v().g(), this.i);
            }
        }
        if (!TextUtils.isEmpty(hVar.w())) {
            strH = hVar.w();
        } else if (!TextUtils.isEmpty(hVar.G())) {
            strH = hVar.G();
        } else {
            strH = !TextUtils.isEmpty(hVar.H()) ? hVar.H() : "";
        }
        if (this.k != null && (hVar3 = this.y) != null && hVar3.y() != null && this.y.y().a() != null) {
            ac.a((View) this.k, 0);
            ac.a((View) this.l, 4);
            com.bytedance.sdk.openadsdk.g.d.a(this.z).a(this.y.y().a(), this.k);
            if (y()) {
                this.k.setOnClickListener(this.G);
                this.k.setOnTouchListener(this.G);
            } else {
                this.k.setOnClickListener(this.F);
                this.k.setOnTouchListener(this.F);
            }
        } else if (!TextUtils.isEmpty(strH)) {
            ac.a((View) this.k, 4);
            ac.a((View) this.l, 0);
            TextView textView = this.l;
            if (textView != null) {
                textView.setText(strH.substring(0, 1));
                if (y()) {
                    this.l.setOnClickListener(this.G);
                    this.l.setOnTouchListener(this.G);
                } else {
                    this.l.setOnClickListener(this.F);
                    this.l.setOnTouchListener(this.F);
                }
            }
        }
        if (this.m != null && !TextUtils.isEmpty(strH)) {
            this.m.setText(strH);
        }
        ac.a((View) this.m, 0);
        ac.a((View) this.n, 0);
        int iX = hVar.x();
        if (iX == 2 || iX == 3) {
            strA = t.a(this.z, "tt_video_mobile_go_detail");
        } else if (iX == 4) {
            strA = t.a(this.z, "tt_video_download_apk");
        } else if (iX != 5) {
            strA = t.a(this.z, "tt_video_mobile_go_detail");
        } else {
            strA = t.a(this.z, "tt_video_dial_phone");
        }
        TextView textView2 = this.n;
        if (textView2 != null) {
            textView2.setText(strA);
            this.n.setOnClickListener(this.F);
            this.n.setOnTouchListener(this.F);
        }
        TextView textView3 = this.K;
        if (textView3 != null) {
            textView3.setText(strA);
            this.K.setOnClickListener(this.F);
            this.K.setOnTouchListener(this.F);
        }
        if (this.I) {
            return;
        }
        f(4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void a(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != this.f6530b.getHolder()) {
            return;
        }
        this.v = true;
        if (r()) {
            this.B.a(this, surfaceHolder);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void a(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (surfaceHolder == this.f6530b.getHolder() && r()) {
            this.B.a(this, surfaceHolder, i, i2, i3);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void a(SurfaceTexture surfaceTexture, int i, int i2) {
        this.v = true;
        if (r()) {
            this.B.a(this, surfaceTexture);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public boolean a(SurfaceTexture surfaceTexture) {
        this.v = false;
        if (!r()) {
            return true;
        }
        this.B.b(this, surfaceTexture);
        return true;
    }

    public void a(boolean z, boolean z2, boolean z3) {
        ac.a((View) this.o, 0);
        ac.a((View) this.f6531c, (!z || this.f6532d.getVisibility() == 0) ? 8 : 0);
    }

    public void a(boolean z, boolean z2) {
        ac.a((View) this.o, z ? 0 : 8);
        ac.a((View) this.f6531c, 8);
    }

    public void a(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        this.H = drawVideoListener;
        com.bytedance.sdk.openadsdk.core.a.a aVar = this.F;
        if (aVar != null) {
            aVar.a(drawVideoListener);
        }
    }
}
