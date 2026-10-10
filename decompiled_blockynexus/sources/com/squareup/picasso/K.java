package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.Picasso;

/* JADX INFO: compiled from: TargetAction.java */
/* JADX INFO: loaded from: classes5.dex */
final class K extends AbstractC2746a<J> {
    K(Picasso picasso, J j, C c2, int i, int i2, Drawable drawable, String str, Object obj, int i3) {
        super(picasso, j, c2, i, i2, i3, drawable, str, obj, false);
    }

    @Override // com.squareup.picasso.AbstractC2746a
    void a(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
        if (bitmap == null) {
            throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", this));
        }
        J j = j();
        if (j != null) {
            j.onBitmapLoaded(bitmap, loadedFrom);
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Target callback must not recycle bitmap!");
            }
        }
    }

    @Override // com.squareup.picasso.AbstractC2746a
    void b() {
        J j = j();
        if (j != null) {
            if (this.g != 0) {
                j.onBitmapFailed(this.f19274a.g.getResources().getDrawable(this.g));
            } else {
                j.onBitmapFailed(this.h);
            }
        }
    }
}
