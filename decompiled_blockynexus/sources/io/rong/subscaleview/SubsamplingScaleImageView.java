package io.rong.subscaleview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import cn.qqtheme.framework.widget.WheelView;
import io.rong.subscaleview.decoder.CompatDecoderFactory;
import io.rong.subscaleview.decoder.DecoderFactory;
import io.rong.subscaleview.decoder.ImageDecoder;
import io.rong.subscaleview.decoder.ImageRegionDecoder;
import io.rong.subscaleview.decoder.SkiaImageDecoder;
import io.rong.subscaleview.decoder.SkiaImageRegionDecoder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes5.dex */
public class SubsamplingScaleImageView extends View {
    public static final int EASE_IN_OUT_QUAD = 2;
    public static final int EASE_OUT_QUAD = 1;
    private static final int MESSAGE_LONG_CLICK = 1;
    public static final int ORIENTATION_0 = 0;
    public static final int ORIENTATION_180 = 180;
    public static final int ORIENTATION_270 = 270;
    public static final int ORIENTATION_90 = 90;
    public static final int ORIENTATION_USE_EXIF = -1;
    public static final int ORIGIN_ANIM = 1;
    public static final int ORIGIN_DOUBLE_TAP_ZOOM = 4;
    public static final int ORIGIN_FLING = 3;
    public static final int ORIGIN_TOUCH = 2;
    public static final int PAN_LIMIT_CENTER = 3;
    public static final int PAN_LIMIT_INSIDE = 1;
    public static final int PAN_LIMIT_OUTSIDE = 2;
    public static final int SCALE_TYPE_CENTER_CROP = 2;
    public static final int SCALE_TYPE_CENTER_INSIDE = 1;
    public static final int SCALE_TYPE_CUSTOM = 3;
    public static final int SCALE_TYPE_START = 4;
    private static final String TAG = "SubsamplingScaleImageView";
    public static final int TILE_SIZE_AUTO = Integer.MAX_VALUE;
    public static final int ZOOM_FOCUS_CENTER = 2;
    public static final int ZOOM_FOCUS_CENTER_IMMEDIATE = 3;
    public static final int ZOOM_FOCUS_FIXED = 1;
    private static Bitmap.Config preferredBitmapConfig;
    private Anim anim;
    private Bitmap bitmap;
    private DecoderFactory<? extends ImageDecoder> bitmapDecoderFactory;
    private boolean bitmapIsCached;
    private boolean bitmapIsPreview;
    private Paint bitmapPaint;
    private boolean debug;
    private Paint debugLinePaint;
    private Paint debugTextPaint;
    private ImageRegionDecoder decoder;
    private final ReadWriteLock decoderLock;
    private final float density;
    private GestureDetector detector;
    private int doubleTapZoomDuration;
    private float doubleTapZoomScale;
    private int doubleTapZoomStyle;
    private final float[] dstArray;
    private boolean eagerLoadingEnabled;
    private Executor executor;
    private int fullImageSampleSize;
    private final Handler handler;
    private boolean imageLoadedSent;
    private boolean isPanning;
    private boolean isQuickScaling;
    private boolean isZooming;
    private Matrix matrix;
    private float maxScale;
    private int maxTileHeight;
    private int maxTileWidth;
    private int maxTouchCount;
    private float minScale;
    private int minimumScaleType;
    private int minimumTileDpi;
    private OnImageEventListener onImageEventListener;
    private View.OnLongClickListener onLongClickListener;
    private OnStateChangedListener onStateChangedListener;
    private int orientation;
    private Rect pRegion;
    private boolean panEnabled;
    private int panLimit;
    private Float pendingScale;
    private boolean quickScaleEnabled;
    private float quickScaleLastDistance;
    private boolean quickScaleMoved;
    private PointF quickScaleSCenter;
    private final float quickScaleThreshold;
    private PointF quickScaleVLastPoint;
    private PointF quickScaleVStart;
    private boolean readySent;
    private DecoderFactory<? extends ImageRegionDecoder> regionDecoderFactory;
    private int sHeight;
    private int sOrientation;
    private PointF sPendingCenter;
    private RectF sRect;
    private Rect sRegion;
    private PointF sRequestedCenter;
    private int sWidth;
    private ScaleAndTranslate satTemp;
    private float scale;
    private float scaleStart;
    private GestureDetector singleDetector;
    private final float[] srcArray;
    private Paint tileBgPaint;
    private Map<Integer, List<Tile>> tileMap;
    private Uri uri;
    private PointF vCenterStart;
    private float vDistStart;
    private PointF vTranslate;
    private PointF vTranslateBefore;
    private PointF vTranslateStart;
    private boolean zoomEnabled;
    private static final List<Integer> VALID_ORIENTATIONS = Arrays.asList(0, 90, 180, 270, -1);
    private static final List<Integer> VALID_ZOOM_STYLES = Arrays.asList(1, 2, 3);
    private static final List<Integer> VALID_EASING_STYLES = Arrays.asList(2, 1);
    private static final List<Integer> VALID_PAN_LIMITS = Arrays.asList(1, 2, 3);
    private static final List<Integer> VALID_SCALE_TYPES = Arrays.asList(2, 1, 3, 4);

    private static class Anim {
        private long duration;
        private int easing;
        private boolean interruptible;
        private OnAnimationEventListener listener;
        private int origin;
        private PointF sCenterEnd;
        private PointF sCenterEndRequested;
        private PointF sCenterStart;
        private float scaleEnd;
        private float scaleStart;
        private long time;
        private PointF vFocusEnd;
        private PointF vFocusStart;

        private Anim() {
            this.duration = 500L;
            this.interruptible = true;
            this.easing = 2;
            this.origin = 1;
            this.time = System.currentTimeMillis();
        }
    }

