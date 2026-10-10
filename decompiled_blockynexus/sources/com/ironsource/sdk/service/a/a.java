package com.ironsource.sdk.service.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import org.json.JSONObject;

/* JADX INFO: compiled from: BroadcastReceiverStrategy.java */
/* JADX INFO: loaded from: classes2.dex */
class a extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f15400a;

    a(b bVar) {
        this.f15400a = bVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String strB = b.f.c.b.b(context);
        if (strB.equals("none")) {
            this.f15400a.f15401a.onDisconnected();
        } else {
            this.f15400a.f15401a.b(strB, new JSONObject());
        }
    }
}
