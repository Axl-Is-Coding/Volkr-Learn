package com.bytedance.sdk.openadsdk.core.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.R;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.t;

/* JADX INFO: compiled from: PrivacyProtectDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f6590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f6591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f6592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f6593d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private InterfaceC0086b f6594e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private RelativeLayout f6595f;

    /* JADX INFO: compiled from: PrivacyProtectDialog.java */
    private class a implements View.OnClickListener {
        private a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.tt_privacy_accept_btn) {
                if (b.this.f6593d != null) {
                    b.this.f6593d.a();
                }
                b.this.dismiss();
            } else if (id == R.id.tt_privacy_reject_btn) {
                if (b.this.f6594e != null) {
                    b.this.f6594e.a();
                }
                b.this.dismiss();
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.widget.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PrivacyProtectDialog.java */
    public interface InterfaceC0086b {
        void a();
    }

    /* JADX INFO: compiled from: PrivacyProtectDialog.java */
    public interface c {
        void a();
    }

    public b(Context context) {
        super(context, t.g(context, "tt_privacy_dialogTheme"));
        this.f6590a = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
        b();
    }

    private void b() {
        WindowManager.LayoutParams attributes;
        setCancelable(false);
        Window window = getWindow();
        if (window == null || (attributes = window.getAttributes()) == null) {
            return;
        }
        attributes.dimAmount = 0.5f;
        double d2 = this.f6590a.getResources().getDisplayMetrics().widthPixels;
        Double.isNaN(d2);
        attributes.width = (int) (d2 * 0.8d);
        window.setAttributes(attributes);
    }

    public b a(String str, c cVar) {
        this.f6591b = str;
        this.f6593d = cVar;
        return this;
    }

    public b a(String str, InterfaceC0086b interfaceC0086b) {
        this.f6592c = str;
        this.f6594e = interfaceC0086b;
        return this;
    }

    private void a() {
        View viewInflate = LayoutInflater.from(this.f6590a).inflate(t.f(this.f6590a, "tt_privacy_dialog"), (ViewGroup) null);
        setContentView(viewInflate);
        final TTCornersWebView tTCornersWebView = (TTCornersWebView) viewInflate.findViewById(t.e(this.f6590a, "tt_privacy_webview"));
        Button button = (Button) viewInflate.findViewById(t.e(this.f6590a, "tt_privacy_accept_btn"));
        TextView textView = (TextView) viewInflate.findViewById(t.e(this.f6590a, "tt_privacy_reject_btn"));
        this.f6595f = (RelativeLayout) viewInflate.findViewById(t.e(this.f6590a, "tt_privacy_back_layout"));
        ac.a((View) this.f6595f, 8);
        textView.getPaint().setFlags(8);
        a(tTCornersWebView);
        if (!TextUtils.isEmpty(this.f6591b) && !TextUtils.isEmpty(this.f6592c)) {
            button.setText(this.f6591b);
            textView.setText(this.f6592c);
        }
        button.setOnClickListener(new a());
        textView.setOnClickListener(new a());
        this.f6595f.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TTCornersWebView tTCornersWebView2 = tTCornersWebView;
                if (tTCornersWebView2 == null || !tTCornersWebView2.canGoBack()) {
                    return;
                }
                tTCornersWebView.goBack();
                if (tTCornersWebView.canGoBack()) {
                    return;
                }
                ac.a((View) b.this.f6595f, 8);
            }
        });
    }

    private void a(final TTCornersWebView tTCornersWebView) {
        String strR = o.h().r();
        if (strR != null) {
            try {
                tTCornersWebView.getSettings().setJavaScriptEnabled(true);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            tTCornersWebView.loadUrl(strR);
            if (Build.VERSION.SDK_INT >= 21) {
                tTCornersWebView.getSettings().setMixedContentMode(0);
            }
            tTCornersWebView.setWebViewClient(new WebViewClient() { // from class: com.bytedance.sdk.openadsdk.core.widget.b.2
                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str) {
                    super.onPageFinished(webView, str);
                    TTCornersWebView tTCornersWebView2 = tTCornersWebView;
                    if (tTCornersWebView2 == null || !tTCornersWebView2.canGoBack()) {
                        return;
                    }
                    ac.a((View) b.this.f6595f, 0);
                }

                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                    if (webView == null || webResourceRequest == null) {
                        return false;
                    }
                    if (Build.VERSION.SDK_INT >= 21) {
                        webView.loadUrl(webResourceRequest.getUrl().toString());
                        return true;
                    }
                    webView.loadUrl(webResourceRequest.toString());
                    return true;
                }
            });
        }
    }
}
