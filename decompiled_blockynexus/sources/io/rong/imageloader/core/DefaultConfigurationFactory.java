package io.rong.imageloader.core;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import io.rong.imageloader.cache.disc.DiskCache;
import io.rong.imageloader.cache.disc.impl.UnlimitedDiskCache;
import io.rong.imageloader.cache.disc.impl.ext.LruDiskCache;
import io.rong.imageloader.cache.disc.naming.FileNameGenerator;
import io.rong.imageloader.cache.disc.naming.HashCodeFileNameGenerator;
import io.rong.imageloader.cache.memory.MemoryCache;
import io.rong.imageloader.cache.memory.impl.LruMemoryCache;
import io.rong.imageloader.core.assist.QueueProcessingType;
import io.rong.imageloader.core.assist.deque.LIFOLinkedBlockingDeque;
import io.rong.imageloader.core.decode.BaseImageDecoder;
import io.rong.imageloader.core.decode.ImageDecoder;
import io.rong.imageloader.core.display.BitmapDisplayer;
import io.rong.imageloader.core.display.SimpleBitmapDisplayer;
import io.rong.imageloader.core.download.BaseImageDownloader;
import io.rong.imageloader.core.download.ImageDownloader;
import io.rong.imageloader.utils.L;
import io.rong.imageloader.utils.StorageUtils;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultConfigurationFactory {

    private static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final String namePrefix;
        private final int threadPriority;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final ThreadGroup group = Thread.currentThread().getThreadGroup();

        DefaultThreadFactory(int i, String str) {
            this.threadPriority = i;
            this.namePrefix = str + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.threadPriority);
            return thread;
        }
    }

    public static BitmapDisplayer createBitmapDisplayer() {
        return new SimpleBitmapDisplayer();
    }

    public static DiskCache createDiskCache(Context context, FileNameGenerator fileNameGenerator, long j, int i) {
        File fileCreateReserveDiskCacheDir = createReserveDiskCacheDir(context);
        if (j > 0 || i > 0) {
            try {
                return new LruDiskCache(StorageUtils.getIndividualCacheDirectory(context), fileCreateReserveDiskCacheDir, fileNameGenerator, j, i);
            } catch (IOException e2) {
                L.e(e2);
            }
        }
        return new UnlimitedDiskCache(StorageUtils.getCacheDirectory(context), fileCreateReserveDiskCacheDir, fileNameGenerator);
    }

    public static Executor createExecutor(int i, int i2, QueueProcessingType queueProcessingType) {
        return new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, (BlockingQueue<Runnable>) (queueProcessingType == QueueProcessingType.LIFO ? new LIFOLinkedBlockingDeque() : new LinkedBlockingQueue()), createThreadFactory(i2, "uil-pool-"));
    }

    public static FileNameGenerator createFileNameGenerator() {
        return new HashCodeFileNameGenerator();
    }

    public static ImageDecoder createImageDecoder(boolean z) {
        return new BaseImageDecoder(z);
    }

    public static ImageDownloader createImageDownloader(Context context) {
        return new BaseImageDownloader(context);
    }

    public static MemoryCache createMemoryCache(Context context, int i) {
        if (i == 0) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                int memoryClass = activityManager.getMemoryClass();
                if (hasHoneycomb() && isLargeHeap(context)) {
                    memoryClass = getLargeMemoryClass(activityManager);
                }
                i = (memoryClass * 1048576) / 8;
            } else {
                i = 2097152;
            }
        }
        return new LruMemoryCache(i);
    }

    private static File createReserveDiskCacheDir(Context context) {
        File cacheDirectory = StorageUtils.getCacheDirectory(context, false);
        File file = new File(cacheDirectory, "uil-images");
        return (file.exists() || file.mkdir()) ? file : cacheDirectory;
    }

    public static Executor createTaskDistributor() {
        return Executors.newCachedThreadPool(createThreadFactory(5, "uil-pool-d-"));
    }

    private static ThreadFactory createThreadFactory(int i, String str) {
        return new DefaultThreadFactory(i, str);
    }

    @TargetApi(11)
    private static int getLargeMemoryClass(ActivityManager activityManager) {
        return activityManager.getLargeMemoryClass();
    }

    private static boolean hasHoneycomb() {
        return Build.VERSION.SDK_INT >= 11;
    }

    @TargetApi(11)
    private static boolean isLargeHeap(Context context) {
        return (context.getApplicationInfo().flags & 1048576) != 0;
    }

    private static File createReserveDiskCacheDir(String str) {
        File file = new File(str);
        File file2 = new File(file, "uil-images");
        return (file2.exists() || file2.mkdir()) ? file2 : file;
    }

    public static DiskCache createDiskCache(Context context, FileNameGenerator fileNameGenerator, long j, int i, String str) {
        File fileCreateReserveDiskCacheDir = createReserveDiskCacheDir(str);
        if (j > 0 || i > 0) {
            try {
                return new LruDiskCache(StorageUtils.getIndividualCacheDirectory(context), fileCreateReserveDiskCacheDir, fileNameGenerator, j, i);
            } catch (IOException e2) {
                L.e(e2);
            }
        }
        return new UnlimitedDiskCache(StorageUtils.getCacheDirectory(context), fileCreateReserveDiskCacheDir, fileNameGenerator);
    }
}
