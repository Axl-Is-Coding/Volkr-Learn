package com.ironsource.sdk.ISNAdView;

import android.app.Activity;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ISNAdView extends FrameLayout {
    private String TAG;
    private Activity mActivity;
    private b.f.d.a mAdViewSize;
    private String mContainerIdentifier;
    private h mIsnAdViewLogic;
    private WebView mWebView;

    public ISNAdView(Activity activity, String str, b.f.d.a aVar) {
        super(activity);
        this.TAG = ISNAdView.class.getSimpleName();
        this.mActivity = activity;
        this.mAdViewSize = aVar;
        this.mContainerIdentifier = str;
        this.mIsnAdViewLogic = new h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createWebView(String str, String str2) throws JSONException {
        this.mWebView = new WebView(this.mActivity);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.addJavascriptInterface(new j(this), "containerMsgHandler");
        this.mWebView.setWebViewClient(new i(new c(this, str2)));
        this.mWebView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.mIsnAdViewLogic.a(this.mWebView);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("adViewId", this.mIsnAdViewLogic.b());
        this.mIsnAdViewLogic.a(str, jSONObject);
    }

    public b.f.d.a getAdViewSize() {
        return this.mAdViewSize;
    }

    public void load(JSONObject jSONObject) throws Exception {
        try {
            try {
                b.f.d.d.b(this.mIsnAdViewLogic.a(jSONObject, this.mContainerIdentifier));
            } catch (Exception unused) {
                throw new Exception("ISNAdView | Failed to instantiate IronSourceAdsPublisherAgent");
            }
        } catch (Exception unused2) {
            throw new Exception("ISNAdView | loadAd | Failed to build load parameters");
        }
    }

    public void loadAd(JSONObject jSONObject) throws Exception {
        try {
            try {
                b.f.d.h.a(this.mActivity).a(this.mIsnAdViewLogic.a(jSONObject, this.mContainerIdentifier));
            } catch (Exception unused) {
                throw new Exception("ISNAdView | Failed to instantiate IronSourceAdsPublisherAgent");
            }
        } catch (Exception unused2) {
            throw new Exception("ISNAdView | loadAd | Failed to build load parameters");
        }
    }

    public void loadUrlIntoWebView(String str, String str2, String str3) {
        this.mActivity.runOnUiThread(new b(this, str2, str3, str));
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        h hVar = this.mIsnAdViewLogic;
        if (hVar != null) {
            hVar.a("isVisible", i, isShown());
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        h hVar = this.mIsnAdViewLogic;
        if (hVar != null) {
            hVar.a("isWindowVisible", i, isShown());
        }
    }

    public void performCleanup() {
        this.mActivity.runOnUiThread(new a(this));
    }

    public void receiveMessageFromController(String str, JSONObject jSONObject, String str2, String str3) {
        try {
            if (!str.equalsIgnoreCase("loadWithUrl")) {
                this.mIsnAdViewLogic.a(str, jSONObject, str2, str3);
                return;
            }
            String string = jSONObject.getString("urlForWebView");
            this.mIsnAdViewLogic.c(jSONObject.getString("adViewId"));
            loadUrlIntoWebView(string, str2, str3);
        } catch (Exception e2) {
            e2.printStackTrace();
            this.mIsnAdViewLogic.a(str3, "Could not handle message from controller: " + str + " with params: " + jSONObject.toString());
        }
    }

    void receiveMessageFromWebView(String str) {
        this.mIsnAdViewLogic.a(str);
    }

    public void setControllerDelegate(d dVar) {
        this.mIsnAdViewLogic.a(dVar);
    }
}
