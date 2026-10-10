package com.twitter.sdk.android.core;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: IntentUtils.java */
/* JADX INFO: loaded from: classes5.dex */
public class h {
    public static boolean a(Context context, Intent intent) {
        return !context.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }

    public static boolean b(Context context, Intent intent) {
        if (!a(context, intent)) {
            return false;
        }
        context.startActivity(intent);
        return true;
    }
}
