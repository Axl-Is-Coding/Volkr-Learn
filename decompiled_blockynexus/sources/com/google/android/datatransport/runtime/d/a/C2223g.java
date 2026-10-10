package com.google.android.datatransport.runtime.d.a;

/* JADX INFO: renamed from: com.google.android.datatransport.runtime.d.a.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: EventStoreModule_DbNameFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2223g implements com.google.android.datatransport.runtime.a.a.b<String> {

    /* JADX INFO: renamed from: com.google.android.datatransport.runtime.d.a.g$a */
    /* JADX INFO: compiled from: EventStoreModule_DbNameFactory.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final C2223g f12892a = new C2223g();
    }

    public static C2223g a() {
        return a.f12892a;
    }

    public static String b() {
        String strA = AbstractC2222f.a();
        com.google.android.datatransport.runtime.a.a.d.a(strA, "Cannot return null from a non-@Nullable @Provides method");
        return strA;
    }

    @Override // e.a.a
    public String get() {
        return b();
    }
}
