package io.rong.imageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import io.rong.imageloader.core.assist.ViewScaleType;
import io.rong.imageloader.utils.L;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes5.dex */
public class ImageViewAware extends ViewAware {
    public ImageViewAware(ImageView imageView) {
        super(imageView);
    }

    private static int getImageViewFieldValue(Object obj, String str) {
        try {
            Field declaredField = ImageView.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            int iIntValue = ((Integer) declaredField.get(obj)).intValue();
            if (iIntValue <= 0 || iIntValue >= Integer.MAX_VALUE) {
                return 0;
            }
            return iIntValue;
        } catch (Exception e2) {
            L.e(e2);
            return 0;
        }
    }

    @Override // io.rong.imageloader.core.imageaware.ViewAware, io.rong.imageloader.core.imageaware.ImageAware
    public int getHeight() {
        ImageView imageView;
        int height = super.getHeight();
        return (height > 0 || (imageView = (ImageView) this.viewRef.get()) == null) ? height : getImageViewFieldValue(imageView, "mMaxHeight");
    }

    @Override // io.rong.imageloader.core.imageaware.ViewAware, io.rong.imageloader.core.imageaware.ImageAware
    public ViewScaleType getScaleType() {
        ImageView imageView = (ImageView) this.viewRef.get();
        return imageView != null ? ViewScaleType.fromImageView(imageView) : super.getScaleType();
    }

    @Override // io.rong.imageloader.core.imageaware.ViewAware, io.rong.imageloader.core.imageaware.ImageAware
    public int getWidth() {
        ImageView imageView;
        int width = super.getWidth();
        return (width > 0 || (imageView = (ImageView) this.viewRef.get()) == null) ? width : getImageViewFieldValue(imageView, "mMaxWidth");
    }

    @Override // io.rong.imageloader.core.imageaware.ViewAware
    protected void setImageBitmapInto(Bitmap bitmap, View view) {
        ((ImageView) view).setImageBitmap(bitmap);
    }

    @Override // io.rong.imageloader.core.imageaware.ViewAware
    protected void setImageDrawableInto(Drawable drawable, View view) {
        ((ImageView) view).setImageDrawable(drawable);
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        }
    }

    public ImageViewAware(ImageView imageView, boolean z) {
        super(imageView, z);
    }

    @Override // io.rong.imageloader.core.imageaware.ViewAware, io.rong.imageloader.core.imageaware.ImageAware
    public ImageView getWrappedView() {
        return (ImageView) super.getWrappedView();
    }
}
