package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.manager.j;

/* JADX INFO: loaded from: classes.dex */
public interface Target<R> extends j {
    com.bumptech.glide.request.d getRequest();

    void getSize(h hVar);

    void onLoadCleared(Drawable drawable);

    void onLoadFailed(Drawable drawable);

    void onLoadStarted(Drawable drawable);

    void onResourceReady(R r, com.bumptech.glide.request.a.b<? super R> bVar);

    void removeCallback(h hVar);

    void setRequest(com.bumptech.glide.request.d dVar);
}
