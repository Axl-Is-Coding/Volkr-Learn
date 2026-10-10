package io.rong.imageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import io.rong.imageloader.core.assist.ViewScaleType;

/* JADX INFO: loaded from: classes5.dex */
public interface ImageAware {
    int getHeight();

    int getId();

    ViewScaleType getScaleType();

    int getWidth();

    View getWrappedView();

    boolean isCollected();

    boolean setImageBitmap(Bitmap bitmap);

    boolean setImageDrawable(Drawable drawable);
}
