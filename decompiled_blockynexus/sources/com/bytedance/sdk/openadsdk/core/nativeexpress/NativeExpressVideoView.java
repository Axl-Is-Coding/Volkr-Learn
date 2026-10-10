package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.o;
import com.bytedance.sdk.openadsdk.utils.q;

/* JADX INFO: loaded from: classes.dex */
public class NativeExpressVideoView extends NativeExpressView implements g, c.b, c.InterfaceC0084c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f6273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f6274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f6275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f6276d;
    private ExpressVideoView t;
    private com.bytedance.sdk.openadsdk.multipro.b.a u;
    private long v;
    private long w;

    public NativeExpressVideoView(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, AdSlot adSlot, String str) {
        super(context, hVar, adSlot, str);
        this.f6273a = 1;
        this.f6274b = false;
        this.f6275c = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.sdk.openadsdk.core.d.j jVar) {
        if (jVar == null) {
            return;
        }
        double d2 = jVar.d();
        double dE = jVar.e();
        double dF = jVar.f();
        double dG = jVar.g();
        int iA = (int) ac.a(this.f6285f, (float) d2);
        int iA2 = (int) ac.a(this.f6285f, (float) dE);
        int iA3 = (int) ac.a(this.f6285f, (float) dF);
        int iA4 = (int) ac.a(this.f6285f, (float) dG);
        o.b("ExpressView", "videoWidth:" + dF);
        o.b("ExpressView", "videoHeight:" + dG);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.m.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(iA3, iA4);
        }
        layoutParams.width = iA3;
        layoutParams.height = iA4;
        layoutParams.topMargin = iA2;
        layoutParams.leftMargin = iA;
        this.m.setLayoutParams(layoutParams);
        this.m.removeAllViews();
        this.m.addView(this.t);
        this.t.a(0L, true, false);
        setShowAdInteractionView(false);
    }

    private void n() {
        try {
            this.u = new com.bytedance.sdk.openadsdk.multipro.b.a();
            this.t = new ExpressVideoView(this.f6285f, this.k, this.i);
            this.t.setShouldCheckNetChange(false);
            this.t.setControllerStatusCallBack(new NativeVideoTsView.a() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.1
                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.a
                public void a(boolean z, long j, long j2, long j3, boolean z2) {
                    NativeExpressVideoView.this.u.f7058a = z;
                    NativeExpressVideoView.this.u.f7062e = j;
                    NativeExpressVideoView.this.u.f7063f = j2;
                    NativeExpressVideoView.this.u.g = j3;
                    NativeExpressVideoView.this.u.f7061d = z2;
                }
            });
            this.t.setVideoAdLoadListener(this);
            this.t.setVideoAdInteractionListener(this);
            if ("embeded_ad".equals(this.i)) {
                this.t.setIsAutoPlay(this.f6274b ? this.j.isAutoPlay() : this.f6275c);
            } else if ("splash_ad".equals(this.i)) {
                this.t.setIsAutoPlay(true);
            } else {
                this.t.setIsAutoPlay(this.f6275c);
            }
            if ("splash_ad".equals(this.i)) {
                this.t.setIsQuiet(true);
            } else {
                this.t.setIsQuiet(com.bytedance.sdk.openadsdk.core.o.h().a(this.f6276d));
            }
            this.t.e();
        } catch (Exception unused) {
            this.t = null;
        }
    }

    private void setShowAdInteractionView(boolean z) {
        ExpressVideoView expressVideoView = this.t;
        if (expressVideoView != null) {
            expressVideoView.setShowAdInteractionView(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void K() {
        o.b("NativeExpressVideoView", "onSkipVideo");
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public long L() {
        return this.v;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public int M() {
        if (this.t.getNativeVideoController().w()) {
            return 1;
        }
        return this.f6273a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void N() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    protected void b() {
        super.b();
        this.h.a((g) this);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void d() {
        o.b("NativeExpressVideoView", "onVideoAdPaused");
        TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.l;
        if (expressVideoAdListener != null) {
            expressVideoAdListener.onVideoAdPaused();
        }
        this.n = true;
        this.f6273a = 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void d_() {
        o.b("NativeExpressVideoView", "onVideoComplete");
        TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.l;
        if (expressVideoAdListener != null) {
            expressVideoAdListener.onVideoAdComplete();
        }
        this.f6273a = 5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void e(boolean z) {
        o.b("NativeExpressVideoView", "onMuteVideo,mute:" + z);
        ExpressVideoView expressVideoView = this.t;
        if (expressVideoView == null || expressVideoView.getNativeVideoController() == null) {
            return;
        }
        this.t.getNativeVideoController().c(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.InterfaceC0084c
    public void f() {
        o.b("NativeExpressVideoView", "onVideoLoad");
        TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.l;
        if (expressVideoAdListener != null) {
            expressVideoAdListener.onVideoLoad();
        }
    }

    public com.bytedance.sdk.openadsdk.multipro.b.a getVideoModel() {
        return this.u;
    }

    public void setCanInterruptVideoPlay(boolean z) {
        ExpressVideoView expressVideoView = this.t;
        if (expressVideoView != null) {
            expressVideoView.setCanInterruptVideoPlay(z);
        }
    }

    private void b(final com.bytedance.sdk.openadsdk.core.d.j jVar) {
        if (jVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c(jVar);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.2
                @Override // java.lang.Runnable
                public void run() {
                    NativeExpressVideoView.this.c(jVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    protected void a() {
        this.m = new FrameLayout(this.f6285f);
        this.f6276d = ab.d(this.k.M());
        a(this.f6276d);
        n();
        addView(this.m, new FrameLayout.LayoutParams(-1, -1));
        super.a();
        getWebView().setBackgroundColor(0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void e() {
        o.b("NativeExpressVideoView", "onVideoAdStartPlay");
        TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.l;
        if (expressVideoAdListener != null) {
            expressVideoAdListener.onVideoAdStartPlay();
        }
        this.f6273a = 2;
    }

    void a(int i) {
        int iC = com.bytedance.sdk.openadsdk.core.o.h().c(i);
        if (3 == iC) {
            this.f6274b = false;
            this.f6275c = false;
            return;
        }
        if (1 == iC && q.d(this.f6285f)) {
            this.f6274b = false;
            this.f6275c = true;
        } else if (2 != iC) {
            if (4 == iC) {
                this.f6274b = true;
            }
        } else if (q.e(this.f6285f) || q.d(this.f6285f)) {
            this.f6274b = false;
            this.f6275c = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(com.bytedance.sdk.openadsdk.core.d.j jVar) {
        if (jVar != null && jVar.a()) {
            b(jVar);
        }
        super.a(jVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void c(int i) {
        o.b("NativeExpressVideoView", "onChangeVideoState,stateType:" + i);
        if (i == 1) {
            this.t.a(0L, true, false);
            return;
        }
        if (i == 2 || i == 3) {
            this.t.setCanInterruptVideoPlay(true);
            this.t.performClick();
        } else if (i == 4) {
            this.t.getNativeVideoController().l();
        } else {
            if (i != 5) {
                return;
            }
            this.t.a(0L, true, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(int i, com.bytedance.sdk.openadsdk.core.d.f fVar) {
        if (i == -1 || fVar == null) {
            return;
        }
        if (i == 4 && this.i == "draw_ad") {
            ExpressVideoView expressVideoView = this.t;
            if (expressVideoView != null) {
                expressVideoView.performClick();
                return;
            }
            return;
        }
        super.a(i, fVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void a(long j, long j2) {
        TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.l;
        if (expressVideoAdListener != null) {
            expressVideoAdListener.onProgressUpdate(j, j2);
        }
        int i = this.f6273a;
        if (i != 5 && i != 3 && j > this.v) {
            this.f6273a = 2;
        }
        this.v = j;
        this.w = j2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void c() {
        o.b("NativeExpressVideoView", "onVideoAdContinuePlay");
        TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.l;
        if (expressVideoAdListener != null) {
            expressVideoAdListener.onVideoAdContinuePlay();
        }
        this.n = false;
        this.f6273a = 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.InterfaceC0084c
    public void a(int i, int i2) {
        o.b("NativeExpressVideoView", "onVideoError,errorCode:" + i + ",extraCode:" + i2);
        TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.l;
        if (expressVideoAdListener != null) {
            expressVideoAdListener.onVideoError(i, i2);
        }
        this.v = this.w;
        this.f6273a = 4;
    }
}
