package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.d.f;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.nativeexpress.FullRewardExpressBackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.c;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.o;

/* JADX INFO: loaded from: classes.dex */
public class FullRewardExpressView extends NativeExpressView implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    g f5975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    FullRewardExpressBackupView f5976b;

    public FullRewardExpressView(Context context, h hVar, AdSlot adSlot, String str) {
        super(context, hVar, adSlot, str);
    }

    private void c() {
        setBackupListener(new c() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.FullRewardExpressView.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public boolean a(NativeExpressView nativeExpressView, int i) {
                nativeExpressView.l();
                FullRewardExpressView.this.f5976b = new FullRewardExpressBackupView(nativeExpressView.getContext());
                FullRewardExpressView fullRewardExpressView = FullRewardExpressView.this;
                fullRewardExpressView.f5976b.a(((NativeExpressView) fullRewardExpressView).k, nativeExpressView, null);
                return true;
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void K() {
        o.b("FullRewardExpressView", "onSkipVideo");
        g gVar = this.f5975a;
        if (gVar != null) {
            gVar.K();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public long L() {
        o.b("FullRewardExpressView", "onGetCurrentPlayTime");
        g gVar = this.f5975a;
        if (gVar != null) {
            return gVar.L();
        }
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public int M() {
        o.b("FullRewardExpressView", "onGetVideoState");
        g gVar = this.f5975a;
        if (gVar != null) {
            return gVar.M();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void N() {
        g gVar = this.f5975a;
        if (gVar != null) {
            gVar.N();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    protected void b() {
        super.b();
        this.h.a((g) this);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void e(boolean z) {
        o.b("FullRewardExpressView", "onMuteVideo,mute:" + z);
        g gVar = this.f5975a;
        if (gVar != null) {
            gVar.e(z);
        }
    }

    public FrameLayout getVideoFrameLayout() {
        return m() ? this.f5976b.getVideoContainer() : this.m;
    }

    public void setExpressVideoListenerProxy(g gVar) {
        this.f5975a = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(j jVar) {
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
    }

    private void b(final j jVar) {
        if (jVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c(jVar);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.FullRewardExpressView.2
                @Override // java.lang.Runnable
                public void run() {
                    FullRewardExpressView.this.c(jVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    protected void a() {
        this.o = true;
        this.m = new FrameLayout(this.f6285f);
        addView(this.m, new FrameLayout.LayoutParams(-1, -1));
        super.a();
        getWebView().setBackgroundColor(0);
        c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(j jVar) {
        if (jVar != null && jVar.a()) {
            b(jVar);
        }
        super.a(jVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(int i, f fVar) {
        if (i != -1 && fVar != null && i == 3) {
            N();
        }
        super.a(i, fVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void c(int i) {
        o.b("FullRewardExpressView", "onChangeVideoState,stateType:" + i);
        g gVar = this.f5975a;
        if (gVar != null) {
            gVar.c(i);
        }
    }
}
