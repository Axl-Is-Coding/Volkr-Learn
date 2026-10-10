package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.e.n;

/* JADX INFO: loaded from: classes.dex */
public abstract class CustomTarget<T> implements Target<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f4802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bumptech.glide.request.d f4803c;

    public CustomTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final com.bumptech.glide.request.d getRequest() {
        return this.f4803c;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void getSize(h hVar) {
        hVar.a(this.f4801a, this.f4802b);
    }

    @Override // com.bumptech.glide.manager.j
    public void onDestroy() {
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
    public final void removeCallback(h hVar) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void setRequest(com.bumptech.glide.request.d dVar) {
        this.f4803c = dVar;
    }

    public CustomTarget(int i, int i2) {
        if (n.b(i, i2)) {
            this.f4801a = i;
            this.f4802b = i2;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i + " and height: " + i2);
    }
}
