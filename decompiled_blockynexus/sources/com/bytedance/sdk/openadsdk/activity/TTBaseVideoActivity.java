package com.bytedance.sdk.openadsdk.activity;

import android.R;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.DownloadListener;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.qqtheme.framework.widget.WheelView;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.c.j;
import com.bytedance.sdk.openadsdk.component.reward.top.TopProxyLayout;
import com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialog;
import com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeToast;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.video.d.b;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.widget.PlayableLoadingView;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.core.widget.c;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.y;
import com.bytedance.sdk.openadsdk.e.a;
import com.bytedance.sdk.openadsdk.e.d;
import com.bytedance.sdk.openadsdk.e.e;
import com.bytedance.sdk.openadsdk.e.f;
import com.bytedance.sdk.openadsdk.e.g;
import com.bytedance.sdk.openadsdk.utils.HomeWatcherReceiver;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.l;
import com.bytedance.sdk.openadsdk.utils.t;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.just.agentweb.WebIndicator;
import com.sandboxol.common.config.HttpCode;
import com.sandboxol.vip.entity.VipDiamond;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class TTBaseVideoActivity extends Activity implements b, f, HomeWatcherReceiver.a, ad.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f5615a = t.a(o.a(), "tt_txt_skip");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final String f5616b = t.a(o.a(), "tt_feedback_submit_text");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final String f5617c = t.a(o.a(), "tt_feedback_thank_text") + UMCustomLogInfoBuilder.LINE_SEP + t.a(o.a(), "tt_feedback_experience_text");
    String A;
    int B;
    RewardDislikeDialog D;
    RewardDislikeToast E;
    c F;
    b.a.a.a.a.a.b G;
    v H;
    v I;
    HomeWatcherReceiver J;
    String L;
    String M;
    int N;
    int O;
    protected String P;
    int R;
    int U;
    String aE;
    boolean aF;
    protected boolean aG;
    String aH;
    String aI;
    View aJ;
    protected a aK;
    protected e aL;
    protected d aM;
    protected int aN;
    ProgressBar aO;
    private com.bytedance.sdk.openadsdk.core.a.e aP;
    private boolean aQ;
    private boolean aR;
    private boolean aS;
    private AtomicBoolean aT;
    private View.OnClickListener aU;
    private boolean aV;
    protected com.bytedance.sdk.openadsdk.core.widget.a ac;
    protected IListenerManager ae;
    protected String af;
    LinearLayout aj;
    TTRoundRectImageView ak;
    TextView al;
    TTRatingBar am;
    TextView an;
    TextView ao;
    protected g au;
    boolean av;
    TextView aw;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    View f5618d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    PlayableLoadingView f5619e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    TopProxyLayout f5620f;
    RelativeLayout g;
    Context h;
    protected SSWebView i;
    protected WeakReference<SSWebView> j;
    SSWebView k;
    ImageView l;
    RelativeLayout m;
    TTRoundRectImageView n;
    TextView o;
    TextView p;
    TextView q;
    FrameLayout r;
    FrameLayout s;
    FrameLayout t;
    TTRatingBar u;
    h v;
    j w;
    String x;
    long z;
    boolean y = true;
    boolean C = false;
    final ad K = new ad(Looper.getMainLooper(), this);
    boolean Q = false;
    int S = 5;
    int T = 3;
    final AtomicBoolean V = new AtomicBoolean(false);
    final AtomicBoolean W = new AtomicBoolean(false);
    final AtomicBoolean X = new AtomicBoolean(false);
    final AtomicBoolean Y = new AtomicBoolean(false);
    final AtomicBoolean Z = new AtomicBoolean(false);
    final AtomicBoolean aa = new AtomicBoolean(false);
    protected final AtomicBoolean ab = new AtomicBoolean(false);
    protected final String ad = Build.MODEL;
    protected boolean ag = false;
    protected boolean ah = false;
    protected int ai = 0;
    AtomicBoolean ap = new AtomicBoolean(true);
    boolean aq = false;
    int ar = 0;
    String as = "";
    int at = 7;
    long ax = 0;
    int ay = 0;
    long az = 0;
    long aA = 0;
    int aB = 0;
    int aC = 0;
    AtomicBoolean aD = new AtomicBoolean(false);

    public TTBaseVideoActivity() {
        this.aE = this instanceof TTRewardVideoActivity ? "rewarded_video" : "fullscreen_interstitial_ad";
        this.aF = false;
        this.aG = true;
        this.aR = false;
        this.aH = "video_player";
        this.aI = "";
        this.aS = true;
        this.aT = new AtomicBoolean(false);
        this.aJ = null;
        this.aU = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TTBaseVideoActivity.this.a(view);
            }
        };
        this.aV = false;
        this.aK = new a() { // from class: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.8
            @Override // com.bytedance.sdk.openadsdk.e.a
            public int a() {
                SSWebView sSWebView = TTBaseVideoActivity.this.i;
                int measuredHeight = sSWebView != null ? sSWebView.getMeasuredHeight() : -1;
                com.bytedance.sdk.openadsdk.utils.o.c("TTAndroidObject", "mWebView>>>>height=" + measuredHeight);
                return measuredHeight <= 0 ? ac.d(TTBaseVideoActivity.this.h) : measuredHeight;
            }

            @Override // com.bytedance.sdk.openadsdk.e.a
            public int b() {
                SSWebView sSWebView = TTBaseVideoActivity.this.i;
                int measuredWidth = sSWebView != null ? sSWebView.getMeasuredWidth() : -1;
                com.bytedance.sdk.openadsdk.utils.o.c("TTAndroidObject", "mWebView>>>>width=" + measuredWidth);
                return measuredWidth <= 0 ? ac.c(TTBaseVideoActivity.this.h) : measuredWidth;
            }
        };
        this.aL = new e() { // from class: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.9
            @Override // com.bytedance.sdk.openadsdk.e.e
            public void a() {
                TTBaseVideoActivity.this.V();
            }
        };
        this.aM = new d() { // from class: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.10
            @Override // com.bytedance.sdk.openadsdk.e.d
            public void a() {
                h hVar;
                if (TTBaseVideoActivity.this.isFinishing()) {
                    return;
                }
                h hVar2 = TTBaseVideoActivity.this.v;
                if ((hVar2 == null || hVar2.p()) && (hVar = TTBaseVideoActivity.this.v) != null && hVar.q()) {
                    TTBaseVideoActivity.this.K.removeMessages(VipDiamond.MVP);
                    TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                    tTBaseVideoActivity.K.sendMessage(tTBaseVideoActivity.c(1));
                }
            }
        };
        this.aN = -1;
    }

    private int J() {
        Resources resources = getResources();
        if (resources != null) {
            return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
        }
        return 0;
    }

    private int K() {
        Resources resources = getResources();
        if (resources != null) {
            return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
        }
        return 0;
    }

    private String L() {
        h hVar;
        String strL = o.h().l();
        com.bytedance.sdk.openadsdk.utils.o.c("Playable", "getPlayableLoadH5Url->loadH5Url=" + strL);
        if (TextUtils.isEmpty(strL) || (hVar = this.v) == null || hVar.K() == null) {
            return strL;
        }
        String str = this.S == 15 ? "portrait" : "landscape";
        String strB = this.v.K().b();
        int iD = this.v.K().d();
        int iE = this.v.K().e();
        String strA = this.v.y().a();
        String strJ = this.v.J();
        String strC = this.v.K().c();
        String strA2 = this.v.K().a();
        String strB2 = this.v.K().b();
        String strG = this.v.G();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("appname=");
        stringBuffer.append(URLEncoder.encode(strB));
        stringBuffer.append("&stars=");
        stringBuffer.append(iD);
        stringBuffer.append("&comments=");
        stringBuffer.append(iE);
        stringBuffer.append("&icon=");
        stringBuffer.append(URLEncoder.encode(strA));
        stringBuffer.append("&downloading=");
        stringBuffer.append(true);
        stringBuffer.append("&id=");
        stringBuffer.append(URLEncoder.encode(strJ));
        stringBuffer.append("&pkg_name=");
        stringBuffer.append(URLEncoder.encode(strC));
        stringBuffer.append("&download_url=");
        stringBuffer.append(URLEncoder.encode(strA2));
        stringBuffer.append("&name=");
        stringBuffer.append(URLEncoder.encode(strB2));
        stringBuffer.append("&orientation=");
        stringBuffer.append(str);
        stringBuffer.append("&apptitle=");
        stringBuffer.append(URLEncoder.encode(strG));
        String str2 = strL + "?" + stringBuffer.toString();
        com.bytedance.sdk.openadsdk.utils.o.c("Playable", "Playable-loadH5Url=" + str2);
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        SSWebView sSWebView;
        if (this.aT.getAndSet(true) || (sSWebView = this.i) == null || this.k == null) {
            return;
        }
        ac.a((View) sSWebView, 0);
        ac.a((View) this.k, 8);
    }

    private void N() {
        this.aj = (LinearLayout) findViewById(t.e(this, "tt_reward_full_endcard_backup"));
        this.ak = (TTRoundRectImageView) findViewById(t.e(this, "tt_reward_ad_icon_backup"));
        this.al = (TextView) findViewById(t.e(this, "tt_reward_ad_appname_backup"));
        this.am = (TTRatingBar) findViewById(t.e(this, "tt_rb_score_backup"));
        this.an = (TextView) findViewById(t.e(this, "tt_comment_backup"));
        this.ao = (TextView) findViewById(t.e(this, "tt_reward_ad_download_backup"));
        TTRatingBar tTRatingBar = this.am;
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            this.am.setStarFillNum(4);
            this.am.setStarImageWidth(ac.c(this, 16.0f));
            this.am.setStarImageHeight(ac.c(this, 16.0f));
            this.am.setStarImagePadding(ac.c(this, 4.0f));
            this.am.a();
        }
    }

    private void P() {
        h hVar = this.v;
        if (hVar == null) {
            return;
        }
        int iD = ab.d(hVar.M());
        com.bytedance.sdk.openadsdk.f.a.c cVarE = com.bytedance.sdk.openadsdk.f.a.c.b().a(this.at).c(String.valueOf(iD)).e(ab.h(this.v.M()));
        cVarE.b(this.ar).f(this.as);
        cVarE.g(this.v.M()).d(this.v.J());
        com.bytedance.sdk.openadsdk.f.a.a().g(cVarE);
    }

    private void R() {
        if (this.v.X()) {
            this.f5620f.setShowDislike(true);
        } else {
            this.f5620f.setShowDislike(false);
        }
    }

    private void S() {
        this.f5620f.c();
        ac.a((View) this.l, 0);
        ac.a((View) this.m, 0);
    }

    private void T() {
        c cVar = this.F;
        if (cVar == null || cVar.t() == null) {
            return;
        }
        this.z = this.F.m();
        if (this.F.t().h() || !this.F.t().l()) {
            this.F.h();
            this.F.k();
            this.aV = true;
        }
    }

    private void U() {
        TopProxyLayout topProxyLayout = this.f5620f;
        if (topProxyLayout != null) {
            topProxyLayout.setShowSound(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void V() {
        /*
            r12 = this;
            com.bytedance.sdk.openadsdk.core.g.i r0 = com.bytedance.sdk.openadsdk.core.o.h()
            int r1 = r12.U
            java.lang.String r1 = java.lang.String.valueOf(r1)
            com.bytedance.sdk.openadsdk.core.g.a r0 = r0.r(r1)
            int r0 = r0.g
            com.bytedance.sdk.openadsdk.core.d.h r1 = r12.v
            boolean r1 = com.bytedance.sdk.openadsdk.core.d.h.c(r1)
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L33
            double r4 = r12.H()
            r6 = 4636737291354636288(0x4059000000000000, double:100.0)
            r8 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r1 = r12.R
            double r10 = (double) r1
            java.lang.Double.isNaN(r10)
            double r10 = r10 / r4
            double r8 = r8 - r10
            double r8 = r8 * r6
            double r0 = (double) r0
            int r4 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r4 < 0) goto L73
        L31:
            r3 = 1
            goto L73
        L33:
            com.bytedance.sdk.openadsdk.core.g.i r1 = com.bytedance.sdk.openadsdk.core.o.h()
            int r4 = r12.U
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r1 = r1.o(r4)
            r4 = 1120403456(0x42c80000, float:100.0)
            r5 = 1065353216(0x3f800000, float:1.0)
            int r6 = r12.ay
            float r6 = (float) r6
            float r1 = (float) r1
            float r6 = r6 / r1
            float r5 = r5 - r6
            float r5 = r5 * r4
            float r0 = (float) r0
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 < 0) goto L54
            r0 = 1
            goto L55
        L54:
            r0 = 0
        L55:
            com.bytedance.sdk.openadsdk.core.g.i r1 = com.bytedance.sdk.openadsdk.core.o.h()
            int r4 = r12.U
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r1 = r1.a(r4)
            if (r1 != 0) goto L70
            if (r0 == 0) goto L73
            com.bytedance.sdk.openadsdk.core.v r0 = r12.H
            boolean r0 = r0.b()
            if (r0 == 0) goto L73
            goto L31
        L70:
            if (r1 != r2) goto L73
            r3 = r0
        L73:
            if (r3 == 0) goto L7a
            r0 = 10000(0x2710, float:1.4013E-41)
            r12.e(r0)
        L7a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.V():void");
    }

    private void W() {
        this.E.a(f5616b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        this.E.a(f5617c);
    }

    void A() {
        if (this.D == null) {
            this.D = new RewardDislikeDialog(this, this.v);
            this.D.setCallback(new RewardDislikeDialog.a() { // from class: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.6
                @Override // com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialog.a
                public void a(View view) {
                    TTBaseVideoActivity.this.Z.set(true);
                    if (TTBaseVideoActivity.this.s()) {
                        TTBaseVideoActivity.this.F.h();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialog.a
                public void b(View view) {
                    TTBaseVideoActivity.this.Z.set(false);
                    if (TTBaseVideoActivity.this.t()) {
                        TTBaseVideoActivity.this.F.j();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialog.a
                public void c(View view) {
                }

                @Override // com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialog.a
                public void a(int i, FilterWord filterWord) {
                    if (TTBaseVideoActivity.this.aa.get() || filterWord == null || filterWord.hasSecondOptions()) {
                        return;
                    }
                    TTBaseVideoActivity.this.aa.set(true);
                    TTBaseVideoActivity.this.X();
                }
            });
            ((FrameLayout) findViewById(R.id.content)).addView(this.D);
        }
        if (this.E == null) {
            this.E = new RewardDislikeToast(this);
            ((FrameLayout) findViewById(R.id.content)).addView(this.E);
        }
    }

    protected void B() {
        c cVar;
        if (this.W.getAndSet(false) || (cVar = this.F) == null) {
            return;
        }
        if (cVar.t() == null) {
            if (this.aV) {
                ((com.bytedance.sdk.openadsdk.core.video.d.a) this.F).x();
                a(this.z, true);
                this.aV = false;
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.video.e.d dVarT = this.F.t();
        if (dVarT.i() || dVarT.j()) {
            ((com.bytedance.sdk.openadsdk.core.video.d.a) this.F).x();
            a(this.z, true);
        }
    }

    protected void C() {
        ad adVar = this.K;
        if (adVar != null) {
            adVar.removeMessages(700);
            this.K.removeMessages(900);
            this.K.removeMessages(950);
            this.K.removeMessages(WebIndicator.DO_END_ANIMATION_DURATION);
        }
    }

    protected void D() {
        if (this.K != null) {
            Message messageObtain = Message.obtain();
            if (this.aB == this.aC) {
                messageObtain.what = 900;
            } else {
                messageObtain.what = 950;
            }
            messageObtain.arg1 = this.ay;
            this.K.sendMessageDelayed(messageObtain, 1000L);
        }
    }

    void E() {
        h hVar;
        this.Z.set(false);
        this.aa.set(false);
        TopProxyLayout topProxyLayout = this.f5620f;
        if (topProxyLayout != null) {
            topProxyLayout.setShowSkip(false);
            this.f5620f.setShowCountDown(false);
            R();
            this.f5620f.setShowSound(h.a(this.v));
            if (((this instanceof TTFullScreenExpressVideoActivity) || (this instanceof TTRewardExpressVideoActivity)) && h.a(this.v)) {
                this.f5620f.setShowSound(true);
                this.f5620f.setShowSkip(true);
            }
        }
        b();
        RewardDislikeToast rewardDislikeToast = this.E;
        if (rewardDislikeToast != null) {
            rewardDislikeToast.a();
        }
        if (this.V.getAndSet(true)) {
            return;
        }
        this.Y.set(true);
        if (!h.a(this.v, this.ap.get(), this.aq) && (hVar = this.v) != null && !hVar.r()) {
            ac.a((View) this.i, 8);
            ac.a((View) this.aj, 0);
            S();
            U();
            P();
            if ((this instanceof TTFullScreenVideoActivity) && this.F != null && s() && this.Y.get()) {
                this.F.i();
                this.F.l();
                return;
            }
            return;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            ac.a(this.i, WheelView.DividerConfig.FILL);
            ac.a(this.l, WheelView.DividerConfig.FILL);
            ac.a(this.m, WheelView.DividerConfig.FILL);
        }
        ac.a((View) this.i, 0);
        h hVar2 = this.v;
        if (hVar2 == null || !hVar2.r()) {
            h hVar3 = this.v;
            if (hVar3 != null && !hVar3.r()) {
                int iM = o.h().m(String.valueOf(this.U));
                if (iM == -1) {
                    S();
                } else if (iM >= 0) {
                    this.K.sendEmptyMessageDelayed(WebIndicator.DO_END_ANIMATION_DURATION, iM);
                }
            }
        } else {
            int iP = o.h().p(String.valueOf(this.U));
            if (iP == -1) {
                S();
            } else if (iP >= 0) {
                this.K.sendEmptyMessageDelayed(WebIndicator.DO_END_ANIMATION_DURATION, iP);
            }
        }
        this.K.sendEmptyMessageDelayed(500, 100L);
        a(this.Q, true);
        v vVar = this.H;
        if (vVar != null) {
            vVar.b(true);
            b(true);
        }
        n();
    }

    @Override // com.bytedance.sdk.openadsdk.utils.HomeWatcherReceiver.a
    public void F() {
        this.aF = true;
    }

    @Override // com.bytedance.sdk.openadsdk.utils.HomeWatcherReceiver.a
    public void G() {
        this.aF = true;
    }

    public double H() {
        h hVar = this.v;
        if (hVar == null || hVar.v() == null) {
            return 0.0d;
        }
        return this.v.v().e();
    }

    protected void I() {
        if (isFinishing()) {
            return;
        }
        if (this.aa.get()) {
            W();
            return;
        }
        if (this.D == null) {
            A();
        }
        this.D.a();
    }

    protected void e() {
        this.f5619e = (PlayableLoadingView) findViewById(t.e(this, "tt_reward_playable_loading"));
        this.f5620f = (TopProxyLayout) findViewById(t.e(this, "tt_top_layout_proxy"));
        TopProxyLayout topProxyLayout = this.f5620f;
        if (topProxyLayout != null) {
            topProxyLayout.a(this instanceof TTRewardVideoActivity, this.v);
        }
        this.f5618d = findViewById(t.e(this, "tt_reward_root"));
        this.k = (SSWebView) findViewById(t.e(this, "tt_browser_webview_loading"));
        this.i = (SSWebView) findViewById(t.e(this, "tt_reward_browser_webview"));
        this.j = new WeakReference<>(this.i);
        this.m = (RelativeLayout) findViewById(t.e(this, "tt_video_ad_close_layout"));
        this.l = (ImageView) findViewById(t.e(this, "tt_video_ad_close"));
        this.aw = (TextView) findViewById(t.e(this, "tt_ad_logo"));
        this.r = (FrameLayout) findViewById(t.e(this, "tt_video_reward_container"));
        this.s = (FrameLayout) findViewById(t.e(this, "tt_click_upper_non_content_layout"));
        this.t = (FrameLayout) findViewById(t.e(this, "tt_click_lower_non_content_layout"));
        this.aj = (LinearLayout) findViewById(t.e(this, "tt_reward_full_endcard_backup"));
        this.q = (TextView) findViewById(t.e(this, "tt_reward_ad_download"));
        this.g = (RelativeLayout) findViewById(t.e(this, "tt_video_reward_bar"));
        this.n = (TTRoundRectImageView) findViewById(t.e(this, "tt_reward_ad_icon"));
        this.o = (TextView) findViewById(t.e(this, "tt_reward_ad_appname"));
        this.p = (TextView) findViewById(t.e(this, "tt_comment_vertical"));
        this.u = (TTRatingBar) findViewById(t.e(this, "tt_rb_score"));
        TTRatingBar tTRatingBar = this.u;
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            this.u.setStarFillNum(4);
            this.u.setStarImageWidth(ac.c(this, 15.0f));
            this.u.setStarImageHeight(ac.c(this, 14.0f));
            this.u.setStarImagePadding(ac.c(this, 4.0f));
            this.u.a();
        }
        h hVar = this.v;
        if (hVar != null && hVar.r()) {
            this.i.setBackgroundColor(-16777216);
            this.k.setBackgroundColor(-16777216);
            if (this.v.c() == 1) {
                ac.a((View) this.r, 8);
                ac.a((View) this.s, 8);
                ac.a((View) this.t, 8);
                ac.a((View) this.g, 8);
                ac.a((View) this.o, 8);
                ac.a((View) this.n, 8);
                ac.a((View) this.p, 8);
                ac.a((View) this.u, 8);
                ac.a((View) this.l, 8);
                ac.a((View) this.m, 8);
                ac.a((View) this.i, 4);
                ac.a((View) this.k, 0);
                ac.a((View) this.q, 8);
                ac.a((View) this.aw, 8);
            }
            TopProxyLayout topProxyLayout2 = this.f5620f;
            if (topProxyLayout2 != null) {
                topProxyLayout2.setShowSound(true);
            }
        }
        SSWebView sSWebView = this.i;
        if (sSWebView != null) {
            sSWebView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (Build.VERSION.SDK_INT >= 16) {
                        TTBaseVideoActivity.this.i.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    } else {
                        TTBaseVideoActivity.this.i.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                    int measuredWidth = TTBaseVideoActivity.this.i.getMeasuredWidth();
                    int measuredHeight = TTBaseVideoActivity.this.i.getMeasuredHeight();
                    if (TTBaseVideoActivity.this.i.getVisibility() == 0) {
                        TTBaseVideoActivity.this.a(measuredWidth, measuredHeight);
                    }
                }
            });
        }
        N();
        if (!this.y) {
            ac.a((View) this.g, 4);
        }
        try {
            if (this.ag && this.v != null && this.v.N() == 5) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
                layoutParams.height = (int) ac.a(this, 55.0f);
                layoutParams.topMargin = (int) ac.a(this, 20.0f);
                this.q.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.g.getLayoutParams();
                layoutParams2.bottomMargin = (int) ac.a(this, 12.0f);
                this.g.setLayoutParams(layoutParams2);
            }
        } catch (Throwable unused) {
        }
        if (this.v == null || !this.ag || this.r == null) {
            return;
        }
        int iC = ac.c((Context) this);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.r.getLayoutParams();
        layoutParams3.width = iC;
        int i = (iC * 9) / 16;
        layoutParams3.height = i;
        this.r.setLayoutParams(layoutParams3);
        this.ai = (ac.d(this) - i) / 2;
        com.bytedance.sdk.openadsdk.utils.o.e("TTBaseVideoActivity", "NonContentAreaHeight:" + this.ai);
    }

    protected boolean f() {
        if (this.k == null) {
            return false;
        }
        String strL = L();
        if (TextUtils.isEmpty(strL)) {
            return false;
        }
        this.k.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.webview.c(this.h, this.I, this.v.J(), null) { // from class: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.11
            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                tTBaseVideoActivity.aI = str;
                if (tTBaseVideoActivity.aS) {
                    TTBaseVideoActivity tTBaseVideoActivity2 = TTBaseVideoActivity.this;
                    tTBaseVideoActivity2.a(tTBaseVideoActivity2.aE, "loading_h5_success");
                }
                super.onPageFinished(webView, str);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                TTBaseVideoActivity.this.aS = false;
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                TTBaseVideoActivity.this.aS = false;
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                TTBaseVideoActivity.this.aS = false;
            }
        });
        this.k.loadUrl(strL);
        this.k.getSettings().setDisplayZoomControls(false);
        this.k.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.b(this.I, this.w));
        this.k.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.12
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                b.a.a.a.a.a.b bVar = TTBaseVideoActivity.this.G;
                if (bVar != null) {
                    bVar.a();
                }
                TTBaseVideoActivity.this.Q();
            }
        });
        return true;
    }

    protected void g() {
        if (this.aG) {
            this.i.loadUrl(this.P);
        }
    }

    protected void h() {
        TextView textView = this.q;
        if (textView != null) {
            textView.setText(this.ah ? y() : x());
        }
    }

    protected void i() {
        StringBuilder sb;
        String str;
        if (this.p == null) {
            return;
        }
        int iE = this.v.K() != null ? this.v.K().e() : 6870;
        String strA = t.a(this, "tt_comment_num");
        if (iE > 10000) {
            sb = new StringBuilder();
            sb.append(iE / 1000);
            str = "k";
        } else {
            sb = new StringBuilder();
            sb.append(iE);
            str = "";
        }
        sb.append(str);
        this.p.setText(String.format(strA, sb.toString()));
    }

    protected void j() {
        if (this.n != null) {
            if (this.v.y() == null || TextUtils.isEmpty(this.v.y().a())) {
                this.n.setImageResource(t.d(this, "tt_ad_logo_small"));
            } else {
                com.bytedance.sdk.openadsdk.g.d.a(this.h).a(this.v.y().a(), this.n);
            }
        }
        if (this.o != null) {
            if (this.S != 15 || this.v.K() == null || TextUtils.isEmpty(this.v.K().b())) {
                this.o.setText(this.v.G());
            } else {
                this.o.setText(this.v.K().b());
            }
        }
    }

    protected void k() {
        this.P = this.v.v() != null ? this.v.v().i() : null;
        if (TextUtils.isEmpty(this.P) || this.S != 15) {
            return;
        }
        if (this.P.contains("?")) {
            this.P += "&orientation=portrait";
            return;
        }
        this.P += "?orientation=portrait";
    }

    protected void l() {
        if (this.f5619e == null) {
            return;
        }
        h hVar = this.v;
        if (hVar == null || !hVar.p() || !this.v.s()) {
            this.f5619e.a();
            return;
        }
        this.f5619e.b();
        h hVar2 = this.v;
        if (hVar2 != null && hVar2.s() && this.v.q()) {
            this.K.sendMessageDelayed(c(2), 10000L);
        }
    }

    protected void m() {
        if (this.v.r() && this.v.c() == 1) {
            TextView textView = this.aw;
            if (textView != null) {
                ac.a((View) textView, 8);
                return;
            }
            return;
        }
        TextView textView2 = this.aw;
        if (textView2 != null) {
            ac.a((View) textView2, 0);
        }
    }

    protected void n() {
        TextView textView = this.aw;
        if (textView != null) {
            ac.a((View) textView, 8);
        }
    }

    protected void o() {
        StringBuilder sb;
        String str;
        if (this.ak != null) {
            if (this.v.y() == null || TextUtils.isEmpty(this.v.y().a())) {
                this.ak.setImageResource(t.d(this, "tt_ad_logo_small"));
            } else {
                com.bytedance.sdk.openadsdk.g.d.a(this.h).a(this.v.y().a(), this.ak);
            }
        }
        if (this.al != null) {
            if (this.v.K() == null || TextUtils.isEmpty(this.v.K().b())) {
                this.al.setText(this.v.G());
            } else {
                this.al.setText(this.v.K().b());
            }
        }
        if (this.an != null) {
            int iE = this.v.K() != null ? this.v.K().e() : 6870;
            String strA = t.a(this, "tt_comment_num_backup");
            if (iE > 10000) {
                sb = new StringBuilder();
                sb.append(iE / 1000);
                str = "k";
            } else {
                sb = new StringBuilder();
                sb.append(iE);
                str = "";
            }
            sb.append(str);
            this.an.setText(String.format(strA, sb.toString()));
        }
        TextView textView = this.ao;
        if (textView != null) {
            textView.setText(x());
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        if (bundle != null) {
            this.aQ = bundle.getBoolean("is_bar_click_first");
        }
        super.onCreate(bundle);
        if (com.bytedance.sdk.openadsdk.core.h.b().l()) {
            getWindow().addFlags(2621440);
        }
        try {
            requestWindowFeature(1);
            getWindow().addFlags(1024);
            getWindow().addFlags(16777216);
        } catch (Throwable unused) {
        }
        try {
            o.a(this);
        } catch (Throwable unused2) {
        }
        if (bundle != null && bundle.getLong("video_current") > 0) {
            this.z = bundle.getLong("video_current", 0L);
        }
        this.h = this;
        this.au = new g(getApplicationContext());
        this.au.a(this);
        this.aN = this.au.g();
        com.bytedance.sdk.openadsdk.utils.o.b("onVolumeChanged", "onCreate >>>>>> mVolume = " + this.aN);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        RewardDislikeToast rewardDislikeToast = this.E;
        if (rewardDislikeToast != null) {
            rewardDislikeToast.b();
        }
        ad adVar = this.K;
        if (adVar != null) {
            adVar.removeCallbacksAndMessages(null);
        }
        y.a(this.h, this.i);
        y.a(this.i);
        c cVar = this.F;
        if (cVar != null) {
            cVar.k();
            this.F = null;
        }
        this.i = null;
        v vVar = this.H;
        if (vVar != null) {
            vVar.g();
        }
        j jVar = this.w;
        if (jVar != null) {
            jVar.d();
        }
        g gVar = this.au;
        if (gVar != null) {
            gVar.f();
            this.au.a((f) null);
        }
        b(getApplicationContext());
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.aR = false;
        com.bytedance.sdk.openadsdk.utils.o.b("TTBaseVideoActivity", "onPause mIsActivityShow=" + this.aR + " mIsMute=" + this.Q);
        SSWebView sSWebView = this.i;
        if (sSWebView != null) {
            sSWebView.onPause();
        }
        if (Build.VERSION.SDK_INT < 26 && !"C8817D".equals(this.ad) && !"M5".equals(this.ad) && !"R7t".equals(this.ad)) {
            try {
                if (s() && !this.Z.get()) {
                    this.F.h();
                }
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.o.e("TTBaseVideoActivity", "onPause throw Exception :" + th.getMessage());
            }
        } else if (!this.Z.get()) {
            T();
        }
        v vVar = this.H;
        if (vVar != null) {
            vVar.f();
            this.H.b(false);
            b(false);
            a(true, false);
        }
        h hVar = this.v;
        if (hVar != null && hVar.c() == 1 && this.v.r()) {
            this.K.removeMessages(700);
            this.K.removeMessages(950);
            this.K.removeMessages(900);
            this.K.removeMessages(WebIndicator.DO_END_ANIMATION_DURATION);
            c("go_background");
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        h hVar;
        this.aR = true;
        com.bytedance.sdk.openadsdk.utils.o.b("TTBaseVideoActivity", "onResume mIsActivityShow=" + this.aR + " mIsMute=" + this.Q);
        if (this.f5620f != null) {
            R();
        }
        if (h.b(this.v) || h.c(this.v)) {
            if (this.aN == 0) {
                this.Q = true;
            }
            if (this.Q) {
                this.au.a(true);
                a(true);
            }
        }
        super.onResume();
        SSWebView sSWebView = this.i;
        if (sSWebView != null) {
            sSWebView.onResume();
        }
        g gVar = this.au;
        if (gVar != null) {
            gVar.a(this);
            this.au.e();
        }
        if (!this.V.get()) {
            if (Build.VERSION.SDK_INT >= 26 || "C8817D".equals(this.ad) || "M5".equals(this.ad) || "R7t".equals(this.ad)) {
                if (!this.Z.get()) {
                    B();
                }
            } else if (t() && !this.Z.get()) {
                this.F.j();
            }
        }
        v vVar = this.H;
        if (vVar != null) {
            vVar.e();
            SSWebView sSWebView2 = this.i;
            if (sSWebView2 != null) {
                if (sSWebView2.getVisibility() == 0) {
                    this.H.b(true);
                    b(true);
                    a(false, true);
                } else {
                    this.H.b(false);
                    b(false);
                    a(true, false);
                }
            }
        }
        j jVar = this.w;
        if (jVar != null) {
            jVar.b();
        }
        if (this.aD.get() && (hVar = this.v) != null && hVar.c() == 1 && this.v.r()) {
            c("return_foreground");
            com.bytedance.sdk.openadsdk.core.widget.a aVar = this.ac;
            if ((aVar == null || !(aVar == null || aVar.isShowing())) && this.ay > 0) {
                Message messageObtain = Message.obtain();
                if (this.aB == this.aC) {
                    messageObtain.what = 900;
                } else {
                    messageObtain.what = 950;
                }
                messageObtain.arg1 = this.ay;
                messageObtain.arg2 = this.aC;
                this.K.sendMessage(messageObtain);
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            bundle.putString("material_meta", this.v != null ? this.v.Z().toString() : null);
            bundle.putString("multi_process_meta_md5", this.x);
            bundle.putLong("video_current", this.F == null ? this.z : this.F.m());
            bundle.putString("video_cache_url", this.A);
            bundle.putInt(AdUnitActivity.EXTRA_ORIENTATION, this.B);
            bundle.putBoolean("is_mute", this.Q);
            bundle.putBoolean("is_bar_click_first", this.aQ);
        } catch (Throwable unused) {
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        com.bytedance.sdk.openadsdk.utils.o.b("TTBaseVideoActivity", "onStop mIsMute=" + this.Q + " mLast=" + this.au.b() + " mVolume=" + this.aN);
        j jVar = this.w;
        if (jVar != null) {
            jVar.c();
        }
        h hVar = this.v;
        if (hVar != null && hVar.c() == 1 && this.v.r()) {
            this.K.removeMessages(700);
            this.K.removeMessages(950);
            this.K.removeMessages(900);
            this.K.removeMessages(WebIndicator.DO_END_ANIMATION_DURATION);
            c("go_background");
        }
        if (this.Q) {
            runOnUiThread(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.7
                @Override // java.lang.Runnable
                public void run() {
                    if (TTBaseVideoActivity.this.au.b() > 0) {
                        TTBaseVideoActivity.this.au.a(false);
                    }
                }
            });
        }
    }

    protected void p() {
        if (this.g == null) {
            return;
        }
        Keyframe keyframeOfFloat = Keyframe.ofFloat(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL);
        Keyframe keyframeOfFloat2 = Keyframe.ofFloat(0.65f, 1.0f);
        Keyframe keyframeOfFloat3 = Keyframe.ofFloat(0.765f, 0.9f);
        Keyframe keyframeOfFloat4 = Keyframe.ofFloat(0.88f, 1.0f);
        Keyframe keyframeOfFloat5 = Keyframe.ofFloat(0.95f, 0.95f);
        Keyframe keyframeOfFloat6 = Keyframe.ofFloat(1.0f, 1.0f);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.g, PropertyValuesHolder.ofKeyframe("scaleX", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4, keyframeOfFloat5, keyframeOfFloat6), PropertyValuesHolder.ofKeyframe("scaleY", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4, keyframeOfFloat5, keyframeOfFloat6));
        objectAnimatorOfPropertyValuesHolder.setDuration(1000L);
        objectAnimatorOfPropertyValuesHolder.start();
    }

    void q() {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(this.af)) {
            map.put("rit_scene", this.af);
        }
        this.H = new v(this.h);
        this.H.a((WebView) this.i).a(this.v).a(this.L).a(this.m).b(this.M).b(this.N).a(this.av).a(this.aK).a(this.aL).a(this.aM).c(ab.e(this.v)).a(map);
        this.I = new v(this);
        this.I.a((WebView) this.k).a(this.v).a(this.L).b(this.M).b(this.N).c(ab.e(this.v));
        this.H.a(new com.bytedance.sdk.openadsdk.e.b() { // from class: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.16
            @Override // com.bytedance.sdk.openadsdk.e.b
            public void a(boolean z, int i, String str) {
                com.bytedance.sdk.openadsdk.utils.o.b("end card load finish: ", "code=" + i + " msg=" + str + " isRenderSuc=" + z);
                if (z) {
                    TTBaseVideoActivity.this.aq = true;
                }
            }
        });
        this.H.a(new com.bytedance.sdk.openadsdk.e.h() { // from class: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.17
            @Override // com.bytedance.sdk.openadsdk.e.h
            public void a() {
                SSWebView sSWebView = TTBaseVideoActivity.this.j.get();
                if (sSWebView == null) {
                    com.bytedance.sdk.openadsdk.utils.o.b("TTBaseVideoActivity", "webView has destroy when onPauseWebView");
                } else {
                    sSWebView.onPause();
                    com.bytedance.sdk.openadsdk.utils.o.b("TTBaseVideoActivity", "js make webView onPause OK");
                }
            }

            @Override // com.bytedance.sdk.openadsdk.e.h
            public void b() {
                SSWebView sSWebView = TTBaseVideoActivity.this.j.get();
                if (sSWebView == null) {
                    com.bytedance.sdk.openadsdk.utils.o.b("TTBaseVideoActivity", "webView has destroy when onPauseWebViewTimers");
                } else {
                    sSWebView.pauseTimers();
                    com.bytedance.sdk.openadsdk.utils.o.b("TTBaseVideoActivity", "js make webView pauseTimers OK");
                }
            }
        });
    }

    void r() {
        h hVar;
        if ((Build.VERSION.SDK_INT < 17 || !isDestroyed()) && !isFinishing()) {
            this.aH = "endcard";
            this.Z.set(false);
            this.aa.set(false);
            b();
            com.bytedance.sdk.openadsdk.core.widget.a aVar = this.ac;
            if (aVar != null && aVar.isShowing()) {
                this.ac.dismiss();
            }
            RewardDislikeToast rewardDislikeToast = this.E;
            if (rewardDislikeToast != null) {
                rewardDislikeToast.a();
            }
            if (this.f5620f != null) {
                if (h.b(this.v)) {
                    this.f5620f.setShowSkip(true);
                } else {
                    this.f5620f.setShowSkip(false);
                }
                R();
                if (((this instanceof TTFullScreenExpressVideoActivity) || (this instanceof TTRewardExpressVideoActivity)) && h.a(this.v)) {
                    this.f5620f.setShowSound(true);
                }
            }
            if (this.V.getAndSet(true)) {
                return;
            }
            if (!h.a(this.v, this.ap.get(), this.aq) && (hVar = this.v) != null && !hVar.r()) {
                com.bytedance.sdk.openadsdk.utils.o.b("TTBaseVideoActivity", "isEndCardLoadSuc=" + this.aq + " so load back up end card");
                ac.a((View) this.i, 8);
                ac.a((View) this.aj, 0);
                S();
                U();
                P();
                return;
            }
            ac.a(this.i, WheelView.DividerConfig.FILL);
            ac.a(this.l, WheelView.DividerConfig.FILL);
            ac.a(this.m, WheelView.DividerConfig.FILL);
            ac.a((View) this.i, 0);
            h hVar2 = this.v;
            if (hVar2 == null || !hVar2.r()) {
                h hVar3 = this.v;
                if (hVar3 != null && !hVar3.r()) {
                    int iM = o.h().m(String.valueOf(this.U));
                    if (iM == -1) {
                        S();
                    } else if (iM >= 0) {
                        this.K.sendEmptyMessageDelayed(WebIndicator.DO_END_ANIMATION_DURATION, iM);
                    }
                }
            } else {
                int iP = o.h().p(String.valueOf(this.U));
                if (this.v.c() == 1) {
                    iP = (o.h().o(String.valueOf(this.U)) + 1) * 1000;
                }
                if (iP == -1) {
                    S();
                } else if (iP >= 0) {
                    this.K.sendEmptyMessageDelayed(WebIndicator.DO_END_ANIMATION_DURATION, iP);
                }
            }
            this.K.sendEmptyMessageDelayed(500, 20L);
            a(this.Q, true);
            b(true);
            n();
            v vVar = this.H;
            if (vVar != null) {
                vVar.b(true);
            }
        }
    }

    boolean s() {
        c cVar = this.F;
        return (cVar == null || cVar.t() == null || !this.F.t().g()) ? false : true;
    }

    protected boolean t() {
        c cVar = this.F;
        return (cVar == null || cVar.t() == null || !this.F.t().i()) ? false : true;
    }

    protected boolean u() {
        c cVar = this.F;
        return cVar != null && cVar.w();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    void v() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        h hVar;
        h hVar2;
        if (this.v == null) {
            return;
        }
        final String str = this instanceof TTRewardVideoActivity ? "rewarded_video" : "fullscreen_interstitial_ad";
        this.aP = new com.bytedance.sdk.openadsdk.core.a.e(this, this.v, str, this.N) { // from class: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.18
            @Override // com.bytedance.sdk.openadsdk.core.a.e
            public void a_(View view, int i, int i2, int i3, int i4) {
                TTBaseVideoActivity.this.a(view, i, i2, i3, i4);
                TTBaseVideoActivity.this.aQ = view.getId() == t.e(TTBaseVideoActivity.this, "tt_video_reward_bar");
                TTBaseVideoActivity.this.aJ = view;
                if (view.getId() == t.e(TTBaseVideoActivity.this, "tt_playable_play") && TTBaseVideoActivity.this.v.s()) {
                    HashMap map = new HashMap();
                    if (TTBaseVideoActivity.this.v.v() != null) {
                        map.put("playable_url", TTBaseVideoActivity.this.v.v().i());
                    }
                    TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                    com.bytedance.sdk.openadsdk.c.d.g(tTBaseVideoActivity, tTBaseVideoActivity.v, str, "click_playable_download_button_loading", map);
                }
                TTBaseVideoActivity tTBaseVideoActivity2 = TTBaseVideoActivity.this;
                if (tTBaseVideoActivity2.G == null) {
                    tTBaseVideoActivity2.a(view);
                    return;
                }
                if (view.getId() == t.e(TTBaseVideoActivity.this, "tt_rb_score")) {
                    TTBaseVideoActivity.this.a("click_play_star_level", (JSONObject) null);
                    return;
                }
                if (view.getId() == t.e(TTBaseVideoActivity.this, "tt_comment_vertical")) {
                    TTBaseVideoActivity.this.a("click_play_star_nums", (JSONObject) null);
                } else if (view.getId() == t.e(TTBaseVideoActivity.this, "tt_reward_ad_appname")) {
                    TTBaseVideoActivity.this.a("click_play_source", (JSONObject) null);
                } else if (view.getId() == t.e(TTBaseVideoActivity.this, "tt_reward_ad_icon")) {
                    TTBaseVideoActivity.this.a("click_play_logo", (JSONObject) null);
                }
            }
        };
        this.aP.a(this.g);
        if (!TextUtils.isEmpty(this.af)) {
            HashMap map = new HashMap();
            map.put("rit_scene", this.af);
            this.aP.a(map);
        }
        b.a.a.a.a.a.b bVar = this.G;
        if (bVar != null) {
            this.aP.a(bVar);
        }
        PlayableLoadingView playableLoadingView = this.f5619e;
        if (playableLoadingView != null && playableLoadingView.getPlayView() != null && (hVar2 = this.v) != null && hVar2.s()) {
            this.f5619e.getPlayView().setOnClickListener(this.aP);
            this.f5619e.getPlayView().setOnTouchListener(this.aP);
        }
        h hVar3 = this.v;
        if (hVar3 != null && hVar3.j() != null) {
            if (this.v.j().f6071e) {
                this.q.setOnClickListener(this.aP);
                this.q.setOnTouchListener(this.aP);
            } else {
                this.q.setOnClickListener(this.aU);
            }
            if (this.ag) {
                if (this.v.j().f6067a) {
                    ac.a((View) this.g, (View.OnClickListener) this.aP, "TTBaseVideoActivity#mRlDownloadBar");
                    ac.a((View) this.g, (View.OnTouchListener) this.aP, "TTBaseVideoActivity#mRlDownloadBar");
                    this.o.setOnClickListener(this.aP);
                    this.o.setOnTouchListener(this.aP);
                    this.p.setOnClickListener(this.aP);
                    this.p.setOnTouchListener(this.aP);
                    this.u.setOnClickListener(this.aP);
                    this.u.setOnTouchListener(this.aP);
                    this.n.setOnClickListener(this.aP);
                    this.n.setOnTouchListener(this.aP);
                } else {
                    ac.a(this.g, this.aU, "TTBaseVideoActivity#mRlDownloadBar");
                    this.o.setOnClickListener(this.aU);
                    this.p.setOnClickListener(this.aU);
                    this.u.setOnClickListener(this.aU);
                    this.n.setOnClickListener(this.aU);
                }
            } else if (this.v.j().f6069c) {
                ac.a((View) this.g, (View.OnClickListener) this.aP, "TTBaseVideoActivity#mRlDownloadBar");
                ac.a((View) this.g, (View.OnTouchListener) this.aP, "TTBaseVideoActivity#mRlDownloadBar");
            } else {
                ac.a(this.g, this.aU, "TTBaseVideoActivity#mRlDownloadBar");
            }
        }
        if (this.r != null && (hVar = this.v) != null && hVar.j() != null) {
            if (this.v.j().f6072f) {
                this.r.setOnClickListener(this.aP);
            } else {
                this.r.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TTBaseVideoActivity.this.a(view);
                    }
                });
            }
        }
        if (this.ag) {
            if (this.v.j() != null && (frameLayout2 = this.s) != null) {
                ac.a((View) frameLayout2, 0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.s.getLayoutParams();
                layoutParams.height = this.ai;
                this.s.setLayoutParams(layoutParams);
                if (this.v.j().f6068b) {
                    this.s.setOnClickListener(this.aP);
                    this.s.setOnTouchListener(this.aP);
                } else {
                    this.s.setOnClickListener(this.aU);
                }
            }
            if (this.v.j() != null && (frameLayout = this.t) != null) {
                ac.a((View) frameLayout, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.t.getLayoutParams();
                layoutParams2.height = this.ai;
                this.t.setLayoutParams(layoutParams2);
                if (this.v.j().f6070d) {
                    this.t.setOnClickListener(this.aP);
                    this.t.setOnTouchListener(this.aP);
                } else {
                    this.t.setOnClickListener(this.aU);
                }
            }
        }
        TextView textView = this.aw;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.bytedance.sdk.openadsdk.utils.o.c("mAdLogo", "mAdLogo,,,,,,,onClick,,,,,");
                    String str2 = TTBaseVideoActivity.this instanceof TTRewardVideoActivity ? "rewarded_video" : "fullscreen_interstitial_ad";
                    TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                    com.bytedance.sdk.openadsdk.c.d.a(tTBaseVideoActivity.h, tTBaseVideoActivity.v, str2, "open_policy");
                    try {
                        if (TextUtils.isEmpty(o.h().q())) {
                            return;
                        }
                        TTBaseVideoActivity.this.startActivity(new Intent(TTBaseVideoActivity.this, (Class<?>) TTWebsiteActivity.class));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
        ac.a(this.aj, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }, "TTBaseVideoActivity#mLLEndCardBackup");
        this.ao.setOnClickListener(this.aP);
        this.ao.setOnTouchListener(this.aP);
    }

    protected JSONObject w() {
        long jP;
        int iQ;
        try {
            if (this.F != null) {
                jP = this.F.p();
                iQ = this.F.q();
            } else {
                jP = 0;
                iQ = 0;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("duration", jP);
                jSONObject.put("percent", iQ);
                return jSONObject;
            } catch (Throwable unused) {
                return jSONObject;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    protected String x() {
        String strA = t.a(this, "tt_video_download_apk");
        h hVar = this.v;
        return hVar == null ? strA : TextUtils.isEmpty(hVar.I()) ? this.v.x() != 4 ? t.a(this, "tt_video_mobile_go_detail") : strA : this.v.I();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.lang.String y() {
        /*
            r7 = this;
            java.lang.String r0 = com.bytedance.sdk.openadsdk.utils.ab.b(r7)
            if (r0 != 0) goto L8
            java.lang.String r0 = ""
        L8:
            r1 = 0
            r2 = 1
            java.util.Locale r3 = java.util.Locale.CHINESE     // Catch: java.lang.Throwable -> L3d
            java.lang.String r3 = r3.getLanguage()     // Catch: java.lang.Throwable -> L3d
            boolean r3 = r0.equals(r3)     // Catch: java.lang.Throwable -> L3d
            if (r3 != 0) goto L31
            java.util.Locale r3 = java.util.Locale.CHINA     // Catch: java.lang.Throwable -> L3d
            java.lang.String r3 = r3.getLanguage()     // Catch: java.lang.Throwable -> L3d
            boolean r3 = r0.equals(r3)     // Catch: java.lang.Throwable -> L3d
            if (r3 != 0) goto L31
            java.util.Locale r3 = java.util.Locale.TRADITIONAL_CHINESE     // Catch: java.lang.Throwable -> L3d
            java.lang.String r3 = r3.getLanguage()     // Catch: java.lang.Throwable -> L3d
            boolean r3 = r0.equals(r3)     // Catch: java.lang.Throwable -> L3d
            if (r3 == 0) goto L2f
            goto L31
        L2f:
            r3 = 0
            goto L32
        L31:
            r3 = 1
        L32:
            java.util.Locale r4 = java.util.Locale.ENGLISH     // Catch: java.lang.Throwable -> L3e
            java.lang.String r4 = r4.getLanguage()     // Catch: java.lang.Throwable -> L3e
            boolean r0 = r0.equals(r4)     // Catch: java.lang.Throwable -> L3e
            goto L3f
        L3d:
            r3 = 1
        L3e:
            r0 = 0
        L3f:
            java.lang.String r4 = "Install"
            com.bytedance.sdk.openadsdk.core.d.h r5 = r7.v
            if (r5 != 0) goto L46
            return r4
        L46:
            java.lang.String r5 = r5.I()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L5c
            com.bytedance.sdk.openadsdk.core.d.h r1 = r7.v
            int r1 = r1.x()
            r2 = 4
            if (r1 == r2) goto L9b
            java.lang.String r4 = "View"
            goto L9b
        L5c:
            com.bytedance.sdk.openadsdk.core.d.h r4 = r7.v
            java.lang.String r4 = r4.I()
            if (r4 == 0) goto L7f
            boolean r5 = com.bytedance.sdk.openadsdk.utils.ab.j(r4)
            if (r5 == 0) goto L7f
            int r5 = r4.length()
            r6 = 2
            if (r5 <= r6) goto L7f
            if (r3 == 0) goto L78
            java.lang.String r4 = r7.f(r2)
            goto L9b
        L78:
            if (r0 == 0) goto L9b
            java.lang.String r4 = r7.f(r1)
            goto L9b
        L7f:
            if (r4 == 0) goto L9b
            boolean r5 = com.bytedance.sdk.openadsdk.utils.ab.j(r4)
            if (r5 != 0) goto L9b
            int r5 = r4.length()
            r6 = 7
            if (r5 <= r6) goto L9b
            if (r3 == 0) goto L95
            java.lang.String r4 = r7.f(r2)
            goto L9b
        L95:
            if (r0 == 0) goto L9b
            java.lang.String r4 = r7.f(r1)
        L9b:
            if (r0 == 0) goto Lb8
            boolean r0 = com.bytedance.sdk.openadsdk.utils.ab.j(r4)
            if (r0 != 0) goto Lb8
            android.widget.TextView r0 = r7.q
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            r1 = 1082130432(0x40800000, float:4.0)
            int r1 = com.bytedance.sdk.openadsdk.utils.ac.c(r7, r1)
            r0.bottomMargin = r1
            android.widget.TextView r1 = r7.q
            r1.setLayoutParams(r0)
        Lb8:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.y():java.lang.String");
    }

    void z() {
        if (this.ah) {
            int[] iArr = {Color.parseColor("#0070FF")};
            com.bytedance.sdk.openadsdk.core.widget.c.a((LinearLayout) findViewById(t.e(this, "tt_reward_ad_download_layout")), new c.a().a(iArr[0]).b(Color.parseColor("#80000000")).a(iArr).c(ac.c(this, 17.0f)).d(0).e(ac.c(this, 3.0f)));
        }
    }

    void c() {
        if (this.S == 15) {
            setRequestedOrientation(1);
            TextView textView = this.o;
            if (textView != null) {
                textView.setMaxWidth((int) ac.a(this, 153.0f));
            }
        } else {
            setRequestedOrientation(0);
            TextView textView2 = this.o;
            if (textView2 != null) {
                textView2.setMaxWidth((int) ac.a(this, 404.0f));
            }
            e(false);
            RelativeLayout relativeLayout = this.m;
            if (relativeLayout != null) {
                ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    int iJ = J();
                    int iK = K();
                    if (iJ > 0) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (iJ > marginLayoutParams.topMargin) {
                            marginLayoutParams.topMargin = iJ;
                            TopProxyLayout topProxyLayout = this.f5620f;
                            if (topProxyLayout != null && (topProxyLayout.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                                ((ViewGroup.MarginLayoutParams) this.f5620f.getLayoutParams()).topMargin = iJ - ac.c(this, 20.0f);
                            }
                        }
                    }
                    if (iK > 0) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (iK > marginLayoutParams2.rightMargin) {
                            marginLayoutParams2.rightMargin = iK;
                        }
                    }
                }
            }
        }
        if (this instanceof TTFullScreenVideoActivity) {
            ac.a((View) this.g, 0);
        }
    }

    void d() {
        this.T = this.v.m();
        if (this.T == -200) {
            this.T = o.h().l(this.U + "");
        }
        if (this.T == -1 && this.y) {
            ac.a((View) this.g, 0);
        }
    }

    void b() {
        if (h.c(this.v) && this.Q) {
            a(true);
            this.au.a(true);
        }
    }

    protected void b(String str) {
        if (this.v.c() == 1 && this.v.r()) {
            return;
        }
        boolean zA = a(this.z, false);
        this.W.set(true);
        if (zA) {
            return;
        }
        r();
        HashMap map = new HashMap();
        map.put("vbtt_skip_type", 1);
        a(str, map);
    }

    protected void a() {
        if ((h.b(this.v) || h.c(this.v)) && this.aN == 0) {
            this.Q = true;
            a(true);
        }
    }

    protected void d(boolean z) {
        if (this.aO == null) {
            this.aO = new ProgressBar(this);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(120, 120);
            layoutParams.gravity = 17;
            this.aO.setLayoutParams(layoutParams);
            this.aO.setIndeterminateDrawable(getResources().getDrawable(t.d(this, "tt_video_loading_progress_bar")));
            this.r.addView(this.aO);
        }
        if (z) {
            this.aO.setVisibility(0);
        } else {
            this.aO.setVisibility(8);
        }
    }

    private String f(boolean z) {
        h hVar = this.v;
        if (hVar == null) {
            return null;
        }
        return hVar.x() != 4 ? "View" : "Install";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        com.bytedance.sdk.openadsdk.c.d.b(this, this.v, str, str2, (JSONObject) null);
    }

    private void a(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.webview.a.a(this.h).a(false).b(false).a(sSWebView);
        sSWebView.getSettings().setUserAgentString(l.a(sSWebView, this.O));
        if (Build.VERSION.SDK_INT >= 21) {
            sSWebView.getSettings().setMixedContentMode(0);
        }
    }

    protected void b(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", z ? 1 : 0);
            this.H.a("viewableChange", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected void a(String str) {
        SSWebView sSWebView = this.i;
        if (sSWebView == null) {
            return;
        }
        this.w = new j(this, this.v, sSWebView).a(true);
        this.w.a(str);
        this.i.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.webview.c(this.h, this.H, this.L, this.w) { // from class: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.13
            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str2) {
                TTBaseVideoActivity.this.aI = str2;
                super.onPageFinished(webView, str2);
                try {
                    if (TTBaseVideoActivity.this.v.s() && !TTBaseVideoActivity.this.isFinishing() && TTBaseVideoActivity.this.v.p() && !TTBaseVideoActivity.this.v.q()) {
                        TTBaseVideoActivity.this.K.sendMessageDelayed(TTBaseVideoActivity.this.c(0), 1000L);
                    }
                } catch (Throwable unused) {
                }
                try {
                    if (TTBaseVideoActivity.this.ap.get() && TTBaseVideoActivity.this.v.c() == 1 && TTBaseVideoActivity.this.v.r()) {
                        TTBaseVideoActivity.this.M();
                        TTBaseVideoActivity.this.b(true);
                        if (this.f6672b != null) {
                            this.f6672b.b(true);
                        }
                        TTBaseVideoActivity.this.a(TTBaseVideoActivity.this.aE, "py_loading_success");
                    }
                } catch (Throwable unused2) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str2, Bitmap bitmap) {
                TTBaseVideoActivity.this.aI = str2;
                super.onPageStarted(webView, str2, bitmap);
                h hVar = TTBaseVideoActivity.this.v;
                if (hVar != null && hVar.r() && TTBaseVideoActivity.this.v.c() == 1) {
                    TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                    boolean z = tTBaseVideoActivity instanceof TTRewardVideoActivity;
                    tTBaseVideoActivity.aB = o.h().o(String.valueOf(TTBaseVideoActivity.this.U));
                    TTBaseVideoActivity.this.aC = o.h().a(String.valueOf(TTBaseVideoActivity.this.U), z);
                    TTBaseVideoActivity tTBaseVideoActivity2 = TTBaseVideoActivity.this;
                    long j = tTBaseVideoActivity2.aB;
                    tTBaseVideoActivity2.az = j;
                    tTBaseVideoActivity2.aA = j;
                    tTBaseVideoActivity2.K.sendEmptyMessageDelayed(WebIndicator.DO_END_ANIMATION_DURATION, r0 * 1000);
                    Message messageObtain = Message.obtain();
                    TTBaseVideoActivity tTBaseVideoActivity3 = TTBaseVideoActivity.this;
                    if (tTBaseVideoActivity3.aB == tTBaseVideoActivity3.aC) {
                        messageObtain.what = 900;
                    } else {
                        messageObtain.what = 950;
                    }
                    TTBaseVideoActivity tTBaseVideoActivity4 = TTBaseVideoActivity.this;
                    messageObtain.arg1 = tTBaseVideoActivity4.aB;
                    messageObtain.arg2 = tTBaseVideoActivity4.aC;
                    tTBaseVideoActivity4.K.sendMessage(messageObtain);
                    TTBaseVideoActivity.this.ax = System.currentTimeMillis();
                    HashMap map = null;
                    if (!TextUtils.isEmpty(TTBaseVideoActivity.this.af)) {
                        map = new HashMap();
                        map.put("rit_scene", TTBaseVideoActivity.this.af);
                    }
                    if (z) {
                        com.bytedance.sdk.openadsdk.c.d.a(this.f6673c, TTBaseVideoActivity.this.v, "rewarded_video", map);
                    } else {
                        com.bytedance.sdk.openadsdk.c.d.a(this.f6673c, TTBaseVideoActivity.this.v, "fullscreen_interstitial_ad", map);
                    }
                    TTBaseVideoActivity.this.O();
                    TTBaseVideoActivity.this.aD.set(true);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str2, String str3) {
                TTBaseVideoActivity.this.ap.set(false);
                TTBaseVideoActivity tTBaseVideoActivity = TTBaseVideoActivity.this;
                tTBaseVideoActivity.ar = i;
                tTBaseVideoActivity.as = str2;
                super.onReceivedError(webView, i, str2, str3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            @TargetApi(21)
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (webResourceRequest != null && webResourceRequest.getUrl() != null && TTBaseVideoActivity.this.P.equals(webResourceRequest.getUrl().toString())) {
                    TTBaseVideoActivity.this.ap.set(false);
                    if (webResourceResponse != null) {
                        TTBaseVideoActivity.this.ar = webResourceResponse.getStatusCode();
                        TTBaseVideoActivity.this.as = "onReceivedHttpError";
                    }
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str2) {
                if (!TTBaseVideoActivity.this.v.r()) {
                    return super.shouldInterceptRequest(webView, str2);
                }
                String strI = TTBaseVideoActivity.this.v.v().i();
                return com.bytedance.sdk.openadsdk.core.video.c.a.a().a(TTBaseVideoActivity.this.v.v().j(), strI, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            @TargetApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                TTBaseVideoActivity.this.ap.set(false);
                if (webResourceError != null && webResourceError.getDescription() != null) {
                    TTBaseVideoActivity.this.ar = webResourceError.getErrorCode();
                    TTBaseVideoActivity.this.as = webResourceError.getDescription().toString();
                }
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            @TargetApi(21)
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
                } catch (Throwable th) {
                    com.bytedance.sdk.openadsdk.utils.o.c("TTBaseVideoActivity", "shouldInterceptRequest error1", th);
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
            }
        });
        a(this.i);
        if (this.v.c() == 1 && this.v.r()) {
            a(this.k);
            f();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            SSWebView sSWebView2 = this.i;
            WebView.setWebContentsDebuggingEnabled(this.av);
            if (this.av) {
                this.i.getSettings().setDomStorageEnabled(true);
            }
        }
        g();
        if ("reward_endcard".equals(str) || "fullscreen_endcard".equals(str)) {
            this.i.setLayerType(1, null);
            this.i.setBackgroundColor(-1);
        }
        this.i.getSettings().setDisplayZoomControls(false);
        this.i.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.b(this.H, this.w) { // from class: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.14
            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.b, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                try {
                    if (!TTBaseVideoActivity.this.v.s() || !TTBaseVideoActivity.this.v.p() || TTBaseVideoActivity.this.isFinishing() || TTBaseVideoActivity.this.f5619e == null) {
                        return;
                    }
                    TTBaseVideoActivity.this.f5619e.setProgress(i);
                } catch (Throwable unused) {
                }
            }
        });
        this.i.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity.15
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str2, String str3, String str4, String str5, long j) {
                b.a.a.a.a.a.b bVar = TTBaseVideoActivity.this.G;
                if (bVar != null) {
                    bVar.a();
                }
                TTBaseVideoActivity.this.Q();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.e.f
    public void b(int i) {
        if (i > 0) {
            if (this.aN > 0) {
                this.aN = i;
            } else {
                com.bytedance.sdk.openadsdk.utils.o.b("onVolumeChanged", "onVolumeChanged >>>> 变为非静音状态通知 h5");
                c(false);
                this.aN = i;
            }
        } else if (this.aN > 0) {
            com.bytedance.sdk.openadsdk.utils.o.b("onVolumeChanged", "onVolumeChanged >>>> 变为静音状态通知 h5");
            c(true);
            this.aN = i;
        } else {
            this.aN = i;
        }
        if (h.b(this.v) || h.c(this.v)) {
            if (this.au.c()) {
                com.bytedance.sdk.openadsdk.utils.o.b("TTBaseVideoActivity", "onVolumeChanged by SDK mIsMute=" + this.Q + " mVolume=" + this.aN + " mLastVolume=" + this.au.b());
                if (this.aN == 0) {
                    a(true);
                    com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.F;
                    if (cVar != null) {
                        cVar.c(true);
                        return;
                    }
                    return;
                }
                a(false);
                com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar2 = this.F;
                if (cVar2 != null) {
                    cVar2.c(false);
                    return;
                }
                return;
            }
            this.au.b(-1);
            com.bytedance.sdk.openadsdk.utils.o.b("TTBaseVideoActivity", "onVolumeChanged by User mIsMute=" + this.Q + " mVolume=" + this.aN + " mLastVolume=" + this.au.b());
            if (this.aR) {
                if (this.aN == 0) {
                    this.Q = true;
                    a(true);
                    com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar3 = this.F;
                    if (cVar3 != null) {
                        cVar3.c(true);
                        return;
                    }
                    return;
                }
                this.Q = false;
                a(false);
                com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar4 = this.F;
                if (cVar4 != null) {
                    cVar4.c(false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Message c(int i) {
        Message messageObtain = Message.obtain();
        messageObtain.what = VipDiamond.MVP;
        messageObtain.arg1 = i;
        return messageObtain;
    }

    protected void c(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            this.H.a("volumeChange", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    void c(String str) {
        if (this.aF) {
            String str2 = this instanceof TTRewardVideoActivity ? "rewarded_video" : "fullscreen_interstitial_ad";
            HashMap map = new HashMap();
            map.put("duration", Long.valueOf(System.currentTimeMillis() - this.ax));
            com.bytedance.sdk.openadsdk.c.d.e(this, this.v, str2, str, map);
            if ("return_foreground".equals(str)) {
                this.aF = false;
            }
        }
    }

    protected void a(boolean z) {
        TopProxyLayout topProxyLayout = this.f5620f;
        if (topProxyLayout != null) {
            topProxyLayout.setSoundMute(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, JSONObject jSONObject) {
        if (this instanceof TTFullScreenVideoActivity) {
            com.bytedance.sdk.openadsdk.c.d.a(this.h, this.v, "fullscreen_interstitial_ad", str, (JSONObject) null);
        }
        if (this instanceof TTRewardVideoActivity) {
            com.bytedance.sdk.openadsdk.c.d.a(this.h, this.v, "rewarded_video", str, jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        if (view == null) {
            return;
        }
        if (view.getId() == t.e(this, "tt_rb_score")) {
            a("click_play_star_level", (JSONObject) null);
            return;
        }
        if (view.getId() == t.e(this, "tt_comment_vertical")) {
            a("click_play_star_nums", (JSONObject) null);
            return;
        }
        if (view.getId() == t.e(this, "tt_reward_ad_appname")) {
            a("click_play_source", (JSONObject) null);
            return;
        }
        if (view.getId() == t.e(this, "tt_reward_ad_icon")) {
            a("click_play_logo", (JSONObject) null);
            return;
        }
        if (view.getId() != t.e(this, "tt_video_reward_bar") && view.getId() != t.e(this, "tt_click_lower_non_content_layout") && view.getId() != t.e(this, "tt_click_upper_non_content_layout")) {
            if (view.getId() == t.e(this, "tt_reward_ad_download")) {
                a("click_start_play", w());
                return;
            } else if (view.getId() == t.e(this, "tt_video_reward_container")) {
                a("click_video", w());
                return;
            } else {
                if (view.getId() == t.e(this, "tt_reward_ad_download_backup")) {
                    a("fallback_endcard_click", w());
                    return;
                }
                return;
            }
        }
        a("click_start_play_bar", w());
    }

    protected void b(Context context) {
        try {
            this.J.a(null);
            context.unregisterReceiver(this.J);
        } catch (Throwable unused) {
        }
    }

    protected float b(Activity activity) {
        return ac.b(activity, ac.h(activity));
    }

    @Override // com.bytedance.sdk.openadsdk.utils.ad.a
    public void a(Message message) {
        int i = message.what;
        if (i == 500) {
            if (!h.a(this.v)) {
                U();
            }
            SSWebView sSWebView = this.j.get();
            if (sSWebView != null) {
                sSWebView.onResume();
                sSWebView.resumeTimers();
            }
            TopProxyLayout topProxyLayout = this.f5620f;
            if (topProxyLayout != null) {
                topProxyLayout.setShowCountDown(false);
            }
            SSWebView sSWebView2 = this.i;
            if (sSWebView2 != null) {
                ac.a((View) sSWebView2, 1.0f);
                ac.a((View) this.l, 1.0f);
                ac.a((View) this.m, 1.0f);
            }
            if ((this instanceof TTFullScreenVideoActivity) && this.F != null && s() && this.Y.get()) {
                this.F.i();
                this.F.l();
                return;
            }
            return;
        }
        if (i == 600) {
            S();
            return;
        }
        if (i == 700) {
            if (this.v.c() != 1) {
                return;
            }
            int i2 = message.arg1;
            if (i2 > 0) {
                TopProxyLayout topProxyLayout2 = this.f5620f;
                if (topProxyLayout2 != null) {
                    topProxyLayout2.setShowCountDown(true);
                    this.f5620f.a(String.valueOf(i2), (CharSequence) null);
                }
                Message messageObtain = Message.obtain();
                messageObtain.what = 700;
                int i3 = i2 - 1;
                messageObtain.arg1 = i3;
                this.az--;
                this.K.sendMessageDelayed(messageObtain, 1000L);
                this.ay = i3;
                if (i2 == 1) {
                    this.K.sendEmptyMessageDelayed(WebIndicator.DO_END_ANIMATION_DURATION, 1000L);
                }
            } else {
                TopProxyLayout topProxyLayout3 = this.f5620f;
                if (topProxyLayout3 != null) {
                    topProxyLayout3.setShowCountDown(false);
                }
                if (this instanceof TTRewardVideoActivity) {
                    e(10001);
                } else {
                    e(HttpCode.UN_KNOW);
                }
            }
            if (this instanceof TTRewardVideoActivity) {
                V();
                return;
            }
            return;
        }
        if (i == 300) {
            r();
            if (message.arg1 == 1) {
                e(10000);
                return;
            }
            return;
        }
        if (i == 800) {
            HashMap map = new HashMap();
            map.put("remove_loading_page_type", Integer.valueOf(message.arg1));
            if (this.v.v() != null) {
                map.put("playable_url", this.v.v().i());
            }
            com.bytedance.sdk.openadsdk.c.d.g(this, this.v, this.aE, "remove_loading_page", map);
            this.K.removeMessages(VipDiamond.MVP);
            PlayableLoadingView playableLoadingView = this.f5619e;
            if (playableLoadingView != null) {
                playableLoadingView.a();
                return;
            }
            return;
        }
        if (i == 900) {
            if (this.v.c() != 1) {
                return;
            }
            int i4 = message.arg1;
            if (i4 > 0) {
                TopProxyLayout topProxyLayout4 = this.f5620f;
                if (topProxyLayout4 != null) {
                    topProxyLayout4.setShowSkip(true);
                    this.f5620f.a(String.valueOf(i4), (CharSequence) null);
                }
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 900;
                int i5 = i4 - 1;
                messageObtain2.arg1 = i5;
                this.az--;
                this.K.sendMessageDelayed(messageObtain2, 1000L);
                this.ay = i5;
                if (i4 == 1) {
                    this.K.sendEmptyMessageDelayed(WebIndicator.DO_END_ANIMATION_DURATION, 1000L);
                }
            } else {
                TopProxyLayout topProxyLayout5 = this.f5620f;
                if (topProxyLayout5 != null) {
                    topProxyLayout5.setShowSkip(false);
                }
                if (this instanceof TTRewardVideoActivity) {
                    e(10001);
                } else {
                    e(HttpCode.UN_KNOW);
                }
            }
            if (this instanceof TTRewardVideoActivity) {
                V();
                return;
            }
            return;
        }
        if (i == 950 && this.v.c() == 1) {
            int i6 = message.arg1;
            int i7 = message.arg2;
            if (i6 > 0) {
                if (i6 == 1) {
                    this.K.sendEmptyMessageDelayed(WebIndicator.DO_END_ANIMATION_DURATION, 1000L);
                }
                int i8 = this.aB;
                if (i8 - i6 < i7) {
                    int i9 = i7 - (i8 - i6);
                    TopProxyLayout topProxyLayout6 = this.f5620f;
                    if (topProxyLayout6 != null) {
                        topProxyLayout6.setShowSkip(true);
                        this.f5620f.a(String.valueOf(i6), "可在(" + i9 + "s)后跳过");
                    }
                    Message messageObtain3 = Message.obtain();
                    messageObtain3.what = 950;
                    int i10 = i6 - 1;
                    messageObtain3.arg1 = i10;
                    messageObtain3.arg2 = i7;
                    this.az--;
                    this.K.sendMessageDelayed(messageObtain3, 1000L);
                    this.ay = i10;
                } else {
                    TopProxyLayout topProxyLayout7 = this.f5620f;
                    if (topProxyLayout7 != null) {
                        topProxyLayout7.setShowSkip(true);
                        this.f5620f.a(String.valueOf(i6), "跳过");
                        this.f5620f.setSkipEnable(true);
                    }
                    Message messageObtain4 = Message.obtain();
                    messageObtain4.what = 950;
                    int i11 = i6 - 1;
                    messageObtain4.arg1 = i11;
                    this.az--;
                    this.K.sendMessageDelayed(messageObtain4, 1000L);
                    this.ay = i11;
                }
            } else {
                TopProxyLayout topProxyLayout8 = this.f5620f;
                if (topProxyLayout8 != null) {
                    topProxyLayout8.setShowSkip(false);
                    this.f5620f.a(String.valueOf(i6), (CharSequence) null);
                }
                if (this instanceof TTRewardVideoActivity) {
                    e(10001);
                } else {
                    e(HttpCode.UN_KNOW);
                }
            }
            if (this instanceof TTRewardVideoActivity) {
                V();
            }
        }
    }

    private void e(boolean z) {
        if (z) {
            return;
        }
        TTRoundRectImageView tTRoundRectImageView = this.ak;
        if (tTRoundRectImageView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tTRoundRectImageView.getLayoutParams();
            layoutParams.setMargins(0, (int) ac.a(this, 50.0f), 0, 0);
            this.ak.setLayoutParams(layoutParams);
        }
        TextView textView = this.ao;
        if (textView != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView.getLayoutParams();
            layoutParams2.setMargins(0, (int) ac.a(this, 35.0f), 0, 0);
            layoutParams2.width = (int) ac.a(this, 342.0f);
            this.ao.setLayoutParams(layoutParams2);
        }
    }

    protected IListenerManager a(int i) {
        if (this.ae == null) {
            this.ae = IListenerManager.Stub.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(o.a()).a(i));
        }
        return this.ae;
    }

    protected void a(boolean z, boolean z2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z);
            jSONObject.put("endcard_show", z2);
            this.H.a("endcard_control_event", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected void a(int i, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, i);
            jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, i2);
            this.H.a("resize", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    protected void a(String str, String str2, Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.F;
        if (cVar != null) {
            Map<String, Object> mapA = ab.a(this.v, cVar.n(), this.F.t());
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    mapA.put(entry.getKey(), entry.getValue());
                }
            }
            com.bytedance.sdk.openadsdk.c.d.a(this.h, this.v, str, str2, this.F.o(), this.F.q(), mapA);
            com.bytedance.sdk.openadsdk.utils.o.b("TTBaseVideoActivity", "event tag:" + str + ", TotalPlayDuration=" + this.F.o() + ",mBasevideoController.getPct()=" + this.F.q());
        }
    }

    protected void a(String str, Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar = this.F;
        if (cVar != null) {
            Map<String, Object> mapA = ab.a(this.v, cVar.n(), this.F.t());
            if (map != null) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    mapA.put(entry.getKey(), entry.getValue());
                }
            }
            mapA.put("play_type", Integer.valueOf(ab.a(this.F, this.C)));
            com.bytedance.sdk.openadsdk.c.d.a(this.h, this.v, str, "endcard_skip", this.F.o(), this.F.q(), mapA);
        }
    }

    protected void a(Context context) {
        try {
            this.J = new HomeWatcherReceiver();
            this.J.a(this);
            context.registerReceiver(this.J, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        } catch (Throwable unused) {
        }
    }

    protected float a(Activity activity) {
        return ac.b(activity, ac.g(activity));
    }
}
