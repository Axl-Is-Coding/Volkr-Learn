package com.sandboxol.common.utils;

import android.content.Context;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: loaded from: classes3.dex */
public class FirebaseUtils {
    public static void onEvent(Context context, String str) {
        FirebaseAnalytics.getInstance(context).logEvent(str, null);
    }

    public static void onEvent(Context context, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("GameId", str2);
        FirebaseAnalytics.getInstance(context).logEvent(str, bundle);
    }
}
