package com.ironsource.mediationsdk.d;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.ironsource.mediationsdk.U;

/* JADX INFO: compiled from: IntegrationHelper.java */
/* JADX INFO: loaded from: classes2.dex */
class a extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f14806a;

    a(Activity activity) {
        this.f14806a = activity;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            Log.w("IntegrationHelper", "--------------- Google Play Services --------------");
            if (this.f14806a.getPackageManager().getApplicationInfo(this.f14806a.getPackageName(), 128).metaData.containsKey("com.google.android.gms.version")) {
                Log.i("IntegrationHelper", "Google Play Services - VERIFIED");
                String strA = U.e().a((Context) this.f14806a);
                if (!TextUtils.isEmpty(strA)) {
                    Log.i("IntegrationHelper", "GAID is: " + strA + " (use this for test devices)");
                }
            } else {
                Log.e("IntegrationHelper", "Google Play Services - MISSING");
            }
        } catch (Exception unused) {
            Log.e("IntegrationHelper", "Google Play Services - MISSING");
        }
    }
}
