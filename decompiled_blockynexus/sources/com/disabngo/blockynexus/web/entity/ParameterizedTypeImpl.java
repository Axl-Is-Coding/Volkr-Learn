package com.disabngo.blockynexus.web.entity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ParameterizedTypeImpl implements ParameterizedType {
    private Class clazz;

    public ParameterizedTypeImpl(Class cls) {
        this.clazz = cls;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return new Type[]{this.clazz};
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return null;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return List.class;
    }
}
