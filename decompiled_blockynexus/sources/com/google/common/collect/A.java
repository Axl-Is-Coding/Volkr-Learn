package com.google.common.collect;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: compiled from: ImmutableList.java */
/* JADX INFO: loaded from: classes2.dex */
class A<E> extends AbstractC2239a<E> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ImmutableList f13775c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    A(ImmutableList immutableList, int i, int i2) {
        super(i, i2);
        this.f13775c = immutableList;
    }

    @Override // com.google.common.collect.AbstractC2239a
    protected E a(int i) {
        return this.f13775c.get(i);
    }
}
