package me.iwf.photopicker.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import android.widget.Scroller;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: loaded from: classes5.dex */
public class TouchImageView extends ImageView {
    private static final String DEBUG = "DEBUG";
    private static final float SUPER_MAX_MULTIPLIER = 1.25f;
    private static final float SUPER_MIN_MULTIPLIER = 0.75f;
    private Context context;
    private h delayedZoomVariables;
    private GestureDetector.OnDoubleTapListener doubleTapListener;
    private c fling;
    private boolean imageRenderedAtLeastOnce;
    private float[] m;
    private GestureDetector mGestureDetector;
    private ScaleGestureDetector mScaleDetector;
    private ImageView.ScaleType mScaleType;
    private float matchViewHeight;
    private float matchViewWidth;
    private Matrix matrix;
    private float maxScale;
    private float minScale;
    private float normalizedScale;
    private boolean onDrawReady;
    private float prevMatchViewHeight;
    private float prevMatchViewWidth;
    private Matrix prevMatrix;
    private int prevViewHeight;
    private int prevViewWidth;
    private State state;
    private float superMaxScale;
    private float superMinScale;
    private e touchImageViewListener;
    private View.OnTouchListener userTouchListener;
    private int viewHeight;
    private int viewWidth;

    private enum State {
        NONE,
        DRAG,
        ZOOM,
        FLING,
        ANIMATE_ZOOM
    }

    private class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        a f22961a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f22962b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f22963c;

        c(int i, int i2) {
            int imageWidth;
            int i3;
            int imageHeight;
            int i4;
            TouchImageView.this.setState(State.FLING);
            this.f22961a = TouchImageView.this.new a(TouchImageView.this.context);
            TouchImageView.this.matrix.getValues(TouchImageView.this.m);
            int i5 = (int) TouchImageView.this.m[2];
            int i6 = (int) TouchImageView.this.m[5];
            if (TouchImageView.this.getImageWidth() > TouchImageView.this.viewWidth) {
                imageWidth = TouchImageView.this.viewWidth - ((int) TouchImageView.this.getImageWidth());
                i3 = 0;
            } else {
                imageWidth = i5;
                i3 = imageWidth;
            }
            if (TouchImageView.this.getImageHeight() > TouchImageView.this.viewHeight) {
                imageHeight = TouchImageView.this.viewHeight - ((int) TouchImageView.this.getImageHeight());
                i4 = 0;
            } else {
                imageHeight = i6;
                i4 = imageHeight;
            }
            this.f22961a.a(i5, i6, i, i2, imageWidth, i3, imageHeight, i4);
            this.f22962b = i5;
            this.f22963c = i6;
        }

