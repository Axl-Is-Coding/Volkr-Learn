package com.tendcloud.tenddata;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public interface z {
    void afterMethodInvoked(Object obj, Method method, Object[] objArr, Object obj2);

    void beforeMethodInvoke(Object obj, Method method, Object[] objArr);
}
