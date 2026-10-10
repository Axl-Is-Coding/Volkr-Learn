package com.google.common.reflect;

import com.google.common.reflect.TypeToken;

/* JADX INFO: compiled from: TypeToken.java */
/* JADX INFO: loaded from: classes2.dex */
class o extends TypeToken.b<TypeToken<?>> {
    o() {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.reflect.TypeToken.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Iterable<? extends TypeToken<?>> b(TypeToken<?> typeToken) {
        return typeToken.getGenericInterfaces();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.reflect.TypeToken.b
    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public Class<?> c(TypeToken<?> typeToken) {
        return typeToken.getRawType();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.reflect.TypeToken.b
    /* JADX INFO: renamed from: c, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public TypeToken<?> d(TypeToken<?> typeToken) {
        return typeToken.getGenericSuperclass();
    }
}
