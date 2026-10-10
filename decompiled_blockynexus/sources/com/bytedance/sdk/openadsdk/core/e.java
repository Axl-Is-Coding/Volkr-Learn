package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.content.Context;
import com.bytedance.sdk.openadsdk.core.f;

/* JADX INFO: compiled from: DBAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile e f6150a;

    private e(Context context) {
        super(context);
    }

    @Override // com.bytedance.sdk.openadsdk.core.f
    public /* bridge */ /* synthetic */ f.c a() {
        return super.a();
    }

    public static e a(Context context) {
        if (f6150a == null) {
            synchronized (e.class) {
                if (f6150a == null) {
                    f6150a = new e(context);
                }
            }
        }
        return f6150a;
    }
}
