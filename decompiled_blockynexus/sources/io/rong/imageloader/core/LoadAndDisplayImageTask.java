package io.rong.imageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import io.rong.imageloader.core.DisplayImageOptions;
import io.rong.imageloader.core.assist.FailReason;
import io.rong.imageloader.core.assist.ImageScaleType;
import io.rong.imageloader.core.assist.ImageSize;
import io.rong.imageloader.core.assist.LoadedFrom;
import io.rong.imageloader.core.assist.ViewScaleType;
import io.rong.imageloader.core.decode.ImageDecoder;
import io.rong.imageloader.core.decode.ImageDecodingInfo;
import io.rong.imageloader.core.download.ImageDownloader;
import io.rong.imageloader.core.imageaware.ImageAware;
import io.rong.imageloader.core.listener.ImageLoadingListener;
import io.rong.imageloader.core.listener.ImageLoadingProgressListener;
import io.rong.imageloader.utils.IoUtils;
import io.rong.imageloader.utils.L;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes5.dex */
final class LoadAndDisplayImageTask implements IoUtils.CopyListener, Runnable {
    private static final String ERROR_NO_IMAGE_STREAM = "No stream for image [%s]";
    private static final String ERROR_POST_PROCESSOR_NULL = "Post-processor returned null [%s]";
    private static final String ERROR_PRE_PROCESSOR_NULL = "Pre-processor returned null [%s]";
    private static final String ERROR_PROCESSOR_FOR_DISK_CACHE_NULL = "Bitmap processor for disk cache returned null [%s]";
    private static final String LOG_CACHE_IMAGE_IN_MEMORY = "Cache image in memory [%s]";
    private static final String LOG_CACHE_IMAGE_ON_DISK = "Cache image on disk [%s]";
    private static final String LOG_DELAY_BEFORE_LOADING = "Delay %d ms before loading...  [%s]";
    private static final String LOG_GET_IMAGE_FROM_MEMORY_CACHE_AFTER_WAITING = "...Get cached bitmap from memory after waiting. [%s]";
    private static final String LOG_LOAD_IMAGE_FROM_DISK_CACHE = "Load image from disk cache [%s]";
    private static final String LOG_LOAD_IMAGE_FROM_NETWORK = "Load image from network [%s]";
    private static final String LOG_POSTPROCESS_IMAGE = "PostProcess image before displaying [%s]";
    private static final String LOG_PREPROCESS_IMAGE = "PreProcess image before caching in memory [%s]";
    private static final String LOG_PROCESS_IMAGE_BEFORE_CACHE_ON_DISK = "Process image before cache on disk [%s]";
    private static final String LOG_RESIZE_CACHED_IMAGE_FILE = "Resize image in disk cache [%s]";
    private static final String LOG_RESUME_AFTER_PAUSE = ".. Resume loading [%s]";
    private static final String LOG_START_DISPLAY_IMAGE_TASK = "Start display image task [%s]";
    private static final String LOG_TASK_CANCELLED_IMAGEAWARE_COLLECTED = "ImageAware was collected by GC. Task is cancelled. [%s]";
    private static final String LOG_TASK_CANCELLED_IMAGEAWARE_REUSED = "ImageAware is reused for another image. Task is cancelled. [%s]";
    private static final String LOG_TASK_INTERRUPTED = "Task was interrupted [%s]";
    private static final String LOG_WAITING_FOR_IMAGE_LOADED = "Image already is loading. Waiting... [%s]";
    private static final String LOG_WAITING_FOR_RESUME = "ImageLoader is paused. Waiting...  [%s]";
    private final ImageLoaderConfiguration configuration;
    private final ImageDecoder decoder;
    private final ImageDownloader downloader;
    private final ImageLoaderEngine engine;
    private final Handler handler;
    final ImageAware imageAware;
    private final ImageLoadingInfo imageLoadingInfo;
    final ImageLoadingListener listener;
    private LoadedFrom loadedFrom = LoadedFrom.NETWORK;
    private final String memoryCacheKey;
    private final ImageDownloader networkDeniedDownloader;
    final DisplayImageOptions options;
    final ImageLoadingProgressListener progressListener;
    private final ImageDownloader slowNetworkDownloader;
    private final boolean syncLoading;
    private final ImageSize targetSize;
    final String uri;

    class TaskCancelledException extends Exception {
        TaskCancelledException() {
        }
    }

