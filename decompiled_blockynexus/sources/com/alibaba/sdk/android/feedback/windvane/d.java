package com.alibaba.sdk.android.feedback.windvane;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.alibaba.sdk.android.feedback.R;
import com.alibaba.sdk.android.feedback.xblink.webview.XBHybridViewController;
import com.alibaba.sdk.android.feedback.xblink.webview.XBHybridWebView;

/* JADX INFO: loaded from: classes.dex */
public class d extends Fragment implements com.alibaba.sdk.android.feedback.xblink.webview.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Handler f3735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected XBHybridViewController f3736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected XBHybridWebView f3737c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected String f3739e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected boolean f3740f;
    protected boolean g;
    protected CustomHybirdWebViewClient h;
    protected k i;
    protected j j;
    private View k;
    private String l;
    private boolean n;
    private ProgressBar p;
    private TextView q;
    private Bundle r;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected byte[] f3738d = null;
    private boolean m = false;
    private String o = "WXPageAction";

    private void a(LayoutInflater layoutInflater) {
        View viewInflate = layoutInflater.inflate(R.layout.ali_feedback_error, (ViewGroup) null);
        this.f3736b.setErrorView(viewInflate);
        ((Button) viewInflate.findViewById(R.id.error_view_refresh_btn)).setOnClickListener(new e(this));
    }

    private void b() {
        this.f3740f = this.r.getBoolean(WXBaseHybridActivity.NEED_LOGIN, false);
        this.g = this.r.getBoolean(WXBaseHybridActivity.NEED_SHOW_NAV, true);
    }

    private void c() {
        if (Build.VERSION.SDK_INT < 18) {
            this.f3737c.getSettings().setSavePassword(false);
        }
        this.h = new CustomHybirdWebViewClient(getActivity());
        this.f3737c.setWebViewClient(this.h);
        this.p = new ProgressBar(getActivity(), null, android.R.attr.progressBarStyleHorizontal);
        this.p.setMax(100);
        this.p.setProgressDrawable(getResources().getDrawable(R.drawable.ali_feedback_progress_bar_states));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, 6);
        layoutParams.addRule(10, -1);
        this.f3737c.getWvUIModel().a(this.p, layoutParams);
        String userAgentString = this.f3736b.getWebview().getSettings().getUserAgentString();
        this.f3736b.getWebview().getSettings().setUserAgentString(userAgentString + " ");
        this.h.setmUrl(this.f3739e);
        this.h.setWebViewErrorListener(this);
    }

    private void d() {
        this.f3737c.addJsObject(this.o, this.i);
        this.f3737c.addJsObject("WXPage", this.j);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e() {
        /*
            r3 = this;
            android.view.View r0 = r3.k
            int r1 = com.alibaba.sdk.android.feedback.R.id.title_back
            android.view.View r0 = r0.findViewById(r1)
            com.alibaba.sdk.android.feedback.windvane.g r1 = new com.alibaba.sdk.android.feedback.windvane.g
            r1.<init>(r3)
            r0.setOnClickListener(r1)
            android.view.View r0 = r3.k
            int r1 = com.alibaba.sdk.android.feedback.R.id.title_button
            android.view.View r0 = r0.findViewById(r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            int r1 = com.alibaba.sdk.android.feedback.a.a.f()
            if (r1 <= 0) goto L29
            int r1 = com.alibaba.sdk.android.feedback.a.a.f()
            float r1 = (float) r1
        L25:
            r0.setTextSize(r1)
            goto L37
        L29:
            float r1 = com.alibaba.sdk.android.feedback.a.b.b()
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 <= 0) goto L37
            float r1 = com.alibaba.sdk.android.feedback.a.b.b()
            goto L25
        L37:
            int r0 = com.alibaba.sdk.android.feedback.a.b.o()
            if (r0 <= 0) goto L5a
            android.view.View r0 = r3.k     // Catch: java.lang.Exception -> L53
            int r1 = com.alibaba.sdk.android.feedback.R.id.title     // Catch: java.lang.Exception -> L53
            android.view.View r0 = r0.findViewById(r1)     // Catch: java.lang.Exception -> L53
            android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()     // Catch: java.lang.Exception -> L53
            int r2 = com.alibaba.sdk.android.feedback.a.b.o()     // Catch: java.lang.Exception -> L53
            r1.height = r2     // Catch: java.lang.Exception -> L53
            r0.setLayoutParams(r1)     // Catch: java.lang.Exception -> L53
            goto L5a
        L53:
            java.lang.String r0 = "fragment"
            java.lang.String r1 = "can not find title"
            com.alibaba.sdk.android.feedback.xblink.i.g.b(r0, r1)
        L5a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.windvane.d.e():void");
    }

    protected void a() {
        this.f3736b.loadUrl(this.f3739e, this.f3738d);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        XBHybridWebView xBHybridWebView = this.f3737c;
        if (xBHybridWebView != null) {
            xBHybridWebView.onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        com.alibaba.sdk.android.feedback.xblink.webview.j jVar;
        this.r = getArguments();
        Bundle bundle2 = this.r;
        if (bundle2 != null) {
            jVar = (com.alibaba.sdk.android.feedback.xblink.webview.j) bundle2.getParcelable("PARAMS");
            this.f3738d = this.r.getByteArray("DATA");
            this.l = this.r.getString("APPKEY");
            this.f3739e = this.r.getString("URL");
        } else {
            jVar = null;
        }
        this.f3735a = new Handler(Looper.getMainLooper());
        this.f3736b = new XBHybridViewController(getActivity());
        this.f3736b.init(jVar);
        this.f3736b.setUrlFilter(null);
        this.f3736b.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.f3737c = this.f3736b.getWebview();
        this.f3737c.setAppkey(this.l);
        this.f3737c.setCurrentUrl(this.f3739e);
        this.n = false;
        this.i = new k(getActivity(), getActivity().getWindow().getDecorView());
        this.j = new j(getActivity(), getActivity().getWindow().getDecorView());
        d();
        c();
        b();
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.k = layoutInflater.inflate(R.layout.ali_feedback_container_layout, viewGroup, false);
        ((ViewGroup) this.k.findViewById(R.id.hybird_container)).addView(this.f3736b);
        e();
        a(layoutInflater);
        a();
        return this.k;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.f3736b.destroy();
        this.f3736b = null;
        super.onDestroy();
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.webview.i
    public void onReceivedError() {
        if (this.q == null) {
            this.q = (TextView) this.k.findViewById(R.id.webview_icon_back);
        }
        TextView textView = this.q;
        if (textView != null) {
            textView.setTextColor(getResources().getColor(R.color.ali_feedback_black));
            this.q.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.ali_feedback_common_back_btn_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.f3737c.getWvUIModel() != null) {
            this.f3737c.getWvUIModel().d();
        }
    }
}
