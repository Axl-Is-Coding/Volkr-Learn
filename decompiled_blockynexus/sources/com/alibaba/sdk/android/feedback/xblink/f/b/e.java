package com.alibaba.sdk.android.feedback.xblink.f.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
class e extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f3842a;

    e(d dVar) {
        this.f3842a = dVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("sourceId");
        String stringExtra2 = intent.getStringExtra("data");
        String stringExtra3 = intent.getStringExtra("fromId");
        if ("com.alibaba.mobileim.ui.windvane.h5notify".equals(intent.getAction()) && this.f3842a.f3841f.contains(stringExtra)) {
            this.f3842a.a(stringExtra, stringExtra3, stringExtra2);
        }
    }
}
