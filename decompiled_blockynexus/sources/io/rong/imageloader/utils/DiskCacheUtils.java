package io.rong.imageloader.utils;

import io.rong.imageloader.cache.disc.DiskCache;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public final class DiskCacheUtils {
    private DiskCacheUtils() {
    }

    public static File findInCache(String str, DiskCache diskCache) {
        File file = diskCache.get(str);
        if (file == null || !file.exists()) {
            return null;
        }
        return file;
    }

    public static boolean removeFromCache(String str, DiskCache diskCache) {
        File file = diskCache.get(str);
        return file != null && file.exists() && file.delete();
    }
}
