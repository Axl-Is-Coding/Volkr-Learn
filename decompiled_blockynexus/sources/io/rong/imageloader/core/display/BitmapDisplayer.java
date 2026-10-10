package io.rong.imageloader.core.display;

import android.graphics.Bitmap;
import io.rong.imageloader.core.assist.LoadedFrom;
import io.rong.imageloader.core.imageaware.ImageAware;

/* JADX INFO: loaded from: classes5.dex */
public interface BitmapDisplayer {
    void display(Bitmap bitmap, ImageAware imageAware, LoadedFrom loadedFrom);
}
