package com.google.protobuf;

/* JADX INFO: renamed from: com.google.protobuf.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ExtensionRegistryFactory.java */
/* JADX INFO: loaded from: classes2.dex */
final class C2305k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Class<?> f14358a = b();

    public static C2306l a() {
        if (f14358a != null) {
            try {
                return a("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return C2306l.f14360b;
    }

    static Class<?> b() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private static final C2306l a(String str) throws Exception {
        return (C2306l) f14358a.getMethod(str, new Class[0]).invoke(null, new Object[0]);
    }
}
