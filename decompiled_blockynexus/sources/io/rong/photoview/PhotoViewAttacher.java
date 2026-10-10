package io.rong.photoview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import androidx.core.view.C0321i;
import cn.qqtheme.framework.widget.WheelView;
import io.rong.photoview.gestures.OnGestureListener;
import io.rong.photoview.gestures.VersionedGestureDetector;
import io.rong.photoview.log.LogManager;
import io.rong.photoview.scrollerproxy.ScrollerProxy;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes5.dex */
public class PhotoViewAttacher implements View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener, IPhotoView, OnGestureListener {
    static final int EDGE_BOTH = 2;
    static final int EDGE_LEFT = 0;
    static final int EDGE_NONE = -1;
    static final int EDGE_RIGHT = 1;
    int ZOOM_DURATION;
    private boolean mAllowParentInterceptOnEdge;
    protected final Matrix mBaseMatrix;
    private float mBaseRotation;
    private boolean mBlockParentIntercept;
    private FlingRunnable mCurrentFlingRunnable;
    private final RectF mDisplayRect;
    private final Matrix mDrawMatrix;
    private GestureDetector mGestureDetector;
    private WeakReference<ImageView> mImageView;
    private int mIvBottom;
    private int mIvLeft;
    private int mIvRight;
    private int mIvTop;
    private View.OnLongClickListener mLongClickListener;
    private OnMatrixChangedListener mMatrixChangeListener;
    private final float[] mMatrixValues;
    private float mMaxScale;
    private float mMidScale;
    private float mMinScale;
    private OnPhotoTapListener mPhotoTapListener;
    private OnScaleChangeListener mScaleChangeListener;
    private io.rong.photoview.gestures.GestureDetector mScaleDragDetector;
    private ImageView.ScaleType mScaleType;
    private int mScrollEdge;
    private OnSingleFlingListener mSingleFlingListener;
    private final Matrix mSuppMatrix;
    private OnViewTapListener mViewTapListener;
    private boolean mZoomEnabled;
    private static final String LOG_TAG = "PhotoViewAttacher";
    private static final boolean DEBUG = Log.isLoggable(LOG_TAG, 3);
    static final Interpolator sInterpolator = new AccelerateDecelerateInterpolator();
    static int SINGLE_TOUCH = 1;

