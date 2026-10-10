package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.Picasso;

/* JADX INFO: compiled from: Target.java */
/* JADX INFO: loaded from: classes5.dex */
public interface J {
    void onBitmapFailed(Drawable drawable);

    void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom);

    void onPrepareLoad(Drawable drawable);
}
