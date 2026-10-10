package com.google.common.reflect;

import com.google.common.reflect.TypeToken;

/* JADX INFO: compiled from: TypeToken.java */
/* JADX INFO: loaded from: classes2.dex */
class n implements com.google.common.base.n<Class<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ TypeToken.InterfaceSet f14013a;

    n(TypeToken.InterfaceSet interfaceSet) {
        this.f14013a = interfaceSet;
    }

    @Override // com.google.common.base.n
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean apply(Class<?> cls) {
        return cls.isInterface();
    }
}
