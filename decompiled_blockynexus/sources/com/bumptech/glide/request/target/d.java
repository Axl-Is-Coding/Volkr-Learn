package com.bumptech.glide.request.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.a.b;

/* JADX INFO: compiled from: ImageViewTarget.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class d<Z> extends ViewTarget<ImageView, Z> implements b.a {
    private Animatable h;

    public d(ImageView imageView) {
        super(imageView);
    }

    private void b(Z z) {
        if (!(z instanceof Animatable)) {
            this.h = null;
        } else {
            this.h = (Animatable) z;
            this.h.start();
        }
    }

    private void c(Z z) {
        a(z);
        b(z);
    }

    public void a(Drawable drawable) {
        ((ImageView) this.f4827c).setImageDrawable(drawable);
    }

    protected abstract void a(Z z);

    @Override // com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.a, com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
        super.onLoadCleared(drawable);
        Animatable animatable = this.h;
        if (animatable != null) {
            animatable.stop();
        }
        c(null);
        a(drawable);
    }

    @Override // com.bumptech.glide.request.target.a, com.bumptech.glide.request.target.Target
    public void onLoadFailed(Drawable drawable) {
        super.onLoadFailed(drawable);
        c(null);
        a(drawable);
    }

    @Override // com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.a, com.bumptech.glide.request.target.Target
    public void onLoadStarted(Drawable drawable) {
        super.onLoadStarted(drawable);
        c(null);
        a(drawable);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onResourceReady(Z z, com.bumptech.glide.request.a.b<? super Z> bVar) {
        if (bVar == null || !bVar.a(z, this)) {
            c(z);
        } else {
            b(z);
        }
    }

    @Override // com.bumptech.glide.request.target.a, com.bumptech.glide.manager.j
    public void onStart() {
        Animatable animatable = this.h;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // com.bumptech.glide.request.target.a, com.bumptech.glide.manager.j
    public void onStop() {
        Animatable animatable = this.h;
        if (animatable != null) {
            animatable.stop();
        }
    }
}
