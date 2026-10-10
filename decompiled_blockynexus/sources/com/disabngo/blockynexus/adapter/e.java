package com.disabngo.blockynexus.adapter;

import android.content.Context;
import android.widget.ImageView;

/* JADX INFO: compiled from: NineGridImageViewAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class e<T> {
    public ImageView a(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return imageView;
    }

    public abstract void a(Context context, ImageView imageView, T t);
}
