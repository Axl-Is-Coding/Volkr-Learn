package io.rong.photoview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import io.rong.photoview.PhotoViewAttacher;

/* JADX INFO: loaded from: classes5.dex */
public class PhotoView extends ImageView implements IPhotoView {
    private PhotoViewAttacher mAttacher;
    private ImageView.ScaleType mPendingScaleType;

    public PhotoView(Context context) {
        this(context, null);
    }

    @Override // io.rong.photoview.IPhotoView
    public boolean canZoom() {
        return this.mAttacher.canZoom();
    }

    @Override // io.rong.photoview.IPhotoView
    public Matrix getDisplayMatrix() {
        return this.mAttacher.getDisplayMatrix();
    }

    @Override // io.rong.photoview.IPhotoView
    public RectF getDisplayRect() {
        return this.mAttacher.getDisplayRect();
    }

    @Override // io.rong.photoview.IPhotoView
    public IPhotoView getIPhotoViewImplementation() {
        return this.mAttacher;
    }

    @Override // io.rong.photoview.IPhotoView
    @Deprecated
    public float getMaxScale() {
        return getMaximumScale();
    }

    @Override // io.rong.photoview.IPhotoView
    public float getMaximumScale() {
        return this.mAttacher.getMaximumScale();
    }

    @Override // io.rong.photoview.IPhotoView
    public float getMediumScale() {
        return this.mAttacher.getMediumScale();
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
        return this.mAttacher.getMinimumScale();
    }

    @Override // io.rong.photoview.IPhotoView
    public PhotoViewAttacher.OnPhotoTapListener getOnPhotoTapListener() {
        return this.mAttacher.getOnPhotoTapListener();
    }

    @Override // io.rong.photoview.IPhotoView
    public PhotoViewAttacher.OnViewTapListener getOnViewTapListener() {
        return this.mAttacher.getOnViewTapListener();
    }

    @Override // io.rong.photoview.IPhotoView
    public float getScale() {
        return this.mAttacher.getScale();
    }

    @Override // android.widget.ImageView, io.rong.photoview.IPhotoView
    public ImageView.ScaleType getScaleType() {
        return this.mAttacher.getScaleType();
    }

    @Override // io.rong.photoview.IPhotoView
    public Bitmap getVisibleRectangleBitmap() {
        return this.mAttacher.getVisibleRectangleBitmap();
    }

    protected void init() {
        PhotoViewAttacher photoViewAttacher = this.mAttacher;
        if (photoViewAttacher == null || photoViewAttacher.getImageView() == null) {
            this.mAttacher = new PhotoViewAttacher(this);
        }
        ImageView.ScaleType scaleType = this.mPendingScaleType;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.mPendingScaleType = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        init();
        super.onAttachedToWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        this.mAttacher.cleanup();
        super.onDetachedFromWindow();
    }

    @Override // io.rong.photoview.IPhotoView
    public void setAllowParentInterceptOnEdge(boolean z) {
        this.mAttacher.setAllowParentInterceptOnEdge(z);
    }

    @Override // io.rong.photoview.IPhotoView
    public boolean setDisplayMatrix(Matrix matrix) {
        return this.mAttacher.setDisplayMatrix(matrix);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        PhotoViewAttacher photoViewAttacher = this.mAttacher;
        if (photoViewAttacher != null) {
            photoViewAttacher.update();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        PhotoViewAttacher photoViewAttacher = this.mAttacher;
        if (photoViewAttacher != null) {
            photoViewAttacher.update();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        PhotoViewAttacher photoViewAttacher = this.mAttacher;
        if (photoViewAttacher != null) {
            photoViewAttacher.update();
        }
    }

    @Override // io.rong.photoview.IPhotoView
    @Deprecated
    public void setMaxScale(float f2) {
        setMaximumScale(f2);
    }

    @Override // io.rong.photoview.IPhotoView
    public void setMaximumScale(float f2) {
        this.mAttacher.setMaximumScale(f2);
    }

    @Override // io.rong.photoview.IPhotoView
    public void setMediumScale(float f2) {
        this.mAttacher.setMediumScale(f2);
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
        this.mAttacher.setMinimumScale(f2);
    }

    @Override // io.rong.photoview.IPhotoView
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.mAttacher.setOnDoubleTapListener(onDoubleTapListener);
    }

    @Override // android.view.View, io.rong.photoview.IPhotoView
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mAttacher.setOnLongClickListener(onLongClickListener);
    }

