package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* JADX INFO: compiled from: BitmapImageViewTarget.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends d<Bitmap> {
    public b(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.target.d
    public void a(Bitmap bitmap) {
        ((ImageView) this.f4827c).setImageBitmap(bitmap);
    }
}
