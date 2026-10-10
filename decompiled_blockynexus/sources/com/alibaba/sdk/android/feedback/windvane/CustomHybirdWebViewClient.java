package com.alibaba.sdk.android.feedback.windvane;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.TextView;
import com.alibaba.sdk.android.feedback.util.p;
import com.alibaba.sdk.android.feedback.xblink.webview.HybridWebViewClient;

/* JADX INFO: loaded from: classes.dex */
public class CustomHybirdWebViewClient extends HybridWebViewClient {
    private static final String TAG = "CustomHybirdWebViewClient";
    private static final String[] sDomainWhiteList = {"chat.etao.com", "amos.alicdn.com", "mobileim.etao.com", "chat.im.daily.taobao.net", "interface.im.daily.taobao.net", "tcms-openim.wangxin.taobao.com", "m.taobao.com", "taobao.com"};
    private boolean isDestroyed;
    private String mUrl;
    private c pageFinishCallback;
    private int reLoginTime;
    private TextView title;

    public CustomHybirdWebViewClient(Context context) {
        super(context);
        this.reLoginTime = 0;
    }

    private void loadSuccess(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    public void PageFinishCallback(c cVar) {
        this.pageFinishCallback = cVar;
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.webview.HybridWebViewClient, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        TextView textView;
        String title;
        c cVar = this.pageFinishCallback;
        if (cVar != null) {
            cVar.a();
        }
        TextView textView2 = this.title;
        if (textView2 != null && TextUtils.isEmpty(textView2.getText())) {
            if (TextUtils.isEmpty(com.alibaba.sdk.android.feedback.a.a.d())) {
                textView = this.title;
                title = webView.getTitle();
            } else {
                com.alibaba.sdk.android.feedback.xblink.i.g.a(TAG, "FeedbackAPI replacing original title with the custom one");
                textView = this.title;
                title = com.alibaba.sdk.android.feedback.a.a.d();
            }
            textView.setText(title);
        }
        loadSuccess(webView, str);
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.webview.HybridWebViewClient, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    public void setDestroyed(boolean z) {
        this.isDestroyed = z;
    }

    public void setPageFinishCallback(c cVar) {
        this.pageFinishCallback = cVar;
    }

    public void setTitle(TextView textView) {
        this.title = textView;
    }

    public void setmUrl(String str) {
        this.mUrl = str;
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.webview.HybridWebViewClient, android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
            com.alibaba.sdk.android.feedback.xblink.i.g.d(TAG, "shouldOverrideUrlLoading: " + str);
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                com.alibaba.sdk.android.feedback.xblink.i.g.a(TAG, "FeedbackAPI " + str + " testing Url");
                if (p.a(str)) {
                    return false;
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.setFlags(268435456);
                if (this.mContext != null) {
                    this.mContext.startActivity(intent);
                }
                return true;
            } catch (Exception unused) {
                com.alibaba.sdk.android.feedback.xblink.i.g.b(TAG, "shouldOverrideUrlLoading: uri parse error, url=" + str);
            }
        }
        return true;
    }
}
