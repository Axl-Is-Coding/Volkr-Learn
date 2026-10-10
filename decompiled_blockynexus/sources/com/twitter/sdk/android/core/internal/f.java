package com.twitter.sdk.android.core.internal;

import android.content.Context;
import android.content.res.Resources;

/* JADX INFO: compiled from: CommonUtils.java */
/* JADX INFO: loaded from: classes5.dex */
public class f {
    static String a(Context context) {
        int i = context.getApplicationContext().getApplicationInfo().icon;
        return i > 0 ? context.getResources().getResourcePackageName(i) : context.getPackageName();
    }

    public static String b(Context context, String str, String str2) {
        Resources resources;
        int iA;
        return (context == null || (resources = context.getResources()) == null || (iA = a(context, str, "string")) <= 0) ? str2 : resources.getString(iA);
    }

    static int a(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, a(context));
    }

    public static void a(String str, String str2) {
        if (!com.twitter.sdk.android.core.n.g()) {
            com.twitter.sdk.android.core.n.e().w(str, str2);
            return;
        }
        throw new IllegalStateException(str2);
    }
}
