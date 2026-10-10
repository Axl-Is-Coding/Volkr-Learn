package com.alibaba.sdk.android.feedback.windvane;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.sdk.android.feedback.R;
import com.alibaba.sdk.android.feedback.xblink.activity.XBBaseHybridActivity;
import com.alibaba.sdk.android.feedback.xblink.webview.XBHybridWebView;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"Registered"})
public class WXBaseHybridActivity extends XBBaseHybridActivity implements com.alibaba.sdk.android.feedback.xblink.webview.i {
    public static final String EXTERNAL = "external";
    public static final String FROM = "from";
    public static final String FROM_TAOBAO_ITEM = "fromTaobaoItem";
    public static final String HIDE_TITLE = "hideTitle";
    public static final String NEED_LOGIN = "needLogin";
    public static final String NEED_SHOW_BACK = "need_show_back";
    public static final String NEED_SHOW_NAV = "need_show_nav";
    public static final int REMAI_REQESTCODE = 3;
    private static final String TAG = "WXBaseHybridActivity";
    private boolean isDestroyed;
    private TextView mBackView;
    protected k mPageAction;
    protected j mWXPage;
    protected boolean needLogin;
    protected boolean needShowNav;
    private ProgressBar progressbar;
    protected CustomHybirdWebViewClient webViewClient;
    protected XBHybridWebView webview;
    private boolean isAutoLogin = false;
    private Handler mHandler = new Handler();
    private String JS_API_NAME = "WXPageAction";

    private void controlWebview() {
        this.needLogin = getIntent().getBooleanExtra(NEED_LOGIN, false);
        this.needShowNav = getIntent().getBooleanExtra(NEED_SHOW_NAV, true);
    }

    public static String getSubUserAgent() {
        return "AliApp(WX/1)";
    }

    private void registerJSObject() {
        this.webview.addJsObject(this.JS_API_NAME, this.mPageAction);
        this.webview.addJsObject("WXPage", this.mWXPage);
    }

    private void setErrorView() {
        View viewInflate = View.inflate(this, R.layout.ali_feedback_error, null);
        this.mViewController.setErrorView(viewInflate);
        ((Button) viewInflate.findViewById(R.id.error_view_refresh_btn)).setOnClickListener(new i(this));
    }

    private void setWebview() {
        this.webview = this.mViewController.getWebview();
        if (Build.VERSION.SDK_INT < 18) {
            this.webview.getSettings().setSavePassword(false);
        }
        this.webViewClient = new CustomHybirdWebViewClient(this);
        this.webview.setWebViewClient(this.webViewClient);
        this.progressbar = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
        this.progressbar.setMax(100);
        try {
            com.alibaba.sdk.android.feedback.xblink.i.g.a(TAG, "setProgressDrawable ");
            int color = Color.parseColor(com.alibaba.sdk.android.feedback.a.a.g());
            com.alibaba.sdk.android.feedback.xblink.i.g.a(TAG, "setProgressDrawable " + color);
            this.progressbar.setProgressDrawable(new ColorDrawable(color));
        } catch (Exception unused) {
            this.progressbar.setProgressDrawable(getResources().getDrawable(R.drawable.ali_feedback_progress_bar_states));
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, 6);
        layoutParams.addRule(10, -1);
        this.webview.setWebChromeClient(new CustomWebChromeClient(this.progressbar));
        this.webview.getWvUIModel().a(this.progressbar, layoutParams);
        String userAgentString = this.mViewController.getWebview().getSettings().getUserAgentString();
        this.mViewController.getWebview().getSettings().setUserAgentString(userAgentString + " " + getSubUserAgent());
        this.webViewClient.setmUrl(this.mUrl);
        this.webViewClient.setWebViewErrorListener(this);
        this.webview.setOnTouchListener(new h(this));
    }

    protected void loadUrl() {
        this.mViewController.loadUrl(this.url, this.postData);
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.activity.XBBaseHybridActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        Object jsObject;
        com.alibaba.sdk.android.feedback.xblink.i.g.a(TAG, "onActivityResult " + i + " : " + i2);
        if (i2 == -1 && i == 3) {
            this.webview.reload();
        }
        if (i == k.f3749a && (jsObject = this.webview.getJsObject(this.JS_API_NAME)) != null && (jsObject instanceof k)) {
            ((k) jsObject).a(i, i2, intent);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.activity.XBBaseHybridActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mUrl = getIntent().getStringExtra("URL");
        this.webview = this.mViewController.getWebview();
        this.isDestroyed = false;
        this.mPageAction = new k(this, getWindow().getDecorView());
        this.mWXPage = new j(this, getWindow().getDecorView());
        setErrorView();
        registerJSObject();
        setWebview();
        controlWebview();
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.activity.XBBaseHybridActivity, android.app.Activity
    protected void onDestroy() {
        this.isDestroyed = true;
        CustomHybirdWebViewClient customHybirdWebViewClient = this.webViewClient;
        if (customHybirdWebViewClient != null) {
            customHybirdWebViewClient.setDestroyed(true);
        }
        this.mViewController.removeAllViews();
        super.onDestroy();
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.webview.i
    public void onReceivedError() {
        if (this.mBackView == null) {
            this.mBackView = (TextView) findViewById(R.id.webview_icon_back);
        }
        TextView textView = this.mBackView;
        if (textView != null) {
            textView.setTextColor(getResources().getColor(R.color.ali_feedback_black));
            this.mBackView.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.ali_feedback_common_back_btn_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (this.webview.getWvUIModel() != null) {
            this.webview.getWvUIModel().d();
        }
    }
}
