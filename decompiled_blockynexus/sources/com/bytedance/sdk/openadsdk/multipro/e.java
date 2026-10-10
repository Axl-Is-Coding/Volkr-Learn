package com.bytedance.sdk.openadsdk.multipro;

import com.bytedance.sdk.openadsdk.core.o;

/* JADX INFO: compiled from: TTPathConst.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f7075a = "com.bytedance.openadsdk";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f7076b = "content://" + f7075a + ".TTMultiProvider";

    static {
        a();
    }

    public static void a() {
        if (o.a() != null) {
            f7075a = o.a().getPackageName();
            f7076b = "content://" + f7075a + ".TTMultiProvider";
        }
    }
}
