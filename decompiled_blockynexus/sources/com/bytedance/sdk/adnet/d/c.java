package com.bytedance.sdk.adnet.d;

/* JADX INFO: compiled from: Logger.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f5552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f5553b;

    /* JADX INFO: compiled from: Logger.java */
    public enum a {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    /* JADX INFO: compiled from: Logger.java */
    public interface b {
        void a(String str, String str2);

        void b(String str, String str2);
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.adnet.d.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Logger.java */
    private static class C0072c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f5559a = new c();
    }

    public static void a(a aVar) {
        synchronized (c.class) {
            C0072c.f5559a.f5552a = aVar;
        }
    }

    public static void b(String str, String str2) {
        if (C0072c.f5559a.f5552a.compareTo(a.DEBUG) <= 0) {
            C0072c.f5559a.f5553b.b(str, str2);
        }
    }

    private c() {
        this.f5552a = a.OFF;
        this.f5553b = new com.bytedance.sdk.adnet.d.a();
    }

    public static void a(String str, String str2) {
        if (C0072c.f5559a.f5552a.compareTo(a.ERROR) <= 0) {
            C0072c.f5559a.f5553b.a(str, str2);
        }
    }
}
