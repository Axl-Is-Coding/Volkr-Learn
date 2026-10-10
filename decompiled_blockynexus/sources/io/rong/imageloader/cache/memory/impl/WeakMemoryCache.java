package io.rong.imageloader.cache.memory.impl;

import android.graphics.Bitmap;
import io.rong.imageloader.cache.memory.BaseMemoryCache;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes5.dex */
public class WeakMemoryCache extends BaseMemoryCache {
    @Override // io.rong.imageloader.cache.memory.BaseMemoryCache
    protected Reference<Bitmap> createReference(Bitmap bitmap) {
        return new WeakReference(bitmap);
    }
}
