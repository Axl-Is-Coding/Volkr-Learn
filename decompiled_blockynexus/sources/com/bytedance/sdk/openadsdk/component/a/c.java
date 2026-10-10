package com.bytedance.sdk.openadsdk.component.a;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.x;

/* JADX INFO: compiled from: TTFeedAdImpl.java */
/* JADX INFO: loaded from: classes.dex */
class c extends com.bytedance.sdk.openadsdk.core.e.a implements TTFeedAd, c.b, c.InterfaceC0084c, a.InterfaceC0093a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.bytedance.sdk.openadsdk.multipro.b.a f5809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f5810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f5811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f5812d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    AdSlot f5813e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f5814f;
    private TTFeedAd.VideoAdListener m;

    c(Context context, h hVar, int i) {
        super(context, hVar, i);
        this.f5810b = false;
        this.f5811c = true;
        this.f5814f = i;
        this.f5809a = new com.bytedance.sdk.openadsdk.multipro.b.a();
        this.f5812d = ab.d(this.h.M());
        a(this.f5812d);
        a("embeded_ad");
    }

    public void c() {
        TTFeedAd.VideoAdListener videoAdListener = this.m;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdContinuePlay(this);
        }
    }

    public void d() {
        TTFeedAd.VideoAdListener videoAdListener = this.m;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdPaused(this);
        }
    }

    public void d_() {
        TTFeedAd.VideoAdListener videoAdListener = this.m;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdComplete(this);
        }
    }

    public void e() {
        TTFeedAd.VideoAdListener videoAdListener = this.m;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdStartPlay(this);
        }
    }

    public void f() {
        TTFeedAd.VideoAdListener videoAdListener = this.m;
        if (videoAdListener != null) {
            videoAdListener.onVideoLoad(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.e.a, com.bytedance.sdk.openadsdk.TTNativeAd
    public View getAdView() {
        NativeVideoTsView nativeVideoTsView;
        h hVar = this.h;
        if (hVar != null && this.i != null) {
            if (x.a(hVar)) {
                try {
                    nativeVideoTsView = new NativeVideoTsView(this.i, this.h);
                    if (x.b(this.h)) {
                        nativeVideoTsView.setVideoAdClickListener(new NativeVideoTsView.b() { // from class: com.bytedance.sdk.openadsdk.component.a.c.1
                            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.b
                            public void a(View view, int i) {
                                if (((com.bytedance.sdk.openadsdk.core.e.a) c.this).g != null) {
                                    ((com.bytedance.sdk.openadsdk.core.e.a) c.this).g.a(view, i);
                                }
                            }
                        });
                    }
                    nativeVideoTsView.setControllerStatusCallBack(new NativeVideoTsView.a() { // from class: com.bytedance.sdk.openadsdk.component.a.c.2
                        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.a
                        public void a(boolean z, long j, long j2, long j3, boolean z2) {
                            com.bytedance.sdk.openadsdk.multipro.b.a aVar = c.this.f5809a;
                            aVar.f7058a = z;
                            aVar.f7062e = j;
                            aVar.f7063f = j2;
                            aVar.g = j3;
                            aVar.f7061d = z2;
                        }
                    });
                    nativeVideoTsView.setVideoAdLoadListener(this);
                    nativeVideoTsView.setVideoAdInteractionListener(this);
                    if (5 == this.f5814f) {
                        nativeVideoTsView.setIsAutoPlay(this.f5810b ? this.f5813e.isAutoPlay() : this.f5811c);
                    } else {
                        nativeVideoTsView.setIsAutoPlay(this.f5811c);
                    }
                    nativeVideoTsView.setIsQuiet(o.h().a(this.f5812d));
                } catch (Exception unused) {
                    nativeVideoTsView = null;
                }
                if (!x.a(this.h) && nativeVideoTsView != null && nativeVideoTsView.a(0L, true, false)) {
                    return nativeVideoTsView;
                }
            } else {
                nativeVideoTsView = null;
                if (!x.a(this.h)) {
                }
            }
        }
        return null;
    }

    public double getVideoDuration() {
        h hVar = this.h;
        if (hVar == null || hVar.v() == null) {
            return 0.0d;
        }
        return this.h.v().e();
    }

    public void setVideoAdListener(TTFeedAd.VideoAdListener videoAdListener) {
        this.m = videoAdListener;
    }

    private void a(int i) {
        int iC = o.h().c(i);
        if (3 == iC) {
            this.f5810b = false;
            this.f5811c = false;
            return;
        }
        if (1 == iC && q.d(this.i)) {
            this.f5810b = false;
            this.f5811c = true;
        } else if (2 != iC) {
            if (4 == iC) {
                this.f5810b = true;
            }
        } else if (q.e(this.i) || q.d(this.i)) {
            this.f5810b = false;
            this.f5811c = true;
        }
    }

    c(Context context, h hVar, int i, AdSlot adSlot) {
        super(context, hVar, i);
        this.f5810b = false;
        this.f5811c = true;
        this.f5814f = i;
        this.f5813e = adSlot;
        this.f5809a = new com.bytedance.sdk.openadsdk.multipro.b.a();
        this.f5812d = ab.d(this.h.M());
        a(this.f5812d);
        a("embeded_ad");
    }

    public void a(int i, int i2) {
        TTFeedAd.VideoAdListener videoAdListener = this.m;
        if (videoAdListener != null) {
            videoAdListener.onVideoError(i, i2);
        }
    }

    public void a(long j, long j2) {
        TTFeedAd.VideoAdListener videoAdListener = this.m;
        if (videoAdListener != null) {
            videoAdListener.onProgressUpdate(j, j2);
        }
    }

    public com.bytedance.sdk.openadsdk.multipro.b.a a() {
        return this.f5809a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.e.a
    protected void a(String str) {
        super.a(str);
    }
}