    public LoadAndDisplayImageTask(ImageLoaderEngine imageLoaderEngine, ImageLoadingInfo imageLoadingInfo, Handler handler) {
        this.engine = imageLoaderEngine;
        this.imageLoadingInfo = imageLoadingInfo;
        this.handler = handler;
        this.configuration = imageLoaderEngine.configuration;
        ImageLoaderConfiguration imageLoaderConfiguration = this.configuration;
        this.downloader = imageLoaderConfiguration.downloader;
        this.networkDeniedDownloader = imageLoaderConfiguration.networkDeniedDownloader;
        this.slowNetworkDownloader = imageLoaderConfiguration.slowNetworkDownloader;
        this.decoder = imageLoaderConfiguration.decoder;
        this.uri = imageLoadingInfo.uri;
        this.memoryCacheKey = imageLoadingInfo.memoryCacheKey;
        this.imageAware = imageLoadingInfo.imageAware;
        this.targetSize = imageLoadingInfo.targetSize;
        this.options = imageLoadingInfo.options;
        this.listener = imageLoadingInfo.listener;
        this.progressListener = imageLoadingInfo.progressListener;
        this.syncLoading = this.options.isSyncLoading();
    }

    private void checkTaskInterrupted() throws TaskCancelledException {
        if (isTaskInterrupted()) {
            throw new TaskCancelledException();
        }
    }

    private void checkTaskNotActual() throws TaskCancelledException {
        checkViewCollected();
        checkViewReused();
    }

    private void checkViewCollected() throws TaskCancelledException {
        if (isViewCollected()) {
            throw new TaskCancelledException();
        }
    }

    private void checkViewReused() throws TaskCancelledException {
        if (isViewReused()) {
            throw new TaskCancelledException();
        }
    }

    private Bitmap decodeImage(String str) throws IOException {
        return this.decoder.decode(new ImageDecodingInfo(this.memoryCacheKey, str, this.uri, this.targetSize, this.imageAware.getScaleType(), getDownloader(), this.options));
    }

    private boolean delayIfNeed() {
        if (!this.options.shouldDelayBeforeLoading()) {
            return false;
        }
        L.d(LOG_DELAY_BEFORE_LOADING, Integer.valueOf(this.options.getDelayBeforeLoading()), this.memoryCacheKey);
        try {
            Thread.sleep(this.options.getDelayBeforeLoading());
            return isTaskNotActual();
        } catch (InterruptedException unused) {
            L.e(LOG_TASK_INTERRUPTED, this.memoryCacheKey);
            return true;
        }
    }

    private boolean downloadImage() throws IOException {
        InputStream stream = getDownloader().getStream(this.uri, this.options.getExtraForDownloader());
        if (stream == null) {
            L.e(ERROR_NO_IMAGE_STREAM, this.memoryCacheKey);
            return false;
        }
        try {
            return this.configuration.diskCache.save(this.uri, stream, this);
        } finally {
            IoUtils.closeSilently(stream);
        }
    }

    private void fireCancelEvent() {
        if (this.syncLoading || isTaskInterrupted()) {
            return;
        }
        runTask(new Runnable() { // from class: io.rong.imageloader.core.LoadAndDisplayImageTask.3
            @Override // java.lang.Runnable
            public void run() {
                LoadAndDisplayImageTask loadAndDisplayImageTask = LoadAndDisplayImageTask.this;
                loadAndDisplayImageTask.listener.onLoadingCancelled(loadAndDisplayImageTask.uri, loadAndDisplayImageTask.imageAware.getWrappedView());
            }
        }, false, this.handler, this.engine);
    }

    private void fireFailEvent(final FailReason.FailType failType, final Throwable th) {
        if (this.syncLoading || isTaskInterrupted() || isTaskNotActual()) {
            return;
        }
        runTask(new Runnable() { // from class: io.rong.imageloader.core.LoadAndDisplayImageTask.2
            @Override // java.lang.Runnable
            public void run() {
                if (LoadAndDisplayImageTask.this.options.shouldShowImageOnFail()) {
                    if (LoadAndDisplayImageTask.this.options.getDisplayer() != null) {
                        LoadAndDisplayImageTask loadAndDisplayImageTask = LoadAndDisplayImageTask.this;
                        DisplayImageOptions displayImageOptions = loadAndDisplayImageTask.options;
                        Bitmap bitmapDrawableToBitmap = displayImageOptions.drawableToBitmap(displayImageOptions.getImageOnFail(loadAndDisplayImageTask.configuration.resources));
                        if (bitmapDrawableToBitmap != null) {
                            LoadAndDisplayImageTask.this.options.getDisplayer().display(bitmapDrawableToBitmap, LoadAndDisplayImageTask.this.imageAware, LoadedFrom.DISC_CACHE);
                        }
                    } else {
                        LoadAndDisplayImageTask loadAndDisplayImageTask2 = LoadAndDisplayImageTask.this;
                        loadAndDisplayImageTask2.imageAware.setImageDrawable(loadAndDisplayImageTask2.options.getImageOnFail(loadAndDisplayImageTask2.configuration.resources));
                    }
                }
                LoadAndDisplayImageTask loadAndDisplayImageTask3 = LoadAndDisplayImageTask.this;
                loadAndDisplayImageTask3.listener.onLoadingFailed(loadAndDisplayImageTask3.uri, loadAndDisplayImageTask3.imageAware.getWrappedView(), new FailReason(failType, th));
            }
        }, false, this.handler, this.engine);
    }

