package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.component.reward.top.TopProxyLayout;
import com.bytedance.sdk.openadsdk.component.reward.top.b;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.i.a;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.o;
import com.bytedance.sdk.openadsdk.utils.t;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TTFullScreenVideoActivity extends TTBaseVideoActivity {
    private static int aP = 5;
    private static TTFullScreenVideoAd.FullScreenVideoAdInteractionListener aR;
    private TTFullScreenVideoAd.FullScreenVideoAdInteractionListener aQ;

    private void K() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        this.y = intent.getBooleanExtra("show_download_bar", true);
        this.A = intent.getStringExtra("video_cache_url");
        this.B = intent.getIntExtra(AdUnitActivity.EXTRA_ORIENTATION, 2);
        this.af = intent.getStringExtra("rit_scene");
        this.av = intent.getBooleanExtra("is_verity_playable", false);
    }

    private void L() {
        h hVar = this.v;
        if (hVar == null) {
            o.e("TTFullScreenVideoActivity", "mMaterialMeta is null , no data to display ,the TTFullScreenVideoActivity finished !!");
            finish();
            return;
        }
        if (hVar.r() && this.v.c() == 1) {
            a(getApplicationContext());
        }
        this.at = 8;
        this.U = ab.d(this.v.M());
        this.S = this.v.N();
        this.L = this.v.J();
        this.M = this.v.M();
        this.R = (int) H();
        this.N = 5;
        this.Q = com.bytedance.sdk.openadsdk.core.o.h().b(this.U);
        this.O = 3153;
        l();
        a(this.Q);
        k();
        q();
        j();
        m();
        i();
        h();
        a("fullscreen_endcard");
        M();
        b("fullscreen_interstitial_ad");
        o();
    }

    private void M() {
        RelativeLayout relativeLayout = this.m;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTFullScreenVideoActivity.this.S();
                    TTFullScreenVideoActivity.this.finish();
                }
            });
        }
        TopProxyLayout topProxyLayout = this.f5620f;
        if (topProxyLayout != null) {
            topProxyLayout.setListener(new b() { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.3
                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void a(View view) {
                    if (h.b(TTFullScreenVideoActivity.this.v)) {
                        TTFullScreenVideoActivity.this.S();
                        TTFullScreenVideoActivity.this.finish();
                        return;
                    }
                    HashMap map = new HashMap();
                    if (!TextUtils.isEmpty(TTFullScreenVideoActivity.this.af)) {
                        map.put("rit_scene", TTFullScreenVideoActivity.this.af);
                    }
                    TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
                    map.put("play_type", Integer.valueOf(ab.a(tTFullScreenVideoActivity.F, tTFullScreenVideoActivity.C)));
                    TTFullScreenVideoActivity.this.a("fullscreen_interstitial_ad", "feed_break", map);
                    TTFullScreenVideoActivity.this.a("fullscreen_interstitial_ad", "skip", (Map<String, Object>) null);
                    TTFullScreenVideoActivity.this.f5620f.setShowSkip(false);
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        TTFullScreenVideoActivity.this.d("onSkippedVideo");
                    } else if (TTFullScreenVideoActivity.this.aQ != null) {
                        TTFullScreenVideoActivity.this.aQ.onSkippedVideo();
                    }
                    if (TTFullScreenVideoActivity.this.P()) {
                        TTFullScreenVideoActivity.this.E();
                    } else {
                        TTFullScreenVideoActivity.this.finish();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void b(View view) {
                    TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
                    tTFullScreenVideoActivity.Q = !tTFullScreenVideoActivity.Q;
                    TTFullScreenVideoActivity tTFullScreenVideoActivity2 = TTFullScreenVideoActivity.this;
                    c cVar = tTFullScreenVideoActivity2.F;
                    if (cVar != null) {
                        cVar.c(tTFullScreenVideoActivity2.Q);
                    }
                    if (h.a(TTFullScreenVideoActivity.this.v)) {
                        TTFullScreenVideoActivity tTFullScreenVideoActivity3 = TTFullScreenVideoActivity.this;
                        tTFullScreenVideoActivity3.au.a(tTFullScreenVideoActivity3.Q, true);
                    }
                    TTFullScreenVideoActivity tTFullScreenVideoActivity4 = TTFullScreenVideoActivity.this;
                    tTFullScreenVideoActivity4.c(tTFullScreenVideoActivity4.Q);
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void c(View view) {
                    TTFullScreenVideoActivity.this.I();
                }
            });
        }
    }

    private void N() {
        TopProxyLayout topProxyLayout = this.f5620f;
        if (topProxyLayout != null) {
            topProxyLayout.a((CharSequence) null, TTBaseVideoActivity.f5615a);
            this.f5620f.setSkipEnable(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        HashMap map = new HashMap();
        h hVar = this.v;
        if (hVar != null && hVar.r() && this.v.c() == 1) {
            map.put("duration", Long.valueOf(System.currentTimeMillis() - this.ax));
        }
        d.d(this.h, this.v, "fullscreen_interstitial_ad", "click_close", map);
    }

    private void c(int i) {
        if (this.f5620f != null) {
            this.f5620f.a((CharSequence) null, new SpannableStringBuilder(String.format(t.a(com.bytedance.sdk.openadsdk.core.o.a(), "tt_skip_ad_time_text"), Integer.valueOf(i))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final String str) {
        a.a().a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TTFullScreenVideoActivity.this.a(1).executeFullVideoCallback(TTFullScreenVideoActivity.this.x, str);
                } catch (Throwable th) {
                    o.c("TTFullScreenVideoActivity", "executeFullVideoCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    protected void J() {
        h hVar = this.v;
        if (hVar == null) {
            finish();
            return;
        }
        if (hVar.i() == 0) {
            setContentView(t.f(this, "tt_activity_full_video"));
        } else if (this.v.i() == 1) {
            setContentView(t.f(this, "tt_activity_full_video_newstyle"));
        } else if (this.v.i() == 3) {
            setContentView(t.f(this, "tt_activity_full_video_new_bar_3_style"));
        } else {
            setContentView(t.f(this, "tt_activity_full_video"));
        }
        o.b("report-5", "getPlayBarStyle=" + this.v.i());
    }

    public void O() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            d("onAdShow");
            return;
        }
        TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.aQ;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onAdShow();
        }
    }

    protected boolean P() {
        return com.bytedance.sdk.openadsdk.core.o.h().k(String.valueOf(this.U)) == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.b
    public void Q() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            d("onAdVideoBarClick");
            return;
        }
        TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.aQ;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onAdVideoBarClick();
        }
    }

    protected void R() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            d("onVideoComplete");
            return;
        }
        TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.aQ;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onVideoComplete();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.b
    public void e(int i) {
        if (i == 10002) {
            R();
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        aR = null;
    }

    @Override // android.app.Activity
    public void finish() {
        try {
            if (this.av && !TextUtils.isEmpty(this.P) && this.ar != 0) {
                com.bytedance.sdk.openadsdk.f.a.a().a(this.P, this.ar, this.as);
            }
        } catch (Throwable unused) {
        }
        try {
            if (this.av && !TextUtils.isEmpty(this.P)) {
                com.bytedance.sdk.openadsdk.f.a.a().b(this.P);
            }
        } catch (Throwable unused2) {
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            d("onAdClose");
        } else {
            TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.aQ;
            if (fullScreenVideoAdInteractionListener != null) {
                fullScreenVideoAdInteractionListener.onAdClose();
            }
        }
        super.finish();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        K();
        if (a(bundle)) {
            J();
            e();
            L();
            c();
            v();
            z();
            h hVar = this.v;
            if (hVar != null) {
                this.U = ab.d(hVar.M());
            }
            a();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            d("recycleRes");
        }
        if (this.aQ != null) {
            this.aQ = null;
        }
        if (TextUtils.isEmpty(this.A)) {
            com.bytedance.sdk.openadsdk.component.reward.c.a(com.bytedance.sdk.openadsdk.core.o.a()).b();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        ac.a((Activity) this);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        aR = this.aQ;
        try {
            bundle.putString("material_meta", this.v != null ? this.v.Z().toString() : null);
            bundle.putString("multi_process_meta_md5", this.x);
            bundle.putLong("video_current", this.F == null ? this.z : this.F.m());
            bundle.putString("video_cache_url", this.A);
            bundle.putInt(AdUnitActivity.EXTRA_ORIENTATION, this.B);
            bundle.putBoolean("is_mute", this.Q);
            bundle.putString("rit_scene", this.af);
            bundle.putBoolean("has_show_skip_btn", this.X.get());
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    protected void d(int i) {
        TopProxyLayout topProxyLayout;
        TopProxyLayout topProxyLayout2;
        aP = com.bytedance.sdk.openadsdk.core.o.h().e(this.U);
        if (aP < 0) {
            aP = 5;
        }
        if (!com.bytedance.sdk.openadsdk.core.o.h().c(String.valueOf(this.U))) {
            if (i >= aP) {
                if (!this.X.getAndSet(true) && (topProxyLayout2 = this.f5620f) != null) {
                    topProxyLayout2.setShowSkip(true);
                }
                N();
                return;
            }
            return;
        }
        if (!this.X.getAndSet(true) && (topProxyLayout = this.f5620f) != null) {
            topProxyLayout.setShowSkip(true);
        }
        int i2 = aP;
        if (i > i2) {
            N();
            return;
        }
        c(i2 - i);
        TopProxyLayout topProxyLayout3 = this.f5620f;
        if (topProxyLayout3 != null) {
            topProxyLayout3.setSkipEnable(false);
        }
    }

    private boolean a(Bundle bundle) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            Intent intent = getIntent();
            if (intent != null) {
                String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                this.x = intent.getStringExtra("multi_process_meta_md5");
                if (stringExtra != null) {
                    try {
                        this.v = com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(stringExtra));
                    } catch (Exception e2) {
                        o.c("TTFullScreenVideoActivity", "initData MultiGlobalInfo throws ", e2);
                    }
                }
            }
            h hVar = this.v;
            if (hVar != null && hVar.x() == 4) {
                this.G = b.a.a.a.a.a.c.a(this.h, this.v, "fullscreen_interstitial_ad");
            }
        } else {
            this.v = s.a().c();
            this.aQ = s.a().e();
            this.G = s.a().f();
            s.a().g();
        }
        if (bundle != null) {
            if (this.aQ == null) {
                this.aQ = aR;
                aR = null;
            }
            try {
                String string = bundle.getString("material_meta");
                this.x = bundle.getString("multi_process_meta_md5");
                this.A = bundle.getString("video_cache_url");
                this.B = bundle.getInt(AdUnitActivity.EXTRA_ORIENTATION, 2);
                this.Q = bundle.getBoolean("is_mute");
                this.af = bundle.getString("rit_scene");
                this.v = com.bytedance.sdk.openadsdk.core.c.a(new JSONObject(string));
                this.X.set(bundle.getBoolean("has_show_skip_btn"));
                if (this.X.get()) {
                    if (this.f5620f != null) {
                        this.f5620f.setShowSkip(true);
                    }
                    N();
                }
            } catch (Throwable unused) {
            }
            if (this.G == null) {
                this.G = b.a.a.a.a.a.c.a(this.h, this.v, "rewarded_video");
            }
        }
        h hVar2 = this.v;
        if (hVar2 == null) {
            o.e("TTFullScreenVideoActivity", "mMaterialMeta is null , no data to display ,the TTFullScreenVideoActivity finished !!");
            finish();
            return false;
        }
        this.ag = hVar2.i() == 1;
        this.ah = this.v.i() == 3;
        h hVar3 = this.v;
        if (hVar3 != null) {
            hVar3.v();
        }
        return true;
    }

    public boolean a(long j, boolean z) {
        HashMap map;
        if (this.F == null) {
            this.F = new com.bytedance.sdk.openadsdk.component.reward.b(this.h, this.r, this.v);
        }
        if (TextUtils.isEmpty(this.af)) {
            map = null;
        } else {
            map = new HashMap();
            map.put("rit_scene", this.af);
        }
        this.F.a(map);
        this.F.a(new c.a() { // from class: com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity.4
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j2, int i) {
                ad adVar = TTFullScreenVideoActivity.this.K;
                if (adVar != null) {
                    adVar.removeMessages(300);
                }
                TTFullScreenVideoActivity.this.R();
                if (TTFullScreenVideoActivity.this.P()) {
                    TTFullScreenVideoActivity.this.r();
                } else {
                    TTFullScreenVideoActivity.this.finish();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void b() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void b(long j2, int i) {
                ad adVar = TTFullScreenVideoActivity.this.K;
                if (adVar != null) {
                    adVar.removeMessages(300);
                }
                if (TTFullScreenVideoActivity.this.s()) {
                    return;
                }
                c cVar = TTFullScreenVideoActivity.this.F;
                if (cVar != null) {
                    cVar.l();
                }
                o.e("TTFullScreenVideoActivity", "onError、、、、、、、、");
                if (!TTFullScreenVideoActivity.this.P()) {
                    TTFullScreenVideoActivity.this.finish();
                    return;
                }
                TTFullScreenVideoActivity.this.r();
                HashMap map2 = new HashMap();
                map2.put("vbtt_skip_type", 1);
                TTFullScreenVideoActivity.this.a("fullscreen_interstitial_ad", map2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a() {
                ad adVar = TTFullScreenVideoActivity.this.K;
                if (adVar != null) {
                    adVar.removeMessages(300);
                }
                o.b("TTFullScreenVideoActivity", "onTimeOut、、、、、、、、");
                if (TTFullScreenVideoActivity.this.P()) {
                    TTFullScreenVideoActivity.this.r();
                } else {
                    TTFullScreenVideoActivity.this.finish();
                }
                HashMap map2 = new HashMap();
                map2.put("vbtt_skip_type", 0);
                TTFullScreenVideoActivity.this.a("fullscreen_interstitial_ad", map2);
                c cVar = TTFullScreenVideoActivity.this.F;
                if (cVar != null) {
                    cVar.l();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j2, long j3) {
                TopProxyLayout topProxyLayout;
                ad adVar = TTFullScreenVideoActivity.this.K;
                if (adVar != null) {
                    adVar.removeMessages(300);
                }
                TTFullScreenVideoActivity tTFullScreenVideoActivity = TTFullScreenVideoActivity.this;
                double dH = tTFullScreenVideoActivity.H();
                long j4 = j2 / 1000;
                double d2 = j4;
                Double.isNaN(d2);
                tTFullScreenVideoActivity.R = (int) (dH - d2);
                TTFullScreenVideoActivity.this.d((int) j4);
                TTFullScreenVideoActivity tTFullScreenVideoActivity2 = TTFullScreenVideoActivity.this;
                if (tTFullScreenVideoActivity2.R >= 0 && (topProxyLayout = tTFullScreenVideoActivity2.f5620f) != null) {
                    topProxyLayout.setShowCountDown(true);
                    TTFullScreenVideoActivity tTFullScreenVideoActivity3 = TTFullScreenVideoActivity.this;
                    tTFullScreenVideoActivity3.f5620f.a(String.valueOf(tTFullScreenVideoActivity3.R), (CharSequence) null);
                }
                if (TTFullScreenVideoActivity.this.R <= 0) {
                    o.b("TTFullScreenVideoActivity", "onProgressUpdate、、、、、、、、");
                    if (TTFullScreenVideoActivity.this.P()) {
                        TTFullScreenVideoActivity.this.r();
                    } else {
                        TTFullScreenVideoActivity.this.finish();
                    }
                }
                if ((TTFullScreenVideoActivity.this.ab.get() || TTFullScreenVideoActivity.this.Z.get()) && TTFullScreenVideoActivity.this.s()) {
                    TTFullScreenVideoActivity.this.F.h();
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
        boolean zA = this.F.a(str2, this.v.J(), this.r.getWidth(), this.r.getHeight(), null, this.v.M(), j, this.Q);
        if (zA && !z) {
            d.a(this.h, this.v, "fullscreen_interstitial_ad", map);
            O();
        }
        return zA;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.b
    public void a(View view, int i, int i2, int i3, int i4) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            d("onAdVideoBarClick");
            return;
        }
        TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.aQ;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onAdVideoBarClick();
        }
    }
}
