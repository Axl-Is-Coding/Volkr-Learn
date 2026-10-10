package com.google.common.collect;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: Platform.java */
/* JADX INFO: loaded from: classes2.dex */
final class ua {
    static <T> T[] a(T[] tArr, int i) {
        return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i));
    }

    static MapMaker a(MapMaker mapMaker) {
        mapMaker.k();
        return mapMaker;
    }
}
