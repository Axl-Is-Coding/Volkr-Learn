package com.alibaba.sdk.android.feedback.xblink.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes.dex */
public class XBHybridViewController extends LinearLayout {
    protected boolean isInited;
    protected Context mContext;
    protected XBHybridWebView mWebView;

    public XBHybridViewController(Context context) {
        super(context);
        this.isInited = false;
        this.mContext = context;
    }

    public XBHybridViewController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isInited = false;
        this.mContext = context;
    }

    public XBHybridViewController(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isInited = false;
        this.mContext = context;
    }

    private void initView(j jVar) {
        setOrientation(1);
        if (jVar == null) {
            jVar = new j();
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        this.mWebView = new XBHybridWebView(this.mContext);
        relativeLayout.addView(this.mWebView, new RelativeLayout.LayoutParams(-1, -1));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        relativeLayout.setLayoutParams(layoutParams);
        addView(relativeLayout);
        initWithParams(jVar);
        this.isInited = true;
    }

    public void destroy() {
        if (this.isInited) {
            removeAllViews();
            this.mWebView.destroy();
            this.mWebView = null;
        }
        this.mContext = null;
    }

    public XBHybridWebView getWebview() {
        if (!this.isInited) {
            initView(null);
        }
        return this.mWebView;
    }

    public void init(j jVar) {
        if (this.isInited) {
            return;
        }
        initView(jVar);
    }

    protected void initWithParams(j jVar) {
        if (jVar.a()) {
            this.mWebView.getWvUIModel().a();
        }
        if (jVar.b()) {
            return;
        }
        com.alibaba.sdk.android.feedback.xblink.f.d.a().a(false);
    }

    public void loadUrl(String str) {
        if (!this.isInited) {
            initView(null);
        }
        this.mWebView.loadUrl(str);
    }

    public void loadUrl(String str, byte[] bArr) {
        if (!this.isInited) {
            initView(null);
        }
        if (bArr == null || bArr.length == 0) {
            this.mWebView.loadUrl(str);
        } else {
            this.mWebView.postUrl(str, bArr);
        }
    }

    public void setErrorView(View view) {
        if (!this.isInited) {
            initView(null);
        }
        this.mWebView.getWvUIModel().b(view);
    }

    public void setUrlFilter(com.alibaba.sdk.android.feedback.xblink.e.a aVar) {
        if (!this.isInited) {
            initView(null);
        }
        this.mWebView.setUrlFilter(aVar);
        com.alibaba.sdk.android.feedback.xblink.f.k.a("WVWebUrl", com.alibaba.sdk.android.feedback.xblink.f.a.c.class);
    }
}
