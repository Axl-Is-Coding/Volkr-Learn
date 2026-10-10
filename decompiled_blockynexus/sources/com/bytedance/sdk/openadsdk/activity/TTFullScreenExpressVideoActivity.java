package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import b.a.a.a.a.a.b;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.component.reward.top.TopProxyLayout;
import com.bytedance.sdk.openadsdk.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.e;
import com.bytedance.sdk.openadsdk.core.nativeexpress.g;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.o;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class TTFullScreenExpressVideoActivity extends TTFullScreenVideoActivity implements TTNativeExpressAd.ExpressAdInteractionListener, g {
    FullRewardExpressView aP;
    FrameLayout aQ;
    long aR;
    b aS;
    Handler aU;
    String aT = "fullscreen_interstitial_ad";
    boolean aV = false;
    boolean aW = false;

    private void f(boolean z) {
        if (this.f5620f != null) {
            if (this.v.r()) {
                if (!this.V.get()) {
                    this.f5620f.setShowSound(z);
                    if (this.v.X()) {
                        this.f5620f.setShowDislike(z);
                    } else {
                        this.f5620f.setShowDislike(false);
                    }
                }
            } else if (!this.V.get()) {
                this.f5620f.setShowSkip(z);
                this.f5620f.setShowSound(z);
                if (this.v.X()) {
                    this.f5620f.setShowDislike(z);
                } else {
                    this.f5620f.setShowDislike(false);
                }
            }
        }
        if (z) {
            ac.a((View) this.g, 0);
            ac.a((View) this.aw, 0);
        } else {
            ac.a((View) this.g, 4);
            ac.a((View) this.aw, 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity
    protected void J() {
        if (this.v == null) {
            finish();
        } else {
            this.aG = false;
            super.J();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void K() {
        TopProxyLayout topProxyLayout = this.f5620f;
        if (topProxyLayout != null) {
            topProxyLayout.a();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public long L() {
        return this.aR;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public int M() {
        if (this.aV) {
            return 4;
        }
        if (this.aW) {
            return 5;
        }
        if (u()) {
            return 1;
        }
        if (s()) {
            return 2;
        }
        if (t()) {
        }
        return 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void N() {
        I();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.core.video.d.b
    public void O() {
        super.O();
        FullRewardExpressView fullRewardExpressView = this.aP;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.g();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.core.video.d.b
    public boolean a(long j, boolean z) {
        this.aQ = this.aP.getVideoFrameLayout();
        if (this.F == null) {
            this.F = new com.bytedance.sdk.openadsdk.component.reward.b(this.h, this.aQ, this.v);
        }
        HashMap map = new HashMap();
        map.put("dynamic_show_type", Integer.valueOf(this.aP.m() ? 1 : 0));
        if (!TextUtils.isEmpty(this.af)) {
            map.put("rit_scene", this.af);
        }
        this.F.a(map);
        this.F.a(new c.a() { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j2, int i) {
                ad adVar = TTFullScreenExpressVideoActivity.this.K;
                if (adVar != null) {
                    adVar.removeMessages(300);
                }
                TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity = TTFullScreenExpressVideoActivity.this;
                tTFullScreenExpressVideoActivity.aW = true;
                tTFullScreenExpressVideoActivity.R();
                if (TTFullScreenExpressVideoActivity.this.P()) {
                    TTFullScreenExpressVideoActivity.this.r();
                } else {
                    TTFullScreenExpressVideoActivity.this.finish();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void b() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void b(long j2, int i) {
                ad adVar = TTFullScreenExpressVideoActivity.this.K;
                if (adVar != null) {
                    adVar.removeMessages(300);
                }
                if (TTFullScreenExpressVideoActivity.this.s()) {
                    return;
                }
                c cVar = TTFullScreenExpressVideoActivity.this.F;
                if (cVar != null) {
                    cVar.l();
                }
                o.e("TTFullScreenExpressVideoActivity", "onError、、、、、、、、");
                if (TTFullScreenExpressVideoActivity.this.P()) {
                    TTFullScreenExpressVideoActivity.this.r();
                    HashMap map2 = new HashMap();
                    map2.put("vbtt_skip_type", 1);
                    TTFullScreenExpressVideoActivity.this.a("fullscreen_interstitial_ad", map2);
                } else {
                    TTFullScreenExpressVideoActivity.this.finish();
                }
                TTFullScreenExpressVideoActivity.this.aV = true;
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a() {
                ad adVar = TTFullScreenExpressVideoActivity.this.K;
                if (adVar != null) {
                    adVar.removeMessages(300);
                }
                o.b("TTFullScreenExpressVideoActivity", "onTimeOut、、、、、、、、");
                if (TTFullScreenExpressVideoActivity.this.P()) {
                    TTFullScreenExpressVideoActivity.this.r();
                } else {
                    TTFullScreenExpressVideoActivity.this.finish();
                }
                HashMap map2 = new HashMap();
                map2.put("vbtt_skip_type", 0);
                TTFullScreenExpressVideoActivity.this.a("fullscreen_interstitial_ad", map2);
                c cVar = TTFullScreenExpressVideoActivity.this.F;
                if (cVar != null) {
                    cVar.l();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j2, long j3) {
                TopProxyLayout topProxyLayout;
                ad adVar = TTFullScreenExpressVideoActivity.this.K;
                if (adVar != null) {
                    adVar.removeMessages(300);
                }
                TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity = TTFullScreenExpressVideoActivity.this;
                tTFullScreenExpressVideoActivity.aR = j2;
                double dH = tTFullScreenExpressVideoActivity.H();
                long j4 = j2 / 1000;
                double d2 = j4;
                Double.isNaN(d2);
                tTFullScreenExpressVideoActivity.R = (int) (dH - d2);
                if (TTFullScreenExpressVideoActivity.this.aP.m()) {
                    TTFullScreenExpressVideoActivity.this.d((int) j4);
                    TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity2 = TTFullScreenExpressVideoActivity.this;
                    if (tTFullScreenExpressVideoActivity2.R >= 0 && (topProxyLayout = tTFullScreenExpressVideoActivity2.f5620f) != null) {
                        topProxyLayout.setShowSkip(true);
                        TTFullScreenExpressVideoActivity tTFullScreenExpressVideoActivity3 = TTFullScreenExpressVideoActivity.this;
                        tTFullScreenExpressVideoActivity3.f5620f.a(String.valueOf(tTFullScreenExpressVideoActivity3.R), (CharSequence) null);
                    }
                }
                if (TTFullScreenExpressVideoActivity.this.R <= 0) {
                    o.b("TTFullScreenExpressVideoActivity", "onProgressUpdate、、、、、、、、");
                    if (TTFullScreenExpressVideoActivity.this.P()) {
                        TTFullScreenExpressVideoActivity.this.r();
                    } else {
                        TTFullScreenExpressVideoActivity.this.finish();
                    }
                }
                if ((TTFullScreenExpressVideoActivity.this.ab.get() || TTFullScreenExpressVideoActivity.this.Z.get()) && TTFullScreenExpressVideoActivity.this.s()) {
                    TTFullScreenExpressVideoActivity.this.F.h();
                }
            }
        });
        String strH = this.v.v() != null ? this.v.v().h() : null;
        String str = this.A;
        if (str != null) {
            File file = new File(str);
            if (file.exists() && file.length() > 0) {
                strH = this.A;
                this.C = true;
            }
        }
        String str2 = strH;
        o.e("wzj", "videoUrl:" + str2);
        if (this.F == null) {
            return false;
        }
        Message message = new Message();
        message.what = 300;
        message.arg1 = 0;
        this.K.sendMessageDelayed(message, 5000L);
        boolean zA = this.F.a(str2, this.v.J(), this.aQ.getWidth(), this.aQ.getHeight(), null, this.v.M(), j, this.Q);
        if (zA && !z) {
            d.a(this.h, this.v, "fullscreen_interstitial_ad", map);
            O();
        }
        return zA;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void b(String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void c(int i) {
        if (i == 1) {
            if (s() || t()) {
                return;
            }
            a(0L, false);
            return;
        }
        if (i == 2) {
            try {
                if (s()) {
                    this.F.h();
                    return;
                }
                return;
            } catch (Throwable th) {
                o.e("TTFullScreenExpressVideoActivity", "onPause throw Exception :" + th.getMessage());
                return;
            }
        }
        if (i == 3) {
            try {
                if (t()) {
                    this.F.j();
                    return;
                }
                return;
            } catch (Throwable th2) {
                o.e("TTFullScreenExpressVideoActivity", "onPause throw Exception :" + th2.getMessage());
                return;
            }
        }
        if (i != 4) {
            if (i != 5 || s() || t()) {
                return;
            }
            a(0L, false);
            return;
        }
        c cVar = this.F;
        if (cVar != null) {
            cVar.k();
            this.F = null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void e() {
        super.e();
        int iD = ab.d(this.v.M());
        boolean z = this.v.N() == 15;
        float fA = a((Activity) this);
        float fB = b((Activity) this);
        if (z != (fA > fB)) {
            float f2 = fA + fB;
            fB = f2 - fB;
            fA = f2 - fB;
        }
        if (ac.b((Activity) this)) {
            int iB = ac.b(this, ac.i(this));
            if (z) {
                fA -= iB;
            } else {
                fB -= iB;
            }
        }
        o.e("TTFullScreenExpressVideoActivity", "screen height:" + fA + ", width:" + fB);
        this.aP = new FullRewardExpressView(this, this.v, new AdSlot.Builder().setCodeId(String.valueOf(iD)).setExpressViewAcceptedSize(fB, fA).build(), this.aT);
        this.aP.setExpressVideoListenerProxy(this);
        this.aP.setExpressInteractionListener(this);
        a(this.aP, this.v);
        this.aQ = this.aP.getVideoFrameLayout();
        this.r.addView(this.aP, new FrameLayout.LayoutParams(-1, -1));
        l();
        a(this.Q);
        k();
        q();
        j();
        a("reward_endcard");
        o();
        if (!h.b(this.v)) {
            d(true);
            this.aP.h();
        } else {
            this.aG = true;
            this.U = ab.d(this.v.M());
            g();
            r();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Handler handler = this.aU;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        FullRewardExpressView fullRewardExpressView = this.aP;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.k();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i) {
        this.aG = true;
        g();
        if (this.aU == null) {
            this.aU = new Handler(Looper.getMainLooper());
        }
        o.b("TTFullScreenExpressVideoActivity", "onRenderFail、、、code:" + i);
        this.aU.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity.2
            @Override // java.lang.Runnable
            public void run() {
                TTFullScreenExpressVideoActivity.this.r();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        if (this.v.c() == 1 && this.v.r()) {
            return;
        }
        if (this.aP.m()) {
            f(true);
        }
        d(false);
        this.aG = true;
        g();
        if (a(this.z, false)) {
            return;
        }
        r();
        HashMap map = new HashMap();
        map.put("vbtt_skip_type", 1);
        a(this.aT, map);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (!this.aP.m()) {
            f(false);
        }
        FullRewardExpressView fullRewardExpressView = this.aP;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.i();
        }
    }

    protected void a(NativeExpressView nativeExpressView, h hVar) {
        if (nativeExpressView == null || this.v == null) {
            return;
        }
        this.aS = a(hVar);
        d.a(hVar);
        EmptyView emptyViewA = a((ViewGroup) nativeExpressView);
        if (emptyViewA == null) {
            emptyViewA = new EmptyView(this.h, nativeExpressView);
            nativeExpressView.addView(emptyViewA);
        }
        emptyViewA.setCallback(new EmptyView.a() { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity.3
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
            }
        });
        Context context = this.h;
        String str = this.aT;
        e eVar = new e(context, hVar, str, ab.a(str)) { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity.4
            @Override // com.bytedance.sdk.openadsdk.core.a.b, com.bytedance.sdk.openadsdk.core.a.c
            public void a(View view, int i, int i2, int i3, int i4) {
                super.a(view, i, i2, i3, i4);
                TTFullScreenExpressVideoActivity.this.a(view, i, i2, i3, i4);
            }
        };
        eVar.a(nativeExpressView);
        eVar.a(this.aS);
        if (!TextUtils.isEmpty(this.af)) {
            HashMap map = new HashMap();
            map.put("rit_scene", this.af);
            eVar.a(map);
        }
        this.aP.setClickListener(eVar);
        Context context2 = this.h;
        String str2 = this.aT;
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(context2, hVar, str2, ab.a(str2)) { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity.5
            @Override // com.bytedance.sdk.openadsdk.core.a.a, com.bytedance.sdk.openadsdk.core.a.b, com.bytedance.sdk.openadsdk.core.a.c
            public void a(View view, int i, int i2, int i3, int i4) {
                super.a(view, i, i2, i3, i4);
                TTFullScreenExpressVideoActivity.this.a(view, i, i2, i3, i4);
            }
        };
        dVar.a(nativeExpressView);
        dVar.a(this.aS);
        if (!TextUtils.isEmpty(this.af)) {
            HashMap map2 = new HashMap();
            map2.put("rit_scene", this.af);
            dVar.a(map2);
        }
        this.aP.setClickCreativeListener(dVar);
        emptyViewA.setNeedCheckingShow(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void e(boolean z) {
        TopProxyLayout topProxyLayout;
        if (this.Q == z || (topProxyLayout = this.f5620f) == null) {
            return;
        }
        topProxyLayout.b();
    }

    private b a(h hVar) {
        if (hVar.x() == 4) {
            return b.a.a.a.a.a.c.a(this.h, hVar, this.aT);
        }
        return null;
    }

    private EmptyView a(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }
}
