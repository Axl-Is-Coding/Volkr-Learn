package io.rong.imkit.widget;

import android.net.Uri;

/* JADX INFO: loaded from: classes5.dex */
public interface IImageLoadingListener {
    void onLoadingComplete(Uri uri);

    void onLoadingFail();
}
