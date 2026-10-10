package io.rong.imkit.plugin.image;

import a.a.g;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.WindowManager;
import io.rong.common.FileUtils;
import io.rong.common.RLog;
import io.rong.imkit.utilities.KitStorageUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class AlbumBitmapCacheHelper {
    private static final String TAG = "AlbumBitmapCacheHelper";
    private static int cacheSize;
    private static volatile AlbumBitmapCacheHelper instance;
    private Context mContext;
    ThreadPoolExecutor tpe = new ThreadPoolExecutor(2, 5, 10, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private g<String, Bitmap> cache = new g<String, Bitmap>(cacheSize) { // from class: io.rong.imkit.plugin.image.AlbumBitmapCacheHelper.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // a.a.g
        public int sizeOf(String str, Bitmap bitmap) {
            int i = Build.VERSION.SDK_INT;
            return i >= 19 ? bitmap.getAllocationByteCount() : i >= 12 ? bitmap.getByteCount() : bitmap.getRowBytes() * bitmap.getHeight();
        }
    };
    private ArrayList<String> currentShowString = new ArrayList<>();

    public interface ILoadImageCallback {
        void onLoadImageCallBack(Bitmap bitmap, String str, Object... objArr);
    }

    private AlbumBitmapCacheHelper() {
    }

    private static int calculateMemoryCacheSize(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        boolean z = (context.getApplicationInfo().flags & 1048576) != 0;
        int memoryClass = activityManager.getMemoryClass();
        if (z) {
            memoryClass = activityManager.getLargeMemoryClass();
        }
        return (int) ((((long) memoryClass) * 1048576) / 8);
    }

    public static Bitmap centerSquareScaleBitmap(Bitmap bitmap, int i) {
        if (bitmap == null || i <= 0) {
            return null;
        }
        int width = (bitmap.getWidth() - i) / 2;
        int height = (bitmap.getHeight() - i) / 2;
        if (width == 0 && height == 0) {
            return bitmap;
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, width, height, i, i);
            try {
                if (!bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                return bitmapCreateBitmap;
            } catch (OutOfMemoryError unused) {
                return bitmapCreateBitmap;
            }
        } catch (OutOfMemoryError unused2) {
            return bitmap;
        }
    }

    private void clearCache() {
        this.cache.evictAll();
        this.cache = null;
        this.tpe = null;
        instance = null;
    }

    private int computeScale(BitmapFactory.Options options, int i, int i2) {
        if (options == null) {
            return 1;
        }
        int i3 = (int) (options.outWidth / i);
        int i4 = (int) (options.outHeight / i2);
        if (i3 > i4) {
            i4 = i3;
        }
        if (i4 < 1) {
            return 1;
        }
        return i4;
    }

    private void decodeBitmapFromPath(final String str, final int i, final int i2, final ILoadImageCallback iLoadImageCallback, final Object... objArr) throws OutOfMemoryError {
        final Handler handler = new Handler() { // from class: io.rong.imkit.plugin.image.AlbumBitmapCacheHelper.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                ILoadImageCallback iLoadImageCallback2 = iLoadImageCallback;
                if (iLoadImageCallback2 != null) {
                    iLoadImageCallback2.onLoadImageCallBack((Bitmap) message.obj, str, objArr);
                }
            }
        };
        this.tpe.execute(new Runnable() { // from class: io.rong.imkit.plugin.image.AlbumBitmapCacheHelper.3
            /* JADX WARN: Removed duplicated region for block: B:78:0x0166  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() throws java.lang.Throwable {
                /*
                    Method dump skipped, instruction units count: 417
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: io.rong.imkit.plugin.image.AlbumBitmapCacheHelper.AnonymousClass3.run():void");
            }
        });
    }

    private Bitmap getBitmapFromCache(String str, int i, int i2) {
        return this.cache.get(str + "_" + i + "_" + i2);
    }

    public static AlbumBitmapCacheHelper getInstance() {
        if (instance == null) {
            synchronized (AlbumBitmapCacheHelper.class) {
                if (instance == null) {
                    instance = new AlbumBitmapCacheHelper();
                }
            }
        }
        return instance;
    }

    public static void init(Context context) {
        RLog.d(TAG, "init");
        cacheSize = calculateMemoryCacheSize(context);
        getInstance().mContext = context.getApplicationContext();
    }

    public void addPathToShowlist(String str) {
        this.currentShowString.add(str);
    }

    public Bitmap getBitmap(String str, int i, int i2, ILoadImageCallback iLoadImageCallback, Object... objArr) {
        Bitmap bitmapFromCache = getBitmapFromCache(str, i, i2);
        if (bitmapFromCache != null) {
            Log.e(TAG, "getBitmap from cache");
        } else {
            decodeBitmapFromPath(str, i, i2, iLoadImageCallback, objArr);
        }
        return bitmapFromCache;
    }

    public void releaseAllSizeCache() {
        this.cache.evictAll();
        this.cache.resize(1);
    }

    public void releaseHalfSizeCache() {
        this.cache.resize((int) ((Runtime.getRuntime().maxMemory() / 1024) / 8));
    }

    public void removePathFromShowlist(String str) {
        this.currentShowString.remove(str);
    }

    public void resizeCache() {
        this.cache.resize((int) ((Runtime.getRuntime().maxMemory() / 1024) / 4));
    }

    public void uninit() {
        RLog.d(TAG, "uninit");
        this.tpe.shutdownNow();
        clearCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public Bitmap getBitmap(String str, int i, int i2) throws OutOfMemoryError {
        ?? r6;
        ?? r2;
        ExifInterface exifInterface;
        int i3;
        int i4;
        int i5;
        int iComputeScale;
        int i6;
        BitmapFactory.Options options;
        Bitmap bitmapDecodeFile;
        try {
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inJustDecodeBounds = true;
            options2.inPreferredConfig = Bitmap.Config.RGB_565;
            if (KitStorageUtils.isBuildAndTargetForQ(this.mContext)) {
                try {
                    if (!FileUtils.uriStartWithContent(Uri.parse(str))) {
                        exifInterface = new ExifInterface(str);
                    } else {
                        exifInterface = new ExifInterface(this.mContext.getContentResolver().openFileDescriptor(Uri.parse(str), "r").getFileDescriptor());
                    }
                } catch (IOException e2) {
                    e = e2;
                    r2 = 0;
                    RLog.e(TAG, "getBitmap", e);
                    return r2;
                } catch (IllegalArgumentException e3) {
                    e = e3;
                    r2 = 0;
                    RLog.e(TAG, "getBitmap", e);
                    return r2;
                }
            } else {
                exifInterface = new ExifInterface(str);
            }
            int attributeInt = exifInterface.getAttributeInt("Orientation", 0);
            if (i == 0 && i2 == 0) {
                iComputeScale = computeScale(options2, ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth(), ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getHeight());
                RLog.d(TAG, "sampleSize:" + iComputeScale);
                i5 = i;
                i6 = i2;
            } else {
                if (attributeInt == 6 || attributeInt == 8 || attributeInt == 5 || attributeInt == 7) {
                    i3 = i;
                    i4 = i2;
                } else {
                    i4 = i;
                    i3 = i2;
                }
                int iComputeScale2 = computeScale(options2, i4, i3);
                RLog.d(TAG, "sampleSize:" + iComputeScale2);
                int i7 = i3;
                i5 = i4;
                iComputeScale = iComputeScale2;
                i6 = i7;
            }
            try {
                options = new BitmapFactory.Options();
                try {
                    options.inJustDecodeBounds = false;
                    options.inSampleSize = iComputeScale;
                    if (!KitStorageUtils.isBuildAndTargetForQ(this.mContext) || !FileUtils.uriStartWithContent(Uri.parse(str))) {
                        bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
                    } else {
                        bitmapDecodeFile = BitmapFactory.decodeFileDescriptor(this.mContext.getContentResolver().openFileDescriptor(Uri.parse(str), "r").getFileDescriptor(), null, options);
                    }
                } catch (OutOfMemoryError e4) {
                    e = e4;
                    RLog.e(TAG, "getBitmap", e);
                    r6 = 1;
                    r6 = 1;
                    options.inSampleSize <<= 1;
                    try {
                    } catch (IOException e5) {
                        e = e5;
                        r2 = r6;
                        RLog.e(TAG, "getBitmap", e);
                        return r2;
                    } catch (IllegalArgumentException e6) {
                        e = e6;
                        r2 = r6;
                        RLog.e(TAG, "getBitmap", e);
                        return r2;
                    }
                    if (KitStorageUtils.isBuildAndTargetForQ(this.mContext)) {
                        if (str.startsWith(KitStorageUtils.getImageSavePath(this.mContext))) {
                            bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
                        } else {
                            r6 = 0;
                            bitmapDecodeFile = BitmapFactory.decodeFileDescriptor(this.mContext.getContentResolver().openFileDescriptor(Uri.parse(str), "r").getFileDescriptor(), null, options);
                        }
                        r2 = r6;
                        RLog.e(TAG, "getBitmap", e);
                        return r2;
                    }
                    r6 = 0;
                    bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
                }
            } catch (OutOfMemoryError e7) {
                e = e7;
                options = options2;
            }
            r2 = bitmapDecodeFile;
            try {
                Matrix matrix = new Matrix();
                if (r2 == 0) {
                    return r2;
                }
                int width = r2.getWidth();
                int height = r2.getHeight();
                if (attributeInt == 6 || attributeInt == 8 || attributeInt == 5 || attributeInt == 7) {
                    height = width;
                    width = height;
                }
                switch (attributeInt) {
                    case 2:
                        matrix.preScale(-1.0f, 1.0f);
                        break;
                    case 3:
                        matrix.setRotate(180.0f, width / 2.0f, height / 2.0f);
                        break;
                    case 4:
                        matrix.preScale(1.0f, -1.0f);
                        break;
                    case 5:
                        matrix.setRotate(90.0f, width / 2.0f, height / 2.0f);
                        matrix.preScale(1.0f, -1.0f);
                        break;
                    case 6:
                        matrix.setRotate(90.0f, width / 2.0f, height / 2.0f);
                        break;
                    case 7:
                        matrix.setRotate(270.0f, width / 2.0f, height / 2.0f);
                        matrix.preScale(1.0f, -1.0f);
                        break;
                    case 8:
                        matrix.setRotate(270.0f, width / 2.0f, height / 2.0f);
                        break;
                }
                if (i5 != 0 && i6 != 0) {
                    float width2 = i5 / r2.getWidth();
                    float height2 = i6 / r2.getHeight();
                    matrix.postScale(Math.min(width2, height2), Math.min(width2, height2));
                } else {
                    RLog.e(TAG, "widthLimit or heightLimit is 0");
                }
                return Bitmap.createBitmap((Bitmap) r2, 0, 0, r2.getWidth(), r2.getHeight(), matrix, true);
            } catch (IOException e8) {
                e = e8;
                RLog.e(TAG, "getBitmap", e);
                return r2;
            } catch (IllegalArgumentException e9) {
                e = e9;
                RLog.e(TAG, "getBitmap", e);
                return r2;
            }
        } catch (IOException e10) {
            e = e10;
            r6 = 0;
        } catch (IllegalArgumentException e11) {
            e = e11;
            r6 = 0;
        }
    }
}
