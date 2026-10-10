package com.alibaba.sdk.android.feedback.xblink.f;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.sdk.android.feedback.xblink.webview.XBHybridWebView;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private XBHybridWebView f3833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f3834b;

    public b(XBHybridWebView xBHybridWebView, String str) {
        this.f3833a = xBHybridWebView;
        this.f3834b = str;
    }

    private void c(String str) {
        if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
            com.alibaba.sdk.android.feedback.xblink.i.g.a("WVCallBackContext", "callback: " + str);
        }
        XBHybridWebView xBHybridWebView = this.f3833a;
        if (xBHybridWebView == null) {
            return;
        }
        try {
            xBHybridWebView.loadUrl(str);
        } catch (Exception e2) {
            com.alibaba.sdk.android.feedback.xblink.i.g.b("WVCallBackContext", "callback error. " + e2.getMessage());
        }
    }

    public XBHybridWebView a() {
        return this.f3833a;
    }

    public void a(m mVar) {
        if (mVar != null) {
            mVar.a();
            a(mVar.b());
        }
    }

    public void a(String str) {
        if (com.alibaba.sdk.android.feedback.a.f3672a >= 19 && Build.VERSION.SDK_INT >= 19) {
            try {
                str = Uri.encode(str);
            } catch (Exception unused) {
            }
        }
        String str2 = TextUtils.isEmpty(str) ? String.format("javascript:window.WindVane.onSuccess(%s,'');", this.f3834b) : String.format("javascript:window.WindVane.onSuccess(%s,'%s');", this.f3834b, str);
        com.alibaba.sdk.android.feedback.xblink.i.g.a("WVCallBackContext", "call success ");
        c(str2);
    }

    public void a(String str, String str2) {
        String str3 = TextUtils.isEmpty(str2) ? String.format("javascript:window.WindVane.fireEvent('%s', '');", str) : String.format("javascript:window.WindVane.fireEvent('%s','%s');", str, str2);
        com.alibaba.sdk.android.feedback.xblink.i.g.a("WVCallBackContext", "call fireEvent ");
        c(str3);
    }

    public String b() {
        return this.f3834b;
    }

    public void b(m mVar) {
        if (mVar != null) {
            b(mVar.b());
        }
    }

    public void b(String str) {
        String str2 = TextUtils.isEmpty(str) ? String.format("javascript:window.WindVane.onFailure(%s,'');", this.f3834b) : String.format("javascript:window.WindVane.onFailure(%s,'%s');", this.f3834b, str);
        com.alibaba.sdk.android.feedback.xblink.i.g.a("WVCallBackContext", "call error ");
        c(str2);
    }
}
