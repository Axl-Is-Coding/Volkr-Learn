package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import cn.qqtheme.framework.widget.WheelView;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.c.p;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.o;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class NativeExpressView extends FrameLayout implements j {
    private final AtomicBoolean A;
    private String B;
    private float C;
    private float D;
    private final AtomicBoolean E;
    private com.bytedance.sdk.openadsdk.c.j F;
    private p G;
    private String H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.dislike.b f6280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TTDislikeDialogAbstract f6281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f6282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f6283d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final AtomicBoolean f6284e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final Context f6285f;
    protected WeakReference<SSWebView> g;
    protected v h;
    protected String i;
    protected AdSlot j;
    protected com.bytedance.sdk.openadsdk.core.d.h k;
    protected TTNativeExpressAd.ExpressVideoAdListener l;
    protected FrameLayout m;
    protected boolean n;
    protected boolean o;
    protected ScheduledFuture<?> p;
    protected c q;
    protected boolean r;
    protected BackupView s;
    private int t;
    private int u;
    private TTNativeExpressAd.ExpressAdInteractionListener v;
    private d w;
    private e x;
    private final Map<String, b.a.a.a.a.a.b> y;
    private final AtomicBoolean z;

    private class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f6293b;

        public a(int i) {
            this.f6293b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f6293b == 1) {
                o.c("NativeExpressView", "MSG_RENDER_TIME_OUT-->OnAdRenderRunnable......run....");
                NativeExpressView.this.a(false, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, 107);
            }
        }
    }

    public NativeExpressView(Context context, com.bytedance.sdk.openadsdk.core.d.h hVar, AdSlot adSlot, String str) {
        super(context);
        this.f6284e = new AtomicBoolean(false);
        this.i = "embeded_ad";
        this.y = Collections.synchronizedMap(new HashMap());
        this.z = new AtomicBoolean(false);
        this.A = new AtomicBoolean(false);
        this.B = null;
        this.o = false;
        this.r = false;
        this.E = new AtomicBoolean(false);
        this.H = "{\"id\":0,\"tplId\":0,\"title\":\"\",\"data\":{\"id\":\"root\",\"type\":\"vessel\",\"values\":{\"widthMode\":\"fixed\",\"width\":320,\"height\":320},\"children\":[[{\"type\":\"text\",\"values\":{\"fontSize\":19,\"fontWeight\":500,\"color\":\"#222222\",\"lineHeight\":1.3,\"data\":\"title\"}}],[{\"type\":\"text\",\"values\":{\"fontSize\":15,\"fontWeight\":500,\"color\":\"#999999\",\"lineHeight\":1,\"data\":\"subtitle\"}}],[{\"type\":\"image\",\"values\":{},\"children\":[]}],[{\"type\":\"vessel\",\"values\":{\"height\":40,\"paddingTop\":10,\"paddingRight\":15,\"paddingBottom\":10,\"paddingLeft\":15},\"children\":[[{\"type\":\"logo\",\"values\":{}},{\"type\":\"text\",\"values\":{\"widthMode\":\"auto\",\"paddingTop\":3,\"paddingRight\":0,\"paddingBottom\":3,\"paddingLeft\":6,\"fontSize\":12,\"color\":\"#999999\",\"lineHeight\":1,\"data\":\"source\"}},{\"type\":\"text\",\"values\":{\"widthMode\":\"auto\",\"paddingTop\":3,\"paddingRight\":0,\"paddingBottom\":3,\"paddingLeft\":10,\"fontSize\":12,\"color\":\"#999999\",\"lineHeight\":1,\"data\":\"time\"}},{\"type\":\"empty\",\"values\":{\"height\":18}},{\"type\":\"dislike\",\"values\":{}}]]}]]}}";
        this.i = str;
        this.f6285f = context;
        this.k = hVar;
        a(adSlot);
        a();
    }

    private void c() {
        this.f6282c = this.k.J();
        this.f6283d = this.k.M();
        this.u = 3153;
        this.t = ab.a(this.i);
        this.B = this.j.getCodeId();
    }

    private void d() {
        a(getWebView());
        this.F = new com.bytedance.sdk.openadsdk.c.j(this.f6285f, this.k, getWebView()).a(true);
        this.F.a(this.G);
        getWebView().setWebViewClient(new f(this.f6285f, this.h, this.k, this.F));
        getWebView().setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.b(this.h, this.F));
        getWebView().setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.1
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                NativeExpressView nativeExpressView = NativeExpressView.this;
                b.a.a.a.a.a.b bVarA = b.a.a.a.a.a.c.a(nativeExpressView.f6285f, nativeExpressView.k, nativeExpressView.i);
                if (bVarA != null) {
                    bVarA.a();
                }
            }
        });
    }

    private boolean e() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.k;
        return (hVar == null || hVar.u() == null || TextUtils.isEmpty(this.k.u().e())) ? false : true;
    }

    private boolean f() {
        com.bytedance.sdk.openadsdk.core.d.h hVar = this.k;
        return hVar != null && hVar.e() == 1 && (this.k.N() == 5 || this.k.N() == 15);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int getAdSlotType() {
        /*
            r6 = this;
            java.lang.String r0 = r6.i
            int r1 = r0.hashCode()
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 5
            switch(r1) {
                case -1695837674: goto L4a;
                case -1364000502: goto L40;
                case -764631662: goto L36;
                case -712491894: goto L2c;
                case 174971131: goto L22;
                case 1844104722: goto L18;
                case 1912999166: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L54
        Le:
            java.lang.String r1 = "draw_ad"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L54
            r0 = 1
            goto L55
        L18:
            java.lang.String r1 = "interaction"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L54
            r0 = 5
            goto L55
        L22:
            java.lang.String r1 = "splash_ad"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L54
            r0 = 6
            goto L55
        L2c:
            java.lang.String r1 = "embeded_ad"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L54
            r0 = 0
            goto L55
        L36:
            java.lang.String r1 = "fullscreen_interstitial_ad"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L54
            r0 = 3
            goto L55
        L40:
            java.lang.String r1 = "rewarded_video"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L54
            r0 = 2
            goto L55
        L4a:
            java.lang.String r1 = "banner_ad"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L54
            r0 = 4
            goto L55
        L54:
            r0 = -1
        L55:
            switch(r0) {
                case 0: goto L64;
                case 1: goto L61;
                case 2: goto L5f;
                case 3: goto L5c;
                case 4: goto L5b;
                case 5: goto L5a;
                case 6: goto L59;
                default: goto L58;
            }
        L58:
            return r5
        L59:
            return r2
        L5a:
            return r3
        L5b:
            return r4
        L5c:
            r0 = 8
            return r0
        L5f:
            r0 = 7
            return r0
        L61:
            r0 = 9
            return r0
        L64:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.getAdSlotType():int");
    }

    private JSONObject getCreativeJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("button_text", this.k.I());
            if (this.k.y() != null) {
                jSONObject.put("icon", this.k.y().a());
            }
            JSONArray jSONArray = new JSONArray();
            if (this.k.B() != null) {
                for (int i = 0; i < this.k.B().size(); i++) {
                    com.bytedance.sdk.openadsdk.core.d.g gVar = this.k.B().get(i);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, gVar.c());
                    jSONObject2.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, gVar.b());
                    jSONObject2.put("url", gVar.a());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("image", jSONArray);
            jSONObject.put("image_mode", this.k.N());
            jSONObject.put("interaction_type", this.k.x());
            jSONObject.put("title", this.k.G());
            jSONObject.put("description", this.k.H());
            jSONObject.put("source", this.k.w());
            if (this.k.K() != null) {
                jSONObject.put("comment_num", this.k.K().e());
                jSONObject.put(FirebaseAnalytics.Param.SCORE, this.k.K().d());
                jSONObject.put("app_size", this.k.K().f());
                jSONObject.put("app", this.k.K().g());
            }
            if (this.k.v() != null) {
                jSONObject.put("video", this.k.v().l());
            }
            if (this.k.u() != null) {
                jSONObject.put("dynamic_creative", this.k.u().g());
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONObject getTemplateInfo() {
        String strE;
        String strF;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", "android");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.C);
            jSONObject2.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.D);
            if (this.o) {
                jSONObject2.put("isLandscape", true);
            }
            jSONObject.put("AdSize", jSONObject2);
            jSONObject.put("creative", getCreativeJson());
            if (this.k.u() != null) {
                strE = this.k.u().e();
                strF = this.k.u().f();
            } else {
                strE = null;
                strF = null;
            }
            if (!TextUtils.isEmpty(strE)) {
                this.H = strE;
            } else if (com.bytedance.sdk.openadsdk.core.widget.webview.a.a.b(this.k) != null) {
                this.H = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.b(this.k).e();
            }
            jSONObject.put("template_Plugin", this.H);
            jSONObject.put("diff_template_Plugin", strF);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private void n() {
        com.bytedance.sdk.openadsdk.f.a.a().a(com.bytedance.sdk.openadsdk.f.a.c.b().a(getAdSlotType()).c(this.B).e(ab.h(this.f6283d)).a("dynamic_backup_render_new"));
    }

    private void o() {
        if (this.z.getAndSet(false) && getWebView().getParent() == null && !this.r) {
            o.e("webviewpool", "attachCallback+++========-----------===========");
            a();
            h();
        }
    }

    private void p() {
        if (this.z.getAndSet(true) || this.r) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.webview.d.a().a(this, this.g, j());
    }

    private void q() {
        try {
            if (this.p == null || this.p.isCancelled()) {
                return;
            }
            o.b("NativeExpressView", "MSG_RENDER_TIME_OUT-->mRenderTimeOutFuture-->cancel.....success=" + this.p.cancel(false));
            this.p = null;
        } catch (Throwable unused) {
        }
    }

    protected void b() {
        this.G = new p(1, this.i, this.k);
        this.h = new v(this.f6285f);
        this.h.a((WebView) getWebView()).a(this.k).a(this.f6282c).b(this.f6283d).b(this.t).c(ab.e(this.k)).a((j) this).a(getTemplateInfo()).a(this.G);
    }

    public void g() {
        if (this.h == null || this.E.get()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("expressShow", true);
            this.h.a("expressShow", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public d getClickCreativeListener() {
        return this.w;
    }

    public e getClickListener() {
        return this.x;
    }

    public int getExpectExpressHeight() {
        return Float.valueOf(this.D).intValue();
    }

    public int getExpectExpressWidth() {
        return Float.valueOf(this.C).intValue();
    }

    public SSWebView getWebView() {
        WeakReference<SSWebView> weakReference = this.g;
        if (weakReference != null && weakReference.get() != null) {
            return this.g.get();
        }
        this.g = com.bytedance.sdk.openadsdk.core.widget.webview.d.a().c();
        return this.g.get();
    }

    public void h() {
        this.A.set(true);
        this.G.a();
        this.p = com.bytedance.sdk.openadsdk.i.a.a().a(new a(1), com.bytedance.sdk.openadsdk.core.o.h().m());
        if (!com.bytedance.sdk.openadsdk.core.widget.webview.a.a.g()) {
            a(false, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, 102);
            return;
        }
        String strC = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.f() != null ? com.bytedance.sdk.openadsdk.core.widget.webview.a.a.f().c() : null;
        if (TextUtils.isEmpty(strC)) {
            a(false, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, 102);
            return;
        }
        com.bytedance.sdk.openadsdk.core.d.l lVarB = com.bytedance.sdk.openadsdk.core.widget.webview.a.a.b(this.k);
        if (lVarB == null && !e()) {
            a(false, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, 103);
            return;
        }
        String strF = lVarB != null ? lVarB.f() : null;
        if (e() && !TextUtils.isEmpty(this.k.u().a())) {
            strF = this.k.u().a();
        }
        if (!com.bytedance.sdk.openadsdk.core.widget.webview.a.f.b(strF) || "https://sf3-ttcdn-tos.pstatp.com/obj/ad-pattern/renderer/latest/index.html".equals(strC)) {
            getWebView().loadUrl(strC);
        } else {
            a(false, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, 102);
        }
    }

    public void i() {
        if (getWebView() == null || this.E.get()) {
            return;
        }
        try {
            if (this.i.equals("embeded_ad")) {
                com.bytedance.sdk.openadsdk.core.widget.webview.a.a(this.f6285f).a(true).a(getWebView());
            }
            getWebView().resumeTimers();
        } catch (Exception unused) {
        }
    }

    boolean j() {
        if ("embeded_ad".equals(this.i) || "draw_ad".equals(this.i)) {
            return false;
        }
        this.E.set(true);
        return true;
    }

    public void k() {
        try {
            com.bytedance.sdk.openadsdk.core.widget.webview.d.a().a(this, this.g, true);
            this.E.set(true);
            this.h = null;
            this.f6280a = null;
            this.f6281b = null;
            this.j = null;
            this.k = null;
            this.v = null;
            this.w = null;
            this.x = null;
            this.y.clear();
            this.l = null;
            removeAllViews();
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            q();
        } catch (Throwable th) {
            o.c("NativeExpressView", "detach error", th);
        }
    }

    public void l() {
        try {
            com.bytedance.sdk.openadsdk.core.widget.webview.d.a().a(this, this.g, true);
            this.E.set(true);
        } catch (Throwable th) {
            o.a("NativeExpressView", "backupDestroy remove webview error", th);
        }
        try {
            if (this.m == null || this.m.getParent() == null) {
                return;
            }
            removeView(this.m);
        } catch (Throwable th2) {
            o.a("NativeExpressView", "backupDestroy remove video container error", th2);
        }
    }

    public boolean m() {
        return this.r;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        o.e("webviewpool", "onAttachedToWindow+++");
        o();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        p();
        o.e("webviewpool", "onDetachedFromWindow===");
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        o.e("webviewpool", "onFinishTemporaryDetach+++");
        o();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        p();
    }

    public void setBackupListener(c cVar) {
        this.q = cVar;
    }

    public void setClickCreativeListener(d dVar) {
        this.w = dVar;
    }

    public void setClickListener(e eVar) {
        this.x = eVar;
    }

    public void setDislike(com.bytedance.sdk.openadsdk.dislike.b bVar) {
        BackupView backupView = this.s;
        if (backupView != null) {
            backupView.setDislikeInner(bVar);
        }
        this.f6280a = bVar;
    }

    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.v = expressAdInteractionListener;
    }

    public void setOuterDislike(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        BackupView backupView = this.s;
        if (backupView != null) {
            backupView.setDislikeOuter(tTDislikeDialogAbstract);
        }
        this.f6281b = tTDislikeDialogAbstract;
    }

    public void setVideoAdListener(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        this.l = expressVideoAdListener;
    }

    private void a(AdSlot adSlot) {
        this.j = adSlot;
        AdSlot adSlot2 = this.j;
        if (adSlot2 == null) {
            return;
        }
        this.C = adSlot2.getExpressViewAcceptedWidth();
        this.D = this.j.getExpressViewAcceptedHeight();
    }

    protected void a() {
        setBackgroundColor(0);
        if (getWebView().getParent() != null) {
            ((ViewGroup) getWebView().getParent()).removeView(getWebView());
        }
        getWebView().setBackgroundColor(0);
        addView(getWebView(), new FrameLayout.LayoutParams(-1, -1));
        c();
        b();
        d();
        getWebView().addJavascriptInterface(this.h, "SDK_INJECT_GLOBAL");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, float f2, float f3, int i) {
        if (this.f6284e.getAndSet(true)) {
            return;
        }
        if (z) {
            this.G.b();
            a(f2, f3);
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this.v;
            if (expressAdInteractionListener != null) {
                expressAdInteractionListener.onRenderSuccess(this, f2, f3);
            }
        } else {
            this.G.a(i);
            this.G.c();
            this.G.a(true);
            c cVar = this.q;
            this.r = cVar != null && cVar.a(this, i);
            this.G.d();
            if (this.r) {
                n();
                com.bytedance.sdk.openadsdk.c.d.e(com.bytedance.sdk.openadsdk.core.o.a(), this.k, this.i, "dynamic_backup_render", null);
                this.s = (BackupView) findViewWithTag("tt_express_backup_fl_tag_26");
                TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener2 = this.v;
                if (expressAdInteractionListener2 != null) {
                    expressAdInteractionListener2.onRenderSuccess(this, this.s.getRealWidth(), this.s.getRealHeight());
                }
            } else {
                TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener3 = this.v;
                if (expressAdInteractionListener3 != null) {
                    expressAdInteractionListener3.onRenderFail(this, com.bytedance.sdk.openadsdk.core.g.a(i), i);
                }
            }
            a(i);
        }
        this.G.h();
        this.G.i();
    }

    private void a(SSWebView sSWebView) {
        if (sSWebView == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.webview.a.a(this.f6285f).a(!this.i.equals("embeded_ad")).a(sSWebView);
            sSWebView.setVerticalScrollBarEnabled(false);
            sSWebView.setHorizontalScrollBarEnabled(false);
            sSWebView.clearCache(true);
            sSWebView.clearHistory();
            WebSettings settings = sSWebView.getSettings();
            settings.setUserAgentString(com.bytedance.sdk.openadsdk.utils.l.a(sSWebView, this.u));
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
            settings.setJavaScriptEnabled(true);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            settings.setCacheMode(2);
            settings.setDomStorageEnabled(true);
            settings.setDatabaseEnabled(true);
            settings.setAppCacheEnabled(true);
            settings.setAllowFileAccess(true);
            settings.setSupportZoom(true);
            settings.setBuiltInZoomControls(true);
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            settings.setUseWideViewPort(true);
        } catch (Exception e2) {
            o.e("NativeExpressView", e2.toString());
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.j jVar) {
        if (jVar == null) {
            a(false, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, 105);
        } else {
            boolean zA = jVar.a();
            a(zA, (float) jVar.b(), (float) jVar.c(), zA ? 0 : jVar.h());
        }
    }

    private void a(float f2, float f3) {
        if (f2 <= WheelView.DividerConfig.FILL || f3 <= WheelView.DividerConfig.FILL) {
            return;
        }
        int iA = (int) ac.a(this.f6285f, f2);
        int iA2 = (int) ac.a(this.f6285f, f3);
        o.e("ExpressView", "width:" + iA);
        o.e("ExpressView", "height:" + iA2);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getWebView().getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(iA, iA2);
        }
        layoutParams.width = iA;
        layoutParams.height = iA2;
        getWebView().setLayoutParams(layoutParams);
    }

    public void a(int i, com.bytedance.sdk.openadsdk.core.d.f fVar) {
        if (i == -1 || fVar == null) {
            return;
        }
        int i2 = fVar.f6088a;
        int i3 = fVar.f6089b;
        int i4 = fVar.f6090c;
        int i5 = fVar.f6091d;
        if (i == 1) {
            FrameLayout frameLayout = this.m;
            if (frameLayout != null) {
                frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, 0));
            }
            e eVar = this.x;
            if (eVar != null) {
                eVar.a(fVar);
                this.x.a(this, i2, i3, i4, i5);
            }
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = this.v;
            if (expressAdInteractionListener != null) {
                expressAdInteractionListener.onAdClicked(this, this.k.x());
                return;
            }
            return;
        }
        if (i == 2) {
            d dVar = this.w;
            if (dVar != null) {
                dVar.a(fVar);
                this.w.a(this, i2, i3, i4, i5);
            }
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener2 = this.v;
            if (expressAdInteractionListener2 != null) {
                expressAdInteractionListener2.onAdClicked(this, this.k.x());
                return;
            }
            return;
        }
        if (i == 3) {
            TTDislikeDialogAbstract tTDislikeDialogAbstract = this.f6281b;
            if (tTDislikeDialogAbstract != null) {
                tTDislikeDialogAbstract.show();
            } else {
                com.bytedance.sdk.openadsdk.dislike.b bVar = this.f6280a;
                if (bVar != null) {
                    bVar.showDislikeDialog();
                }
            }
            TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener3 = this.v;
            if (expressAdInteractionListener3 != null) {
                expressAdInteractionListener3.onAdClicked(this, this.k.x());
                return;
            }
            return;
        }
        if (i != 4) {
            return;
        }
        FrameLayout frameLayout2 = this.m;
        if (frameLayout2 != null) {
            frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, 0));
        }
        o.b("ClickCreativeListener", "创意....mAdType=" + this.i + ",!mVideoPause=" + (true ^ this.n) + "，isAutoPlay=" + ab.f(this.k));
        if ("embeded_ad".equals(this.i) && f() && !this.n && ab.f(this.k)) {
            o.b("ClickCreativeListener", "创意....");
            d dVar2 = this.w;
            if (dVar2 != null) {
                dVar2.a(fVar);
                this.w.a(this, i2, i3, i4, i5);
            }
        } else {
            o.b("ClickCreativeListener", "普通....");
            e eVar2 = this.x;
            if (eVar2 != null) {
                eVar2.a(fVar);
                this.x.a(this, i2, i3, i4, i5);
            }
        }
        TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener4 = this.v;
        if (expressAdInteractionListener4 != null) {
            expressAdInteractionListener4.onAdClicked(this, this.k.x());
        }
    }

    private void a(int i) {
        com.bytedance.sdk.openadsdk.f.a.a().c(com.bytedance.sdk.openadsdk.f.a.c.b().a(getAdSlotType()).c(this.B).e(ab.h(this.f6283d)).b(i).f(com.bytedance.sdk.openadsdk.core.g.a(i)));
    }

    protected void a(final boolean z, final float f2, final float f3, final int i) {
        q();
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b(z, f2, f3, i);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView.2
                @Override // java.lang.Runnable
                public void run() {
                    NativeExpressView.this.b(z, f2, f3, i);
                }
            });
        }
    }
}
