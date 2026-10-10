package com.google.common.reflect;

import com.google.common.reflect.TypeToken;
import java.util.Arrays;

/* JADX INFO: compiled from: TypeToken.java */
/* JADX INFO: loaded from: classes2.dex */
class p extends TypeToken.b<Class<?>> {
    p() {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.reflect.TypeToken.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Iterable<? extends Class<?>> b(Class<?> cls) {
        return Arrays.asList(cls.getInterfaces());
    }

    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
    Class<?> b2(Class<?> cls) {
        return cls;
    }

    @Override // com.google.common.reflect.TypeToken.b
    /* bridge */ /* synthetic */ Class c(Class<?> cls) {
        Class<?> cls2 = cls;
        b2(cls2);
        return cls2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.reflect.TypeToken.b
    /* JADX INFO: renamed from: c, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public Class<?> d(Class<?> cls) {
        return cls.getSuperclass();
    }
}
