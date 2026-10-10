package io.rong.subscaleview.decoder;

import android.graphics.Bitmap;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes5.dex */
public class CompatDecoderFactory<T> implements DecoderFactory<T> {
    private final Bitmap.Config bitmapConfig;
    private final Class<? extends T> clazz;

    public CompatDecoderFactory(Class<? extends T> cls) {
        this(cls, null);
    }

    @Override // io.rong.subscaleview.decoder.DecoderFactory
    public T make() throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        return this.bitmapConfig == null ? this.clazz.newInstance() : this.clazz.getConstructor(Bitmap.Config.class).newInstance(this.bitmapConfig);
    }

    public CompatDecoderFactory(Class<? extends T> cls, Bitmap.Config config) {
        this.clazz = cls;
        this.bitmapConfig = config;
    }
}
