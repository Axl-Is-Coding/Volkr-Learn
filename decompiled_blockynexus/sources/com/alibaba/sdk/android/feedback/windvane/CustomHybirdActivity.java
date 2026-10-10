package com.alibaba.sdk.android.feedback.windvane;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.webkit.WebBackForwardList;
import android.widget.TextView;
import com.alibaba.sdk.android.feedback.R;
import com.alibaba.sdk.android.feedback.impl.FeedbackAPI;
import com.alibaba.sdk.android.feedback.util.p;
import com.alibaba.sdk.android.feedback.xblink.webview.XBHybridWebView;

/* JADX INFO: loaded from: classes.dex */
public class CustomHybirdActivity extends WXBaseHybridActivity {
    public static final String FROM = "from";
    public static final String NEED_SHOW_BACK = "need_show_back";
    public static final String NEED_TRANS = "need_trans";
    public static final String PLUGIN_TITLE = "plugin_title";
    private static final String TAG = "CustomHybirdActivity";
    private String from;
    private boolean hideTitle;
    private boolean needShowBack;
    private TextView rightTitleBtn;
    private boolean needTrans = false;
    private String pluginTitle = "";
    private int mTitleClickCount = 0;

    /* JADX WARN: Removed duplicated region for block: B:41:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void controlTitleBar() {
        /*
            Method dump skipped, instruction units count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.windvane.CustomHybirdActivity.controlTitleBar():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCanGoBack() {
        if (this.needShowNav || !this.webview.canGoBack()) {
            return false;
        }
        WebBackForwardList webBackForwardListCopyBackForwardList = this.webview.copyBackForwardList();
        if (webBackForwardListCopyBackForwardList.getCurrentIndex() <= 0) {
            return false;
        }
        String url = webBackForwardListCopyBackForwardList.getItemAtIndex(webBackForwardListCopyBackForwardList.getCurrentIndex() - 1).getUrl();
        com.alibaba.sdk.android.feedback.xblink.i.g.a(TAG, "FeedbackAPI host " + url);
        if (!p.a(url)) {
            return false;
        }
        com.alibaba.sdk.android.feedback.xblink.i.g.a(TAG, "FeedbackAPI host can go back");
        return true;
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.activity.XBBaseHybridActivity
    protected com.alibaba.sdk.android.feedback.xblink.e.a createFilter() {
        return null;
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.activity.XBBaseHybridActivity, android.app.Activity
    public void onBackPressed() {
        com.alibaba.sdk.android.feedback.xblink.i.g.a(TAG, "Back custom back");
        super.onBackPressed();
    }

    @Override // com.alibaba.sdk.android.feedback.windvane.WXBaseHybridActivity, com.alibaba.sdk.android.feedback.xblink.activity.XBBaseHybridActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ali_feedback_container_layout);
        if (Build.VERSION.SDK_INT >= 19 && com.alibaba.sdk.android.feedback.a.a.e() && com.alibaba.sdk.android.feedback.a.b.a()) {
            getWindow().addFlags(67108864);
        }
        ((ViewGroup) findViewById(R.id.hybird_container)).addView(this.mViewController);
        FeedbackAPI.activity = this;
        if (TextUtils.isEmpty(this.url)) {
            this.url = getIntent().getDataString();
            this.mUrl = getIntent().getDataString();
        }
        controlTitleBar();
        XBHybridWebView xBHybridWebView = this.mWebView;
        if (xBHybridWebView != null) {
            xBHybridWebView.resumeTimers();
        }
        loadUrl();
        if (FeedbackAPI.getActivityCallback() != null) {
            try {
                FeedbackAPI.getActivityCallback().onCreate(this);
            } catch (Exception e2) {
                com.alibaba.sdk.android.feedback.xblink.i.g.b(TAG, "call activitcallback oncreate exception:" + e2.getMessage());
            }
        }
    }

    @Override // com.alibaba.sdk.android.feedback.windvane.WXBaseHybridActivity, com.alibaba.sdk.android.feedback.xblink.activity.XBBaseHybridActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        FeedbackAPI.cleanActivity();
        try {
            if (FeedbackAPI.leaveCallback != null) {
                FeedbackAPI.leaveCallback.call();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        com.alibaba.sdk.android.feedback.xblink.i.g.a(TAG, "onNewIntent");
        super.onNewIntent(intent);
        loadUrl();
    }

    public void onUrlIntercept(com.alibaba.sdk.android.feedback.xblink.e.a.a aVar, int i) {
    }
}
