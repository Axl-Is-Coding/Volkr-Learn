package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: compiled from: DrawableImageViewTarget.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends d<Drawable> {
    public c(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.target.d
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(Drawable drawable) {
        ((ImageView) this.f4827c).setImageDrawable(drawable);
    }
}
