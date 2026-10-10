package com.google.common.collect;

import java.util.Collection;

/* JADX INFO: renamed from: com.google.common.collect.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: Collections2.java */
/* JADX INFO: loaded from: classes2.dex */
class C2260o implements com.google.common.base.f<Object, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Collection f13959a;

    C2260o(Collection collection) {
        this.f13959a = collection;
    }

    @Override // com.google.common.base.f
    public Object apply(Object obj) {
        return obj == this.f13959a ? "(this Collection)" : obj;
    }
}
