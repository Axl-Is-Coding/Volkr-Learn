package com.alibaba.sdk.android.feedback.xblink.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.sdk.android.feedback.xblink.i.g;
import com.alibaba.sdk.android.feedback.xblink.i.h;
import com.alibaba.sdk.android.feedback.xblink.webview.XBHybridViewController;
import com.alibaba.sdk.android.feedback.xblink.webview.XBHybridWebView;
import com.alibaba.sdk.android.feedback.xblink.webview.j;

/* JADX INFO: loaded from: classes.dex */
public abstract class XBBaseHybridActivity extends Activity implements Handler.Callback {
    private String appkey;
    protected Handler mHandler;
    BroadcastReceiver mHomeKeyEventReceiver;
    protected String mUrl;
    protected XBHybridViewController mViewController;
    protected XBHybridWebView mWebView;
    protected String url = null;
    protected byte[] postData = null;
    private boolean jsControlled = false;
    private String jsCallbackPath = "";
    private String TAG = "XBBaseHybridActivity";
    private BroadcastReceiver h5PushReceiver = new a(this);

    private void registHomeKeyEventBroadCast() {
        if (this.mHomeKeyEventReceiver == null) {
            this.mHomeKeyEventReceiver = new b(this);
        }
        androidx.localbroadcastmanager.a.b.a(this).a(this.mHomeKeyEventReceiver, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
    }

    private void unregistHomeKeyEventBroadCast() {
        if (this.mHomeKeyEventReceiver != null) {
            androidx.localbroadcastmanager.a.b.a(this).a(this.mHomeKeyEventReceiver);
            this.mHomeKeyEventReceiver = null;
        }
    }

    protected com.alibaba.sdk.android.feedback.xblink.e.a createFilter() {
        return null;
    }

    protected String getAppkey() {
        return null;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        XBHybridWebView xBHybridWebView = this.mWebView;
        if (xBHybridWebView != null) {
            xBHybridWebView.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        g.a(this.TAG, "custom backPressed");
        if (!this.jsControlled) {
            super.onBackPressed();
            return;
        }
        this.mWebView.loadUrl("javascript:" + this.jsCallbackPath);
    }

    public void onBroadcast(XBHybridWebView xBHybridWebView, String str) {
        String str2 = String.format("javascript:window.WindVane.fireEvent('%s', '%s');", "WXCommunication.onBroadcast", str);
        if (xBHybridWebView != null) {
            try {
                xBHybridWebView.loadUrl(str2);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        j jVar = (j) intent.getParcelableExtra("PARAMS");
        this.url = intent.getStringExtra("URL");
        this.mUrl = this.url;
        this.postData = intent.getByteArrayExtra("DATA");
        this.appkey = getAppkey();
        if (TextUtils.isEmpty(this.appkey)) {
            this.appkey = getIntent().getStringExtra("APPKEY");
        }
        if (TextUtils.isEmpty(this.appkey)) {
            this.appkey = com.alibaba.sdk.android.feedback.xblink.i.b.a(h.b(this.url));
        }
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        this.mViewController = new XBHybridViewController(this);
        this.mViewController.init(jVar);
        this.mViewController.setUrlFilter(createFilter());
        this.mWebView = this.mViewController.getWebview();
        this.mWebView.setAppkey(this.appkey);
        this.mWebView.setCurrentUrl(this.url);
        registHomeKeyEventBroadCast();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        this.mViewController.destroy();
        this.mViewController = null;
        unregistHomeKeyEventBroadCast();
        super.onDestroy();
    }

    @Override // android.app.Activity
    @SuppressLint({"NewApi"})
    protected void onPause() {
        XBHybridWebView xBHybridWebView = this.mWebView;
        if (xBHybridWebView != null) {
            xBHybridWebView.onPause();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    @SuppressLint({"NewApi"})
    protected void onResume() {
        XBHybridWebView xBHybridWebView = this.mWebView;
        if (xBHybridWebView != null) {
            xBHybridWebView.onResume();
        }
        super.onResume();
    }

    public void setJSControlledBackPress(boolean z, String str) {
        this.jsControlled = z;
        this.jsCallbackPath = str;
    }
}
