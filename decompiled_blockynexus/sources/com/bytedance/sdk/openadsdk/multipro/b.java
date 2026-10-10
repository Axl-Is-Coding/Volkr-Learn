package com.bytedance.sdk.openadsdk.multipro;

/* JADX INFO: compiled from: MultiGlobalInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f7056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f7057b;

    public static void a() {
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_info", "is_support_multi_process", (Boolean) true);
        f7056a = true;
        f7057b = true;
    }

    public static boolean b() {
        if (!f7057b) {
            f7056a = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_info", "is_support_multi_process", false);
            f7057b = true;
        }
        return f7056a;
    }
}
