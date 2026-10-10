package com.google.android.datatransport.runtime.e;

/* JADX INFO: compiled from: TimeModule_UptimeClockFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class d implements com.google.android.datatransport.runtime.a.a.b<com.google.android.datatransport.runtime.e.a> {

    /* JADX INFO: compiled from: TimeModule_UptimeClockFactory.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f12937a = new d();
    }

    public static d a() {
        return a.f12937a;
    }

    public static com.google.android.datatransport.runtime.e.a b() {
        com.google.android.datatransport.runtime.e.a aVarB = b.b();
        com.google.android.datatransport.runtime.a.a.d.a(aVarB, "Cannot return null from a non-@Nullable @Provides method");
        return aVarB;
    }

    @Override // e.a.a
    public com.google.android.datatransport.runtime.e.a get() {
        return b();
    }
}
