package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: ActivityUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: compiled from: ActivityUtil.java */
    public interface a {
        void a();

        void a(Throwable th);
    }

    public static void a(Context context, Intent intent, a aVar) {
        if (context == null || intent == null) {
            return;
        }
        try {
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            if (aVar != null) {
                aVar.a();
            }
        } catch (Throwable th) {
            if (aVar != null) {
                aVar.a(th);
            }
        }
    }
}
