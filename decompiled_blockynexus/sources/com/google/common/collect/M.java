package com.google.common.collect;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Iterators.java */
/* JADX INFO: loaded from: classes2.dex */
class M<T> extends AbstractC2239a<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Object[] f13854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f13855d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    M(int i, int i2, Object[] objArr, int i3) {
        super(i, i2);
        this.f13854c = objArr;
        this.f13855d = i3;
    }

    @Override // com.google.common.collect.AbstractC2239a
    protected T a(int i) {
        return (T) this.f13854c[this.f13855d + i];
    }
}
