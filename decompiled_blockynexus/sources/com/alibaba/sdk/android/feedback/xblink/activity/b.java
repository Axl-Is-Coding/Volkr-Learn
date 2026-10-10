package com.alibaba.sdk.android.feedback.xblink.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.alibaba.sdk.android.feedback.xblink.i.g;

/* JADX INFO: loaded from: classes.dex */
class b extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ XBBaseHybridActivity f3762a;

    b(XBBaseHybridActivity xBBaseHybridActivity) {
        this.f3762a = xBBaseHybridActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra;
        try {
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null) {
                if (!stringExtra.equals("homekey")) {
                    stringExtra.equals("recentapps");
                } else if (this.f3762a.mWebView != null && this.f3762a.mWebView.getWVCallBackContext() != null) {
                    this.f3762a.mWebView.getWVCallBackContext().a("WXPage.onPaused", "{}");
                }
            }
        } catch (Exception e2) {
            g.b(this.f3762a.TAG, "FeedbackAPI Failed to extrack HomeKeyEventBroadCastReceiver intent action");
            e2.printStackTrace();
        }
    }
}
