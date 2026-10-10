package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.f;
import com.bytedance.sdk.openadsdk.core.w;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.o;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.t;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ViewConstructor"})
public class NativeVideoTsView extends FrameLayout implements c.a, f.a, ad.a {
    private AtomicBoolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.bytedance.sdk.openadsdk.core.d.h f6493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected c f6494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected FrameLayout f6495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected boolean f6496d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected RelativeLayout f6497e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected ImageView f6498f;
    protected ImageView g;
    protected ImageView h;
    protected String i;
    protected int j;
    AtomicBoolean k;
    boolean l;
    public a m;
    private final Context n;
    private ViewGroup o;
    private boolean p;
    private boolean q;
    private boolean r;
    private long s;
    private final ad t;
    private boolean u;
    private final String v;
    private ViewStub w;
    private c.b x;
    private final AtomicBoolean y;
    private boolean z;

    public interface a {
        void a(boolean z, long j, long j2, long j3, boolean z2);
    }

    public interface b {
        void a(View view, int i);
    }

    public NativeVideoTsView(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar) {
        this(context, hVar, false);
    }

    private void e() {
        a(0L, 0);
        this.x = null;
    }

    private void j() {
        addView(a(this.n));
        l();
    }

    private void k() {
        if (!(this instanceof NativeDrawVideoTsView) || this.k.get() || com.bytedance.sdk.openadsdk.core.h.b().q() == null) {
            return;
        }
        this.h.setImageBitmap(com.bytedance.sdk.openadsdk.core.h.b().q());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
        int iA = (int) ac.a(getContext(), this.j);
        layoutParams.width = iA;
        layoutParams.height = iA;
        this.h.setLayoutParams(layoutParams);
        this.k.set(true);
    }

    private void l() {
        this.f6494b = new f(this.n, this.f6495c, this.f6493a, this.i, !w());
        m();
        this.o.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                NativeVideoTsView nativeVideoTsView = NativeVideoTsView.this;
                ((f) nativeVideoTsView.f6494b).a(nativeVideoTsView.o.getWidth(), NativeVideoTsView.this.o.getHeight());
                NativeVideoTsView.this.o.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    private void m() {
        c cVar = this.f6494b;
        if (cVar == null) {
            return;
        }
        cVar.e(this.p);
        ((f) this.f6494b).a((f.a) this);
        this.f6494b.a(this);
    }

    private void n() {
        c cVar = this.f6494b;
        if (cVar == null) {
            l();
        } else if ((cVar instanceof f) && !w()) {
            ((f) this.f6494b).x();
        }
        if (this.f6494b == null || !this.y.get()) {
            return;
        }
        this.y.set(false);
        c();
        if (h()) {
            ac.a((View) this.f6497e, 8);
            ImageView imageView = this.g;
            if (imageView != null) {
                ac.a((View) imageView, 8);
            }
            this.f6494b.a(this.f6493a.v().h(), this.f6493a.J(), this.o.getWidth(), this.o.getHeight(), null, this.f6493a.M(), 0L, v());
            this.f6494b.d(false);
            return;
        }
        if (!this.f6494b.v()) {
            o.c("NativeVideoAdView", "attachTask.......mRlImgCover.....VISIBLE");
            g();
            ac.a((View) this.f6497e, 0);
        } else {
            o.b("NativeVideoAdView", "attachTask-mNativeVideoController.isPlayComplete()=" + this.f6494b.v());
            b(true);
        }
    }

    private void o() {
        this.m = null;
        i();
        p();
    }

    private void p() {
        if (!this.y.get()) {
            this.y.set(true);
            c cVar = this.f6494b;
            if (cVar != null) {
                cVar.a(true);
            }
        }
        this.A.set(false);
    }

    private void q() {
        c(w.a(this, 50, 5));
        this.t.sendEmptyMessageDelayed(1, 500L);
    }

    private boolean r() {
        if (w()) {
            return false;
        }
        return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_from_detail_page", false) || com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", false);
    }

    private void s() {
        if (w()) {
            return;
        }
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", (Boolean) false);
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_from_detail_page", (Boolean) false);
    }

    private void t() {
        if (this.f6494b == null || w() || !com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", false)) {
            return;
        }
        boolean zA = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_native_video_complete", false);
        long jA = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_current_play_position", 0L);
        long jA2 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_total_play_duration", this.f6494b.o());
        long jA3 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_duration", this.f6494b.r());
        this.f6494b.d(zA);
        this.f6494b.a(jA);
        this.f6494b.b(jA2);
        this.f6494b.c(jA3);
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", (Boolean) false);
        o.e("MultiProcess", "onResumeFeedNativeVideoControllerData-isComplete=" + zA + ",position=" + jA + ",totalPlayDuration=" + jA2 + ",duration=" + jA3);
    }

