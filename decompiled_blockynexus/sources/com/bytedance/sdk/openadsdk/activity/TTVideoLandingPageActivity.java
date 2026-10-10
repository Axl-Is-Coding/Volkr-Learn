package com.bytedance.sdk.openadsdk.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import b.a.a.a.a.a.b;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.c.j;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.d.i;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.s;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.e;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.f;
import com.bytedance.sdk.openadsdk.core.widget.RoundImageView;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.core.y;
import com.bytedance.sdk.openadsdk.d.d;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.l;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TTVideoLandingPageActivity extends Activity implements d {
    private ViewStub A;
    private Button B;
    private ProgressBar C;
    private b D;
    private String F;
    private int K;
    private a L;
    private j M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SSWebView f5703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageView f5704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ImageView f5705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f5706d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f5707e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f5708f;
    private String g;
    private String h;
    private v i;
    private int j;
    private RelativeLayout k;
    private FrameLayout l;
    private NativeVideoTsView n;
    private long o;
    private h p;
    private RelativeLayout v;
    private TextView w;
    private RoundImageView x;
    private TextView y;
    private TextView z;
    private int m = -1;
    private int q = 0;
    private int r = 0;
    private int s = 0;
    private int t = 0;
    private String u = "ダウンロード";
    private boolean E = false;
    private boolean G = false;
    private boolean H = true;
    private boolean I = false;
    private String J = null;
    private AtomicBoolean N = new AtomicBoolean(true);
    private JSONArray O = null;
    private com.bytedance.sdk.openadsdk.core.a.a P = null;
    private final e Q = new e() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.7
        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.e
        public void a(boolean z) {
            TTVideoLandingPageActivity.this.E = z;
            if (TTVideoLandingPageActivity.this.isFinishing()) {
                return;
            }
            if (!z) {
                ac.a((View) TTVideoLandingPageActivity.this.f5703a, 0);
                ac.a((View) TTVideoLandingPageActivity.this.k, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) TTVideoLandingPageActivity.this.l.getLayoutParams();
                marginLayoutParams.width = TTVideoLandingPageActivity.this.s;
                marginLayoutParams.height = TTVideoLandingPageActivity.this.t;
                marginLayoutParams.leftMargin = TTVideoLandingPageActivity.this.r;
                marginLayoutParams.topMargin = TTVideoLandingPageActivity.this.q;
                TTVideoLandingPageActivity.this.l.setLayoutParams(marginLayoutParams);
                return;
            }
            ac.a((View) TTVideoLandingPageActivity.this.f5703a, 8);
            ac.a((View) TTVideoLandingPageActivity.this.k, 8);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) TTVideoLandingPageActivity.this.l.getLayoutParams();
            TTVideoLandingPageActivity.this.r = marginLayoutParams2.leftMargin;
            TTVideoLandingPageActivity.this.q = marginLayoutParams2.topMargin;
            TTVideoLandingPageActivity.this.s = marginLayoutParams2.width;
            TTVideoLandingPageActivity.this.t = marginLayoutParams2.height;
            marginLayoutParams2.width = -1;
            marginLayoutParams2.height = -1;
            marginLayoutParams2.topMargin = 0;
            marginLayoutParams2.leftMargin = 0;
            TTVideoLandingPageActivity.this.l.setLayoutParams(marginLayoutParams2);
        }
    };
    private boolean R = false;
    private final BroadcastReceiver S = new BroadcastReceiver() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.8
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                int iC = q.c(TTVideoLandingPageActivity.this.getApplicationContext());
                if (TTVideoLandingPageActivity.this.K == 0 && iC != 0 && TTVideoLandingPageActivity.this.f5703a != null && TTVideoLandingPageActivity.this.J != null) {
                    TTVideoLandingPageActivity.this.f5703a.loadUrl(TTVideoLandingPageActivity.this.J);
                }
                if (TTVideoLandingPageActivity.this.n != null && TTVideoLandingPageActivity.this.n.getNativeVideoController() != null && !TTVideoLandingPageActivity.this.G && TTVideoLandingPageActivity.this.K != iC) {
                    ((f) TTVideoLandingPageActivity.this.n.getNativeVideoController()).a(context);
                }
                TTVideoLandingPageActivity.this.K = iC;
            }
        }
    };

    @Override // android.app.Activity
    public void onBackPressed() {
        NativeVideoTsView nativeVideoTsView;
        if (this.E && (nativeVideoTsView = this.n) != null && nativeVideoTsView.getNativeVideoController() != null) {
            ((com.bytedance.sdk.openadsdk.core.video.nativevideo.a) this.n.getNativeVideoController()).e(null, null);
            this.E = false;
        } else if (!n() || this.N.getAndSet(true)) {
            super.onBackPressed();
        } else {
            a(true);
            a(0);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        c();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.bytedance.sdk.openadsdk.core.h.b().l()) {
            getWindow().addFlags(2621440);
        }
        try {
            getWindow().addFlags(16777216);
        } catch (Throwable unused) {
        }
        try {
            o.a(this);
        } catch (Throwable unused2) {
        }
        this.K = q.c(getApplicationContext());
        setContentView(t.f(this, "tt_activity_videolandingpage"));
        this.f5707e = this;
        Intent intent = getIntent();
        this.f5708f = intent.getIntExtra("sdk_version", 1);
        this.g = intent.getStringExtra("adid");
        this.h = intent.getStringExtra("log_extra");
        this.j = intent.getIntExtra("source", -1);
        this.J = intent.getStringExtra("url");
        String stringExtra = intent.getStringExtra("web_title");
        this.F = intent.getStringExtra("event_tag");
        this.I = intent.getBooleanExtra("video_is_auto_play", true);
        if (bundle != null && bundle.getLong("video_play_position") > 0) {
            this.o = bundle.getLong("video_play_position", 0L);
        }
        String stringExtra2 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_DATA);
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            String stringExtra3 = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
            if (stringExtra3 != null) {
                try {
                    this.p = c.a(new JSONObject(stringExtra3));
                } catch (Exception unused3) {
                }
            }
            h hVar = this.p;
            if (hVar != null) {
                this.m = hVar.N();
            }
        } else {
            this.p = s.a().c();
            h hVar2 = this.p;
            if (hVar2 != null) {
                this.m = hVar2.N();
            }
            s.a().g();
        }
        if (stringExtra2 != null) {
            try {
                this.L = a.a(new JSONObject(stringExtra2));
            } catch (Exception unused4) {
            }
            a aVar = this.L;
            if (aVar != null) {
                this.o = aVar.g;
                this.G = aVar.f7058a;
            }
        }
        if (bundle != null) {
            String string = bundle.getString("material_meta");
            if (this.p == null) {
                try {
                    this.p = c.a(new JSONObject(string));
                } catch (Throwable unused5) {
                }
            }
            long j = bundle.getLong("video_play_position");
            boolean z = bundle.getBoolean("is_complete");
            if (j > 0) {
                this.o = j;
            }
            if (z) {
                this.G = z;
            }
        }
        e();
        j();
        k();
        a(4);
        com.bytedance.sdk.openadsdk.core.widget.webview.a.a(this.f5707e).a(Build.VERSION.SDK_INT >= 16).b(false).a(this.f5703a);
        this.M = new j(this, this.p, this.f5703a).a(true);
        this.f5703a.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.webview.c(this.f5707e, this.i, this.g, this.M) { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.1
            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                try {
                    if (TTVideoLandingPageActivity.this.C == null || TTVideoLandingPageActivity.this.isFinishing()) {
                        return;
                    }
                    TTVideoLandingPageActivity.this.C.setVisibility(8);
                } catch (Throwable unused6) {
                }
            }
        });
        this.f5703a.getSettings().setUserAgentString(l.a(this.f5703a, this.f5708f));
        if (Build.VERSION.SDK_INT >= 21) {
            this.f5703a.getSettings().setMixedContentMode(0);
        }
        this.f5703a.loadUrl(this.J);
        this.f5703a.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.webview.b(this.i, this.M) { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.webview.b, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (TTVideoLandingPageActivity.this.C == null || TTVideoLandingPageActivity.this.isFinishing()) {
                    return;
                }
                if (i == 100 && TTVideoLandingPageActivity.this.C.isShown()) {
                    TTVideoLandingPageActivity.this.C.setVisibility(8);
                } else {
                    TTVideoLandingPageActivity.this.C.setProgress(i);
                }
            }
        });
        this.f5703a.setDownloadListener(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.3
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                if (TTVideoLandingPageActivity.this.D != null) {
                    TTVideoLandingPageActivity.this.D.a();
                }
            }
        });
        TextView textView = this.f5706d;
        if (textView != null) {
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = t.a(this, "tt_web_title_default");
            }
            textView.setText(stringExtra);
        }
        a();
        f();
        c();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        ViewGroup viewGroup;
        super.onDestroy();
        b();
        try {
            if (getWindow() != null && (viewGroup = (ViewGroup) getWindow().getDecorView()) != null) {
                viewGroup.removeAllViews();
            }
        } catch (Throwable unused) {
        }
        y.a(this.f5707e, this.f5703a);
        y.a(this.f5703a);
        this.f5703a = null;
        v vVar = this.i;
        if (vVar != null) {
            vVar.g();
        }
        NativeVideoTsView nativeVideoTsView = this.n;
        if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
            this.n.getNativeVideoController().l();
        }
        this.n = null;
        this.p = null;
        j jVar = this.M;
        if (jVar != null) {
            jVar.d();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        NativeVideoTsView nativeVideoTsView;
        NativeVideoTsView nativeVideoTsView2;
        super.onPause();
        v vVar = this.i;
        if (vVar != null) {
            vVar.f();
        }
        m();
        if (this.G || ((nativeVideoTsView2 = this.n) != null && nativeVideoTsView2.getNativeVideoController() != null && this.n.getNativeVideoController().v())) {
            this.G = true;
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", (Boolean) true);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_native_video_complete", (Boolean) true);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", (Boolean) true);
        }
        if (this.G || (nativeVideoTsView = this.n) == null || nativeVideoTsView.getNativeVideoController() == null) {
            return;
        }
        a(this.n.getNativeVideoController());
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.H = false;
        v vVar = this.i;
        if (vVar != null) {
            vVar.e();
        }
        l();
        j jVar = this.M;
        if (jVar != null) {
            jVar.b();
        }
        o();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        h hVar = this.p;
        bundle.putString("material_meta", hVar != null ? hVar.Z().toString() : null);
        bundle.putLong("video_play_position", this.o);
        bundle.putBoolean("is_complete", this.G);
        long jM = this.o;
        NativeVideoTsView nativeVideoTsView = this.n;
        if (nativeVideoTsView != null && nativeVideoTsView.getNativeVideoController() != null) {
            jM = this.n.getNativeVideoController().m();
        }
        bundle.putLong("video_play_position", jM);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        j jVar = this.M;
        if (jVar != null) {
            jVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long g() {
        NativeVideoTsView nativeVideoTsView = this.n;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return 0L;
        }
        return this.n.getNativeVideoController().o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h() {
        NativeVideoTsView nativeVideoTsView = this.n;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return 0;
        }
        return this.n.getNativeVideoController().q();
    }

    private void i() {
        h hVar = this.p;
        if (hVar == null || hVar.x() != 4) {
            return;
        }
        ac.a((View) this.v, 0);
        String strG = !TextUtils.isEmpty(this.p.G()) ? this.p.G() : !TextUtils.isEmpty(this.p.H()) ? this.p.H() : !TextUtils.isEmpty(this.p.w()) ? this.p.w() : "";
        if (this.p.y() != null && this.p.y().a() != null) {
            ac.a((View) this.x, 0);
            ac.a((View) this.w, 4);
            com.bytedance.sdk.openadsdk.g.d.a(this.f5707e).a(this.p.y().a(), this.x);
        } else if (!TextUtils.isEmpty(strG)) {
            ac.a((View) this.x, 4);
            ac.a((View) this.w, 0);
            this.w.setText(strG.substring(0, 1));
        }
        if (!TextUtils.isEmpty(strG)) {
            this.y.setText(strG);
        }
        ac.a((View) this.y, 0);
        ac.a((View) this.z, 0);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void j() {
        h hVar = this.p;
        if (hVar == null || hVar.x() != 4) {
            return;
        }
        this.D = b.a.a.a.a.a.c.a(this, this.p, this.F);
        this.P = new com.bytedance.sdk.openadsdk.core.a.a(this, this.p, this.F, this.j);
        this.P.a(false);
        this.P.c(true);
        this.z.setOnClickListener(this.P);
        this.z.setOnTouchListener(this.P);
        this.P.a(this.D);
    }

    private void k() {
        this.i = new v(this);
        this.i.a((WebView) this.f5703a).a(this.g).b(this.h).b(this.j).a(this.p).a(this.p.t()).c(ab.e(this.p));
    }

    private void l() {
        NativeVideoTsView nativeVideoTsView = this.n;
        if (nativeVideoTsView == null || nativeVideoTsView.getNativeVideoController() == null) {
            return;
        }
        this.n.setIsQuiet(false);
        com.bytedance.sdk.openadsdk.core.video.e.d dVarT = this.n.getNativeVideoController().t();
        if (dVarT != null && dVarT.i()) {
            this.n.a(this.o, this.H, this.G);
            return;
        }
        if (!(dVarT == null && this.R) && (dVarT == null || !dVarT.j())) {
            return;
        }
        this.R = false;
        this.n.a(this.o, this.H, this.G);
    }

    private void m() {
        NativeVideoTsView nativeVideoTsView = this.n;
        if (nativeVideoTsView != null) {
            com.bytedance.sdk.openadsdk.core.video.e.d dVarT = nativeVideoTsView.getNativeVideoController().t();
            if (dVarT != null && dVarT.h()) {
                this.R = true;
                ((f) this.n.getNativeVideoController()).e(this.n.getNativeVideoController().o());
                this.n.getNativeVideoController().a(false);
            } else {
                if (dVarT == null || dVarT.l()) {
                    return;
                }
                ((f) this.n.getNativeVideoController()).e(this.n.getNativeVideoController().o());
                this.n.getNativeVideoController().a(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n() {
        return !TextUtils.isEmpty(this.J) && this.J.contains("__luban_sdk");
    }

    private void o() {
        if (this.p == null) {
            return;
        }
        JSONArray jSONArrayB = b(this.J);
        int iD = ab.d(this.h);
        int iC = ab.c(this.h);
        p<com.bytedance.sdk.openadsdk.c.a> pVarF = o.f();
        if (jSONArrayB == null || pVarF == null || iD <= 0 || iC <= 0) {
            return;
        }
        i iVar = new i();
        iVar.f6118d = jSONArrayB;
        AdSlot adSlotK = this.p.k();
        if (adSlotK == null) {
            return;
        }
        adSlotK.setAdCount(6);
        pVarF.a(adSlotK, iVar, iC, new p.a() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.9
            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(int i, String str) {
                TTVideoLandingPageActivity.this.a(0);
            }

            @Override // com.bytedance.sdk.openadsdk.core.p.a
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar != null) {
                    try {
                        TTVideoLandingPageActivity.this.N.set(false);
                        TTVideoLandingPageActivity.this.i.b(new JSONObject(aVar.d()));
                    } catch (Exception unused) {
                        TTVideoLandingPageActivity.this.a(0);
                    }
                }
            }
        });
    }

    private void c() {
        h hVar = this.p;
        if (hVar == null || hVar.x() != 4) {
            return;
        }
        this.A.setVisibility(0);
        this.B = (Button) findViewById(t.e(this, "tt_browser_download_btn"));
        if (this.B != null) {
            a(d());
            this.B.setOnClickListener(this.P);
            this.B.setOnTouchListener(this.P);
        }
    }

    private String d() {
        h hVar = this.p;
        if (hVar != null && !TextUtils.isEmpty(hVar.I())) {
            this.u = this.p.I();
        }
        return this.u;
    }

    private void e() {
        this.C = (ProgressBar) findViewById(t.e(this, "tt_browser_progress"));
        this.A = (ViewStub) findViewById(t.e(this, "tt_browser_download_btn_stub"));
        this.f5703a = (SSWebView) findViewById(t.e(this, "tt_browser_webview"));
        this.f5704b = (ImageView) findViewById(t.e(this, "tt_titlebar_back"));
        ImageView imageView = this.f5704b;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TTVideoLandingPageActivity.this.f5703a != null) {
                        if (TTVideoLandingPageActivity.this.f5703a.canGoBack()) {
                            TTVideoLandingPageActivity.this.f5703a.goBack();
                            return;
                        }
                        if (TTVideoLandingPageActivity.this.n()) {
                            TTVideoLandingPageActivity.this.onBackPressed();
                            return;
                        }
                        Map<String, Object> mapA = null;
                        if (TTVideoLandingPageActivity.this.n != null && TTVideoLandingPageActivity.this.n.getNativeVideoController() != null) {
                            mapA = ab.a(TTVideoLandingPageActivity.this.p, TTVideoLandingPageActivity.this.n.getNativeVideoController().n(), TTVideoLandingPageActivity.this.n.getNativeVideoController().t());
                        }
                        TTVideoLandingPageActivity tTVideoLandingPageActivity = TTVideoLandingPageActivity.this;
                        com.bytedance.sdk.openadsdk.c.d.a(tTVideoLandingPageActivity, tTVideoLandingPageActivity.p, "embeded_ad", "detail_back", TTVideoLandingPageActivity.this.g(), TTVideoLandingPageActivity.this.h(), mapA);
                        TTVideoLandingPageActivity.this.finish();
                    }
                }
            });
        }
        this.f5705c = (ImageView) findViewById(t.e(this, "tt_titlebar_close"));
        ImageView imageView2 = this.f5705c;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TTVideoLandingPageActivity.this.n != null) {
                        Map<String, Object> mapA = TTVideoLandingPageActivity.this.n.getNativeVideoController() != null ? ab.a(TTVideoLandingPageActivity.this.p, TTVideoLandingPageActivity.this.n.getNativeVideoController().n(), TTVideoLandingPageActivity.this.n.getNativeVideoController().t()) : null;
                        TTVideoLandingPageActivity tTVideoLandingPageActivity = TTVideoLandingPageActivity.this;
                        com.bytedance.sdk.openadsdk.c.d.a(tTVideoLandingPageActivity, tTVideoLandingPageActivity.p, "embeded_ad", "detail_skip", TTVideoLandingPageActivity.this.g(), TTVideoLandingPageActivity.this.h(), mapA);
                    }
                    TTVideoLandingPageActivity.this.finish();
                }
            });
        }
        this.f5706d = (TextView) findViewById(t.e(this, "tt_titlebar_title"));
        this.l = (FrameLayout) findViewById(t.e(this, "tt_native_video_container"));
        this.k = (RelativeLayout) findViewById(t.e(this, "tt_native_video_titlebar"));
        this.v = (RelativeLayout) findViewById(t.e(this, "tt_rl_download"));
        this.w = (TextView) findViewById(t.e(this, "tt_video_btn_ad_image_tv"));
        this.y = (TextView) findViewById(t.e(this, "tt_video_ad_name"));
        this.z = (TextView) findViewById(t.e(this, "tt_video_ad_button"));
        this.x = (RoundImageView) findViewById(t.e(this, "tt_video_ad_logo_image"));
        i();
    }

    private void f() {
        if (this.m == 5) {
            try {
                this.n = new NativeVideoTsView(this.f5707e, this.p, true);
                if (this.n.getNativeVideoController() != null) {
                    this.n.getNativeVideoController().b(false);
                }
                if (this.G) {
                    this.l.setVisibility(0);
                    this.l.removeAllViews();
                    this.l.addView(this.n);
                    this.n.b(true);
                } else {
                    if (!this.I) {
                        this.o = 0L;
                    }
                    if (this.L != null && this.n.getNativeVideoController() != null) {
                        this.n.getNativeVideoController().b(this.L.g);
                        this.n.getNativeVideoController().c(this.L.f7062e);
                    }
                    if (this.n.a(this.o, this.H, this.G)) {
                        this.l.setVisibility(0);
                        this.l.removeAllViews();
                        this.l.addView(this.n);
                    }
                    if (this.n.getNativeVideoController() != null) {
                        this.n.getNativeVideoController().b(false);
                        this.n.getNativeVideoController().a(this.Q);
                        this.n.setIsQuiet(false);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (q.c(this) == 0) {
                Toast.makeText(this, t.b(this, "tt_no_network"), 0).show();
            }
        }
    }

    protected void b() {
        try {
            this.f5707e.unregisterReceiver(this.S);
        } catch (Exception unused) {
        }
    }

    private void a(final String str) {
        Button button;
        if (TextUtils.isEmpty(str) || (button = this.B) == null) {
            return;
        }
        button.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.activity.TTVideoLandingPageActivity.4
            @Override // java.lang.Runnable
            public void run() {
                if (TTVideoLandingPageActivity.this.B == null || TTVideoLandingPageActivity.this.isFinishing()) {
                    return;
                }
                TTVideoLandingPageActivity.this.B.setText(str);
            }
        });
    }

    private JSONArray b(String str) {
        int i;
        JSONArray jSONArray = this.O;
        if (jSONArray != null && jSONArray.length() > 0) {
            return this.O;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int iIndexOf = str.indexOf("?id=");
        int iIndexOf2 = str.indexOf("&");
        if (iIndexOf == -1 || iIndexOf2 == -1 || (i = iIndexOf + 4) >= iIndexOf2) {
            return null;
        }
        String strSubstring = str.substring(i, iIndexOf2);
        if (TextUtils.isEmpty(strSubstring)) {
            return null;
        }
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.put(strSubstring);
        return jSONArray2;
    }

    private void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar) {
        com.bytedance.sdk.openadsdk.utils.o.e("mutilproces", "initFeedNaitiveControllerData-isComplete=" + cVar.v() + ",position=" + cVar.m() + ",totalPlayDuration=" + cVar.o() + ",duration=" + cVar.r());
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", (Boolean) true);
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", (Boolean) true);
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_native_video_complete", Boolean.valueOf(cVar.v()));
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_current_play_position", Long.valueOf(cVar.m()));
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_total_play_duration", Long.valueOf(cVar.o()));
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_duration", Long.valueOf(cVar.r()));
    }

    protected void a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            this.f5707e.registerReceiver(this.S, intentFilter);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (this.f5705c == null || !n()) {
            return;
        }
        ac.a((View) this.f5705c, i);
    }

    private void a(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isBackIntercept", z);
            this.i.a("temai_back_event", jSONObject);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.d.d
    public void a(boolean z, JSONArray jSONArray) {
        if (!z || jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        this.O = jSONArray;
        o();
    }
}
