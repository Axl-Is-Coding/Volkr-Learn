package com.google.android.datatransport.runtime.d.a;

/* JADX INFO: compiled from: SQLiteEventStore_Factory.java */
/* JADX INFO: loaded from: classes.dex */
public final class E implements com.google.android.datatransport.runtime.a.a.b<D> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e.a.a<com.google.android.datatransport.runtime.e.a> f12861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e.a.a<com.google.android.datatransport.runtime.e.a> f12862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e.a.a<AbstractC2221e> f12863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e.a.a<J> f12864d;

    public E(e.a.a<com.google.android.datatransport.runtime.e.a> aVar, e.a.a<com.google.android.datatransport.runtime.e.a> aVar2, e.a.a<AbstractC2221e> aVar3, e.a.a<J> aVar4) {
        this.f12861a = aVar;
        this.f12862b = aVar2;
        this.f12863c = aVar3;
        this.f12864d = aVar4;
    }

    public static E a(e.a.a<com.google.android.datatransport.runtime.e.a> aVar, e.a.a<com.google.android.datatransport.runtime.e.a> aVar2, e.a.a<AbstractC2221e> aVar3, e.a.a<J> aVar4) {
        return new E(aVar, aVar2, aVar3, aVar4);
    }

    public static D a(com.google.android.datatransport.runtime.e.a aVar, com.google.android.datatransport.runtime.e.a aVar2, Object obj, Object obj2) {
        return new D(aVar, aVar2, (AbstractC2221e) obj, (J) obj2);
    }

    @Override // e.a.a
    public D get() {
        return a(this.f12861a.get(), this.f12862b.get(), this.f12863c.get(), this.f12864d.get());
    }
}
