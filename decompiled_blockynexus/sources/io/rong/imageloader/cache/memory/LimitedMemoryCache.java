package io.rong.imageloader.cache.memory;

import android.graphics.Bitmap;
import io.rong.imageloader.utils.L;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public abstract class LimitedMemoryCache extends BaseMemoryCache {
    private static final int MAX_NORMAL_CACHE_SIZE = 16777216;
    private static final int MAX_NORMAL_CACHE_SIZE_IN_MB = 16;
    private final int sizeLimit;
    private final List<Bitmap> hardCache = Collections.synchronizedList(new LinkedList());
    private final AtomicInteger cacheSize = new AtomicInteger();

    public LimitedMemoryCache(int i) {
        this.sizeLimit = i;
        if (i > MAX_NORMAL_CACHE_SIZE) {
            L.w("You set too large memory cache size (more than %1$d Mb)", 16);
        }
    }

    @Override // io.rong.imageloader.cache.memory.BaseMemoryCache, io.rong.imageloader.cache.memory.MemoryCache
    public void clear() {
        this.hardCache.clear();
        this.cacheSize.set(0);
        super.clear();
    }

    protected abstract int getSize(Bitmap bitmap);

    protected int getSizeLimit() {
        return this.sizeLimit;
    }

    @Override // io.rong.imageloader.cache.memory.BaseMemoryCache, io.rong.imageloader.cache.memory.MemoryCache
    public boolean put(String str, Bitmap bitmap) {
        boolean z;
        int size = getSize(bitmap);
        int sizeLimit = getSizeLimit();
        int iAddAndGet = this.cacheSize.get();
        if (size < sizeLimit) {
            while (iAddAndGet + size > sizeLimit) {
                Bitmap bitmapRemoveNext = removeNext();
                if (this.hardCache.remove(bitmapRemoveNext)) {
                    iAddAndGet = this.cacheSize.addAndGet(-getSize(bitmapRemoveNext));
                }
            }
            this.hardCache.add(bitmap);
            this.cacheSize.addAndGet(size);
            z = true;
        } else {
            z = false;
        }
        super.put(str, bitmap);
        return z;
    }

    @Override // io.rong.imageloader.cache.memory.BaseMemoryCache, io.rong.imageloader.cache.memory.MemoryCache
    public Bitmap remove(String str) {
        Bitmap bitmap = super.get(str);
        if (bitmap != null && this.hardCache.remove(bitmap)) {
            this.cacheSize.addAndGet(-getSize(bitmap));
        }
        return super.remove(str);
    }

    protected abstract Bitmap removeNext();
}
