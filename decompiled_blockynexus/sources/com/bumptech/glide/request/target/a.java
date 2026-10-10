package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: BaseTarget.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class a<Z> implements Target<Z> {
    private com.bumptech.glide.request.d request;

    @Override // com.bumptech.glide.request.target.Target
    public com.bumptech.glide.request.d getRequest() {
        return this.request;
    }

    @Override // com.bumptech.glide.manager.j
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadFailed(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadStarted(Drawable drawable) {
    }

    @Override // com.bumptech.glide.manager.j
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.j
    public void onStop() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void setRequest(com.bumptech.glide.request.d dVar) {
        this.request = dVar;
    }
}
