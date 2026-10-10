package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.google.protobuf.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ExtensionRegistryLite.java */
/* JADX INFO: loaded from: classes2.dex */
public class C2306l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Class<?> f14359a = b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final C2306l f14360b = new C2306l(true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Object, GeneratedMessageLite.f<?, ?>> f14361c;

    C2306l() {
        this.f14361c = new HashMap();
    }

    public static C2306l a() {
        return C2305k.a();
    }

    static Class<?> b() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    C2306l(boolean z) {
        this.f14361c = Collections.emptyMap();
    }
}
