package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.component.reward.f;
import com.bytedance.sdk.openadsdk.component.reward.g;
import com.bytedance.sdk.openadsdk.component.reward.top.TopProxyLayout;
import com.bytedance.sdk.openadsdk.component.reward.top.b;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.widget.a;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.t;
import com.tencent.map.geolocation.TencentLocation;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TTRewardVideoActivity extends TTBaseVideoActivity {
    private static TTRewardVideoAd.RewardAdInteractionListener aU;
    private p aP;
    private String aQ;
    private int aR;
    private String aS;
    private String aT;
    protected int aX;
    protected int aY;
    protected TTRewardVideoAd.RewardAdInteractionListener aZ;
    private AtomicBoolean aV = new AtomicBoolean(false);
    protected final AtomicBoolean ba = new AtomicBoolean(false);
    String bb = t.a(o.a(), "tt_msgPlayable");
    String bc = t.a(o.a(), "tt_negtiveBtnBtnText");
    String bd = t.a(o.a(), "tt_postiveBtnText");
    String be = t.a(o.a(), "tt_postiveBtnTextPlayable");
    String bf = t.a(o.a(), "tt_reward_msg");

    private void K() {
        this.aP = o.f();
        h hVar = this.v;
        if (hVar == null) {
            com.bytedance.sdk.openadsdk.utils.o.e("TTRewardVideoActivity", "mMaterialMeta is null , no data to display ,the TTRewardVideoActivity finished !!");
            finish();
            return;
        }
        if (hVar.r() && this.v.c() == 1) {
            a(getApplicationContext());
        }
        this.at = 7;
        this.U = ab.d(this.v.M());
        this.Q = o.h().b(this.U);
        this.S = this.v.N();
        this.L = this.v.J();
        this.M = this.v.M();
        this.R = (int) H();
        this.N = 7;
        this.O = 3153;
        l();
        a(this.Q);
        d();
        k();
        q();
        j();
        h();
        m();
        i();
        a("reward_endcard");
        L();
        b("rewarded_video");
        o();
    }

    private void L() {
        RelativeLayout relativeLayout = this.m;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TTRewardVideoActivity.this.T();
                    TTRewardVideoActivity.this.U();
                    if (h.b(TTRewardVideoActivity.this.v)) {
                        TTRewardVideoActivity.this.e(true);
                    } else {
                        TTRewardVideoActivity.this.finish();
                    }
                }
            });
        }
        TopProxyLayout topProxyLayout = this.f5620f;
        if (topProxyLayout != null) {
            topProxyLayout.setListener(new b() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.3
                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void a(View view) {
                    TTRewardVideoActivity.this.T();
                    TTRewardVideoActivity.this.U();
                    h hVar = TTRewardVideoActivity.this.v;
                    if (hVar != null && hVar.r() && TTRewardVideoActivity.this.v.c() == 1) {
                        TTRewardVideoActivity.this.e(true);
                    } else {
                        TTRewardVideoActivity.this.e(false);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void b(View view) {
                    TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                    tTRewardVideoActivity.Q = !tTRewardVideoActivity.Q;
                    com.bytedance.sdk.openadsdk.utils.o.b("TTRewardVideoActivity", "will set is Mute " + TTRewardVideoActivity.this.Q + " mLastVolume=" + TTRewardVideoActivity.this.au.b());
                    TTRewardVideoActivity tTRewardVideoActivity2 = TTRewardVideoActivity.this;
                    c cVar = tTRewardVideoActivity2.F;
                    if (cVar != null) {
                        cVar.c(tTRewardVideoActivity2.Q);
                    }
                    if (h.a(TTRewardVideoActivity.this.v)) {
                        TTRewardVideoActivity tTRewardVideoActivity3 = TTRewardVideoActivity.this;
                        tTRewardVideoActivity3.au.a(tTRewardVideoActivity3.Q, true);
                    }
                    TTRewardVideoActivity tTRewardVideoActivity4 = TTRewardVideoActivity.this;
                    tTRewardVideoActivity4.c(tTRewardVideoActivity4.Q);
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.top.b
                public void c(View view) {
                    TTRewardVideoActivity.this.I();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        c cVar = this.F;
        if (cVar != null) {
            cVar.l();
        }
        a("rewarded_video", "skip", (Map<String, Object>) null);
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(this.af)) {
            map.put("rit_scene", this.af);
        }
        map.put("play_type", Integer.valueOf(ab.a(this.F, this.C)));
        a("rewarded_video", "feed_break", map);
        E();
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            d("onSkippedVideo");
            return;
        }
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.aZ;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onSkippedVideo();
        }
    }

    private void N() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        this.aQ = intent.getStringExtra("reward_name");
        this.aR = intent.getIntExtra("reward_amount", 0);
        this.aS = intent.getStringExtra("media_extra");
        this.aT = intent.getStringExtra("user_id");
        this.y = intent.getBooleanExtra("show_download_bar", true);
        this.A = intent.getStringExtra("video_cache_url");
        this.B = intent.getIntExtra(AdUnitActivity.EXTRA_ORIENTATION, 2);
        this.af = intent.getStringExtra("rit_scene");
    }

    private JSONObject S() {
        JSONObject jSONObject = new JSONObject();
        c cVar = this.F;
        int iR = cVar != null ? (int) cVar.r() : 0;
        try {
            jSONObject.put("oversea_version_type", 1);
            jSONObject.put("reward_name", this.aQ);
            jSONObject.put("reward_amount", this.aR);
            jSONObject.put(TencentLocation.NETWORK_PROVIDER, q.c(this.h));
            jSONObject.put("sdk_version", "3.1.5.3");
            int iT = this.v.t();
            String strC = "unKnow";
            if (iT == 2) {
                strC = ab.b();
            } else if (iT == 1) {
                strC = ab.c();
            }
            jSONObject.put("user_agent", strC);
            jSONObject.put("extra", new JSONObject(this.M));
            jSONObject.put("media_extra", this.aS);
            jSONObject.put("video_duration", this.v.v().e());
            jSONObject.put("play_start_ts", this.aX);
            jSONObject.put("play_end_ts", this.aY);
            jSONObject.put("duration", iR);
            jSONObject.put("user_id", this.aT);
            jSONObject.put("trans_id", UUID.randomUUID().toString().replace("-", ""));
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        HashMap map = new HashMap();
        h hVar = this.v;
        if (hVar != null && hVar.c() == 1 && this.v.r()) {
            map.put("duration", Long.valueOf(System.currentTimeMillis() - this.ax));
        }
        d.d(this.h, this.v, "rewarded_video", "click_close", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final boolean z) {
        if (!o.h().e(String.valueOf(this.U))) {
            if (z) {
                finish();
                return;
            } else {
                M();
                return;
            }
        }
        if (this.aV.get()) {
            if (z) {
                finish();
                return;
            } else {
                M();
                return;
            }
        }
        this.ab.set(true);
        c cVar = this.F;
        if (cVar != null) {
            cVar.h();
        }
        if (z) {
            C();
        }
        this.ac = new a(this);
        if (z) {
            this.ac.a(this.bb).b(this.be).c(this.bc);
        } else {
            this.ac.a(this.bf).b(this.bd).c(this.bc);
        }
        this.ac.a(new a.InterfaceC0085a() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.4
            @Override // com.bytedance.sdk.openadsdk.core.widget.a.InterfaceC0085a
            public void a() {
                c cVar2 = TTRewardVideoActivity.this.F;
                if (cVar2 != null) {
                    cVar2.j();
                }
                if (z) {
                    TTRewardVideoActivity.this.D();
                }
                TTRewardVideoActivity.this.ac.dismiss();
                TTRewardVideoActivity.this.ab.set(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.a.InterfaceC0085a
            public void b() {
                TTRewardVideoActivity.this.ac.dismiss();
                TTRewardVideoActivity.this.ab.set(false);
                if (z) {
                    TTRewardVideoActivity.this.finish();
                } else {
                    TTRewardVideoActivity.this.M();
                }
            }
        }).show();
    }

    protected void J() {
        h hVar = this.v;
        if (hVar == null) {
            finish();
            return;
        }
        if (hVar.i() == 0) {
            setContentView(t.f(this, "tt_activity_rewardvideo"));
            return;
        }
        if (this.v.i() == 1) {
            setContentView(t.f(this, "tt_activity_reward_video_newstyle"));
        } else if (this.v.i() == 3) {
            setContentView(t.f(this, "tt_activity_rewardvideo_new_bar_3_style"));
        } else {
            setContentView(t.f(this, "tt_activity_rewardvideo"));
        }
    }

    public void O() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            d("onAdShow");
            return;
        }
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.aZ;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onAdShow();
        }
    }

    protected void P() {
        if (this.aV.get()) {
            return;
        }
        this.aV.set(true);
        if (!o.h().n(String.valueOf(this.U))) {
            this.aP.a(S(), new p.b() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.6
                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(int i, String str) {
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        TTRewardVideoActivity.this.a("onRewardVerify", false, 0, "");
                        return;
                    }
                    TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = TTRewardVideoActivity.this.aZ;
                    if (rewardAdInteractionListener != null) {
                        rewardAdInteractionListener.onRewardVerify(false, 0, "");
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.p.b
                public void a(q.b bVar) {
                    int iA = bVar.f6358c.a();
                    String strB = bVar.f6358c.b();
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        TTRewardVideoActivity.this.a("onRewardVerify", bVar.f6357b, iA, strB);
                        return;
                    }
                    TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = TTRewardVideoActivity.this.aZ;
                    if (rewardAdInteractionListener != null) {
                        rewardAdInteractionListener.onRewardVerify(bVar.f6357b, iA, strB);
                    }
                }
            });
        } else {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                a("onRewardVerify", true, this.aR, this.aQ);
                return;
            }
            TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.aZ;
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onRewardVerify(true, this.aR, this.aQ);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.b
    public void Q() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            d("onAdVideoBarClick");
            return;
        }
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.aZ;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onAdVideoBarClick();
        }
    }

    protected void R() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            d("onVideoComplete");
            return;
        }
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.aZ;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onVideoComplete();
        }
    }

    protected void d(String str) {
        a(str, false, 0, "");
    }

    protected void finalize() throws Throwable {
        super.finalize();
        aU = null;
    }

    @Override // android.app.Activity
    public void finish() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            d("onAdClose");
        } else {
            TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.aZ;
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onAdClose();
            }
        }
        super.finish();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        N();
        if (a(bundle)) {
            J();
            e();
            K();
            c();
            v();
            z();
            a();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            d("recycleRes");
        }
        if (this.aZ != null) {
            this.aZ = null;
        }
        if (TextUtils.isEmpty(this.A)) {
            g.a(o.a()).a();
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
        aU = this.aZ;
        try {
            bundle.putString("material_meta", this.v != null ? this.v.Z().toString() : null);
            bundle.putString("multi_process_meta_md5", this.x);
            bundle.putLong("video_current", this.F == null ? this.z : this.F.m());
            bundle.putString("video_cache_url", this.A);
            bundle.putInt(AdUnitActivity.EXTRA_ORIENTATION, this.B);
            bundle.putBoolean("is_mute", this.Q);
            bundle.putBoolean("has_show_skip_btn", this.X.get());
            bundle.putString("rit_scene", this.af);
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final boolean z, final int i, final String str2) {
        com.bytedance.sdk.openadsdk.i.a.a().a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TTRewardVideoActivity.this.a(0).executeRewardVideoCallback(TTRewardVideoActivity.this.x, str, z, i, str2);
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.utils.o.c("TTRewardVideoActivity", "executeRewardVideoCallback execute throw Exception : ", th);
                }
            }
        }, 5);
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
                        com.bytedance.sdk.openadsdk.utils.o.c("TTRewardVideoActivity", "TTRewardVideoActivity MultiGlobalInfo throw ", e2);
                    }
                }
            }
            h hVar = this.v;
            if (hVar != null && hVar.x() == 4) {
                this.G = b.a.a.a.a.a.c.a(this.h, this.v, "rewarded_video");
            }
        } else {
            this.v = s.a().c();
            this.aZ = s.a().d();
            this.G = s.a().f();
            s.a().g();
        }
        if (bundle != null) {
            if (this.aZ == null) {
                this.aZ = aU;
                aU = null;
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
                if (this.X.get() && this.f5620f != null) {
                    this.f5620f.setShowSkip(true);
                    this.f5620f.a((CharSequence) null, TTBaseVideoActivity.f5615a);
                    this.f5620f.setSkipEnable(true);
                }
            } catch (Throwable unused) {
            }
            if (this.G == null) {
                this.G = b.a.a.a.a.a.c.a(this.h, this.v, "rewarded_video");
            }
        }
        h hVar2 = this.v;
        if (hVar2 == null) {
            com.bytedance.sdk.openadsdk.utils.o.e("TTRewardVideoActivity", "mMaterialMeta is null , no data to display ,the TTRewardVideoActivity finished !!");
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

    @Override // com.bytedance.sdk.openadsdk.core.video.d.b
    public void e(int i) {
        if (i == 10000) {
            P();
        } else if (i == 10001) {
            R();
        }
    }

    public boolean a(long j, boolean z) {
        HashMap map;
        if (this.F == null) {
            this.F = new f(this.h, this.r, this.v);
        }
        if (TextUtils.isEmpty(this.af)) {
            map = null;
        } else {
            map = new HashMap();
            map.put("rit_scene", this.af);
        }
        this.F.a(map);
        this.F.a(new c.a() { // from class: com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity.5
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j2, int i) {
                ad adVar = TTRewardVideoActivity.this.K;
                if (adVar != null) {
                    adVar.removeMessages(300);
                }
                TTRewardVideoActivity.this.R();
                TTRewardVideoActivity.this.r();
                TTRewardVideoActivity.this.aY = (int) (System.currentTimeMillis() / 1000);
                TTRewardVideoActivity.this.P();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void b() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void b(long j2, int i) {
                ad adVar = TTRewardVideoActivity.this.K;
                if (adVar != null) {
                    adVar.removeMessages(300);
                }
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    TTRewardVideoActivity.this.d("onVideoError");
                } else {
                    TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = TTRewardVideoActivity.this.aZ;
                    if (rewardAdInteractionListener != null) {
                        rewardAdInteractionListener.onVideoError();
                    }
                }
                if (TTRewardVideoActivity.this.s()) {
                    return;
                }
                c cVar = TTRewardVideoActivity.this.F;
                if (cVar != null) {
                    cVar.l();
                }
                TTRewardVideoActivity.this.r();
                HashMap map2 = new HashMap();
                map2.put("vbtt_skip_type", 1);
                TTRewardVideoActivity.this.a("rewarded_video", map2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a() {
                ad adVar = TTRewardVideoActivity.this.K;
                if (adVar != null) {
                    adVar.removeMessages(300);
                }
                TTRewardVideoActivity.this.r();
                HashMap map2 = new HashMap();
                map2.put("vbtt_skip_type", 0);
                TTRewardVideoActivity.this.a("rewarded_video", map2);
                c cVar = TTRewardVideoActivity.this.F;
                if (cVar != null) {
                    cVar.l();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j2, long j3) {
                TopProxyLayout topProxyLayout;
                TopProxyLayout topProxyLayout2;
                ad adVar = TTRewardVideoActivity.this.K;
                if (adVar != null) {
                    adVar.removeMessages(300);
                }
                int i = o.h().r(String.valueOf(TTRewardVideoActivity.this.U)).g;
                if (j3 > 0 && (100 * j2) / Float.valueOf(j3).floatValue() >= i) {
                    TTRewardVideoActivity.this.P();
                }
                TTRewardVideoActivity tTRewardVideoActivity = TTRewardVideoActivity.this;
                double dH = tTRewardVideoActivity.H();
                long j4 = j2 / 1000;
                double d2 = j4;
                Double.isNaN(d2);
                tTRewardVideoActivity.R = (int) (dH - d2);
                TTRewardVideoActivity tTRewardVideoActivity2 = TTRewardVideoActivity.this;
                if (tTRewardVideoActivity2.R >= 0 && (topProxyLayout2 = tTRewardVideoActivity2.f5620f) != null) {
                    topProxyLayout2.setShowCountDown(true);
                    TTRewardVideoActivity tTRewardVideoActivity3 = TTRewardVideoActivity.this;
                    tTRewardVideoActivity3.f5620f.a(String.valueOf(tTRewardVideoActivity3.R), (CharSequence) null);
                }
                int i2 = (int) j4;
                TTRewardVideoActivity tTRewardVideoActivity4 = TTRewardVideoActivity.this;
                int i3 = tTRewardVideoActivity4.T;
                boolean z2 = false;
                if (i3 != -1 && i2 == i3 && !tTRewardVideoActivity4.ba.get()) {
                    TTRewardVideoActivity.this.g.setVisibility(0);
                    TTRewardVideoActivity.this.ba.set(true);
                    TTRewardVideoActivity.this.p();
                }
                int iG = o.h().g(String.valueOf(TTRewardVideoActivity.this.U));
                if (iG != -1 && iG >= 0) {
                    z2 = true;
                }
                if (z2 && i2 >= iG) {
                    if (!TTRewardVideoActivity.this.X.getAndSet(true) && (topProxyLayout = TTRewardVideoActivity.this.f5620f) != null) {
                        topProxyLayout.setShowSkip(true);
                    }
                    TopProxyLayout topProxyLayout3 = TTRewardVideoActivity.this.f5620f;
                    if (topProxyLayout3 != null) {
                        topProxyLayout3.a((CharSequence) null, TTBaseVideoActivity.f5615a);
                        TTRewardVideoActivity.this.f5620f.setSkipEnable(true);
                    }
                }
                TTRewardVideoActivity tTRewardVideoActivity5 = TTRewardVideoActivity.this;
                if (tTRewardVideoActivity5.R <= 0) {
                    tTRewardVideoActivity5.r();
                }
                if ((TTRewardVideoActivity.this.ab.get() || TTRewardVideoActivity.this.Z.get()) && TTRewardVideoActivity.this.s()) {
                    TTRewardVideoActivity.this.F.h();
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
        com.bytedance.sdk.openadsdk.utils.o.e("wzj", "videoUrl:" + str2);
        if (this.F == null) {
            return false;
        }
        Message message = new Message();
        message.what = 300;
        message.arg1 = 1;
        this.K.sendMessageDelayed(message, 5000L);
        boolean zA = this.F.a(str2, this.v.J(), this.r.getWidth(), this.r.getHeight(), null, this.v.M(), j, this.Q);
        if (zA && !z) {
            d.a(this.h, this.v, "rewarded_video", map);
            O();
            this.aX = (int) (System.currentTimeMillis() / 1000);
        }
        return zA;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.b
    public void a(View view, int i, int i2, int i3, int i4) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            d("onAdVideoBarClick");
            return;
        }
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.aZ;
        if (rewardAdInteractionListener != null) {
            rewardAdInteractionListener.onAdVideoBarClick();
        }
    }
}