    /* JADX INFO: renamed from: io.rong.photoview.PhotoViewAttacher$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType = new int[ImageView.ScaleType.values().length];

        static {
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private class AnimatedZoomRunnable implements Runnable {
        private final float mFocalX;
        private final float mFocalY;
        private final long mStartTime = System.currentTimeMillis();
        private final float mZoomEnd;
        private final float mZoomStart;

        public AnimatedZoomRunnable(float f2, float f3, float f4, float f5) {
            this.mFocalX = f4;
            this.mFocalY = f5;
            this.mZoomStart = f2;
            this.mZoomEnd = f3;
        }

        private float interpolate() {
            return PhotoViewAttacher.sInterpolator.getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.mStartTime) * 1.0f) / PhotoViewAttacher.this.ZOOM_DURATION));
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView = PhotoViewAttacher.this.getImageView();
            if (imageView == null) {
                return;
            }
            float fInterpolate = interpolate();
            float f2 = this.mZoomStart;
            PhotoViewAttacher.this.onScale((f2 + ((this.mZoomEnd - f2) * fInterpolate)) / PhotoViewAttacher.this.getScale(), this.mFocalX, this.mFocalY);
            if (fInterpolate < 1.0f) {
                Compat.postOnAnimation(imageView, this);
            }
        }
    }

    private class FlingRunnable implements Runnable {
        private int mCurrentX;
        private int mCurrentY;
        private final ScrollerProxy mScroller;

        public FlingRunnable(Context context) {
            this.mScroller = ScrollerProxy.getScroller(context);
        }

        public void cancelFling() {
            if (PhotoViewAttacher.DEBUG) {
                LogManager.getLogger().d(PhotoViewAttacher.LOG_TAG, "Cancel Fling");
            }
            this.mScroller.forceFinished(true);
        }

        public void fling(int i, int i2, int i3, int i4) {
            int i5;
            int iRound;
            int i6;
            int iRound2;
            RectF displayRect = PhotoViewAttacher.this.getDisplayRect();
            if (displayRect == null) {
                return;
            }
            int iRound3 = Math.round(-displayRect.left);
            float f2 = i;
            if (f2 < displayRect.width()) {
                iRound = Math.round(displayRect.width() - f2);
                i5 = 0;
            } else {
                i5 = iRound3;
                iRound = i5;
            }
            int iRound4 = Math.round(-displayRect.top);
            float f3 = i2;
            if (f3 < displayRect.height()) {
                iRound2 = Math.round(displayRect.height() - f3);
                i6 = 0;
            } else {
                i6 = iRound4;
                iRound2 = i6;
            }
            this.mCurrentX = iRound3;
            this.mCurrentY = iRound4;
            if (PhotoViewAttacher.DEBUG) {
                LogManager.getLogger().d(PhotoViewAttacher.LOG_TAG, "fling. StartX:" + iRound3 + " StartY:" + iRound4 + " MaxX:" + iRound + " MaxY:" + iRound2);
            }
            if (iRound3 == iRound && iRound4 == iRound2) {
                return;
            }
            this.mScroller.fling(iRound3, iRound4, i3, i4, i5, iRound, i6, iRound2, 0, 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView imageView;
            if (this.mScroller.isFinished() || (imageView = PhotoViewAttacher.this.getImageView()) == null || !this.mScroller.computeScrollOffset()) {
                return;
            }
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (PhotoViewAttacher.DEBUG) {
                LogManager.getLogger().d(PhotoViewAttacher.LOG_TAG, "fling run(). CurrentX:" + this.mCurrentX + " CurrentY:" + this.mCurrentY + " NewX:" + currX + " NewY:" + currY);
            }
            PhotoViewAttacher.this.mSuppMatrix.postTranslate(this.mCurrentX - currX, this.mCurrentY - currY);
            PhotoViewAttacher photoViewAttacher = PhotoViewAttacher.this;
            photoViewAttacher.setImageViewMatrix(photoViewAttacher.getDrawMatrix());
            this.mCurrentX = currX;
            this.mCurrentY = currY;
            Compat.postOnAnimation(imageView, this);
        }
    }

    public interface OnMatrixChangedListener {
        void onMatrixChanged(RectF rectF);
    }

    public interface OnPhotoTapListener {
        void onOutsidePhotoTap();

        void onPhotoTap(View view, float f2, float f3);
    }

    public interface OnScaleChangeListener {
        void onScaleChange(float f2, float f3, float f4);
    }

    public interface OnSingleFlingListener {
        boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3);
    }

    public interface OnViewTapListener {
        void onViewTap(View view, float f2, float f3);
    }

    public PhotoViewAttacher(ImageView imageView) {
        this(imageView, true);
    }

    private void cancelFling() {
        FlingRunnable flingRunnable = this.mCurrentFlingRunnable;
        if (flingRunnable != null) {
            flingRunnable.cancelFling();
            this.mCurrentFlingRunnable = null;
        }
    }

    private void checkAndDisplayMatrix() {
        if (checkMatrixBounds()) {
            setImageViewMatrix(getDrawMatrix());
        }
    }

    private void checkImageViewScaleType() {
        ImageView imageView = getImageView();
        if (imageView != null && !(imageView instanceof IPhotoView) && !ImageView.ScaleType.MATRIX.equals(imageView.getScaleType())) {
            throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
        }
    }

    private boolean checkMatrixBounds() {
        RectF displayRect;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        ImageView imageView = getImageView();
        if (imageView == null || (displayRect = getDisplayRect(getDrawMatrix())) == null) {
            return false;
        }
        float fHeight = displayRect.height();
        float fWidth = displayRect.width();
        float imageViewHeight = getImageViewHeight(imageView);
        float f8 = WheelView.DividerConfig.FILL;
        if (fHeight <= imageViewHeight) {
            int i = AnonymousClass2.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    imageViewHeight = (imageViewHeight - fHeight) / 2.0f;
                    f3 = displayRect.top;
                } else {
                    imageViewHeight -= fHeight;
                    f3 = displayRect.top;
                }
            } else {
                f2 = displayRect.top;
                f4 = -f2;
            }
        } else {
            f2 = displayRect.top;
            if (f2 > WheelView.DividerConfig.FILL) {
                f4 = -f2;
            } else {
                f3 = displayRect.bottom;
                f4 = f3 < imageViewHeight ? imageViewHeight - f3 : WheelView.DividerConfig.FILL;
            }
        }
        float imageViewWidth = getImageViewWidth(imageView);
        if (fWidth <= imageViewWidth) {
            int i2 = AnonymousClass2.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    f6 = (imageViewWidth - fWidth) / 2.0f;
                    f7 = displayRect.left;
                } else {
                    f6 = imageViewWidth - fWidth;
                    f7 = displayRect.left;
                }
                f5 = f6 - f7;
            } else {
                f5 = -displayRect.left;
            }
            f8 = f5;
            this.mScrollEdge = 2;
        } else {
            float f9 = displayRect.left;
            if (f9 > WheelView.DividerConfig.FILL) {
                this.mScrollEdge = 0;
                f8 = -f9;
            } else {
                float f10 = displayRect.right;
                if (f10 < imageViewWidth) {
                    f8 = imageViewWidth - f10;
                    this.mScrollEdge = 1;
                } else {
                    this.mScrollEdge = -1;
                }
            }
        }
        this.mSuppMatrix.postTranslate(f8, f4);
        return true;
    }

    private static void checkZoomLevels(float f2, float f3, float f4) {
        if (f2 >= f3) {
            throw new IllegalArgumentException("MinZoom has to be less than MidZoom");
        }
        if (f3 >= f4) {
            throw new IllegalArgumentException("MidZoom has to be less than MaxZoom");
        }
    }

    private float getValue(Matrix matrix, int i) {
        matrix.getValues(this.mMatrixValues);
        return this.mMatrixValues[i];
    }

    private static boolean hasDrawable(ImageView imageView) {
        return (imageView == null || imageView.getDrawable() == null) ? false : true;
    }

    private static boolean isSupportedScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if (scaleType != ImageView.ScaleType.MATRIX) {
            return true;
        }
        throw new IllegalArgumentException(scaleType.name() + " is not supported in PhotoView");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageViewMatrix(Matrix matrix) {
        RectF displayRect;
        ImageView imageView = getImageView();
        if (imageView != null) {
            checkImageViewScaleType();
            imageView.setImageMatrix(matrix);
            if (this.mMatrixChangeListener == null || (displayRect = getDisplayRect(matrix)) == null) {
                return;
            }
            this.mMatrixChangeListener.onMatrixChanged(displayRect);
        }
    }

    private static void setImageViewScaleTypeMatrix(ImageView imageView) {
        if (imageView == null || (imageView instanceof IPhotoView) || ImageView.ScaleType.MATRIX.equals(imageView.getScaleType())) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
    }

    @Override // io.rong.photoview.IPhotoView
    public boolean canZoom() {
        return this.mZoomEnabled;
    }

    public void cleanup() {
        WeakReference<ImageView> weakReference = this.mImageView;
        if (weakReference == null) {
            return;
        }
        ImageView imageView = weakReference.get();
        if (imageView != null) {
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this);
            }
            imageView.setOnTouchListener(null);
            cancelFling();
        }
        GestureDetector gestureDetector = this.mGestureDetector;
        if (gestureDetector != null) {
            gestureDetector.setOnDoubleTapListener(null);
        }
        this.mMatrixChangeListener = null;
        this.mPhotoTapListener = null;
        this.mViewTapListener = null;
        this.mImageView = null;
    }

    @Override // io.rong.photoview.IPhotoView
    public Matrix getDisplayMatrix() {
        return new Matrix(getDrawMatrix());
    }

    @Override // io.rong.photoview.IPhotoView
    public RectF getDisplayRect() {
        checkMatrixBounds();
        return getDisplayRect(getDrawMatrix());
    }

    public Matrix getDrawMatrix() {
        this.mDrawMatrix.set(this.mBaseMatrix);
        this.mDrawMatrix.postConcat(this.mSuppMatrix);
        return this.mDrawMatrix;
    }

    @Override // io.rong.photoview.IPhotoView
    public IPhotoView getIPhotoViewImplementation() {
        return this;
    }

    public ImageView getImageView() {
        WeakReference<ImageView> weakReference = this.mImageView;
        ImageView imageView = weakReference != null ? weakReference.get() : null;
        if (imageView == null) {
            cleanup();
            LogManager.getLogger().i(LOG_TAG, "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
        }
        return imageView;
    }

    protected int getImageViewHeight(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    protected int getImageViewWidth(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    @Override // io.rong.photoview.IPhotoView
    @Deprecated
    public float getMaxScale() {
        return getMaximumScale();
    }

    @Override // io.rong.photoview.IPhotoView
    public float getMaximumScale() {
        return this.mMaxScale;
    }

    @Override // io.rong.photoview.IPhotoView
    public float getMediumScale() {
        return this.mMidScale;
    }

    @Override // io.rong.photoview.IPhotoView
    @Deprecated
    public float getMidScale() {
        return getMediumScale();
    }

    @Override // io.rong.photoview.IPhotoView
    @Deprecated
    public float getMinScale() {
        return getMinimumScale();
    }

    @Override // io.rong.photoview.IPhotoView
    public float getMinimumScale() {
        return this.mMinScale;
    }

    @Override // io.rong.photoview.IPhotoView
    public OnPhotoTapListener getOnPhotoTapListener() {
        return this.mPhotoTapListener;
    }

    @Override // io.rong.photoview.IPhotoView
    public OnViewTapListener getOnViewTapListener() {
        return this.mViewTapListener;
    }

    @Override // io.rong.photoview.IPhotoView
    public float getScale() {
        return (float) Math.sqrt(((float) Math.pow(getValue(this.mSuppMatrix, 0), 2.0d)) + ((float) Math.pow(getValue(this.mSuppMatrix, 3), 2.0d)));
    }

    @Override // io.rong.photoview.IPhotoView
    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    @Override // io.rong.photoview.IPhotoView
    public Bitmap getVisibleRectangleBitmap() {
        ImageView imageView = getImageView();
        if (imageView == null) {
            return null;
        }
        return imageView.getDrawingCache();
    }

    @Override // io.rong.photoview.gestures.OnGestureListener
    public void onDrag(float f2, float f3) {
        if (this.mScaleDragDetector.isScaling()) {
            return;
        }
        if (DEBUG) {
            LogManager.getLogger().d(LOG_TAG, String.format("onDrag: dx: %.2f. dy: %.2f", Float.valueOf(f2), Float.valueOf(f3)));
        }
        ImageView imageView = getImageView();
        this.mSuppMatrix.postTranslate(f2, f3);
        checkAndDisplayMatrix();
        ViewParent parent = imageView.getParent();
        if (!this.mAllowParentInterceptOnEdge || this.mScaleDragDetector.isScaling() || this.mBlockParentIntercept) {
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
                return;
            }
            return;
        }
        int i = this.mScrollEdge;
        if ((i == 2 || ((i == 0 && f2 >= 1.0f) || (this.mScrollEdge == 1 && f2 <= -1.0f))) && parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }

    @Override // io.rong.photoview.gestures.OnGestureListener
    public void onFling(float f2, float f3, float f4, float f5) {
        if (DEBUG) {
            LogManager.getLogger().d(LOG_TAG, "onFling. sX: " + f2 + " sY: " + f3 + " Vx: " + f4 + " Vy: " + f5);
        }
        ImageView imageView = getImageView();
        this.mCurrentFlingRunnable = new FlingRunnable(imageView.getContext());
        this.mCurrentFlingRunnable.fling(getImageViewWidth(imageView), getImageViewHeight(imageView), (int) f4, (int) f5);
        imageView.post(this.mCurrentFlingRunnable);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        ImageView imageView = getImageView();
        if (imageView != null) {
            if (!this.mZoomEnabled) {
                updateBaseMatrix(imageView.getDrawable());
                return;
            }
            int top = imageView.getTop();
            int right = imageView.getRight();
            int bottom = imageView.getBottom();
            int left = imageView.getLeft();
            if (top == this.mIvTop && bottom == this.mIvBottom && left == this.mIvLeft && right == this.mIvRight) {
                return;
            }
            updateBaseMatrix(imageView.getDrawable());
            this.mIvTop = top;
            this.mIvRight = right;
            this.mIvBottom = bottom;
            this.mIvLeft = left;
        }
    }

    @Override // io.rong.photoview.gestures.OnGestureListener
    public void onScale(float f2, float f3, float f4) {
        if (DEBUG) {
            LogManager.getLogger().d(LOG_TAG, String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)));
        }
        if (getScale() < this.mMaxScale || f2 < 1.0f) {
            if (getScale() > this.mMinScale || f2 > 1.0f) {
                OnScaleChangeListener onScaleChangeListener = this.mScaleChangeListener;
                if (onScaleChangeListener != null) {
                    onScaleChangeListener.onScaleChange(f2, f3, f4);
                }
                this.mSuppMatrix.postScale(f2, f2, f3, f4);
                checkAndDisplayMatrix();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0095  */
    @Override // android.view.View.OnTouchListener
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            boolean r0 = r10.mZoomEnabled
            r1 = 0
            r2 = 1
            if (r0 == 0) goto La1
            r0 = r11
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            boolean r0 = hasDrawable(r0)
            if (r0 == 0) goto La1
            android.view.ViewParent r0 = r11.getParent()
            int r3 = r12.getAction()
            if (r3 == 0) goto L49
            if (r3 == r2) goto L1f
            r0 = 3
            if (r3 == r0) goto L1f
            goto L5d
        L1f:
            float r0 = r10.getScale()
            float r3 = r10.mMinScale
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L5d
            android.graphics.RectF r0 = r10.getDisplayRect()
            if (r0 == 0) goto L5d
            io.rong.photoview.PhotoViewAttacher$AnimatedZoomRunnable r9 = new io.rong.photoview.PhotoViewAttacher$AnimatedZoomRunnable
            float r5 = r10.getScale()
            float r6 = r10.mMinScale
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
            r11 = 1
            goto L5e
        L49:
            if (r0 == 0) goto L4f
            r0.requestDisallowInterceptTouchEvent(r2)
            goto L5a
        L4f:
            io.rong.photoview.log.Logger r11 = io.rong.photoview.log.LogManager.getLogger()
            java.lang.String r0 = "PhotoViewAttacher"
            java.lang.String r3 = "onTouch getParent() returned null"
            r11.i(r0, r3)
        L5a:
            r10.cancelFling()
        L5d:
            r11 = 0
        L5e:
            io.rong.photoview.gestures.GestureDetector r0 = r10.mScaleDragDetector
            if (r0 == 0) goto L95
            boolean r11 = r0.isScaling()
            io.rong.photoview.gestures.GestureDetector r0 = r10.mScaleDragDetector
            boolean r0 = r0.isDragging()
            io.rong.photoview.gestures.GestureDetector r3 = r10.mScaleDragDetector
            boolean r3 = r3.onTouchEvent(r12)
            if (r11 != 0) goto L7e
            io.rong.photoview.gestures.GestureDetector r11 = r10.mScaleDragDetector
            boolean r11 = r11.isScaling()
            if (r11 != 0) goto L7e
            r11 = 1
            goto L7f
        L7e:
            r11 = 0
        L7f:
            if (r0 != 0) goto L8b
            io.rong.photoview.gestures.GestureDetector r0 = r10.mScaleDragDetector
            boolean r0 = r0.isDragging()
            if (r0 != 0) goto L8b
            r0 = 1
            goto L8c
        L8b:
            r0 = 0
        L8c:
            if (r11 == 0) goto L91
            if (r0 == 0) goto L91
            r1 = 1
        L91:
            r10.mBlockParentIntercept = r1
            r1 = r3
            goto L96
        L95:
            r1 = r11
        L96:
            android.view.GestureDetector r11 = r10.mGestureDetector
            if (r11 == 0) goto La1
            boolean r11 = r11.onTouchEvent(r12)
            if (r11 == 0) goto La1
            r1 = 1
        La1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.photoview.PhotoViewAttacher.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    protected void resetMatrix() {
        this.mSuppMatrix.reset();
        setRotationBy(this.mBaseRotation);
        setImageViewMatrix(getDrawMatrix());
        checkMatrixBounds();
    }

