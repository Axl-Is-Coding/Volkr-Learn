package io.rong.imageloader.core.display;

import android.graphics.Bitmap;
import io.rong.imageloader.core.assist.LoadedFrom;
import io.rong.imageloader.core.imageaware.ImageAware;

/* JADX INFO: loaded from: classes5.dex */
public final class SimpleBitmapDisplayer implements BitmapDisplayer {
    @Override // io.rong.imageloader.core.display.BitmapDisplayer
    public void display(Bitmap bitmap, ImageAware imageAware, LoadedFrom loadedFrom) {
        imageAware.setImageBitmap(bitmap);
    }
}