    private boolean fireProgressEvent(final int i, final int i2) {
        if (isTaskInterrupted() || isTaskNotActual()) {
            return false;
        }
        if (this.progressListener == null) {
            return true;
        }
        runTask(new Runnable() { // from class: io.rong.imageloader.core.LoadAndDisplayImageTask.1
            @Override // java.lang.Runnable
            public void run() {
                LoadAndDisplayImageTask loadAndDisplayImageTask = LoadAndDisplayImageTask.this;
                loadAndDisplayImageTask.progressListener.onProgressUpdate(loadAndDisplayImageTask.uri, loadAndDisplayImageTask.imageAware.getWrappedView(), i, i2);
            }
        }, false, this.handler, this.engine);
        return true;
    }

    private ImageDownloader getDownloader() {
        return this.engine.isNetworkDenied() ? this.networkDeniedDownloader : this.engine.isSlowNetwork() ? this.slowNetworkDownloader : this.downloader;
    }

    private boolean isTaskInterrupted() {
        if (!Thread.interrupted()) {
            return false;
        }
        L.d(LOG_TASK_INTERRUPTED, this.memoryCacheKey);
        return true;
    }

    private boolean isTaskNotActual() {
        return isViewCollected() || isViewReused();
    }

    private boolean isViewCollected() {
        if (!this.imageAware.isCollected()) {
            return false;
        }
        L.d(LOG_TASK_CANCELLED_IMAGEAWARE_COLLECTED, this.memoryCacheKey);
        return true;
    }

    private boolean isViewReused() {
        if (!(!this.memoryCacheKey.equals(this.engine.getLoadingUriForView(this.imageAware)))) {
            return false;
        }
        L.d(LOG_TASK_CANCELLED_IMAGEAWARE_REUSED, this.memoryCacheKey);
        return true;
    }

    private boolean resizeAndSaveImage(int i, int i2) throws IOException {
        File file = this.configuration.diskCache.get(this.uri);
        if (file == null || !file.exists()) {
            return false;
        }
        Bitmap bitmapDecode = this.decoder.decode(new ImageDecodingInfo(this.memoryCacheKey, ImageDownloader.Scheme.FILE.wrap(file.getAbsolutePath()), this.uri, new ImageSize(i, i2), ViewScaleType.FIT_INSIDE, getDownloader(), new DisplayImageOptions.Builder().cloneFrom(this.options).imageScaleType(ImageScaleType.IN_SAMPLE_INT).build()));
        if (bitmapDecode != null && this.configuration.processorForDiskCache != null) {
            L.d(LOG_PROCESS_IMAGE_BEFORE_CACHE_ON_DISK, this.memoryCacheKey);
            bitmapDecode = this.configuration.processorForDiskCache.process(bitmapDecode);
            if (bitmapDecode == null) {
                L.e(ERROR_PROCESSOR_FOR_DISK_CACHE_NULL, this.memoryCacheKey);
            }
        }
        if (bitmapDecode == null) {
            return false;
        }
        boolean zSave = this.configuration.diskCache.save(this.uri, bitmapDecode);
        bitmapDecode.recycle();
        return zSave;
    }

    static void runTask(Runnable runnable, boolean z, Handler handler, ImageLoaderEngine imageLoaderEngine) {
        if (z) {
            runnable.run();
        } else if (handler == null) {
            imageLoaderEngine.fireCallback(runnable);
        } else {
            handler.post(runnable);
        }
    }

