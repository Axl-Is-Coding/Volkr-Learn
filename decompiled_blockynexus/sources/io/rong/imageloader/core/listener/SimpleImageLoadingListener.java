package io.rong.imageloader.core.listener;

import android.graphics.Bitmap;
import android.view.View;
import io.rong.imageloader.core.assist.FailReason;

/* JADX INFO: loaded from: classes5.dex */
public class SimpleImageLoadingListener implements ImageLoadingListener {
    @Override // io.rong.imageloader.core.listener.ImageLoadingListener
    public void onLoadingCancelled(String str, View view) {
    }

    @Override // io.rong.imageloader.core.listener.ImageLoadingListener
    public void onLoadingComplete(String str, View view, Bitmap bitmap) {
    }

    @Override // io.rong.imageloader.core.listener.ImageLoadingListener
    public void onLoadingFailed(String str, View view, FailReason failReason) {
    }

    @Override // io.rong.imageloader.core.listener.ImageLoadingListener
    public void onLoadingStarted(String str, View view) {
    }
}