    private boolean u() {
        return 2 == com.bytedance.sdk.openadsdk.core.o.h().c(ab.d(this.f6493a.M()));
    }

    private boolean v() {
        return this.f6496d;
    }

    private boolean w() {
        return this.q;
    }

    private void x() {
        ac.f(this.g);
        ac.f(this.f6497e);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void a() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void b(long j, int i) {
    }

    public void b(boolean z) {
        c cVar = this.f6494b;
        if (cVar != null) {
            cVar.d(z);
            h hVarU = this.f6494b.u();
            if (hVarU != null) {
                hVarU.w();
                View viewS = hVarU.s();
                if (viewS != null) {
                    if (viewS.getParent() != null) {
                        ((ViewGroup) viewS.getParent()).removeView(viewS);
                    }
                    viewS.setVisibility(0);
                    addView(viewS);
                    hVarU.a(this.f6493a, new WeakReference<>(this.n), false);
                }
            }
        }
    }

    protected void c() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.f6493a;
        if (hVar == null) {
            return;
        }
        int iD = ab.d(hVar.M());
        int iC = com.bytedance.sdk.openadsdk.core.o.h().c(iD);
        if (iC == 1) {
            this.p = q.d(this.n);
        } else if (iC == 2) {
            this.p = q.e(this.n) || q.d(this.n);
        } else if (iC == 3) {
            this.p = false;
        } else if (iC == 4) {
            this.l = true;
        }
        if (this.q) {
            this.f6496d = false;
        } else {
            this.f6496d = com.bytedance.sdk.openadsdk.core.o.h().a(iD);
        }
        if ("splash_ad".equals(this.i)) {
            this.p = true;
            this.f6496d = true;
        }
        c cVar = this.f6494b;
        if (cVar != null) {
            cVar.e(this.p);
        }
    }