    private boolean tryCacheImageOnDisk() throws TaskCancelledException {
        L.d(LOG_CACHE_IMAGE_ON_DISK, this.memoryCacheKey);
        try {
            boolean zDownloadImage = downloadImage();
            if (!zDownloadImage) {
                return zDownloadImage;
            }
            int i = this.configuration.maxImageWidthForDiskCache;
            int i2 = this.configuration.maxImageHeightForDiskCache;
            if (i <= 0 && i2 <= 0) {
                return zDownloadImage;
            }
            L.d(LOG_RESIZE_CACHED_IMAGE_FILE, this.memoryCacheKey);
            resizeAndSaveImage(i, i2);
            return zDownloadImage;
        } catch (IOException e2) {
            L.e(e2);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004f A[Catch: Throwable -> 0x009f, OutOfMemoryError -> 0x00a1, IOException -> 0x00a3, TaskCancelledException -> 0x00cc, IllegalStateException -> 0x00cf, TryCatch #4 {TaskCancelledException -> 0x00cc, blocks: (B:3:0x0001, B:5:0x000f, B:7:0x0015, B:9:0x001f, B:13:0x0043, B:15:0x0049, B:17:0x004f, B:19:0x0068, B:21:0x006e, B:23:0x007a, B:24:0x0084, B:26:0x008d, B:28:0x0093, B:30:0x0099), top: B:53:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.graphics.Bitmap tryLoadBitmap() throws io.rong.imageloader.core.LoadAndDisplayImageTask.TaskCancelledException {
        /*
            Method dump skipped, instruction units count: 213
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.imageloader.core.LoadAndDisplayImageTask.tryLoadBitmap():android.graphics.Bitmap");
    }

    private boolean waitIfPaused() {
        AtomicBoolean pause = this.engine.getPause();
        if (pause.get()) {
            synchronized (this.engine.getPauseLock()) {
                if (pause.get()) {
                    L.d(LOG_WAITING_FOR_RESUME, this.memoryCacheKey);
                    try {
                        this.engine.getPauseLock().wait();
                        L.d(LOG_RESUME_AFTER_PAUSE, this.memoryCacheKey);
                    } catch (InterruptedException unused) {
                        L.e(LOG_TASK_INTERRUPTED, this.memoryCacheKey);
                        return true;
                    }
                }
            }
        }
        return isTaskNotActual();
    }

    String getLoadingUri() {
        return this.uri;
    }

    @Override // io.rong.imageloader.utils.IoUtils.CopyListener
    public boolean onBytesCopied(int i, int i2) {
        return this.syncLoading || fireProgressEvent(i, i2);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (waitIfPaused() || delayIfNeed()) {
            return;
        }
        ReentrantLock reentrantLock = this.imageLoadingInfo.loadFromUriLock;
        L.d(LOG_START_DISPLAY_IMAGE_TASK, this.memoryCacheKey);
        if (reentrantLock.isLocked()) {
            L.d(LOG_WAITING_FOR_IMAGE_LOADED, this.memoryCacheKey);
        }
        reentrantLock.lock();
        try {
            checkTaskNotActual();
            Bitmap bitmapTryLoadBitmap = this.configuration.memoryCache.get(this.memoryCacheKey);
            if (bitmapTryLoadBitmap == null || bitmapTryLoadBitmap.isRecycled()) {
                bitmapTryLoadBitmap = tryLoadBitmap();
                if (bitmapTryLoadBitmap == null) {
                    return;
                }
                checkTaskNotActual();
                checkTaskInterrupted();
                if (this.options.shouldPreProcess()) {
                    L.d(LOG_PREPROCESS_IMAGE, this.memoryCacheKey);
                    bitmapTryLoadBitmap = this.options.getPreProcessor().process(bitmapTryLoadBitmap);
                    if (bitmapTryLoadBitmap == null) {
                        L.e(ERROR_PRE_PROCESSOR_NULL, this.memoryCacheKey);
                    }
                }
                if (bitmapTryLoadBitmap != null && this.options.isCacheInMemory()) {
                    L.d(LOG_CACHE_IMAGE_IN_MEMORY, this.memoryCacheKey);
                    this.configuration.memoryCache.put(this.memoryCacheKey, bitmapTryLoadBitmap);
                }
            } else {
                this.loadedFrom = LoadedFrom.MEMORY_CACHE;
                L.d(LOG_GET_IMAGE_FROM_MEMORY_CACHE_AFTER_WAITING, this.memoryCacheKey);
            }
            if (bitmapTryLoadBitmap != null && this.options.shouldPostProcess()) {
                L.d(LOG_POSTPROCESS_IMAGE, this.memoryCacheKey);
                bitmapTryLoadBitmap = this.options.getPostProcessor().process(bitmapTryLoadBitmap);
                if (bitmapTryLoadBitmap == null) {
                    L.e(ERROR_POST_PROCESSOR_NULL, this.memoryCacheKey);
                }
            }
            checkTaskNotActual();
            checkTaskInterrupted();
            reentrantLock.unlock();
            runTask(new DisplayBitmapTask(bitmapTryLoadBitmap, this.imageLoadingInfo, this.engine, this.loadedFrom), this.syncLoading, this.handler, this.engine);
        } catch (TaskCancelledException unused) {
            fireCancelEvent();
        } finally {
            reentrantLock.unlock();
        }
    }
}
