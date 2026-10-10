package com.alibaba.sdk.android.feedback.xblink.webview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;
import com.alibaba.sdk.android.feedback.R;
import com.alibaba.sdk.android.feedback.xblink.activity.XBBaseHybridActivity;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class XBHybridWebView extends WebView implements Handler.Callback {
    public static final int NOTIFY_PAGE_ERROR = 402;
    public static final int NOTIFY_PAGE_FINISH = 401;
    public static final int NOTIFY_PAGE_START = 400;
    public static final int NOTIFY_SAVE_IMAGE_FAIL = 405;
    public static final int NOTIFY_SAVE_IMAGE_SUCCESS = 404;
    public static final int NOTIFY_TIME_OUT = 403;
    public static final int NOTIFY_TOOL_BAR_SETTING = 406;
    private static final String TAG = "HybridWebView";
    private String appkey;
    public Context context;
    private String currentUrl;
    protected com.alibaba.sdk.android.feedback.xblink.f.j entryManager;
    private com.alibaba.sdk.android.feedback.xblink.f.b.b event;
    protected boolean isAlive;
    private long loadTime;
    protected Handler mHandler;
    private String mImageUrl;
    private com.alibaba.sdk.android.feedback.xblink.view.a mPopupController;
    private String[] mPopupMenuTags;
    private long onErrorTime;
    private View.OnClickListener popupClickListener;
    protected boolean supportDownload;
    protected WebChromeClient webChromeClient;
    protected WebViewClient webViewClient;
    private boolean wvSupportNativeJs;
    private v wvUIModel;

    public XBHybridWebView(Context context) {
        super(context);
        this.mHandler = null;
        this.wvUIModel = null;
        this.supportDownload = true;
        this.wvSupportNativeJs = true;
        this.currentUrl = "";
        this.appkey = "";
        this.loadTime = System.currentTimeMillis();
        this.onErrorTime = 0L;
        this.mPopupMenuTags = new String[]{"保存到相册"};
        this.popupClickListener = new o(this);
        this.context = context;
        init();
    }

    public XBHybridWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = null;
        this.wvUIModel = null;
        this.supportDownload = true;
        this.wvSupportNativeJs = true;
        this.currentUrl = "";
        this.appkey = "";
        this.loadTime = System.currentTimeMillis();
        this.onErrorTime = 0L;
        this.mPopupMenuTags = new String[]{"保存到相册"};
        this.popupClickListener = new o(this);
        this.context = context;
        init();
    }

    public XBHybridWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mHandler = null;
        this.wvUIModel = null;
        this.supportDownload = true;
        this.wvSupportNativeJs = true;
        this.currentUrl = "";
        this.appkey = "";
        this.loadTime = System.currentTimeMillis();
        this.onErrorTime = 0L;
        this.mPopupMenuTags = new String[]{"保存到相册"};
        this.popupClickListener = new o(this);
        this.context = context;
        init();
    }

    private String addTTID(String str) {
        if (str == null) {
            return null;
        }
        Uri uri = Uri.parse(str);
        String host = uri.getHost();
        String scheme = uri.getScheme();
        if (host == null || !host.endsWith("m.taobao.com")) {
            return str;
        }
        if ((!"http".equals(scheme) && !"https".equals(scheme)) || uri.getQueryParameter("ttid") != null) {
            return str;
        }
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.appendQueryParameter("ttid", com.alibaba.sdk.android.feedback.xblink.b.b.a().b());
        return builderBuildUpon.toString();
    }

    @SuppressLint({"NewApi", "SetJavaScriptEnabled"})
    private void init() {
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        this.webViewClient = new HybridWebViewClient(this.context);
        super.setWebViewClient(this.webViewClient);
        this.webChromeClient = new HybridWebChromeClient(this.context);
        super.setWebChromeClient(this.webChromeClient);
        setVerticalScrollBarEnabled(false);
        requestFocus();
        CookieManager.getInstance().setAcceptCookie(true);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Throwable th) {
            com.alibaba.sdk.android.feedback.xblink.i.g.a(TAG, "Failed to enable javascript on device, " + th.getMessage(), th);
        }
        String strC = com.alibaba.sdk.android.feedback.xblink.b.b.a().c();
        String strD = com.alibaba.sdk.android.feedback.xblink.b.b.a().d();
        if (!TextUtils.isEmpty(strC) && !TextUtils.isEmpty(strD)) {
            settings.setUserAgentString(settings.getUserAgentString() + " AliApp(" + strC + "/" + strD + ")");
        }
        settings.setUserAgentString(settings.getUserAgentString() + " WindVane/4.5.1");
        settings.setCacheMode(-1);
        if (Build.VERSION.SDK_INT >= 5) {
            settings.setDatabaseEnabled(true);
            String str = this.context.getFilesDir().getParentFile().getPath() + "/databases";
            settings.setDatabasePath(str);
            settings.setGeolocationEnabled(true);
            settings.setGeolocationDatabasePath(str);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        if (Build.VERSION.SDK_INT >= 7) {
            settings.setDomStorageEnabled(true);
            settings.setAppCacheEnabled(true);
            Context context = this.context;
            if (context != null && context.getCacheDir() != null) {
                settings.setAppCachePath(this.context.getCacheDir().getAbsolutePath());
            }
        }
        if (Build.VERSION.SDK_INT < 18) {
            settings.setSavePassword(false);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowUniversalAccessFromFileURLs(false);
            settings.setAllowFileAccessFromFileURLs(false);
        }
        com.alibaba.sdk.android.feedback.xblink.f.d.a().b();
        this.entryManager = new com.alibaba.sdk.android.feedback.xblink.f.j(this.context, this);
        this.event = new com.alibaba.sdk.android.feedback.xblink.f.b.b();
        this.event.a(this.context, this);
        addJsObject("WXAppEvent", this.event);
        if (Build.VERSION.SDK_INT > 15) {
            try {
                ClipboardManager clipboardManager = (ClipboardManager) this.context.getSystemService("clipboard");
                if (clipboardManager != null) {
                    ClipData primaryClip = clipboardManager.getPrimaryClip();
                    if (primaryClip == null || "intent:#Intent;S.K_1171477665=;end".equals(primaryClip.getItemAt(0).coerceToText(this.context).toString())) {
                        clipboardManager.setPrimaryClip(ClipData.newPlainText("初始化", ""));
                    }
                }
            } catch (Exception unused) {
            }
        }
        this.wvUIModel = new v(this.context, this);
        setOnLongClickListener(new n(this));
        setDownloadListener(new s(this));
        l.a();
        this.isAlive = true;
        removeJavascriptInterface("searchBoxJavaBridge_");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
    }

    private void setPageTitle(String str) {
        com.alibaba.sdk.android.feedback.xblink.i.g.a(TAG, "feedback setPageTitle");
        com.alibaba.sdk.android.feedback.util.k.b(this.context, str);
    }

    private void updateReturnButtonBehaviour(boolean z, String str) {
        com.alibaba.sdk.android.feedback.xblink.i.g.a(TAG, "feedback updateReturnButtonBehaviour");
        View viewFindViewById = ((Activity) this.context).findViewById(R.id.title_back);
        try {
            ((XBBaseHybridActivity) this.context).setJSControlledBackPress(z, str);
        } catch (ClassCastException unused) {
        }
        viewFindViewById.setOnClickListener(z ? new p(this, str) : new q(this));
    }

    private void updateRightNavButton(boolean z, String str, String str2) {
        TextView textView = (TextView) ((Activity) this.context).findViewById(R.id.title_button);
        if (!z) {
            com.alibaba.sdk.android.feedback.util.k.a(this.context);
        } else {
            com.alibaba.sdk.android.feedback.util.k.a(this.context, str);
            textView.setOnClickListener(new r(this, str2));
        }
    }

    @Override // android.webkit.WebView
    public void addJavascriptInterface(Object obj, String str) {
        if (!this.wvSupportNativeJs && Build.VERSION.SDK_INT < 17) {
            com.alibaba.sdk.android.feedback.xblink.i.g.b(TAG, "addJavascriptInterface is disabled before API level 17 for security.");
        } else if (Build.VERSION.SDK_INT >= 17) {
            super.addJavascriptInterface(obj, str);
        }
    }

    public void addJsObject(String str, Object obj) {
        com.alibaba.sdk.android.feedback.xblink.f.j jVar = this.entryManager;
        if (jVar != null) {
            jVar.a(str, obj);
        }
    }

    @Override // android.webkit.WebView
    public void destroy() {
        if (this.isAlive) {
            this.isAlive = false;
            super.setWebViewClient(null);
            super.setWebChromeClient(null);
            this.webViewClient = null;
            this.webChromeClient = null;
            this.entryManager.a();
            com.alibaba.sdk.android.feedback.xblink.a.b.a().b();
            this.mHandler.removeCallbacksAndMessages(null);
            removeAllViews();
            try {
                super.destroy();
            } catch (Exception unused) {
            }
        }
    }

    public void enableTakeDownload(boolean z) {
        WebViewClient webViewClient = this.webViewClient;
        if (webViewClient instanceof HybridWebViewClient) {
            ((HybridWebViewClient) webViewClient).enableTakeDownload(z);
        }
    }

    public String getAppkey() {
        return this.appkey;
    }

    public String getCurrentUrl() {
        return this.currentUrl;
    }

    public Object getJsObject(String str) {
        com.alibaba.sdk.android.feedback.xblink.f.j jVar = this.entryManager;
        if (jVar == null) {
            return null;
        }
        return jVar.a(str);
    }

    public long getLoadTimestamp() {
        return this.loadTime;
    }

    public com.alibaba.sdk.android.feedback.xblink.e.a getUrlFilter() {
        WebViewClient webViewClient = this.webViewClient;
        if (webViewClient instanceof HybridWebViewClient) {
            return ((HybridWebViewClient) webViewClient).getUrlFilter();
        }
        return null;
    }

    public synchronized com.alibaba.sdk.android.feedback.xblink.f.b getWVCallBackContext() {
        if (this.event == null) {
            return null;
        }
        return this.event.d();
    }

    public Handler getWVHandler() {
        return this.mHandler;
    }

    public v getWvUIModel() {
        return this.wvUIModel;
    }

    public boolean handleMessage(Message message) {
        String string;
        switch (message.what) {
            case 400:
                this.wvUIModel.b();
                break;
            case 401:
                this.wvUIModel.c();
                if (this.onErrorTime != 0 && System.currentTimeMillis() - this.onErrorTime > 3000) {
                    this.wvUIModel.e();
                }
                break;
            case 402:
                this.wvUIModel.d();
                this.onErrorTime = System.currentTimeMillis();
                break;
            case 403:
                this.wvUIModel.c();
                break;
            case 404:
                Toast.makeText(this.context, "图片保存到相册成功", 1).show();
                break;
            case 405:
                Toast.makeText(this.context, "图片保存到相册失败", 1).show();
                break;
            case 406:
                try {
                    JSONObject jSONObject = new JSONObject((String) message.obj);
                    if (jSONObject.has("pageTitle")) {
                        setPageTitle(jSONObject.getString("pageTitle"));
                    }
                    boolean z = jSONObject.getBoolean("canGoBack");
                    String string2 = null;
                    updateReturnButtonBehaviour(z, z ? jSONObject.getString("backCallback") : null);
                    boolean z2 = jSONObject.getBoolean("haveRightNavButton");
                    if (z2) {
                        string2 = jSONObject.getString("rightButtonContent");
                        string = jSONObject.getString("rightButtonCallback");
                    } else {
                        string = null;
                    }
                    updateRightNavButton(z2, string2, string);
                    com.alibaba.sdk.android.feedback.util.k.b(this.context);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                break;
        }
        return true;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    @Override // android.webkit.WebView
    public void loadData(String str, String str2, String str3) {
        if (this.isAlive) {
            super.loadData(str, str2, str3);
            this.loadTime = System.currentTimeMillis();
        }
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (this.isAlive) {
            if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
                com.alibaba.sdk.android.feedback.xblink.i.g.a(TAG, "loadDataWithBaseURL: baseUrl=" + str);
            }
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
            this.loadTime = System.currentTimeMillis();
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        com.alibaba.sdk.android.feedback.xblink.i.g.a(TAG, "FeedbackAPI url=" + str);
        if (!this.isAlive || str == null) {
            return;
        }
        if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
            com.alibaba.sdk.android.feedback.xblink.i.g.a(TAG, "loadUrl: url=" + str);
        }
        super.loadUrl(addTTID(str));
        if (com.alibaba.sdk.android.feedback.xblink.i.h.a(str)) {
            this.loadTime = System.currentTimeMillis();
        }
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str, Map map) {
        if (!this.isAlive || str == null) {
            return;
        }
        if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
            com.alibaba.sdk.android.feedback.xblink.i.g.a(TAG, "loadUrl with headers: url=" + str);
        }
        super.loadUrl(addTTID(str), map);
        if (com.alibaba.sdk.android.feedback.xblink.i.h.a(str)) {
            this.loadTime = System.currentTimeMillis();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        com.alibaba.sdk.android.feedback.xblink.f.j jVar = this.entryManager;
        if (jVar != null) {
            jVar.a(i, i2, intent);
        }
    }

    public void onMessage(int i, Object obj) {
        if (this.mHandler != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = i;
            messageObtain.obj = obj;
            this.mHandler.sendMessage(messageObtain);
        }
    }

    @Override // android.webkit.WebView
    @TargetApi(11)
    public void onPause() {
        com.alibaba.sdk.android.feedback.xblink.a.b.a().b();
        com.alibaba.sdk.android.feedback.xblink.f.j jVar = this.entryManager;
        if (jVar != null) {
            jVar.b();
        }
        if (Build.VERSION.SDK_INT >= 11) {
            super.onPause();
        }
    }

    @Override // android.webkit.WebView
    @TargetApi(11)
    public void onResume() {
        com.alibaba.sdk.android.feedback.xblink.f.j jVar = this.entryManager;
        if (jVar != null) {
            jVar.c();
        }
        if (Build.VERSION.SDK_INT >= 11) {
            super.onResume();
        }
    }

    @Override // android.webkit.WebView
    public void postUrl(String str, byte[] bArr) {
        if (!this.isAlive || str == null) {
            return;
        }
        if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
            com.alibaba.sdk.android.feedback.xblink.i.g.a(TAG, "postUrl: url=" + str);
        }
        super.postUrl(str, bArr);
        if (com.alibaba.sdk.android.feedback.xblink.i.h.a(str)) {
            this.loadTime = System.currentTimeMillis();
        }
    }

    @Override // android.webkit.WebView
    public void reload() {
        super.reload();
        this.loadTime = System.currentTimeMillis();
    }

    public void setAppkey(String str) {
        this.appkey = str;
    }

    public void setCurrentUrl(String str) {
        this.currentUrl = str;
    }

    public void setLoadTimestamp(long j) {
        this.loadTime = j;
    }

    public void setSupportDownload(boolean z) {
        this.supportDownload = z;
    }

    public void setUrlFilter(com.alibaba.sdk.android.feedback.xblink.e.a aVar) {
        WebViewClient webViewClient = this.webViewClient;
        if (webViewClient instanceof HybridWebViewClient) {
            ((HybridWebViewClient) webViewClient).setUrlFilter(aVar);
        }
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        if (!(webChromeClient instanceof HybridWebChromeClient)) {
            throw new u("Your WebChromeClient must be extended from HybridWebChromeClient");
        }
        this.webChromeClient = webChromeClient;
        super.setWebChromeClient(webChromeClient);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        if (!(webViewClient instanceof HybridWebViewClient)) {
            throw new u("Your WebViewClient must be extended from HybridWebViewClient");
        }
        this.webViewClient = webViewClient;
        super.setWebViewClient(webViewClient);
    }

    public void superLoadUrl(String str) {
        if (this.isAlive) {
            super.loadUrl(str);
            if (com.alibaba.sdk.android.feedback.xblink.i.h.a(str)) {
                this.loadTime = System.currentTimeMillis();
            }
        }
    }

    public void supportJavascriptInterface(boolean z) {
        this.wvSupportNativeJs = z;
    }
}