        public void a() {
            if (this.f22961a != null) {
                TouchImageView.this.setState(State.NONE);
                this.f22961a.a(true);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TouchImageView.this.touchImageViewListener != null) {
                TouchImageView.this.touchImageViewListener.a();
            }
            if (this.f22961a.d()) {
                this.f22961a = null;
                return;
            }
            if (this.f22961a.a()) {
                int iB = this.f22961a.b();
                int iC = this.f22961a.c();
                int i = iB - this.f22962b;
                int i2 = iC - this.f22963c;
                this.f22962b = iB;
                this.f22963c = iC;
                TouchImageView.this.matrix.postTranslate(i, i2);
                TouchImageView.this.fixTrans();
                TouchImageView touchImageView = TouchImageView.this;
                touchImageView.setImageMatrix(touchImageView.matrix);
                TouchImageView.this.compatPostOnAnimation(this);
            }
        }
    }

    private class d extends GestureDetector.SimpleOnGestureListener {
        private d() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            boolean zOnDoubleTap = TouchImageView.this.doubleTapListener != null ? TouchImageView.this.doubleTapListener.onDoubleTap(motionEvent) : false;
            if (TouchImageView.this.state != State.NONE) {
                return zOnDoubleTap;
            }
            TouchImageView.this.compatPostOnAnimation(TouchImageView.this.new b(TouchImageView.this.normalizedScale == TouchImageView.this.minScale ? TouchImageView.this.maxScale : TouchImageView.this.minScale, motionEvent.getX(), motionEvent.getY(), false));
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            if (TouchImageView.this.doubleTapListener != null) {
                return TouchImageView.this.doubleTapListener.onDoubleTapEvent(motionEvent);
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (TouchImageView.this.fling != null) {
                TouchImageView.this.fling.a();
            }
            TouchImageView touchImageView = TouchImageView.this;
            touchImageView.fling = touchImageView.new c((int) f2, (int) f3);
            TouchImageView touchImageView2 = TouchImageView.this;
            touchImageView2.compatPostOnAnimation(touchImageView2.fling);
            return super.onFling(motionEvent, motionEvent2, f2, f3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            TouchImageView.this.performLongClick();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return TouchImageView.this.doubleTapListener != null ? TouchImageView.this.doubleTapListener.onSingleTapConfirmed(motionEvent) : TouchImageView.this.performClick();
        }

        /* synthetic */ d(TouchImageView touchImageView, me.iwf.photopicker.widget.a aVar) {
            this();
        }
    }

    public interface e {
        void a();
    }

    private class g extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        private g() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            TouchImageView.this.scaleImage(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY(), true);
            if (TouchImageView.this.touchImageViewListener == null) {
                return true;
            }
            TouchImageView.this.touchImageViewListener.a();
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            TouchImageView.this.setState(State.ZOOM);
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            super.onScaleEnd(scaleGestureDetector);
            TouchImageView.this.setState(State.NONE);
            float f2 = TouchImageView.this.normalizedScale;
            boolean z = true;
            if (TouchImageView.this.normalizedScale > TouchImageView.this.maxScale) {
                f2 = TouchImageView.this.maxScale;
            } else if (TouchImageView.this.normalizedScale < TouchImageView.this.minScale) {
                f2 = TouchImageView.this.minScale;
            } else {
                z = false;
            }
            float f3 = f2;
            if (z) {
                TouchImageView.this.compatPostOnAnimation(TouchImageView.this.new b(f3, r4.viewWidth / 2, TouchImageView.this.viewHeight / 2, true));
            }
        }

        /* synthetic */ g(TouchImageView touchImageView, me.iwf.photopicker.widget.a aVar) {
            this();
        }
    }

    private class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f22969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f22970b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f22971c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ImageView.ScaleType f22972d;

        public h(float f2, float f3, float f4, ImageView.ScaleType scaleType) {
            this.f22969a = f2;
            this.f22970b = f3;
            this.f22971c = f4;
            this.f22972d = scaleType;
        }
    }

    public TouchImageView(Context context) {
        super(context);
        this.doubleTapListener = null;
        this.userTouchListener = null;
        this.touchImageViewListener = null;
        sharedConstructing(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(16)
    public void compatPostOnAnimation(Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            postOnAnimation(runnable);
        } else {
            postDelayed(runnable, 16L);
        }
    }

    private void fitImageToView() {
        Drawable drawable = getDrawable();
        if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0 || this.matrix == null || this.prevMatrix == null) {
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        float f2 = intrinsicWidth;
        float fMax = this.viewWidth / f2;
        float f3 = intrinsicHeight;
        float f4 = this.viewHeight / f3;
        int i = me.iwf.photopicker.widget.a.f22974a[this.mScaleType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    fMax = Math.min(1.0f, Math.min(fMax, f4));
                    f4 = fMax;
                } else if (i != 4) {
                    if (i != 5) {
                        throw new UnsupportedOperationException("TouchImageView does not support FIT_START or FIT_END");
                    }
                }
                fMax = Math.min(fMax, f4);
            } else {
                fMax = Math.max(fMax, f4);
            }
            f4 = fMax;
        } else {
            fMax = 1.0f;
            f4 = 1.0f;
        }
        int i2 = this.viewWidth;
        float f5 = i2 - (fMax * f2);
        int i3 = this.viewHeight;
        float f6 = i3 - (f4 * f3);
        this.matchViewWidth = i2 - f5;
        this.matchViewHeight = i3 - f6;
        if (isZoomed() || this.imageRenderedAtLeastOnce) {
            if (this.prevMatchViewWidth == WheelView.DividerConfig.FILL || this.prevMatchViewHeight == WheelView.DividerConfig.FILL) {
                savePreviousImageValues();
            }
            this.prevMatrix.getValues(this.m);
            float[] fArr = this.m;
            float f7 = this.matchViewWidth / f2;
            float f8 = this.normalizedScale;
            fArr[0] = f7 * f8;
            fArr[4] = (this.matchViewHeight / f3) * f8;
            float f9 = fArr[2];
            float f10 = fArr[5];
            translateMatrixAfterRotate(2, f9, this.prevMatchViewWidth * f8, getImageWidth(), this.prevViewWidth, this.viewWidth, intrinsicWidth);
            translateMatrixAfterRotate(5, f10, this.prevMatchViewHeight * this.normalizedScale, getImageHeight(), this.prevViewHeight, this.viewHeight, intrinsicHeight);
            this.matrix.setValues(this.m);
        } else {
            this.matrix.setScale(fMax, f4);
            this.matrix.postTranslate(f5 / 2.0f, f6 / 2.0f);
            this.normalizedScale = 1.0f;
        }
        fixTrans();
        setImageMatrix(this.matrix);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fixScaleTrans() {
        fixTrans();
        this.matrix.getValues(this.m);
        float imageWidth = getImageWidth();
        int i = this.viewWidth;
        if (imageWidth < i) {
            this.m[2] = (i - getImageWidth()) / 2.0f;
        }
        float imageHeight = getImageHeight();
        int i2 = this.viewHeight;
        if (imageHeight < i2) {
            this.m[5] = (i2 - getImageHeight()) / 2.0f;
        }
        this.matrix.setValues(this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fixTrans() {
        this.matrix.getValues(this.m);
        float[] fArr = this.m;
        float f2 = fArr[2];
        float f3 = fArr[5];
        float fixTrans = getFixTrans(f2, this.viewWidth, getImageWidth());
        float fixTrans2 = getFixTrans(f3, this.viewHeight, getImageHeight());
        if (fixTrans == WheelView.DividerConfig.FILL && fixTrans2 == WheelView.DividerConfig.FILL) {
            return;
        }
        this.matrix.postTranslate(fixTrans, fixTrans2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFixDragTrans(float f2, float f3, float f4) {
        return f4 <= f3 ? WheelView.DividerConfig.FILL : f2;
    }

    private float getFixTrans(float f2, float f3, float f4) {
        float f5;
        float f6;
        if (f4 <= f3) {
            f6 = f3 - f4;
            f5 = WheelView.DividerConfig.FILL;
        } else {
            f5 = f3 - f4;
            f6 = WheelView.DividerConfig.FILL;
        }
        return f2 < f5 ? (-f2) + f5 : f2 > f6 ? (-f2) + f6 : WheelView.DividerConfig.FILL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getImageHeight() {
        return this.matchViewHeight * this.normalizedScale;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getImageWidth() {
        return this.matchViewWidth * this.normalizedScale;
    }

    private void printMatrixInfo() {
        float[] fArr = new float[9];
        this.matrix.getValues(fArr);
        Log.d(DEBUG, "Scale: " + fArr[0] + " TransX: " + fArr[2] + " TransY: " + fArr[5]);
    }

    private void savePreviousImageValues() {
        Matrix matrix = this.matrix;
        if (matrix == null || this.viewHeight == 0 || this.viewWidth == 0) {
            return;
        }
        matrix.getValues(this.m);
        this.prevMatrix.setValues(this.m);
        this.prevMatchViewHeight = this.matchViewHeight;
        this.prevMatchViewWidth = this.matchViewWidth;
        this.prevViewHeight = this.viewHeight;
        this.prevViewWidth = this.viewWidth;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scaleImage(double d2, float f2, float f3, boolean z) {
        float f4;
        float f5;
        if (z) {
            f4 = this.superMinScale;
            f5 = this.superMaxScale;
        } else {
            f4 = this.minScale;
            f5 = this.maxScale;
        }
        float f6 = this.normalizedScale;
        double d3 = f6;
        Double.isNaN(d3);
        this.normalizedScale = (float) (d3 * d2);
        float f7 = this.normalizedScale;
        if (f7 > f5) {
            this.normalizedScale = f5;
            d2 = f5 / f6;
        } else if (f7 < f4) {
            this.normalizedScale = f4;
            d2 = f4 / f6;
        }
        float f8 = (float) d2;
        this.matrix.postScale(f8, f8, f2, f3);
        fixScaleTrans();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setState(State state) {
        this.state = state;
    }

    private int setViewSize(int i, int i2, int i3) {
        return i != Integer.MIN_VALUE ? i != 0 ? i2 : i3 : Math.min(i3, i2);
    }

    private void sharedConstructing(Context context) {
        super.setClickable(true);
        this.context = context;
        me.iwf.photopicker.widget.a aVar = null;
        this.mScaleDetector = new ScaleGestureDetector(context, new g(this, aVar));
        this.mGestureDetector = new GestureDetector(context, new d(this, aVar));
        this.matrix = new Matrix();
        this.prevMatrix = new Matrix();
        this.m = new float[9];
        this.normalizedScale = 1.0f;
        if (this.mScaleType == null) {
            this.mScaleType = ImageView.ScaleType.FIT_CENTER;
        }
        this.minScale = 1.0f;
        this.maxScale = 3.0f;
        this.superMinScale = this.minScale * SUPER_MIN_MULTIPLIER;
        this.superMaxScale = this.maxScale * SUPER_MAX_MULTIPLIER;
        setImageMatrix(this.matrix);
        setScaleType(ImageView.ScaleType.MATRIX);
        setState(State.NONE);
        this.onDrawReady = false;
        super.setOnTouchListener(new f(this, aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PointF transformCoordBitmapToTouch(float f2, float f3) {
        this.matrix.getValues(this.m);
        return new PointF(this.m[2] + (getImageWidth() * (f2 / getDrawable().getIntrinsicWidth())), this.m[5] + (getImageHeight() * (f3 / getDrawable().getIntrinsicHeight())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PointF transformCoordTouchToBitmap(float f2, float f3, boolean z) {
        this.matrix.getValues(this.m);
        float intrinsicWidth = getDrawable().getIntrinsicWidth();
        float intrinsicHeight = getDrawable().getIntrinsicHeight();
        float[] fArr = this.m;
        float f4 = fArr[2];
        float f5 = fArr[5];
        float imageWidth = ((f2 - f4) * intrinsicWidth) / getImageWidth();
        float imageHeight = ((f3 - f5) * intrinsicHeight) / getImageHeight();
        if (z) {
            imageWidth = Math.min(Math.max(imageWidth, WheelView.DividerConfig.FILL), intrinsicWidth);
            imageHeight = Math.min(Math.max(imageHeight, WheelView.DividerConfig.FILL), intrinsicHeight);
        }
        return new PointF(imageWidth, imageHeight);
    }

    private void translateMatrixAfterRotate(int i, float f2, float f3, float f4, int i2, int i3, int i4) {
        float f5 = i3;
        if (f4 < f5) {
            float[] fArr = this.m;
            fArr[i] = (f5 - (i4 * fArr[0])) * 0.5f;
        } else if (f2 > WheelView.DividerConfig.FILL) {
            this.m[i] = -((f4 - f5) * 0.5f);
        } else {
            this.m[i] = -((((Math.abs(f2) + (i2 * 0.5f)) / f3) * f4) - (f5 * 0.5f));
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        this.matrix.getValues(this.m);
        float f2 = this.m[2];
        if (getImageWidth() < this.viewWidth) {
            return false;
        }
        if (f2 < -1.0f || i >= 0) {
            return (Math.abs(f2) + ((float) this.viewWidth)) + 1.0f < getImageWidth() || i <= 0;
        }
        return false;
    }

    public boolean canScrollHorizontallyFroyo(int i) {
        return canScrollHorizontally(i);
    }

    public float getCurrentZoom() {
        return this.normalizedScale;
    }

    public float getMaxZoom() {
        return this.maxScale;
    }

    public float getMinZoom() {
        return this.minScale;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public PointF getScrollPosition() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return null;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        PointF pointFTransformCoordTouchToBitmap = transformCoordTouchToBitmap(this.viewWidth / 2, this.viewHeight / 2, true);
        pointFTransformCoordTouchToBitmap.x /= intrinsicWidth;
        pointFTransformCoordTouchToBitmap.y /= intrinsicHeight;
        return pointFTransformCoordTouchToBitmap;
    }

    public RectF getZoomedRect() {
        if (this.mScaleType == ImageView.ScaleType.FIT_XY) {
            throw new UnsupportedOperationException("getZoomedRect() not supported with FIT_XY");
        }
        PointF pointFTransformCoordTouchToBitmap = transformCoordTouchToBitmap(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, true);
        PointF pointFTransformCoordTouchToBitmap2 = transformCoordTouchToBitmap(this.viewWidth, this.viewHeight, true);
        float intrinsicWidth = getDrawable().getIntrinsicWidth();
        float intrinsicHeight = getDrawable().getIntrinsicHeight();
        return new RectF(pointFTransformCoordTouchToBitmap.x / intrinsicWidth, pointFTransformCoordTouchToBitmap.y / intrinsicHeight, pointFTransformCoordTouchToBitmap2.x / intrinsicWidth, pointFTransformCoordTouchToBitmap2.y / intrinsicHeight);
    }

    public boolean isZoomed() {
        return this.normalizedScale != 1.0f;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        savePreviousImageValues();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.onDrawReady = true;
        this.imageRenderedAtLeastOnce = true;
        h hVar = this.delayedZoomVariables;
        if (hVar != null) {
            setZoom(hVar.f22969a, hVar.f22970b, hVar.f22971c, hVar.f22972d);
            this.delayedZoomVariables = null;
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        Drawable drawable = getDrawable();
        if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        this.viewWidth = setViewSize(mode, size, intrinsicWidth);
        this.viewHeight = setViewSize(mode2, size2, intrinsicHeight);
        setMeasuredDimension(this.viewWidth, this.viewHeight);
        fitImageToView();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        this.normalizedScale = bundle.getFloat("saveScale");
        this.m = bundle.getFloatArray("matrix");
        this.prevMatrix.setValues(this.m);
        this.prevMatchViewHeight = bundle.getFloat("matchViewHeight");
        this.prevMatchViewWidth = bundle.getFloat("matchViewWidth");
        this.prevViewHeight = bundle.getInt("viewHeight");
        this.prevViewWidth = bundle.getInt("viewWidth");
        this.imageRenderedAtLeastOnce = bundle.getBoolean("imageRendered");
        super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putFloat("saveScale", this.normalizedScale);
        bundle.putFloat("matchViewHeight", this.matchViewHeight);
        bundle.putFloat("matchViewWidth", this.matchViewWidth);
        bundle.putInt("viewWidth", this.viewWidth);
        bundle.putInt("viewHeight", this.viewHeight);
        this.matrix.getValues(this.m);
        bundle.putFloatArray("matrix", this.m);
        bundle.putBoolean("imageRendered", this.imageRenderedAtLeastOnce);
        return bundle;
    }

    public void resetZoom() {
        this.normalizedScale = 1.0f;
        fitImageToView();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        savePreviousImageValues();
        fitImageToView();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        savePreviousImageValues();
        fitImageToView();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        savePreviousImageValues();
        fitImageToView();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        savePreviousImageValues();
        fitImageToView();
    }

    public void setMaxZoom(float f2) {
        this.maxScale = f2;
        this.superMaxScale = this.maxScale * SUPER_MAX_MULTIPLIER;
    }

    public void setMinZoom(float f2) {
        this.minScale = f2;
        this.superMinScale = this.minScale * SUPER_MIN_MULTIPLIER;
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.doubleTapListener = onDoubleTapListener;
    }

    public void setOnTouchImageViewListener(e eVar) {
        this.touchImageViewListener = eVar;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.userTouchListener = onTouchListener;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.FIT_START || scaleType == ImageView.ScaleType.FIT_END) {
            throw new UnsupportedOperationException("TouchImageView does not support FIT_START or FIT_END");
        }
        ImageView.ScaleType scaleType2 = ImageView.ScaleType.MATRIX;
        if (scaleType == scaleType2) {
            super.setScaleType(scaleType2);
            return;
        }
        this.mScaleType = scaleType;
        if (this.onDrawReady) {
            setZoom(this);
        }
    }

    public void setScrollPosition(float f2, float f3) {
        setZoom(this.normalizedScale, f2, f3);
    }

    public void setZoom(float f2) {
        setZoom(f2, 0.5f, 0.5f);
    }

    private class f implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private PointF f22966a;

        private f() {
            this.f22966a = new PointF();
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x009d  */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
            /*
                Method dump skipped, instruction units count: 238
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: me.iwf.photopicker.widget.TouchImageView.f.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }

        /* synthetic */ f(TouchImageView touchImageView, me.iwf.photopicker.widget.a aVar) {
            this();
        }
    }

    public void setZoom(float f2, float f3, float f4) {
        setZoom(f2, f3, f4, this.mScaleType);
    }

    @TargetApi(9)
    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Scroller f22951a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        OverScroller f22952b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f22953c;

        public a(Context context) {
            if (Build.VERSION.SDK_INT < 9) {
                this.f22953c = true;
                this.f22951a = new Scroller(context);
            } else {
                this.f22953c = false;
                this.f22952b = new OverScroller(context);
            }
        }

        public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (this.f22953c) {
                this.f22951a.fling(i, i2, i3, i4, i5, i6, i7, i8);
            } else {
                this.f22952b.fling(i, i2, i3, i4, i5, i6, i7, i8);
            }
        }

        public int b() {
            return this.f22953c ? this.f22951a.getCurrX() : this.f22952b.getCurrX();
        }

        public int c() {
            return this.f22953c ? this.f22951a.getCurrY() : this.f22952b.getCurrY();
        }

        public boolean d() {
            return this.f22953c ? this.f22951a.isFinished() : this.f22952b.isFinished();
        }

        public void a(boolean z) {
            if (this.f22953c) {
                this.f22951a.forceFinished(z);
            } else {
                this.f22952b.forceFinished(z);
            }
        }

        public boolean a() {
            if (this.f22953c) {
                return this.f22951a.computeScrollOffset();
            }
            this.f22952b.computeScrollOffset();
            return this.f22952b.computeScrollOffset();
        }
    }

    public void setZoom(float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        if (!this.onDrawReady) {
            this.delayedZoomVariables = new h(f2, f3, f4, scaleType);
            return;
        }
        if (scaleType != this.mScaleType) {
            setScaleType(scaleType);
        }
        resetZoom();
        scaleImage(f2, this.viewWidth / 2, this.viewHeight / 2, true);
        this.matrix.getValues(this.m);
        this.m[2] = -((f3 * getImageWidth()) - (this.viewWidth * 0.5f));
        this.m[5] = -((f4 * getImageHeight()) - (this.viewHeight * 0.5f));
        this.matrix.setValues(this.m);
        fixTrans();
        setImageMatrix(this.matrix);
    }

    private class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f22955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f22956b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f22957c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f22958d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f22959e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f22960f;
        private AccelerateDecelerateInterpolator g = new AccelerateDecelerateInterpolator();
        private PointF h;
        private PointF i;

        b(float f2, float f3, float f4, boolean z) {
            TouchImageView.this.setState(State.ANIMATE_ZOOM);
            this.f22955a = System.currentTimeMillis();
            this.f22956b = TouchImageView.this.normalizedScale;
            this.f22957c = f2;
            this.f22960f = z;
            PointF pointFTransformCoordTouchToBitmap = TouchImageView.this.transformCoordTouchToBitmap(f3, f4, false);
            this.f22958d = pointFTransformCoordTouchToBitmap.x;
            this.f22959e = pointFTransformCoordTouchToBitmap.y;
            this.h = TouchImageView.this.transformCoordBitmapToTouch(this.f22958d, this.f22959e);
            this.i = new PointF(TouchImageView.this.viewWidth / 2, TouchImageView.this.viewHeight / 2);
        }

        private float a() {
            return this.g.getInterpolation(Math.min(1.0f, (System.currentTimeMillis() - this.f22955a) / 500.0f));
        }

        private void b(float f2) {
            PointF pointF = this.h;
            float f3 = pointF.x;
            PointF pointF2 = this.i;
            float f4 = f3 + ((pointF2.x - f3) * f2);
            float f5 = pointF.y;
            float f6 = f5 + (f2 * (pointF2.y - f5));
            PointF pointFTransformCoordBitmapToTouch = TouchImageView.this.transformCoordBitmapToTouch(this.f22958d, this.f22959e);
            TouchImageView.this.matrix.postTranslate(f4 - pointFTransformCoordBitmapToTouch.x, f6 - pointFTransformCoordBitmapToTouch.y);
        }

        @Override // java.lang.Runnable
        public void run() {
            float fA = a();
            TouchImageView.this.scaleImage(a(fA), this.f22958d, this.f22959e, this.f22960f);
            b(fA);
            TouchImageView.this.fixScaleTrans();
            TouchImageView touchImageView = TouchImageView.this;
            touchImageView.setImageMatrix(touchImageView.matrix);
            if (TouchImageView.this.touchImageViewListener != null) {
                TouchImageView.this.touchImageViewListener.a();
            }
            if (fA < 1.0f) {
                TouchImageView.this.compatPostOnAnimation(this);
            } else {
                TouchImageView.this.setState(State.NONE);
            }
        }

        private double a(float f2) {
            float f3 = this.f22956b;
            double d2 = f3 + (f2 * (this.f22957c - f3));
            double d3 = TouchImageView.this.normalizedScale;
            Double.isNaN(d2);
            Double.isNaN(d3);
            return d2 / d3;
        }
    }

    public TouchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.doubleTapListener = null;
        this.userTouchListener = null;
        this.touchImageViewListener = null;
        sharedConstructing(context);
    }

    public TouchImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.doubleTapListener = null;
        this.userTouchListener = null;
        this.touchImageViewListener = null;
        sharedConstructing(context);
    }

    public void setZoom(TouchImageView touchImageView) {
        PointF scrollPosition = touchImageView.getScrollPosition();
        setZoom(touchImageView.getCurrentZoom(), scrollPosition.x, scrollPosition.y, touchImageView.getScaleType());
    }
}
