package io.rong.imageloader.cache.memory.impl;

import android.graphics.Bitmap;
import io.rong.imageloader.cache.memory.MemoryCache;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class FuzzyKeyMemoryCache implements MemoryCache {
    private final MemoryCache cache;
    private final Comparator<String> keyComparator;

    public FuzzyKeyMemoryCache(MemoryCache memoryCache, Comparator<String> comparator) {
        this.cache = memoryCache;
        this.keyComparator = comparator;
    }

    @Override // io.rong.imageloader.cache.memory.MemoryCache
    public void clear() {
        this.cache.clear();
    }

    @Override // io.rong.imageloader.cache.memory.MemoryCache
    public Bitmap get(String str) {
        return this.cache.get(str);
    }

    @Override // io.rong.imageloader.cache.memory.MemoryCache
    public Collection<String> keys() {
        return this.cache.keys();
    }

    @Override // io.rong.imageloader.cache.memory.MemoryCache
    public boolean put(String str, Bitmap bitmap) {
        synchronized (this.cache) {
            String str2 = null;
            Iterator<String> it = this.cache.keys().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (this.keyComparator.compare(str, next) == 0) {
                    str2 = next;
                    break;
                }
            }
            if (str2 != null) {
                this.cache.remove(str2);
            }
        }
        return this.cache.put(str, bitmap);
    }

    @Override // io.rong.imageloader.cache.memory.MemoryCache
    public Bitmap remove(String str) {
        return this.cache.remove(str);
    }
}
