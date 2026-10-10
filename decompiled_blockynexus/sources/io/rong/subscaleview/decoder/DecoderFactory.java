package io.rong.subscaleview.decoder;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes5.dex */
public interface DecoderFactory<T> {
    T make() throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException;
}
