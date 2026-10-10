package com.just.agentweb;

import android.app.Activity;
import android.webkit.DownloadListener;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes2.dex */
public class AgentWebSettingsImpl extends AbsAgentWebSettings {
    private AgentWeb mAgentWeb;

    @Override // com.just.agentweb.AbsAgentWebSettings
    protected void bindAgentWebSupport(AgentWeb agentWeb) {
        this.mAgentWeb = agentWeb;
    }

    @Override // com.just.agentweb.AbsAgentWebSettings, com.just.agentweb.WebListenerManager
    public WebListenerManager setDownloader(WebView webView, DownloadListener downloadListener) {
        if (downloadListener == null) {
            downloadListener = DefaultDownloadImpl.create((Activity) webView.getContext(), webView, this.mAgentWeb.getPermissionInterceptor());
        }
        super.setDownloader(webView, downloadListener);
        return this;
    }
}
