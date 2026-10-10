package com.google.common.reflect;

import com.google.common.reflect.Types;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: Types.java */
/* JADX INFO: loaded from: classes2.dex */
class t implements com.google.common.base.f<Type, String> {
    t() {
    }

    @Override // com.google.common.base.f
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String apply(Type type) {
        return Types.JavaVersion.CURRENT.typeName(type);
    }
}
