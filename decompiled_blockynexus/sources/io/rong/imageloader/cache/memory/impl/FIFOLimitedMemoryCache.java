package io.rong.imageloader.cache.memory.impl;

import android.graphics.Bitmap;
import io.rong.imageloader.cache.memory.LimitedMemoryCache;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class FIFOLimitedMemoryCache extends LimitedMemoryCache {
    private final List<Bitmap> queue;

    public FIFOLimitedMemoryCache(int i) {
        super(i);
        this.queue = Collections.synchronizedList(new LinkedList());
    }

    @Override // io.rong.imageloader.cache.memory.LimitedMemoryCache, io.rong.imageloader.cache.memory.BaseMemoryCache, io.rong.imageloader.cache.memory.MemoryCache
    public void clear() {
        this.queue.clear();
        super.clear();
    }

    @Override // io.rong.imageloader.cache.memory.BaseMemoryCache
    protected Reference<Bitmap> createReference(Bitmap bitmap) {
        return new WeakReference(bitmap);
    }

    @Override // io.rong.imageloader.cache.memory.LimitedMemoryCache
    protected int getSize(Bitmap bitmap) {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    @Override // io.rong.imageloader.cache.memory.LimitedMemoryCache, io.rong.imageloader.cache.memory.BaseMemoryCache, io.rong.imageloader.cache.memory.MemoryCache
    public boolean put(String str, Bitmap bitmap) {
        if (!super.put(str, bitmap)) {
            return false;
        }
        this.queue.add(bitmap);
        return true;
    }

    @Override // io.rong.imageloader.cache.memory.LimitedMemoryCache, io.rong.imageloader.cache.memory.BaseMemoryCache, io.rong.imageloader.cache.memory.MemoryCache
    public Bitmap remove(String str) {
        Bitmap bitmap = super.get(str);
        if (bitmap != null) {
            this.queue.remove(bitmap);
        }
        return super.remove(str);
    }

    @Override // io.rong.imageloader.cache.memory.LimitedMemoryCache
    protected Bitmap removeNext() {
        return this.queue.remove(0);
    }
}
