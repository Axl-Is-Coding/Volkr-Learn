package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.IListenerManager;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: CommonPermissionUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, a> f7108a = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static IListenerManager f7109b;

    /* JADX INFO: compiled from: CommonPermissionUtils.java */
    public interface a {
        void a();

        void a(String str);
    }

    private static a b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f7108a.remove(str);
    }

    public static void a(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            new Thread(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.f.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        o.b("MultiProcess", "handleYes-1，key=" + str);
                        f.b().broadcastPermissionListener(str, null);
                    } catch (Throwable unused) {
                    }
                }
            }).start();
            return;
        }
        a aVarB = b(str);
        if (aVarB == null) {
            return;
        }
        aVarB.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IListenerManager b() {
        if (f7109b == null) {
            f7109b = IListenerManager.Stub.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(com.bytedance.sdk.openadsdk.core.o.a()).a(4));
        }
        return f7109b;
    }

    public static void a(final String str, final String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            new Thread(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.f.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        o.b("MultiProcess", "handleNo-1，key=" + str + "，permission=" + str2);
                        f.b().broadcastPermissionListener(str, str2);
                    } catch (Throwable unused) {
                    }
                }
            }).start();
            return;
        }
        a aVarB = b(str);
        if (aVarB == null) {
            return;
        }
        aVarB.a(str2);
    }
}
