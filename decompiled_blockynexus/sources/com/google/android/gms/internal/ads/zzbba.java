package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.google.android.gms.common.util.SharedPreferencesUtils;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbba implements Callable<String> {
    private final /* synthetic */ Context val$context;

    zzbba(zzbbb zzbbbVar, Context context) {
        this.val$context = context;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        SharedPreferences sharedPreferences = this.val$context.getSharedPreferences("admob_user_agent", 0);
        String string = sharedPreferences.getString("user_agent", "");
        if (!TextUtils.isEmpty(string)) {
            zzayp.zzei("User agent is already initialized on Google Play Services.");
            return string;
        }
        zzayp.zzei("User agent is not initialized on Google Play Services. Initializing.");
        SharedPreferencesUtils.publishWorldReadableSharedPreferences(this.val$context, sharedPreferences.edit().putString("user_agent", WebSettings.getDefaultUserAgent(this.val$context)), "admob_user_agent");
        throw null;
    }
}