    @Override // io.rong.photoview.IPhotoView
    public void setAllowParentInterceptOnEdge(boolean z) {
        this.mAllowParentInterceptOnEdge = z;
    }

    public void setBaseRotation(float f2) {
        this.mBaseRotation = f2 % 360.0f;
        update();
        setRotationBy(this.mBaseRotation);
        checkAndDisplayMatrix();
    }

    @Override // io.rong.photoview.IPhotoView
    public boolean setDisplayMatrix(Matrix matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Matrix cannot be null");
        }
        ImageView imageView = getImageView();
        if (imageView == null || imageView.getDrawable() == null) {
            return false;
        }
        this.mSuppMatrix.set(matrix);
        setImageViewMatrix(getDrawMatrix());
        checkMatrixBounds();
        return true;
    }

    @Override // io.rong.photoview.IPhotoView
    @Deprecated
    public void setMaxScale(float f2) {
        setMaximumScale(f2);
    }

    @Override // io.rong.photoview.IPhotoView
    public void setMaximumScale(float f2) {
        checkZoomLevels(this.mMinScale, this.mMidScale, f2);
        this.mMaxScale = f2;
    }

    @Override // io.rong.photoview.IPhotoView
    public void setMediumScale(float f2) {
        checkZoomLevels(this.mMinScale, f2, this.mMaxScale);
        this.mMidScale = f2;
    }

    @Override // io.rong.photoview.IPhotoView
    @Deprecated
    public void setMidScale(float f2) {
        setMediumScale(f2);
    }

    @Override // io.rong.photoview.IPhotoView
    @Deprecated
    public void setMinScale(float f2) {
        setMinimumScale(f2);
    }

    @Override // io.rong.photoview.IPhotoView
    public void setMinimumScale(float f2) {
        checkZoomLevels(f2, this.mMidScale, this.mMaxScale);
        this.mMinScale = f2;
    }

    @Override // io.rong.photoview.IPhotoView
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        if (onDoubleTapListener != null) {
            this.mGestureDetector.setOnDoubleTapListener(onDoubleTapListener);
        } else {
            this.mGestureDetector.setOnDoubleTapListener(new DefaultOnDoubleTapListener(this));
        }
    }

    @Override // io.rong.photoview.IPhotoView
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
    }

    @Override // io.rong.photoview.IPhotoView
    public void setOnMatrixChangeListener(OnMatrixChangedListener onMatrixChangedListener) {
        this.mMatrixChangeListener = onMatrixChangedListener;
    }

    @Override // io.rong.photoview.IPhotoView
    public void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener) {
        this.mPhotoTapListener = onPhotoTapListener;
    }

    @Override // io.rong.photoview.IPhotoView
    public void setOnScaleChangeListener(OnScaleChangeListener onScaleChangeListener) {
        this.mScaleChangeListener = onScaleChangeListener;
    }

    @Override // io.rong.photoview.IPhotoView
    public void setOnSingleFlingListener(OnSingleFlingListener onSingleFlingListener) {
        this.mSingleFlingListener = onSingleFlingListener;
    }

    @Override // io.rong.photoview.IPhotoView
    public void setOnViewTapListener(OnViewTapListener onViewTapListener) {
        this.mViewTapListener = onViewTapListener;
    }

    @Override // io.rong.photoview.IPhotoView
    public void setPhotoViewRotation(float f2) {
        this.mSuppMatrix.setRotate(f2 % 360.0f);
        checkAndDisplayMatrix();
    }

    @Override // io.rong.photoview.IPhotoView
    public void setRotationBy(float f2) {
        this.mSuppMatrix.postRotate(f2 % 360.0f);
        checkAndDisplayMatrix();
    }

    @Override // io.rong.photoview.IPhotoView
    public void setRotationTo(float f2) {
        this.mSuppMatrix.setRotate(f2 % 360.0f);
        checkAndDisplayMatrix();
    }

    @Override // io.rong.photoview.IPhotoView
    public void setScale(float f2) {
        setScale(f2, false);
    }

    @Override // io.rong.photoview.IPhotoView
    public void setScaleLevels(float f2, float f3, float f4) {
        checkZoomLevels(f2, f3, f4);
        this.mMinScale = f2;
        this.mMidScale = f3;
        this.mMaxScale = f4;
    }

    @Override // io.rong.photoview.IPhotoView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (!isSupportedScaleType(scaleType) || scaleType == this.mScaleType) {
            return;
        }
        this.mScaleType = scaleType;
        update();
    }

    @Override // io.rong.photoview.IPhotoView
    public void setZoomTransitionDuration(int i) {
        if (i < 0) {
            i = 200;
        }
        this.ZOOM_DURATION = i;
    }

    @Override // io.rong.photoview.IPhotoView
    public void setZoomable(boolean z) {
        this.mZoomEnabled = z;
        update();
    }

    public void update() {
        ImageView imageView = getImageView();
        if (imageView != null) {
            if (!this.mZoomEnabled) {
                resetMatrix();
            } else {
                setImageViewScaleTypeMatrix(imageView);
                updateBaseMatrix(imageView.getDrawable());
            }
        }
    }

    protected void updateBaseMatrix(Drawable drawable) {
        ImageView imageView = getImageView();
        if (imageView == null || drawable == null) {
            return;
        }
        float imageViewWidth = getImageViewWidth(imageView);
        float imageViewHeight = getImageViewHeight(imageView);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.mBaseMatrix.reset();
        float f2 = intrinsicWidth;
        float f3 = imageViewWidth / f2;
        float f4 = intrinsicHeight;
        float f5 = imageViewHeight / f4;
        ImageView.ScaleType scaleType = this.mScaleType;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.mBaseMatrix.postTranslate((imageViewWidth - f2) / 2.0f, (imageViewHeight - f4) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float fMax = Math.max(f3, f5);
            this.mBaseMatrix.postScale(fMax, fMax);
            this.mBaseMatrix.postTranslate((imageViewWidth - (f2 * fMax)) / 2.0f, (imageViewHeight - (f4 * fMax)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float fMin = Math.min(1.0f, Math.min(f3, f5));
            this.mBaseMatrix.postScale(fMin, fMin);
            this.mBaseMatrix.postTranslate((imageViewWidth - (f2 * fMin)) / 2.0f, (imageViewHeight - (f4 * fMin)) / 2.0f);
        } else {
            RectF rectF = new RectF(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, f2, f4);
            RectF rectF2 = new RectF(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, imageViewWidth, imageViewHeight);
            if (((int) this.mBaseRotation) % 180 != 0) {
                rectF = new RectF(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, f4, f2);
            }
            int i = AnonymousClass2.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()];
            if (i == 1) {
                this.mBaseMatrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (i == 2) {
                this.mBaseMatrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (i == 3) {
                this.mBaseMatrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            } else if (i == 4) {
                this.mBaseMatrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            }
        }
        resetMatrix();
    }

    public PhotoViewAttacher(ImageView imageView, boolean z) {
        this.ZOOM_DURATION = 200;
        this.mMinScale = 1.0f;
        this.mMidScale = 1.75f;
        this.mMaxScale = 3.0f;
        this.mAllowParentInterceptOnEdge = true;
        this.mBlockParentIntercept = false;
        this.mBaseMatrix = new Matrix();
        this.mDrawMatrix = new Matrix();
        this.mSuppMatrix = new Matrix();
        this.mDisplayRect = new RectF();
        this.mMatrixValues = new float[9];
        this.mScrollEdge = 2;
        this.mScaleType = ImageView.ScaleType.FIT_CENTER;
        this.mImageView = new WeakReference<>(imageView);
        imageView.setDrawingCacheEnabled(true);
        imageView.setOnTouchListener(this);
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        setImageViewScaleTypeMatrix(imageView);
        if (imageView.isInEditMode()) {
            return;
        }
        this.mScaleDragDetector = VersionedGestureDetector.newInstance(imageView.getContext(), this);
        this.mGestureDetector = new GestureDetector(imageView.getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: io.rong.photoview.PhotoViewAttacher.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (PhotoViewAttacher.this.mSingleFlingListener == null || PhotoViewAttacher.this.getScale() > 1.0f || C0321i.b(motionEvent) > PhotoViewAttacher.SINGLE_TOUCH || C0321i.b(motionEvent2) > PhotoViewAttacher.SINGLE_TOUCH) {
                    return false;
                }
                return PhotoViewAttacher.this.mSingleFlingListener.onFling(motionEvent, motionEvent2, f2, f3);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (PhotoViewAttacher.this.mLongClickListener != null) {
                    PhotoViewAttacher.this.mLongClickListener.onLongClick(PhotoViewAttacher.this.getImageView());
                }
            }
        });
        this.mGestureDetector.setOnDoubleTapListener(new DefaultOnDoubleTapListener(this));
        this.mBaseRotation = WheelView.DividerConfig.FILL;
        setZoomable(z);
    }

    @Override // io.rong.photoview.IPhotoView
    public void getDisplayMatrix(Matrix matrix) {
        matrix.set(getDrawMatrix());
    }

    @Override // io.rong.photoview.IPhotoView
    public void setScale(float f2, boolean z) {
        if (getImageView() != null) {
            setScale(f2, r0.getRight() / 2, r0.getBottom() / 2, z);
        }
    }

    private RectF getDisplayRect(Matrix matrix) {
        Drawable drawable;
        ImageView imageView = getImageView();
        if (imageView == null || (drawable = imageView.getDrawable()) == null) {
            return null;
        }
        this.mDisplayRect.set(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        matrix.mapRect(this.mDisplayRect);
        return this.mDisplayRect;
    }

    @Override // io.rong.photoview.IPhotoView
    public void setScale(float f2, float f3, float f4, boolean z) {
        ImageView imageView = getImageView();
        if (imageView != null) {
            if (f2 < this.mMinScale || f2 > this.mMaxScale) {
                LogManager.getLogger().i(LOG_TAG, "Scale must be within the range of minScale and maxScale");
            } else if (z) {
                imageView.post(new AnimatedZoomRunnable(getScale(), f2, f3, f4));
            } else {
                this.mSuppMatrix.setScale(f2, f2, f3, f4);
                checkAndDisplayMatrix();
            }
        }
    }
}
