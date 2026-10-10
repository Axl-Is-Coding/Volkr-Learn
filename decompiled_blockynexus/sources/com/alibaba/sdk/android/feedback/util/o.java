package com.alibaba.sdk.android.feedback.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.alibaba.sdk.android.feedback.windvane.CustomHybirdActivity;

/* JADX INFO: loaded from: classes.dex */
public class o {
    public static void a(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) CustomHybirdActivity.class);
        intent.putExtra("URL", str);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }
}