    @Override // io.rong.photoview.IPhotoView
    public void setOnMatrixChangeListener(PhotoViewAttacher.OnMatrixChangedListener onMatrixChangedListener) {
        this.mAttacher.setOnMatrixChangeListener(onMatrixChangedListener);
    }

    @Override // io.rong.photoview.IPhotoView
    public void setOnPhotoTapListener(PhotoViewAttacher.OnPhotoTapListener onPhotoTapListener) {
        this.mAttacher.setOnPhotoTapListener(onPhotoTapListener);
    }

    @Override // io.rong.photoview.IPhotoView
    public void setOnScaleChangeListener(PhotoViewAttacher.OnScaleChangeListener onScaleChangeListener) {
        this.mAttacher.setOnScaleChangeListener(onScaleChangeListener);
    }

    @Override // io.rong.photoview.IPhotoView
    public void setOnSingleFlingListener(PhotoViewAttacher.OnSingleFlingListener onSingleFlingListener) {
        this.mAttacher.setOnSingleFlingListener(onSingleFlingListener);
    }

    @Override // io.rong.photoview.IPhotoView
    public void setOnViewTapListener(PhotoViewAttacher.OnViewTapListener onViewTapListener) {
        this.mAttacher.setOnViewTapListener(onViewTapListener);
    }

    @Override // io.rong.photoview.IPhotoView
    public void setPhotoViewRotation(float f2) {
        this.mAttacher.setRotationTo(f2);
    }

    @Override // io.rong.photoview.IPhotoView
    public void setRotationBy(float f2) {
        this.mAttacher.setRotationBy(f2);
    }

    @Override // io.rong.photoview.IPhotoView
    public void setRotationTo(float f2) {
        this.mAttacher.setRotationTo(f2);
    }

    @Override // io.rong.photoview.IPhotoView
    public void setScale(float f2) {
        this.mAttacher.setScale(f2);
    }

    @Override // io.rong.photoview.IPhotoView
    public void setScaleLevels(float f2, float f3, float f4) {
        this.mAttacher.setScaleLevels(f2, f3, f4);
    }

    @Override // android.widget.ImageView, io.rong.photoview.IPhotoView
    public void setScaleType(ImageView.ScaleType scaleType) {
        PhotoViewAttacher photoViewAttacher = this.mAttacher;
        if (photoViewAttacher != null) {
            photoViewAttacher.setScaleType(scaleType);
        } else {
            this.mPendingScaleType = scaleType;
        }
    }

    @Override // io.rong.photoview.IPhotoView
    public void setZoomTransitionDuration(int i) {
        this.mAttacher.setZoomTransitionDuration(i);
    }

    @Override // io.rong.photoview.IPhotoView
    public void setZoomable(boolean z) {
        this.mAttacher.setZoomable(z);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // io.rong.photoview.IPhotoView
    public void getDisplayMatrix(Matrix matrix) {
        this.mAttacher.getDisplayMatrix(matrix);
    }

    @Override // io.rong.photoview.IPhotoView
    public void setScale(float f2, boolean z) {
        this.mAttacher.setScale(f2, z);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        init();
    }

    @Override // io.rong.photoview.IPhotoView
    public void setScale(float f2, float f3, float f4, boolean z) {
        this.mAttacher.setScale(f2, f3, f4, z);
    }
}
