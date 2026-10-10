package com.alibaba.sdk.android.feedback.xblink.webview;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.webkit.WebBackForwardList;
import android.webkit.WebViewClient;
import fi.iki.elonen.NanoHTTPD;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class HybridPlusWebView extends XBHybridWebView implements Handler.Callback, com.alibaba.sdk.android.feedback.xblink.c.j {
    public static final String CHARSET = "charset";
    public static final int DOMREADY = 1016;
    public static final String HTML_CONTENT = "html_content";
    public static final String HTTPSVERIFYERROR = "httpsverifyerror";
    public static final int HTTPS_CERT_EXPIRED = -602;
    public static final int HTTPS_CERT_INVILD = -601;
    public static final int LOAD_BEGIN = 1011;
    public static final int LOAD_ERROR = 1013;
    public static final int LOAD_FINSH = 1012;
    public static final String MIMETYPE = "mimetype";
    public static final int PAGE_FINSH = 1015;
    private static String[] SUPPORTED_MIMETYPE = {NanoHTTPD.MIME_HTML, NanoHTTPD.MIME_PLAINTEXT, "application/xhtml+xml", "application/xml", "image/jpeg", "image/png", "image/webp", "image/gif"};
    private static String[] SUPPORTED_MIMETYPE_CONFIG = null;
    private static final String TAG = "HybridPlusWebView";
    public static final int UNSUPPORTED_MIMETYPE = -400;
    public static final int URL_HITTED = 1014;
    public static final String WEBVIEW_MIMETYPE = "webview_mimetype";
    private final int HTML_FINSH;
    private long beginTime;
    private com.alibaba.sdk.android.feedback.xblink.c.a htmlDownloader;
    private boolean isLoading;
    private boolean isReload;
    private boolean needDomReady;
    private Map requestHeaders;
    private c sslErrorListener;
    private int token;
    private String url;

    public HybridPlusWebView(Context context) {
        super(context);
        this.HTML_FINSH = 200;
        this.beginTime = 0L;
        this.requestHeaders = null;
        init();
    }

    public HybridPlusWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.HTML_FINSH = 200;
        this.beginTime = 0L;
        this.requestHeaders = null;
        init();
    }

    public HybridPlusWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.HTML_FINSH = 200;
        this.beginTime = 0L;
        this.requestHeaders = null;
        init();
    }

    private String addDomReady(String str) {
        int iIndexOf;
        if (str == null) {
            return null;
        }
        if (str.indexOf("window.WindVane.call('WVPlusWebView','htmlFinsh',{});\n") != -1 || (iIndexOf = str.indexOf("</body>")) == -1) {
            return str;
        }
        return str.substring(0, iIndexOf) + "<script type=\"text/javascript\" src=\"http://g.tbcdn.cn/mtb/lib-windvane/1.2.4/bridge.js\"></script><script type=\"text/javascript\">document.addEventListener( \"DOMContentLoaded\", function() { window.WindVane.call('WVPlusWebView','htmlFinsh',{}); }, false ); </script>" + str.substring(iIndexOf);
    }

    private void init() {
        String string = "";
        this.token = 0;
        this.needDomReady = true;
        super.addJsObject("WVPlusWebView", new b(this));
        if (SUPPORTED_MIMETYPE_CONFIG == null) {
            try {
                string = this.context.getSharedPreferences(WEBVIEW_MIMETYPE, 0).getString(WEBVIEW_MIMETYPE, "");
            } catch (ClassCastException unused) {
                com.alibaba.sdk.android.feedback.xblink.i.g.b(TAG, "get mimeType ClassCastException:");
            }
            if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
                com.alibaba.sdk.android.feedback.xblink.i.g.a(TAG, "support mimetype:" + string);
            }
            SUPPORTED_MIMETYPE_CONFIG = string.split(";");
            String[] strArr = SUPPORTED_MIMETYPE_CONFIG;
            if (strArr == null || strArr.length <= 0 || strArr[0].length() <= 0) {
                SUPPORTED_MIMETYPE_CONFIG = null;
            } else {
                SUPPORTED_MIMETYPE = SUPPORTED_MIMETYPE_CONFIG;
            }
        }
    }

    private void loadUrl(String str, Map map, boolean z) {
        if (this.isAlive) {
            this.isReload = str != null && str.equals(this.url);
            if (str != null && (str.toLowerCase().startsWith("data:") || str.toLowerCase().startsWith("javascript:") || str.toLowerCase().startsWith("file:"))) {
                super.loadUrl(str);
                return;
            }
            com.alibaba.sdk.android.feedback.xblink.c.a aVar = this.htmlDownloader;
            if (aVar != null) {
                aVar.a();
                this.htmlDownloader.b();
                this.htmlDownloader.a(null);
            }
            this.token++;
            this.url = str;
            this.isLoading = true;
            this.requestHeaders = null;
            if (map != null) {
                this.requestHeaders = new HashMap(map);
            }
            this.htmlDownloader = new com.alibaba.sdk.android.feedback.xblink.c.a(getSettings().getUserAgentString(), this, this.requestHeaders, str, this.token, z);
            new Thread(this.htmlDownloader).start();
            WebViewClient webViewClient = this.webViewClient;
            if (webViewClient != null && this.isAlive) {
                webViewClient.onPageStarted(this, str, null);
            }
            this.beginTime = System.currentTimeMillis();
        }
    }

    public boolean back() {
        if (!this.isAlive || !canGoBack()) {
            return false;
        }
        goBack();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0125  */
    @Override // com.alibaba.sdk.android.feedback.xblink.c.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void callback(byte[] r11, java.util.Map r12, int r13) {
        /*
            Method dump skipped, instruction units count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.webview.HybridPlusWebView.callback(byte[], java.util.Map, int):void");
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.webview.XBHybridWebView, android.webkit.WebView
    public void destroy() {
        com.alibaba.sdk.android.feedback.xblink.c.a aVar = this.htmlDownloader;
        if (aVar != null) {
            aVar.a(null);
            this.htmlDownloader.b();
            this.htmlDownloader = null;
        }
        super.destroy();
    }

    public void enableDomReady(boolean z) {
        this.needDomReady = z;
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.webview.XBHybridWebView
    public String getCurrentUrl() {
        return (this.isLoading || super.getUrl() == null) ? this.url : super.getUrl();
    }

    @Override // android.webkit.WebView
    public String getUrl() {
        return getCurrentUrl();
    }

    @Override // android.webkit.WebView
    public void goBack() {
        WebViewClient webViewClient;
        if (this.isAlive) {
            this.token++;
            com.alibaba.sdk.android.feedback.xblink.c.a aVar = this.htmlDownloader;
            if (aVar != null) {
                aVar.a();
                this.htmlDownloader.b();
                this.htmlDownloader.a(null);
            }
            if (this.isLoading && (webViewClient = this.webViewClient) != null) {
                webViewClient.onPageFinished(this, getUrl());
                return;
            }
            if (canGoBack()) {
                String url = copyBackForwardList().getItemAtIndex(r0.getCurrentIndex() - 1).getUrl();
                if (url != null) {
                    if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
                        com.alibaba.sdk.android.feedback.xblink.i.g.a(TAG, "goBack: " + url);
                    }
                    super.goBack();
                }
            }
        }
    }

    @Override // android.webkit.WebView
    public void goBackOrForward(int i) {
        if (this.isAlive) {
            if (i != 0) {
                this.token++;
            }
            com.alibaba.sdk.android.feedback.xblink.c.a aVar = this.htmlDownloader;
            if (aVar != null) {
                aVar.a();
                this.htmlDownloader.b();
                this.htmlDownloader.a(null);
            }
            if (this.isLoading) {
                if (i < -1) {
                    i++;
                } else if (i < 0) {
                    WebViewClient webViewClient = this.webViewClient;
                    if (webViewClient == null) {
                        return;
                    } else {
                        webViewClient.onPageFinished(this, super.getUrl());
                    }
                }
            }
            if (canGoBackOrForward(i)) {
                WebBackForwardList webBackForwardListCopyBackForwardList = copyBackForwardList();
                String url = webBackForwardListCopyBackForwardList.getItemAtIndex(webBackForwardListCopyBackForwardList.getCurrentIndex() + i).getUrl();
                if (url != null && com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
                    com.alibaba.sdk.android.feedback.xblink.i.g.a(TAG, "goBackOrForward: " + url);
                }
                super.goBackOrForward(i);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0109 A[PHI: r12
      0x0109: PHI (r12v6 com.alibaba.sdk.android.feedback.xblink.c.a) = (r12v3 com.alibaba.sdk.android.feedback.xblink.c.a), (r12v7 com.alibaba.sdk.android.feedback.xblink.c.a) binds: [B:64:0x0107, B:54:0x00e9] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.alibaba.sdk.android.feedback.xblink.webview.XBHybridWebView, android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean handleMessage(android.os.Message r12) {
        /*
            Method dump skipped, instruction units count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.webview.HybridPlusWebView.handleMessage(android.os.Message):boolean");
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.webview.XBHybridWebView, android.webkit.WebView
    public void loadUrl(String str) {
        if (this.isAlive) {
            if (str.startsWith("http://m.taobao.com") || str.startsWith("https://m.taobao.com")) {
                str = com.alibaba.sdk.android.feedback.xblink.i.h.a(str, "ttid", com.alibaba.sdk.android.feedback.xblink.b.b.a().b());
            }
            loadUrl(str, null, true);
        }
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.webview.XBHybridWebView, android.webkit.WebView
    public void reload() {
        reload(false);
    }

    public void reload(boolean z) {
        StringBuilder sb;
        if (this.isAlive) {
            String url = super.getUrl();
            if (this.isLoading || url == null) {
                loadUrl(this.url, this.requestHeaders, z);
                if (!com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
                    return;
                }
                sb = new StringBuilder();
                sb.append("reload & loading: ");
                url = this.url;
            } else {
                super.reload();
                if (!com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
                    return;
                }
                sb = new StringBuilder();
                sb.append("reload & post： ");
            }
            sb.append(url);
            com.alibaba.sdk.android.feedback.xblink.i.g.a(TAG, sb.toString());
        }
    }

    public void setSslErrorListener(c cVar) {
        this.sslErrorListener = cVar;
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        if (this.isAlive) {
            this.token++;
            com.alibaba.sdk.android.feedback.xblink.c.a aVar = this.htmlDownloader;
            if (aVar != null) {
                aVar.a();
                this.htmlDownloader.b();
                this.htmlDownloader.a(null);
            }
            super.stopLoading();
        }
    }
}
