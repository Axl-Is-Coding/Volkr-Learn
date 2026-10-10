package com.sandboxol.blockmango.webvideo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.WebChromeClient;
import com.just.agentweb.WebViewClient;

/* JADX INFO: loaded from: classes2.dex */
public class WebVideoModel {
    private static final String JS_HIDE_YOUTUBE_MORE_VIDEO = "javascript:document.onclick= function(){document.querySelector('.ytp-pause-overlay').style.visibility='hidden'}";
    private static final String JS_HIDE_YOUTUBE_TITLE = "javascript:(function() { document.querySelector('.ytp-chrome-top').style.display='none';  })();";

    static /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        return motionEvent.getAction() == 2;
    }

    private String getLoopVideo(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str + "?autoplay=1&loop=1&playlist=" + str.substring(str.lastIndexOf("/") + 1) + "&muted=1";
    }

    public AgentWeb initAgentWebView(final Activity activity, ViewGroup viewGroup, String str) {
        AgentWeb agentWebGo = AgentWeb.with(activity).setAgentWebParent(viewGroup, new LinearLayout.LayoutParams(-1, -1)).useDefaultIndicator().setWebChromeClient(new WebChromeClient() { // from class: com.sandboxol.blockmango.webvideo.WebVideoModel.2
            @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
            public Bitmap getDefaultVideoPoster() {
                return super.getDefaultVideoPoster() == null ? Bitmap.createBitmap(640, 360, Bitmap.Config.ALPHA_8) : super.getDefaultVideoPoster();
            }

            @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
            public void onHideCustomView() {
                super.onHideCustomView();
                activity.setRequestedOrientation(0);
            }

            @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (i != 100 || webView == null) {
                    return;
                }
                webView.loadUrl(WebVideoModel.JS_HIDE_YOUTUBE_TITLE);
                webView.loadUrl(WebVideoModel.JS_HIDE_YOUTUBE_MORE_VIDEO);
            }

            @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                super.onShowCustomView(view, customViewCallback);
                activity.setRequestedOrientation(0);
            }
        }).setWebViewClient(new WebViewClient() { // from class: com.sandboxol.blockmango.webvideo.WebVideoModel.1
            @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str2) {
                super.onPageFinished(webView, str2);
                if (webView != null) {
                    webView.loadUrl(WebVideoModel.JS_HIDE_YOUTUBE_TITLE);
                    webView.loadUrl(WebVideoModel.JS_HIDE_YOUTUBE_MORE_VIDEO);
                }
            }
        }).createAgentWeb().ready().go(getLoopVideo(str));
        WebSettings webSettings = agentWebGo.getAgentWebSettings().getWebSettings();
        if (Build.VERSION.SDK_INT >= 17) {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        }
        webSettings.setBuiltInZoomControls(false);
        webSettings.setSupportZoom(false);
        webSettings.setDisplayZoomControls(false);
        agentWebGo.getWebCreator().getWebView().setScrollContainer(false);
        agentWebGo.getWebCreator().getWebView().setVerticalScrollBarEnabled(false);
        agentWebGo.getWebCreator().getWebView().setHorizontalScrollBarEnabled(false);
        agentWebGo.getWebCreator().getWebView().setOnTouchListener(new View.OnTouchListener() { // from class: com.sandboxol.blockmango.webvideo.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return WebVideoModel.a(view, motionEvent);
            }
        });
        agentWebGo.getWebCreator().getWebView().setBackgroundColor(-16777216);
        return agentWebGo;
    }
}
