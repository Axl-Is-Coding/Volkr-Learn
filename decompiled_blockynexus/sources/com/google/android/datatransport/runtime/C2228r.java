package com.google.android.datatransport.runtime;

import java.util.Set;

/* JADX INFO: renamed from: com.google.android.datatransport.runtime.r, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TransportFactoryImpl.java */
/* JADX INFO: loaded from: classes.dex */
final class C2228r implements com.google.android.datatransport.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<com.google.android.datatransport.b> f12958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q f12959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final t f12960c;

    C2228r(Set<com.google.android.datatransport.b> set, q qVar, t tVar) {
        this.f12958a = set;
        this.f12959b = qVar;
        this.f12960c = tVar;
    }

    @Override // com.google.android.datatransport.f
    public <T> com.google.android.datatransport.e<T> a(String str, Class<T> cls, com.google.android.datatransport.b bVar, com.google.android.datatransport.d<T, byte[]> dVar) {
        if (this.f12958a.contains(bVar)) {
            return new s(this.f12959b, str, bVar, dVar, this.f12960c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", bVar, this.f12958a));
    }
}
