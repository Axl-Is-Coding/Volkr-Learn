package com.google.android.datatransport.runtime.e;

/* JADX INFO: compiled from: TimeModule_EventClockFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class c implements com.google.android.datatransport.runtime.a.a.b<com.google.android.datatransport.runtime.e.a> {

    /* JADX INFO: compiled from: TimeModule_EventClockFactory.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f12936a = new c();
    }

    public static c a() {
        return a.f12936a;
    }

    public static com.google.android.datatransport.runtime.e.a b() {
        com.google.android.datatransport.runtime.e.a aVarA = b.a();
        com.google.android.datatransport.runtime.a.a.d.a(aVarA, "Cannot return null from a non-@Nullable @Provides method");
        return aVarA;
    }

    @Override // e.a.a
    public com.google.android.datatransport.runtime.e.a get() {
        return b();
    }
}