    protected void d() {
        if (q.c(com.bytedance.sdk.openadsdk.core.o.a()) == 0) {
            return;
        }
        if (this.f6494b.t() != null) {
            if (this.f6494b.t().g()) {
                c(false);
                ad adVar = this.t;
                if (adVar != null) {
                    adVar.removeMessages(1);
                }
                a(true);
                return;
            }
            if (this.f6494b.t().i()) {
                c(true);
                ad adVar2 = this.t;
                if (adVar2 != null) {
                    adVar2.sendEmptyMessageDelayed(1, 500L);
                }
                a(false);
                return;
            }
        }
        if (h() || this.A.get()) {
            return;
        }
        this.A.set(true);
        x();
        this.f6494b.a(this.f6493a.v().h(), this.f6493a.J(), this.o.getWidth(), this.o.getHeight(), null, this.f6493a.M(), this.s, v());
        ad adVar3 = this.t;
        if (adVar3 != null) {
            adVar3.sendEmptyMessageDelayed(1, 500L);
        }
        a(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.f.a
    public void f() {
        c.b bVar = this.x;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void g() {
        ViewStub viewStub;
        if (this.n == null || (viewStub = this.w) == null || viewStub.getParent() == null || this.f6493a == null || this.f6497e != null) {
            return;
        }
        this.f6497e = (RelativeLayout) this.w.inflate();
        if (this.f6493a.v() != null && this.f6493a.v().g() != null) {
            com.bytedance.sdk.openadsdk.g.d.a(this.n).a(this.f6493a.v().g(), this.f6498f);
        }
        this.f6498f = (ImageView) findViewById(t.e(this.n, "tt_native_video_img_id"));
        this.h = (ImageView) findViewById(t.e(this.n, "tt_native_video_play"));
        k();
    }

    public c getNativeVideoController() {
        return this.f6494b;
    }

    public boolean h() {
        return this.p;
    }

    public void i() {
        h hVarU;
        c cVar = this.f6494b;
        if (cVar == null || (hVarU = cVar.u()) == null) {
            return;
        }
        hVarU.e();
        View viewS = hVarU.s();
        if (viewS != null) {
            viewS.setVisibility(8);
            if (viewS.getParent() != null) {
                ((ViewGroup) viewS.getParent()).removeView(viewS);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        n();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        o();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        n();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a aVar;
        c cVar;
        if (!this.q && (aVar = this.m) != null && (cVar = this.f6494b) != null) {
            aVar.a(cVar.v(), this.f6494b.r(), this.f6494b.o(), this.f6494b.m(), this.p);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        o();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        c cVar;
        c cVar2;
        c cVar3;
        c cVar4;
        super.onWindowFocusChanged(z);
        t();
        if (r() && (cVar4 = this.f6494b) != null && cVar4.v()) {
            s();
            ac.a((View) this.f6497e, 8);
            b(true);
            e();
            return;
        }
        c();
        if (!w() && h() && (cVar2 = this.f6494b) != null && !cVar2.s()) {
            if (this.t != null) {
                if (z && (cVar3 = this.f6494b) != null && !cVar3.v()) {
                    this.t.obtainMessage(1).sendToTarget();
                    return;
                } else {
                    this.t.removeMessages(1);
                    c(false);
                    return;
                }
            }
            return;
        }
        if (h()) {
            return;
        }
        if (!z && (cVar = this.f6494b) != null && cVar.t() != null && this.f6494b.t().g()) {
            this.t.removeMessages(1);
            c(false);
        } else if (z) {
            this.t.obtainMessage(1).sendToTarget();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        c cVar;
        c cVar2;
        c cVar3;
        super.onWindowVisibilityChanged(i);
        t();
        if (this.z) {
            this.z = i == 0;
        }
        if (r() && (cVar3 = this.f6494b) != null && cVar3.v()) {
            s();
            ac.a((View) this.f6497e, 8);
            b(true);
            e();
            return;
        }
        c();
        if (w() || !h() || (cVar = this.f6494b) == null || cVar.s()) {
            return;
        }
        if (this.r) {
            this.f6494b.a(this.f6493a.v().h(), this.f6493a.J(), this.o.getWidth(), this.o.getHeight(), null, this.f6493a.M(), this.s, v());
            this.r = false;
            ac.a((View) this.f6497e, 8);
        }
        if (i != 0 || this.t == null || (cVar2 = this.f6494b) == null || cVar2.v()) {
            return;
        }
        this.t.obtainMessage(1).sendToTarget();
    }

    public void setControllerStatusCallBack(a aVar) {
        this.m = aVar;
    }

    public void setDrawVideoListener(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        c cVar = this.f6494b;
        if (cVar != null) {
            ((f) cVar).a(drawVideoListener);
        }
    }

    public void setIsAutoPlay(boolean z) {
        if (this.u) {
            return;
        }
        int iC = com.bytedance.sdk.openadsdk.core.o.h().c(ab.d(this.f6493a.M()));
        if (z && iC != 4 && (!q.e(this.n) ? !q.d(this.n) : !u())) {
            z = false;
        }
        this.p = z;
        c cVar = this.f6494b;
        if (cVar != null) {
            cVar.e(this.p);
        }
        if (this.p) {
            ac.a((View) this.f6497e, 8);
        } else {
            g();
            RelativeLayout relativeLayout = this.f6497e;
            if (relativeLayout != null) {
                ac.a((View) relativeLayout, 0);
                com.bytedance.sdk.openadsdk.g.d.a(this.n).a(this.f6493a.v().g(), this.f6498f);
            }
        }
        this.u = true;
    }

    public void setIsQuiet(boolean z) {
        this.f6496d = z;
        c cVar = this.f6494b;
        if (cVar != null) {
            cVar.c(z);
        }
    }

    public void setNativeVideoAdListener(c.a aVar) {
        c cVar = this.f6494b;
        if (cVar != null) {
            cVar.a(aVar);
        }
    }

    public void setNativeVideoController(c cVar) {
        this.f6494b = cVar;
    }

    public void setVideoAdClickListener(b bVar) {
        c cVar = this.f6494b;
        if (cVar != null) {
            ((f) cVar).a(bVar);
        }
    }

    public void setVideoAdInteractionListener(c.b bVar) {
        this.x = bVar;
    }

    public void setVideoAdLoadListener(c.InterfaceC0084c interfaceC0084c) {
        c cVar = this.f6494b;
        if (cVar != null) {
            cVar.a(interfaceC0084c);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 4 || i == 8) {
            p();
        }
    }

    public NativeVideoTsView(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, boolean z) {
        this(context, hVar, z, "embeded_ad");
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void a(long j, int i) {
        c.b bVar = this.x;
        if (bVar != null) {
            bVar.d_();
        }
    }

    public NativeVideoTsView(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, boolean z, String str) {
        super(context);
        this.p = true;
        this.f6496d = true;
        this.q = false;
        this.i = "embeded_ad";
        this.j = 50;
        this.r = true;
        this.k = new AtomicBoolean(false);
        this.t = new ad(this);
        this.u = false;
        this.v = Build.MODEL;
        this.l = false;
        this.y = new AtomicBoolean(false);
        this.z = true;
        this.A = new AtomicBoolean(false);
        this.i = str;
        this.n = context;
        this.f6493a = hVar;
        this.q = z;
        setContentDescription("NativeVideoAdView");
        c();
        j();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void a(long j, long j2) {
        c.b bVar = this.x;
        if (bVar != null) {
            bVar.a(j, j2);
        }
    }

    private View a(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        frameLayout.setId(t.e(this.n, "tt_native_video_layout"));
        layoutParams.gravity = 17;
        frameLayout.setVisibility(8);
        this.o = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        frameLayout2.setId(t.e(this.n, "tt_native_video_frame"));
        layoutParams2.gravity = 17;
        frameLayout2.setLayoutParams(layoutParams2);
        frameLayout.addView(frameLayout2);
        this.f6495c = frameLayout2;
        ViewStub viewStub = new ViewStub(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        viewStub.setId(t.e(this.n, "tt_native_video_img_cover_viewStub"));
        viewStub.setLayoutResource(t.f(this.n, "tt_native_video_img_cover_layout"));
        viewStub.setLayoutParams(layoutParams3);
        frameLayout.addView(viewStub);
        this.w = viewStub;
        return frameLayout;
    }

    private void c(boolean z) {
        if (this.f6493a == null || this.f6494b == null) {
            return;
        }
        boolean zR = r();
        s();
        if (zR && this.f6494b.v()) {
            o.b("NativeVideoAdView", "changeVideoStatus---isFromDetailPage()=" + zR + "，mNativeVideoController.isPlayComplete()=" + this.f6494b.v());
            b(true);
            e();
            return;
        }
        if (z && !this.f6494b.v() && !this.f6494b.s()) {
            if (this.f6494b.t() != null && this.f6494b.t().i()) {
                if (this.p) {
                    if ("ALP-AL00".equals(this.v)) {
                        this.f6494b.j();
                    } else {
                        ((f) this.f6494b).g(zR);
                    }
                    c.b bVar = this.x;
                    if (bVar != null) {
                        bVar.c();
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.p && this.f6494b.t() == null) {
                if (!this.y.get()) {
                    this.y.set(true);
                }
                this.A.set(false);
                n();
                return;
            }
            return;
        }
        if (this.f6494b.t() == null || !this.f6494b.t().g()) {
            return;
        }
        this.f6494b.h();
        c.b bVar2 = this.x;
        if (bVar2 != null) {
            bVar2.d();
        }
    }

    public boolean a(long j, boolean z, boolean z2) {
        c cVar;
        this.o.setVisibility(0);
        if (this.f6494b == null) {
            this.f6494b = new f(this.n, this.f6495c, this.f6493a, this.i);
            m();
        }
        this.s = j;
        if (!w()) {
            return true;
        }
        this.f6494b.b(false);
        boolean zA = this.f6494b.a(this.f6493a.v().h(), this.f6493a.J(), this.o.getWidth(), this.o.getHeight(), null, this.f6493a.M(), j, v());
        if (((j > 0 && !z && !z2) || (j > 0 && z)) && (cVar = this.f6494b) != null) {
            com.bytedance.sdk.openadsdk.c.d.a(this.n, this.f6493a, this.i, "feed_continue", cVar.o(), this.f6494b.q(), ab.a(this.f6493a, this.f6494b.n(), this.f6494b.t()));
        }
        return zA;
    }

    @Override // com.bytedance.sdk.openadsdk.utils.ad.a
    public void a(Message message) {
        if (message.what != 1) {
            return;
        }
        q();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.f.a
    public void a(int i) {
        c();
    }

    protected void a(boolean z) {
        if (this.g == null) {
            this.g = new ImageView(getContext());
            if (com.bytedance.sdk.openadsdk.core.h.b().q() != null) {
                this.g.setImageBitmap(com.bytedance.sdk.openadsdk.core.h.b().q());
            } else {
                this.g.setImageResource(t.d(com.bytedance.sdk.openadsdk.core.o.a(), "tt_new_play_video"));
            }
            this.g.setScaleType(ImageView.ScaleType.FIT_XY);
            int iA = (int) ac.a(getContext(), this.j);
            int iA2 = (int) ac.a(getContext(), 10.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iA, iA);
            layoutParams.gravity = 17;
            layoutParams.rightMargin = iA2;
            layoutParams.bottomMargin = iA2;
            this.o.addView(this.g, layoutParams);
        }
        if (z) {
            this.g.setVisibility(0);
        } else {
            this.g.setVisibility(8);
        }
    }
}
