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
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.component.reward.f;
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
public class TTRewardExpressVideoActivity extends TTRewardVideoActivity implements TTNativeExpressAd.ExpressAdInteractionListener, g {
    FullRewardExpressView aP;
    FrameLayout aQ;
    long aR;
    b aS;
    Handler aU;
    String aT = "rewarded_video";
    boolean aV = false;
    boolean aW = false;

    private void f(boolean z) {
        if (this.f5620f != null && !this.V.get()) {
            this.f5620f.setShowSkip(z);
            this.f5620f.setShowSound(z);
            if (this.v.X()) {
                this.f5620f.setShowDislike(z);
            } else {
                this.f5620f.setShowDislike(false);
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

    @Override // com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity
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
        o.e("TTRewardExpressVideoActivity", "onGetCurrentPlayTime mVideoCurrent:" + this.aR);
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

    @Override // com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity, com.bytedance.sdk.openadsdk.core.video.d.b
    public void O() {
        super.O();
        FullRewardExpressView fullRewardExpressView = this.aP;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.g();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity, com.bytedance.sdk.openadsdk.core.video.d.b
    public boolean a(long j, boolean z) {
        this.aQ = this.aP.getVideoFrameLayout();
        if (this.F == null) {
            this.F = new f(this.h, this.aQ, this.v);
        }
        HashMap map = new HashMap();
        map.put("dynamic_show_type", Integer.valueOf(this.aP.m() ? 1 : 0));
        if (!TextUtils.isEmpty(this.af)) {
            map.put("rit_scene", this.af);
        }
        this.F.a(map);
        this.F.a(new c.a() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardExpressVideoActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j2, int i) {
                ad adVar = TTRewardExpressVideoActivity.this.K;
                if (adVar != null) {
                    adVar.removeMessages(300);
                }
                TTRewardExpressVideoActivity tTRewardExpressVideoActivity = TTRewardExpressVideoActivity.this;
                tTRewardExpressVideoActivity.aW = true;
                tTRewardExpressVideoActivity.R();
                TTRewardExpressVideoActivity.this.r();
                TTRewardExpressVideoActivity.this.aY = (int) (System.currentTimeMillis() / 1000);
                TTRewardExpressVideoActivity.this.P();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void b() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void b(long j2, int i) {
                ad adVar = TTRewardExpressVideoActivity.this.K;
                if (adVar != null) {
                    adVar.removeMessages(300);
                }
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    TTRewardExpressVideoActivity.this.d("onVideoError");
                } else {
                    TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = TTRewardExpressVideoActivity.this.aZ;
                    if (rewardAdInteractionListener != null) {
                        rewardAdInteractionListener.onVideoError();
                    }
                }
                if (TTRewardExpressVideoActivity.this.s()) {
                    return;
                }
                c cVar = TTRewardExpressVideoActivity.this.F;
                if (cVar != null) {
                    cVar.l();
                }
                TTRewardExpressVideoActivity.this.r();
                TTRewardExpressVideoActivity.this.aV = true;
                HashMap map2 = new HashMap();
                map2.put("vbtt_skip_type", 1);
                TTRewardExpressVideoActivity.this.a("rewarded_video", map2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a() {
                ad adVar = TTRewardExpressVideoActivity.this.K;
                if (adVar != null) {
                    adVar.removeMessages(300);
                }
                TTRewardExpressVideoActivity.this.r();
                HashMap map2 = new HashMap();
                map2.put("vbtt_skip_type", 0);
                TTRewardExpressVideoActivity.this.a("rewarded_video", map2);
                c cVar = TTRewardExpressVideoActivity.this.F;
                if (cVar != null) {
                    cVar.l();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j2, long j3) {
                c cVar;
                TopProxyLayout topProxyLayout;
                TopProxyLayout topProxyLayout2;
                ad adVar = TTRewardExpressVideoActivity.this.K;
                if (adVar != null) {
                    adVar.removeMessages(300);
                }
                TTRewardExpressVideoActivity.this.aR = j2;
                int i = com.bytedance.sdk.openadsdk.core.o.h().r(String.valueOf(TTRewardExpressVideoActivity.this.U)).g;
                if (j3 > 0 && (100 * j2) / Float.valueOf(j3).floatValue() >= i) {
                    TTRewardExpressVideoActivity.this.P();
                }
                TTRewardExpressVideoActivity tTRewardExpressVideoActivity = TTRewardExpressVideoActivity.this;
                double dH = tTRewardExpressVideoActivity.H();
                long j4 = j2 / 1000;
                double d2 = j4;
                Double.isNaN(d2);
                tTRewardExpressVideoActivity.R = (int) (dH - d2);
                TTRewardExpressVideoActivity tTRewardExpressVideoActivity2 = TTRewardExpressVideoActivity.this;
                int i2 = tTRewardExpressVideoActivity2.R;
                if (i2 >= 0 && (topProxyLayout2 = tTRewardExpressVideoActivity2.f5620f) != null) {
                    topProxyLayout2.a(String.valueOf(i2), (CharSequence) null);
                }
                int i3 = (int) j4;
                TTRewardExpressVideoActivity tTRewardExpressVideoActivity3 = TTRewardExpressVideoActivity.this;
                int i4 = tTRewardExpressVideoActivity3.T;
                boolean z2 = false;
                if (i4 != -1 && i3 == i4 && !tTRewardExpressVideoActivity3.ba.get()) {
                    TTRewardExpressVideoActivity.this.g.setVisibility(0);
                    TTRewardExpressVideoActivity.this.ba.set(true);
                    TTRewardExpressVideoActivity.this.p();
                }
                int iG = com.bytedance.sdk.openadsdk.core.o.h().g(String.valueOf(TTRewardExpressVideoActivity.this.U));
                if (TTRewardExpressVideoActivity.this.aP.m() && iG != -1 && iG >= 0) {
                    z2 = true;
                }
                if (z2 && i3 >= iG) {
                    if (!TTRewardExpressVideoActivity.this.X.getAndSet(true) && (topProxyLayout = TTRewardExpressVideoActivity.this.f5620f) != null) {
                        topProxyLayout.setShowSkip(true);
                    }
                    TopProxyLayout topProxyLayout3 = TTRewardExpressVideoActivity.this.f5620f;
                    if (topProxyLayout3 != null) {
                        topProxyLayout3.a((CharSequence) null, TTBaseVideoActivity.f5615a);
                        TTRewardExpressVideoActivity.this.f5620f.setSkipEnable(true);
                    }
                }
                TTRewardExpressVideoActivity tTRewardExpressVideoActivity4 = TTRewardExpressVideoActivity.this;
                if (tTRewardExpressVideoActivity4.R <= 0) {
                    tTRewardExpressVideoActivity4.r();
                }
                if (!TTRewardExpressVideoActivity.this.ab.get() || (cVar = TTRewardExpressVideoActivity.this.F) == null || cVar.t() == null || !TTRewardExpressVideoActivity.this.F.t().g()) {
                    return;
                }
                TTRewardExpressVideoActivity.this.F.h();
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
        message.arg1 = 1;
        this.K.sendMessageDelayed(message, 5000L);
        boolean zA = this.F.a(str2, this.v.J(), this.aQ.getWidth(), this.aQ.getHeight(), null, this.v.M(), j, this.Q);
        if (zA && !z) {
            d.a(this.h, this.v, "rewarded_video", map);
            O();
            this.aX = (int) (System.currentTimeMillis() / 1000);
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
                o.e("TTRewardExpressVideoActivity", "onPause throw Exception :" + th.getMessage());
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
                o.e("TTRewardExpressVideoActivity", "onPause throw Exception :" + th2.getMessage());
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

    @Override // com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
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
        this.aU.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardExpressVideoActivity.2
            @Override // java.lang.Runnable
            public void run() {
                TTRewardExpressVideoActivity.this.r();
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

    @Override // com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
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
        emptyViewA.setCallback(new EmptyView.a() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardExpressVideoActivity.3
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
        e eVar = new e(context, hVar, str, ab.a(str)) { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardExpressVideoActivity.4
            @Override // com.bytedance.sdk.openadsdk.core.a.b, com.bytedance.sdk.openadsdk.core.a.c
            public void a(View view, int i, int i2, int i3, int i4) {
                super.a(view, i, i2, i3, i4);
                TTRewardExpressVideoActivity.this.a(view, i, i2, i3, i4);
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
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(context2, hVar, str2, ab.a(str2)) { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardExpressVideoActivity.5
            @Override // com.bytedance.sdk.openadsdk.core.a.a, com.bytedance.sdk.openadsdk.core.a.b, com.bytedance.sdk.openadsdk.core.a.c
            public void a(View view, int i, int i2, int i3, int i4) {
                super.a(view, i, i2, i3, i4);
                TTRewardExpressVideoActivity.this.a(view, i, i2, i3, i4);
            }
        };
        dVar.a(nativeExpressView);
        if (!TextUtils.isEmpty(this.af)) {
            HashMap map2 = new HashMap();
            map2.put("rit_scene", this.af);
            dVar.a(map2);
        }
        dVar.a(this.aS);
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
