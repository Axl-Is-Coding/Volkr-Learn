package com.bytedance.sdk.openadsdk.component.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.x;

/* JADX INFO: compiled from: TTDrawFeedAdImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends c implements TTDrawFeedAd {
    private boolean m;
    private Bitmap n;
    private int o;
    private TTDrawFeedAd.DrawVideoListener p;

    public b(Context context, h hVar, int i) {
        super(context, hVar, i);
        a("embeded_ad");
    }

    private void g() {
        int i = this.o;
        if (i >= 200) {
            this.o = 200;
        } else if (i <= 20) {
            this.o = 20;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.multipro.b.a.InterfaceC0093a
    public /* bridge */ /* synthetic */ com.bytedance.sdk.openadsdk.multipro.b.a a() {
        return super.a();
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public /* bridge */ /* synthetic */ void d_() {
        super.d_();
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public /* bridge */ /* synthetic */ void e() {
        super.e();
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.InterfaceC0084c
    public /* bridge */ /* synthetic */ void f() {
        super.f();
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.e.a, com.bytedance.sdk.openadsdk.TTNativeAd
    public View getAdView() {
        NativeDrawVideoTsView nativeDrawVideoTsView;
        h hVar = this.h;
        if (hVar != null && this.i != null) {
            if (x.a(hVar)) {
                try {
                    nativeDrawVideoTsView = new NativeDrawVideoTsView(this.i, this.h);
                    nativeDrawVideoTsView.setControllerStatusCallBack(new NativeVideoTsView.a() { // from class: com.bytedance.sdk.openadsdk.component.a.b.1
                        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.a
                        public void a(boolean z, long j, long j2, long j3, boolean z2) {
                            com.bytedance.sdk.openadsdk.multipro.b.a aVar = ((c) b.this).f5809a;
                            aVar.f7058a = z;
                            aVar.f7062e = j;
                            aVar.f7063f = j2;
                            aVar.g = j3;
                            aVar.f7061d = z2;
                        }
                    });
                    nativeDrawVideoTsView.setVideoAdLoadListener(this);
                    nativeDrawVideoTsView.setVideoAdInteractionListener(this);
                    int iD = ab.d(this.h.M());
                    nativeDrawVideoTsView.setIsAutoPlay(a(iD));
                    nativeDrawVideoTsView.setIsQuiet(o.h().a(iD));
                    nativeDrawVideoTsView.setCanInterruptVideoPlay(this.m);
                    if (this.n != null) {
                        nativeDrawVideoTsView.a(this.n, this.o);
                    }
                    nativeDrawVideoTsView.setDrawVideoListener(this.p);
                } catch (Exception unused) {
                    nativeDrawVideoTsView = null;
                }
                if (!x.a(this.h) && nativeDrawVideoTsView != null && nativeDrawVideoTsView.a(0L, true, false)) {
                    return nativeDrawVideoTsView;
                }
            } else {
                nativeDrawVideoTsView = null;
                if (!x.a(this.h)) {
                }
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.TTFeedAd
    public /* bridge */ /* synthetic */ double getVideoDuration() {
        return super.getVideoDuration();
    }

    @Override // com.bytedance.sdk.openadsdk.TTDrawFeedAd
    public void setCanInterruptVideoPlay(boolean z) {
        this.m = z;
    }

    @Override // com.bytedance.sdk.openadsdk.TTDrawFeedAd
    public void setDrawVideoListener(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        this.p = drawVideoListener;
    }

    @Override // com.bytedance.sdk.openadsdk.TTDrawFeedAd
    public void setPauseIcon(Bitmap bitmap, int i) {
        this.n = bitmap;
        this.o = i;
        g();
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.TTFeedAd
    public /* bridge */ /* synthetic */ void setVideoAdListener(TTFeedAd.VideoAdListener videoAdListener) {
        super.setVideoAdListener(videoAdListener);
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.InterfaceC0084c
    public /* bridge */ /* synthetic */ void a(int i, int i2) {
        super.a(i, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public /* bridge */ /* synthetic */ void a(long j, long j2) {
        super.a(j, j2);
    }

    private boolean a(int i) {
        int iC = o.h().c(i);
        if (3 == iC) {
            return false;
        }
        if (1 != iC || !q.d(this.i)) {
            if (2 != iC) {
                return false;
            }
            if (!q.e(this.i) && !q.d(this.i)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.e.a
    protected void a(String str) {
        super.a(str);
    }
}
