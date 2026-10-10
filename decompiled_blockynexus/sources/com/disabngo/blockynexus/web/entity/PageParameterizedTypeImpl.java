package com.disabngo.blockynexus.web.entity;

import com.sandboxol.common.widget.rv.pagerv.PageData;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
public class PageParameterizedTypeImpl implements ParameterizedType {
    private Class clazz;

    public PageParameterizedTypeImpl(Class cls) {
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
        return PageData.class;
    }
}
