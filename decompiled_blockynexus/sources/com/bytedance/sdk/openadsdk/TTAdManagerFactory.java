package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.t;
import com.bytedance.sdk.openadsdk.multipro.b;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class TTAdManagerFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final TTAdManager f5608a = new t();

    private TTAdManagerFactory() {
    }

    static TTAdManager a() {
        return f5608a;
    }

    public static TTAdManager getInstance(Context context) {
        return getInstance(context, false);
    }

    public static TTAdManager getInstance(Context context, boolean z) {
        if (z) {
            b.a();
        }
        l.a(context);
        return f5608a;
    }
}
