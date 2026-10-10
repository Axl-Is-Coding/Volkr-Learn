package com.umeng.commonsdk.config;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: CollectController.java */
/* JADX INFO: loaded from: classes5.dex */
public class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static d f21043a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<String, Boolean> f21044b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Object f21045c = new Object();

    /* JADX INFO: compiled from: CollectController.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f21046a = new b();

        private a() {
        }
    }

    public static b a() {
        return a.f21046a;
    }

    private b() {
    }

    public static boolean a(String str) {
        if (!d.a(str)) {
            return false;
        }
        synchronized (f21045c) {
            if (!f21044b.containsKey(str)) {
                return true;
            }
            return f21044b.get(str).booleanValue();
        }
    }

    @Override // com.umeng.commonsdk.config.f
    public void a(String str, Boolean bool) {
        if (d.a(str)) {
            synchronized (f21045c) {
                if (f21044b != null) {
                    f21044b.put(str, bool);
                }
            }
        }
    }
}
