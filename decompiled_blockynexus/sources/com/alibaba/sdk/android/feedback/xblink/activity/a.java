package com.alibaba.sdk.android.feedback.xblink.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
class a extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ XBBaseHybridActivity f3761a;

    a(XBBaseHybridActivity xBBaseHybridActivity) {
        this.f3761a = xBBaseHybridActivity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        String stringExtra = intent.getStringExtra("data");
        String stringExtra2 = this.f3761a.getIntent().getStringExtra("APPKEY");
        if (TextUtils.isEmpty(stringExtra2)) {
            str = "WXCOMMUNICATIONPUSH" + this.f3761a.url;
        } else {
            str = "WXCOMMUNICATIONPUSH" + stringExtra2;
        }
        if (this.f3761a.url == null || !str.equals(action)) {
            return;
        }
        XBBaseHybridActivity xBBaseHybridActivity = this.f3761a;
        xBBaseHybridActivity.onBroadcast(xBBaseHybridActivity.mWebView, stringExtra);
    }
}
