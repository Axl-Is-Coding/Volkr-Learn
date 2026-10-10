package com.bumptech.glide;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.target.Target;

/* JADX INFO: loaded from: classes.dex */
final class ListPreloader$PreloadTarget implements Target<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f4073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f4074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.request.d f4075c;

    ListPreloader$PreloadTarget() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public com.bumptech.glide.request.d getRequest() {
        return this.f4075c;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void getSize(com.bumptech.glide.request.target.h hVar) {
        hVar.a(this.f4074b, this.f4073a);
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

    @Override // com.bumptech.glide.request.target.Target
    public void onResourceReady(Object obj, com.bumptech.glide.request.a.b<? super Object> bVar) {
    }

    @Override // com.bumptech.glide.manager.j
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.j
    public void onStop() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void removeCallback(com.bumptech.glide.request.target.h hVar) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void setRequest(com.bumptech.glide.request.d dVar) {
        this.f4075c = dVar;
    }
}
