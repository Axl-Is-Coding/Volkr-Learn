package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.IListenerManager;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: CommonDialogHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, a> f7104a = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static IListenerManager f7105b;

    /* JADX INFO: compiled from: CommonDialogHelper.java */
    public interface a {
        void a();

        void b();

        void c();
    }

    public static void b(String str) {
        a(str, 2);
    }

    public static void c(String str) {
        a(str, 3);
    }

    public static a d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f7104a.remove(str);
    }

    public static void a(String str) {
        a(str, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IListenerManager b() {
        if (f7105b == null) {
            f7105b = IListenerManager.Stub.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(com.bytedance.sdk.openadsdk.core.o.a()).a(2));
        }
        return f7105b;
    }

    private static void a(final String str, final int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            new Thread(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.e.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        e.b().broadcastDialogListener(str, i);
                    } catch (Throwable unused) {
                    }
                }
            }).start();
            return;
        }
        a aVarD = d(str);
        if (aVarD == null) {
            return;
        }
        if (i == 1) {
            aVarD.a();
            return;
        }
        if (i == 2) {
            aVarD.b();
        } else if (i != 3) {
            aVarD.c();
        } else {
            aVarD.c();
        }
    }
}
