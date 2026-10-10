package com.bytedance.sdk.openadsdk.core.g;

import android.util.Log;
import com.bytedance.sdk.openadsdk.core.o;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SdkSwitch.java */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicInteger f6213a = new AtomicInteger(1);

    public static boolean a() {
        return f6213a.get() == 1;
    }

    protected static void a(int i) {
        boolean z = true;
        if (i == 1 || i == 2) {
            try {
                if (f6213a.get() != i) {
                    try {
                        f6213a.set(i);
                    } catch (Throwable th) {
                        th = th;
                        th.printStackTrace();
                    }
                } else {
                    z = false;
                }
            } catch (Throwable th2) {
                th = th2;
                z = false;
            }
            if (z) {
                Log.e("SdkSwitch", "switch status changed: " + a());
                if (a()) {
                    o.b();
                    return;
                }
                try {
                    if (o.c() != null) {
                        o.c().b();
                    }
                    if (o.e() != null) {
                        o.e().b();
                    }
                    if (o.d() != null) {
                        o.d().b();
                    }
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
                try {
                    if (o.g() != null) {
                        o.g().b();
                    }
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
                try {
                    if (o.j() != null) {
                        o.j().b();
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        }
    }
}
