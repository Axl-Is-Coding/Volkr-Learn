package io.rong.photoview;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultOnDoubleTapListener implements GestureDetector.OnDoubleTapListener {
    private PhotoViewAttacher photoViewAttacher;

    public DefaultOnDoubleTapListener(PhotoViewAttacher photoViewAttacher) {
        setPhotoViewAttacher(photoViewAttacher);
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        PhotoViewAttacher photoViewAttacher = this.photoViewAttacher;
        if (photoViewAttacher == null) {
            return false;
        }
        try {
            float scale = photoViewAttacher.getScale();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (scale < this.photoViewAttacher.getMediumScale()) {
                this.photoViewAttacher.setScale(this.photoViewAttacher.getMediumScale(), x, y, true);
            } else if (scale < this.photoViewAttacher.getMediumScale() || scale >= this.photoViewAttacher.getMaximumScale()) {
                this.photoViewAttacher.setScale(this.photoViewAttacher.getMinimumScale(), x, y, true);
            } else {
                this.photoViewAttacher.setScale(this.photoViewAttacher.getMaximumScale(), x, y, true);
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        RectF displayRect;
        PhotoViewAttacher photoViewAttacher = this.photoViewAttacher;
        if (photoViewAttacher == null) {
            return false;
        }
        ImageView imageView = photoViewAttacher.getImageView();
        if (this.photoViewAttacher.getOnPhotoTapListener() == null || (displayRect = this.photoViewAttacher.getDisplayRect()) == null) {
            if (this.photoViewAttacher.getOnViewTapListener() != null) {
                this.photoViewAttacher.getOnViewTapListener().onViewTap(imageView, motionEvent.getX(), motionEvent.getY());
            }
            return false;
        }
        this.photoViewAttacher.getOnPhotoTapListener().onPhotoTap(imageView, (motionEvent.getX() - displayRect.left) / displayRect.width(), (motionEvent.getY() - displayRect.top) / displayRect.height());
        return true;
    }

    public void setPhotoViewAttacher(PhotoViewAttacher photoViewAttacher) {
        this.photoViewAttacher = photoViewAttacher;
    }
}
