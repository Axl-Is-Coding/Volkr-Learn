package com.ironsource.sdk.service.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.util.Log;
import org.json.JSONObject;

/* JADX INFO: compiled from: BroadcastReceiverStrategy.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f15401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BroadcastReceiver f15402b = new a(this);

    public b(d dVar) {
        this.f15401a = dVar;
    }

    @Override // com.ironsource.sdk.service.a.c
    public void b(Context context) {
        try {
            context.registerReceiver(this.f15402b, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ironsource.sdk.service.a.c
    public void c(Context context) {
        try {
            context.unregisterReceiver(this.f15402b);
        } catch (IllegalArgumentException unused) {
        } catch (Exception e2) {
            Log.e("ContentValues", "unregisterConnectionReceiver - " + e2);
            new com.ironsource.sdk.utils.b().execute("https://www.supersonicads.com/mobile/sdk5/log?method=" + e2.getStackTrace()[0].getMethodName());
        }
    }

    @Override // com.ironsource.sdk.service.a.c
    public void release() {
        this.f15402b = null;
    }

    @Override // com.ironsource.sdk.service.a.c
    public JSONObject a(Context context) {
        return new JSONObject();
    }
}
