package com.google.android.datatransport.runtime.d.a;

/* JADX INFO: renamed from: com.google.android.datatransport.runtime.d.a.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: EventStoreModule_StoreConfigFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2225i implements com.google.android.datatransport.runtime.a.a.b<AbstractC2221e> {

    /* JADX INFO: renamed from: com.google.android.datatransport.runtime.d.a.i$a */
    /* JADX INFO: compiled from: EventStoreModule_StoreConfigFactory.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final C2225i f12894a = new C2225i();
    }

    public static C2225i a() {
        return a.f12894a;
    }

    public static AbstractC2221e b() {
        AbstractC2221e abstractC2221eC = AbstractC2222f.c();
        com.google.android.datatransport.runtime.a.a.d.a(abstractC2221eC, "Cannot return null from a non-@Nullable @Provides method");
        return abstractC2221eC;
    }

    @Override // e.a.a
    public AbstractC2221e get() {
        return b();
    }
}