    private static class BitmapLoadTask extends AsyncTask<Void, Void, Integer> {
        private Bitmap bitmap;
        private final WeakReference<Context> contextRef;
        private final WeakReference<DecoderFactory<? extends ImageDecoder>> decoderFactoryRef;
        private Exception exception;
        private final boolean preview;
        private final Uri source;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        BitmapLoadTask(SubsamplingScaleImageView subsamplingScaleImageView, Context context, DecoderFactory<? extends ImageDecoder> decoderFactory, Uri uri, boolean z) {
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.contextRef = new WeakReference<>(context);
            this.decoderFactoryRef = new WeakReference<>(decoderFactory);
            this.source = uri;
            this.preview = z;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Integer doInBackground(Void... voidArr) {
            try {
                String string = this.source.toString();
                Context context = this.contextRef.get();
                DecoderFactory<? extends ImageDecoder> decoderFactory = this.decoderFactoryRef.get();
                SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
                if (context == null || decoderFactory == null || subsamplingScaleImageView == null) {
                    return null;
                }
                subsamplingScaleImageView.debug("BitmapLoadTask.doInBackground", new Object[0]);
                this.bitmap = decoderFactory.make().decode(context, this.source);
                return Integer.valueOf(subsamplingScaleImageView.getExifOrientation(context, string));
            } catch (Exception e2) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to load bitmap", e2);
                this.exception = e2;
                return null;
            } catch (OutOfMemoryError e3) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to load bitmap - OutOfMemoryError", e3);
                this.exception = new RuntimeException(e3);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Integer num) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
            if (subsamplingScaleImageView != null) {
                Bitmap bitmap = this.bitmap;
                if (bitmap != null && num != null) {
                    if (this.preview) {
                        subsamplingScaleImageView.onPreviewLoaded(bitmap);
                        return;
                    } else {
                        subsamplingScaleImageView.onImageLoaded(bitmap, num.intValue(), false);
                        return;
                    }
                }
                if (this.exception == null || subsamplingScaleImageView.onImageEventListener == null) {
                    return;
                }
                if (this.preview) {
                    subsamplingScaleImageView.onImageEventListener.onPreviewLoadError(this.exception);
                } else {
                    subsamplingScaleImageView.onImageEventListener.onImageLoadError(this.exception);
                }
            }
        }
    }

    public static class DefaultOnAnimationEventListener implements OnAnimationEventListener {
        @Override // io.rong.subscaleview.SubsamplingScaleImageView.OnAnimationEventListener
        public void onComplete() {
        }

        @Override // io.rong.subscaleview.SubsamplingScaleImageView.OnAnimationEventListener
        public void onInterruptedByNewAnim() {
        }

        @Override // io.rong.subscaleview.SubsamplingScaleImageView.OnAnimationEventListener
        public void onInterruptedByUser() {
        }
    }

    public static class DefaultOnImageEventListener implements OnImageEventListener {
        @Override // io.rong.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onImageLoadError(Exception exc) {
        }

        @Override // io.rong.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onImageLoaded() {
        }

        @Override // io.rong.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onPreviewLoadError(Exception exc) {
        }

        @Override // io.rong.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onPreviewReleased() {
        }

        @Override // io.rong.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onReady() {
        }

        @Override // io.rong.subscaleview.SubsamplingScaleImageView.OnImageEventListener
        public void onTileLoadError(Exception exc) {
        }
    }

    public static class DefaultOnStateChangedListener implements OnStateChangedListener {
        @Override // io.rong.subscaleview.SubsamplingScaleImageView.OnStateChangedListener
        public void onCenterChanged(PointF pointF, int i) {
        }

        @Override // io.rong.subscaleview.SubsamplingScaleImageView.OnStateChangedListener
        public void onScaleChanged(float f2, int i) {
        }
    }

    public interface OnAnimationEventListener {
        void onComplete();

        void onInterruptedByNewAnim();

        void onInterruptedByUser();
    }

    public interface OnImageEventListener {
        void onImageLoadError(Exception exc);

        void onImageLoaded();

        void onPreviewLoadError(Exception exc);

        void onPreviewReleased();

        void onReady();

        void onTileLoadError(Exception exc);
    }

    public interface OnStateChangedListener {
        void onCenterChanged(PointF pointF, int i);

        void onScaleChanged(float f2, int i);
    }

    private static class ScaleAndTranslate {
        private float scale;
        private final PointF vTranslate;

        private ScaleAndTranslate(float f2, PointF pointF) {
            this.scale = f2;
            this.vTranslate = pointF;
        }
    }

    private static class Tile {
        private Bitmap bitmap;
        private Rect fileSRect;
        private boolean loading;
        private Rect sRect;
        private int sampleSize;
        private Rect vRect;
        private boolean visible;

        private Tile() {
        }
    }

    private static class TileLoadTask extends AsyncTask<Void, Void, Bitmap> {
        private final WeakReference<ImageRegionDecoder> decoderRef;
        private Exception exception;
        private final WeakReference<Tile> tileRef;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        TileLoadTask(SubsamplingScaleImageView subsamplingScaleImageView, ImageRegionDecoder imageRegionDecoder, Tile tile) {
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.decoderRef = new WeakReference<>(imageRegionDecoder);
            this.tileRef = new WeakReference<>(tile);
            tile.loading = true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Bitmap doInBackground(Void... voidArr) {
            try {
                SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
                ImageRegionDecoder imageRegionDecoder = this.decoderRef.get();
                Tile tile = this.tileRef.get();
                if (imageRegionDecoder == null || tile == null || subsamplingScaleImageView == null || !imageRegionDecoder.isReady() || !tile.visible) {
                    if (tile == null) {
                        return null;
                    }
                    tile.loading = false;
                    return null;
                }
                subsamplingScaleImageView.debug("TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d", tile.sRect, Integer.valueOf(tile.sampleSize));
                subsamplingScaleImageView.decoderLock.readLock().lock();
                try {
                    if (!imageRegionDecoder.isReady()) {
                        tile.loading = false;
                        subsamplingScaleImageView.decoderLock.readLock().unlock();
                        return null;
                    }
                    subsamplingScaleImageView.fileSRect(tile.sRect, tile.fileSRect);
                    if (subsamplingScaleImageView.sRegion != null) {
                        tile.fileSRect.offset(subsamplingScaleImageView.sRegion.left, subsamplingScaleImageView.sRegion.top);
                    }
                    return imageRegionDecoder.decodeRegion(tile.fileSRect, tile.sampleSize);
                } finally {
                    subsamplingScaleImageView.decoderLock.readLock().unlock();
                }
            } catch (Exception e2) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to decode tile", e2);
                this.exception = e2;
                return null;
            } catch (OutOfMemoryError e3) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to decode tile - OutOfMemoryError", e3);
                this.exception = new RuntimeException(e3);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bitmap) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
            Tile tile = this.tileRef.get();
            if (subsamplingScaleImageView == null || tile == null) {
                return;
            }
            if (bitmap != null) {
                tile.bitmap = bitmap;
                tile.loading = false;
                subsamplingScaleImageView.onTileLoaded();
            } else {
                if (this.exception == null || subsamplingScaleImageView.onImageEventListener == null) {
                    return;
                }
                subsamplingScaleImageView.onImageEventListener.onTileLoadError(this.exception);
            }
        }
    }

    private static class TilesInitTask extends AsyncTask<Void, Void, int[]> {
        private final WeakReference<Context> contextRef;
        private ImageRegionDecoder decoder;
        private final WeakReference<DecoderFactory<? extends ImageRegionDecoder>> decoderFactoryRef;
        private Exception exception;
        private final Uri source;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        TilesInitTask(SubsamplingScaleImageView subsamplingScaleImageView, Context context, DecoderFactory<? extends ImageRegionDecoder> decoderFactory, Uri uri) {
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.contextRef = new WeakReference<>(context);
            this.decoderFactoryRef = new WeakReference<>(decoderFactory);
            this.source = uri;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public int[] doInBackground(Void... voidArr) {
            try {
                String string = this.source.toString();
                Context context = this.contextRef.get();
                DecoderFactory<? extends ImageRegionDecoder> decoderFactory = this.decoderFactoryRef.get();
                SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
                if (context == null || decoderFactory == null || subsamplingScaleImageView == null) {
                    return null;
                }
                subsamplingScaleImageView.debug("TilesInitTask.doInBackground", new Object[0]);
                this.decoder = decoderFactory.make();
                Point pointInit = this.decoder.init(context, this.source);
                int iWidth = pointInit.x;
                int iHeight = pointInit.y;
                int exifOrientation = subsamplingScaleImageView.getExifOrientation(context, string);
                if (subsamplingScaleImageView.sRegion != null) {
                    subsamplingScaleImageView.sRegion.left = Math.max(0, subsamplingScaleImageView.sRegion.left);
                    subsamplingScaleImageView.sRegion.top = Math.max(0, subsamplingScaleImageView.sRegion.top);
                    subsamplingScaleImageView.sRegion.right = Math.min(iWidth, subsamplingScaleImageView.sRegion.right);
                    subsamplingScaleImageView.sRegion.bottom = Math.min(iHeight, subsamplingScaleImageView.sRegion.bottom);
                    iWidth = subsamplingScaleImageView.sRegion.width();
                    iHeight = subsamplingScaleImageView.sRegion.height();
                }
                return new int[]{iWidth, iHeight, exifOrientation};
            } catch (Exception e2) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to initialise bitmap decoder", e2);
                this.exception = e2;
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(int[] iArr) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
            if (subsamplingScaleImageView != null) {
                ImageRegionDecoder imageRegionDecoder = this.decoder;
                if (imageRegionDecoder != null && iArr != null && iArr.length == 3) {
                    subsamplingScaleImageView.onTilesInited(imageRegionDecoder, iArr[0], iArr[1], iArr[2]);
                } else {
                    if (this.exception == null || subsamplingScaleImageView.onImageEventListener == null) {
                        return;
                    }
                    subsamplingScaleImageView.onImageEventListener.onImageLoadError(this.exception);
                }
            }
        }
    }

    public SubsamplingScaleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.orientation = 0;
        this.maxScale = 2.0f;
        this.minScale = minScale();
        this.minimumTileDpi = -1;
        this.panLimit = 1;
        this.minimumScaleType = 1;
        this.maxTileWidth = Integer.MAX_VALUE;
        this.maxTileHeight = Integer.MAX_VALUE;
        this.executor = AsyncTask.THREAD_POOL_EXECUTOR;
        this.eagerLoadingEnabled = true;
        this.panEnabled = true;
        this.zoomEnabled = true;
        this.quickScaleEnabled = true;
        this.doubleTapZoomScale = 1.0f;
        this.doubleTapZoomStyle = 1;
        this.doubleTapZoomDuration = 500;
        this.decoderLock = new ReentrantReadWriteLock(true);
        this.bitmapDecoderFactory = new CompatDecoderFactory(SkiaImageDecoder.class);
        this.regionDecoderFactory = new CompatDecoderFactory(SkiaImageRegionDecoder.class);
        this.srcArray = new float[8];
        this.dstArray = new float[8];
        this.density = getResources().getDisplayMetrics().density;
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setMinimumTileDpi(320);
        setGestureDetector(context);
        this.handler = new Handler(new Handler.Callback() { // from class: io.rong.subscaleview.SubsamplingScaleImageView.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what == 1 && SubsamplingScaleImageView.this.onLongClickListener != null) {
                    SubsamplingScaleImageView.this.maxTouchCount = 0;
                    SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                    SubsamplingScaleImageView.super.setOnLongClickListener(subsamplingScaleImageView.onLongClickListener);
                    SubsamplingScaleImageView.this.performLongClick();
                    SubsamplingScaleImageView.super.setOnLongClickListener(null);
                }
                return true;
            }
        });
        this.quickScaleThreshold = TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
    }

    static /* synthetic */ PointF access$6600(SubsamplingScaleImageView subsamplingScaleImageView, float f2, float f3, float f4, PointF pointF) {
        subsamplingScaleImageView.limitedSCenter(f2, f3, f4, pointF);
        return pointF;
    }

    private int calculateInSampleSize(float f2) {
        int iRound;
        if (this.minimumTileDpi > 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f2 *= this.minimumTileDpi / ((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f);
        }
        int iSWidth = (int) (sWidth() * f2);
        int iSHeight = (int) (sHeight() * f2);
        if (iSWidth == 0 || iSHeight == 0) {
            return 32;
        }
        int i = 1;
        if (sHeight() > iSHeight || sWidth() > iSWidth) {
            iRound = Math.round(sHeight() / iSHeight);
            int iRound2 = Math.round(sWidth() / iSWidth);
            if (iRound >= iRound2) {
                iRound = iRound2;
            }
        } else {
            iRound = 1;
        }
        while (true) {
            int i2 = i * 2;
            if (i2 >= iRound) {
                return i;
            }
            i = i2;
        }
    }

    private boolean checkImageLoaded() {
        boolean zIsBaseLayerReady = isBaseLayerReady();
        if (!this.imageLoadedSent && zIsBaseLayerReady) {
            preDraw();
            this.imageLoadedSent = true;
            onImageLoaded();
            OnImageEventListener onImageEventListener = this.onImageEventListener;
            if (onImageEventListener != null) {
                onImageEventListener.onImageLoaded();
            }
        }
        return zIsBaseLayerReady;
    }

    private boolean checkReady() {
        boolean z = getWidth() > 0 && getHeight() > 0 && this.sWidth > 0 && this.sHeight > 0 && (this.bitmap != null || isBaseLayerReady());
        if (!this.readySent && z) {
            preDraw();
            this.readySent = true;
            onReady();
            OnImageEventListener onImageEventListener = this.onImageEventListener;
            if (onImageEventListener != null) {
                onImageEventListener.onReady();
            }
            setNewDefaultScale();
        }
        return z;
    }

    private void createPaints() {
        if (this.bitmapPaint == null) {
            this.bitmapPaint = new Paint();
            this.bitmapPaint.setAntiAlias(true);
            this.bitmapPaint.setFilterBitmap(true);
            this.bitmapPaint.setDither(true);
        }
        if ((this.debugTextPaint == null || this.debugLinePaint == null) && this.debug) {
            this.debugTextPaint = new Paint();
            this.debugTextPaint.setTextSize(px(12));
            this.debugTextPaint.setColor(-65281);
            this.debugTextPaint.setStyle(Paint.Style.FILL);
            this.debugLinePaint = new Paint();
            this.debugLinePaint.setColor(-65281);
            this.debugLinePaint.setStyle(Paint.Style.STROKE);
            this.debugLinePaint.setStrokeWidth(px(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void debug(String str, Object... objArr) {
        if (this.debug) {
            Log.d(TAG, String.format(str, objArr));
        }
    }

    private float distance(float f2, float f3, float f4, float f5) {
        float f6 = f2 - f3;
        float f7 = f4 - f5;
        return (float) Math.sqrt((f6 * f6) + (f7 * f7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doubleTapZoom(PointF pointF, PointF pointF2) {
        if (!this.panEnabled) {
            PointF pointF3 = this.sRequestedCenter;
            if (pointF3 != null) {
                pointF.x = pointF3.x;
                pointF.y = pointF3.y;
            } else {
                pointF.x = sWidth() / 2;
                pointF.y = sHeight() / 2;
            }
        }
        float fMin = Math.min(this.maxScale, this.doubleTapZoomScale);
        float f2 = this.scale;
        double d2 = f2;
        double d3 = fMin;
        Double.isNaN(d3);
        boolean z = d2 <= d3 * 0.9d || f2 == this.minScale;
        if (!z) {
            fMin = minScale();
        }
        float f3 = fMin;
        int i = this.doubleTapZoomStyle;
        if (i == 3) {
            setScaleAndCenter(f3, pointF);
        } else if (i == 2 || !z || !this.panEnabled) {
            AnimationBuilder animationBuilderWithDuration = new AnimationBuilder(f3, pointF).withInterruptible(false).withDuration(this.doubleTapZoomDuration);
            AnimationBuilder.access$1300(animationBuilderWithDuration, 4);
            animationBuilderWithDuration.start();
        } else if (i == 1) {
            AnimationBuilder animationBuilderWithDuration2 = new AnimationBuilder(f3, pointF, pointF2).withInterruptible(false).withDuration(this.doubleTapZoomDuration);
            AnimationBuilder.access$1300(animationBuilderWithDuration2, 4);
            animationBuilderWithDuration2.start();
        }
        invalidate();
    }

    private float ease(int i, long j, float f2, float f3, long j2) {
        if (i == 1) {
            return easeOutQuad(j, f2, f3, j2);
        }
        if (i == 2) {
            return easeInOutQuad(j, f2, f3, j2);
        }
        throw new IllegalStateException("Unexpected easing type: " + i);
    }

    private float easeInOutQuad(long j, float f2, float f3, long j2) {
        float f4;
        float f5 = j / (j2 / 2.0f);
        if (f5 < 1.0f) {
            f4 = (f3 / 2.0f) * f5;
        } else {
            float f6 = f5 - 1.0f;
            f4 = (-f3) / 2.0f;
            f5 = (f6 * (f6 - 2.0f)) - 1.0f;
        }
        return (f4 * f5) + f2;
    }

    private float easeOutQuad(long j, float f2, float f3, long j2) {
        float f4 = j / j2;
        return ((-f3) * f4 * (f4 - 2.0f)) + f2;
    }

    private void execute(AsyncTask<Void, Void, ?> asyncTask) {
        asyncTask.executeOnExecutor(this.executor, new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fileSRect(Rect rect, Rect rect2) {
        if (getRequiredRotation() == 0) {
            rect2.set(rect);
            return;
        }
        if (getRequiredRotation() == 90) {
            int i = rect.top;
            int i2 = this.sHeight;
            rect2.set(i, i2 - rect.right, rect.bottom, i2 - rect.left);
        } else if (getRequiredRotation() != 180) {
            int i3 = this.sWidth;
            rect2.set(i3 - rect.bottom, rect.left, i3 - rect.top, rect.right);
        } else {
            int i4 = this.sWidth;
            int i5 = i4 - rect.right;
            int i6 = this.sHeight;
            rect2.set(i5, i6 - rect.bottom, i4 - rect.left, i6 - rect.top);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fitToBounds(boolean z, ScaleAndTranslate scaleAndTranslate) {
        float fMax;
        int iMax;
        float fMax2;
        if (this.panLimit == 2 && isReady()) {
            z = false;
        }
        PointF pointF = scaleAndTranslate.vTranslate;
        float fLimitedScale = limitedScale(scaleAndTranslate.scale);
        float fSWidth = sWidth() * fLimitedScale;
        float fSHeight = sHeight() * fLimitedScale;
        if (this.panLimit == 3 && isReady()) {
            pointF.x = Math.max(pointF.x, (getWidth() / 2.0f) - fSWidth);
            pointF.y = Math.max(pointF.y, (getHeight() / 2.0f) - fSHeight);
        } else if (z) {
            pointF.x = Math.max(pointF.x, getWidth() - fSWidth);
            pointF.y = Math.max(pointF.y, getHeight() - fSHeight);
        } else {
            pointF.x = Math.max(pointF.x, -fSWidth);
            pointF.y = Math.max(pointF.y, -fSHeight);
        }
        float paddingLeft = (getPaddingLeft() > 0 || getPaddingRight() > 0) ? getPaddingLeft() / (getPaddingLeft() + getPaddingRight()) : 0.5f;
        float paddingTop = (getPaddingTop() > 0 || getPaddingBottom() > 0) ? getPaddingTop() / (getPaddingTop() + getPaddingBottom()) : 0.5f;
        if (this.panLimit == 3 && isReady()) {
            fMax = Math.max(0, getWidth() / 2);
            iMax = Math.max(0, getHeight() / 2);
        } else {
            if (z) {
                fMax = Math.max(WheelView.DividerConfig.FILL, (getWidth() - fSWidth) * paddingLeft);
                fMax2 = Math.max(WheelView.DividerConfig.FILL, (getHeight() - fSHeight) * paddingTop);
                pointF.x = Math.min(pointF.x, fMax);
                pointF.y = Math.min(pointF.y, fMax2);
                scaleAndTranslate.scale = fLimitedScale;
            }
            fMax = Math.max(0, getWidth());
            iMax = Math.max(0, getHeight());
        }
        fMax2 = iMax;
        pointF.x = Math.min(pointF.x, fMax);
        pointF.y = Math.min(pointF.y, fMax2);
        scaleAndTranslate.scale = fLimitedScale;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getExifOrientation(android.content.Context r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = "content"
            boolean r0 = r11.startsWith(r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L70
            r0 = 0
            java.lang.String[] r5 = new java.lang.String[r1]     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            java.lang.String r1 = "orientation"
            r5[r2] = r1     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            android.net.Uri r4 = android.net.Uri.parse(r11)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r0 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            if (r0 == 0) goto L52
            boolean r10 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            if (r10 == 0) goto L52
            int r10 = r0.getInt(r2)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            java.util.List<java.lang.Integer> r11 = io.rong.subscaleview.SubsamplingScaleImageView.VALID_ORIENTATIONS     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            java.lang.Integer r1 = java.lang.Integer.valueOf(r10)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            boolean r11 = r11.contains(r1)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            if (r11 == 0) goto L3c
            r11 = -1
            if (r10 == r11) goto L3c
            goto L53
        L3c:
            java.lang.String r11 = io.rong.subscaleview.SubsamplingScaleImageView.TAG     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            r1.<init>()     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            java.lang.String r3 = "Unsupported orientation: "
            r1.append(r3)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            r1.append(r10)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            java.lang.String r10 = r1.toString()     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            android.util.Log.w(r11, r10)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
        L52:
            r10 = 0
        L53:
            if (r0 == 0) goto L58
            r0.close()
        L58:
            r2 = r10
            goto Lc7
        L5b:
            r10 = move-exception
            goto L6a
        L5d:
            java.lang.String r10 = io.rong.subscaleview.SubsamplingScaleImageView.TAG     // Catch: java.lang.Throwable -> L5b
            java.lang.String r11 = "Could not get orientation of image from media store"
            android.util.Log.w(r10, r11)     // Catch: java.lang.Throwable -> L5b
            if (r0 == 0) goto Lc7
            r0.close()
            goto Lc7
        L6a:
            if (r0 == 0) goto L6f
            r0.close()
        L6f:
            throw r10
        L70:
            java.lang.String r10 = "file:///"
            boolean r10 = r11.startsWith(r10)
            if (r10 == 0) goto Lc7
            java.lang.String r10 = "file:///android_asset/"
            boolean r10 = r11.startsWith(r10)
            if (r10 != 0) goto Lc7
            androidx.exifinterface.a.a r10 = new androidx.exifinterface.a.a     // Catch: java.lang.Exception -> Lc0
            r0 = 7
            java.lang.String r11 = r11.substring(r0)     // Catch: java.lang.Exception -> Lc0
            r10.<init>(r11)     // Catch: java.lang.Exception -> Lc0
            java.lang.String r11 = "Orientation"
            int r10 = r10.a(r11, r1)     // Catch: java.lang.Exception -> Lc0
            r11 = 6
            if (r10 != r11) goto L98
            r10 = 90
            r2 = 90
            goto Lc7
        L98:
            r11 = 3
            if (r10 != r11) goto La0
            r10 = 180(0xb4, float:2.52E-43)
            r2 = 180(0xb4, float:2.52E-43)
            goto Lc7
        La0:
            r11 = 8
            if (r10 != r11) goto La9
            r10 = 270(0x10e, float:3.78E-43)
            r2 = 270(0x10e, float:3.78E-43)
            goto Lc7
        La9:
            java.lang.String r11 = io.rong.subscaleview.SubsamplingScaleImageView.TAG     // Catch: java.lang.Exception -> Lc0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lc0
            r0.<init>()     // Catch: java.lang.Exception -> Lc0
            java.lang.String r1 = "Unsupported EXIF orientation: "
            r0.append(r1)     // Catch: java.lang.Exception -> Lc0
            r0.append(r10)     // Catch: java.lang.Exception -> Lc0
            java.lang.String r10 = r0.toString()     // Catch: java.lang.Exception -> Lc0
            android.util.Log.w(r11, r10)     // Catch: java.lang.Exception -> Lc0
            goto Lc7
        Lc0:
            java.lang.String r10 = io.rong.subscaleview.SubsamplingScaleImageView.TAG
            java.lang.String r11 = "Could not get EXIF orientation of image"
            android.util.Log.w(r10, r11)
        Lc7:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.subscaleview.SubsamplingScaleImageView.getExifOrientation(android.content.Context, java.lang.String):int");
    }

    private Point getMaxBitmapDimensions(Canvas canvas) {
        return new Point(Math.min(canvas.getMaximumBitmapWidth(), this.maxTileWidth), Math.min(canvas.getMaximumBitmapHeight(), this.maxTileHeight));
    }

    public static Bitmap.Config getPreferredBitmapConfig() {
        return preferredBitmapConfig;
    }

    private int getRequiredRotation() {
        int i = this.orientation;
        return i == -1 ? this.sOrientation : i;
    }

    private synchronized void initialiseBaseLayer(Point point) {
        debug("initialiseBaseLayer maxTileDimensions=%dx%d", Integer.valueOf(point.x), Integer.valueOf(point.y));
        this.satTemp = new ScaleAndTranslate(WheelView.DividerConfig.FILL, new PointF(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL));
        fitToBounds(true, this.satTemp);
        this.fullImageSampleSize = calculateInSampleSize(this.satTemp.scale);
        if (this.fullImageSampleSize > 1) {
            this.fullImageSampleSize /= 2;
        }
        if (this.fullImageSampleSize != 1 || this.sRegion != null || sWidth() >= point.x || sHeight() >= point.y) {
            initialiseTileMap(point);
            Iterator<Tile> it = this.tileMap.get(Integer.valueOf(this.fullImageSampleSize)).iterator();
            while (it.hasNext()) {
                execute(new TileLoadTask(this, this.decoder, it.next()));
            }
            refreshRequiredTiles(true);
        } else {
            this.decoder.recycle();
            this.decoder = null;
            execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, this.uri, false));
        }
    }

    private void initialiseTileMap(Point point) {
        String str;
        String str2;
        Point point2 = point;
        int i = 1;
        debug("initialiseTileMap maxTileDimensions=%dx%d", Integer.valueOf(point2.x), Integer.valueOf(point2.y));
        this.tileMap = new LinkedHashMap();
        int i2 = this.fullImageSampleSize;
        int i3 = 1;
        int i4 = 1;
        while (true) {
            int iSWidth = sWidth() / i3;
            int iSHeight = sHeight() / i4;
            int i5 = iSWidth / i2;
            int i6 = iSHeight / i2;
            String str3 = "initialiseTileMap";
            Log.i("initialiseTileMap", " sampleSize = " + i2);
            Log.i("initialiseTileMap", " sWidth() = " + sWidth() + " xTiles = " + i3);
            Log.i("initialiseTileMap", " sHeight() = " + sHeight() + " yTiles = " + i4);
            StringBuilder sb = new StringBuilder();
            sb.append(" sTileWidth = ");
            sb.append(iSWidth);
            Log.i("initialiseTileMap", sb.toString());
            Log.i("initialiseTileMap", " sTileWidth = " + iSHeight);
            Log.i("initialiseTileMap", " subTileWidth = " + i5);
            Log.i("initialiseTileMap", " subTileHeight = " + i6);
            Log.i("initialiseTileMap", " maxTileDimensions.x = " + point2.x + " maxTileDimensions.y = " + point2.y);
            while (true) {
                if (i5 + i3 + i <= point2.x) {
                    double d2 = i5;
                    str2 = str3;
                    double width = getWidth();
                    Double.isNaN(width);
                    if (d2 <= width * 1.25d || i2 >= this.fullImageSampleSize) {
                        break;
                    } else {
                        str = str2;
                    }
                } else {
                    str = str3;
                }
                i3++;
                iSWidth = sWidth() / i3;
                i5 = iSWidth / i2;
                point2 = point;
                str3 = str;
                i = 1;
            }
            while (true) {
                if (i6 + i4 + 1 <= point2.y) {
                    double d3 = i6;
                    double height = getHeight();
                    Double.isNaN(height);
                    if (d3 <= height * 1.25d || i2 >= this.fullImageSampleSize) {
                        break;
                    }
                }
                i4++;
                iSHeight = sHeight() / i4;
                i6 = iSHeight / i2;
                point2 = point;
                str2 = str2;
            }
            String str4 = str2;
            Log.i(str4, " 计算后的 xTiles = " + i3 + " yTiles = " + i4 + " sTileWidth = " + iSWidth + " sTileHeight= " + iSHeight);
            ArrayList arrayList = new ArrayList(i3 * i4);
            int i7 = 0;
            while (i7 < i3) {
                int i8 = 0;
                while (i8 < i4) {
                    Tile tile = new Tile();
                    tile.sampleSize = i2;
                    tile.visible = i2 == this.fullImageSampleSize;
                    tile.sRect = new Rect(i7 * iSWidth, i8 * iSHeight, i7 == i3 + (-1) ? sWidth() : (i7 + 1) * iSWidth, i8 == i4 + (-1) ? sHeight() : (i8 + 1) * iSHeight);
                    tile.vRect = new Rect(0, 0, 0, 0);
                    tile.fileSRect = new Rect(tile.sRect);
                    arrayList.add(tile);
                    i8++;
                }
                i7++;
            }
            Log.i(str4, "tileGrid.size() = " + arrayList.size());
            this.tileMap.put(Integer.valueOf(i2), arrayList);
            if (i2 == 1) {
                return;
            }
            Log.i(str4, "----------------------------------------------");
            Log.i(str4, " 加大抽样率");
            i2 /= 2;
            point2 = point;
            i = 1;
        }
    }

    private boolean isBaseLayerReady() {
        boolean z = true;
        if (this.bitmap != null && !this.bitmapIsPreview) {
            return true;
        }
        Map<Integer, List<Tile>> map = this.tileMap;
        if (map == null) {
            return false;
        }
        for (Map.Entry<Integer, List<Tile>> entry : map.entrySet()) {
            if (entry.getKey().intValue() == this.fullImageSampleSize) {
                for (Tile tile : entry.getValue()) {
                    if (tile.loading || tile.bitmap == null) {
                        z = false;
                    }
                }
            }
        }
        return z;
    }

    private PointF limitedSCenter(float f2, float f3, float f4, PointF pointF) {
        PointF pointFVTranslateForSCenter = vTranslateForSCenter(f2, f3, f4);
        pointF.set(((getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2)) - pointFVTranslateForSCenter.x) / f4, ((getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2)) - pointFVTranslateForSCenter.y) / f4);
        return pointF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float limitedScale(float f2) {
        return Math.min(this.maxScale, Math.max(minScale(), f2));
    }

    private float minScale() {
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i = this.minimumScaleType;
        if (i == 2 || i == 4) {
            return Math.max((getWidth() - paddingLeft) / sWidth(), (getHeight() - paddingBottom) / sHeight());
        }
        if (i == 3) {
            float f2 = this.minScale;
            if (f2 > WheelView.DividerConfig.FILL) {
                return f2;
            }
        }
        return Math.min((getWidth() - paddingLeft) / sWidth(), (getHeight() - paddingBottom) / sHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onImageLoaded(Bitmap bitmap, int i, boolean z) {
        debug("onImageLoaded", new Object[0]);
        if (this.sWidth > 0 && this.sHeight > 0 && (this.sWidth != bitmap.getWidth() || this.sHeight != bitmap.getHeight())) {
            reset(false);
        }
        if (this.bitmap != null && !this.bitmapIsCached) {
            this.bitmap.recycle();
        }
        if (this.bitmap != null && this.bitmapIsCached && this.onImageEventListener != null) {
            this.onImageEventListener.onPreviewReleased();
        }
        this.bitmapIsPreview = false;
        this.bitmapIsCached = z;
        this.bitmap = bitmap;
        this.sWidth = bitmap.getWidth();
        this.sHeight = bitmap.getHeight();
        this.sOrientation = i;
        boolean zCheckReady = checkReady();
        boolean zCheckImageLoaded = checkImageLoaded();
        if (zCheckReady || zCheckImageLoaded) {
            invalidate();
            requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onPreviewLoaded(Bitmap bitmap) {
        debug("onPreviewLoaded", new Object[0]);
        if (this.bitmap == null && !this.imageLoadedSent) {
            if (this.pRegion != null) {
                this.bitmap = Bitmap.createBitmap(bitmap, this.pRegion.left, this.pRegion.top, this.pRegion.width(), this.pRegion.height());
            } else {
                this.bitmap = bitmap;
            }
            this.bitmapIsPreview = true;
            if (checkReady()) {
                invalidate();
                requestLayout();
            }
            return;
        }
        bitmap.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onTileLoaded() {
        debug("onTileLoaded", new Object[0]);
        checkReady();
        checkImageLoaded();
        if (isBaseLayerReady() && this.bitmap != null) {
            if (!this.bitmapIsCached) {
                this.bitmap.recycle();
            }
            this.bitmap = null;
            if (this.onImageEventListener != null && this.bitmapIsCached) {
                this.onImageEventListener.onPreviewReleased();
            }
            this.bitmapIsPreview = false;
            this.bitmapIsCached = false;
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onTilesInited(ImageRegionDecoder imageRegionDecoder, int i, int i2, int i3) {
        debug("onTilesInited sWidth=%d, sHeight=%d, sOrientation=%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.orientation));
        if (this.sWidth > 0 && this.sHeight > 0 && (this.sWidth != i || this.sHeight != i2)) {
            reset(false);
            if (this.bitmap != null) {
                if (!this.bitmapIsCached) {
                    this.bitmap.recycle();
                }
                this.bitmap = null;
                if (this.onImageEventListener != null && this.bitmapIsCached) {
                    this.onImageEventListener.onPreviewReleased();
                }
                this.bitmapIsPreview = false;
                this.bitmapIsCached = false;
            }
        }
        this.decoder = imageRegionDecoder;
        this.sWidth = i;
        this.sHeight = i2;
        this.sOrientation = i3;
        checkReady();
        if (!checkImageLoaded() && this.maxTileWidth > 0 && this.maxTileWidth != Integer.MAX_VALUE && this.maxTileHeight > 0 && this.maxTileHeight != Integer.MAX_VALUE && getWidth() > 0 && getHeight() > 0) {
            initialiseBaseLayer(new Point(this.maxTileWidth, this.maxTileHeight));
        }
        invalidate();
        requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
    
        if (r1 != 262) goto L138;
     */
    /* JADX WARN: Removed duplicated region for block: B:136:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0288  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean onTouchEventInternal(android.view.MotionEvent r14) {
        /*
            Method dump skipped, instruction units count: 1242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.subscaleview.SubsamplingScaleImageView.onTouchEventInternal(android.view.MotionEvent):boolean");
    }

    private void preDraw() {
        Float f2;
        if (getWidth() == 0 || getHeight() == 0 || this.sWidth <= 0 || this.sHeight <= 0) {
            return;
        }
        if (this.sPendingCenter != null && (f2 = this.pendingScale) != null) {
            this.scale = f2.floatValue();
            if (this.vTranslate == null) {
                this.vTranslate = new PointF();
            }
            this.vTranslate.x = (getWidth() / 2.0f) - (this.scale * this.sPendingCenter.x);
            this.vTranslate.y = (getHeight() / 2.0f) - (this.scale * this.sPendingCenter.y);
            this.sPendingCenter = null;
            this.pendingScale = null;
            fitToBounds(true);
            refreshRequiredTiles(true);
        }
        fitToBounds(false);
    }

    private int px(int i) {
        return (int) (this.density * i);
    }

    private void refreshRequiredTiles(boolean z) {
        if (this.decoder == null || this.tileMap == null) {
            return;
        }
        int iMin = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
        Iterator<Map.Entry<Integer, List<Tile>>> it = this.tileMap.entrySet().iterator();
        while (it.hasNext()) {
            for (Tile tile : it.next().getValue()) {
                if (tile.sampleSize < iMin || (tile.sampleSize > iMin && tile.sampleSize != this.fullImageSampleSize)) {
                    tile.visible = false;
                    if (tile.bitmap != null) {
                        tile.bitmap.recycle();
                        tile.bitmap = null;
                    }
                }
                if (tile.sampleSize == iMin) {
                    if (tileVisible(tile)) {
                        tile.visible = true;
                        if (!tile.loading && tile.bitmap == null && z) {
                            execute(new TileLoadTask(this, this.decoder, tile));
                        }
                    } else if (tile.sampleSize != this.fullImageSampleSize) {
                        tile.visible = false;
                        if (tile.bitmap != null) {
                            tile.bitmap.recycle();
                            tile.bitmap = null;
                        }
                    }
                } else if (tile.sampleSize == this.fullImageSampleSize) {
                    tile.visible = true;
                }
            }
        }
    }

    private void requestDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private void reset(boolean z) {
        OnImageEventListener onImageEventListener;
        debug("reset newImage=" + z, new Object[0]);
        this.scale = WheelView.DividerConfig.FILL;
        this.scaleStart = WheelView.DividerConfig.FILL;
        this.vTranslate = null;
        this.vTranslateStart = null;
        this.vTranslateBefore = null;
        this.pendingScale = Float.valueOf(WheelView.DividerConfig.FILL);
        this.sPendingCenter = null;
        this.sRequestedCenter = null;
        this.isZooming = false;
        this.isPanning = false;
        this.isQuickScaling = false;
        this.maxTouchCount = 0;
        this.fullImageSampleSize = 0;
        this.vCenterStart = null;
        this.vDistStart = WheelView.DividerConfig.FILL;
        this.quickScaleLastDistance = WheelView.DividerConfig.FILL;
        this.quickScaleMoved = false;
        this.quickScaleSCenter = null;
        this.quickScaleVLastPoint = null;
        this.quickScaleVStart = null;
        this.anim = null;
        this.satTemp = null;
        this.matrix = null;
        this.sRect = null;
        if (z) {
            this.uri = null;
            this.decoderLock.writeLock().lock();
            try {
                if (this.decoder != null) {
                    this.decoder.recycle();
                    this.decoder = null;
                }
                this.decoderLock.writeLock().unlock();
                Bitmap bitmap = this.bitmap;
                if (bitmap != null && !this.bitmapIsCached) {
                    bitmap.recycle();
                }
                if (this.bitmap != null && this.bitmapIsCached && (onImageEventListener = this.onImageEventListener) != null) {
                    onImageEventListener.onPreviewReleased();
                }
                this.sWidth = 0;
                this.sHeight = 0;
                this.sOrientation = 0;
                this.sRegion = null;
                this.pRegion = null;
                this.readySent = false;
                this.imageLoadedSent = false;
                this.bitmap = null;
                this.bitmapIsPreview = false;
                this.bitmapIsCached = false;
            } catch (Throwable th) {
                this.decoderLock.writeLock().unlock();
                throw th;
            }
        }
        Map<Integer, List<Tile>> map = this.tileMap;
        if (map != null) {
            Iterator<Map.Entry<Integer, List<Tile>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                for (Tile tile : it.next().getValue()) {
                    tile.visible = false;
                    if (tile.bitmap != null) {
                        tile.bitmap.recycle();
                        tile.bitmap = null;
                    }
                }
            }
            this.tileMap = null;
        }
        setGestureDetector(getContext());
    }

    private void restoreState(ImageViewState imageViewState) {
        if (imageViewState == null || imageViewState.getCenter() == null || !VALID_ORIENTATIONS.contains(Integer.valueOf(imageViewState.getOrientation()))) {
            return;
        }
        this.orientation = imageViewState.getOrientation();
        this.pendingScale = Float.valueOf(imageViewState.getScale());
        this.sPendingCenter = imageViewState.getCenter();
        invalidate();
    }

    private int sHeight() {
        int requiredRotation = getRequiredRotation();
        return (requiredRotation == 90 || requiredRotation == 270) ? this.sWidth : this.sHeight;
    }

    private int sWidth() {
        int requiredRotation = getRequiredRotation();
        return (requiredRotation == 90 || requiredRotation == 270) ? this.sHeight : this.sWidth;
    }

    private void sendStateChanged(float f2, PointF pointF, int i) {
        OnStateChangedListener onStateChangedListener = this.onStateChangedListener;
        if (onStateChangedListener != null) {
            float f3 = this.scale;
            if (f3 != f2) {
                onStateChangedListener.onScaleChanged(f3, i);
            }
        }
        if (this.onStateChangedListener == null || this.vTranslate.equals(pointF)) {
            return;
        }
        this.onStateChangedListener.onCenterChanged(getCenter(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setGestureDetector(final Context context) {
        this.detector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: io.rong.subscaleview.SubsamplingScaleImageView.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (!SubsamplingScaleImageView.this.zoomEnabled || !SubsamplingScaleImageView.this.readySent || SubsamplingScaleImageView.this.vTranslate == null) {
                    return super.onDoubleTapEvent(motionEvent);
                }
                SubsamplingScaleImageView.this.setGestureDetector(context);
                if (!SubsamplingScaleImageView.this.quickScaleEnabled) {
                    SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                    subsamplingScaleImageView.doubleTapZoom(subsamplingScaleImageView.viewToSourceCoord(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
                    return true;
                }
                SubsamplingScaleImageView.this.vCenterStart = new PointF(motionEvent.getX(), motionEvent.getY());
                SubsamplingScaleImageView subsamplingScaleImageView2 = SubsamplingScaleImageView.this;
                subsamplingScaleImageView2.vTranslateStart = new PointF(subsamplingScaleImageView2.vTranslate.x, SubsamplingScaleImageView.this.vTranslate.y);
                SubsamplingScaleImageView subsamplingScaleImageView3 = SubsamplingScaleImageView.this;
                subsamplingScaleImageView3.scaleStart = subsamplingScaleImageView3.scale;
                SubsamplingScaleImageView.this.isQuickScaling = true;
                SubsamplingScaleImageView.this.isZooming = true;
                SubsamplingScaleImageView.this.quickScaleLastDistance = -1.0f;
                SubsamplingScaleImageView subsamplingScaleImageView4 = SubsamplingScaleImageView.this;
                subsamplingScaleImageView4.quickScaleSCenter = subsamplingScaleImageView4.viewToSourceCoord(subsamplingScaleImageView4.vCenterStart);
                SubsamplingScaleImageView.this.quickScaleVStart = new PointF(motionEvent.getX(), motionEvent.getY());
                SubsamplingScaleImageView subsamplingScaleImageView5 = SubsamplingScaleImageView.this;
                subsamplingScaleImageView5.quickScaleVLastPoint = new PointF(subsamplingScaleImageView5.quickScaleSCenter.x, SubsamplingScaleImageView.this.quickScaleSCenter.y);
                SubsamplingScaleImageView.this.quickScaleMoved = false;
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (!SubsamplingScaleImageView.this.panEnabled || !SubsamplingScaleImageView.this.readySent || SubsamplingScaleImageView.this.vTranslate == null || motionEvent == null || motionEvent2 == null || ((Math.abs(motionEvent.getX() - motionEvent2.getX()) <= 50.0f && Math.abs(motionEvent.getY() - motionEvent2.getY()) <= 50.0f) || ((Math.abs(f2) <= 500.0f && Math.abs(f3) <= 500.0f) || SubsamplingScaleImageView.this.isZooming))) {
                    return super.onFling(motionEvent, motionEvent2, f2, f3);
                }
                PointF pointF = new PointF(SubsamplingScaleImageView.this.vTranslate.x + (f2 * 0.25f), SubsamplingScaleImageView.this.vTranslate.y + (f3 * 0.25f));
                AnimationBuilder animationBuilderWithEasing = new AnimationBuilder(new PointF(((SubsamplingScaleImageView.this.getWidth() / 2.0f) - pointF.x) / SubsamplingScaleImageView.this.scale, ((SubsamplingScaleImageView.this.getHeight() / 2.0f) - pointF.y) / SubsamplingScaleImageView.this.scale)).withEasing(1);
                AnimationBuilder.access$1200(animationBuilderWithEasing, false);
                AnimationBuilder.access$1300(animationBuilderWithEasing, 3);
                animationBuilderWithEasing.start();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                SubsamplingScaleImageView.this.performClick();
                return true;
            }
        });
        this.singleDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: io.rong.subscaleview.SubsamplingScaleImageView.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                SubsamplingScaleImageView.this.performClick();
                return true;
            }
        });
    }

    private void setMatrixArray(float[] fArr, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        fArr[0] = f2;
        fArr[1] = f3;
        fArr[2] = f4;
        fArr[3] = f5;
        fArr[4] = f6;
        fArr[5] = f7;
        fArr[6] = f8;
        fArr[7] = f9;
    }

    private void setNewDefaultScale() {
        float f2;
        float f3;
        int width = getWidth();
        int height = getHeight();
        int i = this.sWidth;
        int i2 = this.sHeight;
        if (width <= 0 || height <= 0 || i <= 0 || i2 <= 0) {
            return;
        }
        float f4 = width * 1.0f;
        float f5 = height;
        float f6 = i;
        float f7 = i2;
        float f8 = -1.0f;
        if ((1.0f * f6) / f7 < f4 / f5) {
            f8 = f4 / f6;
            f3 = f7 / 2.0f;
            f2 = (f5 / 2.0f) / f8;
        } else {
            f2 = -1.0f;
            f3 = -1.0f;
        }
        if (f8 < WheelView.DividerConfig.FILL || f3 < WheelView.DividerConfig.FILL || f2 < WheelView.DividerConfig.FILL) {
            return;
        }
        PointF pointF = new PointF(f3, f2);
        this.pendingScale = Float.valueOf(f8);
        this.sPendingCenter = pointF;
        this.sRequestedCenter = pointF;
    }

    public static void setPreferredBitmapConfig(Bitmap.Config config) {
        preferredBitmapConfig = config;
    }

    private void sourceToViewRect(Rect rect, Rect rect2) {
        rect2.set((int) sourceToViewX(rect.left), (int) sourceToViewY(rect.top), (int) sourceToViewX(rect.right), (int) sourceToViewY(rect.bottom));
    }

    private float sourceToViewX(float f2) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 * this.scale) + pointF.x;
    }

    private float sourceToViewY(float f2) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 * this.scale) + pointF.y;
    }

    private boolean tileVisible(Tile tile) {
        return viewToSourceX(WheelView.DividerConfig.FILL) <= ((float) tile.sRect.right) && ((float) tile.sRect.left) <= viewToSourceX((float) getWidth()) && viewToSourceY(WheelView.DividerConfig.FILL) <= ((float) tile.sRect.bottom) && ((float) tile.sRect.top) <= viewToSourceY((float) getHeight());
    }

    private PointF vTranslateForSCenter(float f2, float f3, float f4) {
        int paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int paddingTop = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.satTemp == null) {
            this.satTemp = new ScaleAndTranslate(WheelView.DividerConfig.FILL, new PointF(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL));
        }
        this.satTemp.scale = f4;
        this.satTemp.vTranslate.set(paddingLeft - (f2 * f4), paddingTop - (f3 * f4));
        fitToBounds(true, this.satTemp);
        return this.satTemp.vTranslate;
    }

    private float viewToSourceX(float f2) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 - pointF.x) / this.scale;
    }

    private float viewToSourceY(float f2) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 - pointF.y) / this.scale;
    }

    public AnimationBuilder animateCenter(PointF pointF) {
        if (isReady()) {
            return new AnimationBuilder(pointF);
        }
        return null;
    }

    public AnimationBuilder animateScale(float f2) {
        if (isReady()) {
            return new AnimationBuilder(f2);
        }
        return null;
    }

    public AnimationBuilder animateScaleAndCenter(float f2, PointF pointF) {
        if (isReady()) {
            return new AnimationBuilder(f2, pointF);
        }
        return null;
    }

    public final int getAppliedOrientation() {
        return getRequiredRotation();
    }

    public final PointF getCenter() {
        return viewToSourceCoord(getWidth() / 2, getHeight() / 2);
    }

    public float getMaxScale() {
        return this.maxScale;
    }

    public final float getMinScale() {
        return minScale();
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final void getPanRemaining(RectF rectF) {
        if (isReady()) {
            float fSWidth = this.scale * sWidth();
            float fSHeight = this.scale * sHeight();
            int i = this.panLimit;
            if (i == 3) {
                rectF.top = Math.max(WheelView.DividerConfig.FILL, -(this.vTranslate.y - (getHeight() / 2.0f)));
                rectF.left = Math.max(WheelView.DividerConfig.FILL, -(this.vTranslate.x - (getWidth() / 2.0f)));
                rectF.bottom = Math.max(WheelView.DividerConfig.FILL, this.vTranslate.y - ((getHeight() / 2.0f) - fSHeight));
                rectF.right = Math.max(WheelView.DividerConfig.FILL, this.vTranslate.x - ((getWidth() / 2.0f) - fSWidth));
                return;
            }
            if (i == 2) {
                rectF.top = Math.max(WheelView.DividerConfig.FILL, -(this.vTranslate.y - getHeight()));
                rectF.left = Math.max(WheelView.DividerConfig.FILL, -(this.vTranslate.x - getWidth()));
                rectF.bottom = Math.max(WheelView.DividerConfig.FILL, this.vTranslate.y + fSHeight);
                rectF.right = Math.max(WheelView.DividerConfig.FILL, this.vTranslate.x + fSWidth);
                return;
            }
            rectF.top = Math.max(WheelView.DividerConfig.FILL, -this.vTranslate.y);
            rectF.left = Math.max(WheelView.DividerConfig.FILL, -this.vTranslate.x);
            rectF.bottom = Math.max(WheelView.DividerConfig.FILL, (fSHeight + this.vTranslate.y) - getHeight());
            rectF.right = Math.max(WheelView.DividerConfig.FILL, (fSWidth + this.vTranslate.x) - getWidth());
        }
    }

    public final int getSHeight() {
        return this.sHeight;
    }

    public final int getSWidth() {
        return this.sWidth;
    }

    public final float getScale() {
        return this.scale;
    }

    public final ImageViewState getState() {
        if (this.vTranslate == null || this.sWidth <= 0 || this.sHeight <= 0) {
            return null;
        }
        return new ImageViewState(getScale(), getCenter(), getOrientation());
    }

    public Uri getUri() {
        return this.uri;
    }

    public boolean hasImage() {
        return (this.uri == null && this.bitmap == null) ? false : true;
    }

    public final boolean isImageLoaded() {
        return this.imageLoadedSent;
    }

    public final boolean isPanEnabled() {
        return this.panEnabled;
    }

    public final boolean isQuickScaleEnabled() {
        return this.quickScaleEnabled;
    }

    public final boolean isReady() {
        return this.readySent;
    }

    public final boolean isZoomEnabled() {
        return this.zoomEnabled;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        float height;
        int i3;
        int i4;
        super.onDraw(canvas);
        createPaints();
        if (this.sWidth == 0 || this.sHeight == 0 || getWidth() == 0 || getHeight() == 0) {
            return;
        }
        if (this.tileMap == null && this.decoder != null) {
            initialiseBaseLayer(getMaxBitmapDimensions(canvas));
        }
        if (checkReady()) {
            preDraw();
            Anim anim = this.anim;
            if (anim != null && anim.vFocusStart != null) {
                float f2 = this.scale;
                if (this.vTranslateBefore == null) {
                    this.vTranslateBefore = new PointF(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL);
                }
                this.vTranslateBefore.set(this.vTranslate);
                long jCurrentTimeMillis = System.currentTimeMillis() - this.anim.time;
                boolean z = jCurrentTimeMillis > this.anim.duration;
                long jMin = Math.min(jCurrentTimeMillis, this.anim.duration);
                this.scale = ease(this.anim.easing, jMin, this.anim.scaleStart, this.anim.scaleEnd - this.anim.scaleStart, this.anim.duration);
                float fEase = ease(this.anim.easing, jMin, this.anim.vFocusStart.x, this.anim.vFocusEnd.x - this.anim.vFocusStart.x, this.anim.duration);
                float fEase2 = ease(this.anim.easing, jMin, this.anim.vFocusStart.y, this.anim.vFocusEnd.y - this.anim.vFocusStart.y, this.anim.duration);
                this.vTranslate.x -= sourceToViewX(this.anim.sCenterEnd.x) - fEase;
                this.vTranslate.y -= sourceToViewY(this.anim.sCenterEnd.y) - fEase2;
                fitToBounds(z || this.anim.scaleStart == this.anim.scaleEnd);
                sendStateChanged(f2, this.vTranslateBefore, this.anim.origin);
                refreshRequiredTiles(z);
                if (z) {
                    if (this.anim.listener != null) {
                        try {
                            this.anim.listener.onComplete();
                        } catch (Exception e2) {
                            Log.w(TAG, "Error thrown by animation listener", e2);
                        }
                    }
                    this.anim = null;
                }
                invalidate();
            }
            if (this.tileMap == null || !isBaseLayerReady()) {
                i = 15;
                i2 = 5;
                if (this.bitmap != null) {
                    float width = this.scale;
                    if (this.bitmapIsPreview) {
                        width *= this.sWidth / r0.getWidth();
                        height = this.scale * (this.sHeight / this.bitmap.getHeight());
                    } else {
                        height = width;
                    }
                    if (this.matrix == null) {
                        this.matrix = new Matrix();
                    }
                    this.matrix.reset();
                    this.matrix.postScale(width, height);
                    this.matrix.postRotate(getRequiredRotation());
                    Matrix matrix = this.matrix;
                    PointF pointF = this.vTranslate;
                    matrix.postTranslate(pointF.x, pointF.y);
                    if (getRequiredRotation() == 180) {
                        Matrix matrix2 = this.matrix;
                        float f3 = this.scale;
                        matrix2.postTranslate(this.sWidth * f3, f3 * this.sHeight);
                    } else if (getRequiredRotation() == 90) {
                        this.matrix.postTranslate(this.scale * this.sHeight, WheelView.DividerConfig.FILL);
                    } else if (getRequiredRotation() == 270) {
                        this.matrix.postTranslate(WheelView.DividerConfig.FILL, this.scale * this.sWidth);
                    }
                    if (this.tileBgPaint != null) {
                        if (this.sRect == null) {
                            this.sRect = new RectF();
                        }
                        this.sRect.set(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, this.bitmapIsPreview ? this.bitmap.getWidth() : this.sWidth, this.bitmapIsPreview ? this.bitmap.getHeight() : this.sHeight);
                        this.matrix.mapRect(this.sRect);
                        canvas.drawRect(this.sRect, this.tileBgPaint);
                    }
                    canvas.drawBitmap(this.bitmap, this.matrix, this.bitmapPaint);
                }
            } else {
                int iMin = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
                boolean z2 = false;
                for (Map.Entry<Integer, List<Tile>> entry : this.tileMap.entrySet()) {
                    if (entry.getKey().intValue() == iMin) {
                        for (Tile tile : entry.getValue()) {
                            if (tile.visible && (tile.loading || tile.bitmap == null)) {
                                z2 = true;
                            }
                        }
                    }
                }
                for (Map.Entry<Integer, List<Tile>> entry2 : this.tileMap.entrySet()) {
                    if (entry2.getKey().intValue() == iMin || z2) {
                        for (Tile tile2 : entry2.getValue()) {
                            sourceToViewRect(tile2.sRect, tile2.vRect);
                            if (tile2.loading || tile2.bitmap == null) {
                                i3 = 15;
                                i4 = 5;
                                if (tile2.loading && this.debug) {
                                    canvas.drawText("LOADING", tile2.vRect.left + px(5), tile2.vRect.top + px(35), this.debugTextPaint);
                                }
                            } else {
                                if (this.tileBgPaint != null) {
                                    canvas.drawRect(tile2.vRect, this.tileBgPaint);
                                }
                                if (this.matrix == null) {
                                    this.matrix = new Matrix();
                                }
                                this.matrix.reset();
                                i4 = 5;
                                i3 = 15;
                                setMatrixArray(this.srcArray, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, tile2.bitmap.getWidth(), WheelView.DividerConfig.FILL, tile2.bitmap.getWidth(), tile2.bitmap.getHeight(), WheelView.DividerConfig.FILL, tile2.bitmap.getHeight());
                                if (getRequiredRotation() == 0) {
                                    setMatrixArray(this.dstArray, tile2.vRect.left, tile2.vRect.top, tile2.vRect.right, tile2.vRect.top, tile2.vRect.right, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.bottom);
                                } else if (getRequiredRotation() == 90) {
                                    setMatrixArray(this.dstArray, tile2.vRect.right, tile2.vRect.top, tile2.vRect.right, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.top);
                                } else if (getRequiredRotation() == 180) {
                                    setMatrixArray(this.dstArray, tile2.vRect.right, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.top, tile2.vRect.right, tile2.vRect.top);
                                } else if (getRequiredRotation() == 270) {
                                    setMatrixArray(this.dstArray, tile2.vRect.left, tile2.vRect.bottom, tile2.vRect.left, tile2.vRect.top, tile2.vRect.right, tile2.vRect.top, tile2.vRect.right, tile2.vRect.bottom);
                                }
                                this.matrix.setPolyToPoly(this.srcArray, 0, this.dstArray, 0, 4);
                                canvas.drawBitmap(tile2.bitmap, this.matrix, this.bitmapPaint);
                                if (this.debug) {
                                    canvas.drawRect(tile2.vRect, this.debugLinePaint);
                                }
                            }
                            if (tile2.visible && this.debug) {
                                canvas.drawText("ISS " + tile2.sampleSize + " RECT " + tile2.sRect.top + "," + tile2.sRect.left + "," + tile2.sRect.bottom + "," + tile2.sRect.right, tile2.vRect.left + px(i4), tile2.vRect.top + px(i3), this.debugTextPaint);
                            }
                        }
                    }
                }
                i = 15;
                i2 = 5;
            }
            if (this.debug) {
                canvas.drawText("Scale: " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.scale)) + " (" + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(minScale())) + " - " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.maxScale)) + ")", px(i2), px(i), this.debugTextPaint);
                StringBuilder sb = new StringBuilder();
                sb.append("Translate: ");
                sb.append(String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.vTranslate.x)));
                sb.append(":");
                sb.append(String.format(Locale.ENGLISH, "%.2f", Float.valueOf(this.vTranslate.y)));
                canvas.drawText(sb.toString(), (float) px(i2), (float) px(30), this.debugTextPaint);
                PointF center = getCenter();
                canvas.drawText("Source center: " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(center.x)) + ":" + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(center.y)), px(i2), px(45), this.debugTextPaint);
                Anim anim2 = this.anim;
                if (anim2 != null) {
                    PointF pointFSourceToViewCoord = sourceToViewCoord(anim2.sCenterStart);
                    PointF pointFSourceToViewCoord2 = sourceToViewCoord(this.anim.sCenterEndRequested);
                    PointF pointFSourceToViewCoord3 = sourceToViewCoord(this.anim.sCenterEnd);
                    canvas.drawCircle(pointFSourceToViewCoord.x, pointFSourceToViewCoord.y, px(10), this.debugLinePaint);
                    this.debugLinePaint.setColor(-65536);
                    canvas.drawCircle(pointFSourceToViewCoord2.x, pointFSourceToViewCoord2.y, px(20), this.debugLinePaint);
                    this.debugLinePaint.setColor(-16776961);
                    canvas.drawCircle(pointFSourceToViewCoord3.x, pointFSourceToViewCoord3.y, px(25), this.debugLinePaint);
                    this.debugLinePaint.setColor(-16711681);
                    canvas.drawCircle(getWidth() / 2, getHeight() / 2, px(30), this.debugLinePaint);
                }
                if (this.vCenterStart != null) {
                    this.debugLinePaint.setColor(-65536);
                    PointF pointF2 = this.vCenterStart;
                    canvas.drawCircle(pointF2.x, pointF2.y, px(20), this.debugLinePaint);
                }
                if (this.quickScaleSCenter != null) {
                    this.debugLinePaint.setColor(-16776961);
                    canvas.drawCircle(sourceToViewX(this.quickScaleSCenter.x), sourceToViewY(this.quickScaleSCenter.y), px(35), this.debugLinePaint);
                }
                if (this.quickScaleVStart != null && this.isQuickScaling) {
                    this.debugLinePaint.setColor(-16711681);
                    PointF pointF3 = this.quickScaleVStart;
                    canvas.drawCircle(pointF3.x, pointF3.y, px(30), this.debugLinePaint);
                }
                this.debugLinePaint.setColor(-65281);
            }
        }
    }

    protected void onImageLoaded() {
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        boolean z = mode != 1073741824;
        boolean z2 = mode2 != 1073741824;
        if (this.sWidth > 0 && this.sHeight > 0) {
            if (z && z2) {
                size = sWidth();
                size2 = sHeight();
            } else if (z2) {
                double dSHeight = sHeight();
                double dSWidth = sWidth();
                Double.isNaN(dSHeight);
                Double.isNaN(dSWidth);
                double d2 = dSHeight / dSWidth;
                double d3 = size;
                Double.isNaN(d3);
                size2 = (int) (d2 * d3);
            } else if (z) {
                double dSWidth2 = sWidth();
                double dSHeight2 = sHeight();
                Double.isNaN(dSWidth2);
                Double.isNaN(dSHeight2);
                double d4 = dSWidth2 / dSHeight2;
                double d5 = size2;
                Double.isNaN(d5);
                size = (int) (d4 * d5);
            }
        }
        setMeasuredDimension(Math.max(size, getSuggestedMinimumWidth()), Math.max(size2, getSuggestedMinimumHeight()));
    }

    protected void onReady() {
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        debug("onSizeChanged %dx%d -> %dx%d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2));
        PointF center = getCenter();
        if (!this.readySent || center == null) {
            return;
        }
        this.anim = null;
        this.pendingScale = Float.valueOf(this.scale);
        this.sPendingCenter = center;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        Anim anim = this.anim;
        if (anim != null && !anim.interruptible) {
            requestDisallowInterceptTouchEvent(true);
            return true;
        }
        Anim anim2 = this.anim;
        if (anim2 != null && anim2.listener != null) {
            try {
                this.anim.listener.onInterruptedByUser();
            } catch (Exception e2) {
                Log.w(TAG, "Error thrown by animation listener", e2);
            }
        }
        this.anim = null;
        if (this.vTranslate == null) {
            GestureDetector gestureDetector2 = this.singleDetector;
            if (gestureDetector2 != null) {
                gestureDetector2.onTouchEvent(motionEvent);
            }
            return true;
        }
        if (!this.isQuickScaling && ((gestureDetector = this.detector) == null || gestureDetector.onTouchEvent(motionEvent))) {
            this.isZooming = false;
            this.isPanning = false;
            this.maxTouchCount = 0;
            return true;
        }
        if (this.vTranslateStart == null) {
            this.vTranslateStart = new PointF(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL);
        }
        if (this.vTranslateBefore == null) {
            this.vTranslateBefore = new PointF(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL);
        }
        if (this.vCenterStart == null) {
            this.vCenterStart = new PointF(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL);
        }
        float f2 = this.scale;
        this.vTranslateBefore.set(this.vTranslate);
        boolean zOnTouchEventInternal = onTouchEventInternal(motionEvent);
        sendStateChanged(f2, this.vTranslateBefore, 2);
        return zOnTouchEventInternal || super.onTouchEvent(motionEvent);
    }

    public void recycle() {
        reset(true);
        this.bitmapPaint = null;
        this.debugTextPaint = null;
        this.debugLinePaint = null;
        this.tileBgPaint = null;
    }

    public final void resetScaleAndCenter() {
        this.anim = null;
        this.pendingScale = Float.valueOf(limitedScale(WheelView.DividerConfig.FILL));
        if (isReady()) {
            this.sPendingCenter = new PointF(sWidth() / 2, sHeight() / 2);
        } else {
            this.sPendingCenter = new PointF(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL);
        }
        invalidate();
    }

    public final void setBitmapAndFileUri(Bitmap bitmap, Uri uri) {
        int maxLoader = Utils.getMaxLoader();
        if (bitmap == null || bitmap.getWidth() >= maxLoader || bitmap.getHeight() >= maxLoader) {
            if (uri != null) {
                setImage(ImageSource.uri(uri));
                return;
            }
            return;
        }
        float height = bitmap.getHeight();
        float screenHeight = Utils.getScreenHeight(getContext()) / height;
        float screenWidth = Utils.getScreenWidth(getContext()) / bitmap.getWidth();
        float fMax = Math.max(screenWidth, screenHeight);
        setMaxScale(fMax * 10.0f);
        setDoubleTapZoomScale(fMax * 2.0f);
        setImage(ImageSource.bitmap(bitmap));
        if (screenWidth / screenHeight >= 1.5d) {
            setMaxScale(10.0f * screenWidth);
            setScaleAndCenter(screenWidth, new PointF((getWidth() / screenWidth) / 2.0f, (getHeight() / screenWidth) / 2.0f));
        }
    }

    public final void setBitmapDecoderClass(Class<? extends ImageDecoder> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("Decoder class cannot be set to null");
        }
        this.bitmapDecoderFactory = new CompatDecoderFactory(cls);
    }

    public final void setBitmapDecoderFactory(DecoderFactory<? extends ImageDecoder> decoderFactory) {
        if (decoderFactory == null) {
            throw new IllegalArgumentException("Decoder factory cannot be set to null");
        }
        this.bitmapDecoderFactory = decoderFactory;
    }

    public final void setBitmapFitX(Bitmap bitmap) {
        int maxLoader = Utils.getMaxLoader();
        if (bitmap == null || bitmap.getWidth() >= maxLoader || bitmap.getHeight() >= maxLoader) {
            return;
        }
        setImage(ImageSource.bitmap(bitmap));
        float screenWidth = Utils.getScreenWidth(getContext()) / bitmap.getWidth();
        setMaxScale(10.0f * screenWidth);
        setScaleAndCenter(screenWidth, new PointF((getWidth() / screenWidth) / 2.0f, (getHeight() / screenWidth) / 2.0f));
    }

    public final void setDebug(boolean z) {
        this.debug = z;
    }

    public final void setDoubleTapZoomDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setDoubleTapZoomScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i);
    }

    public final void setDoubleTapZoomDuration(int i) {
        this.doubleTapZoomDuration = Math.max(0, i);
    }

    public final void setDoubleTapZoomScale(float f2) {
        this.doubleTapZoomScale = f2;
    }

    public final void setDoubleTapZoomStyle(int i) {
        if (VALID_ZOOM_STYLES.contains(Integer.valueOf(i))) {
            this.doubleTapZoomStyle = i;
            return;
        }
        throw new IllegalArgumentException("Invalid zoom style: " + i);
    }

    public void setEagerLoadingEnabled(boolean z) {
        this.eagerLoadingEnabled = z;
    }

    public void setExecutor(Executor executor) {
        if (executor == null) {
            throw new NullPointerException("Executor must not be null");
        }
        this.executor = executor;
    }

    public final void setImage(ImageSource imageSource) {
        setImage(imageSource, null, null);
    }

    public final void setMaxScale(float f2) {
        this.maxScale = f2;
    }

    public void setMaxTileSize(int i) {
        this.maxTileWidth = i;
        this.maxTileHeight = i;
    }

    public final void setMaximumDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMinScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i);
    }

    public final void setMinScale(float f2) {
        this.minScale = f2;
    }

    public final void setMinimumDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMaxScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / i);
    }

    public final void setMinimumScaleType(int i) {
        if (!VALID_SCALE_TYPES.contains(Integer.valueOf(i))) {
            throw new IllegalArgumentException("Invalid scale type: " + i);
        }
        this.minimumScaleType = i;
        if (isReady()) {
            fitToBounds(true);
            invalidate();
        }
    }

    public void setMinimumTileDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.minimumTileDpi = (int) Math.min((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f, i);
        if (isReady()) {
            reset(false);
            invalidate();
        }
    }

    public void setOnImageEventListener(OnImageEventListener onImageEventListener) {
        this.onImageEventListener = onImageEventListener;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener) {
        this.onStateChangedListener = onStateChangedListener;
    }

    public final void setOrientation(int i) {
        if (!VALID_ORIENTATIONS.contains(Integer.valueOf(i))) {
            throw new IllegalArgumentException("Invalid orientation: " + i);
        }
        this.orientation = i;
        reset(false);
        invalidate();
        requestLayout();
    }

    public final void setPanEnabled(boolean z) {
        PointF pointF;
        this.panEnabled = z;
        if (z || (pointF = this.vTranslate) == null) {
            return;
        }
        pointF.x = (getWidth() / 2.0f) - (this.scale * (sWidth() / 2.0f));
        this.vTranslate.y = (getHeight() / 2.0f) - (this.scale * (sHeight() / 2.0f));
        if (isReady()) {
            refreshRequiredTiles(true);
            invalidate();
        }
    }

    public final void setPanLimit(int i) {
        if (!VALID_PAN_LIMITS.contains(Integer.valueOf(i))) {
            throw new IllegalArgumentException("Invalid pan limit: " + i);
        }
        this.panLimit = i;
        if (isReady()) {
            fitToBounds(true);
            invalidate();
        }
    }

    public final void setQuickScaleEnabled(boolean z) {
        this.quickScaleEnabled = z;
    }

    public final void setRegionDecoderClass(Class<? extends ImageRegionDecoder> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("Decoder class cannot be set to null");
        }
        this.regionDecoderFactory = new CompatDecoderFactory(cls);
    }

    public final void setRegionDecoderFactory(DecoderFactory<? extends ImageRegionDecoder> decoderFactory) {
        if (decoderFactory == null) {
            throw new IllegalArgumentException("Decoder factory cannot be set to null");
        }
        this.regionDecoderFactory = decoderFactory;
    }

    public final void setScaleAndCenter(float f2, PointF pointF) {
        this.anim = null;
        this.pendingScale = Float.valueOf(f2);
        this.sPendingCenter = pointF;
        this.sRequestedCenter = pointF;
        invalidate();
    }

    public final void setTileBackgroundColor(int i) {
        if (Color.alpha(i) == 0) {
            this.tileBgPaint = null;
        } else {
            this.tileBgPaint = new Paint();
            this.tileBgPaint.setStyle(Paint.Style.FILL);
            this.tileBgPaint.setColor(i);
        }
        invalidate();
    }

    public final void setZoomEnabled(boolean z) {
        this.zoomEnabled = z;
    }

    public final PointF sourceToViewCoord(PointF pointF) {
        return sourceToViewCoord(pointF.x, pointF.y, new PointF());
    }

    public void suitMaxScaleWithSize(int i, int i2) {
        int maxLoader = Utils.getMaxLoader();
        if (i >= maxLoader || i2 >= maxLoader) {
            return;
        }
        float screenHeight = (Utils.getScreenHeight(getContext()) * 1.0f) / i2;
        float screenWidth = (Utils.getScreenWidth(getContext()) * 1.0f) / i;
        float fMax = Math.max(screenWidth, screenHeight);
        setMaxScale(fMax * 10.0f);
        setDoubleTapZoomScale(fMax * 2.0f);
        if (screenWidth / screenHeight >= 1.5d) {
            setMaxScale(10.0f * screenWidth);
            setScaleAndCenter(screenWidth, new PointF((getWidth() / screenWidth) / 2.0f, (getHeight() / screenWidth) / 2.0f));
        }
    }

    public void viewToFileRect(Rect rect, Rect rect2) {
        if (this.vTranslate == null || !this.readySent) {
            return;
        }
        rect2.set((int) viewToSourceX(rect.left), (int) viewToSourceY(rect.top), (int) viewToSourceX(rect.right), (int) viewToSourceY(rect.bottom));
        fileSRect(rect2, rect2);
        rect2.set(Math.max(0, rect2.left), Math.max(0, rect2.top), Math.min(this.sWidth, rect2.right), Math.min(this.sHeight, rect2.bottom));
        Rect rect3 = this.sRegion;
        if (rect3 != null) {
            rect2.offset(rect3.left, rect3.top);
        }
    }

    public final PointF viewToSourceCoord(PointF pointF) {
        return viewToSourceCoord(pointF.x, pointF.y, new PointF());
    }

    public void visibleFileRect(Rect rect) {
        if (this.vTranslate == null || !this.readySent) {
            return;
        }
        rect.set(0, 0, getWidth(), getHeight());
        viewToFileRect(rect, rect);
    }

    public final void setImage(ImageSource imageSource, ImageViewState imageViewState) {
        setImage(imageSource, null, imageViewState);
    }

    public final PointF sourceToViewCoord(float f2, float f3) {
        return sourceToViewCoord(f2, f3, new PointF());
    }

    public final PointF viewToSourceCoord(float f2, float f3) {
        return viewToSourceCoord(f2, f3, new PointF());
    }

    public final void setImage(ImageSource imageSource, ImageSource imageSource2) {
        setImage(imageSource, imageSource2, null);
    }

    public void setMaxTileSize(int i, int i2) {
        this.maxTileWidth = i;
        this.maxTileHeight = i2;
    }

    public final PointF sourceToViewCoord(PointF pointF, PointF pointF2) {
        return sourceToViewCoord(pointF.x, pointF.y, pointF2);
    }

    public final PointF viewToSourceCoord(PointF pointF, PointF pointF2) {
        return viewToSourceCoord(pointF.x, pointF.y, pointF2);
    }

    public final class AnimationBuilder {
        private long duration;
        private int easing;
        private boolean interruptible;
        private OnAnimationEventListener listener;
        private int origin;
        private boolean panLimited;
        private final PointF targetSCenter;
        private final float targetScale;
        private final PointF vFocus;

        static /* synthetic */ AnimationBuilder access$1200(AnimationBuilder animationBuilder, boolean z) {
            animationBuilder.withPanLimited(z);
            return animationBuilder;
        }

        static /* synthetic */ AnimationBuilder access$1300(AnimationBuilder animationBuilder, int i) {
            animationBuilder.withOrigin(i);
            return animationBuilder;
        }

        private AnimationBuilder withOrigin(int i) {
            this.origin = i;
            return this;
        }

        private AnimationBuilder withPanLimited(boolean z) {
            this.panLimited = z;
            return this;
        }

        public void start() {
            PointF pointF;
            if (SubsamplingScaleImageView.this.anim != null && SubsamplingScaleImageView.this.anim.listener != null) {
                try {
                    SubsamplingScaleImageView.this.anim.listener.onInterruptedByNewAnim();
                } catch (Exception e2) {
                    Log.w(SubsamplingScaleImageView.TAG, "Error thrown by animation listener", e2);
                }
            }
            int paddingLeft = SubsamplingScaleImageView.this.getPaddingLeft() + (((SubsamplingScaleImageView.this.getWidth() - SubsamplingScaleImageView.this.getPaddingRight()) - SubsamplingScaleImageView.this.getPaddingLeft()) / 2);
            int paddingTop = SubsamplingScaleImageView.this.getPaddingTop() + (((SubsamplingScaleImageView.this.getHeight() - SubsamplingScaleImageView.this.getPaddingBottom()) - SubsamplingScaleImageView.this.getPaddingTop()) / 2);
            float fLimitedScale = SubsamplingScaleImageView.this.limitedScale(this.targetScale);
            if (this.panLimited) {
                SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                PointF pointF2 = this.targetSCenter;
                float f2 = pointF2.x;
                float f3 = pointF2.y;
                pointF = new PointF();
                SubsamplingScaleImageView.access$6600(subsamplingScaleImageView, f2, f3, fLimitedScale, pointF);
            } else {
                pointF = this.targetSCenter;
            }
            SubsamplingScaleImageView.this.anim = new Anim();
            SubsamplingScaleImageView.this.anim.scaleStart = SubsamplingScaleImageView.this.scale;
            SubsamplingScaleImageView.this.anim.scaleEnd = fLimitedScale;
            SubsamplingScaleImageView.this.anim.time = System.currentTimeMillis();
            SubsamplingScaleImageView.this.anim.sCenterEndRequested = pointF;
            SubsamplingScaleImageView.this.anim.sCenterStart = SubsamplingScaleImageView.this.getCenter();
            SubsamplingScaleImageView.this.anim.sCenterEnd = pointF;
            SubsamplingScaleImageView.this.anim.vFocusStart = SubsamplingScaleImageView.this.sourceToViewCoord(pointF);
            SubsamplingScaleImageView.this.anim.vFocusEnd = new PointF(paddingLeft, paddingTop);
            SubsamplingScaleImageView.this.anim.duration = this.duration;
            SubsamplingScaleImageView.this.anim.interruptible = this.interruptible;
            SubsamplingScaleImageView.this.anim.easing = this.easing;
            SubsamplingScaleImageView.this.anim.origin = this.origin;
            SubsamplingScaleImageView.this.anim.time = System.currentTimeMillis();
            SubsamplingScaleImageView.this.anim.listener = this.listener;
            PointF pointF3 = this.vFocus;
            if (pointF3 != null) {
                float f4 = pointF3.x - (SubsamplingScaleImageView.this.anim.sCenterStart.x * fLimitedScale);
                float f5 = this.vFocus.y - (SubsamplingScaleImageView.this.anim.sCenterStart.y * fLimitedScale);
                ScaleAndTranslate scaleAndTranslate = new ScaleAndTranslate(fLimitedScale, new PointF(f4, f5));
                SubsamplingScaleImageView.this.fitToBounds(true, scaleAndTranslate);
                SubsamplingScaleImageView.this.anim.vFocusEnd = new PointF(this.vFocus.x + (scaleAndTranslate.vTranslate.x - f4), this.vFocus.y + (scaleAndTranslate.vTranslate.y - f5));
            }
            SubsamplingScaleImageView.this.invalidate();
        }

        public AnimationBuilder withDuration(long j) {
            this.duration = j;
            return this;
        }

        public AnimationBuilder withEasing(int i) {
            if (SubsamplingScaleImageView.VALID_EASING_STYLES.contains(Integer.valueOf(i))) {
                this.easing = i;
                return this;
            }
            throw new IllegalArgumentException("Unknown easing type: " + i);
        }

        public AnimationBuilder withInterruptible(boolean z) {
            this.interruptible = z;
            return this;
        }

        public AnimationBuilder withOnAnimationEventListener(OnAnimationEventListener onAnimationEventListener) {
            this.listener = onAnimationEventListener;
            return this;
        }

        private AnimationBuilder(PointF pointF) {
            this.duration = 500L;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = SubsamplingScaleImageView.this.scale;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        private AnimationBuilder(float f2) {
            this.duration = 500L;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f2;
            this.targetSCenter = SubsamplingScaleImageView.this.getCenter();
            this.vFocus = null;
        }

        private AnimationBuilder(float f2, PointF pointF) {
            this.duration = 500L;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f2;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        private AnimationBuilder(float f2, PointF pointF, PointF pointF2) {
            this.duration = 500L;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f2;
            this.targetSCenter = pointF;
            this.vFocus = pointF2;
        }
    }

    public final void setImage(ImageSource imageSource, ImageSource imageSource2, ImageViewState imageViewState) {
        if (imageSource != null) {
            reset(true);
            if (imageViewState != null) {
                restoreState(imageViewState);
            }
            if (imageSource2 != null) {
                if (imageSource.getBitmap() == null) {
                    if (imageSource.getSWidth() > 0 && imageSource.getSHeight() > 0) {
                        this.sWidth = imageSource.getSWidth();
                        this.sHeight = imageSource.getSHeight();
                        this.pRegion = imageSource2.getSRegion();
                        if (imageSource2.getBitmap() != null) {
                            this.bitmapIsCached = imageSource2.isCached();
                            onPreviewLoaded(imageSource2.getBitmap());
                        } else {
                            Uri uri = imageSource2.getUri();
                            if (uri == null && imageSource2.getResource() != null) {
                                uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + imageSource2.getResource());
                            }
                            execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, uri, true));
                        }
                    } else {
                        throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
                    }
                } else {
                    throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
                }
            }
            if (imageSource.getBitmap() != null && imageSource.getSRegion() != null) {
                onImageLoaded(Bitmap.createBitmap(imageSource.getBitmap(), imageSource.getSRegion().left, imageSource.getSRegion().top, imageSource.getSRegion().width(), imageSource.getSRegion().height()), 0, false);
                return;
            }
            if (imageSource.getBitmap() != null) {
                onImageLoaded(imageSource.getBitmap(), 0, imageSource.isCached());
                return;
            }
            this.sRegion = imageSource.getSRegion();
            this.uri = imageSource.getUri();
            if (this.uri == null && imageSource.getResource() != null) {
                this.uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + imageSource.getResource());
            }
            if (!imageSource.getTile() && this.sRegion == null) {
                execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, this.uri, false));
                return;
            } else {
                execute(new TilesInitTask(this, getContext(), this.regionDecoderFactory, this.uri));
                return;
            }
        }
        throw new NullPointerException("imageSource must not be null");
    }

    public final PointF sourceToViewCoord(float f2, float f3, PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(sourceToViewX(f2), sourceToViewY(f3));
        return pointF;
    }

    public final PointF viewToSourceCoord(float f2, float f3, PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(viewToSourceX(f2), viewToSourceY(f3));
        return pointF;
    }

    private void fitToBounds(boolean z) {
        boolean z2;
        PointF pointF = this.vTranslate;
        float f2 = WheelView.DividerConfig.FILL;
        if (pointF == null) {
            z2 = true;
            this.vTranslate = new PointF(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL);
        } else {
            z2 = false;
        }
        if (this.satTemp == null) {
            this.satTemp = new ScaleAndTranslate(f2, new PointF(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL));
        }
        this.satTemp.scale = this.scale;
        this.satTemp.vTranslate.set(this.vTranslate);
        fitToBounds(z, this.satTemp);
        this.scale = this.satTemp.scale;
        this.vTranslate.set(this.satTemp.vTranslate);
        if (!z2 || this.minimumScaleType == 4) {
            return;
        }
        this.vTranslate.set(vTranslateForSCenter(sWidth() / 2, sHeight() / 2, this.scale));
    }

    public SubsamplingScaleImageView(Context context) {
        this(context, null);
    }
}
